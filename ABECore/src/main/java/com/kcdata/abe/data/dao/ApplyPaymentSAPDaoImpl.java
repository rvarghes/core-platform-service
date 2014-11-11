/*
 * ApplyPaymentSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 13, 2009  dmahanth
 * Nov 23, 2009  nvittal	  Added method for apply payment check
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.math.BigDecimal;

import com.kcdata.abe.bapi.Y_Bapi_Apply_Payment_Check_Input;
import com.kcdata.abe.bapi.Y_Bapi_Apply_Payment_Check_Output;
import com.kcdata.abe.bapi.Y_Bapi_Apply_Payment_Input;
import com.kcdata.abe.bapi.Y_Bapi_Apply_Payment_Output;
import com.kcdata.abe.bapi.Zapi_Credit_CardType;
import com.kcdata.abe.bapi.Zapi_Guarantee_CheckType;
import com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType;
import com.kcdata.abe.bapi.Zapi_UserinfoType;
import com.kcdata.abe.bapi.Zepsilon_Cc_FeedType;
import com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List;
import com.kcdata.abe.business.response.ApplyPaymentResponse;
import com.kcdata.abe.data.dto.CreditCard;
import com.kcdata.abe.data.dto.GuaranteedCheck;
import com.kcdata.abe.data.dto.MoneyTransfer;
import com.kcdata.abe.data.dto.PaymentInformation;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;

/**
 * Apply Payment DAO implementation class
 * 
 * @author dmahanth
 * @version
 * 
 * @see
 * @since
 */
public class ApplyPaymentSAPDaoImpl extends ABESAPDaoBase implements ApplyPaymentDao{

	/**
	 * Method checks if apply payment could be performed for a given booking
	 *
	 * @param bookingNo
	 * @param userName
	 * @param userGroupName
	 * @return
	 *
	 * @see
	 * @since
	 */
	public ApplyPaymentResponse applyPaymentCheck(String bookingNo,
			String userName, String userGroupName) {

		//Create BAPI input
		Y_Bapi_Apply_Payment_Check_Input bapiInput = new Y_Bapi_Apply_Payment_Check_Input();
		bapiInput.setBookingnumber(bookingNo);
		
		//Set User Info object
		Zapi_UserinfoType userInfo = new Zapi_UserinfoType();
		userInfo.setUsername(userName);
		userInfo.setUser_Group(userGroupName);
		bapiInput.setUserinfo(userInfo);
		
		Y_Bapi_Apply_Payment_Check_Output bapiOutput = (Y_Bapi_Apply_Payment_Check_Output) 
			this.getBapiExecutionManager().executeBAPI("Y_Bapi_Apply_Payment_Check", bapiInput);
		
		//Business error will be populated for Non-Sked desk users
		//Info message will be populated for Sked Desk users		
		ApplyPaymentResponse applyPmntCheckResponse = new ApplyPaymentResponse();

		//Check BAPI response for any errors
		this.processWarningsErrors(bapiOutput.getReturn(), applyPmntCheckResponse);
		
		return applyPmntCheckResponse;
	}

	/**
	 * Method to apply payment for the booking
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public ApplyPaymentResponse applyPayment(PaymentInformation  paymentInformation) {
		
		ApplyPaymentResponse applyPaymentResponse = new ApplyPaymentResponse();
		
		// Create Input for BAPI
		Y_Bapi_Apply_Payment_Input bapiInput = new Y_Bapi_Apply_Payment_Input();
		
		// Set IMApplication info
		bapiInput.setIm_Application_Info(this.prepareIMApplicationInfo());

		//Set Payment Method Options
		bapiInput.setIm_Bookingnumber(paymentInformation.getBookingNo());
		bapiInput.setIm_Flag_Ccard(paymentInformation.getCreditCardFlag()+"");
		bapiInput.setIm_Flag_Gcheck(paymentInformation.getGuaranteedCheckFlag()+"");
		bapiInput.setIm_Flag_Mtrans(paymentInformation.getMoneyTransferFlag()+"");
		
		// Set Credit Card Details
		if(paymentInformation.getCreditCardFlag() == 'X')
			setCreditCardDetails(bapiInput,paymentInformation);
		
		// Set Guaranteed Check Details
		if(paymentInformation.getGuaranteedCheckFlag() == 'X')
			setGuaranteedCheckDetails(bapiInput,paymentInformation.getGuaranteedCheck());
		
		// Set Money Transfer Details
		if(paymentInformation.getMoneyTransferFlag() == 'X')	
			setMoneyTransferDetails(bapiInput,paymentInformation.getMoneyTransfer());
		
		// Execute the BAPI
		Y_Bapi_Apply_Payment_Output bapiOutput = (Y_Bapi_Apply_Payment_Output) this
				.getBapiExecutionManager().executeBAPI("Y_Bapi_Apply_Payment",
						bapiInput);
		
		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				applyPaymentResponse);
		// Check for any business errors from BAPI
		if (applyPaymentResponse.isBusinessErrorOccurred()) {
			applyPaymentResponse.setPaymentInformation(paymentInformation);
			return applyPaymentResponse;
		}
		return applyPaymentResponse;
	}
	
	/**
	 * Method to set Credit Card Details for the booking in the BAPI input
	 * 
	 * @param Y_Bapi_Apply_Payment_Input bapiInput
	 *            CreditCard creditCard
	 * @return void
	 * 
	 * @see
	 * @since
	 */
	private void setCreditCardDetails(Y_Bapi_Apply_Payment_Input bapiInput,
			PaymentInformation paymentInfo) {
		CreditCard creditCard = paymentInfo.getCreditCard();	
		Zapi_Credit_CardType creditCardType = new Zapi_Credit_CardType();
		if(creditCard != null){ 
			creditCardType.setCardnumber(creditCard.getCardNo());
			creditCardType.setCardtype(creditCard.getCardType());
			creditCardType.setLastfourdigt(creditCard.getLastFourDigits());
			creditCardType.setAmount(new BigDecimal(creditCard.getAmountUSD()));
			creditCardType.setDebitpositionyear(creditCard.getExpiryYear());
			creditCardType.setDebitpositionmonth(creditCard.getExpiryMonth());
			creditCardType.setCvvval(creditCard.getCVVCode());
			creditCardType.setFirstname(creditCard.getFirstName());
			creditCardType.setLastname(creditCard.getLastName());
			creditCardType.setStreet(creditCard.getStreet());
			creditCardType.setCity(creditCard.getCity());
			creditCardType.setState(creditCard.getState());
			creditCardType.setPostalcode(creditCard.getPostalCode());
			creditCardType.setPassengerid(creditCard.getPassengerId());
			creditCardType.setAmountusd(new BigDecimal(creditCard.getAmountUSD()));
			creditCardType.setDescription(creditCard.getDescription());
			creditCardType.setOrt02(creditCard.getDistrict());
			creditCardType.setLand1(creditCard.getCountryCode());
			creditCardType.setTelephoneno(creditCard.getTelephone());
			creditCardType.setUsesamecard(creditCard.getUseSameCard()+"");
		}
		bapiInput.setIm_Ccarddetails(creditCardType);
		// If an other card holder is applying payment
		// Epsilon need to email to other card holder as well.
		
		if(creditCard.getOtherCardHolderFlag() == 'X') {
			Zepsilon_Cc_FeedType_List epsilonFeedTable = new Zepsilon_Cc_FeedType_List();
			Zepsilon_Cc_FeedType epsilonFeedRow = new Zepsilon_Cc_FeedType();
			epsilonFeedRow.setVbeln(paymentInfo.getBookingNo());
			epsilonFeedRow.setZzemail(creditCard.getOtherCardHolderEmail());
			epsilonFeedRow.setZzname_Fst(creditCard.getFirstName());
			epsilonFeedRow.setZzname_Lst(creditCard.getLastName());
			epsilonFeedRow.setZzftcviewed("X");
			epsilonFeedRow.setZzamnt_Paid(new BigDecimal(creditCard.getAmountUSD()));
			epsilonFeedTable.add(epsilonFeedRow);
			bapiInput.setIt_Epsilon_Cc_Info(epsilonFeedTable);
		}
	
	}
	
	/**
	 * Method to set Guaranteed Check Details for the booking in the BAPI input
	 * 
	 * @param Y_Bapi_Apply_Payment_Input bapiInput
	 *            GuaranteedCheck guaranteedCheck
	 * @return void
	 * 
	 * @see
	 * @since
	 */
	private void setGuaranteedCheckDetails(Y_Bapi_Apply_Payment_Input bapiInput,
			GuaranteedCheck guaranteedCheck) {

		Zapi_Guarantee_CheckType guranteedCheckType = new Zapi_Guarantee_CheckType();
		if(guaranteedCheck != null){
			guranteedCheckType.setChecknumber(guaranteedCheck.getCheckNo());
			guranteedCheckType.setPromisedamount(new BigDecimal(guaranteedCheck.getPromisedAmount()));
			guranteedCheckType.setRemarks(guaranteedCheck.getRemarks());
		}	
		bapiInput.setIm_Gcheckdetails(guranteedCheckType);
	}
	
	/**
	 * Method to set Money Transfer Check Details for the booking in the BAPI input
	 * 
	 * @param Y_Bapi_Apply_Payment_Input bapiInput
	 *            MoneyTransfer moneyTransfer
	 * @return void
	 * 
	 * @see
	 * @since
	 */
	private void setMoneyTransferDetails(Y_Bapi_Apply_Payment_Input bapiInput,
			MoneyTransfer moneyTransfer) {

		Zapi_Money_Transfer_ReqType moneyTransferType = new Zapi_Money_Transfer_ReqType();
		if(moneyTransfer != null){
			moneyTransferType.setTransferfrombooking(moneyTransfer.getTransferFromBooking());
			moneyTransferType.setAmountapplied(new BigDecimal(moneyTransfer.getAmountApplied()));
			moneyTransferType.setReason(moneyTransfer.getReason());
		}	
		bapiInput.setIm_Mtransdetails(moneyTransferType);
	}
}