/*
 * ABEAuditable.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 23, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.audit;

/**
 * ABEAuditable.
 * This interface defines operation that must be implemented for returning
 * textual audit information.
 * N/A for any specific usecase
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface ABEAuditable
{
    /**
     * This method is used to return textual audit information.
     *
     * @return String audit information in textual format.
     *
     * @see
     * @since
     */
    String getAuditText();
}
