package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.ReceiveHotelConfirmationCommand;
import com.kcdata.abe.application.command.RetrieveHotelsCommand;
import com.kcdata.abe.business.service.ItineraryService;
import com.kcdata.abe.data.dto.HotelConfirmation;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class ReceiveHotelConfirmationCommandHandler extends ABECommandHandlerBase  {
	private ItineraryService itineraryService;
	
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof ReceiveHotelConfirmationCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "ReceiveHotelConfirmationCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION, new IllegalArgumentException(
					message));
		}
		ReceiveHotelConfirmationCommand receiveHotelConfirmationCommand = (ReceiveHotelConfirmationCommand) command;
		HotelConfirmation hotelConfirmation = receiveHotelConfirmationCommand.getHotelConfirmation();
		itineraryService.receiveSupplierConfirmation(hotelConfirmation);
		return receiveHotelConfirmationCommand;
	}
	/**
	 * @param itineraryService the itineraryService to set
	 */
	public void setItineraryService(ItineraryService itineraryService) {
		this.itineraryService = itineraryService;
	}
	/**
	 * @return the itineraryService
	 */
	public ItineraryService getItineraryService() {
		return itineraryService;
	}

}
