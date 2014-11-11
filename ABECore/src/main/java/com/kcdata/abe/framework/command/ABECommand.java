/*
 * ABECommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 24, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.command;

import java.io.Serializable;
import java.util.List;

import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.framework.context.ABEApplicationContext;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABEInfoMessage;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABEWarning;

/**
 * This interface defines the operations of a Command object. N/A.
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface ABECommand extends Serializable {

	/**
	 * This method returns the key to locate the appropriate handler.
	 * 
	 * @return String The key to locate the appropriate handler
	 * 
	 * @see
	 * @since
	 */
	String getCommandHandlerName();

	/**
	 * Getter method for application context field.
	 * 
	 * @return application context
	 * 
	 * @see com.kcdata.abe.framework.context.ABEApplicationContext
	 * @since
	 */
	ABEApplicationContext getApplicationContext();

	/**
	 * Setter method for application context field.
	 * 
	 * @param applicationContext
	 *            application context
	 * 
	 * @see com.kcdata.abe.framework.context.ABEApplicationContext
	 * @since
	 */
	void setApplicationContext(ABEApplicationContext applicationContext);

	/**
	 * @return Returns the warnings.
	 */
	List<ABEWarning> getWarnings();

	/**
	 * @param warnings
	 *            The warnings to set.
	 */
	void setWarnings(List<ABEWarning> warnings);

	/**
	 * This method add a warning to the warning list.
	 * 
	 * @param warning
	 *            ABEWarning object
	 * 
	 * @see
	 * @since
	 */
	void addWarning(ABEWarning warning);

	/**
	 * @return Returns the info messages.
	 */
	List<ABEInfoMessage> getInfoMessages();

	/**
	 * @param infoMessages
	 *            The info messages to set.
	 */
	void setInfoMessages(List<ABEInfoMessage> infoMessages);

	/**
	 * This method add a info message to list.
	 * 
	 * @param infoMessage
	 *            ABEInfoMessage object
	 * 
	 * @see
	 * @since
	 */
	void addInfoMessage(ABEInfoMessage infoMessage);

	/**
	 * @return Returns the Errors.
	 */
	List<ABEBusinessError> getBusinessErrors();

	/**
	 * @param errors
	 *            The errors to set.
	 */
	void setBusinessErrors(List<ABEBusinessError> errors);

	/**
	 * @return Returns the Errors.
	 */
	List<ABESystemError> getSystemErrors();

	/**
	 * @param errors
	 *            The errors to set.
	 */
	void setSystemErrors(List<ABESystemError> errors);

	/**
	 * This method add a warning to the warning list.
	 * 
	 * @param warning
	 *            ABEBusinessError object
	 * 
	 * @see
	 * @since
	 */
	void addBusinessError(ABEBusinessError warning);

	/**
	 * This method add a systemError to the systemError list.
	 * 
	 * @param systemError
	 *            ABESystemError object
	 * 
	 * @see
	 * @since
	 */
	void addSystemError(ABESystemError systemError);

	/**
	 * Method sets application info object
	 * 
	 * @param imApplicationInfo
	 * 
	 * @see
	 * @since
	 */
	void setIMApplicationInfo(IMApplicationInfo imApplicationInfo);

	/**
	 * Method returns application info object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	IMApplicationInfo getIMApplicationInfo();

	/**
	 * Method to check if there are any {@link ABESystemError} or
	 * {@link ABEBusinessError} in the command
	 * 
	 * @return
	 */
	public boolean hasErrors();

	/**
	 * Method to check if there are any {@link ABEWarning} in the command
	 * 
	 * @return
	 */
	public boolean hasWarnings();

	/**
	 * Method to check if there are any {@link ABEInfoMessage} in the command
	 * 
	 * @return
	 */
	public boolean hasInfoMessages();
}
