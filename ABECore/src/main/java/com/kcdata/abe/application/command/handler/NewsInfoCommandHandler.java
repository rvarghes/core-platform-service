/*
 * NewsInfoCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 15, 2010  vgandrap	  Command Handler to handle NewsInfoCommand	
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.NewsInfoCommand;
import com.kcdata.abe.business.response.NewsInfoResponse;
import com.kcdata.abe.business.service.NewsInfoService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class NewsInfoCommandHandler extends ABECommandHandlerBase {

	private NewsInfoService newsInfoService;

	public ABECommand handle(ABECommand command) {
		if (!(command instanceof NewsInfoCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEGAL_COMMAND_ERROR",
					new Object[] { "NewsInfoCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		NewsInfoCommand newsInfoCommand = (NewsInfoCommand) command;
		NewsInfoResponse newsInfoResponse = newsInfoService
				.retrieveNewsInfo(newsInfoCommand.getGateway());

		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(newsInfoCommand, newsInfoResponse);
		newsInfoCommand.setNewsInfo(newsInfoResponse.getNewsInfo());
		return newsInfoCommand;
	}

	public void setNewsInfoService(NewsInfoService newsInfoService) {
		this.newsInfoService = newsInfoService;
	}

	public NewsInfoService getNewsInfoService() {
		return newsInfoService;
	}

}
