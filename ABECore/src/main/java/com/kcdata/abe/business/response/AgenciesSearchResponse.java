/*
 * AgenciesSearchResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Feb 21, 2011  kmadugul
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.framework.response.ABEResponse;
import com.kcdata.abe.data.dto.Agency;
/**
 * Class for agencies search response
 *
 * @author kmadugul
 * @version
 *
 * @see
 * @since
 */
public class AgenciesSearchResponse extends ABEResponse 
{

	private static final long serialVersionUID = 7020179022584851368L;
	private List<Agency> agenciesList;

	/**
	 * @param agenciesList the agenciesList to set
	 */
	public void setAgenciesList(List<Agency> agenciesList) 
	{
		this.agenciesList = agenciesList;
	}

	/**
	 * @return the agenciesList
	 */
	public List<Agency> getAgenciesList() 
	{
		return agenciesList;
	}
}