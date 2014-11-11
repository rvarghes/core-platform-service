/*
 * CommentsDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 22, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.List;

import com.kcdata.abe.business.response.CommentsResponse;
import com.kcdata.abe.data.dto.Comment;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * Dao class for comments
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface CommentsDao extends ABEDao {
	
	/**
	 * Method to retrieve Comments of Booking
	 *
	 * @param bookingNumber
	 * @return
	 *
	 * @see
	 * @since
	 */
	public CommentsResponse retrieveComments(String bookingNumber);
	
	/**
	 * Method to add a comment to the booking
	 *
	 * @param comment
	 * @return
	 *
	 * @see
	 * @since
	 */
	public CommentsResponse addComment(Comment comment);
	
	/**
	 * Method to add a comment to the booking
	 *
	 * @param comment
	 * @return
	 *
	 * @see
	 * @since
	 */
	public CommentsResponse addComments(List<Comment> comments);

}
