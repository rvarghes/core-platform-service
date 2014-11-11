/*
 * NewsInfoCommand.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 15, 2010  vgandrap	  Command for retrieving News	
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.NewsInfo;
import com.kcdata.abe.framework.command.ABECommandBase;

public class NewsInfoCommand extends ABECommandBase{

	/**
	 * Auto generated Serial ID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 5863489583869508068L;
	
	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "newsInfoCommandHandler";
	
	/**
	 * Returns command handler name
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public String getCommandHandlerName() {
		return COMMAND_HANDLER_NAME;
	}
	
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
	public String getGateway() {
		return gateway;
	}

	public void setNewsInfo(NewsInfo newsInfo) {
		this.newsInfo = newsInfo;
	}

	public NewsInfo getNewsInfo() {
		return newsInfo;
	}

	//agent gateway/call center code
	private String gateway;
	//DTO for retrieved news
	private NewsInfo newsInfo;


}
