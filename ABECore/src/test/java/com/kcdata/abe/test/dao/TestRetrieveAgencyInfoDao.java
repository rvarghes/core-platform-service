/*
 * TestRetrieveAgencyInfoDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 17, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.test.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.business.response.AgencyResponse;
import com.kcdata.abe.data.dao.AgencyInfoDao;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.UserType;
import com.kcdata.abe.framework.context.ABEApplicationContext;

/**
 * UNIT test class to test Agency Info DAO
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRetrieveAgencyInfoDao {

	@Autowired
	private AgencyInfoDao agencyInfoDao;

	/**
	 * Method to test the Agency DAO for retrieving agency information
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveAgencyInfo(){
		// Prepare application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");

		// Get the Application Context and Request Context
		ABEApplicationContext applicationContext = this.agencyInfoDao
				.getApplicationContextFactory().getApplicationContext();
		if (applicationContext == null) {
			applicationContext = this.agencyInfoDao
					.getApplicationContextFactory().create();
		}
		this.agencyInfoDao.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.setIMApplicationInfo(applicationInfo);

		AgencyResponse agencyResponse = this.agencyInfoDao.retrieveAgencyInfo();
		assertNotNull(agencyResponse);
	}
}