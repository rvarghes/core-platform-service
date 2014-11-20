/*
 * AirlineInfo.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 09, 2009  dmahanth
 ******************************************************************************
 */
package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold airline information details
 *
 * @author dmahanth
 * @version
 *
 *
 * @see
 * @since
 */
public class AirlineInfo implements ABEDto {
	
	/**
	 * Field for serialization version ID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3007683681819710138L;

	public AirlineInfo()
	{
		marketingStrategy = null;
	}

	public String getAirlineCode()
	{
		return airlineCode;
	}

	public String getAirlineEstablished()
	{
		return airlineEstablished;
	}

	public String getAirlineName()
	{
		return airlineName;
	}

	public String getAirlineType()
	{
		return airlineType;
	}

	public String getApplePerformanceRating()
	{
		return applePerformanceRating;
	}

	public String getBicycles()
	{
		return bicycles;
	}

	public String getCarryOnBaggage()
	{
		return carryOnBaggage;
	}

	public String getCheckedBaggage()
	{
		return checkedBaggage;
	}

	public String getChildCarSeat()
	{
		return childCarSeat;
	}

	public String getExtraBaggageCost()
	{
		return extraBaggageCost;
	}

	public String getFireArmsAndWeapons()
	{
		return fireArmsAndWeapons;
	}

	public String getGoldenAppleInflightServices()
	{
		return goldenAppleInflightServices;
	}

	public String getGolfClubs()
	{
		return golfClubs;
	}

	public String getHandicapInformation()
	{
		return handicapInformation;
	}

	public String getHeadQuarters()
	{
		return headQuarters;
	}

	public String getLostBaggageNo()
	{
		return lostBaggageNo;
	}

	public String[] getMarketingStrategy()
	{
		return marketingStrategy;
	}

	public String getOxygen()
	{
		return oxygen;
	}

	public String getPets()
	{
		return pets;
	}

	public String getPhoneNo()
	{
		return phoneNo;
	}

	public String getReturnMessage()
	{
		return returnMessage;
	}

	public String getScubaEquipment()
	{
		return scubaEquipment;
	}

	public String getSeatBeltExtension()
	{
		return seatBeltExtension;
	}

	public String getSpecialMealRequest()
	{
		return specialMealRequest;
	}

	public String getSurfBoard()
	{
		return surfBoard;
	}

	public String getWeddingGown()
	{
		return weddingGown;
	}

	public String getWheelChair()
	{
		return wheelChair;
	}

	public void setAirlineCode(String s)
	{
		this.airlineCode = s;
	}

	public void setAirlineEstablished(String s)
	{
		this.airlineEstablished = s;
	}

	public void setAirlineName(String s)
	{
		this.airlineName = s;
	}

	public void setAirlineType(String s)
	{
		this.airlineType = s;
	}

	public void setApplePerformanceRating(String s)
	{
		this.applePerformanceRating = s;
	}

	public void setBicycles(String s)
	{
		this.bicycles = s;
	}

	public void setCarryOnBaggage(String s)
	{
		this.carryOnBaggage = s;
	}

	public void setCheckedBaggage(String s)
	{
		this.checkedBaggage = s;
	}

	public void setChildCarSeat(String s)
	{
		this.childCarSeat = s;
	}

	public void setExtraBaggageCost(String s)
	{
		this.extraBaggageCost = s;
	}

	public void setFireArmsAndWeapons(String s)
	{
		this.fireArmsAndWeapons = s;
	}

	public void setGoldenAppleInflightServices(String s)
	{
		this.goldenAppleInflightServices = s;
	}

	public void setGolfClubs(String s)
	{
		this.golfClubs = s;
	}

	public void setHandicapInformation(String s)
	{
		this.handicapInformation = s;
	}

	public void setHeadQuarters(String s)
	{
		this.headQuarters = s;
	}

	public void setLostBaggageNo(String s)
	{
		this.lostBaggageNo = s;
	}

	public void setMarketingStrategy(String as[])
	{
		this.marketingStrategy = as;
	}

	public void setOxygen(String s)
	{
		this.oxygen = s;
	}

	public void setPets(String s)
	{
		this.pets = s;
	}

	public void setPhoneNo(String s)
	{
		this.phoneNo = s;
	}

	public void setReturnMessage(String s)
	{
		this.returnMessage = s;
	}

	public void setScubaEquipment(String s)
	{
		this.scubaEquipment = s;
	}

	public void setSeatBeltExtension(String s)
	{
		this.seatBeltExtension = s;
	}

	public void setSpecialMealRequest(String s)
	{
		this.specialMealRequest = s;
	}

	public void setSurfBoard(String s)
	{
		this.surfBoard = s;
	}

	public void setWeddingGown(String s)
	{
		this.weddingGown = s;
	}

	public void setWheelChair(String s)
	{
		this.wheelChair = s;
	}
	
	/**
	 * Method to clone the current objext
	 *
	 * @return
	 * @throws CloneNotSupportedException
	 *
	 * @see
	 * @since
	 */
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public String returnMessage;
	private String airlineCode;
	private String airlineName;
	private String headQuarters;
	private String airlineEstablished;
	private String phoneNo;
	private String applePerformanceRating;
	private String extraBaggageCost;
	private String childCarSeat;
	private String fireArmsAndWeapons;
	private String oxygen;
	private String pets;
	private String seatBeltExtension;
	private String lostBaggageNo;
	private String wheelChair;
	private String goldenAppleInflightServices;
	private String handicapInformation;
	private String specialMealRequest;
	private String checkedBaggage;
	private String airlineType;
	private String carryOnBaggage;
	private String bicycles;
	private String golfClubs;
	private String scubaEquipment;
	private String surfBoard;
	private String weddingGown;
	private String marketingStrategy[];

}
