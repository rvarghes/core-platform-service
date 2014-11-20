/**
 * 
 * Class used for fixing support Fix #3535943
 * 
 */

package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.GroupedTripFlight;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.framework.command.ABECommandBase;

public class PriceChangeBookingCommand  extends ABECommandBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4809004677366755020L;
	
	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "priceChangeBookingCommandHandler";
	
	
	private List<GroupedTripFlight> groupedTripFlight;
	
	private List<GroupedTripFlight> totalGroupedTripFlight;
	
	private List<TripFlight> displayTripFlightList;
	
	private Itinerary itinerary;
	
	private String bookingTypeIndicator;
	
	public String getCommandHandlerName() {
		// TODO Auto-generated method stub
		return COMMAND_HANDLER_NAME;
	}

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
	 * @return the itinerary
	 */
	public Itinerary getItinerary() {
		return itinerary;
	}

	/**
	 * @param itinerary the itinerary to set
	 */
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	/**
	 * @return the bookingTypeIndicator
	 */
	public String getBookingTypeIndicator() {
		return bookingTypeIndicator;
	}

	/**
	 * @param bookingTypeIndicator the bookingTypeIndicator to set
	 */
	public void setBookingTypeIndicator(String bookingTypeIndicator) {
		this.bookingTypeIndicator = bookingTypeIndicator;
	}

	/**
	 * @return the totalGroupedTripFlight
	 */
	public List<GroupedTripFlight> getTotalGroupedTripFlight() {
		return totalGroupedTripFlight;
	}

	/**
	 * @param totalGroupedTripFlight the totalGroupedTripFlight to set
	 */
	public void setTotalGroupedTripFlight(
			List<GroupedTripFlight> totalGroupedTripFlight) {
		this.totalGroupedTripFlight = totalGroupedTripFlight;
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

}
