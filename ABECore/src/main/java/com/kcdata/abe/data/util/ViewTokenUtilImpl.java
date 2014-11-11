/*
 * ViewTokenUtilImpl.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 16, 2010  cmelam
 ******************************************************************************
 */

package com.kcdata.abe.data.util;


import java.security.MessageDigest;
import com.kcdata.abe.data.util.HashStruct;

public class ViewTokenUtilImpl implements ViewTokenUtil{
	
	private static HashStruct AGENT_STRUCT =
		new HashStruct(
			"<applevac-encrypt-travelagent>",
			"</applevac-encrypt-travelagent>");

	private static HashStruct PAX_STRUCT =
		new HashStruct("<APPLEVAC-ENCRYPT-PAX>", "</APPLEVAC-ENCRYPT-PAX>");


	private MessageDigest hash;

	/**
	 * 
	 * Method to travel Agent
	 * 
	 * @param bookingNo
	 * 
	 * @return tokenNo
	 */
	public String getTaHash(String bookingNo) {
		return getHashedString(bookingNo, AGENT_STRUCT);
	}
	
	/**
	 * 
	 * Method to Passenger
	 * 
	 * @param bookingNo
	 * 
	 * @return tokenNo
	 */
	public String getPaxHash(String bookingNo)
	{
		return getHashedString(bookingNo, PAX_STRUCT);
	}

	/**
	 * 
	 * Method for HashedString (TokenNo)
	 * 
	 * @param bookingNo
	 * @param HashStruct
	 * 
	 * @return tokenString
	 * 
	 */
	
	private String getHashedString(String bookingNo, HashStruct struct) {
		String taStr = new StringBuffer()
							.append(struct.getPref())
							.append(bookingNo)
							.append(struct.getSuff())
							.toString();
		return toHexString(
			hash.digest(
					taStr
					.getBytes()));

	}

	/**
	 * 
	 * Method for toHexString 
	 * 
	 * @param byte
	 * 
	 * @return String
	 * 
	 */
	
	public String toHexString(byte bytes[]) {
		StringBuffer retString = new StringBuffer();
		for (int i = 0; i < bytes.length; ++i) {
			retString.append(
				Integer.toHexString(0x0100 + (bytes[i] & 0x00FF)).substring(1));
		}
		return retString.toString();
	}
	/**
	 * 
	 * Method to set the MessageDigest instance
	 * 
	 * @param MessageDigest
	 * 
	 * @return void
	 * 
	 */
	
	public void setHash(MessageDigest digest) {
		hash = digest;
	}

}
