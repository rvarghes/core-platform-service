/*
 * ServiceDetailsResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 20, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import com.kcdata.abe.data.dto.Service;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Response class to hold the Service Details response
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ServiceDetailsResponse extends ABEResponse {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -8080233529473098094L;

	private Service service;

	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(Service service) {
		this.service = service;
	}

}
