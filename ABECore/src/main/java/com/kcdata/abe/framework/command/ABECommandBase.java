/*
 * ABECommandBase.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 24, 2009  hguntupa
 * Jul 09, 2009  nvittal	  Moved warnings, infoMessages, businessErrors 
 * 							  and imApplicationInfo attributes to public scope
 * 							  for BlazeDS bug
 ******************************************************************************
 */

package com.kcdata.abe.framework.command;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.framework.context.ABEApplicationContext;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABEInfoMessage;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABEWarning;

/**
 * This class is the parent class of all command objects. N/A for any use case.
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public abstract class ABECommandBase implements ABECommand {

	/**
	 * Auto generated id.
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 5083307598155310186L;

	/**
	 * Field carries application context information.
	 * 
	 * @see
	 * @since
	 */
	private ABEApplicationContext applicationContext;

	/*
	 * Imp Note: warnings, infoMessages, businessErrors & imApplicationInfo
	 * attributes are moved to public scope to handle BlazeDS bug. BlazeDS
	 * currently does not capture super class attributes.
	 * 
	 * This fix allows bi-directional flow of required data between Flex & Java
	 */

	/**
	 * This field contains a list of CDQIWarning objects.
	 * 
	 * @see
	 * @since
	 */
	public List<ABEWarning> warnings;

	/**
	 * This field contains a list of Info Mesg objects.
	 * 
	 * @see
	 * @since
	 */
	public List<ABEInfoMessage> infoMessages;

	/**
	 * This field contains a list of ABESystemError objects.
	 * 
	 * @see
	 * @since
	 */
	public List<ABESystemError> systemErrors;

	/**
	 * This field contains a list of ABEBusinessError objects.
	 * 
	 * @see
	 * @since
	 */
	public List<ABEBusinessError> businessErrors;

	/**
	 * Field stores application info object
	 * 
	 * @see
	 * @since
	 */
	public IMApplicationInfo imApplicationInfo;

	/**
	 * @return the imApplicationInfo
	 */
	public IMApplicationInfo getIMApplicationInfo() {
		return imApplicationInfo;
	}

	/**
	 * @param imApplicationInfo
	 *            the imApplicationInfo to set
	 */
	public void setIMApplicationInfo(IMApplicationInfo imApplicationInfo) {
		this.imApplicationInfo = imApplicationInfo;
	}

	/**
	 * Adds the business error to the list
	 * 
	 * @param warning
	 * 
	 * @see
	 * @since
	 */

	public void addWarning(ABEWarning warning) {
		if (warnings == null) {
			warnings = new ArrayList<ABEWarning>();
		}
		warnings.add(warning);
	}

	/**
	 * Adds the info message to the list
	 * 
	 * @param info
	 *            message
	 * 
	 * @see
	 * @since
	 */

	public void addInfoMessage(ABEInfoMessage infoMessage) {
		if (infoMessages == null) {
			infoMessages = new ArrayList<ABEInfoMessage>();
		}
		infoMessages.add(infoMessage);
	}

	/**
	 * Adds error to the list
	 * 
	 * @param warning
	 * 
	 * @see
	 * @since
	 */

	public void addBusinessError(ABEBusinessError warning) {
		if (businessErrors == null) {
			businessErrors = new ArrayList<ABEBusinessError>();
		}
		businessErrors.add(warning);
	}

	/**
	 * Adds error to the list
	 * 
	 * @param systemError
	 * 
	 * @see
	 * @since
	 */

	public void addSystemError(ABESystemError systemError) {
		if (systemErrors == null) {
			systemErrors = new ArrayList<ABESystemError>();
		}
		systemErrors.add(systemError);
	}
	
	/**
	 * This method returns the application context object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public ABEApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * @return the systemErrors
	 */
	public List<ABESystemError> getSystemErrors() {
		return systemErrors;
	}

	/**
	 * @param systemErrors
	 *            the systemErrors to set
	 */
	public void setSystemErrors(List<ABESystemError> systemErrors) {
		this.systemErrors = systemErrors;
	}

	/**
	 * This method returns the errors list
	 * 
	 * @return list of errors
	 * 
	 * @see
	 * @since
	 */

	public List<ABEBusinessError> getBusinessErrors() {
		return businessErrors;
	}

	/**
	 * This method returns the list of warnings
	 * 
	 * @return List of warnings
	 * 
	 * @see
	 * @since
	 */

	public List<ABEWarning> getWarnings() {
		return warnings;
	}

	/**
	 * This method returns the list of info messages
	 * 
	 * @return List of info messages
	 * 
	 * @see
	 * @since
	 */

	public List<ABEInfoMessage> getInfoMessages() {
		return infoMessages;
	}

	/**
	 * This method sets the errors list
	 * 
	 * @param errors
	 * 
	 * @see
	 * @since
	 */

	public void setBusinessErrors(List<ABEBusinessError> businessErrors) {
		this.businessErrors = businessErrors;
	}

	/**
	 * this method sets the application context
	 * 
	 * @param applicationContext
	 * 
	 * @see
	 * @since
	 */
	public void setApplicationContext(ABEApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	/**
	 * This method sets the warnings list
	 * 
	 * @param warnings
	 * 
	 * @see
	 * @since
	 */
	public void setWarnings(List<ABEWarning> warnings) {
		this.warnings = warnings;
	}

	/**
	 * This method sets the info messages list
	 * 
	 * @param infoMessages
	 * 
	 * @see
	 * @since
	 */
	public void setInfoMessages(List<ABEInfoMessage> infoMessages) {
		this.infoMessages = infoMessages;
	}

	/**
	 * Method to check if there are any {@link ABESystemError} or
	 * {@link ABEBusinessError} in the command
	 * 
	 * @return
	 */
	public boolean hasErrors() {
		if((this.systemErrors != null && this.systemErrors.size() > 0) ||
				(this.businessErrors != null && this.businessErrors.size() > 0)) {
			return true;
		}
		return false;
	}

	/**
	 * Method to check if there are any {@link ABEWarning} in the command
	 * 
	 * @return
	 */
	public boolean hasWarnings() {
		if(this.warnings != null && this.warnings.size() > 0) {
			return true;
		}
		return false;		
	}

	/**
	 * Method to check if there are any {@link ABEInfoMessage} in the command
	 * 
	 * @return
	 */
	public boolean hasInfoMessages() {
		if(this.infoMessages != null && this.infoMessages.size() > 0) {
			return true;
		}
		return false;				
	}
}
