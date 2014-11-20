/*
 * ItineraryServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 19, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.kcdata.abe.application.command.ViewItineraryCommand;
import com.kcdata.abe.business.response.AlertsResponse;
import com.kcdata.abe.business.response.BookingSearchResponse;
import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.business.response.PaymentHistoryResponse;
import com.kcdata.abe.business.response.ServicesResponse;
import com.kcdata.abe.data.dao.AlertsDao;
import com.kcdata.abe.data.dao.BookingSearchDao;
import com.kcdata.abe.data.dao.CommentsDao;
import com.kcdata.abe.data.dao.HBSiHotelDao;
import com.kcdata.abe.data.dao.HBSiHotelsOnlyDao;
import com.kcdata.abe.data.dao.HotelsDao;
import com.kcdata.abe.data.dao.ItineraryComparisonEmailDao;
import com.kcdata.abe.data.dao.ItineraryDao;
import com.kcdata.abe.data.dao.ItineraryPricingDao;
import com.kcdata.abe.data.dao.ItinerarySearchDao;
import com.kcdata.abe.data.dao.ItineraryWESBDao;
import com.kcdata.abe.data.dao.ItineraryXMLDao;
import com.kcdata.abe.data.dao.PaymentHistoryDao;
import com.kcdata.abe.data.dao.WesbBookingDao;
import com.kcdata.abe.data.dto.Comment;
import com.kcdata.abe.data.dto.CommentType;
import com.kcdata.abe.data.dto.EmailAndPrintMessage;
import com.kcdata.abe.data.dto.Flight;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.HotelConfirmation;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.MultiDestinationPackage;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.PrintItinerary;
import com.kcdata.abe.data.dto.RequestedDatesForAvailability;
import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.RoomPrice;
import com.kcdata.abe.data.dto.SeatAllocations;
import com.kcdata.abe.data.dto.Service;
import com.kcdata.abe.data.dto.ServiceGroup;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.data.util.HotelConvertUtils;
import com.kcdata.abe.data.util.SeatMapUtils;
import com.kcdata.abe.data.util.ViewTokenUtil;
import com.kcdata.abe.framework.dto.ABEDto;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABEWarning;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.service.ABEServiceBase;
import com.kcdata.abe.framework.util.ABEConstants;

/**
 * ItineraryService implementation class
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ItineraryServiceImpl extends ABEServiceBase implements
		ItineraryService {

	ABELogger logger = ABELogger.getLogger(ItineraryServiceImpl.class);
	private ItineraryDao itineraryDao;
	private PaymentHistoryDao paymentHistoryDao;
	private AlertsDao alertsDao;
	private CommentsDao commentsDao;
	private ItineraryComparisonEmailDao itineraryComparisonEmailDao;
	private ViewTokenUtil tokenProcessNo;
	private BookingSearchDao bookingSearchDao;
	private ItinerarySearchDao itinerarySearchDao;
	private HotelsDao hotelsDao;
	private ItineraryPricingDao itineraryPricingDao;
	private WesbBookingDao wesbBookingDao;
	private ItineraryWESBDao itineraryWESBDao;
	private HBSiHotelDao hbsiHotelDao;
	private SeatBookModifyCancelService seatBookModifyCancelService;
	private HBSiHotelsOnlyDao hbsiHotelsOnly;

	/**
	 * @return the ItineraryWESBDao
	 */
	public ItineraryWESBDao getItineraryWESBDao() {
		return itineraryWESBDao;
	}

	/**
	 * @param itineraryWESBDao
	 *            the itineraryWESBDao to set
	 */
	public void setItineraryWESBDao(ItineraryWESBDao itineraryWESBDao) {
		this.itineraryWESBDao = itineraryWESBDao;
	}

	/**
	 * @param hbsiHotelDao
	 *            the hbsiHotelDao to set
	 */
	public void setHbsiHotelDao(HBSiHotelDao hbsiHotelDao) {
		this.hbsiHotelDao = hbsiHotelDao;
	}

	/**
	 * @return the wesbBookingDao
	 */
	public WesbBookingDao getWesbBookingDao() {
		return wesbBookingDao;
	}

	/**
	 * @param wesbBookingDao
	 *            the wesbBookingDao to set
	 */
	public void setWesbBookingDao(WesbBookingDao wesbBookingDao) {
		this.wesbBookingDao = wesbBookingDao;
	}

	/**
	 * @return the itinerarySearchDao
	 */
	public ItinerarySearchDao getItinerarySearchDao() {
		return itinerarySearchDao;
	}

	/**
	 * @param itinerarySearchDao
	 *            the itinerarySearchDao to set
	 */
	public void setItinerarySearchDao(ItinerarySearchDao itinerarySearchDao) {
		this.itinerarySearchDao = itinerarySearchDao;
	}

	/**
	 * @return the bookingSearchDao
	 */
	public BookingSearchDao getBookingSearchDao() {
		return bookingSearchDao;
	}

	/**
	 * @param bookingSearchDao
	 *            the bookingSearchDao to set
	 */
	public void setBookingSearchDao(BookingSearchDao bookingSearchDao) {
		this.bookingSearchDao = bookingSearchDao;
	}

	/**
	 * @return the tokenProcessNo
	 */
	public ViewTokenUtil getTokenProcessNo() {
		return tokenProcessNo;
	}

	/**
	 * @param tokenProcessNo
	 *            the tokenProcessNo to set
	 */
	public void setTokenProcessNo(ViewTokenUtil tokenProcessNo) {
		this.tokenProcessNo = tokenProcessNo;
	}

	/**
	 * @return the itineraryComparisonEmailDao
	 */
	public ItineraryComparisonEmailDao getItineraryComparisonEmailDao() {
		return itineraryComparisonEmailDao;
	}

	/**
	 * @param itineraryComparisonEmailDao
	 *            the itineraryComparisonEmailDao to set
	 */
	public void setItineraryComparisonEmailDao(
			ItineraryComparisonEmailDao itineraryComparisonEmailDao) {
		this.itineraryComparisonEmailDao = itineraryComparisonEmailDao;
	}

	private String CUSTOMER_FORMAT_BOOKING = "";
	private String AGENT_FORMAT_BOOKING = "";

	/**
	 * @return the paymentHistoryDao
	 */
	public PaymentHistoryDao getPaymentHistoryDao() {
		return paymentHistoryDao;
	}

	/**
	 * @return the logger
	 */
	public ABELogger getLogger() {
		return logger;
	}

	/**
	 * @param logger
	 *            the logger to set
	 */
	public void setLogger(ABELogger logger) {
		this.logger = logger;
	}

	/**
	 * @return the commentsDao
	 */
	public CommentsDao getCommentsDao() {
		return commentsDao;
	}

	/**
	 * @param commentsDao
	 *            the commentsDao to set
	 */
	public void setCommentsDao(CommentsDao commentsDao) {
		this.commentsDao = commentsDao;
	}

	/**
	 * @param paymentHistoryDao
	 *            the paymentHistoryDao to set
	 */
	public void setPaymentHistoryDao(PaymentHistoryDao paymentHistoryDao) {
		this.paymentHistoryDao = paymentHistoryDao;
	}

	/**
	 * @return the itineraryDao
	 */
	public ItineraryDao getItineraryDao() {
		return itineraryDao;
	}

	/**
	 * @param itineraryDao
	 *            the itineraryDao to set
	 */
	public void setItineraryDao(ItineraryDao itineraryDao) {
		this.itineraryDao = itineraryDao;
	}

	/**
	 * @return the alertsDao
	 */
	public AlertsDao getAlertsDao() {
		return alertsDao;
	}

	/**
	 * @param alertsDao
	 *            the alertsDao to set
	 */
	public void setAlertsDao(AlertsDao alertsDao) {
		this.alertsDao = alertsDao;
	}

	private ItineraryXMLDao itineraryXMLDao;

	/**
	 * @return the itineraryXMLDao
	 */
	public ItineraryXMLDao getItineraryXMLDao() {
		return itineraryXMLDao;
	}

	/**
	 * @param itineraryXMLDao
	 *            the itineraryXMLDao to set
	 */
	public void setItineraryXMLDao(ItineraryXMLDao itineraryXMLDao) {
		this.itineraryXMLDao = itineraryXMLDao;
	}

	/*********** WESB CODE BEGINS ****************/
	/**
	 * Method to check whether its hotel only
	 * 
	 * @param itinerary
	 * @return boolean
	 */
	public boolean isHotelOnly(Itinerary itinerary) {
		boolean isHotelOnly =  true;
		if( ((itinerary.getFlights() == null) || (itinerary.getFlights().size() == 0)) &&
				((itinerary.getVehicles() == null) || (itinerary.getVehicles().size() == 0)) &&
				((itinerary.getPackages() == null) || (itinerary.getPackages().size() == 0)) &&
				((itinerary.getMultiDestinationPackages() == null) || (itinerary.getMultiDestinationPackages().size() == 0)) &&
				((itinerary.getHotels() != null) && (itinerary.getHotels().size() > 0)) ) {
			
			isHotelOnly =  true;
			
			if(itinerary.getDeletedList()!=null){
				List lsABEDto  = itinerary.getDeletedList();
				for (Iterator iterator = lsABEDto.iterator(); iterator.hasNext();) {
					Object abeDto =  iterator.next();
					if (abeDto instanceof TripFlight) {
						isHotelOnly = false;
					}else if (abeDto instanceof Vehicle) {
						isHotelOnly = false;
					}
				}
			}

		} else if (itinerary.getName()!=null && itinerary.getName().startsWith("CB") 
				&& itinerary.getHotels() != null 
				&& itinerary.getHotels().size() > 0
				&& itinerary.getFlights()==null
				&& itinerary.getVehicles()==null
				&& itinerary.getPackages() == null
				&& itinerary.getMultiDestinationPackages() == null) {
			
			isHotelOnly =  true;
			
			if(itinerary.getDeletedList()!=null){
				List lsABEDto  = itinerary.getDeletedList();
				for (Iterator iterator = lsABEDto.iterator(); iterator.hasNext();) {
					Object abeDto =  iterator.next();
					if (abeDto instanceof TripFlight) {
						isHotelOnly = false;
					}else if (abeDto instanceof Vehicle) {
						isHotelOnly = false;
					}
				}
			}
		}
		else if(itinerary.getHotels() != null 
				&& itinerary.getHotels().size() > 0 
				&& itinerary.getFlights()==null
				&& itinerary.getVehicles()==null
				&& itinerary.getPackages() == null
				&& itinerary.getMultiDestinationPackages() == null){
			
			isHotelOnly =  true;
			
			if(itinerary.getDeletedList()!=null){
				List lsABEDto  = itinerary.getDeletedList();
				for (Iterator iterator = lsABEDto.iterator(); iterator.hasNext();) {
					Object abeDto =  iterator.next();
					if (abeDto instanceof TripFlight) {
						isHotelOnly = false;
					}else if (abeDto instanceof Vehicle) {
						isHotelOnly = false;
					}
				}
			}
		}
		else
		{
			isHotelOnly =  false;
		}
		
		return isHotelOnly;

	}
	
	private void  validateMandatorySupplements(Itinerary itinerary, ServicesResponse servicesResponse){
		
		List<ServiceGroup> serviceGroups = servicesResponse.getServiceGroups();	
		//Null check added after running merge cycle from trunk on 21-Jan-2013
		if(serviceGroups!=null)
		for (Iterator iterator = serviceGroups.iterator(); iterator.hasNext();) {
			ServiceGroup serviceGroup = (ServiceGroup) iterator.next();							
				List<Service> serviceList = serviceGroup.getServices();
				for (Iterator iterator2 = serviceList.iterator(); iterator2.hasNext();) {
					Service service = (Service) iterator2.next();
					if (service.isMandatory()) {
						if(itinerary.getServices() != null) {
							List<Service> itineraryServiceList =  itinerary.getServices();
							boolean containsMandatoryService = false;
							for (Iterator iterator3 = itineraryServiceList.iterator(); iterator3.hasNext();) {
								Service eachService = (Service) iterator3.next();
								if(eachService.getServiceCode().equalsIgnoreCase(service.getServiceCode()) &&
										eachService.getDepatureDate().compareTo(service.getDepatureDate())==0) {
									containsMandatoryService = true;
								} 
							}
							if (!containsMandatoryService)
								itinerary.getServices().add(service);
						}
						else {
							List<Service> newServiceList = new ArrayList<Service>();
							newServiceList.add(service);
							itinerary.setServices(newServiceList);
						}
							
					}
					
				}
		}	
	
	}
	
	
	private Itinerary populateHBSirates(Itinerary itinerary, ServicesResponse servicesResponse){
		Map<String,HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao.getHBSiDBData();		
		validateMandatorySupplements(itinerary,servicesResponse);
		if(itinerary!=null && itinerary.getHotels()!=null && itinerary.getHotels().size()>0){
			for(int i=0;i<itinerary.getHotels().size();i++){
				if(hbsiHotelDao.isHBSiHotel(itinerary.getHotels().get(i).getHotelCode())){
					Hotel hbsiHotel = itinerary.getHotels().get(i);						
					
					if(hbsiHotel.getDisplayRoomCategory()==null) {
						hbsiHotel.setDisplayRoomCategory(itinerary.getHotels().get(0).getRoomCategories().get(0));
						hbsiHotel.getDisplayRoomCategory().setDisplayRoomPrice(itinerary.getHotels().get(0).getRoomCategories().get(0).getRoomPrices().get(0)); 
					}
					
					if(hbsiHotel.getDisplayRoomCategory().getHbsiRates()==null)
					{
						HotelsResponse hotelResponse = hbsiHotelsOnly.retrieveWesbHotels(itinerary, hbsiHotel, null, hbsiHotelList, "CP");
						//Start the implemention of AV3749/HBsi 52 emergency tab information for passgenger enhancement
					    //Checking the hotesllist can't be zero, atleast one record should be there
						if (hotelResponse.getHotelList()!=null && hotelResponse.getHotelList().size()>0)
						{
							Hotel hotel = hotelResponse.getHotelList().get(0);
						

							hbsiHotel.getDisplayRoomCategory().getDisplayRoomPrice().setPaxBasePrices(hotel.getDisplayRoomCategory().getDisplayRoomPrice().getPaxBasePrices()); 
							hbsiHotel.getDisplayRoomCategory().setHbsiRates(hotel.getDisplayRoomCategory().getHbsiRates());
							hbsiHotel.getDisplayRoomCategory().setCancelPolicy(hotel.getDisplayRoomCategory().getCancelPolicy());
						
						
						for(int roomCat=0; roomCat<hotel.getRoomCategories().size(); roomCat++)
						{
							if (roomCat<hbsiHotel.getRoomCategories().size()){
							hbsiHotel.getRoomCategories().get(roomCat).setHbsiRates(hotel.getRoomCategories().get(roomCat).getHbsiRates());
							hbsiHotel.getRoomCategories().get(roomCat).setCancelPolicy(hotel.getRoomCategories().get(roomCat).getCancelPolicy());
							}
							for(int roomPrice=0; roomPrice<hotel.getRoomCategories().get(roomCat).getRoomPrices().size(); roomPrice++) {
								if (roomCat<hbsiHotel.getRoomCategories().size()){
								hbsiHotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setHotelCost(hotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getHotelCost());
								hbsiHotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setTransferCost(hotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getTransferCost());
								hbsiHotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setPaxBasePrices(hotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getPaxBasePrices());
							}
							}
						}
						
						for(int dispRoomPrice=0; dispRoomPrice<hotel.getDisplayRoomCategory().getRoomPrices().size(); dispRoomPrice++) {
							if(hbsiHotel.getDisplayRoomCategory().getRoomPrices() != null && hbsiHotel.getDisplayRoomCategory().getRoomPrices().size()>0) {
								if (dispRoomPrice<hbsiHotel.getDisplayRoomCategory().getRoomPrices().size()){
								hbsiHotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).setHotelCost(hotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).getHotelCost());
								hbsiHotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).setTransferCost(hotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).getTransferCost());
								hbsiHotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).setPaxBasePrices(hotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).getPaxBasePrices());
							}
							}
							
						}
					}
						itinerary.getHotels().set(i, hbsiHotel);
					
						}
					}
					//Start the implemention of AV3749/HBsi 52 emergency tab information for passgenger enhancement
					// End of if -Checking the hotesllist can't be zero, atleast one record should be there
			}
		} else if (itinerary != null && itinerary.getPackages() != null && itinerary.getPackages().size() > 0){
			for (int i=0; i<itinerary.getPackages().size(); i++) {
				Package itineraryPackage = itinerary.getPackages().get(i);
				if (itineraryPackage.getSelectedHotel() != null && hbsiHotelDao.isHBSiHotel(itineraryPackage.getSelectedHotel().getHotelCode())) {

					Hotel hbsiHotel = itinerary.getPackages().get(i).getSelectedHotel();
					if(hbsiHotel.getDisplayRoomCategory()==null) {
						hbsiHotel.setDisplayRoomCategory(itineraryPackage.getSelectedHotel().getRoomCategories().get(0));
						hbsiHotel.getDisplayRoomCategory().setDisplayRoomPrice(itineraryPackage.getSelectedHotel().getRoomCategories().get(0).getRoomPrices().get(0)); 
					}
					if(hbsiHotel.getDisplayRoomCategory()!=null && hbsiHotel.getDisplayRoomCategory().getHbsiRates()==null)
					{
						HotelsResponse hotelResponse = hbsiHotelsOnly.retrieveWesbHotels(itinerary, hbsiHotel, null, hbsiHotelList, "CP");
						Hotel hotel = hotelResponse.getHotelList().get(0);
						
						hbsiHotel.getDisplayRoomCategory().setHbsiRates(hotel.getDisplayRoomCategory().getHbsiRates());
						hbsiHotel.getDisplayRoomCategory().setCancelPolicy(hotel.getDisplayRoomCategory().getCancelPolicy());
						
						
						for(int roomCat=0; roomCat<hotel.getRoomCategories().size(); roomCat++)
						{
							hbsiHotel.getRoomCategories().get(roomCat).setHbsiRates(hotel.getRoomCategories().get(roomCat).getHbsiRates());
							hbsiHotel.getRoomCategories().get(roomCat).setCancelPolicy(hotel.getRoomCategories().get(roomCat).getCancelPolicy());

							
							for(int roomPrice=0; roomPrice<hotel.getRoomCategories().get(roomCat).getRoomPrices().size(); roomPrice++) {
								hbsiHotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setHotelCost(hotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getHotelCost());
								hbsiHotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setTransferCost(hotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getTransferCost());
								hbsiHotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setPaxBasePrices(hotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getPaxBasePrices());
							}
						}
						
						for(int dispRoomPrice=0; dispRoomPrice<hotel.getDisplayRoomCategory().getRoomPrices().size(); dispRoomPrice++) {
							if(hbsiHotel.getDisplayRoomCategory().getRoomPrices() != null) {
								hbsiHotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).setHotelCost(hotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).getHotelCost());
								hbsiHotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).setTransferCost(hotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).getTransferCost());
								hbsiHotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).setPaxBasePrices(hotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).getPaxBasePrices());
							}
						}
					}
						itinerary.getPackages().get(i).setSelectedHotel(hbsiHotel);
					
						
				}
			}
		} else if (itinerary != null && itinerary.getMultiDestinationPackages() != null && itinerary.getMultiDestinationPackages().size() > 0) {
			for (int i=0; i<itinerary.getMultiDestinationPackages().size(); i++) {
				MultiDestinationPackage multiDestPackage = itinerary.getMultiDestinationPackages().get(i);
				if(multiDestPackage != null && multiDestPackage.getSelectedHotels() != null && multiDestPackage.getSelectedHotels().size() > 0) {
					
					for(int k=0; k<multiDestPackage.getSelectedHotels().size(); k++) {
						Hotel hbsiHotel = multiDestPackage.getSelectedHotels().get(k);
						if(hbsiHotel.getDisplayRoomCategory()!=null && hbsiHotel.getDisplayRoomCategory().getHbsiRates()==null)
						{
							HotelsResponse hotelResponse = hbsiHotelsOnly.retrieveWesbHotels(itinerary, hbsiHotel, itinerary.getSearchCriteria().getHotelsRequest(), hbsiHotelList, "CP");
							Hotel hotel = hotelResponse.getHotelList().get(0);
							
							hbsiHotel.getDisplayRoomCategory().setHbsiRates(hotel.getDisplayRoomCategory().getHbsiRates());
							hbsiHotel.getDisplayRoomCategory().setCancelPolicy(hotel.getDisplayRoomCategory().getCancelPolicy());
							
							
							for(int roomCat=0; roomCat<hotel.getRoomCategories().size(); roomCat++)
							{
								hbsiHotel.getRoomCategories().get(roomCat).setHbsiRates(hotel.getRoomCategories().get(roomCat).getHbsiRates());
								hbsiHotel.getRoomCategories().get(roomCat).setCancelPolicy(hotel.getRoomCategories().get(roomCat).getCancelPolicy());
								
								for(int roomPrice=0; roomPrice<hotel.getRoomCategories().get(roomCat).getRoomPrices().size(); roomPrice++) {
									hbsiHotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setHotelCost(hotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getHotelCost());
									hbsiHotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).setTransferCost(hotel.getRoomCategories().get(roomCat).getRoomPrices().get(roomPrice).getTransferCost());
								}
							}
							
							for(int dispRoomPrice=0; dispRoomPrice<hotel.getDisplayRoomCategory().getRoomPrices().size(); dispRoomPrice++) {
								if(hbsiHotel.getDisplayRoomCategory().getRoomPrices() != null) {
									hbsiHotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).setHotelCost(hotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).getHotelCost());
									hbsiHotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).setTransferCost(hotel.getDisplayRoomCategory().getRoomPrices().get(dispRoomPrice).getTransferCost());
								}
							}
						}
						itinerary.getMultiDestinationPackages().get(i).getSelectedHotels().set(k, hbsiHotel);
					}
					
				}
			}
		}
		
		return itinerary;
	}

	/********* END OF WESB CODE ********/

	/**
	 * Method to book the itinerary
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public ItineraryResponse bookItinerary(Itinerary itinerary, ServicesResponse servicesResponse) {
		
		boolean customer = this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getType().isCustomer();
		if (customer && !hotelsDao.checkisStatusValid(itinerary)) {
			final ItineraryResponse itineraryResponse = new ItineraryResponse();
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("RETRIEVE_HOTEL_AVAILABILITY_ERROR");
			businessError
					.setErrorDescription(this.getMessageSource().getMessage(
							"RETRIEVE_HOTEL_AVAILABILITY_ERROR", null, null));
			itineraryResponse.saveBusinessError(businessError);
			return itineraryResponse;
		}

		/******************************************* WESB CODE FOR HOTEL ONLY *********************************************/
		/*BEGIN: Convert VendorHotelCode to hotel code for HBSi hotels    */
		
Map<String,HBSiHotelInfo> hbsiHotelVendorCode = this.hbsiHotelDao.getHotelVendors();
		
HotelConvertUtils.formatHotelCode(itinerary, hbsiHotelDao);
HotelConvertUtils.decodeHotelDesc(itinerary);
		if(itinerary!=null && (itinerary.getHotels()!=null || itinerary.getPackages()!=null || itinerary.getMultiDestinationPackages()!=null))
		{
			Map<String,HBSiHotelInfo> hotelVendorCodeMap = this.hbsiHotelDao.getHotelVendors();
			if(itinerary.getHotels()!=null)
			{
				for(int hbsiHotel=0;hbsiHotel<itinerary.getHotels().size();hbsiHotel++ )
				{
					if(this.hbsiHotelDao.isHBSiHotelVendorCode(itinerary.getHotels().get(hbsiHotel).getHotelCode()))
					{
						HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(itinerary.getHotels().get(hbsiHotel).getHotelCode());
						if(hbsiHotelInfo!=null)
						{
							itinerary.getHotels().get(hbsiHotel).setHotelCode(hbsiHotelInfo.getHotelId());
						}
					}
				}
			}
			
			if(itinerary.getPackages()!=null)
			{
				for(int pack=0;pack<itinerary.getPackages().size();pack++)
				{
					if(itinerary.getPackages().get(pack)!=null && itinerary.getPackages().get(pack).getSelectedHotel()!=null
							&& this.hbsiHotelDao.isHBSiHotelVendorCode(itinerary.getPackages().get(pack).getSelectedHotel().getHotelCode()))
					{
						HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(itinerary.getPackages().get(pack).getSelectedHotel().getHotelCode());
						itinerary.getPackages().get(pack).getSelectedHotel().setHotelCode(hbsiHotelInfo.getHotelId());
					}
				}
			}
			
			
				if(itinerary.getMultiDestinationPackages()!=null && itinerary.getMultiDestinationPackages().size()>0)
				{
					for(int multiDestPack=0;multiDestPack<itinerary.getMultiDestinationPackages().size();multiDestPack++)
					{
						if(itinerary.getMultiDestinationPackages().get(multiDestPack)!=null && itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels()!=null)
						{
							for(int hbsiHotel=0;hbsiHotel<itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().size();hbsiHotel++)
							{
								if(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel)!=null 
							&& this.hbsiHotelDao.isHBSiHotelVendorCode(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).getHotelCode()))
								
								{
									HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).getHotelCode());
									itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).setHotelCode(hbsiHotelInfo.getHotelId());
								}
							}
						}
					
					}
					
				}
			
		}
		
		/* END Convert vendorHotelCode to HotelCode****/
		
		
		
		
		List<String> hbsiSwitchList = this.hbsiHotelDao.getHBSiSwitch();
		/******************************************* WESB CODE BEGINS *********************************************/
		if (hbsiSwitchList!=null && hbsiSwitchList.contains("TRUE")&& isHotelOnly(itinerary)) {
			boolean isHBSi = false;
			if (itinerary.getHotels() != null)
				isHBSi = this.hbsiHotelDao.isHBSiHotel(itinerary.getHotels()
						.get(0).getHotelCode());
			
			Map<String,HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao.getHBSiDBData();

			itinerary=populateHBSirates(itinerary, servicesResponse);			
			ItineraryResponse itineraryResponse = this.wesbBookingDao
					.bookHotelItinerary(itinerary, isHBSi,hbsiHotelList);
			sendRFAEmail(itineraryResponse.getItinerary());
			return itineraryResponse;
		}

		else if (hbsiSwitchList!=null && hbsiSwitchList.contains("TRUE")&& itinerary!= null
				&& getHbsiHotelsFromItinerary(itinerary)!=null && getHbsiHotelsFromItinerary(itinerary).size()>0)
		
		/*else if (itinerary.getPackages() != null
				&& isPckageHasHotelAndIsHBSi(itinerary))*/ {
			ItineraryResponse itineraryResponse = null;
			ItineraryResponse itineraryASISresponse = null;
			List<SeatAllocations> rollbackList = null;
		List<String> seatErrorList = null;
		boolean rollBackStatus = true;
		if(itinerary.getSeatAllocationList() != null && itinerary.getSeatAllocationList().size() > 0)
		{
			//Book or cancel seats			
			rollbackList = itinerary.getSeatAllocationList();
			try 
			{
				seatErrorList = seatBookModifyCancelService.validateBookCancelSeats(itinerary , null, false);
			} catch (Exception e) {
				//e.printStackTrace();				
			}
			
		}
		if(seatErrorList != null && seatErrorList.contains("Error in booking seats"))
		{
			rollBackStatus = false;
		}
		itinerary=populateHBSirates(itinerary, servicesResponse);
		if(itinerary.getHotels()!=null && itinerary.getHotels().size()>0)
		{
			for(int hbsiHotel=0;hbsiHotel<itinerary.getHotels().size();hbsiHotel++)
			{
			if(this.hbsiHotelDao.isHBSiHotel(itinerary.getHotels().get(hbsiHotel).getHotelCode()))	
			{
				itinerary.getHotels().get(hbsiHotel).setHBSI(true);
			}
			}
		}
		if(itinerary.getPackages()!=null && itinerary.getPackages().size()>0)
		{
			for(int hbsiHotel=0;hbsiHotel<itinerary.getPackages().size();hbsiHotel++)
				
			{
				if(itinerary.getPackages().get(hbsiHotel)!=null && itinerary.getPackages().get(hbsiHotel).getSelectedHotel()!=null)
				{
					if(this.hbsiHotelDao.isHBSiHotel(itinerary.getPackages().get(hbsiHotel).getSelectedHotel().getHotelCode()))
					{
						itinerary.getPackages().get(hbsiHotel).getSelectedHotel().setHBSI(true);
					}
				}
			}
		}
		if(itinerary.getMultiDestinationPackages()!=null && itinerary.getMultiDestinationPackages().size()>0)
		{
			for(int multiDestPack=0;multiDestPack<itinerary.getMultiDestinationPackages().size();multiDestPack++)
			{
				
				if(itinerary.getMultiDestinationPackages().get(multiDestPack)!=null)
				{
					for(int hbsiHotel=0;hbsiHotel<itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().size();hbsiHotel++)
					{
						if(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel)!=null 
					&& this.hbsiHotelDao.isHBSiHotel(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).getHotelCode()))
						
						{
							
							itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).setHBSI(true);
						}
					}
				}
				
				
			}
		}
		itineraryASISresponse = itineraryDao.bookItinerary(itinerary, servicesResponse);	
		if(seatErrorList != null && seatErrorList.size() > 0)
		{
			
			if(seatErrorList.contains(ABEConstants.SEAT_PRICE_CHANGED))
			{
				ABEWarning warningForSeat = new ABEWarning();
				warningForSeat.setErrorDescription("Seat price has been modified. Please contact Apple Vacations at 1-800-517-2000 ");
				warningForSeat.setErrorCode("SEAT_PRICE");
				itineraryASISresponse.saveWarning(warningForSeat);
			} 
			else
			{	
				ABEWarning warning = new ABEWarning();
				//Message Edited by IGT				
				warning.setErrorDescription(ABEConstants.SEAT_PRICING_ERROR);				
				//End Edit
				warning.setErrorCode("SEAT");
				itineraryASISresponse.saveWarning(warning);
			}
			
		}
		
		//Need to check for itinerary error
		if((itineraryASISresponse.isErrorsOccurred() || SeatMapUtils.isSeatWarningMessage(itineraryASISresponse.getWarnings())) 
				&& rollbackList != null && rollbackList.size() > 0 && rollBackStatus)
		{
			itinerary.setSeatAllocationList(rollbackList);
			seatBookModifyCancelService.rollBackSeats(itinerary);
		}
			// get the HBSi hotels for package booking from Itinerary
		//commenting following code for time being; Considering itinerary has any of these Hotel + Package + MultidestinationPackage + Vehicles + Flights 
			//List<Hotel> hbsiHotelList = getHBSiHotelForPackages(itinerary);
		List<Hotel> hbsiHotelList = getHbsiHotelsFromItinerary(itinerary);
			//Start HBSI-8 Phase 1 fix //Added the check of Systems Error(s) in if  condition
			//IF both Business Error(s) and Systems Error(s) are null then 'WesbBookingDao' Service method 'bookPackageItinerary' Called.
			if ((itineraryASISresponse.getBusinessErrors() == null && itineraryASISresponse.getSystemErrors()==null)
					&& itineraryASISresponse.getItinerary() != null) {
				
				itineraryResponse = this.wesbBookingDao.bookPackageItinerary(
						itinerary, hbsiHotelList, itineraryASISresponse
								.getItinerary().getBookingNo());
				//Move the below two line into if clause.
				HotelConvertUtils.encodeHotelDesc(itineraryASISresponse.getItinerary());
				sendRFAEmail(itineraryASISresponse.getItinerary());
				//End HBSI 8 Phase 1 fix
			}
			
			
			
			
			
			return itineraryASISresponse;
		}

	/*	else if (itinerary.getMultiDestinationPackages() != null
				&& isMultidestinationPackageHasHBSiHotel(itinerary)) {
			ItineraryResponse itineraryResponse = null;
			ItineraryResponse itineraryASISresponse = itineraryDao
					.bookItinerary(itinerary,servicesResponse);

			List<Hotel> hbsiHotelList = getHBSiHotelForMultiDestinationPackages(itinerary);

			if (itineraryASISresponse.getBusinessErrors() == null
					&& itineraryASISresponse.getItinerary() != null) {

				itineraryResponse = this.wesbBookingDao.bookPackageItinerary(
						itinerary, hbsiHotelList, itineraryASISresponse
								.getItinerary().getBookingNo());
			}
			sendRFAEmail(itineraryASISresponse.getItinerary());
			return itineraryASISresponse;
		}*/

		/******************************************* WESB CODE ENDS *********************************************/
		else {
		List<SeatAllocations> rollbackList = null;
		List<String> seatErrorList = null;
		boolean rollBackStatus = true;
		if(itinerary.getSeatAllocationList() != null && itinerary.getSeatAllocationList().size() > 0)
		{
			//Book or cancel seats			
			rollbackList = itinerary.getSeatAllocationList();
			try 
			{
				seatErrorList = seatBookModifyCancelService.validateBookCancelSeats(itinerary , null, false);
			} catch (Exception e) {
				e.printStackTrace();				
			}
			
		}
		if(seatErrorList != null && seatErrorList.contains("Error in booking seats"))
		{
			rollBackStatus = false;
		}
		final ItineraryResponse itineraryResponse = itineraryDao.bookItinerary(itinerary, servicesResponse);	
		if(seatErrorList != null && seatErrorList.size() > 0)
		{
			
			if(seatErrorList.contains(ABEConstants.SEAT_PRICE_CHANGED))
			{
				ABEWarning warningForSeat = new ABEWarning();
				warningForSeat.setErrorDescription("Seat price has been modified. Please contact Apple Vacations at 1-800-517-2000 ");
				warningForSeat.setErrorCode("SEAT_PRICE");
				itineraryResponse.saveWarning(warningForSeat);
			}
			else
			{
				ABEWarning warning = new ABEWarning();
				//Message Edited by IGT				
				warning.setErrorDescription(ABEConstants.SEAT_PRICING_ERROR);
				//End Edit
				warning.setErrorCode("SEAT");
				itineraryResponse.saveWarning(warning);
			}
			
		}
		
		//Need to check for itinerary error
		if((itineraryResponse.isErrorsOccurred() || SeatMapUtils.isSeatWarningMessage(itineraryResponse.getWarnings())) 
				&& rollbackList != null && rollbackList.size() > 0 && rollBackStatus)
		{
			itinerary.setSeatAllocationList(rollbackList);
			seatBookModifyCancelService.rollBackSeats(itinerary);
		}
		
		HotelConvertUtils.encodeHotelDesc(itineraryResponse.getItinerary());
			sendRFAEmail(itineraryResponse.getItinerary());
			// Return itinerary response
			return itineraryResponse;
		}

	}

	/**
	 * Method to retrieve HBSi hotels from Itinerary Object for MultiDestination
	 * Packages
	 * 
	 * @param itinerary
	 * @return hotel
	 */
	public List<Hotel> getHBSiHotelForMultiDestinationPackages(
			Itinerary itinerary) {
		if ((itinerary.getMultiDestinationPackages() != null)
				&& (itinerary.getMultiDestinationPackages().size() > 0)) {
			List<MultiDestinationPackage> multiDestinationPackages = itinerary
					.getMultiDestinationPackages();
			List<Hotel> hbsiHotelList = new ArrayList<Hotel>();
			for (MultiDestinationPackage multidestinationPackage : multiDestinationPackages) {
				if (multidestinationPackage != null
						&& multidestinationPackage.getSelectedHotels() != null)
					for (Hotel hotel : multidestinationPackage
							.getSelectedHotels()) {
						if (this.hbsiHotelDao.isHBSiHotel(hotel.getHotelCode()))
							hbsiHotelList.add(hotel);
					}
			}
			return hbsiHotelList;
		}
		return null;
	}

	/**
	 * Method to check whether MultiDestinationPackage ha HBSi hotel or what
	 * 
	 * @param itinerary
	 * @return boolean
	 */

	public boolean isMultidestinationPackageHasHBSiHotel(Itinerary itinerary) {
		if ((itinerary.getMultiDestinationPackages() != null)
				&& (itinerary.getMultiDestinationPackages().size() > 0)) {
			List<MultiDestinationPackage> multiDestinationPackages = itinerary
					.getMultiDestinationPackages();
			for (MultiDestinationPackage multidestinationPackage : multiDestinationPackages) {
				if (multidestinationPackage != null
						&& multidestinationPackage.getSelectedHotels() != null)
					for (Hotel hotel : multidestinationPackage
							.getSelectedHotels()) {
						if (this.hbsiHotelDao.isHBSiHotel(hotel.getHotelCode()))
							return true;
					}
			}
		}
		return false;
	}

	public List<Hotel> getHbsiHotelsFromItinerary(Itinerary itinerary)
	{
		List<Hotel> hbsiHotelList = new ArrayList<Hotel>();
		List<Vehicle> vehicleList= itinerary.getVehicles();
		List<Hotel> hotelList =itinerary.getHotels();
		List<Package> packagesList= itinerary.getPackages();
		List<TripFlight> flightList = itinerary.getFlights();
		List<MultiDestinationPackage> multiDestinationPackageList=itinerary.getMultiDestinationPackages();
		int itemRph=0;
		if(vehicleList!=null && vehicleList.size()>0)
		{
//			int itemRph=0;
			for(int vehicle=0;vehicle<vehicleList.size();vehicle++)
			{
				if(vehicleList.get(vehicle)!=null)
				{
				++itemRph;
				}
			}
		}
		if(flightList!=null && flightList.size()>0)
		{
//			int itemRph=0;
			for(int flight=0;flight<flightList.size();flight++)
			{
				if(flightList.get(flight)!=null)
				{
					++itemRph;
				}
			}
		}
		
		if(hotelList!=null &&hotelList.size()>0 )
		{ 
//			int itemRph=0;
			for(int hotelOnly=0;hotelOnly<hotelList.size();hotelOnly++)
			{
//				++itemRph;
				if(this.hbsiHotelDao.isHBSiHotel(hotelList.get(hotelOnly).getHotelCode()))
						{
						hotelList.get(hotelOnly).setHotelId(itemRph);
						hbsiHotelList.add(hotelList.get(hotelOnly));
						}
					
			}
		}
		if(packagesList!=null && packagesList.size()>0)
		{
//			int itemRph=0;
			for (Package availPackage : packagesList) {
				
				if(availPackage!=null && availPackage.getSelectedVehicle()!=null)
				{
					++itemRph;
				}
				if(availPackage!=null && availPackage.getSelectedFlight()!=null)
				{
					++itemRph;
				}
				if (availPackage != null
						&& availPackage.getSelectedHotel() != null) {
//					++itemRph;
					if (this.hbsiHotelDao.isHBSiHotel(availPackage
							.getSelectedHotel().getHotelCode())) {
						availPackage.getSelectedHotel().setHotelId(itemRph);
						hbsiHotelList.add(availPackage.getSelectedHotel());
					}
				}
			}
		}
		if(multiDestinationPackageList!=null && multiDestinationPackageList.size()>0)
		{
//			int itemRph=0;
			for(MultiDestinationPackage multiDestPackage: multiDestinationPackageList)
			{
				if(multiDestPackage!=null && multiDestPackage.getSelectedVehicles()!=null && multiDestPackage.getSelectedVehicles().size()>0)
				{
					for(int vehicle=0;vehicle<multiDestPackage.getSelectedVehicles().size();vehicle++)
					{
						if(multiDestPackage.getSelectedVehicles().get(vehicle)!=null)
						{
							++itemRph;
						}
					}
				}
				if(multiDestPackage!=null &&multiDestPackage.getSelectedFlights()!=null && multiDestPackage.getSelectedFlights().size()>0)
				{
					for(int flight=0;flight<multiDestPackage.getSelectedFlights().size();flight++)
					{
						if(multiDestPackage.getSelectedFlights().get(flight)!=null)
						{
							++itemRph;
						}
					}
				}
				
				if(multiDestPackage!=null && multiDestPackage.getSelectedHotels()!=null &&multiDestPackage.getSelectedHotels().size()>0)
				{
					for(int multiDestinationHotel=0;multiDestinationHotel<multiDestPackage.getSelectedHotels().size();multiDestinationHotel++)
					{
						if(multiDestPackage.getSelectedHotels().get(multiDestinationHotel)!=null)
						{
							++itemRph;
							if(this.hbsiHotelDao.isHBSiHotel(multiDestPackage.getSelectedHotels().get(multiDestinationHotel).getHotelCode()))
							{
								multiDestPackage.getSelectedHotels().get(multiDestinationHotel).setHotelId(itemRph);
								hbsiHotelList.add(multiDestPackage.getSelectedHotels().get(multiDestinationHotel));
							}
						}
					}
				}
			}
		}
		
		
		
		return hbsiHotelList;
	}
	
	
	/**
	 * method to retrieve HBSi hotels For packages from Itinerary Object
	 * 
	 * @param itinerary
	 * @return hotel
	 */
	public List<Hotel> getHBSiHotelForPackages(Itinerary itinerary) {
		if ((itinerary.getPackages() != null)
				&& (itinerary.getPackages().size() > 0)) {
			List<Package> packages = itinerary.getPackages();
			List<Hotel> hbsiHotelList = new ArrayList<Hotel>();
			
			int itemRph=0;
			for (Package availPackage : packages) {
				
				if(availPackage!=null && availPackage.getSelectedVehicle()!=null)
				{
					++itemRph;
				}
				if(availPackage!=null && availPackage.getSelectedFlight()!=null)
				{
					++itemRph;
				}
				if (availPackage != null
						&& availPackage.getSelectedHotel() != null) {
					++itemRph;
					if (this.hbsiHotelDao.isHBSiHotel(availPackage
							.getSelectedHotel().getHotelCode())) {
						availPackage.getSelectedHotel().setHotelId(itemRph);
						hbsiHotelList.add(availPackage.getSelectedHotel());
					}
				}
			}
			return hbsiHotelList;
		}

		return null;
	}

	/**
	 * Method to check whether package has hotel and Its HBSi
	 * 
	 * @param itinerary
	 * @return boolean
	 */
	public boolean isPckageHasHotelAndIsHBSi(Itinerary itinerary) {
		if ((itinerary.getPackages() != null)
				&& (itinerary.getPackages().size() > 0)) {
			List<Package> packages = itinerary.getPackages();
			for (Package availPackage : packages) {
				if (availPackage != null
						&& availPackage.getSelectedHotel() != null) {
					if (this.hbsiHotelDao.isHBSiHotel(availPackage
							.getSelectedHotel().getHotelCode())) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * Send RFA email to hotel vendor
	 * 
	 * @param itinerary
	 */

	public void sendRFAEmail(final Itinerary itinerary) {

		// Do not set from email id will be default email id
		final String fromEmailID = null;
		// Set email format for XSLT
		final String emailFormat = "HOTEL_ALLOTMENT_VENDOR_REQUEST";
		// Set message opening and closing if required
		final EmailAndPrintMessage messages = new EmailAndPrintMessage();
		// Set print itinerary
		final PrintItinerary printItinerary = new PrintItinerary();

		if ((null != itinerary) && (null != itinerary.getHotels())
				&& (!itinerary.getHotels().isEmpty())) {
			final List<Hotel> hotels = itinerary.getHotels();
			for (final Hotel hotel : hotels) {
				if ((null != hotel)
						&& (null != hotel.getDisplayRoomCategory())
						&& (null != hotel.getDisplayRoomCategory().getStatus())
						&& (hotel.getDisplayRoomCategory().getStatus()
								.equalsIgnoreCase("Q"))) {
					// send email to the vender
					// Check email is exit in vendor to send mail
					if (null != hotel.getVendor()) {
						// if(((null != hotel.getVendor().getEmail()) && (null
						// != hotel.getVendor().getMode()) &&
						// (hotel.getVendor().getMode().equalsIgnoreCase("Email"))
						// &&(!hotel.getVendor().getEmail().trim().equals("")))
						// ||
						// ((null != hotel.getVendor().getMode()) &&
						// (hotel.getVendor().getMode().equalsIgnoreCase("Phone")||hotel.getVendor().getMode().equalsIgnoreCase("Fax")))){
						{
							final List<Hotel> onRequesthotels = new ArrayList<Hotel>();
							List<RoomPrice> roomPrices = hotel
									.getSelectedRooms();
							int noofRequestedRoom = 0;
							if ((null != roomPrices) && (!roomPrices.isEmpty())) {
								for (RoomPrice roomPrice : roomPrices) {
									int roomCategoryId = roomPrice
											.getRoomCategoryId();
									final List<RoomCategory> categories = hotel
											.getRoomCategories();
									for (RoomCategory roomCategory : categories) {
										if ((roomCategory.getRoomCategoryId() == roomCategoryId)
												&& (roomCategory.getStatus()
														.equalsIgnoreCase("Q"))
												&& (null == roomCategory
														.getPosnr())
												&& (null == roomCategory
														.getOldPosnr())) {
											noofRequestedRoom = noofRequestedRoom + 1;
										} else if ((roomCategory
												.getRoomCategoryId() == roomCategoryId)
												&& (roomCategory.getStatus()
														.equalsIgnoreCase("Q"))
												&& (null == roomCategory
														.getPosnr())
												&& (null != roomCategory
														.getOldPosnr())) {
											noofRequestedRoom = noofRequestedRoom + 1;
										}
									}
								}
							}
							if (noofRequestedRoom > 0) {
								// Set to email id - need to get from vender
								// information
								String emailId = hotel.getVendor().getEmail()
										.trim();
								hotel.setNoOfRequestedRooms(noofRequestedRoom);
								onRequesthotels.add(hotel);
								List<RequestedDatesForAvailability> requestDates = hotelsDao
										.getRequestedDatesForAvailability(hotel);
								// Set print itinerary
								setPrintItinerary(itinerary, onRequesthotels,
										printItinerary, requestDates);
								// Send Mail
								// TODO hard code for QA box
								// emailId = "kardary@applevac.com";
								itineraryXMLDao.emailItinerary(printItinerary,
										emailFormat, emailId, messages,
										fromEmailID);
							}
						}
					}
				}
			}
		} else if ((null != itinerary) && (null != itinerary.getPackages())
				&& (!itinerary.getPackages().isEmpty())) {

			final List<Package> packages = itinerary.getPackages();
			for (Package package1 : packages) {
				Hotel hotel = package1.getSelectedHotel();
				if ((null != hotel)
						&& (null != hotel.getDisplayRoomCategory())
						&& (null != hotel.getDisplayRoomCategory().getStatus())
						&& (hotel.getDisplayRoomCategory().getStatus()
								.equalsIgnoreCase("Q"))) {
					// send email to the vender
					// Check email is exit in vendor to send mail
					if (null != hotel.getVendor()) {
						// if(((null != hotel.getVendor().getEmail()) && (null
						// != hotel.getVendor().getMode()) &&
						// (hotel.getVendor().getMode().equalsIgnoreCase("Email"))&&(!hotel.getVendor().getEmail().trim().equals("")))
						// || ((null != hotel.getVendor().getMode()) &&
						// (hotel.getVendor().getMode().equalsIgnoreCase("Phone")||hotel.getVendor().getMode().equalsIgnoreCase("Fax"))))
						{
							final List<Hotel> onRequesthotels = new ArrayList<Hotel>();
							List<RoomPrice> roomPrices = hotel
									.getSelectedRooms();
							int noofRequestedRoom = 0;
							if ((null != roomPrices) && (!roomPrices.isEmpty())) {
								for (RoomPrice roomPrice : roomPrices) {
									int roomCategoryId = roomPrice
											.getRoomCategoryId();
									final List<RoomCategory> categories = hotel
											.getRoomCategories();
									for (RoomCategory roomCategory : categories) {
										if ((roomCategory.getRoomCategoryId() == roomCategoryId)
												&& (roomCategory.getStatus()
														.equalsIgnoreCase("Q"))
												&& (null == roomCategory
														.getPosnr())
												&& (null == roomCategory
														.getOldPosnr())) {
											noofRequestedRoom = noofRequestedRoom + 1;
										} else if ((roomCategory
												.getRoomCategoryId() == roomCategoryId)
												&& (roomCategory.getStatus()
														.equalsIgnoreCase("Q"))
												&& (null == roomCategory
														.getPosnr())
												&& (null != roomCategory
														.getOldPosnr())) {
											noofRequestedRoom = noofRequestedRoom + 1;
										}
									}
								}
							}
							if (noofRequestedRoom > 0) {
								// Set to email id - need to get from vender
								// information
								String emailId = hotel.getVendor().getEmail()
										.trim();
								hotel.setNoOfRequestedRooms(noofRequestedRoom);
								onRequesthotels.add(hotel);
								List<RequestedDatesForAvailability> requestDates = hotelsDao
										.getRequestedDatesForAvailability(hotel);
								// Set print itinerary
								setPrintItinerary(itinerary, onRequesthotels,
										printItinerary, requestDates);
								// Send Mail
								// TODO hard code for QA box
								// emailId = "kardary@applevac.com";
								itineraryXMLDao.emailItinerary(printItinerary,
										emailFormat, emailId, messages,
										fromEmailID);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Set printItinerary from Itinerary
	 * 
	 * @param itinerary
	 * @param printItinerary
	 */
	private void setPrintItinerary(Itinerary itinerary,
			List<Hotel> onRequesthotels, PrintItinerary printItinerary,
			List<RequestedDatesForAvailability> requestDatesForAvl) {

		printItinerary.setAllowBPG(itinerary.isAllowBPG());
		printItinerary.setAllowEdocs(itinerary.isAllowEdocs());
		printItinerary.setBookingCancelled(itinerary.isBookingCancelled());
		printItinerary.setBookingHeader(itinerary.getBookingHeader());
		printItinerary.setBookingLockDetails(itinerary.getBookingLockDetails());
		printItinerary.setBookingNo(itinerary.getBookingNo());
		printItinerary.setCancellationRules(itinerary.getCancellationRules());
		printItinerary.setDeletedList(itinerary.getDeletedList());
		printItinerary.setExtendOptionDate(itinerary.getExtendOptionDate());
		printItinerary.setFlights(itinerary.getFlights());
		List<GuestInfo> guestInfos = itinerary.getGuests();
		List<GuestInfo> guestInfos2 = new ArrayList<GuestInfo>();
		for (GuestInfo guestInfo : guestInfos) {
			guestInfos2.add(guestInfo);
		}
		printItinerary.setGuests(guestInfos2);
		// Set on request hotels which status is Q
		printItinerary.setHotels(onRequesthotels);
		printItinerary.setImApplicationInfo(itinerary.getImApplicationInfo());
		printItinerary.setInsurances(itinerary.getInsurances());
		printItinerary.setItineraryCharges(itinerary.getItineraryCharges());
		printItinerary.setItineraryPrice(itinerary.getItineraryPrice());
		printItinerary.setMaxOccupancy(itinerary.getMaxOccupancy());
		printItinerary.setMultiDestinationPackages(itinerary
				.getMultiDestinationPackages());
		printItinerary.setName(itinerary.getName());
		printItinerary.setNotices(itinerary.getNotices());
		printItinerary.setOpsAlerts(itinerary.getOpsAlerts());
		printItinerary.setPackages(itinerary.getPackages());
		printItinerary.setPaymentInformation(itinerary.getPaymentInformation());
		printItinerary.setQuoteNo(itinerary.getQuoteNo());
		printItinerary.setSearchCriteria(itinerary.getSearchCriteria());
		printItinerary.setServices(itinerary.getServices());
		printItinerary.setShippingAddress(itinerary.getShippingAddress());
		printItinerary.setTabUpdated(itinerary.isTabUpdated());
		printItinerary.setTransferInfo(itinerary.getTransferInfo());
		printItinerary.setVehicles(itinerary.getVehicles());
		printItinerary.setReqDatesForAvl(requestDatesForAvl);
	}

	/**
	 * Method to check whether deleted List has HBSi hotel.
	 * 
	 * @param itinerary
	 * @return boolean
	 */
	public List<Hotel> getHBSiHotelFromDeletedList(Itinerary itinerary) {
		if (itinerary.getDeletedList() != null) {
			List<ABEDto> deletedList = itinerary.getDeletedList();
			List<Hotel> hbsiHotelList = new ArrayList<Hotel>();
			for (ABEDto object : deletedList) {
				if (object instanceof Hotel) {
					Hotel hotel = (Hotel) object;
					if (hotel != null && hotel.getHotelCode() != null
							&& hotel.getHotelCode() != "")
						if (this.hbsiHotelDao.isHBSiHotel(hotel.getHotelCode()))
							hbsiHotelList.add(hotel);

				}

			}
			return hbsiHotelList;
		}

		return null;
	}

	/**
	 * Method to check whether deleted List has HBSi hotel.
	 * 
	 * @param itinerary
	 * @return boolean
	 */
	public boolean isDeletedListHasHBSiHotel(Itinerary itinerary,Map<String,HBSiHotelInfo> hbsiHotelVendorCode ) {
		boolean isHBSi=false;
		if (itinerary.getDeletedList() != null) {
			List<ABEDto> deletedList = itinerary.getDeletedList();
			for (ABEDto object : deletedList) {
				if (object instanceof Hotel) {
					Hotel hotel = (Hotel) object;
						if(hotel!=null && hotel.getHotelCode()!=null && hotel.getHotelCode()!="")
						
						isHBSi= this.hbsiHotelDao.isHBSiHotelVendorCode(hotel.getHotelCode());
						if(isHBSi ==false){
							isHBSi= this.hbsiHotelDao.isHBSiHotel(hotel.getHotelCode());
							hotel.setHBSI(isHBSi);
							return isHBSi;
						}
						HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(hotel.getHotelCode());
						if(hbsiHotelInfo!=null)
						{
							hotel.setHotelCode(hbsiHotelInfo.getHotelId());
						}
						hotel.setHBSI(isHBSi);
						
				
						
				}

			}
		}

		return isHBSi;
	}

	/**
	 * 
	 * Method to save changes done in a given itinerary
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse saveItineraryChanges(Itinerary itinerary, Itinerary oldItinerary, ServicesResponse servicesResponse) {
		ItineraryResponse itineraryResponse = new ItineraryResponse();
		

		/******************************************* WESB CODE FOR HOTEL ONLY *********************************************/
		/*BEGIN: Convert VendorHotelCode to hotel code for HBSi hotels    */
		
		Map<String,HBSiHotelInfo> hbsiHotelVendorCode = this.hbsiHotelDao.getHotelVendors();
		Hotel newHotelFromPackageItinerary=new Hotel();
		Hotel oldHotelFromPackageItinerary=new Hotel();
		HotelConvertUtils.formatHotelCode(itinerary, hbsiHotelDao);
		HotelConvertUtils.decodeHotelDesc(itinerary);
		if(itinerary!=null && (itinerary.getHotels()!=null || itinerary.getPackages()!=null || itinerary.getMultiDestinationPackages()!=null) )
		{
			Map<String,HBSiHotelInfo> hotelVendorCodeMap = this.hbsiHotelDao.getHotelVendors();
			if(itinerary.getHotels()!=null)
			{
				for(int hbsiHotel=0;hbsiHotel<itinerary.getHotels().size();hbsiHotel++ )
				{
					newHotelFromPackageItinerary=itinerary.getHotels().get(hbsiHotel);
					if(this.hbsiHotelDao.isHBSiHotelVendorCode(itinerary.getHotels().get(hbsiHotel).getHotelCode()))
					{
						HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(itinerary.getHotels().get(hbsiHotel).getHotelCode());
						if(hbsiHotelInfo!=null)
						{
							itinerary.getHotels().get(hbsiHotel).setHotelCode(hbsiHotelInfo.getHotelId());
							
						}
					}
				}
			}
			if(oldItinerary !=null){
			if(oldItinerary.getHotels()!=null)
			{
				for(int hbsiHotel=0;hbsiHotel<oldItinerary.getHotels().size();hbsiHotel++ )
				{
					if(this.hbsiHotelDao.isHBSiHotelVendorCode(oldItinerary.getHotels().get(hbsiHotel).getHotelCode()))
					{
						HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(oldItinerary.getHotels().get(hbsiHotel).getHotelCode());
						if(hbsiHotelInfo!=null)
						{
							oldItinerary.getHotels().get(hbsiHotel).setHotelCode(hbsiHotelInfo.getHotelId());
							oldHotelFromPackageItinerary=oldItinerary.getHotels().get(hbsiHotel);
						}
					}
				}
			}
			}
			if(itinerary.getPackages()!=null)
			{
				for(int pack=0;pack<itinerary.getPackages().size();pack++)
				{
					if(itinerary.getPackages().get(pack)!=null && itinerary.getPackages().get(pack).getSelectedHotel()!=null
							&& this.hbsiHotelDao.isHBSiHotelVendorCode(itinerary.getPackages().get(pack).getSelectedHotel().getHotelCode()))
					{
						HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(itinerary.getPackages().get(pack).getSelectedHotel().getHotelCode());
						itinerary.getPackages().get(pack).getSelectedHotel().setHotelCode(hbsiHotelInfo.getHotelId());
					}
				}
			}
			
			
				if(itinerary.getMultiDestinationPackages()!=null && itinerary.getMultiDestinationPackages().size()>0)
				{
					for(int multiDestPack=0;multiDestPack<itinerary.getMultiDestinationPackages().size();multiDestPack++)
					{
						if(itinerary.getMultiDestinationPackages().get(multiDestPack)!=null)
						{
							for(int hbsiHotel=0;hbsiHotel<itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().size();hbsiHotel++)
							{
								if(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel)!=null 
							&& this.hbsiHotelDao.isHBSiHotelVendorCode(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).getHotelCode()))
								
								{
									HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).getHotelCode());
									itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).setHotelCode(hbsiHotelInfo.getHotelId());
								}
							}
						}
					
					}
					
				}
			
		}
		
		/* END Convert vendorHotelCode to HotelCode****/
		
		
		/******************************************* WESB CODE BEGINS *********************************************/
		List<String> hbsiSwitchList = this.hbsiHotelDao.getHBSiSwitch();
		if (hbsiSwitchList!=null && hbsiSwitchList.contains("TRUE")&&this.isHotelOnly(itinerary) || cancelHotelBooking(itinerary)) {
			boolean isHBSi = false;
			Map<String,HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao.getHBSiDBData();
			if (itinerary.getHotels() != null) {
				isHBSi = this.hbsiHotelDao.isHBSiHotel(itinerary.getHotels()
						.get(0).getHotelCode());
				
			} else {
				isHBSi = isDeletedListHasHBSiHotel(itinerary,hbsiHotelVendorCode);
			}
			itinerary=populateHBSirates(itinerary, servicesResponse);
			itineraryResponse = this.itineraryWESBDao.saveWESBItineraryChanges(
					itinerary, isHBSi,hbsiHotelList);
		} else if (hbsiSwitchList!=null && hbsiSwitchList.contains("TRUE") && 
				((itinerary!=null && this.getHbsiHotelsFromItinerary(itinerary)!=null && this.getHbsiHotelsFromItinerary(itinerary).size()>0)
				|| cancelPackageBookingHasHbsiHotel(itinerary,hbsiHotelVendorCode))) {
			List<SeatAllocations> rollbackList = null;
			itinerary=populateHBSirates(itinerary, servicesResponse);
		List<String> seatErrorList = null;
		boolean cancelRollBackStatus = true;
		if(itinerary.getSeatAllocationList() != null && itinerary.getSeatAllocationList().size() > 0)
		{
			//Book or cancel seats		
			rollbackList = itinerary.getSeatAllocationList();
			
			try 
			{
				seatErrorList = seatBookModifyCancelService.validateBookCancelSeats(itinerary , oldItinerary , false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(seatErrorList != null && seatErrorList.contains("Error in booking seats"))
		{
			cancelRollBackStatus = false;
		}
		 itineraryResponse = itineraryDao.saveItineraryChanges(itinerary, oldItinerary, servicesResponse);
		if(seatErrorList != null && seatErrorList.size() > 0)
		{
			
			if(seatErrorList.contains(ABEConstants.SEAT_PRICE_CHANGED))
			{
				ABEWarning warningForSeat = new ABEWarning();
				warningForSeat.setErrorDescription(ABEConstants.SEAT_PRICING_ERROR);
				warningForSeat.setErrorCode("SEAT_PRICE");
				itineraryResponse.saveWarning(warningForSeat);
			}
			else
			{
				ABEWarning warning = new ABEWarning();
				warning.setErrorDescription(ABEConstants.SEAT_BOOKING_ERROR);
				warning.setErrorCode("SEAT");
				itineraryResponse.saveWarning(warning);
			}
		}
		//Need to check for itinerary error
		if((itineraryResponse.isErrorsOccurred() || SeatMapUtils.isSeatWarningMessage(itineraryResponse.getWarnings())) 
				&& rollbackList != null && rollbackList.size() > 0 && cancelRollBackStatus)
		{
			itinerary.setSeatAllocationList(rollbackList);
			seatBookModifyCancelService.rollBackSeats(itinerary);
		}
		else if(cancelRollBackStatus)
		{
			//Now booking is successful and we are doing cancellation
			try 
			{
				if(itinerary.isBookingCancelled() && !itineraryResponse.isErrorsOccurred() && !SeatMapUtils.isSeatWarningMessage(itineraryResponse.getWarnings()))
				{
					//SeatMapUtils.prepareForItineraryCancellation(oldItinerary);
					seatErrorList = seatBookModifyCancelService.validateBookCancelSeats(oldItinerary , null , true);
				}
				else
				{
					seatErrorList = seatBookModifyCancelService.validateBookCancelSeats(itinerary , oldItinerary , true);
				}
				
			} catch (Exception e) {
				logger.error("Error in cancelling seats  -"+e.getStackTrace());
			}
		}
			List<Hotel> hbsiHotelList = new ArrayList<Hotel>();
			//if (itinerary.isBookingCancelled() == false) {
				hbsiHotelList = getHbsiHotelsFromItinerary(itinerary);

			//} else {
				//if (itinerary.getDeletedList() != null) {

				//	hbsiHotelList = getHBSiHotelFromDeletedList(itinerary);

			//	}
			//}
			
			// HBSI Specific  posnr from room category to display room category posnr and old posnr
			for (Iterator iterator = hbsiHotelList.iterator(); iterator
					.hasNext();) {
				Hotel hotel = (Hotel) iterator.next();
				List<RoomCategory> roomCats= hotel.getRoomCategories();
				for (Iterator iterator2 = roomCats.iterator(); iterator2.hasNext();) {
					RoomCategory roomCategory = (RoomCategory) iterator2.next();					
					if(roomCategory.getRoomTypeDescription().equalsIgnoreCase(hotel.getDisplayRoomCategory().getRoomTypeDescription())){
						hotel.getDisplayRoomCategory().setPosnr(roomCategory.getPosnr());
						hotel.getDisplayRoomCategory().setOldPosnr(roomCategory.getOldPosnr());
					}
				}
			}			
		
			
			//For HBSI 1
			if( !(itinerary.isBookingCancelled())){
				if(newHotelFromPackageItinerary.getHotelCode() !=null){
			if(newHotelFromPackageItinerary.getHotelCode().equalsIgnoreCase(oldHotelFromPackageItinerary.getHotelCode())){
				itinerary.setReserve(false);
				itinerary.setModify(true);
//				if(newHotelFromPackageItinerary.getHbsiPNR().
//						equalsIgnoreCase(oldHotelFromPackageItinerary.getHbsiPNR())){
//					itinerary.setModify(false);
//					itinerary.setNoChange(true);
//				}
				
			}else{
				itinerary.setReserve(true);
				itinerary.setModify(false);
				itinerary.setNoChange(false);
			}
			}else{
				itinerary.setBookingCancelled(true);
			}
			}
			ItineraryResponse itineraryWESBResponse = this.itineraryWESBDao
					.saveWESBPackageItineraryChanges(itinerary, hbsiHotelList,
							itinerary.getBookingNo());
		}

	/*	else if (itinerary.getMultiDestinationPackages() != null
				&& isMultidestinationPackageHasHBSiHotel(itinerary)
				|| cancelPackageBookingHasHbsiHotel(itinerary)) {
			itineraryResponse = itineraryDao.saveItineraryChanges(itinerary,oldItinerary ,servicesResponse);
			List<Hotel> hbsiHotelList = new ArrayList<Hotel>();
			if (itinerary.isBookingCancelled() == false) {
				hbsiHotelList = getHBSiHotelForMultiDestinationPackages(itinerary);

			} else {
				if (itinerary.getDeletedList() != null) {

					hbsiHotelList = getHBSiHotelFromDeletedList(itinerary);

				}
			}
			ItineraryResponse itineraryWESBResponse = this.itineraryWESBDao
					.saveWESBPackageItineraryChanges(itinerary, hbsiHotelList,
							itinerary.getBookingNo());
		} */
		
		/******************************************* WESB CODE ENDS *********************************************/
		else {
		List<SeatAllocations> rollbackList = null;
		List<String> seatErrorList = null;
		boolean cancelRollBackStatus = true;
		if(itinerary.getSeatAllocationList() != null && itinerary.getSeatAllocationList().size() > 0)
		{
			//Book or cancel seats		
			rollbackList = itinerary.getSeatAllocationList();
			
			try 
			{
				seatErrorList = seatBookModifyCancelService.validateBookCancelSeats(itinerary , oldItinerary , false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(seatErrorList != null && seatErrorList.contains("Error in booking seats"))
		{
			cancelRollBackStatus = false;
		}
		itineraryResponse = itineraryDao.saveItineraryChanges(itinerary, oldItinerary, servicesResponse);
		if(seatErrorList != null && seatErrorList.size() > 0)
		{
			
			if(seatErrorList.contains(ABEConstants.SEAT_PRICE_CHANGED))
			{
				ABEWarning warningForSeat = new ABEWarning();
				warningForSeat.setErrorDescription(ABEConstants.SEAT_PRICING_ERROR);
				warningForSeat.setErrorCode("SEAT_PRICE");
				itineraryResponse.saveWarning(warningForSeat);
			}
			else
			{
				ABEWarning warning = new ABEWarning();
				warning.setErrorDescription(ABEConstants.SEAT_BOOKING_ERROR);
				warning.setErrorCode("SEAT");
				itineraryResponse.saveWarning(warning);
			}
		}
		//Need to check for itinerary error
		if((itineraryResponse.isErrorsOccurred() || SeatMapUtils.isSeatWarningMessage(itineraryResponse.getWarnings())) 
				&& rollbackList != null && rollbackList.size() > 0 && cancelRollBackStatus)
		{
			itinerary.setSeatAllocationList(rollbackList);
			seatBookModifyCancelService.rollBackSeats(itinerary);
		}
		else if(cancelRollBackStatus)
		{
			//Now booking is successful and we are doing cancellation
			try 
			{
				if(itinerary.isBookingCancelled() && !itineraryResponse.isErrorsOccurred() && !SeatMapUtils.isSeatWarningMessage(itineraryResponse.getWarnings()))
				{
					//SeatMapUtils.prepareForItineraryCancellation(oldItinerary);
					seatErrorList = seatBookModifyCancelService.validateBookCancelSeats(oldItinerary , null , true);
				}
				else
				{
					seatErrorList = seatBookModifyCancelService.validateBookCancelSeats(itinerary , oldItinerary , true);
				}
				
			} catch (Exception e) {
				logger.error("Error in cancelling seats  -"+e.getStackTrace());
			}
		}
		}
		
		HotelConvertUtils.encodeHotelDesc(itinerary);
		sendRFAEmail(itineraryResponse.getItinerary());
		return itineraryResponse;
	}

	boolean cancelPackageBookingHasHbsiHotel(Itinerary itinerary ,Map<String,HBSiHotelInfo> hbsiHotelVendorCode) {
		Boolean isHBSi=false;
		if (itinerary.getDeletedList() != null) {
			List<ABEDto> deletedList = itinerary.getDeletedList();
			for (ABEDto object : deletedList) {

				if (object instanceof Hotel) {
					Hotel hotel = (Hotel) object;
						if(hotel!=null && hotel.getHotelCode()!=null && hotel.getHotelCode()!="")
						
						isHBSi= this.hbsiHotelDao.isHBSiHotelVendorCode(hotel.getHotelCode());
						if(isHBSi ==false){
							isHBSi= this.hbsiHotelDao.isHBSiHotel(hotel.getHotelCode());
							hotel.setHBSI(isHBSi);
							return isHBSi;
						}
						HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(hotel.getHotelCode());
						if(hbsiHotelInfo!=null)
						{
							hotel.setHotelCode(hbsiHotelInfo.getHotelId());
						}
						hotel.setHBSI(isHBSi);
						
				
						
				}

			}
		}
		return isHBSi;
	}

	boolean cancelHotelBooking(Itinerary itinerary) {

		if (itinerary.getDeletedList() != null) {
			List<ABEDto> deletedList = itinerary.getDeletedList();
			for (ABEDto object : deletedList) {
				if (object instanceof TripFlight) {
					return false;
				}
				if (object instanceof Vehicle) {
					return false;
				}
				if (object instanceof Package) {
					return false;
				}
				if (object instanceof MultiDestinationPackage) {
					return false;
				}
				if (object instanceof Hotel && itinerary.getFlights()==null && itinerary.getVehicles()==null) {

					return true;
				}

			}
		}
		return false;
	}

	/**
	 * 
	 * Method to save itinerary or create Quote
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse saveItinerary(Itinerary itinerary) {
		/*if (isHotelOnly(itinerary)) {
			boolean isHBSi = false;
			if (itinerary.getHotels() != null && itinerary.getHotels().size()>0)
				for(int j=0;j<itinerary.getHotels().size();j++)
				{
				isHBSi = this.hbsiHotelDao.isHBSiHotel(itinerary.getHotels()
						.get(j).getHotelCode());
				if(isHBSi==true && itinerary.getHotels().get(j).getRoomCategories()!=null &&itinerary.getHotels().get(j).getRoomCategories().get(0).getMealPlanType()!=null )
				{
						itinerary
								.getHotels()
								.get(j)
								.setHotelName(
										itinerary.getHotels().get(j)
												.getHotelName()
												+ "::"
												+ itinerary
														.getHotels()
														.get(j)
														.getRoomCategories()
														.get(0)
														.getRoomTypeDescription()
												+ "::"
												+ itinerary.getHotels().get(j)
														.getRoomCategories()
														.get(0)
														.getMealPlanType()
														.getCode());	
				}
				}
		}*/
		
		
		/* Convert Hotel Vendor Code to Hotel Code for HBSi hotels */
		
		
		Map<String,HBSiHotelInfo> hbsiHotelVendorCode = this.hbsiHotelDao.getHotelVendors();
		
		if(itinerary!=null && (itinerary.getHotels()!=null || itinerary.getPackages()!=null || itinerary.getMultiDestinationPackages()!=null))
		{
			Map<String,HBSiHotelInfo> hotelVendorCodeMap = this.hbsiHotelDao.getHotelVendors();
			if(itinerary.getHotels()!=null)
			{
				for(int hbsiHotel=0;hbsiHotel<itinerary.getHotels().size();hbsiHotel++ )
				{
					if(this.hbsiHotelDao.isHBSiHotelVendorCode(itinerary.getHotels().get(hbsiHotel).getHotelCode()))
					{
						HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(itinerary.getHotels().get(hbsiHotel).getHotelCode());
						if(hbsiHotelInfo!=null)
						{
							itinerary.getHotels().get(hbsiHotel).setHotelCode(hbsiHotelInfo.getHotelId());
						}
					}
				}
			}
			
			if(itinerary.getPackages()!=null)
			{
				for(int pack=0;pack<itinerary.getPackages().size();pack++)
				{
					if(itinerary.getPackages().get(pack)!=null && itinerary.getPackages().get(pack).getSelectedHotel()!=null
							&& this.hbsiHotelDao.isHBSiHotelVendorCode(itinerary.getPackages().get(pack).getSelectedHotel().getHotelCode()))
					{
						HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(itinerary.getPackages().get(pack).getSelectedHotel().getHotelCode());
						itinerary.getPackages().get(pack).getSelectedHotel().setHotelCode(hbsiHotelInfo.getHotelId());
					}
				}
			}
			
			
				if(itinerary.getMultiDestinationPackages()!=null && itinerary.getMultiDestinationPackages().size()>0)
				{
					for(int multiDestPack=0;multiDestPack<itinerary.getMultiDestinationPackages().size();multiDestPack++)
					{
						if(itinerary.getMultiDestinationPackages().get(multiDestPack)!=null)
						{
							for(int hbsiHotel=0;hbsiHotel<itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().size();hbsiHotel++)
							{
								if(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel)!=null 
							&& this.hbsiHotelDao.isHBSiHotelVendorCode(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).getHotelCode()))
								
								{
									HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).getHotelCode());
									itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).setHotelCode(hbsiHotelInfo.getHotelId());
								}
							}
						}
					
					}
					
				}
			
		}
		
		
		HotelConvertUtils.decodeHotelDesc(itinerary);
		 
		ItineraryResponse itineraryResponse = itineraryDao.saveItinerary(itinerary);
		HotelConvertUtils.encodeHotelDesc(itineraryResponse.getItinerary());
		return itineraryResponse;
	}

	/**
	 * 
	 * Method to email itinerary to customer/agent recipient, format based on
	 * emailFormat
	 * 
	 * @param itinerary
	 * @param emailFormat
	 * @param emailId
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse emailItinerary(Itinerary itinerary,
			String emailFormat, String emailId, EmailAndPrintMessage messages,
			String fromEmailId) {
		String bookingNumber = itinerary.getBookingHeader().getBookingNo();
		Itinerary retrieveItinerary = null;
		if (itinerary.getQuoteNo() != null
				&& itinerary.getQuoteNo().length() > 0) {
			retrieveItinerary = itinerarySearchDao.retrieveItinerary(
					itinerary.getQuoteNo()).getItinerary();
			retrieveItinerary.setItineraryPrice(itinerary.getItineraryPrice());
			List<Package> packageList = itinerary.getPackages();
			if (null != retrieveItinerary.getPackages()) {
				retrieveItinerary.getPackages().clear();
				for (Iterator<Package> iterator = packageList.iterator(); iterator
						.hasNext();) {

					Package package1 = iterator.next();
					try {
						retrieveItinerary.getPackages().add(
								(Package) package1.clone());
					} catch (CloneNotSupportedException e) {
						logger.warn("Clone not supported for Package class.");
					}
				}
			}
			if (null != itinerary.getHotels()) {

				List<Hotel> hotel = itinerary.getHotels();
				// Hotels list
				final ArrayList<Hotel> hotelsList = new ArrayList<Hotel>();
				retrieveItinerary.setHotels(hotelsList);
				for (Iterator<Hotel> iterator = hotel.iterator(); iterator
						.hasNext();) {
					Hotel hotel2 = iterator.next();
					try {
						hotel2 = (Hotel) hotel2.clone();
						// fix for null pointer exception for null preselected
						// rooms. Added after merging with trunk on 04/03/2013
						if (hotel2.getPreselectedRooms() == null)
							hotel2.setPreselectedRooms(new ArrayList<RoomPrice>());
						hotel2.getPreselectedRooms().clear();
						hotel2.getPreselectedRooms().addAll(hotel2.getSelectedRooms());
					} catch (CloneNotSupportedException e) {
						logger.warn("Clone not supported for Hotel class.");
					}
					if (null != hotel2) {
						retrieveItinerary.getHotels().add(hotel2);
					}
				}
			}

			if (null != itinerary.getFlights()) {

				List<TripFlight> flights = itinerary.getFlights();
				// Hotels list
				final ArrayList<TripFlight> flightsList = new ArrayList<TripFlight>();
				retrieveItinerary.setFlights(flightsList);
				for (Iterator<TripFlight> iterator = flights.iterator(); iterator
						.hasNext();) {
					TripFlight flight = iterator.next();
					try {
						flight = (TripFlight) flight.clone();
					} catch (CloneNotSupportedException e) {
						logger.warn("Clone not supported for Hotel class.");
					}
					if (null != flight) {
						retrieveItinerary.getFlights().add(flight);
					}
				}
			}

		} else {
			BookingSearchResponse searchResponse = bookingSearchDao
					.retrieveBooking(bookingNumber);
//			Code added to encode the room description before email itinerary
			searchResponse.setItinerary(HotelConvertUtils.encodeHotelDesc(searchResponse.getItinerary()));
			retrieveItinerary = searchResponse.getItinerary();
		}

		// Itinerary
		// retrieveItinerary=bookingSearchDao.retrieveBooking(bookingNumber).getItinerary();
		PaymentHistoryResponse paymentHistory = this
				.paymentHistory(bookingNumber);
		itinerary.getBookingHeader().setPaymentHistoryInformationList(
				paymentHistory.getPaymentHistoryInfoList());
		// Retrieve notices
		if (itinerary.getNotices() == null
				|| itinerary.getNotices().size() == 0) {
			AlertsResponse alertsResponse = alertsDao
					.retrieveAlerts(bookingNumber);
			if (!alertsResponse.isBusinessErrorOccurred()
					&& alertsResponse.getAlertList() != null) {
				itinerary.setNotices(alertsResponse.getAlertList());
			}
		}
		PrintItinerary printItinerary = retrieveItinerary.copyItinerary();
		printItinerary.getBookingHeader().setAgency(
				itinerary.getBookingHeader().getAgency());
		printItinerary.getBookingHeader().setPaymentHistoryInformationList(
				paymentHistory.getPaymentHistoryInfoList());
		printItinerary.setNotices(itinerary.getNotices());
		ItineraryResponse itineraryResponse = itineraryXMLDao.emailItinerary(
				printItinerary, emailFormat, emailId, messages, fromEmailId);

		if (!itineraryResponse.isErrorsOccurred()
				&& (itinerary.getBookingHeader().getBookingNo() != null && itinerary
						.getBookingHeader().getBookingNo() != "")) {
			Comment autoComment = new Comment();
			autoComment.setBookingNumber(bookingNumber);
			autoComment.setCreatedBy(itinerary.getImApplicationInfo()
					.getCreatedBy().toUpperCase());
			autoComment.setCommentType(CommentType.MANUAL);
			CUSTOMER_FORMAT_BOOKING = this.getMessageSource().getMessage(
					"CUSTOMER_FORMAT_BOOKING", new Object[] {}, null);
			AGENT_FORMAT_BOOKING = this.getMessageSource().getMessage(
					"AGENT_FORMAT_BOOKING", new Object[] {}, null);
			if (CUSTOMER_FORMAT_BOOKING.equals(emailFormat)) {
				autoComment.setCommentDetails(this.getMessageSource()
						.getMessage(
								"EMAIL_CUSTOMER_COMMENT",
								new Object[] {
										emailId,
										itinerary.getBookingHeader()
												.getTourPrice() }, null));
				commentsDao.addComment(autoComment);

			} else if (AGENT_FORMAT_BOOKING.equals(emailFormat)) {
				autoComment.setCommentDetails(this.getMessageSource()
						.getMessage(
								"EMAIL_AGENT_COMMENT",
								new Object[] {
										emailId,
										itinerary.getBookingHeader()
												.getTourPrice() }, null));
				commentsDao.addComment(autoComment);

			}

		}
		return itineraryResponse;
	}

	/**
	 * 
	 * Method to prepare content for print
	 * 
	 * @param itinerary
	 * @param printFormat
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse printItinerary(Itinerary itinerary,
			String printFormat, EmailAndPrintMessage messages) {

		String bookingNumber = itinerary.getBookingHeader().getBookingNo();

		Itinerary retrieveItinerary = null;

		if (itinerary.getQuoteNo() != null
				&& itinerary.getQuoteNo().length() > 0) {
			retrieveItinerary = itinerarySearchDao.retrieveItinerary(
					itinerary.getQuoteNo()).getItinerary();
			retrieveItinerary.setItineraryPrice(itinerary.getItineraryPrice());
			List<Package> packageList = itinerary.getPackages();
			// CQ#8840 - Code fix for NPE
			if (retrieveItinerary.getPackages() != null) {
				retrieveItinerary.getPackages().clear();
			}
			try {
				// CQ#8840 - Code fix for NPE
				if (packageList != null) {
					for (Iterator iterator = packageList.iterator(); iterator
							.hasNext();) {

						Package package1 = (Package) iterator.next();
						retrieveItinerary.getPackages().add(
								(Package) package1.clone());
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			BookingSearchResponse searchResponse = bookingSearchDao
					.retrieveBooking(bookingNumber);
//			Code added to encode the room description before email itinerary
			searchResponse.setItinerary(HotelConvertUtils.encodeHotelDesc(searchResponse.getItinerary()));
			retrieveItinerary = searchResponse.getItinerary();
		}

		PaymentHistoryResponse paymentHistory = this
				.paymentHistory(bookingNumber);
		itinerary.getBookingHeader().setPaymentHistoryInformationList(
				paymentHistory.getPaymentHistoryInfoList());
		// Retrieve notices
		if (itinerary.getNotices() == null
				|| itinerary.getNotices().size() == 0) {
			AlertsResponse alertsResponse = alertsDao
					.retrieveAlerts(bookingNumber);
			if (!alertsResponse.isBusinessErrorOccurred()
					&& alertsResponse.getAlertList() != null) {
				itinerary.setNotices(alertsResponse.getAlertList());
			}
		}
		PrintItinerary printItinerary = retrieveItinerary.copyItinerary();

		printItinerary.getBookingHeader().setAgency(
				itinerary.getBookingHeader().getAgency());
		if (itinerary.getQuoteNo() == null)
			printItinerary.getBookingHeader().setPaymentHistoryInformationList(
					paymentHistory.getPaymentHistoryInfoList());
		printItinerary.setNotices(itinerary.getNotices());

		ItineraryResponse itineraryResponse = itineraryXMLDao.printItinerary(
				printItinerary, printFormat, messages);
		if (!itineraryResponse.isErrorsOccurred()
				&& (itinerary.getBookingHeader().getBookingNo() != null && itinerary
						.getBookingHeader().getBookingNo() != "")) {
			Comment autoComment = new Comment();
			autoComment.setBookingNumber(bookingNumber);
			autoComment.setCreatedBy(itinerary.getImApplicationInfo()
					.getCreatedBy().toUpperCase());
			autoComment.setCommentType(CommentType.MANUAL);
			CUSTOMER_FORMAT_BOOKING = this.getMessageSource().getMessage(
					"CUSTOMER_FORMAT_BOOKING", new Object[] {}, null);
			AGENT_FORMAT_BOOKING = this.getMessageSource().getMessage(
					"AGENT_FORMAT_BOOKING", new Object[] {}, null);

			if (CUSTOMER_FORMAT_BOOKING.equals(printFormat)) {
				autoComment.setCommentDetails(this.getMessageSource()
						.getMessage(
								"PRINT_CUSTOMER_COMMENT",
								new Object[] { itinerary.getBookingHeader()
										.getTourPrice() }, null));
				commentsDao.addComment(autoComment);

			} else if (AGENT_FORMAT_BOOKING.equals(printFormat)) {
				autoComment.setCommentDetails(this.getMessageSource()
						.getMessage(
								"PRINT_AGENT_COMMENT",
								new Object[] { itinerary.getBookingHeader()
										.getTourPrice() }, null));
				commentsDao.addComment(autoComment);

			}

		}
		return itineraryResponse;
	}

	/**
	 * 
	 * Method to prepare payment content for email and print
	 * 
	 * @param itinerary
	 * @param printFormat
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public PaymentHistoryResponse paymentHistory(String bookingNumber) {
		return paymentHistoryDao.getPaymentHistory(bookingNumber);

	}

	public ItineraryResponse extendOptionDateOfItinerary(Itinerary itinerary) {

		return itineraryDao.extendOptionDateOfItinerary(itinerary);
	}

	/**
	 * 
	 * Overloaded method for emailing itinerary comparison
	 * 
	 * @param itineraries
	 * @param imgByteArray
	 * @param emailId
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse emailItinerary(List<Itinerary> itineraries,
			byte[] imgByteArray, String emailId) {
		return itineraryComparisonEmailDao.sendItineraryComparisonEmail(
				itineraries, imgByteArray, emailId);
	}

	/**
	 * 
	 * Method to set TokenNo on viewItinerary
	 * 
	 * @param bookingNumber
	 * @param
	 * @return itineraryResponse
	 * 
	 */
	public ItineraryResponse viewItinerary(String bookingNumber) {
		ItineraryResponse viewResponse = new ItineraryResponse();
		// IMApplicationInfo imApplicationInfo = this
		// .getApplicationContextFactory().getApplicationContext()
		// .getRequestContext().getIMApplicationInfo();
		// if (imApplicationInfo.getType() != null
		// && imApplicationInfo.getType().isTravelAgent()) {
		// viewResponse.setTokenNo(tokenProcessNo.getTaHash(bookingNumber));
		// } else {
		// viewResponse.setTokenNo(tokenProcessNo.getPaxHash(bookingNumber));
		// }
		viewResponse.setTokenNo(tokenProcessNo.getTaHash(bookingNumber));
		return viewResponse;
	}

	/**
	 * Sets MD5 token depending on agency or consumer copy requested
	 * 
	 * @param viewItineraryCommand
	 * @return anItineraryResponse
	 */
	public ItineraryResponse viewInvoice(
			ViewItineraryCommand viewItineraryCommand) {
		ItineraryResponse viewResponse = new ItineraryResponse();
		if ("X".equals(viewItineraryCommand.getAgencyCopy()))
			viewResponse.setTokenNo(tokenProcessNo
					.getTaHash(viewItineraryCommand.getBookingNo()));
		else
			viewResponse.setTokenNo(tokenProcessNo
					.getPaxHash(viewItineraryCommand.getBookingNo()));
		return viewResponse;
	}

	/**
	 * Method to price and cancel the itinerary of given booking no.
	 * 
	 * @param bookingNo
	 *            - Booking number of the itinerary to be canceled
	 * @param cancelItinerary
	 *            - If the flag is true, price and cancel the itinerary. If the
	 *            flag is false, then only price the itinerary for cancellation.
	 *            Do not cancel it.
	 * @return
	 */
	public ItineraryResponse priceAndCancelItinerary(String bookingNo,
			boolean cancelItinerary,Itinerary oldItinerary) {
		
		List<String> seatErrorList = null;
		ItineraryResponse itineraryResponse = null;
		itineraryResponse = this.itineraryDao.priceAndCancelItinerary(bookingNo,
				cancelItinerary);
		
		//Now itinerary cancel is successful and we are doing seat cancellation
		
		//Need to check for itinerary error
		if(!itineraryResponse.isErrorsOccurred() && !SeatMapUtils.isSeatWarningMessage(itineraryResponse.getWarnings()))
		{
			try 
			{
				SeatMapUtils.prepareForItineraryCancellation(oldItinerary);
				seatErrorList = seatBookModifyCancelService.validateBookCancelSeats(oldItinerary , null , true);
			} catch (Exception e) {
				logger.error("Error in cancelling seats  -"+e.getStackTrace());
			}
		}
		return itineraryResponse;
	}

	/**
	 * @param hotelsDao
	 *            the hotelsDao to set
	 */
	public void setHotelsDao(HotelsDao hotelsDao) {
		this.hotelsDao = hotelsDao;
	}

	/**
	 * @return the hotelsDao
	 */
	public HotelsDao getHotelsDao() {
		return hotelsDao;
	}

	/**
	 * @param itineraryPricingDao
	 *            the itineraryPricingDao to set
	 */
	public void setItineraryPricingDao(ItineraryPricingDao itineraryPricingDao) {
		this.itineraryPricingDao = itineraryPricingDao;
	}

	/**
	 * @return the itineraryPricingDao
	 */
	public ItineraryPricingDao getItineraryPricingDao() {
		return itineraryPricingDao;
	}
	
	/**
	 * @return the seatBookModifyCancelService
	 */
	public SeatBookModifyCancelService getSeatBookModifyCancelService() {
		return seatBookModifyCancelService;
	}

	/**
	 * @param seatBookModifyCancelService the seatBookModifyCancelService to set
	 */
	public void setSeatBookModifyCancelService(
			SeatBookModifyCancelService seatBookModifyCancelService) {
		this.seatBookModifyCancelService = seatBookModifyCancelService;
	}

	/**
	 * @return the hbsiHotelsOnly
	 */
	public HBSiHotelsOnlyDao getHbsiHotelsOnly() {
		return hbsiHotelsOnly;
	}

	/**
	 * @param hbsiHotelsOnly the hbsiHotelsOnly to set
	 */
	public void setHbsiHotelsOnly(HBSiHotelsOnlyDao hbsiHotelsOnly) {
		this.hbsiHotelsOnly = hbsiHotelsOnly;
	}
	
	//@Override
	public void receiveSupplierConfirmation(HotelConfirmation hotelConfirmation) {
		hotelConfirmation = this.hbsiHotelDao.getSAPBookingDetails(hotelConfirmation);
		this.itineraryDao.updateSupplierConfirmation(hotelConfirmation);
	}
}
