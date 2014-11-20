/*
 * NewsInfoResponse.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 14, 2010  vgandrap	  Response to carry retrieved news info		
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import com.kcdata.abe.data.dto.NewsInfo;
import com.kcdata.abe.framework.response.ABEResponse;

public class NewsInfoResponse extends ABEResponse {

	/**
	 * Auto generated serial ID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3262669666991789451L;
	
	private NewsInfo newsInfo;

	public void setNewsInfo(NewsInfo newsInfo) {
		this.newsInfo = newsInfo;
	}

	public NewsInfo getNewsInfo() {
		return newsInfo;
	}
	

}
