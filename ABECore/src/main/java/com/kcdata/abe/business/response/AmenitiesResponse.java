/*
 * AmenitiesResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 16, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;
import com.kcdata.abe.data.dto.Amenity;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Amenity Codes and Names response class
 *
 * @author dmahanth
 * @version
 *
 *
 * @see
 * @since
 */

public class AmenitiesResponse extends ABEResponse{
	
	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -7511773282464943002L;

	/**
	 * @return the amenities
	 */
	public List<Amenity> getAmenities() {
		return amenities;
	}

	/**
	 * @param amenities the amenities to set
	 */
	public void setAmenities(List<Amenity> amenities) {
		this.amenities = amenities;
	}

	/**
	 * Field to hold list of amenity codes and names
	 */
	private List<Amenity> amenities;
	
	
	

}
