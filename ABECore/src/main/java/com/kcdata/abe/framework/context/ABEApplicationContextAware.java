/*
 * ABEApplicationContextAware.java
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
 * All object needs to be aware of the application wide context implements
 * this interface.
 * N/A for any use case.
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface ABEApplicationContextAware
{

    /**
     * Getter method for application context factory.
     *
     * @return a instance of the application context factory
     *
     * @see
     * @since
     */
    ABEApplicationContextFactory getApplicationContextFactory();

    /**
     * Setter method for the application context factory.
     *
     * @param applicationContextFactory can be any class that implements
     *        com.kcdata.abe.framework.context.ABEApplicationContextFactory
     *
     * @see com.kcdata.abe.framework.context.ABEApplicationContextFactory
     * @since
     */
    void setApplicationContextFactory(
    		ABEApplicationContextFactory applicationContextFactory);
}
