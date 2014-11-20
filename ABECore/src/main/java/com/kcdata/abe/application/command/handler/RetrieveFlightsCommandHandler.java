/*
 * RetrieveFlightsCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 26, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import java.util.List;

import com.kcdata.abe.application.command.RetrieveFlightsCommand;
import com.kcdata.abe.business.response.FlightsResponse;
import com.kcdata.abe.business.service.AbeSmAvailService;
import com.kcdata.abe.business.service.FlightsService;
import com.kcdata.abe.business.service.GatewayDestinationsService;
import com.kcdata.abe.business.service.SeatMapAvailabiltyRunnable;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.util.FlightConvertUtils;
import com.kcdata.abe.data.util.SeatAvailResponseUtil;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.sms.data.dto.SMLinkViewRequest;

/**
 * Command handler for RetrieveFlightsCommand RetrieveFlights usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrieveFlightsCommandHandler extends ABECommandHandlerBase {

	/**
	 * Logger for RetrieveFlightsCommandHandler
	 */
	ABELogger logger = ABELogger.getLogger(RetrieveFlightsCommandHandler.class);
	/**
	 * Service class for the command
	 */
	private FlightsService flightsService;
	/**
	 * AbeSmAvailService for command
	 */
	private AbeSmAvailService abeSmAvailService;
	/**
	 * Field contains days ahead from flight search date
	 */
	private byte daysAhead;
	/**
	 * Field contains days behind from flight search date
	 */
	private byte daysBehind;
	/**
	 * GatewayDestinationsService for retrieving gateway and destinations Strings
	 */
	private GatewayDestinationsService gatewayDestinationsService;

	/**
	 * Method to handle the RetrieveFlightsCommand
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public ABECommand handle(ABECommand command) {

		if (!(command instanceof RetrieveFlightsCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveFlightsCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION, new IllegalArgumentException(
					message));
		}
		RetrieveFlightsCommand flightsCommand = (RetrieveFlightsCommand) command;
		SeatAvailResponseUtil availResponseUtil = new SeatAvailResponseUtil();
		Thread mapAvailabiltyThread = null;
		SeatMapAvailabiltyRunnable mapAvailabiltyRunnable = null;
		boolean isShowAllLinks = false;
		DestinationOptions destOptions = null;
		if (flightsCommand.getSearchCriteria() != null) {
			List<DestinationOptions> destOptionsList = flightsCommand
				.getSearchCriteria().getDestinationOptions();
			if (destOptionsList != null && destOptionsList.size() >= 0) {
				destOptions = (DestinationOptions) destOptionsList.get(0);
			}
		}
		
		if ((destOptions != null && destOptions.isAirRequested() && !destOptions
				.isSkedOnly()) || destOptions.isCharterOnly()) {
			try {
				// Thread to get seat map availability for the searched criteria
				SMLinkViewRequest smLinkViewRequest = availResponseUtil.populateSmAvailRequest(flightsCommand.getSearchCriteria(), daysAhead, daysBehind);
				mapAvailabiltyRunnable = new SeatMapAvailabiltyRunnable(abeSmAvailService, smLinkViewRequest);
				mapAvailabiltyThread = new Thread(mapAvailabiltyRunnable, "SeatMapAvailability");
				mapAvailabiltyThread.start();
			} catch (IllegalStateException ise) {
				logger.debug("Caught IllegalStateException while executing SeatMapAvailability Thread: ", ise);
				isShowAllLinks = true;
			} catch (Exception e) {
				logger.debug("Caught Exception while executing SeatMapAvailability Thread: ", e);
				isShowAllLinks = true;
			} finally {
				if (isShowAllLinks) {
					mapAvailabiltyThread = null;
					mapAvailabiltyRunnable = null;
				}
			}
		}

		// Retrieve Flights
		FlightsResponse flightsResponse =  new FlightsResponse();
		Itinerary itin = flightsCommand.getItineraryChangeFlight();
		if(itin!=null){
			itin.setSearchCriteria(new SearchCriteria());
			flightsCommand.getSearchCriteria().setItineraryChangeFlight(itin);
		}
		if(flightsCommand.getSubCommand()!=null && flightsCommand.getSubCommand().equals(RetrieveFlightsCommand.SEAT_MAP_AVAILABILITY)) {
			flightsResponse.setFlightList(flightsCommand.getFlights());
			if(flightsCommand.getFlights() != null && flightsCommand.getFlights().size() > 0) {
				FlightConvertUtils.populateSeatMapSegId(flightsCommand.getFlights());
			}
		} else {			
			flightsResponse=flightsService.retrieveFlights(flightsCommand.getSearchCriteria());
		}
			
		
		if (flightsResponse.getFlightOffer() != null){
			flightsCommand.setFlightOffer(flightsResponse.getFlightOffer());
			if (flightsResponse.getFlightOffer().isCharterFlightOffer())
				//reset the flag since it will be used only for flight search triggered on search button
				flightsCommand.getSearchCriteria().setCheckCharterOfferFlight(false);
		}
		
		// Process response and set the business errors, warnings, and info messages to command
		this.processResponse(flightsCommand, flightsResponse);
		try {
			if (mapAvailabiltyThread != null) {
				mapAvailabiltyThread.join();
			}
		} catch (InterruptedException ie) {
			logger.debug("Caught InterruptedException while joining SeatMapAvailability Thread: ", ie);
			isShowAllLinks = true;
		} catch (Exception e) {
			logger.debug("Caught Exception while joining SeatMapAvailability Thread: ", e);
			isShowAllLinks = true;
		} finally {
			if (isShowAllLinks) {
				// populate default availability 'true' for charter flights
				availResponseUtil.populateSeatMapAvailability(null, flightsResponse.getFlightList(), true, true);
			}
		}
		if (mapAvailabiltyRunnable != null && !isShowAllLinks && mapAvailabiltyRunnable.getLinkViewResponse() != null
				&& mapAvailabiltyRunnable.getLinkViewResponse().getLinkViewResponseTypeList() != null) {
			availResponseUtil.populateSeatMapAvailability(mapAvailabiltyRunnable.getLinkViewResponse().getLinkViewResponseTypeList(),
					flightsResponse.getFlightList(), false, true);
		} else {
			// populate default availability 'true' for charter flights
			availResponseUtil.populateSeatMapAvailability(null, flightsResponse.getFlightList(), true, true);
		}

		// Populate Seat Map Request JSON
		FlightConvertUtils.populateSeatMapJsonReq(flightsResponse.getFlightList(), gatewayDestinationsService, null);
		flightsCommand.setFlights(flightsResponse.getFlightList());
		//IGT-A--Issue # 3620601---START
		flightsCommand.setGroupedTripFlight(flightsResponse.getGroupedTripFlight());
		flightsCommand.setDisplayTripFlightList(flightsResponse.getDisplayTripFlightList());
		//IGT-A--Issue # 3620601---END
		//Added to set status if requested charter flight date(s) are all sold out or not
		if (!flightsCommand.getExcludeCharterSoldOut())
			flightsCommand.setCharterSoldOut(flightsResponse.isSoldOutFlights());
		return flightsCommand;
	}

	/**
	 * @return the flightsService
	 */
	public FlightsService getFlightsService() {
		return flightsService;
	}

	/**
	 * @param flightsService
	 *            the flightsService to set
	 */
	public void setFlightsService(FlightsService flightsService) {
		this.flightsService = flightsService;
	}

	public GatewayDestinationsService getGatewayDestinationsService() {
		return gatewayDestinationsService;
	}

	public void setGatewayDestinationsService(
			GatewayDestinationsService gatewayDestinationsService) {
		this.gatewayDestinationsService = gatewayDestinationsService;
	}

	public byte getDaysAhead() {
		return daysAhead;
	}

	public void setDaysAhead(byte daysAhead) {
		this.daysAhead = daysAhead;
	}

	public byte getDaysBehind() {
		return daysBehind;
	}

	public void setDaysBehind(byte daysBehind) {
		this.daysBehind = daysBehind;
	}

	public AbeSmAvailService getAbeSmAvailService() {
		return abeSmAvailService;
	}

	public void setAbeSmAvailService(AbeSmAvailService abeSmAvailService) {
		this.abeSmAvailService = abeSmAvailService;
	}
}
