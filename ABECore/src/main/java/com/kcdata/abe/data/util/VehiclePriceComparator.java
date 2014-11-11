/*
 * VehiclePriceComparator.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 14, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.util.Comparator;

import com.kcdata.abe.data.dto.Vehicle;

/**
 * Class to compare two vehicle objects based on Price
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class VehiclePriceComparator implements Comparator<Vehicle> {

	private boolean isPackage;

	/**
	 * Overloaded constructor
	 * 
	 * @param isPackage
	 */
	public VehiclePriceComparator(boolean isPackage) {
		this.isPackage = isPackage;
	}

	/**
	 * Method to sort the vehicles based on price
	 * 
	 * @param object1
	 * @param object2
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public int compare(Vehicle object1, Vehicle object2) {
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
