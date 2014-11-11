/*
 * BookingHeader.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 28, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Value object to hold booking header details
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class BookingHeader implements ABEDto {

	/**
	 * Default generated serial UID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -7307258674931477615L;

	/**
	 * @return the bookingNo
	 */
	public String getBookingNo() {
		return bookingNo;
	}

	/**
	 * @param bookingNo
	 *            the bookingNo to set
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	/**
	 * @return the bookingDate
	 */
	public Date getBookingDate() {
		return bookingDate;
	}

	/**
	 * @param bookingDate
	 *            the bookingDate to set
	 */
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	/**
	 * @return the bookingStatus
	 */
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	/**
	 * @param bookingStatus
	 *            the bookingStatus to set
	 */
	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	/**
	 * @return the tourId
	 */
	public String getTourId() {
		return tourId;
	}

	/**
	 * @param tourId
	 *            the tourId to set
	 */
	public void setTourId(String tourId) {
		this.tourId = tourId;
	}

	/**
	 * @return the agency
	 */
	public Agency getAgency() {
		return agency;
	}

	/**
	 * @param agency
	 *            the agency to set
	 */
	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	/**
	 * @return the tourPrice
	 */
	public double getTourPrice() {
		return tourPrice;
	}

	/**
	 * @param tourPrice
	 *            the tourPrice to set
	 */
	public void setTourPrice(double tourPrice) {
		this.tourPrice = tourPrice;
	}

	/**
	 * @return the amountDue
	 */
	public double getAmountDue() {
		return amountDue;
	}

	/**
	 * @param amountDue
	 *            the amountDue to set
	 */
	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}

	/**
	 * @return the minimumAmount
	 */
	public double getMinimumAmount() {
		return minimumAmount;
	}

	/**
	 * @param minimumAmount
	 *            the minimumAmount to set
	 */
	public void setMinimumAmount(double minimumAmount) {
		this.minimumAmount = minimumAmount;
	}

	/**
	 * @return the baseCommission
	 */
	public double getBaseCommission() {
		return baseCommission;
	}

	/**
	 * @param baseCommission
	 *            the baseCommission to set
	 */
	public void setBaseCommission(double baseCommission) {
		this.baseCommission = baseCommission;
	}

	/**
	 * @return the amountPaid
	 */
	public double getAmountPaid() {
		return amountPaid;
	}

	/**
	 * @param amountPaid
	 *            the amountPaid to set
	 */
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	/**
	 * @return the optionDate
	 */
	public Date getOptionDate() {
		return optionDate;
	}

	/**
	 * @param optionDate
	 *            the optionDate to set
	 */
	public void setOptionDate(Date optionDate) {
		this.optionDate = optionDate;
	}

	/**
	 * @return the cancellationDate
	 */
	public Date getCancellationDate() {
		return cancellationDate;
	}

	/**
	 * @param cancellationDate
	 *            the cancellationDate to set
	 */
	public void setCancellationDate(Date cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	/**
	 * @return the ticketingDate
	 */
	public Date getTicketingDate() {
		return ticketingDate;
	}

	/**
	 * @param ticketingDate
	 *            the ticketingDate to set
	 */
	public void setTicketingDate(Date ticketingDate) {
		this.ticketingDate = ticketingDate;
	}

	/**
	 * @return the departureDate
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate
	 *            the departureDate to set
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @return the trackingNo
	 */
	public String getTrackingNo() {
		return trackingNo;
	}

	/**
	 * @param trackingNo
	 *            the trackingNo to set
	 */
	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}

	/**
	 * @return the voucherDate
	 */
	public Date getVoucherDate() {
		return voucherDate;
	}

	/**
	 * @param voucherDate
	 *            the voucherDate to set
	 */
	public void setVoucherDate(Date voucherDate) {
		this.voucherDate = voucherDate;
	}

	/**
	 * @return the promoId
	 */
	public String getPromoId() {
		return promoId;
	}

	/**
	 * @param promoId
	 *            the promoId to set
	 */
	public void setPromoId(String promoId) {
		this.promoId = promoId;
	}

	/**
	 * @return the promoCode
	 */
	public String getPromoCode() {
		return promoCode;
	}

	/**
	 * @param promoCode
	 *            the promoCode to set
	 */
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	/**
	 * @return the promoSaving
	 */
	public double getPromoSaving() {
		return promoSaving;
	}

	/**
	 * @param promoSaving
	 *            the promoSaving to set
	 */
	public void setPromoSaving(double promoSaving) {
		this.promoSaving = promoSaving;
	}

	/**
	 * @return the guaranteedDate
	 */
	public Date getGuaranteedDate() {
		return guaranteedDate;
	}

	/**
	 * @param guaranteedDate
	 *            the guaranteedDate to set
	 */
	public void setGuaranteedDate(Date guaranteedDate) {
		this.guaranteedDate = guaranteedDate;
	}

	/**
	 * @return the finalDueDate
	 */
	public Date getFinalDueDate() {
		return finalDueDate;
	}

	/**
	 * @param finalDueDate
	 *            the finalDueDate to set
	 */
	public void setFinalDueDate(Date finalDueDate) {
		this.finalDueDate = finalDueDate;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastChangeBy
	 */
	public String getLastChangeBy() {
		return lastChangeBy;
	}

	/**
	 * @param lastChangeBy
	 *            the lastChangeBy to set
	 */
	public void setLastChangeBy(String lastChangeBy) {
		this.lastChangeBy = lastChangeBy;
	}

	/**
	 * @return the lastChangeDate
	 */
	public Date getLastChangeDate() {
		return lastChangeDate;
	}

	/**
	 * @param lastChangeDate
	 *            the lastChangeDate to set
	 */
	public void setLastChangeDate(Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}

	/**
	 * @return the travelDate
	 */
	public Date getTravelDate() {
		return travelDate;
	}

	/**
	 * @param travelDate
	 *            the travelDate to set
	 */
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	/**
	 * @return the salesOrg
	 */
	public String getSalesOrg() {
		return salesOrg;
	}

	/**
	 * @param salesOrg
	 *            the salesOrg to set
	 */
	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	/**
	 * @return the distributionChannel
	 */
	public String getDistributionChannel() {
		return distributionChannel;
	}

	/**
	 * @param distributionChannel
	 *            the distributionChannel to set
	 */
	public void setDistributionChannel(String distributionChannel) {
		this.distributionChannel = distributionChannel;
	}

	/**
	 * @return the callCenter
	 */
	public String getCallCenter() {
		return callCenter;
	}

	/**
	 * @param callCenter
	 *            the callCenter to set
	 */
	public void setCallCenter(String callCenter) {
		this.callCenter = callCenter;
	}

	/**
	 * @return the applyPaymentAllowed
	 */
	public boolean isApplyPaymentAllowed() {
		return applyPaymentAllowed;
	}

	/**
	 * @param applyPaymentAllowed
	 *            the applyPaymentAllowed to set
	 */
	public void setApplyPaymentAllowed(boolean applyPaymentAllowed) {
		this.applyPaymentAllowed = applyPaymentAllowed;
	}

	/**
	 * @return the zeroPriceError
	 */
	public boolean isZeroPriceError() {
		return zeroPriceError;
	}

	/**
	 * @param zeroPriceError
	 *            the zeroPriceError to set
	 */
	public void setZeroPriceError(boolean zeroPriceError) {
		this.zeroPriceError = zeroPriceError;
	}

	/**
	 * @return the priceMismatchError
	 */
	public boolean isPriceMismatchError() {
		return priceMismatchError;
	}

	/**
	 * @param priceMismatchError
	 *            the priceMismatchError to set
	 */
	public void setPriceMismatchError(boolean priceMismatchError) {
		this.priceMismatchError = priceMismatchError;
	}

	/**
	 * @return the alertCode
	 */
	public String getAlertCode() {
		return alertCode;
	}

	/**
	 * @param alertCode
	 *            the alertCode to set
	 */
	public void setAlertCode(String alertCode) {
		this.alertCode = alertCode;
	}

	/**
	 * @return the actionCode
	 */
	public String getActionCode() {
		return actionCode;
	}

	/**
	 * @param actionCode
	 *            the actionCode to set
	 */
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	/**
	 * @return the agencyRatingCode
	 */
	public String getAgencyRatingCode() {
		return agencyRatingCode;
	}

	/**
	 * @param agencyRatingCode
	 *            the agencyRatingCode to set
	 */
	public void setAgencyRatingCode(String agencyRatingCode) {
		this.agencyRatingCode = agencyRatingCode;
	}

	/**
	 * @return the grossBalanceDue
	 */
	public double getGrossBalanceDue() {
		return grossBalanceDue;
	}

	/**
	 * @param grossBalanceDue the grossBalanceDue to set
	 */
	public void setGrossBalanceDue(double grossBalanceDue) {
		this.grossBalanceDue = grossBalanceDue;
	}
	
	/**
	 * Clone method implementation
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */

	protected Object clone() throws CloneNotSupportedException {
		BookingHeader bookingHeader = (BookingHeader) super.clone();

		if (agency != null)
			bookingHeader.agency = (Agency) agency.clone();

		return bookingHeader;
	}

	/**
	 * Return the String representation of booking header
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<BookingHeader>\n");
		sb.append("bookingNo: " + bookingNo + "\n");
		sb.append("bookingDate: " + bookingDate + "\n");
		sb.append("bookingStatus: " + bookingStatus + "\n");
		sb.append("tourId: " + tourId + "\n");
		sb.append("agency: " + agency + "\n");
		sb.append("tourPrice: " + tourPrice + "\n");
		sb.append("amountDue: " + amountDue + "\n");
		sb.append("minimumAmount: " + minimumAmount + "\n");
		sb.append("baseCommission: " + baseCommission + "\n");
		sb.append("amountPaid: " + amountPaid + "\n");
		sb.append("optionDate: " + optionDate + "\n");
		sb.append("cancellationDate: " + cancellationDate + "\n");
		sb.append("ticketingDate: " + ticketingDate + "\n");
		sb.append("departureDate: " + departureDate + "\n");
		sb.append("guaranteedDate: " + guaranteedDate + "\n");
		sb.append("finalDueDate: " + finalDueDate + "\n");
		sb.append("trackingNo: " + trackingNo + "\n");
		sb.append("voucherDate: " + voucherDate + "\n");
		sb.append("promoId: " + promoId + "\n");
		sb.append("promoCode: " + promoCode + "\n");
		sb.append("promoSaving: " + promoSaving + "\n");
		sb.append("createdBy: " + createdBy + "\n");
		sb.append("createdDate: " + createdDate + "\n");
		sb.append("lastChangeBy: " + lastChangeBy + "\n");
		sb.append("lastChangeDate: " + lastChangeDate + "\n");
		sb.append("travelDate: " + travelDate + "\n");
		sb.append("salesOrg: " + salesOrg + "\n");
		sb.append("distributionChannel: " + distributionChannel + "\n");
		sb.append("applyPaymentAllowed: " + applyPaymentAllowed + "\n");
		sb.append("callCenter: " + callCenter + "\n");
		sb.append("zeroPriceError: " + zeroPriceError + "\n");
		sb.append("priceMismatchError: " + priceMismatchError + "\n");
		sb.append("alertCode: " + alertCode + "\n");
		sb.append("actionCode: " + actionCode + "\n");
		sb.append("agencyRatingCode: " + agencyRatingCode + "\n");
		sb.append("grossBalanceDue: " +grossBalanceDue + "\n");
		sb.append("</BookingHeader>");

		return sb.toString();
	}

	private String bookingNo;
	private Date bookingDate;
	private BookingStatus bookingStatus;
	private String tourId;
	private Agency agency;
	private double tourPrice;
	private double amountDue;
	private double minimumAmount;
	private double baseCommission;
	private double amountPaid;
	private Date optionDate;
	private Date cancellationDate;
	private Date ticketingDate;
	private Date departureDate;
	private Date guaranteedDate;
	private Date finalDueDate;
	private String trackingNo;
	private Date voucherDate;
	private String promoId;
	private String promoCode;
	private double promoSaving;
	private String createdBy;
	private Date createdDate;
	private String lastChangeBy;
	private Date lastChangeDate;
	private Date travelDate;
	private String salesOrg;
	private String distributionChannel;
	private String callCenter;
	private boolean applyPaymentAllowed;
	private boolean zeroPriceError;
	private boolean priceMismatchError;
	private String alertCode;
	private String actionCode;
	private ArrayList<PaymentHistoryInfo> paymentHistoryInformationList;
	private String agencyRatingCode;
	private String bookingDocumentType;
	private double  paymentDue;

	public double getPaymentDue() {
		return paymentDue;
	}

	public void setPaymentDue(double paymentDue) {
		this.paymentDue = paymentDue;
	}

	/*CQ8955- grossBalancedue Required for Agent email*/
	private double grossBalanceDue;
	
	/**
	 * @return the paymentHistoryInformationList
	 */
	public ArrayList<PaymentHistoryInfo> getPaymentHistoryInformationList() {
		return paymentHistoryInformationList;
	}

	/**
	 * @param paymentHistoryInformationList
	 *            the paymentHistoryInformationList to set
	 */
	public void setPaymentHistoryInformationList(
			ArrayList<PaymentHistoryInfo> paymentHistoryInformationList) {
		this.paymentHistoryInformationList = paymentHistoryInformationList;
	}

	/**
	 * @return the bookingDocumentType
	 */
	public String getBookingDocumentType() {
		return bookingDocumentType;
	}

	/**
	 * @param bookingDocumentType the bookingDocumentType to set
	 */
	public void setBookingDocumentType(String bookingDocumentType) {
		this.bookingDocumentType = bookingDocumentType;
	}
	

}