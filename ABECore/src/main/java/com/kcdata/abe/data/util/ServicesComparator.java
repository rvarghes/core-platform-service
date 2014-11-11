/*
 * ServicesComparator.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Feb 7, 2011  kmadugul
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.util.Comparator;

import com.kcdata.abe.data.dto.Service;

/**
 * Comparator class for sorting services based on criteria
 * 
 * @author kmadugul
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ServicesComparator implements Comparator<Service>
{

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
		
		public int compare(Service o1, Service o2) 
		{			
			String destination1 = o1.getDestination();
			String destination2 = o2.getDestination();
			
			return destination1.compareTo(destination2);
		}
	
}
