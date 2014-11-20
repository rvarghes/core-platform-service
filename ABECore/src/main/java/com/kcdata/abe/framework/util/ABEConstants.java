/*
 * ABEConstants.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 15, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.framework.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Interface for defining various constants used in application
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public interface ABEConstants {
	//Constant definitions for various types of BAPI return message types
	//Information (shown as pop up), Warning, Error (shown on screen), 
	//Irrecoverable system error
	public static final String BAPI_RETURN_TYPE_INFO = "I";
	public static final String BAPI_RETURN_TYPE_WARNING = "W";
	public static final String BAPI_RETURN_TYPE_ERROR = "E";
	public static final String BAPI_RETURN_TYPE_ABORT = "A";
	public static final String BAPI_RETURN_TYPE_DEBUG = "N";

	//Constant definitions for different user types
	public static int USERTYPE_TRAVELAGENT = 1;
	public static int USERTYPE_RESERVATIONAGENT = 2;
	public static int USERTYPE_ADMINISTRATOR = 6;
	public static int USERTYPE_SKEDCDESK = 12;

	// Flight direction codes to R/3
	public static String OUTBOUND_DIRECTION = "1";
	public static String INBOUND_DIRECTION = "2";
	
	//Existing AppleSavers	SU, WS, MS, AS, SD 
	public String strAppleSavers[]={"AS","SD","SU","WS","MS"};  
	public static Set<String> appleSavers = new HashSet<String>(Arrays.asList(strAppleSavers));
	
	public static String RFA_HOTEL_STATUS = "Q";
	
	public static String ON_YOUR_OWN_HOTEL_TEXT = "ON YOUR OWN";
	//SeatMap constants
	public static String DOLLAR = "$";
	public static String FRONT_SLASH_DOLLAR = "\\$";
	public static String SEATMAP_CONCAT_REQ = "seatMapConcatReq";
	public static final String LEG_ID = "legid";
	public static final String PREVIEW = "preview";
	public static final String SOURCE = "source";
	public static final String PAX_JSON = "paxJson";
	public static final String ABE = "ABE";
	public static final String NEW_LINE = "\n";
	public static boolean TRUE = true;
	public static boolean False = false;
	public static final String MISC_SUPPLEMENT_CODE = "84";
	public static final String SEAT_MATERIAL_CODE = "-SNO";
	public static final String SEAT_SELECTED_DATE_FORMAT = "yyyyMMdd";
	public static final String DATE_FORMAT = "EEE MMM dd HH:mm:ss z yyyy";
	public static final String DATE_FORMAT_APPLE_EXTRA = "MM/dd/yyyy";
	//Group Booking
	public static final String GROUP_BOOKING_DOC_TYPE_CODE = "ZGR";
	public static final String GROUP_BOOKING_FIRST_NAME = "GROUP RESERVATION";
	public static final String GROUP_BOOKING_LAST_NAME = "GROUP BOOKING";
	public static final String STRING_ZERO = "0";
	
	//Comments Constants
	public static String BLANK = "";
	public static String BLANK_SPACE = " ";
	public static String SELECTED_SEAT = "selected seat";
	public static String FROM = "from";
	public static String TO = "to";
	public static String CHANGED = "changed";
	public static String REMOVED = "removed";
	public static String ADD_SEAT_COMMENT = "ADD_COMMENT";
	public static String UPDATE_SEAT_COMMENT = "UPDATE_SEAT_COMMENT";
	public static String REMOVE_SEAT_COMMENT = "REMOVE_SEAT_COMMENT";
	public static String OLD_SEATS = "OldSeats";
	public static String NEW_SEATS = "NewSeats";
	public static String COMMA = ",";
	public static String X = "X";
	public static String US_CURRENCY = "USD";
	public static String SEAT_MAP_URL = "seatMapURL";
	public static String SEAT_PRICE_CHANGED = "Seat price has changed.";
	public static String INBOUND_FLIGHT = "Inbound";
	public static String OUTBOUND_FLIGHT = "Outbound";
	public static String SEAT_MODIFY = "Modify";
	public static String SEAT_ADD = "Add";
	public static String SEAT_CANCEL = "Cancel";
	public static String SEAT_NO_ACTION = "NoAction";
	public static String PPP = "Preferred Perks Plus";
	public static String PRM = "Premium";
	public static String BOOKING_CP = "CP";
	//Editing by IGT
	public static String SEAT_BOOKING_ERROR = "Sorry, we are unable to confirm the seats selected for some passengers on one or more of your flights. Next to your air itinerary, please select View/Change Seats to choose seats for the unconfirmed passengers and flights.";
	//End Editing
	public static String SEAT_PRICING_ERROR = "Seat price has been modified. Please contact Apple Vacations at 1-800-517-2000 ";
	public static String PROTOCOL = "protocol";
	
	//Constants added for cabin  classes
	public static String FIRST_CLASS = "First";
	public static String COACH_CLASS = "Coach";
	
	//Error message code added for issue# 3621763(Rapid re-pricing)
	public static String RAPID_REPRICE_ERROR_CODE="763";
	
}

