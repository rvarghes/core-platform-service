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

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.kcdata.abe.data.dto.PaxTypePriceBreakup;

/**
 * Comparator class for comparing and sorting PAX types
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class PaxTypePriceByTypeComparator implements Comparator<PaxTypePriceBreakup> {

	private List<Character> sortOrder = Arrays.asList('A', 'C', 'I', 'L');

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
		int index1 = sortOrder.indexOf(type1.getPaxType());
		if (index1 == -1) {
			index1 = sortOrder.size() + 1;
		}
		int index2 = sortOrder.indexOf(type2.getPaxType());
		if (index2 == -1) {
			index2 = sortOrder.size() + 1;
		}
		if (index1 > index2) {
			return 1;
		} else if (index1 < index2) {
			return -1;
		} else if (type1.getAge() < type2.getAge()) {
			return 1;
		}
		return 0;
	}

}
