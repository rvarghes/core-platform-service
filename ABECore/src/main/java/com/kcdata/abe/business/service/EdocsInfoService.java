/*
 * EdocsInfoService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 17, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.EdocsInfoResponse;
import com.kcdata.abe.data.dto.EdocsInfo;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Service interface for EdocsInfo
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface EdocsInfoService extends ABEService {

	/**
	 * Method to store the edocs info 
	 *
	 * @param edocsInfo
	 * @return
	 *
	 * @see
	 * @since
	 */
	public EdocsInfoResponse storeEdocsInfo(EdocsInfo edocsInfo);
}
