/*
 * AuthenticateUserCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 18, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.Date;

import com.kcdata.abe.data.dto.User;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * User authentication command class
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AuthenticateUserCommand extends ABECommandBase {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -3406958002772360489L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "authenticateUserCommandHandler";

	/**
	 * Returns command handler class name
	 * 
	 * @return Command Handler string
	 * 
	 * @see
	 * @since
	 */

	public String getCommandHandlerName() {
		return COMMAND_HANDLER_NAME;
	}

	// Object to hold user details
	private User user;

	// Objects to determine the server offset
	private String dateStr;
	private Date dateObj;
	private int serverOffset;
	private int serverOffsetTime;
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the dateStr
	 */
	public String getDateStr() {
		return dateStr;
	}

	/**
	 * @param dateStr
	 *            the dateStr to set
	 */
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	/**
	 * @return the dateObj
	 */
	public Date getDateObj() {
		return dateObj;
	}

	/**
	 * @param dateObj
	 *            the dateObj to set
	 */
	public void setDateObj(Date dateObj) {
		this.dateObj = dateObj;
	}

	/**
	 * @return the serverOffset
	 */
	public int getServerOffset() {
		return serverOffset;
	}

	/**
	 * @param serverOffset
	 *            the serverOffset to set
	 */
	public void setServerOffset(int serverOffset) {
		this.serverOffset = serverOffset;
	}
	//Regarding the issue 3621774
	/**
	 * @return the serverOffsetTime
	 */
	public int getServerOffsetTime() {
		return serverOffsetTime;
	}

	/**
	 * @param serverOffsetTime the serverOffsetTime to set
	 */
	public void setServerOffsetTime(int serverOffsetTime) {
		this.serverOffsetTime = serverOffsetTime;
	}

}
