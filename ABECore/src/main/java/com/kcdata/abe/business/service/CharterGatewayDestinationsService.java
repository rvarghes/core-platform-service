package com.kcdata.abe.business.service;

import com.kcdata.abe.framework.service.ABEService;
import com.kcdata.abe.business.response.CharterGatewayDestinationResponse;

public interface CharterGatewayDestinationsService extends ABEService {

	/**
	 * Method to retrieve charter gateway 
	 * 
	 * @return Gateway 
	 * 
	 * @see
	 * @since
	 */
	public CharterGatewayDestinationResponse retrieveCharterGatewayDestinations();

}
