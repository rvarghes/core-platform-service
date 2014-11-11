/*
 * RoomPriceComparator.java
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

import com.kcdata.abe.data.dto.RoomPrice;

/**
 * Comparator class for comparing room price objects
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public class RoomPriceComparator implements Comparator<RoomPrice> {

	private boolean isPackage;
	
	RoomPriceComparator(boolean isPackage) {
		this.isPackage = isPackage;
	}
	public int compare(RoomPrice roomPrice1, RoomPrice roomPrice2) {
		
		if(isPackage) {
			if (roomPrice1.getPackagePrice() > roomPrice2.getPackagePrice())
				return 1;			
		} else {
			if (roomPrice1.getTotalAmount() > roomPrice2.getTotalAmount())
				return 1;
		}
		return 0;
	}

}
