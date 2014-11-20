/*
 * TestRetrieveBookingDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Nov 23, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.test.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.business.response.ApplyPaymentResponse;
import com.kcdata.abe.data.dao.ApplyPaymentDao;
import com.kcdata.abe.framework.context.ABEApplicationContext;

/**
 * UNIT test class to test Apply Payment Check DAO
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestApplyPaymentCheckDao {

	@Autowired
	private ApplyPaymentDao applyPaymentDao;

	/**
	 * Method to test Apply payment check DAO
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void applyPaymentCheck() {
		// Get the Application Context and Request Context
		ABEApplicationContext applicationContext = this.applyPaymentDao
				.getApplicationContextFactory().getApplicationContext();
		if (applicationContext == null) {
			applicationContext = this.applyPaymentDao.getApplicationContextFactory().create();
		}
		ApplyPaymentResponse applyPmntCheckResponse = 
			this.applyPaymentDao.applyPaymentCheck("0050012242", "", "SKEDCDESK");
		//Business error will be populated for Non-Sked desk users
		//Info message will be populated for Sked Desk users		
		assertTrue(applyPmntCheckResponse.getBusinessErrors() == null 
						&& applyPmntCheckResponse.getInfoMessages() == null);
	}
}