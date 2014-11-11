/*
 * BAPIExecutionManagerImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 26, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.sap;

import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.context.MessageSource;
import org.springframework.util.ClassUtils;

import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.framework.logging.ABELogger;
import com.sap.aii.proxy.framework.core.AbstractProxy;
import com.sap.mw.jco.JCO;

/**
 * Class for executing the BAPI N/A for any usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class BAPIExecutionManagerImpl implements BAPIExecutionManager {

	/**
	 * Instance of Logger
	 */
	ABELogger logger = ABELogger.getLogger("bapi.performance.log");

	/**
	 * Spring MessageSource object
	 */
	private MessageSource messageSource;

	/**
	 * SAPClientFactory object
	 */
	SAPClientFactory sapClientFactory;

	/**
	 * Method to execute the BAPI
	 * 
	 * @param name
	 *            - Name of the BAPI to be executed
	 * @param input
	 *            - Input for the BAPI
	 * @return response of the BAPI along with error messages
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	
	public Object executeBAPI(String bapiName, Object input) {
		JCO.Client jcoClient = null;
		try {
			// Construct BAPI PortType class
			String portTypeClassName = "com.kcdata.abe.bapi." + bapiName + "_PortType";
			//Class portTypeClass = Class.forName(portTypeClassName);
			Class portTypeClass = ClassUtils.getDefaultClassLoader().loadClass(portTypeClassName);
			AbstractProxy portTypeObject = (AbstractProxy) portTypeClass
					.newInstance();
			// Construct BAPI Input type class
			String inputClassName = "com.kcdata.abe.bapi." + bapiName + "_Input";
			
			Class inputClass = ClassUtils.getDefaultClassLoader().loadClass(inputClassName);
			String methodName = bapiName.substring(0,1).toLowerCase() + bapiName.substring(1);
			// Get the BAPI method object
			Method bapiMethod = portTypeClass.getMethod(methodName, inputClass);
			if (bapiMethod != null) {
				// Get connection
				jcoClient = sapClientFactory.getSAPClient();
				// Set connection for execution
				portTypeObject.messageSpecifier.setJcoClient(jcoClient);
				Date startTime = new Date();
				// Execute BAPI
				Object output = bapiMethod.invoke(portTypeClass
						.cast(portTypeObject), inputClass.cast(input));				
				logger.debug("Execution of BAPI: "+bapiName+" completed. Total time for execution(in milliSeconds):"+ (new Date().getTime() - startTime.getTime()));
				return output;
			}
			// Release JCO Client
		} catch (IllegalArgumentException iae) {
			ABESystemError systemError = new ABESystemError(
					"BAPI_ILLEGAL_ARGUMENT_ERROR", messageSource.getMessage(
							"BAPI_ILLAGAL_ARGUMENT_ERROR",
							new Object[] { bapiName }, null));
			throw new ABESystemException(systemError, ABETier.ABAP, iae);
		} catch (Exception e) {
			ABESystemError systemError = new ABESystemError(
					"BAPI_EXECUTION_ERROR", messageSource.getMessage(
							"BAPI_EXECUTION_ERROR",
							new Object[] { bapiName }, null));
			throw new ABESystemException(systemError, ABETier.ABAP, e);
		} finally {
			if (jcoClient != null) {
				sapClientFactory.releaseSAPClient(jcoClient);
			}
		}
		return null;
	}

	/**
	 * Method to set the MessageSource
	 * 
	 * @param messageSource
	 * 
	 * @see
	 * @since
	 */
	
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	/**
	 * @return the sapClientFactory
	 */
	public SAPClientFactory getSapClientFactory() {
		return sapClientFactory;
	}

	/**
	 * @param sapClientFactory
	 *            the sapClientFactory to set
	 */
	public void setSapClientFactory(SAPClientFactory sapClientFactory) {
		this.sapClientFactory = sapClientFactory;
	}

}
