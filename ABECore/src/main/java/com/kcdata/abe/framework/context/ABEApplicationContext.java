/*
 * ABEApplicationContext.java
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

import com.kcdata.abe.framework.audit.ABEAuditable;

/**
 * Implemented by classes that provide an application wide context. It contains
 * request context, and security context. Request context has
 * its own ID, which is unique per request. The ID can be used for tracking
 * specific user requests by correlating it with user name. N/A for any use case
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface ABEApplicationContext extends ABEAuditable, Serializable {


    /**
     * Getter method for the request context.
     *
     * @return com.kcdata.abe.framework.context.ABERequestContext
     *
     * @see
     * @since
     */
    ABERequestContext getRequestContext();

    /**
     * Setter method for the request context.
     *
     * @param requestContext
     *        com.kcdata.abe.framework.context.ABERequestContext
     *
     * @see
     * @since
     */
    void setRequestContext(ABERequestContext requestContext);

    /**
     * Getter method for the security context.
     *
     * @return com.kcdata.abe.framework.ABESecurityContext
     *
     * @see
     * @since
     */
    ABESecurityContext getSecurityContext();

    /**
     * Setter method for the security context.
     *
     * @param securityContext
     *        com.kcdata.abe.framework.ABESecurityContext
     *
     * @see
     * @since
     */
    void setSecurityContext(ABESecurityContext securityContext);
	
}
