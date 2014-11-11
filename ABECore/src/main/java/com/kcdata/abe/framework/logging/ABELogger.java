/*
 * ABELogger.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 23, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.logging;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * This class is a wrapper class that wraps log4j logger functionality into a
 * generic custom logger. 
 * N/A for any specific usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ABELogger {

	/**
	 * Logger name field.
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unused")
	private final String name;

	/**
	 * Logger field.
	 * 
	 * @see
	 * @since
	 */
	private Logger log;

	/**
	 * Constructor.
	 * 
	 * @param name logger name
	 */
	protected ABELogger(String name) {
		this.name = name;
		log = Logger.getLogger(name);
	}

    /**
     * Wrapper method for trace method of the log4j logger.
     *
     * @param message message to log
     *
     * @see
     * @since
     */
    public void trace(Object message)
    {
        log.log(Level.TRACE, message);
    }

    /**
     * Wrapper method for trace method of the log4j logger.
     *
     * @param message message to log
     * @param t exception to log
     *
     * @see
     * @since
     */
    public void trace(Object message, Throwable t)
    {
        log.log(Level.TRACE, message, t);
    }

    /**
     * Wrapper method for debug method of the log4j logger.
     *
     * @param message message to log
     *
     * @see
     * @since
     */
    public void debug(Object message)
    {
        log.log(Level.DEBUG, message);
    }

    /**
     * Wrapper method for debug method of the log4j logger.
     *
     * @param message message to log
     * @param t exception to log
     *
     * @see
     * @since
     */
    public void debug(Object message, Throwable t)
    {
        log.log(Level.DEBUG, message, t);
    }

    /**
     * Wrapper method for info method of the log4j logger.
     *
     * @param message message to log
     *
     * @see
     * @since
     */
    public void info(Object message)
    {
        log.log(Level.INFO, message);
    }

    /**
     * Wrapper method for info method of the log4j logger.
     *
     * @param message message to log
     * @param t exception to log
     *
     * @see
     * @since
     */
    public void info(Object message, Throwable t)
    {
        log.log(Level.INFO, message, t);
    }

    /**
     * Wrapper method for warn method of the log4j logger.
     *
     * @param message message to log
     *
     * @see
     * @since
     */
    public void warn(Object message)
    {
        log.log(Level.WARN, message);
    }

    /**
     * Wrapper method for warn method of the log4j logger.
     *
     * @param message message to log
     * @param t exception to log
     *
     * @see
     * @since
     */
    public void warn(Object message, Throwable t)
    {
        log.log(Level.WARN, message, t);
    }

    /**
     * Wrapper method for error method of the log4j logger.
     *
     * @param message message to log
     *
     * @see
     * @since
     */
    public void error(Object message)
    {
        log.log(Level.ERROR, message);
    }

    /**
     * Wrapper method for error method of the log4j logger.
     *
     * @param message message to log
     * @param t exception to log
     *
     * @see
     * @since
     */
    public void error(Object message, Throwable t)
    {
        log.log(Level.ERROR, message, t);
    }

    /**
     * Wrapper method for fatal method of the log4j logger.
     *
     * @param message message to log
     *
     * @see
     * @since
     */
    public void fatal(Object message)
    {
        log.log(Level.FATAL, message);
    }

    /**
     * Wrapper method for fatal method of the log4j logger.
     *
     * @param message message to log
     * @param t exception to log
     *
     * @see
     * @since
     */
    public void fatal(Object message, Throwable t)
    {
        log.log(Level.FATAL, message, t);
    }

    /**
     * Wrapper method for log method of the log4j logger.
     *
     * @param p level to use to log
     * @param message message to log
     *
     * @see
     * @since
     */
    public void log(Level p, Object message)
    {
        log.log(p, message);
    }

    /**
     * Wrapper method for log method of the log4j logger.
     *
     * @param p level to use to log
     * @param message message to log
     * @param t exception to log
     *
     * @see
     * @since
     */
    public void log(Level p, Object message, Throwable t)
    {
        log.log(p, message, t);
    }

    /**
     * Static getter method for ABELogger.
     *
     * @param name name of the logger
     * @return ABELogger
     *
     * @see
     * @since
     */
    public static ABELogger getLogger(String name)
    {
    	ABELogger logger = new ABELogger(name);
        return logger;
    }

    /**
     * Static getter method for ABELogger.
     *
     * @param clazz class, which is used to determine the logger
     * @return ABELogger
     *
     * @see
     * @since
     */
    @SuppressWarnings("unchecked")
	public static ABELogger getLogger(Class clazz)
    {
    	ABELogger logger = new ABELogger(clazz.getName());
        return logger;
    }

}
