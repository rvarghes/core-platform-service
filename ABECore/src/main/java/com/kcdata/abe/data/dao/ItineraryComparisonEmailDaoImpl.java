/*
 * ItineraryComparisonDaoImpl.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 27, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.Iterator;
import java.util.List;

import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.util.EmailUtils;
import com.kcdata.abe.framework.dao.ABEDaoBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.framework.response.ABEResponse;

public class ItineraryComparisonEmailDaoImpl extends ABEDaoBase implements
		ItineraryComparisonEmailDao {

	private EmailUtils emailProcessor;

	/**
	 * @return the emailProcessor
	 */
	public EmailUtils getEmailProcessor() {
		return emailProcessor;
	}

	/**
	 * @param emailProcessor
	 *            the emailProcessor to set
	 */
	public void setEmailProcessor(EmailUtils emailProcessor) {
		this.emailProcessor = emailProcessor;
	}

	public ItineraryResponse sendItineraryComparisonEmail(
			List<Itinerary> itineraries, byte[] imgByteArray, String emailId) {
		ItineraryResponse itineraryResponse = new ItineraryResponse();
		try {
			 String fileName="";
			 itineraries.iterator();
			 for (Iterator<Itinerary> iterator = itineraries.iterator(); iterator.hasNext();) {
				Itinerary itinerary = iterator.next();
				if(null != itinerary.getBookingHeader()){
					fileName = itinerary.getBookingHeader().getTourId();
				}				
			}
			if( (null == fileName) || ("".equals(fileName.trim()))){
				fileName = "Package Comparison";
			}
			emailProcessor.sendItineraryComparison(emailId, imgByteArray,fileName);

		} catch (Exception ex) {
			String debugMessage = "Email Itinerary Error: Error emailing Itinerary Comparison";
			this.processWarningErrors(ex, itineraryResponse, debugMessage);
			return itineraryResponse;

		}
		itineraryResponse.setItineraries(itineraries);
		return itineraryResponse;
	}

	private void processWarningErrors(Exception e, ABEResponse response,
			String debugMessage) {
		// Throw in case of irrecoverable error
		ABESystemError systemError = new ABESystemError("101", e.getMessage(),
				debugMessage);
		throw new ABESystemException(systemError, ABETier.BUSINESS, e);
	}
}
