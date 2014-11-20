/*
 * RoomCategoryComparator.java
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

import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.RoomPrice;

/**
 * Comparator class for room categories
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public class RoomCategoryComparator implements Comparator<RoomCategory> {

	/**
	 * Flag to determine the sort field
	 */
	private boolean packagePrice;
	
	RoomCategoryComparator(boolean packagePrice) {
		this.packagePrice = packagePrice;
	}
	
	public int compare(RoomCategory roomCategory1, RoomCategory roomCategory2) {
		RoomPrice roomPrice1 = roomCategory1.getDisplayRoomPrice();
		RoomPrice roomPrice2 = roomCategory2.getDisplayRoomPrice();
		
		if(packagePrice) {
			if (roomPrice1.getPackagePrice() > roomPrice2.getPackagePrice())
				return 1;			
		} else {
			if (roomPrice1.getTotalAmount() > roomPrice2.getTotalAmount())
				return 1;			
		}
		return 0;
	}

}
