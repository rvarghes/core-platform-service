/*
 * FlightsServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 26, 2009  hguntupa
 * Jun 24, 2009  nvittal	  Added method for retrieving adv sked search options
 * Sep 24, 2009  hguntupa	  Refactored code to create FlightsRequest object
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

import org.springframework.core.task.AsyncTaskExecutor;

import com.kcdata.abe.business.request.FlightsRequest;
import com.kcdata.abe.business.response.FlightInfoResponse;
import com.kcdata.abe.business.response.FlightsResponse;
import com.kcdata.abe.data.dao.FlightInfoDao;
import com.kcdata.abe.data.dao.FlightsDao;
import com.kcdata.abe.data.dao.GatewayDestinationsDao;
import com.kcdata.abe.data.dao.threads.AvailabilityThreadDao;
import com.kcdata.abe.data.dto.FlightInfoCriteria;
import com.kcdata.abe.data.dto.FlightRequestType;
import com.kcdata.abe.data.dto.FlightType;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.GroupedTripFlight;
import com.kcdata.abe.data.factory.AvailabilityDaoFactory;
import com.kcdata.abe.data.util.FlightUtils;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.response.ABEResponse;
import com.kcdata.abe.framework.service.ABEServiceBase;
import com.kcdata.abe.data.dao.CharterGatewayDestinationsDao;
import com.kcdata.abe.business.response.CharterGatewayDestinationResponse;

/**
 * Service class for retrieving flights RetrieveFligths usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class FlightsServiceImpl extends ABEServiceBase implements
		FlightsService {

	ABELogger logger = ABELogger.getLogger(FlightsServiceImpl.class);

	/**
	 * Task executor for executing the threads
	 */
	private AsyncTaskExecutor taskExecutor;

	/**
	 * Service Interface to create the Availability Dao objects
	 */
	private AvailabilityDaoFactory availabilityDaoFactory;

	/**
	 * Charter flights dao used for retrieving charter flights from Charter
	 * Cache
	 */
	private FlightsDao charterFlightsDao;

	/**
	 * Flights dao used for retrieving SKED flights and Charter one-way flights
	 * from Worldspan
	 */
	private FlightsDao flightsDao;

	/**
	 * DAO class for retrieving flight information
	 */
	private FlightInfoDao flightInfoDao;

	/**
	 * Dao class for validating the Charter Gateway and destinations
	 */
	private GatewayDestinationsDao gatewayDestinationsDao;
	
	//Added for 3620543
	/**
	 * Dao class for validating the charter Gateway 
	 */
	private CharterGatewayDestinationsDao charterGatewayDestinationsDao;
	
	private PricingThreadService pricingThreadService;

	/**
	 * Method to retrieve flights
	 * 
	 * @param searchCriteria
	 *            - Search criteria
	 * @return Flights
	 * 
	 * @see
	 * @since
	 */
	public FlightsResponse retrieveFlights(SearchCriteria searchCriteria) {
 		FlightsResponse flightsResponse = new FlightsResponse();

		// Create the Flight Request object
		FlightsRequest flightsRequest = searchCriteria.getFlightRequest();
		// If Gateway or destination or duration is null, then retrieve charter
		// air only.
		boolean charterOnly = false;
		//Variable added for 3620543.
		boolean ischarterGateway  = false;
		if (searchCriteria.getGateway() == null
				|| "".equals(searchCriteria.getGateway().trim())
				|| flightsRequest.getDestination() == null
				|| "".equals(flightsRequest.getDestination().trim())
				|| (flightsRequest.getNoOfNights() == 0 && (flightsRequest
						.getTripType() == null || flightsRequest.getTripType()
						.isRoundTrip()))) {
			charterOnly = true;
		}
		/**--- 3620543 Coding Start---**/
		if (searchCriteria.getGateway() != null
				&& !"".equals(searchCriteria.getGateway().trim())){
			CharterGatewayDestinationResponse chrtrGatewayResponse = charterGatewayDestinationsDao.retrieveCharterGatewayDestinations();
			ischarterGateway = FlightUtils.isGatewayCharter(chrtrGatewayResponse.getGatewayList(),searchCriteria.getGateway());
		}
		/**--- 3620543 Coding End---**/
		//This will identify when to retrieve availability of 6-night charter flights in sap
		flightsRequest.setCheckCharterOfferFlight(searchCriteria.isCheckCharterOfferFlight());
		if (flightsRequest.isCharterOnly() || charterOnly) {
			// Retrieve only charter flights
			flightsRequest.setFlightRequestType(FlightRequestType.CHARTER);
			if (flightsRequest.getTripType().isRoundTrip()) {
				
				//if no 6-night charter flight offer then continue retrieving original search criteria
				boolean hasCharterOffer = checkFlightOffer(flightsResponse, flightsRequest);;
				if (hasCharterOffer)
					return flightsResponse;
					// If round trip, then call cache
					flightsResponse = charterFlightsDao
					.retrieveFlights(flightsRequest);
			} else {
				flightsResponse = flightsDao.retrieveFlights(flightsRequest);
			}
		} else if (flightsRequest.isSkedOnly()) {
			// Retrieve only sked flights
			flightsRequest.setFlightRequestType(FlightRequestType.SCHEDULED);
			flightsResponse = flightsDao.retrieveFlights(flightsRequest);
		} else {
			try {
				boolean isValidCharterPair = gatewayDestinationsDao
						.isCharterOfferedGatewayDestination(flightsRequest
								.getGateway(), flightsRequest.getDestination());
				if (!isValidCharterPair
						&& flightsRequest.getTripType().isOnewayTrip()) {
					isValidCharterPair = gatewayDestinationsDao
							.isCharterOfferedGatewayDestination(flightsRequest
									.getDestination(), flightsRequest
									.getGateway());
				}
				//if no 6-night charter flight offer then continue retrieving original search criteria
				boolean hasCharterOffer = checkFlightOffer(flightsResponse, flightsRequest);;
				if (hasCharterOffer)
					return flightsResponse;
					// Retrieve both charter and sked flights
					// Create threads for executing the charter and sked in parllel
					// and combine the response
					AvailabilityThreadDao charterDao = null;
					Future<ABEResponse> charterFuture = null;
					if (isValidCharterPair) {
						charterDao = (AvailabilityThreadDao) availabilityDaoFactory
						.createAvailabilityThreadDao();
						// Copy the context information to the Threads
						charterDao.setApplicationContext(this
								.getApplicationContextFactory()
								.getApplicationContext());

						// Clone the flight request object
						FlightsRequest charterRequest = (FlightsRequest) flightsRequest
						.clone();
						charterRequest
						.setFlightRequestType(FlightRequestType.CHARTER);
						// Set the flight request for charter dao
						charterDao.setAbeRequest(charterRequest);
						// Call the Charter Dao
						charterFuture = taskExecutor.submit(charterDao);
					}
					AvailabilityThreadDao skedDao = (AvailabilityThreadDao) availabilityDaoFactory
					.createAvailabilityThreadDao();

					skedDao
					.setApplicationContext(this
							.getApplicationContextFactory()
							.getApplicationContext());

					// Set the flight request for charter dao
					flightsRequest
					.setFlightRequestType(FlightRequestType.SCHEDULED);
					skedDao.setAbeRequest(flightsRequest);
					// Call the SKED dao
					Future<ABEResponse> skedFuture = taskExecutor.submit(skedDao);

					List<TripFlight> flightsList = null;
					if (isValidCharterPair) {
						// Wait for Charter response
						FlightsResponse charterResponse = (FlightsResponse) charterFuture
						.get();

						flightsResponse.processResponse(charterResponse);

						flightsList = charterResponse.getFlightList();
						//set charter result for soldout flight
						flightsResponse.setSoldOutFlights(charterResponse.isSoldOutFlights());
					}
					// Wait for SKED response
					FlightsResponse skedResponse = (FlightsResponse) skedFuture
					.get();
					flightsResponse.processResponse(skedResponse);
					if (skedResponse.getFlightList() != null) {
						if (flightsList != null) {
							flightsList.addAll(skedResponse.getFlightList());
						} else {
							flightsList = skedResponse.getFlightList();
						}
					}
					flightsResponse.setFlightList(flightsList);
			} catch (RejectedExecutionException rx) {
				ABESystemError systemError = new ABESystemError(
						"UNABLE_TO_EXECUTE_THE_FLIGHTS_REQUEST",
						this.getMessageSource().getMessage(
								"UNABLE_TO_EXECUTE_THE_FLIGHTS_REQUEST", null,
								null));
				throw new ABESystemException(systemError, ABETier.BUSINESS, rx);
			} catch (Exception ex) {
				ABESystemError systemError = new ABESystemError(
						"UNABLE_TO_RETRIEVE_FLIGHTS_AVAILABILITY",
						this.getMessageSource().getMessage(
								"UNABLE_TO_RETRIEVE_FLIGHTS_AVAILABILITY",
								null, null));
				throw new ABESystemException(systemError, ABETier.BUSINESS, ex);
			}
		}
		if (flightsResponse.getFlightList() != null) {
			flightsResponse.setFlightList(FlightUtils.sortFlights(
					flightsResponse.getFlightList(), flightsRequest, false));
			
			//IGT-A--Issue # 3620601---START
			//This code here generating tripFlight groups, the code shifted from flex to java
			List <GroupedTripFlight>arrFlightsFilterted = new ArrayList<GroupedTripFlight>();
			List <TripFlight>tempArrFlightsFilterted = new ArrayList<TripFlight>();
			
			for(TripFlight tf: flightsResponse.getFlightList())
			{
				try{
					tf.setFlightRotForInternalUse(tf.getOutboundFlight().getFlightId().substring(19,20));
					 
					if("ONEWAY".equalsIgnoreCase((tf.getTripType().toString()))){
						//ONEWAY FLIGHT : outBoundFlightId + outBoundFlightRotation--IGT-A
						tf.setFlightIdForInternalUse((tf.getOutboundFlight().getFlightId().substring(0,18)) 
													+ tf.getFlightRotForInternalUse());
					}
					else
					{
						//ROUNDTRIP FLIGHT : outBoundFlightId + outBoundFlightRotation + inBoundFlightId + inBoundFlightRotation--IGT-A
						tf.setFlightIdForInternalUse((tf.getOutboundFlight().getFlightId().substring(0,18)) 
								+ tf.getFlightRotForInternalUse()
								+ (tf.getInboundFlight().getFlightId().substring(0,18))
								+ (tf.getInboundFlight().getFlightId().substring(19,20)));
					}
					tf.setFlightClassForInternalUse(tf.getOutboundFlight().getFlightId().substring(18,19));	
				}
				catch(IndexOutOfBoundsException iob)
				{
					System.out.println("Exception : "+iob.toString());
				}
			}
			boolean tfExistenceChecker;
			arrFlightsFilterted.clear();
			List <TripFlight> tempBVF;
			for (TripFlight tfMain : flightsResponse.getFlightList() ){
				if((tfMain.getFlightType().isPublished()) || (tfMain.getFlightType().isBulk())){
					tfMain.setFlightSelectedForDisplay(true);
					GroupedTripFlight groupTripFlight = new GroupedTripFlight();
					groupTripFlight.setFlightId(tfMain.getFlightIdForInternalUse());
					groupTripFlight.setFlightTypeStr(tfMain.getFlightType().toString());
					tempBVF = new ArrayList<TripFlight>();
					tempBVF.add(tfMain);
					groupTripFlight.setTripFlights(tempBVF);
					arrFlightsFilterted.add(groupTripFlight);
				}
				else
				{
					tfExistenceChecker = false;
			
					for (GroupedTripFlight gtp: arrFlightsFilterted ){
						if (tfMain.getFlightIdForInternalUse().equals(gtp.getFlightId())){
							tfExistenceChecker = true;
							break;
						}
						
					}//end for loop
					if (tfExistenceChecker){
						continue;
					}
					
					tempBVF = new ArrayList<TripFlight>();
					String tfId = "";
					String tfCS = "";
					
					GroupedTripFlight groupTripFlight = new GroupedTripFlight();
					groupTripFlight.setFlightId(tfMain.getFlightIdForInternalUse());
					groupTripFlight.setFlightTypeStr(tfMain.getFlightType().toString());
					//now make a group of flights whose flightIdForInternalUse is same.--START
					for (TripFlight tfMainInner : flightsResponse.getFlightList() )
					{
						if((tfMainInner.getFlightIdForInternalUse()).equals(tfMain.getFlightIdForInternalUse()))		//if currentFlight(tfMain) matches internal looped flight, so include them in tempAC
						{
							if(tempBVF.size() == 0)	//if tempAC was empty, add first tripFlight which will make a group of same ID.
							{
								tempBVF.add(tfMainInner);
								tfId = tfMainInner.getFlightIdForInternalUse();
								tfCS = tfMainInner.getFlightClassForInternalUse();
							}
							else
							{
								if((tfId.equals(tfMainInner.getFlightIdForInternalUse())) 
										&& (!tfCS.equals(tfMainInner.getFlightClassForInternalUse())))
								{
									tempBVF.add(tfMainInner);
								}
							}
						}
					}//for end 
					//IGT-A---Issue # 3620601---Finding the minimum priced class of service---START 
					TripFlight firstTF = (TripFlight)tempBVF.get(0);
					for (TripFlight priceTf : tempBVF)
					{
						priceTf.setFlightSelectedForDisplay(false);
						if(priceTf.getPrice().getOccpancyBasedPrice() < firstTF.getPrice().getOccpancyBasedPrice())
							firstTF = priceTf;
					}
					firstTF.setFlightSelectedForDisplay(true);	//Minimum priced class of services' flightSelectedForDisplay to true
					//IGT-A--END
					groupTripFlight.setTripFlights(tempBVF);
					arrFlightsFilterted.add(groupTripFlight);
				}//else end
			}
		
			/*--- 3535943 Issue Sagar.. Sending Flight for repricing---*/
			// Only for Change booking scenario
			//Check if shop more is is clicked then below code is bypassed.
			if(!searchCriteria.isShopMoreIndicator() && flightsRequest.getBookingNo() != null && !"".equals(flightsRequest.getBookingNo())||
					searchCriteria.isChangeFlightOnly()){
				//Send Only ABE change booking flights for pricing
				String contextID = this.getApplicationContextFactory().getApplicationContext().getRequestContext().getIMApplicationInfo().getContextID();
				if(contextID!=null && !"".equals(contextID) && "ABE".equalsIgnoreCase(contextID)){
					arrFlightsFilterted = pricingThreadService.createItineraryForFlightOnlyPricingOnFirstInstance(arrFlightsFilterted, flightsResponse, flightsRequest, searchCriteria.getItineraryChangeFlight());
					//This code will remove the flights whose package price is not calculated properly.
					for(GroupedTripFlight grpdTripFlight : arrFlightsFilterted)
					{
						if(grpdTripFlight.isPackagePriced()){
						tempBVF = new ArrayList<TripFlight>();
						for (TripFlight tFlight : grpdTripFlight.getTripFlights())
						{
							if(tFlight.isPackagePriceSet())
								tempBVF.add(tFlight);			
						}
						if(tempBVF.size() == 0)
						{
							grpdTripFlight.getTripFlights().clear();
						}
						else{
							TripFlight firstTF = (TripFlight)tempBVF.get(0);
							for (TripFlight priceTf : tempBVF){
								priceTf.setFlightSelectedForDisplay(false);
								if(priceTf.getPrice().getOccpancyBasedPrice() < firstTF.getPrice().getOccpancyBasedPrice())
									firstTF = priceTf;
								}
							firstTF.setFlightSelectedForDisplay(true);	//Minimum priced class of services' flightSelectedForDisplay to true
							grpdTripFlight.getTripFlights().clear();
							grpdTripFlight.setTripFlights(tempBVF);
							}
						tempBVF = null;	//Release this object, job over.
						}
					}
				}
			}
			/*--- 3535943 Issue Sagar.. Sending Flight for repricing Ends ---*/
			//IGT-A--END
			//IGT-A---Issue # 3620601---Here we are maintaining List which will be used directly at the front end.---START 
			for (GroupedTripFlight gtf1 : arrFlightsFilterted)
			{
				for (TripFlight tf1 : gtf1.getTripFlights())
				{
					if(tf1.isFlightSelectedForDisplay())
						tempArrFlightsFilterted.add(tf1);
				}
			}
			
			flightsResponse.setGroupedTripFlight(arrFlightsFilterted);
			flightsResponse.setDisplayTripFlightList(tempArrFlightsFilterted);
			//IGT-A--Issue # 3620601---END
		} else {
			/**--- 3620543 Coding Start---**/
			List<ABEBusinessError> errorList = new ArrayList<ABEBusinessError>();
			if(flightsRequest.getDestination() == null
					|| "".equals(flightsRequest.getDestination().trim())){
					if(flightsResponse.getBusinessErrors()!=null)
						flightsResponse.getBusinessErrors().clear();
					ABEBusinessError headerErrorMsg = new ABEBusinessError("HEADER_ERROR_MESSAGE",this.getMessageSource()
						.getMessage("HEADER_ERROR_MESSAGE", null,
								null));
					ABEBusinessError destinationErrorMsg = new ABEBusinessError("BLANK_DESTINATION",this.getMessageSource()
							.getMessage("BLANK_DESTINATION", null,
									null));
					errorList.add(headerErrorMsg);
					errorList.add(destinationErrorMsg);
					if(flightsRequest.getNoOfNights() == 0){
						ABEBusinessError nightsErrorMsg = new ABEBusinessError("ZERO_NIGHTS",this.getMessageSource()
								.getMessage("ZERO_NIGHTS", null,
										null));
						errorList.add(nightsErrorMsg);
					}
			}
			else if(flightsRequest.getNoOfNights() == 0 && !ischarterGateway){
				if(flightsResponse.getBusinessErrors()!=null)
					flightsResponse.getBusinessErrors().clear();
				ABEBusinessError headerErrorMsg = new ABEBusinessError("HEADER_ERROR_MESSAGE",this.getMessageSource()
						.getMessage("HEADER_ERROR_MESSAGE", null,
								null));
				ABEBusinessError nightsErrorMsg = new ABEBusinessError("ZERO_NIGHTS",this.getMessageSource()
						.getMessage("ZERO_NIGHTS", null,
								null));
				errorList.add(headerErrorMsg);
				errorList.add(nightsErrorMsg);
			}
			else{
				//a separate popup will display in ABE if charter flights are sold out.
				if (!flightsResponse.isSoldOutFlights()){
					ABEBusinessError error = new ABEBusinessError(
							"UNABLE_TO_RETRIEVE_FLIGHTS", this.getMessageSource()
							.getMessage("UNABLE_TO_RETRIEVE_FLIGHTS", null,
									null));
					errorList.add(error);
				}
			}
			flightsResponse.saveBusinessErrors(errorList);
			/**--- 3620543 Coding End---**/
		}
		return flightsResponse;
	}

	/**
	 * Method to retrieve the charter flights availability dates
	 * 
	 * @param flightInfoCriteria
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public FlightsResponse retrieveCharterOperatingDates(
			SearchCriteria searchCriteria) {
		FlightsResponse flightsResponse = new FlightsResponse();

		// Create the Flight Request object
		FlightsRequest flightsRequest = searchCriteria.getFlightRequest();
		flightsRequest.setFlightRequestType(FlightRequestType.CHARTER);
		flightsResponse = charterFlightsDao
				.retrieveCharterOperatingDates(flightsRequest);
		return flightsResponse;
	}

	/**
	 * Method to retrieve the flights information
	 * 
	 * @param flightInfoCriteria
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public FlightInfoResponse retrieveFlightInfo(
			FlightInfoCriteria flightInfoCriteria) {
		return this.flightInfoDao.retrieveFlightInfo(flightInfoCriteria);
	}

	/**
	 * @return the charterFlightsDao
	 */
	public FlightsDao getCharterFlightsDao() {
		return charterFlightsDao;
	}

	/**
	 * @param charterFlightsDao
	 *            the charterFlightsDao to set
	 */
	public void setCharterFlightsDao(FlightsDao charterFlightsDao) {
		this.charterFlightsDao = charterFlightsDao;
	}

	/**
	 * @return the flightsDao
	 */
	public FlightsDao getFlightsDao() {
		return flightsDao;
	}

	/**
	 * @param flightsDao
	 *            the flightsDao to set
	 */
	public void setFlightsDao(FlightsDao flightsDao) {
		this.flightsDao = flightsDao;
	}

	/**
	 * @return the taskExecutor
	 */
	public AsyncTaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	/**
	 * @param taskExecutor
	 *            the taskExecutor to set
	 */
	public void setTaskExecutor(AsyncTaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	/**
	 * @return the availabilityDaoFactory
	 */
	public AvailabilityDaoFactory getAvailabilityDaoFactory() {
		return availabilityDaoFactory;
	}

	/**
	 * @param availabilityDaoFactory
	 *            the availabilityDaoFactory to set
	 */
	public void setAvailabilityDaoFactory(
			AvailabilityDaoFactory availabilityDaoFactory) {
		this.availabilityDaoFactory = availabilityDaoFactory;
	}

	/**
	 * @return the flightInfoDao
	 */
	public FlightInfoDao getFlightInfoDao() {
		return flightInfoDao;
	}

	/**
	 * @param flightInfoDao
	 *            the flightInfoDao to set
	 */
	public void setFlightInfoDao(FlightInfoDao flightInfoDao) {
		this.flightInfoDao = flightInfoDao;
	}

	/**
	 * @return the gatewayDestinationsDao
	 */
	public GatewayDestinationsDao getGatewayDestinationsDao() {
		return gatewayDestinationsDao;
	}

	/**
	 * @param gatewayDestinationsDao
	 *            the gatewayDestinationsDao to set
	 */
	public void setGatewayDestinationsDao(
			GatewayDestinationsDao gatewayDestinationsDao) {
		this.gatewayDestinationsDao = gatewayDestinationsDao;
	}

	/**
	 * @return the charterGatewayDestinationsDao
	 */
	public CharterGatewayDestinationsDao getCharterGatewayDestinationsDao() {
		return charterGatewayDestinationsDao;
	}

	/**
	 * @param charterGatewayDestinationsDao the charterGatewayDestinationsDao to set
	 */
	public void setCharterGatewayDestinationsDao(
			CharterGatewayDestinationsDao charterGatewayDestinationsDao) {
		this.charterGatewayDestinationsDao = charterGatewayDestinationsDao;
	}

	/**
	 * @return the pricingThreadService
	 */
	public PricingThreadService getPricingThreadService() {
		return pricingThreadService;
	}

	/**
	 * @param pricingThreadService the pricingThreadService to set
	 */
	public void setPricingThreadService(PricingThreadService pricingThreadService) {
		this.pricingThreadService = pricingThreadService;
	}
	
	/***
	 * check if there is flight offer with alternate duration available
	 * @param flightsResponse
	 * @param flightsRequest
	 * @return
	 */
	private boolean checkFlightOffer(FlightsResponse flightsResponse, FlightsRequest flightsRequest){
		boolean hasCharterOffer = false;
		if (flightsRequest.isCheckCharterOfferFlight()){
			flightsRequest.setFlightRequestType(FlightRequestType.CHARTER);
			FlightsResponse flightOfferResponse = charterFlightsDao.retrieveFlightOffer(flightsRequest);
			flightsResponse.setFlightOffer(flightOfferResponse.getFlightOffer());
			if (flightOfferResponse.getFlightOffer()!= null && flightOfferResponse.getFlightOffer().isCharterFlightOffer())
				hasCharterOffer = true;
		}
		return hasCharterOffer;
	}
}