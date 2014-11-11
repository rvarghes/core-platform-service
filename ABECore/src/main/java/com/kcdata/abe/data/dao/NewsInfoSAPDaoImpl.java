/*
 * NewsInfoSAPDaoImpl.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 14, 2010  vgandrap	  Retrieve news based on agent call center	
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.Calendar;
import java.util.Iterator;

import com.kcdata.abe.bapi.Y_Bapi_Tourop_News_Info_Input;
import com.kcdata.abe.bapi.Y_Bapi_Tourop_News_Info_Output;
import com.kcdata.abe.bapi.Yst_NewsType;
import com.kcdata.abe.bapi.util.Yst_NewsType_List;
import com.kcdata.abe.business.response.NewsInfoResponse;
import com.kcdata.abe.data.dto.NewsInfo;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.logging.ABELogger;

public class NewsInfoSAPDaoImpl extends ABESAPDaoBase implements NewsInfoDao{

	ABELogger logger = ABELogger.getLogger(NewsInfoSAPDaoImpl.class);
	
	/**
	 * 
	 * Retrieve the tourop news for the specific sales org and date
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public NewsInfoResponse retrieveNewsInfo(String gateway) {
		NewsInfoResponse newsInfoResponse = new NewsInfoResponse();
		
		//Execute the news retrieve BAPI
		Y_Bapi_Tourop_News_Info_Input input = new Y_Bapi_Tourop_News_Info_Input();
		input.setIm_Application_Info(prepareIMApplicationInfo());
		input.setIm_Date(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		//input.setIm_Gateway(gateway);
		input.setIm_Gateway("PHL");
		// execute the BAPI
		Y_Bapi_Tourop_News_Info_Output bapiOutput = (Y_Bapi_Tourop_News_Info_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Bapi_Tourop_News_Info", input);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(), newsInfoResponse);
		
		// Return response in case of any business errors
		if (newsInfoResponse.isBusinessErrorOccurred())
			return newsInfoResponse;
		
		Yst_NewsType_List newsInfoList = bapiOutput.get_as_listIt_Tour_News();
		Iterator<Yst_NewsType> newsInfoType =  newsInfoList.iterator();
		NewsInfo newsInfo = new NewsInfo();
		
		while(newsInfoType.hasNext()){
			Yst_NewsType newsInfoRow = newsInfoType.next();
			String category = newsInfoRow.getNewscategory();
			String value = newsInfoRow.getNews();
			newsInfo.addNews(category, value);
		}
		
		newsInfoResponse.setNewsInfo(newsInfo);
		
		return newsInfoResponse;
	}

}
