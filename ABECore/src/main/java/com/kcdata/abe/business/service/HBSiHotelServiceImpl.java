package com.kcdata.abe.business.service;

import com.kcdata.abe.data.dao.HBSiHotelDao;
import com.kcdata.abe.framework.service.ABEServiceBase;

public class HBSiHotelServiceImpl extends ABEServiceBase implements HBSiHotelService{
	
	private HBSiHotelDao hbsiHotelDao;
	
	/**
	 * @param hbsiHotelDao the hbsiHotelDao to set
	 */
	public void setHbsiHotelDao(HBSiHotelDao hbsiHotelDao) {
		this.hbsiHotelDao = hbsiHotelDao;
	}
	
	
	/**
	 * Method to get the hotel material code from DB
	 * 
	 * @param hotelCode
	 * 
	 * @return isHBSi
	 * 
	 */
	public boolean isHBSiHotel(String hotelCode)
	{
		return this.hbsiHotelDao.isHBSiHotel(hotelCode);
	}
	
}

