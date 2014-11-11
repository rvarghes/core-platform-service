package com.kcdata.abe.business.service;

import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.service.ABEServiceBase;
import com.kcdata.sms.business.service.SMAvailService;
import com.kcdata.sms.data.dto.SMLinkViewRequest;
import com.kcdata.sms.data.dto.SMLinkViewResponse;


public class AbeSmAvailServiceImpl extends ABEServiceBase implements AbeSmAvailService {
	private static final long serialVersionUID = 1L;
	private SMAvailService smAvailService;
	
	ABELogger logger = ABELogger.getLogger(AbeSmAvailServiceImpl.class);
	/**
	 * method to check the availability of seat map in any sector on which link will display in ABE and AV.com
	 * @param smLinkViewRequestDTO
	 * @return smLinkViewResponseDTO
	 */
	public SMLinkViewResponse getLinkViewAvailability(SMLinkViewRequest smLinkViewRequestDTO) {
		SMLinkViewResponse smLinkViewResponseDTO = null;
		smLinkViewResponseDTO = smAvailService.getLinkViewAvailability(smLinkViewRequestDTO);
		
		return smLinkViewResponseDTO;
	}
	/**
	 * 
	 * @return smAvailService
	 */
	public SMAvailService getSmAvailService() {
		return smAvailService;
	}

	/**
	 * 
	 * @param smAvailService
	 */
	public void setSmAvailService(SMAvailService smAvailService) {
		this.smAvailService = smAvailService;
	}
	
	
}
