/*
 * ABESystemException.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 23, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.errorhandling.exception;

import com.kcdata.abe.framework.env.ABETier;

/**
 * This exception class is used when there is a system exception caught within
 * the application.
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class ABESystemException extends ABEException {

    /**
	 * Auto generated id
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -245398954721282686L;
	/**
     * This field .
     *
     * @see
     * @since
     */
    private ABESystemError systemErrorCode;

    /**
     * Constructor.
     * @param systemErrorCode ABESystemError
     * @param tier ABETier
     * @param cause cause cause of the exception
     */
    
    public ABESystemException(ABESystemError systemErrorCode, ABETier tier,
            Throwable cause)
    {
        super(tier, cause.getMessage(), cause);
        this.systemErrorCode = systemErrorCode;
    }

    /**
     * Constructor.
     * @param systemErrorCode ABESystemError
     * @param tier ABETier
     * @param internalMessage String value of the error message
     */
    public ABESystemException(ABESystemError systemErrorCode, ABETier tier,
            String internalMessage)
    {
        super(tier, internalMessage, null);
        this.systemErrorCode = systemErrorCode;
    }

    /**
     * This method overrides the default behavior of the getMessage method of
     * the exception class.
     *
     * @return java.lang.String
     *
     * @see
     * @since
     */
    public String getMessage()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("SYSTEM EXCEPTION [ CODE: ");
        sb.append(this.getSystemErrorCode().getErrorCode());
        sb.append(" ] [ DESCRIPTION: ");
        sb.append(this.getSystemErrorCode().getErrorDescription());
        sb.append(" ] - ");
        sb.append(" ] [ DEBUG MESSAGE: ");
        sb.append(this.getSystemErrorCode().getDebugMessage());
        sb.append(" ] - ");
        if (super.getMessage() != null && super.getMessage().length() > 0)
        {
            sb.append(super.getMessage());
        }
        return sb.toString();
    }

    /**
     * @return Returns the errorCode.
     */
    public ABESystemError getSystemErrorCode()
    {
        return systemErrorCode;
    }
	
}
