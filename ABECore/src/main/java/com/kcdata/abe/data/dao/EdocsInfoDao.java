/*
 * EdocsInfoDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 17, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;


import java.util.List;

import com.kcdata.abe.business.response.EdocsInfoResponse;
import com.kcdata.abe.data.dto.Agent;
import com.kcdata.abe.data.dto.Alert;
import com.kcdata.abe.data.dto.EdocsInfo;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * DAO Interface to store edocs information
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface EdocsInfoDao extends ABEDao {
	
	/**
	 * Method to store the edocs info 
	 *
	 * @param edocsInfo
	 * @return
	 *
	 * @see
	 * @since
	 */
	public EdocsInfoResponse storeEdocsInfo(EdocsInfo edocsInfo);
	
	/**
	 * CQ8775 -  Methods added to execute Z-BAPI code from Itinerary Viewer Application
	 */
	public Boolean isFtcViewed(String bookingNo, int paxId); 
	
	public void savePaxItinView(String bookingNo, int paxId);
	
	public void saveTaItinView(String bookingNo);
	
	public void saveFTCView(String bookingNo, int paxId);
	
	public Boolean sendEmail(String bookingNo, boolean isAgentCopy);
	
	public Boolean declineEdocs(String bookingNo);
	
	public Boolean saveTA(Agent agent, String bookingNo);
	
	public List<Alert> getAlerts(String bookingNo);
	
	public String getTAEmailId(Agent agent);
	
	public String setPaxEmailAddresses(GuestInfo[] guests, String bookingNo);
	/*End*/
	
	
}
