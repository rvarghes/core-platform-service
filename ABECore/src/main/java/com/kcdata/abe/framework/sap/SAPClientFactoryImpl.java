/*
 * SAPClientFactoryImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 25, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.sap;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.MessageSource;

import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.framework.logging.ABELogger;
import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.Client;

/**
 * Factory class to manage SAP Client connections N/A for any use case
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class SAPClientFactoryImpl implements SAPClientFactory, FactoryBean<SAPClientFactory>, DisposableBean {

	/**
	 * Instance of Logger
	 */
	ABELogger logger = ABELogger.getLogger(SAPClientFactoryImpl.class);

	/**
	 * Spring MessageSource object
	 */
	private MessageSource messageSource;

	/**
	 * Auto generated sequence id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 5616326505125725689L;

	/**
	 * Holds the SAP Logon properties
	 */
	private SAPLogonProperties sapLogonProperties;

	/**
	 * Holds JCO Pool
	 */
	private JCO.Pool clientPool;

	/**
	 * Default constructor
	 */
	public SAPClientFactoryImpl() {
	}

	/**
	 * Method returns the JCO.Client object
	 * 
	 * @return Client - JCO.client object
	 * 
	 * @see
	 * @since
	 */
	
	public Client getSAPClient() {
		// Check pool is available
		if (this.clientPool == null) {
			ABESystemError systemError = new ABESystemError(
					"JCO_ERROR_NO_POOL_AVAILABLE", messageSource.getMessage(
							"JCO_ERROR_NO_POOL_AVAILABLE", null, null));
			throw new ABESystemException(systemError, ABETier.ABAP, "");
		}
		JCO.Client client;
		try {
			JCO.PoolManager poolManager = this.clientPool.getPoolManager();
			client = poolManager.getClient(this.clientPool.getName());
			if(this.sapLogonProperties.getDebugMode().equalsIgnoreCase(Boolean.TRUE.toString()))
			{
				client.setAbapDebug(true);
			}
		} catch (JCO.Exception e) {
			int exceptionGroup = e.getGroup();
			ABESystemError systemError = null;
			switch (exceptionGroup) {
			case JCO.Exception.JCO_ERROR_COMMUNICATION:
				systemError = new ABESystemError("JCO_ERROR_COMMUNICATION",
						messageSource.getMessage("JCO_ERROR_COMMUNICATION",
								null, null));
			case JCO.Exception.JCO_ERROR_LOGON_FAILURE:
				systemError = new ABESystemError("JCO_ERROR_LOGON_FAILURE",
						messageSource.getMessage("JCO_ERROR_LOGON_FAILURE",
								null, null));
			case JCO.Exception.JCO_ERROR_SYSTEM_FAILURE:
				systemError = new ABESystemError("JCO_ERROR_SYSTEM_FAILURE",
						messageSource.getMessage("JCO_ERROR_SYSTEM_FAILURE",
								null, null));
			case JCO.Exception.JCO_ERROR_RESOURCE:
				systemError = new ABESystemError("JCO_ERROR_RESOURCE",
						messageSource.getMessage("JCO_ERROR_RESOURCE", null,
								null));
			default:
				systemError = new ABESystemError("JCO_ERROR_UNABLE_GET_CLIENT",
						messageSource.getMessage("JCO_ERROR_UNABLE_GET_CLIENT",
								null, null));
			}
			throw new ABESystemException(systemError, ABETier.ABAP, e);

		} catch (Exception ex) {
			ABESystemError systemError = new ABESystemError(
					"JCO_ERROR_UNABLE_GET_CLIENT", messageSource.getMessage(
							"JCO_ERROR_UNABLE_GET_CLIENT", null, null));
			throw new ABESystemException(systemError, ABETier.ABAP, ex);
		}
		return client;
	}

	/**
	 * @return the sapLogonProperties
	 */
	public SAPLogonProperties getSapLogonProperties() {
		return sapLogonProperties;
	}

	/**
	 * @param sapLogonProperties the sapLogonProperties to set
	 */
	public void setSapLogonProperties(SAPLogonProperties sapLogonProperties) {
		this.sapLogonProperties = sapLogonProperties;
	}

	/**
	 * Method to release the SAP Client
	 * 
	 * @param sapClient
	 * 
	 * @see
	 * @since
	 */
	
	public void releaseSAPClient(Client sapClient) {
		try {
			JCO.releaseClient(sapClient);
		} catch (Exception e) {
			logger.fatal(messageSource.getMessage(
					"JCO_ERROR_UNABLE_RELEASE_CLIENT", null, null));
		}
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
	 * Factory Bean Life cycle call back method
	 *
	 * @return
	 * @throws Exception
	 *
	 * @see
	 * @since
	 */
	
	public SAPClientFactory getObject() throws Exception {
		// Create the Connection Pool and hold the pool manager instance
		try {
			// Retrieve if pool is already exists with the given name
			clientPool = JCO.getClientPoolManager().getPool(
					sapLogonProperties.getPoolName());
			if (clientPool == null) {
				// Pool not exist
				String isLoadBalanced = sapLogonProperties.getLoadBalanced();
				// Check for Load Balanced environment or not
				if (Boolean.TRUE.toString().equals(isLoadBalanced)) {
					// Load balanced
					logger.trace("Connecting to Load balanced environment");
					JCO
							.addClientPool(sapLogonProperties.getPoolName(),
									sapLogonProperties.getMaxConnections(),
									sapLogonProperties.getClient(),
									sapLogonProperties.getUser(),
									sapLogonProperties.getPasswd(),
									sapLogonProperties.getLang(),
									sapLogonProperties.getMshost(),
									sapLogonProperties.getR3Name(),
									sapLogonProperties.getGroup());
				} else {
					// Non load balanced environment
					// Check for gateway exists or not
					if (sapLogonProperties.getGwhost() == null
							|| sapLogonProperties.getGwserv() == null) {
						// Gateway not exist. Connect directly to Server
						logger
								.trace("Connecting to non load balanced environment");
						JCO.addClientPool(sapLogonProperties.getPoolName(),
								sapLogonProperties.getMaxConnections(),
								sapLogonProperties.getClient(),
								sapLogonProperties.getUser(),
								sapLogonProperties.getPasswd(),
								sapLogonProperties.getLang(),
								sapLogonProperties.getAshost(),
								sapLogonProperties.getSysnr());
					} else {
						// Gateway exists. Connect using the Gateway
						logger
								.trace("Connecting non-load balanced environement using the Gateway");
						JCO.addClientPool(sapLogonProperties.getPoolName(),
								sapLogonProperties.getMaxConnections(),
								sapLogonProperties.getClient(),
								sapLogonProperties.getUser(),
								sapLogonProperties.getPasswd(),
								sapLogonProperties.getLang(),
								sapLogonProperties.getAshost(),
								sapLogonProperties.getSysnr(),
								sapLogonProperties.getGwhost(),
								sapLogonProperties.getGwserv());
					}
				}
				clientPool = JCO.getClientPoolManager().getPool(
						sapLogonProperties.getPoolName());
				clientPool.setMaxWaitTime(sapLogonProperties.getMaxWaitTime());
				JCO.PoolManager poolManager = clientPool.getPoolManager();
				poolManager.setConnectionTimeout(sapLogonProperties
						.getConnectionTimeout());
				poolManager.setTimeoutCheckPeriod(sapLogonProperties
						.getTimeoutCheckPeriod());
			}
		} catch (JCO.Exception e) {
			int exceptionGroup = e.getGroup();
			ABESystemError systemError = null;
			switch (exceptionGroup) {
			case JCO.Exception.JCO_ERROR_COMMUNICATION:
				systemError = new ABESystemError("JCO_ERROR_COMMUNICATION",
						messageSource.getMessage("JCO_ERROR_COMMUNICATION",
								null, null));
			case JCO.Exception.JCO_ERROR_LOGON_FAILURE:
				systemError = new ABESystemError("JCO_ERROR_LOGON_FAILURE",
						messageSource.getMessage("JCO_ERROR_LOGON_FAILURE",
								null, null));
			case JCO.Exception.JCO_ERROR_SYSTEM_FAILURE:
				systemError = new ABESystemError("JCO_ERROR_SYSTEM_FAILURE",
						messageSource.getMessage("JCO_ERROR_SYSTEM_FAILURE",
								null, null));
			default:
				systemError = new ABESystemError(
						"JCO_ERROR_UNABLE_CREATE_POOL", messageSource
								.getMessage("JCO_ERROR_UNABLE_CREATE_POOL",
										null, null));
			}
			throw new ABESystemException(systemError, ABETier.ABAP, e);

		} catch (Exception ex) {
			ABESystemError systemError = new ABESystemError(
					"JCO_ERROR_UNABLE_CREATE_POOL", messageSource.getMessage(
							"JCO_ERROR_UNABLE_CREATE_POOL", null, null));
			throw new ABESystemException(systemError, ABETier.ABAP, ex);
		}
		return this;
	}

	/**
	 * Factroy bean lifecycle callback method
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public Class<? extends SAPClientFactory> getObjectType() {
		return SAPClientFactory.class;
	}

	/**
	 * Bean Life cycle callback method
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public boolean isSingleton() {
		return true;
	}

	/**
	 * DisposableBean destroy method to remove the SAP connection pool
	 *
	 * @throws Exception
	 *
	 * @see
	 * @since
	 */
	
	public void destroy() throws Exception {
		if (clientPool != null) {
			JCO.PoolManager poolManager = this.clientPool.getPoolManager();
			poolManager.removePool(this.clientPool.getName());
		}
	}

}
