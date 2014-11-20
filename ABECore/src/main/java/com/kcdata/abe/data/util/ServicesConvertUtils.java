/*
 * ServicesConvertUtils.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 21, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.kcdata.abe.bapi.Y_Ota_Booking_Input;
import com.kcdata.abe.bapi.Y_Ota_Change_Booking_Input;
import com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType;
import com.kcdata.abe.bapi.Yst_Ota_Res_SerType;
import com.kcdata.abe.bapi.Yst_Ota_Ser_ItemsType;
import com.kcdata.abe.bapi.Yst_Ota_ServicesType;
import com.kcdata.abe.bapi.Yzseat_Info_SType;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Res_SerType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List;
import com.kcdata.abe.bapi.util.Yzseat_Info_SType_List;
import com.kcdata.abe.business.response.ServicesResponse;
import com.kcdata.abe.data.dto.Flight;
import com.kcdata.abe.data.dto.FlightSegment;
import com.kcdata.abe.data.dto.FlightSegmentUniqueCriteria;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.Material;
import com.kcdata.abe.data.dto.MultiDestinationPackage;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.RoomPrice;
import com.kcdata.abe.data.dto.SeatAllocations;
import com.kcdata.abe.data.dto.Service;
import com.kcdata.abe.data.dto.ServiceGroup;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.util.ABEConstants;
import com.rits.cloning.Cloner;

/**
 * Class to convert Services to SAP structures and vice versa.
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ServicesConvertUtils {

	static ABELogger logger = ABELogger.getLogger(ServicesConvertUtils.class);
	static Map<String, String> oldPaxAllocMap = new HashMap<String, String>();
	/**
	 * Method to parse the services response
	 * 
	 * @param servicesList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<ServiceGroup> processServicesResponse(
			Yst_Ota_ServicesType_List servicesList) {
		Iterator<Yst_Ota_ServicesType> itServices = servicesList.iterator();
		HashMap<String, ServiceGroup> serviceGroupMap = new HashMap<String, ServiceGroup>();
		while (itServices.hasNext()) {
			Yst_Ota_ServicesType servicesDetailRow = itServices.next();
			if (servicesDetailRow != null) {
				Service service = new Service();
				service.setServiceCode(servicesDetailRow.getCode());
				service.setServiceName(servicesDetailRow.getService_Name());
				service.setDepatureDate(servicesDetailRow.getTr_From_Dt());
				service.setReturnDate(servicesDetailRow.getTr_To_Dt());
				service.setGateway(servicesDetailRow.getGateway());
				service.setDestination(servicesDetailRow.getDestination());
				service.setCurrency(servicesDetailRow.getCurrency());
				if (servicesDetailRow.getMax_Quantity() != null) {
					service.setMaxQuantity(servicesDetailRow.getMax_Quantity()
							.doubleValue());
				}
				service.setUnitOfMeasure(servicesDetailRow.getUom());
				// Parse Price details
				if (servicesDetailRow.getPrice() != null) {
					service.setAdultPrice(servicesDetailRow.getPrice()
							.doubleValue());
				}
				if (servicesDetailRow.getPrice_C1() != null) {
					service.setChild1Price(servicesDetailRow.getPrice_C1()
							.doubleValue());
				}
				if (servicesDetailRow.getPrice_C2() != null) {
					service.setChild2Price(servicesDetailRow.getPrice_C2()
							.doubleValue());
				}
				if (servicesDetailRow.getPrice_C3() != null) {
					service.setChild3Price(servicesDetailRow.getPrice_C3()
							.doubleValue());
				}
				if (servicesDetailRow.getC1_Min_Age() != null
						&& !"".equals(servicesDetailRow.getC1_Min_Age())) {
					service.setChild1MinAge(Byte.parseByte(servicesDetailRow
							.getC1_Min_Age()));
				}
				if (servicesDetailRow.getC2_Min_Age() != null
						&& !"".equals(servicesDetailRow.getC2_Min_Age())) {
					service.setChild2MinAge(Byte.parseByte(servicesDetailRow
							.getC2_Min_Age()));
				}
				if (servicesDetailRow.getC3_Min_Age() != null
						&& !"".equals(servicesDetailRow.getC3_Min_Age())) {
					service.setChild3MinAge(Byte.parseByte(servicesDetailRow
							.getC3_Min_Age()));
				}
				if (servicesDetailRow.getC1_Max_Age() != null
						&& !"".equals(servicesDetailRow.getC1_Max_Age())) {
					service.setChild1MaxAge(Byte.parseByte(servicesDetailRow
							.getC1_Max_Age()));
				}
				if (servicesDetailRow.getC2_Max_Age() != null
						&& !"".equals(servicesDetailRow.getC2_Max_Age())) {
					service.setChild2MaxAge(Byte.parseByte(servicesDetailRow
							.getC2_Max_Age()));
				}
				if (servicesDetailRow.getC3_Max_Age() != null
						&& !"".equals(servicesDetailRow.getC3_Max_Age())) {
					service.setChild3MaxAge(Byte.parseByte(servicesDetailRow
							.getC3_Max_Age()));
				}

				// Set the flags for supplements
				if (service.getChild1Price() > 0
						|| service.getChild1Price() > 0
						|| service.getChild3Price() > 0) {
					// If we have child price, then mark it as a tired
					// supplement
					service.setTierBased(true);
				}
				service.setMandatory("X".equals(servicesDetailRow
						.getMandatory()) ? true : false);
				service.setFree("X".equals(servicesDetailRow.getFree()) ? true
						: false);
				service.setOccupancyBased("X".equals(servicesDetailRow
						.getOccupancy()) ? true : false);
				service.setDateSpecific("X".equals(servicesDetailRow
						.getDate_Specific()) ? true : false);
				service.setAllOrNothing("X".equals(servicesDetailRow
						.getAll_Or_Nothing()) ? true : false);
				service.setWeightBased("X".equals(servicesDetailRow
						.getWeight_Supp()) ? true : false);
				// For date specific supplements
				if (service.isDateSpecific()) {
					service
							.setMonday("X".equals(servicesDetailRow.getMon()) ? true
									: false);
					service
							.setTuesday("X".equals(servicesDetailRow.getTue()) ? true
									: false);
					service
							.setWednesday("X"
									.equals(servicesDetailRow.getWed()) ? true
									: false);
					service
							.setThursday("X".equals(servicesDetailRow.getThu()) ? true
									: false);
					service
							.setFriday("X".equals(servicesDetailRow.getFri()) ? true
									: false);
					service
							.setSaturday("X".equals(servicesDetailRow.getSat()) ? true
									: false);
					service
							.setSunday("X".equals(servicesDetailRow.getSun()) ? true
									: false);
					// Populate the dates list
					updateServiceDates(service);
				}

				// Populate the group information
				service.setGroupCode(servicesDetailRow.getService_Grp_Code());
				service.setGroupDescription(servicesDetailRow
						.getService_Grp_Desc());				
				service.setFlightMaterialCode(servicesDetailRow
						.getFlight_Material());
				service.setHotelMaterialCode(servicesDetailRow
						.getHotel_Material());

				// Check group is available
				if (serviceGroupMap.get(service.getGroupCode()) != null) {
					ServiceGroup serviceGroup = serviceGroupMap.get(service
							.getGroupCode());
					serviceGroup.addServiceToGroup(service);
				} else {
					ServiceGroup serviceGroup = new ServiceGroup();
					serviceGroup.setCode(service.getGroupCode());
					if("Shipping Methods".equalsIgnoreCase(service.getGroupDescription())) 
						serviceGroup.setDescription("Documents & Notifications");
					else
						serviceGroup.setDescription(service.getGroupDescription());	
					serviceGroup.addServiceToGroup(service);
					serviceGroupMap.put(serviceGroup.getCode(), serviceGroup);
				}
			}
		} // End of insurance options list
		Collection<ServiceGroup> serviceGroups = (Collection<ServiceGroup>) serviceGroupMap
				.values();
		ArrayList<ServiceGroup> groupsList = new ArrayList<ServiceGroup>();
		if (serviceGroups != null) {
			Iterator<ServiceGroup> groupIterator = serviceGroups.iterator();
			while (groupIterator.hasNext()) {
				ServiceGroup serviceGroup = groupIterator.next();
				groupsList.add(serviceGroup);
			}
		}
		// Sort the groups
		Collections.sort(groupsList, new ServicesGroupComparator());
		
		for(ServiceGroup serviceGrp : groupsList)
		{
			List<Service> servicesLst = serviceGrp.getServices();
			//Sort services based on destination
			Collections.sort(servicesLst,new ServicesComparator());			
		}
		return groupsList;
	}

	/**
	 * Method to update the service dates
	 * 
	 * @param service
	 * 
	 * @see
	 * @since
	 */
	private static void updateServiceDates(Service service) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar deptCal = Calendar.getInstance();
		deptCal.setTime(service.getDepatureDate());
		String returnDateStr = sdf.format(service.getReturnDate());
		List<java.util.Date> availableDatesList = new ArrayList<java.util.Date>();
		while (true) {
			int dayOfWeek = deptCal.get(Calendar.DAY_OF_WEEK);
			switch (dayOfWeek) {
			case Calendar.MONDAY:
				if (service.isMonday()) {
					availableDatesList.add(deptCal.getTime());
				}
				break;
			case Calendar.TUESDAY:
				if (service.isTuesday()) {
					availableDatesList.add(deptCal.getTime());
				}
				break;
			case Calendar.WEDNESDAY:
				if (service.isWednesday()) {
					availableDatesList.add(deptCal.getTime());
				}
				break;
			case Calendar.THURSDAY:
				if (service.isThursday()) {
					availableDatesList.add(deptCal.getTime());
				}
				break;
			case Calendar.FRIDAY:
				if (service.isFriday()) {
					availableDatesList.add(deptCal.getTime());
				}
				break;
			case Calendar.SATURDAY:
				if (service.isSaturday()) {
					availableDatesList.add(deptCal.getTime());
				}
				break;
			case Calendar.SUNDAY:
				if (service.isSunday()) {
					availableDatesList.add(deptCal.getTime());
				}
				break;
			}
			if (returnDateStr.equals(sdf.format(deptCal.getTime()))) {
				break;
			}
			deptCal.add(Calendar.DATE, 1);
		}
		if (availableDatesList.size() > 0) {
			service.setAvailableDates(availableDatesList);
		}
	}

	/**
	 * Method to prepare the SAP input structure for Service object
	 * 
	 * @param service
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static Yst_Ota_Ser_ItemsType prepareServiceItemType(Service service,
			byte itemRph) {
		Yst_Ota_Ser_ItemsType serviceType = new Yst_Ota_Ser_ItemsType();
		serviceType.setItem_Rph(ABEConstants.BLANK + itemRph);
		serviceType.setCode(service.getServiceCode());
		serviceType.setService_Name(service.getServiceName());
		if (service.getDepatureDate() != null) {
			serviceType.setTr_From_Dt(new java.sql.Date(service
					.getDepatureDate().getTime()));
		}
		if (service.getReturnDate() != null) {
			serviceType.setTr_To_Dt(new java.sql.Date(service.getReturnDate()
					.getTime()));
		}
		serviceType.setGateway(service.getGateway());
		serviceType.setDestination(service.getDestination());
		serviceType.setCode(service.getServiceCode());
		serviceType.setPrice(new BigDecimal(service.getAdultPrice()));
		serviceType.setPrice_C1(new BigDecimal(service.getChild1Price()));
		serviceType.setPrice_C2(new BigDecimal(service.getChild2Price()));
		serviceType.setPrice_C3(new BigDecimal(service.getChild3Price()));
		serviceType.setCurrency(service.getCurrency());
		serviceType.setQty_A(ABEConstants.BLANK + service.getAdultQty());
		serviceType.setQty_C1(ABEConstants.BLANK + service.getChild1Qty());
		serviceType.setQty_C2(ABEConstants.BLANK + service.getChild2Qty());
		serviceType.setQty_C3(ABEConstants.BLANK + service.getChild3Qty());
		if (service.isFree()) {
			serviceType.setFree("X");
		}
		if (service.isMandatory()) {
			serviceType.setMandatory("X");
		}
		serviceType.setPax_Alloc_Rph(service.getGuestAllocation());
		if (service.isDateSpecific() && service.getSelectedDate() != null) {
			serviceType.setDay(getDay(service.getSelectedDate()));
			serviceType.setDt_Specific(new java.sql.Date(service
					.getSelectedDate().getTime()));
		}
		serviceType.setFlight_Material(service.getFlightMaterialCode());
		serviceType.setHotel_Material(service.getHotelMaterialCode());
		serviceType.setParent_Item_Rph(service.getParentItemRph());
		// Set POSNR values
		serviceType.setPosnr(service.getPosnr());
		serviceType.setOld_Posnr(service.getOldPosnr());
		return serviceType;
	}

	/**
	 * Method to compute the day of a week
	 * 
	 * @param date
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private static String getDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.MONDAY:
			return "1";
		case Calendar.TUESDAY:
			return "2";
		case Calendar.WEDNESDAY:
			return "3";
		case Calendar.THURSDAY:
			return "4";
		case Calendar.FRIDAY:
			return "5";
		case Calendar.SATURDAY:
			return "6";
		case Calendar.SUNDAY:
			return "7";
		}
		return "";
	}

	/**
	 * Method to parse the services response
	 * 
	 * @param servicesList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<Service> processReservedServices(
			Yst_Ota_Res_SerType_List servicesList) {
		Iterator<Yst_Ota_Res_SerType> itServices = servicesList.iterator();
		ArrayList<Service> services = new ArrayList<Service>();
		while (itServices.hasNext()) {
			Yst_Ota_Res_SerType servicesDetailRow = itServices.next();
			if (servicesDetailRow != null) {
				Service service = new Service();
				service.setServiceCode(servicesDetailRow.getCode());
				service.setServiceName(servicesDetailRow.getService_Name());
				service.setDepatureDate(servicesDetailRow.getTr_From_Dt());
				service.setReturnDate(servicesDetailRow.getTr_To_Dt());
				service.setGateway(servicesDetailRow.getGateway());
				service.setDestination(servicesDetailRow.getDestination());
				service.setCurrency(servicesDetailRow.getCurrency());
				// Parse Price details
				if (servicesDetailRow.getPrice() != null) {
					service.setAdultPrice(servicesDetailRow.getPrice()
							.doubleValue());
				}
				if (servicesDetailRow.getTotal() != null) {
					service.setTotalPrice(servicesDetailRow.getTotal()
							.doubleValue());
				}
				if (servicesDetailRow.getQty_A() != null) {
					service.setAdultQty(Byte.parseByte(servicesDetailRow
							.getQty_A()));
				}
				if (servicesDetailRow.getQty_C1() != null) {
					service.setChild1Qty(Byte.parseByte(servicesDetailRow
							.getQty_C1()));
				}
				if (servicesDetailRow.getQty_C2() != null) {
					service.setChild1Qty(Byte.parseByte(servicesDetailRow
							.getQty_C2()));
				}
				if (servicesDetailRow.getQty_C3() != null) {
					service.setChild1Qty(Byte.parseByte(servicesDetailRow
							.getQty_C3()));
				}
				service.setMandatory("X".equals(servicesDetailRow
						.getMandatory()) ? true : false);
				service.setFree("X".equals(servicesDetailRow.getFree()) ? true
						: false);
				service.setDateSpecific("00".equals(servicesDetailRow.getDay()) ? false : true); 
				service.setWeightBased("X".equals(servicesDetailRow
						.getWeight_Supp()) ? true : false);
				
				
				if (servicesDetailRow.getDt_Specific() != null) {
					service.setSelectedDate(servicesDetailRow.getDt_Specific());
				}
				service
						.setGuestAllocation(servicesDetailRow
								.getPax_Alloc_Rph());
				service.setHotelMaterialCode(servicesDetailRow.getHtl_Matnr());
				service.setFlightMaterialCode(servicesDetailRow.getFlt_Matnr());
				// POSNR number for reserved services
				service.setPosnr(servicesDetailRow.getPosnr());
				services.add(service);
			}
		} // End of insurance options list
		return services;
	}

	/**
	 * Method to parse the services response
	 * 
	 * @param servicesList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<Service> processQuotedServices(
			Yst_Ota_Ser_ItemsType_List servicesList) {
		Iterator<Yst_Ota_Ser_ItemsType> itServices = servicesList.iterator();
		ArrayList<Service> services = new ArrayList<Service>();
		while (itServices.hasNext()) {
			Yst_Ota_Ser_ItemsType servicesDetailRow = itServices.next();
			if (servicesDetailRow != null) {
				Service service = new Service();
				service.setServiceCode(servicesDetailRow.getCode());
				service.setServiceName(servicesDetailRow.getService_Name());
				service.setDepatureDate(servicesDetailRow.getTr_From_Dt());
				service.setReturnDate(servicesDetailRow.getTr_To_Dt());
				service.setGateway(servicesDetailRow.getGateway());
				service.setDestination(servicesDetailRow.getDestination());
				service.setCurrency(servicesDetailRow.getCurrency());
				// Parse Price details
				if (servicesDetailRow.getPrice() != null) {
					service.setAdultPrice(servicesDetailRow.getPrice()
							.doubleValue());
				}
				if (servicesDetailRow.getTotal() != null) {
					service.setTotalPrice(servicesDetailRow.getTotal()
							.doubleValue());
				}
				if (servicesDetailRow.getQty_A() != null) {
					service.setAdultQty(Byte.parseByte(servicesDetailRow
							.getQty_A()));
				}
				if (servicesDetailRow.getQty_C1() != null) {
					service.setChild1Qty(Byte.parseByte(servicesDetailRow
							.getQty_C1()));
				}
				if (servicesDetailRow.getQty_C2() != null) {
					service.setChild1Qty(Byte.parseByte(servicesDetailRow
							.getQty_C2()));
				}
				if (servicesDetailRow.getQty_C3() != null) {
					service.setChild1Qty(Byte.parseByte(servicesDetailRow
							.getQty_C3()));
				}
				service.setMandatory("X".equals(servicesDetailRow
						.getMandatory()) ? true : false);
				service.setFree("X".equals(servicesDetailRow.getFree()) ? true
						: false);
				if (servicesDetailRow.getDt_Specific() != null) {
					service.setSelectedDate(servicesDetailRow.getDt_Specific());
				}
				service
						.setGuestAllocation(servicesDetailRow
								.getPax_Alloc_Rph());
				// POSNR number for reserved services
				service.setPosnr(servicesDetailRow.getPosnr());
				services.add(service);
			}
		} // End of insurance options list
		return services;
	}

	/**
	 * Method to process Flight Specific supplements
	 * 
	 * @param service
	 * @param itinerary
	 * @param itemsMap
	 * @param serviceItemsList
	 * @param itemRPH
	 * @param servicesMap
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static byte processFlightSpecificSupplements(Service service,
			Itinerary itinerary, HashMap<Byte, Object> itemsMap,
			Yst_Ota_Ser_ItemsType_List serviceItemsList, byte itemRPH,
			HashMap<Service, List<Byte>> servicesMap) {

		List<FlightServiceItems> flightsServiceItems = retrieveFlightsByFlightMaterial(
				itinerary, itemsMap, service.getFlightMaterialCode());

		if (flightsServiceItems == null || flightsServiceItems.size() == 0) {
			serviceItemsList.add(ServicesConvertUtils.prepareServiceItemType(
					service, ++itemRPH));
			itemsMap.put(itemRPH, service);
		} else if (flightsServiceItems.size() == 1) {
			FlightServiceItems flightServiceItem = flightsServiceItems.get(0);
			service.setParentItemRph("" + flightServiceItem.getItemRph());
			serviceItemsList.add(ServicesConvertUtils.prepareServiceItemType(
					service, ++itemRPH));
			itemsMap.put(itemRPH, service);
		} else {
			List<Byte> serviceItemList = new ArrayList<Byte>();
			String serviceAllocation = service.getGuestAllocation();
			for (FlightServiceItems flightServiceItem : flightsServiceItems) {
				String allocation = getServiceAllocation(serviceAllocation,
						flightServiceItem.getTripFlight().getGuestAllocation());
				if (allocation != null) {
					try {
						Service clonedSer = (Service) service.clone();
						clonedSer.setParentItemRph(""
								+ flightServiceItem.getItemRph());
						clonedSer.setGuestAllocation(allocation);
						serviceItemsList.add(ServicesConvertUtils
								.prepareServiceItemType(clonedSer, ++itemRPH));
						itemsMap.put(itemRPH, clonedSer);
						serviceItemList.add(itemRPH);
					} catch (CloneNotSupportedException e) {
					}
					serviceAllocation = getGuestsToBeAllocated(
							serviceAllocation, flightServiceItem
									.getTripFlight().getGuestAllocation());
				}
			}
			servicesMap.put(service, serviceItemList);
		}
		return itemRPH;
	}

	/**
	 * Method to process Hotel Specific supplements
	 * 
	 * @param service
	 * @param itinerary
	 * @param itemsMap
	 * @param serviceItemsList
	 * @param itemRPH
	 * @param servicesMap
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static byte processHotelSpecificSupplements(Service service,
			Itinerary itinerary, HashMap<Byte, Object> itemsMap,
			Yst_Ota_Ser_ItemsType_List serviceItemsList, byte itemRPH,
			HashMap<Service, List<Byte>> servicesMap) {
		List<HotelServiceItems> hotelRoomPrices = retrieveRoomPriceByHotelMaterial(
				itinerary, itemsMap, service.getHotelMaterialCode());
		if (hotelRoomPrices == null || hotelRoomPrices.size() == 0) {
			serviceItemsList.add(ServicesConvertUtils.prepareServiceItemType(
					service, ++itemRPH));
			itemsMap.put(itemRPH, service);
		} else if (hotelRoomPrices.size() == 1) {
			HotelServiceItems hotelServiceItem = hotelRoomPrices.get(0);
			service.setParentItemRph("" + hotelServiceItem.getItemRph());
			serviceItemsList.add(ServicesConvertUtils.prepareServiceItemType(
					service, ++itemRPH));
			itemsMap.put(itemRPH, service);
		} else {
			List<Byte> serviceItemList = new ArrayList<Byte>();
			String serviceAllocation = service.getGuestAllocation();
			for (HotelServiceItems hotelServiceItem : hotelRoomPrices) {
				String allocation = getServiceAllocation(serviceAllocation,
						hotelServiceItem.getRoomPrice().getGuestAllocation());
				if (allocation != null) {
					try {
						Service clonedSer = (Service) service.clone();
						clonedSer.setParentItemRph(""
								+ hotelServiceItem.getItemRph());
						clonedSer.setGuestAllocation(allocation);
						serviceItemsList.add(ServicesConvertUtils
								.prepareServiceItemType(clonedSer, ++itemRPH));
						itemsMap.put(itemRPH, clonedSer);
						serviceItemList.add(itemRPH);
					} catch (CloneNotSupportedException e) {
					}
					serviceAllocation = getGuestsToBeAllocated(
							serviceAllocation, hotelServiceItem.getRoomPrice()
									.getGuestAllocation());
				}
			}
			servicesMap.put(service, serviceItemList);
		}
		return itemRPH;
	}

	/**
	 * Method to process Destination Specific supplements
	 * 
	 * @param service
	 * @param itinerary
	 * @param itemsMap
	 * @param serviceItemsList
	 * @param itemRPH
	 * @param servicesMap
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static byte processDestinationSpecificSupplements(Service service,
			Itinerary itinerary, HashMap<Byte, Object> itemsMap,
			Yst_Ota_Ser_ItemsType_List serviceItemsList, byte itemRPH,
			HashMap<Service, List<Byte>> servicesMap) {
		List<HotelServiceItems> hotelRoomPrices = retrieveRoomPriceByDestination(
				itinerary, itemsMap, service.getDestination());
		List<Byte> serviceItemList = new ArrayList<Byte>();
		String serviceAllocation = service.getGuestAllocation();
		if (hotelRoomPrices != null && hotelRoomPrices.size() > 0) {
			for (HotelServiceItems hotelServiceItem : hotelRoomPrices) {
				String allocation = getServiceAllocation(serviceAllocation,
						hotelServiceItem.getRoomPrice().getGuestAllocation());
				if (allocation != null) {
					try {
						Service clonedSer = (Service) service.clone();
						clonedSer.setParentItemRph(""
								+ hotelServiceItem.getItemRph());
						clonedSer.setGuestAllocation(allocation);
						serviceItemsList.add(ServicesConvertUtils
								.prepareServiceItemType(clonedSer, ++itemRPH));
						itemsMap.put(itemRPH, clonedSer);
						serviceItemList.add(itemRPH);
					} catch (CloneNotSupportedException e) {
					}
					serviceAllocation = getGuestsToBeAllocated(
							serviceAllocation, hotelServiceItem.getRoomPrice()
									.getGuestAllocation());
				}
			}
		}
		HashMap<Byte, Object> tempHashMap= new HashMap<Byte, Object>();
		
		if (serviceAllocation != null) {
			// Allocate supplements to flights
			Set<Entry<Byte, Object>> entrySet = itemsMap.entrySet();
			if (entrySet != null) {
				Iterator<Entry<Byte, Object>> iterator = entrySet.iterator();
				while (iterator.hasNext()) {
					Entry<Byte, Object> entry = iterator.next();
					if (entry.getValue() instanceof TripFlight) {
						TripFlight tripFlight = (TripFlight) entry.getValue();
						if (service.getDestination()
								.equals(
										tripFlight.getOutboundFlight()
												.getDestination())) {
							String allocation = getServiceAllocation(
									serviceAllocation, tripFlight
											.getGuestAllocation());
							if (allocation != null) {
								try {
									Service clonedSer = (Service) service
											.clone();
									clonedSer.setParentItemRph(""
											+ entry.getKey());
									clonedSer.setGuestAllocation(allocation);
									serviceItemsList.add(ServicesConvertUtils
											.prepareServiceItemType(clonedSer,
													++itemRPH));
									tempHashMap.put(itemRPH, clonedSer);
									serviceItemList.add(itemRPH);
								} catch (CloneNotSupportedException e) {
								}
								serviceAllocation = getGuestsToBeAllocated(
										serviceAllocation, tripFlight
												.getGuestAllocation());
							}
						}
					}
				}
			}
			itemsMap.putAll(tempHashMap);
		}
		
		
		servicesMap.put(service, serviceItemList);
		return itemRPH;
	}

	/**
	 * Method to process Gateway Specific supplements
	 * 
	 * @param service
	 * @param itinerary
	 * @param itemsMap
	 * @param serviceItemsList
	 * @param itemRPH
	 * @param servicesMap
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static byte processGatewaySpecificSupplements(Service service,
			Itinerary itinerary, HashMap<Byte, Object> itemsMap,
			Yst_Ota_Ser_ItemsType_List serviceItemsList, byte itemRPH,
			HashMap<Service, List<Byte>> servicesMap) {
		List<HotelServiceItems> hotelRoomPrices = retrieveRoomPriceByGateway(
				itinerary, itemsMap, service.getDestination());
		List<Byte> serviceItemList = new ArrayList<Byte>();
		String serviceAllocation = service.getGuestAllocation();
		if (hotelRoomPrices != null && hotelRoomPrices.size() > 0) {
			for (HotelServiceItems hotelServiceItem : hotelRoomPrices) {
				String allocation = getServiceAllocation(serviceAllocation,
						hotelServiceItem.getRoomPrice().getGuestAllocation());
				if (allocation != null) {
					try {
						Service clonedSer = (Service) service.clone();
						clonedSer.setParentItemRph(""
								+ hotelServiceItem.getItemRph());
						clonedSer.setGuestAllocation(allocation);
						serviceItemsList.add(ServicesConvertUtils
								.prepareServiceItemType(clonedSer, ++itemRPH));
						itemsMap.put(itemRPH, clonedSer);
						serviceItemList.add(itemRPH);
					} catch (CloneNotSupportedException e) {
					}
					serviceAllocation = getGuestsToBeAllocated(
							serviceAllocation, hotelServiceItem.getRoomPrice()
									.getGuestAllocation());
				}
			}
		}
		if (serviceAllocation != null) {
			HashMap<Byte, Object> tempHashMap = new HashMap<Byte, Object>();
			// Allocate supplements to flights
			Set<Entry<Byte, Object>> entrySet = itemsMap.entrySet();
			if (entrySet != null) {
				Iterator<Entry<Byte, Object>> iterator = entrySet.iterator();
				while (iterator.hasNext()) {
					Entry<Byte, Object> entry = iterator.next();
					if (entry.getValue() instanceof TripFlight) {
						TripFlight tripFlight = (TripFlight) entry.getValue();
						if (service.getGateway().equals(
								tripFlight.getOutboundFlight().getGateway())) {
							String allocation = getServiceAllocation(
									serviceAllocation, tripFlight
											.getGuestAllocation());
							if (allocation != null) {
								try {
									Service clonedSer = (Service) service
											.clone();
									clonedSer.setParentItemRph(""
											+ entry.getKey());
									clonedSer.setGuestAllocation(allocation);
									serviceItemsList.add(ServicesConvertUtils
											.prepareServiceItemType(clonedSer,
													++itemRPH));
									//itemsMap.put(itemRPH, clonedSer);
									// Causing concurrentAccess Issues.
									tempHashMap.put(itemRPH, clonedSer);									
									serviceItemList.add(itemRPH);
								} catch (CloneNotSupportedException e) {
								}
							}
							serviceAllocation = getGuestsToBeAllocated(
									serviceAllocation, tripFlight
											.getGuestAllocation());
						}
					}
				}
			}
			itemsMap.putAll(tempHashMap);
		}
		servicesMap.put(service, serviceItemList);
		return itemRPH;
	}

	/**
	 * Method to retrieve any hotels rooms with the given material
	 * 
	 * @param itinerary
	 * @param itemsMap
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private static List<HotelServiceItems> retrieveRoomPriceByHotelMaterial(
			Itinerary itinerary, HashMap<Byte, Object> itemsMap,
			String hotelMaterial) {
		List<HotelServiceItems> hotelServiceItemsList = new ArrayList<HotelServiceItems>();
		if (itinerary.getHotels() != null) {
			for (Hotel hotel : itinerary.getHotels()) {
				List<HotelServiceItems> roomPriceHotelList = retrieveHotelsRoomPriceByHotelMaterial(
						hotel, itemsMap, hotelMaterial);
				if (roomPriceHotelList != null && roomPriceHotelList.size() > 0) {
					hotelServiceItemsList.addAll(roomPriceHotelList);
				}
			}
		}
		if (itinerary.getPackages() != null) {
			for (Package availablePackage : itinerary.getPackages()) {
				if (availablePackage.getSelectedHotel() != null) {
					List<HotelServiceItems> roomPriceHotelList = retrieveHotelsRoomPriceByHotelMaterial(
							availablePackage.getSelectedHotel(), itemsMap,
							hotelMaterial);
					if (roomPriceHotelList != null
							&& roomPriceHotelList.size() > 0) {
						hotelServiceItemsList.addAll(roomPriceHotelList);
					}
				}
			}
		}
		if (itinerary.getMultiDestinationPackages() != null) {
			for (MultiDestinationPackage availablePackage : itinerary
					.getMultiDestinationPackages()) {
				if (availablePackage.getSelectedHotels() != null) {
					for (Hotel hotel : availablePackage.getSelectedHotels()) {
						List<HotelServiceItems> roomPriceHotelList = retrieveHotelsRoomPriceByHotelMaterial(
								hotel, itemsMap, hotelMaterial);
						if (roomPriceHotelList != null
								&& roomPriceHotelList.size() > 0) {
							hotelServiceItemsList.addAll(roomPriceHotelList);
						}
					}
				}
			}
		}
		return hotelServiceItemsList;
	}

	/**
	 * Method to retrieve any hotels rooms with the given material
	 * 
	 * @param itinerary
	 * @param itemsMap
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private static List<HotelServiceItems> retrieveRoomPriceByDestination(
			Itinerary itinerary, HashMap<Byte, Object> itemsMap,
			String destination) {
		List<HotelServiceItems> hotelServiceItemsList = new ArrayList<HotelServiceItems>();
		if (itinerary.getHotels() != null) {
			for (Hotel hotel : itinerary.getHotels()) {
				List<HotelServiceItems> roomPriceHotelList = retrieveHotelsRoomPriceByDestination(
						hotel, itemsMap, destination);
				if (roomPriceHotelList != null && roomPriceHotelList.size() > 0) {
					hotelServiceItemsList.addAll(roomPriceHotelList);
				}
			}
		}
		if (itinerary.getPackages() != null) {
			for (Package availablePackage : itinerary.getPackages()) {
				if (availablePackage.getSelectedHotel() != null) {
					List<HotelServiceItems> roomPriceHotelList = retrieveHotelsRoomPriceByDestination(
							availablePackage.getSelectedHotel(), itemsMap,
							destination);
					if (roomPriceHotelList != null
							&& roomPriceHotelList.size() > 0) {
						hotelServiceItemsList.addAll(roomPriceHotelList);
					}
				}
			}
		}
		if (itinerary.getMultiDestinationPackages() != null) {
			for (MultiDestinationPackage availablePackage : itinerary
					.getMultiDestinationPackages()) {
				if (availablePackage.getSelectedHotels() != null) {
					for (Hotel hotel : availablePackage.getSelectedHotels()) {
						List<HotelServiceItems> roomPriceHotelList = retrieveHotelsRoomPriceByDestination(
								hotel, itemsMap, destination);
						if (roomPriceHotelList != null
								&& roomPriceHotelList.size() > 0) {
							hotelServiceItemsList.addAll(roomPriceHotelList);
						}
					}
				}
			}
		}
		return hotelServiceItemsList;
	}

	/**
	 * Method to retrieve any hotels rooms with the given material
	 * 
	 * @param itinerary
	 * @param itemsMap
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private static List<HotelServiceItems> retrieveRoomPriceByGateway(
			Itinerary itinerary, HashMap<Byte, Object> itemsMap,
			String destination) {
		List<HotelServiceItems> hotelServiceItemsList = new ArrayList<HotelServiceItems>();
		if (itinerary.getHotels() != null) {
			for (Hotel hotel : itinerary.getHotels()) {
				List<HotelServiceItems> roomPriceHotelList = retrieveHotelsRoomPriceByGateway(
						hotel, itemsMap, destination);
				if (roomPriceHotelList != null && roomPriceHotelList.size() > 0) {
					hotelServiceItemsList.addAll(roomPriceHotelList);
				}
			}
		}
		if (itinerary.getPackages() != null) {
			for (Package availablePackage : itinerary.getPackages()) {
				if (availablePackage.getSelectedHotel() != null) {
					List<HotelServiceItems> roomPriceHotelList = retrieveHotelsRoomPriceByGateway(
							availablePackage.getSelectedHotel(), itemsMap,
							destination);
					if (roomPriceHotelList != null
							&& roomPriceHotelList.size() > 0) {
						hotelServiceItemsList.addAll(roomPriceHotelList);
					}
				}
			}
		}
		if (itinerary.getMultiDestinationPackages() != null) {
			for (MultiDestinationPackage availablePackage : itinerary
					.getMultiDestinationPackages()) {
				if (availablePackage.getSelectedHotels() != null) {
					for (Hotel hotel : availablePackage.getSelectedHotels()) {
						List<HotelServiceItems> roomPriceHotelList = retrieveHotelsRoomPriceByGateway(
								hotel, itemsMap, destination);
						if (roomPriceHotelList != null
								&& roomPriceHotelList.size() > 0) {
							hotelServiceItemsList.addAll(roomPriceHotelList);
						}
					}
				}
			}
		}
		return hotelServiceItemsList;
	}

	/**
	 * Method to retrieve the hotel room price by material ID
	 * 
	 * @param hotel
	 * @param itemsMap
	 * @param hotelMaterial
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private static List<HotelServiceItems> retrieveHotelsRoomPriceByHotelMaterial(
			Hotel hotel, HashMap<Byte, Object> itemsMap, String hotelMaterial) {
		List<HotelServiceItems> hotelServiceItemsList = new ArrayList<HotelServiceItems>();
		if (hotel.getSelectedRooms() != null) {
			for (RoomPrice roomPrice : hotel.getSelectedRooms()) {
				RoomCategory roomCategory = hotel.getRoomCatgoryById(roomPrice
						.getRoomCategoryId());
				if (roomCategory != null
						&& hotelMaterial.equals(roomCategory.getRoomTypeCode())) {
					Set<Entry<Byte, Object>> entrySet = itemsMap.entrySet();
					if (entrySet != null) {
						Iterator<Entry<Byte, Object>> iterator = entrySet
								.iterator();
						while (iterator.hasNext()) {
							Entry<Byte, Object> entry = iterator.next();
							if (entry.getValue() == roomPrice) {
								HotelServiceItems hotelServiceItems = new HotelServiceItems();
								hotelServiceItems.setItemRph(entry.getKey()
										.byteValue());
								hotelServiceItems.setRoomPrice(roomPrice);
								hotelServiceItemsList.add(hotelServiceItems);
							}
						}
					}
				}
			}
		}
		return hotelServiceItemsList;
	}

	/**
	 * Method to retrieve the hotel room price by material ID
	 * 
	 * @param hotel
	 * @param itemsMap
	 * @param hotelMaterial
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private static List<HotelServiceItems> retrieveHotelsRoomPriceByDestination(
			Hotel hotel, HashMap<Byte, Object> itemsMap, String destination) {
		List<HotelServiceItems> hotelServiceItemsList = new ArrayList<HotelServiceItems>();
		if (hotel.getSelectedRooms() != null) {
			if (hotel.getHotelCityCode().equals(destination)) {
				for (RoomPrice roomPrice : hotel.getSelectedRooms()) {
					Set<Entry<Byte, Object>> entrySet = itemsMap.entrySet();
					if (entrySet != null) {
						Iterator<Entry<Byte, Object>> iterator = entrySet
								.iterator();
						while (iterator.hasNext()) {
							Entry<Byte, Object> entry = iterator.next();
							if (entry.getValue() == roomPrice) {
								HotelServiceItems hotelServiceItems = new HotelServiceItems();
								hotelServiceItems.setItemRph(entry.getKey()
										.byteValue());
								hotelServiceItems.setRoomPrice(roomPrice);
								hotelServiceItemsList.add(hotelServiceItems);
							}
						}
					}
				}
			}
		}
		return hotelServiceItemsList;
	}

	/**
	 * Method to retrieve the hotel room price by Gateway
	 * 
	 * @param hotel
	 * @param itemsMap
	 * @param hotelMaterial
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private static List<HotelServiceItems> retrieveHotelsRoomPriceByGateway(
			Hotel hotel, HashMap<Byte, Object> itemsMap, String gateway) {
		List<HotelServiceItems> hotelServiceItemsList = new ArrayList<HotelServiceItems>();
		if (hotel.getSelectedRooms() != null) {
			if (hotel.getOriginLocation().equals(gateway)) {
				for (RoomPrice roomPrice : hotel.getSelectedRooms()) {
					Set<Entry<Byte, Object>> entrySet = itemsMap.entrySet();
					if (entrySet != null) {
						Iterator<Entry<Byte, Object>> iterator = entrySet
								.iterator();
						while (iterator.hasNext()) {
							Entry<Byte, Object> entry = iterator.next();
							if (entry.getValue() == roomPrice) {
								HotelServiceItems hotelServiceItems = new HotelServiceItems();
								hotelServiceItems.setItemRph(entry.getKey()
										.byteValue());
								hotelServiceItems.setRoomPrice(roomPrice);
								hotelServiceItemsList.add(hotelServiceItems);
							}
						}
					}
				}
			}
		}
		return hotelServiceItemsList;
	}

	/**
	 * Method to retrieve the guest allocation of service to the room
	 * 
	 * @param serviceAllocation
	 * @param roomAllocation
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private static String getServiceAllocation(String serviceAllocation,
			String roomAllocation) {
		if (serviceAllocation == null || roomAllocation == null) {
			return null;
		}
		List<String> toReturn = new ArrayList<String>();
		String serviceAllocStr[] = StringUtils
				.commaDelimitedListToStringArray(serviceAllocation);
		String roomAllocationStr[] = StringUtils
				.commaDelimitedListToStringArray(roomAllocation);
		roomAllocationStr = StringUtils.sortStringArray(roomAllocationStr);
		for (int index = 0; index < serviceAllocStr.length; index++) {
			if (Arrays.binarySearch(roomAllocationStr, serviceAllocStr[index]) >= 0) {
				toReturn.add(serviceAllocStr[index]);
			}
		}
		if (toReturn.size() > 0) {
			return StringUtils.collectionToCommaDelimitedString(toReturn);
		}
		return null;
	}

	/**
	 * Method to retrieve the guest allocation of service to the room
	 * 
	 * @param serviceAllocation
	 * @param roomAllocation
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private static String getGuestsToBeAllocated(String serviceAllocation,
			String roomAllocation) {
		if (serviceAllocation == null || roomAllocation == null) {
			return null;
		}
		List<String> toReturn = new ArrayList<String>();
		String serviceAllocStr[] = StringUtils
				.commaDelimitedListToStringArray(serviceAllocation);
		String roomAllocationStr[] = StringUtils
				.commaDelimitedListToStringArray(roomAllocation);
		roomAllocationStr = StringUtils.sortStringArray(roomAllocationStr);
		for (int index = 0; index < serviceAllocStr.length; index++) {
			if (Arrays.binarySearch(roomAllocationStr, serviceAllocStr[index]) < 0) {
				toReturn.add(serviceAllocStr[index]);
			}
		}
		if (toReturn.size() > 0) {
			return StringUtils.collectionToCommaDelimitedString(toReturn);
		}
		return null;
	}

	/**
	 * Method to retrieve any hotels rooms with the given material
	 * 
	 * @param itinerary
	 * @param itemsMap
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private static List<FlightServiceItems> retrieveFlightsByFlightMaterial(
			Itinerary itinerary, HashMap<Byte, Object> itemsMap,
			String flightMaterial) {

		List<FlightServiceItems> flightServiceItemsList = new ArrayList<FlightServiceItems>();

		if (itinerary.getFlights() != null) {
			for (TripFlight tripFlight : itinerary.getFlights()) {
				List<FlightServiceItems> flightMaterialList = retrieveFlightsByMaterial(
						tripFlight, itemsMap, flightMaterial);
				if (flightMaterialList != null && flightMaterialList.size() > 0) {
					flightServiceItemsList.addAll(flightMaterialList);
				}
			}
		}
		if (itinerary.getPackages() != null) {
			for (Package availablePackage : itinerary.getPackages()) {
				if (availablePackage.getSelectedFlight() != null) {
					List<FlightServiceItems> flightMaterialList = retrieveFlightsByMaterial(
							availablePackage.getSelectedFlight(), itemsMap,
							flightMaterial);
					if (flightMaterialList != null
							&& flightMaterialList.size() > 0) {
						flightServiceItemsList.addAll(flightMaterialList);
					}
				}
			}
		}
		if (itinerary.getMultiDestinationPackages() != null) {
			for (MultiDestinationPackage availablePackage : itinerary
					.getMultiDestinationPackages()) {
				if (availablePackage.getSelectedFlights() != null) {
					for (TripFlight tripFlight : availablePackage
							.getSelectedFlights()) {
						List<FlightServiceItems> flightMaterialList = retrieveFlightsByMaterial(
								tripFlight, itemsMap, flightMaterial);
						if (flightMaterialList != null
								&& flightMaterialList.size() > 0) {
							flightServiceItemsList.addAll(flightMaterialList);
						}
					}
				}
			}
		}
		return flightServiceItemsList;
	}// End of retrieveFlightsByFlightMaterial

	/**
	 * Method to retrieve the flight by material ID
	 * 
	 * @param hotel
	 * @param itemsMap
	 * @param hotelMaterial
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private static List<FlightServiceItems> retrieveFlightsByMaterial(
			TripFlight tripFlight, HashMap<Byte, Object> itemsMap,
			String flightMaterial) {
		List<FlightServiceItems> flightServiceItemsList = new ArrayList<FlightServiceItems>();

		if (tripFlight.getOutboundFlight() != null) {
			if (tripFlight.getOutboundFlight().getMaterial() == null) {
				Material material = new Material();
				if (tripFlight.getFlightType().isCharter()) {
					material.setMaterialNo(tripFlight.getOutboundFlight()
							.getGateway()
							+ tripFlight.getOutboundFlight().getDestination()
							+ "C");
				} else if (tripFlight.getFlightType().isBulk()) {
					material.setMaterialNo(tripFlight.getOutboundFlight()
							.getGateway()
							+ tripFlight.getOutboundFlight().getDestination()
							+ tripFlight.getCarrier().getCarrierCode() + "S");
				} else {
					material.setMaterialNo("SKED"
							+ tripFlight.getCarrier().getCarrierCode());
				}
				tripFlight.getOutboundFlight().setMaterial(material);
			}
			if (tripFlight.getOutboundFlight().getMaterial().getMaterialNo()
					.equals(flightMaterial)) {
				Set<Entry<Byte, Object>> entrySet = itemsMap.entrySet();
				if (entrySet != null) {
					Iterator<Entry<Byte, Object>> iterator = entrySet
							.iterator();
					while (iterator.hasNext()) {
						Entry<Byte, Object> entry = iterator.next();
						if (entry.getValue() == tripFlight) {
							FlightServiceItems flightServiceItems = new FlightServiceItems();
							flightServiceItems.setItemRph(entry.getKey()
									.byteValue());
							flightServiceItems.setTripFlight(tripFlight);
							flightServiceItemsList.add(flightServiceItems);
						}
					}
				}
			}
		}// End of Flight
		return flightServiceItemsList;
	}// End of retrieveFlightsByMaterial function...
	
	/**
	 * Method to populate seat information in the info Object of BAPI
	 * @param serviceGroups of type List<ServiceGroup>
	 * @param seatAllocationList of type List<SeatAllocations>
	 * @param seatItemsList of type Yzseat_Info_SType_List
	 */
	public static void processSeatSpecificInformation(List<ServiceGroup> serviceGroups, List<SeatAllocations> seatAllocationList,
			Yzseat_Info_SType_List seatItemsList)
	{
		
		String seatServiceCode = ABEConstants.BLANK;
		Date now = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");

		for (SeatAllocations seatAllocations : seatAllocationList) {
			seatServiceCode = getSeatServiceCodeOrName(serviceGroups, seatAllocations.getSegmentID(), "SeatServiceCode");
			if(StringUtils.hasText(seatAllocations.getSeatNo()) && StringUtils.hasText(seatServiceCode))
			{
				Yzseat_Info_SType seatInfo = new Yzseat_Info_SType();
				seatInfo.setPax_Id(seatAllocations.getPaxNo()); //Pax number

				seatInfo.setYzstmat(seatServiceCode); //Material code
				if(seatAllocations.getSeatPrice() != null)
					seatInfo.setZzprice(BigDecimal.valueOf(seatAllocations.getSeatPrice())); //Price
				if(StringUtils.hasText(seatAllocations.getSeatNo()))
					seatInfo.setZztstno(seatAllocations.getSeatNo()); //Seat Number
				if(StringUtils.hasText(seatAllocations.getCabinClass()))
					seatInfo.setYzcstno(seatAllocations.getCabinClass()); //Class
				if(seatAllocations.getSeatCost() != null)
					seatInfo.setYzcost(BigDecimal.valueOf(seatAllocations.getSeatCost())); //Cost
				if(StringUtils.hasText(seatAllocations.getSeatType()))
					seatInfo.setYzstty(seatAllocations.getSeatType()); //Seat Type 
				if(StringUtils.hasText(seatAllocations.getSegmentID()))
					seatInfo.setYzltxt(seatAllocations.getSegmentID()); //Comment
	//			if(StringUtils.hasText(seatAllocations.getSeatDescription()))
	//				seatInfo.setYzltxt(seatAllocations.getSeatDescription()); //Comment
	
				if(!StringUtils.hasText(seatAllocations.getSelectedDate()))
				{
					seatInfo.setYzssdt(sdf.format(now)); // Seat selection date
					seatInfo.setYzsmdt(ABEConstants.BLANK);
				} else {
					
					seatInfo.setYzssdt(seatAllocations.getSelectedDate());
					seatInfo.setYzsmdt(sdf.format(now)); // Seat modified date
				}
				seatInfo.setParent_Item_Rph(seatAllocations.getParentItemRph());
				if(StringUtils.hasText(seatAllocations.getSeatNo())) {
					seatItemsList.add(seatInfo);
				}
			}
		}
	}
	
	/**
	 * Method to get seat service code or name from the services configured in SAP
	 * @param serviceGroups of type List<ServiceGroup>
	 * @param segId of type String
	 * @param criteria of type String
	 * @return seatinfo of type String
	 */
	private static String getSeatServiceCodeOrName(List<ServiceGroup> serviceGroups, String segId, String criteria)
	{
		String stringToSearch = ABEConstants.BLANK;
		String seatinfo = ABEConstants.BLANK;
		if(StringUtils.hasText(segId))
			stringToSearch = segId.substring(0, 5);
		if(serviceGroups != null && StringUtils.hasText(stringToSearch))
		{
			for (ServiceGroup serviceGroup : serviceGroups) {
				List<Service> servicesList = serviceGroup.getServices();
				if(servicesList != null)
				{
					for (Service service : servicesList) {
						if(service.getServiceCode().contains(stringToSearch))
						{
							if("FlightMaterialCode".equalsIgnoreCase(criteria))
								seatinfo = service.getFlightMaterialCode();
							else if("SeatServiceCode".equalsIgnoreCase(criteria))
								seatinfo = service.getServiceCode();
							else if("SeatServiceName".equalsIgnoreCase(criteria))
								seatinfo = service.getServiceName();
						}
					}
				}
			}
		}		
		return seatinfo;
	}
	
	/**
	 * This method is used to identify ratePlanCategory on the basis of roomCategoryId send.
	 * @param roomCategories
	 * @param roomCategoryId
	 * @return
	 */
	public static String getHotelRatePlanCategory(List<RoomCategory> roomCategories, int roomCategoryId ){
		String ratePlanCategory = "";
		for(RoomCategory cat: roomCategories){
			if(cat.getRoomCategoryId() == roomCategoryId){
				ratePlanCategory = cat.getRatePlanCategory();
			}
		}
		return ratePlanCategory;
	}
	
	/**
	 * Method to populate seat specific services in service type Object of BAPI
	 * @param itinerary of type Itinerary
	 * @param serviceItemsList of type Yst_Ota_Ser_ItemsType_List
	 * @param itemRPH of type byte
	 * @param servicesResponse of type ServicesResponse
	 * @param input of type Object
	 * @param isModify of type boolean
	 * @param oldItinerary of type Itinerary
	 * @return itemRPH of type byte
	 */
	public static byte processSeatSpecificServices(Itinerary itinerary, Yst_Ota_Ser_ItemsType_List serviceItemsList, byte itemRPH,
			ServicesResponse servicesResponse, Object input, boolean isModify, Itinerary oldItinerary)
	{
		
		List<SeatAllocations> seatAllocList = itinerary.getSeatAllocationList();
		if(seatAllocList != null && seatAllocList.size() > 0)
		{
			List<TripFlight> tripFlightList = SeatMapUtils.getTripFlights(itinerary);
			Flight outboundFlight;
			Flight inboundFlight;
			String parentItemRph = ABEConstants.BLANK;
			Yst_Ota_Ser_ItemsType serviceTypeOutBound = null;
			Yst_Ota_Ser_ItemsType serviceTypeInBound = null;
			boolean isOutboundSeatSelected = ABEConstants.False;
			boolean isInboundSeatSelected = ABEConstants.False;
			FlightSegmentUniqueCriteria flightSegUnique = new FlightSegmentUniqueCriteria();
			if(tripFlightList != null)
			{
				flightSegUnique.setSeatAllocationList(itinerary.getSeatAllocationList());
				oldPaxAllocMap.clear();
				for (TripFlight tripFlight : tripFlightList) {
					isOutboundSeatSelected = ABEConstants.False;
					isInboundSeatSelected = ABEConstants.False;
					flightSegUnique.setSegIdConcat(tripFlight.getLegIdConcat());
					//For Outbound Flight
					outboundFlight = tripFlight.getOutboundFlight();
					FlightSegment segment = outboundFlight.getFlightSegments().size() > 0?outboundFlight.getFlightSegments().get(0):null;
					if(segment != null)
					{
						flightSegUnique.setSegmentId(outboundFlight.getFlightIdForSeatMap());
						if(StringUtils.hasText(tripFlight.getGuestAllocation()) && isSeatSelected(outboundFlight.getFlightIdForSeatMap(), itinerary.getSeatAllocationList(), tripFlight.getGuestAllocation()))
						{
							isOutboundSeatSelected = ABEConstants.TRUE;
							flightSegUnique.setPaxAllocation(tripFlight.getGuestAllocation());
							parentItemRph = getParentRphItem(outboundFlight, tripFlight.getGuestAllocation(), segment, input, ABEConstants.OUTBOUND_FLIGHT);
							serviceTypeOutBound = getSeatServiceItemType(outboundFlight, segment, ++itemRPH, servicesResponse, input, isModify,
									oldItinerary, flightSegUnique, parentItemRph, itinerary.isBookingCancelled(), tripFlight.isHotelModified(), tripFlight.isCpPackage());
							/*****Code starts
							 * for ASA 20 Seat Selection not printing on paper docs
							 *  ******/
							if(itinerary.getPackages()!=null && itinerary.getPackages().size()>0 )
							{
								boolean isServiceItemAddedAnyways = false;
								for(Package itinPackage : itinerary.getPackages()){
									boolean flag= false; 
									if(getHotelRatePlanCategory(itinPackage.getSelectedHotel().getRoomCategories(), itinPackage.getSelectedHotel().getSelectedRooms().get(0).getRoomCategoryId()).equals("60") && 
										itinPackage.getSelectedHotel().getSelectedRooms().size()>1 && 
										itinPackage.getSelectedFlight().getFlightItemRPH() == Integer.parseInt(parentItemRph)){
											String paxAllocations = serviceTypeOutBound.getPax_Alloc_Rph();
											String [] paxAllocatedToFlight = paxAllocations.split(",");
											List<String> paxList = Arrays.asList(paxAllocatedToFlight);
											StringBuffer guestsWithSeatAllocation = null;
											
											for(RoomPrice roomPrice : itinPackage.getSelectedHotel().getSelectedRooms()){
												guestsWithSeatAllocation = new StringBuffer();
												String guestAllocations = roomPrice.getGuestAllocation();
												String [] guestAllocatedToRoom = guestAllocations.split(",");
												List<String> guestList = Arrays.asList(guestAllocatedToRoom);
												for(String pax : paxList){
													for(String guest : guestList){
														if(pax.equalsIgnoreCase(guest)){
															guestsWithSeatAllocation.append(pax +",");
														}
													}
												}
												if(guestsWithSeatAllocation != null && guestsWithSeatAllocation.length()>0){
													guestsWithSeatAllocation.deleteCharAt(guestsWithSeatAllocation.length()-1);
													Cloner cloner = new Cloner();
													Yst_Ota_Ser_ItemsType serviceTypeOutBoundCloned = cloner.deepClone(serviceTypeOutBound);
													serviceTypeOutBoundCloned.setPax_Alloc_Rph(guestsWithSeatAllocation.toString());
													serviceItemsList.add(serviceTypeOutBoundCloned);
												}
											flag = true;
										}
										if(flag){
											flag = false;
											isServiceItemAddedAnyways = true;
											break;
										}
									}
								}
								if(isServiceItemAddedAnyways == false){
									if(serviceTypeOutBound != null) {
										serviceItemsList.add(serviceTypeOutBound);
									}
								}
							}
							else{
								if(serviceTypeOutBound != null) {
									serviceItemsList.add(serviceTypeOutBound);
								}
							}
						}
					}
					
					//For Inbound Flight
					inboundFlight = tripFlight.getInboundFlight();
					if(inboundFlight != null)
					{
						segment = inboundFlight.getFlightSegments().size() > 0?inboundFlight.getFlightSegments().get(0):null;
						if(segment != null)
						{
							flightSegUnique.setSegmentId(inboundFlight.getFlightIdForSeatMap());
							if(StringUtils.hasText(tripFlight.getGuestAllocation()) && isSeatSelected(inboundFlight.getFlightIdForSeatMap(), itinerary.getSeatAllocationList(), tripFlight.getGuestAllocation()))
							{
								isInboundSeatSelected = ABEConstants.TRUE;								
								flightSegUnique.setPaxAllocation(tripFlight.getGuestAllocation());
								parentItemRph = getParentRphItem(inboundFlight, tripFlight.getGuestAllocation(), segment, input, ABEConstants.INBOUND_FLIGHT);
								serviceTypeInBound = getSeatServiceItemType(inboundFlight, segment, ++itemRPH, servicesResponse, input, isModify,
										oldItinerary, flightSegUnique, parentItemRph, itinerary.isBookingCancelled(), tripFlight.isHotelModified(), tripFlight.isCpPackage());
								/*****Code starts
								 * for ASA 20 Seat Selection not printing on paper docs
								 *  ******/
								if(itinerary.getPackages()!=null && itinerary.getPackages().size()>0 )
								{
									boolean isServiceItemAddedAnyways = false;
									for(Package itinPackage : itinerary.getPackages()){
										boolean flag= false; 
										if(getHotelRatePlanCategory(itinPackage.getSelectedHotel().getRoomCategories(), itinPackage.getSelectedHotel().getSelectedRooms().get(0).getRoomCategoryId()).equals("60")  && 
											itinPackage.getSelectedHotel().getSelectedRooms().size()>1 &&
											itinPackage.getSelectedFlight().getFlightItemRPH() == Integer.parseInt(parentItemRph)){
												String paxAllocations = serviceTypeInBound.getPax_Alloc_Rph();
												String [] paxAllocatedToFlight = paxAllocations.split(",");
												List<String> paxList = Arrays.asList(paxAllocatedToFlight);
												StringBuffer guestsWithSeatAllocation = null;
												for(RoomPrice roomPrice : itinPackage.getSelectedHotel().getSelectedRooms()){
													guestsWithSeatAllocation = new StringBuffer();
													String guestAllocations = roomPrice.getGuestAllocation();
													String [] guestAllocatedToRoom = guestAllocations.split(",");
													List<String> guestList = Arrays.asList(guestAllocatedToRoom);
													for(String pax : paxList){
														for(String guest : guestList){
															if(pax.equalsIgnoreCase(guest)){
																guestsWithSeatAllocation.append(pax +",");
															}
														}
													}
													
													if(guestsWithSeatAllocation != null && guestsWithSeatAllocation.length()>0){
														guestsWithSeatAllocation.deleteCharAt(guestsWithSeatAllocation.length()-1);
														Cloner cloner = new Cloner();
														Yst_Ota_Ser_ItemsType serviceTypeInBoundCloned = cloner.deepClone(serviceTypeInBound);
														serviceTypeInBoundCloned.setPax_Alloc_Rph(guestsWithSeatAllocation.toString());
														serviceItemsList.add(serviceTypeInBoundCloned);
													}
													flag = true;
												}
												if(flag){
													flag = false;
													isServiceItemAddedAnyways = true;
													break;
												}
												
										}
										
									}
									if(isServiceItemAddedAnyways == false){
										if(serviceTypeInBound != null) {
											serviceItemsList.add(serviceTypeInBound);
										}
									}
								}
								/*****Code ends ******/
								else{
									if(serviceTypeInBound != null) {
										serviceItemsList.add(serviceTypeInBound);
									}
								}
							}
						}
					}
					if(isOutboundSeatSelected && serviceTypeOutBound == null && serviceTypeInBound != null) {
						serviceTypeInBound.setPosnr(ABEConstants.STRING_ZERO);
						serviceTypeInBound.setOld_Posnr(ABEConstants.STRING_ZERO);
					}
					if(isInboundSeatSelected && serviceTypeInBound == null && serviceTypeOutBound != null) {
						serviceTypeOutBound.setPosnr(ABEConstants.STRING_ZERO);
						serviceTypeOutBound.setOld_Posnr(ABEConstants.STRING_ZERO);
					}
				}
			}
		}
		return itemRPH;
	}
		
	/**
	 * Method to check if seats selected for the segment
	 * @param segId of type String
	 * @param seatAllocationList of type List<SeatAllocations>
	 * @return true/false
	 */
	private static boolean isSeatSelected(String segId, List<SeatAllocations> seatAllocationList, String guestAllocation)
	{
		String[] segIdArray = segId.split("//$");
		List<String> gusetAllocArray = new ArrayList<String>();
		if(StringUtils.hasText(guestAllocation)) {
			SeatMapUtils.populateGuestAllocationList(guestAllocation, gusetAllocArray);
		}
		for (String string : segIdArray) {
			for (SeatAllocations seatAlloc : seatAllocationList) {
				if(string.equalsIgnoreCase(seatAlloc.getSegmentID())
						&& gusetAllocArray != null 
						&& gusetAllocArray.contains(ABEConstants.BLANK+Integer.parseInt(seatAlloc.getPaxNo())))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Method to get service item Object for seats selected for particular segment
	 * @param flightSegment of type FlightSegment
	 * @param itemRPH of type byte
	 * @param servicesResponse of type ServicesResponse
	 * @param input of type Object
	 * @param isModify of type boolean
	 * @param oldItinerary of type Itinerary
	 * @param flightSegUnique of type FlightSegmentUniqueCriteria
	 * @param parentItemRph of type String
	 * @return serviceType of type Yst_Ota_Ser_ItemsType
	 */
	private static Yst_Ota_Ser_ItemsType getSeatServiceItemType(Flight flight, FlightSegment flightSegment, byte itemRPH, 
			ServicesResponse servicesResponse, Object input, boolean isModify, Itinerary oldItinerary,
			FlightSegmentUniqueCriteria flightSegUnique, String parentItemRph, boolean isBookingCancelled,
			boolean isHotelModified, boolean isCpPackage)
	{
		Yst_Ota_Ser_ItemsType serviceType = new Yst_Ota_Ser_ItemsType();
		Double totalPrice = 0.0;
		String seatMaterialCode = ABEConstants.BLANK;
		String seatServiceName = ABEConstants.BLANK;
		String flightMaterialCode = ABEConstants.BLANK;
		String posnr = ABEConstants.BLANK;
		String oldPosnr = ABEConstants.STRING_ZERO;
		String actionType = ABEConstants.BLANK;
		StringBuffer  seatSelectedPaxId = new StringBuffer();
		String seatForPaxId = ABEConstants.BLANK; 
		String posnerToMatch = ABEConstants.BLANK;

		totalPrice = populatePaxIdAndTotal(flightSegUnique.getSegmentId(), flightSegUnique.getSeatAllocationList(), flightSegUnique.getPaxAllocation(), totalPrice, seatSelectedPaxId, parentItemRph);
		seatMaterialCode = getSeatServiceCodeOrName(servicesResponse.getSeatServiceGroups(), flightSegUnique.getSegmentId(), "SeatServiceCode");
		seatServiceName = getSeatServiceCodeOrName(servicesResponse.getSeatServiceGroups(), flightSegUnique.getSegmentId(), "SeatServiceName");
		flightMaterialCode = getSeatServiceCodeOrName(servicesResponse.getSeatServiceGroups(), flightSegUnique.getSegmentId(), "FlightMaterialCode");
		if(StringUtils.hasText(seatSelectedPaxId.toString()))
		{
			seatForPaxId = seatSelectedPaxId.toString().substring(0, seatSelectedPaxId.toString().length()-1);
		}
		if(isModify)
		{
			//Need to modify aegIdarray 
			if(isBookingCancelled)
			{
				actionType = ABEConstants.SEAT_CANCEL;
			} else {
				if(isCpPackage) {
					actionType = SeatMapUtils.isSeatsChanged(flightSegUnique, oldItinerary.getSeatAllocationList(), seatMaterialCode);
					if(isHotelModified && (!ABEConstants.SEAT_CANCEL.equalsIgnoreCase(actionType))) {
						actionType = ABEConstants.SEAT_ADD;
					}
				} else {
					actionType = getActionType(flightSegUnique.getSegmentId(), flightSegUnique.getSeatAllocationList(), oldItinerary, seatForPaxId);
				}
			}
			if(!ABEConstants.SEAT_ADD.equalsIgnoreCase(actionType)) {
				posnerToMatch = flight.getPosnr();
				if(!StringUtils.hasText(posnerToMatch)) {
					posnerToMatch = flight.getOldPosnr();
				}
				posnr = getPosnr(seatMaterialCode, seatForPaxId, oldItinerary, flightSegment.getDepartureDate(), posnerToMatch);
			}
			if(ABEConstants.SEAT_MODIFY.equals(actionType))
			{
				if(StringUtils.hasText(posnr))
				{
					oldPosnr = String.valueOf(Integer.parseInt(posnr));
					posnr = ABEConstants.STRING_ZERO;
				}
			} else if(ABEConstants.SEAT_CANCEL.equals(actionType))
			{
				if(StringUtils.hasText(posnr)) {
					oldPosnr = String.valueOf(Integer.parseInt(posnr));
				} else {
					posnr = ABEConstants.BLANK;
				}
			} else if(ABEConstants.SEAT_ADD.equals(actionType))
			{
				posnr = ABEConstants.STRING_ZERO;
				oldPosnr = ABEConstants.STRING_ZERO;
			}
		}
		//Set Service values in Items type
		serviceType.setItem_Rph(ABEConstants.BLANK + itemRPH);
		serviceType.setFree(ABEConstants.X);
		serviceType.setService_Name(seatServiceName);
		serviceType.setCode(seatMaterialCode);
		serviceType.setPrice(BigDecimal.valueOf(totalPrice));
		serviceType.setTotal(BigDecimal.valueOf(totalPrice));
		serviceType.setTr_From_Dt(new java.sql.Date(flightSegment.getDepartureDate().getTime()));
		serviceType.setGateway(flight.getGateway());
		serviceType.setDestination(flight.getDestination());
		serviceType.setCurrency(ABEConstants.US_CURRENCY);
		serviceType.setFlight_Material(flightMaterialCode);
		if(StringUtils.hasText(parentItemRph))
		{
			serviceType.setParent_Item_Rph(String.valueOf(Integer.parseInt(parentItemRph)));
		}
		serviceType.setQty_A(String.valueOf((seatForPaxId.split(ABEConstants.COMMA).length)));
		serviceType.setPax_Alloc_Rph(seatForPaxId);
		if(isModify)
		{
			serviceType.setPosnr(posnr);
			serviceType.setOld_Posnr(oldPosnr);
		}
		return serviceType;
	}
	
	/**
	 * Method to get action type required during modification flow
	 * @param segId of type String
	 * @param currentSeatAllocList of type List<SeatAllocations>
	 * @param oldItinerary of type Itinerary
	 * @param seatForPaxId of type String
	 * @return of type String
	 */
	private static String getActionType(String segId, List<SeatAllocations> currentSeatAllocList, Itinerary oldItinerary, String seatForPaxId) {
		List<SeatAllocations> oldSeatAllocList =  oldItinerary.getSeatAllocationList();
		String actionType = ABEConstants.SEAT_MODIFY;
		boolean isCancel = false;
		boolean isModify = false;
		boolean isAdd = false;
		boolean isNoAction = false;
		if(!StringUtils.hasText(seatForPaxId)) {
			return ABEConstants.SEAT_CANCEL;
		}
		if(StringUtils.hasText(segId) && currentSeatAllocList != null)
		{
			for (SeatAllocations seatAlloc : currentSeatAllocList) {
				/** Condition added for issue # 77  FIT charter package with 3 flights  
				and ASA 25 AVOK 4 Add insurance and seats are rejected and re-added
				***/			
				if(segId.equalsIgnoreCase(seatAlloc.getSegmentID())&& seatForPaxId.contains(seatAlloc.getPaxNo()))
				{
					if(StringUtils.hasText(seatAlloc.getSeatNo()))
					{
						if(StringUtils.hasText(seatAlloc.getOldSeatNo()))
						{
							if(seatAlloc.getSeatNo().equalsIgnoreCase(seatAlloc.getOldSeatNo()) && oldSeatAllocList != null 
									&& isNoSeatInfoModified(seatAlloc, oldSeatAllocList))
							{
								isNoAction = true;
							} else {
								isModify = true;
							}
						} else {
							isAdd = true;
						}
					} else {
						if(StringUtils.hasText(seatAlloc.getOldSeatNo())) {
							isCancel = true;
						}
					}
				}
				// Condition added for ABE 11-seats are not rejected when one persons seats are removed.
				else if(segId.equalsIgnoreCase(seatAlloc.getSegmentID())&& !seatForPaxId.contains(seatAlloc.getPaxNo())){
					if(StringUtils.hasText(seatAlloc.getOldSeatNo())) {
						isCancel = true;
				}
}
			}
		}
		
		if(isCancel && !isModify && !isAdd && !isNoAction)
		{
			actionType = ABEConstants.SEAT_CANCEL;
		}
		if(isNoAction && !isCancel && !isModify && !isAdd)
		{
			actionType = ABEConstants.SEAT_NO_ACTION;
		}
		if(isAdd && !isNoAction && !isCancel && !isModify)
		{
			actionType = ABEConstants.SEAT_ADD;
		}
		return actionType;	
	}
	
	/**
	 * Method to validate if seat information is modified or not
	 * @param seatAlloc of type SeatAllocations
	 * @param oldSeatAllocList of type List<SeatAllocations> 
	 * @return true/false of type boolean
	 */
	private static boolean isNoSeatInfoModified(SeatAllocations seatAlloc,List<SeatAllocations> oldSeatAllocList)
	{
		for (SeatAllocations seatAllocations : oldSeatAllocList) {
			if(seatAllocations.getSegmentID().equalsIgnoreCase(seatAlloc.getSegmentID())
					&& (Integer.parseInt(seatAllocations.getPaxNo()) == Integer.parseInt(seatAlloc.getPaxNo()))
					&& seatAllocations.getSeatPrice().equals(seatAlloc.getSeatPrice())
					&& seatAllocations.getSeatCost().equals(seatAlloc.getSeatCost()))
//					&& seatAllocations.getSeatType().equals(seatAlloc.getSeatType())
//					&& seatAllocations.getCabinClass().equals(seatAlloc.getCabinClass()))
					{
						return true;
					}
		}
		return false;
	}
	/**
	 * Method to get posner during modify flow
	 * @param seatMaterialCode of type String
	 * @param oldItinerary of type Itinerary
	 * @return posnr of type String
	 */
	private static String getPosnr(String seatMaterialCode, String seatForPaxId, Itinerary oldItinerary,
			Date departureDate, String flightPosnr)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String posnr = ABEConstants.BLANK;
		if(StringUtils.hasText(flightPosnr)) {
			if(oldPaxAllocMap.isEmpty()) {
				populateOldPaxAllocationMap(SeatMapUtils.getTripFlights(oldItinerary));
			}
			String oldPaxAllocString = oldPaxAllocMap.get(ABEConstants.BLANK+Integer.parseInt(flightPosnr)); 
			List<Service> servicesList = oldItinerary.getServices();
			if(servicesList != null)
			{
				for (Service service : servicesList) {
					if(seatMaterialCode.equalsIgnoreCase(service.getServiceCode())
							&& sdf.format(departureDate).equalsIgnoreCase(sdf.format(service.getDepatureDate()))
							&& isGuestAllocationMatches(oldPaxAllocString, service.getGuestAllocation()))
					{
						posnr = service.getPosnr();
						break;
					}
				}
			}
		}
		return posnr;
	}
	
	/**
	 * Method to populate posner and old guest allocation map from Old Itinerary
	 * @param oldTripFlightsList of type List<TripFlight>
	 */
	private static void populateOldPaxAllocationMap(List<TripFlight> oldTripFlightsList) {
		Flight flight = null;
		for (TripFlight tripFlight : oldTripFlightsList) {
			//Outbound Flight
			flight = tripFlight.getOutboundFlight();
			if(flight != null) {
				if(StringUtils.hasText(flight.getPosnr())) {
					oldPaxAllocMap.put(ABEConstants.BLANK+Integer.parseInt(flight.getPosnr()), tripFlight.getGuestAllocation());
				}
			}
			//Inbound Flight
			flight = tripFlight.getInboundFlight();
			if(flight != null) {
				if(StringUtils.hasText(flight.getPosnr())) {
					oldPaxAllocMap.put(ABEConstants.BLANK+Integer.parseInt(flight.getPosnr()), tripFlight.getGuestAllocation());
				}
			}
		}
	}
	
	/**
	 * Method to validate if Guest Allocation matches with service guest allocation
	 * @param oldPaxAllocString of type String
	 * @param guestAllocation of type String
	 * @return true/false of type boolean
	 */
	private static boolean isGuestAllocationMatches(String oldPaxAllocString, String serviceGuestAlloc) {
		List<String> oldPaxAllocList = new ArrayList<String>();
		List<String> serviceGuestAllocList = new ArrayList<String>();
		if(StringUtils.hasText(oldPaxAllocString)) {
			SeatMapUtils.populateGuestAllocationList(oldPaxAllocString, oldPaxAllocList);
		}
		if(StringUtils.hasText(serviceGuestAlloc)) {
			SeatMapUtils.populateGuestAllocationList(serviceGuestAlloc, serviceGuestAllocList);
		}
		for (String string : serviceGuestAllocList) {
			if(!oldPaxAllocList.contains(string)) {
				return ABEConstants.False;
			}
		}
		return ABEConstants.TRUE;
	}
	
	/**
	 * Method to get parent item rph from BAPI objects
	 * @param key if type String 
	 * @param input of type Object
	 * @return parentItemRph of type String
	 */
	private static String getParentRphItem(Flight flight, String paxIdString, FlightSegment flightSeg, Object input, String flightType)
	{
		String parentItemRph = ABEConstants.BLANK;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		boolean isGatewayDestMatch = false;
		boolean isDepDateMatch = false;
		if (input instanceof Y_Ota_Booking_Input) {
			Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
			Yst_Ota_Flt_ItemsType_List flightItemsList = bapiInput.get_as_listIt_Flt_Items();
			Iterator<Yst_Ota_Flt_ItemsType> flightItemTypeItr = flightItemsList.iterator();
			while(flightItemTypeItr.hasNext())
			{
				Yst_Ota_Flt_ItemsType flightItemType = flightItemTypeItr.next();
				isGatewayDestMatch = isGatewayDestMatch(flight, flightItemType, flightType);
				isDepDateMatch = isDepDateMatch(sdf.format(flightSeg.getDepartureDate()), flightItemType, flightType);
				if(isGatewayDestMatch
						&& paxIdString.equals(flightItemType.getPax_Alloc_Rph())
						&& isDepDateMatch)
				{
					parentItemRph = flightItemType.getItem_Rph();
					break;
				}
			}
		} else if (input instanceof Y_Ota_Change_Booking_Input) {
			Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
			Yst_Ota_Flt_ItemsType_List flightItemsList = bapiInput.get_as_listIt_Flt_Items();
			Iterator<Yst_Ota_Flt_ItemsType> flightItemTypeItr = flightItemsList.iterator();
			while(flightItemTypeItr.hasNext())
			{
				Yst_Ota_Flt_ItemsType flightItemType = flightItemTypeItr.next();
				isGatewayDestMatch = isGatewayDestMatch(flight, flightItemType, flightType);
				isDepDateMatch = isDepDateMatch(sdf.format(flightSeg.getDepartureDate()), flightItemType, flightType);
				if(isGatewayDestMatch
						&& paxIdString.equals(flightItemType.getPax_Alloc_Rph())
						&& isDepDateMatch)
				{
					parentItemRph = flightItemType.getItem_Rph();
					break;
				}
			}
		}

		return parentItemRph;
	}
	
	private static boolean isGatewayDestMatch(Flight flight, Yst_Ota_Flt_ItemsType flightItemType, String flightType)
	{
		boolean isMatchFound = false;
		if(ABEConstants.OUTBOUND_FLIGHT.equals(flightType) && StringUtils.hasText(flightItemType.getOut_Gateway()) && StringUtils.hasText(flightItemType.getOut_Dest()))
			isMatchFound = (flight.getGateway().equalsIgnoreCase(flightItemType.getOut_Gateway()) && flight.getDestination().equalsIgnoreCase(flightItemType.getOut_Dest()));
		if(ABEConstants.INBOUND_FLIGHT.equals(flightType) && StringUtils.hasText(flightItemType.getIn_Gateway()) && StringUtils.hasText(flightItemType.getIn_Dest()))
			isMatchFound = (flight.getGateway().equalsIgnoreCase(flightItemType.getIn_Gateway()) && flight.getDestination().equalsIgnoreCase(flightItemType.getIn_Dest()));
		return isMatchFound;
	}
	
	private static boolean isDepDateMatch(String depDate, Yst_Ota_Flt_ItemsType flightItemType, String flightType)
	{
		boolean isMatchFound = false;
		if(ABEConstants.INBOUND_FLIGHT.equals(flightType) && flightItemType.getIn_Dep_Date() != null && StringUtils.hasText(flightItemType.getIn_Dep_Date().toString()))
			isMatchFound = depDate.equals(flightItemType.getIn_Dep_Date().toString());
		if(ABEConstants.OUTBOUND_FLIGHT.equals(flightType) && flightItemType.getOut_Dep_Date() != null && StringUtils.hasText(flightItemType.getOut_Dep_Date().toString()))
			isMatchFound = depDate.equals(flightItemType.getOut_Dep_Date().toString());
		return isMatchFound;
	}
	
	/**
	 * Method to populate paxId and total of seats selected
	 * @param key of type String
	 * @param seatAllocationList of type List<SeatAllocations>
	 * @param paxIdString of type String
	 * @param totalPrice of type Double
	 * @return totalPrice of type Double
	 */
	private static Double populatePaxIdAndTotal(String key, List<SeatAllocations> seatAllocationList, String paxIdString, Double totalPrice, StringBuffer seatSelectedPaxId, String parentItemRph)
	{
		List<String> seatAllocList = new ArrayList<String>();
		SeatMapUtils.populateGuestAllocationList(paxIdString, seatAllocList);
		for (SeatAllocations seatAllocations : seatAllocationList) {
			if(StringUtils.hasText(seatAllocations.getPaxNo())) {
				seatAllocations.setPaxNo(String.valueOf(Integer.parseInt(seatAllocations.getPaxNo())));
			}
			if(key.equalsIgnoreCase(seatAllocations.getSegmentID())
					&& seatAllocList.contains(seatAllocations.getPaxNo())
					&& StringUtils.hasText(seatAllocations.getSeatNo()))
			{
				seatAllocations.setParentItemRph(parentItemRph);
				totalPrice = totalPrice + seatAllocations.getSeatPrice();
				seatSelectedPaxId = seatSelectedPaxId.append(seatAllocations.getPaxNo())
					.append(ABEConstants.COMMA);
			}
		}
		return totalPrice;
	}
	
	/**
	 * Inner class to hold the Flight Services mapping info
	 * 
	 * @author agudise
	 * @version
	 * 
	 * 
	 * @see
	 * @since
	 */
	private static class FlightServiceItems {
		private byte itemRph;
		private TripFlight tripFlight;

		/**
		 * @return the itemRph
		 */
		public byte getItemRph() {
			return itemRph;
		}

		/**
		 * @param itemRph
		 *            the itemRph to set
		 */
		public void setItemRph(byte itemRph) {
			this.itemRph = itemRph;
		}

		/**
		 * @return the tripFlight
		 */
		public TripFlight getTripFlight() {
			return tripFlight;
		}

		/**
		 * @param tripFlight
		 *            the tripFlight to set
		 */
		public void setTripFlight(TripFlight tripFlight) {
			this.tripFlight = tripFlight;
		}
	}// End of FlightServiceItems inner class...

	/**
	 * Inner class to hold the Hotel Services mapping info
	 * 
	 * @author hguntupa
	 * @version
	 * 
	 * 
	 * @see
	 * @since
	 */
	private static class HotelServiceItems {
		private byte itemRph;
		private RoomPrice roomPrice;

		/**
		 * @return the itemRph
		 */
		public byte getItemRph() {
			return itemRph;
		}

		/**
		 * @param itemRph
		 *            the itemRph to set
		 */
		public void setItemRph(byte itemRph) {
			this.itemRph = itemRph;
		}

		/**
		 * @return the roomPrice
		 */
		public RoomPrice getRoomPrice() {
			return roomPrice;
		}

		/**
		 * @param roomPrice
		 *            the roomPrice to set
		 */
		public void setRoomPrice(RoomPrice roomPrice) {
			this.roomPrice = roomPrice;
		}
	}
}
