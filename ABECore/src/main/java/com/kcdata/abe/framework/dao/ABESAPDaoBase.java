/*
 * ABESAPDaoBase.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 26, 2009  hguntupa
 * Jun 17, 2009  nvittal	  Added processWarningsErrors method
 * Sep 24, 2009	 hguntupa	  Changed the scope for the methods
 ******************************************************************************
 */

package com.kcdata.abe.framework.dao;

import java.math.BigInteger;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import kcdebdmnlib_hva.CancelPolicy;

import com.kcdata.abe.bapi.Bapiret2Type;
import com.kcdata.abe.bapi.BapireturnType;
import com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType;
import com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType;
import com.kcdata.abe.bapi.util.Bapiret2Type_List;
import com.kcdata.abe.bapi.util.BapireturnType_List;
import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.request.PackagesRequest;
import com.kcdata.abe.business.request.VehiclesRequest;
import com.kcdata.abe.business.response.ItineraryPricingResponse;
import com.kcdata.abe.business.response.PackagesResponse;
import com.kcdata.abe.data.dto.ActionType;
import com.kcdata.abe.data.dto.Address;
import com.kcdata.abe.data.dto.AgeCode;
import com.kcdata.abe.data.dto.Agency;
import com.kcdata.abe.data.dto.Agent;
import com.kcdata.abe.data.dto.AirOptions;
import com.kcdata.abe.data.dto.Alert;
import com.kcdata.abe.data.dto.AlertType;
import com.kcdata.abe.data.dto.Amenity;
import com.kcdata.abe.data.dto.BookingHeader;
import com.kcdata.abe.data.dto.BookingLockDetails;
import com.kcdata.abe.data.dto.BookingStatus;
import com.kcdata.abe.data.dto.CabinType;
import com.kcdata.abe.data.dto.Carrier;
import com.kcdata.abe.data.dto.CreditCard;
import com.kcdata.abe.data.dto.Destination;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.DestinationService;
import com.kcdata.abe.data.dto.FlightTransferInfo;
import com.kcdata.abe.data.dto.FlightTripType;
import com.kcdata.abe.data.dto.GuaranteedCheck;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.GuestPriceBreakup;
import com.kcdata.abe.data.dto.HBSiRates;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.HotelOptions;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Insurance;
import com.kcdata.abe.data.dto.InsuranceGuestAllocation;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.ItineraryCancellationRules;
import com.kcdata.abe.data.dto.ItineraryCharge;
import com.kcdata.abe.data.dto.ItineraryPrice;
import com.kcdata.abe.data.dto.MealPlanType;
import com.kcdata.abe.data.dto.MoneyTransfer;
import com.kcdata.abe.data.dto.MultiDestinationPackage;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.OpsAlert;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.PassportInfo;
import com.kcdata.abe.data.dto.PaxTypeBasePrices;
import com.kcdata.abe.data.dto.PaxTypePriceBreakup;
import com.kcdata.abe.data.dto.PaymentHistoryInfo;
import com.kcdata.abe.data.dto.PaymentInformation;
import com.kcdata.abe.data.dto.PaymentMethod;
import com.kcdata.abe.data.dto.RFARequest;
import com.kcdata.abe.data.dto.RequestedDatesForAvailability;
import com.kcdata.abe.data.dto.ResortArea;
import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.RoomPrice;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.Service;
import com.kcdata.abe.data.dto.SpecialOptions;
import com.kcdata.abe.data.dto.SpecialRequestType;
import com.kcdata.abe.data.dto.SpecialType;
import com.kcdata.abe.data.dto.TimeOfDay;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.UserType;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.data.dto.VehicleOptions;
import com.kcdata.abe.data.dto.Vendor;
import com.kcdata.abe.data.dto.VendorService;
import com.kcdata.abe.framework.context.ABEApplicationContext;
import com.kcdata.abe.framework.context.ABERequestContext;
import com.kcdata.abe.framework.dto.ABEDto;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABEInfoMessage;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.framework.errorhandling.exception.ABEWarning;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.request.ABERequest;
import com.kcdata.abe.framework.response.ABEResponse;
import com.kcdata.abe.framework.sap.BAPIExecutionManager;
import com.kcdata.abe.framework.util.ABEConstants;
import com.kcdata.abe.framework.util.XMLGregorianCalendarConversionUtil;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.allpricebreakup.v1.AllPricesBreakUp;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.deletedlist.v1.DeletedList;

//import flex.messaging.io.amf.ASObject;
//import flex.messaging.io.amf.translator.ASTranslator;

/**
 * Base class for the SAP interaction DAO's N/A for any usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ABESAPDaoBase extends ABEDaoBase implements ABEConstants {

	private ABELogger abeLogger = ABELogger.getLogger(ABESAPDaoBase.class);

	/**
	 * Execution Manager for the BAPI
	 */
	private BAPIExecutionManager bapiExecutionManager;

	/**
	 * @return the bapiExecutionManager
	 */
	public BAPIExecutionManager getBapiExecutionManager() {
		return bapiExecutionManager;
	}

	/**
	 * @param bapiExecutionManager
	 *            the bapiExecutionManager to set
	 */
	public void setBapiExecutionManager(
			BAPIExecutionManager bapiExecutionManager) {
		this.bapiExecutionManager = bapiExecutionManager;
	}

	/**
	 * Method to handle BAPI Return2 list
	 * 
	 * Call this method to process BAPI return table for any
	 * warning/info/error/abort return type messages and act accordingly.
	 * 
	 * @param bapiReturn2Table
	 * @param abeResponse
	 * 
	 * @see
	 * @since
	 */
	protected void processWarningsErrors(Bapiret2Type_List bapiReturn2Table,
			ABEResponse abeResponse) {
		this.processWarningsErrors(bapiReturn2Table, abeResponse, false);
	}

	/**
	 * Method to handle BAPI Return2 list
	 * 
	 * Call this method to process BAPI return table for any
	 * warning/info/error/abort return type messages and act accordingly.
	 * 
	 * @param bapiReturn2Table
	 * @param abeResponse
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	protected void processWarningsErrors(Bapiret2Type_List bapiReturn2Table,
			ABEResponse abeResponse, boolean saveSystemErrors) {
		if (bapiReturn2Table == null || abeResponse == null)
			return;

		String debugMessage = this.retrieveDebugMessage(bapiReturn2Table);
		// Parse BAPI return table for respective return responses
		Iterator<Bapiret2Type> itReturn = bapiReturn2Table.iterator();
		while (itReturn.hasNext()) {
			Bapiret2Type bapiReturn2 = itReturn.next();
			processWarningsErrors(bapiReturn2, abeResponse, debugMessage,
					saveSystemErrors);
		}
		if (debugMessage != null && !"".equals(debugMessage)) {
			abeLogger.debug(debugMessage);
		}
	}

	/**
	 * Method to handle BAPI Return list
	 * 
	 * Call this method to process Z BAPI return table for any
	 * warning/info/error/abort return type messages and act accordingly.
	 * 
	 * @param bapiReturnTable
	 * @param abeResponse
	 * 
	 * @see
	 * @since
	 */
	protected void processWarningsErrors(BapireturnType_List bapiReturnTable,
			ABEResponse abeResponse) {
		this.processWarningsErrors(bapiReturnTable, abeResponse, false);
	}

	/**
	 * Method to handle BAPI Return list
	 * 
	 * Call this method to process Z BAPI return table for any
	 * warning/info/error/abort return type messages and act accordingly.
	 * 
	 * @param bapiReturnTable
	 * @param abeResponse
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	protected void processWarningsErrors(BapireturnType_List bapiReturnTable,
			ABEResponse abeResponse, boolean saveSystemError) {
		if (bapiReturnTable == null || abeResponse == null)
			return;

		String debugMessage = this.retrieveDebugMessage(bapiReturnTable);
		// Parse BAPI return table for respective return responses
		Iterator<BapireturnType> itReturn = bapiReturnTable.iterator();
		while (itReturn.hasNext()) {
			BapireturnType bapiReturn = itReturn.next();
			processWarningsErrors(bapiReturn, abeResponse, debugMessage,
					saveSystemError);
		}
		if (debugMessage != null && !"".equals(debugMessage)) {
			abeLogger.debug(debugMessage);
		}
	}

	/**
	 * Overloaded method to handle BAPI Return2 table
	 * 
	 * Call this method to process BAPI return table for any
	 * warning/info/error/abort return type messages and act accordingly.
	 * 
	 * Populates respective attributes in response object based on return type.
	 * In case, of irrecoverable error, a system error is thrown
	 * 
	 * @param bapiReturn2Table
	 * @param abeResponse
	 * 
	 * @see
	 * @since
	 */
	protected void processWarningsErrors(Bapiret2Type bapiReturn2,
			ABEResponse abeResponse) {
		this.processWarningsErrors(bapiReturn2, abeResponse, false);
	}
	
	/**
	 * Overloaded method to handle BAPI Return2 table
	 * 
	 * Call this method to process BAPI return table for any
	 * warning/info/error/abort return type messages and act accordingly.
	 * 
	 * Populates respective attributes in response object based on return type.
	 * In case, of irrecoverable error, a system error is thrown
	 * 
	 * @param bapiReturn2Table
	 * @param abeResponse
	 * 
	 * @see
	 * @since
	 */
	protected void processWarningsErrors(Bapiret2Type bapiReturn2,
			ABEResponse abeResponse, boolean saveSystemErrors) {
		processWarningsErrors(bapiReturn2, abeResponse, null, saveSystemErrors);
	}

	/**
	 * Overloaded method to handle BAPI Return2 table
	 * 
	 * Call this method to process BAPI return table for any
	 * warning/info/error/abort return type messages and act accordingly.
	 * 
	 * Populates respective attributes in response object based on return type.
	 * In case, of irrecoverable error, a system error is thrown
	 * 
	 * @param bapiReturn2Table
	 * @param abeResponse
	 * 
	 * @see
	 * @since
	 */
	protected void processWarningsErrors(Bapiret2Type bapiReturn2,
			ABEResponse abeResponse, String debugMessage,
			boolean saveSystemError) {
		if (bapiReturn2 == null || abeResponse == null)
			return;

		if (BAPI_RETURN_TYPE_WARNING.equalsIgnoreCase(bapiReturn2.getType())) {
			// Prepare warning list
			ABEWarning warning = new ABEWarning();
			warning.setErrorCode(bapiReturn2.getNumber());
			warning.setErrorDescription(bapiReturn2.getMessage());
			abeResponse.saveWarning(warning);
		} else if (BAPI_RETURN_TYPE_INFO
				.equalsIgnoreCase(bapiReturn2.getType())) {
			// Prepare info message list
			ABEInfoMessage infoMessage = new ABEInfoMessage();
			infoMessage.setErrorCode(bapiReturn2.getNumber());
			infoMessage.setErrorDescription(bapiReturn2.getMessage());
			abeResponse.saveInfoMessage(infoMessage);
		} else if (BAPI_RETURN_TYPE_ERROR.equalsIgnoreCase(bapiReturn2
				.getType())) {
			// Prepare error list
			ABEBusinessError error = new ABEBusinessError();
			error.setErrorCode(bapiReturn2.getNumber());
			if(bapiReturn2.getNumber().equals("030")){
				// modified for mantis id 72 for ticket no 3548205
				error.setErrorDescription(this.getMessageSource().getMessage("HOTELS_NOT_AVAILABLE_SEARCH_CRITERIA", null, null));
			}else{
				error.setErrorDescription(bapiReturn2.getMessage());
			}	
			abeResponse.saveBusinessError(error);
		} else if (BAPI_RETURN_TYPE_ABORT.equalsIgnoreCase(bapiReturn2
				.getType())) {
			// Throw in case of irrecoverable error
			ABESystemError systemError = new ABESystemError(bapiReturn2
					.getNumber(), bapiReturn2.getMessage(), debugMessage);
			if (saveSystemError) {
				abeResponse.saveSystemError(systemError);
			} else {
				throw new ABESystemException(systemError, ABETier.ABAP,
						bapiReturn2.getMessage());
			}
		}
	}

	/**
	 * Overloaded method to handle Z_BAPI Return table.
	 * 
	 * Call this method to process BAPI return table for any
	 * warning/info/error/abort return type messages and act accordingly.
	 * 
	 * Populates respective attributes in response object based on return type.
	 * In case, of irrecoverable error, a system error is thrown
	 * 
	 * @param abeResponse
	 * 
	 * @see
	 * @since
	 */
	protected void processWarningsErrors(BapireturnType bapiReturn,
			ABEResponse abeResponse) {
		this.processWarningsErrors(bapiReturn, abeResponse, false);
	}
	
	/**
	 * Overloaded method to handle Z_BAPI Return table.
	 * 
	 * Call this method to process BAPI return table for any
	 * warning/info/error/abort return type messages and act accordingly.
	 * 
	 * Populates respective attributes in response object based on return type.
	 * In case, of irrecoverable error, a system error is thrown
	 * 
	 * @param abeResponse
	 * 
	 * @see
	 * @since
	 */
	protected void processWarningsErrors(BapireturnType bapiReturn,
			ABEResponse abeResponse, boolean saveSystemError) {
		processWarningsErrors(bapiReturn, abeResponse, null, saveSystemError);
	}

	/**
	 * Overloaded method to handle Z_BAPI Return table.
	 * 
	 * Call this method to process BAPI return table for any
	 * warning/info/error/abort return type messages and act accordingly.
	 * 
	 * Populates respective attributes in response object based on return type.
	 * In case, of irrecoverable error, a system error is thrown
	 * 
	 * @param bapiReturnTable
	 * @param abeResponse
	 * 
	 * @see
	 * @since
	 */
	protected void processWarningsErrors(BapireturnType bapiReturn,
			ABEResponse abeResponse, String debugMessage,
			boolean saveSystemError) {
		if (bapiReturn == null || abeResponse == null)
			return;

		if (BAPI_RETURN_TYPE_WARNING.equalsIgnoreCase(bapiReturn.getType())) {
			// Prepare warning list
			ABEWarning warning = new ABEWarning();
			warning.setErrorCode(bapiReturn.getCode());
			warning.setErrorDescription(bapiReturn.getMessage());
			abeResponse.saveWarning(warning);
		} else if (BAPI_RETURN_TYPE_INFO.equalsIgnoreCase(bapiReturn.getType())) {
			// Prepare info message list
			ABEInfoMessage infoMessage = new ABEInfoMessage();
			infoMessage.setErrorCode(bapiReturn.getCode());
			infoMessage.setErrorDescription(bapiReturn.getMessage());
			abeResponse.saveInfoMessage(infoMessage);
		} else if (BAPI_RETURN_TYPE_ERROR
				.equalsIgnoreCase(bapiReturn.getType())) {
			// Prepare error list
			ABEBusinessError error = new ABEBusinessError();
			error.setErrorCode(bapiReturn.getCode());
			error.setErrorDescription(bapiReturn.getMessage());
			abeResponse.saveBusinessError(error);
		} else if (BAPI_RETURN_TYPE_ABORT
				.equalsIgnoreCase(bapiReturn.getType())) {
			// Throw in case of irrecoverable error
			ABESystemError systemError = new ABESystemError(bapiReturn
					.getCode(), bapiReturn.getMessage(), debugMessage);
			if (saveSystemError) {
				abeResponse.saveSystemError(systemError);
			} else {
				throw new ABESystemException(systemError, ABETier.ABAP,
						bapiReturn.getMessage());
			}
		}
	}

	/**
	 * Method to retrieve the debug message from BAPIRerurn table
	 * 
	 * @param bapiReturn2Table
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private String retrieveDebugMessage(Bapiret2Type_List bapiReturn2Table) {
		StringBuffer debugMessage = new StringBuffer();
		// Parse BAPI return table for respective return responses
		Iterator<Bapiret2Type> itReturn = bapiReturn2Table.iterator();
		while (itReturn.hasNext()) {
			Bapiret2Type bapiReturn2 = itReturn.next();
			if (BAPI_RETURN_TYPE_DEBUG.equalsIgnoreCase(bapiReturn2.getType())) {
				debugMessage.append(bapiReturn2.getNumber());
				debugMessage.append(":");
				debugMessage.append(bapiReturn2.getMessage());
			}
		}
		if (debugMessage.length() == 0) {
			return null;
		}
		return debugMessage.toString();
	}

	/**
	 * Method to retrieve the debug message from BAPIRerurn table
	 * 
	 * @param bapiReturn2Table
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private String retrieveDebugMessage(BapireturnType_List bapiReturnTable) {
		StringBuffer debugMessage = new StringBuffer();
		// Parse BAPI return table for respective return responses
		Iterator<Bapiret2Type> itReturn = bapiReturnTable.iterator();
		while (itReturn.hasNext()) {
			Bapiret2Type bapiReturn2 = itReturn.next();
			if (BAPI_RETURN_TYPE_DEBUG.equalsIgnoreCase(bapiReturn2.getType())) {
				debugMessage.append(bapiReturn2.getNumber());
				debugMessage.append(":");
				debugMessage.append(bapiReturn2.getMessage());
				debugMessage.append("  \n");
			}
		}
		if (debugMessage.length() == 0) {
			return null;
		}
		return debugMessage.toString();
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
	
	/**
	 * Method prepare Yst_Bapi_Appli_InfoType
	 * @param imApplicationInfo
	 * @return Yst_Bapi_Appli_InfoType
	 */
	protected Yst_Bapi_Appli_InfoType prepareLocalIMApplicationInfo(IMApplicationInfo imApplicationInfo) {
		Yst_Bapi_Appli_InfoType applicationInfo = new Yst_Bapi_Appli_InfoType();		
		
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

	/**
	 * Method to prepare the header for all the availability BAPI's
	 * 
	 * @param request
	 * @return
	 * 
	 * @see
	 * @since
	 */
	protected Yst_Bapi_Req_HdrType prepareHeader(ABERequest request) {
		Yst_Bapi_Req_HdrType header = new Yst_Bapi_Req_HdrType();
		if (request.isAirRequested()) {
			if (request.isMultiDestinationRequest()) {
				header.setFlights_Ind("2");
			} else {
				header.setFlights_Ind("1");
			}
		}
		if (request.isHotelRequested()) {
			header.setHotels_Ind("1");
		}
		if (request.isVehicleRequested()) {
			header.setVehicle_Ind("1");
		}
		if (request.getPromoCode() != null) {
			header.setPromo_Code(request.getPromoCode());
		}
		if (request.getBookingNo() != null
				&& !"".equals(request.getBookingNo())) {
			header.setBooking_Num(request.getBookingNo());
		}
		// Set show all flag, if passed
		if (request instanceof PackagesRequest) {
			PackagesRequest pRequest = (PackagesRequest) request;
			if (pRequest.getHotelsRequest() != null
					&& pRequest.getHotelsRequest().getHotelOptions() != null
					&& pRequest.getHotelsRequest().getHotelOptions()
							.isShowAll()) {
				header.setShow_All("X");
			}
		}

		return header;
	}
	/*******************************************************************************************************************
	 W E S B
	********************************************************************************************************************/
	
	
	
	public boolean isHBSi(String hotelMaterialCode)
	{
		if(hotelMaterialCode!=null && hotelMaterialCode!="")
			return true;
		
		return false;
	}
	
	/**
	 * 
	 * @param xmlDate
	 * @return
	 */
	public Date dateConverterXMLtoUtilBirthDate(XMLGregorianCalendar xmlDate) {

		Date date = new Date();
		Date lNextDate=null;
		if (xmlDate != null) {
			date = xmlDate.toGregorianCalendar().getTime();
			String pattern ="EEE, MMM d HH:mm:ss Z yyyy";
	
			 DateFormat lFormatter = new SimpleDateFormat("EEE, MMM d HH:mm:ss Z yyyy");
			 
			  try {
				lNextDate = (Date)lFormatter.parse(lFormatter.format(date));
				
			} catch (ParseException e) {
	
				
			}
		
		}
		return lNextDate;

	}
	
	
	/**
	 * Method to handle price break for HBSi hotel
	 * @param allPriceBreakUpBO
	 * @return allPriceBrekUp
	 */
	
	public com.kcdata.abe.data.dto.AllPricesBreakUp getAllPriceBreakResponse(AllPricesBreakUp allPriceBreakUpBO)
	{
		com.kcdata.abe.data.dto.AllPricesBreakUp allPriceBrekUp = new com.kcdata.abe.data.dto.AllPricesBreakUp();
		allPriceBrekUp.setChildRule(allPriceBreakUpBO.getChildRule());
		if(allPriceBreakUpBO.getFreeChildCount()!=null)
			allPriceBrekUp.setFreeChildCount(allPriceBreakUpBO.getFreeChildCount().byteValue());
		if(allPriceBreakUpBO.getMaxAdultCount()!=null)
			allPriceBrekUp.setMaxAdultCount(allPriceBreakUpBO.getMaxAdultCount().byteValue());
		if(allPriceBreakUpBO.getMaxChildCount()!=null)
			allPriceBrekUp.setMaxChildCount(allPriceBreakUpBO.getMaxChildCount().byteValue());
		if(allPriceBreakUpBO.getMaxPerRoom()!=null)
			allPriceBrekUp.setMaxPerRoom(allPriceBreakUpBO.getMaxPerRoom().byteValue());
		if(allPriceBreakUpBO.getMinPerRoom()!=null)
			allPriceBrekUp.setMinPerRoom(allPriceBreakUpBO.getMinPerRoom().byteValue());
		
		if(allPriceBreakUpBO.getPaxTypePrices()!=null && allPriceBreakUpBO.getPaxTypePrices().size()>0)
		{
			for(int p=0;p<allPriceBreakUpBO.getPaxTypePrices().size();p++)
			{
				if(allPriceBreakUpBO.getPaxTypePrices().get(p)!=null)
				allPriceBrekUp.getPaxTypePrices().add(p,this.getPaxTypePriceBreakup(allPriceBreakUpBO.getPaxTypePrices().get(p)));
			}
		}
		
		return allPriceBrekUp;
	}
	
	
	/**
	 * Method to prepare com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.abedmnlib_hva.v1.ActionType BO
	 * @param actionType
	 * @return actionTypeReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.abedmnlib_hva.v1.ActionType getActionTypeReq(ActionType actionType){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.abedmnlib_hva.v1.ActionType actionTypeReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.abedmnlib_hva.v1.ActionType();
		
		actionTypeReq.setActionCode( actionType.getActionCode() );
		actionTypeReq.setDescription( actionType.getDescription() );
		
		return actionTypeReq;
	}
	/**
	 * Method to prepare ActionType DTO
	 * @param res
	 * @return ActionType (DTO)
	 */
	public ActionType getActionType(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.abedmnlib_hva.v1.ActionType res){
		ActionType actionType = new ActionType();
		
		actionType.setActionCode( res.getActionCode() );
		actionType.setDescription( res.getDescription() );
		
		return actionType;
	}
	/**
	 * Prepare Address DTO from BO
	 * @param res
	 * @return Address
	 */
	
	public Address getAddress(com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.address.v1.Address res){
		Address address = new Address();
		
		address.setStreetAddress( res.getStreetAddress() );
		//Start theAV-3749/HBsi 52 Enhancement of emergency info tab for passegner	
		address.setCity( res.getCity().toUpperCase() );
		address.setState( res.getState().toUpperCase() );
		//Business wise not require for now
		//address.setCountry( res.getCountry() );
		//End of the AV-3749/HBsi 52 Enhancement of emergency info tab for passegner	
		address.setZipCode( res.getZipCode() );
		
		return address;
	}
	
	/**
	 * Prepare Addess BO from DTO
	 * @param address
	 * @return com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.address.v1.Address
	 */
	public com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.address.v1.Address getAddressReq(Address address){
		com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.address.v1.Address addressReq =
			new com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.address.v1.Address();
		//Start theAV-3749/HBsi 52 Enhancement of emergency info tab for passegner	
		addressReq.setStreetAddress( address.getStreetAddress() );
		addressReq.setCity( address.getCity() );
		addressReq.setState( address.getState() );
		//Business wise not require for now
		//addressReq.setCountry( address.getCountry() );
		addressReq.setZipCode( address.getZipCode() );
		//End of the AV-3749/HBsi 52 Enhancement of emergency info tab for passegner	
		return addressReq;
	}
	
	/**
	 * Method to prepare AgeCode BO
	 * @param ageCode
	 * @return ageCodeReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.agecode.v1.AgeCode getAgeCodeReq(AgeCode ageCode){
		com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.agecode.v1.AgeCode ageCodeReq = 
			new com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.agecode.v1.AgeCode();
		ageCodeReq.setAge( new Integer(ageCode.getAgeCode()) );
		ageCodeReq.setPaxTypeCode( Character.toString( ageCode.getPaxTypeCode() ) );
		
		return ageCodeReq;
	}

	/**
	 * Method to prepare AgeCode DTO from BO
	 * @param res
	 * @return AgeCode
	 */
	public AgeCode getAgeCode(com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.agecode.v1.AgeCode res){
		if( (res.getAge().intValue() == 50) || res.getPaxTypeCode().equals('L') ){
			return AgeCode.LAPCHILD;
		}
		if( (res.getAge().intValue() == 7) || res.getPaxTypeCode().equals('I') ){
			return AgeCode.INFANT;
		}
		if( (res.getAge().intValue() == 8) || res.getPaxTypeCode().equals('C') ){
			return AgeCode.CHILD;
		}
		if( (res.getAge().intValue() == 10) || res.getPaxTypeCode().equals('A') ){
			return AgeCode.ADULT;
		}
		if( (res.getAge().intValue() == 11) || res.getPaxTypeCode().equals('S') ){
			return AgeCode.SENIOR;
		}
		
		return null;
	}
	
	/**
	 * Method to prepare Agency DTO from BO
	 * @param res
	 * @return agency
	 */
	public Agency getAgency(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.agency.v1.Agency res){
		Agency agency = new Agency();
		
		agency.setCustomerNo( res.getCustomerNo() );
		agency.setIataNo( res.getIataNo() );
		agency.setName( res.getName() );
		agency.setCity( res.getCity() );
		agency.setPoBox( res.getPoBox() );
		agency.setPoBoxZipCode( res.getPoBoxZipCode() );
		agency.setZipCode( res.getZipCode() );
		agency.setState( res.getState() );
		agency.setStreet( res.getStreet() );
		agency.setPrimaryPhone( res.getPrimaryPhone() );
		agency.setSecondaryPhone( res.getSecondaryPhone() );
		agency.setFaxNo( res.getFaxNo() );
		agency.setCountry( res.getCountry() );
		agency.setAgencyRatingCode( res.getCountry() );
		if( (res.getAgents() != null) && (res.getAgents().size() > 0) ){
			List<Agent> agents = new ArrayList<Agent>();
			for(int i=0; i < res.getAgents().size(); i++){
				if( res.getAgents().get(i) != null ){
					agents.add( this.getAgent( res.getAgents().get(i) ) );
				}
			}
			agency.setAgents(agents);
		}
		if( (res.getPaymentMethods() != null) && (res.getPaymentMethods().size() > 0) ){
			List<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
			for(int i=0; i < res.getPaymentMethods().size(); i++){
				if( res.getPaymentMethods().get(i) != null ){
					paymentMethods.add( this.getPaymentMethod( res.getPaymentMethods().get(i) ) );
				}
			}
			agency.setPaymentMethods(paymentMethods);
		}
		if( (res.getCreditCards() != null) && (res.getCreditCards().size() > 0) ){
			List<CreditCard> creditCards = new ArrayList<CreditCard>();
			for(int i=0; i < res.getCreditCards().size(); i++){
				if( res.getCreditCards().get(i) != null ){
				creditCards.add( this.getCreditCard( res.getCreditCards().get(i) ) );
				}
			}
			agency.setCreditCards(creditCards);
		}
		
		return agency;
	}
	
	/**
	 * Method to prepare Agent DTO from BO
	 * @param res
	 * @return agent
	 */
	public Agent getAgent(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.agent.v1.Agent res){
		Agent agent = new Agent();
		
		agent.setAgentNo( res.getAgentNo() );
		agent.setFirstName( res.getFirstName() );
		agent.setLastName( res.getLastName() );
		agent.setFullName( res.getFullName() );
		agent.setEmailId( res.getEmailId() );
		agent.setRoyaltyNo( res.getRoyaltyNo() );
		agent.setPrint( res.getPrint() );
		agent.setFaxInput( res.getFaxInput() );
		
		return agent;
	}
	
	/**
	 * Method to prepare Agent BO
	 * @param agent
	 * @return agentReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.agent.v1.Agent getAgentReq(Agent agent){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.agent.v1.Agent agentReq = 
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.agent.v1.Agent();
		
		agentReq.setAgentNo( agent.getAgentNo() );
		agentReq.setFirstName( agent.getFirstName() );
		agentReq.setLastName( agent.getLastName() );
		agentReq.setFullName( agent.getFullName() );
		agentReq.setEmailId( agent.getEmailId() );
		agentReq.setRoyaltyNo( agent.getRoyaltyNo() );
		agentReq.setPrint( agent.getPrint() );
		agentReq.setFaxInput( agent.getFaxInput() );
		
		return agentReq;
	}
	
	/**
	 * Method to prepare Amenity BO
	 * @param amenity
	 * @return amenityReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.amenity.v1.Amenity getAmenityReq(Amenity amenity){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.amenity.v1.Amenity amenityReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.amenity.v1.Amenity();
		
		amenityReq.setHotelId( new Integer( amenity.getHotelId() ) );
		amenityReq.setRoomCategoryId( new Integer( amenity.getRoomCategoryId() ) );
		amenityReq.setAmenityCode( amenity.getAmenityCode() );
		amenityReq.setAmenityName( amenity.getAmenityName() );
		amenityReq.setAmenityValue( amenity.getAmenityValue() );
		if( amenity.getAmenityDate() != null ){
			amenityReq.setAmenityDate( this.getDate( amenity.getAmenityDate() ) );
		}
		
		return amenityReq;
	}
	
	/**
	 * Method to prepare Amenity DTO from BO
	 * @param res
	 * @return amenity
	 */
	public Amenity getAmenity(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.amenity.v1.Amenity res){
		Amenity amenity = new Amenity();
		
		amenity.setAmenityCode( res.getAmenityCode() );
		amenity.setAmenityName( res.getAmenityName() );
		amenity.setAmenityValue( res.getAmenityValue() );
		if( res.getAmenityDate() != null ){
			amenity.setAmenityDate( this.getDate( res.getAmenityDate() ) );
		}
		if( res.getHotelId() != null ){
			amenity.setHotelId( res.getHotelId().intValue() );
		}
		if( res.getRoomCategoryId() != null ){
			amenity.setRoomCategoryId( res.getRoomCategoryId().intValue() );
		}
		
		return amenity;
	}
	
	/**
	 * Method to prepare AlertType DTO
	 * @param res
	 * @return alertType
	 */
	public AlertType getAlertType(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.alerttype.v1.AlertType res){
		AlertType alertType = new AlertType();
		
		alertType.setAlertCode( res.getAlertCode() );
		alertType.setActionCode( res.getActionCode() );
		alertType.setDescription( res.getDescription() );
		
		return alertType;
	}
	
	/**
	 * Method to prepare Alert DTO
	 * @param res
	 * @return alert
	 */
	public Alert getAlert(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.alert.v1.Alert res){
		Alert alert = new Alert();
		
		if( res.getAlertLineNo() != null ){
			alert.setAlertLineNo( res.getAlertLineNo().intValue() );
		}
		if( res.getAlertSerialNo() != null ){
			alert.setAlertSerialNo( res.getAlertSerialNo().intValue() );
		}
		alert.setAlertLevel( res.getAlertLevel() );
		alert.setAlertId( res.getAlertId() );
		alert.setAlertMessage( res.getAlertMessage() );
		alert.setAlertType( res.getAlertType() );
		alert.appendText( res.getText() );
		
		return alert;
	}
	
	/**
	 * Method to prepare Alert BO
	 * @param alert
	 * @return alertReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.alert.v1.Alert getAlertReq(Alert alert){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.alert.v1.Alert alertReq = 
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.alert.v1.Alert();
		
		alertReq.setAlertLineNo( new Integer(alert.getAlertLineNo()) );
		alertReq.setAlertLevel( alert.getAlertLevel() );
		alertReq.setAlertId( alert.getAlertId() );
		alertReq.setAlertSerialNo( new Integer(alert.getAlertSerialNo()) );
		alertReq.setAlertMessage( alert.getAlertMessage());
		alertReq.setAlertType( alert.getAlertType() );
		alertReq.setText( alert.getText() );
		
		return alertReq;
	}
	
	/**
	 * Method to prepare AlertType BO 
	 * @param alertType
	 * @return alertTypeReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.alerttype.v1.AlertType getAlertTypeReq(AlertType alertType){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.alerttype.v1.AlertType alertTypeReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.alerttype.v1.AlertType();
		
		alertTypeReq.setAlertCode( alertType.getAlertCode() );
		alertTypeReq.setActionCode( alertType.getActionCode());
		alertTypeReq.setDescription( alertType.getDescription() );
		
		return alertTypeReq;
	}
	
	/**
	 * Method to prepare BookingLockDetails DTO from BO
	 * @param res
	 * @return bookingLockDetails
	 */
	public BookingLockDetails getBookingLockDetails(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.bookinglockdetails.v1.BookingLockDetails res){
		BookingLockDetails bookingLockDetails = new BookingLockDetails();
		
		bookingLockDetails.setBookingNo( res.getBookingNo() );
		bookingLockDetails.setLockId( res.getLockId() );
		bookingLockDetails.setLockMessage( res.getLockMessage() );
		if( res.isAlreadyLocked() != null ){
			bookingLockDetails.setAlreadyLocked( res.isAlreadyLocked().booleanValue() );
		}
		if( res.isAdmin() != null ){
			bookingLockDetails.setAdmin( res.isAdmin().booleanValue() );
		}
		
		return bookingLockDetails;
	}
	
	/**
	 * Method to prepare BookingHeader DTO from BO
	 * @param res
	 * @return bookingHeader
	 */
	public BookingHeader getBookingHeader(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.bookingheader.v1.BookingHeader res){
		BookingHeader bookingHeader = new BookingHeader();
		
		if( res.getTourPrice() != null ){
			bookingHeader.setTourPrice( res.getTourPrice().doubleValue() );
		}
		if( res.getAmountDue() != null ){
			bookingHeader.setAmountDue( res.getAmountDue().doubleValue() );
		}
		if( res.getMinimumAmount() != null ){
			bookingHeader.setMinimumAmount( res.getMinimumAmount().doubleValue() );
		}
		if( res.getBaseCommission() != null ){
			bookingHeader.setBaseCommission( res.getBaseCommission().doubleValue() );
		}
		if( res.getAmountPaid() != null ){
			bookingHeader.setAmountPaid( res.getAmountPaid().doubleValue() );
		}
		if( res.getGrossBalanceDue() != null ){
			bookingHeader.setGrossBalanceDue( res.getGrossBalanceDue().doubleValue() );
		}
		if( res.getPromoSaving() != null ){
			bookingHeader.setPromoSaving( res.getPromoSaving().doubleValue() );
		}
		bookingHeader.setBookingNo( res.getBookingNo() );
		bookingHeader.setTourId( res.getTourId() );
		bookingHeader.setTrackingNo( res.getTrackingNo() );
		bookingHeader.setPromoId( res.getPromoId() );
		bookingHeader.setPromoCode( res.getPromoCode() );
		bookingHeader.setCreatedBy( res.getCreatedBy() );
		bookingHeader.setLastChangeBy( res.getLastChangeBy() );
		bookingHeader.setSalesOrg( res.getSalesOrg() );
		bookingHeader.setDistributionChannel( res.getDistributionChannel() );
		bookingHeader.setCallCenter( res.getCallCenter() );
		bookingHeader.setAlertCode( res.getAlertCode() );
		bookingHeader.setActionCode( res.getActionCode() );
		bookingHeader.setAgencyRatingCode( res.getAgencyRatingCode() );
		if( res.getOptionDate() != null ){
			bookingHeader.setOptionDate( this.getDate( res.getOptionDate() ) );
		}
		if( res.getCancellationDate() != null ){
			bookingHeader.setCancellationDate( this.getDate( res.getCancellationDate() ) );
		}
		if( res.getTicketingDate() != null ){
			bookingHeader.setTicketingDate( this.getDate( res.getTicketingDate() ) );
		}
		if( res.getDepartureDate() != null ){
			bookingHeader.setDepartureDate( this.getDate( res.getDepartureDate() ) );
		}
		if( res.getGuaranteedDate() != null ){
			bookingHeader.setGuaranteedDate( this.getDate( res.getGuaranteedDate() ) );
		}
		if( res.getFinalDueDate() != null ){
			bookingHeader.setFinalDueDate( this.getDate( res.getFinalDueDate() ) );
		}
		if( res.getVoucherDate() != null ){
			bookingHeader.setVoucherDate( this.getDate( res.getVoucherDate() ) );
		}
		if( res.getCreatedDate() != null ){
			bookingHeader.setCreatedDate( this.getDate( res.getCreatedDate() ) );
		}
		if( res.getLastChangeDate() != null ){
			bookingHeader.setLastChangeDate( this.getDate( res.getLastChangeDate() ) );
		}
		if( res.getTravelDate() != null ){
			bookingHeader.setTravelDate( this.getDate( res.getTravelDate() ) );
		}
		if( res.getBookingDate() != null ){
			bookingHeader.setBookingDate( this.getDate( res.getBookingDate() ) );
		}
		if( res.isApplyPaymentAllowed() != null ){
			bookingHeader.setApplyPaymentAllowed( res.isApplyPaymentAllowed().booleanValue() );
		}
		if( res.isZeroPriceError() != null ){
			bookingHeader.setZeroPriceError( res.isZeroPriceError().booleanValue() );
		}
		if( res.isPriceMismatchError() != null ){
			bookingHeader.setPriceMismatchError( res.isPriceMismatchError().booleanValue() );
		}
		if( (res.getBookingStatus() != null) && (res.getBookingStatus().getStatus() != null ) ){
			if( res.getBookingStatus().getStatus().equals("OPT")){
				bookingHeader.setBookingStatus( BookingStatus.OPT );
			}
			else if( res.getBookingStatus().getStatus().equals("GTD")){
				bookingHeader.setBookingStatus( BookingStatus.GTD );
			}
			else if( res.getBookingStatus().getStatus().equals("PIF")){
				bookingHeader.setBookingStatus( BookingStatus.PIF );
			}
			else if( res.getBookingStatus().getStatus().equals("DRD")){
				bookingHeader.setBookingStatus( BookingStatus.DRD );
			}
			else if( res.getBookingStatus().getStatus().equals("CANC")){
				bookingHeader.setBookingStatus( BookingStatus.CANC );
			}
			else if( res.getBookingStatus().getStatus().equals("DEP")){
				bookingHeader.setBookingStatus( BookingStatus.DEP );
			}
			else if( res.getBookingStatus().getStatus().equals("EXP")){
				bookingHeader.setBookingStatus( BookingStatus.EXP );
			}
		}
		if( res.getAgency() != null ){
			bookingHeader.setAgency( this.getAgency( res.getAgency() ) );
		}
		if( (res.getPaymentHistoryInformationList() != null) && (res.getPaymentHistoryInformationList().size() > 0) ){
			bookingHeader.setPaymentHistoryInformationList( new ArrayList<PaymentHistoryInfo>() );
			for(int i=0; i < res.getPaymentHistoryInformationList().size(); i++){
				if( res.getPaymentHistoryInformationList().get(i) != null ){
					bookingHeader.getPaymentHistoryInformationList().add( 
						this.getPaymentHistoryInfo( res.getPaymentHistoryInformationList().get(i) ) );
				}
			}
		}
		
		return bookingHeader;
	}
	
	/**
	 * Method to prepare BookingHeader BO
	 * @param bookingHeader
	 * @return bookingHeaderReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.bookingheader.v1.BookingHeader getBookingHeaderReq(BookingHeader bookingHeader){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.bookingheader.v1.BookingHeader bookingHeaderReq = 
		new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.bookingheader.v1.BookingHeader();
		
		if(bookingHeader!=null)
		{
			
			bookingHeaderReq.setBookingNo(bookingHeader.getBookingNo());
			bookingHeaderReq.setCallCenter(bookingHeader.getCallCenter());
			bookingHeaderReq.setPromoCode(bookingHeader.getPromoCode());
					
		}
		return bookingHeaderReq;
	}
	
	/**
	 * Method to prepare BookingLockDetails BO
	 * @param bookingLockDetails
	 * @return bookingLockDetailsReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.bookinglockdetails.v1.BookingLockDetails getBookingLockDetailsReq(BookingLockDetails bookingLockDetails){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.bookinglockdetails.v1.BookingLockDetails bookingLockDetailsReq = new
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.bookinglockdetails.v1.BookingLockDetails();
		
		bookingLockDetailsReq.setBookingNo( bookingLockDetails.getBookingNo() );
		bookingLockDetailsReq.setLockId( bookingLockDetails.getLockId() );
		bookingLockDetailsReq.setLockMessage( bookingLockDetails.getLockMessage() );
		bookingLockDetailsReq.setAlreadyLocked( new Boolean(bookingLockDetails.isAlreadyLocked()) );
		bookingLockDetailsReq.setAdmin( new Boolean(bookingLockDetails.isAdmin()));
		
		return bookingLockDetailsReq;
	}
	
	/**
	 * Method to prepare Carrier BO
	 * @param carrier
	 * @return carrierReq
	 */
	
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.carrier.v1.Carrier getCarrierReq(Carrier carrier){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.carrier.v1.Carrier carrierReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.carrier.v1.Carrier();
		
		carrierReq.setCarrierCode( carrier.getCarrierCode() );
		carrierReq.setCarrierName( carrier.getCarrierName() );
		carrierReq.setCodeshareAvaialable( new Boolean(carrier.isCodeshareAvaialable()) );
		carrierReq.setCodeShareInfo( carrier.getCodeShareInfo() );
		
		return carrierReq;
	}
	
	/**
	 * Method to prepare Carrier DTO from BO
	 * @param res
	 * @return carrier
	 */
	public Carrier getCarrier(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.carrier.v1.Carrier res){
		Carrier carrier = new Carrier();
		
		carrier.setCodeShareInfo( res.getCodeShareInfo() );
		carrier.setCarrierCode( res.getCarrierCode() );
		carrier.setCarrierName( res.getCarrierName() );
		if( res.isCodeshareAvaialable() != null ){
			carrier.setCodeshareAvaialable( res.isCodeshareAvaialable().booleanValue() );
		}
		
		return carrier;
	}
	
	/**
	 * Method to prepare CreditCard BO 
	 * @param creditCard
	 * @return creditCardReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.creditcard.v1.CreditCard getCreditCardReq(CreditCard creditCard){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.creditcard.v1.CreditCard creditCardReq = 
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.creditcard.v1.CreditCard();
		
		creditCardReq.setStreet( creditCard.getStreet() );
		creditCardReq.setCity( creditCard.getCity() );
		creditCardReq.setState( creditCard.getState() );
		creditCardReq.setPostalCode( creditCard.getPostalCode() );
		creditCardReq.setDistrict( creditCard.getDistrict() );
		creditCardReq.setCountryCode( creditCard.getCountryCode() );
		creditCardReq.setTelephone( creditCard.getTelephone() );
		creditCardReq.setAmountUSD( new Double(creditCard.getAmountUSD()) );
		creditCardReq.setPassengerId( creditCard.getPassengerId() );
		creditCardReq.setCVVCode( creditCard.getCVVCode() );
		creditCardReq.setDescription( creditCard.getDescription() );
		creditCardReq.setUseSameCard( Character.toString(creditCard.getUseSameCard()) );
		creditCardReq.setOtherCardHolderFlag( Character.toString(creditCard.getOtherCardHolderFlag()) );
		creditCardReq.setOtherCardHolderEmail( creditCard.getOtherCardHolderEmail() );
		creditCardReq.setCardType( creditCard.getCardType() );
		creditCardReq.setName( creditCard.getName() );
		creditCardReq.setCardNo( creditCard.getCardNo() );
		creditCardReq.setExpiryMonth( creditCard.getExpiryMonth() );
		creditCardReq.setExpiryYear( creditCard.getExpiryYear() );
		creditCardReq.setAmount( new Double(creditCard.getAmount()) );
		creditCardReq.setLastName( creditCard.getLastName() );
		creditCardReq.setFirstName( creditCard.getFirstName() );
		creditCardReq.setPaymentDate( creditCard.getPaymentDate() );
		
		return creditCardReq;
	}
	
	/**
	 * Method to prepare CreditCard DTO
	 * @param res
	 * @return creditCard
	 */
	public CreditCard getCreditCard(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.creditcard.v1.CreditCard res){
		CreditCard creditCard = new CreditCard();
		
		creditCard.setCardType( res.getCardType() );
		creditCard.setName( res.getName() );
		creditCard.setCardNo( res.getCardNo() );
		creditCard.setExpiryMonth( res.getExpiryMonth() );
		creditCard.setExpiryYear( res.getExpiryYear() );
		creditCard.setLastName( res.getLastName() );
		creditCard.setFirstName( res.getFirstName() );
		creditCard.setPaymentDate( res.getPaymentDate() );
		creditCard.setStreet( res.getStreet() );
		creditCard.setCity( res.getCity() );
		creditCard.setState( res.getState() );
		creditCard.setPostalCode( res.getPostalCode() ); 
		creditCard.setDistrict( res.getDistrict() );
		creditCard.setCountryCode( res.getCountryCode() );
		creditCard.setTelephone( res.getTelephone() );
		creditCard.setPassengerId( res.getPassengerId() );
		creditCard.setCVVCode( res.getCVVCode() );
		creditCard.setDescription( res.getDescription() );
		creditCard.setOtherCardHolderEmail( res.getOtherCardHolderEmail() );
		if( res.getUseSameCard() != null ){
			creditCard.setUseSameCard( res.getUseSameCard().charAt(0) );
		}
		if( res.getOtherCardHolderFlag() != null ){
			creditCard.setOtherCardHolderFlag( res.getOtherCardHolderFlag().charAt(0) );
		}
		if( res.getAmountUSD() != null ){
			creditCard.setAmountUSD( res.getAmountUSD().doubleValue() );
		}
		if( res.getAmount() != null ){
			creditCard.setAmount( res.getAmount().doubleValue() );
		}
		
		return creditCard;
	}
	
	/**
	 * Method to convert BigInteger to Integer
	 * @param alist
	 * @return blist
	 */
	public List<Integer> convertBigIntegerList(List<BigInteger> alist){
		List<Integer> blist = new ArrayList<Integer>(alist.size());
		for(int i=0; i < alist.size(); i++){
			if(alist.get(i)!=null)
			{
			blist.add( new Integer( alist.get(i).intValue() ) );
			}
		}
		
		return blist;
	}
	
	/**
	 * Method to convert Integer to BigInteger
	 * @param alist
	 * @return blist
	 */
	public List<BigInteger> convertIntegerList(List<Integer> alist){
		List<BigInteger> blist = new ArrayList<BigInteger>(alist.size());
		for(int i=0; i < alist.size(); i++){
			blist.add( BigInteger.valueOf( alist.get(i).intValue() ) );
		}
		
		return blist;
	}
	
	/**
	 * Method to create list of Java.util.Date from  list of XMLGregorianCalendar dates
	 * @param alist
	 * @return blist
	 */
	public List<Date> convertXMLGregorianCalendarList(List<XMLGregorianCalendar> alist){
		List<Date> blist = new ArrayList<Date>(alist.size());
		for(int i=0; i < alist.size(); i++){
			blist.add( this.getDate(alist.get(i)) );
		}
		return blist;
	}
	
	/**
	 * Method to create list of XMLGregorianCalendar dates from list of Java.util.Date dates
	 * @param alist
	 * @return blist
	 */
	public List<XMLGregorianCalendar> convertDateList(List<Date> alist){
		List<XMLGregorianCalendar> blist = new ArrayList<XMLGregorianCalendar>(alist.size());
		for(int i=0; i < alist.size(); i++){
			blist.add( this.getDate(alist.get(i)) );
		}
		return blist;
	}
	
	/**
	 * Method to convert java.util.Date to XMLGregorianCalendar
	 * @param date
	 * @return XMLGregorianCalendar
	 */
	public XMLGregorianCalendar getDate(Date date){
		return XMLGregorianCalendarConversionUtil.asXMLGregorianCalendar(date);
	}
	
	/**
	 * Method to convert XMLGregorianCalendar to java.util.Date
	 * @param date
	 * @return java.util.Date
	 */
	public Date getDate(XMLGregorianCalendar dateRes){
		return XMLGregorianCalendarConversionUtil.asDate(dateRes);
	}
	
	/**
	 * Method to prepare Destination DTO from BO
	 * @param res
	 * @return destination
	 */
	public Destination getDestination(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destination.v1.Destination res){
		Destination destination = new Destination();
		destination.setAirportCode( res.getAirportCode() );
		destination.setAirportName( res.getAirportName() );
		destination.setCityName( res.getCityName() );
		destination.setStateCode( res.getStateCode() );
		destination.setCountryCode( res.getCountryCode() );
		destination.setLanguageCode( res.getLanguageCode() );
		if( res.isAirDestination() != null ){
			destination.setAirDestination( res.isAirDestination().booleanValue() );
		}
		if( res.isHotelDestination() != null ){
			destination.setHotelDestination( res.isHotelDestination().booleanValue() );
		}
		if( res.isVehicleDestination() != null ){
			destination.setVehicleDestination( res.isVehicleDestination().booleanValue() );
		}
		destination.setCountryDescription( res.getCountryDescription() );
		destination.setNearbyAirports( res.getNearbyAirports() );
		if( (res.getServices() != null) && (res.getServices().size() > 0) ){
			List<DestinationService> services = new ArrayList<DestinationService>();
			for(int i=0; i < res.getServices().size(); i++){
				if( res.getServices().get(i) != null ){
				services.add( this.getDestinationService( res.getServices().get(i) ) );
				}
			}
			destination.setServices( services );
		}
		
		return destination;
	}
	
	/**
	 * Method to prepare DestinationService DTO
	 * @param res
	 * @return destinationService
	 */
	public DestinationService getDestinationService(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destinationservice.v1.DestinationService res){
		DestinationService destinationService = new DestinationService();
		
		destinationService.setServiceCode( res.getServiceCode() );
		destinationService.setServiceName( res.getServiceName() );
		destinationService.setCurrency( res.getCurrency() );
		if( res.getPrice() != null ){
			destinationService.setPrice( res.getPrice().doubleValue() );
		}
		
		return destinationService;
	}
	
	/**
	 * Method to prepare FlightTransferInfo BO
	 * @param flightTransferInfo
	 * @return flightTransferInfoReq
	 */
	
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.flighttransferinfo.v1.FlightTransferInfo getFlightTransferInfoReq(FlightTransferInfo flightTransferInfo){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.flighttransferinfo.v1.FlightTransferInfo flightTransferInfoReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.flighttransferinfo.v1.FlightTransferInfo();
		
		flightTransferInfoReq.setGateway( flightTransferInfo.getGateway() );
		flightTransferInfoReq.setDestination( flightTransferInfo.getDestination() );
		flightTransferInfoReq.setFlightNo( flightTransferInfo.getFlightNo());
		flightTransferInfoReq.setRotation( flightTransferInfo.getRotation() );
		if( flightTransferInfo.getArrivalDate() !=  null ){
			flightTransferInfoReq.setArrivalDate( this.getDate( flightTransferInfo.getArrivalDate() ) );
		}
		if( flightTransferInfo.getDepartureDate() != null ){
			flightTransferInfoReq.setDepartureDate( this.getDate( flightTransferInfo.getDepartureDate() ) );
		}
		if( flightTransferInfo.getCarrier() != null ){
			flightTransferInfoReq.setCarrier( this.getCarrierReq(flightTransferInfo.getCarrier()) );
		}
		
		return flightTransferInfoReq;
	}
	
	/**
	 * Method to prepare FlightTransferInfo
	 * @param res
	 * @return flightTransferInfo
	 */
	public FlightTransferInfo getFlightTransferInfo(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.flighttransferinfo.v1.FlightTransferInfo res){
		FlightTransferInfo flightTransferInfo = new FlightTransferInfo();
		
		flightTransferInfo.setGateway( res.getGateway() );
		flightTransferInfo.setDestination( res.getDestination() );
		flightTransferInfo.setFlightNo( res.getFlightNo() );
		flightTransferInfo.setRotation( res.getRotation() );
		if( res.getArrivalDate() != null ){
			flightTransferInfo.setArrivalDate( this.getDate( res.getArrivalDate() ) );
		}
		if( res.getDepartureDate() != null ){
			flightTransferInfo.setDepartureDate( this.getDate( res.getDepartureDate() ) );
		}
		if( res.getCarrier() != null ){
			flightTransferInfo.setCarrier( this.getCarrier( res.getCarrier() ) );
		}
		
		return flightTransferInfo;
	}
	/**
	 * Method to prepare FlightTripType BO
	 * @param flightTripType
	 * @return flightTripTypeReq
	 */
	
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.flighttriptype.v1.FlightTripType getFlightTripTypeReq(FlightTripType flightTripType){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.flighttriptype.v1.FlightTripType flightTripTypeReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.flighttriptype.v1.FlightTripType();
		
		flightTripTypeReq.setType( flightTripType.getType() );
		
		return flightTripTypeReq;
	}
	
	/**
	 * Method to prepare Hotel BO
	 * @param hotel
	 * @return hotelReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel getHotelReq(Hotel hotel){com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel hotelReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel();
		
		//set the hotelGdsCode
		hotelReq.setGdsHotelCode(hotel.getGdsHotelCode());
		hotelReq.setVendorHotelCode(hotel.getVendorHotelCode());
		hotelReq.setHotelId( new Integer( hotel.getHotelId() ) );
		hotelReq.setHotelCode( hotel.getHotelCode() );
		hotelReq.setHotelChain( hotel.getHotelChain() );
		hotelReq.setHotelName( hotel.getHotelName() );
		hotelReq.setNoOfRooms( new Integer( hotel.getNoOfRooms() ) );
		hotelReq.setAppleRating( hotel.getAppleRating() );
		hotelReq.setHbsiPNRNo(hotel.getHbsiPNR());
		hotelReq.setIsHBSi(hotel.isHBSI());
		if( hotel.getCheckInDate() != null ){
			hotelReq.setCheckInDate( this.getDate( hotel.getCheckInDate() ) );
		}
		if( hotel.getCheckOutDate() != null ){
			hotelReq.setCheckOutDate( this.getDate( hotel.getCheckOutDate() ) );
		}
		hotelReq.setMinRate( new Double(hotel.getMinRate()) );
		hotelReq.setCurrency( hotel.getCurrency() );
		hotelReq.setHotelCityCode( hotel.getHotelCityCode() );
		hotelReq.setOriginLocation( hotel.getOriginLocation() );
		hotelReq.setRiskHotel( new Boolean( hotel.isRiskHotel() ) );
		hotelReq.setNoOfNights( hotel.getNoOfNights() );
		hotelReq.setAppleSpecialsAndSavers( new Boolean( hotel.isAppleSpecialsAndSavers() ) ); 
		hotelReq.setNoOfRequestedRooms( new Integer( hotel.getNoOfRequestedRooms() ) );
		if( hotel.getOccupancy() != null ){
			hotelReq.setOccupancy( this.getOccupancyReq( hotel.getOccupancy() ) );
		}
		if( hotel.getResortArea() != null ){
			hotelReq.setResortArea( this.getResortAreaReq( hotel.getResortArea() ) );
		}
		if( hotel.getDisplayRoomCategory() != null ){
			hotelReq.setDisplayRoomCategory( this.getRoomCategoryReq( hotel.getDisplayRoomCategory() ));
		}
		if( (hotel.getSelectedRooms() != null) && (hotel.getSelectedRooms().size() > 0) ){
			for(int i=0; i < hotel.getSelectedRooms().size(); i++){
				hotelReq.getSelectedRooms().add( this.getRoomPriceReq( hotel.getSelectedRooms().get(i) ) );
			}
		}
		if( (hotel.getPreselectedRooms() != null) && (hotel.getPreselectedRooms().size() > 0) ){
			for(int i=0; i < hotel.getPreselectedRooms().size(); i++){
				hotelReq.getPreselectedRooms().add( this.getRoomPriceReq( hotel.getPreselectedRooms().get(i) ) );
			}
		}
		if( (hotel.getRoomCategories() != null) && (hotel.getRoomCategories().size() > 0) ){
			for(int i=0; i < hotel.getRoomCategories().size(); i++){
				hotelReq.getRoomCategories().add( this.getRoomCategoryReq( hotel.getRoomCategories().get(i) ) );
			}
		}
		if( (hotel.getVendorServices() != null) && (hotel.getVendorServices().size() > 0) ){
			for(int i=0; i < hotel.getVendorServices().size(); i++){
				hotelReq.getVendorServices().add( this.getVendorServiceReq( hotel.getVendorServices().get(i) ) );
			}
		}
		if( (hotel.getRequestedDatesForAvailabilities() != null) && (hotel.getRequestedDatesForAvailabilities().size() > 0) ){
			for(int i=0; i < hotel.getRequestedDatesForAvailabilities().size(); i++){
				hotelReq.getRequestedDatesForAvailabilities().add( 
						this.getRequestedDatesForAvailabilityReq( hotel.getRequestedDatesForAvailabilities().get(i) ) );
			}
		}
		
		if (hotel.getVendor() != null) {
//			hotelReq.getVendor().setCity(hotel.getVendor().getCity()); 
			hotelReq.setVendor(this.getVendorReq(hotel.getVendor()));
		}
		
		//setting search criteria
		
		if(hotel.getSearchCriteria()!=null)
		{
			hotelReq.setSearchCriteria(this.getSearchCriteriaReq(hotel.getSearchCriteria()));
		}
		
		//Set the Cancellation Policy
		
		if(hotel.getCancellationPolicy()!=null)
		{
			hotelReq.getCancellationPolicy().addAll(hotel.getCancellationPolicy());
		}
		
		return hotelReq;
	}
	
	/**
	 * Method to prepare Hotel DTO from BO
	 * @param res
	 * @return hotel
	 */
	public Hotel getHotel(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel res ){
		Hotel hotel = new Hotel();
		
		//set the gdsHotelCode
		hotel.setGdsHotelCode(res.getGdsHotelCode());
		hotel.setVendorHotelCode(res.getVendorHotelCode());
		hotel.setHotelCode( res.getHotelCode() );
		hotel.setHotelChain( res.getHotelChain() );
		hotel.setHotelName( res.getHotelName() );
		hotel.setAppleRating( res.getAppleRating() );
		hotel.setCurrency( res.getCurrency() );
		hotel.setHotelCityCode( res.getHotelCityCode() );
		hotel.setOriginLocation( res.getOriginLocation() );
		hotel.setNoOfNights( res.getNoOfNights() ); 
		hotel.setHbsiPNR(res.getHbsiPNRNo());
		hotel.setHBSI(res.isIsHBSi()!=null?res.isIsHBSi():false);

		if( res.getHotelId() != null ){
			hotel.setHotelId( res.getHotelId().intValue() );
		}
		if( res.getNoOfRequestedRooms() != null ){
			hotel.setNoOfRequestedRooms( res.getNoOfRequestedRooms().intValue() );
		}
		if( res.getNoOfRooms() != null ){
			hotel.setNoOfRooms( res.getNoOfRooms().intValue() );
		}
		if( res.getMinRate() != null ){
			hotel.setMinRate( res.getMinRate().doubleValue() );
		}
		if( res.isAppleSpecialsAndSavers() != null ){
			hotel.setAppleSpecialsAndSavers( res.isAppleSpecialsAndSavers().booleanValue() );
		}
		if( res.isRiskHotel() != null ){
			hotel.setRiskHotel( res.isRiskHotel().booleanValue() );
		}
		if( res.getCheckInDate() != null ){
			hotel.setCheckInDate( this.getDate( res.getCheckInDate() ) );
		}
		if( res.getCheckOutDate() != null ){
			hotel.setCheckOutDate( this.getDate( res.getCheckOutDate() ) );
		}
		if( res.getVendor() != null ){
			hotel.setVendor( this.getVendor( res.getVendor()) );
		}
		if( res.getOccupancy() != null ){
			hotel.setOccupancy( this.getOccupancy( res.getOccupancy() ) );
		}
		if( res.getResortArea() != null ){
			hotel.setResortArea( this.getResortArea( res.getResortArea() ) );
		}
		if( res.getDisplayRoomCategory() != null ){
			hotel.setDisplayRoomCategory( this.getRoomCategory( res.getDisplayRoomCategory() ) );
		}
		if( (res.getPreselectedRooms() != null) && (res.getPreselectedRooms().size() > 0) ){
			List<RoomPrice> preselectedRooms = new ArrayList<RoomPrice>();
			for(int i=0; i < res.getPreselectedRooms().size(); i++){
				if( res.getPreselectedRooms().get(i) != null ){
					preselectedRooms.add( this.getRoomPrice( res.getPreselectedRooms().get(i) ) );
				}
			}
			hotel.setPreselectedRooms(preselectedRooms);
		}
		if( (res.getSelectedRooms() != null) && (res.getSelectedRooms().size() > 0) ){
			List<RoomPrice> selectedRooms = new ArrayList<RoomPrice>();
			for(int i=0; i < res.getSelectedRooms().size(); i++){
				if( res.getSelectedRooms().get(i) != null ){
					selectedRooms.add( this.getRoomPrice( res.getSelectedRooms().get(i) ) );
				}
			}
			hotel.setSelectedRooms(selectedRooms);
		}
		if( (res.getRequestedDatesForAvailabilities() != null) && (res.getRequestedDatesForAvailabilities().size() > 0) ){
			List<RequestedDatesForAvailability> requestedDatesForAvailabilities = 
							new ArrayList<RequestedDatesForAvailability>();
			for(int i=0; i < res.getRequestedDatesForAvailabilities().size(); i++){
				if( res.getRequestedDatesForAvailabilities().get(i) != null ){
					requestedDatesForAvailabilities.add( this.getRequestedDatesForAvailability( res.getRequestedDatesForAvailabilities().get(i) ) );
				}
			}
			hotel.setRequestedDatesForAvailabilities(requestedDatesForAvailabilities);
		}
		if( (res.getRoomCategories() != null) && (res.getRoomCategories().size() > 0) ){
			List<RoomCategory> roomCategories = new ArrayList<RoomCategory>();
			for(int i=0; i < res.getRoomCategories().size(); i++){
				if( res.getRoomCategories().get(i) != null ){
					roomCategories.add( this.getRoomCategory( res.getRoomCategories().get(i) ) );
				}
			}
			hotel.setRoomCategories(roomCategories);
		}
		if( (res.getVendorServices() != null) && (res.getVendorServices().size() > 0) ){
			List<VendorService> vendorServices = new ArrayList<VendorService>();
			for(int i=0; i < res.getVendorServices().size(); i++){
				if( res.getVendorServices().get(i) != null ){
					vendorServices.add( this.getVendorService( res.getVendorServices().get(i) ) );
				}
			}
			hotel.setVendorServices(vendorServices);
		}
		
		//set cancellation policy
		
		if(res.getCancellationPolicy()!=null && res.getCancellationPolicy().size()>0)
		//if(res.getCancellationPolicy()==null)
		{
			
			hotel.setCancellationPolicy(res.getCancellationPolicy());
		
		}
		
		return hotel;
	}
	/**
	 * method to prepare HotelOptions BO
	 * @param hotelOptions
	 * @return hotelOptionsReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hoteloptions.v1.HotelOptions getHotelOptionsReq(HotelOptions hotelOptions){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hoteloptions.v1.HotelOptions hotelOptionsReq = 
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hoteloptions.v1.HotelOptions();
		
		hotelOptionsReq.setAppleRating( hotelOptions.getAppleRating() );
		//hotelOptionsReq.setGdsHotelCode(arg0)//ignore
		hotelOptionsReq.setHotelChain( hotelOptions.getHotelChain() );
		if( hotelOptions.getHotelCode() != null ){
			hotelOptionsReq.setHotelCode( hotelOptions.getHotelCode() );
		}
		else{
			hotelOptionsReq.setHotelCode( "" );
		}
		hotelOptionsReq.setHotelName( hotelOptions.getHotelName() );
		
		if( this.getIMApplicationInfo() != null ){
			hotelOptionsReq.setImApplicationInfo( this.getImApplicationInfoReq( this.getIMApplicationInfo() ) );
		}
		
		hotelOptionsReq.setNoOfRooms( new Integer(hotelOptions.getNoOfRooms()) );
		hotelOptionsReq.setShowAll( new Boolean(hotelOptions.isShowAll()) );
		hotelOptionsReq.setRoomTypeCode( hotelOptions.getRoomTypeCode() );
		hotelOptionsReq.setRatePlanCode( hotelOptions.getRatePlanCode() );
		if( hotelOptions.getResortArea() != null ){
			hotelOptionsReq.setResortArea( this.getResortAreaReq( hotelOptions.getResortArea() ) );
		}
		if( (hotelOptions.getAmenities() != null) && (hotelOptions.getAmenities().size() > 0) ){
			for(int i=0; i < hotelOptions.getAmenities().size(); i++){
				if( hotelOptions.getAmenities().get(i) != null ){
					hotelOptionsReq.getAmenities().add(this.getAmenityReq(hotelOptions.getAmenities().get(i)));
				}
			}
		}
		return hotelOptionsReq;
	}
	
	/**
	 * method to prepare HotelsPriceItineraryRequest BO
	 * @param itinerary
	 * @return hotelsPriceItineraryRequest
	 */
	public com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelspriceitineraryrequest.v1.HotelsPriceItineraryRequest getHotelsPriceItineraryRequestReq(Itinerary itinerary){
		com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelspriceitineraryrequest.v1.
		HotelsPriceItineraryRequest hotelsPriceItineraryRequest = new 
				com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelspriceitineraryrequest.v1.HotelsPriceItineraryRequest();
		
		if( this.getItineraryReq(itinerary) != null ){
			
			hotelsPriceItineraryRequest.setBookingNo( itinerary.getBookingNo() );
			
			
			hotelsPriceItineraryRequest.setItinerary( this.getItineraryReq(itinerary) );
			
			if( itinerary.getSearchCriteria() != null ){
				if( itinerary.getSearchCriteria().getMultiDestPackageRequest() != null ){
					hotelsPriceItineraryRequest.setMultiDestinationRequest( 
							new Boolean( itinerary.getSearchCriteria().getMultiDestPackageRequest().isMultiDestinationRequest() )  );//Boolean
				}
				if( itinerary.getSearchCriteria().getOccupancy() != null ){
					hotelsPriceItineraryRequest.setOccupancy( this.getOccupancyReq(itinerary.getSearchCriteria().getOccupancy() ));
				}
				if( itinerary.getSearchCriteria().getPackagesRequest() != null ){
					hotelsPriceItineraryRequest.setPackageRequest( 
						new Boolean( itinerary.getSearchCriteria().getPackagesRequest().isPackageRequest() ) );
				}
				hotelsPriceItineraryRequest.setPromoCode( itinerary.getSearchCriteria().getPromoCode() );
				if( itinerary.getSearchCriteria().getVehiclesRequest() != null ){
					hotelsPriceItineraryRequest.setVehicleRequested( 
						new Boolean( itinerary.getSearchCriteria().getVehiclesRequest().isVehicleRequested() ) );
				}
				if( itinerary.getSearchCriteria().getDepartureDate() != null ){
					hotelsPriceItineraryRequest.setDepartureDate( 
						XMLGregorianCalendarConversionUtil.asXMLGregorianCalendar(itinerary.getSearchCriteria().getDepartureDate() ));
				}
				if( (itinerary.getSearchCriteria().getDestinationOptions() != null) &&
					(itinerary.getSearchCriteria().getDestinationOptions().size() > 0)){
					hotelsPriceItineraryRequest.setDestination( 
						itinerary.getSearchCriteria().getDestinationOptions().get(0).getDestination() );
					
					hotelsPriceItineraryRequest.setNoOfNights( 
							itinerary.getSearchCriteria().getDestinationOptions().get(0).getNoOfNights() );
				}
				hotelsPriceItineraryRequest.setGateway( itinerary.getSearchCriteria().getGateway() );
				if( itinerary.getSearchCriteria().getHotelsRequest() != null ){
					hotelsPriceItineraryRequest.setHotelRequested( 
						new Boolean( itinerary.getSearchCriteria().getHotelsRequest().isHotelRequested() ));
				}
				if( itinerary.getSearchCriteria().getFlightRequest() != null ){
					hotelsPriceItineraryRequest.setAirRequested( 
						new Boolean(itinerary.getSearchCriteria().getFlightRequest().isAirRequested()));
				}
			}
		}
		
		return hotelsPriceItineraryRequest;
	}
	
	/**
	 * Method to prepare InsuranceGuestAllocation
	 * @param insuranceGuestAllocation
	 * @return req
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insuranceguestallocation.v1.InsuranceGuestAllocation getInsuranceGuestAllocationReq(InsuranceGuestAllocation insuranceGuestAllocation){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insuranceguestallocation.v1.InsuranceGuestAllocation req =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insuranceguestallocation.v1.InsuranceGuestAllocation();
		
		req.setGuestID( insuranceGuestAllocation.getGuestID() );
		req.setPosnr( insuranceGuestAllocation.getPosnr() );
		req.setOldPosnr( insuranceGuestAllocation.getOldPosnr() );
		req.setPrice( new Double(insuranceGuestAllocation.getPrice()) );
		
		return req;
	}
	
	/**
	 * Method to prepare VehicleOptions
	 * @param vehicleOptions
	 * @return vehicleOptionsReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vehicleoptions.v1.VehicleOptions 
							getVehicleOptionsReq( VehicleOptions vehicleOptions ){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vehicleoptions.v1.VehicleOptions vehicleOptionsReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vehicleoptions.v1.VehicleOptions();
		
		vehicleOptionsReq.setPickupLocation( vehicleOptions.getPickupLocation() );
		vehicleOptionsReq.setDropoffLocation( vehicleOptions.getDropoffLocation() );
		vehicleOptionsReq.setVendorCode( vehicleOptions.getVendorCode() );
		vehicleOptionsReq.setVehicleClass( vehicleOptions.getVehicleClass() );
		if( vehicleOptions.getPickupDateTime() != null ){
			vehicleOptionsReq.setPickupDateTime( this.getDate( vehicleOptions.getPickupDateTime() ) );
		}
		if( vehicleOptions.getDropoffDateTime() != null ){
			vehicleOptionsReq.setDropoffDateTime( this.getDate( vehicleOptions.getDropoffDateTime() ) );
		}
		
		return vehicleOptionsReq;
	}
	
	/**
	 * Method to prepare DestinationOptions BO
	 * @param destinationOptions
	 * @return req
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destinationoptions.v1.DestinationOptions 
													getDestinationOptionsReq(DestinationOptions destinationOptions){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destinationoptions.v1.DestinationOptions req =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destinationoptions.v1.DestinationOptions();
		
		req.setDestination( destinationOptions.getDestination() );
		req.setDestinationId( new Integer( destinationOptions.getDestinationId() ) );
		req.setNoOfNights( new Short( destinationOptions.getNoOfNights() ));
		req.setAirRequested( new Boolean( destinationOptions.isAirRequested() ) );
		req.setHotelRequested( new Boolean( destinationOptions.isHotelRequested() ) );
		req.setVehicleRequested( new Boolean( destinationOptions.isVehicleRequested() ) );
		req.setNearbyAirportIndicator( new Boolean( destinationOptions.isNearbyAirportIndicator() ) );
		req.setFlexiDateIndicator( new Boolean( destinationOptions.isFlexiDateIndicator() ) );
		req.setCharterOnly( new Boolean( destinationOptions.isCharterOnly() ) );
		req.setSkedOnly( new Boolean( destinationOptions.isSkedOnly() ) );
		req.setNonStopFlights( new Boolean( destinationOptions.getNonStopFlights() ) );
		req.setDoubleConnections( new Boolean( destinationOptions.getDoubleConnections() ) );
		req.setMultiCarrierFlights( new Boolean( destinationOptions.getMultiCarrierFlights() ) );
		req.setNoOfAirOptions( new Byte( destinationOptions.getNoOfAirOptions() ) );
		req.setAlternateGatewayMiles( new Integer( destinationOptions.getAlternateGatewayMiles() ));
		if( destinationOptions.getOutboundAirOptions() != null ){
			req.setOutboundAirOptions( this.getAirOptionsReq( destinationOptions.getOutboundAirOptions() ) );
		}
		if( destinationOptions.getInboundAirOptions() != null ){
			req.setInboundAirOptions( this.getAirOptionsReq( destinationOptions.getInboundAirOptions() ) );
		}
		if( destinationOptions.getHotelOptions() != null ){
			req.setHotelOptions( this.getHotelOptionsReq( destinationOptions.getHotelOptions() ) );
		}
		if( destinationOptions.getSpecialOptions() != null ){
			req.setSpecialOptions( this.getSpecialOptionsReq( destinationOptions.getSpecialOptions() ) );
		}
		if( destinationOptions.getVehicleOptions() != null ){
			req.setVehicleOptions( this.getVehicleOptionsReq( destinationOptions.getVehicleOptions() ) );
		}
		if( (destinationOptions.getPreferredCarriersList() != null) && (destinationOptions.getPreferredCarriersList().size() > 0) ){
			for(int i=0; i < destinationOptions.getPreferredCarriersList().size(); i++){
				req.getPreferredCarriersList().add( this.getCarrierReq( destinationOptions.getPreferredCarriersList().get(i) ) );
			}
		}
		if( (destinationOptions.getNearByDestinations() != null) && (destinationOptions.getNearByDestinations().size() > 0) ){
			req.getNearByDestinations().addAll( destinationOptions.getNearByDestinations() );
		}
		
		return req;
	}
	
	/**
	 * Method to prepare SearchCriteria 
	 * @param searchCriteria
	 * @return searchCriteriaReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.searchcriteria.v1.SearchCriteria 
										getSearchCriteriaReq(SearchCriteria searchCriteria){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.searchcriteria.v1.SearchCriteria searchCriteriaReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.searchcriteria.v1.SearchCriteria();
		
		searchCriteriaReq.setGateway( searchCriteria.getGateway() );
		searchCriteriaReq.setPromoCode( searchCriteria.getPromoCode() );
		searchCriteriaReq.setAnchorGateway( searchCriteria.getAnchorGateway() );
		searchCriteriaReq.setBookingNo( searchCriteria.getBookingNo() );
		searchCriteriaReq.setFilterSpecials( new Boolean( searchCriteria.isFilterSpecials() ));
		if( searchCriteria.getDepartureDate() != null ){
			searchCriteriaReq.setDepartureDate( this.getDate( searchCriteria.getDepartureDate() ));
		}
		if( searchCriteria.getAnchorDepartureDate() != null ){
			searchCriteriaReq.setAnchorDepartureDate( this.getDate( searchCriteria.getAnchorDepartureDate() ) );
		}
		if( searchCriteria.getFlightTripType() != null ){
			searchCriteriaReq.setFlightTripType( this.getFlightTripTypeReq( searchCriteria.getFlightTripType() ) );
		}
		if( searchCriteria.getOccupancy() != null ){
			searchCriteriaReq.setOccupancy( this.getOccupancyReq( searchCriteria.getOccupancy() ) );
		}
		if( (searchCriteria.getDestinationOptions() != null) && (searchCriteria.getDestinationOptions().size() > 0) ){
			for(int i=0; i < searchCriteria.getDestinationOptions().size(); i++){
				searchCriteriaReq.getDestinationOptions().add( this.getDestinationOptionsReq( searchCriteria.getDestinationOptions().get(i) ) );
			}
		}
		if( (searchCriteria.getNearByGateways() != null) && (searchCriteria.getNearByGateways().size() > 0) ){
			searchCriteriaReq.getNearByGateways().addAll( searchCriteria.getNearByGateways() );
		}
		
		return searchCriteriaReq;
	}
	
	/**
	 * Method to prepare Itinerary BO
	 * @param itinerary
	 * @return itineraryReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary getItineraryReq(Itinerary itinerary){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary itineraryReq = 
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary();
		
		itineraryReq.setBookingNo( itinerary.getBookingNo() );
		itineraryReq.setName( itinerary.getName() );
		itineraryReq.setQuoteNo( itinerary.getQuoteNo() );
		itineraryReq.setAllowEdocs( new Boolean(itinerary.isAllowEdocs()) );
		itineraryReq.setTabUpdated( new Boolean(itinerary.isTabUpdated()) );
		itineraryReq.setBookingCancelled( new Boolean(itinerary.isBookingCancelled()) );
		itineraryReq.setAllowBPG( new Boolean(itinerary.isAllowBPG()) );
		if( itinerary.getExtendOptionDate() != null ){
			itineraryReq.setExtendOptionDate( this.getDate( itinerary.getExtendOptionDate() ));
		}
		itineraryReq.setNeedToResync( new Boolean(itinerary.isNeedToResync()) );
		if( itinerary.getPaymentInformation() != null ){
			itineraryReq.setPaymentInformation( this.getPaymentInformationReq( itinerary.getPaymentInformation() ) );
		}
		if( itinerary.getRfaRequest() != null ){
			itineraryReq.setRfaRequest( this.getRFARequestReq( itinerary.getRfaRequest() ) );
		}
		if( itinerary.getImApplicationInfo() != null ){
			itineraryReq.setImApplicationInfo( this.getIMApplicationInfoReq(itinerary.getImApplicationInfo()) );
		}
		if( itinerary.getBookingHeader() != null ){
			itineraryReq.setBookingHeader( this.getBookingHeaderReq(itinerary.getBookingHeader()) );
		}
		if( itinerary.getItineraryPrice() != null ){
			itineraryReq.setItineraryPrice( this.getItineraryPriceReq(itinerary.getItineraryPrice()) );
		}
		
		if( itinerary.getSearchCriteria() != null ){
			itineraryReq.setSearchCriteria( this.getSearchCriteriaReq( itinerary.getSearchCriteria() ) );
		}
		if( itinerary.getShippingAddress() != null ){
			itineraryReq.setShippingAddress( this.getAddressReq(itinerary.getShippingAddress()) );
		}
		if( itinerary.getMaxOccupancy() != null ){
			itineraryReq.setMaxOccupancy( this.getOccupancyReq(itinerary.getMaxOccupancy()) );
		}
		if( itinerary.getTransferInfo() != null ){
			itineraryReq.setTransferInfo( this.getOpsAlertReq(itinerary.getTransferInfo()) );
		}
		if( itinerary.getBookingLockDetails() != null ){
			itineraryReq.setBookingLockDetails( this.getBookingLockDetailsReq( itinerary.getBookingLockDetails() ) );
		}
		if( (itinerary.getNotices() != null) && (itinerary.getNotices().size() > 0) ){
			for(int i=0; i < itinerary.getNotices().size(); i++){
				itineraryReq.getNotices().add( this.getAlertReq( itinerary.getNotices().get(i) ) );
			}
		}
		if( itinerary.getCancellationRules() != null ){
			itineraryReq.setCancellationRules( this.getItineraryCancellationRulesReq( itinerary.getCancellationRules() ) );
		}
		if( (itinerary.getFlights() != null) && (itinerary.getFlights().size() > 0) ){
			for(int i=0; i < itinerary.getFlights().size(); i++){
				itineraryReq.getFlights().add( this.getTripFlightReq( itinerary.getFlights().get(i) ) );
			}
		}
		if( (itinerary.getHotels() != null) && (itinerary.getHotels().size() > 0) ){
			for(int i=0; i < itinerary.getHotels().size(); i++){
				itineraryReq.getHotels().add( this.getHotelReq(itinerary.getHotels().get(i)) );
			}
		}
		
		
		if( (itinerary.getGuests() != null) && (itinerary.getGuests().size() > 0) ){
			for(int i=0; i < itinerary.getGuests().size(); i++){
				itineraryReq.getGuests().add( this.getGuestInfoReq(itinerary.getGuests().get(i)) );
			}
		}
		if( (itinerary.getInsurances() != null) && (itinerary.getInsurances().size() > 0) ){
			for(int i=0; i < itinerary.getInsurances().size(); i++){
				itineraryReq.getInsurances().add( this.getInsuranceReq(itinerary.getInsurances().get(i)) );
			}
		}
		if( (itinerary.getOpsAlerts() != null) && (itinerary.getOpsAlerts().size() > 0) ){
			for(int i=0; i < itinerary.getOpsAlerts().size(); i++){
				itineraryReq.getOpsAlerts().add( this.getOpsAlertReq(itinerary.getOpsAlerts().get(i)) );
			}
		}
		if( (itinerary.getItineraryCharges() != null) && (itinerary.getItineraryCharges().size() > 0) ){
			for(int i=0; i < itinerary.getItineraryCharges().size(); i++){
				itineraryReq.getItineraryCharges().add( this.getItineraryChargeReq(itinerary.getItineraryCharges().get(i)) );
			}
		}
		if( (itinerary.getVehicles() != null) && (itinerary.getVehicles().size() > 0) ){
			for(int i=0; i < itinerary.getVehicles().size(); i++){
				itineraryReq.getVehicles().add( this.getVehicleReq(itinerary.getVehicles().get(i)) );
			}
		}
		if( (itinerary.getPackages() != null) && (itinerary.getPackages().size() > 0) ){
			for(int i=0; i < itinerary.getPackages().size(); i++){
				itineraryReq.getPackages().add( this.getPackageObjReq(itinerary.getPackages().get(i)) );
			}
		}
		if( (itinerary.getMultiDestinationPackages() != null) && (itinerary.getMultiDestinationPackages().size() > 0) ){
			for(int i=0; i < itinerary.getMultiDestinationPackages().size(); i++){
				itineraryReq.getMultiDestinationPackages().add( this.getMultiDestinationPackageReq(itinerary.getMultiDestinationPackages().get(i)) );
			}
		}
		if( (itinerary.getServices() != null) && (itinerary.getServices().size() > 0) ){
			for(int i=0; i < itinerary.getServices().size(); i++){
				itineraryReq.getServices().add( this.getServiceReq(itinerary.getServices().get(i)) );
			}
		}
		
		//Prepare deleted list
		if( (itinerary.getDeletedList() != null) && (itinerary.getDeletedList().size() > 0) ){
			List<DeletedList> deletedList = new ArrayList<DeletedList>();
			DeletedList deletedListBO = new DeletedList();
			for(int i=0; i < itinerary.getDeletedList().size(); i++){
				
				
				//itineraryReq.getDeletedList().add( this.getDeletedObject(itinerary.getDeletedList().get(i)) );
				if(itinerary.getDeletedList()!=null)
				{
				if(itinerary.getDeletedList().get(i)!=null && itinerary.getDeletedList().get(i) instanceof Hotel)
				{
					
					List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel> hotelListBO = 
						(List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel>)this.getDeletedObject(itinerary.getDeletedList().get(i));

					if(hotelListBO!=null && hotelListBO.size()>0)
					{
						for(int j=0;j<hotelListBO.size();j++)
						{
							deletedListBO.getHotelList().add(j, hotelListBO.get(j));
						}
					}
					
				}
				if(itinerary.getDeletedList().get(i)!=null && itinerary.getDeletedList().get(i) instanceof Service)
				{
					List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service> serviceListBO = 
						(List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service>)this.getDeletedObject(itinerary.getDeletedList().get(i));
					
					if(serviceListBO!=null && serviceListBO.size()>0)
					{
						for(int j=0;j<serviceListBO.size();j++)
						{
							deletedListBO.getServiceList().add(j, serviceListBO.get(j));
						}
					}
				}
				
				if(itinerary.getDeletedList().get(i)!=null && itinerary.getDeletedList().get(i) instanceof Insurance)
				{
					List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance> insuranceListBO =
						(List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance>)this.getDeletedObject(itinerary.getDeletedList().get(i));
					if(insuranceListBO!=null && insuranceListBO.size()>0)
					{
						for(int j=0;j<insuranceListBO.size();j++)
						{
							deletedListBO.getInsuranceList().add(j, insuranceListBO.get(j));
						}
					}
				}
				
				}
				
				
				
			}
			
		if(deletedListBO!=null)
		{
			itineraryReq.getDeletedList().add(deletedListBO);
		}
			
			
		}
		
		return itineraryReq;
	}
	
	
	/**
	 * Prepare deleted Object BO
	 * @param ABEDto
	 * @return Object
	 */
	public Object getDeletedObject(ABEDto object)
	{
		//Send this as return object when input object is null
		Object obj = new Object();
		 if (object instanceof Hotel) {
			 List<Hotel> hotelsList = new ArrayList<Hotel>();
			 com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel hotelBO = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel();
			 List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel> hotelListBO = new ArrayList<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel>();
				hotelsList.add((Hotel) object);
				if(hotelsList!=null && hotelsList.size()>0)
				{
					for(int i=0;i<hotelsList.size();i++)
					{
						if(hotelsList.get(i)!=null)
						{
						hotelBO = this.getHotelReq(hotelsList.get(i));
						hotelListBO.add(hotelBO);
						}
					}
					
				}
				return hotelListBO;
		 }
		 
		 else if(object instanceof Service)
		 {
			 List<Service> servicesList = new ArrayList<Service>();
			 com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service serviceBO = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service();
			 List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service> serviceListBO = new ArrayList<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service>();
			 servicesList.add((Service) object); 
				if(servicesList!=null && servicesList.size()>0)
				{
					for(int i=0;i<servicesList.size();i++)
					{
						if(servicesList.get(i)!=null)
						{
							serviceBO = this.getServiceReq(servicesList.get(i));
							serviceListBO.add(serviceBO);
						}
					}
					
				}
				return serviceListBO;
		 }
		 
		 else if(object instanceof Insurance)
		 {
			 List<Insurance> insuranceList = new ArrayList<Insurance>();
				insuranceList.add((Insurance) object);
				
			com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance insuranceBO = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance();
			List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance> insuranceListBO = new ArrayList<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance>();
			if(insuranceList!=null && insuranceList.size()>0)
			{
				for(int i=0;i<insuranceList.size();i++)
				{
					if(insuranceList.get(i)!=null)
					{
						insuranceBO = this.getInsuranceReq(insuranceList.get(i));
						insuranceListBO.add(insuranceBO);
					}
				}
				
			}
			return insuranceListBO;
		 }
	return obj;	
	}
	
	/**
	 * method to cast the object to ABEDto 
	 * @param object
	 * @return abeDto
	 */
	public ABEDto getABEDto(Object object){
		
			
		if(object instanceof com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel)
		{

			com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel hotelBo = (com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel)object;
			Hotel hotelDto = this.getHotel(hotelBo);
			if(hotelDto!=null)
			{
				ABEDto abeDto = (ABEDto) hotelDto;
				return abeDto;
			}
		}
		if(object instanceof com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service)
		{
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service serviceBo = (com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service)object;
		Service serviceDto = this.getService(serviceBo);
		if(serviceDto!=null)
		{
			ABEDto abeDto = (ABEDto)serviceDto;
			return abeDto;
		}
		}
		if(object instanceof com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance)
		{
			com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance insuranceBO = (com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance)object;
			Insurance insuranceDto =this.getInsurance(insuranceBO);
			if(insuranceBO!=null)
			{
				ABEDto abeDto = (ABEDto)insuranceDto;
				return abeDto;
			}
		
		}
		
		return null;
	}
	
	/**
	 * Method to prepare Itinerary DTO
	 * @param res
	 * @return itinerary
	 */
	public Itinerary getItinerary(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary res){
		Itinerary itinerary = new Itinerary();
		
		itinerary.setBookingNo( res.getBookingNo() );
		itinerary.setName( res.getName() );
		itinerary.setQuoteNo( res.getQuoteNo() );
		if( res.isAllowEdocs() != null ){
			itinerary.setAllowEdocs( res.isAllowEdocs().booleanValue() );
		}
		if( res.isTabUpdated() != null ){
			itinerary.setTabUpdated( res.isTabUpdated().booleanValue() );
		}
		if( res.isBookingCancelled() != null ){
			itinerary.setBookingCancelled( res.isBookingCancelled().booleanValue() );
		}
		if( res.isAllowBPG() != null ){
			itinerary.setAllowBPG( res.isAllowBPG().booleanValue() );
		}
		if( res.isNeedToResync() != null ){
			itinerary.setNeedToResync( res.isNeedToResync().booleanValue() );
		}
		if( res.getExtendOptionDate() != null ){
			itinerary.setExtendOptionDate( this.getDate( res.getExtendOptionDate() ) );
		}
		if( res.getBookingLockDetails() != null ){
			itinerary.setBookingLockDetails( this.getBookingLockDetails( res.getBookingLockDetails() ) );
		}
		if( res.getCancellationRules() != null ){
			itinerary.setCancellationRules( this.getItineraryCancellationRules( res.getCancellationRules() ) );
		}
		if( res.getImApplicationInfo() != null ){
			itinerary.setImApplicationInfo( this.getIMApplicationInfo( res.getImApplicationInfo() ) );
		}
		if( res.getBookingHeader() != null ){
			itinerary.setBookingHeader( this.getBookingHeader( res.getBookingHeader() ));
		}
		if( res.getItineraryPrice() != null ){
			itinerary.setItineraryPrice( this.getItineraryPrice( res.getItineraryPrice() ) );
		}
		if( res.getShippingAddress() != null ){
			itinerary.setShippingAddress( this.getAddress( res.getShippingAddress() ) );
		}
		if( res.getPaymentInformation() != null ){
			itinerary.setPaymentInformation( this.getPaymentInformation( res.getPaymentInformation() ) );
		}
		if( res.getMaxOccupancy() != null ){
			itinerary.setMaxOccupancy( this.getOccupancy( res.getMaxOccupancy() ) );
		}
		if( res.getTransferInfo() != null ){
			itinerary.setTransferInfo( this.getOpsAlert( res.getTransferInfo() ) );
		}
		if( res.getRfaRequest() != null ){
			itinerary.setRfaRequest( this.getRFARequest( res.getRfaRequest() ) );
		}
		if( (res.getNotices() != null) && (res.getNotices().size() > 0) ){
			List<Alert> notices = new ArrayList<Alert>();
			for(int i=0; i < res.getNotices().size(); i++){
				if( res.getNotices().get(i) != null ){
					notices.add( this.getAlert( res.getNotices().get(i) ) );
				}
			}
			itinerary.setNotices(notices);
		}
		if( (res.getFlights() != null) && (res.getFlights().size() > 0) ){
			List<TripFlight> flights = new ArrayList<TripFlight>();
			for(int i=0; i < res.getFlights().size(); i++){
				if( res.getFlights().get(i) != null ){
					flights.add( this.getTripFlight( res.getFlights().get(i) ) );
				}
			}
			itinerary.setFlights(flights);
		}
		if( (res.getHotels() != null) && (res.getHotels().size() > 0) ){
			List<Hotel> hotels = new ArrayList<Hotel>();
			for(int i=0; i < res.getHotels().size(); i++){
				if( res.getHotels().get(i) != null ){
					hotels.add( this.getHotel( res.getHotels().get(i) ) );
				}
			}
			itinerary.setHotels(hotels);
		}
		if( (res.getGuests() != null) && (res.getGuests().size() > 0) ){
			List<GuestInfo> guests = new ArrayList<GuestInfo>();
			for(int i=0; i < res.getGuests().size(); i++){
				if( res.getGuests().get(i) != null ){
					guests.add( this.getGuestInfo( res.getGuests().get(i) ) );
				}
			}
			itinerary.setGuests(guests);
		}
		if( (res.getInsurances() != null) && (res.getInsurances().size() > 0) ){
			List<Insurance> insurances = new ArrayList<Insurance>();
			for(int i=0; i < res.getInsurances().size(); i++){
				if( res.getInsurances().get(i) != null ){
					insurances.add( this.getInsurance( res.getInsurances().get(i) ) );
				}
			}
			itinerary.setInsurances(insurances);
		}
		if( (res.getOpsAlerts() != null) && (res.getOpsAlerts().size() > 0) ){
			List<OpsAlert> opsAlerts = new ArrayList<OpsAlert>();
			for(int i=0; i < res.getOpsAlerts().size(); i++){
				if( res.getOpsAlerts().get(i) != null ){
					opsAlerts.add( this.getOpsAlert( res.getOpsAlerts().get(i) ) );
				}
			}
			itinerary.setOpsAlerts(opsAlerts);
		}
		if( (res.getItineraryCharges() != null) && (res.getItineraryCharges().size() > 0) ){
			List<ItineraryCharge> itineraryCharges = new ArrayList<ItineraryCharge>();
			for(int i=0; i < res.getItineraryCharges().size(); i++){
				if( res.getItineraryCharges().get(i) != null ){
					if( res.getItineraryCharges().get(i) != null ){
						itineraryCharges.add( this.getItineraryCharge( res.getItineraryCharges().get(i) ) );
					}
				}
			}
			itinerary.setItineraryCharges(itineraryCharges);
		}
		if( (res.getVehicles() != null) && (res.getVehicles().size() > 0) ){
			List<Vehicle> vehicles = new ArrayList<Vehicle>();
			for(int i=0; i < res.getVehicles().size(); i++){
				if( res.getVehicles().get(i) != null ){
					vehicles.add( this.getVehicle( res.getVehicles().get(i) ) );
				}
			}
			itinerary.setVehicles(vehicles);
		}
		if( (res.getPackages() != null) && (res.getPackages().size() > 0) ){
			List<Package> packages = new ArrayList<Package>();
			for(int i=0; i < res.getPackages().size(); i++){
				if( res.getPackages().get(i) != null ){
				packages.add( this.getPackage( res.getPackages().get(i) ) );
				}
			}
			itinerary.setPackages(packages);
		}
		if( (res.getServices() != null) && (res.getServices().size() > 0) ){
			List<Service> services = new ArrayList<Service>();
			for(int i=0; i < res.getServices().size(); i++){
				if( res.getServices().get(i) != null ){
				services.add( this.getService( res.getServices().get(i) ) );
				}
			}
			itinerary.setServices(services);
		}
		if( (res.getMultiDestinationPackages() != null) && (res.getMultiDestinationPackages().size() > 0) ){
			List<MultiDestinationPackage> multiDestinationPackages = new ArrayList<MultiDestinationPackage>();
			for(int i=0; i < res.getMultiDestinationPackages().size(); i++){
				if( res.getMultiDestinationPackages().get(i) != null ){
				multiDestinationPackages.add( this.getMultiDestinationPackage( res.getMultiDestinationPackages().get(i) ) );
				}
			}
			itinerary.setMultiDestinationPackages(multiDestinationPackages);
		}
		if( (res.getDeletedList() != null) && (res.getDeletedList().size() > 0) ){
			List<ABEDto> deletedList = new ArrayList<ABEDto>();
			for(int i=0; i < res.getDeletedList().size(); i++){
				if( res.getDeletedList().get(i) != null ){
					//deletedList.add( this.getABEDto( res.getDeletedList().get(i) ) );
					DeletedList deletedListBO = (DeletedList)res.getDeletedList().get(i);
					
					if(deletedListBO!=null)
					{
					if( deletedListBO.getHotelList()!=null && deletedListBO.getHotelList().size()>0)
					{
						for(int k=0;k<deletedListBO.getHotelList().size();k++)
						{
						ABEDto abeDto = getABEDto(deletedListBO.getHotelList().get(k));
						if(abeDto!=null)
							deletedList.add(abeDto);
						}
					}
					if(deletedListBO.getServiceList()!=null && deletedListBO.getServiceList().size()>0)
					{
						for(int k=0;k<deletedListBO.getServiceList().size();k++)
						{
							ABEDto abeDto  = getABEDto(deletedListBO.getServiceList().get(k));
							if(abeDto!=null)
								deletedList.add(abeDto);
						}
					}
					if(deletedListBO.getInsuranceList()!=null && deletedListBO.getInsuranceList().size()>0)
					{
						for(int k=0;k<deletedListBO.getInsuranceList().size();k++)
						{
							ABEDto abeDto = getABEDto(deletedListBO.getInsuranceList().get(k));
							if(abeDto!=null)
								deletedList.add(abeDto);
						}
					}
					}
									
				}
			}
			itinerary.setDeletedList(deletedList);
		}
		
		return itinerary;
	}
	
	/**
	 * Method to prepare  ItineraryCharge DTO from BO
	 * @param res
	 * @return itineraryCharge
	 */
	public ItineraryCharge getItineraryCharge(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerarycharge.v1.ItineraryCharge res){
		ItineraryCharge itineraryCharge = new ItineraryCharge();
		
		itineraryCharge.setCode( res.getCode() );
		itineraryCharge.setDescription( res.getDescription() );
		itineraryCharge.setUnitsOfMeasure( res.getUnitsOfMeasure() );
		if( res.getQuantity() != null ){
			itineraryCharge.setQuantity( res.getQuantity().doubleValue() );
		}
		if( res.getPrice() != null ){
			itineraryCharge.setPrice( res.getPrice().doubleValue() );
		}
		
		return itineraryCharge;
	}
	/**
	 * method to prepare ItineraryCancellationRules DTO from BO
	 * @param res
	 * @return rules
	 */
	public ItineraryCancellationRules getItineraryCancellationRules(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerarycancellationrules.v1.ItineraryCancellationRules res){
		
		ItineraryCancellationRules rules = new ItineraryCancellationRules();
		rules.setSkedInfoRules( res.getSkedInfoRules() );
		
		return rules;
	}
	
	/**
	 * method to prepare ItineraryCharge BO
	 * @param itineraryCharge
	 * @return itineraryChargeReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerarycharge.v1.ItineraryCharge getItineraryChargeReq(ItineraryCharge itineraryCharge){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerarycharge.v1.ItineraryCharge itineraryChargeReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerarycharge.v1.ItineraryCharge();
		
		itineraryChargeReq.setCode( itineraryCharge.getCode() );
		itineraryChargeReq.setDescription( itineraryCharge.getDescription() );
		itineraryChargeReq.setQuantity( new Double( itineraryCharge.getQuantity() ));
		itineraryChargeReq.setUnitsOfMeasure( itineraryCharge.getUnitsOfMeasure() );
		itineraryChargeReq.setPrice( new Double(itineraryCharge.getPrice()) );
		
		return itineraryChargeReq;
	}
	
	/**
	 * Method to prepare GuaranteedCheck BO
	 * @param guaranteedCheck
	 * @return guaranteedCheckReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guaranteedcheck.v1.GuaranteedCheck getGuaranteedCheckReq(GuaranteedCheck guaranteedCheck){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guaranteedcheck.v1.GuaranteedCheck guaranteedCheckReq = 
		new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guaranteedcheck.v1.GuaranteedCheck();
		
		guaranteedCheckReq.setCheckNo( guaranteedCheck.getCheckNo() );
		guaranteedCheckReq.setPromisedAmount( new Double( guaranteedCheck.getPromisedAmount()) );
		guaranteedCheckReq.setRemarks( guaranteedCheck.getRemarks() );
		
		return guaranteedCheckReq;
	}
	
	/**
	 * Method to prepare GuestPriceBreakup BO
	 * @param guestPriceBreakup
	 * @return guestPriceBreakupReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guestpricebreakup.v1.GuestPriceBreakup getGuestPriceBreakupReq(GuestPriceBreakup guestPriceBreakup){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guestpricebreakup.v1.GuestPriceBreakup guestPriceBreakupReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guestpricebreakup.v1.GuestPriceBreakup();
		
		guestPriceBreakupReq.setFlightPrice( new Double(guestPriceBreakup.getFlightPrice()) );
		guestPriceBreakupReq.setHotelPrice( new Double(guestPriceBreakup.getHotelPrice()) );
		guestPriceBreakupReq.setVehiclePrice( new Double(guestPriceBreakup.getVehiclePrice()) );
		guestPriceBreakupReq.setInsurancePrice( new Double(guestPriceBreakup.getInsurancePrice()) );
		guestPriceBreakupReq.setSupplementsPrice( new Double(guestPriceBreakup.getSupplementsPrice()) );
		guestPriceBreakupReq.setTaxPrice( new Double(guestPriceBreakup.getTaxPrice()) );
		guestPriceBreakupReq.setFees( new Double(guestPriceBreakup.getFees()) );
		guestPriceBreakupReq.setServicePrice( new Double(guestPriceBreakup.getServicePrice()) );
		guestPriceBreakupReq.setTotalPrice( new Double(guestPriceBreakup.getTotalPrice()) );
		guestPriceBreakupReq.setBasePrice( new Double(guestPriceBreakup.getBasePrice()) );
		
		return guestPriceBreakupReq;
	}
	
	/**
	 * Method to prepare GuestPriceBreakup DTO from BO
	 * @param res
	 * @return guestPriceBreakup
	 */
	public GuestPriceBreakup getGuestPriceBreakup(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guestpricebreakup.v1.GuestPriceBreakup res){
		GuestPriceBreakup guestPriceBreakup = new GuestPriceBreakup();
		
/*		guestPriceBreakup.setFlightPrice( res.getFlightPrice() );
		guestPriceBreakup.setHotelPrice( res.getHotelPrice() );
		guestPriceBreakup.setVehiclePrice( res.getVehiclePrice() );
		guestPriceBreakup.setInsurancePrice( res.getInsurancePrice() );
		guestPriceBreakup.setSupplementsPrice( res.getSupplementsPrice() );
		guestPriceBreakup.setTaxPrice( res.getTaxPrice() );
		guestPriceBreakup.setFees( res.getFees() );
		guestPriceBreakup.setServicePrice( res.getServicePrice() );
		guestPriceBreakup.setTotalPrice( res.getTotalPrice() );
		guestPriceBreakup.setBasePrice( res.getBasePrice());*/
		
			if(res.getFlightPrice()!=null)
			guestPriceBreakup.setFlightPrice( res.getFlightPrice().doubleValue() );
			if(res.getHotelPrice()!=null)
			guestPriceBreakup.setHotelPrice( res.getHotelPrice().doubleValue() );
			if(res.getVehiclePrice()!=null)
			guestPriceBreakup.setVehiclePrice( res.getVehiclePrice().doubleValue() );
			if(res.getInsurancePrice()!=null)
			guestPriceBreakup.setInsurancePrice( res.getInsurancePrice().doubleValue() );
			if(res.getSupplementsPrice()!=null)
			guestPriceBreakup.setSupplementsPrice( res.getSupplementsPrice().doubleValue() );
			if(res.getTaxPrice()!=null)
			guestPriceBreakup.setTaxPrice( res.getTaxPrice().doubleValue() );
			if(res.getFees()!=null)
			guestPriceBreakup.setFees( res.getFees().doubleValue() );
			if(res.getServicePrice()!=null)
			guestPriceBreakup.setServicePrice( res.getServicePrice().doubleValue() );
			if(res.getTotalPrice()!=null)
			guestPriceBreakup.setTotalPrice( res.getTotalPrice().doubleValue() );
			if(res.getBasePrice()!=null)
			guestPriceBreakup.setBasePrice( res.getBasePrice().doubleValue());
		
		return guestPriceBreakup;
	}
	
	/**
	 * Method to prepare GuestInfo
	 * @param guestInfo
	 * @return guestInfoReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guestinfo.v1.GuestInfo getGuestInfoReq(GuestInfo guestInfo){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guestinfo.v1.GuestInfo guestInfoReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guestinfo.v1.GuestInfo();
		
		guestInfoReq.setSelectedFlag( guestInfo.getSelectedFlag() );
		guestInfoReq.setGuestId( guestInfo.getGuestId() );
		guestInfoReq.setAge( new Byte(guestInfo.getAge()) );
		guestInfoReq.setLapChild( new Boolean(guestInfo.isLapChild()) );
		guestInfoReq.setTitle( guestInfo.getTitle() );
		guestInfoReq.setFirstName( guestInfo.getFirstName() );
		guestInfoReq.setMiddleName( guestInfo.getMiddleName() );
		guestInfoReq.setLastName( guestInfo.getLastName() );
		guestInfoReq.setGender( guestInfo.getGender() );
		guestInfoReq.setPhoneNumber( guestInfo.getPhoneNumber() );
		guestInfoReq.setEmailId( guestInfo.getEmailId() );
		if((guestInfo.getAgeCode().getPaxTypeCode()=='I'||guestInfo.getAgeCode().getPaxTypeCode()=='L')
				&&(guestInfo.getParentGuestId()==null || guestInfo.getParentGuestId().equals(""))){
			guestInfoReq.setParentGuestId("1");
		}else{
			guestInfoReq.setParentGuestId( guestInfo.getParentGuestId() );
		}
		guestInfoReq.setEmergencyContactName( guestInfo.getEmergencyContactName() );
		guestInfoReq.setEmergencyContactPhone( guestInfo.getEmergencyContactPhone() );
		guestInfoReq.setFrequentFlyerNo( guestInfo.getFrequentFlyerNo() );
		guestInfoReq.setAirRemarks( guestInfo.getAirRemarks() );
		guestInfoReq.setHotelRemarks( guestInfo.getHotelRemarks() );
		guestInfoReq.setCruiseRemarks( guestInfo.getCruiseRemarks() );
		guestInfoReq.setMealRequest( guestInfo.getMealRequest() );
		guestInfoReq.setAirRequest( guestInfo.getAirRequest() );
		guestInfoReq.setGroundRequest( guestInfo.getGroundRequest() );
		guestInfoReq.setCateringRequest( guestInfo.getCateringRequest() );
		guestInfoReq.setSeatPreference( guestInfo.getSeatPreference() );
		guestInfoReq.setPnrNumber( guestInfo.getPnrNumber() );
		guestInfoReq.setStatus( guestInfo.getStatus() );
		guestInfoReq.setRedressNumber( guestInfo.getRedressNumber() );
		guestInfoReq.setChangeType( guestInfo.getChangeType() );
		guestInfoReq.setOldPaxId( guestInfo.getOldPaxId() );
		guestInfoReq.setPaxWeight( guestInfo.getPaxWeight() );
		if( guestInfo.getDateOfBirth() != null ){
			guestInfoReq.setDateOfBirth( this.getDate( guestInfo.getDateOfBirth() ) );
		}
		if( guestInfo.getAgeCode() != null ){
			guestInfoReq.setAgeCode( this.getAgeCodeReq(guestInfo.getAgeCode()) );
		}
		if( guestInfo.getPassportInfo() != null ){
			guestInfoReq.setPassportInfo( this.getPassportInfoReq(guestInfo.getPassportInfo()) );
		}
		if( guestInfo.getPriceBreakup() != null ){
			guestInfoReq.setPriceBreakup( this.getGuestPriceBreakupReq(guestInfo.getPriceBreakup()) );
		}
		
		return guestInfoReq;
	}
	
	/**
	 * Method to prepare GuestInfo DTO from BO 
	 * @param res
	 * @return guestInfo
	 */
	public GuestInfo getGuestInfo(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guestinfo.v1.GuestInfo res){
		GuestInfo guestInfo = new GuestInfo();
		
		guestInfo.setSelectedFlag( res.getSelectedFlag() );
		guestInfo.setGuestId( res.getGuestId() );
		guestInfo.setTitle( res.getTitle() );
		guestInfo.setFirstName( res.getFirstName() );
		guestInfo.setMiddleName( res.getMiddleName() );
		guestInfo.setLastName( res.getLastName() );
		guestInfo.setGender( res.getGender() );
		guestInfo.setPhoneNumber( res.getPhoneNumber() );
		guestInfo.setEmailId( res.getEmailId() );
		guestInfo.setParentGuestId( res.getParentGuestId() );
		guestInfo.setEmergencyContactName( res.getEmergencyContactName() );
		//Start the the AV-3749/HBsi 52 Enhancement of emergency info tab for passegner	
		// Map/Setting the emergency contact phone correctly.
		guestInfo.setEmergencyContactPhone( res.getEmergencyContactPhone() );
		//End of the AV-3749/HBsi 52 Enhancement of emergency info tab for passegner	
		guestInfo.setFrequentFlyerNo( res.getFrequentFlyerNo() );
		guestInfo.setAirRemarks( res.getAirRemarks() );
		guestInfo.setHotelRemarks( res.getHotelRemarks() );
		guestInfo.setCruiseRemarks( res.getCruiseRemarks() );
		guestInfo.setMealRequest( res.getMealRequest() );
		guestInfo.setAirRequest( res.getAirRequest() );
		guestInfo.setGroundRequest( res.getGroundRequest() );
		guestInfo.setCateringRequest( res.getCateringRequest() );
		guestInfo.setSeatPreference( res.getSeatPreference() );
		guestInfo.setPnrNumber( res.getPnrNumber() );
		guestInfo.setStatus( res.getStatus() );
		guestInfo.setRedressNumber( res.getRedressNumber() );
		guestInfo.setChangeType( res.getChangeType() );
		guestInfo.setOldPaxId( res.getOldPaxId() );
		guestInfo.setPaxWeight( res.getPaxWeight() );
		if( res.getAge() != null ){
			guestInfo.setAge( res.getAge().byteValue() );
		}
		if( res.isLapChild() != null ){
			guestInfo.setLapChild( res.isLapChild().booleanValue() );
		}
		if( res.getDateOfBirth() != null ){
			guestInfo.setDateOfBirth( this.dateConverterXMLtoUtilBirthDate( res.getDateOfBirth() ) );
		}
		if( (res.getAgeCode() != null) && (res.getAgeCode().getAge() > 0) ){
			guestInfo.setAgeCode( this.getAgeCode( res.getAgeCode() ) );
		}
		if( res.getPassportInfo() !=  null ){
			guestInfo.setPassportInfo( this.getPassportInfo( res.getPassportInfo() ) );
		}
		if( res.getPriceBreakup() != null ){
			guestInfo.setPriceBreakup( this.getGuestPriceBreakup( res.getPriceBreakup() ) );
		}
		
		return guestInfo;
	}
	
	/**
	 * method to prepare GuaranteedCheck DTO from BO
	 * @param res
	 * @return guaranteedCheck
	 */
	
	public GuaranteedCheck getGuaranteedCheck(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guaranteedcheck.v1.GuaranteedCheck res ){
		GuaranteedCheck guaranteedCheck = new GuaranteedCheck();
		
		guaranteedCheck.setCheckNo( res.getCheckNo() );
		guaranteedCheck.setRemarks( res.getRemarks() );
		if( res.getPromisedAmount() != null ){
			guaranteedCheck.setPromisedAmount( res.getPromisedAmount().doubleValue() );
		}
		
		return guaranteedCheck;
	}
	
	/**
	 * method to prepare IMapplicationInfo
	 * @return
	 */
	public IMApplicationInfo getIMApplicationInfo(){
		return this.getApplicationContextFactory().getApplicationContext().getRequestContext().getIMApplicationInfo();
	}
	
	/**
	 * method to prepare IMapplicationInfo
	 * @param res
	 * @return iMApplicationInfo
	 */
	public IMApplicationInfo getIMApplicationInfo(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.imapplicationinfo.v1.IMApplicationInfo res){
		IMApplicationInfo iMApplicationInfo = new IMApplicationInfo();
		
		iMApplicationInfo.setRequestorID( res.getRequestorID() );
		iMApplicationInfo.setContextID( res.getContextID() );
		iMApplicationInfo.setCreatedBy( res.getCreatedBy() );
		iMApplicationInfo.setAgentNumber( res.getAgentNumber() );
		iMApplicationInfo.setPseudoCityCode( res.getPseudoCityCode() );
		iMApplicationInfo.setIsoCountry( res.getIsoCountry() );
		iMApplicationInfo.setIsoCurrency( res.getIsoCurrency()  );
		iMApplicationInfo.setSalesOrg( res.getSalesOrg() );
		iMApplicationInfo.setAgentFirstName( res.getAgentFirstName() );
		iMApplicationInfo.setAgentLastName( res.getAgentLastName() );
		
		if( (res.getType() != null) && (res.getType().getCode() != null) ){
			iMApplicationInfo.setType( this.getUserType( res.getType() ) );
		}
		if( res.getSelectedAgent() != null ){
			iMApplicationInfo.setSelectedAgent( this.getAgent( res.getSelectedAgent() ) );
		}
		
		return iMApplicationInfo;
	}
	
	/**
	 * Method to prepare IMApplicationINfo BO
	 * @param iMApplicationInfo
	 * @return imApplicationInfoReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.imapplicationinfo.v1.IMApplicationInfo getImApplicationInfoReq(IMApplicationInfo iMApplicationInfo){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.imapplicationinfo.v1.IMApplicationInfo imApplicationInfoReq = 
		new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.imapplicationinfo.v1.IMApplicationInfo();
		
		imApplicationInfoReq.setAgentFirstName( iMApplicationInfo.getAgentFirstName());
		imApplicationInfoReq.setAgentLastName( iMApplicationInfo.getAgentLastName() );
		imApplicationInfoReq.setAgentNumber( iMApplicationInfo.getAgentNumber() );
		imApplicationInfoReq.setContextID( iMApplicationInfo.getContextID() );
		imApplicationInfoReq.setCreatedBy( iMApplicationInfo.getCreatedBy() );
		imApplicationInfoReq.setIsoCountry( iMApplicationInfo.getIsoCountry() );
		imApplicationInfoReq.setIsoCurrency( iMApplicationInfo.getIsoCurrency() );
		imApplicationInfoReq.setPseudoCityCode( iMApplicationInfo.getPseudoCityCode() );
		imApplicationInfoReq.setRequestorID( iMApplicationInfo.getRequestorID() );
		imApplicationInfoReq.setSalesOrg( iMApplicationInfo.getSalesOrg() );
		if( this.getIMApplicationInfo().getSelectedAgent() != null ){
			imApplicationInfoReq.setSelectedAgent( this.getAgentReq( this.getIMApplicationInfo().getSelectedAgent() ) );
		}
		if( this.getIMApplicationInfo().getType() != null ){
			imApplicationInfoReq.setType( this.getUserTypeReq(this.getIMApplicationInfo().getType() ) );
		}
		
		return imApplicationInfoReq;
	}

	/**
	 * Method ro prepare Insurance DTO from BO
	 * @param res
	 * @return insurance
	 */
	public Insurance getInsurance(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance res){
		Insurance insurance = new Insurance();
		
		insurance.setMaterialNo( res.getMaterialNo() );
		insurance.setMaterailDesc( res.getMaterailDesc() );
		insurance.setVacationType( res.getVacationType() );
		insurance.setVacationDescription( res.getVacationDescription() );
		insurance.setChildRuleDesc( res.getChildRuleDesc() );
		insurance.setOptionIns( res.getOptionIns() );
		insurance.setOptionDesc( res.getOptionDesc() );
		insurance.setGuestAllocation( res.getGuestAllocation() );
		insurance.setPosnr( res.getPosnr() );
		insurance.setOldPosnr( res.getOldPosnr() );
		insurance.setDisabledGuestAllocation( res.getDisabledGuestAllocation() );
		if( res.getMaxQuantity() != null ){
			insurance.setMaxQuantity( res.getMaxQuantity().byteValue() );
		}
		if( res.getAdultsQty() != null ){
			insurance.setAdultsQty( res.getAdultsQty().byteValue() );
		}
		if( res.getChildsQty() != null ){
			insurance.setChildsQty( res.getChildsQty().byteValue() );
		}
		if( res.getInfantsQty() != null ){
			insurance.setInfantsQty( res.getInfantsQty().byteValue() );
		}
		if( res.getLapChildQty() != null ){
			insurance.setLapChildQty( res.getLapChildQty().byteValue() );
		}
		if( res.getSeniorsQty() != null ){
			insurance.setSeniorsQty( res.getSeniorsQty().byteValue() );
		}
		if( res.getItemRPH() != null ){
			insurance.setItemRPH( res.getItemRPH().intValue() );
		}
		if( res.getChildMinAge() != null ){
			insurance.setChildMinAge( res.getChildMinAge().intValue() );
		}
		if( res.getChildMaxAge() != null ){
			insurance.setChildMaxAge( res.getChildMaxAge().intValue() );
		}
		if( res.getTotalPrice() != null ){
			insurance.setTotalPrice( res.getTotalPrice().doubleValue() );
		}
		if( res.getAdultPrice() != null ){
			insurance.setAdultPrice( res.getAdultPrice().doubleValue() );
		}
		if( res.getChildPrice() != null ){
			insurance.setChildPrice( res.getChildPrice().doubleValue() );
		}
		if( res.getValidDateFrom() != null ){
			insurance.setValidDateFrom( this.getDate( res.getValidDateFrom() ) );
		}
		if( res.getValidDateTo() != null ){
			insurance.setValidDateTo( this.getDate( res.getValidDateTo() ) );
		}
		if( (res.getChildAges() != null) && (res.getChildAges().size() > 0) ){
			insurance.setChildAges( this.convertBigIntegerList( res.getChildAges() ) );
		}
		if( (res.getGuestAllocationList() != null) && (res.getGuestAllocationList().size() > 0) ){
			List<InsuranceGuestAllocation> guestAllocationList = new ArrayList<InsuranceGuestAllocation>();
			for(int i=0; i < res.getGuestAllocationList().size(); i++){
				if( res.getGuestAllocationList().get(i) != null ){
				guestAllocationList.add( this.getInsuranceGuestAllocation( res.getGuestAllocationList().get(i) ) );
				}
			}
			insurance.setGuestAllocationList(guestAllocationList);
		}
		
		
		
		return insurance;
	}
	
	/**
	 * Method to prepare Insurance BO
	 * @param insurance
	 * @return insuranceReq
	 */
	
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance getInsuranceReq(Insurance insurance){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance insuranceReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance();
		
		insuranceReq.setItemRPH( new Integer( insurance.getItemRPH() ) );
		insuranceReq.setMaterialNo( insurance.getMaterialNo() );
		insuranceReq.setMaterailDesc( insurance.getMaterailDesc() );
		insuranceReq.setVacationType( insurance.getVacationType() );
		insuranceReq.setVacationDescription( insurance.getVacationDescription() );
		insuranceReq.setAdultPrice( new Double( insurance.getAdultPrice() ) );
		insuranceReq.setChildPrice( new Double( insurance.getChildPrice() ) );
		insuranceReq.setChildRuleDesc( insurance.getChildRuleDesc() );
		insuranceReq.setChildMinAge( new Integer( insurance.getChildMinAge() ) );
		insuranceReq.setChildMaxAge( new Integer( insurance.getChildMaxAge() ) );
		insuranceReq.setOptionIns( insurance.getOptionIns() );
		insuranceReq.setOptionDesc( insurance.getOptionDesc() );
		insuranceReq.setGuestAllocation( insurance.getGuestAllocation() );
		insuranceReq.setAdultsQty( new Byte( insurance.getAdultsQty() ) );
		insuranceReq.setChildsQty( new Byte( insurance.getChildsQty() ) );
		insuranceReq.setInfantsQty( new Byte( insurance.getInfantsQty() ) );
		insuranceReq.setLapChildQty( new Byte( insurance.getLapChildQty() ) );
		insuranceReq.setSeniorsQty( new Byte( insurance.getSeniorsQty() ) );
		insuranceReq.setTotalPrice( new Double( insurance.getTotalPrice() ) );
		insuranceReq.setPosnr( insurance.getPosnr() );
		insuranceReq.setOldPosnr( insurance.getOldPosnr() );
		insuranceReq.setMaxQuantity( new Byte( insurance.getMaxQuantity() ) );
		insuranceReq.setDisabledGuestAllocation( insurance.getDisabledGuestAllocation() );
		if( insurance.getValidDateFrom() != null ){
			insuranceReq.setValidDateFrom( this.getDate( insurance.getValidDateFrom() ) );
		}
		if( insurance.getValidDateTo() != null ){
			insuranceReq.setValidDateTo( this.getDate( insurance.getValidDateTo() ) );
		}
		if( (insurance.getChildAges() != null) && (insurance.getChildAges().size() > 0) ){
			for(int i=0; i < insurance.getChildAges().size(); i++){
				insuranceReq.getChildAges().add( BigInteger.valueOf( insurance.getChildAges().get(i).intValue() ) );
			}
		}
		if( (insurance.getGuestAllocationList() != null) && (insurance.getGuestAllocationList().size() > 0) ){
			for(int i=0; i < insurance.getGuestAllocationList().size(); i++){
				insuranceReq.getGuestAllocationList().add( 
						this.getInsuranceGuestAllocationReq( insurance.getGuestAllocationList().get(i) ));
			}
		}
		
		return insuranceReq;
	}
	
	/**
	 * Method to prepare InsuranceGuestAllocation DTO from BO
	 * @param res
	 * @return insuranceGuestAllocation
	 */
			
	public InsuranceGuestAllocation getInsuranceGuestAllocation(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insuranceguestallocation.v1.InsuranceGuestAllocation res){
		InsuranceGuestAllocation insuranceGuestAllocation = new InsuranceGuestAllocation();
		
		insuranceGuestAllocation.setGuestID( res.getGuestID() );
		insuranceGuestAllocation.setPosnr( res.getPosnr() );
		insuranceGuestAllocation.setOldPosnr( res.getOldPosnr() );
		if( res.getPrice() != null ){
			insuranceGuestAllocation.setPrice( res.getPrice().doubleValue() );
		}
		
		return insuranceGuestAllocation;
	}
	
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.imapplicationinfo.v1.IMApplicationInfo getIMApplicationInfoReq(IMApplicationInfo iMApplicationInfo){
			com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.imapplicationinfo.v1.IMApplicationInfo iMApplicationInfoReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.imapplicationinfo.v1.IMApplicationInfo();
			
			iMApplicationInfoReq.setRequestorID( iMApplicationInfo.getRequestorID() );
			iMApplicationInfoReq.setContextID( iMApplicationInfo.getContextID() );
			iMApplicationInfoReq.setCreatedBy( iMApplicationInfo.getCreatedBy() );
			iMApplicationInfoReq.setAgentNumber( iMApplicationInfo.getAgentNumber() );
			iMApplicationInfoReq.setPseudoCityCode( iMApplicationInfo.getPseudoCityCode() );
			iMApplicationInfoReq.setIsoCountry( iMApplicationInfo.getIsoCountry() );
			iMApplicationInfoReq.setIsoCurrency( iMApplicationInfo.getIsoCurrency() );
			iMApplicationInfoReq.setSalesOrg( iMApplicationInfo.getSalesOrg() );
			iMApplicationInfoReq.setAgentFirstName( iMApplicationInfo.getAgentFirstName() );
			iMApplicationInfoReq.setAgentLastName( iMApplicationInfo.getAgentLastName() );
			if( iMApplicationInfo.getSelectedAgent() != null ){
				iMApplicationInfoReq.setSelectedAgent( this.getAgentReq( iMApplicationInfo.getSelectedAgent()) );
			}
			if( this.getIMApplicationInfo().getType() != null ){
				iMApplicationInfoReq.setType( this.getUserTypeReq( this.getIMApplicationInfo().getType()) );
			}
			
			return iMApplicationInfoReq;
	}
	
	/**
	 * method to prepare ItineraryCancellationRules BO
	 * @param itineraryCancellationRules
	 * @return itineraryCancellationRulesReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerarycancellationrules.v1.ItineraryCancellationRules getItineraryCancellationRulesReq(ItineraryCancellationRules itineraryCancellationRules){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerarycancellationrules.v1.
			ItineraryCancellationRules itineraryCancellationRulesReq =
		new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerarycancellationrules.v1.ItineraryCancellationRules();
		
		if( (itineraryCancellationRules.getSkedInfoRules() != null) && (itineraryCancellationRules.getSkedInfoRules().size() > 0) ){
			for(int i=0; i < itineraryCancellationRules.getSkedInfoRules().size(); i ++){
				itineraryCancellationRulesReq.getSkedInfoRules().add( itineraryCancellationRules.getSkedInfoRules().get(i) );
			}
		}
	
		return itineraryCancellationRulesReq;
	}
	/**
	 * Method to prepare ItineraryPrice BO
	 * @param itineraryPrice
	 * @return itineraryPriceReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itineraryprice.v1.ItineraryPrice getItineraryPriceReq(ItineraryPrice itineraryPrice){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itineraryprice.v1.ItineraryPrice itineraryPriceReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itineraryprice.v1.ItineraryPrice();
		
		itineraryPriceReq.setTotalPrice( new Double(itineraryPrice.getTotalPrice()) );
		itineraryPriceReq.setPreBPGTotalPrice( new Double(itineraryPrice.getPreBPGTotalPrice()) );
		itineraryPriceReq.setTotalTax( new Double(itineraryPrice.getTotalTax()) );
		itineraryPriceReq.setPromoSavings( new Double(itineraryPrice.getPromoSavings()) );
		itineraryPriceReq.setCurrency( itineraryPrice.getCurrency() );
		itineraryPriceReq.setDepositAmount( new Double(itineraryPrice.getDepositAmount()) );
		if( itineraryPrice.getDepositDate() != null ){
			itineraryPriceReq.setDepositDate( this.getDate( itineraryPrice.getDepositDate() ) );
		}
		
		return itineraryPriceReq;
	}
	
	/**
	 * Method to prepare ItineraryPrice DTO from BO
	 * @param res
	 * @return itineraryPrice
	 */
	public ItineraryPrice getItineraryPrice(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itineraryprice.v1.ItineraryPrice res){
		ItineraryPrice itineraryPrice = new ItineraryPrice();
		
		itineraryPrice.setCurrency( res.getCurrency() );
		if( res.getTotalPrice() != null ){
			itineraryPrice.setTotalPrice( res.getTotalPrice().doubleValue() );
		}
		if( res.getPreBPGTotalPrice() != null ){
			itineraryPrice.setPreBPGTotalPrice( res.getPreBPGTotalPrice().doubleValue() );
		}
		if( res.getTotalTax() != null ){
			itineraryPrice.setTotalTax( res.getTotalTax().doubleValue() );
		}
		if( res.getPromoSavings() != null ){
			itineraryPrice.setPromoSavings( res.getPromoSavings().doubleValue() );
		}
		if( res.getDepositAmount() != null ){
			itineraryPrice.setDepositAmount( res.getDepositAmount().doubleValue() );
		}
		if( res.getDepositDate() != null ){
			itineraryPrice.setDepositDate( this.getDate( res.getDepositDate() ) );
		}
		
		return itineraryPrice;
	}
	
	public ABEBusinessError getABEBusinessError(com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.abebusinesserror.v1.ABEBusinessError res ){
		ABEBusinessError abeBusinessError = new ABEBusinessError( res.getErrorCode(), res.getErrorDescription());
		
		return abeBusinessError;
	}
	
	public ABEInfoMessage getABEInfoMessage(com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.abeinfomessage.v1.ABEInfoMessage res){
		ABEInfoMessage ABEInfoMessage = new ABEInfoMessage( res.getErrorCode(), res.getErrorDescription() );
		
		return ABEInfoMessage;
	}
	
	public ABESystemError getABESystemError(com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.abesystemerror.v1.ABESystemError res ){
		ABESystemError abeSystemError = new ABESystemError(res.getErrorCode(), res.getErrorDescription() );
		
		return abeSystemError;
	}
	
	public ABEWarning getABEWarning(com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.abewarning.v1.ABEWarning res){
		ABEWarning abeWarning = new ABEWarning( res.getErrorCode(), res.getErrorDescription() );
		
		return abeWarning;
	}
	/**
	 * Method to prepare ItineraryPricingResponse DTO from BO
	 * @param res
	 * @return pricingResponse
	 */
	public ItineraryPricingResponse getItineraryPricingResponse(com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.priceitineraryresponse.v1.HotelsPriceItineraryResponse res){
		ItineraryPricingResponse pricingResponse = new ItineraryPricingResponse();
		
		if( (res.getBusinessError() != null) && (res.getBusinessError().size() > 0) ){
			List<ABEBusinessError> businessErrors = new ArrayList<ABEBusinessError>();
			for(int i=0; i < res.getBusinessError().size(); i++){
				if( (res.getBusinessError().get(i).getErrorCode() != null) && 
						!res.getBusinessError().get(i).getErrorCode().equals("000") ){
					businessErrors.add( this.getABEBusinessError( res.getBusinessError().get(i) ) );
				}
			}
			pricingResponse.saveBusinessErrors(businessErrors);
		}
		
		if( (res.getInfoMessage() != null) && (res.getInfoMessage().size() > 0) ){
			List<ABEInfoMessage> infoMessages = new ArrayList<ABEInfoMessage>();
			for(int i=0; i < res.getInfoMessage().size(); i++){
				if( res.getInfoMessage().get(i) != null ){
				infoMessages.add( this.getABEInfoMessage( res.getInfoMessage().get(i) ) );
				}
			}
			
			pricingResponse.saveInfoMessages(infoMessages);
		}
		
		if( res.getItinerary() != null ){
		
			pricingResponse.setItinerary( this.getItinerary( res.getItinerary() ));
		
		}
		
		if( (res.getSystemErrors() != null) && (res.getSystemErrors().size() > 0) ){
			List<ABESystemError> systemErrors = new ArrayList<ABESystemError>( );
			for(int i=0; i < res.getSystemErrors().size(); i++){
				if( res.getSystemErrors().get(i) != null ){
				systemErrors.add( this.getABESystemError( res.getSystemErrors().get(i) ) );
				}
			}
			
			pricingResponse.saveSystemErrors(systemErrors);
		}
		
		if( (res.getWarnings() != null) && (res.getWarnings().size() > 0) ){
			List<ABEWarning> warnings = new ArrayList<ABEWarning>( );
			for(int i=0; i < res.getWarnings().size(); i++){
				if( res.getWarnings().get(i) != null ){
				warnings.add( this.getABEWarning( res.getWarnings().get(i) ) );
				}
			}
			
			pricingResponse.saveWarnings(warnings);
		}
		
		return pricingResponse;
	}
	
	/**
	 * Method to prepare MealPlanType BO
	 * @param mealPlanType
	 * @return mealPlanTypeReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.mealplantype.v1.MealPlanType getMealPlanTypeReq(MealPlanType mealPlanType){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.mealplantype.v1.MealPlanType mealPlanTypeReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.mealplantype.v1.MealPlanType();
		
		mealPlanTypeReq.setCode( mealPlanType.getCode() );
		mealPlanTypeReq.setDescription( mealPlanType.getDescription() );
		
		return mealPlanTypeReq;
	}
	/**
	 *  Method to prepare MealPlanType DTO from BO
	 * @param res
	 * @return MealPlanType
	 */
	public MealPlanType getMealPlanType(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.mealplantype.v1.MealPlanType res){
		if( res.getCode().equals("ALLI") || res.getCode().equals("All Inclusive")){
			return MealPlanType.ALLI;
		}
		if( res.getCode().equals("INC") || res.getCode().equals("Inclusive")){
			return MealPlanType.INC;
		}
		if( res.getCode().equals("EP") || res.getCode().equals("European Plan") ){
			return MealPlanType.EP;
		}
		if( res.getCode().equals("BP") || res.getCode().equals("Breakfast Plan") ){
			return MealPlanType.BP;
		}
		if( res.getCode().equals("FAP") || res.getCode().equals("Full American Plan") ){
			return MealPlanType.FAP;
		}
		if( res.getCode().equals("MAP") || res.getCode().equals("Modified American Plan") ){
			return MealPlanType.MAP;
		}
		if( res.getCode().equals("IMAP") || res.getCode().equals("IMAP") ){
			return MealPlanType.IMAP;
		}
		if( res.getCode().equals("BB") || res.getCode().equals("BB") ){
			return MealPlanType.BB;
		}
		if( res.getCode().equals("ADP") || res.getCode().equals("ADP") ){
			return MealPlanType.ADP;
		}
		if( res.getCode().equals("NOM") || res.getCode().equals("NOM") ){
			return MealPlanType.NOM;
		}
		
		return null;
	}
	
	/**
	 * Method to prepare MoneyTransfer DTO
	 * @param res
	 * @return moneyTransfer
	 */
	public MoneyTransfer getMoneyTransfer(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.moneytransfer.v1.MoneyTransfer res){
		MoneyTransfer moneyTransfer = new MoneyTransfer();
		
		moneyTransfer.setTransferFromBooking( res.getTransferFromBooking());
		moneyTransfer.setReason( res.getReason() );
		if( res.getAmountApplied() != null ){
			moneyTransfer.setAmountApplied( res.getAmountApplied().doubleValue() );
		}
		
		return moneyTransfer;
	}
	
	/**
	 * method to prepare MoneyTransfer BO
	 * @param moneyTransfer
	 * @return moneyTransferReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.moneytransfer.v1.MoneyTransfer getMoneyTransferReq(MoneyTransfer moneyTransfer){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.moneytransfer.v1.MoneyTransfer moneyTransferReq = 
		new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.moneytransfer.v1.MoneyTransfer();
		
		moneyTransferReq.setTransferFromBooking( moneyTransfer.getTransferFromBooking() );
		moneyTransferReq.setAmountApplied( new Double(moneyTransfer.getAmountApplied()) );
		moneyTransferReq.setReason( moneyTransfer.getReason() );
		
		return moneyTransferReq;
	}
	
	/**
	 * Method to prepare MultiDestinationPackage BO
	 * @param multiDestinationPackage
	 * @return req
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.multidestinationpackage.v1.MultiDestinationPackage getMultiDestinationPackageReq(MultiDestinationPackage multiDestinationPackage){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.multidestinationpackage.v1.MultiDestinationPackage req =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.multidestinationpackage.v1.MultiDestinationPackage();
		
		if( (multiDestinationPackage.getSelectedFlights() != null) && (multiDestinationPackage.getSelectedFlights().size() > 0) ){
			for(int i=0; i < multiDestinationPackage.getSelectedFlights().size(); i++){
				req.getSelectedFlights().add( this.getTripFlightReq( multiDestinationPackage.getSelectedFlights().get(i) ));
			}
		}
		if( (multiDestinationPackage.getSelectedHotels() != null) && (multiDestinationPackage.getSelectedHotels().size() > 0) ){
			for(int i=0; i < multiDestinationPackage.getSelectedHotels().size(); i++){
				req.getSelectedHotels().add( this.getHotelReq( multiDestinationPackage.getSelectedHotels().get(i) ));
			}
		}
		if( (multiDestinationPackage.getSelectedVehicles() != null) && (multiDestinationPackage.getSelectedVehicles().size() > 0) ){
			for(int i=0; i < multiDestinationPackage.getSelectedVehicles().size(); i++){
				req.getSelectedVehicles().add( this.getVehicleReq( multiDestinationPackage.getSelectedVehicles().get(i) ));
			}
		}
		req.setChangePosition( new Byte( multiDestinationPackage.getChangePosition() ));
		
		return req;
	}
	
	/**
	 * Method to prepare MultiDestinationPackage DTO from BO
	 * @param res
	 * @return multiDestinationPackage
	 */
	public MultiDestinationPackage getMultiDestinationPackage(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.multidestinationpackage.v1.MultiDestinationPackage res){
		MultiDestinationPackage multiDestinationPackage = new MultiDestinationPackage();
		
		if( (res.getSelectedFlights() != null) && (res.getSelectedFlights().size() > 0) ){
			multiDestinationPackage.setSelectedFlights( new ArrayList<TripFlight>());
			for(int i=0; i < res.getSelectedFlights().size(); i++){
				if( res.getSelectedFlights().get(i) != null )
				multiDestinationPackage.getSelectedFlights().add( this.getTripFlight( res.getSelectedFlights().get(i) ) );
			}
		}
		if( (res.getSelectedHotels() != null) && (res.getSelectedHotels().size() > 0) ){
			multiDestinationPackage.setSelectedHotels( new ArrayList<Hotel>() );
			for(int i=0; i < res.getSelectedHotels().size(); i++){
				if( res.getSelectedHotels().get(i) != null )
				multiDestinationPackage.getSelectedHotels().add( this.getHotel( res.getSelectedHotels().get(i) ) );
			}
		}
		if( (res.getSelectedVehicles() != null) && (res.getSelectedVehicles().size() > 0) ){
			multiDestinationPackage.setSelectedVehicles( new ArrayList<Vehicle>() );
			for(int i=0; i < res.getSelectedVehicles().size(); i++){
				if( res.getSelectedVehicles().get(i) != null )
				multiDestinationPackage.getSelectedVehicles().add( this.getVehicle( res.getSelectedVehicles().get(i) ) );
			}
		}
		if( res.getChangePosition() != null ){
			multiDestinationPackage.setChangePosition( res.getChangePosition().byteValue() );
		}

		return multiDestinationPackage;
	}
	/**
	 * Method to prepare Occupancy BO
	 * @param occupancy
	 * @return occupancyReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.occupancy.v1.Occupancy getOccupancyReq(Occupancy occupancy){
		com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.occupancy.v1.Occupancy occupancyReq =
			new com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.occupancy.v1.Occupancy();
		
		occupancyReq.setNoOfAdults( new Byte(occupancy.getNoOfAdults()) );
		occupancyReq.setNoOfSeniors( new Byte(occupancy.getNoOfSeniors()) );
		occupancyReq.setNoOfChilds( new Byte(occupancy.getNoOfChilds()) );
		occupancyReq.setNoOfLapChilds( new Byte(occupancy.getNoOfLapChilds()) );
		occupancyReq.setNoOfInfants( new Byte(occupancy.getNoOfInfants()) );
		if( (occupancy.getPassengers() != null) && (occupancy.getPassengers().size() > 0)){
			for(int i=0; i < occupancy.getPassengers().size(); i++){
				occupancyReq.getPassengers().add( this.getPassengerReq( occupancy.getPassengers().get(i) ) );
			}
		}
		
		return occupancyReq;
	}
	
	/**
	 * Method to prepare Occupancy DTO from BO
	 * @param res
	 * @return occupancy
	 */
	public Occupancy getOccupancy(com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.occupancy.v1.Occupancy res){
		Occupancy occupancy = new Occupancy();
		
		occupancy.setNoOfAdults( new Byte( res.getNoOfAdults() ) );
		occupancy.setNoOfSeniors( new Byte( res.getNoOfSeniors() ) );
		occupancy.setNoOfChilds( new Byte( res.getNoOfChilds() ) );
		occupancy.setNoOfLapChilds( new Byte( res.getNoOfLapChilds() ) );
		occupancy.setNoOfInfants( new Byte( res.getNoOfInfants() ) );
		if( (res.getPassengers() != null) && (res.getPassengers().size() > 0) ){
			List<Passenger> passengers = new ArrayList<Passenger>();
			for(int i=0; i < res.getPassengers().size(); i++){
				if( res.getPassengers().get(i) != null )
				passengers.add( this.getPassenger( res.getPassengers().get(i) ) );
			}
			occupancy.setPassengers(passengers);
		}
		
		return occupancy;
	}
	
	/**
	 * Method to prepare OpsAlert BO
	 * @param opsAlert
	 * @return opsAlertReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.opsalert.v1.OpsAlert getOpsAlertReq(OpsAlert opsAlert){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.opsalert.v1.OpsAlert opsAlertReq = 
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.opsalert.v1.OpsAlert();
		
		opsAlertReq.setActionCode( opsAlert.getActionCode() );
		opsAlertReq.setAlertCode( opsAlert.getAlertCode() );
		opsAlertReq.setInstructions( opsAlert.getInstructions() );
		opsAlertReq.setHotelName( opsAlert.getHotelName() );
		opsAlertReq.setUserName( opsAlert.getUserName() );
		opsAlertReq.setLocaltelephNo( opsAlert.getLocaltelephNo() );
		opsAlertReq.setService( opsAlert.getService() );
		opsAlertReq.setReprintDoc( opsAlert.getReprintDoc() );
		opsAlertReq.setType( opsAlert.getType() );
		opsAlertReq.setTravelAgencyAccountNo( opsAlert.getTravelAgencyAccountNo() );
		if( opsAlertReq.getImApplicationInfo() != null ){
			opsAlertReq.setImApplicationInfo( this.getIMApplicationInfoReq(opsAlert.getImApplicationInfo()) );
		}
		if( opsAlert.getInFlightInfo() != null ){
			opsAlertReq.setInFlightInfo( this.getFlightTransferInfoReq(opsAlert.getInFlightInfo()) );
		}
		if( opsAlert.getOutFlightInfo() != null ){
			opsAlertReq.setOutFlightInfo( this.getFlightTransferInfoReq( opsAlert.getOutFlightInfo() ) );
		}
		if( opsAlert.getDocumentAddress() != null ){
			opsAlertReq.setDocumentAddress( this.getAddressReq(opsAlert.getDocumentAddress()) );
		}
		if( opsAlert.getBookingHeader() != null ){
			opsAlertReq.setBookingHeader( this.getBookingHeaderReq(opsAlert.getBookingHeader()) );
		}
		if( (opsAlert.getGuests() != null) && (opsAlert.getGuests().size() > 0) ){
			for(int i=0; i < opsAlert.getGuests().size(); i++){
				opsAlertReq.getGuests().add( this.getGuestInfoReq( opsAlert.getGuests().get(i) ));
			}
		}
		if( (opsAlert.getAlertTypes() != null) && (opsAlert.getAlertTypes().size() > 0) ){
			for(int i=0; i < opsAlert.getAlertTypes().size(); i++){
				opsAlertReq.getAlertTypes().add( this.getAlertTypeReq( opsAlert.getAlertTypes().get(i)) );
			}
		}
		if( (opsAlert.getActionTypes() != null) && (opsAlert.getActionTypes().size() > 0) ){
			for(int i=0; i < opsAlert.getActionTypes().size(); i++){
				opsAlertReq.getActionTypes().add( this.getActionTypeReq( opsAlert.getActionTypes().get(i) ) );
			}
		}

		return opsAlertReq;
	}
	
	/**
	 * Method to prepare OpsAlert DTO from BO
	 * @param res
	 * @return opsAlert
	 */
	public OpsAlert getOpsAlert(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.opsalert.v1.OpsAlert res){
		OpsAlert opsAlert = new OpsAlert();
		
		opsAlert.setActionCode( res.getActionCode() );
		opsAlert.setAlertCode( res.getAlertCode() );
		opsAlert.setInstructions( res.getInstructions() );
		opsAlert.setHotelName( res.getHotelName() );
		opsAlert.setUserName( res.getUserName() );
		opsAlert.setLocaltelephNo( res.getLocaltelephNo() );
		opsAlert.setService( res.getService() );
		opsAlert.setReprintDoc( res.getReprintDoc() );
		opsAlert.setType( res.getType() );
		opsAlert.setTravelAgencyAccountNo( res.getTravelAgencyAccountNo() );
		if( res.getImApplicationInfo() != null ){
			opsAlert.setImApplicationInfo( this.getIMApplicationInfo( res.getImApplicationInfo() ));
		}
		if( res.getInFlightInfo() != null ){
			opsAlert.setInFlightInfo( this.getFlightTransferInfo( res.getInFlightInfo() ) );
		}
		if( res.getOutFlightInfo() != null ){
			opsAlert.setOutFlightInfo( this.getFlightTransferInfo( res.getOutFlightInfo() ) );
		}
		if( res.getDocumentAddress() != null ){
			opsAlert.setDocumentAddress( this.getAddress( res.getDocumentAddress() ) );
		}
		if( res.getBookingHeader() != null ){
			opsAlert.setBookingHeader( this.getBookingHeader( res.getBookingHeader() ) );
		}
		if( (res.getGuests() != null) && (res.getGuests().size() > 0) ){
			List<GuestInfo> guests = new ArrayList<GuestInfo>();
			for(int i=0; i < res.getGuests().size(); i++){
				if( res.getGuests().get(i) != null )
				guests.add( this.getGuestInfo( res.getGuests().get(i) ) );
			}
			opsAlert.setGuests(guests);
		}
		if( (res.getAlertTypes() != null) && (res.getAlertTypes().size() > 0) ){
			List<AlertType> alertTypes = new ArrayList<AlertType>();
			for(int i=0; i < res.getAlertTypes().size(); i++){
				if( res.getAlertTypes().get(i) != null )
				alertTypes.add( this.getAlertType( res.getAlertTypes().get(i) ) );
			}
			opsAlert.setAlertTypes(alertTypes);
		}
		if( (res.getActionTypes() != null) && (res.getActionTypes().size() > 0) ){
			List<ActionType> actionTypes = new ArrayList<ActionType>();
			for(int i=0; i < res.getActionTypes().size(); i++){
				if( res.getActionTypes().get(i) != null )
				actionTypes.add( this.getActionType( res.getActionTypes().get(i) ) );
			}
			opsAlert.setActionTypes(actionTypes);
		}
		
		return opsAlert;
	}
	/**
	 * Method to prepare PackageObj BO
	 * @param packageObj
	 * @return packageObjReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.packageobj.v1.PackageObj getPackageObjReq(Package packageObj){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.packageobj.v1.PackageObj packageObjReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.packageobj.v1.PackageObj();
		
		if( packageObj.getSelectedFlight() != null ){
			packageObjReq.setSelectedFlight( this.getTripFlightReq( packageObj.getSelectedFlight() ) );
		}
		if( packageObj.getSelectedHotel() != null ){
			packageObjReq.setSelectedHotel( this.getHotelReq( packageObj.getSelectedHotel() ) );
		}
		if( packageObj.getSelectedVehicle() != null ){
			packageObjReq.setSelectedVehicle( this.getVehicleReq( packageObj.getSelectedVehicle() ) );
		}
		
		return packageObjReq;
	}
	/**
	 * Method to prepare Package DTO form BO
	 * @param res
	 * @return packageObj
	 */
	public Package getPackage(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.packageobj.v1.PackageObj res){
		Package packageObj = new Package();
		
		if( res.getSelectedFlight() != null ){
			packageObj.setSelectedFlight( this.getTripFlight( res.getSelectedFlight() ) );
		}
		if( res.getSelectedHotel() != null ){
			packageObj.setSelectedHotel( this.getHotel(res.getSelectedHotel()) );
		}
		if( res.getSelectedVehicle() != null ){
			packageObj.setSelectedVehicle( this.getVehicle(res.getSelectedVehicle()) );
		}
		
		return packageObj;
	}
	
	/**
	 * Method to prepare passenger BO
	 * @param passenger
	 * @return passengerReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.passenger.v1.Passenger getPassengerReq(Passenger passenger){
		com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.passenger.v1.Passenger passengerReq =
			new com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.passenger.v1.Passenger();
		
		passengerReq.setPaxId( new Byte(passenger.getPaxId()) );
		passengerReq.setRoomNumber( new Byte(passenger.getRoomNumber()) );
		passengerReq.setAge( new Byte(passenger.getAge()) );
		passengerReq.setGuestCount( new Byte(passenger.getGuestCount()) );
		
		if( passenger.getAgeCode() != null ){
			passengerReq.setAgeCode( this.getAgeCodeReq(passenger.getAgeCode()) );
		}
		
		return passengerReq;
	}
	/**
	 * Method to prepare Passenger DTO from BO
	 * @param res
	 * @return passenger
	 */
	public Passenger getPassenger(com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.passenger.v1.Passenger res){
		Passenger passenger = new Passenger();
		
		if( res.getPaxId() != null ){
			passenger.setPaxId( res.getPaxId().byteValue() );
		}
		if( res.getRoomNumber() != null ){
			passenger.setRoomNumber( res.getRoomNumber().byteValue() );
		}
		if( res.getAge() != null ){
			passenger.setAge( res.getAge().byteValue() );
		}
		if( res.getGuestCount() != null ){
			passenger.setGuestCount( res.getGuestCount().byteValue() );
		}
		if( (res.getAgeCode() != null) && (res.getAgeCode().getAge() > 0) ){
			passenger.setAgeCode( this.getAgeCode(res.getAgeCode()) );
		}
		
		return passenger;
	}
	
	/**
	 * Method to prepare PassportInfo BO
	 * @param passportInfo
	 * @return passportInfoReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.passportinfo.v1.PassportInfo getPassportInfoReq(PassportInfo passportInfo){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.passportinfo.v1.PassportInfo passportInfoReq = 
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.passportinfo.v1.PassportInfo();
		
		passportInfoReq.setPassportNumber( passportInfo.getPassportNumber() );
		passportInfoReq.setNationality( passportInfo.getNationality() );
		passportInfoReq.setCountryOfIssue( passportInfo.getCountryOfIssue() );
		if( passportInfo.getExpirationDate() != null ){
			passportInfoReq.setExpirationDate( this.getDate( passportInfo.getExpirationDate() ) );
		}
		if( passportInfo.getAddress() != null ){
			passportInfoReq.setAddress( this.getAddressReq(passportInfo.getAddress()) );
		}
		
		return passportInfoReq;
	}
	
	/**
	 * Method to prepare PaxTypeBasePrices DTO from BO
	 * @param res
	 * @return paxTypeBasePrices
	 */
	public PaxTypeBasePrices getPaxTypeBasePrices(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paxtypebaseprices.v1.PaxTypeBasePrices res){
		PaxTypeBasePrices paxTypeBasePrices = new PaxTypeBasePrices();
		
		paxTypeBasePrices.setNoOfAdults( res.getNoOfAdults() );
		paxTypeBasePrices.setNoOfChilds( res.getNoOfChilds() );
		paxTypeBasePrices.setNoOfInfants( res.getNoOfInfants() );
		paxTypeBasePrices.setNoOfLapChilds( res.getNoOfLapChilds() );
		paxTypeBasePrices.setNoOfSeniors( res.getNoOfSeniors() );
		paxTypeBasePrices.setChild1Age( res.getChild1Age() );
		paxTypeBasePrices.setChild2Age( res.getChild2Age() );
		paxTypeBasePrices.setChild3Age( res.getChild3Age() );
		paxTypeBasePrices.setChild4Age( res.getChild4Age() );
		paxTypeBasePrices.setChild5Age( res.getChild5Age() );
		paxTypeBasePrices.setChild6Age( res.getChild6Age() );
		paxTypeBasePrices.setNoOfJuniors( res.getNoOfJuniors() );
		paxTypeBasePrices.setNoOfMinors( res.getNoOfMinors() );
		paxTypeBasePrices.setChild1Type("");
		paxTypeBasePrices.setChild2Type("");
		paxTypeBasePrices.setChild3Type("");
		paxTypeBasePrices.setChild4Type("");
		paxTypeBasePrices.setChild5Type("");
		paxTypeBasePrices.setChild6Type("");
		if( res.getChild1Type() != null ){
		paxTypeBasePrices.setChild1Type( res.getChild1Type() );
		}
		if( res.getChild2Type() != null ){
		paxTypeBasePrices.setChild2Type( res.getChild2Type() );
		}
		if( res.getChild3Type() != null ){
		paxTypeBasePrices.setChild3Type( res.getChild3Type() );
		}
		if( res.getChild4Type() != null ){
		paxTypeBasePrices.setChild4Type( res.getChild4Type() );
		}
		if( res.getChild5Type() != null ){
		paxTypeBasePrices.setChild5Type( res.getChild5Type() );
		}
		if( res.getChild6Type() != null ){
		paxTypeBasePrices.setChild6Type( res.getChild6Type() );
		}
		if( res.getAdultBasePrice() != null ){
			paxTypeBasePrices.setAdultBasePrice( res.getAdultBasePrice().doubleValue() );
		}
		if( res.getChildBasePrice() != null ){
			paxTypeBasePrices.setChildBasePrice( res.getChildBasePrice().doubleValue() );
		}
		if( res.getSeniorBasePrice() != null ){
			paxTypeBasePrices.setSeniorBasePrice( res.getSeniorBasePrice().doubleValue() );
		}
		if( res.getInfantBasePrice() != null ){
			paxTypeBasePrices.setInfantBasePrice( res.getInfantBasePrice().doubleValue() );
		}
		if( res.getLapChildBasePrice() != null ){
			paxTypeBasePrices.setLapChildBasePrice( res.getLapChildBasePrice().doubleValue() );
		}
		if( res.getJuniorBasePrice() != null ){
			paxTypeBasePrices.setJuniorBasePrice( res.getJuniorBasePrice().doubleValue() );
		}
		if( res.getMinorBasePrice() != null ){
			paxTypeBasePrices.setMinorBasePrice( res.getMinorBasePrice().doubleValue() );
		}
		
		return paxTypeBasePrices;
	}
	
	/**
	 * Method to prepare PassportInfo DTO from BO
	 * @param res
	 * @return passportInfo
	 */
	public PassportInfo getPassportInfo(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.passportinfo.v1.PassportInfo res){
		PassportInfo passportInfo = new PassportInfo();
		
		passportInfo.setPassportNumber( res.getPassportNumber() );
		passportInfo.setNationality( res.getNationality() );
		passportInfo.setCountryOfIssue( res.getCountryOfIssue() );
		if( res.getExpirationDate() != null ){
			passportInfo.setExpirationDate( this.getDate( res.getExpirationDate() ) );
		}
		if( res.getAddress() != null ){
			passportInfo.setAddress( this.getAddress( res.getAddress() ) );
		}
		
		return passportInfo;
	}
	
	/**
	 * Method to prepare RequestedDatesForAvailability BO
	 * @param requestedDatesForAvailability
	 * @return req
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.requesteddatesforavailability.v1.RequestedDatesForAvailability getRequestedDatesForAvailabilityReq(RequestedDatesForAvailability requestedDatesForAvailability){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.requesteddatesforavailability.v1.RequestedDatesForAvailability req = 
		new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.requesteddatesforavailability.v1.RequestedDatesForAvailability();
		
		req.setNoOfRooms( requestedDatesForAvailability.getNoOfRooms() );
		req.setBookingDate( requestedDatesForAvailability.getBookingDate() );	
		req.setBookingDuration( requestedDatesForAvailability.getBookingDuration() );
		req.setRoomDescription( requestedDatesForAvailability.getRoomDescription() );
		req.setRoomStatus( requestedDatesForAvailability.getRoomStatus() );
		req.setMaterialNumber( requestedDatesForAvailability.getMaterialNumber() );
		if( (requestedDatesForAvailability.getReqDates() != null) && (requestedDatesForAvailability.getReqDates().size() > 0) ){
			for(int i=0; i < requestedDatesForAvailability.getReqDates().size(); i++){
				req.getReqDates().add( requestedDatesForAvailability.getReqDates().get(i) );
			}
		}
		
		return req;
	}
	
	/**
	 * Method to prepare RequestedDatesForAvailability DTO from BO
	 * @param res
	 * @return requestedDatesForAvailability
	 */
	public RequestedDatesForAvailability getRequestedDatesForAvailability(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.requesteddatesforavailability.v1.RequestedDatesForAvailability res){
		RequestedDatesForAvailability requestedDatesForAvailability = new RequestedDatesForAvailability();
		
		requestedDatesForAvailability.setNoOfRooms( res.getNoOfRooms() );
		requestedDatesForAvailability.setBookingDate( res.getBookingDate() );	
		requestedDatesForAvailability.setBookingDuration( res.getBookingDuration() );
		requestedDatesForAvailability.setRoomDescription( res.getRoomDescription() );
		requestedDatesForAvailability.setRoomStatus( res.getRoomStatus() );
		requestedDatesForAvailability.setMaterialNumber( res.getMaterialNumber() );
		
		requestedDatesForAvailability.setReqDates( res.getReqDates() );
		
		return requestedDatesForAvailability;
	}
	
	/**
	 * Method to prepare PaymentHistoryInfo DTO from BO
	 * @param res
	 * @return paymentHistoryInfo
	 */
	public PaymentHistoryInfo getPaymentHistoryInfo(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paymenthistoryinfo.v1.PaymentHistoryInfo res){
		PaymentHistoryInfo paymentHistoryInfo = new PaymentHistoryInfo();
		
		paymentHistoryInfo.setFirstName( res.getFirstName() );
		paymentHistoryInfo.setLastName( res.getLastName() );
		paymentHistoryInfo.setPaymentMode( res.getPaymentMode() );
		paymentHistoryInfo.setInstrNo( res.getInstrNo() );
		paymentHistoryInfo.setSign( res.getSign() );
		if( res.getAmountPaid() != null ){
			paymentHistoryInfo.setAmountPaid( res.getAmountPaid().doubleValue() );
		}
		if( res.getPaymentDate() != null ){
			paymentHistoryInfo.setPaymentDate( this.getDate( res.getPaymentDate() ) );
		}
		
		return paymentHistoryInfo;
	}
	
	/**
	 * method to prepare PaymentInformation BO
	 * @param paymentInformation
	 * @return paymentInformationReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paymentinformation.v1.PaymentInformation getPaymentInformationReq(PaymentInformation paymentInformation){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paymentinformation.v1.PaymentInformation paymentInformationReq = 
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paymentinformation.v1.PaymentInformation();
		
		paymentInformationReq.setBookingNo( paymentInformation.getBookingNo() );
		paymentInformationReq.setCreditCardFlag( Character.toString(paymentInformation.getCreditCardFlag()) );
		paymentInformationReq.setGuaranteedCheckFlag( Character.toString(paymentInformation.getGuaranteedCheckFlag() ) );
		paymentInformationReq.setMoneyTransferFlag( Character.toString( paymentInformation.getMoneyTransferFlag() ) );
		if( paymentInformation.getCreditCard() != null ){
			paymentInformationReq.setCreditCard( this.getCreditCardReq(paymentInformation.getCreditCard()) );
		}
		if( paymentInformation.getGuaranteedCheck() != null ){
			paymentInformationReq.setGuaranteedCheck( this.getGuaranteedCheckReq(paymentInformation.getGuaranteedCheck()) );
		}
		if( paymentInformation.getMoneyTransfer() != null ){
			paymentInformationReq.setMoneyTransfer( this.getMoneyTransferReq(paymentInformation.getMoneyTransfer()) );
		}
		if( this.getIMApplicationInfo() != null ){
			paymentInformationReq.setImApplicationInfo( this.getIMApplicationInfoReq( this.getIMApplicationInfo() ) );
		}
		
		return paymentInformationReq;
	}
	
	/**
	 * Method to prepare PaymentInformation DTO from BO
	 * @param res
	 * @return paymentInformation
	 */
	public PaymentInformation getPaymentInformation(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paymentinformation.v1.PaymentInformation res){
		PaymentInformation paymentInformation = new PaymentInformation();
		
		paymentInformation.setBookingNo( res.getBookingNo() );
		if( res.getCreditCardFlag() != null ){
			paymentInformation.setCreditCardFlag( res.getCreditCardFlag().charAt(0) );
		}
		if( res.getGuaranteedCheckFlag() != null ){
			paymentInformation.setGuaranteedCheckFlag( res.getGuaranteedCheckFlag().charAt(0) );
		}
		if( res.getMoneyTransferFlag() != null ){
			paymentInformation.setMoneyTransferFlag( res.getMoneyTransferFlag().charAt(0) );
		}
		if( res.getImApplicationInfo() != null ){
			paymentInformation.setImApplicationInfo( this.getIMApplicationInfo( res.getImApplicationInfo() ) );
		}
		if( res.getGuaranteedCheck() != null ){
			paymentInformation.setGuaranteedCheck( this.getGuaranteedCheck( res.getGuaranteedCheck() ) );
		}
		if( res.getMoneyTransfer() != null ){
			paymentInformation.setMoneyTransfer( this.getMoneyTransfer( res.getMoneyTransfer() ) );
		}
		if( res.getCreditCard() != null ){
			paymentInformation.setCreditCard( this.getCreditCard( res.getCreditCard() ) );
		}
		
		return paymentInformation;
	}
	
	/**
	 * method to prepare PaymentMethod DTO from BO
	 * @param res
	 * @return paymentMethod
	 */
	public PaymentMethod getPaymentMethod(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paymentmethod.v1.PaymentMethod res ){
		PaymentMethod paymentMethod = new PaymentMethod();
		
		if( res.getMethod() != null ){
			paymentMethod.setMethod( res.getMethod().charAt(0) );
		}
		paymentMethod.setDescription( res.getDescription() );
		
		return paymentMethod;
	}
	/**
	 * method to prepare PaxTypeBasePrices BO
	 * @param paxTypeBasePrices
	 * @return paxTypeBasePricesReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paxtypebaseprices.v1.PaxTypeBasePrices getPaxTypeBasePricesReq(PaxTypeBasePrices paxTypeBasePrices){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paxtypebaseprices.v1.PaxTypeBasePrices paxTypeBasePricesReq =
		new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paxtypebaseprices.v1.PaxTypeBasePrices();
		paxTypeBasePricesReq.setNoOfAdults( paxTypeBasePrices.getNoOfAdults() );
		paxTypeBasePricesReq.setNoOfChilds( paxTypeBasePrices.getNoOfChilds() );
		paxTypeBasePricesReq.setNoOfInfants( paxTypeBasePrices.getNoOfInfants() );
		paxTypeBasePricesReq.setNoOfLapChilds( paxTypeBasePrices.getNoOfLapChilds() );
		paxTypeBasePricesReq.setNoOfSeniors( paxTypeBasePrices.getNoOfSeniors() );
		paxTypeBasePricesReq.setChild1Age( paxTypeBasePrices.getChild1Age() );
		paxTypeBasePricesReq.setChild2Age( paxTypeBasePrices.getChild2Age() );
		paxTypeBasePricesReq.setChild3Age( paxTypeBasePrices.getChild3Age() );
		paxTypeBasePricesReq.setChild4Age( paxTypeBasePrices.getChild4Age() );
		paxTypeBasePricesReq.setChild5Age( paxTypeBasePrices.getChild5Age() );
		paxTypeBasePricesReq.setChild6Age( paxTypeBasePrices.getChild6Age() );
		paxTypeBasePricesReq.setNoOfJuniors( paxTypeBasePrices.getNoOfJuniors() );
		paxTypeBasePricesReq.setNoOfMinors( paxTypeBasePrices.getNoOfMinors() );
		paxTypeBasePricesReq.setChild1Type( paxTypeBasePrices.getChild1Type() );
		paxTypeBasePricesReq.setChild2Type( paxTypeBasePrices.getChild2Type() );
		paxTypeBasePricesReq.setChild3Type( paxTypeBasePrices.getChild3Type() );
		paxTypeBasePricesReq.setChild4Type( paxTypeBasePrices.getChild4Type() );
		paxTypeBasePricesReq.setChild5Type( paxTypeBasePrices.getChild5Type() );
		paxTypeBasePricesReq.setChild6Type( paxTypeBasePrices.getChild6Type() );
		paxTypeBasePricesReq.setAdultBasePrice( new Double( paxTypeBasePrices.getAdultBasePrice() ) );
		paxTypeBasePricesReq.setChildBasePrice( new Double( paxTypeBasePrices.getChildBasePrice() ) );
		paxTypeBasePricesReq.setSeniorBasePrice( new Double( paxTypeBasePrices.getSeniorBasePrice() ) );
		paxTypeBasePricesReq.setInfantBasePrice( new Double( paxTypeBasePrices.getInfantBasePrice() ) );
		paxTypeBasePricesReq.setLapChildBasePrice( new Double( paxTypeBasePrices.getLapChildBasePrice() ) );
		paxTypeBasePricesReq.setJuniorBasePrice( new Double( paxTypeBasePrices.getJuniorBasePrice() ) );
		paxTypeBasePricesReq.setMinorBasePrice( new Double( paxTypeBasePrices.getMinorBasePrice() ) );
		
		return paxTypeBasePricesReq;
	}
	/**
	 * Method to prepare PaxTypePriceBreakup BO
	 * @param paxTypePriceBreakup
	 * @return paxTypePriceBreakupReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paxtypepricebreakup.v1.PaxTypePriceBreakup getPaxTypePriceBreakupReq(PaxTypePriceBreakup paxTypePriceBreakup){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paxtypepricebreakup.v1.PaxTypePriceBreakup paxTypePriceBreakupReq =
		new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paxtypepricebreakup.v1.PaxTypePriceBreakup();
		
		paxTypePriceBreakupReq.setPaxType( Character.toString( paxTypePriceBreakup.getPaxType() ) );
		paxTypePriceBreakupReq.setCount( new Integer( paxTypePriceBreakup.getCount() ) );
		paxTypePriceBreakupReq.setTaxes( new Double( paxTypePriceBreakup.getTaxes() ) );
		paxTypePriceBreakupReq.setPrice( new Double( paxTypePriceBreakup.getPrice() ) );
		paxTypePriceBreakupReq.setUsTax( new Double( paxTypePriceBreakup.getUsTax() ) );
		paxTypePriceBreakupReq.setForeignTax( new Double( paxTypePriceBreakup.getForeignTax() ) );
		paxTypePriceBreakupReq.setAirportTax( new Double( paxTypePriceBreakup.getAirportTax() ) );
		paxTypePriceBreakupReq.setTotalAmount( new Double( paxTypePriceBreakup.getTotalAmount() ) );
		paxTypePriceBreakupReq.setTypeRule( paxTypePriceBreakup.getTypeRule() );
		paxTypePriceBreakupReq.setMinAge( new Byte( paxTypePriceBreakup.getMinAge() ) );
		paxTypePriceBreakupReq.setMaxAge( new Byte( paxTypePriceBreakup.getMaxAge() ) );
		paxTypePriceBreakupReq.setSavings( new Double( paxTypePriceBreakup.getSavings() ) );
		paxTypePriceBreakupReq.setRoomId( new Byte( paxTypePriceBreakup.getRoomId() ) );
		paxTypePriceBreakupReq.setAge( new Byte( paxTypePriceBreakup.getAge() ) );
		
		return paxTypePriceBreakupReq;
	}
	
	/**
	 * method to prepare PaxTypePriceBreakup DTO from Bo
	 * @param res
	 * @return paxTypePriceBreakup
	 */
	public PaxTypePriceBreakup getPaxTypePriceBreakup(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paxtypepricebreakup.v1.PaxTypePriceBreakup res){
		PaxTypePriceBreakup paxTypePriceBreakup = new PaxTypePriceBreakup();
		
		paxTypePriceBreakup.setTypeRule( res.getTypeRule() );
		if( res.getPaxType() != null ){
			paxTypePriceBreakup.setPaxType( res.getPaxType().charAt(0) );
		}
		if( res.getCount() != null ){
			paxTypePriceBreakup.setCount( res.getCount().intValue() );
		}
		if( res.getTaxes() != null ){
			paxTypePriceBreakup.setTaxes( res.getTaxes().doubleValue() );
		}
		if( res.getPrice() != null ){
			paxTypePriceBreakup.setPrice( res.getPrice().doubleValue() );
		}
		if( res.getUsTax() != null ){
			paxTypePriceBreakup.setUsTax( res.getUsTax().doubleValue() );
		}
		if( res.getForeignTax() != null ){
			paxTypePriceBreakup.setForeignTax( res.getForeignTax().doubleValue() );
		}
		if( res.getAirportTax() != null ){
			paxTypePriceBreakup.setAirportTax( res.getAirportTax().doubleValue() );
		}
		if( res.getTotalAmount() != null ){
			paxTypePriceBreakup.setTotalAmount( res.getTotalAmount().doubleValue() );
		}
		if( res.getMinAge() != null ){
			paxTypePriceBreakup.setMinAge( res.getMinAge().byteValue() );
		}
		if( res.getMaxAge() != null ){
			paxTypePriceBreakup.setMaxAge( res.getMaxAge().byteValue() );
		}
		if( res.getSavings() != null ){
			paxTypePriceBreakup.setSavings( res.getSavings().doubleValue() );
		}
		if( res.getLateFee() != null ){
			paxTypePriceBreakup.setLateFee( res.getLateFee().doubleValue() );
		}
		return paxTypePriceBreakup;
	}
	
	/**
	 * Method to prepare ResortArea DTO from BO
	 * @param res
	 * @return resortArea
	 */
	public ResortArea getResortArea(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.resortarea.v1.ResortArea res){
		ResortArea resortArea = new ResortArea();
		
		resortArea.setResortAreaCode( res.getResortAreaCode() );
		resortArea.setResortAreaName( res.getResortAreaName() );
		
		return resortArea;
	}
	
	/**
	 * method to prepare ResortArea DTO from Bo
	 * @param resortArea
	 * @return resortAreaReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.resortarea.v1.ResortArea getResortAreaReq(ResortArea resortArea){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.resortarea.v1.ResortArea resortAreaReq = 
										new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.resortarea.v1.ResortArea();
		
		resortAreaReq.setResortAreaCode( resortArea.getResortAreaCode() );
		resortAreaReq.setResortAreaName( resortArea.getResortAreaName() );
		
		return resortAreaReq;
	}
	/**
	 * method to prepare RoomCategory BO
	 * @param roomCategory
	 * @return roomCategoryReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory getRoomCategoryReq(RoomCategory roomCategory){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory roomCategoryReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory();
		
		roomCategoryReq.setHotelId( new Integer( roomCategory.getHotelId() ) );
		roomCategoryReq.setRoomCategoryId( new Integer( roomCategory.getRoomCategoryId() ) );

		roomCategoryReq.setRoomTypeCode( roomCategory.getRoomTypeCode() );
		String desc = roomCategory.getRoomTypeDescription();
        if(desc!=null && desc.contains(":")){
            String split[]=desc.split(":");
            String description= split[0]+split[split.length-1];
            System.out.println(description);
            roomCategoryReq.setRoomTypeDescription(description); 
        }else{
        	roomCategoryReq.setRoomTypeDescription( roomCategory.getRoomTypeDescription()!=null? roomCategory.getRoomTypeDescription().replaceAll(": ", ""):"" );
        }
//		String roomTypeCode = roomCategory.getRoomTypeCode();
//		if(roomTypeCode.contains("-RD-")) {
//			String [] splitRoomTypeCode = null;
//			splitRoomTypeCode = roomTypeCode.split("-RD-");
//			roomCategoryReq.setRoomTypeCode(splitRoomTypeCode[0]);
//			roomCategoryReq.setRoomTypeDescription(splitRoomTypeCode[1]);
//		}
		
		
		
		
		roomCategoryReq.setRatePlanId( roomCategory.getRatePlanId() );
		roomCategoryReq.setRatePlanCode( roomCategory.getRatePlanCode() );
		roomCategoryReq.setRatePlanDescription( roomCategory.getRatePlanDescription() );
		roomCategoryReq.setRateIndicator( roomCategory.getRateIndicator() );
		roomCategoryReq.setCorporateId( roomCategory.getCorporateId() );
		roomCategoryReq.setGuaranteeType( roomCategory.getGuaranteeType() );
		roomCategoryReq.setGuaranteeMethod( roomCategory.getGuaranteeMethod() );
		roomCategoryReq.setGuaranteeRequired( roomCategory.getGuaranteeRequired() );
		roomCategoryReq.setGuaranteeAmount( new Double( roomCategory.getGuaranteeAmount() ) );
		roomCategoryReq.setRatePlanCategory( roomCategory.getRatePlanCategory() );
		roomCategoryReq.setNoOfRoomsAvailable( new Integer( roomCategory.getNoOfRoomsAvailable() ) );
		roomCategoryReq.setStatus( roomCategory.getStatus() );
		roomCategoryReq.setCurrency( roomCategory.getCurrency() );
		roomCategoryReq.setPosnr( roomCategory.getPosnr() );
		roomCategoryReq.setOldPosnr( roomCategory.getOldPosnr() );
		roomCategoryReq.setRiskRoomCategory( new Boolean( roomCategory.isRiskRoomCategory() ) );
		roomCategoryReq.setAppleChoice( new Boolean( roomCategory.getAppleChoice() ) );
		roomCategoryReq.setMealplanDesc( roomCategory.getMealplanDesc() );
		if( roomCategory.getDisplayRoomPrice()!= null ){
			roomCategoryReq.setDisplayRoomPrice( this.getRoomPriceReq( roomCategory.getDisplayRoomPrice() ) );
		}
		if( roomCategory.getMealPlanType() != null ){
			roomCategoryReq.setMealPlanType( this.getMealPlanTypeReq( roomCategory.getMealPlanType() ) );
		}
		
		if( (roomCategory.getRoomPrices() != null) && (roomCategory.getRoomPrices().size() > 0) ){
			for(int i=0; i < roomCategory.getRoomPrices().size(); i++){
				roomCategoryReq.getRoomPrices().add( this.getRoomPriceReq(roomCategory.getRoomPrices().get(i)));
			}
		}
		if( (roomCategory.getAmenities() != null) && (roomCategory.getAmenities().size() > 0) ){
			for(int i=0; i < roomCategory.getAmenities().size(); i++){
				roomCategoryReq.getAmenities().add( this.getAmenityReq( roomCategory.getAmenities().get(i) ) );
			}
		}
		
		if(roomCategory!=null && roomCategory.getHbsiRates()!=null && roomCategory.getHbsiRates().size()>0)
		{
			HBSiRates hbsi;
			 
			for(int hbsiRate=0;hbsiRate<roomCategory.getHbsiRates().size();hbsiRate++)
			{
				if(roomCategory.getHbsiRates().get(hbsiRate)!=null)
				{
					Object hbsiRateObject = roomCategory.getHbsiRates().get(hbsiRate);
					if(hbsiRateObject instanceof HBSiRates)
					{
						roomCategoryReq.getHbsiRates().add(hbsiRate,this.getHBSiRateReq(roomCategory.getHbsiRates().get(hbsiRate)));
					}
//					else 	if(hbsiRateObject instanceof ASObject)
//					{
//						ASTranslator ast = new ASTranslator();
//						ASObject hbsiAsObject = (ASObject)hbsiRateObject;
//						hbsiAsObject.setType("com.kcdata.abe.data.dto.HBSiRates");
//						hbsi= (HBSiRates)ast.convert(hbsiAsObject, HBSiRates.class);
//						roomCategoryReq.getHbsiRates().add(this.getHBSiRateReq(hbsi));
//					}
				}
			}
		}
		
		//Set cancel Policy
		
		if(roomCategory!=null && roomCategory.getCancelPolicy()!=null && roomCategory.getCancelPolicy().size()>0)
		{
			com.kcdata.abe.data.dto.CancelPolicy cancelPolicy;
			
			for(int cancel=0;cancel<roomCategory.getCancelPolicy().size();cancel++)
			{
				if(roomCategory.getCancelPolicy().get(cancel)!=null)
				{
					Object cancelObject = roomCategory.getCancelPolicy().get(cancel);
					if(cancelObject instanceof com.kcdata.abe.data.dto.CancelPolicy)
					{
						roomCategoryReq.getCancelPolicy().add(cancel,this.getCancelPolicyReq(roomCategory.getCancelPolicy().get(cancel)));
					}
//					else if(cancelObject instanceof ASObject)
//					{
//						ASTranslator ast = new ASTranslator();
//						ASObject cancelASObject = (ASObject)cancelObject;
//						cancelASObject.setType("com.kcdata.abe.data.dto.CancelPolicy");
//						cancelPolicy=(com.kcdata.abe.data.dto.CancelPolicy)ast.convert(cancelASObject, com.kcdata.abe.data.dto.CancelPolicy.class);
//						
//						roomCategoryReq.getCancelPolicy().add(this.getCancelPolicyReq(cancelPolicy));
//						
//					}
				
				}
				
			}
		}
		return roomCategoryReq;
	}
	
	/**
	 * Method to prepare RoomCategory DTO from BO
	 * @param res
	 * @return roomCategory
	 */
	public RoomCategory getRoomCategory(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory res){
		RoomCategory roomCategory = new RoomCategory();
		
		roomCategory.setRoomTypeCode( res.getRoomTypeCode() );
		roomCategory.setRoomTypeDescription( res.getRoomTypeDescription() );
		
//		Code to set the room description in UI
		String roomDescription = res.getRoomTypeDescription();
		if (roomDescription!=null && roomDescription.contains(":")) {
			int firstColonIndex=roomDescription.indexOf(":");
			int lastCOlonIndex= roomDescription.lastIndexOf(":");
			String removedString = (roomDescription.substring(firstColonIndex,lastCOlonIndex+1));
			String roomTypeToBediplayedonUI = roomDescription.replace(removedString, "");
			
			roomCategory.setRoomTypeCode( res.getRoomTypeCode() + "-RD-" + roomDescription);
			roomCategory.setRoomTypeDescription(roomTypeToBediplayedonUI);
		}
		else{
			//Start the fix of HBSI 52 - Phase 1 // Setting the default roomTypeCode and Description
			roomCategory.setRoomTypeCode( res.getRoomTypeCode());
			roomCategory.setRoomTypeDescription(res.getRoomTypeDescription());
		}
		  //End the fix of HBSI 52 -Phase 1 
		roomCategory.setRatePlanId( res.getRatePlanId() );
		roomCategory.setRatePlanCode( res.getRatePlanCode() );
		roomCategory.setRatePlanDescription( res.getRatePlanDescription() );
		if( res.getRateIndicator() != null ){
			roomCategory.setRateIndicator( res.getRateIndicator() );
		}
		else{
			roomCategory.setRateIndicator( "" );
		}
		if( res.getCorporateId() != null ){
			roomCategory.setCorporateId( res.getCorporateId() );
		}
		else{
			roomCategory.setCorporateId( "" );
		}
		if( res.getGuaranteeType() != null ){
		roomCategory.setGuaranteeType( res.getGuaranteeType() );
		}
		else{
			roomCategory.setGuaranteeType( "" );
		}
		if( res.getGuaranteeMethod() != null ){
		roomCategory.setGuaranteeMethod( res.getGuaranteeMethod() );
		}
		else{
			roomCategory.setGuaranteeMethod( "" );
		}
		if( res.getGuaranteeRequired() != null ){
		roomCategory.setGuaranteeRequired( res.getGuaranteeRequired() );
		}
		else{
			roomCategory.setGuaranteeRequired( "" );
		}
		roomCategory.setRatePlanCategory( res.getRatePlanCategory() );
		roomCategory.setStatus( res.getStatus() );
		if( res.getCurrency() != null ){
			roomCategory.setCurrency( res.getCurrency() );
		}
		else{
			roomCategory.setCurrency( "" );
		}
		roomCategory.setPosnr( res.getPosnr() );
		roomCategory.setOldPosnr( res.getOldPosnr() );
		roomCategory.setMealplanDesc( res.getMealplanDesc() );
		if( res.getHotelId() != null ){
			roomCategory.setHotelId( res.getHotelId().intValue() );
		}
		if( res.getRoomCategoryId() != null ){
			roomCategory.setRoomCategoryId( res.getRoomCategoryId().intValue() );
		}
		if( res.getNoOfRoomsAvailable() != null ){
			roomCategory.setNoOfRoomsAvailable( res.getNoOfRoomsAvailable().intValue() );
		}
		if( res.isRiskRoomCategory() != null ){
			roomCategory.setRiskRoomCategory( res.isRiskRoomCategory().booleanValue() );
		}
		if( res.isAppleChoice() != null ){
			roomCategory.setAppleChoice( res.isAppleChoice().booleanValue() );
		}
		if( res.getGuaranteeAmount() != null ){
			roomCategory.setGuaranteeAmount( res.getGuaranteeAmount() );
		}
		if( res.getDisplayRoomPrice() != null ){
			roomCategory.setDisplayRoomPrice( this.getRoomPrice( res.getDisplayRoomPrice() ) );
		}
		if( (res.getMealPlanType() != null) && (res.getMealPlanType().getCode() != null) ){
			roomCategory.setMealPlanType( this.getMealPlanType( res.getMealPlanType() ) );
		}
		if( (res.getRoomPrices() != null) && (res.getRoomPrices().size() > 0) ){
			List<RoomPrice> roomPrices = new ArrayList<RoomPrice>();
			for(int i=0; i < res.getRoomPrices().size(); i++){
				if( res.getRoomPrices().get(i) != null )
				roomPrices.add( this.getRoomPrice( res.getRoomPrices().get(i) ) );
			}
			roomCategory.setRoomPrices( roomPrices );
		}
		if( (res.getAmenities() != null) && (res.getAmenities().size() > 0) ){
			List<Amenity> amenities = new ArrayList<Amenity>(res.getAmenities().size());
			for(int i=0; i < res.getAmenities().size(); i++){
				if( res.getAmenities().get(i) != null )
				amenities.add( this.getAmenity( res.getAmenities().get(i) ) );
			}
			roomCategory.setAmenities( amenities );
		}
		
		if(res!=null && res.getHbsiRates()!=null && res.getHbsiRates().size()>0){
			List<HBSiRates> hbsiRates = new ArrayList<HBSiRates>(res.getHbsiRates().size());
			for(int hbsiRate=0;hbsiRate<res.getHbsiRates().size();hbsiRate++)
			{
				if(res.getHbsiRates().get(hbsiRate)!=null)
				{
					hbsiRates.add(this.getHBSiRate(res.getHbsiRates().get(hbsiRate)));
					//roomCategory.getHbsiRates().add(hbsiRate, getHBSiRate(res.getHbsiRates().get(hbsiRate)));
					
				}
			}
			roomCategory.setHbsiRates(hbsiRates);
		}
		
		//set Cancel Policy for room category
		if(res!=null && res.getCancelPolicy()!=null && res.getCancelPolicy().size()>0)
		{
			List<com.kcdata.abe.data.dto.CancelPolicy> canccelPolicies = new ArrayList<com.kcdata.abe.data.dto.CancelPolicy>(res.getCancelPolicy().size());
			for(int cancelPolicy=0;cancelPolicy<res.getCancelPolicy().size();cancelPolicy++)
			{
				if(res.getCancelPolicy().get(cancelPolicy)!=null)
				{
					canccelPolicies.add(this.getCancelPolicy(res.getCancelPolicy().get(cancelPolicy)));
				}
			}
			
			roomCategory.setCancelPolicy(canccelPolicies);
		}
		return roomCategory;
	}
	/**
	 * Method to prepare RoomPrice BO
	 * @param roomPrice
	 * @return roomPriceReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice getRoomPriceReq(RoomPrice roomPrice){com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice roomPriceReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice();
		
				//Setting two more fields to hold transfer cost and hotel cost
			roomPriceReq.setHotelCost(roomPrice.getHotelCost());
			roomPriceReq.setTransferCost(roomPrice.getTransferCost());
	
	
	
		roomPriceReq.setHotelId( new Integer( roomPrice.getHotelId() ) );
		roomPriceReq.setRoomCategoryId( new Integer( roomPrice.getRoomCategoryId() ) );
		roomPriceReq.setRoomId( new Byte( roomPrice.getRoomId() ) );
		roomPriceReq.setTotalAmount( new Double( roomPrice.getTotalAmount() ) );
		roomPriceReq.setTax( new Double( roomPrice.getTax() ) );
		roomPriceReq.setCommissionAmount( new Double( roomPrice.getCommissionAmount() ) );
		roomPriceReq.setCommissionPercent( new Double( roomPrice.getCommissionPercent() ) );
		roomPriceReq.setLateFee( new Double( roomPrice.getLateFee() ) );
		roomPriceReq.setFreeNights( new Integer( roomPrice.getFreeNights() ) );
		roomPriceReq.setPromoSavingsAmount( new Double( roomPrice.getPromoSavingsAmount() ) );
		roomPriceReq.setSavings( new Double( roomPrice.getSavings() ) );
		roomPriceReq.setCurrency( roomPrice.getCurrency() );
		roomPriceReq.setPriceChanged( new Boolean( roomPrice.isPriceChanged() ) );
		roomPriceReq.setGuestAllocation( roomPrice.getGuestAllocation() );
		roomPriceReq.setPackagePrice( new Double( roomPrice.getPackagePrice() ) );
		roomPriceReq.setPerAdultBasePrice( new Double( roomPrice.getPerAdultBasePrice() ) );
		roomPriceReq.setPerAdultBasePriceSavings( new Double( roomPrice.getPerAdultBasePriceSavings() ) );
		if( roomPrice.getPaxBasePrices() != null ){
			roomPriceReq.setPaxBasePrices( this.getPaxTypeBasePricesReq( roomPrice.getPaxBasePrices() ) );
		}
		if( (roomPrice.getPaxTypePriceBreakups() != null) && (roomPrice.getPaxTypePriceBreakups().size() > 0) ){
			for(int i=0; i < roomPrice.getPaxTypePriceBreakups().size(); i++){
				roomPriceReq.getPaxTypePriceBreakups().add( this.getPaxTypePriceBreakupReq(roomPrice.getPaxTypePriceBreakups().get(i)) );
			}
		}
	
		return roomPriceReq;
	}
	
	
	
	public RoomPrice getInitialRoomPrice(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice res){
		RoomPrice roomPrice = new RoomPrice();
		
		roomPrice.setCurrency( res.getCurrency() );
		roomPrice.setGuestAllocation( res.getGuestAllocation() );
		if( res.getHotelId() != null ){
			roomPrice.setHotelId( res.getHotelId() );
		}
		if( res.getRoomCategoryId() != null ){
			roomPrice.setRoomCategoryId( res.getRoomCategoryId().intValue() );
		}
		if( res.getFreeNights() != null ){
			roomPrice.setFreeNights( res.getFreeNights().intValue() );
		}
		if( res.getRoomId() != null ){
			roomPrice.setRoomId( res.getRoomId().byteValue() );
		}
		if( res.isPriceChanged() != null ){
			roomPrice.setPriceChanged( res.isPriceChanged().booleanValue() );
		}
		if( res.getPromoSavingsAmount() != null ){
			roomPrice.setPromoSavingsAmount( res.getPromoSavingsAmount().doubleValue() );
		}
		if( res.getSavings() != null ){
			roomPrice.setSavings( res.getSavings().doubleValue() );
		}
		if( res.getTotalAmount() != null ){
			roomPrice.setTotalAmount( res.getTotalAmount().doubleValue() );
		}
		if( res.getTax() != null ){
			roomPrice.setTax( res.getTax().doubleValue() );
		}
		if( res.getCommissionAmount() != null ){
			roomPrice.setCommissionAmount( res.getCommissionAmount().doubleValue() );
		}
		if( res.getCommissionPercent() != null ){
			roomPrice.setCommissionPercent( res.getCommissionPercent().doubleValue() );
		}
		if( res.getLateFee() != null ){
			roomPrice.setLateFee( res.getLateFee().doubleValue() );
		}
		if( res.getPackagePrice() != null ){
			roomPrice.setPackagePrice( res.getPackagePrice().doubleValue() );
		}
		if( res.getPerAdultBasePrice() != null ){
			roomPrice.setPerAdultBasePrice( res.getPerAdultBasePrice().doubleValue() );
		}
		if( res.getPerAdultBasePriceSavings() != null ){
			roomPrice.setPerAdultBasePriceSavings( res.getPerAdultBasePriceSavings().doubleValue() );
		}
		if( res.getPaxBasePrices() != null ){
			roomPrice.setPaxBasePrices( this.getPaxTypeBasePrices( res.getPaxBasePrices() ) );
		}
		if( (res.getPaxTypePriceBreakups() != null) && (res.getPaxTypePriceBreakups().size() > 0) ){
			List<PaxTypePriceBreakup> paxTypePriceBreakups = new ArrayList<PaxTypePriceBreakup>();
			for(int i=0; i < res.getPaxTypePriceBreakups().size(); i++){
				if( res.getPaxTypePriceBreakups().get(i) != null )
				paxTypePriceBreakups.add( this.getPaxTypePriceBreakup( res.getPaxTypePriceBreakups().get(i) ) );
			}
			roomPrice.setPaxTypePriceBreakups(paxTypePriceBreakups);
		}
		roomPrice.setInitialPrice( null );
		
		return roomPrice;
	}
	
	
	/**
	 * Method to prepare RoomPrice DTO from Bo
	 * @param res
	 * @return roomPrice
	 */
	public RoomPrice getRoomPrice(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice res){
		RoomPrice roomPrice = new RoomPrice();
		
		//setting two more new fields to hold hotelCost and transfer cost
		roomPrice.setHotelCost(res.getHotelCost());
		roomPrice.setTransferCost(res.getTransferCost());
		
		
		roomPrice.setCurrency( res.getCurrency() );
		roomPrice.setGuestAllocation( res.getGuestAllocation() );
		if( res.getHotelId() != null ){
			roomPrice.setHotelId( res.getHotelId() );
		}
		if( res.getRoomCategoryId() != null ){
			roomPrice.setRoomCategoryId( res.getRoomCategoryId().intValue() );
		}
		if( res.getFreeNights() != null ){
			roomPrice.setFreeNights( res.getFreeNights().intValue() );
		}
		if( res.getRoomId() != null ){
			roomPrice.setRoomId( res.getRoomId().byteValue() );
		}
		if( res.isPriceChanged() != null ){
			roomPrice.setPriceChanged( res.isPriceChanged().booleanValue() );
		}
		if( res.getPromoSavingsAmount() != null ){
			roomPrice.setPromoSavingsAmount( res.getPromoSavingsAmount().doubleValue() );
		}
		if( res.getSavings() != null ){
			roomPrice.setSavings( res.getSavings().doubleValue() );
		}
		if( res.getTotalAmount() != null ){
			roomPrice.setTotalAmount( res.getTotalAmount().doubleValue() );
		}
		if( res.getTax() != null ){
			roomPrice.setTax( res.getTax().doubleValue() );
		}
		if( res.getCommissionAmount() != null ){
			roomPrice.setCommissionAmount( res.getCommissionAmount().doubleValue() );
		}
		if( res.getCommissionPercent() != null ){
			roomPrice.setCommissionPercent( res.getCommissionPercent().doubleValue() );
		}
		if( res.getLateFee() != null ){
			roomPrice.setLateFee( res.getLateFee().doubleValue() );
		}
		if( res.getPackagePrice() != null ){
			roomPrice.setPackagePrice( res.getPackagePrice().doubleValue() );
		}
		if( res.getPerAdultBasePrice() != null ){
			roomPrice.setPerAdultBasePrice( res.getPerAdultBasePrice().doubleValue() );
		}
		if( res.getPerAdultBasePriceSavings() != null ){
			roomPrice.setPerAdultBasePriceSavings( res.getPerAdultBasePriceSavings().doubleValue() );
		}
		if( res.getPaxBasePrices() != null ){
			roomPrice.setPaxBasePrices( this.getPaxTypeBasePrices( res.getPaxBasePrices() ) );
		}
		if( (res.getPaxTypePriceBreakups() != null) && (res.getPaxTypePriceBreakups().size() > 0) ){
			List<PaxTypePriceBreakup> paxTypePriceBreakups = new ArrayList<PaxTypePriceBreakup>();
			for(int i=0; i < res.getPaxTypePriceBreakups().size(); i++){
				if( res.getPaxTypePriceBreakups().get(i) != null )
				paxTypePriceBreakups.add( this.getPaxTypePriceBreakup( res.getPaxTypePriceBreakups().get(i) ) );
			}
			roomPrice.setPaxTypePriceBreakups(paxTypePriceBreakups);
		}
		if(res.getInitialPrice()!=null)
		{
		roomPrice.setInitialPrice(this.getInitialRoomPrice(res.getInitialPrice()) );
		}
		
		return roomPrice;
	}
	/**
	 * method to prepare Service BO
	 * @param service
	 * @return serviceReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service getServiceReq(Service service){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service serviceReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service();
		
		serviceReq.setServiceCode( service.getServiceCode() );
		serviceReq.setServiceName( service.getServiceName() );
		serviceReq.setGateway( service.getGateway() );
		serviceReq.setDestination( service.getDestination() );
		serviceReq.setAdultPrice( new Double( service.getAdultPrice() ) );
		serviceReq.setChild1Price( new Double( service.getChild1Price() ) );
		serviceReq.setChild2Price( new Double( service.getChild2Price() ) );
		serviceReq.setChild3Price( new Double( service.getChild3Price() ) );
		serviceReq.setChild1MinAge( new Byte( service.getChild1MinAge() ) );
		serviceReq.setChild2MinAge( new Byte( service.getChild2MinAge() ) );
		serviceReq.setChild3MinAge( new Byte( service.getChild3MinAge() ) );
		serviceReq.setChild1MaxAge( new Byte( service.getChild1MaxAge() ) );
		serviceReq.setChild2MaxAge( new Byte( service.getChild2MaxAge() ) );
		serviceReq.setChild3MaxAge( new Byte( service.getChild3MaxAge() ) );
		serviceReq.setCurrency( service.getCurrency() );
		serviceReq.setMaxQuantity( new Double( service.getMaxQuantity() ) );
		serviceReq.setUnitOfMeasure( service.getUnitOfMeasure() );
		serviceReq.setMandatory( new Boolean( service.isMandatory() ) );
		serviceReq.setFree( new Boolean( service.isFree() ) );
		serviceReq.setOccupancyBased( new Boolean( service.isOccupancyBased() ) );
		serviceReq.setDateSpecific( new Boolean( service.isDateSpecific() ) );
		serviceReq.setAllOrNothing( new Boolean( service.isAllOrNothing() ) );
		serviceReq.setWeightBased( new Boolean( service.isWeightBased() ) );
		serviceReq.setTierBased( new Boolean( service.isTierBased() ) );
		serviceReq.setGroupCode( service.getGroupCode() );
		serviceReq.setGroupDescription( service.getGroupDescription() );
		serviceReq.setMonday( new Boolean( service.isMonday() ) );
		serviceReq.setTuesday( new Boolean( service.isTuesday() ) );
		serviceReq.setWednesday( new Boolean( service.isWednesday() ) );
		serviceReq.setThursday( new Boolean( service.isThursday() ) );
		serviceReq.setFriday( new Boolean( service.isFriday() ) );
		serviceReq.setSaturday( new Boolean( service.isSaturday() ) );
		serviceReq.setSunday( new Boolean( service.isSunday() ) );
		serviceReq.setAdultQty( new Byte( service.getAdultQty() ) );
		serviceReq.setChild1Qty( new Byte( service.getChild1Qty() ) );
		serviceReq.setChild2Qty( new Byte( service.getChild2Qty() ) );
		serviceReq.setChild3Qty( new Byte( service.getChild3Qty() ) );
		serviceReq.setTravelAgentFee( new Double( service.getTravelAgentFee() ) );
		serviceReq.setFlightMaterialCode( service.getFlightMaterialCode() );
		serviceReq.setHotelMaterialCode( service.getHotelMaterialCode() );
		serviceReq.setParentItemRph(service.getParentItemRph() );
		serviceReq.setGuestAllocation( service.getGuestAllocation() );
		serviceReq.setTotalPrice( new Double( service.getTotalPrice() ) );
		serviceReq.setPosnr( service.getPosnr() );
		serviceReq.setOldPosnr( service.getOldPosnr() );
		if( service.getSelectedDate() != null ){
			serviceReq.setSelectedDate( this.getDate( service.getSelectedDate() ) );
		}
		if( service.getDepatureDate() != null ){
			serviceReq.setDepatureDate( this.getDate( service.getDepatureDate() ) );
		}
		if( service.getReturnDate() != null ){
			serviceReq.setReturnDate( this.getDate( service.getReturnDate() ));
		}
		if( (service.getAvailableDates() != null) && (service.getAvailableDates().size() > 0) ){
			for(int i=0; i < service.getAvailableDates().size();i++){
				serviceReq.getAvailableDates().add( this.getDate( service.getAvailableDates().get(i) ) );
			}
		}
		if( (service.getServiceDescription() != null) && (service.getServiceDescription().size() > 0) ){
			for(int i=0; i < service.getServiceDescription().size();i++){
				serviceReq.getServiceDescription().add( service.getServiceDescription().get(i) );
			}
		}
		
		return serviceReq;
	}
	/**
	 * Method to prepare SpecialOptions BO
	 * @param specialOptions
	 * @return specialOptionsReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.specialoptions.v1.SpecialOptions getSpecialOptionsReq(SpecialOptions specialOptions){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.specialoptions.v1.SpecialOptions specialOptionsReq = 
							new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.specialoptions.v1.SpecialOptions();
	
		specialOptionsReq.setSpecialCategoryId( specialOptions.getSpecialCategoryId() );
		specialOptionsReq.setSpecialBatchId( specialOptions.getSpecialBatchId() );
		specialOptionsReq.setSpecialId( specialOptions.getSpecialId() );
		
		if( specialOptions.getSpecialRequestType() != null ){
			specialOptionsReq.setSpecialRequestType(this.getSpecialRequestTypeReq( specialOptions.getSpecialRequestType() ));
		}
		if( specialOptions.getSpecialType() != null ){
			specialOptionsReq.setSpecialType( this.getSpecialTypeReq( specialOptions.getSpecialType() ) );
		}
		
		return specialOptionsReq;
	}
	
	/**
	 * Method to prepare SpecialRequestType BO
	 * @param specialRequestType
	 * @return specialRequestTypeReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.specialrequesttype.v1.SpecialRequestType getSpecialRequestTypeReq(SpecialRequestType specialRequestType){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.specialrequesttype.v1.SpecialRequestType specialRequestTypeReq =
							new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.specialrequesttype.v1.SpecialRequestType();
		
		specialRequestTypeReq.setType( specialRequestType.getType() );
		
		return specialRequestTypeReq;
	}
	/**
	 * Method to prepare SpecialType BO
	 * @param specialType
	 * @return specialTypeReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.specialtype.v1.SpecialType getSpecialTypeReq(SpecialType specialType){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.specialtype.v1.SpecialType specialTypeReq = 
							new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.specialtype.v1.SpecialType();
		
		specialTypeReq.setType( specialType.getType() );
		
		return specialTypeReq;
	}
	/**
	 * Method to prepare Service DTO from BO
	 * @param res
	 * @return service
	 */
	public Service getService(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service res){
		Service service = new Service();
		
		service.setServiceCode( res.getServiceCode() );
		service.setServiceName( res.getServiceName() );
		service.setGateway( res.getGateway() );
		service.setCurrency( res.getCurrency() );
		service.setDestination( res.getDestination() );
		service.setUnitOfMeasure( res.getUnitOfMeasure() );
		service.setGroupCode( res.getGroupCode() );
		service.setGroupDescription( res.getGroupDescription() );
		service.setFlightMaterialCode( res.getFlightMaterialCode() );
		service.setHotelMaterialCode( res.getHotelMaterialCode() );
		service.setParentItemRph( res.getParentItemRph() );
		service.setGuestAllocation( res.getGuestAllocation() );
		service.setPosnr( res.getPosnr() );
		service.setOldPosnr( res.getOldPosnr() );
		if( res.isMandatory() != null ){
			service.setMandatory( res.isMandatory().booleanValue() );
		}
		if( res.isFree() != null ){
			service.setFree( res.isFree().booleanValue() );
		}
		if( res.isOccupancyBased() != null ){
			service.setOccupancyBased( res.isOccupancyBased().booleanValue() );
		}
		if( res.isDateSpecific() != null ){
			service.setDateSpecific( res.isDateSpecific().booleanValue() );
		}
		if( res.isAllOrNothing() != null ){
			service.setAllOrNothing( res.isAllOrNothing().booleanValue() );
		}
		if( res.isWeightBased() != null ){
			service.setWeightBased( res.isWeightBased().booleanValue() );
		}
		if( res.isTierBased() != null ){
			service.setTierBased( res.isTierBased().booleanValue() );
		}
		if( res.isMonday() != null ){
			service.setMonday( res.isMonday().booleanValue() );
		}
		if( res.isTuesday() != null ){
			service.setTuesday( res.isTuesday().booleanValue() );
		}
		if( res.isWednesday() != null ){
			service.setWednesday( res.isWednesday().booleanValue() );
		}
		if( res.isThursday() != null ){
			service.setThursday( res.isThursday().booleanValue() );
		}
		if( res.isFriday() != null ){
			service.setFriday( res.isFriday().booleanValue() );
		}
		if( res.isSaturday() != null ){
			service.setSaturday( res.isSaturday().booleanValue() );
		}
		if( res.isSunday() ){
			service.setSunday( res.isSunday().booleanValue() );
		}
		if( res.getSelectedDate() != null ){
			service.setSelectedDate( this.getDate( res.getSelectedDate() ) );
		}
		if( res.getDepatureDate() != null ){
			service.setDepatureDate( this.getDate( res.getDepatureDate() ) );
		}
		if( res.getReturnDate() != null ){
			service.setReturnDate( this.getDate( res.getReturnDate() ) );
		}
		if( res.getAdultQty() != null ){
			service.setAdultQty( res.getAdultQty().byteValue() );
		}
		if( res.getChild1Qty() != null ){
			service.setChild1Qty( res.getChild1Qty().byteValue() );
		}
		if( res.getChild2Qty() != null ){
			service.setChild2Qty( res.getChild2Qty().byteValue() );
		}
		if( res.getChild3Qty() != null ){
			service.setChild3Qty( res.getChild3Qty().byteValue() );
		}
		if( res.getChild1MinAge() != null ){
			service.setChild1MinAge( res.getChild1MinAge().byteValue() );
		}
		if( res.getChild2MinAge() != null ){
			service.setChild2MinAge( res.getChild2MinAge().byteValue() );
		}
		if( res.getChild3MinAge() != null ){
			service.setChild3MinAge( res.getChild3MinAge().byteValue() );
		}
		if( res.getChild1MaxAge() != null ){
			service.setChild1MaxAge( res.getChild1MaxAge().byteValue() );
		}
		if( res.getChild2MaxAge() != null ){
			service.setChild2MaxAge( res.getChild2MaxAge().byteValue() );
		}
		if( res.getChild3MaxAge() != null ){
			service.setChild3MaxAge( res.getChild3MaxAge().byteValue() );
		}
		if( res.getTravelAgentFee() != null ){
			service.setTravelAgentFee( res.getTravelAgentFee().doubleValue() );
		}
		if( res.getTotalPrice() != null ){
			service.setTotalPrice( res.getTotalPrice().doubleValue() );
		}
		if( res.getMaxQuantity() != null ){
			service.setMaxQuantity( res.getMaxQuantity().doubleValue() );
		}
		if( res.getAdultPrice() != null ){
			service.setAdultPrice( res.getAdultPrice().doubleValue() );
		}
		if( res.getChild1Price() != null ){
			service.setChild1Price( res.getChild1Price().doubleValue() );
		}
		if( res.getChild2Price() != null ){
			service.setChild2Price( res.getChild2Price().doubleValue() );
		}
		if( res.getChild3Price() != null ){
			service.setChild3Price( res.getChild3Price().doubleValue() );
		}
		if( (res.getAvailableDates() != null) && (res.getAvailableDates().size() > 0) ){
			service.setAvailableDates( this.convertXMLGregorianCalendarList( res.getAvailableDates() ) );
		}
		service.setServiceDescription( res.getServiceDescription());
		
		return service;
	}
	/**
	 * method to prepare RFARequest BO
	 * @param rfaRequest
	 * @return rfaRequestReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.rfarequest.v1.RFARequest getRFARequestReq(RFARequest rfaRequest){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.rfarequest.v1.RFARequest rfaRequestReq = 
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.rfarequest.v1.RFARequest();
		
		rfaRequestReq.setBookingNumber( rfaRequest.getBookingNumber() );	
		rfaRequestReq.setPosnr( rfaRequest.getPosnr() );
		rfaRequestReq.setConfirmationNumber( rfaRequest.getConfirmationNumber() );
		rfaRequestReq.setRequestMode( rfaRequest.getRequestMode() );
		rfaRequestReq.setVendorEmailId( rfaRequest.getVendorEmailId() );
		rfaRequestReq.setVendorPhoneNUmber( rfaRequest.getVendorPhoneNUmber() );
		rfaRequestReq.setVendorFaxNumber( rfaRequest.getVendorFaxNumber() );
		rfaRequestReq.setVendorMode( rfaRequest.getVendorMode() );	
		rfaRequestReq.setAgentMode( rfaRequest.getAgentMode() );
		rfaRequestReq.setAgentEmailId( rfaRequest.getAgentEmailId() );
		rfaRequestReq.setAgentPhoneNo( rfaRequest.getAgentPhoneNo() );
		rfaRequestReq.setAgentFaxNo( rfaRequest.getAgentFaxNo() );
		rfaRequestReq.setRequestConfirmBy( rfaRequest.getRequestConfirmBy() );
		rfaRequestReq.setRequestDeclineBy( rfaRequest.getRequestDeclineBy() );
		
		return rfaRequestReq;
	}
	/**
	 * Method to prepare RFARequest DTO from BO
	 * @param res
	 * @return rFARequest
	 */
	public RFARequest getRFARequest(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.rfarequest.v1.RFARequest res){
		RFARequest rFARequest = new RFARequest();
		
		rFARequest.setBookingNumber( res.getBookingNumber() );	
		rFARequest.setPosnr( res.getPosnr() );
		rFARequest.setConfirmationNumber( res.getConfirmationNumber() );
		rFARequest.setRequestMode( res.getRequestMode() );
		rFARequest.setVendorEmailId( res.getVendorEmailId() );
		rFARequest.setVendorPhoneNUmber( res.getVendorPhoneNUmber() );
		rFARequest.setVendorFaxNumber( res.getVendorFaxNumber() );
		rFARequest.setVendorMode( res.getVendorMode() );
		rFARequest.setAgentMode( res.getAgentMode() );
		rFARequest.setAgentEmailId( res.getAgentEmailId() );
		rFARequest.setAgentPhoneNo( res.getAgentPhoneNo() );
		rFARequest.setAgentFaxNo( res.getAgentFaxNo());
		rFARequest.setRequestConfirmBy( res.getRequestConfirmBy() );
		rFARequest.setRequestDeclineBy( res.getRequestDeclineBy());
		
		return rFARequest;
	}
	
	/**
	 * getHBSiRate
	 * @param res
	 * @return HBSiRates
	 */
	public HBSiRates getHBSiRate(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hbsirates.v1.HBSiRates res)
	{
		HBSiRates hbsiRate = new HBSiRates();
		if(res.getAmountAfterTax()!=null)
			hbsiRate.setAmountAfterTax(res.getAmountAfterTax().doubleValue());
		if(res.getAmountBeforeTax()!=null)
			hbsiRate.setAmountBeforeTax(res.getAmountBeforeTax().doubleValue());
		if(res.getUnitMultiplier()!=null)
			hbsiRate.setUnitMultiplier(res.getUnitMultiplier().intValue());
		
		hbsiRate.setCurrencyCode(res.getCurrencyCode());
		hbsiRate.setDescription(res.getDescription());
		hbsiRate.setTax(res.getTax());
		
		if(res.getEffectiveDate()!=null)
		{
			hbsiRate.setEffectiveDate(XMLGregorianCalendarConversionUtil.asDate(res.getEffectiveDate()));
		}
		if(res.getExpireDate()!=null)
		{
			hbsiRate.setExpireDate(XMLGregorianCalendarConversionUtil.asDate(res.getExpireDate()));
		}
		
		return hbsiRate;
	}
	
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hbsirates.v1.HBSiRates getHBSiRateReq(HBSiRates req)
	{
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hbsirates.v1.HBSiRates hbSiRates = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hbsirates.v1.HBSiRates();
		
		hbSiRates.setUnitMultiplier(req.getUnitMultiplier());
		hbSiRates.setAmountAfterTax(req.getAmountAfterTax());
		hbSiRates.setAmountBeforeTax(req.getAmountBeforeTax());
		hbSiRates.setCurrencyCode(req.getCurrencyCode());
		hbSiRates.setDescription(req.getDescription());
		hbSiRates.setTax(req.getTax());
		
		if(req.getEffectiveDate()!=null)
			hbSiRates.setEffectiveDate(XMLGregorianCalendarConversionUtil.asXMLGregorianCalendar(req.getEffectiveDate()));
		
		if(req.getExpireDate()!=null)
			hbSiRates.setExpireDate(XMLGregorianCalendarConversionUtil.asXMLGregorianCalendar(req.getExpireDate()));
		
		
		return hbSiRates;	
		
	}
	
	public CancelPolicy getCancelPolicyReq(com.kcdata.abe.data.dto.CancelPolicy req)
	{
		CancelPolicy cancelPolicy = new CancelPolicy();
		
		cancelPolicy.setCancelPolicyCode(req.getCancelPolicyCode());
		if(req.getCancelAmount()!=null)
		{
			cancelPolicy.setCancelAmount(req.getCancelAmount());
		}
		if (req.getNmbrOfNights() !=null){
			cancelPolicy.setNmbrOfNights(req.getNmbrOfNights());
		}
		if(req.getCancelDescription()!=null)
		{
			cancelPolicy.getCancelDescription().addAll(req.getCancelDescription());
		}
		if(req.getCancelPolicyDeadLine()!=null)
		{
			cancelPolicy.setCancelPolicyDeadline(XMLGregorianCalendarConversionUtil.asXMLGregorianCalendar(req.getCancelPolicyDeadLine()));
		}
		return cancelPolicy;
		
	}
	
	public com.kcdata.abe.data.dto.CancelPolicy getCancelPolicy(CancelPolicy res)
	{
		com.kcdata.abe.data.dto.CancelPolicy cancelPolicy = new com.kcdata.abe.data.dto.CancelPolicy();
		
		cancelPolicy.setCancelPolicyCode(res.getCancelPolicyCode());
		if(res.getCancelAmount()!=null)
		{
			cancelPolicy.setCancelAmount(res.getCancelAmount().doubleValue());
		}
		if (res.getNmbrOfNights() !=null){
			cancelPolicy.setNmbrOfNights(res.getNmbrOfNights().doubleValue());
		}
		if(res.getCancelPolicyDeadline()!=null)
		{
			cancelPolicy.setCancelPolicyDeadLine(XMLGregorianCalendarConversionUtil.asDate(res.getCancelPolicyDeadline()));
		}
		if(res.getCancelDescription()!=null && res.getCancelDescription().size()>0)
		{
			cancelPolicy.setCancelDescription(res.getCancelDescription());
		}
		
		return cancelPolicy;
	}
	
	
	
	/**
	 * Method to prepare TripFlight BO
	 * @param tripFlight
	 * @return tripFlightReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.tripflight.v1.TripFlight getTripFlightReq(TripFlight tripFlight){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.tripflight.v1.TripFlight tripFlightReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.tripflight.v1.TripFlight();
		
		//tripFlightReq.setDuration( new Integer(tripFlight.getDuration()) );
		//tripFlightReq.setContractDocumentNo( tripFlight.getContractDocumentNo() );
		//tripFlightReq.setRevisionNo( tripFlight.getRevisionNo() );
		//tripFlightReq.setLineNo( tripFlight.getLineNo() );
		//tripFlightReq.setGuestAllocation( tripFlight.getGuestAllocation() );
		//tripFlightReq.setNegotiatedFareCode( tripFlight.getNegotiatedFareCode() );
		if( tripFlight.getTicketedDate() != null ){
			//tripFlightReq.setTicketedDate( this.getDate( tripFlight.getTicketedDate() ) );
		}
		if( tripFlight.getOccupancy() != null ){
			//tripFlightReq.setOccupancy( this.getOccupancy( tripFlight.getOccupancy() ) );
		}
		if( tripFlight.getTripType() != null ){
			//tripFlightReq.setTripType( this.getFlightTripType(tripFlight.getTripType()) );
		}
		if( tripFlight.getFlightType() != null ){
			//tripFlightReq.setFlightType( this.getFlightType(tripFlight.getFlightType()) );
		}
		if( tripFlight.getStatus() != null ){
			//tripFlightReq.setStatus( this.getFlightStatus(tripFlight.getStatus()) );
		}
		if( tripFlight.getCarrier() != null ){
			//tripFlightReq.setCarrier( this.getCarrier(tripFlight.getCarrier()) );
		}
		if( tripFlight.getOutboundFlight() != null ){
			//tripFlightReq.setOutboundFlight( this.getFlight(tripFlight.getOutboundFlight()) );
		}
		if( tripFlight.getInboundFlight() != null ){
			//tripFlightReq.setInboundFlight( this.getFlight(tripFlight.getInboundFlight()) );
		}
		if( tripFlight.getPrice() != null ){
			//tripFlightReq.setPrice( this.getPrice(tripFlight.getPrice()) );
		}
		
		return tripFlightReq;
	}
	/**
	 * method to prepare TripFlight DTO form BO
	 * @param res
	 * @return tripFlight
	 */
	public TripFlight getTripFlight(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.tripflight.v1.TripFlight res){
		TripFlight tripFlight = new TripFlight();
		/*
		if( res.getDuration() != null ){
			tripFlight.setDuration( res.getDuration().intValue() );
		}
		tripFlight.setContractDocumentNo( res.getContractDocumentNo() );
		tripFlight.setRevisionNo( res.getRevisionNo() );
		tripFlight.setLineNo( res.getLineNo() );
		tripFlight.setGuestAllocation( res.getGuestAllocation() );
		tripFlight.setNegotiatedFareCode( res.getNegotiatedFareCode() );
		if( res.getTicketedDate() != null ){
			tripFlight.setTicketedDate( this.getDate( res.getTicketedDate() ) );
		}
		if( res.isPackageFlightNoChange() != null ){
			tripFlight.setPackageFlightNoChange( res.isPackageFlightNoChange().booleanValue() );
		}
		if( res.getOutboundFlight() != null ){
			tripFlight.setOutboundFlight( this.getFlight( res.getOutboundFlight() ) );
		}
		if( res.getInboundFlight() != null ){
			tripFlight.setInboundFlight( this.getFlight( res.getInboundFlight() ) );
		}
		if( res.getPrice() != null ){
			tripFlight.setPrice( this.getPrice( res.getPrice() ) );
		}
		if( res.getTripType() != null ){
			tripFlight.setTripType( this.getFlightTripType( res.getTripType() ) );
		}
		if( res.getFlightType() != null ){
			tripFlight.setFlightType( this.getFlightType( res.getFlightType() ) );
		}
		if( res.getStatus() != null ){
			tripFlight.setStatus( this.getFlightStatus( res.getStatus() ) );
		}
		if( res.getCarrier() != null ){
			tripFlight.setCarrier( this.getCarrier( res.getCarrier() ) );
		}
		if( res.getOccupancy() != null ){
			tripFlight.setOccupancy( this.getOccupancy( res.getOccupancy() ) );
		}
		*/
		return tripFlight;
	}
	
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vehicle.v1.Vehicle getVehicleReq(Vehicle vehicle){com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vehicle.v1.Vehicle vehicleReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vehicle.v1.Vehicle();
		/*
		vehicleReq.setVehicleId( new Byte(vehicle.getVehicleId()) );
		vehicleReq.setRateCategory( vehicle.getRateCategory() );
		vehicleReq.setCapacity( vehicle.getCapacity() );
		vehicleReq.setUniqueIdType( vehicle.getUniqueIdType() );
		vehicleReq.setNoOfChildSeat( vehicle.getNoOfChildSeat() );
		vehicleReq.setVehicleUniqueId( vehicle.getVehicleUniqueId() );
		vehicleReq.setPickupLocation( vehicle.getPickupLocation() );
		if( vehicle.getPickupTime() != null ){
			vehicleReq.setPickupTime( this.getDate( vehicle.getPickupTime() ));
		}
		vehicleReq.setDropOffLocation( vehicle.getDropOffLocation() );
		if( vehicle.getDropOffTime() != null ){
			vehicleReq.setDropOffTime( this.getDate( vehicle.getDropOffTime() ));
		}
		vehicleReq.setCompanyCode( vehicle.getCompanyCode() );
		vehicleReq.setCompanyDescription( vehicle.getCompanyDescription() );
		vehicleReq.setAirConditionIndicator( vehicle.getAirConditionIndicator() );
		vehicleReq.setDescription( vehicle.getDescription() );
		vehicleReq.setTransmission( vehicle.getTransmission() );
		vehicleReq.setExtendedLocation( vehicle.getExtendedLocation() );
		vehicleReq.setCounterLocation( vehicle.getCounterLocation() );
		vehicleReq.setRateQualifier( vehicle.getRateQualifier() );
		vehicleReq.setDoorCount( vehicle.getDoorCount() );
		vehicleReq.setUniqueId( vehicle.getUniqueId() );
		vehicleReq.setCurrency( vehicle.getCurrency() );
		vehicleReq.setRatePlanCategory( vehicle.getRatePlanCategory() );
		vehicleReq.setGuestAllocation( vehicle.getGuestAllocation() );
		vehicleReq.setGateway( vehicle.getGateway() );
		vehicleReq.setDestination( vehicle.getDestination() );
		vehicleReq.setPosnr( vehicle.getPosnr() );
		vehicleReq.setOldPosnr( vehicle.getOldPosnr() );
		vehicleReq.setStatus( vehicle.getStatus() );
		if( vehicle.getPrice() != null ){
			vehicleReq.setStatus( this.getPrice( vehicle.getPrice() ) );
		}
		if( vehicle.getVehicleCategory() != null ){
			vehicleReq.setVehicleCategory( vehicle.getVehicleCategory().getCategory() );
		}
		if( vehicle.getVehicleClass() != null ){
			vehicleReq.setVehicleClass( vehicle.getVehicleClass().getVehicleClass() );
		}
		*/
		return vehicleReq;
	}
	
	public Vehicle getVehicle(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vehicle.v1.Vehicle res){
		Vehicle vehicle = new Vehicle();
		/*
		vehicle.setVehicleUniqueId( res.getVehicleUniqueId() );
		vehicle.setPickupLocation( res.getPickupLocation() );
		vehicle.setDropOffLocation( res.getDropOffLocation() );
		vehicle.setCompanyCode( res.getCompanyCode() );
		vehicle.setCompanyDescription( res.getCompanyDescription() );
		vehicle.setAirConditionIndicator( res.getAirConditionIndicator() );
		vehicle.setDescription( res.getDescription() );
		vehicle.setTransmission( res.getTransmission() );
		vehicle.setExtendedLocation( res.getExtendedLocation() );
		vehicle.setCounterLocation( res.getCounterLocation() );
		vehicle.setRateQualifier( res.getRateQualifier() );
		vehicle.setDoorCount( res.getDoorCount() );
		vehicle.setUniqueId( res.getUniqueId() );
		vehicle.setCurrency( res.getCurrency() );
		vehicle.setRatePlanCategory( res.getRatePlanCategory() );
		vehicle.setGuestAllocation( res.getGuestAllocation() );
		vehicle.setGateway( res.getGateway() );
		vehicle.setDestination( res.getDestination() );
		vehicle.setPosnr( res.getPosnr() );
		vehicle.setOldPosnr( res.getOldPosnr() );
		vehicle.setStatus( res.getStatus() );
		if( res.getPickupTime() != null ){
			vehicle.setPickupTime( this.getDate( res.getPickupTime() ) );
		}
		if( res.getDropOffTime() != null ){
			vehicle.setDropOffTime( this.getDate( res.getDropOffTime() ) );
		}
		if( res.getRateCategory() != null ){
			vehicle.setRateCategory( res.getRateCategory().byteValue() );
		}
		if( res.getVehicleId() != null ){
			vehicle.setVehicleId( res.getVehicleId().byteValue() );
		}
		if( res.getUniqueIdType() != null ){
			vehicle.setUniqueIdType( res.getUniqueIdType().byteValue() );
		}
		if( res.getCapacity() != null ){
			vehicle.setCapacity( res.getCapacity().byteValue() );
		}
		if( res.getNoOfChildSeat() != null ){
			vehicle.setNoOfChildSeat( res.getNoOfChildSeat().byteValue() );
		}
		if( res.getPrice() != null ){
			vehicle.setPrice( this.getPrice( res.getPrice() ) );
		}
		if( res.getVehicleCategory() != null ){
			vehicle.setVehicleCategory( this.getVehicleCategory( res.getVehicleCategory() ) );
		}
		if( res.getVehicleClass() != null ){
			vehicle.setVehicleClass( this.getVehicleClass( res.getVehicleClass() ) )
		}
		*/

		return vehicle;
	}
	/**
	 * Method to prepare Vendor DTO form BO
	 * @param res
	 * @return vendor
	 */
	public Vendor getVendor(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vendor.v1.Vendor res){
		Vendor vendor = new Vendor();
		vendor.setVendorId( res.getVendorId() );
		vendor.setFirstName( res.getFirstName() );
		vendor.setLastName( res.getLastName() );
		vendor.setStreetAddrs( res.getStreetAddrs() );
		vendor.setCity( res.getCity() );
		vendor.setRegion( res.getRegion() );
		vendor.setCountry( res.getCountry() );
		vendor.setPostalCode( res.getPostalCode() );
		vendor.setPhone( res.getPhone() );
		vendor.setEmail( res.getEmail() );
		vendor.setFaxNo( res.getFaxNo() );
		vendor.setMode( res.getMode() );
		if( res.isVendorExist() != null ){
			vendor.setVendorExist( res.isVendorExist().booleanValue() );
		}
		
		return vendor;
	}
	/**
	 * method to prepare VendorService BO
	 * @param vendorService
	 * @return vendorServiceReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vendorservice.v1.VendorService getVendorServiceReq(VendorService vendorService){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vendorservice.v1.VendorService vendorServiceReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vendorservice.v1.VendorService();
		
		vendorServiceReq.setVendorId( new Integer( vendorService.getVendorId() ) );
		vendorServiceReq.setServiceCode( vendorService.getServiceCode() );
		vendorServiceReq.setServiceName( vendorService.getServiceName() );
		vendorServiceReq.setPrice( new Double( vendorService.getPrice() ) );
		vendorServiceReq.setCurrency( vendorService.getCurrency() );
		
		return vendorServiceReq;
	}
	/**
	 * Method to prepare VendorService DTO from BO
	 * @param res
	 * @return vendorService
	 */ 
	public VendorService getVendorService(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vendorservice.v1.VendorService res){
		VendorService vendorService = new VendorService();
		
		if( res.getVendorId() != null ){
			vendorService.setVendorId( res.getVendorId().intValue() );
		}
		if( res.getPrice() != null ){
			vendorService.setPrice( res.getPrice().doubleValue() );
		}
		
		vendorService.setServiceCode( res.getServiceCode() );
		vendorService.setServiceName( res.getServiceName() );
		vendorService.setCurrency( res.getCurrency() );
		
		return vendorService;
	}
	/**
	 * Method to prepare UserType BO
	 * @param userType
	 * @return userTypeReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.usertype.v1.UserType getUserTypeReq(UserType userType){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.usertype.v1.UserType userTypeReq = 
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.usertype.v1.UserType();
		
		userTypeReq.setCode(new Integer(userType.getCode()));
		
		return userTypeReq;
	}
	/**
	 * Method to prepare  UserType DTO from BO
	 * @param res
	 * @return UserType
	 */
	public UserType getUserType(com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.usertype.v1.UserType res){
		if( res.getCode().intValue() == 1 ){
			return UserType.CUSTOMER;
		}
		if( res.getCode().intValue() == 4 ){
			return UserType.TRAVEL_AGENT;
		}
		if( res.getCode().intValue() == 9 ){
			return UserType.RESERVATION_AGENT;
		}
		if( res.getCode().intValue() == 22 ){
			return UserType.ADMINISTRATOR;
		}
		if( res.getCode().intValue() == 23 ){
			return UserType.SKED_DESK;
		}
		return null;
	}
	/**
	 * Method to prepare TimeOfDay BO
	 * @param timeOfDay
	 * @return timeOfDayReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.timeofday.v1.TimeOfDay getTimeOfDayReq(TimeOfDay timeOfDay){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.timeofday.v1.TimeOfDay timeOfDayReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.timeofday.v1.TimeOfDay();
		
		timeOfDayReq.setCode( timeOfDay.getCode() );
		
		return timeOfDayReq;
	}
	/**
	 * Method to prepare  CabinType BO
	 * @param cabinType
	 * @return cabinTypeReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.cabintype.v1.CabinType getCabinTypeReq(CabinType cabinType){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.cabintype.v1.CabinType cabinTypeReq = 
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.cabintype.v1.CabinType();
		
		cabinTypeReq.setType( Character.toString( cabinType.getType() ) );
		
		return cabinTypeReq;
	}
	/**
	 * Method to prepare AirOptions BO
	 * @param airOptions
	 * @return airOptionsReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.airoptions.v1.AirOptions getAirOptionsReq(AirOptions airOptions){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.airoptions.v1.AirOptions airOptionsReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.airoptions.v1.AirOptions();
		
		airOptionsReq.setNoOfStops( airOptions.getNoOfStops() );
	    airOptionsReq.setFlightNo( airOptions.getFlightNo() );
	    airOptionsReq.setClassOfService( airOptions.getClassOfService() );
	    airOptionsReq.setStopOverCity( airOptions.getStopOverCity() );
	    airOptionsReq.setStopOverDuration( airOptions.getStopOverDuration() );
	    airOptionsReq.setConnectingCity( airOptions.getConnectingCity() );
	    airOptionsReq.setConnectionCity1( airOptions.getConnectionCity1() );
	    airOptionsReq.setConnectionCity2( airOptions.getConnectionCity2() );
	    airOptionsReq.setExcludeCity1( airOptions.getExcludeCity1() );
	    airOptionsReq.setExcludeCity2( airOptions.getExcludeCity2() );
	    airOptionsReq.setExcludeCity3( airOptions.getExcludeCity3() );
	    airOptionsReq.setShowAll( new Boolean( airOptions.isShowAll() ) );
	    
	    if(airOptions.getDepartureTimeOfDay()!=null)
	    airOptionsReq.setDepartureTimeOfDay( this.getTimeOfDayReq( airOptions.getDepartureTimeOfDay() ) );
	    
	    if(airOptions.getArrivaTimeOfDay()!=null)
	    airOptionsReq.setArrivaTimeOfDay( this.getTimeOfDayReq( airOptions.getArrivaTimeOfDay() ) );
	    
	    if(airOptions.getCabinType()!=null)
	    airOptionsReq.setCabinType( this.getCabinTypeReq( airOptions.getCabinType() ) );
		
		return airOptionsReq;
	}
	/*
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.flightRequestType.v1.FlightRequestType 
														getFlightRequestTypeReq(FlightRequestType flightRequestType){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.flightRequestType.v1.FlightRequestType flightRequestTypeReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.flightRequestType.v1.FlightRequestType();
		
		flightRequestTypeReq.setType( Character.toString( flightRequestType.getType() ) );
		
		return flightRequestTypeReq;
	}
	
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.flightsRequest.v1.FlightsRequest 
														getFlightsRequestReq(FlightsRequest flightsRequest){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.flightsRequest.v1.FlightsRequest flightsRequestReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.flightsRequest.v1.FlightsRequest();
		
		flightsRequestReq.setAnchorGateway( flightsRequest.getAnchorGateway() );
		flightsRequestReq.setNearbyAirportIndicator( new Boolean( flightsRequest.isNearbyAirportIndicator() ) );
		flightsRequestReq.setFlexiDateIndicator( new Boolean( flightsRequest.isFlexiDateIndicator() ) );
		flightsRequestReq.setShowAll( new Boolean( flightsRequest.isShowAll() ) );
		flightsRequestReq.setCharterOnly( new Boolean( flightsRequest.isCharterOnly() ) );
		flightsRequestReq.setSkedOnly( new Boolean( flightsRequest.isSkedOnly() ) );
		flightsRequestReq.setNonStopFlights( new Boolean( flightsRequest.getNonStopFlights() ) );
		flightsRequestReq.setDoubleConnections( new Boolean( flightsRequest.getDoubleConnections() ) );
		flightsRequestReq.setMultiCarrierFlights( new Boolean( flightsRequest.getMultiCarrierFlights() ) );
		flightsRequestReq.setNoOfAirOptions( new Byte( flightsRequest.getNoOfAirOptions() ));
		flightsRequestReq.setAlternateGatewayMiles( new Integer( flightsRequest.getAlternateGatewayMiles() ));
		flightsRequestReq.setAnchorDepartureDate( this.getDate( flightsRequest.getAnchorDepartureDate() ));
		flightsRequestReq.setOutboundAirOptions( this.getAirOptionsReq( flightsRequest.getOutboundAirOptions() ) );
		flightsRequestReq.setInboundAirOptions( this.getAirOptionsReq( flightsRequest.getInboundAirOptions() ) );
		flightsRequestReq.setFlightRequestType( this.getFlightRequestTypeReq( flightsRequest.getFlightRequestType() ));
		flightsRequestReq.setTripType( this.getFlightTripTypeReq( flightsRequest.getTripType() ));
		if( (flightsRequest.getPreferredCarriersList() != null) && (flightsRequest.getPreferredCarriersList().size() > 0) ){
			for(int i=0; i < flightsRequest.getPreferredCarriersList().size(); i++){
				flightsRequestReq.getPreferredCarriersList(),add( this.getCarrierReq(flightsRequest.getPreferredCarriersList().get(i)));
			}
		}
		if( (flightsRequest.getNearByGateways() != null) && (flightsRequest.getNearByGateways().size() > 0) ){
			for(int i=0; i < flightsRequest.getNearByGateways().size(); i++){
				flightsRequestReq.getNearByGateways().add( flightsRequest.getNearByGateways().get(i) );
			}
		}
		if( (flightsRequest.getNearByDestinations() != null) && (flightsRequest.getNearByDestinations().size() > 0) ){
			for(int i=0; i < flightsRequest.getNearByDestinations().size(); i++){
				flightsRequestReq.getNearByDestinations().add( flightsRequest.getNearByDestinations().get(i) );
			}
		}
		
		return flightsRequestReq;
	}
	*/
	/**
	 * method to prepare HotelsPackageRequest BO
	 * @param hotelsRequest
	 * @return hotelsPackageRequest
	 */
	public com.kcdataservices.partners.kcdebsrvlib_package.interfaces.hotelspackagerequest.v1.HotelsPackageRequest 
					getHotelsPackageRequestReq(HotelsRequest hotelsRequest){
		com.kcdataservices.partners.kcdebsrvlib_package.interfaces.hotelspackagerequest.v1.HotelsPackageRequest hotelsPackageRequest =
			new com.kcdataservices.partners.kcdebsrvlib_package.interfaces.hotelspackagerequest.v1.HotelsPackageRequest();
	
		if( hotelsRequest.getHotelOptions() != null ){
			hotelsPackageRequest.setHotelOptions( this.getHotelOptionsReq( hotelsRequest.getHotelOptions() ) );
		}
		if( hotelsRequest.getSpecialOptions() != null ){
			hotelsPackageRequest.setSpecialOptions( this.getSpecialOptionsReq( hotelsRequest.getSpecialOptions() ));
		}
		
		return hotelsPackageRequest;
	}
	/*
	public com.kcdataservices.partners.kcdebsrvlib_package.interfaces.vehicleoptions.v1.VehicleOptions 
																				getVehicleOptionsReq(VehicleOptions vehicleOptions){
		com.kcdataservices.partners.kcdebsrvlib_package.interfaces.vehicleoptions.v1.VehicleOptions vehicleOptionsReq = 
			new com.kcdataservices.partners.kcdebsrvlib_package.interfaces.vehicleoptions.v1.VehicleOptions();
		
		vehicleOptionsReq.setPickupLocation( vehicleOptions.getPickupLocation() );
		vehicleOptionsReq.setDropoffLocation( vehicleOptions.getDropoffLocation() );
		vehicleOptionsReq.setVendorCode( vehicleOptions.getVendorCode() );
		vehicleOptionsReq.setVehicleClass( vehicleOptions.getVehicleClass() );
		vehicleOptionsReq.setPickupDateTime( this.getDate( vehicleOptions.getPickupDateTime() ) );
		vehicleOptionsReq.setDropoffDateTime( this.getDate( vehicleOptions.getDropoffDateTime() ) );
		
		return vehicleOptionsReq;
	}
	*/
	public com.kcdataservices.partners.kcdebsrvlib_package.interfaces.vehiclespackagerequest.v1.VehiclesPackageRequest 
													getVehiclesRequestReq(VehiclesRequest vehiclesRequest){
		com.kcdataservices.partners.kcdebsrvlib_package.interfaces.vehiclespackagerequest.v1.VehiclesPackageRequest vehiclesPackageRequest =
			new com.kcdataservices.partners.kcdebsrvlib_package.interfaces.vehiclespackagerequest.v1.VehiclesPackageRequest();

		//vehiclesPackageRequest.setVehicleOptions( this.getVehicleOptionsReq( vehiclesRequest.getVehicleOptions() ) );
		
		return vehiclesPackageRequest;
	}
	
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destinationservice.v1.DestinationService 
																getDestinationServiceReq(DestinationService destinationService){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destinationservice.v1.DestinationService destinationServiceReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destinationservice.v1.DestinationService();
		
		destinationServiceReq.setServiceCode( destinationService.getServiceCode() );
		destinationServiceReq.setServiceName( destinationService.getServiceName() );
		destinationServiceReq.setCurrency( destinationService.getCurrency() );
		destinationServiceReq.setPrice( new Double( destinationService.getPrice() ) );
		
		return destinationServiceReq;
	}
	
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destination.v1.Destination getDestinationReq(Destination destination){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destination.v1.Destination destinationReq =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destination.v1.Destination();
		
		destinationReq.setAirportCode( destination.getAirportCode() );
		destinationReq.setAirportName( destination.getAirportName() );
		destinationReq.setCityName( destination.getCityName() );
		destinationReq.setStateCode( destination.getStateCode() );
		destinationReq.setCountryCode( destination.getCountryCode() );
		destinationReq.setLanguageCode( destination.getLanguageCode() );
		
		destinationReq.setAirDestination( new Boolean( destination.isAirDestination() ) );
		destinationReq.setHotelDestination( new Boolean( destination.isHotelDestination() ) );
		destinationReq.setVehicleDestination( new Boolean( destination.isVehicleDestination() ) );
		
		if( (destination.getServices() != null) && (destination.getServices().size() > 0) ){
			for(int i=0; i < destination.getServices().size(); i++){
				destinationReq.getServices().add( this.getDestinationServiceReq( destination.getServices().get(i) ) );
			}
		}
		
		if( (destination.getNearbyAirports() != null) && (destination.getNearbyAirports().size() > 0) ){
			for(int i=0; i < destination.getNearbyAirports().size(); i++){
				destinationReq.getNearbyAirports().add( destination.getNearbyAirports().get(i) );
			}
		}

		return destinationReq;
	}
	
	public com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packageavailabilityrequest.v1.PackageAvailabilityRequest 
							getPackageAvailabilityRequestReq(PackagesRequest packagesRequest){
		com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packageavailabilityrequest.v1.
		PackageAvailabilityRequest packageAvailabilityRequest = 
			new com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packageavailabilityrequest.v1.PackageAvailabilityRequest();
		
		if( packagesRequest.getHotelsRequest() != null ){
			packageAvailabilityRequest.setGateway( packagesRequest.getHotelsRequest().getGateway() );
		    packageAvailabilityRequest.setDestination( packagesRequest.getHotelsRequest().getDestination() );
		    packageAvailabilityRequest.setPromoCode( packagesRequest.getHotelsRequest().getPromoCode());
		    packageAvailabilityRequest.setBookingNo( packagesRequest.getHotelsRequest().getBookingNo());
		    packageAvailabilityRequest.setAirRequested( new Boolean( packagesRequest.getHotelsRequest().isAirRequested() ));
		    packageAvailabilityRequest.setHotelRequested( new Boolean(packagesRequest.getHotelsRequest().isHotelRequested()));
		    packageAvailabilityRequest.setVehicleRequested( new Boolean(packagesRequest.getHotelsRequest().isVehicleRequested()));
		    packageAvailabilityRequest.setMultiDestinationRequest( new Boolean(packagesRequest.getHotelsRequest().isMultiDestinationRequest()));
		    
		    packageAvailabilityRequest.setNoOfNights( new Short(packagesRequest.getHotelsRequest().getNoOfNights()));
		    
		    if( packagesRequest.getHotelsRequest().getDepartureDate() != null ){
		    	packageAvailabilityRequest.setDepartureDate( this.getDate( packagesRequest.getHotelsRequest().getDepartureDate() ) );
		    }
		    
		    if( packagesRequest.getHotelsRequest().getOccupancy() != null ){
		    	packageAvailabilityRequest.setOccupancy( this.getOccupancyReq(packagesRequest.getHotelsRequest().getOccupancy() ) );
		    }
		}
	    
		//packageAvailabilityRequest.setFlightsRequest( this.getFlightsRequestReq( packagesRequest.getFlightsRequest() ) );
		if(  packagesRequest.getHotelsRequest() != null ){
			packageAvailabilityRequest.setHotelsRequest( this.getHotelsPackageRequestReq( packagesRequest.getHotelsRequest() ) );
		}
		
		if( packagesRequest.getVehiclesRequest() != null ){
			packageAvailabilityRequest.setVehiclesRequest( this.getVehiclesRequestReq( packagesRequest.getVehiclesRequest() ) );
		}

		if( (packagesRequest.getFlightsList() != null) && (packagesRequest.getFlightsList().size() > 0) ){
			for(int i=0; i < packagesRequest.getFlightsList().size(); i++){
				packageAvailabilityRequest.getFlightsList().add( this.getTripFlightReq( packagesRequest.getFlightsList().get(i) ) );
			}
		}
		
		if( (packagesRequest.getHotelList() != null) && (packagesRequest.getHotelList().size() > 0) ){
			for(int i=0; i < packagesRequest.getHotelList().size(); i++){
				packageAvailabilityRequest.getHotelList().add( this.getHotelReq( packagesRequest.getHotelList().get(i) ) );
			}
		}

		if( (packagesRequest.getDestinationsList() != null) && (packagesRequest.getDestinationsList().size() > 0) ){
			for(int i=0; i < packagesRequest.getDestinationsList().size(); i++){
				packageAvailabilityRequest.getDestinationsList().add( this.getDestinationReq( packagesRequest.getDestinationsList().get(i) ) );
			}
		}

		if( (packagesRequest.getVehiclesList() != null) && (packagesRequest.getVehiclesList().size() > 0) ){
			for(int i=0; i < packagesRequest.getVehiclesList().size(); i++){
				packageAvailabilityRequest.getVehiclesList().add( this.getVehicleReq( packagesRequest.getVehiclesList().get(i) ) );
			}
		}
		
		if( packagesRequest.getAvailablePackage() != null ){
			packageAvailabilityRequest.setAvailablePackage( this.getPackageObjReq( packagesRequest.getAvailablePackage() ) );
		}
		
		return packageAvailabilityRequest;
	}
	
	public PackagesResponse getPackagesResponse(
		com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packageavailabilityresponse.v1.PackageAvailabilityResponse res){
		PackagesResponse packagesResponse = new PackagesResponse();
		
		if( res.getAvailablePackage() != null ){
			packagesResponse.setAvailablePackage( this.getPackage( res.getAvailablePackage() ) );
		}
		
		if( (res.getFlightsList() != null) && (res.getFlightsList().size() > 0) ){
			List<TripFlight> flightsList = new ArrayList<TripFlight>();
			for(int i=0; i < res.getFlightsList().size(); i++){
				if( res.getFlightsList().get(i) != null )
				flightsList.add( this.getTripFlight( res.getFlightsList().get(i) ) );
			}
			packagesResponse.setFlightsList( flightsList );
		}
		
		if( (res.getHotelList() != null) && (res.getHotelList().size() > 0) ){
			List<Hotel> hotelList = new ArrayList<Hotel>();
			for(int i=0; i < res.getHotelList().size(); i++){
				if( res.getHotelList().get(i) != null )
				hotelList.add( this.getHotel( res.getHotelList().get(i) ) );
			}
			packagesResponse.setHotelList( hotelList );
		}
		
		if( (res.getDestinationsList() != null) && (res.getDestinationsList().size() > 0) ){
			List<Destination> destinationsList = new ArrayList<Destination>();
			for(int i=0; i < res.getDestinationsList().size(); i++){
				if( res.getDestinationsList().get(i) != null )
				destinationsList.add( this.getDestination( res.getDestinationsList().get(i) ) );
			}
			packagesResponse.setDestinationsList( destinationsList );
		}
		
		if( (res.getVehiclesList() != null) && (res.getVehiclesList().size() > 0) ){
			List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
			for(int i=0; i < res.getVehiclesList().size(); i++){
				if( res.getVehiclesList().get(i) != null )
				vehiclesList.add( this.getVehicle( res.getVehiclesList().get(i) ) );
			}
			packagesResponse.setVehiclesList( vehiclesList );
		}
		
		return packagesResponse;
	}
	
	public ItineraryPricingResponse getPackagePriceItineraryResponse(
			com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packagepriceitineraryresponse.v1.PackagePriceItineraryResponse res){
		ItineraryPricingResponse pricingResponse = new ItineraryPricingResponse();
		
		pricingResponse.setItinerary( this.getItinerary( res.getItinerary() ));
		
		return pricingResponse;
	}
	
	public com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packagepriceitineraryrequest.v1.PackagePriceItineraryRequest 
								getPackagePriceItineraryRequest(Itinerary itinerary){
		com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packagepriceitineraryrequest.v1.PackagePriceItineraryRequest req =
		new com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packagepriceitineraryrequest.v1.PackagePriceItineraryRequest();
		
		req.setItinerary( this.getItineraryReq( itinerary ) );
		
		if( itinerary.getSearchCriteria() != null ){
			req.setGateway( itinerary.getSearchCriteria().getGateway() );
			if( (itinerary.getSearchCriteria().getDestinationOptions() != null) &&
				(itinerary.getSearchCriteria().getDestinationOptions().size() > 0) ){
				req.setDestination( itinerary.getSearchCriteria().getDestinationOptions().get(0).getDestination() );
			}
			
			req.setPromoCode( itinerary.getSearchCriteria().getPromoCode() );
			
			req.setBookingNo( itinerary.getSearchCriteria().getBookingNo() );
			
			if( itinerary.getSearchCriteria().getHotelsRequest() != null ){
				req.setHotelRequested( 
					new Boolean(itinerary.getSearchCriteria().getHotelsRequest().isHotelRequested()) );
				req.setNoOfNights( 
					new Short( itinerary.getSearchCriteria().getHotelsRequest().getNoOfNights() ) );
			}
		    if( itinerary.getSearchCriteria().getVehiclesRequest() != null ){
		    	req.setVehicleRequested( 
		    		new Boolean(itinerary.getSearchCriteria().getVehiclesRequest().isVehicleRequested()) );
		    }
		    if( itinerary.getSearchCriteria().getMultiDestPackageRequest() != null ){
		    	req.setMultiDestinationRequest(
		    		new Boolean(
		    		itinerary.getSearchCriteria().getMultiDestPackageRequest().isMultiDestinationRequest()));
		    }
		    if( itinerary.getSearchCriteria().getPackagesRequest() != null ){
		    	req.setPackageRequest( 
		    		new Boolean(
		    		itinerary.getSearchCriteria().getPackagesRequest().isMultiDestinationRequest() ));
		    }
		    if( itinerary.getSearchCriteria().getFlightRequest() != null ){
		    	req.setAirRequested(
		    		new Boolean( itinerary.getSearchCriteria().getFlightRequest().isAirRequested() ));
		    }
		    if( itinerary.getSearchCriteria().getDepartureDate() != null ){
		    	req.setDepartureDate( 
		    		this.getDate( itinerary.getSearchCriteria().getDepartureDate() ) );
		    }
		    if( itinerary.getSearchCriteria().getOccupancy() != null ){
		    	req.setOccupancy( this.getOccupancyReq( itinerary.getSearchCriteria().getOccupancy() ) );
		    }
		}
	    
		return req;
	}
	
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vendor.v1.Vendor getVendorReq(Vendor vendor){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vendor.v1.Vendor vendorReq = 
										new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vendor.v1.Vendor();
		if(vendor.getCity() != null)
			vendorReq.setCity(vendor.getCity());
		if(vendor.getCountry() != null)
			vendorReq.setCountry(vendor.getCountry());
		if(vendor.getEmail() != null)
			vendorReq.setEmail(vendor.getEmail());
		if(vendor.getFaxNo() != null)
			vendorReq.setFaxNo(vendor.getFaxNo());
		if(vendor.getFirstName() != null)
			vendorReq.setFirstName(vendor.getFirstName());
		if(vendor.getLastName() != null)
			vendorReq.setLastName(vendor.getLastName());
		if(vendor.getMode() != null)
			vendorReq.setMode(vendor.getMode());
		if(vendor.getPhone() != null)
			vendorReq.setPhone(vendor.getPhone());
		if(vendor.getPostalCode() != null)
			vendorReq.setPostalCode(vendor.getPostalCode());
		if(vendor.getRegion() != null)
			vendorReq.setRegion(vendor.getRegion());
		if(vendor.getStreetAddrs() != null)
			vendorReq.setStreetAddrs(vendor.getStreetAddrs());
		if(vendor.getVendorId() != null)
//		vendorReq.setVendorExist(vendor.getVendorExist());
		vendorReq.setVendorId(vendor.getVendorId());
		
		return vendorReq;
	}
		

	
	
	
	
}