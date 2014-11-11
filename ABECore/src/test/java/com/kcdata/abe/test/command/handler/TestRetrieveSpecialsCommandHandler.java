/*
 * TestRetrieveSpecialsCommandHandler.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jan 5, 2011  chazari
 ******************************************************************************
 */

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.RetrieveSpecialsCommand;
import com.kcdata.abe.application.command.handler.RetrieveSpecialsCommandHandler;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.SpecialOptions;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRetrieveSpecialsCommandHandler {
	
	@Autowired
	private RetrieveSpecialsCommandHandler retrieveSpecialsCommandHandler; 
	
	/**
	 * Test to retrieve all specials for next one year.
	 * In order to use retrieve all specials command, include specialsSupport.jar in 
	 * class path. 
	 * @see TestRetrieveSpecialPackagesCommandHandler
	 */
	@Test
	public void retrieveSpecials() {
		RetrieveSpecialsCommand specialsCommand = new RetrieveSpecialsCommand();

		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setGateway("PHL");
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(2011, 00, 22);
		searchCriteria.setDepartureDate(c.getTime());		
		
		DestinationOptions dOptions = new DestinationOptions();
		dOptions.setNoOfNights((short)365);
		dOptions.setHotelRequested(true);
		
		SpecialOptions specialOptions = new SpecialOptions();
		specialOptions.setSpecialCategoryId("779");
		dOptions.setSpecialOptions(specialOptions);
		List<DestinationOptions> dOptionsList = new ArrayList<DestinationOptions>();
		dOptionsList.add(dOptions);
		
		searchCriteria.setDestinationOptions(dOptionsList);
		specialsCommand.setSearchCriteria(searchCriteria);		
		
		specialsCommand = (RetrieveSpecialsCommand) retrieveSpecialsCommandHandler
				.handle(specialsCommand);
		assertNotNull(specialsCommand.getSpecialsList());
	}
	
}
