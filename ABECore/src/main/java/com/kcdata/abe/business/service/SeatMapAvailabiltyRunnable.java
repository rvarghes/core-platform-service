package com.kcdata.abe.business.service;

import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.sms.data.dto.SMLinkViewRequest;
import com.kcdata.sms.data.dto.SMLinkViewResponse;

/**
 * Thread to fetch seat map availability on the basis of some parameters like
 * gateway, destination, from date, to date, days ahead, days behind
 * 
 * @author sbharti
 */
public class SeatMapAvailabiltyRunnable implements Runnable {
	
	ABELogger logger = ABELogger.getLogger(SeatMapAvailabiltyRunnable.class);
	
	private SMLinkViewResponse linkViewResponse;
	private AbeSmAvailService abeSmAvailService;
	private SMLinkViewRequest smLinkViewRequest;
	
	public SeatMapAvailabiltyRunnable(AbeSmAvailService abeSmAvailService, SMLinkViewRequest smLinkViewRequest) {
		this.abeSmAvailService = abeSmAvailService;
		this.smLinkViewRequest = smLinkViewRequest;
	}

	public void run() {
			if(this.smLinkViewRequest != null)
			{
				SMLinkViewResponse linkViewResp = abeSmAvailService.getLinkViewAvailability(smLinkViewRequest);
				this.linkViewResponse = linkViewResp;
			}
	}


	public SMLinkViewResponse getLinkViewResponse() {
		return linkViewResponse;
	}

	public void setLinkViewResponse(SMLinkViewResponse linkViewResponse) {
		this.linkViewResponse = linkViewResponse;
	}
}
