/*
 * SaveItineraryChangeCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Mar 1, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.kcdata.abe.application.command.ResyncBookingCommand;
import com.kcdata.abe.application.command.SaveItineraryChangeCommand;
import com.kcdata.abe.business.response.BookingSearchResponse;
import com.kcdata.abe.business.response.CommentsResponse;
import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.business.response.ServicesResponse;
import com.kcdata.abe.business.service.BookingSearchService;
import com.kcdata.abe.business.service.CommentsService;
import com.kcdata.abe.business.service.GatewayDestinationsService;
import com.kcdata.abe.business.service.ItineraryService;
import com.kcdata.abe.business.service.ServicesService;
import com.kcdata.abe.data.dto.Comment;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.SeatAllocations;
import com.kcdata.abe.data.util.SeatMapUtils;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.framework.errorhandling.exception.ABEWarning;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.util.ABEConstants;

/**
 * 
 * Command Handler for saving changes in specific itinerary
 *
 * @author vgandrap
 * @version
 *
 *
 * @see
 * @since
 */

public class SaveItineraryChangeCommandHandler extends ABECommandHandlerBase{
	
	ABELogger logger = ABELogger.getLogger(SaveItineraryChangeCommandHandler.class);
	/**
	 * Itinerary booking service
	 */
	private ItineraryService itineraryService;

	/**
	 * Service class to retrieve services
	 */
	private ServicesService servicesService;
	
	/**
	 * Booking Search Service
	 */
	private BookingSearchService bookingSearchService;
	/**
	 * Comments Service
	 */
	private CommentsService commentsService;
	private Map<String, String> gatewayDestMap;
	/**
	 * GatewayDestinationsService for reteriving gateway and destinations Strings
	 */
	private GatewayDestinationsService gatewayDestinationsService;

	/**
	 * @return the itineraryService
	 */
	public ItineraryService getItineraryService() {
		return itineraryService;
	}

	/**
	 * @param itineraryService
	 *            the itineraryService to set
	 */
	public void setItineraryService(
			ItineraryService itineraryService) {
		this.itineraryService = itineraryService;
	}
	
	/**
	 * Method to handle the SaveItineraryChangeCommand
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof SaveItineraryChangeCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "SaveItineraryChangeCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		IMApplicationInfo imApplicationInfo = this.getApplicationContextFactory().getApplicationContext()
			.getRequestContext().getIMApplicationInfo();
		
		SaveItineraryChangeCommand saveItineraryChangeCommand = (SaveItineraryChangeCommand) command;
		BookingSearchResponse searchResponse = null;
		String bookingNumber = saveItineraryChangeCommand.getItinerary().getBookingNo();
		// Retrieve booking for seat allocation and comments
		
		 searchResponse = bookingSearchService.retrieveBooking(bookingNumber);
		

		if((null != searchResponse.getItinerary()) && (searchResponse.getItinerary().getBookingHeader().isPriceMismatchError() || searchResponse.getItinerary().isNeedToResync())){
			
			final ResyncBookingCommand resyncBookingCommand = new ResyncBookingCommand();
			resyncBookingCommand.setBookingNo(searchResponse.getItinerary().getBookingHeader().getBookingNo());
			resyncBookingCommand.setIMApplicationInfo(saveItineraryChangeCommand.getIMApplicationInfo());
			resyncBookingCommand.setApplicationContext(saveItineraryChangeCommand.getApplicationContext());
			bookingSearchService.resyncBooking(resyncBookingCommand );
			searchResponse = bookingSearchService.retrieveBooking(bookingNumber);
		}
		List<Comment> commentList = null;
		List<String> seatMaterialSegIds = new ArrayList<String>();
		//In case booking is cancelled
		if(saveItineraryChangeCommand.getItinerary().isBookingCancelled() 
				&& searchResponse.getItinerary().getSeatAllocationList() != null)
		{
			commentList = SeatMapUtils.updateComments(searchResponse.getItinerary(), gatewayDestinationsService, gatewayDestMap,
					imApplicationInfo, false, true, seatMaterialSegIds);
		}
		// populate seats information to be inserted in comments
		if((SeatMapUtils.getTripFlights(saveItineraryChangeCommand.getItinerary()).size() > 0 || SeatMapUtils.getTripFlights(searchResponse.getItinerary()).size() > 0)
				&& (saveItineraryChangeCommand.getItinerary().getSeatAllocationList() != null ||
				searchResponse.getItinerary().getSeatAllocationList() != null)) {
			populateSeatsInfo(saveItineraryChangeCommand.getItinerary().getSeatAllocationList(), searchResponse.getItinerary().getSeatAllocationList());
		}
		ServicesResponse servicesResponse = servicesService.retrieveServices(saveItineraryChangeCommand.getItinerary());
		ABEWarning warning = null;
		if(!saveItineraryChangeCommand.getItinerary().isBookingCancelled()
				&& saveItineraryChangeCommand.getItinerary().getSeatAllocationList() != null)
		{
			seatMaterialSegIds = SeatMapUtils.getSegmentForSeatServiceAvailability(servicesResponse);
			warning = SeatMapUtils.removeNonSeatMaterialSeats(saveItineraryChangeCommand.getItinerary().getSeatAllocationList(), seatMaterialSegIds);
		}
		
		// Save Itinerary Changes
		//Start the implemention of AV3749/HBsi 52 emergency tab information for passgenger enhancement
		if (!saveItineraryChangeCommand.getItinerary().isBookingCancelled()) {
		if (saveItineraryChangeCommand.getItinerary().getBookingNo()!=null){
			searchResponse.getItinerary().setGuests(saveItineraryChangeCommand.getItinerary().getGuests());
		}
		}
		//End of the implemention of AV3749/HBsi 52 emergency tab information for passgenger enhancement
		if (!saveItineraryChangeCommand.getItinerary().isBookingCancelled()) {
			if(saveItineraryChangeCommand.getItinerary().getHotels()!=null && searchResponse.getItinerary().getHotels()!=null ){
				for(int i=0;i<saveItineraryChangeCommand.getItinerary().getHotels().size();i++){
					if(saveItineraryChangeCommand.getItinerary().getHotels().get(i).getHbsiPNR() !=null && 
							(!(saveItineraryChangeCommand.getItinerary().getHotels().get(i).getHbsiPNR().equalsIgnoreCase("") || saveItineraryChangeCommand.getItinerary().getHotels().get(i).getHbsiPNR().equalsIgnoreCase("null")))){
						String hbsiPNR=searchResponse.getItinerary().getHotels().get(i).getHbsiPNR();
						saveItineraryChangeCommand.getItinerary().getHotels().get(i).setHbsiPNR(hbsiPNR);
					}
				}
			}		
		}
		ItineraryResponse itineraryResponse = itineraryService
				.saveItineraryChanges(saveItineraryChangeCommand.getItinerary(),searchResponse.getItinerary(), servicesResponse);

		// Update seat comments here
		if(!saveItineraryChangeCommand.getItinerary().isBookingCancelled() && !itineraryResponse.isErrorsOccurred())
		{
			commentList = SeatMapUtils.updateComments(itineraryResponse.getItinerary(), gatewayDestinationsService, gatewayDestMap,
					imApplicationInfo, false, false, seatMaterialSegIds);
		}
		
		if(warning != null)
		{
			itineraryResponse.saveWarning(warning);
		}
		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(saveItineraryChangeCommand, itineraryResponse);
		saveItineraryChangeCommand.setItinerary(itineraryResponse
				.getItinerary());
		
		// Save comments here
		if(commentList != null && commentList.size() > 0 && !SeatMapUtils.isSeatWarningMessage(itineraryResponse.getWarnings()))
		{
			CommentsResponse commentsResponse = null;
			try {
				 commentsResponse = commentsService.addComments(commentList);
			} catch (Exception e) {
				logger.debug("Error insering comments for seats selected.");
			}
			if(commentsResponse.isErrorsOccurred()) {
				logger.debug("Error insering comments for seats selected.");
			}
		}
		
		return saveItineraryChangeCommand;
	}
	
	/**
	 * Method to populate seat information for comments (ADD, UPDATE or REMOVE)
	 * @param seatAllocCurList of type List<SeatAllocations>
	 * @param seatAllocOldList of type List<SeatAllocations>
	 */
	private void populateSeatsInfo(List<SeatAllocations> seatAllocCurList, List<SeatAllocations> seatAllocOldList)
	{
		boolean matchFound = false;
		SimpleDateFormat sdfFormat = new SimpleDateFormat(ABEConstants.SEAT_SELECTED_DATE_FORMAT);
		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy");
		List<SeatAllocations> seatAllocationNewList = new ArrayList<SeatAllocations>();
		List<SeatAllocations> seatAllocationMergedList = new ArrayList<SeatAllocations>();
		if(seatAllocCurList == null) {
			seatAllocCurList = new ArrayList<SeatAllocations>();
		}
		if(seatAllocOldList != null) {
			for (SeatAllocations seatAllocOld : seatAllocOldList)
			{
				if(seatAllocCurList != null && seatAllocCurList.size() > 0)
				{
					matchFound = false;
					for (SeatAllocations seatAllocCur : seatAllocCurList)
					{
						if(seatAllocOld.getSegmentID().equalsIgnoreCase(seatAllocCur.getSegmentID())
								&& isPaxNoEqual(seatAllocOld.getPaxNo(), seatAllocCur.getPaxNo()))
						{
							matchFound = true;
							if(!(seatAllocOld.getSeatNo().equalsIgnoreCase(seatAllocCur.getSeatNo())))
							{
								seatAllocCur.setSeatSelected(ABEConstants.TRUE);
							}
							seatAllocCur.setSelectedDate(seatAllocOld.getSelectedDate());
							seatAllocCur.setOldSeatNo(seatAllocOld.getSeatNo());
							seatAllocationNewList.add(seatAllocCur);
							break;
						}
					}
					if(!matchFound)
					{
						seatAllocOld.setSeatSelected(ABEConstants.TRUE);
						seatAllocOld.setOldSeatNo(seatAllocOld.getSeatNo());
						seatAllocOld.setSeatNo(ABEConstants.BLANK);
						seatAllocationNewList.add(seatAllocOld);
						
					}
				} else {
					// Add alloc to remove here
					seatAllocOld.setSeatSelected(ABEConstants.TRUE);
					seatAllocOld.setOldSeatNo(seatAllocOld.getSeatNo());
					seatAllocOld.setSeatNo(ABEConstants.BLANK);
					seatAllocationNewList.add(seatAllocOld);
				}				
			}
		}		
		//Merge seat allocations with current list
		if(seatAllocCurList != null && seatAllocCurList.size() > 0 && seatAllocationNewList.size() > 0)
		{
			for (SeatAllocations seatAllocCur : seatAllocCurList)
			{
				matchFound = false;
				for (SeatAllocations seatAllocNewList : seatAllocationNewList)
				{
					if(seatAllocCur.getSegmentID().equalsIgnoreCase(seatAllocNewList.getSegmentID())
							&& isPaxNoEqual(seatAllocCur.getPaxNo(), seatAllocNewList.getPaxNo()))
					{
						matchFound = true;
						break;
					}					
				}
				if(!matchFound) {
					try {
						Date dateObj = format.parse(seatAllocCur.getSelectedDate());
						seatAllocCur.setSelectedDate(sdfFormat.format(dateObj));
					} catch (ParseException e) {
						logger.debug("Error parsing date in SaveItineraryChangeHandler"+e);
					}
					seatAllocationMergedList.add(seatAllocCur);
					seatAllocCur.setSeatSelected(ABEConstants.TRUE);
				}
			}
		}
		if(seatAllocOldList != null && seatAllocOldList.size() != 0)
		{
			seatAllocCurList.clear();
		} else if (seatAllocCurList != null) {
			populateSelectedDate(seatAllocCurList);
		}
		seatAllocCurList.addAll(seatAllocationNewList);
		seatAllocCurList.addAll(seatAllocationMergedList);
	}
	
	/**
	 * Method to populate departure date in seat allocation Object
	 * @param seatAllocCurList of type List<SeatAllocations>
	 */
	private void populateSelectedDate(List<SeatAllocations> seatAllocCurList) {
		SimpleDateFormat sdfFormat = new SimpleDateFormat(ABEConstants.SEAT_SELECTED_DATE_FORMAT);
		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy");
		Date dateObj = null;
		for (SeatAllocations seatAllocations : seatAllocCurList) {
			seatAllocations.setSeatSelected(ABEConstants.TRUE);
			try {
				dateObj = format.parse(seatAllocations.getSelectedDate());
				seatAllocations.setSelectedDate(sdfFormat.format(dateObj));
			} catch (ParseException e) {
				logger.debug("Error parsing date in SaveItineraryChangeHandler"+e);
			}
		}
	}
	/**
	 * Method to compare pax numbers, if found equal return true else false 
	 * @param oldPaxNo of type String
	 * @param paxNo of type String
	 * @return of type boolean (true/false)
	 */
	private boolean isPaxNoEqual(String oldPaxNo, String paxNo) {
		if(StringUtils.hasText(oldPaxNo) && StringUtils.hasText(paxNo)
				&& Integer.parseInt(oldPaxNo) == Integer.parseInt(paxNo)) {
			return true;
		}
		return false;
	}
	
	public CommentsService getCommentsService() {
		return commentsService;
	}

	public void setCommentsService(CommentsService commentsService) {
		this.commentsService = commentsService;
	}

	public GatewayDestinationsService getGatewayDestinationsService() {
		return gatewayDestinationsService;
	}

	public void setGatewayDestinationsService(
			GatewayDestinationsService gatewayDestinationsService) {
		this.gatewayDestinationsService = gatewayDestinationsService;
	}

	public BookingSearchService getBookingSearchService() {
		return bookingSearchService;
	}

	public void setBookingSearchService(BookingSearchService bookingSearchService) {
		this.bookingSearchService = bookingSearchService;
	}

	/**
	 * @return the servicesService
	 */
	public ServicesService getServicesService() {
		return servicesService;
	}

	/**
	 * @param servicesService the servicesService to set
	 */
	public void setServicesService(ServicesService servicesService) {
		this.servicesService = servicesService;
	}

}
