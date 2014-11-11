package com.kcdata.abe.business.service;

import com.kcdata.abe.framework.service.ABEService;


public interface HBSiHotelService extends ABEService{
	
	/**
	 * Method to get the hotel material code from DB
	 * 
	 * @param hotelCode
	 * 
	 * @return isHBSi
	 * 
	 */
	public boolean isHBSiHotel(String hotelCode);
}

