package com.kcdata.abe.business.service;

import com.kcdata.sms.data.dto.SMLinkViewRequest;
import com.kcdata.sms.data.dto.SMLinkViewResponse;
/**
 * 
 * @author sachin verma
 *
 */
public interface AbeSmAvailService {
	
	/**
	 * method to check the availability of seat map in any sector on which link will display in ABE and AV.com
	 * @param smLinkViewRequestDTO
	 * @return
	 */
	
	public SMLinkViewResponse getLinkViewAvailability(SMLinkViewRequest smLinkViewRequestDTO);
	
}
