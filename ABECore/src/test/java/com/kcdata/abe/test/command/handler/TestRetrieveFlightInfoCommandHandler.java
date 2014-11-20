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

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.RetrieveFlightInfoCommand;
import com.kcdata.abe.application.command.handler.RetrieveFlightInfoCommandHandler;
import com.kcdata.abe.application.command.handler.RetrieveFlightsCommandHandler;
import com.kcdata.abe.data.dto.FlightInfoCriteria;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Material;
import com.kcdata.abe.data.dto.UserType;

/**
 * UNIT test class to test the {@link RetrieveFlightsCommandHandler}
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
public class TestRetrieveFlightInfoCommandHandler {
	
	@Autowired
	private RetrieveFlightInfoCommandHandler retrieveFlightInfoCommandHandler;
	
	/**
	 * Method to test the CharterFlightsCacheDaoImpl class retrieveFlights method
	 *
	 *
	 * @see
	 * @since
	 */
	@Test
	public void retrieveFlight() {
		FlightInfoCriteria criteria = new FlightInfoCriteria();
		Material material = new Material();
		material.setBatchNo("11081007A1");
		material.setMaterialNo("PHLPUJC");
		criteria.setMaterial(material);
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("0000206298");
		applicationInfo.setRequestorID("10000");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		RetrieveFlightInfoCommand command = new RetrieveFlightInfoCommand();
		command.setFlightInfoCriteria(criteria);
		command.setIMApplicationInfo(applicationInfo);
		command =  (RetrieveFlightInfoCommand) this.retrieveFlightInfoCommandHandler.handle(command);
		assertNotNull(command.getTripFlight());		
	}
}
