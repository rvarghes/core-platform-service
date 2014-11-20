package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.SeatmapViewCommand;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.sms.business.service.SMAvailService;
import com.kcdata.sms.data.dto.SMAvailResponse;

public class SeatmapViewCommandHandler extends ABECommandHandlerBase {
    private SMAvailService seatmapAvailService;
 
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof SeatmapViewCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "SeatmapViewCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		SeatmapViewCommand seatmapViewCommand = (SeatmapViewCommand) command;
		SMAvailResponse smAvailResponse=seatmapAvailService.getMapAvailability(seatmapViewCommand.getSmAvailRequest());
		seatmapViewCommand.setSmAvailResponse(smAvailResponse);		
		return seatmapViewCommand;
	}

	/**
	 * @return the seatmapAvailService
	 */
	public SMAvailService getSeatmapAvailService() {
		return seatmapAvailService;
	}

	/**
	 * @param seatmapAvailService the seatmapAvailService to set
	 */
	public void setSeatmapAvailService(SMAvailService seatmapAvailService) {
		this.seatmapAvailService = seatmapAvailService;
	}



}
