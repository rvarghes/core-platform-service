/*
 * ABEBusinessException.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 23, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.errorhandling.exception;

import java.util.List;

import com.kcdata.abe.framework.env.ABETier;

/**
 * This exception class is thrown when there is a business rule related error.
 * N/A for any use case.
 *
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class ABEBusinessException extends ABEException {

    /**
	 * Auto generated id
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -4032839782184500927L;

	/**
     * This field is the constant for business exception message.
     *
     * @see
     * @since
     */
    private static final String BUS_EXCEPTION_MSG = "BUSINESS EXCEPTION";

    /**
     * Field that represents a list of business errors.
     *
     * @see
     * @since
     */
    private List<ABEBusinessError> businessErrors;

    /**
     * Field that represents a list of warnings.
     *
     * @see
     * @since
     */
    private List<ABEWarning> warnings;

    /**
     * Constructor.
     * @param tier application tier where the exception occurs
     * @param businessErrors a list of business errors
     * @param warnings a list of warnings
     */
    public ABEBusinessException(ABETier tier, List<ABEBusinessError> businessErrors,
            List<ABEWarning> warnings)
    {
        super(tier, "");
        this.businessErrors = businessErrors;
        this.warnings = warnings;
    }

    /**
     * This method overrides the default behavior of the getMessage method of
     * the exception class.
     *
     * @return java.lang.String
     *
     * @see
     * @since
     */
    public String getMessage()
    {
        return BUS_EXCEPTION_MSG;
    }

    /**
     * This method returns detailed description of the business exception.
     *
     * @return detailed description of the business exception
     *
     * @see
     * @since
     */
    public String getDetailedMessage()
    {
        StringBuilder sb = new StringBuilder();
        if (businessErrors != null && businessErrors.size() > 0)
        {
            ABEBusinessError busError;
            for (int i = 0; i < businessErrors.size(); i++)
            {
                busError = (ABEBusinessError) businessErrors.get(i);
                sb.append(BUS_EXCEPTION_MSG);
                sb.append(" [BUSINESS ERROR CODE: ");
                sb.append(busError.getErrorCode());
                sb.append("]");
                sb.append(" [DESCRIPTION: ");
                sb.append(busError.getErrorDescription());
                sb.append("]");
            }

        }
        else
        {
            sb.append(" [There is no business exception] ");
        }
        if (warnings != null && warnings.size() > 0)
        {
            ABEWarning warning;
            for (int i = 0; i < warnings.size(); i++)
            {
                warning = (ABEWarning) warnings.get(i);
                sb.append("WARNING");
                sb.append(" [WARNING CODE: ");
                sb.append(warning.getErrorCode());
                sb.append("]");
                sb.append(" [DESCRIPTION: ");
                sb.append(warning.getErrorDescription());
                sb.append("]");
            }

        }
        else
        {
            sb.append(" [There is no warning] ");
        }
        return sb.toString();
    }

    /**
     * This method checks if a particular business error occurred within the
     * business exception.
     *
     * @param be ABEBusinessError
     * @return if the ABEBusinessError is in the list of business errors
     * then "true"
     *
     * @see
     * @since
     */
    public boolean isBusinessErrorOccurred(ABEBusinessError be)
    {
        boolean isBusinessErrorOccurred = false;
        if (businessErrors != null && businessErrors.size() > 0)
        {
            ABEBusinessError tempBe;
            for (int i = 0; i < businessErrors.size(); i++)
            {
                tempBe = (ABEBusinessError) businessErrors.get(i);
                //if business error found then stop looping and return true
                if (be == tempBe)
                {
                    isBusinessErrorOccurred = true;
                    break;
                }
            }
        }
        return isBusinessErrorOccurred;
    }

    /**
     * @return Returns the businessErrors.
     */
    public List<ABEBusinessError> getBusinessErrors()
    {
        return businessErrors;
    }

    /**
     * @return Returns the warnings.
     */
    public List<ABEWarning> getWarnings()
    {
        return warnings;
    }
}
