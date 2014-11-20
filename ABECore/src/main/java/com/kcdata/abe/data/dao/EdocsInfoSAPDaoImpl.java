/*
 * EdocsInfoSAPDaoImpl.java
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.kcdata.abe.bapi.BapireturnType;
import com.kcdata.abe.bapi.YsvpromocType;
import com.kcdata.abe.bapi.Z_Api_Alerts_Disp_Input;
import com.kcdata.abe.bapi.Z_Api_Alerts_Disp_Output;
import com.kcdata.abe.bapi.Z_Api_Mail_Ids_Input;
import com.kcdata.abe.bapi.Z_Api_Mail_Ids_Output;
import com.kcdata.abe.bapi.Z_Api_Mail_Trackitin_Input;
import com.kcdata.abe.bapi.Z_Api_Mail_Trackitin_Output;
import com.kcdata.abe.bapi.Z_Api_Send_Mail_Itin_Input;
import com.kcdata.abe.bapi.Z_Api_Send_Mail_Itin_Output;
import com.kcdata.abe.bapi.ZapipaxType;
import com.kcdata.abe.bapi.Zepsilon_Cc_FeedType;
import com.kcdata.abe.bapi.ZsalertType;
import com.kcdata.abe.bapi.Ztrackitin_PaxType;
import com.kcdata.abe.bapi.Ztrackitin_TaType;
import com.kcdata.abe.bapi.util.YsvpromocType_List;
import com.kcdata.abe.bapi.util.ZapipaxType_List;
import com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List;
import com.kcdata.abe.bapi.util.ZsalertType_List;
import com.kcdata.abe.bapi.util.Ztrackitin_PaxType_List;
import com.kcdata.abe.business.response.EdocsInfoResponse;
import com.kcdata.abe.data.dto.Agent;
import com.kcdata.abe.data.dto.Alert;
import com.kcdata.abe.data.dto.Comment;
import com.kcdata.abe.data.dto.CommentType;
import com.kcdata.abe.data.dto.EdocsInfo;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;

/**
 * DAO implementation class for EDocs info
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class EdocsInfoSAPDaoImpl extends ABESAPDaoBase implements EdocsInfoDao {

	private CommentsDao commentsDao;

	/**
	 * @return the commentsDao
	 */
	public CommentsDao getCommentsDao() {
		return commentsDao;
	}

	/**
	 * @param commentsDao
	 *            the commentsDao to set
	 */
	public void setCommentsDao(CommentsDao commentsDao) {
		this.commentsDao = commentsDao;
	}

	/**
	 * Method to store the edocs info
	 * 
	 * @param edocsInfo
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public EdocsInfoResponse storeEdocsInfo(EdocsInfo edocsInfo) {
		EdocsInfoResponse response = new EdocsInfoResponse();

		// Prepare input
		Z_Api_Mail_Ids_Input bapiInput = new Z_Api_Mail_Ids_Input();
		prepareBapiInput(edocsInfo, bapiInput);

		// Execute the BAPI
		Z_Api_Mail_Ids_Output bapiOutput = (Z_Api_Mail_Ids_Output) this
				.getBapiExecutionManager().executeBAPI("Z_Api_Mail_Ids",
						bapiInput);

		// Process warnings and errors
		processWarningsErrors(bapiOutput.getReturn(), response);

		// Update Comments for the booking
		this.updateComments(edocsInfo);

		return response;
	}

	/**
	 * Method to prepare input for the BAPI
	 * 
	 * @param edocsInfo
	 * @param bapiInput
	 * 
	 * @see
	 * @since
	 */
	private void prepareBapiInput(EdocsInfo edocsInfo,
			Z_Api_Mail_Ids_Input bapiInput) {
		bapiInput.setBookingno(edocsInfo.getBookingNumber());
		if (edocsInfo.getAgentDetails() != null
				&& edocsInfo.getTaEmail() != null
				&& !edocsInfo.getTaEmail().equalsIgnoreCase(
						edocsInfo.getAgentDetails().getEmailId())
				&& !edocsInfo.isClientEdocsOnly()) {
			bapiInput.setTa_No(edocsInfo.getCustomerNumber());
			bapiInput.setTa_Fname(edocsInfo.getAgentDetails().getFirstName());
			bapiInput.setTa_Lname(edocsInfo.getAgentDetails().getLastName());
			bapiInput.setTa_Mailid(edocsInfo.getTaEmail());
		} else {
			bapiInput.setTa_No("");
			bapiInput.setTa_Fname("");
			bapiInput.setTa_Lname("");
			bapiInput.setTa_Mailid("");
		}
		bapiInput.setUpdate("X");
		if (edocsInfo.isEdocsAccepted()) {
			bapiInput.setPrint("N");
			// Prepare Guest Details
			if (edocsInfo != null && !"".equals(edocsInfo)) {
				ZapipaxType_List paxList = new ZapipaxType_List();
				for (GuestInfo guestInfo : edocsInfo.getGuests()) {
					if (guestInfo.getEmailId() != null) {
						ZapipaxType zapipaxType = new ZapipaxType();
						zapipaxType.setPax_Id(guestInfo.getGuestId());
						zapipaxType.setPax_Mail(guestInfo.getEmailId());
						zapipaxType.setVbeln(edocsInfo.getBookingNumber());
						paxList.add(zapipaxType);
					}
				}
				if (paxList.size() > 0) {
					bapiInput.setPax_Ids(paxList);
				}
			}
		} else {
			bapiInput.setPrint("Y");
		}
	}

	/**
	 * Method update booking comments
	 * 
	 * @param edocsInfo
	 * 
	 * @see
	 * @since
	 */
	private void updateComments(EdocsInfo edocsInfo) {
		IMApplicationInfo imApplicationInfo = this
				.getApplicationContextFactory().getApplicationContext()
				.getRequestContext().getIMApplicationInfo();

		if (edocsInfo.isEdocsAccepted()) {
			// Comments
			Comment comment = new Comment();
			comment.setBookingNumber(edocsInfo.getBookingNumber());
			comment.setCallcenter(edocsInfo.getCallCenter());
			comment.setCommentDetails("E-Docs Requested");
			comment.setCommentType(CommentType.HISTORY);
			comment.setCreatedBy(imApplicationInfo.getCreatedBy());
			this.commentsDao.addComment(comment);

			if (edocsInfo.getAgentDetails() != null
					&& edocsInfo.getTaEmail() != null
					&& !edocsInfo.getTaEmail().equalsIgnoreCase(
							edocsInfo.getAgentDetails().getEmailId())
					&& !edocsInfo.isClientEdocsOnly()) {
				try {
					Comment taComment = (Comment) comment.clone();
					StringBuffer sb = new StringBuffer();
					sb.append("Change TA EMAIL from "
							+ edocsInfo.getAgentDetails().getEmailId() + " to "
							+ edocsInfo.getTaEmail());
					SimpleDateFormat dateFormat = new SimpleDateFormat(
							"MM/dd/yyyy h:mm a");
					String strDateStamp = dateFormat.format(Calendar
							.getInstance().getTime());

					String commentStr = strDateStamp + " "
							+ imApplicationInfo.getCreatedBy() + " "
							+ sb.toString();
					taComment.setCommentDetails(commentStr);
					taComment.setCommentType(CommentType.HISTORY);
					this.commentsDao.addComment(taComment);
				} catch (CloneNotSupportedException e) {
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.kcdata.abe.data.dao.EdocsInfoDao#isFtcViewed(java.lang.String, int)
	 */
	public Boolean isFtcViewed(String bookingNo, int paxId) {
		// Prepare input
		Z_Api_Mail_Trackitin_Input bapiInput = new Z_Api_Mail_Trackitin_Input();

		Ztrackitin_PaxType struct = getPaxStructure(bookingNo);

		struct.setZzpaxid(paxId + "");

		bapiInput.setPass_Details(struct);
		bapiInput.setTa_Details(new Ztrackitin_TaType());
		Z_Api_Mail_Trackitin_Output outBAPI = null;
		try {
			outBAPI = (Z_Api_Mail_Trackitin_Output) this.getBapiExecutionManager().executeBAPI("Z_Api_Mail_Trackitin",
							bapiInput);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Ztrackitin_PaxType_List paxTable = outBAPI.get_as_listPassengers();

		for (int i = 0; i < paxTable.size(); ++i) {
			Ztrackitin_PaxType row = paxTable.getZtrackitin_PaxType(i);

			if (paxId == Integer.parseInt(row.getZzpaxid())) {
				if ("X".equals(row.getZzftcviewed()))
					return new Boolean(true);
			}
		}

		return new Boolean(false);
	}
	
	private Ztrackitin_PaxType getPaxStructure(String bookingNo){
		Z_Api_Mail_Trackitin_Input inputBAPI = new Z_Api_Mail_Trackitin_Input();

		Ztrackitin_PaxType struct = new Ztrackitin_PaxType();

		struct.setVbeln(bookingNo);

		inputBAPI.setPass_Details(struct);
		inputBAPI.setTa_Details(new Ztrackitin_TaType());

		//@TODO Z_Api_Mail_Trackitin_Output outBAPI = (Z_Api_Mail_Trackitin_Output)this.getBapiExecutionManager().executeBAPI("Z_Api_Mail_Trackitin", inputBAPI);

		// return outBAPI.getPassDetails();
		return struct;
	}
	
	public void savePaxItinView(String bookingNo, int paxId){
		Z_Api_Mail_Trackitin_Input inputBAPI = new Z_Api_Mail_Trackitin_Input();

		Ztrackitin_PaxType struct = getPaxStructure(bookingNo);
		struct.setZzitinviewed("X");

		Date date = new Date();

		struct.setZzdatepax(new java.sql.Date(date.getTime()));
		struct.setZztimepax(new java.sql.Time(date.getTime()));

		struct.setZzpaxid(paxId + "");
		inputBAPI.setPass_Details(struct);
		inputBAPI.setUpdate("X");
		inputBAPI.setTa_Details(new Ztrackitin_TaType());
		Z_Api_Mail_Trackitin_Output outBAPI = (Z_Api_Mail_Trackitin_Output) this.getBapiExecutionManager().executeBAPI("Z_Api_Mail_Trackitin",
				inputBAPI);

	}

	public void saveTaItinView(String bookingNo){
		Z_Api_Mail_Trackitin_Input inputBAPI = new Z_Api_Mail_Trackitin_Input();

		//PAX structure
		Ztrackitin_PaxType struct = getPaxStructure(bookingNo);
		struct.setZzitinviewed("X");

		Date date = new Date();

		struct.setZzdatepax(new java.sql.Date(date.getTime()));
		struct.setZztimepax(new java.sql.Time(date.getTime()));

		inputBAPI.setPass_Details(struct);
		
		//TA Structure
		Ztrackitin_TaType taStruct = new Ztrackitin_TaType();
		taStruct.setVbeln(bookingNo);
		taStruct.setZzitinviewed("X");

		taStruct.setZzdateta(new java.sql.Date(date.getTime()));
		taStruct.setZztimeta(new java.sql.Time(date.getTime()));

		inputBAPI.setTa_Details(taStruct);
		inputBAPI.setUpdate("X");
		
		Z_Api_Mail_Trackitin_Output outBAPI = (Z_Api_Mail_Trackitin_Output) this.getBapiExecutionManager().executeBAPI("Z_Api_Mail_Trackitin", inputBAPI);
	}
	
	public void saveFTCView(String bookingNo, int paxId) {
		Z_Api_Mail_Trackitin_Input inputBAPI = new Z_Api_Mail_Trackitin_Input();

		Ztrackitin_PaxType struct = getPaxStructure(bookingNo);
		struct.setZzftcviewed("X");

		Date date = new Date();

		struct.setZzdatepax(new java.sql.Date(date.getTime()));
		struct.setZztimepax(new java.sql.Time(date.getTime()));

		struct.setZzpaxid(paxId + "");

		inputBAPI.setPass_Details(struct);
		inputBAPI.setUpdate("X");

		// IRfcConnection con = (IRfcConnection) connectionPool.borrowObject();
		inputBAPI.setTa_Details(new Ztrackitin_TaType());
		try {
			Z_Api_Mail_Trackitin_Output outBAPI = (Z_Api_Mail_Trackitin_Output) this.getBapiExecutionManager().
													executeBAPI("Z_Api_Mail_Trackitin", inputBAPI);
		} finally {
			// connectionPool.returnObject(con);
		}
	}

	public Boolean sendEmail(String bookingNo, boolean isAgentCopy) {
		Boolean sentEmail = Boolean.FALSE;
		Z_Api_Send_Mail_Itin_Input inputBAPI = new Z_Api_Send_Mail_Itin_Input();
		Zepsilon_Cc_FeedType_List table = new Zepsilon_Cc_FeedType_List();
		Zepsilon_Cc_FeedType row = new Zepsilon_Cc_FeedType();
		row.setVbeln(bookingNo);
		// send a value for agency copy
		if (isAgentCopy) {
			row.setZslno("000010");
		} else {
			row.setZslno("000020");
		}
		table.add(row);
		inputBAPI.setIt_Epsilon_Cc_Info(table);
		try {
			Z_Api_Send_Mail_Itin_Output outBAPI = (Z_Api_Send_Mail_Itin_Output) this.getBapiExecutionManager().executeBAPI("Z_Api_Send_Mail_Itin",
							inputBAPI);
			sentEmail = Boolean.TRUE;
		} catch (Exception e) {
			sentEmail = Boolean.FALSE;
		}
		return sentEmail;
	}

	public Boolean declineEdocs(String bookingNo) {
		Boolean isDeclined = Boolean.TRUE;
		Z_Api_Mail_Ids_Input inputBAPI = new Z_Api_Mail_Ids_Input();

		inputBAPI.setBookingno(bookingNo);

		inputBAPI.setPrint("Y");
		inputBAPI.setUpdate("X");
		
		inputBAPI.setTa_Fname("JO");
		inputBAPI.setTa_Lname("GLORIOSO");
		inputBAPI.setTa_No("0000203405");
		inputBAPI.setTa_Mailid("");
		
		try {
			Z_Api_Mail_Ids_Output outBAPI = (Z_Api_Mail_Ids_Output) this
					.getBapiExecutionManager().executeBAPI("Z_Api_Mail_Ids",
							inputBAPI);
		} catch (Exception e) {
			isDeclined = Boolean.FALSE;
			e.printStackTrace();
		}
		return isDeclined;
	}

	public Boolean saveTA(Agent agent, String bookingNo) {
		Boolean isSaved = Boolean.TRUE;
		Z_Api_Mail_Ids_Input inputBAPI = new Z_Api_Mail_Ids_Input();

		inputBAPI.setBookingno(bookingNo);

		inputBAPI.setUpdate("X");
		//Set Agent info
		inputBAPI.setTa_Fname(agent.getFirstName());
		inputBAPI.setTa_Lname(agent.getLastName());
		inputBAPI.setTa_No(agent.getAgentNo());
		inputBAPI.setTa_Mailid(agent.getEmailId());
		inputBAPI.setPrint(agent.getPrint());
		
		
		try {
			Z_Api_Mail_Ids_Output outBAPI = (Z_Api_Mail_Ids_Output) this.getBapiExecutionManager().executeBAPI("Z_Api_Mail_Ids",
							inputBAPI);
		} catch (Exception e) {
			isSaved = Boolean.FALSE;
			e.printStackTrace();
		}
		return isSaved;
	}

	public String getTAEmailId(Agent agent) {
		String emailId = null;
		Z_Api_Mail_Ids_Input inputBAPI = new Z_Api_Mail_Ids_Input();

		inputBAPI.setTa_Fname(agent.getFirstName());
		inputBAPI.setTa_Lname(agent.getLastName());
		inputBAPI.setTa_No(agent.getAgentNo());
		
		Z_Api_Mail_Ids_Output outBAPI = (Z_Api_Mail_Ids_Output) this.getBapiExecutionManager().executeBAPI("Z_Api_Mail_Ids", inputBAPI);
		
		BapireturnType returnStruct = outBAPI.getReturn();

		
		if (returnStruct != null && (returnStruct.getMessage() != null
				&& returnStruct.getMessage().length() > 0)) {
			// !!! this is kind of weird, but the return message also serves as
			// a way
			// to let the application know that the email address is not
			// populated.
			// we'll parse the return message and see if its that or some other
			// application
			// exception occured
			if (returnStruct.getMessage().indexOf("Agent E-mail id is not available") != -1) {
				return null;
			} 
		}
		emailId = outBAPI.getMailid();
		// I cant update with no value. This is to mimic a reset
		if (emailId!=null && "Z".equals(emailId))
			emailId = null;
		return emailId;
	}
	
	public List<Alert> getAlerts(String bookingNo){
		Z_Api_Alerts_Disp_Input inputBAPI = new Z_Api_Alerts_Disp_Input();

		inputBAPI.setBookingno(bookingNo);

		Z_Api_Alerts_Disp_Output outBAPI = (Z_Api_Alerts_Disp_Output) this.getBapiExecutionManager().executeBAPI("Z_Api_Alerts_Disp", inputBAPI);

		ZsalertType_List alertTable = outBAPI.get_as_listIt_Alert();
		ZsalertType_List alertTable1 = outBAPI.get_as_listIt_Vmessage();
		YsvpromocType_List alertTable2 = outBAPI.get_as_listIt_Vpc();
		ZsalertType_List notices = outBAPI.get_as_listIt_Output();

		Map alertMap = new TreeMap();

		for (int i = 0; i < alertTable.size(); ++i) {
			ZsalertType row = alertTable.getZsalertType(i);
			Alert alert = new Alert();
			if (alert.getText().indexOf("AVOK") != -1)
				alert.setAlertType("AVOK");
			else {
				alert.setAlertType("PAXALERT");
			}
			String alertSeqKey = row.getZzalertid() + alert.getAlertType();
			if (!alertMap.containsKey(alertSeqKey)) {
				alertMap.put(alertSeqKey, alert);
			} else {
				alert = (Alert) alertMap.get(alertSeqKey);
			}
			alert.appendText(row.getZzcoments());
			alert.appendText(" ");
		}
		// code changes are made by Narasimha Vuntla for new alerts added
		for (int j = 0; j < alertTable1.size(); ++j) {
			ZsalertType row = alertTable1.getZsalertType(j);
			Alert alert = new Alert();
			if (alert.getText().indexOf("AVOK") != -1)
				alert.setAlertType("AVOK");
			else {
				alert.setAlertType("PAXALERT");
			}
			String alertSeqKey = row.getZzalertid() + alert.getAlertType();
			if (!alertMap.containsKey(alertSeqKey)) {
				alertMap.put(alertSeqKey, alert);
			} else {
				alert = (Alert) alertMap.get(alertSeqKey);
			}
			alert.appendText(row.getZzcoments());
			alert.appendText(" ");
		}
		// adding ended here.
		for (int i = 0; i < alertTable2.size(); ++i) {
			Alert alert = new Alert();
			YsvpromocType row = alertTable2.getYsvpromocType(i);
			alert.appendText(row.getZzvpromoc());
			alert.appendText("");
		}
		// added to display notices on E-Docs
		if (notices != null && notices.size() > 0) {
			for (int i = 0; i < notices.size(); ++i) {
				ZsalertType row = notices.getZsalertType(i);
				Alert alert = new Alert();
				alert.setAlertType("notice");
				String alertSeqKey = row.getZzalertid() + alert.getAlertType();
				if (!alertMap.containsKey(alertSeqKey)) {
					alertMap.put(alertSeqKey, alert);
				} else {
					alert = (Alert) alertMap.get(alertSeqKey);
				}
				alert.appendText(row.getZzcoments());
				alert.appendText(" ");
				alertMap.put(alertSeqKey, alert);
			}
		}

		/*if (itin.hasAvok()) {
			Alert alert = new Alert();
			alert.setAlertType("AVOK");
			alert.appendText(getAvokText());
			alertMap.put("ZZAVOK", alert);
		}*/
		Collection collection = alertMap.values();
		List<Alert> alertList = new ArrayList<Alert>(collection);
		return alertList;
	}
	
	public String setPaxEmailAddresses(GuestInfo[] guests, String bookingNo){
		Z_Api_Mail_Ids_Input inputBAPI = new Z_Api_Mail_Ids_Input();

		inputBAPI.setBookingno(bookingNo);

		ZapipaxType_List table = new ZapipaxType_List();

		for (int i = 0; i < guests.length; ++i) {

			GuestInfo guestInfo = guests[i];
			if (guestInfo.getEmailId()== null) {
				continue;
			}

			ZapipaxType row = new ZapipaxType();

			row.setVbeln(bookingNo);
			row.setPax_Id(guestInfo.getGuestId().toString());

			row.setPax_Mail(guestInfo.getEmailId());
			table.add(row);
		}
		if (table.size() > 0) {

			inputBAPI.setPax_Ids(table);
			inputBAPI.setUpdate("X");
			inputBAPI.setTa_Fname("");
			inputBAPI.setTa_Lname("");
			inputBAPI.setTa_No("");

			Z_Api_Mail_Ids_Output outBAPI = (Z_Api_Mail_Ids_Output) this.getBapiExecutionManager().executeBAPI("Z_Api_Mail_Ids", inputBAPI);
			
			if(outBAPI !=null){
				return "SUCCESS";
			}
		}
		return "FAILURE";
	}
}
