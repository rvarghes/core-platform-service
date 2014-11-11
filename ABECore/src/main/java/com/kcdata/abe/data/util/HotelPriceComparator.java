/*
 * HotelPriceComparator.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 21, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.util.Comparator;

import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.RoomPrice;

/**
 * Comparator class for sorting hotel objects
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public class HotelPriceComparator implements Comparator<Hotel> {

	
	public int compare(Hotel hotel1, Hotel hotel2) {

		RoomPrice roomPrice1 = hotel1.getDisplayRoomCategory().getDisplayRoomPrice();
		RoomPrice roomPrice2 = hotel2.getDisplayRoomCategory().getDisplayRoomPrice();
		
		if (roomPrice1.getTotalAmount() > roomPrice2.getTotalAmount())
			return 1;
		return 0;
	}

}
