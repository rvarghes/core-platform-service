/*

 * InsuranceServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 21, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.kcdata.abe.business.response.InsuranceResponse;
import com.kcdata.abe.data.dao.HBSiHotelDao;
import com.kcdata.abe.data.dao.InsuranceDao;
import com.kcdata.abe.data.dao.InsuranceWESBDao;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.data.util.HotelConvertUtils;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.service.ABEServiceBase;


public class InsuranceServiceImpl extends ABEServiceBase implements
InsuranceService{

	ABELogger logger = ABELogger.getLogger(ABELogger.class);

	/**
	 * DAO class for retrieving insurance options
	 */
	private InsuranceDao insuranceDao;

	/**
	 * @return the insuranceDao
	 */
	public InsuranceDao getInsuranceDao() {
		return insuranceDao;
	}

	/**
	 * @param insuranceDao
	 *            the insuranceDao to set
	 */
	public void setInsuranceDao(
			InsuranceDao insuranceDao) {
		this.insuranceDao = insuranceDao;
	}

	/**
	 * DAO class for retrieving insurance options for WESB
	 */

	private InsuranceWESBDao insuranceWESBDao;

	/**
	 * @return the insuranceWESBDao
	 */
	public InsuranceWESBDao getInsuranceWESBDao() {
		return insuranceWESBDao;
	}

	/**
	 * @param insuranceWESBDao
	 *            the insuranceWESBDao to set
	 */
	public void setInsuranceWESBDao(
			InsuranceWESBDao insuranceWESBDao) {
		this.insuranceWESBDao = insuranceWESBDao;
	}

	private HBSiHotelDao hbsiHotelDao;
	
	/**
	 * @param hbsiHotelDao the hbsiHotelDao to set
	 */
	public void setHbsiHotelDao(HBSiHotelDao hbsiHotelDao) {
		this.hbsiHotelDao = hbsiHotelDao;
	}
	
	/**
	 * Method for retrieving insurance options
	 * 
	 * @param itinerary
	 * @return insuranceResponse
	 * 
	 * @see
	 * @since
	 */
	
	public InsuranceResponse retrieveInsurance(Itinerary itinerary) {
		
		
		
		/** BEGIN: COnvert hotel vendor code to hotel code for HBSi hotel ****/
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
		
		/** END: COnvert hotel vendor code to hotel code for HBSi hotel****/
		

		InsuranceResponse insuranceResponse = null;
		List<String> hbsiSwitchList = this.hbsiHotelDao.getHBSiSwitch();
		if(hbsiSwitchList!=null && hbsiSwitchList.contains("TRUE")&& this.isHotelOnly(itinerary))
		{
			
			boolean isHbsi = this.hbsiHotelDao.isHBSiHotel(itinerary.getHotels().get(0).getHotelCode());
			
			Map<String,HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao.getHBSiDBData();

			insuranceResponse = this.insuranceWESBDao.retrieveWESBInsurance(itinerary,isHbsi,hbsiHotelList);
			
		}
		else
		{
			insuranceResponse = this.insuranceDao.retrieveInsurance(itinerary);
		}

		return insuranceResponse;
	}
	
	
	public boolean isHotelOnly(Itinerary itinerary){
		boolean isHotelOnly=false;
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

}
