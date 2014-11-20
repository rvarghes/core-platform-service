/*
 * TestRetrieveFareRulesCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 14, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.RetrieveFareRulesCommand;
import com.kcdata.abe.application.command.handler.RetrieveFareRulesCommandHandler;
import com.kcdata.abe.data.dto.Carrier;
import com.kcdata.abe.data.dto.FareBasisCode;
import com.kcdata.abe.data.dto.Flight;
import com.kcdata.abe.data.dto.FlightSegment;
import com.kcdata.abe.data.dto.FlightType;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.UserType;

/**
 * UNIT test class to test the {@link TestRetrieveFareRulesCommandHandler}
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRetrieveFareRulesCommandHandler {
	
	@Autowired
	private RetrieveFareRulesCommandHandler retrieveFareRulesCommandHandler;
	
	/**
	 * Method for testing fare rules retrieval DAO
	 *
	 * @see
	 * @since
	 */
	@Test
	public void retrieveFareRules() throws ParseException {
		RetrieveFareRulesCommand fareRulesCommand = new RetrieveFareRulesCommand();
		
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		fareRulesCommand.setIMApplicationInfo(applicationInfo);
		
		TripFlight tripFlight = getTripFlight();
		
		fareRulesCommand.setTripFlight(tripFlight);
		
		fareRulesCommand = (RetrieveFareRulesCommand) retrieveFareRulesCommandHandler.handle(fareRulesCommand);
		assertNotNull(fareRulesCommand.getFareRules());		
	}

	/**
	 * Method for testing fare rules retrieval DAO
	 *
	 * @see
	 * @since
	 */
	@Test
	public void retrieveAdditionalFareRules() throws ParseException {
		RetrieveFareRulesCommand fareRulesCommand = new RetrieveFareRulesCommand();
		
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		fareRulesCommand.setIMApplicationInfo(applicationInfo);
		
		TripFlight tripFlight = getTripFlight();
		
		fareRulesCommand.setTripFlight(tripFlight);
		fareRulesCommand.setFetchAdditionalRules(true);
		
		fareRulesCommand = (RetrieveFareRulesCommand) retrieveFareRulesCommandHandler.handle(fareRulesCommand);
		assertNotNull(fareRulesCommand.getFareRules());		
	}
	
	/**
	 * Method to prepare trip flight
	 * 
	 * @throws ParseException 
	 *
	 * @see
	 * @since
	 */
	private TripFlight getTripFlight() throws ParseException {
		
		TripFlight tripFlight = new TripFlight();
		//P for Published SKED, C for contracted SKED
		tripFlight.setFlightType(FlightType.PUBLISHED);
		
		SimpleDateFormat sdfDateTime = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		
		//Create oubound flight data
		Flight outbound = new Flight();
		outbound.setGateway("ORD");
		outbound.setDestination("OGG");
		//Create outbound segment details
		ArrayList<FlightSegment> outboundSegments = new ArrayList<FlightSegment>();
		//First outbound segment
		FlightSegment obSegment = new FlightSegment();
		obSegment.setGateway("ORD");
		obSegment.setDestination("MSP");
		obSegment.setDepartureDate(sdfDateTime.parse("08/17/2009 07:00"));
		obSegment.setArrivalDate(sdfDateTime.parse("08/17/2009 08:25"));
		Carrier carrier = new Carrier();
		carrier.setCarrierCode("DL");
		obSegment.setCarrier(carrier);
		obSegment.setFlightNo("3284");
		Carrier codeShareCarrier = new Carrier();
		codeShareCarrier.setCarrierCode("NW");
		obSegment.setCodeShareCarrier(codeShareCarrier);
		obSegment.setAircraftType("320");
		obSegment.setClassOfService("Q");
		FareBasisCode fareBasisCode = new FareBasisCode();
		fareBasisCode.setAdultCode("KU00K9NC");
		obSegment.setFareBasisCode(fareBasisCode);		
		outboundSegments.add(obSegment);
		
		//Second outbound segment
		obSegment = new FlightSegment();
		obSegment.setGateway("MSP");
		obSegment.setDestination("SEA");
		obSegment.setDepartureDate(sdfDateTime.parse("08/17/2009 09:20"));
		obSegment.setArrivalDate(sdfDateTime.parse("08/17/2009 11:05"));
		carrier = new Carrier();
		carrier.setCarrierCode("DL");
		obSegment.setCarrier(carrier);
		obSegment.setFlightNo("2987");
		codeShareCarrier = new Carrier();
		codeShareCarrier.setCarrierCode("NW");
		obSegment.setCodeShareCarrier(codeShareCarrier);
		obSegment.setAircraftType("753");
		obSegment.setClassOfService("Q");
		fareBasisCode = new FareBasisCode();
		fareBasisCode.setAdultCode("KU00K9NC");
		obSegment.setFareBasisCode(fareBasisCode);
		outboundSegments.add(obSegment);
		//Set segments
		outbound.setFlightSegments(outboundSegments);
		//Set outbound flight
		tripFlight.setOutboundFlight(outbound);
		
		//Create inbound flight data
		Flight inbound = new Flight();
		inbound.setGateway("SEA");
		inbound.setDestination("ORD");
		//Create inbound segment details
		ArrayList<FlightSegment> inboundSegments = new ArrayList<FlightSegment>();
		//First inbound segment
		FlightSegment inSegment = new FlightSegment();
		inSegment.setGateway("SEA");
		inSegment.setDestination("SLC");
		inSegment.setDepartureDate(sdfDateTime.parse("08/25/2009 06:03"));
		inSegment.setArrivalDate(sdfDateTime.parse("08/17/2009 09:10"));
		carrier = new Carrier();
		carrier.setCarrierCode("DL");
		inSegment.setCarrier(carrier);
		inSegment.setFlightNo("1658");
		codeShareCarrier = new Carrier();
		codeShareCarrier.setCarrierCode("NW");
		inSegment.setCodeShareCarrier(codeShareCarrier);
		inSegment.setAircraftType("757");
		inSegment.setClassOfService("L");
		fareBasisCode = new FareBasisCode();
		fareBasisCode.setAdultCode("KU00K9NC");
		inSegment.setFareBasisCode(fareBasisCode);		
		inboundSegments.add(inSegment);
		
		//Second inbound segment
		inSegment = new FlightSegment();
		inSegment.setGateway("SLC");
		inSegment.setDestination("ORD");
		inSegment.setDepartureDate(sdfDateTime.parse("08/25/2009 10:02"));
		inSegment.setArrivalDate(sdfDateTime.parse("08/25/2009 14:17"));
		carrier = new Carrier();
		carrier.setCarrierCode("DL");
		inSegment.setCarrier(carrier);
		inSegment.setFlightNo("1222");
		inSegment.setCodeShareCarrier(codeShareCarrier);
		inSegment.setAircraftType("M90");
		inSegment.setClassOfService("L");
		fareBasisCode = new FareBasisCode();
		fareBasisCode.setAdultCode("KU00K9NC");
		inSegment.setFareBasisCode(fareBasisCode);
		inboundSegments.add(inSegment);
		//Set segments
		inbound.setFlightSegments(inboundSegments);
		//Set inbound flight
		tripFlight.setInboundFlight(inbound);
		
		return tripFlight;
	}
}