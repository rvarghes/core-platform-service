/*
 * ValidatePromoCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 21, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.ValidatePromoCommand;
import com.kcdata.abe.business.response.ValidatePromoResponse;
import com.kcdata.abe.business.service.PromoService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class to validate the promo code
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ValidatePromoCommandHandler extends ABECommandHandlerBase {

	private PromoService promoService;

	/**
	 * @return the promoService
	 */
	public PromoService getPromoService() {
		return promoService;
	}

	/**
	 * @param promoService
	 *            the promoService to set
	 */
	public void setPromoService(PromoService promoService) {
		this.promoService = promoService;
	}

	/**
	 * Method to handle the ValidatePromoCommand
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof ValidatePromoCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "ValidatePromoCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		ValidatePromoCommand validatePromoCommand = (ValidatePromoCommand) command;
		ValidatePromoResponse validatePromoResponse = this.promoService.validatePromo(validatePromoCommand.getSearchCriteria());
		// Process response and set the business errors, warnings, and info messages to command
		this.processResponse(validatePromoCommand, validatePromoResponse);
		return validatePromoCommand;		
	}

}
