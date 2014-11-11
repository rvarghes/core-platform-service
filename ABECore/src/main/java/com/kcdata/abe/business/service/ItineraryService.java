/*
 * ItineraryService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 19, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import java.util.List;

import com.kcdata.abe.application.command.ViewItineraryCommand;
import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.business.response.PaymentHistoryResponse;
import com.kcdata.abe.business.response.ServicesResponse;
import com.kcdata.abe.data.dto.EmailAndPrintMessage;
import com.kcdata.abe.data.dto.HotelConfirmation;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Interface to define itinerary booking service
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface ItineraryService extends ABEService {

	/**
	 * Method to book the given itinerary
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse bookItinerary(Itinerary itinerary, ServicesResponse servicesResponse);

	/**
	 * 
	 * Method to save changes done in a given itinerary
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse saveItineraryChanges(Itinerary itinerary, Itinerary oldItinerary, ServicesResponse servicesResponse);

	/**
	 * 
	 * Method to save the itinerary & create Quote
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse saveItinerary(Itinerary itinerary);

	/**
	 * 
	 * Method to email itinerary to customer/agent recipient, format based on
	 * emailFormat
	 * 
	 * @param itinerary
	 * @param emailFormat
	 * @param emailId
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse emailItinerary(Itinerary itinerary,
			String emailFormat, String emailId, EmailAndPrintMessage messages,
			String fromEmailId);

	/**
	 * 
	 * Method to construct itinerary content for print
	 * 
	 * @param itinerary
	 * @param contentFormat
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse printItinerary(Itinerary itinerary,
			String printFormat, EmailAndPrintMessage messages);

	/**
	 * 
	 * Method to construct payment content for email and print
	 * 
	 * @param itinerary
	 * @param contentFormat
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public PaymentHistoryResponse paymentHistory(String bookingNumber);

	/**
	 * 
	 * Method to construct itinerary content for extendoption
	 * 
	 * @param itinerary
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse extendOptionDateOfItinerary(Itinerary itinerary);

	/**
	 * 
	 * Method used to print the itinerary comparison
	 * 
	 * @param itineraries
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse emailItinerary(List<Itinerary> itineraries,
			byte[] imgByteArray, String emailId);

	/**
	 * 
	 * Method  for ViewItinerary
	 * 
	 * @param bookingNo
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse viewItinerary(String bookingNumber);

	/**
	 * Sets MD5 token depending on agency or consumer copy requested
	 * 
	 * @param viewItineraryCommand
	 * @return anItineraryResponse
	 */
	public ItineraryResponse viewInvoice(
			ViewItineraryCommand viewItineraryCommand);

	/**
	 * Method to price and cancel the itinerary of given booking no.
	 * 
	 * @param bookingNo
	 *            - Booking number of the itinerary to be canceled
	 * @param cancelItinerary
	 *            - If the flag is true, price and cancel the itinerary. If the
	 *            flag is false, then only price the itinerary for cancellation.
	 *            Do not cancel it.
	 * @return
	 */
	public ItineraryResponse priceAndCancelItinerary(String bookingNo,
			boolean cancelItinerary,Itinerary oldItinerary);
	
	/**
	 * Method to receive supplier confirmation back in asynchronous fashion i.e through callback
	 * @param Itinerary
	 * @return void
	 */
	public void receiveSupplierConfirmation(HotelConfirmation hotelConfirmation);

}
