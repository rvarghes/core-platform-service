/*
 * VehicleClass.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 14, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

/**
 * Enumeration for vehicle class as per OTA standards
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public enum VehicleClass {

	Mini(1), Subcompact(2), Economy(3), Compact(4), Midsize(5), Intermediate(6), Standard(7), Fullsize(8), Luxury(9), 
	Premium(10), Minivan(11), TwelvePassengerVan(12), MovingVan(13), FifteenPassengerVan(14), CargoVan(15), 
	TwelveFootTruck(16), TwentyFootTruck(17), TwentyFourFootTruck(18), TwentySixFootTruck(19), Moped(20), 
	Stretch(21), Regular(22), Unique(23), Exotic(24), SmallOrMediumTruck(25), LargeTruck(26), SmallSUV(27), 
	MediumSUV(28), LargeSUV(29), ExoticSUV(30), FourWheelDrive(31), Special(32), MiniElite(33), EconomyElite(34), 
	CompactElite(35), IntermediateElite(36), StandardElite(37), FullsizeElite(38), PremiumElite(39), 
	LuxuryElite(40), Oversize(41);
	
	private int vehicleClass;
	
	private VehicleClass() {
	}
	
	private VehicleClass(int vehicleClass) {
		this.vehicleClass = vehicleClass;
	}
	
	public int getVehicleClass() {
		return this.vehicleClass;
	}
}