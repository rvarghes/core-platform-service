/*
 * ABERequest.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 10, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.Passenger;

/**
 * This class holds request details for all components. Base class for all the
 * component request N/A for any use case.
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ABERequest implements Serializable, Cloneable {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 8251820177079686910L;

	private String gateway;
	private String destination;
	private Date departureDate;
	private short noOfNights;
	private String promoCode;
	private boolean airRequested;
	private boolean hotelRequested;
	private boolean vehicleRequested;
	private Occupancy occupancy;
	private boolean multiDestinationRequest;
	private boolean packageRequest;
	private String bookingNo;

	/**
	 * @return the gateway
	 */
	public String getGateway() {
		return gateway;
	}

	/**
	 * @param gateway
	 *            the gateway to set
	 */
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination
	 *            the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the departureDate
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate
	 *            the departureDate to set
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @return the noOfNights
	 */
	public short getNoOfNights() {
		return noOfNights;
	}

	/**
	 * @param noOfNights
	 *            the noOfNights to set
	 */
	public void setNoOfNights(short noOfNights) {
		this.noOfNights = noOfNights;
	}

	/**
	 * @return the promoCode
	 */
	public String getPromoCode() {
		return promoCode;
	}

	/**
	 * @param promoCode
	 *            the promoCode to set
	 */
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	/**
	 * @return the airRequested
	 */
	public boolean isAirRequested() {
		return airRequested;
	}

	/**
	 * @param airRequested
	 *            the airRequested to set
	 */
	public void setAirRequested(boolean airRequested) {
		this.airRequested = airRequested;
	}

	/**
	 * @return the hotelRequested
	 */
	public boolean isHotelRequested() {
		return hotelRequested;
	}

	/**
	 * @param hotelRequested
	 *            the hotelRequested to set
	 */
	public void setHotelRequested(boolean hotelRequested) {
		this.hotelRequested = hotelRequested;
	}

	/**
	 * @return the vehicleRequested
	 */
	public boolean isVehicleRequested() {
		return vehicleRequested;
	}

	/**
	 * @param vehicleRequested
	 *            the vehicleRequested to set
	 */
	public void setVehicleRequested(boolean vehicleRequested) {
		this.vehicleRequested = vehicleRequested;
	}

	/**
	 * @return the occupancy
	 */
	public Occupancy getOccupancy() {
		return occupancy;
	}

	/**
	 * @param occupancy
	 *            the occupancy to set
	 */
	public void setOccupancy(Occupancy occupancy) {
		this.occupancy = occupancy;
	}

	/**
	 * @return the multiDestinationRequest
	 */
	public boolean isMultiDestinationRequest() {
		return multiDestinationRequest;
	}

	/**
	 * @param multiDestinationRequest
	 *            the multiDestinationRequest to set
	 */
	public void setMultiDestinationRequest(boolean multiDestinationRequest) {
		this.multiDestinationRequest = multiDestinationRequest;
	}

	/**
	 * @return the packageRequest
	 */
	public boolean isPackageRequest() {
		return packageRequest;
	}

	/**
	 * @param packageRequest
	 *            the packageRequest to set
	 */
	public void setPackageRequest(boolean packageRequest) {
		this.packageRequest = packageRequest;
	}

	/**
	 * @return the bookingNo
	 */
	public String getBookingNo() {
		return bookingNo;
	}

	/**
	 * @param bookingNo
	 *            the bookingNo to set
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	/**
	 * Method to clone the ABERequest object
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */
	public Object clone() throws CloneNotSupportedException {
		ABERequest request = (ABERequest) super.clone();
		if (occupancy != null) {
			Occupancy occupancyObj = (Occupancy) occupancy.clone();
			if (occupancy.getPassengers() != null) {
				ArrayList<Passenger> passangersList = new ArrayList<Passenger>();
				for (Passenger passenger : occupancy.getPassengers()) {
					passangersList.add((Passenger) passenger.clone());
				}
				occupancyObj.setPassengers(passangersList);
				request.setOccupancy(occupancyObj);
			}
		}
		return request;
	}
}