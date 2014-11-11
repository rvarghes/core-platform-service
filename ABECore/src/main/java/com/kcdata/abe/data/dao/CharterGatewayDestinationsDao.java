package com.kcdata.abe.data.dao;

import com.kcdata.abe.framework.dao.ABEDao;
import com.kcdata.abe.business.response.CharterGatewayDestinationResponse;

public interface CharterGatewayDestinationsDao extends ABEDao {

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
