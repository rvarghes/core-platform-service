/*
 * RetrievePackagesCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 25, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.application.command.RetrievePackagesCommand;
import com.kcdata.abe.business.request.PackagesRequest;
import com.kcdata.abe.business.response.PackagesResponse;
import com.kcdata.abe.business.service.AbeSmAvailService;
import com.kcdata.abe.business.service.GatewayDestinationsService;
import com.kcdata.abe.business.service.PackagesService;
import com.kcdata.abe.business.service.SeatMapAvailabiltyRunnable;
import com.kcdata.abe.data.dao.GatewayDestinationsDao;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.TripFlight;
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
 * Command handler for RetrievePackagesCommand RetrievePackages usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrievePackagesCommandHandler extends ABECommandHandlerBase {

	ABELogger logger = ABELogger.getLogger(RetrievePackagesCommandHandler.class);
	/**
	 * Service to retrieve the packages
	 */
	private PackagesService packagesService;

	private AbeSmAvailService abeSmAvailService;
	private byte daysAhead;
	private byte daysBehind;
	/**
	 * GatewayDestinationsDao for validating the Charter Gateway and destinations
	 */
	private GatewayDestinationsDao gatewayDestinationsDao;

	/**
	 * GatewayDestinationsService for reteriving gateway and destinations Strings
	 */
	private GatewayDestinationsService gatewayDestinationsService;
	
	/**
	 * @return the packagesService
	 */
	public PackagesService getPackagesService() {
		return packagesService;
	}

	/**
	 * @param packagesService
	 *            the packagesService to set
	 */
	public void setPackagesService(PackagesService packagesService) {
		this.packagesService = packagesService;
	}

	/**
	 * Method to handle the RetrievePackagesCommand
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof RetrievePackagesCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrievePackagesCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrievePackagesCommand packagesCommand = (RetrievePackagesCommand) command;
		PackagesResponse packagesResponse;
		SeatAvailResponseUtil availResponseUtil = new SeatAvailResponseUtil();
		Thread mapAvailabiltyThread = null;
		SeatMapAvailabiltyRunnable mapAvailabiltyRunnable = null;
		boolean isShowAllLinks = false;
		DestinationOptions destOptions = null;
		boolean isValidCharterPair = false;
		List<TripFlight> selectedFlightList = new ArrayList<TripFlight>();
			
		if(packagesCommand.getSearchCriteria() != null)
		{
		PackagesRequest packagesRequest = packagesCommand.getSearchCriteria().getPackagesRequest();
		if(packagesRequest.getFlightsRequest() !=null){
		isValidCharterPair = gatewayDestinationsDao
		.isCharterOfferedGatewayDestination(packagesRequest
				.getFlightsRequest().getGateway(),
				packagesRequest.getFlightsRequest()
						.getDestination());
		}
			List<DestinationOptions> destOptionsList = packagesCommand.getSearchCriteria().getDestinationOptions();
			if(destOptionsList != null && destOptionsList.size() >= 0)
			{
				destOptions = (DestinationOptions)destOptionsList.get(0);
			}
		}
		
		if(destOptions != null && isValidCharterPair)
		{
			try {
				// Thread to get seat map availability for the searched criteria
				SMLinkViewRequest smLinkViewRequest = availResponseUtil.populateSmAvailRequest(packagesCommand.getSearchCriteria(), daysAhead, daysBehind);
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
				if(isShowAllLinks)
				{
					mapAvailabiltyThread = null;
					mapAvailabiltyRunnable = null;
				}
			}
		}
		
		if (RetrievePackagesCommand.CHANGE_FLIGHT.equals(packagesCommand
				.getSubCommand())) {
			// Change flight of a package
			packagesResponse = packagesService
					.changeFlights(packagesCommand.getSearchCriteria(),
							packagesCommand.getAvailablePackage());
		} else if (RetrievePackagesCommand.CHANGE_HOTEL.equals(packagesCommand
				.getSubCommand())) {
			// Change hotel component of a package
			packagesResponse = packagesService
					.changeHotels(packagesCommand.getSearchCriteria(),
							packagesCommand.getAvailablePackage());
		} else if (RetrievePackagesCommand.CHANGE_VEHICLE
				.equals(packagesCommand.getSubCommand())) {
			// Change vehicle component of a package
			packagesResponse = packagesService
					.changeVehicles(packagesCommand.getSearchCriteria(),
							packagesCommand.getAvailablePackage());
		} else if (RetrievePackagesCommand.SPECIAL_PACKAGE_AVAILABILITY
				.equals(packagesCommand.getSubCommand())) {
			// Get Special packages
			packagesResponse = packagesService
					.retrieveSpecialPackages(packagesCommand.getSearchCriteria());
		} else {
			// Retrieve Packages
			packagesResponse = packagesService.retrievePackages(packagesCommand
					.getSearchCriteria());
		}

		if (packagesResponse.getFlightOffer() != null){
			packagesCommand.setFlightOffer(packagesResponse.getFlightOffer());
			if (packagesResponse.getFlightOffer().isCharterFlightOffer())
				//reset the flag since it will be used only for flight search triggered on search button
				packagesCommand.getSearchCriteria().setCheckCharterOfferFlight(false);
		}
		
		try {
			if(packagesResponse.getAvailablePackage() != null && packagesResponse.getAvailablePackage().getSelectedFlight() != null)
			{
				selectedFlightList.add(packagesResponse.getAvailablePackage().getSelectedFlight());
			}
			if(mapAvailabiltyThread != null)
			{
				mapAvailabiltyThread.join();
			}
		} catch (InterruptedException ie) {
			logger.debug("Caught InterruptedException while joining SeatMapAvailability Thread: ", ie);
			isShowAllLinks = true;
		} catch (Exception e) {
			logger.debug("Caught Exception while joining SeatMapAvailability Thread: ", e);
			isShowAllLinks = true;
		} finally {
			if(isShowAllLinks)
			{
				// populate default availability 'true' for charter flights
				if(packagesResponse.getAvailablePackage() != null)
				{
					if(packagesResponse.getAvailablePackage().getFlightOptions() != null)
					{
						availResponseUtil.populateSeatMapAvailability(null, packagesResponse.getAvailablePackage().getFlightOptions(), true, true);
					}
					availResponseUtil.populateSeatMapAvailability(null, selectedFlightList, true, true);
				}
			}
		}
		if(mapAvailabiltyRunnable != null && packagesResponse.getAvailablePackage() != null)
		{
			if(!isShowAllLinks && mapAvailabiltyRunnable.getLinkViewResponse() != null
					&& mapAvailabiltyRunnable.getLinkViewResponse().getLinkViewResponseTypeList() != null)
			{
				availResponseUtil.populateSeatMapAvailability(mapAvailabiltyRunnable.getLinkViewResponse().getLinkViewResponseTypeList(),
						packagesResponse.getAvailablePackage().getFlightOptions(), false, true);
				availResponseUtil.populateSeatMapAvailability(mapAvailabiltyRunnable.getLinkViewResponse().getLinkViewResponseTypeList(),
						selectedFlightList, false, true);
			} else {
				// populate default availability 'true' for charter flights
				availResponseUtil.populateSeatMapAvailability(null, packagesResponse.getAvailablePackage().getFlightOptions(), true, true);
				availResponseUtil.populateSeatMapAvailability(null, selectedFlightList, true, true);
			}
		}
		
		if(isValidCharterPair && packagesResponse.getAvailablePackage() != null)
		{
			// Populate Seat Map Request JSON
			FlightConvertUtils.populateSeatMapJsonReq(packagesResponse.getAvailablePackage().getFlightOptions(), gatewayDestinationsService, null);
			FlightConvertUtils.populateSeatMapJsonReq(selectedFlightList, gatewayDestinationsService, null);
		}
		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(packagesCommand, packagesResponse);
		packagesCommand.setAvailablePackage(packagesResponse
				.getAvailablePackage());
		//Added to set status if requested charter flight date(s) are all sold out or not
		packagesCommand.setCharterSoldOut(packagesResponse.isSoldOutFlights());
		return packagesCommand;
	}

	public AbeSmAvailService getAbeSmAvailService() {
		return abeSmAvailService;
	}

	public void setAbeSmAvailService(AbeSmAvailService abeSmAvailService) {
		this.abeSmAvailService = abeSmAvailService;
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

	public GatewayDestinationsDao getGatewayDestinationsDao() {
		return gatewayDestinationsDao;
	}

	public void setGatewayDestinationsDao(
			GatewayDestinationsDao gatewayDestinationsDao) {
		this.gatewayDestinationsDao = gatewayDestinationsDao;
	}

	public GatewayDestinationsService getGatewayDestinationsService() {
		return gatewayDestinationsService;
	}

	public void setGatewayDestinationsService(
			GatewayDestinationsService gatewayDestinationsService) {
		this.gatewayDestinationsService = gatewayDestinationsService;
	}

}
