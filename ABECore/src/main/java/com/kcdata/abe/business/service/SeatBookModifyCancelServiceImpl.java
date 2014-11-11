package com.kcdata.abe.business.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.SeatAllocations;
import com.kcdata.abe.data.util.SeatMapUtils;
import com.kcdata.abe.framework.service.ABEServiceBase;
import com.kcdata.abe.framework.util.ABEConstants;
import com.kcdata.sms.business.service.SMAvailService;
import com.kcdata.sms.business.service.SMBookCancService;
import com.kcdata.sms.data.dto.SMAvailPricingResponse;
import com.kcdata.sms.data.dto.SMBookCancRequest;
import com.kcdata.sms.data.dto.SMBookCancResponse;
import com.kcdata.sms.data.dto.SMSearchCriteria;
import com.kcdata.sms.data.dto.SmAvailPricingRequest;
/**
 * 
 * @author sverma
 *
 */
public class SeatBookModifyCancelServiceImpl extends ABEServiceBase implements
		SeatBookModifyCancelService {
	
	private static final Logger logger = Logger.getLogger(SeatBookModifyCancelServiceImpl.class);
	private SMAvailService smAvailService;
	private SMBookCancService smBookCancService;
	
	private SeatMapUtils seatMapUtils = new SeatMapUtils();
	public SMAvailPricingResponse priceSeats(SmAvailPricingRequest availPricingRequest) 
	{
		SMAvailPricingResponse smAvailPricingResponse = null;	
		smAvailPricingResponse = smAvailService.repriceRequest(availPricingRequest);
		return smAvailPricingResponse;
	}

	public List<String> validateBookCancelSeats(Itinerary itinerary , Itinerary oldItinerary , boolean cancel)
	{
		Map<String, SMSearchCriteria> searchCriteriaMap = null;	
		SMBookCancRequest smBookCancRequest = null;
		List<String> errorList = null;
		SMBookCancResponse bookCancResponse = null;
		Map<String,List<SeatAllocations>> seatAllocationsMap = null;
		// Flow added by IGT to get new seats along with unchanged seats and their costs during modification of seats.
		if(oldItinerary!=null)
			seatAllocationsMap = seatMapUtils.getNewSeatsListWithSeatCost(itinerary.getSeatAllocationList(),oldItinerary.getSeatAllocationList());
		else
			seatAllocationsMap = seatMapUtils.getNewSeatsList(itinerary.getSeatAllocationList());
		List<SeatAllocations> newList = seatAllocationsMap.get(ABEConstants.NEW_SEATS);
		/**-------------Code added for ABE 12 - Name change with seats causes error on booking---------***/
		List<GuestInfo> guestsList = itinerary.getGuests(); 
		List<String> paxInterchangeList = new ArrayList<String>();
		if(guestsList!= null && guestsList.size()>0){
			for(GuestInfo guest : guestsList){
				if(guest.getOldPaxId()!=null && StringUtils.hasText(guest.getOldPaxId())){
					paxInterchangeList.add(guest.getGuestId());
					paxInterchangeList.add(guest.getOldPaxId());
				}
			}
		}
		/**-------------Code added for ABE 12 - Name change with seats causes error on booking End---------***/
		if(newList != null)
		{
			/**-------------Code added for ABE 12 - Name change with seats causes error on booking---------***/
			if(paxInterchangeList!=null && paxInterchangeList.size()>0){
				List<SeatAllocations> paxToBeInterchangedList = new ArrayList<SeatAllocations>();
				Iterator<SeatAllocations> itr = newList.iterator();
				while(itr.hasNext()){
					SeatAllocations seatAlloc = itr.next();
					for(String pax :paxInterchangeList){
						if(Integer.parseInt(seatAlloc.getPaxNo())==Integer.parseInt(pax)){
							paxToBeInterchangedList.add(seatAlloc);
							itr.remove();
						}
					}
				}
				if(paxToBeInterchangedList!=null && paxToBeInterchangedList.size()>0){
					paxToBeInterchangedList.addAll(seatAllocationsMap.get(ABEConstants.OLD_SEATS));
					seatAllocationsMap.put(ABEConstants.OLD_SEATS,paxToBeInterchangedList);
				}
			}
			/**-------------Code added for ABE 12 - Name change with seats causes error on booking End---------***/
			searchCriteriaMap = seatMapUtils.createSearchCriteriaMap(itinerary , oldItinerary);
			
			smBookCancRequest = seatMapUtils.generateSmBookModifyRequest(newList, searchCriteriaMap,cancel);
			if(smBookCancRequest != null && smBookCancRequest.getBookingRequestTypeDTOList() != null)
			{
				try {
					bookCancResponse = smBookCancService.bookCancSeat(smBookCancRequest);
				} catch (Exception e) {
					logger.error("validateBookCancelSeats --Error in booking seats : "+e.getMessage());
					
					errorList = new ArrayList<String>();
					errorList.add("Error in booking seats");
					itinerary.getSeatAllocationList().clear();
					if(oldItinerary != null && oldItinerary.getSeatAllocationList() != null)
					{
						itinerary.getSeatAllocationList().addAll(oldItinerary.getSeatAllocationList());
					}				
					return errorList;
					
				}
				if(!cancel)
				{
					errorList = seatMapUtils.updateWithBookingResponse(newList, bookCancResponse ,oldItinerary);
				}
				
			}
			else
			{
				
			}
			itinerary.getSeatAllocationList().clear();
			itinerary.getSeatAllocationList().addAll(seatAllocationsMap.get(ABEConstants.OLD_SEATS));
			itinerary.getSeatAllocationList().addAll(newList);	
		}
		return errorList;
		
	}
	
	

	/* (non-Javadoc)
	 * @see com.kcdata.abe.business.service.SeatBookModifyCancelService#rollBackSeats(com.kcdata.abe.data.dto.Itinerary)
	 */
	public void rollBackSeats(Itinerary itinerary) 
	{
		Map<String, SMSearchCriteria> searchCriteriaMap = null;	
		SMBookCancRequest smBookCancRequest = null;
		SMBookCancResponse bookCancResponse = null;
		Map<String,List<SeatAllocations>> seatAllocationsMap = seatMapUtils.getNewSeatsList(itinerary.getSeatAllocationList());
		List<SeatAllocations> newList = seatAllocationsMap.get(ABEConstants.NEW_SEATS);
		if(newList != null)
		{
			searchCriteriaMap = seatMapUtils.createSearchCriteriaMap(itinerary,null);
			smBookCancRequest = seatMapUtils.generateRollbackRequest(newList, searchCriteriaMap);
			if(smBookCancRequest != null && smBookCancRequest.getBookingRequestTypeDTOList() != null)
			{
				try {
					bookCancResponse = smBookCancService.bookCancSeat(smBookCancRequest);
					//TODO handle rolback response;
				} catch (Exception e) {
					logger.error("Error in seat rollback" + e);
					// TODO: handle exception
				}
				newList.clear();
				//SeatMapUtils.updateWithBookingResponse(itinerary.getSeatAllocationList(), bookCancResponse);
			}
		}
		itinerary.getSeatAllocationList().clear();
		itinerary.getSeatAllocationList().addAll(seatAllocationsMap.get(ABEConstants.OLD_SEATS));
		itinerary.getSeatAllocationList().addAll(newList);	
	}

	/**
	 * Book seat in SMS
	 */
	public List<String> bookSeats(Itinerary itinerary) {

		Map<String, SMSearchCriteria> searchCriteriaMap = null;	
		SMBookCancRequest smBookCancRequest = null;
		List<String> errorList = null;
		SMBookCancResponse bookCancResponse = null;
		Map<String,List<SeatAllocations>> seatAllocationsMap = seatMapUtils.getNewSeatsList(itinerary.getSeatAllocationList());
		List<SeatAllocations> newList = seatAllocationsMap.get(ABEConstants.NEW_SEATS);
		if(newList != null)
		{
			searchCriteriaMap = seatMapUtils.createSearchCriteriaMap(itinerary,null);
			
			smBookCancRequest = seatMapUtils.generateSmBookRequest(newList, searchCriteriaMap);
			if(smBookCancRequest != null && smBookCancRequest.getBookingRequestTypeDTOList() != null)
			{
				try {
					bookCancResponse = smBookCancService.bookCancSeat(smBookCancRequest);
				} catch (Exception e) {
					logger.error("validateBookCancelSeats --Error in booking seats : "+e.getMessage());
				}
				
				//errorList = seatMapUtils.updateWithBookingResponse(newList, bookCancResponse);
			}
			itinerary.getSeatAllocationList().clear();
			itinerary.getSeatAllocationList().addAll(seatAllocationsMap.get(ABEConstants.OLD_SEATS));
			itinerary.getSeatAllocationList().addAll(newList);	
		}
		return errorList;
		
	
		
	}

	/* (non-Javadoc)
	 * @see com.kcdata.abe.business.service.SeatBookModifyCancelService#cancelSeats(com.kcdata.abe.data.dto.Itinerary)
	 */
	public List<String> cancelSeats(Itinerary itinerary) {

		Map<String, SMSearchCriteria> searchCriteriaMap = null;	
		SMBookCancRequest smBookCancRequest = null;
		List<String> errorList = null;
		SMBookCancResponse bookCancResponse = null;
		Map<String,List<SeatAllocations>> seatAllocationsMap = seatMapUtils.getNewSeatsList(itinerary.getSeatAllocationList());
		List<SeatAllocations> newList = seatAllocationsMap.get(ABEConstants.NEW_SEATS);
		if(newList != null)
		{
			searchCriteriaMap = seatMapUtils.createSearchCriteriaMap(itinerary,null);
			
			smBookCancRequest = seatMapUtils.generateSmCancelRequest(newList, searchCriteriaMap);
			if(smBookCancRequest != null && smBookCancRequest.getBookingRequestTypeDTOList() != null)
			{
				try {
					bookCancResponse = smBookCancService.bookCancSeat(smBookCancRequest);
				} catch (Exception e) {
					logger.error("validateBookCancelSeats --Error in booking seats : "+e.getMessage());
				}
				
				//errorList = seatMapUtils.updateWithBookingResponse(newList, bookCancResponse);
			}
			itinerary.getSeatAllocationList().clear();
			itinerary.getSeatAllocationList().addAll(seatAllocationsMap.get(ABEConstants.OLD_SEATS));
			itinerary.getSeatAllocationList().addAll(newList);	
		}
		return errorList;
		
	
		
	}
	
	/**
	 * @return the smAvailService
	 */
	public SMAvailService getSmAvailService() {
		return smAvailService;
	}

	/**
	 * @param smAvailService the smAvailService to set
	 */
	public void setSmAvailService(SMAvailService smAvailService) {
		this.smAvailService = smAvailService;
	}

	/**
	 * @return the smBookCancService
	 */
	public SMBookCancService getSmBookCancService() {
		return smBookCancService;
	}

	/**
	 * @param smBookCancService the smBookCancService to set
	 */
	public void setSmBookCancService(SMBookCancService smBookCancService) {
		this.smBookCancService = smBookCancService;
	}

	

}
