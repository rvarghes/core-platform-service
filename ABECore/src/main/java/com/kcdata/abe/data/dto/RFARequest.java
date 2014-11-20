package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * DTO to hold the RFARequest information
 * @author atripath
 *
 */
public class RFARequest implements ABEDto{


	private static final long serialVersionUID = 1L;
	private String bookingNumber;	
	private String posnr;
	private String confirmationNumber;
	private String requestMode;

	private String vendorEmailId;
	private String vendorPhoneNUmber;
	private String vendorFaxNumber;
	private String vendorMode;
		
	private String agentMode;
	private String agentEmailId;
	private String agentPhoneNo;
	private String agentFaxNo;
	
	private String requestConfirmBy;
	private String requestDeclineBy;
	
	
	/**
	 * @return the bookingNumber
	 */
	public String getBookingNumber() {
		return bookingNumber;
	}

	/**
	 * @param bookingNumber the bookingNumber to set
	 */
	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	/**
	 * @return the posnr
	 */
	public String getPosnr() {
		return posnr;
	}

	/**
	 * @param posnr the posnr to set
	 */
	public void setPosnr(String posnr) {
		this.posnr = posnr;
	}

	/**
	 * @return the vendorEmailId
	 */
	public String getVendorEmailId() {
		return vendorEmailId;
	}

	/**
	 * @param vendorEmailId the vendorEmailId to set
	 */
	public void setVendorEmailId(String vendorEmailId) {
		this.vendorEmailId = vendorEmailId;
	}

	/**
	 * @return the vendorPhoneNUmber
	 */
	public String getVendorPhoneNUmber() {
		return vendorPhoneNUmber;
	}

	/**
	 * @param vendorPhoneNUmber the vendorPhoneNUmber to set
	 */
	public void setVendorPhoneNUmber(String vendorPhoneNUmber) {
		this.vendorPhoneNUmber = vendorPhoneNUmber;
	}

	/**
	 * @return the vendorFaxNumber
	 */
	public String getVendorFaxNumber() {
		return vendorFaxNumber;
	}

	/**
	 * @param vendorFaxNumber the vendorFaxNumber to set
	 */
	public void setVendorFaxNumber(String vendorFaxNumber) {
		this.vendorFaxNumber = vendorFaxNumber;
	}

	/**
	 * @return the confirmationNumber
	 */
	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	/**
	 * @param confirmationNumber the confirmationNumber to set
	 */
	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	/**
	 * @return the mode
	 */
	public String getVendorMode() {
		return vendorMode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setVendorMode(String vendorMode) {
		this.vendorMode = vendorMode;
	}

	/**
	 * @return the agentMode
	 */
	public String getAgentMode() {
		return agentMode;
	}

	/**
	 * @param agentMode the agentMode to set
	 */
	public void setAgentMode(String agentMode) {
		this.agentMode = agentMode;
	}

	/**
	 * @return the agentEmailId
	 */
	public String getAgentEmailId() {
		return agentEmailId;
	}

	/**
	 * @param agentEmailId the agentEmailId to set
	 */
	public void setAgentEmailId(String agentEmailId) {
		this.agentEmailId = agentEmailId;
	}

	/**
	 * @return the agentPhoneNo
	 */
	public String getAgentPhoneNo() {
		return agentPhoneNo;
	}

	/**
	 * @param agentPhoneNo the agentPhoneNo to set
	 */
	public void setAgentPhoneNo(String agentPhoneNo) {
		this.agentPhoneNo = agentPhoneNo;
	}

	/**
	 * @return the agentFaxNo
	 */
	public String getAgentFaxNo() {
		return agentFaxNo;
	}

	/**
	 * @param agentFaxNo the agentFaxNo to set
	 */
	public void setAgentFaxNo(String agentFaxNo) {
		this.agentFaxNo = agentFaxNo;
	}

	/**
	 * @return the requestConfirmBy
	 */
	public String getRequestConfirmBy() {
		return requestConfirmBy;
	}

	/**
	 * @param requestConfirmBy the requestConfirmBy to set
	 */
	public void setRequestConfirmBy(String requestConfirmBy) {
		this.requestConfirmBy = requestConfirmBy;
	}

	/**
	 * @return the requestDeclineBy
	 */
	public String getRequestDeclineBy() {
		return requestDeclineBy;
	}

	/**
	 * @param requestDeclineBy the requestDeclineBy to set
	 */
	public void setRequestDeclineBy(String requestDeclineBy) {
		this.requestDeclineBy = requestDeclineBy;
	}

	/**
	 * @return the requestMode
	 */
	public String getRequestMode() {
		return requestMode;
	}

	/**
	 * @param requestMode the requestMode to set
	 */
	public void setRequestMode(String requestMode) {
		this.requestMode = requestMode;
	}

	/**
	 * Return the String representation of booking header
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<RFARequest>\n");
		sb.append("bookingNo: " + bookingNumber + "\n");
		sb.append("posnr: " +posnr + "\n");
		sb.append("confirmationNumber: " +confirmationNumber + "\n");
		sb.append("requestMode: " +requestMode + "\n");
		sb.append("vendorMode: " +vendorMode + "\n");
		sb.append("agentMode: " +agentMode + "\n");
		sb.append("agentEmailId: " +agentEmailId + "\n");
		sb.append("agentPhoneNo: " +agentPhoneNo + "\n");
		sb.append("agentFaxNo: " +agentFaxNo + "\n");
		sb.append("requestConfirmBy: " +requestConfirmBy + "\n");
		sb.append("requestDeclineBy: " +requestDeclineBy + "\n");
		sb.append("</RFARequest>");
		return sb.toString();
	}
}
