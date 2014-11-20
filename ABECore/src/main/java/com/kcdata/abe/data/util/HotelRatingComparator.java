/*
 * HotelRatingComparator.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 30, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.kcdata.abe.data.dto.Hotel;

/**
 * Comparator class for sorting hotels based on rating
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class HotelRatingComparator implements Comparator<Hotel> {

	private List<String> sortOrder = Arrays.asList("6P", "6G", "6+",
			"6", "5P", "5G", "5+", "5", "4P", "4G", "4+", "4", "3P", "3G",
			"3+", "3", "2P", "2G", "2+", "2", "1P", "1G", "1+", "1");

	/**
	 * Method to compare the hotels
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public int compare(Hotel hotel1, Hotel hotel2) {
		int index1 = sortOrder.indexOf(hotel1.getAppleRating());
		if(index1 == -1) {
			index1 = sortOrder.size() + 1;
		}
		int index2 = sortOrder.indexOf(hotel2.getAppleRating());
		if(index2 == -1) {
			index2 = sortOrder.size() + 1;
		}
		if(index1 > index2) {
			return 1;
		} else if(index1 < index2) {
			return -1;
		}		
		return 0;
	}

}
