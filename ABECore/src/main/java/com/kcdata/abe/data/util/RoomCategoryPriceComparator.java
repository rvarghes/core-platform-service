/*
 * RoomCategoryPriceComparator.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 31, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.util.Comparator;

import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.RoomPrice;

/**
 * Class to compare RoomCategory objects
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class RoomCategoryPriceComparator implements Comparator<RoomCategory> {

	private boolean isPackage;	
	
	public RoomCategoryPriceComparator(boolean isPackage) {
		this.isPackage = isPackage;
	}
	
	public int compare(RoomCategory category1, RoomCategory category2) {
		if(category1.getRoomPrices() == null || category2.getRoomPrices() == null) {
			return 0;
		}
		RoomPrice roomPrice1 = category1.getRoomPrices().get(0);
		RoomPrice roomPrice2 = category2.getRoomPrices().get(0);
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
