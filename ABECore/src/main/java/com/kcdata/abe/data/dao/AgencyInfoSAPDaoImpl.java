/*
 * AgencyInfoSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 17, 2009  nvittal
 * Sep 24, 2009	 hguntupa	  Changes for IMApplicationInfo
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.Iterator;

import com.kcdata.abe.bapi.Y_Bapi_Get_Agency_Info_Input;
import com.kcdata.abe.bapi.Y_Bapi_Get_Agency_Info_Output;
import com.kcdata.abe.bapi.Yst_Bapi_Agency_HdrType;
import com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType;
import com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType;
import com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType;
import com.kcdata.abe.bapi.util.Yst_Bapi_Contact_PersonType_List;
import com.kcdata.abe.business.response.AgencyResponse;
import com.kcdata.abe.data.dto.Agency;
import com.kcdata.abe.data.dto.Agent;
import com.kcdata.abe.data.dto.CreditCard;
import com.kcdata.abe.data.dto.PaymentMethod;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.logging.ABELogger;

/**
 * DAO implementation class for fetching agency information
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class AgencyInfoSAPDaoImpl extends ABESAPDaoBase implements
		AgencyInfoDao {

	ABELogger logger = ABELogger.getLogger(AgencyInfoSAPDaoImpl.class);

	/**
	 * Implementation to retrieve agency information
	 * 
	 * @return agency response
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public AgencyResponse retrieveAgencyInfo() {

		AgencyResponse agencyResponse = new AgencyResponse();

		Y_Bapi_Get_Agency_Info_Input bapiInput = new Y_Bapi_Get_Agency_Info_Input();

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// execute the BAPI
		Y_Bapi_Get_Agency_Info_Output bapiOutput = (Y_Bapi_Get_Agency_Info_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Bapi_Get_Agency_Info", bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(), agencyResponse);

		// Return response in case of any business errors
		if (agencyResponse.isBusinessErrorOccurred())
			return agencyResponse;

		// Prepare agency header object
		Yst_Bapi_Agency_HdrType agencyHeader = bapiOutput
				.getEx_St_Agency_Header();
		Agency agency = new Agency();
		agency.setCustomerNo(agencyHeader.getCustomer_No());
		agency.setIataNo(agencyHeader.getIata_No());
		agency.setName(agencyHeader.getName1());
		agency.setCity(agencyHeader.getCity());
		agency.setPoBox(agencyHeader.getPo_Box());
		agency.setPoBoxZipCode(agencyHeader.getPo_Box_Zipcode());
		agency.setZipCode(agencyHeader.getZipcode());
		agency.setState(agencyHeader.getState());
		agency.setStreet(agencyHeader.getHouse_No());
		agency.setPrimaryPhone(agencyHeader.getPhone_No_Pri());
		agency.setSecondaryPhone(agencyHeader.getPhone_No_Sec());
		agency.setFaxNo(agencyHeader.getFax_No());
		agency.setCountry(agencyHeader.getCountry());
		agency.setAgencyRatingCode(agencyHeader.getAbc_Code());

		// Parse & Prepare agents list
		Yst_Bapi_Contact_PersonType_List bpAgentList = bapiOutput
				.get_as_listIt_Contact_Persons();
		Iterator<Yst_Bapi_Contact_PersonType> itAgent = bpAgentList.iterator();
		ArrayList<Agent> agents = new ArrayList<Agent>();

		while (itAgent.hasNext()) {
			Yst_Bapi_Contact_PersonType agentRow = itAgent.next();
			Agent agent = new Agent();
			agent.setAgentNo(agentRow.getPerson_No());
			agent.setFirstName(agentRow.getFirst_Name());
			agent.setLastName(agentRow.getLast_Name());
			agent.setFullName(agent.getFirstName() + " " + agent.getLastName());
			agent.setEmailId(agentRow.getEmail());
			agent.setRoyaltyNo(agentRow.getRoyalty_No());
			agents.add(agent);
		}
		agency.setAgents(agents);
		// Prepare & set accepted payment methods
		if (bapiOutput.get_as_listIt_Paymentmethods() != null
				&& bapiOutput.get_as_listIt_Paymentmethods().size() > 0) {
			Iterator<Yst_Bapi_PaymentmethodsType> itPaymentMethods = bapiOutput
					.get_as_listIt_Paymentmethods().iterator();
			ArrayList<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();

			while (itPaymentMethods.hasNext()) {
				Yst_Bapi_PaymentmethodsType paymentMethodRow = itPaymentMethods
						.next();
				PaymentMethod paymentMethod = new PaymentMethod();
				paymentMethod.setMethod(paymentMethodRow.getMethod().charAt(0));
				paymentMethod.setDescription(paymentMethodRow.getDescription());
				paymentMethods.add(paymentMethod);
			}
			agency.setPaymentMethods(paymentMethods);
		}
		// Prepare & set accepted credit cards
		if (bapiOutput.get_as_listIt_Accepted_Cards() != null
				&& bapiOutput.get_as_listIt_Accepted_Cards().size() > 0) {
			Iterator<Yst_Bapi_CreditcardsType> itAcceptedCards = bapiOutput
					.get_as_listIt_Accepted_Cards().iterator();
			ArrayList<CreditCard> creditCards = new ArrayList<CreditCard>();

			while (itAcceptedCards.hasNext()) {
				Yst_Bapi_CreditcardsType acceptedCardRow = itAcceptedCards
						.next();
				CreditCard creditCard = new CreditCard();
				creditCard.setCardType(acceptedCardRow.getCard_Type());
				creditCard.setName(acceptedCardRow.getName());
				creditCards.add(creditCard);
			}
			agency.setCreditCards(creditCards);
		}
		agencyResponse.setAgency(agency);

		return agencyResponse;
	}
}