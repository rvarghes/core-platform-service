package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.ExpireBookingCommand;
import com.kcdata.abe.business.service.ExpireBookingService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class ExpireBookingCommmandHandler extends ABECommandHandlerBase {

	private ExpireBookingService expireBookingService;

	public ExpireBookingService getExpireBookingService() {
		return expireBookingService;
	}

	public void setExpireBookingService(
			ExpireBookingService expireBookingService) {
		this.expireBookingService = expireBookingService;
	}

	public ABECommand handle(ABECommand command) {
		if (!(command instanceof ExpireBookingCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "ExpireBookingCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		ExpireBookingCommand expireBookingCommand = (ExpireBookingCommand) command;
		boolean status = expireBookingService.processExpireBooking(expireBookingCommand);
		expireBookingCommand.setStatus(Boolean.toString(status));
	    return expireBookingCommand;
	}
}
