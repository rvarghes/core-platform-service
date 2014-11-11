/*
 * HotelsRequest.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 23, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.request;

import com.kcdata.abe.data.dto.HotelOptions;
import com.kcdata.abe.data.dto.SpecialOptions;
import com.kcdata.abe.framework.request.ABERequest;

/**
 * Holds the search criteria for Hotels
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class HotelsRequest extends ABERequest {
	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -5950527195139111069L;

	/**
	 * @return the hotelOptions
	 */
	public HotelOptions getHotelOptions() {
		return hotelOptions;
	}

	/**
	 * @param hotelOptions
	 *            the hotelOptions to set
	 */
	public void setHotelOptions(HotelOptions hotelOptions) {
		this.hotelOptions = hotelOptions;
	}

	/**
	 * @return the specialOptions
	 */
	public SpecialOptions getSpecialOptions() {
		return specialOptions;
	}

	/**
	 * @param specialOptions the specialOptions to set
	 */
	public void setSpecialOptions(SpecialOptions specialOptions) {
		this.specialOptions = specialOptions;
	}

	/**
	 * Method to clone the object
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */
	
	public Object clone() throws CloneNotSupportedException {
		HotelsRequest hotelRequest = (HotelsRequest) super.clone();
		if(hotelOptions != null) {
			hotelRequest.hotelOptions = (HotelOptions) hotelOptions.clone();
		}
		if(specialOptions != null) {
			hotelRequest.specialOptions = (SpecialOptions) specialOptions.clone();
		}
		return hotelRequest;
	}

	private HotelOptions hotelOptions;
	private SpecialOptions specialOptions;
}