package com.kcdata.abe.business.service;

import com.kcdata.abe.framework.service.ABEServiceBase;
import com.kcdata.abe.business.response.CharterGatewayDestinationResponse;
import com.kcdata.abe.data.dao.CharterGatewayDestinationsDao;

public class CharterGatewayDestinationsServiceImpl extends ABEServiceBase implements 
 CharterGatewayDestinationsService{

	/**
	 * DAO class for retrieving gateway destinations
	 */
	private CharterGatewayDestinationsDao charterGatewayDestinationsDao;

	/**
	 * @return the gatewayDestinationsDao
	 */
	public CharterGatewayDestinationsDao getCharterGatewayDestinationsDao() {
		return charterGatewayDestinationsDao;
	}

	/**
	 * @param gatewayDestinationsDao
	 *            the gatewayDestinationsDao to set
	 */
	public void setCharterGatewayDestinationsDao(
			CharterGatewayDestinationsDao charterGatewayDestinationsDao) {
		this.charterGatewayDestinationsDao = charterGatewayDestinationsDao;
	}
	
	/**
	 * 
	 */
	public CharterGatewayDestinationResponse retrieveCharterGatewayDestinations() {
		return this.charterGatewayDestinationsDao.retrieveCharterGatewayDestinations();
	}
}
