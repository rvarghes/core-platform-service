/*
 * BookingLockSAPDaoImpl.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 21, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.sql.Date;
import java.sql.Time;

import com.kcdata.abe.bapi.Z_Api_Add_Sales_Doc_Lock_Input;
import com.kcdata.abe.bapi.Z_Api_Add_Sales_Doc_Lock_Output;
import com.kcdata.abe.bapi.Zsbook_LocType;
import com.kcdata.abe.business.response.BookingLockResponse;
import com.kcdata.abe.data.dto.BookingLockDetails;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.framework.context.ABEApplicationContext;
import com.kcdata.abe.framework.context.ABERequestContext;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;

/**
 * DAO class to create and release booking locks
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class BookingLockSAPDaoImpl extends ABESAPDaoBase implements
		BookingLockDao {

	/**
	 * Method to create booking lock
	 * 
	 * @param bookingNo
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public BookingLockResponse createLock(String bookingNo) {
		BookingLockResponse lockResponse = new BookingLockResponse();
		if (bookingNo == null) {
			// Return business error
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_BOOKING_NUMBER");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_BOOKING_NUMBER", null, null));
			lockResponse.saveBusinessError(businessError);
			return lockResponse;
		}
		Z_Api_Add_Sales_Doc_Lock_Input bapiInput = new Z_Api_Add_Sales_Doc_Lock_Input();
		bapiInput.setLock_Switch("L");
		bapiInput.setDoc_Details(this.getBookingLockType(null, bookingNo, false));

		// Execute BAPI
		Z_Api_Add_Sales_Doc_Lock_Output bapiOutput = (Z_Api_Add_Sales_Doc_Lock_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Z_Api_Add_Sales_Doc_Lock", bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.getReturn(), lockResponse);

		if (lockResponse.isBusinessErrorOccurred()) {
			return lockResponse;
		}

		// Process response
		if (bapiOutput.getLock_Info() != null) {
			BookingLockDetails lockDetails = new BookingLockDetails();
			lockDetails.setBookingNo(bookingNo);
			lockDetails.setLockId(bapiOutput.getLock_Info().getZzlocid());
			if ("X".equals(bapiOutput.getLock_Info().getAlready_Locked())) {
				lockDetails.setAlreadyLocked(true);
			}
			if (bapiOutput.getLock_Info().getMessage() != null
					&& !"".equals(bapiOutput.getLock_Info().getMessage())) {
				lockDetails.setLockMessage(this.getMessageSource().getMessage(
						"BOOKING_LOCK_MESSAGE",
						new Object[] { bapiOutput.getLock_Info().getZzuname(),
								bapiOutput.getLock_Info().getUname() }, null));
			}
			lockResponse.setBookingLockDetails(lockDetails);
		}
		return lockResponse;
	}

	/**
	 * Method to release booking lock
	 * 
	 * @param bookingLockDetails
	 * 
	 * @see
	 * @since
	 */
	public BookingLockResponse releaseLock(BookingLockDetails bookingLockDetails) {
		BookingLockResponse lockResponse = new BookingLockResponse();
		if (bookingLockDetails == null
				|| bookingLockDetails.getBookingNo() == null) {
			// Return business error
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_BOOKING_NUMBER");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_BOOKING_NUMBER", null, null));
			lockResponse.saveBusinessError(businessError);
			return lockResponse;
		}
		Z_Api_Add_Sales_Doc_Lock_Input bapiInput = new Z_Api_Add_Sales_Doc_Lock_Input();
		if (bookingLockDetails.isAdmin()) {
			bapiInput.setLock_Switch("A");
		} else {
			bapiInput.setLock_Switch("R");
		}
		bapiInput.setDoc_Details(this.getBookingLockType(bookingLockDetails
				.getLockId(), bookingLockDetails.getBookingNo(), bookingLockDetails.isAdmin()));

		// Execute BAPI
		Z_Api_Add_Sales_Doc_Lock_Output bapiOutput = (Z_Api_Add_Sales_Doc_Lock_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Z_Api_Add_Sales_Doc_Lock", bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.getReturn(), lockResponse);

		if (lockResponse.isBusinessErrorOccurred()) {
			return lockResponse;
		} else {
			BookingLockDetails lockDetails = new BookingLockDetails();
			lockDetails.setBookingNo(bookingLockDetails.getBookingNo());
			lockResponse.setBookingLockDetails(lockDetails);
		}
		return lockResponse;
	}

	/**
	 * Method to prepare the booking lock Input
	 * 
	 * @param lockId
	 * @param bookingNumber
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private Zsbook_LocType getBookingLockType(String lockId,
			String bookingNumber, boolean isAdmin) {
		Zsbook_LocType lockType = new Zsbook_LocType();
		lockType.setVbeln(bookingNumber);
		if (!isAdmin) {
			lockType.setZzlocid(lockId);
			ABEApplicationContext context = this.getApplicationContextFactory()
					.getApplicationContext();
			ABERequestContext requestContext = context.getRequestContext();
			IMApplicationInfo imApplicationInfo = requestContext
					.getIMApplicationInfo();
			if (imApplicationInfo != null) {
				lockType.setZzuname(imApplicationInfo.getCreatedBy());
			}
			lockType.setZzloc_Date(new Date(new java.util.Date().getTime()));
			lockType.setZzloc_Time(new Time(new java.util.Date().getTime()));
		}
		return lockType;
	}
}
