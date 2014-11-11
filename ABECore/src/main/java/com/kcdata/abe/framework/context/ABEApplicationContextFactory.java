/*
 * ABEApplicationContextFactory.java
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
 * This interface is implemented by ABEApplicationContextFactoryImpl class
 * N/A for any use case.
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface ABEApplicationContextFactory {
	
    /**
     * This method create a new application context and set it to threadlocal.
     * If there is an existing application context in the threadlocal already,
     * this method creates a new application context and replases the existing
     * application context with it.
     *
     * @return a new instance of application context
     *
     * @see
     * @since
     */
    ABEApplicationContext create();

    /**
     * This method create a new application context.
     *
     * @return a new instance of application context
     *
     * @see
     * @since
     */
    ABEApplicationContext createWithoutSetThreadLocal();

    /**
     * This method places the application context passed to the method as the
     * parameter into threadlocal.  If there is an existing application context
     * in the threadlocal, then this method will replace the existing one with
     * the one passed to it as the parameter.
     *
     * @param ctx any object implements ABEApplicationContext
     * @return the same ABEApplicationContext being passed to the method
     *
     * @see
     * @since
     */
    ABEApplicationContext create(ABEApplicationContext ctx);

    /**
     * Getter method for the application context currently stored in the
     * threadlocal.
     *
     * @return application context currently stored in the threadlocal
     *         ABEApplicationContext
     *
     * @see
     * @since
     */
    ABEApplicationContext getApplicationContext();

    /**
     * This mehtod removes the application context from the threadlocal.
     *
     *
     * @see
     * @since
     */
    void delete();
}
