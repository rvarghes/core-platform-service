/**
 * 
 */
package com.kcdata.abe.application.command;

import com.kcdata.abe.framework.command.ABECommandBase;
import com.kcdata.sms.data.dto.SMAvailRequest;
import com.kcdata.sms.data.dto.SMAvailResponse;

/**
 * This commond is used to getting seatmap data for affiliates
 * @author sjain
 *
 */
public class SeatmapViewCommand extends ABECommandBase {
 
   private static final long serialVersionUID = 1L;
   private SMAvailRequest smAvailRequest;
   private SMAvailResponse smAvailResponse;
	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "seatmapViewCommandHandler";
	public String getCommandHandlerName() {		
		return COMMAND_HANDLER_NAME;
	}
	/**
	 * @return the smAvailRequest
	 */
	public SMAvailRequest getSmAvailRequest() {
		return smAvailRequest;
	}
	/**
	 * @param smAvailRequest the smAvailRequest to set
	 */
	public void setSmAvailRequest(SMAvailRequest smAvailRequest) {
		this.smAvailRequest = smAvailRequest;
	}
	/**
	 * @return the smAvailResponse
	 */
	public SMAvailResponse getSmAvailResponse() {
		return smAvailResponse;
	}
	/**
	 * @param smAvailResponse the smAvailResponse to set
	 */
	public void setSmAvailResponse(SMAvailResponse smAvailResponse) {
		this.smAvailResponse = smAvailResponse;
	}

}
