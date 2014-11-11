package com.kcdata.abe.data.dao;

import java.util.List;
import java.util.Map;

import com.kcdata.abe.data.dto.HotelConfirmation;
import com.kcdata.abe.framework.dao.ABEDao;

public interface HBSiHotelDao extends ABEDao
{
	/**
	 * Method to get the hotel material code from DB
	 * 
	 * @param hotelCode
	 * 
	 * @return isHBSi
	 * 
	 */
	
	public boolean isHBSiHotel(String hotelCode);
	
	/**
	 * Method to get the HBSi Hotel ids
	 * 
	 * @param 
	 * 
	 * @return materialCodeMap
	 * 
	 */
	public Map getHBSiDBData();
	
	public Map getHotelVendors();
	
	public boolean isHBSiHotelVendorCode(String hotelCode);
	
	/**
	 * Method to get the destinations for HBSi Hotels
	 * @return List<String>
	 */
	public List<String> getHotelDestinations();
	
	public List<String> getHotelChainListForNAS();
	
	public List<String> getHBSiSwitch();
	
	public HotelConfirmation getSAPBookingDetails(HotelConfirmation hotelConfirmation);
}
