/*
 * VehicleConvertUtils.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 24, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.kcdata.abe.bapi.Yst_Bapi_Veh_InfoType;
import com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType;
import com.kcdata.abe.bapi.Yst_Ota_Res_VehType;
import com.kcdata.abe.bapi.Yst_Ota_Veh_AvailabilityType;
import com.kcdata.abe.bapi.Yst_Ota_Veh_ItemsType;
import com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType;
import com.kcdata.abe.bapi.util.Yst_Bapi_Veh_InfoType_List;
import com.kcdata.abe.bapi.util.Yst_Bapi_Veh_TypesType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Res_VehType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Veh_AvailabilityType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Veh_ReqType_List;
import com.kcdata.abe.business.request.VehiclesRequest;
import com.kcdata.abe.data.dto.Price;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.data.dto.VehicleVendorDetails;

/**
 * Utility class for conversions between SAP and Java objects
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class VehicleConvertUtils {

	/**
	 * Method parses vehicle availability response
	 * 
	 * @param bapiOutput
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<Vehicle> parseVehicleResponse(
			Yst_Ota_Veh_AvailabilityType_List vehicleAvailabilityList,
			VehiclesRequest vehiclesRequest) {
		if (vehicleAvailabilityList == null
				|| vehicleAvailabilityList.isEmpty()) {
			return null;
		}

		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

		SimpleDateFormat sdfDateTime = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		Iterator<Yst_Ota_Veh_AvailabilityType> itVehicles = vehicleAvailabilityList
				.iterator();

		while (itVehicles.hasNext()) {
			Yst_Ota_Veh_AvailabilityType vehicleRow = itVehicles.next();
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleId(Byte.parseByte(vehicleRow.getItem_Rph()));
			vehicle.setPickupLocation(vehicleRow.getPickup_Locid());
			try {
				vehicle.setPickupTime(sdfDateTime.parse(vehicleRow
						.getPickup_Date()
						+ " " + vehicleRow.getPickup_Time()));
				vehicle.setDropOffTime(sdfDateTime.parse(vehicleRow
						.getDropoff_Date()
						+ " " + vehicleRow.getDropoff_Time()));
			} catch (Exception e) {
			}
			vehicle.setDropOffLocation(vehicleRow.getDropoff_Locid());
			vehicle.setCompanyCode(vehicleRow.getVendorcode());
			vehicle.setCompanyDescription(vehicleRow.getVendordesc());
			vehicle.setRateCategory(Byte
					.parseByte(vehicleRow.getRatecategory()));
			vehicle.setAirConditionIndicator(vehicleRow.getAirconditionind());
			// Set vehicle category
			VehicleUtils.setVehicleCategory(vehicle, Integer
					.parseInt(vehicleRow.getVehcategory()));
			// Set Vehicle Class
			VehicleUtils.setVehicleClass(vehicle, Integer.parseInt(vehicleRow
					.getVehclass()));
			vehicle.setCapacity(Byte.parseByte(vehicleRow.getVehcapacity()));
			vehicle.setDescription(vehicleRow.getVehdesc());
			if (vehicleRow.getTotal() != null) {
				Price price = new Price();
				price
						.setOccpancyBasedPrice(vehicleRow.getTotal()
								.doubleValue());
				price.setTotalTax(vehicleRow.getTaxes().doubleValue());
				price.setPerAdultBasePrice(vehicleRow.getPer_Adult_Base_Price()
						.doubleValue());
				if (vehicleRow.getPkg_Total() != null) {
					price.setPackagePrice(vehicleRow.getPkg_Total()
							.doubleValue());
				}
				price.setPromoSavings(0.0);
				// Per Person Based Price changes...

				vehicle.setPrice(price);
			}
			vehicle.setTransmission(vehicleRow.getTransmission());
			vehicle.setExtendedLocation(vehicleRow.getExtendlocation());
			vehicle.setCounterLocation(vehicleRow.getCounterlocation());
			vehicle.setRateQualifier(vehicleRow.getRatequalifier());
			vehicle.setDoorCount(vehicleRow.getDoorcount());
			vehicle.setUniqueIdType(Byte.parseByte(""
					+ vehicleRow.getUnique_Id_Type()));
			vehicle.setUniqueId(vehicleRow.getUnique_Id());
			vehicle.setCurrency(vehicleRow.getCurrency());
			vehicle.setRatePlanCategory(vehicleRow.getRate_Plan_Catg());
			vehicle.setGateway(vehicleRow.getGateway());
			vehicle.setDestination(vehicleRow.getDestination());
			vehicle.setStatus(vehicleRow.getStatus());
			
			// Generate & set unique vehicle identifier code
			vehicle.setVehicleUniqueId(VehicleUtils.generateUniqueId(vehicle));
			// Add vehicle to vehicles list
			vehicles.add(vehicle);
		}
		// Sort the vehicles
		Collections.sort(vehicles, new VehiclePriceComparator(vehiclesRequest
				.isPackageRequest()));
		return vehicles;
	}

	/**
	 * Method to prepare the vendor details list
	 * 
	 * @param vendorInfoList
	 * @param vehicleTypesList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<VehicleVendorDetails> parseVehicleVendorDetails(
			Yst_Bapi_Veh_InfoType_List vendorInfoList,
			Yst_Bapi_Veh_TypesType_List vehicleTypesList) {
		if (vendorInfoList == null) {
			return null;
		}
		HashMap<String, List<String>> vendorCarTypesMap = new HashMap<String, List<String>>();
		if (vehicleTypesList != null) {
			Iterator<Yst_Bapi_Veh_TypesType> iterator = vehicleTypesList
					.iterator();
			ArrayList<String> carTypesList = null;
			String currentVendorCode = null;
			while (iterator.hasNext()) {
				Yst_Bapi_Veh_TypesType vehicleTypeType = (Yst_Bapi_Veh_TypesType) iterator
						.next();
				if (currentVendorCode == null) {
					currentVendorCode = vehicleTypeType.getVendorcode();
					carTypesList = new ArrayList<String>();
				}
				if (!currentVendorCode.equals(vehicleTypeType.getVendorcode())) {
					vendorCarTypesMap.put(currentVendorCode, carTypesList);
					carTypesList = new ArrayList<String>();
					currentVendorCode = vehicleTypeType.getVendorcode();
				}
				carTypesList.add(vehicleTypeType.getCartype());
			}
			vendorCarTypesMap.put(currentVendorCode, carTypesList);
		}
		ArrayList<VehicleVendorDetails> vendorDetailsList = new ArrayList<VehicleVendorDetails>();
		Iterator<Yst_Bapi_Veh_InfoType> iterator = vendorInfoList.iterator();
		while (iterator.hasNext()) {
			Yst_Bapi_Veh_InfoType vendorDetails = (Yst_Bapi_Veh_InfoType) iterator
					.next();
			VehicleVendorDetails vehicleVendorDetails = new VehicleVendorDetails();
			vehicleVendorDetails.setVendorCode(vendorDetails.getVendorcode());
			vehicleVendorDetails.setVendorName(vendorDetails
					.getCarcompanyname());
			vehicleVendorDetails.setCashDepositRequird(vendorDetails
					.getCashdepositrequired());
			vehicleVendorDetails.setAgeRequired(vendorDetails.getAgerequired());
			vehicleVendorDetails.setAdditionalDrivers(vendorDetails
					.getAdditionaldrivers());
			vehicleVendorDetails.setOptions(vendorDetails.getOptions());
			vehicleVendorDetails.setPickupDropOffLocations(vendorDetails
					.getPickupdropofflocations());
			vehicleVendorDetails.setFuelMilage(vendorDetails.getFuelmileage());
			vehicleVendorDetails.setTaxes(vendorDetails.getTaxes());
			vehicleVendorDetails.setGeneralRequirements(vendorDetails
					.getGeneralrequirements());
			vehicleVendorDetails.setSeatBeltsChildRestraints(vendorDetails
					.getSeatbeltschildrestraints());
			vehicleVendorDetails.setDrivingAreas(vendorDetails
					.getDrivingareas());
			vehicleVendorDetails.setAvailableDestinations(vendorDetails
					.getAvailabledestinations());
			vehicleVendorDetails.setMarketStratagy(vendorDetails
					.getMarketstrategy());
			if (vendorCarTypesMap.get(vehicleVendorDetails.getVendorCode()) != null) {
				vehicleVendorDetails.setCarTypes(vendorCarTypesMap
						.get(vehicleVendorDetails.getVendorCode()));
			}
			vendorDetailsList.add(vehicleVendorDetails);
		}
		return vendorDetailsList;
	}

	/**
	 * Method to construct the BAPI VehiclesRequest objects from vehicle Request
	 * 
	 * @param request
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static Yst_Ota_Veh_ReqType_List constructVehicleRequestList(
			VehiclesRequest vehiclesRequest) {
		Yst_Ota_Veh_ReqType_List vehicleAvailReqList = new Yst_Ota_Veh_ReqType_List();
		Yst_Ota_Veh_ReqType vehicleAvailRequest = new Yst_Ota_Veh_ReqType();
		vehicleAvailRequest.setItem_Rph("1");
		vehicleAvailRequest.setPickup_Locid(vehiclesRequest.getVehicleOptions()
				.getPickupLocation());
		vehicleAvailRequest.setPickup_Date(new java.sql.Date(vehiclesRequest
				.getVehicleOptions().getPickupDateTime().getTime()));
		vehicleAvailRequest.setPickup_Time(new java.sql.Time(vehiclesRequest
				.getVehicleOptions().getPickupDateTime().getTime()));
		vehicleAvailRequest.setDropoff_Locid(vehiclesRequest
				.getVehicleOptions().getDropoffLocation());
		vehicleAvailRequest.setDropoff_Date(new java.sql.Date(vehiclesRequest
				.getVehicleOptions().getDropoffDateTime().getTime()));
		vehicleAvailRequest.setDropoff_Time(new java.sql.Time(vehiclesRequest
				.getVehicleOptions().getDropoffDateTime().getTime()));
		vehicleAvailRequest.setVendorcode(vehiclesRequest.getVehicleOptions()
				.getVendorCode());
		vehicleAvailRequest.setVehclass(vehiclesRequest.getVehicleOptions()
				.getVehicleClass());
		vehicleAvailRequest.setGateway(vehiclesRequest.getGateway());
		vehicleAvailRequest.setDestination(vehiclesRequest.getDestination());
		vehicleAvailReqList.add(vehicleAvailRequest);
		return vehicleAvailReqList;
	}

	/**
	 * Method to covert vehicle to SAP structure
	 * 
	 * @param vehicle
	 * @param vehicleItemRph
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static Yst_Ota_Veh_AvailabilityType prepareVehAvailabilityType(
			Vehicle vehicle, byte vehicleItemRph) {
		Yst_Ota_Veh_AvailabilityType vehAvailabilityType = new Yst_Ota_Veh_AvailabilityType();
		vehAvailabilityType.setItem_Rph("" + vehicleItemRph);
		vehAvailabilityType.setPickup_Locid(vehicle.getPickupLocation());
		vehAvailabilityType.setPickup_Date(new java.sql.Date(vehicle
				.getPickupTime().getTime()));
		vehAvailabilityType.setPickup_Time(new java.sql.Time(vehicle
				.getPickupTime().getTime()));
		vehAvailabilityType.setDropoff_Locid(vehicle.getDropOffLocation());
		vehAvailabilityType.setDropoff_Date(new java.sql.Date(vehicle
				.getDropOffTime().getTime()));
		vehAvailabilityType.setDropoff_Time(new java.sql.Time(vehicle
				.getDropOffTime().getTime()));
		vehAvailabilityType.setVendorcode(vehicle.getCompanyCode());
		vehAvailabilityType.setVendordesc(vehicle.getCompanyDescription());
		vehAvailabilityType.setRatecategory("" + vehicle.getRateCategory());
		vehAvailabilityType.setAirconditionind(vehicle
				.getAirConditionIndicator());
		vehAvailabilityType.setVehcategory(""
				+ vehicle.getVehicleCategory().getCategory());
		vehAvailabilityType.setVehclass(""
				+ vehicle.getVehicleClass().getVehicleClass());
		vehAvailabilityType.setVehcapacity("" + vehicle.getCapacity());
		vehAvailabilityType.setVehdesc(vehicle.getDescription());
		if (vehicle.getPrice() != null) {
			vehAvailabilityType.setTotal(new BigDecimal(vehicle.getPrice()
					.getOccpancyBasedPrice()));
			vehAvailabilityType.setTaxes(new BigDecimal(vehicle.getPrice()
					.getTotalTax()));
			vehAvailabilityType.setPer_Adult_Base_Price(new BigDecimal(vehicle
					.getPrice().getPerAdultBasePrice()));
		}
		vehAvailabilityType.setTransmission(vehicle.getTransmission());
		vehAvailabilityType.setExtendlocation(vehicle.getExtendedLocation());
		vehAvailabilityType.setCounterlocation(vehicle.getCounterLocation());
		vehAvailabilityType.setRatequalifier(vehicle.getRateQualifier());
		vehAvailabilityType.setDoorcount(vehicle.getDoorCount());
		vehAvailabilityType.setUnique_Id_Type(vehicle.getUniqueIdType());
		vehAvailabilityType.setUnique_Id(vehicle.getUniqueId());
		vehAvailabilityType.setCurrency(vehicle.getCurrency());
		vehAvailabilityType.setRate_Plan_Catg(vehicle.getRatePlanCategory());
		vehAvailabilityType.setGateway(vehicle.getGateway());
		vehAvailabilityType.setDestination(vehicle.getDestination());
		return vehAvailabilityType;
	}

	/**
	 * Method to covert vehicle to SAP Vehicle Items structure
	 * 
	 * @param vehicle
	 * @param vehicleItemRph
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static Yst_Ota_Veh_ItemsType prepareVehItemType(Vehicle vehicle,
			byte vehicleItemRph) {
		Yst_Ota_Veh_ItemsType vehItemTypeList = new Yst_Ota_Veh_ItemsType();
		vehItemTypeList.setItem_Rph("" + vehicleItemRph);
		vehItemTypeList.setPickup_Locid(vehicle.getPickupLocation());
		if (vehicle.getPickupTime() != null) {
			vehItemTypeList.setPickup_Date(new java.sql.Date(vehicle
					.getPickupTime().getTime()));
			vehItemTypeList.setPickup_Time(new java.sql.Time(vehicle
					.getPickupTime().getTime()));
		}
		vehItemTypeList.setDropoff_Locid(vehicle.getDropOffLocation());
		if (vehicle.getDropOffTime() != null) {
			vehItemTypeList.setDropoff_Date(new java.sql.Date(vehicle
					.getDropOffTime().getTime()));
			vehItemTypeList.setDropoff_Time(new java.sql.Time(vehicle
					.getDropOffTime().getTime()));
		}
		vehItemTypeList.setVendorcode(vehicle.getCompanyCode());
		vehItemTypeList.setVendordesc(vehicle.getCompanyDescription());
		vehItemTypeList.setRatecategory("" + vehicle.getRateCategory());
		vehItemTypeList.setAirconditionind(vehicle.getAirConditionIndicator());
		if (vehicle.getVehicleCategory() != null) {
			vehItemTypeList.setVehcategory(""
					+ vehicle.getVehicleCategory().getCategory());
		}
		if (vehicle.getVehicleClass() != null) {
			vehItemTypeList.setVehclass(""
					+ vehicle.getVehicleClass().getVehicleClass());
		}
		vehItemTypeList.setVehcapacity("" + vehicle.getCapacity());
		vehItemTypeList.setVehdesc(vehicle.getDescription());
		if (vehicle.getPrice() != null) {
			vehItemTypeList.setTotal(new BigDecimal(vehicle.getPrice()
					.getOccpancyBasedPrice()));
			vehItemTypeList.setTaxes(new BigDecimal(vehicle.getPrice()
					.getTotalTax()));
		}
		vehItemTypeList.setTransmission(vehicle.getTransmission());
		vehItemTypeList.setExtendlocation(vehicle.getExtendedLocation());
		vehItemTypeList.setCounterlocation(vehicle.getCounterLocation());
		vehItemTypeList.setRatequalifier(vehicle.getRateQualifier());
		vehItemTypeList.setDoorcount(vehicle.getDoorCount());
		vehItemTypeList.setUnique_Id_Type(vehicle.getUniqueIdType());
		vehItemTypeList.setUnique_Id(vehicle.getUniqueId());
		vehItemTypeList.setCurrency(vehicle.getCurrency());
		vehItemTypeList.setRate_Plan_Catg(vehicle.getRatePlanCategory());
		// Set the pax allocation for the Vehicle
		vehItemTypeList.setPax_Alloc_Rph(vehicle.getGuestAllocation());
		vehItemTypeList.setGateway(vehicle.getGateway());
		vehItemTypeList.setDestination(vehicle.getDestination());
		// Set POSNR numbers
		vehItemTypeList.setPosnr(vehicle.getPosnr());
		vehItemTypeList.setOld_Posnr(vehicle.getOldPosnr());
		// Set Car seat values
		vehItemTypeList.setNo_Child_Seats(vehicle.getNoOfChildSeat() + "");
		return vehItemTypeList;
	}

	/**
	 * Method parses vehicle availability response
	 * 
	 * @param bapiOutput
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<Vehicle> parseReservedVehicles(
			Yst_Ota_Res_VehType_List reservedVehiclesList) {
		if (reservedVehiclesList == null || reservedVehiclesList.isEmpty()) {
			return null;
		}

		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

		SimpleDateFormat sdfDateTime = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		Iterator<Yst_Ota_Res_VehType> itVehicles = reservedVehiclesList
				.iterator();

		while (itVehicles.hasNext()) {
			Yst_Ota_Res_VehType vehicleRow = itVehicles.next();
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleId(Byte.parseByte(vehicleRow.getItem_Rph()));
			vehicle.setPickupLocation(vehicleRow.getPickup_Locid());
			try {
				vehicle.setPickupTime(sdfDateTime.parse(vehicleRow
						.getPickup_Date()
						+ " " + vehicleRow.getPickup_Time()));
				vehicle.setDropOffTime(sdfDateTime.parse(vehicleRow
						.getDropoff_Date()
						+ " " + vehicleRow.getDropoff_Time()));
			} catch (Exception e) {
			}
			vehicle.setDropOffLocation(vehicleRow.getDropoff_Locid());
			vehicle.setGateway(vehicleRow.getGateway());
			vehicle.setDestination(vehicleRow.getDestination());
			vehicle.setCompanyCode(vehicleRow.getVendorcode());
			vehicle.setCompanyDescription(vehicleRow.getVendordesc());
			vehicle.setRateCategory(Byte
					.parseByte(vehicleRow.getRatecategory()));
			vehicle.setAirConditionIndicator(vehicleRow.getAirconditionind());
			// Set vehicle category
			VehicleUtils.setVehicleCategory(vehicle, Integer
					.parseInt(vehicleRow.getVehcategory()));
			// Set Vehicle Class
			VehicleUtils.setVehicleClass(vehicle, Integer.parseInt(vehicleRow
					.getVehclass()));
			vehicle.setCapacity(Byte.parseByte(vehicleRow.getVehcapacity()));
			vehicle.setDescription(vehicleRow.getVehdesc());
			if (vehicleRow.getTotal() != null) {
				Price price = new Price();
				price
						.setOccpancyBasedPrice(vehicleRow.getTotal()
								.doubleValue());
				price.setTotalTax(vehicleRow.getTaxes().doubleValue());
				price.setPromoSavings(0.0);
				price.setCommissionAmount(vehicleRow.getCommission()
						.doubleValue());
				price.setCommissionPercent(vehicleRow.getCommission_Prct()
						.floatValue());
				vehicle.setPrice(price);
			}
			vehicle.setTransmission(vehicleRow.getTransmission());
			vehicle.setExtendedLocation(vehicleRow.getExtendlocation());
			vehicle.setCounterLocation(vehicleRow.getCounterlocation());
			vehicle.setRateQualifier(vehicleRow.getRatequalifier());
			vehicle.setDoorCount(vehicleRow.getDoorcount());
			vehicle.setUniqueIdType(Byte.parseByte(""
					+ vehicleRow.getUnique_Id_Type()));
			vehicle.setUniqueId(vehicleRow.getUnique_Id());
			vehicle.setCurrency(vehicleRow.getCurrency());
			vehicle.setRatePlanCategory(vehicleRow.getRate_Plan_Catg());
			vehicle.setGuestAllocation(vehicleRow.getPax_Alloc_Rph());
			// POSNR number for reserved vehicles
			vehicle.setPosnr(vehicleRow.getPosnr());
			// Set Car Seat Values
			vehicle.setNoOfChildSeat(Byte.parseByte(vehicleRow.getNo_Child_Seats()));
			// Generate & set unique vehicle identifier code
			vehicle.setVehicleUniqueId(VehicleUtils.generateUniqueId(vehicle));
			// Add vehicle to vehicles list
			vehicles.add(vehicle);
		}
		return vehicles;
	}

	/**
	 * Method parses vehicle availability response
	 * 
	 * @param bapiOutput
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<Vehicle> parseQuotedVehicles(
			Yst_Ota_Veh_ItemsType_List quotedVehiclesList) {
		if (quotedVehiclesList == null || quotedVehiclesList.isEmpty()) {
			return null;
		}

		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

		SimpleDateFormat sdfDateTime = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		Iterator<Yst_Ota_Veh_ItemsType> itVehicles = quotedVehiclesList
				.iterator();

		while (itVehicles.hasNext()) {
			Yst_Ota_Veh_ItemsType vehicleRow = itVehicles.next();
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleId(Byte.parseByte(vehicleRow.getItem_Rph()));
			vehicle.setPickupLocation(vehicleRow.getPickup_Locid());
			try {
				vehicle.setPickupTime(sdfDateTime.parse(vehicleRow
						.getPickup_Date()
						+ " " + vehicleRow.getPickup_Time()));
				vehicle.setDropOffTime(sdfDateTime.parse(vehicleRow
						.getDropoff_Date()
						+ " " + vehicleRow.getDropoff_Time()));
			} catch (Exception e) {
			}
			vehicle.setDropOffLocation(vehicleRow.getDropoff_Locid());
			vehicle.setGateway(vehicleRow.getGateway());
			vehicle.setDestination(vehicleRow.getDestination());
			vehicle.setCompanyCode(vehicleRow.getVendorcode());
			vehicle.setCompanyDescription(vehicleRow.getVendordesc());
			vehicle.setRateCategory(Byte
					.parseByte(vehicleRow.getRatecategory()));
			vehicle.setAirConditionIndicator(vehicleRow.getAirconditionind());
			// Set vehicle category
			VehicleUtils.setVehicleCategory(vehicle, Integer
					.parseInt(vehicleRow.getVehcategory()));
			// Set Vehicle Class
			VehicleUtils.setVehicleClass(vehicle, Integer.parseInt(vehicleRow
					.getVehclass()));
			vehicle.setCapacity(Byte.parseByte(vehicleRow.getVehcapacity()));
			vehicle.setDescription(vehicleRow.getVehdesc());
			if (vehicleRow.getTotal() != null) {
				Price price = new Price();
				price
						.setOccpancyBasedPrice(vehicleRow.getTotal()
								.doubleValue());
				price.setTotalTax(vehicleRow.getTaxes().doubleValue());
				price.setPromoSavings(0.0);
				price.setCommissionAmount(vehicleRow.getCommission()
						.doubleValue());
				price.setCommissionPercent(vehicleRow.getCommission_Prct()
						.floatValue());
				vehicle.setPrice(price);
			}
			vehicle.setTransmission(vehicleRow.getTransmission());
			vehicle.setExtendedLocation(vehicleRow.getExtendlocation());
			vehicle.setCounterLocation(vehicleRow.getCounterlocation());
			vehicle.setRateQualifier(vehicleRow.getRatequalifier());
			vehicle.setDoorCount(vehicleRow.getDoorcount());
			vehicle.setUniqueIdType(Byte.parseByte(""
					+ vehicleRow.getUnique_Id_Type()));
			vehicle.setUniqueId(vehicleRow.getUnique_Id());
			vehicle.setCurrency(vehicleRow.getCurrency());
			vehicle.setRatePlanCategory(vehicleRow.getRate_Plan_Catg());
			vehicle.setGuestAllocation(vehicleRow.getPax_Alloc_Rph());
			// POSNR number for reserved vehicles
			vehicle.setPosnr(vehicleRow.getPosnr());
			// Generate & set unique vehicle identifier code
			vehicle.setVehicleUniqueId(VehicleUtils.generateUniqueId(vehicle));
			// Add vehicle to vehicles list
			vehicles.add(vehicle);
		}
		return vehicles;
	}

}
