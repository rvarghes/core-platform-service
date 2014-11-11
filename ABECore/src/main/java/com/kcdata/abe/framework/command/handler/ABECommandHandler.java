/*
 * ABECommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 24, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.command.handler;

import org.springframework.context.MessageSourceAware;

import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.context.ABEApplicationContextAware;

/**
 * ABECommandHandler interface. This interface defines operations signature of
 * a Command Handler.
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface ABECommandHandler extends ABEApplicationContextAware, MessageSourceAware {
	
	/**
	 * This method provides implementation for handling a Command.
	 * 
	 * @param command
	 *            ABECommand
	 * @return ABECommand
	 * 
	 * @see
	 * @since
	 */
	ABECommand handle(ABECommand command);
}
