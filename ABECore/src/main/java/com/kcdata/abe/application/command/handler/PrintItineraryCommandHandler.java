/*
 * PrintItineraryCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * May 21, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import java.util.Iterator;
import java.util.List;

import com.kcdata.abe.application.command.PrintItineraryCommand;
import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.business.service.ItineraryService;
import com.kcdata.abe.data.dto.Comment;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.framework.util.DateUtils;

public class PrintItineraryCommandHandler extends ABECommandHandlerBase {

	/**
	 * Itinerary booking service
	 */
	private ItineraryService itineraryService;

	/**
	 * @return the itineraryService
	 */
	public ItineraryService getItineraryService() {
		return itineraryService;
	}

	/**
	 * @param itineraryService
	 *            the itineraryService to set
	 */
	public void setItineraryService(ItineraryService itineraryService) {
		this.itineraryService = itineraryService;
	}

	/**
	 * Method to handle the PrintItineraryCommand
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public ABECommand handle(ABECommand command) {
		if (!(command instanceof PrintItineraryCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "PrintItineraryCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		PrintItineraryCommand printItineraryCommand = (PrintItineraryCommand) command;
		if((null== printItineraryCommand.getCommentCollection())|| (printItineraryCommand.getCommentCollection().isEmpty())){
			ItineraryResponse itineraryResponse = itineraryService.printItinerary(
			printItineraryCommand.getItinerary(), printItineraryCommand.getContentFormat(),printItineraryCommand.getMessages());
			//Process response and set the business errors, warnings, and info
			// messages to command
			this.processResponse(printItineraryCommand, itineraryResponse);
			printItineraryCommand.setItinerary(itineraryResponse.getItinerary());
			printItineraryCommand.setPrintContent(itineraryResponse.getHtmlItinerary());
		}else{
			processPrintCommentContent(printItineraryCommand);
		}
		return printItineraryCommand;
		
	}
	
	private void processPrintCommentContent(final PrintItineraryCommand printItineraryCommand){
	
		if(!printItineraryCommand.getCommentCollection().isEmpty()){
			List<Comment> commentList =  printItineraryCommand.getCommentCollection();
			StringBuffer endbodyContent = new StringBuffer();
			
			String headContent = "<html><title>Comments:"+commentList.get(0).getBookingNumber()+"</title><head>"+
			"<meta content='IE=7' http-equiv='X-UA-Compatible'>"+
			"<!--[ifIE]><STYLE type='text/css'>.altova-rotate-left-textbox{filter: progid:DXImageTransform.Microsoft.BasicImage(rotation=3)} .altova-rotate-right-textbox{filter: progid:DXImageTransform.Microsoft.BasicImage(rotation=1)} </STYLE><![endif]-->"+
			"<!--[if !IE]>-->"+
			"<style type='text/css'>"+
			".altova-rotate-left-textbox {"+
				"-webkit-transform: rotate(-90deg) translate(-100%, 0%);"+
				"-webkit-transform-origin: 0% 0%;"+
				"-moz-transform: rotate(-90deg) translate(-100%, 0%);"+
				"-moz-transform-origin: 0% 0%"+
			"}"+

			".altova-rotate-right-textbox {"+
				"-webkit-transform: rotate(90deg) translate(0%, -100%);"+
				"-webkit-transform-origin: 0% 0%;"+
				"-moz-transform: rotate(90deg) translate(0%, -100%);"+
				"-moz-transform-origin: 0% 0%"+
			"}"+
			"</style>"+
			"<!--<![endif]-->"+
			"<style type='text/css'>"+
			"@page {"+
				"margin-left: 0.60in;"+
				"margin-right: 0.60in;"+
				"margin-top: 0.79in;"+
				"margin-bottom: 0.79in"+
			"}"+

			"@media print {"+
				"br.altova-page-break {"+
					"page-break-before: always;"+
				"}"+
			"}"+
			"</style>"+
			"</head>";
			String startBodyContent = "<body>"+
			"<table width='100%' cellSpacing='0' cellPadding='10' border='0'"+
				"style='background-color: #ffffff; border-bottom: #a0a0a4 2px solid; border-left: #a0a0a4 2px solid; border-right: #a0a0a4 2px solid; border-top: #a0a0a4 2px solid; font-family: arial, helvetica, sans-serif; font-size: 12px;'>"+
				"<tbody>"+		
					"<tr>"+
						"<td style='width: 100%;' colspan='2'>"+			
						"<br>"+
						"<table style='width: 100%;' cellSpacing='2' cellPadding='2' border='0'>"+
							"<tbody>"+
								"<tr>"+
									"<td "+
										"style='background-color: #005e9d; color: #ffffff; font-size: 15px; padding-left: 5px;'><span "+
										" style='font-weight: bold;'>Comments-" +
										commentList.get(0).getBookingNumber() +
										"</span></td>"+
								"</tr>"+
							"</tbody>"+
						"</table>"+
						"<table style='width: 100%;' cellSpacing='2' cellPadding='2' border='0'>"+
							"<tbody>"+
								"<tr style='background-color: #cacaca; font-weight: bold;'>"+
									"<td align='center' style='width: 10%;'><span>Date</span></td>"+
									"<td align='center' style='width: 10%;'><span>Time</span></td>"+
									"<td align='center' style='width: 10%;'><span>Created By</span></td>"+
									"<td align='center' style='width: 10%;'><span>Call Center</span></td>"+
									"<td align='center' style='width: 40%;'><span>Comments</span></td>"+
									"<td align='center' style='width: 10%;'><span>Booking Number</span></td>"+
								"</tr>"+
							"</tbody>"+
						"</table>";
			
			String endContent= "</td></tr></tbody></table></body></html>";
			
			for (Comment comment : commentList) {
				
				String dateValue = DateUtils.reformatDate(comment.getCreatedDate().toString(), "EEE MMM dd hh:mm:ss z yyyy", "MM/dd/yy");
				String timeValue = DateUtils.reformatDate(comment.getCreatedDate().toString(), "EEE MMM dd hh:mm:ss z yyyy", "hh:mm aaa");
				
				String date = "<table style='width: 100%;' cellSpacing='2' cellPadding='2' border='0'>"+
				"<tbody>"+
				"<tr vAlign='middle' align='left'style='background-color: #f5f5f5;'>"+
				"<td style='width: 10%;'>"+dateValue+"</td>";
				String time = "<td style='width: 10%;'>"+timeValue+"</td>";
				String CreatedBy="<td style='width: 10%;'>"+comment.getCreatedBy()+"</td>";
				String callCenter="<td style='width: 10%;'>"+comment.getCallcenter()+"</td>";
				String comments="<td style='width: 40%;'>"+comment.getCommentDetails()+"</td>";
				String BookingNumber="<td style='width: 10%;'>"+comment.getBookingNumber()+"</td></tr></tbody></table>";
				
				endbodyContent.append(date).append(time).append(CreatedBy).append(callCenter).append(comments).append(BookingNumber);
				
			}
			printItineraryCommand.setPrintContent(headContent+startBodyContent+endbodyContent.toString()+endContent);
		}
		
	}

}

