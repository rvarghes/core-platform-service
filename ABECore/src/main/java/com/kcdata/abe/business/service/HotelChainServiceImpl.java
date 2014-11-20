/*
 * HotelChainServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Nov,09 2010  kmadugul
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import java.util.Collections;
import java.util.List;

import com.kcdata.abe.business.response.HotelChainResponse;
import com.kcdata.abe.data.dao.HBSiHotelDao;
import com.kcdata.abe.data.dao.HotelChainDao;
import com.kcdata.abe.data.dto.HotelChain;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Service implementation class for retrieving hotel chains
 * 
 * @author kmadugul
 * @version
 * 
 * @see
 * @since
 */
public class HotelChainServiceImpl extends ABEServiceBase implements
		HotelChainService {

	/**
	 * DAO class for retrieving hotel chains
	 */
	private HotelChainDao hotelChainDao;

	/**
	 * @return the hotel chains Dao
	 */
	public HotelChainDao getHotelChainDao() {
		return hotelChainDao;
	}

	/**
	 * @param hotel chains Dao
	 *            the hotel chains Dao to set
	 */
	public void setHotelChainDao(HotelChainDao hotelChainDao) {
		this.hotelChainDao = hotelChainDao;
	}

	
	private HBSiHotelDao hbsiHotelDao;

	/**
	 * @return the hbsiHotelDao
	 */
	public HBSiHotelDao getHbsiHotelDao() {
		return hbsiHotelDao;
	}

	/**
	 * @param hbsiHotelDao
	 *            the hbsiHotelDao to set
	 */
	public void setHbsiHotelDao(HBSiHotelDao hbsiHotelDao) {
		this.hbsiHotelDao = hbsiHotelDao;
	}
	
	
	
	
	public HotelChainResponse retrieveHotelChain(String destination) {
		
		//return this.hotelChainDao.retrieveHotelChain(destination);
		HotelChainResponse hotelChainResponse = this.hotelChainDao.retrieveHotelChain(destination);
		
		
		List<String> hotelChainList = this.hbsiHotelDao.getHotelChainListForNAS();
		List<String> hoteldestinationList = this.hbsiHotelDao.getHotelDestinations();
		
		if(hotelChainResponse.getBusinessErrors()==null && 
				hotelChainResponse.getSystemErrors()==null && 
				hotelChainList!=null && hotelChainList.size()>0 && 
				hotelChainList.get(0)!="" && 
				hoteldestinationList!=null && 
				hoteldestinationList.contains(destination))
		{
			HotelChainResponse res = new HotelChainResponse();
			List<HotelChain> chainHotel = hotelChainResponse.getHotelChain();
			HotelChain atlantishotelchain = new HotelChain();
			atlantishotelchain.setHotelChainName(hotelChainList.get(0).toUpperCase());
			atlantishotelchain.setHotelChainCode(hotelChainList.get(0).toUpperCase());
//			chainHotel.add(atlantishotelchain);
			chainHotel.add(0,atlantishotelchain);
//			Collections.sort(chainHotel);
			res.setHotelChain(chainHotel);
			return res;
			
		}
		
		
		return hotelChainResponse;
	}

}