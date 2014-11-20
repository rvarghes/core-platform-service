/*
 * ItineraryPricingServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 19, 2009  hguntupa
 * Jul 31, 2013  Khamed
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List;
import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.response.BookingSearchResponse;
import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.business.response.ItineraryPricingResponse;
import com.kcdata.abe.business.response.ServicesResponse;
import com.kcdata.abe.data.dao.BookingSearchDao;
import com.kcdata.abe.data.dao.HBSiHotelDao;
import com.kcdata.abe.data.dao.HBSiHotelsOnlyDao;
import com.kcdata.abe.data.dao.HotelsDao;
import com.kcdata.abe.data.dao.ItineraryPricingDao;
import com.kcdata.abe.data.dao.WesbHotelDao;
import com.kcdata.abe.data.dao.WesbItineraryPricingDao;
import com.kcdata.abe.data.dto.CarType;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Insurance;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.MultiDestinationPackage;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.RequestedDatesForAvailability;
import com.kcdata.abe.data.dto.Service;
import com.kcdata.abe.data.dto.ServiceGroup;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.data.util.HotelConvertUtils;
import com.kcdata.abe.data.util.ServicesConvertUtils;
import com.kcdata.abe.framework.dto.ABEDto;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * ItineraryPricingService implementation class
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ItineraryPricingServiceImpl extends ABEServiceBase implements
		ItineraryPricingService {

	private ItineraryPricingDao itineraryPricingDao;
	private WesbItineraryPricingDao wesbItineraryPricingDao;
	private HBSiHotelsOnlyDao hbsiHotelsOnly;
	private BookingSearchDao bookingSearchDao;
	
	
	/**
	 * @return the bookingSearchDao
	 */
	public BookingSearchDao getBookingSearchDao() {
		return bookingSearchDao;
	}

	/**
	 * @param bookingSearchDao
	 *            the bookingSearchDao to set
	 */
	public void setBookingSearchDao(BookingSearchDao bookingSearchDao) {
		this.bookingSearchDao = bookingSearchDao;
	}
	
	
	
	
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

	/**
	 * @return the wesbItineraryPricingDao
	 */
	public WesbItineraryPricingDao getWesbItineraryPricingDao() {
		return wesbItineraryPricingDao;
	}

	/**
	 * @param wesbItineraryPricingDao the wesbItineraryPricingDao to set
	 */
	public void setWesbItineraryPricingDao(
			WesbItineraryPricingDao wesbItineraryPricingDao) {
		this.wesbItineraryPricingDao = wesbItineraryPricingDao;
	}

	private HotelsDao hotelsDao;

	/**
	 * @return the itineraryPricingDao
	 */
	public ItineraryPricingDao getItineraryPricingDao() {
		return itineraryPricingDao;
	}

	/**
	 * @param itineraryPricingDao
	 *            the itineraryPricingDao to set
	 */
	public void setItineraryPricingDao(ItineraryPricingDao itineraryPricingDao) {
		this.itineraryPricingDao = itineraryPricingDao;
	}

	
	public boolean isRemoveHotel(Itinerary itinerary,BookingSearchResponse bookSearchResponse)
	{
		if(itinerary.getBookingNo()!=null && itinerary.getName()!=null && itinerary.getName().startsWith("CB"))
				{
			//BookingSearchResponse bookSearchResponse = this.bookingSearchDao.retrieveBooking(itinerary.getBookingNo());
			Itinerary bookingCommand = null;
			
			if(bookSearchResponse.getItinerary()!=null)
				bookingCommand=bookSearchResponse.getItinerary();
			
			
			if (bookingCommand.getHotels() != null
					&& itinerary.getHotels() != null
					&& (itinerary.getHotels()
							.size() < bookingCommand.getHotels().size() ) )
			{
				return true;
			}
				}
		return false;
	}
	
	
	public boolean isShopMore(Itinerary itinerary,String hotelCode,BookingSearchResponse bookSearchResponse)
	{
		if(itinerary.getBookingNo()!=null && itinerary.getName()!=null && itinerary.getName().startsWith("CB"))
		{
			//BookingSearchResponse bookSearchResponse = this.bookingSearchDao.retrieveBooking(itinerary.getBookingNo());
			Itinerary bookingCommand = null;
			
			if(bookSearchResponse.getItinerary()!=null)
				bookingCommand=bookSearchResponse.getItinerary();
			//Check for Shop more or Remove Hotel or Edit Passanger
			/*if (bookingCommand.getHotels() != null
						&& itinerary.getHotels() != null
						&& (itinerary.getHotels()
								.size() > bookingCommand.getHotels().size() ) )*/
				
				if (bookingCommand.getHotels() != null
						&& itinerary.getHotels() != null
						&& (itinerary.getHotels()
								.size() > bookingCommand.getHotels().size() ) )
				{
					return true;
				}
		}
		return false;
	}
	
	public boolean isSHopeMoreorRemoveorEditPassangerorAddorDeletePassanger(Itinerary itinerary,int h,String hotelCode,BookingSearchResponse bookSearchResponse)
	{
		
		
		if(itinerary.getBookingNo()!=null && itinerary.getName()!=null && itinerary.getName().startsWith("CB"))
		{
			//BookingSearchResponse bookSearchResponse = this.bookingSearchDao.retrieveBooking(itinerary.getBookingNo());
			Itinerary bookingCommand = null;
			
			if(bookSearchResponse.getItinerary()!=null)
				bookingCommand=bookSearchResponse.getItinerary();
			//Check for Shop more or Remove Hotel or Edit Passanger
			if (bookingCommand.getHotels() != null
						&& itinerary.getHotels() != null
						&& (bookingCommand.getHotels().size() > itinerary
								.getHotels().size() || itinerary.getHotels()
								.size() > bookingCommand.getHotels().size() ))
				{
					return false;
				}
			else if(hotelCode!=null && hotelCode!="")
			{
				//if index of hotel in bookingCommand and itinerary same
				if(bookingCommand.getHotels().get(h).getHotelCode().equalsIgnoreCase(hotelCode))
				{
					//compare size of the Passenger list size
					if(itinerary.getHotels().get(h).getOccupancy().getPassengers().size()!=bookingCommand.getHotels().get(h).getOccupancy().getPassengers().size())
					{
						return true;
					}
				}
				else 
				{
					for(int hotelIndex=0;hotelIndex<bookingCommand.getHotels().size();hotelIndex++)
					{
						if(bookingCommand.getHotels().get(hotelIndex).getHotelCode().equalsIgnoreCase(hotelCode))
						{
							if(bookingCommand.getHotels().get(hotelIndex).getOccupancy().getPassengers().size()!=itinerary.getHotels().get(h).getOccupancy().getPassengers().size())
							{
								return true;
							}
						}
					}
				}
			}
			
		}
		
		return false;
	}
	
	public boolean isCloneBooking(Itinerary itinerary,boolean hbsiStatus)
	{
		if(hbsiStatus==true && itinerary.getBookingLockDetails()!=null && itinerary.getBookingHeader()==null && itinerary.getBookingNo()==null)
		return true;
		
		return false;
	}
	
	
	public boolean isPackageCloneBooking(Itinerary itinerary) {
		if(itinerary.getBookingLockDetails()!=null && itinerary.getBookingHeader()==null && itinerary.getBookingNo()==null)
			return true;
		
			return false;
	}
	
	public int getHbsiRates(int duplicate,int hsiRateHotel,Itinerary itinerary)
	{
		if(itinerary.getHotels()!=null && itinerary.getHotels().size()>0)
		{
			if(itinerary.getHotels().get(hsiRateHotel).getDisplayRoomCategory()!=null && itinerary.getHotels().get(hsiRateHotel).getDisplayRoomCategory().getHbsiRates()==null)
			{
				return hsiRateHotel;
			}
			else if(itinerary.getHotels().get(duplicate).getDisplayRoomCategory()!=null && itinerary.getHotels().get(duplicate).getDisplayRoomCategory().getHbsiRates()==null)
			{
				return duplicate;
			}
				
			
		}
		return -1;
	}
	
	
	Itinerary populatePricingHBSi(Itinerary itinerary)
	{
	Map<String,HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao.getHBSiDBData();
	if(itinerary!=null && itinerary.getHotels()!=null && itinerary.getHotels().size()>0)
	{
		for(int i=0;i<itinerary.getHotels().size();i++)
		{
			if(hbsiHotelDao.isHBSiHotel(itinerary.getHotels().get(i).getHotelCode()))
					{
				Hotel hbsiHotel = itinerary.getHotels().get(i);
				
				
				if(hbsiHotel.getDisplayRoomCategory()==null) {
					hbsiHotel.setDisplayRoomCategory(itinerary.getHotels().get(0).getRoomCategories().get(0));
					hbsiHotel.getDisplayRoomCategory().setDisplayRoomPrice(itinerary.getHotels().get(0).getRoomCategories().get(0).getRoomPrices().get(0)); 
				}
				
				if(hbsiHotel.getDisplayRoomCategory().getHbsiRates()==null)
				{
					HotelsResponse hotelResponse = hbsiHotelsOnly.retrieveWesbHotels(itinerary, hbsiHotel, null, hbsiHotelList, "CP");
				  	//Start the implemention of AV3749/HBsi 52 emergency tab information for passgenger enhancement
					// Added the check to make sure there would be data in hotel list	
				  if (hotelResponse!=null && hotelResponse.getHotelList()!=null && hotelResponse.getHotelList().size()>0){
					Hotel hotel = hotelResponse.getHotelList().get(0);
					//fix for HBSI 173 cancel passenger
					if(hbsiHotel.getDisplayRoomCategory().getDisplayRoomPrice()!=null){
						hbsiHotel.getDisplayRoomCategory().getDisplayRoomPrice().setPaxBasePrices(hotel.getDisplayRoomCategory().getDisplayRoomPrice().getPaxBasePrices()); 
					}else{
						hbsiHotel.getDisplayRoomCategory().setDisplayRoomPrice(itinerary.getHotels().get(0).getRoomCategories().get(0).getRoomPrices().get(0));
						hbsiHotel.getDisplayRoomCategory().getDisplayRoomPrice().setPaxBasePrices(hotel.getDisplayRoomCategory().getDisplayRoomPrice().getPaxBasePrices());
					}
					hbsiHotel.getDisplayRoomCategory().setHbsiRates(hotel.getDisplayRoomCategory().getHbsiRates());
					hbsiHotel.getDisplayRoomCategory().setCancelPolicy(hotel.getDisplayRoomCategory().getCancelPolicy());
					
					
					for(int roomCat=0; roomCat<hotel.getRoomCategories().size(); roomCat++)
					{
						if (roomCat<hbsiHotel.getRoomCategories().size()) {
							hbsiHotel.getRoomCategories().get(roomCat).setHbsiRates(hotel.getRoomCategories().get(roomCat).getHbsiRates());
							hbsiHotel.getRoomCategories().get(roomCat).setCancelPolicy(hotel.getRoomCategories().get(roomCat).getCancelPolicy());
						
							for(int roomPrice=0; roomPrice<hotel.getRoomCategories().get(roomCat).getRoomPrices().size(); roomPrice++) {
								hbsiHotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setHotelCost(hotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getHotelCost());
								hbsiHotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setTransferCost(hotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getTransferCost());
								hbsiHotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setPaxBasePrices(hotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getPaxBasePrices());
							}
						}
					}
					//fix for changing roommate index out of bound
					if(hbsiHotel.getDisplayRoomCategory().getRoomPrices() == null||hbsiHotel.getDisplayRoomCategory().getRoomPrices().size()<1) {
						hbsiHotel.getDisplayRoomCategory().setRoomPrices(hotel.getDisplayRoomCategory().getRoomPrices());
					}
					for(int dispRoomPrice=0; dispRoomPrice<hotel.getDisplayRoomCategory().getRoomPrices().size(); dispRoomPrice++) {
						if(hbsiHotel.getDisplayRoomCategory().getRoomPrices() != null) {
							hbsiHotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).setHotelCost(hotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).getHotelCost());
							hbsiHotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).setTransferCost(hotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).getTransferCost());
							hbsiHotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).setPaxBasePrices(hotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).getPaxBasePrices());
						}
						
					}
				}
			}
			//End of the if (Checking hotellist can't zero)
			//End of the implemention of AV3749/HBsi 52 emergency tab information for passgenger enhancement
					itinerary.getHotels().set(i, hbsiHotel);
				
					}
		}
	} else if (itinerary != null && itinerary.getPackages() != null && itinerary.getPackages().size() > 0){
		for (int i=0; i<itinerary.getPackages().size(); i++) {
			Package itineraryPackage = itinerary.getPackages().get(i);
			if (itineraryPackage.getSelectedHotel() != null && hbsiHotelDao.isHBSiHotel(itineraryPackage.getSelectedHotel().getHotelCode())) {

				Hotel hbsiHotel = itinerary.getPackages().get(i).getSelectedHotel();
				if(hbsiHotel.getDisplayRoomCategory()!=null && hbsiHotel.getDisplayRoomCategory().getHbsiRates()==null)
				{
					HotelsResponse hotelResponse = hbsiHotelsOnly.retrieveWesbHotels(itinerary, hbsiHotel, itinerary.getSearchCriteria().getHotelsRequest(), hbsiHotelList, "CP");
					Hotel hotel = hotelResponse.getHotelList().get(0);
					
					hbsiHotel.getDisplayRoomCategory().setHbsiRates(hotel.getDisplayRoomCategory().getHbsiRates());
					hbsiHotel.getDisplayRoomCategory().setCancelPolicy(hotel.getDisplayRoomCategory().getCancelPolicy());
					
					
					for(int roomCat=0; roomCat<hotel.getRoomCategories().size(); roomCat++)
					{
						hbsiHotel.getRoomCategories().get(roomCat).setHbsiRates(hotel.getRoomCategories().get(roomCat).getHbsiRates());
						hbsiHotel.getRoomCategories().get(roomCat).setCancelPolicy(hotel.getRoomCategories().get(roomCat).getCancelPolicy());
						
						for(int roomPrice=0; roomPrice<hotel.getRoomCategories().get(roomCat).getRoomPrices().size(); roomPrice++) {
							hbsiHotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setHotelCost(hotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getHotelCost());
							hbsiHotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setTransferCost(hotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getTransferCost());
						}
					}
					
					for(int dispRoomPrice=0; dispRoomPrice<hotel.getDisplayRoomCategory().getRoomPrices().size(); dispRoomPrice++) {
						if(hbsiHotel.getDisplayRoomCategory().getRoomPrices() != null) {
							hbsiHotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).setHotelCost(hotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).getHotelCost());
							hbsiHotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).setTransferCost(hotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).getTransferCost());
						}
					}
				}
					itinerary.getPackages().get(i).setSelectedHotel(hbsiHotel);
				
					
			}
		}
	} else if (itinerary != null && itinerary.getMultiDestinationPackages() != null && itinerary.getMultiDestinationPackages().size() > 0) {
		for (int i=0; i<itinerary.getMultiDestinationPackages().size(); i++) {
			MultiDestinationPackage multiDestPackage = itinerary.getMultiDestinationPackages().get(i);
			if(multiDestPackage != null && multiDestPackage.getSelectedHotels() != null && multiDestPackage.getSelectedHotels().size() > 0) {
				
				for(int k=0; k<multiDestPackage.getSelectedHotels().size(); k++) {
					Hotel hbsiHotel = multiDestPackage.getSelectedHotels().get(k);
					if(hbsiHotel.getDisplayRoomCategory()!=null && hbsiHotel.getDisplayRoomCategory().getHbsiRates()==null)
					{
						HotelsResponse hotelResponse = hbsiHotelsOnly.retrieveWesbHotels(itinerary, hbsiHotel, itinerary.getSearchCriteria().getHotelsRequest(), hbsiHotelList, "CP");
						Hotel hotel = hotelResponse.getHotelList().get(0);
						
						hbsiHotel.getDisplayRoomCategory().setHbsiRates(hotel.getDisplayRoomCategory().getHbsiRates());
						hbsiHotel.getDisplayRoomCategory().setCancelPolicy(hotel.getDisplayRoomCategory().getCancelPolicy());
						
						
						for(int roomCat=0; roomCat<hotel.getRoomCategories().size(); roomCat++)
						{
							hbsiHotel.getRoomCategories().get(roomCat).setHbsiRates(hotel.getRoomCategories().get(roomCat).getHbsiRates());
							hbsiHotel.getRoomCategories().get(roomCat).setCancelPolicy(hotel.getRoomCategories().get(roomCat).getCancelPolicy());
							
							for(int roomPrice=0; roomPrice<hotel.getRoomCategories().get(roomCat).getRoomPrices().size(); roomPrice++) {
								hbsiHotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setHotelCost(hotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getHotelCost());
								hbsiHotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setTransferCost(hotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getTransferCost());
							}
						}
						
						for(int dispRoomPrice=0; dispRoomPrice<hotel.getDisplayRoomCategory().getRoomPrices().size(); dispRoomPrice++) {
							if(hbsiHotel.getDisplayRoomCategory().getRoomPrices() != null) {
								hbsiHotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).setHotelCost(hotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).getHotelCost());
								hbsiHotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).setTransferCost(hotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).getTransferCost());
							}
						}
					}
					itinerary.getMultiDestinationPackages().get(i).getSelectedHotels().set(k, hbsiHotel);
				}
				
			}
		}
	}
	
	return itinerary;
}
	
	
	/**
	 * Method to price the itinerary
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public ItineraryPricingResponse priceItinerary(Itinerary itinerary) {
		
		boolean customer=this.getApplicationContextFactory().getApplicationContext().getRequestContext().getIMApplicationInfo().getType().isCustomer();
		if(customer && !hotelsDao.checkisStatusValid(itinerary)){ 
			final ItineraryPricingResponse itineraryPricingResponse = new ItineraryPricingResponse();
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("RETRIEVE_HOTEL_AVAILABILITY_ERROR");
			businessError.setErrorDescription(this.getMessageSource().getMessage("RETRIEVE_HOTEL_AVAILABILITY_ERROR", null, null));
			itineraryPricingResponse.saveBusinessError(businessError);
			return itineraryPricingResponse;
		}	
			
		ItineraryPricingResponse itineraryPricingResponse = null;
		
		/******************************************* WESB CODE FOR HOTEL ONLY *********************************************/
		
		Map<String,HBSiHotelInfo> hbsiHotelVendorCode = this.hbsiHotelDao.getHotelVendors();
		
		// convert hotel code as per vendorCOdeformat
		HotelConvertUtils.formatHotelCode(itinerary, hbsiHotelDao);
		HotelConvertUtils.decodeHotelDesc(itinerary);

		
		
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
			//haris change here
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
						if(itinerary.getMultiDestinationPackages().get(multiDestPack)!=null && itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels()!=null)
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
		
		
		List<String> hbsiSwitchList = this.hbsiHotelDao.getHBSiSwitch();
		if(hbsiSwitchList!=null && hbsiSwitchList.contains("TRUE")&& (this.isHotelOnly(itinerary) || cancelHotelBooking(itinerary)))
		{
			
			Map<String,HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao.getHBSiDBData();
			boolean isHBSi =false;
			boolean hbsiStatus = false;
			BookingSearchResponse bookSearchResponse = this.bookingSearchDao.retrieveBooking(itinerary.getBookingNo());
			
			if(itinerary.getHotels()!=null)
			{
				isHBSi = this.hbsiHotelDao.isHBSiHotel(itinerary.getHotels().get(0).getHotelCode());
				
				//fetch only HBSi hotels
				for(int h=0;h<itinerary.getHotels().size();h++)
				{
					hbsiStatus = this.hbsiHotelDao.isHBSiHotel(itinerary.getHotels().get(h).getHotelCode());
					String hotelCode=itinerary.getHotels().get(h).getHotelCode();
					
					
					if(hbsiStatus==true && itinerary.getName()!=null &&itinerary.getName().startsWith("CB") && isSHopeMoreorRemoveorEditPassangerorAddorDeletePassanger(itinerary,h,hotelCode,bookSearchResponse))
					{
						itinerary.getSearchCriteria().setOccupancy(itinerary.getHotels().get(h).getOccupancy());
						
						
						HotelsResponse hotelResponse = this.hbsiHotelsOnly.retrieveWesbHotels(itinerary,itinerary.getHotels().get(h),itinerary.getSearchCriteria().getHotelsRequest(),hbsiHotelList,"CP");
						
						if(hotelResponse!=null && hotelResponse.getHotelList().size()>0)
						{
							
							for(int roomCat=0;roomCat<itinerary.getHotels().get(h).getRoomCategories().size();roomCat++)
							{
								itinerary.getHotels().get(h).getRoomCategories().get(roomCat).setHbsiRates(hotelResponse.getHotelList().get(0).getRoomCategories().get(roomCat).getHbsiRates());	
								for(int roomPrice=0;roomPrice<itinerary.getHotels().get(h).getRoomCategories().get(roomCat).getRoomPrices().size();roomPrice++)
								{
									itinerary.getHotels().get(h).getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setPaxBasePrices(hotelResponse.getHotelList().get(0).
											getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getPaxBasePrices());
								}
							}
							
							//set the PaxBasePrices in displayRoomCategory based on roomCategoryId in displayRoomCategory 
							for(int roomCat=0;roomCat<itinerary.getHotels().get(h).getRoomCategories().size();roomCat++)
							{
								if(itinerary.getHotels().get(h).getDisplayRoomCategory().getRoomCategoryId()==hotelResponse.getHotelList().get(0).getRoomCategories().get(roomCat).getRoomCategoryId())
								{
									itinerary.getHotels().get(h).getDisplayRoomCategory().setHbsiRates(hotelResponse.getHotelList().get(0).getRoomCategories().get(roomCat).getHbsiRates());
									itinerary.getHotels().get(h).getDisplayRoomCategory().getDisplayRoomPrice().setPaxBasePrices(hotelResponse.getHotelList().get(0).getRoomCategories().get(roomCat).getRoomPrices().get(0).getPaxBasePrices());
								}
							}
							
							
							
							for(int selectedRoom=0;selectedRoom<itinerary.getHotels().get(h).getSelectedRooms().size();selectedRoom++)
							{
								itinerary.getHotels().get(h).getSelectedRooms().get(selectedRoom).setPaxBasePrices(hotelResponse.getHotelList().get(0).
										getRoomCategories().get(0).getRoomPrices().get(0).getPaxBasePrices());
							}
							
						}

						

					}
					else if(isCloneBooking(itinerary,hbsiStatus))
					{
						//todo - >itinerary.getSearchCriteria().getHotelsRequest() is useless in below method parameter causing nullpointer
						//because no one is using this object in method further and it should be removed when needed -- added by haris 
						HotelsResponse hotelResponse=null;
						if(itinerary.getSearchCriteria()!=null && itinerary.getSearchCriteria().getHotelsRequest()!=null)
							hotelResponse = this.hbsiHotelsOnly.retrieveWesbHotels(itinerary,itinerary.getHotels().get(h),itinerary.getSearchCriteria().getHotelsRequest(),hbsiHotelList,"CP");
						else
							hotelResponse = this.hbsiHotelsOnly.retrieveWesbHotels(itinerary,itinerary.getHotels().get(h),new HotelsRequest(),hbsiHotelList,"CP");
						if(hotelResponse!=null && hotelResponse.getHotelList().size()>0)
						{
							
							for(int roomCat=0;roomCat<itinerary.getHotels().get(h).getRoomCategories().size();roomCat++)
							{
								itinerary.getHotels().get(h).getRoomCategories().get(roomCat).setHbsiRates(hotelResponse.getHotelList().get(0).getRoomCategories().get(roomCat).getHbsiRates());
								for(int roomPrice=0;roomPrice<itinerary.getHotels().get(h).getRoomCategories().get(roomCat).getRoomPrices().size();roomPrice++)
								{
									itinerary.getHotels().get(h).getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setPaxBasePrices(hotelResponse.getHotelList().get(0).
											getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getPaxBasePrices());
								}
							}
							
							//set the PaxBasePrices in displayRoomCategory based on roomCategoryId in displayRoomCategory 
							for(int roomCat=0;roomCat<itinerary.getHotels().get(h).getRoomCategories().size();roomCat++)
							{
								if(itinerary.getHotels().get(h).getDisplayRoomCategory().getRoomCategoryId()==hotelResponse.getHotelList().get(0).getRoomCategories().get(roomCat).getRoomCategoryId())
								{
									itinerary.getHotels().get(h).getDisplayRoomCategory().setHbsiRates(hotelResponse.getHotelList().get(0).getRoomCategories().get(roomCat).getHbsiRates());
									itinerary.getHotels().get(h).getDisplayRoomCategory().getDisplayRoomPrice().setPaxBasePrices(hotelResponse.getHotelList().get(0).getRoomCategories().get(roomCat).getRoomPrices().get(0).getPaxBasePrices());
								}
							}
							
							
							
							for(int selectedRoom=0;selectedRoom<itinerary.getHotels().get(h).getSelectedRooms().size();selectedRoom++)
							{
								itinerary.getHotels().get(h).getSelectedRooms().get(selectedRoom).setPaxBasePrices(hotelResponse.getHotelList().get(0).
										getRoomCategories().get(0).getRoomPrices().get(0).getPaxBasePrices());
							}
							
						}
						
						
					}
					//set the HBSiRates if user adds same hotel during change book
					else if(isShopMore(itinerary,hotelCode,bookSearchResponse))
					{
						boolean isHbsi=false;
						for(int hsiRateHotel=0;hsiRateHotel<itinerary.getHotels().size();hsiRateHotel++)
						{
							isHbsi = this.hbsiHotelDao.isHBSiHotel(itinerary.getHotels().get(hsiRateHotel).getHotelCode());
							String hbsiHotelCode=itinerary.getHotels().get(hsiRateHotel).getHotelCode();
							
							if(isHbsi==true && itinerary.getHotels().get(hsiRateHotel).getRoomCategories().get(0).getHbsiRates() == null)
							{
								for(int duplicate=0;duplicate<itinerary.getHotels().size();duplicate++)
								{
									if(hotelCode.equalsIgnoreCase(itinerary.getHotels().get(duplicate).getHotelCode()) && duplicate!=hsiRateHotel)
									{
										int value = getHbsiRates(duplicate,hsiRateHotel,itinerary);
										if(value!=-1)
										{
										HotelsResponse hotelResponseHbsirate = this.hbsiHotelsOnly.retrieveWesbHotels(itinerary,itinerary.getHotels().get(hsiRateHotel),itinerary.getSearchCriteria().getHotelsRequest(),hbsiHotelList,"CP");
										
										if(hotelResponseHbsirate!=null && hotelResponseHbsirate.getHotelList()!=null && hotelResponseHbsirate.getHotelList().size()>0)
										{
											
											for(int roomCat=0;roomCat<itinerary.getHotels().get(value).getRoomCategories().size();roomCat++)
											{
												itinerary.getHotels().get(value).getRoomCategories().get(roomCat).setHbsiRates(hotelResponseHbsirate.getHotelList().get(0).getRoomCategories().get(roomCat).getHbsiRates());	
												
											}
											
											//set the PaxBasePrices in displayRoomCategory based on roomCategoryId in displayRoomCategory 
											for(int roomCat=0;roomCat<itinerary.getHotels().get(value).getRoomCategories().size();roomCat++)
											{
												if(itinerary.getHotels().get(value).getDisplayRoomCategory().getRoomCategoryId()==hotelResponseHbsirate.getHotelList().get(0).getRoomCategories().get(roomCat).getRoomCategoryId())
												{
													itinerary.getHotels().get(value).getDisplayRoomCategory().setHbsiRates(hotelResponseHbsirate.getHotelList().get(0).getRoomCategories().get(roomCat).getHbsiRates());
												
												}
											}
										}//end of if
										}
									}
								}
							}
							
							
						}
						
					}
					if(isRemoveHotel(itinerary,bookSearchResponse))
					{
						if(itinerary!=null && itinerary.getHotels()!=null && itinerary.getHotels().size()>0 && itinerary.getName()!=null && itinerary.getName()!="" && itinerary.getName().startsWith("CB"))
						{
								for(int remove=0;remove<itinerary.getHotels().size();remove++)
								{
									boolean hbsiHotel=this.hbsiHotelDao.isHBSiHotel(itinerary.getHotels().get(remove).getHotelCode());
									
									if(hbsiHotel==true && itinerary.getHotels().get(remove).getRoomCategories().get(0).getHbsiRates()==null)
									{
										HotelsResponse hotelResponseHbsirate = this.hbsiHotelsOnly.retrieveWesbHotels(itinerary,itinerary.getHotels().get(remove),itinerary.getSearchCriteria().getHotelsRequest(),hbsiHotelList,"CP");
										
										
										if(hotelResponseHbsirate!=null && hotelResponseHbsirate.getHotelList().size()>0)
										{
											
											for(int roomCat=0;roomCat<itinerary.getHotels().get(remove).getRoomCategories().size();roomCat++)
											{
												itinerary.getHotels().get(remove).getRoomCategories().get(roomCat).setHbsiRates(hotelResponseHbsirate.getHotelList().get(0).getRoomCategories().get(roomCat).getHbsiRates());	
												
											}
											
											//set the PaxBasePrices in displayRoomCategory based on roomCategoryId in displayRoomCategory 
											for(int roomCat=0;roomCat<itinerary.getHotels().get(remove).getRoomCategories().size();roomCat++)
											{
												if(itinerary.getHotels().get(remove).getDisplayRoomCategory().getRoomCategoryId()==hotelResponseHbsirate.getHotelList().get(0).getRoomCategories().get(roomCat).getRoomCategoryId())
												{
													itinerary.getHotels().get(remove).getDisplayRoomCategory().setHbsiRates(hotelResponseHbsirate.getHotelList().get(0).getRoomCategories().get(roomCat).getHbsiRates());
												
												}
											}
										}
									}
									
								}
						}
					}
					
				}
				
			}
			else
			{
				isHBSi = this.isDeletedListHasHBSiHotel(itinerary);
			}
			
			itinerary = populatePricingHBSi(itinerary);	
					
			
			itineraryPricingResponse = wesbItineraryPricingDao.hotelPriceItinerary(itinerary,isHBSi,hbsiHotelList);
			
		}
	
		else
		{
			//Package Modify For HBSi hotels
			/***************WESB CODE FOR PACKAGE MODIFY**************/
			
			if((itinerary!=null && itinerary.getName()!=null && itinerary.getName()!="" && itinerary.getName().startsWith("CB") && itinerary.getBookingNo()!=null) || isPackageCloneBooking(itinerary))
			{
				if(itinerary.getPackages()!=null && itinerary.getPackages().size()>0)
				{
					for(int pack=0;pack<itinerary.getPackages().size();pack++)
					{
					if(itinerary.getPackages().get(pack)!=null && itinerary.getPackages().get(pack).getSelectedHotel()!=null && this.hbsiHotelDao.isHBSiHotel(itinerary.getPackages().get(pack).getSelectedHotel().getHotelCode()))
					{
						if(itinerary.getPackages().get(pack).getSelectedHotel().getDisplayRoomCategory()!=null && itinerary.getPackages().get(pack).getSelectedHotel().getDisplayRoomCategory().getHbsiRates()==null)
						{
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
			
			itineraryPricingResponse = itineraryPricingDao.priceItinerary(itinerary);
			
		}
		
		if( itineraryPricingResponse != null ){
			HotelConvertUtils.encodeHotelDesc(itineraryPricingResponse.getItinerary());
			setRFADates(itineraryPricingResponse.getItinerary());
		}
		
		
		/* Convert HotelCode to Vendor code for HBSi hotels for UI*/

		if(itineraryPricingResponse != null && itineraryPricingResponse.getItinerary()!=null)
		{
			
			Map<String,HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao.getHBSiDBData();
			if(itineraryPricingResponse.getItinerary().getHotels()!=null && itineraryPricingResponse.getItinerary().getHotels().size()>0)
			{
				for(int vendorHotel=0;vendorHotel<itineraryPricingResponse.getItinerary().getHotels().size();vendorHotel++)
				{
					if(this.hbsiHotelDao.isHBSiHotel(itineraryPricingResponse.getItinerary().getHotels().get(vendorHotel).getHotelCode()));
					{
						if(hbsiHotelList.containsKey(itineraryPricingResponse.getItinerary().getHotels().get(vendorHotel).getHotelCode()))
						{
							HBSiHotelInfo hbsiHotelInfo = new HBSiHotelInfo();
							hbsiHotelInfo = hbsiHotelList.get(itineraryPricingResponse.getItinerary().getHotels().get(vendorHotel).getHotelCode());
							itineraryPricingResponse.getItinerary().getHotels().get(vendorHotel).setHotelCode(hbsiHotelInfo.getHotelVendorCode());
						}
					}
				}
			}
			
			if(itineraryPricingResponse.getItinerary().getPackages()!=null &&itineraryPricingResponse.getItinerary().getPackages().size()>0 )
			{
				for(int vendorHotel=0;vendorHotel<itineraryPricingResponse.getItinerary().getPackages().size();vendorHotel++)
				{
					if(itineraryPricingResponse.getItinerary().getPackages().get(vendorHotel).getSelectedHotel()!=null && this.hbsiHotelDao.isHBSiHotel(itineraryPricingResponse.getItinerary().getPackages().get(vendorHotel).getSelectedHotel().getHotelCode()))
					{
						//chk for null itineraryPricingResponse.getItinerary().getPackages().get(vendorHotel).getSelectedHotel()
							if(hbsiHotelList.containsKey(itineraryPricingResponse.getItinerary().getPackages().get(vendorHotel).getSelectedHotel().getHotelCode()))
							{
								HBSiHotelInfo hbsiHotelInfo = new HBSiHotelInfo();
								hbsiHotelInfo = hbsiHotelList.get(itineraryPricingResponse.getItinerary().getPackages().get(vendorHotel).getSelectedHotel().getHotelCode());
								itineraryPricingResponse.getItinerary().getPackages().get(vendorHotel).getSelectedHotel().setHotelCode(hbsiHotelInfo.getHotelVendorCode());
						}
					}
				}
			}
			
			
			if(itineraryPricingResponse.getItinerary().getMultiDestinationPackages()!=null && itineraryPricingResponse.getItinerary().getMultiDestinationPackages().size()>0)
			{
				for(int vendorHotel=0;vendorHotel<itineraryPricingResponse.getItinerary().getMultiDestinationPackages().size();vendorHotel++)
				{
					if(itineraryPricingResponse.getItinerary().getMultiDestinationPackages().get(vendorHotel)!=null &&itineraryPricingResponse.getItinerary().getMultiDestinationPackages().get(vendorHotel).getSelectedHotels()!=null && itineraryPricingResponse.getItinerary().getMultiDestinationPackages().get(vendorHotel).getSelectedHotels().size()>0)
					{
						for(int multiDestHotel=0;multiDestHotel<itineraryPricingResponse.getItinerary().getMultiDestinationPackages().get(vendorHotel).getSelectedHotels().size();multiDestHotel++)
						{
							if(itineraryPricingResponse.getItinerary().getMultiDestinationPackages().get(vendorHotel).getSelectedHotels().get(multiDestHotel)!=null && this.hbsiHotelDao.isHBSiHotel(itineraryPricingResponse.getItinerary().getMultiDestinationPackages().get(vendorHotel).getSelectedHotels().get(multiDestHotel).getHotelCode()))
							{
								if(hbsiHotelList.containsKey(itineraryPricingResponse.getItinerary().getMultiDestinationPackages().get(vendorHotel).getSelectedHotels().get(multiDestHotel).getHotelCode()))
								{
									HBSiHotelInfo hbsiHotelInfo = new HBSiHotelInfo();
									hbsiHotelInfo = hbsiHotelList.get(itineraryPricingResponse.getItinerary().getMultiDestinationPackages().get(vendorHotel).getSelectedHotels().get(multiDestHotel).getHotelCode());
									itineraryPricingResponse.getItinerary().getMultiDestinationPackages().get(vendorHotel).getSelectedHotels().get(multiDestHotel).setHotelCode(hbsiHotelInfo.getHotelVendorCode());
								}
							}
						}
					}
				}
				
			}
		}
		
		
		
		
	
		return itineraryPricingResponse;
		
	}
	
		
	public Hotel getModifiedHBSiHotel(Itinerary itinerary,Hotel hotelDTO)
	{
		Map<String,HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao.getHBSiDBData();
		HotelsResponse hotelResponse = this.hbsiHotelsOnly.retrieveWesbHotels(itinerary, hotelDTO, null, hbsiHotelList, "CP");
	
		if(hotelResponse!=null && hotelResponse.getHotelList()!=null && hotelResponse.getHotelList().size()>0)
		{
			//Start the fix of HBSI 52 phase 1
			Hotel modifiedHbsiHotel = hotelResponse.getHotelList().get(0);
			// End the fix of HBSi 52 phase 1
			//Populate the room catgories with roomType Description,Meal Plan ,Hbsi rates and Pax Base prices for HBSi hotel
			if(hotelDTO.getSelectedRooms()!=null && hotelResponse.getHotelList().get(0)!=null && hotelResponse.getHotelList().get(0).getRoomCategories()!=null && hotelResponse.getHotelList().get(0).getRoomCategories().size()>0)
			{
				
					for(int hbsiRoomCat=0;hbsiRoomCat<modifiedHbsiHotel.getRoomCategories().size();hbsiRoomCat++)
					{
						if(hotelDTO.getDisplayRoomCategory().getRatePlanCode().equalsIgnoreCase(modifiedHbsiHotel.getRoomCategories().get(hbsiRoomCat).getRatePlanCode()))
						{
							for(int roomCat=0;roomCat<hotelDTO.getRoomCategories().size();roomCat++)
							{
								if(hotelDTO.getRoomCategories().get(roomCat).getRatePlanCode().equalsIgnoreCase(hotelDTO.getDisplayRoomCategory().getRatePlanCode()))
								{
									hotelDTO.getRoomCategories().get(roomCat).getRoomPrices().get(0).setPaxBasePrices(modifiedHbsiHotel.getRoomCategories().get(hbsiRoomCat).getRoomPrices().get(0).getPaxBasePrices());
									hotelDTO.getRoomCategories().get(roomCat).setHbsiRates(modifiedHbsiHotel.getRoomCategories().get(hbsiRoomCat).getHbsiRates());
									hotelDTO.getRoomCategories().get(roomCat).setRoomTypeDescription(modifiedHbsiHotel.getRoomCategories().get(hbsiRoomCat).getRoomTypeDescription());
									hotelDTO.getRoomCategories().get(roomCat).setRoomTypeCode(modifiedHbsiHotel.getRoomCategories().get(hbsiRoomCat).getRoomTypeCode());
									hotelDTO.getRoomCategories().get(roomCat).setMealPlanType(modifiedHbsiHotel.getRoomCategories().get(hbsiRoomCat).getMealPlanType());
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
					if(hotelDTO.getDisplayRoomCategory().getRatePlanCode().equalsIgnoreCase(modifiedHbsiHotel.getRoomCategories().get(modifiedHbsi).getRatePlanCode()))
					{
						hotelDTO.getDisplayRoomCategory().setHbsiRates(modifiedHbsiHotel.getRoomCategories().get(modifiedHbsi).getHbsiRates());
						hotelDTO.getDisplayRoomCategory().getDisplayRoomPrice().setPaxBasePrices(modifiedHbsiHotel.getRoomCategories().get(modifiedHbsi).getRoomPrices().get(0).getPaxBasePrices());
						hotelDTO.getDisplayRoomCategory().setRoomTypeDescription(modifiedHbsiHotel.getRoomCategories().get(modifiedHbsi).getRoomTypeDescription());
						hotelDTO.getDisplayRoomCategory().setRoomTypeCode(modifiedHbsiHotel.getRoomCategories().get(modifiedHbsi).getRoomTypeCode());
						hotelDTO.getDisplayRoomCategory().setMealPlanType(modifiedHbsiHotel.getRoomCategories().get(modifiedHbsi).getMealPlanType());
						
					}
				}
			}
			
			if(hotelDTO.getSelectedRooms()!=null)
			{
				for(int selctedRoom=0;selctedRoom<hotelDTO.getSelectedRooms().size();selctedRoom++)
				{
				/*for(int selectedRoomCat=0;selectedRoomCat<modifiedHbsiHotel.getSelectedRooms().size();selectedRoomCat++)
				{
					if(hotelDTO.getSelectedRooms().get(selctedRoom).getRoomCategoryId()==modifiedHbsiHotel.getSelectedRooms().get(selctedRoom).getRoomCategoryId())
					{
//						hotelDTO.getSelectedRooms().get(selctedRoom).setPaxBasePrices(modifiedHbsiHotel.getRoomCategories().get(0).getRoomPrices().get(0).getPaxBasePrices());
					}
					
				}*/
					hotelDTO.getSelectedRooms().get(selctedRoom).setPaxBasePrices(modifiedHbsiHotel.getRoomCategories().get(0).getRoomPrices().get(0).getPaxBasePrices());
				}
			}
			
		}
		
		return hotelDTO;
	}
	
	
	
		
	/**
	 * Method to check whether DeletedList has HBSi hotel or what
	 * @param itinerary
	 * @return
	 */
	public boolean isDeletedListHasHBSiHotel(Itinerary itinerary)
	{
		boolean isHBSi=false;
		if(itinerary.getDeletedList()!=null)
		{
			List<ABEDto> deletedList =itinerary.getDeletedList();
			for (ABEDto object : deletedList) 
			{
				if(object instanceof Hotel)
				{
					 Hotel hotel = (Hotel)object;
					if(hotel!=null && hotel.getHotelCode()!=null && hotel.getHotelCode()!="")
						
						isHBSi= this.hbsiHotelDao.isHBSiHotelVendorCode(hotel.getHotelCode());
						if(isHBSi ==false){
							isHBSi= this.hbsiHotelDao.isHBSiHotel(hotel.getHotelCode());
							hotel.setHBSI(isHBSi);
							
						}
						hotel.setHBSI(isHBSi);
						
				}
				
			}
		}
		
		return isHBSi;
	}
	
	
	/**
	 * Method to check for Hotel Only during cancel request. 
	 * @param itinerary
	 * @return
	 */
	public boolean cancelHotelBooking(Itinerary itinerary)
	{
		if(itinerary.getDeletedList()!=null)
		{
			List<ABEDto> deletedList =itinerary.getDeletedList();
			for (ABEDto object : deletedList) 
			{
				if(object instanceof TripFlight)
				{
					return false;
				}
				if(object instanceof Vehicle)
				{
					return false;
				}
				if(object instanceof Package)
				{
					return false;
				}
				if(object instanceof MultiDestinationPackage)
				{
					return false;
				}
				if(object instanceof Hotel && itinerary.getFlights()==null && itinerary.getVehicles()==null)
				{
					return true;
				}
				
			}
		}
		return false;
	}
	/**
	 * Method to check whether Hotel Only
	 * @param itinerary
	 * @return boolean
	 */
	public boolean isHotelOnly(Itinerary itinerary){
		
		boolean isHotelOnly =  false;
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
//		System.out.println("isHotelOnly " + isHotelOnly);
		return isHotelOnly;
	}
	

	/**
	 * 
	 * @param hotelList
	 */
	private void setRFADates(final Itinerary itinerary) {

		if ((null != itinerary.getHotels())
				&& (!itinerary.getHotels().isEmpty())) {
			for (final Hotel hotel : itinerary.getHotels()) {

				List<RequestedDatesForAvailability> datesForAvailabilities = hotelsDao
						.getRequestedDatesForAvailability(hotel);
				hotel.setRequestedDatesForAvailabilities(datesForAvailabilities);
			}
		}

		if((null !=itinerary.getPackages()) && (!itinerary.getPackages().isEmpty())){
			for (final com.kcdata.abe.data.dto.Package pkg : itinerary.getPackages()) {
				
				final Hotel hotel = pkg.getSelectedHotel();
				if(null != hotel){
					List<RequestedDatesForAvailability> datesForAvailabilities = hotelsDao
					.getRequestedDatesForAvailability(hotel);
					hotel.setRequestedDatesForAvailabilities(datesForAvailabilities);
				}
			}
			
		}
	}

	/**
	 * @param hotelsDao
	 *            the hotelsDao to set
	 */
	public void setHotelsDao(HotelsDao hotelsDao) {
		this.hotelsDao = hotelsDao;
	}

	/**
	 * @return the hotelsDao
	 */
	public HotelsDao getHotelsDao() {
		return hotelsDao;
	}

}
