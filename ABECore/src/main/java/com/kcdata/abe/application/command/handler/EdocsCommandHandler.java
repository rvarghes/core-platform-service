package com.kcdata.abe.application.command.handler;

import java.util.Collection;
import java.util.List;

import com.kcdata.abe.application.command.EdocsCommand;
import com.kcdata.abe.application.command.RetrieveBookingCommand;
import com.kcdata.abe.business.response.BookingSearchResponse;
import com.kcdata.abe.business.service.BookingSearchService;
import com.kcdata.abe.business.service.EdocsService;
import com.kcdata.abe.data.dto.Agent;
import com.kcdata.abe.data.dto.Alert;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * @author atripath
 *
 */
public class EdocsCommandHandler extends ABECommandHandlerBase{

	// Service class instance
	private BookingSearchService bookingSearchService;
	
	private EdocsService edocsService;

	/**
	 * @return the bookingSearchService
	 */
	public BookingSearchService getBookingSearchService() {
		return bookingSearchService;
	}

	/**
	 * @param bookingSearchService
	 *            the bookingSearchService to set
	 */
	public void setBookingSearchService(
			BookingSearchService bookingSearchService) {
		this.bookingSearchService = bookingSearchService;
	}
	
	
	/**
	 * @return
	 */
	public EdocsService getEdocsService() {
		return edocsService;
	}

	/**
	 * @param edocsService
	 */
	public void setEdocsService(EdocsService edocsService) {
		this.edocsService = edocsService;
	}

	@SuppressWarnings("unused")
	public ABECommand handle(ABECommand command) {
		
		if (!(command instanceof RetrieveBookingCommand) && !(command instanceof EdocsCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveBookingCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		
		if(command instanceof RetrieveBookingCommand){
			RetrieveBookingCommand retrieveBookingCommand = (RetrieveBookingCommand) command;
			BookingSearchResponse searchResponse = bookingSearchService
					.retrieveBooking(retrieveBookingCommand.getBookingNo());

			// Process response and set the business errors, warnings, and info
			// messages to command
			this.processResponse(retrieveBookingCommand, searchResponse);
			retrieveBookingCommand.setItinerary(searchResponse.getItinerary());
			return retrieveBookingCommand;
		}else{
			//@TODO add exception handling for success/failure 
			EdocsCommand edocsCommand = (EdocsCommand) command;
			String commandType = edocsCommand.getCommandType();
			String[] paxes = edocsCommand.getPaxes();
			String bookingNo = edocsCommand.getBookingNo();
			if(paxes!= null && commandType !=null) {
				for (int i = 0; i < paxes.length; ++i) {
					int iPaxId = Integer.parseInt(paxes[i]);
					if(commandType.equals("FTC_VIEWED")){
						if (!edocsService.isFtcViewed(bookingNo, iPaxId).booleanValue()) {
							edocsCommand.setIsFTCViewed(Boolean.FALSE);
							break;
						}
					}else if(commandType.equals("SAVE_PAX_ITIN_VIEW")){
						edocsService.savePaxItinView(bookingNo, iPaxId);
						edocsCommand.setResult("SUCCESS");
					}else if(commandType.equals("SAVE_TA_ITIN_VIEW")){
						edocsService.saveTaItinView(bookingNo);
					}else if(commandType.equals("SAVE_FTC_VIEW")){
						edocsService.saveFTCView(bookingNo, iPaxId);
						edocsCommand.setResult("SUCCESS");
					}else if(commandType.equals("SEND_EMAIL")){
						edocsCommand.setSentEmail(edocsService.sendEmail(bookingNo, false));
					}
				}
			}
			if(paxes == null){
				if(commandType.equals("SEND_EMAIL")){
					boolean isAgentCopy = edocsCommand.getIsAgentCopy().booleanValue();
					edocsCommand.setSentEmail(edocsService.sendEmail(bookingNo, isAgentCopy));
				}else if(commandType.equals("DECLINE_EDOCS")){
					edocsCommand.setIsDeclineEdocs(edocsService.declineEdocs(bookingNo));
				}else if(commandType.equals("SAVE_TA")){
					if(edocsService.saveTA(edocsCommand.getAgent(), bookingNo)){
						edocsCommand.setResult("SUCCESS");
					}
				}else if(commandType.equals("GET_EMAIL_TA")){
					Agent agent = edocsCommand.getAgent();
					agent.setEmailId(edocsService.getTAEmailId(agent));
					edocsCommand.setAgent(agent);
				}else if(commandType.equals("GET_ALERTS")){
					List<Alert> alertList = edocsService.getAlerts(bookingNo);
					edocsCommand.setAlertList(alertList);
				}else if(commandType.equals("SET_PAX_EMAIL")){
					GuestInfo[] guests = edocsCommand.getGuestInfos();
					edocsCommand.setResult(edocsService.setPaxEmailAddresses(guests, bookingNo));
				}
			}
			return edocsCommand;
		}
	}
}
