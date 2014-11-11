/*
 * BreakdownChargesSAPDaoImpl.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 2, 2010  chazari
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.kcdata.abe.bapi.Y_Bapi_Pri_Breakdown_Input;
import com.kcdata.abe.bapi.Y_Bapi_Pri_Breakdown_Output;
import com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType;
import com.kcdata.abe.bapi.Zapi_Commission_DtlsType;
import com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType;
import com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List;
import com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List;
import com.kcdata.abe.business.response.BreakdownChargesResponse;
import com.kcdata.abe.data.dto.BreakdownChargesHeader;
import com.kcdata.abe.data.dto.GuestBreakdownCharge;
import com.kcdata.abe.data.dto.GuestBreakdownCommissionCharge;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.framework.context.ABEApplicationContext;
import com.kcdata.abe.framework.context.ABERequestContext;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;

public class BreakdownChargesSAPDaoImpl extends ABESAPDaoBase implements
		BreakdownChargesDao {

	/**
	 * Method retrieves price breakdown details from R/3 for a specified booking
	 * 
	 * @param bookingNo
	 * @return
	 * @see
	 * @since
	 */
	public BreakdownChargesResponse retrievePriceBreakdown(String bookingNo) {
		BreakdownChargesResponse breakdownChargesResponse = new BreakdownChargesResponse();

		if (bookingNo == null || bookingNo.trim().equals("")) {
			// Invalid booking number, return to presentation with error
			// message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_BOOKING_NUMBER");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_BOOKING_NUMBER", null, null));
			breakdownChargesResponse.saveBusinessError(businessError);
			return breakdownChargesResponse;
		}

		// Prepare BAPI input
		Y_Bapi_Pri_Breakdown_Input bapiInput = new Y_Bapi_Pri_Breakdown_Input();

		bapiInput.setBookingnumber(bookingNo);
		
		// Prepare & set application info object to input
		bapiInput.setIm_St_Appli_Info(prepareIMApplicationInfo());
		
		// Execute booking search BAPI
		Y_Bapi_Pri_Breakdown_Output bapiOutput = (Y_Bapi_Pri_Breakdown_Output) this
				.getBapiExecutionManager().executeBAPI("Y_Bapi_Pri_Breakdown",
						bapiInput);

		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.getReturn(),
				breakdownChargesResponse);

		// Check for any business errors from BAPI
		if (breakdownChargesResponse.isBusinessErrorOccurred()) {
			return breakdownChargesResponse;
		}
		// Process break down charges
		breakdownChargesResponse.setBreakdownChargesHeader(this
				.processBreakdownChargesHeader(bapiOutput));
		breakdownChargesResponse.setBreakdownCharges(this
				.processGuestBreakdownCharges(bapiOutput
						.get_as_listDetailprices()));
		breakdownChargesResponse.setCommissionCharges(this
				.processGuestBreakdownCommissionCharge(bapiOutput
						.get_as_listCommissiondtls()));

		return breakdownChargesResponse;
	}

	/**
	 * Method prepares breakdown charges header
	 * 
	 * @param bapiOutput
	 * @return BreakdownChargesHeader
	 */
	private BreakdownChargesHeader processBreakdownChargesHeader(
			Y_Bapi_Pri_Breakdown_Output bapiOutput) {
		BreakdownChargesHeader breakdownChargesHeader = new BreakdownChargesHeader();

		breakdownChargesHeader
				.setCustomerNumber(bapiOutput.getCustomernumber());
		breakdownChargesHeader.setFirstName(bapiOutput.getCustomername());
		breakdownChargesHeader.setLastName(bapiOutput.getCustomername2());
		breakdownChargesHeader.setAddress(bapiOutput.getHousenumberstreet());
		breakdownChargesHeader.setCity(bapiOutput.getCity());
		breakdownChargesHeader.setState(bapiOutput.getRegionstate());
		breakdownChargesHeader.setPostalCode(bapiOutput.getPostalcode());
		if (bapiOutput.getDepositdue() != null)
			breakdownChargesHeader.setDepositDue(bapiOutput.getDepositdue()
					.doubleValue());
		breakdownChargesHeader.setDepartureDate(bapiOutput.getDeparturedate());
		breakdownChargesHeader.setDuration(Integer.parseInt(bapiOutput
				.getDuration()));
		return breakdownChargesHeader;
	}

	@SuppressWarnings("unchecked")
	private List<GuestBreakdownCommissionCharge> processGuestBreakdownCommissionCharge(
			Zapi_Commission_DtlsType_List commissionDetailsList) {
		List<GuestBreakdownCommissionCharge> commissionBreakdownCharges = new ArrayList<GuestBreakdownCommissionCharge>();
		Iterator<Zapi_Commission_DtlsType> itcommissionDetailType = commissionDetailsList
				.iterator();
		while (itcommissionDetailType.hasNext()) {
			Zapi_Commission_DtlsType commissionDetailRow = itcommissionDetailType
					.next();
			GuestBreakdownCommissionCharge guestBreakdownCommissionCharge = new GuestBreakdownCommissionCharge();
			guestBreakdownCommissionCharge
					.setCommissionableAmount(commissionDetailRow
							.getCommissionableamount().doubleValue());
			guestBreakdownCommissionCharge
					.setCommissionAmount(commissionDetailRow
							.getCommissionamount().doubleValue());
			guestBreakdownCommissionCharge
					.setCommissionPercent(commissionDetailRow
							.getCommissionpercent());
			guestBreakdownCommissionCharge.setMaterialGroup(commissionDetailRow
					.getMatkl());
			guestBreakdownCommissionCharge
					.setMaterialGroupDescription(commissionDetailRow
							.getMaterial_Grp_Des());
			commissionBreakdownCharges.add(guestBreakdownCommissionCharge);
		}
		return commissionBreakdownCharges;
	}

	@SuppressWarnings("unchecked")
	private List<GuestBreakdownCharge> processGuestBreakdownCharges(
			Zapi_Pax_Info_DetailType_List detailedPriceList) {
		List<GuestBreakdownCharge> guestBreakdownCharges = new ArrayList<GuestBreakdownCharge>();
		Iterator<Zapi_Pax_Info_DetailType> itPaxInfoDetailType = detailedPriceList
				.iterator();
		while (itPaxInfoDetailType.hasNext()) {
			Zapi_Pax_Info_DetailType paxDetailRow = itPaxInfoDetailType.next();
			GuestBreakdownCharge guestBreakdownCharge = new GuestBreakdownCharge();
			guestBreakdownCharge.setChargeDescription(paxDetailRow
					.getChargedescription());
			guestBreakdownCharge.setFirstName(paxDetailRow.getFirstname());
			guestBreakdownCharge.setLastName(paxDetailRow.getLastname());
			guestBreakdownCharge.setItemPrice(paxDetailRow.getItemprice()
					.doubleValue());
			guestBreakdownCharge.setNetPrice(paxDetailRow.getNetprice()
					.doubleValue());
			guestBreakdownCharge.setPaxId(paxDetailRow.getPassengerid());
			guestBreakdownCharges.add(guestBreakdownCharge);
		}
		return guestBreakdownCharges;
	}
	
	/**
	 * This method prepares Application Info Type object for BAPI based on IM
	 * Application Info object
	 * 
	 * @param imApplicationInfo
	 * @return Yst_Bapi_Appli_InfoType SAP application info type object
	 * 
	 * @see
	 * @since
	 */
	protected Yst_Bapi_Appli_InfoType prepareIMApplicationInfo() {
		Yst_Bapi_Appli_InfoType applicationInfo = new Yst_Bapi_Appli_InfoType();
		ABEApplicationContext context = this.getApplicationContextFactory()
				.getApplicationContext();
		ABERequestContext requestContext = context.getRequestContext();

		IMApplicationInfo imApplicationInfo = requestContext
				.getIMApplicationInfo();
		if (imApplicationInfo != null) {
			if (imApplicationInfo.getAgentNumber() != null)
				applicationInfo
						.setAgentsine(imApplicationInfo.getAgentNumber());
			if (imApplicationInfo.getContextID() != null)
				applicationInfo.setId_Context(imApplicationInfo.getContextID());
			if (imApplicationInfo.getRequestorID() != null)
				applicationInfo.setRequestorid(imApplicationInfo
						.getRequestorID());
			if (imApplicationInfo.getType() != null) {
				applicationInfo.setType(imApplicationInfo.getType().getCode());
			}
			if (imApplicationInfo.getCreatedBy() != null)
				applicationInfo.setCreatedby(imApplicationInfo.getCreatedBy());
			if (imApplicationInfo.getIsoCountry() != null)
				applicationInfo
						.setIsocountry(imApplicationInfo.getIsoCountry());
			if (imApplicationInfo.getIsoCurrency() != null)
				applicationInfo.setIsocurrency(imApplicationInfo
						.getIsoCurrency());
			if (imApplicationInfo.getPseudoCityCode() != null)
				applicationInfo.setPseudocitycode(imApplicationInfo
						.getPseudoCityCode());
			if (imApplicationInfo.getSalesOrg() != null) {
				applicationInfo.setSales_Org(imApplicationInfo.getSalesOrg());
			}
			if (imApplicationInfo.getAgentFirstName() != null) {
				applicationInfo.setAgentfname(imApplicationInfo
						.getAgentFirstName());
			}
			if (imApplicationInfo.getAgentLastName() != null) {
				applicationInfo.setAgentlname(imApplicationInfo
						.getAgentLastName());
			}
		}
		return applicationInfo;
	}

}
