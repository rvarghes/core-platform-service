/*
 * AllPriceBreakUpResponse.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 9, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import com.kcdata.abe.data.dto.AllPricesBreakUp;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Response class to hold the AllPriceBreakUp object
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AllPriceBreakUpResponse extends ABEResponse {

	/**
	 * Auto generated serialization version id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -5337780154655741821L;

	private AllPricesBreakUp allPricesBreakUp;

	/**
	 * @return the allPricesBreakUp
	 */
	public AllPricesBreakUp getAllPricesBreakUp() {
		return allPricesBreakUp;
	}

	/**
	 * @param allPricesBreakUp
	 *            the allPricesBreakUp to set
	 */
	public void setAllPricesBreakUp(AllPricesBreakUp allPricesBreakUp) {
		this.allPricesBreakUp = allPricesBreakUp;
	}

}
