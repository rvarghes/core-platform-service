/*
 * EdocsInfoResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 17, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import com.kcdata.abe.data.dto.EdocsInfo;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Response class for Edocs
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class EdocsInfoResponse extends ABEResponse {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -3039317156015509709L;

	private EdocsInfo edocsInfo;

	/**
	 * @return the edocsInfo
	 */
	public EdocsInfo getEdocsInfo() {
		return edocsInfo;
	}

	/**
	 * @param edocsInfo
	 *            the edocsInfo to set
	 */
	public void setEdocsInfo(EdocsInfo edocsInfo) {
		this.edocsInfo = edocsInfo;
	}
}
