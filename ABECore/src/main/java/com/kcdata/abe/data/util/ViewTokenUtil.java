/*
 * Util.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 17, 2010  cmelam
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

public interface ViewTokenUtil {
	
	
	
	/**
	 * 
	 * Method to Passenger 
	 * 
	 * @param bookingNo
	 * 
	 * @return tokenNo
	 */
	
	public String getPaxHash(String bookingNo);
	/**
	 * 
	 * Method to travel Agent
	 * 
	 * @param bookingNo
	 * 
	 * @return tokenNo
	 */
	
	
	public String getTaHash(String bookingNo);
	
	
	

}
