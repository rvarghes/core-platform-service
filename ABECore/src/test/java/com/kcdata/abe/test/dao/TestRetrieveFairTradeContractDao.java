/*
 * TestRetrieveFairTradeContractDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 19, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.test.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.business.response.FairTradeContractResponse;
import com.kcdata.abe.data.dao.FairTradeContractDao;
import com.kcdata.abe.framework.context.ABEApplicationContext;

/**
 * UNIT test class to test Fair Trade Contract DAO
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRetrieveFairTradeContractDao {

	@Autowired
	private FairTradeContractDao ftcDao;

	/**
	 * Method to test the Fair Trade Contarct DAO for retrieving terms &
	 * conditions
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveFTC() {
		// Get the Application Context and Request Context
		ABEApplicationContext applicationContext = this.ftcDao
				.getApplicationContextFactory().getApplicationContext();
		if (applicationContext == null) {
			applicationContext = this.ftcDao.getApplicationContextFactory()
					.create();
		}
		FairTradeContractResponse ftcResponse = this.ftcDao
				.retrieveTermsAndConditions();
		assertNotNull(ftcResponse);
	}
}