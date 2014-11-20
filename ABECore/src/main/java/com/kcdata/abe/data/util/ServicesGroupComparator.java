/*
 * ServicesGroupComparator.java
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

import com.kcdata.abe.data.dto.ServiceGroup;

/**
 * Comparator class to sort the services based on group
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ServicesGroupComparator implements Comparator<ServiceGroup> {

	private List<String> sortOrder = Arrays.asList("86", "80", "84", "124","88", "82", "85");
	

	/**
	 * Method to compare two services
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public int compare(ServiceGroup serviceObj1, ServiceGroup serviceObj2) {
		int index1 = sortOrder.indexOf(serviceObj1.getCode());
		if(index1 == -1) {
			index1 = sortOrder.size() + 1;
		}
		int index2 = sortOrder.indexOf(serviceObj2.getCode());
		if(index2 == -1) {
			index2 = sortOrder.size() + 1;
		}		
		if(index1 > index2) {
			return 1;
		} else if(index1 < index2){
			return -1;
		}
		return 0;
	}

}
