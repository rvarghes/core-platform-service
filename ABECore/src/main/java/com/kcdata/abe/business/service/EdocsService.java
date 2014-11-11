package com.kcdata.abe.business.service;

import java.util.List;

import com.kcdata.abe.data.dto.Agent;
import com.kcdata.abe.data.dto.Alert;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.framework.service.ABEService;

/**
 * @author atripath
 *
 */
public interface EdocsService extends ABEService{

	/**
	 * Method to check 
	 * 
	 * @param bookingNo
	 * @param paxId
	 * @return
	 */
	public Boolean isFtcViewed(String bookingNo, int paxId);
	
	public void savePaxItinView(String bookingNo, int paxId);
	
	public void saveTaItinView(String bookingNo);
	
	public void saveFTCView(String bookingNo, int paxId);
	
	public Boolean sendEmail(String bookingNo, boolean isAgentCopy);
	
	public Boolean declineEdocs(String bookingNo);
	
	public Boolean saveTA(Agent agent, String bookingNo);
	
	public List<Alert> getAlerts(String bookingNo);
	
	public String setPaxEmailAddresses(GuestInfo[] guests, String bookingNo);
	
	public String getTAEmailId(Agent agent);
}
