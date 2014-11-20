/*
 * ABEApplicationContextFactoryImpl.java
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
 * This class is a factory class for creating, retrieving and removing
 * appplication context from the threadlocal.
 * N/A for any use case.
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class ABEApplicationContextFactoryImpl implements
		ABEApplicationContextFactory {

    /**
     * A static field that holds application context information in the
     * threadlocal.
     *
     * @see
     * @since
     */
    private static ThreadLocal<ABEApplicationContext> contextThreadLocal = new ThreadLocal<ABEApplicationContext>();
	
	
    /**
     * This method sets the application context passed to it as parametre
     * into the threadlocal.
     *
     * @param ctx ABEApplicationContext
     *
     * @see
     * @since
     */
    public void setApplicationContext(ABEApplicationContext ctx)
    {
        if (ctx != null)
        {
            contextThreadLocal.set(ctx);
        }
    }

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
    
    public ABEApplicationContext create()
    {
        ABEApplicationContext applicationContext = new ABEApplicationContextImpl();
        setApplicationContext(applicationContext);
        return applicationContext;
    }

    /**
     * This method create a new application context.
     *
     * @return a new instance of application context
     *
     * @see
     * @since
     */
    
    public ABEApplicationContext createWithoutSetThreadLocal()
    {
        ABEApplicationContext applicationContext = new ABEApplicationContextImpl();
        return applicationContext;
    }

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
    
    public ABEApplicationContext create(ABEApplicationContext ctx)
    {
        this.setApplicationContext(ctx);
        return ctx;
    }

    /**
     * This mehtod removes the application context from the threadlocal.
     *
     *
     * @see
     * @since
     */
    
    public void delete()
    {
    	ABEApplicationContext applicationContext = this
                .getApplicationContext();
        if (applicationContext != null)
        {
            contextThreadLocal.set(null);
        }
    }

    /**
     * This method returns the application context currently stored in the
     * threadlocal.
     *
     * @return application context currently stored in the threadlocal
     *
     * @see
     * @since
     */
    
    public ABEApplicationContext getApplicationContext()
    {
        return (ABEApplicationContext) contextThreadLocal.get();
    }

}
