/*
 * RetrieveFlightsCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 26, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.FlightOffer;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.GroupedTripFlight;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class for retrieving flights
 * Retrieve flights usecase
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class RetrieveFlightsCommand extends ABECommandBase {
	
	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -8229223012133674935L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveFlightsCommandHandler";
	public static final String SEAT_MAP_AVAILABILITY = "SEAT_MAP_AVAILABILITY";
	
	/**
	 * Search criteria for retrieving flights
	 */
	private SearchCriteria searchCriteria;
	
	/**
	 * Flights response 
	 */
	public List<TripFlight> flights;
	//IGT-A--Issue # 3620601---START
	private List<GroupedTripFlight> groupedTripFlight;
	private List<TripFlight> displayTripFlightList;
	//IGT-A--Issue # 3620601---END
	
	private String subCommand;
	
	private Itinerary itineraryChangeFlight;
	//Added as indicator if requested charter flight date(s) are all sold out
	private boolean charterSoldOut;
	private boolean excludeCharterSoldOut;
	private FlightOffer flightOffer;

	/**
	 * Method to retrieve the command handler name
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public String getCommandHandlerName() {
		return COMMAND_HANDLER_NAME;
	}

	/**
	 * @return the searchCriteria
	 */
	public SearchCriteria getSearchCriteria() {
		return searchCriteria;
	}

	/**
	 * @param searchCriteria the searchCriteria to set
	 */
	public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	/**
	 * @return the flights
	 */
	public List<TripFlight> getFlights() {
		return flights;
	}

	/**
	 * @param flights the flights to set
	 */
	public void setFlights(List<TripFlight> flights) {
		this.flights = flights;
	}
	
	/**
	 * @return the subCommand
	 */
	public String getSubCommand() {
		return subCommand;
	}

	/**
	 * @param subCommand
	 *            the subCommand to set
	 */
	public void setSubCommand(String subCommand) {
		this.subCommand = subCommand;
	}

	//IGT-A--Issue # 3620601---START
	/**
	 * @return the groupedTripFlight
	 */
	public List<GroupedTripFlight> getGroupedTripFlight() {
		return groupedTripFlight;
	}

	/**
	 * @param groupedTripFlight the groupedTripFlight to set
	 */
	public void setGroupedTripFlight(List<GroupedTripFlight> groupedTripFlight) {
		this.groupedTripFlight = groupedTripFlight;
	}

	/**
	 * @return the displayTripFlightList
	 */
	public List<TripFlight> getDisplayTripFlightList() {
		return displayTripFlightList;
	}

	/**
	 * @param displayTripFlightList the displayTripFlightList to set
	 */
	public void setDisplayTripFlightList(List<TripFlight> displayTripFlightList) {
		this.displayTripFlightList = displayTripFlightList;
	}
	//IGT-A--Issue # 3620601---END

	/**
	 * @return the itineraryChangeBooking
	 */
	public Itinerary getItineraryChangeFlight() {
		return itineraryChangeFlight;
	}

	/**
	 * @param itineraryChangeBooking the itineraryChangeBooking to set
	 */
	public void setItineraryChangeFlight(Itinerary itineraryChangeFlight) {
		this.itineraryChangeFlight = itineraryChangeFlight;
	}
	
	/**
	 * @return the charterSoldOut
	 */
	public boolean getCharterSoldOut() {
		return charterSoldOut;
	}

	/**
	 * @param charterSoldOut the charterSoldOut to set
	 */
	public void setCharterSoldOut(boolean charterSoldOut) {
		this.charterSoldOut = charterSoldOut;
	}

	/**
	 * @return the excludeCharterSoldOut
	 */
	public boolean getExcludeCharterSoldOut() {
		return excludeCharterSoldOut;
	}

	/**
	 * @param excludeCharterSoldOut the excludeCharterSoldOut to set
	 */
	public void setExcludeCharterSoldOut(boolean excludeCharterSoldOut) {
		this.excludeCharterSoldOut = excludeCharterSoldOut;
	}

	/**
	 * @return the flightOffer
	 */
	public FlightOffer getFlightOffer() {
		return flightOffer;
	}

	/**
	 * @param flightOffer the flightOffer to set
	 */
	public void setFlightOffer(FlightOffer flightOffer) {
		this.flightOffer = flightOffer;
	}

}