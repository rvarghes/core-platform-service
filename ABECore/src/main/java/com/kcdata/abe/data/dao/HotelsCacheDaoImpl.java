/*
 * HotelsCacheDaoImpl.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jan 13, 2011  chazari
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.applevac.sce.service.external.SpecialsSearchCriteria;
import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.business.response.SpecialsCacheResponse;
import com.kcdata.abe.data.dto.SpecialRequestType;
import com.kcdata.abe.data.util.SpecialUtils;
import com.kcdata.abe.framework.dao.ABEDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.logging.ABELogger;
/**
 * DAO Class to retrieve hotels from SCE Web and map it to HotelsResponse structure
 * Applicable for Consumer Booking Engine scenarios
 */
public class HotelsCacheDaoImpl extends ABEDaoBase implements HotelsCacheDao {
	
	private SpecialsCacheDao specialsCacheDao;
	
	/**
	 * @return the specialsCacheDao
	 */
	public SpecialsCacheDao getSpecialsCacheDao() {
		return specialsCacheDao;
	}

	/**
	 * @param specialsCacheDao the specialsCacheDao to set
	 */
	public void setSpecialsCacheDao(SpecialsCacheDao specialsCacheDao) {
		this.specialsCacheDao = specialsCacheDao;
	}
	
	ABELogger logger = ABELogger.getLogger(HotelsCacheDaoImpl.class);
	
	/**
	 * Method queries SCEWeb for a list of hotels and filter to a hotel 
	 * matching a hotel name that's passed through hotel request
	 * @param hotelsRequest
	 * @return hotelsResponse
	 */
	public HotelsResponse retrieveHotels(HotelsRequest hotelRequest) {
		HotelsResponse hotelResponse = new HotelsResponse();
		if (hotelRequest == null || hotelRequest.getSpecialOptions() == null) {
			// Invalid search options, return to presentation with error
			// message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_HOTEL_SEARCH_CRITERIA");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_HOTEL_SEARCH_CRITERIA", null, null));
			hotelResponse.saveBusinessError(businessError);
			return hotelResponse;
		}
		SpecialsSearchCriteria specialsSearchCriteria = SpecialUtils
				.convertSearchCriteria(hotelRequest,
						SpecialRequestType.ONESPECIAL);
		SpecialsCacheResponse specialsResponse = specialsCacheDao
				.retrieveSpecialsFromGrid(specialsSearchCriteria);
		hotelResponse = SpecialUtils.buildHotelFromSpecial(specialsResponse,
				specialsSearchCriteria, hotelRequest);
		
		if(hotelResponse.getHotelList().get(0).getRoomCategories().size() == 0) {
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("NO_HOTEL_SPECIALS_FOUND");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("NO_HOTEL_SPECIALS_FOUND", null, null));
			hotelResponse.saveBusinessError(businessError);
			return hotelResponse;
		} return hotelResponse;
	}
	
}
