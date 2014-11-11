/*
 * ABEService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 24, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.service;

import org.springframework.context.MessageSourceAware;

import com.kcdata.abe.framework.context.ABEApplicationContextAware;

/**
 * This interface is implemented by all business services.
 * N/A for any use case.
 * 
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface ABEService extends ABEApplicationContextAware, MessageSourceAware {

}
