/**
 * 
 */
package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * @author hguntupa
 * 
 */
public class CancelItineraryCommand extends ABECommandBase {

	/**
	 * Auto generated serialization version ID
	 */
	private static final long serialVersionUID = -6902572597637213105L;

	private String bookingNo;
	private Itinerary itinerary;
	private boolean cancelItinerary;

	/**
	 * @return the bookingNo
	 */
	public String getBookingNo() {
		return bookingNo;
	}

	/**
	 * @param bookingNo
	 *            the bookingNo to set
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	/**
	 * @return the itinerary
	 */
	public Itinerary getItinerary() {
		return itinerary;
	}

	/**
	 * @param itinerary
	 *            the itinerary to set
	 */
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	/**
	 * @return the cancelItinerary
	 */
	public boolean isCancelItinerary() {
		return cancelItinerary;
	}

	/**
	 * @param cancelItinerary
	 *            the cancelItinerary to set
	 */
	public void setCancelItinerary(boolean cancelItinerary) {
		this.cancelItinerary = cancelItinerary;
	}

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "cancelItineraryCommandHandler";

	/**
	 * Method to return the command handler name
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public String getCommandHandlerName() {
		return COMMAND_HANDLER_NAME;
	}

}
