/*
 * PaymentHistorySAPDaoImpl.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 22, 2010  agudise
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.Iterator;

import com.kcdata.abe.bapi.Y_Api_Order_Pymt_Hist_Display_Input;
import com.kcdata.abe.bapi.Y_Api_Order_Pymt_Hist_Display_Output;
import com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType;
import com.kcdata.abe.business.response.PaymentHistoryResponse;
import com.kcdata.abe.data.dto.PaymentHistoryInfo;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;

public class PaymentHistorySAPDaoImpl extends ABESAPDaoBase implements
		PaymentHistoryDao {

	/**
	 * 
	 * This function is to return payment history for provided booking number.
	 * 
	 * @param bookingNumber
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public PaymentHistoryResponse getPaymentHistory(String bookingNumber) {

		Y_Api_Order_Pymt_Hist_Display_Input bapiInput = new Y_Api_Order_Pymt_Hist_Display_Input();
		bapiInput.setDocumentnumber(bookingNumber);
		Y_Api_Order_Pymt_Hist_Display_Output bapiOutput = (Y_Api_Order_Pymt_Hist_Display_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Api_Order_Pymt_Hist_Display", bapiInput);

		// Business error will be populated for Non-Sked desk users
		// Info message will be populated for Sked Desk users
		PaymentHistoryResponse paymentHistoryResponse = new PaymentHistoryResponse();

		// Check BAPI response for any errors
		this.processWarningsErrors(bapiOutput.getReturn(),
				paymentHistoryResponse);

		if (paymentHistoryResponse.isBusinessErrorOccurred())
			return paymentHistoryResponse;

		this.processPaymentHistoryOutput(bapiOutput, paymentHistoryResponse);

		return paymentHistoryResponse;
	}

	/**
	 * Method processes booking search results onto response
	 * 
	 * @param bapiOutput
	 * @param searchResponse
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private void processPaymentHistoryOutput(
			Y_Api_Order_Pymt_Hist_Display_Output bapiOutput,
			PaymentHistoryResponse paymentHistoryResponse) {

		ArrayList<PaymentHistoryInfo> paymentHistoryInfo = new ArrayList<PaymentHistoryInfo>();
		if (bapiOutput.get_as_listPaymentstodate() != null) {
			Iterator<Zapi_Tourop_Itn_PaytodateType> itResults = bapiOutput
					.get_as_listPaymentstodate().iterator();
			while (itResults.hasNext()) {
				Zapi_Tourop_Itn_PaytodateType result = itResults.next();
				PaymentHistoryInfo paymentHistory = new PaymentHistoryInfo();
				paymentHistory.setAmountPaid(result.getAmountpadi()
						.doubleValue());
				paymentHistory.setFirstName(result.getFirstname());
				paymentHistory.setLastName(result.getLastname());
				paymentHistory.setPaymentDate(result.getPaymentdate());
				paymentHistory.setPaymentMode(result.getPaymentmode());
				paymentHistory.setInstrNo(result.getZzinstrno());
				paymentHistory.setSign(result.getSign());
				paymentHistoryInfo.add(paymentHistory);
			}
		}
		// Setting PaymentHistory to Response...
		paymentHistoryResponse.setPaymentHistoryInfoList(paymentHistoryInfo);
	}// End of process function

	/**
	 * 
	 * Utility method for hiding some of credit card characters
	 * 
	 * @param creditCardNumber
	 * @return replaced creditCardNumber
	 * 
	 * @see
	 * @since
	 */
	public String hideCreditCardNumber(String creditCardNumber, String hideChar) {
		if (creditCardNumber != null && !"".equals(creditCardNumber)) {
			for (int i = 0; i < creditCardNumber.length() - 4; i++) {
				creditCardNumber = creditCardNumber.substring(0, i) + hideChar
						+ creditCardNumber.substring(i + 1);
			}
		}
		return creditCardNumber;
	}
}
