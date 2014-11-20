
/*
 * InsuranceSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 18, 2009  dmahanth
 * Sep 24, 2009	 hguntupa	  Changes for IMApplicationInfo
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.HotelConfirmation;
import com.kcdata.abe.data.dto.User;
import com.kcdata.abe.data.util.HotelConvertUtils;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.logging.ABELogger;

/**
 * HBSiHotel DAO implementation class
 * 
 * @author 
 * @version
 * 
 * @see
 * @since
 */
public class HBSiHotelDaoImpl extends ABESAPDaoBase implements HBSiHotelDao {

	/**
	 * Instance of Logger
	 */
	final ABELogger logger = ABELogger.getLogger(com.kcdata.abe.data.dao.HBSiHotelDaoImpl.class);


	private JdbcTemplate jdbcTemplate;

	public void setHotelDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private List<Map<String, Object>> hbsiHotelList = null;

	private Calendar cacheExpiry;
	private static final int CACHE_EXP_TIMEOUT = 1;

	/**
	 * Method to get the HBSi Hotel ids from DB
	 * 
	 * @param 
	 * 
	 * @return hbsiList
	 * 
	 */

	public List<Map<String, Object>> getHBSiHotelids()
	{
		String sql="select HOTEL_ID,HOTEL_MATERIAL_ID,PROPERTY_NAME,APPLE_RATING,RESORT_AREA_NAME,RESORT_AREA_CODE,DESTINATION,HBSI_SWITCH,HOTEL_VENDOR_CODE from \"AVESBUSR\".APPLE_HOTEL_CONSTANTS";
		List<Map<String, Object>> hbsiList = jdbcTemplate.queryForList(sql);
		this.cacheExpiry = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		// adding 1 hour to the current time, as cahce timeout
		this.cacheExpiry.add(Calendar.HOUR, HBSiHotelDaoImpl.CACHE_EXP_TIMEOUT);
		return hbsiList;
	}

	/**
	 * Method to get the hotel material code from DB
	 * 
	 * @param hotelCode
	 * 
	 * @return isHBsi
	 * 
	 */

	public boolean isHBSiHotel(String hotelCode) {
		boolean isHBsi=false;
		if(hotelCode!=null && !hotelCode.equals(""))
		{
			if(hbsiHotelList!=null)
			{	
				isHBsi=getHBSiValue(hbsiHotelList, hotelCode);
			}
			else{
				hbsiHotelList = getHBSiHotelids();
				isHBsi=getHBSiValue(hbsiHotelList, hotelCode);
			}
		}

		return isHBsi;
	}

	
	
	public boolean isHBSiHotelVendorCode(String hotelCode) {
		boolean isHBsi=false;
		if(hotelCode!=null && !hotelCode.equals(""))
		{
			if(hbsiHotelList!=null)
			{	
				isHBsi=getHBSiVendorCode(hbsiHotelList, hotelCode);
			}
			else{
				hbsiHotelList = getHBSiHotelids();
				isHBsi=getHBSiVendorCode(hbsiHotelList, hotelCode);
			}
		}

		return isHBsi;
	}
	
	
	private boolean getHBSiVendorCode(List<Map<String, Object>> hbsiList,String hotelCode)
	{
		validateCacheAge();
		boolean isHBsi=false;
		hotelCode = HotelConvertUtils.padString(hotelCode, true, '0', 10);
		for(Map<String, Object> map : hbsiHotelList)
		{
			if(hotelCode.equalsIgnoreCase(map.get("HOTEL_VENDOR_CODE").toString()))
			{
				isHBsi=true;
				break;
			}
		}
		return isHBsi;
	}
	
	
	
	/**
	 * Method to get the hotel material code from List
	 * 
	 * @param hbsiList,hotelCode
	 * 
	 * @return isHBsi
	 * 
	 */

	private boolean getHBSiValue(List<Map<String, Object>> hbsiList,String hotelCode)
	{
		validateCacheAge();
		boolean isHBsi=false;
		for(Map<String, Object> map : hbsiHotelList)
		{
			if(hotelCode.equalsIgnoreCase(map.get("HOTEL_ID").toString()))
			{
				isHBsi=true;
				break;
			}
		}
		return isHBsi;
	}

	/**
	 * Method to Validate the Cache Age
	 * 
	 * @param 
	 * 
	 * @return 
	 * 
	 */
	
	private void validateCacheAge() {
		Calendar currentTime = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		if(this.cacheExpiry != null) {
			if (this.cacheExpiry.before(currentTime) ) {
				getHBSiHotelids();
			}
		} else {
			getHBSiHotelids();
		}
	}

	/**
	 * Method to get the HBSi Hotel ids 
	 * 
	 * @param 
	 * 
	 * @return materialMap
	 * 
	 */
	
	public Map getHBSiDBData()
	{
		Map materialMap = new HashMap(); 

		if(hbsiHotelList==null)
		{
			hbsiHotelList=getHBSiHotelids();
		}
		validateCacheAge();
		for(Map<String, Object> map : hbsiHotelList)
		{
			HBSiHotelInfo hbSiHotelInfo = new HBSiHotelInfo();
			hbSiHotelInfo.setAppleRating(map.get("APPLE_RATING").toString());
			hbSiHotelInfo.setHotelId(map.get("HOTEL_ID").toString());
			hbSiHotelInfo.setHotelMaterialId(map.get("HOTEL_MATERIAL_ID").toString());
			hbSiHotelInfo.setPropertyName(map.get("PROPERTY_NAME").toString());
			hbSiHotelInfo.setResortAreaName(map.get("RESORT_AREA_NAME").toString());
			hbSiHotelInfo.setResortAreaCode(map.get("RESORT_AREA_CODE").toString());
			hbSiHotelInfo.setHotelVendorCode(map.get("HOTEL_VENDOR_CODE").toString());
			materialMap.put(map.get("HOTEL_ID").toString(), hbSiHotelInfo);
		}
		return materialMap;
	}
	
	public Map getHotelVendors()
	{
		Map materialMap = new HashMap(); 

		if(hbsiHotelList==null)
		{
			hbsiHotelList=getHBSiHotelids();
		}
		validateCacheAge();
		for(Map<String, Object> map : hbsiHotelList)
		{
			HBSiHotelInfo hbSiHotelInfo = new HBSiHotelInfo();
			hbSiHotelInfo.setAppleRating(map.get("APPLE_RATING").toString());
			hbSiHotelInfo.setHotelId(map.get("HOTEL_ID").toString());
			hbSiHotelInfo.setHotelMaterialId(map.get("HOTEL_MATERIAL_ID").toString());
			hbSiHotelInfo.setPropertyName(map.get("PROPERTY_NAME").toString());
			hbSiHotelInfo.setResortAreaName(map.get("RESORT_AREA_NAME").toString());
			hbSiHotelInfo.setResortAreaCode(map.get("RESORT_AREA_CODE").toString());
			hbSiHotelInfo.setHotelVendorCode(map.get("HOTEL_VENDOR_CODE").toString());
			materialMap.put(map.get("HOTEL_VENDOR_CODE").toString(), hbSiHotelInfo);
		}
		return materialMap;
	}
	
	
	
	
	
	public List<String> getHotelDestinations()
	{

		List<String> destinationList = new ArrayList<String>();
		if(hbsiHotelList==null)
		{
			hbsiHotelList=getHBSiHotelids();
		}
		validateCacheAge();
		if(hbsiHotelList!=null)
		{
		for(Map<String, Object> map : hbsiHotelList)
		{
			if(map.get("DESTINATION")!=null)
			destinationList.add(map.get("DESTINATION").toString().trim());
						
		}
		return destinationList;
		}
		
		
		return destinationList;
	}
	
	//HBSI_SWITCH
	public List<String> getHotelChainListForNAS()
	{

		List<String> hotelChainList = new ArrayList<String>();
		if(hbsiHotelList==null)
		{
			hbsiHotelList=getHBSiHotelids();
		}
		validateCacheAge();
		if(hbsiHotelList!=null)
		{
		for(Map<String, Object> map : hbsiHotelList)
		{
			if(map.get("RESORT_AREA_CODE")!=null)
				hotelChainList.add(map.get("RESORT_AREA_CODE").toString().trim());
						
		}
		return hotelChainList;
		}
		
		
		return hotelChainList;
	}
	
	public List<String> getHBSiSwitch()
	{

		List<String> hbsiSwitchList = new ArrayList<String>();
		if(hbsiHotelList==null)
		{
			hbsiHotelList=getHBSiHotelids();
		}
		validateCacheAge();
		if(hbsiHotelList!=null)
		{
		for(Map<String, Object> map : hbsiHotelList)
		{
			if(map.get("HBSI_SWITCH")!=null)
				hbsiSwitchList.add(map.get("HBSI_SWITCH").toString().trim());
						
		}
		return hbsiSwitchList;
		}
		
		
		return hbsiSwitchList;
	}

	public HotelConfirmation getSAPBookingDetails(HotelConfirmation hotelConfirmation) {
		String sourceReservationID = hotelConfirmation.getSourceReservationID();
		/* sourceReservationID pattern is <sapbookingno>+"-"+<vendorid>+"-"+<datetimestamp> */
		String hbsiReferenceNumberSplit [] =  sourceReservationID.split("-");
		String sapBookingNumber = hbsiReferenceNumberSplit[0];
		//String sql="SELECT * FROM AVESBUSR.HBSI_NOTIFICATION AS HBSI_NOTIFICATION WHERE HBSI_NOTIFICATION.\"BookingNo\"="+"'"+sourceReservationID+"'";
		String sql="SELECT \"HBSiConfirmationNo\" FROM AVESBUSR.HBSI_NOTIFICATION AS HBSI_NOTIFICATION WHERE HBSI_NOTIFICATION.\"BookingNo\"=?";
		String pnrNo = (String)jdbcTemplate.queryForObject(sql, new Object[] { sourceReservationID }, String.class);
		hotelConfirmation.setHotelPNRNo(pnrNo);
		hotelConfirmation.setSapBookingNo(sapBookingNumber);
		return hotelConfirmation;
	}

}

