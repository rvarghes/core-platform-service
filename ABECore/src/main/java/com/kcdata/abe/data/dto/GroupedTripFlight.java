//IGT-A--Issue # 3620601--New File--Feb06,2013
package com.kcdata.abe.data.dto;

import java.util.List;

public class GroupedTripFlight {

	public GroupedTripFlight() {
	
	}
	
	private String flightId;
	private List <TripFlight> tripFlights;
	private String flightTypeStr;
	// Field added for Support Item #3535943
	private boolean isPackagePriced;
	
	/**
	 * @return the flightId
	 */
	public String getFlightId() {
		return flightId;
	}
	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	/**
	 * @return the tripFlights
	 */
	public List<TripFlight> getTripFlights() {
		return tripFlights;
	}
	/**
	 * @param tripFlights the tripFlights to set
	 */
	public void setTripFlights(List<TripFlight> tripFlights) {
		this.tripFlights = tripFlights;
	}
	/**
	 * @return the flightTypeStr
	 */
	public String getFlightTypeStr() {
		return flightTypeStr;
	}
	/**
	 * @param flightTypeStr the flightTypeStr to set
	 */
	public void setFlightTypeStr(String flightTypeStr) {
		this.flightTypeStr = flightTypeStr;
	}
	/**
	 * @return the isPackagePriced
	 */
	public boolean isPackagePriced() {
		return isPackagePriced;
	}
	/**
	 * @param isPackagePriced the isPackagePriced to set
	 */
	public void setPackagePriced(boolean isPackagePriced) {
		this.isPackagePriced = isPackagePriced;
	}
}