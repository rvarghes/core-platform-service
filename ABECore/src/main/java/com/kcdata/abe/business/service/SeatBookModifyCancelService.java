/**
 * 
 */
package com.kcdata.abe.business.service;

import java.util.List;

import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.service.ABEService;

/**
 * @author sverma
 *
 */
public interface SeatBookModifyCancelService extends ABEService {


public List<String> validateBookCancelSeats(Itinerary itinerary , Itinerary oldItinerary , boolean cancel);

public void rollBackSeats(Itinerary itinerary);

public List<String> bookSeats(Itinerary itinerary);

public List<String> cancelSeats(Itinerary itinerary);

}
