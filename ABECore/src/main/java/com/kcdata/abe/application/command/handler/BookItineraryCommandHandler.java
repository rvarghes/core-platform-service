/*
 * BookItineraryCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 19, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import java.util.List;
import java.util.Map;

import com.kcdata.abe.application.command.BookItineraryCommand;
import com.kcdata.abe.business.response.CommentsResponse;
import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.business.response.ServicesResponse;
import com.kcdata.abe.business.service.CommentsService;
import com.kcdata.abe.business.service.GatewayDestinationsService;
import com.kcdata.abe.business.service.ItineraryService;
import com.kcdata.abe.business.service.ServicesService;
import com.kcdata.abe.data.dto.Comment;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.util.SeatMapUtils;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.framework.errorhandling.exception.ABEWarning;
import com.kcdata.abe.framework.logging.ABELogger;

/**
 * Command handler for booking itinerary usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class BookItineraryCommandHandler extends ABECommandHandlerBase {

	ABELogger logger = ABELogger.getLogger(BookItineraryCommandHandler.class);
	/**
	 * Itinerary booking service
	 */
	private ItineraryService itineraryService;
	/**
	 * Service class to retrieve services
	 */
	private ServicesService servicesService;
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
	 * Method to handle the BookItineraryCommand
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof BookItineraryCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "BookItineraryCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		BookItineraryCommand bookItineraryCommand = (BookItineraryCommand) command;

		ServicesResponse servicesResponse = servicesService.retrieveServices(bookItineraryCommand.getItinerary());
		List<String> seatMaterialSegIds = SeatMapUtils.getSegmentForSeatServiceAvailability(servicesResponse);
		ABEWarning warning = null;
		if(bookItineraryCommand.getItinerary() != null && bookItineraryCommand.getItinerary().getSeatAllocationList() != null)
		{
			warning = SeatMapUtils.setSeatChange(bookItineraryCommand.getItinerary().getSeatAllocationList(),seatMaterialSegIds);
		}
		
		
		// Book Itinerary
		ItineraryResponse itineraryResponse = itineraryService
				.bookItinerary(bookItineraryCommand.getItinerary(), servicesResponse);
		
		if(warning != null)
		{
			itineraryResponse.saveWarning(warning);
		}
		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(bookItineraryCommand, itineraryResponse);
		
		if(itineraryResponse.getItinerary() != null && itineraryResponse.getItinerary().getSeatAllocationList() != null &&
				itineraryResponse.getItinerary().getSeatAllocationList().size() > 0 
				&& !SeatMapUtils.isSeatWarningMessage(itineraryResponse.getWarnings()))
		{
			//List<String> seatMaterialSegIds = SeatMapUtils.getSegmentForSeatServiceAvailability(servicesResponse);
			if(seatMaterialSegIds != null && seatMaterialSegIds.size() > 0) {
				IMApplicationInfo imApplicationInfo = this.getApplicationContextFactory().getApplicationContext()
					.getRequestContext().getIMApplicationInfo();
				// Add seat comments here
				List<Comment> commentList = SeatMapUtils.updateComments(itineraryResponse.getItinerary(), gatewayDestinationsService, gatewayDestMap,
						imApplicationInfo, true, false, seatMaterialSegIds);
				// Save comments here
				if(commentList.size() > 0)
				{
					CommentsResponse commentsResponse = commentsService.addComments(commentList);
					if(commentsResponse.isErrorsOccurred()) {
						logger.debug("Error insering comments for seats selected.");
					}
				}
			}
		}
		
		bookItineraryCommand.setItinerary(itineraryResponse
				.getItinerary());
		return bookItineraryCommand;
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
