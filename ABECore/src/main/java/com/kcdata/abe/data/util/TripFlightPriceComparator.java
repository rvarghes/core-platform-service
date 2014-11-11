/*
 * TripFlightPriceComparator.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 27, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.util.Comparator;

import com.kcdata.abe.data.dto.TripFlight;

/**
 * Class to compare two flight objects based on Price
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class TripFlightPriceComparator implements Comparator<TripFlight> {

	private boolean isPackage;

	/**
	 * Overloaded constructor
	 * 
	 * @param isPackage
	 */
	public TripFlightPriceComparator(boolean isPackage) {
		this.isPackage = isPackage;
	}

	/**
	 * Method to sort the flights based on price
	 * 
	 * @param object1
	 * @param object2
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public int compare(TripFlight object1, TripFlight object2) {
		if (isPackage) {
			if (object1.getPrice().getPackagePrice() > object2.getPrice()
					.getPackagePrice()) {
				return 1;
			} else if (object1.getPrice().getPackagePrice() < object2
					.getPrice().getPackagePrice()) {
				return -1;
			}
		} else {
			if (object1.getPrice().getOccpancyBasedPrice() > object2.getPrice()
					.getOccpancyBasedPrice()) {
				return 1;
			} else if (object1.getPrice().getOccpancyBasedPrice() < object2
					.getPrice().getOccpancyBasedPrice()) {
				return -1;
			}
		}
		return 0;
	}

}
