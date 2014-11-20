/*
 * VehicleCategory.java
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
 * Enumeration for Vehicle Category as per OTA standards
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public enum VehicleCategory {

	Car(1), Van(2), SUV(3), Convertible(4), Truck(5), Motorcycle(6), Limo(7), StationWagon(8), 
	Pickup(9), Motorhome(10), AllTerrain(11), Recreational(12), Sport(13), Special(14), 
	ExtendedCabPickup(15), RegularCabPickup(16), SpecialOffer(17), Coupe(18), Monospace(19), 
	TwoWheelVehicle(20), Roadster(21), Crossover(22), CommercialVanOrTruck(23);
	
	private int category;
	
	/**
	 * Default constructor
	 */
	private VehicleCategory() {
	}
	
	/**
	 * Overloaded constructor for creating the CabinType
	 * @param type
	 */
	private VehicleCategory(int category) {
		this.category = category;
	}
	
	public int getCategory() {
		return this.category;
	}	
}