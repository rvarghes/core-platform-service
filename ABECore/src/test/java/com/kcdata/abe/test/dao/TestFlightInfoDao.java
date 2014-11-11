/*
 * TestRetrieveFlightsCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 22, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.test.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.business.response.FlightInfoResponse;
import com.kcdata.abe.data.dao.FlightInfoDao;
import com.kcdata.abe.data.dao.FlightsDao;
import com.kcdata.abe.data.dto.FlightInfoCriteria;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Material;
import com.kcdata.abe.data.dto.UserType;
import com.kcdata.abe.framework.context.ABEApplicationContext;

/**
 * UNIT test class to test the {@link FlightsDao}
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestFlightInfoDao {

	@Autowired
	private FlightInfoDao flightInfoDao;

	/**
	 * Method to test the CharterFlightsCacheDaoImpl class retrieveFlights
	 * method
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveFlightInfo() {
		FlightInfoCriteria criteria = new FlightInfoCriteria();
		Material material = new Material();
		material.setBatchNo("10260907C1");
		material.setMaterialNo("PHLCUNC");
		criteria.setMaterial(material);
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		// Get the Application Context and Request Context
		ABEApplicationContext applicationContext = this.flightInfoDao
				.getApplicationContextFactory().getApplicationContext();
		if (applicationContext == null) {
			applicationContext = this.flightInfoDao
					.getApplicationContextFactory().create();
		}
		this.flightInfoDao.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.setIMApplicationInfo(applicationInfo);
		FlightInfoResponse response = this.flightInfoDao
				.retrieveFlightInfo(criteria);
		assertNotNull(response);
	}
}
