/*
 * HashStruct.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 29, 2010  chazari
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

public class HashStruct {
	
	private String prefix;
	private String suffix;

	public HashStruct(String pref, String suff)
	{
		prefix = pref.toUpperCase();
		suffix = suff.toUpperCase();
	}
	public String getPref()
	{
		return prefix;
	}
	public String getSuff()
	{
		return suffix;
	}
}
