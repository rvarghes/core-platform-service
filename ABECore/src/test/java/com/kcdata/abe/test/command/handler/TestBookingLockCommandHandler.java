/*
 * TestBookingLockCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 22, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.BookingLockCommand;
import com.kcdata.abe.application.command.handler.BookingLockCommandHandler;
import com.kcdata.abe.data.dto.BookingLockDetails;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.UserType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestBookingLockCommandHandler {
	
	@Autowired
	private BookingLockCommandHandler bookingLockCommandHandler;
		
	@Test
	public void createLock() {
		BookingLockCommand bookingLockCommand = new BookingLockCommand();
		bookingLockCommand.setBookingNo("0050519090");
		bookingLockCommand.setSubCommand(BookingLockCommand.CREATE_LOCK);
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		applicationInfo.setCreatedBy("hguntupalli");
		bookingLockCommand.setIMApplicationInfo(applicationInfo);
		bookingLockCommand = (BookingLockCommand) this.bookingLockCommandHandler.handle(bookingLockCommand);
		assertNotNull(bookingLockCommand.getBookingLockDetails());
	}

	@Test
	public void releaseLock() {
		BookingLockCommand bookingLockCommand = new BookingLockCommand();
		bookingLockCommand.setBookingNo("50519090");
		bookingLockCommand.setSubCommand(BookingLockCommand.RELEASE_LOCK);
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		applicationInfo.setCreatedBy("hguntupalli");
		bookingLockCommand.setIMApplicationInfo(applicationInfo);
		BookingLockDetails bookingLockDetails = new BookingLockDetails();
		bookingLockDetails.setBookingNo("50519090");
		bookingLockDetails.setLockId("005051909020100622095007NYFNOL");
		bookingLockCommand.setBookingLockDetails(bookingLockDetails);
		bookingLockCommand = (BookingLockCommand) this.bookingLockCommandHandler.handle(bookingLockCommand);
		assertNotNull(bookingLockCommand.getBookingLockDetails());
	}
}

