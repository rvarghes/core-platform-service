/*
 * ABEApplicationContextImpl.java
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

/**
 * This class provides an application wide context. It contains request context,
 * and security context. Request context has its own ID, which is unique per
 * request. The ID can be used for tracking specific user requests by
 * correlating it with user name. Security Context holds information about the
 * current user if logged on, null otherwise. N/A for any use case.
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ABEApplicationContextImpl implements ABEApplicationContext {

	/**
	 * Auto generated id
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -5930014837640844393L;

	/**
	 * This field holds the request context information
	 */
	private ABERequestContext requestContext;

	/**
	 * This field holds the Security context information
	 */
	private ABESecurityContext securityContext;

    /**
     * Constructor.
     * This constructor initializes security context, request context and
     * application session.
     */
    public ABEApplicationContextImpl()
    {
        securityContext = new ABESecurityContextImpl();
        requestContext = new ABERequestContextImpl();
    }
    
	/**
	 * Getter method for the request context.
	 * 
	 * @return com.kcdata.abe.framework.context.ABERequestContext
	 * 
	 * @see
	 * @since
	 */
	
	public ABERequestContext getRequestContext() {
		return this.requestContext;
	}

	/**
	 * Getter method for the security context.
	 * 
	 * @return com.kcdata.abe.framework.ABESecurityContext
	 * 
	 * @see
	 * @since
	 */
	
	public ABESecurityContext getSecurityContext() {
		return this.securityContext;
	}

	/**
	 * Setter method for the request context.
	 * 
	 * @param requestContext
	 *            com.kcdata.abe.framework.context.ABERequestContext
	 * 
	 * @see
	 * @since
	 */
	
	public void setRequestContext(ABERequestContext requestContext) {
		this.requestContext = requestContext;
	}

	/**
	 * Setter method for the security context.
	 * 
	 * @param securityContext
	 *            com.kcdata.abe.framework.ABESecurityContext
	 * 
	 * @see
	 * @since
	 */
	
	public void setSecurityContext(ABESecurityContext securityContext) {
		this.securityContext = securityContext;
	}

    /**
     * This method is a implementation of getAuditText method defined in the
     * Audible interface.  This method returns a string that represents the
     * internal states of the application context.
     *
     * @return String representation of the internal states of the application
     * context
     *
     * @see
     * @since
     */
	
	public String getAuditText() {
        StringBuilder sb = new StringBuilder();
        sb.append("####  APPLICATION CONTEXT DUMP  ####\n\n");
        if(requestContext != null){
            sb.append(requestContext.getAuditText());
            sb.append("\n");        	
        }
        if(securityContext != null){
            sb.append(securityContext.getAuditText());
            sb.append("\n");        	
        }
        return sb.toString();
	}

}
