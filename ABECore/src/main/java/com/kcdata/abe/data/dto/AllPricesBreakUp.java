/*
 * AllPricesBreakUp.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 9, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Class to hold the all price breakups of a component
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AllPricesBreakUp implements ABEDto {

	/**
	 * Auto generated serialization version id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 8361949726405121307L;

	private List<PaxTypePriceBreakup> paxTypePrices;
	private byte freeChildCount;
	private byte maxPerRoom;
	private byte minPerRoom;
	private byte maxAdultCount;
	private byte maxChildCount;
	private String childRule;

	/**
	 * @return the paxTypePrices
	 */
	public List<PaxTypePriceBreakup> getPaxTypePrices() {
		return paxTypePrices;
	}

	/**
	 * @param paxTypePrices
	 *            the paxTypePrices to set
	 */
	public void setPaxTypePrices(List<PaxTypePriceBreakup> paxTypePrices) {
		this.paxTypePrices = paxTypePrices;
	}

	/**
	 * @return the freeChildCount
	 */
	public byte getFreeChildCount() {
		return freeChildCount;
	}

	/**
	 * @param freeChildCount
	 *            the freeChildCount to set
	 */
	public void setFreeChildCount(byte freeChildCount) {
		this.freeChildCount = freeChildCount;
	}

	/**
	 * @return the maxPerRoom
	 */
	public byte getMaxPerRoom() {
		return maxPerRoom;
	}

	/**
	 * @param maxPerRoom
	 *            the maxPerRoom to set
	 */
	public void setMaxPerRoom(byte maxPerRoom) {
		this.maxPerRoom = maxPerRoom;
	}

	/**
	 * @return the minPerRoom
	 */
	public byte getMinPerRoom() {
		return minPerRoom;
	}

	/**
	 * @param minPerRoom
	 *            the minPerRoom to set
	 */
	public void setMinPerRoom(byte minPerRoom) {
		this.minPerRoom = minPerRoom;
	}

	/**
	 * @return the maxAdultCount
	 */
	public byte getMaxAdultCount() {
		return maxAdultCount;
	}

	/**
	 * @param maxAdultCount
	 *            the maxAdultCount to set
	 */
	public void setMaxAdultCount(byte maxAdultCount) {
		this.maxAdultCount = maxAdultCount;
	}

	/**
	 * @return the maxChildCount
	 */
	public byte getMaxChildCount() {
		return maxChildCount;
	}

	/**
	 * @param maxChildCount
	 *            the maxChildCount to set
	 */
	public void setMaxChildCount(byte maxChildCount) {
		this.maxChildCount = maxChildCount;
	}

	/**
	 * @return the childRule
	 */
	public String getChildRule() {
		return childRule;
	}

	/**
	 * @param childRule
	 *            the childRule to set
	 */
	public void setChildRule(String childRule) {
		this.childRule = childRule;
	}

	/**
	 * Method to clone the object
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		AllPricesBreakUp allPricesBreakUp = (AllPricesBreakUp) super.clone();
		if(paxTypePrices != null) {
			List<PaxTypePriceBreakup> breakupList = new ArrayList<PaxTypePriceBreakup>();
			for(PaxTypePriceBreakup breakUp: paxTypePrices) {
				breakupList.add((PaxTypePriceBreakup)breakUp.clone()); 
			}
			allPricesBreakUp.setPaxTypePrices(breakupList);
		}
		return allPricesBreakUp;
	}

}
