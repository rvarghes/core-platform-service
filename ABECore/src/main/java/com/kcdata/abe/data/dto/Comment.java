/*
 * Comment.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 22, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Dto class to hold the Comment details
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class Comment implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -274530008947648809L;

	private Date createdDate;
	private String createdBy;
	private String callcenter;
	private boolean newlyCreated;
	private CommentType commentType;
	private String commentDetails;
	private String bookingNumber;

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
	 * @return the callcenter
	 */
	public String getCallcenter() {
		return callcenter;
	}

	/**
	 * @param callcenter
	 *            the callcenter to set
	 */
	public void setCallcenter(String callcenter) {
		this.callcenter = callcenter;
	}

	/**
	 * @return the newlyCreated
	 */
	public boolean isNewlyCreated() {
		return newlyCreated;
	}

	/**
	 * @param newlyCreated
	 *            the newlyCreated to set
	 */
	public void setNewlyCreated(boolean newlyCreated) {
		this.newlyCreated = newlyCreated;
	}

	/**
	 * @return the commentType
	 */
	public CommentType getCommentType() {
		return commentType;
	}

	/**
	 * @param commentType
	 *            the commentType to set
	 */
	public void setCommentType(CommentType commentType) {
		this.commentType = commentType;
	}

	/**
	 * @return the commentDetails
	 */
	public String getCommentDetails() {
		return commentDetails;
	}

	/**
	 * @param commentDetails
	 *            the commentDetails to set
	 */
	public void setCommentDetails(String commentDetails) {
		this.commentDetails = commentDetails;
	}

	/**
	 * @return the bookingNumber
	 */
	public String getBookingNumber() {
		return bookingNumber;
	}

	/**
	 * @param bookingNumber
	 *            the bookingNumber to set
	 */
	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
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
		return super.clone();
	}
}
