/*
 * CommentsSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 22, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.util.StringUtils;

import com.kcdata.abe.bapi.Y_Bapi_Add_Comments_Input;
import com.kcdata.abe.bapi.Y_Bapi_Add_Comments_Output;
import com.kcdata.abe.bapi.Yst_Bapi_CommentsType;
import com.kcdata.abe.bapi.Z_Api_Order_Get_Comments_Input;
import com.kcdata.abe.bapi.Z_Api_Order_Get_Comments_Output;
import com.kcdata.abe.bapi.Zapi_CommentsType;
import com.kcdata.abe.bapi.Zapi_Comments_DtlType;
import com.kcdata.abe.bapi.util.Yst_Bapi_CommentsType_List;
import com.kcdata.abe.business.response.CommentsResponse;
import com.kcdata.abe.data.dto.Comment;
import com.kcdata.abe.data.dto.CommentType;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;

/**
 * Dao implementation class for Booking Comments
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class CommentsSAPDaoImpl extends ABESAPDaoBase implements CommentsDao {

	/**
	 * Method to add a comment to the booking
	 * 
	 * @param comment
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public CommentsResponse addComment(Comment comment) {
		CommentsResponse commentsResponse = new CommentsResponse();

		Y_Bapi_Add_Comments_Input bapiInput = new Y_Bapi_Add_Comments_Input();

		// set the booking number
		bapiInput.setIm_Booking_Number(comment.getBookingNumber());

		// Set the comment input
		bapiInput.setIt_Comments(this.prepareCommentType(comment));

		// Execute the BAPI
		Y_Bapi_Add_Comments_Output bapiOutput = (Y_Bapi_Add_Comments_Output) this
				.getBapiExecutionManager().executeBAPI("Y_Bapi_Add_Comments",
						bapiInput);

		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.getEs_Return(), commentsResponse);

		return commentsResponse;
	}

	/**
	 * Method to add comments to the booking
	 * 
	 * @param comment
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public CommentsResponse addComments(List<Comment> commentList) {
		CommentsResponse commentsResponse = new CommentsResponse();

		Y_Bapi_Add_Comments_Input bapiInput = new Y_Bapi_Add_Comments_Input();

		// Set the comment input
		bapiInput.setIt_Comments(this.prepareCommentsType(commentList,bapiInput));

		// Execute the BAPI
		Y_Bapi_Add_Comments_Output bapiOutput = (Y_Bapi_Add_Comments_Output) this
				.getBapiExecutionManager().executeBAPI("Y_Bapi_Add_Comments",
						bapiInput);

		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.getEs_Return(), commentsResponse);
		return commentsResponse;
	}
	
	/**
	 * Method to retrieve Comments of Booking
	 * 
	 * @param bookingNumber
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public CommentsResponse retrieveComments(String bookingNumber) {

		CommentsResponse commentsResponse = new CommentsResponse();

		Z_Api_Order_Get_Comments_Input bapiInput = new Z_Api_Order_Get_Comments_Input();

		// Set the input
		bapiInput.setBooking_Number(bookingNumber);

		// Execute the BAPI
		Z_Api_Order_Get_Comments_Output bapiOutput = (Z_Api_Order_Get_Comments_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Z_Api_Order_Get_Comments", bapiInput);

		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.getReturn(), commentsResponse);
		// Check for any business errors from BAPI
		if (commentsResponse.isBusinessErrorOccurred()) {
			return commentsResponse;
		}

		// Parse the output and create comments
		commentsResponse.setComments(this.processCommentsResponse(bapiOutput,
				bookingNumber));

		return commentsResponse;
	}

	/**
	 * Method to prepare comment type
	 * 
	 * @param comment
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private Yst_Bapi_CommentsType_List prepareCommentType(Comment comment) {
		Yst_Bapi_CommentsType_List commentTypeList = new Yst_Bapi_CommentsType_List();
		String commentDetails = comment.getCommentDetails();
		do {
			Yst_Bapi_CommentsType commentType = new Yst_Bapi_CommentsType();
			commentType.setZzuser(comment.getCreatedBy());
			commentType.setZzcmt_Typ(comment.getCommentType().getType() + "");
			commentType.setZzccenter(comment.getCallcenter());
			if(commentDetails.length() <= 255) {
				commentType.setZzcmnt(commentDetails);
				commentDetails = null;				
			} else {
				commentType.setZzcmnt(commentDetails.substring(0, 255));
				commentDetails = commentDetails.substring(255);				
			}
			commentTypeList.add(commentType);
		} while(commentDetails != null);
		return commentTypeList;
	}

	/**
	 * Method to prepare comment type
	 * 
	 * @param comment
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private Yst_Bapi_CommentsType_List prepareCommentsType(List<Comment> commentsList , Y_Bapi_Add_Comments_Input bapiInput) {
		Yst_Bapi_CommentsType_List commentTypeList = new Yst_Bapi_CommentsType_List();
		
		for(Comment comment : commentsList)
		{
			if(!StringUtils.hasText(bapiInput.getIm_Booking_Number()))
			{
				bapiInput.setIm_Booking_Number(comment.getBookingNumber());
			}
			String commentDetails = comment.getCommentDetails();
				if(StringUtils.hasText(commentDetails))
				{
					Yst_Bapi_CommentsType commentType = new Yst_Bapi_CommentsType();
					commentType.setZzuser(comment.getCreatedBy());
					commentType.setZzcmt_Typ(comment.getCommentType().getType() + "");
					commentType.setZzccenter(comment.getCallcenter());
					if(commentDetails.length() <= 255) {
						commentType.setZzcmnt(commentDetails);
						commentDetails = null;				
					} else {
						commentType.setZzcmnt(commentDetails.substring(0, 255));
						commentDetails = commentDetails.substring(255);				
					}
					commentTypeList.add(commentType);
				}
		}
		
		return commentTypeList;
	}

	/**
	 * Method to parse the response and prepare comments
	 * 
	 * @param output
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings( { "unchecked" })
	private List<Comment> processCommentsResponse(
			Z_Api_Order_Get_Comments_Output bapiOutput, String bookingNumber) {
		if (bapiOutput.get_as_listComments_H() != null) {
			ArrayList<Comment> commentsList = new ArrayList<Comment>();
			HashMap<String, Comment> commentsMap = new HashMap<String, Comment>();
			Iterator<Zapi_CommentsType> headerIterator = bapiOutput
					.get_as_listComments_H().iterator();
			SimpleDateFormat sdfDateTime = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			while (headerIterator.hasNext()) {
				Zapi_CommentsType commentType = headerIterator.next();
				Comment comment = new Comment();
				comment.setBookingNumber(bookingNumber);
				if (commentType.getZzdate() != null
						&& commentType.getZztime() != null) {
					try {
						comment.setCreatedDate(sdfDateTime.parse(commentType
								.getZzdate()
								+ " " + commentType.getZztime()));
					} catch (Exception e) {
					}
				}
				comment.setCreatedBy(commentType.getZzuser());
				comment.setCallcenter(commentType.getZzccenter());
				if (commentType.getZzcmt_Typ() != null
						&& commentType.getZzcmt_Typ().length() > 0) {
					comment.setCommentType(CommentType
							.getCommentType(commentType.getZzcmt_Typ()
									.charAt(0)));
				}
				if (commentType.getZznew() != null) {
					comment.setNewlyCreated(true);
				}
				commentsList.add(comment);
				commentsMap.put(commentType.getSno(), comment);
			}
			if (bapiOutput.get_as_listComments_L() != null) {
				Iterator<Zapi_Comments_DtlType> lIterator = bapiOutput
						.get_as_listComments_L().iterator();
				boolean isFirst = true;
				String currentSno = null;
				StringBuffer commentDeatils = new StringBuffer();
				while(lIterator.hasNext()) {
					
					Zapi_Comments_DtlType commentDetailsType = lIterator.next();
					if (isFirst) {
						currentSno = commentDetailsType.getSno();
						isFirst = false;
					} else if (!currentSno.equals(commentDetailsType.getSno())) {
						Comment comment = commentsMap.get(currentSno);
						if (comment != null) {
							comment.setCommentDetails(commentDeatils.toString());
						}
						currentSno = commentDetailsType.getSno();
						commentDeatils = new StringBuffer();
					}
					commentDeatils.append(commentDetailsType.getComm());
				}
				Comment comment = commentsMap.get(currentSno);
				if (comment != null) {
					comment.setCommentDetails(commentDeatils.toString());
				}
			}
			return commentsList;
		}
		return null;
	}

}
