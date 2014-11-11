/*
 * ItineraryPricingSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 18, 2009  hguntupa
 * Sep 24, 2009	 hguntupa	  Changes for IMApplicationInfo
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.kcdata.abe.business.response.FlightInfoResponse;
import com.kcdata.abe.business.response.ItineraryPricingResponse;
import com.kcdata.abe.business.service.WesbProxyService;
import com.kcdata.abe.data.dto.Flight;
import com.kcdata.abe.data.dto.FlightInfoCriteria;
import com.kcdata.abe.data.dto.FlightSegment;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.Material;
import com.kcdata.abe.data.dto.MultiDestinationPackage;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.PaxTypePriceBreakup;
import com.kcdata.abe.data.dto.Price;
import com.kcdata.abe.data.dto.RoomPrice;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.data.util.PaxTypePriceByRoomComparator;
import com.kcdata.abe.data.util.PaxTypePriceByTypeComparator;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.logging.ABELogger;

import com.kcdataservices.partners.kcdebsrvlib_hotel.interfaces.hotelservicebs.v1.RetrieveHotelPricingRetrieveHotelPricingFaultMsg;

/**
 * Itinerary Pricing DAO implementation class
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */

public class ItineraryPricingWESBDaoImpl extends ABESAPDaoBase implements
		WesbItineraryPricingDao {

	/**
	 * Instance of Logger
	 */
	final ABELogger logger = ABELogger
			.getLogger(com.kcdata.abe.data.dao.ItineraryPricingWESBDaoImpl.class);

	private FlightInfoDao flightInfoDao;

	private WesbProxyService proxyService;

	/**
	 * @return the proxyService
	 */
	public WesbProxyService getProxyService() {
		return proxyService;
	}

	/**
	 * @param proxyService
	 *            the proxyService to set
	 */
	public void setProxyService(WesbProxyService proxyService) {
		this.proxyService = proxyService;
	}

	/**
	 * @return the flightInfoDao
	 */
	public FlightInfoDao getFlightInfoDao() {
		return flightInfoDao;
	}

	/**
	 * @param flightInfoDao
	 *            the flightInfoDao to set
	 */
	public void setFlightInfoDao(FlightInfoDao flightInfoDao) {
		this.flightInfoDao = flightInfoDao;
	}

	public ItineraryPricingResponse packagePriceItinerary(Itinerary itinerary) {
		return null;

	}

	private ItineraryPricingResponse retrieveHotelPricing(Itinerary itinerary,
			boolean isHBSi, Map<String, HBSiHotelInfo> hbsiHotelList) {
		ItineraryPricingResponse pricingResponse = new ItineraryPricingResponse();

		com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelspriceitineraryrequest.v1.HotelsPriceItineraryRequest hotelsPriceItineraryRequest = this
				.getHotelsPriceItineraryRequestReq(itinerary);

		/*
		 * if (isHBSi == true) hotelsPriceItineraryRequest.setIsHBSi(true);
		 */
		// Map<String,HBSiHotelInfo> hbsiHotelList
		if (hbsiHotelList != null
				&& hotelsPriceItineraryRequest != null
				&& hotelsPriceItineraryRequest.getItinerary().getHotels() != null
				&& hotelsPriceItineraryRequest.getItinerary().getHotels()
						.size() > 0) {
			for (int j = 0; j < hotelsPriceItineraryRequest.getItinerary()
					.getHotels().size(); j++) {
				if (hbsiHotelList.containsKey(hotelsPriceItineraryRequest
						.getItinerary().getHotels().get(j).getHotelCode())) {
					hotelsPriceItineraryRequest.getItinerary().getHotels()
							.get(j).setIsHBSi(true);
					hotelsPriceItineraryRequest.setIsHBSi(true);
				} else {
					hotelsPriceItineraryRequest.getItinerary().getHotels()
							.get(j).setIsHBSi(false);
				}
			}
		}

		if (hbsiHotelList != null
				&& hotelsPriceItineraryRequest != null
				&& hotelsPriceItineraryRequest.getItinerary().getDeletedList() != null
				&& hotelsPriceItineraryRequest.getItinerary().getDeletedList()
						.size() > 0)

		{
			for (int k = 0; k < hotelsPriceItineraryRequest.getItinerary()
					.getDeletedList().size(); k++) {
				if (hotelsPriceItineraryRequest.getItinerary().getDeletedList()
						.get(k) != null) {
					if (hotelsPriceItineraryRequest.getItinerary()
							.getDeletedList().get(k).getHotelList() != null
							&& hotelsPriceItineraryRequest.getItinerary()
									.getDeletedList().get(k).getHotelList()
									.size() > 0) {
						for (int h = 0; h < hotelsPriceItineraryRequest
								.getItinerary().getDeletedList().get(k)
								.getHotelList().size(); h++) {
							if (hbsiHotelList
									.containsKey(hotelsPriceItineraryRequest
											.getItinerary().getDeletedList()
											.get(k).getHotelList().get(h)
											.getHotelCode())) {
								hotelsPriceItineraryRequest.getItinerary()
										.getDeletedList().get(k).getHotelList()
										.get(h).setIsHBSi(true);
								hotelsPriceItineraryRequest.setIsHBSi(true);
							} else {
								hotelsPriceItineraryRequest.getItinerary()
										.getDeletedList().get(k).getHotelList()
										.get(h).setIsHBSi(false);
							}
						}
					}
				}
			}
		}

		com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.priceitineraryresponse.v1.HotelsPriceItineraryResponse hotelsPriceItineraryResponse = null;

		// set the header elements
		hotelsPriceItineraryRequest.setHotelRequested(true);
		hotelsPriceItineraryRequest.setPackageRequest(false);
		hotelsPriceItineraryRequest.setAirRequested(false);
		hotelsPriceItineraryRequest.setVehicleRequested(false);
		hotelsPriceItineraryRequest.setMultiDestinationRequest(false);
		try {

			hotelsPriceItineraryResponse = proxyService.getProxyService()
					.retrieveHotelPricing(hotelsPriceItineraryRequest);

		} catch (RetrieveHotelPricingRetrieveHotelPricingFaultMsg e) {

		}

		catch (Exception e) {

		}
		//Start fix HBSI-8 Phase-1 //composing up the response coming from WESB
		if (hotelsPriceItineraryResponse != null) {
			//Checking the business Error(s)
			if (hotelsPriceItineraryResponse.getBusinessError() != null
					&& hotelsPriceItineraryResponse.getBusinessError().size() > 0) {

				List<ABEBusinessError> businesserrorList = new ArrayList<ABEBusinessError>();

				for (int l = 0; l < hotelsPriceItineraryResponse
						.getBusinessError().size(); l++) {
					ABEBusinessError businessError = null;
					businessError = this
							.getABEBusinessError(hotelsPriceItineraryResponse
									.getBusinessError().get(l));
					if (businessError != null)
						businesserrorList.add(businessError);

				}

				if (businesserrorList != null && businesserrorList.size() > 0)
					pricingResponse.saveBusinessErrors(businesserrorList);

			} 
			//Checking the System Error(s)
			else if (hotelsPriceItineraryResponse.getSystemErrors() != null
					&& hotelsPriceItineraryResponse.getSystemErrors().size() > 0) {
				List<ABESystemError> systemErrorList = new ArrayList<ABESystemError>();

				for (int l = 0; l < hotelsPriceItineraryResponse
						.getSystemErrors().size(); l++) {
					ABESystemError systemError = null;
					systemError = this
							.getABESystemError(hotelsPriceItineraryResponse
									.getSystemErrors().get(l));
					if (systemError != null)
						systemErrorList.add(systemError);

				}

				if (systemErrorList != null && systemErrorList.size() > 0)
					pricingResponse.saveSystemErrors(systemErrorList);

			}
			//Composing/Process the response object into predefined format
			else  {
				pricingResponse = this
						.getItineraryPricingResponse(hotelsPriceItineraryResponse);
				pricingResponse.getItinerary().setSearchCriteria(
						itinerary.getSearchCriteria());
				// Call it when bookingCancelled is false it makes hotel to be
				// to
				// pre selected
				if (itinerary.isBookingCancelled() == false
						&& pricingResponse.getItinerary() != null
						&& pricingResponse.getItinerary().getHotels() != null
						&& pricingResponse.getItinerary().getHotels().size() > 0) {
					pricingResponse
							.getItinerary()
							.getHotels()
							.get(0)
							.setSearchCriteria(
									itinerary.getHotels().get(0)
											.getSearchCriteria());
				}

			}

		}
		//End HBSI -8 Phase -1 fix
		return pricingResponse;
	}

	/**
	 * Method to price the given itinerary
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryPricingResponse hotelPriceItinerary(Itinerary itinerary,
			boolean isHBSi, Map<String, HBSiHotelInfo> hbsiHotelList) {
		ItineraryPricingResponse pricingResponse = this.retrieveHotelPricing(
				itinerary, isHBSi, hbsiHotelList);

		// Check for any business errors from BAPI
		if (pricingResponse.isBusinessErrorOccurred()
				|| pricingResponse.isErrorsOccurred()
				|| pricingResponse.isSystemErrorOccurred()
				|| pricingResponse.isWarningOccurred()) {
			pricingResponse.setItinerary(itinerary);
			return pricingResponse;
		}

		// Process Hotels
		if (pricingResponse.getItinerary().getHotels() != null) {
			this.updateHotelDisplayPrices(pricingResponse.getItinerary()
					.getHotels());
		}

		// Process Packages
		if (pricingResponse.getItinerary().getPackages() != null) {
			this.parsePackagesPricingResponse(pricingResponse.getItinerary()
					.getPackages());
		}

		// Process MultiDestinationPackages
		if (pricingResponse.getItinerary().getMultiDestinationPackages() != null) {
			this.parseMultiDestPackagesPricingResponse(pricingResponse
					.getItinerary().getMultiDestinationPackages());
		}
		// Process the charters with no. of stops
		processChartersWithStops(pricingResponse.getItinerary());

		// Set the itinerary
		// pricingResponse.setItinerary(itinerary);

		return pricingResponse;
	}

	private void updateHotelDisplayPrices(List<Hotel> hotels) {
		for (Hotel hotel : hotels) {
			double displayPrice = 0;
			for (RoomPrice roomPrice : hotel.getSelectedRooms()) {
				displayPrice += roomPrice.getPackagePrice();
			}
			if (hotel.getDisplayRoomCategory() != null) {
				if(hotel.getDisplayRoomCategory().getDisplayRoomPrice() !=null){
				hotel.getDisplayRoomCategory().getDisplayRoomPrice()
						.setTotalAmount(displayPrice);
				}
			}
		}
	}

	/**
	 * Method to parse the Packages pricing response
	 * 
	 * @param packages
	 * 
	 * @see
	 * @since
	 */
	private void parsePackagesPricingResponse(List<Package> packages) {
		for (Package availablePackage : packages) {
			double packagePrice = 0;
			double perPersonPkgPrice = 0;
			double commissionPkgPrice = 0;
			double packageTax = 0;
			List<PaxTypePriceBreakup> paxTypeBreakupList = new ArrayList<PaxTypePriceBreakup>();
			/*
			 * if(availablePackage.getSelectedFlight() != null){ TripFlight
			 * tripFlight = availablePackage.getSelectedFlight(); packageTax
			 * +=tripFlight.getPrice().getTotalTax(); }
			 */
			if (availablePackage.getSelectedHotel() != null) {
				// Air + Hotel, Air + Hotel + Car and Hotel + Car scenarios
				Hotel hotel = availablePackage.getSelectedHotel();
				for (RoomPrice roomPrice : hotel.getSelectedRooms()) {
					packagePrice += roomPrice.getPackagePrice();
					perPersonPkgPrice += roomPrice.getPerAdultBasePrice();
					if (roomPrice.getPaxTypePriceBreakups() != null) {
						paxTypeBreakupList.addAll(roomPrice
								.getPaxTypePriceBreakups());
					}
					if (!roomPrice.getPaxTypePriceBreakups().isEmpty()) {
						for (PaxTypePriceBreakup paxTypePriceBreakup : paxTypeBreakupList) {
							packageTax += paxTypePriceBreakup.getTaxes()
									* paxTypePriceBreakup.getCount();
						}

					}
					commissionPkgPrice += roomPrice.getCommissionAmount();
				}

				Price price = availablePackage.getPrice();
				if (price == null) {
					price = new Price();
				}
				price.setPackagePrice(packagePrice);
				price.setPerAdultBasePrice(perPersonPkgPrice);
				price.setCommissionAmount(commissionPkgPrice);
				price.setPaxTypePriceBreakups(paxTypeBreakupList);
				price.setTotalTax(packageTax);
				price.setBasePrice(packagePrice - packageTax);
				availablePackage.setPrice(price);
			} else if (availablePackage.getSelectedFlight() != null) {
				// Air + Car scenario
				availablePackage.setPrice(availablePackage.getSelectedFlight()
						.getPrice());
			}
		}
	}

	/**
	 * Method to parse the Packages pricing response
	 * 
	 * @param packages
	 * 
	 * @see
	 * @since
	 */
	private void parseMultiDestPackagesPricingResponse(
			List<MultiDestinationPackage> multiDestPkgs) {
		for (MultiDestinationPackage multiDestPkg : multiDestPkgs) {
			Price price = new Price();
			// Prepare the Price break-up for multi-destination based on
			// SearchCriteria
			List<PaxTypePriceBreakup> paxTypePriceList = this
					.getPaxTypeFromSearchCriteria(multiDestPkg
							.getSearchCriteria());

			// Add Flights price
			if (multiDestPkg.getSelectedFlights() != null
					&& !multiDestPkg.getSelectedFlights().isEmpty()) {
				for (TripFlight flight : multiDestPkg.getSelectedFlights()) {
					if (flight.getPrice() != null) {
						price.setPackagePrice(price.getPackagePrice()
								+ flight.getPrice().getOccpancyBasedPrice());
						price.setCommissionAmount(price.getCommissionAmount()
								+ flight.getPrice().getCommissionAmount());
						if (paxTypePriceList != null) {
							determineMultiDestFlightsPriceTypeBreakUp(flight
									.getPrice().getPaxTypePriceBreakups(),
									paxTypePriceList);
						}
					}
				}
			}
			// Add Hotels price
			if (multiDestPkg.getSelectedHotels() != null
					&& !multiDestPkg.getSelectedHotels().isEmpty()) {
				// Sort PAX types by room
				if (paxTypePriceList != null) {
					Collections.sort(paxTypePriceList,
							new PaxTypePriceByRoomComparator());
				}

				for (Hotel hotel : multiDestPkg.getSelectedHotels()) {
					if (hotel.getDisplayRoomCategory() != null
							&& hotel.getDisplayRoomCategory()
									.getDisplayRoomPrice() != null) {
						price.setPackagePrice(price.getPackagePrice()
								+ hotel.getDisplayRoomCategory()
										.getDisplayRoomPrice().getTotalAmount());
						for (RoomPrice roomPrice : hotel.getSelectedRooms()) {
							price.setCommissionAmount(price
									.getCommissionAmount()
									+ roomPrice.getCommissionAmount());
						}
					}
					if (paxTypePriceList != null) {
						determineMultiDestHotelPriceTypeBreakUp(
								hotel.getPreselectedRooms(), paxTypePriceList);
					}
				}
			}
			// Add Vehicles price
			if (multiDestPkg.getSelectedVehicles() != null
					&& !multiDestPkg.getSelectedVehicles().isEmpty()) {
				for (Vehicle vehicle : multiDestPkg.getSelectedVehicles()) {
					if (vehicle.getPrice() != null) {
						price.setPackagePrice(price.getPackagePrice()
								+ vehicle.getPrice().getOccpancyBasedPrice());
						price.setCommissionAmount(price.getCommissionAmount()
								+ vehicle.getPrice().getCommissionAmount());
						if (paxTypePriceList != null) {
							determineMultiDestVehiclePriceTypeBreakUp(
									price.getPaxTypePriceBreakups(),
									paxTypePriceList);
						}
					}
				}
			}
			price.setPaxTypePriceBreakups(paxTypePriceList);
			multiDestPkg.setPrice(price);
		}
	}

	/**
	 * Method to construct PaxTypePriceBreakup structure from SearchCriteria
	 * 
	 * @param searchCriteria
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private List<PaxTypePriceBreakup> getPaxTypeFromSearchCriteria(
			SearchCriteria searchCriteria) {
		if (searchCriteria == null || searchCriteria.getOccupancy() == null
				|| searchCriteria.getOccupancy().getPassengers() == null) {
			return null;
		}
		List<PaxTypePriceBreakup> paxTypeList = new ArrayList<PaxTypePriceBreakup>();
		for (Passenger passenger : searchCriteria.getOccupancy()
				.getPassengers()) {
			PaxTypePriceBreakup paxTypePriceBreakUp = new PaxTypePriceBreakup();
			paxTypePriceBreakUp.setPaxType(passenger.getAgeCode()
					.getPaxTypeCode());
			paxTypePriceBreakUp.setCount(passenger.getGuestCount());
			paxTypePriceBreakUp.setAge(passenger.getAge());
			paxTypePriceBreakUp.setRoomId(passenger.getRoomNumber());
			paxTypeList.add(paxTypePriceBreakUp);
		}
		// Sort the Pax Types based on type and ages
		Collections.sort(paxTypeList, new PaxTypePriceByTypeComparator());
		return paxTypeList;
	}

	/**
	 * Method to update the price type break up for multi destination flights
	 * 
	 * @param flightsPaxTypeList
	 * @param multiDestPaxTypeList
	 * 
	 * @see
	 * @since
	 */
	private void determineMultiDestFlightsPriceTypeBreakUp(
			List<PaxTypePriceBreakup> flightsPaxTypeList,
			List<PaxTypePriceBreakup> multiDestPaxTypeList) {
		if (flightsPaxTypeList == null || multiDestPaxTypeList == null)
			return;
		// Clone the current list
		List<PaxTypePriceBreakup> clonedList = clonePaxTypeBreakUpList(flightsPaxTypeList);
		for (PaxTypePriceBreakup paxTypeBreakUp : multiDestPaxTypeList) {
			if (clonedList.size() > 0) {
				PaxTypePriceBreakup flightPaxTypeBreakUp = clonedList.get(0);
				paxTypeBreakUp.setTaxes(paxTypeBreakUp.getTaxes()
						+ flightPaxTypeBreakUp.getTaxes());
				paxTypeBreakUp.setPrice(paxTypeBreakUp.getPrice()
						+ flightPaxTypeBreakUp.getPrice());
				paxTypeBreakUp.setUsTax(paxTypeBreakUp.getUsTax()
						+ flightPaxTypeBreakUp.getUsTax());
				paxTypeBreakUp.setForeignTax(paxTypeBreakUp.getForeignTax()
						+ flightPaxTypeBreakUp.getForeignTax());
				paxTypeBreakUp.setAirportTax(paxTypeBreakUp.getAirportTax()
						+ flightPaxTypeBreakUp.getAirportTax());
				paxTypeBreakUp.setTotalAmount(paxTypeBreakUp.getTotalAmount()
						+ flightPaxTypeBreakUp.getTotalAmount());
				if (flightPaxTypeBreakUp.getCount() - paxTypeBreakUp.getCount() > 0) {
					flightPaxTypeBreakUp.setCount(flightPaxTypeBreakUp
							.getCount() - paxTypeBreakUp.getCount());
				} else {
					clonedList.remove(0);
				}
			}
		}
	}

	/**
	 * Method to update the price type break up for multi-destination hotels
	 * 
	 * @param selectedRooms
	 * @param multiDestPaxTypeList
	 * 
	 * @see
	 * @since
	 */
	private void determineMultiDestHotelPriceTypeBreakUp(
			List<RoomPrice> selectedRooms,
			List<PaxTypePriceBreakup> multiDestPaxTypeList) {
		for (RoomPrice roomPrice : selectedRooms) {
			byte roomId = roomPrice.getRoomId();
			List<PaxTypePriceBreakup> roomPaxTypeList = roomPrice
					.getPaxTypePriceBreakups();
			// Clone the current list
			List<PaxTypePriceBreakup> clonedList = clonePaxTypeBreakUpList(roomPaxTypeList);
			for (PaxTypePriceBreakup paxTypeBreakUp : multiDestPaxTypeList) {
				if (paxTypeBreakUp.getRoomId() != roomId) {
					continue;
				}
				if (paxTypeBreakUp.getPaxType() == 'A') {
					// Process Adults
					ListIterator<PaxTypePriceBreakup> roomTypeIterator = clonedList
							.listIterator();
					while (roomTypeIterator.hasNext()) {
						PaxTypePriceBreakup roomPaxType = roomTypeIterator
								.next();
						if (roomPaxType.getPaxType() == 'A') {
							paxTypeBreakUp.setTaxes(paxTypeBreakUp.getTaxes()
									+ roomPaxType.getTaxes());
							paxTypeBreakUp.setPrice(paxTypeBreakUp.getPrice()
									+ roomPaxType.getPrice());
							paxTypeBreakUp.setUsTax(paxTypeBreakUp.getUsTax()
									+ roomPaxType.getUsTax());
							paxTypeBreakUp.setForeignTax(paxTypeBreakUp
									.getForeignTax()
									+ roomPaxType.getForeignTax());
							paxTypeBreakUp.setAirportTax(paxTypeBreakUp
									.getAirportTax()
									+ roomPaxType.getAirportTax());
							paxTypeBreakUp.setTotalAmount(paxTypeBreakUp
									.getTotalAmount()
									+ roomPaxType.getTotalAmount());
							if (roomPaxType.getCount()
									- paxTypeBreakUp.getCount() > 0) {
								roomPaxType.setCount(roomPaxType.getCount()
										- paxTypeBreakUp.getCount());
							} else {
								roomTypeIterator.remove();
							}
							break;
						}
					}
				} else {
					// Process Childrens
					boolean childPricingExists = false;
					PaxTypePriceBreakup childPriceBreakUp = null;
					for (PaxTypePriceBreakup clonedPaxType : clonedList) {
						if (paxTypeBreakUp.getAge() >= clonedPaxType
								.getMinAge()
								&& paxTypeBreakUp.getAge() <= clonedPaxType
										.getMaxAge()) {
							childPriceBreakUp = clonedPaxType;
							childPricingExists = true;
						}
					}
					if (!childPricingExists) {
						// Check for adults
						for (PaxTypePriceBreakup clonedPaxType : clonedList) {
							if (clonedPaxType.getPaxType() == 'A') {
								childPriceBreakUp = clonedPaxType;
								childPricingExists = true;
								break;
							}
						}
					}
					if (childPricingExists) {
						paxTypeBreakUp.setTaxes(paxTypeBreakUp.getTaxes()
								+ childPriceBreakUp.getTaxes());
						paxTypeBreakUp.setPrice(paxTypeBreakUp.getPrice()
								+ childPriceBreakUp.getPrice());
						paxTypeBreakUp.setUsTax(paxTypeBreakUp.getUsTax()
								+ childPriceBreakUp.getUsTax());
						paxTypeBreakUp.setForeignTax(paxTypeBreakUp
								.getForeignTax()
								+ childPriceBreakUp.getForeignTax());
						paxTypeBreakUp.setAirportTax(paxTypeBreakUp
								.getAirportTax()
								+ childPriceBreakUp.getAirportTax());
						paxTypeBreakUp.setTotalAmount(paxTypeBreakUp
								.getTotalAmount()
								+ childPriceBreakUp.getTotalAmount());
						if (childPriceBreakUp.getCount()
								- paxTypeBreakUp.getCount() > 0) {
							childPriceBreakUp.setCount(childPriceBreakUp
									.getCount() - paxTypeBreakUp.getCount());
						} else {
							int index = clonedList.indexOf(childPriceBreakUp);
							clonedList.remove(index);
						}
					}
				}
			}
		}
	}

	/**
	 * Method to update the price type break up for multi-destination vehicles
	 * 
	 * @param paxTypeBreakUpList
	 * @param multiDestPaxTypeList
	 * 
	 * @see
	 * @since
	 */
	private void determineMultiDestVehiclePriceTypeBreakUp(
			List<PaxTypePriceBreakup> paxTypeBreakUpList,
			List<PaxTypePriceBreakup> multiDestPaxTypeList) {
		if (paxTypeBreakUpList != null) {
			int adultCount = 0;
			for (PaxTypePriceBreakup paxTypePriceBreakup : multiDestPaxTypeList) {
				if (paxTypePriceBreakup.getPaxType() == 'A') {
					adultCount += paxTypePriceBreakup.getCount();
				}
			}
			PaxTypePriceBreakup vehiclePaxType = paxTypeBreakUpList.get(0);
			for (PaxTypePriceBreakup paxTypeBreakUp : multiDestPaxTypeList) {
				paxTypeBreakUp.setTaxes(paxTypeBreakUp.getTaxes()
						+ (vehiclePaxType.getTaxes() / adultCount));
				paxTypeBreakUp.setPrice(paxTypeBreakUp.getPrice()
						+ (vehiclePaxType.getPrice() / adultCount));
				paxTypeBreakUp.setUsTax(paxTypeBreakUp.getUsTax()
						+ (vehiclePaxType.getUsTax() / adultCount));
				paxTypeBreakUp.setForeignTax(paxTypeBreakUp.getForeignTax()
						+ (vehiclePaxType.getForeignTax() / adultCount));
				paxTypeBreakUp.setAirportTax(paxTypeBreakUp.getAirportTax()
						+ (vehiclePaxType.getAirportTax() / adultCount));
				paxTypeBreakUp.setTotalAmount(paxTypeBreakUp.getTotalAmount()
						+ (vehiclePaxType.getTotalAmount() / adultCount));
			}
		}
	}

	/**
	 * Method to clone the PaxTypeBreakUp List
	 * 
	 * @param paxTypeList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private List<PaxTypePriceBreakup> clonePaxTypeBreakUpList(
			List<PaxTypePriceBreakup> paxTypeList) {
		if (paxTypeList == null || paxTypeList.size() == 0) {
			return null;
		}
		List<PaxTypePriceBreakup> returnList = new ArrayList<PaxTypePriceBreakup>();
		for (PaxTypePriceBreakup paxTypePriceBreakup : paxTypeList) {
			try {
				returnList.add((PaxTypePriceBreakup) paxTypePriceBreakup
						.clone());
			} catch (CloneNotSupportedException ex) {
			}
		}
		return returnList;
	}

	/**
	 * Method to process the charters with stops and fill the stops information
	 * 
	 * @param itinerary
	 * 
	 * @see
	 * @since
	 */
	private void processChartersWithStops(Itinerary itinerary) {
		if (itinerary.getFlights() != null) {
			for (TripFlight tripFlight : itinerary.getFlights()) {
				updateFlightDetailsOfCharter(tripFlight);
			}
		}
		if (itinerary.getPackages() != null) {
			for (Package availablePackage : itinerary.getPackages()) {
				if (availablePackage.getSelectedFlight() != null) {
					updateFlightDetailsOfCharter(availablePackage
							.getSelectedFlight());
				}
			}
		}
	}

	/**
	 * Method to update stop details of the flight
	 * 
	 * @param tripFlight
	 * 
	 * @see
	 * @since
	 */
	private void updateFlightDetailsOfCharter(TripFlight tripFlight) {
		if (!tripFlight.getFlightType().isCharter()) {
			return;
		}
		byte outBoundStops = 0;
		if (tripFlight.getOutboundFlight() != null) {
			if (tripFlight.getOutboundFlight().getNoOfStops() != null) {
				outBoundStops = Byte.parseByte(tripFlight.getOutboundFlight()
						.getNoOfStops());
			}
		}
		byte inBoundStops = 0;
		if (tripFlight.getInboundFlight() != null) {
			if (tripFlight.getInboundFlight().getNoOfStops() != null) {
				inBoundStops = Byte.parseByte(tripFlight.getInboundFlight()
						.getNoOfStops());
			}
		}
		if (outBoundStops != (tripFlight.getOutboundFlight()
				.getFlightSegments().size() - 1)
				|| (tripFlight.getInboundFlight() != null && inBoundStops != (tripFlight
						.getInboundFlight().getFlightSegments().size() - 1))) {
			FlightInfoCriteria flightInfoCriteria = new FlightInfoCriteria();
			FlightSegment flightSegment = tripFlight.getOutboundFlight()
					.getFlightSegments().get(0);
			if (tripFlight.getOutboundFlight().getMaterial() != null) {
				flightInfoCriteria.setMaterial(tripFlight.getOutboundFlight()
						.getMaterial());
			} else {
				Material material = new Material();
				material.setMaterialNo(tripFlight.getOutboundFlight()
						.getGateway()
						+ tripFlight.getOutboundFlight().getDestination() + "C");
				SimpleDateFormat sdf = new SimpleDateFormat("MMddyy");
				StringBuffer batchNo = new StringBuffer();
				batchNo.append(sdf.format(tripFlight.getOutboundFlight()
						.getDepartureTime()));
				if (tripFlight.getDuration() < 10) {
					batchNo.append("0");
				}
				batchNo.append(tripFlight.getDuration());
				batchNo.append(flightSegment.getClassOfService());
				batchNo.append(flightSegment.getRotation());
				material.setBatchNo(batchNo.toString());
				flightInfoCriteria.setMaterial(material);
			}
			FlightInfoResponse flightInfoResponse = flightInfoDao
					.retrieveFlightInfo(flightInfoCriteria);
			if (!flightInfoResponse.isErrorsOccurred()
					&& flightInfoResponse.getTripFlight() != null) {
				TripFlight flightDetails = flightInfoResponse.getTripFlight();
				// CQ8827 : Code fix added for setting oldPosnr & posnr value
				// for Inbound & Outbound Flight.
				Flight outboundFlight = updateSeatsAvailable(
						flightDetails.getOutboundFlight(),
						flightSegment.getSeatsAvailable());
				Flight inboundFlight = updateSeatsAvailable(
						flightDetails.getInboundFlight(),
						flightSegment.getSeatsAvailable());
				if (outboundFlight != null
						&& tripFlight.getOutboundFlight() != null) {
					outboundFlight.setOldPosnr(tripFlight.getOutboundFlight()
							.getOldPosnr());
					outboundFlight.setPosnr(tripFlight.getOutboundFlight()
							.getPosnr());
				}
				if (inboundFlight != null
						&& tripFlight.getInboundFlight() != null) {
					inboundFlight.setOldPosnr(tripFlight.getInboundFlight()
							.getOldPosnr());
					inboundFlight.setPosnr(tripFlight.getInboundFlight()
							.getPosnr());
				}
				tripFlight.setOutboundFlight(outboundFlight);
				tripFlight.setInboundFlight(inboundFlight);
			}

		}
	}

	/**
	 * Method to update no. of seats available at each segment
	 * 
	 * @param flight
	 * @param seatAvailable
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private Flight updateSeatsAvailable(Flight flight, byte seatAvailable) {
		if (flight == null) {
			return null;
		}
		for (FlightSegment flightSegment : flight.getFlightSegments()) {
			flightSegment.setSeatsAvailable(seatAvailable);
		}
		return flight;
	}
}
