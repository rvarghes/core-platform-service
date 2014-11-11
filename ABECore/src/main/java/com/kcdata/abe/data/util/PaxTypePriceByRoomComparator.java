/*
 * PaxTypePriceByTypeComparator.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 23, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.util.Comparator;

import com.kcdata.abe.data.dto.PaxTypePriceBreakup;

/**
 * Comparator class for comparing and sorting based on room number
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class PaxTypePriceByRoomComparator implements Comparator<PaxTypePriceBreakup> {

	/**
	 * Method to compare the PaxTypePriceBreakup based on type and age
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public int compare(PaxTypePriceBreakup type1, PaxTypePriceBreakup type2) {
		if(type1.getRoomId() > type2.getRoomId()) {
			return 1;
		}
		return 0;
	}
}
