/*
 * SAPLogonProperties.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 24, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.sap;

import java.io.Serializable;

/**
 * Class holds all the properties of SAP System N/A for any use case
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class SAPLogonProperties implements Serializable {

	/**
	 * 	Auto generated sequence id
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 9159463120776061763L;

	/**
	 * Field to hold the SAP POOL NAME
	 */
	private String poolName;

	/**
	 * Field to hold max. number of connections allowed for the pool
	 */
	private int maxConnections;

	/**
	 * Field to hold SAP logon client
	 */
	private String client;

	/**
	 * Field to hold SAP logon user
	 */
	private String user;

	/**
	 * Field to hold SAP logon password
	 */
	private String passwd;

	/**
	 * Field to hold SAP logon language
	 */
	private String lang;

	/**
	 * Field to hold Host name of the application server
	 */
	private String ashost;

	/**
	 * Field to hold SAP system number
	 */
	private String sysnr;

	/**
	 * Field to hold Host name of the SAP gateway
	 */
	private String gwhost;

	/**
	 * Field to hold Service number of the SAP gateway
	 */
	private String gwserv;

	/**
	 * Field to hold name of the message server
	 */
	private String mshost;

	/**
	 * Field to hold Name of the SAP system
	 */
	private String r3Name;

	/**
	 * Field to hold the connection mode
	 */
	private String loadBalanced;

	/**
	 * Field to hold Name of the group of application servers
	 */
	private String group;

	/**
	 * Debug mode
	 */
	private String debugMode;
	
	/**
	 * Field to hold max. time to wait in a connection request when a pool is exhausted.
	 */
	private int maxWaitTime;
	
	/**
	 * Sets the new connection timeout (in milliseconds)
	 */
	private int connectionTimeout;
	
	/**
	 * Sets the timeout check period (in milliseconds), i.e. the time after which all connections are being checked for timeouts periodically
	 */
	private int timeoutCheckPeriod;

	/**
	 * @return the poolName
	 */
	public String getPoolName() {
		return poolName;
	}

	/**
	 * @param poolName
	 *            the poolName to set
	 */
	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}

	/**
	 * @return the maxConnections
	 */
	public int getMaxConnections() {
		return maxConnections;
	}

	/**
	 * @param maxConnections
	 *            the maxConnections to set
	 */
	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}

	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd
	 *            the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * @param lang
	 *            the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 * @return the ashost
	 */
	public String getAshost() {
		return ashost;
	}

	/**
	 * @param ashost
	 *            the ashost to set
	 */
	public void setAshost(String ashost) {
		this.ashost = ashost;
	}

	/**
	 * @return the sysnr
	 */
	public String getSysnr() {
		return sysnr;
	}

	/**
	 * @param sysnr
	 *            the sysnr to set
	 */
	public void setSysnr(String sysnr) {
		this.sysnr = sysnr;
	}

	/**
	 * @return the gwhost
	 */
	public String getGwhost() {
		return gwhost;
	}

	/**
	 * @param gwhost
	 *            the gwhost to set
	 */
	public void setGwhost(String gwhost) {
		this.gwhost = gwhost;
	}

	/**
	 * @return the gwserv
	 */
	public String getGwserv() {
		return gwserv;
	}

	/**
	 * @param gwserv
	 *            the gwserv to set
	 */
	public void setGwserv(String gwserv) {
		this.gwserv = gwserv;
	}

	/**
	 * @return the mshost
	 */
	public String getMshost() {
		return mshost;
	}

	/**
	 * @param mshost
	 *            the mshost to set
	 */
	public void setMshost(String mshost) {
		this.mshost = mshost;
	}

	/**
	 * @return the r3Name
	 */
	public String getR3Name() {
		return r3Name;
	}

	/**
	 * @param name
	 *            the r3Name to set
	 */
	public void setR3Name(String name) {
		r3Name = name;
	}

	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * @param group
	 *            the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * @return the loadBalanced
	 */
	public String getLoadBalanced() {
		return loadBalanced;
	}

	/**
	 * @param loadBalanced
	 *            the loadBalanced to set
	 */
	public void setLoadBalanced(String loadBalanced) {
		this.loadBalanced = loadBalanced;
	}

	/**
	 * @return the debugMode
	 */
	public String getDebugMode() {
		return debugMode;
	}

	/**
	 * @param debugMode
	 *            the debugMode to set
	 */
	public void setDebugMode(String debugMode) {
		this.debugMode = debugMode;
	}

	/**
	 * @return the maxWaitTime
	 */
	public int getMaxWaitTime() {
		return maxWaitTime;
	}

	/**
	 * @param maxWaitTime the maxWaitTime to set
	 */
	public void setMaxWaitTime(int maxWaitTime) {
		this.maxWaitTime = maxWaitTime;
	}

	/**
	 * @return the connectionTimeout
	 */
	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	/**
	 * @param connectionTimeout the connectionTimeout to set
	 */
	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	/**
	 * @return the timeoutCheckPeriod
	 */
	public int getTimeoutCheckPeriod() {
		return timeoutCheckPeriod;
	}

	/**
	 * @param timeoutCheckPeriod the timeoutCheckPeriod to set
	 */
	public void setTimeoutCheckPeriod(int timeoutCheckPeriod) {
		this.timeoutCheckPeriod = timeoutCheckPeriod;
	}
}
