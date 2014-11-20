/*
 * UserType.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 30, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

/**
 * Enum to hold the type of the user
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public enum UserType {
	
	TRAVEL_AGENT(4), RESERVATION_AGENT(9), ADMINISTRATOR(22), SKED_DESK(23), CUSTOMER(1);
	
	private int code;	
	
	/**
	 * Constructor
	 * @param code
	 */
	private UserType(int code) {
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	
	/**
	 * Method to check whether the give user type is a Travel Agent or not
	 *
	 * @return true - if the given user is a travel agent
	 *
	 * @see
	 * @since
	 */
	public boolean isTravelAgent() {
		return this.code == TRAVEL_AGENT.code;
	}

	/**
	 * Method to check whether the give user type is a Reservation Agent or not
	 *
	 * @return true - if the given user is a reservation agent
	 *
	 * @see
	 * @since
	 */
	public boolean isReservationAgent() {
		return this.code == RESERVATION_AGENT.code;
	}

	/**
	 * Method to check whether the give user type is a Administrator or not
	 *
	 * @return true - if the given user is administrator
	 *
	 * @see
	 * @since
	 */
	public boolean isAdministrator() {
		return this.code == ADMINISTRATOR.code;
	}

	/**
	 * Method to check whether the give user type is a SKED Desk or not
	 *
	 * @return true - if the given user is a sked desk
	 *
	 * @see
	 * @since
	 */
	public boolean isSKEDDesk() {
		return this.code == SKED_DESK.code;
	}

	/**
	 * Method to check whether the give user type is a Customer not
	 *
	 * @return true - if the given user is a Customer
	 *
	 * @see
	 * @since
	 */
	public boolean isCustomer() {
		return this.code == CUSTOMER.code;
	}
	
	/**
	 * Method to retrieve the String form of the instance
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<UserType>\n");
		sb.append("\nCode: "+this.code+"</n>");
		if(this.isTravelAgent()) {
			sb.append("\nDescription: TRAVEL AGENT</n>");			
		} else if(this.isReservationAgent()) {
			sb.append("\nDescription: RESERVATION AGENT</n>");			
		} else if(this.isAdministrator()) {
			sb.append("\nDescription: ADMINISTRATOR</n>");			
		} else if(this.isSKEDDesk()) {
			sb.append("\nDescription: SKED DESK</n>");			
		} else {
			sb.append("\nDescription: CUSTOMER</n>");			
		}
		sb.append("\n</UserType>\n"); 
		return sb.toString();
	}
	
}
