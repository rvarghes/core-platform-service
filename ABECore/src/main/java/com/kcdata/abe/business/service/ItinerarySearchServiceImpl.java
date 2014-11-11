/*
 * ItinerarySearchServiceImpl.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Mar 29, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.business.response.ItinerarySearchResponse;
import com.kcdata.abe.data.dao.HBSiHotelDao;
import com.kcdata.abe.data.dao.HBSiHotelsOnlyDao;
import com.kcdata.abe.data.dao.ItinerarySearchDao;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.ItinerarySearchCriteria;
import com.kcdata.abe.data.dto.MealPlanType;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.framework.service.ABEServiceBase;

public class ItinerarySearchServiceImpl extends ABEServiceBase implements
		ItinerarySearchService {
	/**
	 * DAO for searching bookings
	 * 
	 * @see
	 * @since
	 */
	private ItinerarySearchDao itinerarySearchDao;


	/**
	 * @return the itinerarySearchDao
	 */
	public ItinerarySearchDao getItinerarySearchDao() {
		return itinerarySearchDao;
	}

	/**
	 * @param itinerarySearchDao the itinerarySearchDao to set
	 */
	public void setItinerarySearchDao(ItinerarySearchDao itinerarySearchDao) {
		this.itinerarySearchDao = itinerarySearchDao;
	}
	
	private HBSiHotelsOnlyDao hbsiHotelsOnly;
	
	/**
 * @return the hbsiHotelsOnly
 */
	public HBSiHotelsOnlyDao getHbsiHotelsOnly() {
	return hbsiHotelsOnly;
	}

/**
 * @param hbsiHotelsOnly the hbsiHotelsOnly to set
 */
	public void setHbsiHotelsOnly(HBSiHotelsOnlyDao hbsiHotelsOnly) {
	this.hbsiHotelsOnly = hbsiHotelsOnly;
	}
	
	/**
	 * DAO class for retrieving HBSi Hotel constants
	 */
	private HBSiHotelDao hbsiHotelDao;
	/**
	 * @return the hbsiHotelDao
	 */
	public HBSiHotelDao getHbsiHotelDao() {
		return hbsiHotelDao;
	}

	/**
	 * @param hbsiHotelDao the hbsiHotelDao to set
	 */
	public void setHbsiHotelDao(HBSiHotelDao hbsiHotelDao) {
		this.hbsiHotelDao = hbsiHotelDao;
	}
	
	
	public Hotel getModifiedHBSiHotel(Itinerary itinerary,Hotel hotelDTO)
	{
		Map<String,HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao.getHBSiDBData();
		HotelsResponse hotelResponse = this.hbsiHotelsOnly.retrieveWesbHotels(itinerary, hotelDTO, null, hbsiHotelList, "CQ");
		Hotel modifiedHbsiHotel = hotelResponse.getHotelList().get(0);
		if(hotelResponse!=null && hotelResponse.getHotelList()!=null && hotelResponse.getHotelList().size()>0)
		{
			//Populate the room catgories with roomType Description,Meal Plan ,Hbsi rates and Pax Base prices for HBSi hotel
			if(hotelDTO.getSelectedRooms()!=null && hotelResponse.getHotelList().get(0)!=null && hotelResponse.getHotelList().get(0).getRoomCategories()!=null && hotelResponse.getHotelList().get(0).getRoomCategories().size()>0)
			{
				
				for(int roomPrice=0;roomPrice<hotelDTO.getSelectedRooms().size();roomPrice++)
				{
					for(int hbsiRoomCat=0;hbsiRoomCat<modifiedHbsiHotel.getRoomCategories().size();hbsiRoomCat++)
					{
						if(hotelDTO.getSelectedRooms().get(roomPrice).getRoomCategoryId()==modifiedHbsiHotel.getRoomCategories().get(hbsiRoomCat).getRoomCategoryId())
						{
							for(int roomCat=0;roomCat<hotelDTO.getRoomCategories().size();roomCat++)
							{
								if(hotelDTO.getRoomCategories().get(roomCat).getRoomCategoryId()==hotelDTO.getSelectedRooms().get(roomPrice).getRoomCategoryId())
								{
									hotelDTO.getRoomCategories().get(roomCat).getRoomPrices().get(0).setPaxBasePrices(modifiedHbsiHotel.getRoomCategories().get(hbsiRoomCat).getRoomPrices().get(0).getPaxBasePrices());
									hotelDTO.getRoomCategories().get(roomCat).setHbsiRates(modifiedHbsiHotel.getRoomCategories().get(hbsiRoomCat).getHbsiRates());
									hotelDTO.getRoomCategories().get(roomCat).setRoomTypeDescription(modifiedHbsiHotel.getRoomCategories().get(hbsiRoomCat).getRoomTypeDescription());
									hotelDTO.getRoomCategories().get(roomCat).setMealPlanType(modifiedHbsiHotel.getRoomCategories().get(hbsiRoomCat).getMealPlanType());
									
									//setting rate plan code
									hotelDTO.getRoomCategories().get(roomCat).setRatePlanCode(modifiedHbsiHotel.getRoomCategories().get(hbsiRoomCat).getRatePlanCode());
								}
							}
						}
					}
				}
			}
			
			//Populate the Display Room category with roomType Description,Meal Plan ,Hbsi rates and Pax Base prices for HBSi hotel
			
			if(hotelDTO.getDisplayRoomCategory()!=null)
			{
				for(int modifiedHbsi=0;modifiedHbsi<modifiedHbsiHotel.getRoomCategories().size();modifiedHbsi++)
				{
					if(hotelDTO.getDisplayRoomCategory().getRoomCategoryId()==modifiedHbsiHotel.getRoomCategories().get(modifiedHbsi).getRoomCategoryId())
					{
						hotelDTO.getDisplayRoomCategory().setHbsiRates(modifiedHbsiHotel.getRoomCategories().get(modifiedHbsi).getHbsiRates());
						hotelDTO.getDisplayRoomCategory().getDisplayRoomPrice().setPaxBasePrices(modifiedHbsiHotel.getRoomCategories().get(modifiedHbsi).getRoomPrices().get(0).getPaxBasePrices());
						hotelDTO.getDisplayRoomCategory().setRoomTypeDescription(modifiedHbsiHotel.getRoomCategories().get(modifiedHbsi).getRoomTypeDescription());
						hotelDTO.getDisplayRoomCategory().setMealPlanType(modifiedHbsiHotel.getRoomCategories().get(modifiedHbsi).getMealPlanType());
						
						//set Rate plan code 
						hotelDTO.getDisplayRoomCategory().setRatePlanCode(modifiedHbsiHotel.getRoomCategories().get(modifiedHbsi).getRatePlanCode());
						
					}
				}
			}
			
			if(hotelDTO.getSelectedRooms()!=null)
			{
				for(int selctedRoom=0;selctedRoom<hotelDTO.getSelectedRooms().size();selctedRoom++)
				{
				for(int selectedRoomCat=0;selectedRoomCat<modifiedHbsiHotel.getSelectedRooms().size();selectedRoomCat++)
				{
					if(hotelDTO.getSelectedRooms().get(selctedRoom).getRoomCategoryId()==modifiedHbsiHotel.getSelectedRooms().get(selctedRoom).getRoomCategoryId())
					{
						hotelDTO.getSelectedRooms().get(selctedRoom).setPaxBasePrices(modifiedHbsiHotel.getSelectedRooms().get(selctedRoom).getPaxBasePrices());
					}
					
				}
				}
			}
			
		}
		
		return hotelDTO;
	}
	
	
	/**
	 * Method to check whether Hotel Only
	 * @param itinerary
	 * @return boolean
	 */
	public boolean isHotelOnly(Itinerary itinerary){
		boolean isHotelOnly = false;
		if( ((itinerary.getFlights() == null) || (itinerary.getFlights().size() == 0)) &&
			((itinerary.getVehicles() == null) || (itinerary.getVehicles().size() == 0)) &&
			((itinerary.getPackages() == null) || (itinerary.getPackages().size() == 0)) &&
			((itinerary.getMultiDestinationPackages() == null) || (itinerary.getMultiDestinationPackages().size() == 0)) &&
			((itinerary.getHotels() != null) && (itinerary.getHotels().size() > 0)) )
			isHotelOnly =  true;
		
		if(itinerary.getDeletedList()!=null){
			List lsABEDto  = itinerary.getDeletedList();
			for (Iterator iterator = lsABEDto.iterator(); iterator.hasNext();) {
				Object abeDto =  iterator.next();
				if (abeDto instanceof TripFlight) {
					isHotelOnly = false;
				}else if (abeDto instanceof Vehicle) {
					isHotelOnly = false;
				}
			}
		}
		return isHotelOnly;
	}

	public ItinerarySearchResponse retrieveItinerary(String quoteNo) {
		//return this.itinerarySearchDao.retrieveItinerary(quoteNo);
		ItinerarySearchResponse searchresponse = itinerarySearchDao.retrieveItinerary(quoteNo);
		
		
			Itinerary itinerary = searchresponse.getItinerary();
			
			

			/******************************************* WESB CODE FOR HOTEL ONLY *********************************************/
			/*BEGIN: Convert VendorHotelCode to hotel code for HBSi hotels    */
			
	Map<String,HBSiHotelInfo> hbsiHotelVendorCode = this.hbsiHotelDao.getHotelVendors();
			
			if(itinerary!=null && (itinerary.getHotels()!=null || itinerary.getPackages()!=null || itinerary.getMultiDestinationPackages()!=null))
			{
				Map<String,HBSiHotelInfo> hotelVendorCodeMap = this.hbsiHotelDao.getHotelVendors();
				if(itinerary.getHotels()!=null)
				{
					for(int hbsiHotel=0;hbsiHotel<itinerary.getHotels().size();hbsiHotel++ )
					{
						if(this.hbsiHotelDao.isHBSiHotelVendorCode(itinerary.getHotels().get(hbsiHotel).getHotelCode()))
						{
							HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(itinerary.getHotels().get(hbsiHotel).getHotelCode());
							if(hbsiHotelInfo!=null)
							{
								itinerary.getHotels().get(hbsiHotel).setHotelCode(hbsiHotelInfo.getHotelId());
							}
						}
					}
				}
				
				if(itinerary.getPackages()!=null)
				{
					for(int pack=0;pack<itinerary.getPackages().size();pack++)
					{
						if(itinerary.getPackages().get(pack)!=null && itinerary.getPackages().get(pack).getSelectedHotel()!=null
								&& this.hbsiHotelDao.isHBSiHotelVendorCode(itinerary.getPackages().get(pack).getSelectedHotel().getHotelCode()))
						{
							HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(itinerary.getPackages().get(pack).getSelectedHotel().getHotelCode());
							itinerary.getPackages().get(pack).getSelectedHotel().setHotelCode(hbsiHotelInfo.getHotelId());
							
						}
					}
				}
				
				
					if(itinerary.getMultiDestinationPackages()!=null && itinerary.getMultiDestinationPackages().size()>0)
					{
						for(int multiDestPack=0;multiDestPack<itinerary.getMultiDestinationPackages().size();multiDestPack++)
						{
							if(itinerary.getMultiDestinationPackages().get(multiDestPack)!=null)
							{
								for(int hbsiHotel=0;hbsiHotel<itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().size();hbsiHotel++)
								{
									if(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel)!=null 
								&& this.hbsiHotelDao.isHBSiHotelVendorCode(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).getHotelCode()))
									
									{
										HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).getHotelCode());
										itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).setHotelCode(hbsiHotelInfo.getHotelId());
									}
								}
							}
						
						}
						
					}
				
			}
			
			/* END Convert vendorHotelCode to HotelCode****/
			
			
			
			List<String> hbsiSwitchList = this.hbsiHotelDao.getHBSiSwitch();
			if( itinerary!=null && hbsiSwitchList!=null && hbsiSwitchList.get(0)!=null &&hbsiSwitchList.get(0)!="" && hbsiSwitchList.get(0).equalsIgnoreCase("TRUE") && this.isHotelOnly(itinerary))
			{
				
				Map<String,HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao.getHBSiDBData();
				boolean hbsiStatus = false;
				
					//fetch only HBSi hotels
					for(int h=0;h<itinerary.getHotels().size();h++)
					{
						hbsiStatus = this.hbsiHotelDao.isHBSiHotel(itinerary.getHotels().get(h).getHotelCode());
						if(hbsiStatus==true)
						{
							
							HotelsResponse hotelResponse = this.hbsiHotelsOnly.retrieveWesbHotels(itinerary,itinerary.getHotels().get(h),itinerary.getSearchCriteria().getHotelsRequest(),hbsiHotelList,"CQ");
					
							if(hotelResponse!=null && hotelResponse.getHotelList().size()>0)
							{
							
									for(int roomPrice=0;roomPrice<itinerary.getHotels().get(h).getSelectedRooms().size();roomPrice++)
									{
										
										for(int hbsiRoomCat=0;hbsiRoomCat<hotelResponse.getHotelList().get(0).getRoomCategories().size();hbsiRoomCat++)
										{
										if(itinerary.getHotels().get(h).getSelectedRooms().get(roomPrice).getRoomCategoryId()==hotelResponse.getHotelList().get(0).getRoomCategories().get(hbsiRoomCat).getRoomCategoryId())
										{
											for(int roomCat=0;roomCat<itinerary.getHotels().get(h).getRoomCategories().size();roomCat++)
											{
												
												if(itinerary.getHotels().get(h).getRoomCategories().get(roomCat).getRoomCategoryId()==itinerary.getHotels().get(h).getSelectedRooms().get(roomPrice).getRoomCategoryId())
												{
											//set the pax base price
										itinerary.getHotels().get(h).getRoomCategories().get(roomCat).getRoomPrices().get(0).setPaxBasePrices(hotelResponse.getHotelList().get(0).
												getRoomCategories().get(hbsiRoomCat).getRoomPrices().get(0).getPaxBasePrices());
										
										//set the HBSi Rates,roomType and meal plan
										itinerary.getHotels().get(h).getRoomCategories().get(roomCat).setHbsiRates(hotelResponse.getHotelList().get(0).getRoomCategories().get(hbsiRoomCat).getHbsiRates());
										itinerary.getHotels().get(h).getRoomCategories().get(roomCat).setRoomTypeDescription(hotelResponse.getHotelList().get(0).getRoomCategories().get(hbsiRoomCat).getRoomTypeDescription());
										itinerary.getHotels().get(h).getRoomCategories().get(roomCat).setRoomTypeCode(hotelResponse.getHotelList().get(0).getRoomCategories().get(hbsiRoomCat).getRoomTypeCode());
										itinerary.getHotels().get(h).getRoomCategories().get(roomCat).setMealPlanType(hotelResponse.getHotelList().get(0).getRoomCategories().get(hbsiRoomCat).getMealPlanType());
												}
											}
										}
									}
									}
								
								
								//set the PaxBasePrices in displayRoomCategory based on roomCategoryId in displayRoomCategory 
								for(int roomCat=0;roomCat<itinerary.getHotels().get(h).getRoomCategories().size();roomCat++)
								{
									for(int hbsiRoomCat=0;hbsiRoomCat<hotelResponse.getHotelList().get(0).getRoomCategories().size();hbsiRoomCat++)
									{
									if(itinerary.getHotels().get(h).getDisplayRoomCategory().getRoomCategoryId()==hotelResponse.getHotelList().get(0).getRoomCategories().get(hbsiRoomCat).getRoomCategoryId())
									{
										//Set the meal plan and room type code
										itinerary.getHotels().get(h).getDisplayRoomCategory().setRoomTypeDescription(hotelResponse.getHotelList().get(0).getRoomCategories().get(hbsiRoomCat).getRoomTypeDescription());
										itinerary.getHotels().get(h).getDisplayRoomCategory().setRoomTypeCode(hotelResponse.getHotelList().get(0).getRoomCategories().get(hbsiRoomCat).getRoomTypeCode());
										itinerary.getHotels().get(h).getDisplayRoomCategory().setMealPlanType(hotelResponse.getHotelList().get(0).getRoomCategories().get(hbsiRoomCat).getMealPlanType());
										
										itinerary.getHotels().get(h).getDisplayRoomCategory().setHbsiRates(hotelResponse.getHotelList().get(0).getRoomCategories().get(hbsiRoomCat).getHbsiRates());
										
										
										itinerary.getHotels().get(h).getDisplayRoomCategory().getDisplayRoomPrice().setPaxBasePrices(hotelResponse.getHotelList().get(0).getRoomCategories().get(hbsiRoomCat).getRoomPrices().get(0).getPaxBasePrices());
									}
								}
								}
								
								
								
								for(int selectedRoom=0;selectedRoom<itinerary.getHotels().get(h).getSelectedRooms().size();selectedRoom++)
								{
									itinerary.getHotels().get(h).getSelectedRooms().get(selectedRoom).setPaxBasePrices(hotelResponse.getHotelList().get(0).
											getRoomCategories().get(0).getRoomPrices().get(0).getPaxBasePrices());
								}
								
						
								
								
							}
						}
							
					}
					searchresponse.setItinerary(itinerary);
					
				return searchresponse;
		}
			else if(itinerary!=null && hbsiSwitchList!=null && hbsiSwitchList.get(0)!=null &&hbsiSwitchList.get(0)!="" && hbsiSwitchList.get(0).equalsIgnoreCase("TRUE") )
			{
				//Package Modify For HBSi hotels
				/***************WESB CODE FOR PACKAGE MODIFY**************/
				
				if(itinerary!=null )
				{
					
					
					if(itinerary.getPackages()!=null && itinerary.getPackages().size()>0)
					{
						for(int pack=0;pack<itinerary.getPackages().size();pack++)
						{
						if(itinerary.getPackages().get(pack)!=null && itinerary.getPackages().get(pack).getSelectedHotel()!=null && this.hbsiHotelDao.isHBSiHotel(itinerary.getPackages().get(pack).getSelectedHotel().getHotelCode()))
						{
							if(itinerary.getPackages().get(pack).getSelectedHotel().getDisplayRoomCategory()!=null && itinerary.getPackages().get(pack).getSelectedHotel().getDisplayRoomCategory().getHbsiRates()==null)
							{
								//set the rateplacode for room category from display room category
								itinerary.getPackages().get(pack).getSelectedHotel().getRoomCategories().get(0).setRatePlanCode(null);
								itinerary.getPackages().get(pack).getSelectedHotel().getDisplayRoomCategory().setRatePlanCode(null);
								
								itinerary.getPackages().get(pack).setSelectedHotel(this.getModifiedHBSiHotel(itinerary,itinerary.getPackages().get(pack).getSelectedHotel()));
								
							}
						}
						}
					}
					if(itinerary.getMultiDestinationPackages()!=null && itinerary.getMultiDestinationPackages().size()>0)
					{
						for(int multiDestPack=0;multiDestPack<itinerary.getMultiDestinationPackages().size();multiDestPack++)
						{
							if(itinerary.getMultiDestinationPackages().get(multiDestPack)!=null)
							{
								for(int hbsiHotel=0;hbsiHotel<itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().size();hbsiHotel++)
								{
									if(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel)!=null 
										&& this.hbsiHotelDao.isHBSiHotel(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).getHotelCode())
									&& itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).getDisplayRoomCategory()!=null
									&& itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).getDisplayRoomCategory().getHbsiRates()==null
									)
									{
										itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().set(hbsiHotel, this.getModifiedHBSiHotel(itinerary, itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel)));
									}
								}
							}
						
						}
						
					}
					
					if(itinerary.getHotels()!=null && itinerary.getHotels().size()>0)
					{
						for(int hotelOnly=0;hotelOnly<itinerary.getHotels().size();hotelOnly++)
						{
							if(itinerary.getHotels().get(hotelOnly)!=null 
									&& this.hbsiHotelDao.isHBSiHotel(itinerary.getHotels().get(hotelOnly).getHotelCode())
									&&itinerary.getHotels().get(hotelOnly).getDisplayRoomCategory().getHbsiRates()==null)
							{
								itinerary.getHotels().set(hotelOnly, this.getModifiedHBSiHotel(itinerary, itinerary.getHotels().get(hotelOnly)));
							}
						}
						
					}
					
				}
				
				/**************WESB CODE FOR PACKAGE MODIFY ENDS*********/
				
				searchresponse.setItinerary(itinerary);
				
				return searchresponse;
			}
			else
			{
				return searchresponse;
			}
	}
		
	

	public ItinerarySearchResponse search(
			ItinerarySearchCriteria itinerarySearchCriteria) {
		return this.itinerarySearchDao.search(itinerarySearchCriteria);
	}
}
