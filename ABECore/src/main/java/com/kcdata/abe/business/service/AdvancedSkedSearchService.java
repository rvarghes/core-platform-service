/*
 * AdvancedSkedSearchService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 10, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.AdvancedSkedSearchResponse;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Interface for advanced sked search
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface AdvancedSkedSearchService extends ABEService {

	/**
	 * Method for retrieving advanced sked search options
	 * 
	 * @param searchCriteria
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public AdvancedSkedSearchResponse retrieveAdvancedSkedSearchOptions(
			SearchCriteria searchCriteria);
}
