package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.data.dto.Gateway;
import com.kcdata.abe.framework.response.ABEResponse;

public class CharterGatewayDestinationResponse extends ABEResponse {

	/**
	 * Serial Version Id
	 */
	private static final long serialVersionUID = -2821376834628850076L;
	
	/**
	 * List of charter Gateways
	 */
	private List<Gateway> gatewayList;

	/**
	 * @return the gatewayList
	 */
	public List<Gateway> getGatewayList() {
		return gatewayList;
	}

	/**
	 * @param gatewayList the gatewayList to set
	 */
	public void setGatewayList(List<Gateway> gatewayList) {
		this.gatewayList = gatewayList;
	}

}
