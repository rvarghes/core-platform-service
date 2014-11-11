/*
 * ABEInterceptor.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 25, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.aop.interceptor;

import org.springframework.context.MessageSourceAware;

import com.kcdata.abe.framework.context.ABEApplicationContextAware;

/**
 * Interface to be implemented by all Interceptors
 * N/A to any specific usecase
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface ABEInterceptor extends ABEApplicationContextAware, MessageSourceAware {

}
