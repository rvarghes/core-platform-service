/*
 * ABEUniqueIdGenerator.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 23, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.util;

import java.rmi.dgc.VMID;

/**
 * This class is for generating the unique id.
 * N/A for any specific usecase
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class ABEUniqueIdGenerator {

    /**
     * Private Constructor.
     */
    private ABEUniqueIdGenerator()
    {
    }

    /**
     * This method generates a UID for a request.
     *
     * @return java.lang.String
     *
     * @see
     * @since
     */
    public static synchronized String generateUniqueID()
    {
        return new VMID().toString();
    }

}
