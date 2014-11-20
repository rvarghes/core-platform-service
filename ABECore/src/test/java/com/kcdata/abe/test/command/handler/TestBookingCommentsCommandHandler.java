/*
 * TestBookingCommentsCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 22, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.BookingCommentsCommand;
import com.kcdata.abe.application.command.handler.BookingCommentsCommandHandler;
import com.kcdata.abe.data.dto.Comment;

/**
 * UNIT test class to test the {@link BookingCommentsCommandHandler}
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestBookingCommentsCommandHandler {

	@Autowired
	private BookingCommentsCommandHandler bookingCommentsCommandHandler;

	/**
	 * Method to test the BookingCommentsCommandHandler class addComment method
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void addComment() {
		BookingCommentsCommand commentsCommand = new BookingCommentsCommand();
		Comment comment = new Comment();
		comment.setBookingNumber("0011091454");
		comment.setCommentDetails("UNIT Test from JAVA");
		comment.setCreatedBy("hguntupalli");
		commentsCommand.setComment(comment);
		commentsCommand.setSubCommand(BookingCommentsCommand.ADD_COMMENT);
		commentsCommand = (BookingCommentsCommand)  bookingCommentsCommandHandler.handle(commentsCommand);
		assertNotNull(commentsCommand.getInfoMessages());
	}
	
	/**
	 * Method to test the BookingCommentsCommandHandler class retrieveComments method
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveComments() {
		BookingCommentsCommand commentsCommand = new BookingCommentsCommand();
		commentsCommand.setSubCommand(BookingCommentsCommand.RETRIEVE_COMMENT);
		commentsCommand.setBookingNumber("0011091454");
		commentsCommand = (BookingCommentsCommand)  bookingCommentsCommandHandler.handle(commentsCommand);
		assertNotNull(commentsCommand.getCommentsList());
	}
}
