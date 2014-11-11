/*
 * FlightsResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 26, 2009  hguntupa
 * Sep 14, 2009	 hguntupa	  Added methods for flights availability of packages
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.bapi.util.Yst_Ota_Flt_Orig_DestType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List;
/*Code commented for revocation of 3620608 on 04/05/2013*/
//import com.kcdata.abe.bapi.util.Yzst_Ota_Flt_Segments_CpyType_List;
import com.kcdata.abe.data.dto.CharterFlightsDates;
import com.kcdata.abe.data.dto.FlightOffer;
import com.kcdata.abe.data.dto.GroupedTripFlight;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Class for Flight Response RetrieveFlights usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class FlightsResponse extends ABEResponse {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 534203163004566807L;

	/**
	 * Field to hold flights
	 */
	private List<TripFlight> flightList;
	private List<CharterFlightsDates> charterDates;
	private List<CharterFlightsDates> charterNotAvailDates;
	private List<java.util.Date> nonCharterDates;
	//IGT-A--Issue # 3620601---START
	private List<GroupedTripFlight> groupedTripFlight;
	private List<TripFlight> displayTripFlightList;
	//IGT-A--Issue # 3620601---END	
	//Added as indicator of sold out charter flight
	private boolean soldOutFlights;
	/*
	 * For packages, we will be calling the multiple threads to retrieve the
	 * availability BAPI and then consolidate them in the form of packages. As
	 * we are passing the availability response(sap structures) to package
	 * consolidation, we would like to reduce the time of parsing SAP structures
	 * to JAVA DTO objects and from DTO objects back to SAP structures during
	 * consolidation. So, we will be caching the availability SAP structures and
	 * passing the same to consolidation BAPI. The below fields helps us to
	 * cache the availability response
	 */
	private Yst_Ota_Flt_SegmentsType_List sapSegmentsList;
	private Yst_Ota_Flt_Orig_DestType_List sapOrigDestOptionsList;
	/*Code commented for revocation of 3620608 on 04/05/2013*/
	// Field added for Support Item #3620608
	//private Yzst_Ota_Flt_Segments_CpyType_List sapAddedSegmentsList;

	private FlightOffer flightOffer;

	/**
	 * @return the flightList
	 */
	public List<TripFlight> getFlightList() {
		return flightList;
	}

	/**
	 * @param flightList
	 *            the flightList to set
	 */
	public void setFlightList(List<TripFlight> flightList) {
		this.flightList = flightList;
	}

	/**
	 * @return the sapSegmentsList
	 */
	public Yst_Ota_Flt_SegmentsType_List getSapSegmentsList() {
		return sapSegmentsList;
	}

	/**
	 * @param sapSegmentsList
	 *            the sapSegmentsList to set
	 */
	public void setSapSegmentsList(Yst_Ota_Flt_SegmentsType_List sapSegmentsList) {
		this.sapSegmentsList = sapSegmentsList;
	}

	/**
	 * @return the sapOrigDestOptionsList
	 */
	public Yst_Ota_Flt_Orig_DestType_List getSapOrigDestOptionsList() {
		return sapOrigDestOptionsList;
	}

	/**
	 * @param sapOrigDestOptionsList the sapOrigDestOptionsList to set
	 */
	public void setSapOrigDestOptionsList(
			Yst_Ota_Flt_Orig_DestType_List sapOrigDestOptionsList) {
		this.sapOrigDestOptionsList = sapOrigDestOptionsList;
	}

	/**
	 * @param charterDates the charterDates to set
	 */
	public void setCharterDates(List<CharterFlightsDates> charterDates) {
		this.charterDates = charterDates;
	}

	/**
	 * @return the charterDates
	 */
	public List<CharterFlightsDates> getCharterDates() {
		return charterDates;
	}

	/**
	 * @param nonCharterDates the nonCharterDates to set
	 */
	public void setNonCharterDates(List<java.util.Date> nonCharterDates) {
		this.nonCharterDates = nonCharterDates;
	}

	/**
	 * @return the nonCharterDates
	 */
	public List<java.util.Date> getNonCharterDates() {
		return nonCharterDates;
	}

	/**
	 * @param charterNotAvailDates the charterNotAvailDates to set
	 */
	public void setCharterNotAvailDates(List<CharterFlightsDates> charterNotAvailDates) {
		this.charterNotAvailDates = charterNotAvailDates;
	}

	/**
	 * @return the charterNotAvailDates
	 */
	public List<CharterFlightsDates> getCharterNotAvailDates() {
		return charterNotAvailDates;
	}
 /*Code commented for revocation of 3620608 on 04/05/2013*/
	/**
	 * @return the sapAddedSegmentsList
	 *//*
	public Yzst_Ota_Flt_Segments_CpyType_List getSapAddedSegmentsList() {
		return sapAddedSegmentsList;
	}

	*//**
	 * @param sapAddedSegmentsList the sapAddedSegmentsList to set
	 *//*
	public void setSapAddedSegmentsList(
			Yzst_Ota_Flt_Segments_CpyType_List sapAddedSegmentsList) {
		this.sapAddedSegmentsList = sapAddedSegmentsList;
	}*/

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
	 * @return the soldOutFlights
	 */
	public boolean isSoldOutFlights() {
		return soldOutFlights;
	}

	/**
	 * @param soldOutFlights the soldOutFlights to set
	 */
	public void setSoldOutFlights(boolean soldOutFlights) {
		this.soldOutFlights = soldOutFlights;
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
