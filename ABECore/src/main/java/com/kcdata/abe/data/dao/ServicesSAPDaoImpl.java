/*
 * ServicesSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 30, 2009  dmahanth
 * Oct 19, 2009	 hguntupa	  Added additional fields for services and refactired code
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.kcdata.abe.bapi.TlineType;
import com.kcdata.abe.bapi.Y_Bapi_Supplement_Long_Text_Input;
import com.kcdata.abe.bapi.Y_Bapi_Supplement_Long_Text_Output;
import com.kcdata.abe.bapi.Y_Ota_Services_Availability_Input;
import com.kcdata.abe.bapi.Y_Ota_Services_Availability_Output;
import com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType;
import com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType;
import com.kcdata.abe.bapi.Yst_Ota_ServicesType;
import com.kcdata.abe.bapi.util.TlineType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List;
import com.kcdata.abe.business.response.ServiceDetailsResponse;
import com.kcdata.abe.business.response.ServicesResponse;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.MultiDestinationPackage;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.Service;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.util.FlightConvertUtils;
import com.kcdata.abe.data.util.GuestInfoConvertUtil;
import com.kcdata.abe.data.util.HotelConvertUtils;
import com.kcdata.abe.data.util.ServicesConvertUtils;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;

/**
 * Services DAO implementation class
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ServicesSAPDaoImpl extends ABESAPDaoBase implements ServicesDao {

	/**
	 * Method to get the available services
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ServicesResponse retrieveServices(Itinerary itinerary) {

		ServicesResponse servicesResponse = new ServicesResponse();
		// Create Input for BAPI
		Y_Ota_Services_Availability_Input bapiInput = new Y_Ota_Services_Availability_Input();

		byte itemRPH = 0;

		// Set IMApplication info
		bapiInput.setIm_Application_Info(this.prepareIMApplicationInfo());

		// Set the empty header
		bapiInput.setIm_Req_Hdr(new Yst_Bapi_Req_HdrType());

		// Flights Input for services
		if (itinerary.getFlights() != null) {
			itemRPH = this.prepareFlightsInput(itinerary.getFlights(),
					bapiInput, itemRPH);
		}

		// Hotels Input for services
		if (itinerary.getHotels() != null) {
			itemRPH = this.prepareHotelsInput(itinerary.getHotels(), bapiInput,
					itemRPH);
		}

		// Prepare packages Input for Services
		if (itinerary.getPackages() != null) {
			itemRPH = this.preparePackagesInput(itinerary.getPackages(),
					bapiInput, itemRPH);
		}

		// Prepare Multi-Destination packages input for Services
		if (itinerary.getMultiDestinationPackages() != null) {
			itemRPH = this.prepareMultiDestPackagesInput(itinerary
					.getMultiDestinationPackages(), bapiInput, itemRPH);
		}

		// Guest Info input for services
		if (itinerary.getGuests() != null) {
			this.prepareGuestsInput(itinerary.getGuests(), bapiInput);
		}

		// Execute the BAPI
		Y_Ota_Services_Availability_Output bapiOutput = (Y_Ota_Services_Availability_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Ota_Services_Availability", bapiInput);
		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				servicesResponse);
		// Check for any business errors from BAPI
		if (servicesResponse.isBusinessErrorOccurred()) {
			return servicesResponse;
		}

		// Prepare resort list
		Yst_Ota_ServicesType_List servicesAvailList = bapiOutput
				.get_as_listIt_Ota_Services();

		Yst_Ota_ServicesType_List seatServicesAvailList = bapiOutput
				.get_as_listIt_Ota_Seat_Services();

		if (seatServicesAvailList != null && !seatServicesAvailList.isEmpty()) {
			servicesResponse.setSeatServiceGroups(ServicesConvertUtils
					.processServicesResponse(seatServicesAvailList));
		}
		
		if (servicesAvailList != null && !servicesAvailList.isEmpty()) {
			servicesResponse.setServiceGroups(ServicesConvertUtils
					.processServicesResponse(servicesAvailList));
		} else if((servicesAvailList == null || servicesAvailList.isEmpty()) 
				&& (seatServicesAvailList == null || seatServicesAvailList.isEmpty())) {
			// Unable to retrieve resort area information
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("RETRIEVE_SERVICES_AVAILABILITY_ERROR");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("RETRIEVE_SERVICES_AVAILABILITY_ERROR", null,
							null));
			servicesResponse.saveBusinessError(businessError);
		}
		return servicesResponse;
	}

	/**
	 * Method to retrieve service details
	 * 
	 * @param service
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ServiceDetailsResponse retrieveServiceDetails(Service service) {
		ServiceDetailsResponse serviceDetailsResponse = new ServiceDetailsResponse();

		Y_Bapi_Supplement_Long_Text_Input bapiInput = new Y_Bapi_Supplement_Long_Text_Input();

		// Set the input
		this.prepareSupplementDetailsInput(service, bapiInput);

		// Execute the BAPI
		Y_Bapi_Supplement_Long_Text_Output bapiOutput = (Y_Bapi_Supplement_Long_Text_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Bapi_Supplement_Long_Text", bapiInput);
		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.getEs_Return(),
				serviceDetailsResponse);
		// Check for any business errors from BAPI
		if (serviceDetailsResponse.isBusinessErrorOccurred()) {
			return serviceDetailsResponse;
		}

		// Process the BAPI output
		serviceDetailsResponse.setService(this.parseServiceDeatailsResponse(
				service, bapiOutput));

		return serviceDetailsResponse;
	}

	/**
	 * Method to prepare input for the Service Details BAPI
	 * 
	 * @param service
	 * @param bapiInput
	 * 
	 * @see
	 * @since
	 */
	private void prepareSupplementDetailsInput(Service service,
			Y_Bapi_Supplement_Long_Text_Input bapiInput) {
		Yst_Ota_ServicesType serviceType = new Yst_Ota_ServicesType();
		serviceType.setItem_Rph("1");
		serviceType.setCode(service.getServiceCode());
		if (service.getDepatureDate() != null) {
			serviceType.setTr_From_Dt(new java.sql.Date(service
					.getDepatureDate().getTime()));
		}
		if (service.getReturnDate() != null) {
			serviceType.setTr_To_Dt(new java.sql.Date(service.getReturnDate()
					.getTime()));
		}
		bapiInput.setIm_St_Services(serviceType);
	}

	/**
	 * Method to process the response from Supplement details BAPI
	 * 
	 * @param service
	 * @param bapiOutput
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private Service parseServiceDeatailsResponse(Service service,
			Y_Bapi_Supplement_Long_Text_Output bapiOutput) {
		TlineType_List detailsTypeList = bapiOutput
				.get_as_listIt_Material_Text();
		if (detailsTypeList != null) {
			ArrayList<String> detailsList = new ArrayList<String>();
			Iterator<TlineType> detailsIterator = detailsTypeList.iterator();
			while (detailsIterator.hasNext()) {
				TlineType tline = detailsIterator.next();
				detailsList.add(tline.getTdline());
			}
			service.setServiceDescription(detailsList);
		}
		return service;
	}

	/**
	 * Method to process the Itinerary and prepare the flights structures
	 * 
	 * @param itinerary
	 * @param bapiInput
	 * 
	 * @see
	 * @since
	 */
	private byte prepareFlightsInput(List<TripFlight> flights,
			Y_Ota_Services_Availability_Input bapiInput, byte itemRPH) {
		Yst_Ota_Flt_ItemsType_List flightItemsList = bapiInput
				.get_as_listIt_Ota_Flt_Items();
		Yst_Ota_Flt_SegmentsType_List segmentsList = bapiInput
				.get_as_listIt_Ota_Flt_Segments();
		if (flightItemsList == null) {
			flightItemsList = new Yst_Ota_Flt_ItemsType_List();
			segmentsList = new Yst_Ota_Flt_SegmentsType_List();
		}
		for (TripFlight tripFlight : flights) {
			// Process the Flight Item
			++itemRPH;
			flightItemsList.add(FlightConvertUtils.prepareFlightItemTypeList(
					tripFlight, itemRPH));
			// Process the segment details
			segmentsList.addAll(FlightConvertUtils.prepareFltSegmentsTypeList(
					tripFlight, itemRPH));
		}
		bapiInput.setIt_Ota_Flt_Items(flightItemsList);
		bapiInput.setIt_Ota_Flt_Segments(segmentsList);
		return itemRPH;
	}

	/**
	 * Method to process the Itinerary and prepare the hotels structures
	 * 
	 * @param itinerary
	 * @param bapiInput
	 * 
	 * @see
	 * @since
	 */
	private byte prepareHotelsInput(List<Hotel> hotels,
			Y_Ota_Services_Availability_Input bapiInput, byte itemRPH) {
		Yst_Ota_Htl_ItemsType_List itemsTypeList = bapiInput
				.get_as_listIt_Ota_Htl_Items();
		if (itemsTypeList == null) {
			itemsTypeList = new Yst_Ota_Htl_ItemsType_List();
		}
		for (Hotel hotel : hotels) {
			Yst_Ota_Htl_ItemsType_List hotelItemsList = HotelConvertUtils
					.prepareHotelItemTypeList(hotel, itemRPH, null,false);
			if (hotelItemsList != null) {
				itemsTypeList.addAll(hotelItemsList);
				itemRPH += hotelItemsList.size();
			}
		}
		bapiInput.setIt_Ota_Htl_Items(itemsTypeList);
		return itemRPH;
	}

	/**
	 * Method to process the packages to prepare all packages structures
	 * 
	 * @param packages
	 * @param bapiInput
	 * @param itemsMap
	 * @param itemRPH
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private byte preparePackagesInput(List<Package> packages,
			Y_Ota_Services_Availability_Input bapiInput, byte itemRPH) {
		for (Package availablePackage : packages) {
			byte flightRPH = 0;
			if (availablePackage.getSelectedFlight() != null) {
				Yst_Ota_Flt_ItemsType_List flightItemsList = bapiInput
						.get_as_listIt_Ota_Flt_Items();
				Yst_Ota_Flt_SegmentsType_List segmentsList = bapiInput
						.get_as_listIt_Ota_Flt_Segments();
				if (flightItemsList == null) {
					flightItemsList = new Yst_Ota_Flt_ItemsType_List();
					segmentsList = new Yst_Ota_Flt_SegmentsType_List();
				}
				// Process the Flight Item
				flightRPH = ++itemRPH;
				flightItemsList.add(FlightConvertUtils
						.prepareFlightItemTypeList(availablePackage
								.getSelectedFlight(), itemRPH));
				// Process the segment details
				segmentsList.addAll(FlightConvertUtils
						.prepareFltSegmentsTypeList(availablePackage
								.getSelectedFlight(), itemRPH));
				bapiInput.setIt_Ota_Flt_Items(flightItemsList);
				bapiInput.setIt_Ota_Flt_Segments(segmentsList);
			}
			if (availablePackage.getSelectedHotel() != null) {
				Yst_Ota_Htl_ItemsType_List itemsTypeList = bapiInput
						.get_as_listIt_Ota_Htl_Items();
				if (itemsTypeList == null) {
					itemsTypeList = new Yst_Ota_Htl_ItemsType_List();
				}
				Yst_Ota_Htl_ItemsType_List hotelItemsList = HotelConvertUtils
						.prepareHotelItemTypeList(availablePackage
								.getSelectedHotel(), itemRPH, null,false);
				if (hotelItemsList != null) {
					if (flightRPH != 0) {
						Iterator<Yst_Ota_Htl_ItemsType> hotelIterator = hotelItemsList
								.iterator();
						while (hotelIterator.hasNext()) {
							Yst_Ota_Htl_ItemsType hotelItemType = hotelIterator
									.next();
							hotelItemType.setFlt_Item_Rph("" + flightRPH);
						}
					}
					itemsTypeList.addAll(hotelItemsList);
					itemRPH += hotelItemsList.size();
				}
				bapiInput.setIt_Ota_Htl_Items(itemsTypeList);
			}
		}
		return itemRPH;
	}

	/**
	 * Method to process the multidestination packages to prepare all packages
	 * structures
	 * 
	 * @param packages
	 * @param bapiInput
	 * @param itemsMap
	 * @param itemRPH
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private byte prepareMultiDestPackagesInput(
			List<MultiDestinationPackage> multiDestPkgs,
			Y_Ota_Services_Availability_Input bapiInput, byte itemRPH) {

		for (MultiDestinationPackage multiDestPkg : multiDestPkgs) {
			// Flights Input for pricing
			if (multiDestPkg.getSelectedFlights() != null) {
				itemRPH = this.prepareFlightsInput(multiDestPkg
						.getSelectedFlights(), bapiInput, itemRPH);
			}

			// Hotels Input for Pricing
			if (multiDestPkg.getSelectedHotels() != null) {
				itemRPH = this.prepareHotelsInput(multiDestPkg
						.getSelectedHotels(), bapiInput, itemRPH);
			}
		}
		return itemRPH;
	}

	/**
	 * Method to process the Itinerary and prepare the GuestInfo structures
	 * 
	 * @param itinerary
	 * @param bapiInput
	 * 
	 * @see
	 * @since
	 */
	private void prepareGuestsInput(List<GuestInfo> guests,
			Y_Ota_Services_Availability_Input bapiInput) {
		Yst_Ota_GuestinfoType_List guestInfoList = GuestInfoConvertUtil
				.prepareGuestInfoTypeList(guests);
		if (guestInfoList != null) {
			bapiInput.setIt_Ota_Guestinfo(guestInfoList);
		}
	}
}
