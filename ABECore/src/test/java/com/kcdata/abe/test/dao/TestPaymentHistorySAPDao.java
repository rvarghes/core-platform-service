/*
 * TestPaymentHistorySAPDao.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 22, 2010  agudise
 ******************************************************************************
 */

package com.kcdata.abe.test.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.business.response.PaymentHistoryResponse;
import com.kcdata.abe.data.dao.PaymentHistoryDao;
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
public class TestPaymentHistorySAPDao {

	@Autowired
	private PaymentHistoryDao paymentHistoryDao;
	
	@Test
	public void getPaymentHistory(){
		
		// Get the Application Context and Request Context
		ABEApplicationContext applicationContext = this.paymentHistoryDao
				.getApplicationContextFactory().getApplicationContext();
		if (applicationContext == null) {
			applicationContext = this.paymentHistoryDao.getApplicationContextFactory().create();
		}
		PaymentHistoryResponse paymentHistoryResponse = this.paymentHistoryDao.getPaymentHistory("50521018");
		
		//Business error will be populated for Non-Sked desk users
		//Info message will be populated for Sked Desk users		
		assertTrue(paymentHistoryResponse.getBusinessErrors() == null 
						&& paymentHistoryResponse.getInfoMessages() == null);

	}
}
