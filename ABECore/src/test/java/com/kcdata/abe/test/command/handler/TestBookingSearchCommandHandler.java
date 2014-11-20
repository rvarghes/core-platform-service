/*
 * TestBookingSearchCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 09, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.BookingSearchCommand;
import com.kcdata.abe.application.command.handler.BookingSearchCommandHandler;
import com.kcdata.abe.data.dto.BookingSearchCriteria;

/**
 * UNIT test class to test the {@link TestBookingSearchCommandHandler}
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestBookingSearchCommandHandler {

	@Autowired
	private BookingSearchCommandHandler bookingSearchCommandHandler;

	/**
	 * Method for testing booking search command handler
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void searchBookings() {
		BookingSearchCommand bookingSearchCommand = new BookingSearchCommand();

		//Retrieve all bookings made last week for 'CUN' destination
		BookingSearchCriteria searchCriteria = new BookingSearchCriteria();		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		searchCriteria.setBookingDate(cal.getTime());
		searchCriteria.setDestination("CUN");
		
		bookingSearchCommand.setBookingSearchCriteria(searchCriteria);

		bookingSearchCommand = (BookingSearchCommand) bookingSearchCommandHandler
				.handle(bookingSearchCommand);
		assertNotNull(bookingSearchCommand.getBookings());
	}
}