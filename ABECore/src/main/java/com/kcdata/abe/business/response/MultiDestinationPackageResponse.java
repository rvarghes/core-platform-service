/*
 * MultiDestinationPackageResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 13, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import com.kcdata.abe.data.dto.MultiDestinationPackage;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Response class to hold the multi-destination package response
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class MultiDestinationPackageResponse extends ABEResponse {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 2072550975604528597L;

	private MultiDestinationPackage multiDestinationPackage;

	/**
	 * @return the multiDestinationPackage
	 */
	public MultiDestinationPackage getMultiDestinationPackage() {
		return multiDestinationPackage;
	}

	/**
	 * @param multiDestinationPackage
	 *            the multiDestinationPackage to set
	 */
	public void setMultiDestinationPackage(
			MultiDestinationPackage multiDestinationPackage) {
		this.multiDestinationPackage = multiDestinationPackage;
	}

}
