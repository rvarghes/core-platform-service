package com.kcdata.abe.data.dto;

import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

public class FlightSegmentUniqueCriteria  implements ABEDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String segmentId;
	String paxAllocation;
	String parentItemRph;
	String segIdConcat;
	private List<SeatAllocations> seatAllocationList;
	
	/**
	 * @return the segmentId
	 */
	public String getSegmentId() {
		return segmentId;
	}
	/**
	 * @param segmentId the segmentId to set
	 */
	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}
	/**
	 * @return the paxAllocation
	 */
	public String getPaxAllocation() {
		return paxAllocation;
	}
	/**
	 * @param paxAllocation the paxAllocation to set
	 */
	public void setPaxAllocation(String paxAllocation) {
		this.paxAllocation = paxAllocation;
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
	 * @return the seatAllocationList
	 */
	public List<SeatAllocations> getSeatAllocationList() {
		return seatAllocationList;
	}
	/**
	 * @param seatAllocationList the seatAllocationList to set
	 */
	public void setSeatAllocationList(List<SeatAllocations> seatAllocationList) {
		this.seatAllocationList = seatAllocationList;
	}
	/**
	 * @return the segIdConcat
	 */
	public String getSegIdConcat() {
		return segIdConcat;
	}
	/**
	 * @param segIdConcat the segIdConcat to set
	 */
	public void setSegIdConcat(String segIdConcat) {
		this.segIdConcat = segIdConcat;
	}

}
