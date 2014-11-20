/*
 * CharterFlightClassComparator.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 11, 2010  vgandrap
 * Jun 21, 2010	 hguntupa	  Updated to pick the low cost Charter flight
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.kcdata.cache.data.dto.TripFlight;

public class CharterFlightClassComparator implements Comparator<TripFlight> {

	private List<String> sortOrder = Arrays.asList("X", "C", "B", "A", "P", "F");

	/**
	 * 
	 * Sort flight list with cheapest class first based on occupancy available.
	 * Price of A > B > C classes
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public int compare(TripFlight flight1, TripFlight flight2) {
		int index1 = sortOrder.indexOf(""+ flight1.getOutboundFlight().getClassOfService());
		if(index1 == -1) {
			index1 = sortOrder.size() + 1;
		}
		int index2 = sortOrder.indexOf(""+ flight2.getOutboundFlight().getClassOfService());
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
