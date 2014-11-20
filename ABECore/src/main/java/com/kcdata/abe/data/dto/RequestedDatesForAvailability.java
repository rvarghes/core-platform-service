package com.kcdata.abe.data.dto;

import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * 
 * @author npanday
 *
 */
public class RequestedDatesForAvailability implements ABEDto ,Comparable<RequestedDatesForAvailability> {
	
	/**
	 * Default Serial version id
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  On request dates
	 */	
	private List<String> reqDates;
	/**
	 * @return the reqDates
	 */
	public List<String> getReqDates() {
		return reqDates;
	}
	/**
	 * @param reqDates the reqDates to set
	 */
	public void setReqDates(List<String> reqDates) {
		this.reqDates = reqDates;
	}
	/**
	 * @return the bookingDate
	 */
	public String getBookingDate() {
		return bookingDate;
	}
	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	/**
	 * @return the bookingDuration
	 */
	public String getBookingDuration() {
		return bookingDuration;
	}
	/**
	 * @param bookingDuration the bookingDuration to set
	 */
	public void setBookingDuration(String bookingDuration) {
		this.bookingDuration = bookingDuration;
	}
	/**
	 * @return the roomDescription
	 */
	public String getRoomDescription() {
		return roomDescription;
	}
	/**
	 * @param roomDescription the roomDescription to set
	 */
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
	/**
	 * @return the roomStatus
	 */
	public String getRoomStatus() {
		return roomStatus;
	}
	/**
	 * @param roomStatus the roomStatus to set
	 */
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	
	/**
	 * @param noOfRooms the noOfRooms to set
	 */
	public void setNoOfRooms(String noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	/**
	 * @return the noOfRooms
	 */
	public String getNoOfRooms() {
		return noOfRooms;
	}

	/**
	 * @param materialNumber the materialNumber to set
	 */
	public void setMaterialNumber(String materialNumber) {
		this.materialNumber = materialNumber;
	}
	/**
	 * @return the materialNumber
	 */
	public String getMaterialNumber() {
		return materialNumber;
	}

	/**
	 *  Total No of rooms
	 */
	private String noOfRooms = "1";

	/**
	 * bookingDate
	 */
	private String bookingDate;	
	/**
	 * Duration
	 */
	private String bookingDuration;
	/**
	 * Room Description
	 */
	private String roomDescription;
	/**
	 * room status RQ for request
	 */
	private String roomStatus;
	
	/**
	 * Material Number
	 */
	private String materialNumber;
	public int compareTo(RequestedDatesForAvailability o) {
		if(this.materialNumber.trim().equalsIgnoreCase(o.getMaterialNumber().trim())){
			return 0;
		}else{
			return 1;
		}		
	}
	
}
