/**
 * Class used for fixing support Fix #3535943
 * 
 */

package com.kcdata.abe.business.request;

import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.request.ABERequest;

public class PricingRequest extends ABERequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9080435327325956981L;

	private Itinerary itinerary;

	/**
	 * @return the itinerary
	 */
	public Itinerary getItinerary() {
		return itinerary;
	}

	/**
	 * @param itinerary the itinerary to set
	 */
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	

}
