/*
 * RetrieveAllPricesCommand.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 9, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.AllPricesBreakUp;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class to retrieve all prices of the selected component
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrieveAllPricesCommand extends ABECommandBase {

	/**
	 * Auto generated serialization version id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -1470819731711728073L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveAllPricesCommandHandler";

	private Hotel hotel;
	private Package availablePackage;
	private AllPricesBreakUp allPricesBreakUp;

	/**
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * @param hotel
	 *            the hotel to set
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	/**
	 * @return the availablePackage
	 */
	public Package getAvailablePackage() {
		return availablePackage;
	}

	/**
	 * @param availablePackage
	 *            the availablePackage to set
	 */
	public void setAvailablePackage(Package availablePackage) {
		this.availablePackage = availablePackage;
	}

	/**
	 * @return the allPricesBreakUp
	 */
	public AllPricesBreakUp getAllPricesBreakUp() {
		return allPricesBreakUp;
	}

	/**
	 * @param allPricesBreakUp
	 *            the allPricesBreakUp to set
	 */
	public void setAllPricesBreakUp(AllPricesBreakUp allPricesBreakUp) {
		this.allPricesBreakUp = allPricesBreakUp;
	}

	/**
	 * Method to return the command handler name
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public String getCommandHandlerName() {
		return COMMAND_HANDLER_NAME;
	}

}
