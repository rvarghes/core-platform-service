/*
 * PromoService.java
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
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Service class for promo codes
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface PromoService extends ABEService {
	
	/**
	 * Method to validate the promo code
	 *
	 * @param criteria
	 * @return
	 *
	 * @see
	 * @since
	 */
	public ValidatePromoResponse validatePromo(SearchCriteria criteria);

}
