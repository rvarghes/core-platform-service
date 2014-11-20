/*
 * HotelRiskComparator.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * May 04, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.util.Comparator;

import com.kcdata.abe.data.dto.Hotel;

/**
 * Comparator class for sorting hotel objects
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class HotelRiskComparator implements Comparator<Hotel> {

	public int compare(Hotel hotel1, Hotel hotel2) {
		if (hotel2.isRiskHotel() && !hotel1.isRiskHotel())
			return 1;
		return 0;
	}

}
