/**
 * 
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveVehicleClassCommand;
import com.kcdata.abe.business.response.VehicleClassResponse;
import com.kcdata.abe.business.service.VehicleClassService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * 
 * @author npanday
 *
 */
public class RetrieveVehicleClassCommandHandler extends ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private VehicleClassService  vehicleClassService;

	
	/**
	 * Base class implementation method
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof RetrieveVehicleClassCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveVehicleClassCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveVehicleClassCommand retrieveVehicleClassCommand = (RetrieveVehicleClassCommand) command;
		VehicleClassResponse vehicleClassResponse  = vehicleClassService.retrieveVehicleClass();
		retrieveVehicleClassCommand.setCarTypes(vehicleClassResponse.getCarTypes());
		return retrieveVehicleClassCommand;
	}


	/**
	 * @param vehicleClassService the vehicleClassService to set
	 */
	public void setVehicleClassService(VehicleClassService vehicleClassService) {
		this.vehicleClassService = vehicleClassService;
	}


	/**
	 * @return the vehicleClassService
	 */
	public VehicleClassService getVehicleClassService() {
		return vehicleClassService;
	}

}