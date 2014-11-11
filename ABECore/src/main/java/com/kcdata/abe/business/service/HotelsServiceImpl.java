/*
 * HotelsServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 26, 2009  nvittal	  
 * Sep 24, 2009	 hguntupa	  Refactored code to create HotelsRequest object
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import java.util.List;
import java.util.Map;
import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.response.AllPriceBreakUpResponse;
import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.data.dao.HBSiHotelDao;
import com.kcdata.abe.data.dao.HotelsDao;
import com.kcdata.abe.data.dao.WesbHotelDao;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.util.HotelConvertUtils;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Service class for retrieving hotels
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class HotelsServiceImpl extends ABEServiceBase implements HotelsService {

	ABELogger logger = ABELogger.getLogger(ABELogger.class);

	/**
	 * DAO class for retrieving SAP hotels
	 */
	private HotelsDao hotelsDao;
	
	/**
	 * DAO class for retrieving SAP hotels
	 */
	private WesbHotelDao wesbHotelDao;
	
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
	 * Method to retrieve hotels
	 * 
	 * @param searchCriteria
	 *            - Search criteria
	 * @return Hotels
	 * 
	 * @see
	 * @since
	 */

	public HotelsResponse retrieveHotels(SearchCriteria searchCriteria) {
		// Prepare hotel request
		HotelsResponse hotelsResponse = null;
		
		HotelsRequest hotelsRequest = searchCriteria.getHotelsRequest();
		List<String> hbsiSwitch = this.hbsiHotelDao.getHBSiSwitch();
		boolean isHBSI=false;
		
		/******************************************* WESB CODE FOR HOTEL ONLY *********************************************/
		
		if( hbsiSwitch!=null && hbsiSwitch.contains("TRUE") && this.isHotelOnly(hotelsRequest) ){
			Map<String,HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao.getHBSiDBData();
			
		
			
			/**********Convert Vendor Hotel Code to Hotel Code For Revise Room Category*******/
			
			Map<String,HBSiHotelInfo> hbsiHotelVendorCode = this.hbsiHotelDao.getHotelVendors();
			if(hotelsRequest!=null && hotelsRequest.getHotelOptions()!=null &&hotelsRequest.getHotelOptions().getHotelCode()!=null && hotelsRequest.getHotelOptions().getHotelCode()!="")
			{
				if(this.hbsiHotelDao.isHBSiHotelVendorCode(hotelsRequest.getHotelOptions().getHotelCode()))
				{
					HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(hotelsRequest.getHotelOptions().getHotelCode());
					hotelsRequest.getHotelOptions().setHotelCode(hbsiHotelInfo.getHotelId());
				}
			}
			/***************** Code for Checking HBSI Hotels ********/
			hotelsResponse = this.wesbHotelDao.retrieveWesbHotels(hotelsRequest,hbsiHotelList);
				if(hotelsResponse.getHotelList() !=null && hotelsResponse.getHotelList().size() >0){
				for(Hotel hotel : hotelsResponse.getHotelList()){
					isHBSI=this.hbsiHotelDao.isHBSiHotel(hotel.getDisplayRoomCategory().getHotelId()+"");
					if(isHBSI){
						hotel.setHBSI(isHBSI);
					}
				}
				}
		}
		else
		{
		hotelsResponse = this.hotelsDao.retrieveHotels(hotelsRequest);
			
		}
		
		
		return hotelsResponse;
	}
	/**
	 * Method to check whether its Hotel only
	 * @param hotelsRequest
	 * @return boolean
	 */
	public boolean isHotelOnly(HotelsRequest hotelsRequest){
		if( !hotelsRequest.isAirRequested() && !hotelsRequest.isVehicleRequested() && 
			!hotelsRequest.isPackageRequest() && !hotelsRequest.isMultiDestinationRequest() )
			return true;
		
		return false;
	}

	
	
		
	/**
	 * Method to retrieve the price break up of given hotel
	 * 
	 * @param hotel
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public AllPriceBreakUpResponse retrievePriceBreakUp(Hotel hotel) {
		
		//Price Break up for HBSi Hotel
		if(hotel!=null && hotel.getHotelCode()!=null && hotel.getHotelCode()!="" && this.hbsiHotelDao.isHBSiHotel(hotel.getHotelCode()))
		{
			return this.wesbHotelDao.retrievePriceBreakUp(hotel);
		}
		return this.hotelsDao.retrievePriceBreakUp(hotel);
	}

	/**
	 * @return the hotelsDao
	 */
	public HotelsDao getHotelsDao() {
		return hotelsDao;
	}

	/**
	 * @param hotelsDao
	 *            the hotelsDao to set
	 */
	public void setHotelsDao(HotelsDao hotelsDao) {
		this.hotelsDao = hotelsDao;
	}

	/* (non-Javadoc)
	 * @see com.kcdata.abe.business.service.HotelsService#retrieveHotelVendor()
	 */
	public HotelsResponse retrieveHotelVendor(List<Hotel> hotelList) {
		return hotelsDao.retrieveHotelVendor(hotelList);
	}
	
	/**
	 * @return the wesbHotelDao
	 */
	public WesbHotelDao getWesbHotelDao() {
		return wesbHotelDao;
	}

	/**
	 * @param wesbHotelDao the wesbHotelDao to set
	 */
	public void setWesbHotelDao(WesbHotelDao wesbHotelDao) {
		this.wesbHotelDao = wesbHotelDao;
	}
}