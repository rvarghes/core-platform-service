/*
 * BookingSearchServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 8, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import java.util.List;
import java.util.Map;

import com.kcdata.abe.application.command.ResyncBookingCommand;
import com.kcdata.abe.business.response.BookingSearchResponse;
import com.kcdata.abe.data.dao.BookingSearchDao;
import com.kcdata.abe.data.dao.HBSiHotelDao;
import com.kcdata.abe.data.dao.HotelsDao;
import com.kcdata.abe.data.dto.BookingSearchCriteria;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.RequestedDatesForAvailability;
import com.kcdata.abe.data.util.HotelConvertUtils;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Service implementation class for booking search
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class BookingSearchServiceImpl extends ABEServiceBase implements
		BookingSearchService {
	
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
	 * DAO for searching bookings
	 * 
	 * @see
	 * @since
	 */
	private BookingSearchDao bookingSearchDao;
	private HotelsDao hotelsDao;

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
	 * Method to search bookings
	 * 
	 * @param bookingSearchCriteria
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public BookingSearchResponse search(
			BookingSearchCriteria bookingSearchCriteria) {
		return this.bookingSearchDao.search(bookingSearchCriteria);
	}

	/**
	 * Method to retrieve a booking
	 * 
	 * @param bookingNo
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public BookingSearchResponse retrieveBooking(String bookingNo) {
		BookingSearchResponse bookingSearchResponse = this.bookingSearchDao.retrieveBooking(bookingNo);
		return updateBookingSearchResponse(bookingSearchResponse);
	}

	public BookingSearchResponse resyncBooking(ResyncBookingCommand resyncBookingCommand) {
		return this.bookingSearchDao.resyncBooking(resyncBookingCommand);
	}

	/**
	 * @param hotelsDao the hotelsDao to set
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
	
	/**
	 * 
	 * @param hotelList
	 */
	private void setRFADates(final Itinerary itinerary) {
		if ( null !=itinerary){
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
	}


	
	/**
	 * Update the BookSearhResponse object after being retrieved.
	 * @param bookingSearchResponse
	 * @return BookingSearchResponse
	 */
	private BookingSearchResponse updateBookingSearchResponse(BookingSearchResponse bookingSearchResponse){
		
		if(bookingSearchResponse != null && bookingSearchResponse.getItinerary()!=null)
		{
			
			Map<String,HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao.getHBSiDBData();
			if(bookingSearchResponse.getItinerary().getHotels()!=null && bookingSearchResponse.getItinerary().getHotels().size()>0)
			{
				for(int vendorHotel=0;vendorHotel<bookingSearchResponse.getItinerary().getHotels().size();vendorHotel++)
				{
					if(this.hbsiHotelDao.isHBSiHotel(bookingSearchResponse.getItinerary().getHotels().get(vendorHotel).getHotelCode()));
					{
						if(hbsiHotelList.containsKey(bookingSearchResponse.getItinerary().getHotels().get(vendorHotel).getHotelCode()))
						{
							HBSiHotelInfo hbsiHotelInfo = new HBSiHotelInfo();
							hbsiHotelInfo = hbsiHotelList.get(bookingSearchResponse.getItinerary().getHotels().get(vendorHotel).getHotelCode());
							bookingSearchResponse.getItinerary().getHotels().get(vendorHotel).setHotelCode(hbsiHotelInfo.getHotelVendorCode());
						}
					}
				}
			}
			bookingSearchResponse.setItinerary(HotelConvertUtils.encodeHotelDesc(bookingSearchResponse.getItinerary()));
			setRFADates(bookingSearchResponse.getItinerary());
		}
		
		return bookingSearchResponse;
		
	}

}
