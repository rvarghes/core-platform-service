package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.Agent;
import com.kcdata.abe.data.dto.Alert;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * @author atripath
 *
 */
public class EdocsCommand extends ABECommandBase{
	
	/**
	 * Default generated serial UID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -6237434706801140889L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "edocsCommandHandler";
		
	public String getCommandHandlerName() {
		return COMMAND_HANDLER_NAME;
	}

	/**
	 * @return the bookingNo
	 */
	public String getBookingNo() {
		return bookingNo;
	}

	/**
	 * @param bookingNo the bookingNo to set
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
	 * @param itinerary the itinerary to set
	 */
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
	
	/**
	 * @return
	 */
	public String[] getPaxes() {
		return paxes;
	}

	/**
	 * @param paxes
	 */
	public void setPaxes(String[] paxes) {
		this.paxes = paxes;
	}

	/**
	 * @return
	 */
	public Boolean getIsFTCViewed() {
		return isFTCViewed;
	}

	/**
	 * @param isFTCViewed
	 */
	public void setIsFTCViewed(Boolean isFTCViewed) {
		this.isFTCViewed = isFTCViewed;
	}

	/**
	 * @return
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return
	 */
	public String getCommandType() {
		return commandType;
	}

	/**
	 * @param commandType
	 */
	public void setCommandType(String commandType) {
		this.commandType = commandType;
	}

	/**
	 * @return the sentEmail
	 */
	public Boolean getSentEmail() {
		return sentEmail;
	}

	/**
	 * @param sentEmail the sentEmail to set
	 */
	public void setSentEmail(Boolean sentEmail) {
		this.sentEmail = sentEmail;
	}
	
	/**
	 * @return the isAgentCopy
	 */
	public Boolean getIsAgentCopy() {
		return isAgentCopy;
	}

	/**
	 * @param isAgentCopy the isAgentCopy to set
	 */
	public void setIsAgentCopy(Boolean isAgentCopy) {
		this.isAgentCopy = isAgentCopy;
	}

	/**
	 * @return the isDeclineEdocs
	 */
	public Boolean getIsDeclineEdocs() {
		return isDeclineEdocs;
	}

	/**
	 * @param isDeclineEdocs the isDeclineEdocs to set
	 */
	public void setIsDeclineEdocs(Boolean isDeclineEdocs) {
		this.isDeclineEdocs = isDeclineEdocs;
	}

	/**
	 * @return the agent
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * @param agent the agent to set
	 */
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	/**
	 * @return the alertList
	 */
	public List<Alert> getAlertList() {
		return alertList;
	}

	/**
	 * @param alertList the alertList to set
	 */
	public void setAlertList(List<Alert> alertList) {
		this.alertList = alertList;
	}

	/**
	 * @return the guestInfos
	 */
	public GuestInfo[] getGuestInfos() {
		return guestInfos;
	}

	/**
	 * @param guestInfos the guestInfos to set
	 */
	public void setGuestInfos(GuestInfo[] guestInfos) {
		this.guestInfos = guestInfos;
	}



	//Booking number
	private String bookingNo;
	//Retrieved booking details
	private Itinerary itinerary;
	//CQ8775 - Fields added to set for Itinerary Viewer application
	private String[] paxes;
	private Boolean isFTCViewed;
	private String result;
	private String commandType;
	private Boolean sentEmail;
	private Boolean isAgentCopy;
	private Boolean isDeclineEdocs;
	private Agent agent;
	private List<Alert> alertList;
	private GuestInfo[] guestInfos;
	//End
}
