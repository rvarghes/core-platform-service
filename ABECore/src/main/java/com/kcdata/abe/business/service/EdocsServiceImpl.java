package com.kcdata.abe.business.service;

import java.util.List;

import com.kcdata.abe.data.dao.EdocsInfoDao;
import com.kcdata.abe.data.dto.Agent;
import com.kcdata.abe.data.dto.Alert;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * @author atripath
 *
 */
public class EdocsServiceImpl extends ABEServiceBase implements EdocsService{

	private EdocsInfoDao edocsInfoDao;
	
	public Boolean isFtcViewed(String bookingNo, int paxId) {
		return edocsInfoDao.isFtcViewed(bookingNo, paxId);
	}

	/**
	 * @return
	 */
	public EdocsInfoDao getEdocsInfoDao() {
		return edocsInfoDao;
	}

	/**
	 * @param edocsInfoDao
	 */
	public void setEdocsInfoDao(EdocsInfoDao edocsInfoDao) {
		this.edocsInfoDao = edocsInfoDao;
	}

	public void savePaxItinView(String bookingNo, int paxId) {
		edocsInfoDao.savePaxItinView(bookingNo, paxId);
	}

	public void saveTaItinView(String bookingNo) {
		edocsInfoDao.saveTaItinView(bookingNo);
		
	}
	
	public void saveFTCView(String bookingNo, int paxId) {
		edocsInfoDao.saveFTCView(bookingNo, paxId);
	}

	public Boolean sendEmail(String bookingNo, boolean isAgentCopy) {
		return edocsInfoDao.sendEmail(bookingNo, isAgentCopy);
	}

	public Boolean declineEdocs(String bookingNo) {
		return edocsInfoDao.declineEdocs(bookingNo);
	}

	public Boolean saveTA(Agent agent, String bookingNo) {
		return edocsInfoDao.saveTA(agent, bookingNo);
	}

	public String getTAEmailId(Agent agent) {
		return edocsInfoDao.getTAEmailId(agent);
	}

	public List<Alert> getAlerts(String bookingNo) {
		return edocsInfoDao.getAlerts(bookingNo);
	}

	public String setPaxEmailAddresses(GuestInfo[] guests, String bookingNo) {
		return edocsInfoDao.setPaxEmailAddresses(guests, bookingNo);
		
	}
	
}
