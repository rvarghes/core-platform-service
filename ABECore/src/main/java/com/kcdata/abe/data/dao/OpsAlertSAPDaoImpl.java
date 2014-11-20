/*
 * OpsAlertSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 8, 2009  dmahanth
 * Nov 3, 2009	hguntupa	  Refactored and added a new method to retrieve OpsAlert
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.text.SimpleDateFormat;

import com.kcdata.abe.bapi.Y_Bapi_Create_Ops_Alert_Input;
import com.kcdata.abe.bapi.Y_Bapi_Create_Ops_Alert_Output;
import com.kcdata.abe.bapi.Z_Api_Ops_Alert_Display_Input;
import com.kcdata.abe.bapi.Z_Api_Ops_Alert_Display_Output;
import com.kcdata.abe.bapi.Zalert_HdType;
import com.kcdata.abe.bapi.Zalert_ItType;
import com.kcdata.abe.bapi.Zapi_OpsinfoType;
import com.kcdata.abe.bapi.Zapi_ZpaxrecapType;
import com.kcdata.abe.bapi.util.Zalert_ItType_List;
import com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List;
import com.kcdata.abe.business.response.OpsAlertResponse;
import com.kcdata.abe.data.dto.Address;
import com.kcdata.abe.data.dto.BookingHeader;
import com.kcdata.abe.data.dto.Carrier;
import com.kcdata.abe.data.dto.FlightTransferInfo;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.OpsAlert;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;

/**
 * Create Ops Alert DAO implementation class
 * 
 * @author dmahanth
 * @version
 * 
 * @see
 * @since
 */
public class OpsAlertSAPDaoImpl extends ABESAPDaoBase implements OpsAlertDao {

	/**
	 * Method to create ops alert for the booking
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public OpsAlertResponse createOpsAlert(OpsAlert opsAlert) {

		OpsAlertResponse opsAlertResponse = new OpsAlertResponse();

		// Create Input for BAPI
		Y_Bapi_Create_Ops_Alert_Input bapiInput = new Y_Bapi_Create_Ops_Alert_Input();

		setOpsInfoType(bapiInput, opsAlert);
		setAlertHeaderType(bapiInput, opsAlert);
		setAlertItemType(bapiInput, opsAlert);
		setPaxInfo(bapiInput, opsAlert);

		// Execute the BAPI
		Y_Bapi_Create_Ops_Alert_Output bapiOutput = (Y_Bapi_Create_Ops_Alert_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Bapi_Create_Ops_Alert", bapiInput);
		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.getEx_It_Return(),
				opsAlertResponse);

		return opsAlertResponse;
	}

	/**
	 * Method to retrieve OpsAlert based on ID
	 * 
	 * @param opsAlert
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public OpsAlertResponse retrieveOpsAlert(String alertCode) {
		OpsAlertResponse opsAlertResponse = new OpsAlertResponse();

		// Create Input for BAPI
		Z_Api_Ops_Alert_Display_Input bapiInput = new Z_Api_Ops_Alert_Display_Input();

		// Set the Alert Code
		bapiInput.setZalert_Id(alertCode);

		// Execute the BAPI
		Z_Api_Ops_Alert_Display_Output bapiOutput = (Z_Api_Ops_Alert_Display_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Z_Api_Ops_Alert_Display", bapiInput);

		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.getReturn(), opsAlertResponse);

		// Process output
		opsAlertResponse.setOpsAlert(this
				.processRetrieveOpsAlertResponse(bapiOutput));

		return opsAlertResponse;
	}

	/**
	 * Method to set ops Info Type for the BAPI input
	 * 
	 * @param Y_Bapi_Create_Ops_Alert_Input
	 *            bapiInput, OpsAlert opsAlert
	 * @return void
	 * 
	 * @see
	 * @since
	 */
	private void setOpsInfoType(Y_Bapi_Create_Ops_Alert_Input bapiInput,
			OpsAlert opsAlert) {

		// Creating OpsInfo Type for BAPI Input
		Zapi_OpsinfoType opsInfoType = new Zapi_OpsinfoType();
		if(opsAlert.getAlertCode() != null)
		{
			opsInfoType.setAlertcode(opsAlert.getAlertCode().toUpperCase());
		}
		if (opsAlert.getActionCode() != null) 
		{
			opsInfoType.setActioncode(opsAlert.getActionCode().toUpperCase());
		}
		opsInfoType
				.setBookingnumber(opsAlert.getBookingHeader().getBookingNo());
		if(opsAlert.getBookingHeader().getTourId() != null)
		{
		opsInfoType.setTourid(opsAlert.getBookingHeader().getTourId().toUpperCase());
		}
		opsInfoType.setTraveldate(new java.sql.Date(opsAlert.getBookingHeader()
				.getDepartureDate().getTime()));
		if(opsAlert.getImApplicationInfo().getCreatedBy() != null)
		{
		opsInfoType.setUname(opsAlert.getImApplicationInfo().getCreatedBy().toUpperCase());
		}
		if(opsAlert.getImApplicationInfo().getContextID() != null)
		{
		opsInfoType
				.setZzccenter(opsAlert.getImApplicationInfo().getContextID().toUpperCase());
		}
		if(opsAlert.getBookingHeader().getCallCenter() != null)
		{
		opsInfoType.setZzccenter(opsAlert.getBookingHeader().getCallCenter().toUpperCase());
		}
		bapiInput.setIm_St_General_Info(opsInfoType);
		bapiInput.setIm_St_General_Info(opsInfoType);
	}

	/**
	 * Method to set Alert Header Type for the BAPI input
	 * 
	 * @param Y_Bapi_Create_Ops_Alert_Input
	 *            bapiInput, OpsAlert opsAlert
	 * @return void
	 * 
	 * @see
	 * @since
	 */
	private void setAlertHeaderType(Y_Bapi_Create_Ops_Alert_Input bapiInput,
			OpsAlert opsAlert) {

		// Creating Alert Header Info Type for BAPI Input
		Zalert_HdType alertHeaderType = new Zalert_HdType();
		if(opsAlert.getImApplicationInfo().getContextID() != null)
		{
		alertHeaderType.setMandt(opsAlert.getImApplicationInfo().getContextID().toUpperCase());
		}
		alertHeaderType.setVbeln(opsAlert.getBookingHeader().getBookingNo());
		if(opsAlert.getAlertCode() != null)
		{
		alertHeaderType.setZzalert_Code(opsAlert.getAlertCode().toUpperCase());
		}
		if(opsAlert.getActionCode() != null)
		{
		alertHeaderType.setZzact_Code(opsAlert.getActionCode().toUpperCase());
		}
		if(opsAlert.getType() != null)
		{
		alertHeaderType.setZzal_Tp(opsAlert.getType().toUpperCase());
		}
		if(opsAlert.getBookingHeader().getTourId() != null)
		{
		alertHeaderType.setZztourid(opsAlert.getBookingHeader().getTourId().toUpperCase());
		}
		alertHeaderType.setZztravel_Dt(new java.sql.Date(opsAlert
				.getBookingHeader().getDepartureDate().getTime()));
		if(opsAlert.getInstructions() != null)
		{
		alertHeaderType.setZzcomments(opsAlert.getInstructions().toUpperCase());
		}
		if(opsAlert.getImApplicationInfo().getCreatedBy() != null)
		{
		alertHeaderType.setUname(opsAlert.getImApplicationInfo().getCreatedBy().toUpperCase());
		}
		if(opsAlert.getReprintDoc() != null)
		{
		alertHeaderType.setZzdocreprn(opsAlert.getReprintDoc().toUpperCase());
		}
		bapiInput.setIm_St_Alert_Hdr(alertHeaderType);
	}

	/**
	 * Method to set Alert Item Type for the BAPI input
	 * 
	 * @param Y_Bapi_Create_Ops_Alert_Input
	 *            bapiInput, OpsAlert opsAlert
	 * @return void
	 * 
	 * @see
	 * @since
	 */
	private void setAlertItemType(Y_Bapi_Create_Ops_Alert_Input bapiInput,
			OpsAlert opsAlert) {

		// Creating Alert Item Info Type for BAPI Input
		Zalert_ItType alertItemType = new Zalert_ItType();
		if (opsAlert.getInFlightInfo() != null
				&& opsAlert.getOutFlightInfo() != null) {

			if(opsAlert.getOutFlightInfo().getGateway() != null)
			{
			alertItemType
					.setZzgateway(opsAlert.getOutFlightInfo().getGateway().toUpperCase());
			}
			if(opsAlert.getOutFlightInfo().getDestination() != null)
			{	
			alertItemType.setZzdestn(opsAlert.getOutFlightInfo()
					.getDestination().toUpperCase());
			}
			if(opsAlert.getOutFlightInfo().getFlightNo() != null)
			{
			alertItemType.setZzflt_No(opsAlert.getOutFlightInfo().getFlightNo().toUpperCase());
			}
			if (opsAlert.getOutFlightInfo().getCarrier() != null) {
				alertItemType.setZzal_Code(opsAlert.getOutFlightInfo()
						.getCarrier().getCarrierCode().toUpperCase());
			}
			if (opsAlert.getOutFlightInfo().getArrivalDate() != null) {
				alertItemType.setZzarr_Date(new java.sql.Date(opsAlert
						.getOutFlightInfo().getArrivalDate().getTime()));
				alertItemType.setZzarr_Time(new java.sql.Time(opsAlert
						.getOutFlightInfo().getArrivalDate().getTime()));
			}

			if(opsAlert.getInFlightInfo().getGateway() != null)
			{
			alertItemType.setZzgateway_2(opsAlert.getInFlightInfo()
					.getGateway().toUpperCase());
			}
			if(opsAlert.getInFlightInfo().getDestination() != null)
			{
			alertItemType.setZzdestn_2(opsAlert.getInFlightInfo()
					.getDestination().toUpperCase());
			}
			if(opsAlert.getInFlightInfo().getFlightNo() != null)
			{
			alertItemType.setZzflt_No_2(opsAlert.getInFlightInfo()
					.getFlightNo().toUpperCase());
			}
			if (opsAlert.getInFlightInfo().getCarrier() != null) {
				alertItemType.setZzal_Code_2(opsAlert.getInFlightInfo()
						.getCarrier().getCarrierCode().toUpperCase());
			}
			if (opsAlert.getInFlightInfo().getDepartureDate() != null) {
				alertItemType.setZzarr_Date2(new java.sql.Date(opsAlert
						.getInFlightInfo().getDepartureDate().getTime()));
				alertItemType.setZzarr_Time_2(new java.sql.Time(opsAlert
						.getInFlightInfo().getDepartureDate().getTime()));
			}
		}
		if(opsAlert.getTravelAgencyAccountNo() != null)
		{
		alertItemType.setZzta_Acnt(opsAlert.getTravelAgencyAccountNo().toUpperCase());
		}
		if(opsAlert.getService() != null)
		{
		alertItemType.setZzdservice(opsAlert.getService().toUpperCase());
		}
		if(opsAlert.getHotelName() != null)
		{
		alertItemType.setZzhotel(opsAlert.getHotelName().toUpperCase());
		}
		alertItemType.setZzloctel(opsAlert.getLocaltelephNo());
		if(opsAlert.getUserName() != null)
		{
		alertItemType.setZznames(opsAlert.getUserName().toUpperCase());
		}
		if (opsAlert.getDocumentAddress() != null) {
			alertItemType.setZzstaddress(opsAlert.getDocumentAddress()
					.getStreetAddress().toUpperCase());
			if(opsAlert.getDocumentAddress().getCity() != null)
			{
			alertItemType.setZzcity(opsAlert.getDocumentAddress().getCity().toUpperCase());
			}
			if(opsAlert.getDocumentAddress().getState() != null)
			{
			alertItemType.setZzstate(opsAlert.getDocumentAddress().getState().toUpperCase());
			}
			if(opsAlert.getDocumentAddress().getZipCode() != null)
			{
			alertItemType.setZzzip_Code(opsAlert.getDocumentAddress()
					.getZipCode().toUpperCase());
			}
		}
		if(opsAlert.getInstructions() != null)
		{
		alertItemType.setZzcomments(opsAlert.getInstructions().toUpperCase());
		}
		if(opsAlert.getImApplicationInfo().getAgentNumber() != null)
		{
		alertItemType.setZzta_Acnt(opsAlert.getImApplicationInfo()
				.getAgentNumber().toUpperCase());
		}
		bapiInput.setIm_St_Alert_Itm(alertItemType);
	}

	/**
	 * Method to set PAX Info for the BAPI input
	 * 
	 * @param Y_Bapi_Create_Ops_Alert_Input
	 *            bapiInput, OpsAlert opsAlert
	 * @return void
	 * 
	 * @see
	 * @since
	 */
	private void setPaxInfo(Y_Bapi_Create_Ops_Alert_Input bapiInput,
			OpsAlert opsAlert) {

		// Creating PAX Info for BAPI Input
		Zapi_ZpaxrecapType_List paxTypeList = new Zapi_ZpaxrecapType_List();
		Zapi_ZpaxrecapType paxType = null;
		GuestInfo guestInfo = null;

		if (opsAlert.getGuests() != null) {
			for (int guestCount = 0; guestCount < opsAlert.getGuests().size(); guestCount++) {
				paxType = new Zapi_ZpaxrecapType();
				guestInfo = opsAlert.getGuests().get(guestCount);

				paxType.setCheck_Sel("X");
				paxType.setZzpax_Id(guestInfo.getGuestId());
				if(guestInfo.getTitle() != null)
					paxType.setZztitle(guestInfo.getTitle().toUpperCase());
				if(guestInfo.getLastName() != null)
					paxType.setZzname_Lst(guestInfo.getLastName().toUpperCase());
				if(guestInfo.getFirstName() != null)
					paxType.setZzname_Fst(guestInfo.getFirstName().toUpperCase());
				paxType.setZzagep(guestInfo.getAge() + "");
				paxType.setZztype(guestInfo.getAgeCode().getAgeCode() + "");
				if(guestInfo.getFrequentFlyerNo() != null)
				{
				paxType.setZzfreqfly(guestInfo.getFrequentFlyerNo().toUpperCase());
				}
				if(guestInfo.getParentGuestId() != null)
				{
				paxType.setZzparentid(guestInfo.getParentGuestId().toUpperCase());
				}
				if(guestInfo.getSeatPreference() != null)
				{
				paxType.setZzskdstprf(guestInfo.getSeatPreference().toUpperCase());
				}
				paxType.setZzpaxphn(guestInfo.getPhoneNumber());
				paxTypeList.add(paxType);
			}
		}
		bapiInput.setIt_Pax_Assign(paxTypeList);
	}

	/**
	 * Method to parse the retrieve OpsAlert response
	 * 
	 * @param bapiOutput
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private OpsAlert processRetrieveOpsAlertResponse(
			Z_Api_Ops_Alert_Display_Output bapiOutput) {
		if (bapiOutput.getZalerthd() == null
				&& bapiOutput.get_as_listZalertit() == null) {
			return null;
		}
		OpsAlert opsAlert = new OpsAlert();
		Zalert_HdType alertHeaderType = bapiOutput.getZalerthd();
		opsAlert.setAlertCode(alertHeaderType.getZzalert_Id());
		BookingHeader bookingHeader = new BookingHeader();
		bookingHeader.setBookingNo(alertHeaderType.getVbeln());
		bookingHeader.setTourId(alertHeaderType.getZztourid());
		if (alertHeaderType.getBudat() != null) {
			bookingHeader.setBookingDate(alertHeaderType.getBudat());
		}
		if (alertHeaderType.getZztravel_Dt() != null) {
			bookingHeader.setTravelDate(alertHeaderType.getZztravel_Dt());
		}
		opsAlert.setBookingHeader(bookingHeader);
		//CQ8615 - setting correct alert code
		opsAlert.setAlertCode(alertHeaderType.getZzalert_Code());
		opsAlert.setActionCode(alertHeaderType.getZzact_Code());
		opsAlert.setType(alertHeaderType.getZzal_Tp());
		opsAlert.setUserName(alertHeaderType.getUname());

		Zalert_ItType_List alertTypeList = bapiOutput.get_as_listZalertit();
		if (alertTypeList != null && alertTypeList.size() > 0) {
			Zalert_ItType alertType = alertTypeList.getZalert_ItType(0);
			String hotelName = alertType.getZzhotel_New();
			//CQ8615 - setting correct hotel name
			if (hotelName == null || "".equals(hotelName)) {
				hotelName = alertType.getZzhotel_Old();
			}
			opsAlert.setHotelName(hotelName);
			//End
			opsAlert.setLocaltelephNo(alertType.getZzloctel());

			SimpleDateFormat sdfDateTime = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");

			FlightTransferInfo inFlightTransferInfo = new FlightTransferInfo();
			inFlightTransferInfo.setGateway(alertType.getZzgateway_2());
			inFlightTransferInfo.setDestination(alertType.getZzdestn_2());
			inFlightTransferInfo.setFlightNo(alertType.getZzflt_No_2());
			Carrier carrier = new Carrier();
			carrier.setCarrierCode(alertType.getZzal_Code_2());
			inFlightTransferInfo.setCarrier(carrier);

			FlightTransferInfo outFlightTransferInfo = new FlightTransferInfo();
			outFlightTransferInfo.setGateway(alertType.getZzgateway());
			outFlightTransferInfo.setDestination(alertType.getZzdestn());
			outFlightTransferInfo.setFlightNo(alertType.getZzflt_No());
			carrier = new Carrier();
			carrier.setCarrierCode(alertType.getZzal_Code());
			outFlightTransferInfo.setCarrier(carrier);

			try {
				if (alertType.getZzarr_Date2() != null
						&& alertType.getZzarr_Time_2() != null) {
					inFlightTransferInfo.setArrivalDate(sdfDateTime
							.parse(alertType.getZzarr_Date2() + " "
									+ alertType.getZzarr_Time_2()));
				}
				if (alertType.getZzarr_Date() != null
						&& alertType.getZzarr_Time() != null) {
					outFlightTransferInfo.setArrivalDate(sdfDateTime
							.parse(alertType.getZzarr_Date() + " "
									+ alertType.getZzarr_Time()));
				}
			} catch (java.text.ParseException ex) {
			}
			opsAlert.setInFlightInfo(inFlightTransferInfo);
			opsAlert.setOutFlightInfo(outFlightTransferInfo);
			opsAlert.setService(alertType.getZzdservice());
			opsAlert.setUserName(alertType.getZznames());
			opsAlert.setTravelAgencyAccountNo(alertType.getZzta_Acnt());
			Address address = new Address();
			address.setStreetAddress(alertType.getZzstaddress());
			address.setCity(alertType.getZzcity());
			address.setState(alertType.getZzstate());
			address.setZipCode(alertType.getZzzip_Code());
			opsAlert.setDocumentAddress(address);
			opsAlert.setInstructions(alertType.getZzcomments());
		}
		return opsAlert;
	}

}
