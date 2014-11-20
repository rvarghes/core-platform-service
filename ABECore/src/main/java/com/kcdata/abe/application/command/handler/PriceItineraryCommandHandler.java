/*
 * PriceItineraryCommandHandler.java
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

import com.kcdata.abe.application.command.PriceItineraryCommand;
import com.kcdata.abe.business.response.ItineraryPricingResponse;
import com.kcdata.abe.business.service.GatewayDestinationsService;
import com.kcdata.abe.business.service.ItineraryPricingService;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.util.FlightConvertUtils;
import com.kcdata.abe.data.util.SeatMapUtils;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler for PriceItineraryCommand usecase
 * 
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class PriceItineraryCommandHandler extends ABECommandHandlerBase {
	
	/**
	 * Itinerary pricing service
	 */
	private ItineraryPricingService itineraryPricingService;
	/**
	 * GatewayDestinationsService for retrieving gateway and destinations Strings
	 */
	private GatewayDestinationsService gatewayDestinationsService;

	/**
	 * Method to handle the PriceItineraryCommand
	 *
	 * @param command
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof PriceItineraryCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "PriceItineraryCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION, new IllegalArgumentException(
					message));
		}
		PriceItineraryCommand priceItineraryCommand = (PriceItineraryCommand) command;
		//Start the fix of AV-3749/HBSI 52 --getting up the corrected RoomTypeCode before price calculated.
		String roomTypeCode = null;
		String roomTypeDesc = null;
		if (priceItineraryCommand.getItinerary().getHotels() != null) {
			if(priceItineraryCommand.getItinerary().getHotels().get(0).getDisplayRoomCategory()!=null){
			if (priceItineraryCommand.getItinerary().getHotels().get(0).getDisplayRoomCategory().getRoomTypeCode() != null
					|| (! (priceItineraryCommand.getItinerary().getHotels().get(0).getDisplayRoomCategory().getRoomTypeCode().equals("")))){ 
			roomTypeCode = priceItineraryCommand.getItinerary().getHotels()
					.get(0).getDisplayRoomCategory().getRoomTypeCode();
		}
			if (priceItineraryCommand.getItinerary().getHotels().get(0).getDisplayRoomCategory().getRoomTypeDescription() != null
					|| (! (priceItineraryCommand.getItinerary().getHotels().get(0).getDisplayRoomCategory().getRoomTypeDescription().equals("")))){
			roomTypeDesc = priceItineraryCommand.getItinerary().getHotels()
					.get(0).getDisplayRoomCategory().getRoomTypeDescription();
		}
		}
		} else if (priceItineraryCommand.getItinerary().getPackages() != null
				&& priceItineraryCommand.getItinerary().getPackages().get(0)
						.getSelectedHotel() != null
				) {
			if(priceItineraryCommand.getItinerary().getPackages().get(0).getSelectedHotel().getDisplayRoomCategory()!=null){
			if (priceItineraryCommand.getItinerary().getPackages()
					.get(0).getSelectedHotel().getDisplayRoomCategory()
					.getRoomTypeCode() != null
					|| (! (priceItineraryCommand.getItinerary().getPackages()
							.get(0).getSelectedHotel().getDisplayRoomCategory()
							.getRoomTypeCode().equals("")))){
			roomTypeCode = priceItineraryCommand.getItinerary().getPackages()
					.get(0).getSelectedHotel().getDisplayRoomCategory()
					.getRoomTypeCode();
			}
			if (priceItineraryCommand.getItinerary().getPackages()
					.get(0).getSelectedHotel().getDisplayRoomCategory()
					.getRoomTypeDescription() != null
					|| (! (priceItineraryCommand.getItinerary().getPackages()
							.get(0).getSelectedHotel().getDisplayRoomCategory()
							.getRoomTypeDescription().equals("")))){
			roomTypeDesc = priceItineraryCommand.getItinerary().getPackages()
					.get(0).getSelectedHotel().getDisplayRoomCategory()
					.getRoomTypeDescription();
				}
			}
		}
		//End of the fix of Av-3749/HBsi 52 .

		// Price Itinerary
		ItineraryPricingResponse pricingResponse = itineraryPricingService.priceItinerary(priceItineraryCommand.getItinerary());
		// Process response and set the business errors, warnings, and info messages to command
		this.processResponse(priceItineraryCommand, pricingResponse);
		// Populate Seat Map Request JSON
		List<TripFlight> tripFlightsList = SeatMapUtils.getTripFlights(pricingResponse.getItinerary());
		// Flag added to populate Seat Map Json Request.
		boolean isGroupRequestFlag = false;
		if(pricingResponse.getItinerary().getBookingHeader()!=null && 
		    pricingResponse.getItinerary().getBookingHeader().getBookingDocumentType()!=null &&
			!"".equals(pricingResponse.getItinerary().getBookingHeader().getBookingDocumentType()) && 
			"ZGR".equalsIgnoreCase(pricingResponse.getItinerary().getBookingHeader().getBookingDocumentType())){
			isGroupRequestFlag = true;
			FlightConvertUtils.populateSeatMapJsonReq(tripFlightsList, gatewayDestinationsService, isGroupRequestFlag);
		}	
		else{
			FlightConvertUtils.populateSeatMapJsonReq(tripFlightsList, gatewayDestinationsService, null);
		}
		priceItineraryCommand.setItinerary(pricingResponse.getItinerary());
		//Start the fix of AV-3749/HBSI 52 --Setting up the corrected RoomTypeCode after price calculated.
		if (priceItineraryCommand.getItinerary().getHotels() != null) {
			if(priceItineraryCommand.getItinerary().getHotels().get(0).getDisplayRoomCategory()!=null){
			priceItineraryCommand.getItinerary().getHotels().get(0)
					.getDisplayRoomCategory().setRoomTypeCode(roomTypeCode);
			priceItineraryCommand.getItinerary().getHotels().get(0)
					.getDisplayRoomCategory()
					.setRoomTypeDescription(roomTypeDesc);
			}
		} else if (priceItineraryCommand.getItinerary().getPackages() != null
				&& priceItineraryCommand.getItinerary().getPackages().get(0)
						.getSelectedHotel() != null
				) {
			if(priceItineraryCommand.getItinerary().getPackages().get(0).getSelectedHotel().getDisplayRoomCategory()!=null){
			priceItineraryCommand.getItinerary().getPackages().get(0).getSelectedHotel().getDisplayRoomCategory()
					.setRoomTypeCode(roomTypeCode);
			priceItineraryCommand.getItinerary().getPackages().get(0).getSelectedHotel().getDisplayRoomCategory()
					.setRoomTypeDescription(roomTypeDesc);
		}
		}
		//End of the fix of AV-3749/HBsi52 .
		return priceItineraryCommand;
	}

	/**
	 * @return the itineraryPricingService
	 */
	public ItineraryPricingService getItineraryPricingService() {
		return itineraryPricingService;
	}

	/**
	 * @param itineraryPricingService the itineraryPricingService to set
	 */
	public void setItineraryPricingService(
			ItineraryPricingService itineraryPricingService) {
		this.itineraryPricingService = itineraryPricingService;
	}

	/**
	 * @return the gatewayDestinationsService
	 */
	public GatewayDestinationsService getGatewayDestinationsService() {
		return gatewayDestinationsService;
	}

	/**
	 * @param gatewayDestinationsService the gatewayDestinationsService to set
	 */
	public void setGatewayDestinationsService(
			GatewayDestinationsService gatewayDestinationsService) {
		this.gatewayDestinationsService = gatewayDestinationsService;
	}

}
