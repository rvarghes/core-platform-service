package com.kcdata.abe.data.dto;

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

public class SeatAllocations implements ABEDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6451222785353654947L;
	private String seatNo;
	private String paxName;
	private String sNo;
	private String oldSeatNo;
	private String paxNo;
	private Double seatPrice;
	private Double seatCost;
	private String segmentID;
	private String seatDescription;
	private String cabinClass;
	private String selectedDate;
	private String modifiedDate;
	private String availResponseDateTime;
	private String seatType;
	private String aircraftCode; 
	private String parentItemRph;
	private String departDate;
	
	private boolean seatSelected;//This needs to be true if seat has been selected or changed.
	
	
	public String serviceName;
	public Date deptDate;

	
	public String getSelectedDate() {
		return selectedDate;
	}
	public void setSelectedDate(String selectedDate) {
		this.selectedDate = selectedDate;
	}
	/**
	 * @return the seatNo
	 */
	public String getSeatNo() {
		return seatNo;
	}
	/**
	 * @return the seatDescription
	 */
	public String getSeatDescription() {
		return seatDescription;
	}
	/**
	 * @param seatDescription the seatDescription to set
	 */
	public void setSeatDescription(String seatDescription) {
		this.seatDescription = seatDescription;
	}
	/**
	 * @param seatNo the seatNo to set
	 */
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	/**
	 * @return the paxName
	 */
	public String getPaxName() {
		return paxName;
	}
	/**
	 * @param paxName the paxName to set
	 */
	public void setPaxName(String paxName) {
		this.paxName = paxName;
	}
	/**
	 * @return the sNo
	 */
	public String getSNo() {
		return sNo;
	}
	/**
	 * @param sNo the sNo to set
	 */
	public void setSNo(String sNo) {
		this.sNo = sNo;
	}
	/**
	 * @return the paxNo
	 */
	public String getPaxNo() {
		return paxNo;
	}
	/**
	 * @param paxNo the paxNo to set
	 */
	public void setPaxNo(String paxNo) {
		this.paxNo = paxNo;
	}
	/**
	 * @return the seatPrice
	 */
	public Double getSeatPrice() {
		return seatPrice;
	}
	/**
	 * @param seatPrice the seatPrice to set
	 */
	public void setSeatPrice(Double seatPrice) {
		this.seatPrice = seatPrice;
	}
	/**
	 * @return the seatCost
	 */
	public Double getSeatCost() {
		return seatCost;
	}
	/**
	 * @param seatCost the seatCost to set
	 */
	public void setSeatCost(Double seatCost) {
		this.seatCost = seatCost;
	}
	/**
	 * @return the segmentID
	 */
	public String getSegmentID() {
		return segmentID;
	}
	/**
	 * @param segmentID the segmentID to set
	 */
	public void setSegmentID(String segmentID) {
		this.segmentID = segmentID;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n<SeatAllocation>\n");
		sb.append("sNo: " + sNo + "\n");
		sb.append("paxName: " + paxName + "\n");
		sb.append("paxNo: " + paxNo + "\n");
		sb.append("seatPrice: " + seatPrice + "\n");
		sb.append("seatNo: " + seatNo + "\n");
		sb.append("seatCost: " + seatCost + "\n");
		sb.append("segmentID: " + seatDescription + "\n");
		sb.append("cabinClass: " + cabinClass + "\n");
		sb.append("selectedDate: " + selectedDate + "\n");
		sb.append("</SeatAllocation>");
		return sb.toString();
	}
	
	/**
	 * Method to clone the object
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		SeatAllocations seatAllocations = (SeatAllocations) super.clone();
		
		return seatAllocations;
	}
	public String getOldSeatNo() {
		return oldSeatNo;
	}
	public void setOldSeatNo(String oldSeatNo) {
		this.oldSeatNo = oldSeatNo;
	}
	public String getCabinClass() {
		return cabinClass;
	}
	public void setCabinClass(String cabinClass) {
		this.cabinClass = cabinClass;
	}
	/**
	 * @return the availResponseDateTime
	 */
	public String getAvailResponseDateTime() {
		return availResponseDateTime;
	}
	/**
	 * @param availResponseDateTime the availResponseDateTime to set
	 */
	public void setAvailResponseDateTime(String availResponseDateTime) {
		this.availResponseDateTime = availResponseDateTime;
	}
	/**
	 * @return the seatSelected
	 */
	public boolean isSeatSelected() {
		return seatSelected;
	}
	/**
	 * @param seatSelected the seatSelected to set
	 */
	public void setSeatSelected(boolean seatSelected) {
		this.seatSelected = seatSelected;
	}
	/**
	 * @return the seatType
	 */
	public String getSeatType() {
		return seatType;
	}
	/**
	 * @param seatType the seatType to set
	 */
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	/**
	 * @return the modifiedDate
	 */
	public String getModifiedDate() {
		return modifiedDate;
	}
	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	/**
	 * @return the aircraftCode
	 */
	public String getAircraftCode() {
		return aircraftCode;
	}
	/**
	 * @param aircraftCode the aircraftCode to set
	 */
	public void setAircraftCode(String aircraftCode) {
		this.aircraftCode = aircraftCode;
	}
	/**
	 * @return the parentItemRph
	 */
	public String getParentItemRph() {
		return parentItemRph;
	}
	/**
	 * @param parentItemRph the parentItemRph to set
	 */
	public void setParentItemRph(String parentItemRph) {
		this.parentItemRph = parentItemRph;
	}
	/**
	 * @return the departDate
	 */
	public String getDepartDate() {
		return departDate;
	}
	/**
	 * @param departDate the departDate to set
	 */
	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}
	

}
