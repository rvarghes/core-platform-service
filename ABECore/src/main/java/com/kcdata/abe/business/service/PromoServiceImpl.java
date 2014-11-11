/*
 * PromoServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 21, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.ValidatePromoResponse;
import com.kcdata.abe.data.dao.PromoDao;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Service implementation class for promo codes
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class PromoServiceImpl extends ABEServiceBase implements PromoService {

	private PromoDao promoDao;

	/**
	 * @return the promoDao
	 */
	public PromoDao getPromoDao() {
		return promoDao;
	}

	/**
	 * @param promoDao
	 *            the promoDao to set
	 */
	public void setPromoDao(PromoDao promoDao) {
		this.promoDao = promoDao;
	}

	/**
	 * Method to validate the promo code
	 * 
	 * @param criteria
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ValidatePromoResponse validatePromo(SearchCriteria criteria) {
		return this.promoDao.validatePromo(criteria);
	}

}
