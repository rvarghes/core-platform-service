/*
 * CommentType.java
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

/**
 * Enum class to hold the CommentTypes 
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public enum CommentType {
// enum OPS added for regression testing issue on 05/08/2013
	MANUAL('K'), HISTORY('H'), AUTO('A'), OPS('M');

	private char type;

	/**
	 * Default constructor
	 */
	private CommentType() {
	}

	/**
	 * Over loaded constructor
	 * 
	 * @param type
	 */
	private CommentType(char type) {
		this.type = type;
	}

	/**
	 * Method to get the comment type
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public char getType() {
		return this.type;
	}

	/**
	 * Method to check the comment is HISTORY or not
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public boolean isHistory() {
		return this.type == HISTORY.getType();
	}

	/**
	 * Method to check whether the comment is manual or not
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public boolean isManual() {
		return this.type == MANUAL.getType();
	}
	
	/**
	 * Method to check whether the comment is auto or not
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public boolean isAuto() {
		return this.type == AUTO.getType();
	}	

	
	/**
	 * Method to check whether the comment is OPS or not
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public boolean isOPS() {
		return this.type == OPS.getType();
	}
	/**
	 * Method to get the CommentType based on the type
	 *
	 * @param type
	 * @return
	 *
	 * @see
	 * @since
	 */
	public static CommentType getCommentType(char type) {
		if(MANUAL.type == type) {
			return MANUAL;
		}
		if(HISTORY.type == type) {
			return HISTORY;
		}
		if(AUTO.type == type) {
			return AUTO;
		}
		if(OPS.type == type){
			return OPS;
		}
		return null;
	}
}
