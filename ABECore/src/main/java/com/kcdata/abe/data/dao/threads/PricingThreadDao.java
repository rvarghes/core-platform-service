/**
 *   Class used for fixing support Fix #3535943
 *   
 */

package com.kcdata.abe.data.dao.threads;

import java.util.concurrent.Callable;

import com.kcdata.abe.business.request.PricingRequest;
import com.kcdata.abe.data.dao.ItineraryPricingDao;
import com.kcdata.abe.framework.context.ABEApplicationContext;
import com.kcdata.abe.framework.dao.ABEDaoBase;
import com.kcdata.abe.framework.request.ABERequest;
import com.kcdata.abe.framework.response.ABEResponse;

public class PricingThreadDao extends ABEDaoBase implements 
	Callable<ABEResponse>{
	
	private ABERequest abeRequest;
	
	private ItineraryPricingDao itineraryPricingDao;
	
	private ABEApplicationContext applicationContext;
	
	public ABEResponse call() throws Exception {
		this.getApplicationContextFactory().create(this.applicationContext);
		PricingRequest pricingRequest = null;
		if(abeRequest instanceof PricingRequest){
			pricingRequest = (PricingRequest) abeRequest;
			return itineraryPricingDao.priceItinerayThread(pricingRequest);
		}
		else 
			return null;
	}


	/**
	 * @return the abeRequest
	 */
	public ABERequest getAbeRequest() {
		return abeRequest;
	}


	/**
	 * @param abeRequest the abeRequest to set
	 */
	public void setAbeRequest(ABERequest abeRequest) {
		this.abeRequest = abeRequest;
	}


	/**
	 * @return the itineraryPricingDao
	 */
	public ItineraryPricingDao getItineraryPricingDao() {
		return itineraryPricingDao;
	}


	/**
	 * @param itineraryPricingDao the itineraryPricingDao to set
	 */
	public void setItineraryPricingDao(ItineraryPricingDao itineraryPricingDao) {
		this.itineraryPricingDao = itineraryPricingDao;
	}


	/**
	 * @return the applicationContext
	 */
	public ABEApplicationContext getApplicationContext() {
		return applicationContext;
	}


	/**
	 * @param applicationContext the applicationContext to set
	 */
	public void setApplicationContext(ABEApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

}
