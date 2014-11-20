/*
 * RetrieveBookingCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 15, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.ResyncBookingCommand;
import com.kcdata.abe.application.command.RetrieveBookingCommand;
import com.kcdata.abe.business.response.BookingSearchResponse;
import com.kcdata.abe.business.service.AbeSmAvailService;
import com.kcdata.abe.business.service.BookingSearchService;
import com.kcdata.abe.business.service.GatewayDestinationsService;
import com.kcdata.abe.business.service.SeatMapAvailabiltyRunnable;
import com.kcdata.abe.data.util.FlightConvertUtils;
import com.kcdata.abe.data.util.SeatAvailResponseUtil;
import com.kcdata.abe.data.util.SeatMapUtils;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.sms.data.dto.SMLinkViewRequest;

/**
 * Command handler class for booking retrieval
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class RetrieveBookingCommandHandler extends ABECommandHandlerBase {

	ABELogger logger = ABELogger.getLogger(RetrieveBookingCommandHandler.class);
	
	// Service class instance
	private BookingSearchService bookingSearchService;
	private AbeSmAvailService abeSmAvailService;
	/**
	 * GatewayDestinationsService for reteriving gateway and destinations Strings
	 */
	private GatewayDestinationsService gatewayDestinationsService;

	/**
	 * @return the bookingSearchService
	 */
	public BookingSearchService getBookingSearchService() {
		return bookingSearchService;
	}

	/**
	 * @param bookingSearchService
	 *            the bookingSearchService to set
	 */
	public void setBookingSearchService(
			BookingSearchService bookingSearchService) {
		this.bookingSearchService = bookingSearchService;
	}

	/**
	 * Handle method implementation for booking retrieval
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof RetrieveBookingCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveBookingCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveBookingCommand retrieveBookingCommand = (RetrieveBookingCommand) command;
		
		BookingSearchResponse searchResponse = bookingSearchService
				.retrieveBooking(retrieveBookingCommand.getBookingNo());
		SeatAvailResponseUtil availResponseUtil = new SeatAvailResponseUtil();
		if((null != searchResponse.getItinerary()) && (searchResponse.getItinerary().getBookingHeader().isPriceMismatchError() || searchResponse.getItinerary().isNeedToResync())){
			
			final ResyncBookingCommand resyncBookingCommand = new ResyncBookingCommand();
			resyncBookingCommand.setBookingNo(searchResponse.getItinerary().getBookingHeader().getBookingNo());
			resyncBookingCommand.setIMApplicationInfo(retrieveBookingCommand.getIMApplicationInfo());
			resyncBookingCommand.setApplicationContext(retrieveBookingCommand.getApplicationContext());
			bookingSearchService.resyncBooking(resyncBookingCommand );
			searchResponse = bookingSearchService.retrieveBooking(retrieveBookingCommand.getBookingNo());
		}
		if(searchResponse != null && !searchResponse.isErrorsOccurred()) {
			//Remove seatmap services here
			SeatMapUtils.removeSeatServicesWhileRetrieve(searchResponse.getItinerary().getServices());
		}

		Thread mapAvailabiltyThread = null;
		SeatMapAvailabiltyRunnable mapAvailabiltyRunnable = null;
		boolean isShowAllLinks = false;
		boolean showSeatMapLink = false;
		
		//Validate if booking is Group Booking
		if(searchResponse != null && !searchResponse.isErrorsOccurred()) {
			showSeatMapLink = true;
			// As per last minute discuss System don't have to check any Keyword in Group Booking PAX NAme.
			// SeatMapUtils.validateBookingToShowLink(searchResponse.getItinerary());
		}
		if(searchResponse != null && !searchResponse.isErrorsOccurred() && searchResponse.getItinerary() != null 
				&& SeatMapUtils.getTripFlights(searchResponse.getItinerary()) != null && showSeatMapLink)
		{
			SMLinkViewRequest smLinkViewRequest = FlightConvertUtils.populateSmAvailRequestForRetrieveBooking(searchResponse.getItinerary());
			if(smLinkViewRequest.getSmSearchCriteriaDTOList().size() > 0)
			{
				try {
					// Thread to get seat map availability for the searched criteria
					mapAvailabiltyRunnable = new SeatMapAvailabiltyRunnable(abeSmAvailService, smLinkViewRequest);
					mapAvailabiltyThread = new Thread(mapAvailabiltyRunnable, "SeatMapAvailability");
					mapAvailabiltyThread.start();
					mapAvailabiltyThread.join();
				} catch (IllegalStateException ise) {
					logger.debug("Caught IllegalStateException while executing SeatMapAvailability Thread: ", ise);
					isShowAllLinks = true;
				} catch (Exception e) {
					logger.debug("Caught Exception while executing SeatMapAvailability Thread: ", e);
					isShowAllLinks = true;
				} finally {
					if(isShowAllLinks)
					{
						// populate default availability 'true' for charter flights
						availResponseUtil.populateSeatMapAvailability(null, SeatMapUtils.getTripFlights(searchResponse.getItinerary()), true, false);
					}
				}
			}
			if(!isShowAllLinks && mapAvailabiltyRunnable != null && mapAvailabiltyRunnable.getLinkViewResponse() != null
					&& mapAvailabiltyRunnable.getLinkViewResponse().getLinkViewResponseTypeList() != null)
			{
				availResponseUtil.populateSeatMapAvailability(mapAvailabiltyRunnable.getLinkViewResponse().getLinkViewResponseTypeList(),
						SeatMapUtils.getTripFlights(searchResponse.getItinerary()), false, false);
			} else {
				//Set default link true
				availResponseUtil.populateSeatMapAvailability(null, SeatMapUtils.getTripFlights(searchResponse.getItinerary()), true, false);
			}
		}		
		
		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(retrieveBookingCommand, searchResponse);
		retrieveBookingCommand.setItinerary(searchResponse.getItinerary());
		//Utility Call to set seat map req json in itinerary
		if(searchResponse != null && null != searchResponse.getItinerary() 
				&& !searchResponse.isErrorsOccurred() && showSeatMapLink) {
			FlightConvertUtils.populateSeatMapJsonReq(SeatMapUtils.getTripFlights(searchResponse.getItinerary()),
					gatewayDestinationsService, searchResponse.getItinerary());
		}
		return retrieveBookingCommand;
	}

	public GatewayDestinationsService getGatewayDestinationsService() {
		return gatewayDestinationsService;
	}

	public void setGatewayDestinationsService(
			GatewayDestinationsService gatewayDestinationsService) {
		this.gatewayDestinationsService = gatewayDestinationsService;
	}

	public AbeSmAvailService getAbeSmAvailService() {
		return abeSmAvailService;
	}

	public void setAbeSmAvailService(AbeSmAvailService abeSmAvailService) {
		this.abeSmAvailService = abeSmAvailService;
	}
}