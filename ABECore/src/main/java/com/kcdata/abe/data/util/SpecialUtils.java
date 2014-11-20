/*
 * SpecialUtils.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jan 22, 2011  chazari
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.applevac.sce.schema.Duration;
import com.applevac.sce.schema.Special;
import com.applevac.sce.service.external.SpecialsSearchCriteria;
import com.applevac.sce.util.Zero;
import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.request.PackagesRequest;
import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.business.response.SpecialsCacheResponse;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.HotelOptions;
import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.RoomPrice;
import com.kcdata.abe.data.dto.SpecialOptions;
import com.kcdata.abe.data.dto.SpecialRequestType;
import com.kcdata.abe.data.dto.TripFlight;

/**
 * 
 * Utility methods used in processing specials
 *
 * @author chazari
 * @version
 *
 */
public class SpecialUtils {
	
	/**
	 * 
	 * Method maps hotel returned from grid to ABE hotel structure
	 * @param specialsResponse
	 * @param searchCriteria
	 * @return hotelsResponse
	 */
	public static HotelsResponse buildHotelFromSpecial(
			SpecialsCacheResponse specialsResponse,
			SpecialsSearchCriteria searchCriteria, HotelsRequest hotelRequest) {
		HotelsResponse hotelResponse = new HotelsResponse();
		List<Hotel> hotelsList = new ArrayList<Hotel>();
		List<RoomCategory> roomCategories = new ArrayList<RoomCategory>();
		List<Special> specialsList = specialsResponse
				.getRetrievedSpecialsList().getSpecial();
		Hotel hotel = new Hotel();
		boolean hotelAdded = false;
		for (Special eachSpecial : specialsList) {
			if (searchCriteria.getHotelName().equalsIgnoreCase(
					eachSpecial.getHotelName())) {

				if (!hotelAdded) {
					hotelAdded = true;
					prepareHotel(searchCriteria, hotel, eachSpecial);
				}
				String roomTypeCode = "";

				if ("Y".equalsIgnoreCase(eachSpecial.getMaintainedSpecial()))
					roomTypeCode = eachSpecial.getId().substring(3,
							(eachSpecial.getId().length()));
				else
					roomTypeCode = eachSpecial.getId().substring(3,
							(eachSpecial.getId().length() - 1));
				// One room category for each special
				 
				List<Duration> durationList = eachSpecial.getDurations()
						.getDuration();
				for (Duration eachDuration : durationList) {
					List<com.applevac.sce.schema.Date> dateList = eachDuration
							.getDates().getDate();
					for (com.applevac.sce.schema.Date eachDate : dateList) {
						if (searchCriteria.getBatchId().equalsIgnoreCase(
								eachDate.getBatchID())) {
							RoomCategory room = new RoomCategory();
							hotel.setNoOfRooms(eachDate.getRoomsAvailable());
							room.setRoomTypeDescription(eachSpecial
									.getHotelCategoryName());
							room.setRoomTypeCode(roomTypeCode);
							RoomPrice roomPrice = new RoomPrice();
							roomPrice.setTotalAmount(eachDuration.getPriceNow());
							roomPrice.setSavings(eachDuration.getSavingPerCouple());
							room.setDisplayRoomPrice(roomPrice);
							roomCategories.add(room);
							break;
						}
					}

				}
			}
		}
		hotel.setOccupancy(hotelRequest.getOccupancy());
		hotel.setRoomCategories(roomCategories);
		hotelsList.add(hotel);
		hotelResponse.setHotelList(hotelsList);
		return hotelResponse;
	}
	
	/**
	 * Prepare top level hotel object.
	 * @param hotel
	 * @param eachSpecial
	 * @return hotel
	 */
	private static Hotel prepareHotel(SpecialsSearchCriteria searchCriteria,
			Hotel hotel, Special eachSpecial) {
		
		hotel.setHotelName(eachSpecial.getHotelName());

		String rating = eachSpecial.getRating().toUpperCase();
		String modifiedRating = rating.substring(0, 1);

		if (rating.indexOf("APPLE") != -1)
			modifiedRating += "A";
		else if (rating.indexOf("GOLDEN") != -1)
			modifiedRating = modifiedRating + "G";
		else if (rating.indexOf("ULTRA") != -1)
			modifiedRating = modifiedRating + "U";
		if (rating.endsWith("P"))
			modifiedRating += "+";
		hotel.setHotelCityCode(eachSpecial.getDestinationCode());
		hotel.setOriginLocation(eachSpecial.getGatewayCode());
		hotel.setCheckInDate(searchCriteria.getStartDate());
		hotel.setCheckOutDate(searchCriteria.getEndDate());
		hotel.setHotelCode(Zero.appendZeros(eachSpecial.getHotelCode(), 10));
		hotel.setAppleRating(modifiedRating);
		return hotel;
	}
	
	/**
	 * Converts ABE Search criteria to specials search criteria
	 * @param abeSearchCriteria
	 * @return specialsSearchCriteria
	 */
	public static SpecialsSearchCriteria convertSearchCriteria(
			HotelsRequest hotelRequest, SpecialRequestType specialReqType) {
		SpecialsSearchCriteria specialsSearchCriteria = new SpecialsSearchCriteria();
		SpecialOptions specialOptions = hotelRequest.getSpecialOptions();
		HotelOptions hotelOptions = hotelRequest.getHotelOptions();
		if(hotelOptions != null) 
			specialsSearchCriteria.setHotelName(hotelOptions.getHotelName());
		if(specialOptions != null) {
			if(specialOptions.getSpecialRequestType() != null)
				specialsSearchCriteria.setRequestType(specialOptions.getSpecialRequestType().getType());
			if (!specialReqType.allSpecialsRequested()) 
				specialsSearchCriteria.setCategoryId("CT");
			else
				specialsSearchCriteria.setCategoryId(specialOptions.getSpecialCategoryId());
			specialsSearchCriteria.setBatchId(specialOptions.getSpecialBatchId());
		}
		specialsSearchCriteria.setDurationInt(hotelRequest.getNoOfNights());
		specialsSearchCriteria.setGateway(hotelRequest.getGateway());
		specialsSearchCriteria.setStartDate(hotelRequest.getDepartureDate());
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(hotelRequest.getDepartureDate());
		cal.add(Calendar.DATE, hotelRequest.getNoOfNights());
		specialsSearchCriteria.setEndDate(cal.getTime());
		return specialsSearchCriteria;
	}
	
	/**
	 * Converts ABE Search criteria to specials search criteria
	 * @param packagesRequest
	 * @param specialReqType
	 * @param categoryId
	 * @return
	 */
	public static SpecialsSearchCriteria convertSpecialsSearchCriteria(
			PackagesRequest packagesRequest, SpecialRequestType specialReqType, String categoryId) {
		SpecialsSearchCriteria specialsSearchCriteria = new SpecialsSearchCriteria();
			
		specialsSearchCriteria.setDurationInt(packagesRequest.getHotelsRequest().getNoOfNights());
		specialsSearchCriteria.setGateway(packagesRequest.getHotelsRequest().getGateway());
		specialsSearchCriteria.setStartDate(packagesRequest.getHotelsRequest().getDepartureDate());
		specialsSearchCriteria.setCategoryId(categoryId);
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(packagesRequest.getHotelsRequest().getDepartureDate());
		cal.add(Calendar.DATE, packagesRequest.getHotelsRequest().getNoOfNights());
		specialsSearchCriteria.setEndDate(cal.getTime());
		return specialsSearchCriteria;
	}
	
	/**
	 * 
	 * Method updates room prices with air prices for scheduled air specials
	 * Currently, this implementations supports one hotel for room
	 * upgrade scenario.
	 * @param specialHotels
	 * @param selectedFlight
	 * @return updatedHotelList
	 */
	public static List<Hotel> updatePrices(List<Hotel> specialHotels, TripFlight selectedFlight) {
		List<Hotel> updatedHotels = new ArrayList<Hotel>(1);
		Hotel hotel = specialHotels.get(0);
		List<RoomCategory> roomList = hotel.getRoomCategories();
		for (int i = 0; i < roomList.size(); i++) {
			RoomCategory room = roomList.get(i);
			RoomPrice roomPrice = room.getDisplayRoomPrice();
			double currentRoomPrice = room.getDisplayRoomPrice().getTotalAmount();			
			int noOfpassenger=selectedFlight.getOccupancy().getNoOfAdults()+selectedFlight.getOccupancy().getNoOfChilds()+selectedFlight.getOccupancy().getNoOfInfants();
			currentRoomPrice += selectedFlight.getPrice().getPerAdultBasePrice()+(selectedFlight.getPrice().getTotalTax()/noOfpassenger);			
			//currentRoomPrice += selectedFlight.getPrice().getPerAdultBasePrice();
			roomPrice.setTotalAmount(currentRoomPrice);
			room.setDisplayRoomPrice(roomPrice);
			roomList.set(i, room);
		}
		hotel.setRoomCategories(roomList);
		updatedHotels.add(hotel);
		return updatedHotels;
	}
}
