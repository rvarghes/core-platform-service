package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

public class ExpireBooking implements ABEDto {

	public String bookingStatus;

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

}
