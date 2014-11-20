/*
 * ABERequestContext.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 23, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.context;

import java.io.Serializable;
import java.util.Date;

import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.framework.audit.ABEAuditable;
import com.kcdata.abe.framework.env.ABETier;

/**
 * This interface is implemented by ABERequestContextImpl.
 * N/A for any use case.
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface ABERequestContext extends Serializable, ABEAuditable
{
    /**
     * Getter method for request UID field.
     *
     * @return Request UID in String format
     *
     * @see
     * @since
     */
    String getRequestId();

    /**
     * Getter method for request tier field.
     *
     * @return request tier
     *
     * @see
     * @since
     */
    ABETier getRequestTier();

    /**
     * Setter method for request tier field.
     *
     * @param requestTier request tier
     *
     * @see
     * @since
     */
    void setRequestTier(ABETier requestTier);

    /**
     * Getter method for request time field.
     *
     * @return request time in java.util.Date format
     *
     * @see
     * @since
     */
    Date getRequestTime();

    /**
     * Setter method for request time field.
     *
     * @param requestTime java.util.Date
     *
     * @see
     * @since
     */
    void setRequestTime(Date requestTime);

    /**
     * Setter method for request UID field.
     *
     * @param requestId java.lang.String
     *
     * @see
     * @since
     */
    void setRequestId(String requestId);
    
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
}
