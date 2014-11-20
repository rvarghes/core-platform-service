/*
 * VehicleUtils.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 14, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.data.dto.VehicleCategory;
import com.kcdata.abe.data.dto.VehicleClass;

/**
 * Utility class for vehicle
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class VehicleUtils {

	/**
	 * Method generates unique identifier code for the vehicle
	 *
	 * @param vehicle
	 * @return
	 *
	 * @see
	 * @since
	 */
	public static String generateUniqueId(Vehicle vehicle) {
		if(vehicle == null)
			return null;
		StringBuffer uniqueId = new StringBuffer();
		
		uniqueId.append(vehicle.getCompanyCode());
		if(vehicle.getVehicleCategory() != null)
			uniqueId.append(vehicle.getVehicleCategory().getCategory());
		if(vehicle.getVehicleClass() != null)
			uniqueId.append(vehicle.getVehicleClass().getVehicleClass());
		uniqueId.append(vehicle.getRateQualifier());
		uniqueId.append(vehicle.getDoorCount());
		uniqueId.append(vehicle.getUniqueId());
		uniqueId.append(vehicle.getUniqueIdType());
		
		return uniqueId.toString();
	}
	
	/**
	 * Method assigns respective vehicle category 
	 *
	 * @param vehicle Vehicle object
	 * @param category Category code
	 *
	 * @see
	 * @since
	 */
	public static void setVehicleCategory(Vehicle vehicle, int category) {
		if(category == VehicleCategory.Car.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.Car);
		else if(category == VehicleCategory.AllTerrain.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.AllTerrain);
		else if(category == VehicleCategory.CommercialVanOrTruck.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.CommercialVanOrTruck);
		else if(category == VehicleCategory.Convertible.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.Convertible);
		else if(category == VehicleCategory.Coupe.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.Coupe);
		else if(category == VehicleCategory.Crossover.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.Crossover);
		else if(category == VehicleCategory.ExtendedCabPickup.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.ExtendedCabPickup);
		else if(category == VehicleCategory.Limo.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.Limo);
		else if(category == VehicleCategory.Monospace.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.Monospace);
		else if(category == VehicleCategory.Motorcycle.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.Motorcycle);
		else if(category == VehicleCategory.Motorhome.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.Motorhome);
		else if(category == VehicleCategory.Pickup.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.Pickup);
		else if(category == VehicleCategory.Recreational.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.Recreational);
		else if(category == VehicleCategory.RegularCabPickup.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.RegularCabPickup);
		else if(category == VehicleCategory.Roadster.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.Roadster);
		else if(category == VehicleCategory.Special.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.Special);
		else if(category == VehicleCategory.SpecialOffer.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.SpecialOffer);
		else if(category == VehicleCategory.Sport.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.Sport);
		else if(category == VehicleCategory.StationWagon.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.StationWagon);
		else if(category == VehicleCategory.SUV.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.SUV);
		else if(category == VehicleCategory.Truck.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.Truck);
		else if(category == VehicleCategory.TwoWheelVehicle.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.TwoWheelVehicle);
		else if(category == VehicleCategory.Van.getCategory())
			vehicle.setVehicleCategory(VehicleCategory.Van);
	}
	
	/**
	 * Method assigns respective vehicle class
	 *
	 * @param vehicle Vehicle object
	 * @param vehClass Vehicle class code
	 *
	 * @see
	 * @since
	 */
	public static void setVehicleClass(Vehicle vehicle, int vehClass) {
		if(vehClass == VehicleClass.CargoVan.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.CargoVan);
		else if(vehClass == VehicleClass.Compact.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Compact);
		else if(vehClass == VehicleClass.CompactElite.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.CompactElite);
		else if(vehClass == VehicleClass.Economy.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Economy);
		else if(vehClass == VehicleClass.EconomyElite.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.EconomyElite);
		else if(vehClass == VehicleClass.Exotic.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Exotic);
		else if(vehClass == VehicleClass.ExoticSUV.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.ExoticSUV);
		else if(vehClass == VehicleClass.FifteenPassengerVan.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.FifteenPassengerVan);
		else if(vehClass == VehicleClass.FourWheelDrive.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.FourWheelDrive);
		else if(vehClass == VehicleClass.Fullsize.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Fullsize);
		else if(vehClass == VehicleClass.FullsizeElite.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.FullsizeElite);
		else if(vehClass == VehicleClass.Intermediate.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Intermediate);
		else if(vehClass == VehicleClass.IntermediateElite.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.IntermediateElite);
		else if(vehClass == VehicleClass.LargeSUV.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.LargeSUV);
		else if(vehClass == VehicleClass.LargeTruck.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.LargeTruck);
		else if(vehClass == VehicleClass.Luxury.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Luxury);
		else if(vehClass == VehicleClass.LuxuryElite.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.LuxuryElite);
		else if(vehClass == VehicleClass.MediumSUV.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.MediumSUV);
		else if(vehClass == VehicleClass.Midsize.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Midsize);
		else if(vehClass == VehicleClass.Mini.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Mini);
		else if(vehClass == VehicleClass.MiniElite.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.MiniElite);
		else if(vehClass == VehicleClass.Minivan.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Minivan);
		else if(vehClass == VehicleClass.Moped.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Moped);
		else if(vehClass == VehicleClass.MovingVan.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.MovingVan);
		else if(vehClass == VehicleClass.Oversize.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Oversize);
		else if(vehClass == VehicleClass.Premium.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Premium);
		else if(vehClass == VehicleClass.PremiumElite.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.PremiumElite);
		else if(vehClass == VehicleClass.Regular.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Regular);
		else if(vehClass == VehicleClass.SmallOrMediumTruck.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.SmallOrMediumTruck);
		else if(vehClass == VehicleClass.SmallSUV.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.SmallSUV);
		else if(vehClass == VehicleClass.Special.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Special);
		else if(vehClass == VehicleClass.Standard.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Standard);
		else if(vehClass == VehicleClass.StandardElite.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.StandardElite);
		else if(vehClass == VehicleClass.Stretch.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Stretch);
		else if(vehClass == VehicleClass.Subcompact.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Subcompact);
		else if(vehClass == VehicleClass.TwelveFootTruck.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.TwelveFootTruck);
		else if(vehClass == VehicleClass.TwelvePassengerVan.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.TwelvePassengerVan);
		else if(vehClass == VehicleClass.TwentyFootTruck.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.TwentyFootTruck);
		else if(vehClass == VehicleClass.TwentyFourFootTruck.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.TwentyFourFootTruck);
		else if(vehClass == VehicleClass.TwentySixFootTruck.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.TwentySixFootTruck); 
		else if(vehClass == VehicleClass.Unique.getVehicleClass())
			vehicle.setVehicleClass(VehicleClass.Unique); 
	}	
}