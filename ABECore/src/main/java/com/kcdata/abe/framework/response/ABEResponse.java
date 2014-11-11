/*
 * ABEResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 24, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABEInfoMessage;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABEWarning;

/**
 * This class holds both response data and response status information. N/A for
 * any use case.
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ABEResponse implements Serializable {

	/**
	 * Auto generated id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3522606263066854088L;

	/**
	 * This field contains a list of system error codes as part of the response.
	 * 
	 * @see
	 * @since
	 */
	private List<ABESystemError> systemErrors;

	/**
	 * This field contains a list of error codes as part of the response.
	 * 
	 * @see
	 * @since
	 */
	private List<ABEBusinessError> businessErrors;

	/**
	 * This field is a list of information messages as part of the response.
	 * 
	 * @see
	 * @since
	 */
	private List<ABEInfoMessage> infoMessages;

	/**
	 * This field is a list of business events as part of the response.
	 * 
	 * @see
	 * @since
	 */
	private List<ABEWarning> warnings;

	/**
	 * This method process response object's business errors, warnings and info
	 * messages
	 * 
	 * @param response
	 *            response object being processed
	 * 
	 * @see
	 * @since
	 */
	public void processResponse(ABEResponse response) {
		if (response != null) {
			this.saveSystemErrors(response.getSystemErrors());
			this.saveBusinessErrors(response.getBusinessErrors());
			this.saveWarnings(response.getWarnings());
			this.saveInfoMessages(response.getInfoMessages());
		}
	}

	/**
	 * This method append a new error to the existing list of errors.
	 * 
	 * @param businessError
	 *            a new business error
	 * 
	 * @see
	 * @since
	 */
	public void saveSystemError(ABESystemError systemError) {
		if (systemErrors == null) {
			systemErrors = new ArrayList<ABESystemError>();
		}
		systemErrors.add(systemError);
	}

	/**
	 * This method appends a list of business error to the existing list of
	 * business erros.
	 * 
	 * @param systemErrors
	 *            a list of new system errors
	 * 
	 * @see
	 * @since
	 */
	public void saveSystemErrors(List<ABESystemError> systemErrors) {
		if (systemErrors != null && systemErrors.size() > 0) {
			if (this.getSystemErrors() == null) {
				this.systemErrors = new ArrayList<ABESystemError>();
			}
			this.systemErrors.addAll(systemErrors);
		}
	}

	/**
	 * This method append a new error to the existing list of errors.
	 * 
	 * @param businessError
	 *            a new business error
	 * 
	 * @see
	 * @since
	 */
	public void saveBusinessError(ABEBusinessError businessError) {
		if (businessErrors == null) {
			businessErrors = new ArrayList<ABEBusinessError>();
		}
		businessErrors.add(businessError);
	}

	/**
	 * This method appends a list of business error to the existing list of
	 * business erros.
	 * 
	 * @param businessErrors
	 *            a list of new business errors
	 * 
	 * @see
	 * @since
	 */
	public void saveBusinessErrors(List<ABEBusinessError> businessErrors) {
		if (businessErrors != null && businessErrors.size() > 0) {
			if (this.getBusinessErrors() == null) {
				this.businessErrors = new ArrayList<ABEBusinessError>();
			}
			this.businessErrors.addAll(businessErrors);
		}
	}

	/**
	 * This method append the new event to the existing list of events.
	 * 
	 * @param infoMessage
	 *            a new information message
	 * 
	 * @see
	 * @since
	 */
	public void saveInfoMessage(ABEInfoMessage infoMessage) {
		if (infoMessages == null) {
			infoMessages = new ArrayList<ABEInfoMessage>();
		}
		infoMessages.add(infoMessage);
	}

	/**
	 * This method appends a list of info message to the existing list.
	 * 
	 * @param infoMessages
	 *            a list of new info messages
	 * 
	 * @see
	 * @since
	 */
	public void saveInfoMessages(List<ABEInfoMessage> infoMessages) {
		if (infoMessages != null && infoMessages.size() > 0) {
			if (this.infoMessages == null) {
				this.infoMessages = new ArrayList<ABEInfoMessage>();
			}
			this.infoMessages.addAll(infoMessages);
		}
	}

	/**
	 * This method append the new event to the existing list of events.
	 * 
	 * @param warning
	 *            a new warning
	 * 
	 * @see
	 * @since
	 */
	public void saveWarning(ABEWarning warning) {
		if (warnings == null) {
			warnings = new ArrayList<ABEWarning>();
		}
		warnings.add(warning);
	}

	/**
	 * This method appends a list of warnings to the existing list of warnings.
	 * 
	 * @param warnings
	 *            a list of new warnings
	 * 
	 * @see
	 * @since
	 */
	public void saveWarnings(List<ABEWarning> warnings) {
		if (warnings != null && warnings.size() > 0) {
			if (this.warnings == null) {
				this.warnings = new ArrayList<ABEWarning>();
			}
			this.warnings.addAll(warnings);
		}
	}

	/**
	 * This method checks if the response contains any system errors.
	 * 
	 * @return boolean try if there is at least one error, and false if there is
	 *         no error at all
	 * 
	 * @see
	 * @since
	 */
	public boolean isSystemErrorOccurred() {
		if (this.getSystemErrors() == null
				|| this.getSystemErrors().size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * This method checks if the response contains any business error.
	 * 
	 * @return boolean try if there is at least one error, and false if there is
	 *         no error at all
	 * 
	 * @see
	 * @since
	 */
	public boolean isBusinessErrorOccurred() {
		if (this.getBusinessErrors() == null
				|| this.getBusinessErrors().size() == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * This method checks if the response contains any business error or system errors.
	 * 
	 * @return boolean try if there is at least one error, and false if there is
	 *         no error at all
	 * 
	 * @see
	 * @since
	 */
	public boolean isErrorsOccurred() {
		return isSystemErrorOccurred() || isBusinessErrorOccurred();
	}

	/**
	 * This method checks if the response contains any event.
	 * 
	 * @return boolean try if there is at least one error, and false if there is
	 *         no error at all
	 * 
	 * @see
	 * @since
	 */
	public boolean isWarningOccurred() {
		if (this.getWarnings() == null || this.getWarnings().size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @return the systemErrors
	 */
	public List<ABESystemError> getSystemErrors() {
		return systemErrors;
	}

	/**
	 * @return Returns the businessErrors.
	 */
	public List<ABEBusinessError> getBusinessErrors() {
		return businessErrors;
	}

	/**
	 * @return Returns the infoMessages.
	 */
	public List<ABEInfoMessage> getInfoMessages() {
		return infoMessages;
	}

	/**
	 * @return Returns the warnings.
	 */
	public List<ABEWarning> getWarnings() {
		return warnings;
	}
}
