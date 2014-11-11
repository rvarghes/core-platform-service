/*
 * ABERequestContextImpl.java
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

import java.util.Date;

import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.util.ABEUniqueIdGenerator;

/**
 * This class holds the Request information
 * N/A for any specific usecase
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class ABERequestContextImpl implements ABERequestContext {

    /**
	 * Auto generated id
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3727535070585328708L;

	/**
     * Field represents the request UID.
     *
     * @see
     * @since
     */
    private String requestId;

    /**
     * Field represents the time the request is submitted.
     *
     * @see
     * @since
     */
    private Date requestTime;

    /**
     * Field represents the tier where the request is originated.
     *
     * @see
     * @since
     */
    private ABETier requestTier;

	/**
	 * Field stores application info object
	 *
	 * @see
	 * @since
	 */
	private IMApplicationInfo imApplicationInfo;
    
    /**
     * Constructor.
     */
    public ABERequestContextImpl()
    {
        requestId = ABEUniqueIdGenerator.generateUniqueID();
    }

    /**
     * This method is used to return textual audit information.
     *
     * @return String audit information in textual format.
     *
     * @see
     * @since
     */
    
    public String getAuditText()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("## REQUEST CONTEXT DUMP ##");
        sb.append("\n[REQUEST ID: ");
        sb.append(requestId);
        sb.append("]\n[REQUEST TIME: ");
        sb.append(requestTime.toString());
        sb.append("]\n[REQUEST SOURCE CODE: ");
        sb.append(requestTier.getTier());
        sb.append("]\n");
        if(this.getIMApplicationInfo() != null)
        {
            sb.append(this.getIMApplicationInfo().toString());
            sb.append("]\n");        	
        }
        return sb.toString();
    }

    /**
     * @return Returns the requestTier.
     */
    
    public ABETier getRequestTier()
    {
        return requestTier;
    }

    /**
     * @param requestTier The requestTier to set.
     */
    
    public void setRequestTier(ABETier requestTier)
    {
        this.requestTier = requestTier;
    }

    /**
     * @return Returns the requestTime.
     */
    
    public Date getRequestTime()
    {
        return requestTime;
    }

    /**
     * @param requestTime The requestTime to set.
     */
    
    public void setRequestTime(Date requestTime)
    {
        this.requestTime = requestTime;
    }

    /**
     * @return Returns the requestId.
     */
    
    public String getRequestId()
    {
        return requestId;
    }

    /**
     * @param requestId The requestId to set.
     */
    
    public void setRequestId(String requestId)
    {
        this.requestId = requestId;
    }

	/**
	 * @return the imApplicationInfo
	 */
	public IMApplicationInfo getIMApplicationInfo() {
		return imApplicationInfo;
	}

	/**
	 * @param imApplicationInfo the imApplicationInfo to set
	 */
	public void setIMApplicationInfo(IMApplicationInfo imApplicationInfo) {
		this.imApplicationInfo = imApplicationInfo;
	}    
}
