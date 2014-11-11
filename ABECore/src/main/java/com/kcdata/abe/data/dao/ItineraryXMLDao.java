/*
 * ItineraryXMLDao.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * May 3, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.data.dto.EmailAndPrintMessage;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.PrintItinerary;
import com.kcdata.abe.framework.dao.ABEDao;

public interface ItineraryXMLDao extends ABEDao {

/**
 * 	
 * Method to send email to recipient emailId, in the emailFormat [Customer,Agent]
 *
 * @param itinerary
 * @param emailFormat
 * @param emailId
 * @return
 *
 * @see
 * @since
 */
public ItineraryResponse emailItinerary(PrintItinerary itinerary, String emailFormat, String emailId,EmailAndPrintMessage messages,String fromEmailID);

/**
 * 
 * Method to prepare content for printing itinerary
 *
 * @param itinerary
 * @param printFormat
 * @return
 *
 * @see
 * @since
 */
public ItineraryResponse printItinerary(PrintItinerary itinerary, String printFormat,EmailAndPrintMessage messages);
}
