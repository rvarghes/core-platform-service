/*
 * ItineraryCancellationRules.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 30, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

public class ItineraryCancellationRules implements ABEDto{

	/**
	 * Autogeneration serial id
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -4119427559475396007L;
	private List<String> skedInfoRules;

	/**
	 * @return the skedInfoRules
	 */
	public List<String> getSkedInfoRules() {
		return skedInfoRules;
	}

	/**
	 * @param skedInfoRules
	 *            the skedInfoRules to set
	 */
	public void setSkedInfoRules(List<String> skedInfoRules) {
		this.skedInfoRules = skedInfoRules;
	}

	private List<String> skedCancellationRules;

	/**
	 * @return the skedCancellationRules
	 */
	public List<String> getSkedCancellationRules() {
		return skedCancellationRules;
	}

	/**
	 * @param skedCancellationRules
	 *            the skedCancellationRules to set
	 */
	public void setSkedCancellationRules(List<String> skedCancellationRules) {
		this.skedCancellationRules = skedCancellationRules;
	}

	public void addSkedCancellationRules(String skedCancellationRule) {
		if (this.skedCancellationRules != null) {
			this.skedCancellationRules.add(skedCancellationRule);
		} else {
			this.skedCancellationRules = new ArrayList<String>();
			this.skedCancellationRules.add(skedCancellationRule);
		}
	}

	public void addSkedInfoRules(String skedInfoRule) {
		if (this.skedInfoRules != null) {
			this.skedInfoRules.add(skedInfoRule);
		} else {
			this.skedInfoRules = new ArrayList<String>();
			this.skedInfoRules.add(skedInfoRule);
		}
	}
}
