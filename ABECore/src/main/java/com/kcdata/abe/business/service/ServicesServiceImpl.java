/*
 * ServicesServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 30, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.kcdata.abe.business.response.ServiceDetailsResponse;
import com.kcdata.abe.business.response.ServicesResponse;
import com.kcdata.abe.data.dao.HBSiHotelDao;
import com.kcdata.abe.data.dao.ServicesDao;
import com.kcdata.abe.data.dao.WesbServicesDao;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.Service;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.data.util.HotelConvertUtils;
import com.kcdata.abe.framework.service.ABEServiceBase;

public class ServicesServiceImpl extends ABEServiceBase implements
		ServicesService {

	org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(ServicesServiceImpl.class);

	/**
	 * DAO class for retrieving available services
	 */
	private ServicesDao servicesDao;
	/**
	 * DAO class for retrieving available services from WESB
	 */
	private WesbServicesDao wesbServicesDao;

	/**
	 * DAO class to check whether its HBSi and retrieve Map of HotelMaterial
	 * code against hotelCode
	 */
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

	/**
	 * @return the wesbServicesDao
	 */
	public WesbServicesDao getWesbServicesDao() {
		return wesbServicesDao;
	}

	/**
	 * @param wesbServicesDao
	 *            the wesbServicesDao to set
	 */
	public void setWesbServicesDao(WesbServicesDao wesbServicesDao) {
		this.wesbServicesDao = wesbServicesDao;
	}

	/**
	 * @return the servicesDao
	 */
	public ServicesDao getServicesDao() {
		return servicesDao;
	}

	/**
	 * @param servicesDao
	 *            the servicesDao to set
	 */
	public void setServicesDao(ServicesDao servicesDao) {

		this.servicesDao = servicesDao;
	}

	/**
	 * Method for retrieving available services
	 * 
	 * @param itinerary
	 * @return servicesResponse
	 * 
	 * @see
	 * @since
	 */
	public ServicesResponse retrieveServices(Itinerary itinerary) {
	
		/******************************************* WESB CODE FOR HOTEL ONLY *********************************************/
		/*BEGIN: Convert VendorHotelCode to hotel code for HBSi hotels    */
		
Map<String,HBSiHotelInfo> hbsiHotelVendorCode = this.hbsiHotelDao.getHotelVendors();
		
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
						if(itinerary.getMultiDestinationPackages().get(multiDestPack)!=null && itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels()!= null)
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
		if (hbsiSwitchList!=null && hbsiSwitchList.contains("TRUE")&& isHotelOnly(itinerary)) {
			boolean isHbsi = this.hbsiHotelDao.isHBSiHotel(itinerary
					.getHotels().get(0).getHotelCode());
			
			Map<String,HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao.getHBSiDBData();
			return this.wesbServicesDao.retrieveWESBSupplements(itinerary, isHbsi,hbsiHotelList);

		}

		else {
			return this.servicesDao.retrieveServices(itinerary);
		}

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
	 * Method to retrieve service details
	 * 
	 * @param service
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ServiceDetailsResponse retrieveServiceDetails(Service service) {
		return this.servicesDao.retrieveServiceDetails(service);
	}
}
