/*
 * InsuranceIdComparator.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * May 11, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.util.Comparator;

import com.kcdata.abe.data.dto.Insurance;

/**
 * Comparator class for sorting Insurance objects
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class InsuranceIdComparator implements Comparator<Insurance> {

	public int compare(Insurance insurance1, Insurance insurance2) {
		if (insurance1.getItemRPH() > insurance2.getItemRPH()) {
			return 1;
		}
		return 0;
	}

}
