/*
 * CommentsServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 22, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import java.util.List;

import com.kcdata.abe.business.response.CommentsResponse;
import com.kcdata.abe.data.dao.CommentsDao;
import com.kcdata.abe.data.dto.Comment;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Service implementation class for Comments
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class CommentsServiceImpl extends ABEServiceBase implements
		CommentsService {

	private CommentsDao commetsDao;

	/**
	 * @return the commetsDao
	 */
	public CommentsDao getCommetsDao() {
		return commetsDao;
	}

	/**
	 * @param commetsDao
	 *            the commetsDao to set
	 */
	public void setCommetsDao(CommentsDao commetsDao) {
		this.commetsDao = commetsDao;
	}

	/**
	 * Method to add a comment to the booking
	 * 
	 * @param comment
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public CommentsResponse addComment(Comment comment) {
		return this.getCommetsDao().addComment(comment);
	}

	/**
	 * Method to add a comment to the booking
	 * 
	 * @param comment
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public CommentsResponse addComments(List<Comment> comments) {
		return this.getCommetsDao().addComments(comments);
	}
	/**
	 * Method to retrieve Comments of Booking
	 * 
	 * @param bookingNumber
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public CommentsResponse retrieveComments(String bookingNumber) {
		return this.getCommetsDao().retrieveComments(bookingNumber);
	}

}
