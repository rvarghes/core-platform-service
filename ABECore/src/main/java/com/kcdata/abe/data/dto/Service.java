/*
 * Service.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 30, 2009  dmahanth
 * Oct 19, 2009	 hguntupa	  Added new fields for Services
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

public class Service implements ABEDto {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -6295387900365826042L;

	private String serviceCode;
	private String serviceName;
	private List<String> serviceDescription;
	private Date depatureDate;
	private Date returnDate;
	private String gateway;
	private String destination;
	private double adultPrice;
	private double child1Price;
	private double child2Price;
	private double child3Price;
	private byte child1MinAge;
	private byte child2MinAge;
	private byte child3MinAge;
	private byte child1MaxAge;
	private byte child2MaxAge;
	private byte child3MaxAge;
	private String currency;
	private double maxQuantity;
	private String unitOfMeasure;
	private boolean mandatory;
	private boolean free;
	private boolean occupancyBased;
	private boolean dateSpecific;
	private boolean allOrNothing;
	private boolean weightBased;
	private boolean tierBased;
	private String groupCode;
	private String groupDescription;

	/**
	 * Fields used for dateSpecific supplements
	 */
	private boolean monday;
	private boolean tuesday;
	private boolean wednesday;
	private boolean thursday;
	private boolean friday;
	private boolean saturday;
	private boolean sunday;
	private List<Date> availableDates;
	private Date selectedDate;

	/**
	 * Fields for capturing the occupancy and pricing info
	 */
	private byte adultQty;
	private byte child1Qty;
	private byte child2Qty;
	private byte child3Qty;
	private double travelAgentFee;

	/**
	 * Flight and Hotel materials
	 */
	private String flightMaterialCode;
	private String hotelMaterialCode;

	/**
	 * Parent Item RPH
	 */
	private String parentItemRph;

	/**
	 * PAX allocation details
	 */
	private String guestAllocation;

	/**
	 * Total price to be displayed in Itinerary
	 */
	private double totalPrice;

	// POSNR numbers for reserved services
	private String posnr;
	private String oldPosnr;

	/**
	 * @return the serviceCode
	 */
	public String getServiceCode() {
		return serviceCode;
	}

	/**
	 * @param serviceCode
	 *            the serviceCode to set
	 */
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName
	 *            the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return the serviceDescription
	 */
	public List<String> getServiceDescription() {
		return serviceDescription;
	}

	/**
	 * @param serviceDescription
	 *            the serviceDescription to set
	 */
	public void setServiceDescription(List<String> serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	/**
	 * @return the depatureDate
	 */
	public Date getDepatureDate() {
		return depatureDate;
	}

	/**
	 * @param depatureDate
	 *            the depatureDate to set
	 */
	public void setDepatureDate(Date depatureDate) {
		this.depatureDate = depatureDate;
	}

	/**
	 * @return the returnDate
	 */
	public Date getReturnDate() {
		return returnDate;
	}

	/**
	 * @param returnDate
	 *            the returnDate to set
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

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
	 * @return the adultPrice
	 */
	public double getAdultPrice() {
		return adultPrice;
	}

	/**
	 * @param adultPrice
	 *            the adultPrice to set
	 */
	public void setAdultPrice(double adultPrice) {
		this.adultPrice = adultPrice;
	}

	/**
	 * @return the child1Price
	 */
	public double getChild1Price() {
		return child1Price;
	}

	/**
	 * @param child1Price
	 *            the child1Price to set
	 */
	public void setChild1Price(double child1Price) {
		this.child1Price = child1Price;
	}

	/**
	 * @return the child2Price
	 */
	public double getChild2Price() {
		return child2Price;
	}

	/**
	 * @param child2Price
	 *            the child2Price to set
	 */
	public void setChild2Price(double child2Price) {
		this.child2Price = child2Price;
	}

	/**
	 * @return the child3Price
	 */
	public double getChild3Price() {
		return child3Price;
	}

	/**
	 * @param child3Price
	 *            the child3Price to set
	 */
	public void setChild3Price(double child3Price) {
		this.child3Price = child3Price;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the maxQuantity
	 */
	public double getMaxQuantity() {
		return maxQuantity;
	}

	/**
	 * @param maxQuantity
	 *            the maxQuantity to set
	 */
	public void setMaxQuantity(double maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	/**
	 * @return the unitOfMeasure
	 */
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	/**
	 * @param unitOfMeasure
	 *            the unitOfMeasure to set
	 */
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	/**
	 * @return the mandatory
	 */
	public boolean isMandatory() {
		return mandatory;
	}

	/**
	 * @param mandatory
	 *            the mandatory to set
	 */
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	/**
	 * @return the free
	 */
	public boolean isFree() {
		return free;
	}

	/**
	 * @param free
	 *            the free to set
	 */
	public void setFree(boolean free) {
		this.free = free;
	}

	/**
	 * @return the occupancyBased
	 */
	public boolean isOccupancyBased() {
		return occupancyBased;
	}

	/**
	 * @param occupancyBased
	 *            the occupancyBased to set
	 */
	public void setOccupancyBased(boolean occupancyBased) {
		this.occupancyBased = occupancyBased;
	}

	/**
	 * @return the dateSpecific
	 */
	public boolean isDateSpecific() {
		return dateSpecific;
	}

	/**
	 * @param dateSpecific
	 *            the dateSpecific to set
	 */
	public void setDateSpecific(boolean dateSpecific) {
		this.dateSpecific = dateSpecific;
	}

	/**
	 * @return the allOrNothing
	 */
	public boolean isAllOrNothing() {
		return allOrNothing;
	}

	/**
	 * @param allOrNothing
	 *            the allOrNothing to set
	 */
	public void setAllOrNothing(boolean allOrNothing) {
		this.allOrNothing = allOrNothing;
	}

	/**
	 * @return the weightBased
	 */
	public boolean isWeightBased() {
		return weightBased;
	}

	/**
	 * @param weightBased
	 *            the weightBased to set
	 */
	public void setWeightBased(boolean weightBased) {
		this.weightBased = weightBased;
	}

	/**
	 * @return the tierBased
	 */
	public boolean isTierBased() {
		return tierBased;
	}

	/**
	 * @param tierBased
	 *            the tierBased to set
	 */
	public void setTierBased(boolean tierBased) {
		this.tierBased = tierBased;
	}

	/**
	 * @return the groupCode
	 */
	public String getGroupCode() {
		return groupCode;
	}

	/**
	 * @param groupCode
	 *            the groupCode to set
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	/**
	 * @return the groupDescription
	 */
	public String getGroupDescription() {
		return groupDescription;
	}

	/**
	 * @param groupDescription
	 *            the groupDescription to set
	 */
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	/**
	 * @return the monday
	 */
	public boolean isMonday() {
		return monday;
	}

	/**
	 * @param monday
	 *            the monday to set
	 */
	public void setMonday(boolean monday) {
		this.monday = monday;
	}

	/**
	 * @return the tuesday
	 */
	public boolean isTuesday() {
		return tuesday;
	}

	/**
	 * @param tuesday
	 *            the tuesday to set
	 */
	public void setTuesday(boolean tuesday) {
		this.tuesday = tuesday;
	}

	/**
	 * @return the wednesday
	 */
	public boolean isWednesday() {
		return wednesday;
	}

	/**
	 * @param wednesday
	 *            the wednesday to set
	 */
	public void setWednesday(boolean wednesday) {
		this.wednesday = wednesday;
	}

	/**
	 * @return the thursday
	 */
	public boolean isThursday() {
		return thursday;
	}

	/**
	 * @param thursday
	 *            the thursday to set
	 */
	public void setThursday(boolean thursday) {
		this.thursday = thursday;
	}

	/**
	 * @return the friday
	 */
	public boolean isFriday() {
		return friday;
	}

	/**
	 * @param friday
	 *            the friday to set
	 */
	public void setFriday(boolean friday) {
		this.friday = friday;
	}

	/**
	 * @return the saturday
	 */
	public boolean isSaturday() {
		return saturday;
	}

	/**
	 * @param saturday
	 *            the saturday to set
	 */
	public void setSaturday(boolean saturday) {
		this.saturday = saturday;
	}

	/**
	 * @return the sunday
	 */
	public boolean isSunday() {
		return sunday;
	}

	/**
	 * @param sunday
	 *            the sunday to set
	 */
	public void setSunday(boolean sunday) {
		this.sunday = sunday;
	}

	/**
	 * @return the availableDates
	 */
	public List<Date> getAvailableDates() {
		return availableDates;
	}

	/**
	 * @param availableDates
	 *            the availableDates to set
	 */
	public void setAvailableDates(List<Date> availableDates) {
		this.availableDates = availableDates;
	}

	/**
	 * @return the adultQty
	 */
	public byte getAdultQty() {
		return adultQty;
	}

	/**
	 * @param adultQty
	 *            the adultQty to set
	 */
	public void setAdultQty(byte adultQty) {
		this.adultQty = adultQty;
	}

	/**
	 * @return the child1Qty
	 */
	public byte getChild1Qty() {
		return child1Qty;
	}

	/**
	 * @param child1Qty
	 *            the child1Qty to set
	 */
	public void setChild1Qty(byte child1Qty) {
		this.child1Qty = child1Qty;
	}

	/**
	 * @return the child2Qty
	 */
	public byte getChild2Qty() {
		return child2Qty;
	}

	/**
	 * @param child2Qty
	 *            the child2Qty to set
	 */
	public void setChild2Qty(byte child2Qty) {
		this.child2Qty = child2Qty;
	}

	/**
	 * @return the child3Qty
	 */
	public byte getChild3Qty() {
		return child3Qty;
	}

	/**
	 * @param child3Qty
	 *            the child3Qty to set
	 */
	public void setChild3Qty(byte child3Qty) {
		this.child3Qty = child3Qty;
	}

	/**
	 * @return the travelAgentFee
	 */
	public double getTravelAgentFee() {
		return travelAgentFee;
	}

	/**
	 * @param travelAgentFee
	 *            the travelAgentFee to set
	 */
	public void setTravelAgentFee(double travelAgentFee) {
		this.travelAgentFee = travelAgentFee;
	}

	/**
	 * @return the selectedDate
	 */
	public Date getSelectedDate() {
		return selectedDate;
	}

	/**
	 * @param selectedDate
	 *            the selectedDate to set
	 */
	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}

	/**
	 * @return the guestAllocation
	 */
	public String getGuestAllocation() {
		return guestAllocation;
	}

	/**
	 * @param guestAllocation
	 *            the guestAllocation to set
	 */
	public void setGuestAllocation(String guestAllocation) {
		this.guestAllocation = guestAllocation;
	}

	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice
	 *            the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Method to clone the object
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Service service = (Service) super.clone();
		if (availableDates != null) {
			List<Date> availableDatesList = new ArrayList<Date>();
			for (Date availableDate : availableDates) {
				availableDatesList.add((Date) availableDate.clone());
			}
		}
		return service;
	}

	/**
	 * @return the child1MinAge
	 */
	public byte getChild1MinAge() {
		return child1MinAge;
	}

	/**
	 * @param child1MinAge
	 *            the child1MinAge to set
	 */
	public void setChild1MinAge(byte child1MinAge) {
		this.child1MinAge = child1MinAge;
	}

	/**
	 * @return the child2MinAge
	 */
	public byte getChild2MinAge() {
		return child2MinAge;
	}

	/**
	 * @param child2MinAge
	 *            the child2MinAge to set
	 */
	public void setChild2MinAge(byte child2MinAge) {
		this.child2MinAge = child2MinAge;
	}

	/**
	 * @return the child3MinAge
	 */
	public byte getChild3MinAge() {
		return child3MinAge;
	}

	/**
	 * @param child3MinAge
	 *            the child3MinAge to set
	 */
	public void setChild3MinAge(byte child3MinAge) {
		this.child3MinAge = child3MinAge;
	}

	/**
	 * @return the child1MaxAge
	 */
	public byte getChild1MaxAge() {
		return child1MaxAge;
	}

	/**
	 * @param child1MaxAge
	 *            the child1MaxAge to set
	 */
	public void setChild1MaxAge(byte child1MaxAge) {
		this.child1MaxAge = child1MaxAge;
	}

	/**
	 * @return the child2MaxAge
	 */
	public byte getChild2MaxAge() {
		return child2MaxAge;
	}

	/**
	 * @param child2MaxAge
	 *            the child2MaxAge to set
	 */
	public void setChild2MaxAge(byte child2MaxAge) {
		this.child2MaxAge = child2MaxAge;
	}

	/**
	 * @return the child3MaxAge
	 */
	public byte getChild3MaxAge() {
		return child3MaxAge;
	}

	/**
	 * @param child3MaxAge
	 *            the child3MaxAge to set
	 */
	public void setChild3MaxAge(byte child3MaxAge) {
		this.child3MaxAge = child3MaxAge;
	}

	/**
	 * @return the flightMaterialCode
	 */
	public String getFlightMaterialCode() {
		return flightMaterialCode;
	}

	/**
	 * @param flightMaterialCode
	 *            the flightMaterialCode to set
	 */
	public void setFlightMaterialCode(String flightMaterialCode) {
		this.flightMaterialCode = flightMaterialCode;
	}

	/**
	 * @return the hotelMaterialCode
	 */
	public String getHotelMaterialCode() {
		return hotelMaterialCode;
	}

	/**
	 * @param hotelMaterialCode
	 *            the hotelMaterialCode to set
	 */
	public void setHotelMaterialCode(String hotelMaterialCode) {
		this.hotelMaterialCode = hotelMaterialCode;
	}

	/**
	 * @return the parentItemRph
	 */
	public String getParentItemRph() {
		return parentItemRph;
	}

	/**
	 * @param parentItemRph
	 *            the parentItemRph to set
	 */
	public void setParentItemRph(String parentItemRph) {
		this.parentItemRph = parentItemRph;
	}

	/**
	 * @return the posnr
	 */
	public String getPosnr() {
		return posnr;
	}

	/**
	 * @param posnr
	 *            the posnr to set
	 */
	public void setPosnr(String posnr) {
		this.posnr = posnr;
	}

	/**
	 * @return the oldPosnr
	 */
	public String getOldPosnr() {
		return oldPosnr;
	}

	/**
	 * @param oldPosnr
	 *            the oldPosnr to set
	 */
	public void setOldPosnr(String oldPosnr) {
		this.oldPosnr = oldPosnr;
	}
}
