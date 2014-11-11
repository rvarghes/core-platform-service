/*
 * PackagesServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 24, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

import org.springframework.core.task.AsyncTaskExecutor;

import com.applevac.sce.schema.Special;
import com.applevac.sce.schema.Specials;
import com.applevac.sce.service.external.SpecialsSearchCriteria;
import com.kcdata.abe.business.request.FlightsRequest;
import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.request.PackagesRequest;
import com.kcdata.abe.business.response.AllPriceBreakUpResponse;
import com.kcdata.abe.business.response.FlightsResponse;
import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.business.response.PackagesResponse;
import com.kcdata.abe.business.response.SpecialsCacheResponse;
import com.kcdata.abe.business.response.VehiclesResponse;
import com.kcdata.abe.data.dao.FlightsDao;
import com.kcdata.abe.data.dao.GatewayDestinationsDao;
import com.kcdata.abe.data.dao.HBSiHotelDao;
import com.kcdata.abe.data.dao.ItineraryPricingDao;
import com.kcdata.abe.data.dao.PackagesDAO;
import com.kcdata.abe.data.dao.SpecialsCacheDao;
import com.kcdata.abe.data.dao.WesbPackagesDAO;
import com.kcdata.abe.data.dao.threads.AvailabilityThreadDao;
import com.kcdata.abe.data.dto.FlightRequestType;
import com.kcdata.abe.data.dto.GroupedTripFlight;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.SpecialOptions;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.factory.AvailabilityDaoFactory;
import com.kcdata.abe.data.util.FlightUtils;
import com.kcdata.abe.data.util.FlightConvertUtils;
import com.kcdata.abe.data.util.HotelRatingComparator;
import com.kcdata.abe.data.util.SpecialUtils;
import com.kcdata.abe.data.util.TripFlightPriceComparator;
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
 * Implementation class for packages service
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class PackagesServiceImpl extends ABEServiceBase implements
		PackagesService {

	ABELogger logger = ABELogger.getLogger(PackagesServiceImpl.class);

	/**
	 * Task executor for executing the threads
	 */
	private AsyncTaskExecutor taskExecutor;

	/**
	 * Service Interface to create the Availability Dao objects
	 */
	private AvailabilityDaoFactory availabilityDaoFactory;

	/**
	 * Packages DAO
	 */
	private PackagesDAO packagesDAO;

	private HBSiHotelDao hbsiHotelDao;

	private FlightsDao charterFlightsDao;

	/**
	 * @return the hbsiHotelDao
	 */
	public HBSiHotelDao getHbsiHotelDao() {
		return hbsiHotelDao;
	}

	/**
	 * @param hbsiHotelDao
	 *            the hbsiHotelDao to set
	 */
	public void setHbsiHotelDao(HBSiHotelDao hbsiHotelDao) {
		this.hbsiHotelDao = hbsiHotelDao;
	}

	/**
	 * Packages DAO for WESB
	 */
	private WesbPackagesDAO wesbPackagesDAO;

	/**
	 * @return the wesbPackagesDAO
	 */
	public WesbPackagesDAO getWesbPackagesDAO() {
		return wesbPackagesDAO;
	}

	/**
	 * @param wesbPackagesDAO
	 *            the wesbPackagesDAO to set
	 */
	public void setWesbPackagesDAO(WesbPackagesDAO wesbPackagesDAO) {
		this.wesbPackagesDAO = wesbPackagesDAO;
	}

	/**
	 * Dao class for validating the Charter Gateway and destinations
	 */
	private GatewayDestinationsDao gatewayDestinationsDao;

	private SpecialsCacheDao specialsCacheDao;

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
	 * @return the packagesDAO
	 */
	public PackagesDAO getPackagesDAO() {
		return packagesDAO;
	}

	/**
	 * @param packagesDAO
	 *            the packagesDAO to set
	 */
	public void setPackagesDAO(PackagesDAO packagesDAO) {
		this.packagesDAO = packagesDAO;
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
	
	//Added for 3620543
	/**
	 * Dao class for validating the charter Gateway 
	 */
	private CharterGatewayDestinationsDao charterGatewayDestinationsDao;
	
	
	private ItineraryPricingDao itineraryPricingDao;

	
	private PricingThreadService pricingThreadService;
	/**
	 * Method to retrieve the flights for packages
	 * 
	 * @param request
	 *            - request for packages
	 * @return PackagesResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public PackagesResponse changeFlights(SearchCriteria searchCriteria,
			Package availablePackage) {
		// Retrieve the request objects
		PackagesRequest packagesRequest = searchCriteria.getPackagesRequest();
		PackagesResponse toReturnPackagesResponse = new PackagesResponse();
		packagesRequest.setAvailablePackage(availablePackage);

		try {
			Future<ABEResponse> charterFuture = null;
			Future<ABEResponse> skedFuture = null;
			if (!packagesRequest.getFlightsRequest().isCharterOnly()) {
				AvailabilityThreadDao skedDao = (AvailabilityThreadDao) availabilityDaoFactory
						.createAvailabilityThreadDao();
				skedDao.setApplicationContext(this
						.getApplicationContextFactory().getApplicationContext());
				// Set the flight request for charter dao
				FlightsRequest skedRequest = (FlightsRequest) packagesRequest
						.getFlightsRequest().clone();
				skedRequest.setFlightRequestType(FlightRequestType.SCHEDULED);
				skedDao.setAbeRequest(skedRequest);
				// Call the SKED dao
				skedFuture = taskExecutor.submit(skedDao);
			}
			boolean isValidCharterPair = gatewayDestinationsDao
					.isCharterOfferedGatewayDestination(packagesRequest
							.getFlightsRequest().getGateway(), packagesRequest
							.getFlightsRequest().getDestination());

			if (!packagesRequest.getFlightsRequest().isSkedOnly()
					&& isValidCharterPair) {
				AvailabilityThreadDao charterDao = (AvailabilityThreadDao) availabilityDaoFactory
						.createAvailabilityThreadDao();
				// Copy the context information to the Threads
				charterDao
						.setApplicationContext(this
								.getApplicationContextFactory()
								.getApplicationContext());
				FlightsRequest charterRequest = (FlightsRequest) packagesRequest
						.getFlightsRequest().clone();
				charterRequest.setFlightRequestType(FlightRequestType.CHARTER);
				// If User already selected a hotel, then set the flexible
				// indicator to false
				if (availablePackage.getSelectedHotel() != null) {
					charterRequest.setFlexiDateIndicator(false);
				}
				// Set the flight request for charter dao
				charterDao.setAbeRequest(charterRequest);
				// Call the Charter Dao
				charterFuture = taskExecutor.submit(charterDao);

			}
			if (!packagesRequest.getFlightsRequest().isSkedOnly()
					&& isValidCharterPair) {
				// Wait for Charter response
				FlightsResponse charterResponse = (FlightsResponse) charterFuture
						.get();
				toReturnPackagesResponse.processResponse(charterResponse);
				// Process the charter response
				packagesRequest.setFlightsList(charterResponse.getFlightList());
			}
			if (!packagesRequest.getFlightsRequest().isCharterOnly()) {
				// Wait for SKED response
				FlightsResponse skedResponse = (FlightsResponse) skedFuture
						.get();
				toReturnPackagesResponse.processResponse(skedResponse);
				// Process the SKED response
				packagesRequest.setSapOrigDestOptionsList(skedResponse
						.getSapOrigDestOptionsList());
				packagesRequest.setSapSegmentsList(skedResponse
						.getSapSegmentsList());
		/*Code commented for revocation of 3620608 on 04/05/2013*/				
			/*	//Added segment set in PackageRequest for #3620608
				packagesRequest.setSapAddedSegmentsList(skedResponse
						.getSapAddedSegmentsList());*/
			}
			if (packagesRequest.getFlightsList() == null
					&& (packagesRequest.getSapOrigDestOptionsList() == null
							|| packagesRequest.getSapOrigDestOptionsList()
									.isEmpty()
							|| packagesRequest.getSapSegmentsList() == null || packagesRequest
							.getSapSegmentsList().isEmpty())) {
				ABEBusinessError error = new ABEBusinessError(
						"UNABLE_TO_RETRIEVE_FLIGHTS", this.getMessageSource()
								.getMessage("UNABLE_TO_RETRIEVE_FLIGHTS", null,
										null));
				toReturnPackagesResponse.saveBusinessError(error);
				return toReturnPackagesResponse;
			}

			Hotel selectedHotels = packagesRequest.getAvailablePackage().getSelectedHotel();
			if(this.hbsiHotelDao.isHBSiHotelVendorCode(packagesRequest.getAvailablePackage().getSelectedHotel().getHotelCode())) {
				packagesRequest.getAvailablePackage().setSelectedHotel(null);
			}
			
			// Call for packages
			
			PackagesResponse packagesResponse = packagesDAO.changeFlights(packagesRequest);
			packagesResponse.getAvailablePackage().setSelectedHotel(selectedHotels);
			if (packagesResponse.getAvailablePackage().getFlightOptions() != null
					&& packagesRequest.getFlightsRequest() != null) {
				packagesResponse.getAvailablePackage().setFlightOptions(
						FlightUtils.sortFlights(packagesResponse
								.getAvailablePackage().getFlightOptions(),
								packagesRequest.getFlightsRequest(), true));
				
				//IGT-A--Issue # 3620601---START
				//This code here generating tripFlight groups, the code shifted from flex to java
				List <GroupedTripFlight>arrFlightsFilterted = new ArrayList<GroupedTripFlight>();
				List <TripFlight>tempArrFlightsFilterted = new ArrayList<TripFlight>();
				for(TripFlight tf: packagesResponse.getAvailablePackage().getFlightOptions())
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
				for (TripFlight tfMain : packagesResponse.getAvailablePackage().getFlightOptions()){
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
						for (TripFlight tfMainInner : packagesResponse.getAvailablePackage().getFlightOptions())
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
				//Send Only ABE change booking packages for pricing
				//&& packagesRequest.getBookingNo()!=null && !"".equals(packagesRequest.getBookingNo())
				String contextID = this.getApplicationContextFactory().getApplicationContext().getRequestContext().getIMApplicationInfo().getContextID();
				if(contextID!=null && !"".equals(contextID) && "ABE".equalsIgnoreCase(contextID))
				{
					arrFlightsFilterted = pricingThreadService.createItineraryForPricingOnFirstInstance(arrFlightsFilterted, packagesResponse, packagesRequest);
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
				/*------ coding ends for 3535943--- Sagar-----*/
				
				
				//Remove Flights whose 
				
				
				//IGT-A--END
				packagesResponse.getAvailablePackage().setGroupedTripFlight(arrFlightsFilterted);
				//IGT-A---Issue # 3620601---Here we are maintaining List which will be used directly at the front end.---START 
				for (GroupedTripFlight grpdTripFlight : arrFlightsFilterted)
				{
					for (TripFlight tFlight : grpdTripFlight.getTripFlights())
					{
						if(tFlight.isFlightSelectedForDisplay())
							tempArrFlightsFilterted.add(tFlight);
					}
				}
				packagesResponse.getAvailablePackage().setDisplayTripFlightList(tempArrFlightsFilterted);
				//IGT-A--Issue # 3620601---END
			}
			toReturnPackagesResponse.processResponse(packagesResponse);
			toReturnPackagesResponse.setAvailablePackage(packagesResponse
					.getAvailablePackage());
		} catch (RejectedExecutionException rx) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_EXECUTE_THE_PACKAGES_REQUEST", this
							.getMessageSource().getMessage(
									"UNABLE_TO_EXECUTE_THE_PACKAGES_REQUEST",
									null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, rx);
		} catch (Exception ex) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_RETRIEVE_PACKAGES_AVAILABILITY", this
							.getMessageSource().getMessage(
									"UNABLE_TO_RETRIEVE_PACKAGES_AVAILABILITY",
									null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, ex);
		}
		return toReturnPackagesResponse;
	}

	/**
	 * Set apple specials savers flag
	 * 
	 * @param packagesResponse
	 * @param packagesRequest
	 */

	private void setAppleSpecialsSavers(
			final PackagesResponse packagesResponse,
			final PackagesRequest packagesRequest) {

		final SpecialsSearchCriteria specialsSearchCriteria = SpecialUtils
				.convertSpecialsSearchCriteria(packagesRequest, null, "LM");
		SpecialsCacheResponse cacheResponse = specialsCacheDao
				.retrieveSpecialsFromGrid(specialsSearchCriteria);
		Specials specials = cacheResponse.getRetrievedSpecialsList();
		if ((null != specials) && (null != specials.getSpecial())
				&& !specials.getSpecial().isEmpty()) {
			List<Special> listSpecils = specials.getSpecial();
			final List<Hotel> hotels = packagesResponse.getHotelList();
			for (final Hotel hotel : hotels) {
				Integer hotelCode = Integer.valueOf(hotel.getHotelCode());
				for (Special special : listSpecils) {
					Integer specilalHotelCode = Integer.valueOf(special
							.getHotelCode());
					if (hotelCode.equals(specilalHotelCode)) {
						hotel.setAppleSpecialsAndSavers(true);
					}
				}
			}
		}
	}

	private boolean isReviseRoomCategory(PackagesResponse packageResponse)
	{
		Package availablePackage = packageResponse.getAvailablePackage();
		Hotel hotel = availablePackage.getSelectedHotel();
		if(hotel!=null && hotel.getHotelCode()!=null && hotel.getHotelCode()!="" && this.hbsiHotelDao.isHBSiHotelVendorCode(hotel.getHotelCode()))
		{
			return true;
			/*Map<String,HBSiHotelInfo> hbsiHotelVendorCode = this.hbsiHotelDao.getHotelVendors();
			HBSiHotelInfo hbsiHotelInfo = hbsiHotelVendorCode.get(hotel.getHotelCode());*/
			
		}
		
		return false;
	}
	
	/**
	 * Description: Revise Room Category
	 * @param packagesRequest
	 * @param packagesResponse
	 * @return
	 */
	private PackagesResponse reviseRoomCategory(PackagesRequest packagesRequest,PackagesResponse packagesResponse)
	{
		boolean isHBSI=false;
		if(packagesResponse==null)
		{
			packagesResponse = new PackagesResponse();
			packagesResponse.setAvailablePackage(packagesRequest.getAvailablePackage());
		}
		Map<String, HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao
				.getHBSiDBData();
		packagesRequest.getHotelsRequest().getHotelOptions().setRatePlanCode(null);
		PackagesResponse wesbPackagesResponse = wesbPackagesDAO
				.wesbRetrievePackages(packagesRequest,
						hbsiHotelList);
		
		if ((wesbPackagesResponse.getHotelList() != null)
				&& (wesbPackagesResponse.getHotelList().size() > 0) && packagesResponse
				.getAvailablePackage()!=null &&packagesResponse
				 .getAvailablePackage().getSelectedFlight()!=null) {

			List<Hotel> hotelList = new ArrayList<Hotel>();
			List<RoomCategory> hbsiRoomCategoryList = new ArrayList<RoomCategory>();
			for (int i = 0; i < wesbPackagesResponse.getHotelList()
					.size(); i++) {
				Hotel hbsiHotel = wesbPackagesResponse
						.getHotelList().get(i);
			/*	hbsiHotel
						.getDisplayRoomCategory()
						.getDisplayRoomPrice()
						.setPackagePrice(
								hbsiHotel.getDisplayRoomCategory()
										.getDisplayRoomPrice()
										.getTotalAmount()
										+ packagesResponse
												.getAvailablePackage()
												.getSelectedFlight().getPrice()
												.getOccpancyBasedPrice());*/
				
				isHBSI=this.hbsiHotelDao.isHBSiHotel(hbsiHotel.getDisplayRoomCategory().getHotelId()+"");
				if(isHBSI){
					hbsiHotel.setHBSI(isHBSI);
				}
				//Calculating package price for all the room categories 
				double totalPrice=0.0;
				if(hbsiHotel.getRoomCategories()!=null && hbsiHotel.getRoomCategories().size()>0)
				{
					for(int k=0;k<hbsiHotel.getRoomCategories().size();k++)
					{
						RoomCategory roomCat = hbsiHotel.getRoomCategories().get(k);
						if(roomCat!=null && roomCat.getRoomPrices()!=null && roomCat.getRoomPrices().size()>0 )
						{
							for(int roomPrice=0;roomPrice<roomCat.getRoomPrices().size();roomPrice++ )
							{/*
									roomCat.getRoomPrices()
											.get(roomPrice)
											.setPackagePrice(
													roomCat.getRoomPrices()
															.get(roomPrice)
															.getTotalAmount()
															+ packagesResponse
																	.getAvailablePackage().
																	getSelectedFlight()
																	.getPrice()
																	.getOccpancyBasedPrice());
									//Calculate total price
									if(k==0 && packagesResponse
											.getAvailablePackage().getSelectedFlight()!=null)
									{
										totalPrice=totalPrice+roomCat.getRoomPrices()
										.get(roomPrice)
										.getTotalAmount()
										+ packagesResponse
												.getAvailablePackage()
												.getPrice()
												.getOccpancyBasedPrice();
									}*/
									
									
									double adultPrice=0.0;
									double childPrice=0.0;
									double lapChildPrice=0.0;
									double infantPrice=0.0;
									double seniorMemberPrice=0.0;
									double juniorPrice=0.0;
									double minorPrice=0.0;
									double packagePricePerRoom=0.0;
									double totalTaxPerRoom=0.0;
									int noOfAdults=0;
									int noOfChilds=0;
									int noOfInfants=0;
									int noOflapChilds=0;
									int noOfSeniorMember=0;
									int noOfJuniors=0;
									int noOfMinors=0;
									int occupancyPerRoom=1;
									
									
									
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfAdults()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfAdults()!=""){
										noOfAdults = Integer.parseInt(roomCat.getRoomPrices().get(roomPrice).getPaxBasePrices().getNoOfAdults());
										if(packagesResponse.getAvailablePackage().getPrice()!=null)
										adultPrice=noOfAdults*packagesResponse.getAvailablePackage().getPrice().getPerAdultBasePrice();
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfChilds()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfChilds()!=""){
										noOfChilds = Integer.parseInt(roomCat.getRoomPrices().get(roomPrice).getPaxBasePrices().getNoOfChilds());
										if(packagesResponse.getAvailablePackage().getPrice()!=null)
										childPrice=(packagesResponse.getAvailablePackage().getPrice().getPerAdultBasePrice())*noOfChilds;
										
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfInfants()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfInfants()!="")
									{
										noOfInfants = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfInfants());
										if(packagesResponse.getAvailablePackage().getPrice()!=null)
										infantPrice=(packagesResponse.getAvailablePackage().getPrice().getPerAdultBasePrice())*noOfInfants;
										
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfJuniors()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfJuniors()!="")
									{
										noOfJuniors = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfJuniors());
										
										if(packagesResponse.getAvailablePackage().getPrice()!=null)
										juniorPrice=(packagesResponse
												.getAvailablePackage()
												.getPrice().getPerAdultBasePrice())*noOfJuniors;
										
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfLapChilds()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfLapChilds()!="")
									{
										noOflapChilds = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfLapChilds());
										
										if(packagesResponse.getAvailablePackage().getPrice()!=null)
										lapChildPrice=(packagesResponse
												.getAvailablePackage()
												.getPrice().getPerAdultBasePrice())*noOflapChilds;
										
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfSeniors()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfSeniors()!="")
									{
										noOfSeniorMember = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfSeniors());
										
										if(packagesResponse.getAvailablePackage().getPrice()!=null)
										seniorMemberPrice=(packagesResponse
												.getAvailablePackage()
												.getPrice().getPerAdultBasePrice())*noOfSeniorMember;
										
									}
									
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfMinors()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfMinors()!="")
									{
										noOfMinors = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfMinors());
										
										if(packagesResponse.getAvailablePackage().getPrice()!=null)
										minorPrice=(packagesResponse
												.getAvailablePackage()
												.getPrice().getPerAdultBasePrice())*noOfMinors;
										
									}
									
									occupancyPerRoom=noOfAdults+noOfChilds+noOfInfants+noOfJuniors+noOflapChilds+noOfMinors+noOfSeniorMember;
									int totalOccupancy=hbsiHotel.getOccupancy().getNoOfAdults()+hbsiHotel.getOccupancy().getNoOfChilds()+
									hbsiHotel.getOccupancy().getNoOfInfants()+hbsiHotel.getOccupancy().getNoOfLapChilds()+
									hbsiHotel.getOccupancy().getNoOfSeniors();
									
									double taxPerOccupant=0;
									if(packagesResponse.getAvailablePackage().getPrice()!=null)
										taxPerOccupant=(packagesResponse.getAvailablePackage().getPrice().getTotalTax())/totalOccupancy;
									totalTaxPerRoom=occupancyPerRoom*taxPerOccupant;
									packagePricePerRoom=(adultPrice+childPrice+infantPrice+lapChildPrice+seniorMemberPrice+minorPrice+juniorPrice)+
									(totalTaxPerRoom);
									
									
									
											//Commenting code for time being
											/*roomCat.getRoomPrices()
													.get(roomPrice)
													.setPackagePrice(
															roomCat.getRoomPrices()
																	.get(roomPrice)
																	.getTotalAmount()
																	+ packagesResponse
																			.getFlightsList()
																			.get(0)
																			.getPrice()
																			.getOccpancyBasedPrice());*/
											
											
											roomCat.getRoomPrices()
											.get(roomPrice)
											.setPackagePrice(roomCat.getRoomPrices()
													.get(roomPrice)
													.getTotalAmount()+
													packagePricePerRoom);
											
											
											//Calculate Total Amount to display on UI
											//commenting for time being
									/*		if(k==0)
											{
												totalPrice=totalPrice+roomCat.getRoomPrices()
												.get(roomPrice)
												.getTotalAmount()
												+ packagesResponse
														.getFlightsList()
														.get(0)
														.getPrice()
														.getOccpancyBasedPrice();
											}*/
											
											if(k==0)
											{
												totalPrice=totalPrice+roomCat.getRoomPrices()
												.get(roomPrice).getPackagePrice();
												
											}
									
									
							}
						}
						hbsiHotel.getRoomCategories().remove(k);
						hbsiHotel.getRoomCategories().add(k, roomCat);
						
					}
				
				}
				hbsiHotel
				.getDisplayRoomCategory()
				.getDisplayRoomPrice()
				.setPackagePrice(
						totalPrice);
				hotelList.add(hbsiHotel);
			}

			packagesResponse.getAvailablePackage().setHotelOptions(
					hotelList);
			Collections.sort(packagesResponse.getAvailablePackage().getHotelOptions(),new HotelRatingComparator());
		}

return packagesResponse;
	
	}
	
	
	/**
	 * Description: fetch the Hotels when user clicks on show alternative flights
	 * @param packagesRequest
	 * @param packagesResponse
	 * @return
	 */
	private PackagesResponse showAlternativeFlightsandHotels(PackagesRequest packagesRequest,PackagesResponse packagesResponse)
	{


		Map<String, HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao.getHBSiDBData();		
		if(packagesRequest!=null&& packagesRequest.getHotelsRequest()!=null && packagesRequest.getHotelsRequest().getHotelOptions()!=null){
			packagesRequest.getHotelsRequest().getHotelOptions().setRatePlanCode(null);
		}
		PackagesResponse wesbPackagesResponse = wesbPackagesDAO.wesbRetrievePackages(packagesRequest,hbsiHotelList);
		// check for HBSI Hotel 
		if(wesbPackagesResponse.getHotelList() !=null && wesbPackagesResponse.getHotelList().size() >0){
			for(Hotel hotel : wesbPackagesResponse.getHotelList()){
				hotel.setHBSI(hbsiHotelDao.isHBSiHotel(hotel.getDisplayRoomCategory().getHotelId()+""));
				}
			}
		
		/*if ((wesbPackagesResponse.getHotelList() != null)
				&& (wesbPackagesResponse.getHotelList().size() > 0) && packagesResponse
				.getAvailablePackage()!=null &&packagesResponse
				.getAvailablePackage().getFlightOptions()!=null &&packagesResponse
				.getAvailablePackage().getFlightOptions().size()>0)*/
		
			if ((wesbPackagesResponse.getHotelList() != null)
					&& (wesbPackagesResponse.getHotelList().size() > 0) && packagesResponse
					.getAvailablePackage()!=null &&((packagesResponse
					.getAvailablePackage().getFlightOptions()!=null &&packagesResponse
					.getAvailablePackage().getFlightOptions().size()>0)||packagesResponse.getAvailablePackage().getSelectedFlight()!=null )){

			List<Hotel> hotelList = new ArrayList<Hotel>();
			List<RoomCategory> hbsiRoomCategoryList = new ArrayList<RoomCategory>();
			for (int i = 0; i < wesbPackagesResponse.getHotelList()
					.size(); i++) {
				Hotel hbsiHotel = wesbPackagesResponse
						.getHotelList().get(i);
			/*	hbsiHotel
						.getDisplayRoomCategory()
						.getDisplayRoomPrice()
						.setPackagePrice(
								hbsiHotel.getDisplayRoomCategory()
										.getDisplayRoomPrice()
										.getTotalAmount()
										+ packagesResponse
												.getAvailablePackage()
												.getFlightOptions().get(0).getPrice()
												.getOccpancyBasedPrice());*/
				
				//Calculating package price for all the room categories 
				double totalPrice=0.0;
				if(hbsiHotel.getRoomCategories()!=null && hbsiHotel.getRoomCategories().size()>0)
				{
					for(int k=0;k<hbsiHotel.getRoomCategories().size();k++)
					{
						RoomCategory roomCat = hbsiHotel.getRoomCategories().get(k);
						if(roomCat!=null && roomCat.getRoomPrices()!=null && roomCat.getRoomPrices().size()>0 )
						{
							for(int roomPrice=0;roomPrice<roomCat.getRoomPrices().size();roomPrice++ )
							{
								if(packagesResponse
									.getAvailablePackage()
									.getFlightOptions()!=null && packagesResponse
									.getAvailablePackage()
									.getFlightOptions().size()>0 && packagesResponse
									.getAvailablePackage().getSelectedFlight() == null)
							{
/*									roomCat.getRoomPrices()
											.get(roomPrice)
											.setPackagePrice(
													roomCat.getRoomPrices()
															.get(roomPrice)
															.getTotalAmount()
															+ packagesResponse
																	.getAvailablePackage()
																	.getFlightOptions().get(0)
																	.getPrice()
																	.getOccpancyBasedPrice());
*/							
									double adultPrice=0.0;
									double childPrice=0.0;
									double lapChildPrice=0.0;
									double infantPrice=0.0;
									double seniorMemberPrice=0.0;
									double juniorPrice=0.0;
									double minorPrice=0.0;
									double packagePricePerRoom=0.0;
									double totalTaxPerRoom=0.0;
									int noOfAdults=0;
									int noOfChilds=0;
									int noOfInfants=0;
									int noOflapChilds=0;
									int noOfSeniorMember=0;
									int noOfJuniors=0;
									int noOfMinors=0;
									int occupancyPerRoom=1;
									
									
									
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfAdults()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfAdults()!="")
									{
										noOfAdults = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfAdults());
										
										adultPrice=noOfAdults*packagesResponse.getAvailablePackage()
										.getFlightOptions()
										.get(0)
										.getPrice().getPerAdultBasePrice();
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfChilds()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfChilds()!="")
									{
										noOfChilds = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfChilds());
										
										childPrice=(packagesResponse.getAvailablePackage()
										.getFlightOptions()
										.get(0)
										.getPrice().getPerAdultBasePrice())*noOfChilds;
										
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfInfants()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfInfants()!="")
									{
										noOfInfants = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfInfants());
										
										infantPrice=(packagesResponse.getAvailablePackage()
										.getFlightOptions()
										.get(0)
										.getPrice().getPerAdultBasePrice())*noOfInfants;
										
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfJuniors()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfJuniors()!="")
									{
										noOfJuniors = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfJuniors());
										
										juniorPrice=(packagesResponse.getAvailablePackage()
										.getFlightOptions()
										.get(0)
										.getPrice().getPerAdultBasePrice())*noOfJuniors;
										
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfLapChilds()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfLapChilds()!="")
									{
										noOflapChilds = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfLapChilds());
										
										lapChildPrice=(packagesResponse.getAvailablePackage()
										.getFlightOptions()
										.get(0)
										.getPrice().getPerAdultBasePrice())*noOflapChilds;
										
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfSeniors()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfSeniors()!="")
									{
										noOfSeniorMember = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfSeniors());
										
										seniorMemberPrice=(packagesResponse.getAvailablePackage()
										.getFlightOptions()
										.get(0)
										.getPrice().getPerAdultBasePrice())*noOfSeniorMember;
										
									}
									
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfMinors()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfMinors()!="")
									{
										noOfMinors = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfMinors());
										
										minorPrice=(packagesResponse.getAvailablePackage()
										.getFlightOptions()
										.get(0)
										.getPrice().getPerAdultBasePrice())*noOfMinors;
										
									}
									
									occupancyPerRoom=noOfAdults+noOfChilds+noOfInfants+noOfJuniors+noOflapChilds+noOfMinors+noOfSeniorMember;
									int totalOccupancy=hbsiHotel.getOccupancy().getNoOfAdults()+hbsiHotel.getOccupancy().getNoOfChilds()+
									hbsiHotel.getOccupancy().getNoOfInfants()+hbsiHotel.getOccupancy().getNoOfLapChilds()+
									hbsiHotel.getOccupancy().getNoOfSeniors();
									double taxPerOccupant=(packagesResponse.getAvailablePackage()
									.getFlightOptions()
									.get(0)
									.getPrice().getTotalTax())/totalOccupancy;
									totalTaxPerRoom=occupancyPerRoom*taxPerOccupant;
									packagePricePerRoom=(adultPrice+childPrice+infantPrice+lapChildPrice+seniorMemberPrice+minorPrice+juniorPrice)+
									(totalTaxPerRoom);
									
											
											roomCat.getRoomPrices()
											.get(roomPrice)
											.setPackagePrice(roomCat.getRoomPrices()
													.get(roomPrice)
													.getTotalAmount()+
													packagePricePerRoom);
											
											if(k==0)
											{
												totalPrice=totalPrice+roomCat.getRoomPrices()
												.get(roomPrice).getPackagePrice();
												
											}

									
							}
								else if(packagesResponse
										.getAvailablePackage().getSelectedFlight()!=null)
								{
									/*roomCat.getRoomPrices()
									.get(roomPrice)
									.setPackagePrice(
											roomCat.getRoomPrices()
													.get(roomPrice)
													.getTotalAmount()
													+ packagesResponse
															.getAvailablePackage()
															.getSelectedFlight()
															.getPrice()
															.getOccpancyBasedPrice());*/
									
									double adultPrice=0.0;
									double childPrice=0.0;
									double lapChildPrice=0.0;
									double infantPrice=0.0;
									double seniorMemberPrice=0.0;
									double juniorPrice=0.0;
									double minorPrice=0.0;
									double packagePricePerRoom=0.0;
									double totalTaxPerRoom=0.0;
									int noOfAdults=0;
									int noOfChilds=0;
									int noOfInfants=0;
									int noOflapChilds=0;
									int noOfSeniorMember=0;
									int noOfJuniors=0;
									int noOfMinors=0;
									int occupancyPerRoom=1;
									
									
									
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfAdults()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfAdults()!="")
									{
										noOfAdults = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfAdults());
										
										adultPrice=noOfAdults*packagesResponse
										.getAvailablePackage().getSelectedFlight()
										.getPrice().getPerAdultBasePrice();
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfChilds()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfChilds()!="")
									{
										noOfChilds = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfChilds());
										
										childPrice=(packagesResponse
												.getAvailablePackage().getSelectedFlight()
												.getPrice().getPerAdultBasePrice())*noOfChilds;
										
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfInfants()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfInfants()!="")
									{
										noOfInfants = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfInfants());
										
										infantPrice=(packagesResponse
												.getAvailablePackage().getSelectedFlight()
												.getPrice().getPerAdultBasePrice())*noOfInfants;
										
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfJuniors()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfJuniors()!="")
									{
										noOfJuniors = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfJuniors());
										
										juniorPrice=(packagesResponse
												.getAvailablePackage().getSelectedFlight()
												.getPrice().getPerAdultBasePrice())*noOfJuniors;
										
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfLapChilds()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfLapChilds()!="")
									{
										noOflapChilds = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfLapChilds());
										
										lapChildPrice=(packagesResponse
												.getAvailablePackage().getSelectedFlight()
												.getPrice().getPerAdultBasePrice())*noOflapChilds;
										
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfSeniors()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfSeniors()!="")
									{
										noOfSeniorMember = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfSeniors());
										
										seniorMemberPrice=(packagesResponse
												.getAvailablePackage().getSelectedFlight()
												.getPrice().getPerAdultBasePrice())*noOfSeniorMember;
										
									}
									
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfMinors()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfMinors()!="")
									{
										noOfMinors = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfMinors());
										
										minorPrice=(packagesResponse
												.getAvailablePackage().getSelectedFlight()
												.getPrice().getPerAdultBasePrice())*noOfMinors;
										
									}
									
									occupancyPerRoom=noOfAdults+noOfChilds+noOfInfants+noOfJuniors+noOflapChilds+noOfMinors+noOfSeniorMember;
									int totalOccupancy=hbsiHotel.getOccupancy().getNoOfAdults()+hbsiHotel.getOccupancy().getNoOfChilds()+
									hbsiHotel.getOccupancy().getNoOfInfants()+hbsiHotel.getOccupancy().getNoOfLapChilds()+
									hbsiHotel.getOccupancy().getNoOfSeniors();
									double taxPerOccupant=(packagesResponse
											.getAvailablePackage().getSelectedFlight()
											.getPrice().getTotalTax())/totalOccupancy;
									totalTaxPerRoom=occupancyPerRoom*taxPerOccupant;
									packagePricePerRoom=(adultPrice+childPrice+infantPrice+lapChildPrice+seniorMemberPrice+minorPrice+juniorPrice)+
									(totalTaxPerRoom);
									
									
									
											//Commenting code for time being
											/*roomCat.getRoomPrices()
													.get(roomPrice)
													.setPackagePrice(
															roomCat.getRoomPrices()
																	.get(roomPrice)
																	.getTotalAmount()
																	+ packagesResponse
																			.getFlightsList()
																			.get(0)
																			.getPrice()
																			.getOccpancyBasedPrice());*/
											
											
											roomCat.getRoomPrices()
											.get(roomPrice)
											.setPackagePrice(roomCat.getRoomPrices()
													.get(roomPrice)
													.getTotalAmount()+
													packagePricePerRoom);
											
											
											//Calculate Total Amount to display on UI
											//commenting for time being
									/*		if(k==0)
											{
												totalPrice=totalPrice+roomCat.getRoomPrices()
												.get(roomPrice)
												.getTotalAmount()
												+ packagesResponse
														.getFlightsList()
														.get(0)
														.getPrice()
														.getOccpancyBasedPrice();
											}*/
											
											if(k==0)
											{
												totalPrice=totalPrice+roomCat.getRoomPrices()
												.get(roomPrice).getPackagePrice();
												
											}
									
					
									
									
								}
									
/*									if(k==0 && packagesResponse
											.getAvailablePackage()
											.getFlightOptions()!=null && packagesResponse
											.getAvailablePackage()
											.getFlightOptions().size()>0)
									{
										totalPrice=totalPrice+roomCat.getRoomPrices()
										.get(roomPrice)
										.getTotalAmount()
										+ packagesResponse.getAvailablePackage()
												.getFlightOptions()
												.get(0)
												.getPrice()
												.getOccpancyBasedPrice();
									}
*/						/*			else if(k==0 && packagesResponse
											.getAvailablePackage().getSelectedFlight()!=null)
									{
										totalPrice=totalPrice+roomCat.getRoomPrices()
										.get(roomPrice)
										.getTotalAmount()
										+ packagesResponse
												.getAvailablePackage()
												.getPrice()
												.getOccpancyBasedPrice();
									}*/
							}
						}
						hbsiHotel.getRoomCategories().remove(k);
						hbsiHotel.getRoomCategories().add(k, roomCat);
						
					}
					
					
				}
				hbsiHotel
				.getDisplayRoomCategory()
				.getDisplayRoomPrice()
				.setPackagePrice(
						totalPrice);
				hotelList.add(hbsiHotel);
			}

			packagesResponse.getAvailablePackage().getHotelOptions().addAll(
					hotelList);
			Collections.sort(packagesResponse.getAvailablePackage().getHotelOptions(),new HotelRatingComparator());
		}

return packagesResponse;
	
	}
	
	
	
	/**
	 * Method to retrieve the hotels for packages
	 * 
	 * @param searchCriteria
	 *            - searchCriteria for packages
	 * @return PackagesResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public PackagesResponse changeHotels(SearchCriteria searchCriteria,
			Package availablePackage) {
		// Retrieve the request objects
		PackagesRequest packagesRequest = searchCriteria.getPackagesRequest();
		PackagesResponse packagesResponse = null;
		packagesRequest.setAvailablePackage(availablePackage);

		try {

			if(packagesRequest!=null && packagesRequest.getHotelsRequest()!=null && 
					packagesRequest.getHotelsRequest().getHotelOptions()!=null &&
					packagesRequest.getHotelsRequest().getHotelOptions().getHotelCode()!=null &&
					this.hbsiHotelDao.isHBSiHotelVendorCode(packagesRequest.getHotelsRequest().getHotelOptions().getHotelCode())){
				Map<String,HBSiHotelInfo> hbsiHotelVendorCode = this.hbsiHotelDao.getHotelVendors();
				HBSiHotelInfo hbsiHotelDetails = hbsiHotelVendorCode.get(packagesRequest.getHotelsRequest().getHotelOptions().getHotelCode());
				packagesRequest.getHotelsRequest().getHotelOptions().setHotelCode(hbsiHotelDetails.getHotelId());
			}					
			
			if(packagesRequest!=null && packagesRequest.getHotelsRequest()!=null &&
					packagesRequest.getHotelsRequest().getHotelOptions()!=null &&
					(packagesRequest.getHotelsRequest().getHotelOptions().getHotelCode()==null ||packagesRequest.getHotelsRequest().getHotelOptions().getHotelCode().equals(""))){
				packagesResponse = packagesDAO.changeHotels(packagesRequest);
			}
			if(packagesRequest!=null && packagesRequest.getHotelsRequest()!=null &&
					packagesRequest.getHotelsRequest().getHotelOptions()!=null &&
					packagesRequest.getHotelsRequest().getHotelOptions().getHotelCode()!=null && !packagesRequest.getHotelsRequest().getHotelOptions().getHotelCode().equals("")
						&& !this.hbsiHotelDao.isHBSiHotel(packagesRequest.getHotelsRequest().getHotelOptions().getHotelCode())){
				packagesResponse = packagesDAO.changeHotels(packagesRequest);
			}
			

			/*********** WESB CODE BEGINS ************/
			
			
			if (packagesResponse!=null && packagesResponse.getBusinessErrors() == null && 
					packagesRequest!=null && 
					packagesRequest.getHotelsRequest()!=null &&packagesRequest.getHotelsRequest().getHotelOptions()!=null &&
					(packagesRequest.getHotelsRequest().getHotelOptions().getHotelCode()==null ||packagesRequest.getHotelsRequest().getHotelOptions().getHotelCode().equals(""))){
				List<String> destinationList = this.hbsiHotelDao.getHotelDestinations();
					if (packagesRequest.isHotelRequested()
							&& (packagesRequest.getHotelsRequest() != null)
							&& packagesRequest.getHotelsRequest().getDestination() != null
							&& !packagesRequest.getHotelsRequest().getDestination().equals("")
							&& destinationList != null
							&& destinationList.contains(packagesRequest.getHotelsRequest().getDestination())){
						packagesResponse = showAlternativeFlightsandHotels(packagesRequest, packagesResponse);
				}
			}
			
			if(packagesRequest!=null && packagesRequest.getHotelsRequest()!=null &&
					packagesRequest.getHotelsRequest().getHotelOptions()!=null &&
					packagesRequest.getHotelsRequest().getHotelOptions().getHotelCode()!=null && 
					!packagesRequest.getHotelsRequest().getHotelOptions().getHotelCode().equals("")
					&& this.hbsiHotelDao.isHBSiHotel(packagesRequest.getHotelsRequest().getHotelOptions().getHotelCode())){
				
				List<String> destinationList = this.hbsiHotelDao.getHotelDestinations();
				if (packagesRequest.isHotelRequested()
						&& (packagesRequest.getHotelsRequest() != null)
						&& packagesRequest.getHotelsRequest().getDestination() != null
						&& !packagesRequest.getHotelsRequest().getDestination().equals("")
						&& destinationList != null
						&& destinationList.contains(packagesRequest.getHotelsRequest().getDestination())){
					packagesResponse = reviseRoomCategory(packagesRequest, packagesResponse);
			}
			}
			/*********** WESB CODE ENDS ************/

		} catch (RejectedExecutionException rx) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_EXECUTE_THE_PACKAGES_REQUEST", this
							.getMessageSource().getMessage(
									"UNABLE_TO_EXECUTE_THE_PACKAGES_REQUEST",
									null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, rx);
		} catch (Exception ex) {			
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_RETRIEVE_PACKAGES_AVAILABILITY", this
							.getMessageSource().getMessage(
									"UNABLE_TO_RETRIEVE_PACKAGES_AVAILABILITY",
									null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, ex);
		}
		return packagesResponse;
	}

	/**
	 * Method to retrieve the vehicles for packages
	 * 
	 * @param request
	 *            - request for packages
	 * @return PackagesResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public PackagesResponse changeVehicles(SearchCriteria searchCriteria,
			Package availablePackage) {
		// Retrieve the request objects
		PackagesRequest packagesRequest = searchCriteria.getPackagesRequest();
		PackagesResponse packagesResponse = null;
		packagesRequest.setAvailablePackage(availablePackage);

		try {
			// Call for packages
			packagesResponse = packagesDAO.changeVehicles(packagesRequest);
		} catch (RejectedExecutionException rx) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_EXECUTE_THE_PACKAGES_REQUEST", this
							.getMessageSource().getMessage(
									"UNABLE_TO_EXECUTE_THE_PACKAGES_REQUEST",
									null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, rx);
		} catch (Exception ex) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_RETRIEVE_PACKAGES_AVAILABILITY", this
							.getMessageSource().getMessage(
									"UNABLE_TO_RETRIEVE_PACKAGES_AVAILABILITY",
									null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, ex);
		}
		return packagesResponse;
	}

	/**
	 * Method to retrieve the packages
	 * 
	 * @param request
	 *            - request for packages
	 * @return PackagesResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public PackagesResponse retrievePackages(SearchCriteria searchCriteria) {

		// Retrieve the request objects
		PackagesRequest packagesRequest = searchCriteria.getPackagesRequest();
		PackagesResponse toReturnPackagesResponse = new PackagesResponse();
		//Variable added for 3620543.
		boolean ischarterGateway  = false;

		try {
			if (packagesRequest.getFlightsRequest() != null) {
				/**
				 * Should cover Air + Hotel, Air + Hotel + Car and Air + Car
				 * scenarios. In Air + Hotel and Air + Hotel + Car scenarios, we
				 * will not be calling hotel thread. Hotels will be picked
				 * during the consolidations BAPI.
				 */
				/**--- 3620543 Coding Start---**/
				if (packagesRequest
						.getFlightsRequest().getGateway() != null
						&& !"".equals(packagesRequest
								.getFlightsRequest().getGateway().trim())){
					CharterGatewayDestinationResponse chrtrGatewayResponse = charterGatewayDestinationsDao.retrieveCharterGatewayDestinations();
					ischarterGateway = FlightUtils.isGatewayCharter(chrtrGatewayResponse.getGatewayList(),searchCriteria.getGateway());
				}
				/**--- 3620543 Coding End---**/
				Future<ABEResponse> vehicleFuture = null;
				// Check if Vehicle is requested.
				if (packagesRequest.getVehiclesRequest() != null) {
					/*
					 * Should be either Air + Car or Air + Hotel + Car scenarios
					 */
					AvailabilityThreadDao vehicleDao = (AvailabilityThreadDao) availabilityDaoFactory
							.createAvailabilityThreadDao();
					// Copy the context information to the Threads
					vehicleDao.setApplicationContext(this
							.getApplicationContextFactory()
							.getApplicationContext());
					vehicleDao.setAbeRequest(packagesRequest
							.getVehiclesRequest());

					// Call the Vehicle Dao
					vehicleFuture = taskExecutor.submit(vehicleDao);
				}
				boolean isValidCharterPair = gatewayDestinationsDao
						.isCharterOfferedGatewayDestination(packagesRequest
								.getFlightsRequest().getGateway(),
								packagesRequest.getFlightsRequest()
										.getDestination());
				Future<ABEResponse> charterFuture = null;
				boolean skedCallRequired = true;
				//This will identify when to retrieve availability of 6-night charter flights in sap
				FlightsRequest flightRequest = packagesRequest.getFlightsRequest();
				flightRequest.setCheckCharterOfferFlight(searchCriteria.isCheckCharterOfferFlight());
				//if no 6-night charter flight offer then continue retrieving original search criteria
				boolean hasCharterOffer = checkFlightOffer(toReturnPackagesResponse, flightRequest);
				if (hasCharterOffer)
					return toReturnPackagesResponse;
				
				if (!packagesRequest.getFlightsRequest().isSkedOnly()
						&& isValidCharterPair) {
					AvailabilityThreadDao charterDao = (AvailabilityThreadDao) availabilityDaoFactory
							.createAvailabilityThreadDao();
					// Copy the context information to the Threads
					charterDao.setApplicationContext(this
							.getApplicationContextFactory()
							.getApplicationContext());
					FlightsRequest charterRequest = (FlightsRequest) packagesRequest
							.getFlightsRequest().clone();
					charterRequest
							.setFlightRequestType(FlightRequestType.CHARTER);
					// Set FLEXI indicator to false as only specific day
					// charters should come in availability
					charterRequest.setFlexiDateIndicator(false);
					// Set the flight request for charter dao
					charterDao.setAbeRequest(charterRequest);
					// Call the Charter Dao
					charterFuture = taskExecutor.submit(charterDao);
					if (packagesRequest.isHotelRequested()) {
						/**
						 * If Hotels are requested, then wait for charter to
						 * come back. SKED will be called only if charters are
						 * not available
						 */
						// Wait for Charter response
						FlightsResponse charterResponse = (FlightsResponse) charterFuture
								.get();
						toReturnPackagesResponse
								.processResponse(charterResponse);
						// Process the charter response
						packagesRequest.setFlightsList(charterResponse
								.getFlightList());
						//Added to set if retrieved charter flights are sold out or not - AOL3FUNC_10A Price sold out charter air
						toReturnPackagesResponse.setSoldOutFlights(charterResponse.isSoldOutFlights());
						if (packagesRequest.getFlightsList() != null) {
							skedCallRequired = false;
						}
					}
				}
				Future<ABEResponse> skedFuture = null;
				if (skedCallRequired || !packagesRequest.isHotelRequested()) {
					AvailabilityThreadDao skedDao = (AvailabilityThreadDao) availabilityDaoFactory
							.createAvailabilityThreadDao();
					skedDao.setApplicationContext(this
							.getApplicationContextFactory()
							.getApplicationContext());
					// Set the flight request for charter dao
					FlightsRequest skedRequest = (FlightsRequest) packagesRequest
							.getFlightsRequest().clone();
					skedRequest
							.setFlightRequestType(FlightRequestType.SCHEDULED);
					skedDao.setAbeRequest(skedRequest);
					// Call the SKED dao
					skedFuture = taskExecutor.submit(skedDao);
				}
				if (packagesRequest.getVehiclesRequest() != null) {
					// If Vehicles are called, then parse the response
					VehiclesResponse vehicleResponse = (VehiclesResponse) vehicleFuture
							.get();
					if (vehicleResponse.isErrorsOccurred()) {
						toReturnPackagesResponse
								.processResponse(vehicleResponse);
						return toReturnPackagesResponse;
					}
					// Copy vehicles
					packagesRequest
							.setSapVehicleAvailabilityList(vehicleResponse
									.getSapVehicleAvailabilityList());
				}
				if (isValidCharterPair
						&& !packagesRequest.getFlightsRequest().isSkedOnly()
						&& !packagesRequest.isHotelRequested()) {
					// Air + Car scenario: Read the charter flights
					FlightsResponse charterResponse = (FlightsResponse) charterFuture
							.get();
					toReturnPackagesResponse.processResponse(charterResponse);
					// Process the charter response
					packagesRequest.setFlightsList(charterResponse
							.getFlightList());
				}
				if (skedFuture != null) {
					// Wait for SKED response
					FlightsResponse skedResponse = (FlightsResponse) skedFuture
							.get();
					toReturnPackagesResponse.processResponse(skedResponse);
					// Process the SKED response
					packagesRequest.setSapOrigDestOptionsList(skedResponse
							.getSapOrigDestOptionsList());
					packagesRequest.setSapSegmentsList(skedResponse
							.getSapSegmentsList());
				/*Code commented for revocation of 3620608 on 04/05/2013*/
					/*//Added segment set in PackageRequest for #3620608
					packagesRequest.setSapAddedSegmentsList(skedResponse
							.getSapAddedSegmentsList());*/
				}

				if (packagesRequest.getFlightsList() == null
						&& (packagesRequest.getSapOrigDestOptionsList() == null
								|| packagesRequest.getSapOrigDestOptionsList()
										.isEmpty()
								|| packagesRequest.getSapSegmentsList() == null || packagesRequest
								.getSapSegmentsList().isEmpty())) {
					
					/**--- 3620543 Coding Start---**/
					List<ABEBusinessError> errorList = new ArrayList<ABEBusinessError>();
					if(packagesRequest.getFlightsRequest().getDestination() == null
							|| "".equals(packagesRequest.getFlightsRequest().getDestination().trim())){
							toReturnPackagesResponse.getBusinessErrors().clear();
							ABEBusinessError headerErrorMsg = new ABEBusinessError("HEADER_ERROR_MESSAGE",this.getMessageSource()
								.getMessage("HEADER_ERROR_MESSAGE", null,
										null));
							ABEBusinessError destinationErrorMsg = new ABEBusinessError("BLANK_DESTINATION",this.getMessageSource()
									.getMessage("BLANK_DESTINATION", null,
											null));
							errorList.add(headerErrorMsg);
							errorList.add(destinationErrorMsg);
							if(packagesRequest.getFlightsRequest().getNoOfNights() == 0){
								ABEBusinessError nightsErrorMsg = new ABEBusinessError("ZERO_NIGHTS",this.getMessageSource()
										.getMessage("ZERO_NIGHTS", null,
												null));
								errorList.add(nightsErrorMsg);
							}
					}
					else if(packagesRequest.getFlightsRequest().getNoOfNights() == 0 && !ischarterGateway){
						toReturnPackagesResponse.getBusinessErrors().clear();
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
					ABEBusinessError error = new ABEBusinessError(
							"UNABLE_TO_RETRIEVE_FLIGHTS", this
									.getMessageSource().getMessage(
											"UNABLE_TO_RETRIEVE_FLIGHTS", null,
											null));
					errorList.add(error);
					}
					toReturnPackagesResponse.saveBusinessErrors(errorList);
					/**--- 3620543 Coding End---**/
					return toReturnPackagesResponse;
				}
			}

			// Call for packages
			PackagesResponse packagesResponse = packagesDAO
					.retrievePackages(packagesRequest);

			/*********** WESB CODE BEGINS ************/
			if (packagesResponse.getBusinessErrors() != null){				
				PackagesResponse packagesResponseTemp = packagesDAO.prepareHBSIPackageRequest(packagesRequest);
				packagesResponse.setFlightsList(packagesResponseTemp.getFlightsList());
			}		
							
				List<String> destinationList = this.hbsiHotelDao.getHotelDestinations();
				/*if (packagesRequest.isHotelRequested()
						&& (packagesRequest.getHotelsRequest() != null)
						&& packagesRequest.getHotelsRequest().getDestination()
								.equals("NAS"))*/
				
				//Fetch the Destinations for HBSi Hotels
				if (packagesRequest.isHotelRequested()
						&& (packagesRequest.getHotelsRequest() != null)
						&& packagesRequest.getHotelsRequest().getDestination() != null
						&& packagesRequest.getHotelsRequest().getDestination() != ""
						&& destinationList != null
						&& destinationList.contains(packagesRequest
								.getHotelsRequest().getDestination()))
				{
					Map<String, HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao
							.getHBSiDBData();
					
					
					//Change for over night flight, check for the overNightFlight status inside the flights in the packageReponse, if true set the hotel check in date
					//as flight Arrival date and reduce the number of nights by 1
					boolean overNightFlightStatus = false;
					overNightFlightStatus = packagesResponse.getFlightsList().get(0).getOutboundFlight().isOverNight();
					if(overNightFlightStatus) {
						int noOfNightsOverNight = (int) packagesRequest.getHotelsRequest().getNoOfNights();
						noOfNightsOverNight = noOfNightsOverNight - 1;
						packagesRequest.getHotelsRequest().setNoOfNights((short)noOfNightsOverNight);
						packagesRequest.getHotelsRequest().setDepartureDate(packagesResponse.getFlightsList().get(0).getOutboundFlight().getArrivalTime());
					}
					
					
					
					
					
					PackagesResponse wesbPackagesResponse = wesbPackagesDAO
							.wesbRetrievePackages(packagesRequest,
									hbsiHotelList);
					if(wesbPackagesResponse.getHotelList() !=null && wesbPackagesResponse.getHotelList().size() >0){
						for(Hotel hotel : wesbPackagesResponse.getHotelList()){
							hotel.setHBSI(hbsiHotelDao.isHBSiHotel(hotel.getDisplayRoomCategory().getHotelId()+""));
							}
						}		
					

					if ((wesbPackagesResponse.getHotelList() != null)
							&& (wesbPackagesResponse.getHotelList().size() > 0) && packagesResponse
							.getFlightsList()!=null &&packagesResponse
							.getFlightsList().size()>0) {

						List<Hotel> hotelList = new ArrayList<Hotel>();
						/*Calculate Package price inside displayRoomCategory and roomCategories (packagePrice = totalAmount(Hotel->displyRoomCategory)
						+ adultPrice (TripFlight))*/
						for (int i = 0; i < wesbPackagesResponse.getHotelList()
								.size(); i++) {
							
							Hotel hbsiHotel = wesbPackagesResponse
									.getHotelList().get(i);
							/*hbsiHotel
									.getDisplayRoomCategory()
									.getDisplayRoomPrice()
									.setPackagePrice(
											hbsiHotel.getDisplayRoomCategory()
													.getDisplayRoomPrice()
													.getTotalAmount()
													+ packagesResponse
															.getFlightsList()
															.get(0).getPrice()
															.getAdultPrice());*/
							//Calculating package price for all the room categories 
							double totalPrice=0.0;
							if(hbsiHotel.getRoomCategories()!=null && hbsiHotel.getRoomCategories().size()>0)
							{
							for(int k=0;k<hbsiHotel.getRoomCategories().size();k++)
							{
								RoomCategory roomCat = hbsiHotel.getRoomCategories().get(k);
								if(roomCat!=null && roomCat.getRoomPrices()!=null && roomCat.getRoomPrices().size()>0 )
								{
									for(int roomPrice=0;roomPrice<roomCat.getRoomPrices().size();roomPrice++ )
									{
									double adultPrice=0.0;
									double childPrice=0.0;
									double lapChildPrice=0.0;
									double infantPrice=0.0;
									double seniorMemberPrice=0.0;
									double juniorPrice=0.0;
									double minorPrice=0.0;
									double packagePricePerRoom=0.0;
									double totalTaxPerRoom=0.0;
									int noOfAdults=0;
									int noOfChilds=0;
									int noOfInfants=0;
									int noOflapChilds=0;
									int noOfSeniorMember=0;
									int noOfJuniors=0;
									int noOfMinors=0;
									int occupancyPerRoom=1;
									
									
									
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfAdults()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfAdults()!="")
									{
										noOfAdults = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfAdults());
										
										adultPrice=noOfAdults*packagesResponse
										.getFlightsList()
										.get(0)
										.getPrice().getPerAdultBasePrice();
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfChilds()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfChilds()!="")
									{
										noOfChilds = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfChilds());
										
										childPrice=(packagesResponse
										.getFlightsList()
										.get(0)
										.getPrice().getPerAdultBasePrice())*noOfChilds;
										
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfInfants()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfInfants()!="")
									{
										noOfInfants = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfInfants());
										
										infantPrice=(packagesResponse
										.getFlightsList()
										.get(0)
										.getPrice().getPerAdultBasePrice())*noOfInfants;
										
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfJuniors()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfJuniors()!="")
									{
										noOfJuniors = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfJuniors());
										
										juniorPrice=(packagesResponse
										.getFlightsList()
										.get(0)
										.getPrice().getPerAdultBasePrice())*noOfJuniors;
										
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfLapChilds()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfLapChilds()!="")
									{
										noOflapChilds = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfLapChilds());
										
										lapChildPrice=(packagesResponse
										.getFlightsList()
										.get(0)
										.getPrice().getPerAdultBasePrice())*noOflapChilds;
										
									}
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfSeniors()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfSeniors()!="")
									{
										noOfSeniorMember = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfSeniors());
										
										seniorMemberPrice=(packagesResponse
										.getFlightsList()
										.get(0)
										.getPrice().getPerAdultBasePrice())*noOfSeniorMember;
										
									}
									
									if(roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfMinors()!=null && roomCat.getRoomPrices()
											.get(roomPrice).getPaxBasePrices().getNoOfMinors()!="")
									{
										noOfMinors = Integer.parseInt(roomCat.getRoomPrices()
												.get(roomPrice).getPaxBasePrices().getNoOfMinors());
										
										minorPrice=(packagesResponse
										.getFlightsList()
										.get(0)
										.getPrice().getPerAdultBasePrice())*noOfMinors;
										
									}
									
									occupancyPerRoom=noOfAdults+noOfChilds+noOfInfants+noOfJuniors+noOflapChilds+noOfMinors+noOfSeniorMember;
									int totalOccupancy=hbsiHotel.getOccupancy().getNoOfAdults()+hbsiHotel.getOccupancy().getNoOfChilds()+
									hbsiHotel.getOccupancy().getNoOfInfants()+hbsiHotel.getOccupancy().getNoOfLapChilds()+
									hbsiHotel.getOccupancy().getNoOfSeniors();
									double taxPerOccupant=(packagesResponse
									.getFlightsList()
									.get(0)
									.getPrice().getTotalTax())/totalOccupancy;
									totalTaxPerRoom=occupancyPerRoom*taxPerOccupant;
									packagePricePerRoom=(adultPrice+childPrice+infantPrice+lapChildPrice+seniorMemberPrice+minorPrice+juniorPrice)+
									(totalTaxPerRoom);
									
											
											roomCat.getRoomPrices()
											.get(roomPrice)
											.setPackagePrice(roomCat.getRoomPrices()
													.get(roomPrice)
													.getTotalAmount()+
													packagePricePerRoom);
											
											if(k==0)
											{
												totalPrice=totalPrice+roomCat.getRoomPrices()
												.get(roomPrice).getPackagePrice();
												
											}
											
										
									}
								}
								hbsiHotel.getRoomCategories().remove(k);
								/*roomCat.getDisplayRoomPrice().setPackagePrice
								(roomCat.getDisplayRoomPrice().getTotalAmount()+packagesResponse.getFlightsList().get(0).getPrice().getAdultPrice());*/
								hbsiHotel.getRoomCategories().add(k, roomCat);
								
							}
							
							}
							hbsiHotel
							.getDisplayRoomCategory()
							.getDisplayRoomPrice()
							.setPackagePrice(totalPrice);
							
							
							hotelList.add(hbsiHotel);
						}

						/*packagesResponse.getHotelList().addAll(
								wesbPackagesResponse.getHotelList());*/
						if(packagesResponse.getHotelList()==null)
							packagesResponse.setHotelList(new ArrayList<Hotel>());
						packagesResponse.getHotelList().addAll(hotelList);
						if(packagesResponse.getHotelList().size()!=0)	
							if(packagesResponse.getBusinessErrors() != null)
								packagesResponse.getBusinessErrors().clear();
						Collections.sort(packagesResponse.getHotelList(),new HotelRatingComparator());
					}
				}
					

			/*********** WESB CODE ENDS ************/

			if (searchCriteria.isFilterSpecials())
				if (packagesRequest.isHotelRequested()
						&& packagesRequest.isAirRequested()
						&& packagesResponse.getHotelList() != null) {
					setAppleSpecialsSavers(packagesResponse, packagesRequest);
				}

			if (packagesResponse.isErrorsOccurred()) {

				// CQ#8872 - Rewrite business error message -@TODO
				if (packagesResponse.getBusinessErrors() != null) {
					for (ABEBusinessError error : packagesResponse
							.getBusinessErrors()) {
						if (error.getErrorCode() != null
								&& error.getErrorCode().equals("031")) {
							int index = packagesResponse.getBusinessErrors()
									.indexOf(error);
							error.setErrorDescription(this
									.getMessageSource()
									.getMessage(
											"HOTELS_NOT_AVAILABLE_SEARCH_CRITERIA",
											null, null));
							packagesResponse.getBusinessErrors().set(index,
									error);
							break;
						}
					}
				}

				return packagesResponse;
			}

			// Parse the response and populate the VO objects
			Package availablePackage = new Package();
			// Set the SearchCriteria
			availablePackage.setSearchCriteria(searchCriteria);
			if (packagesRequest.getHotelsRequest() != null) {
				/*
				 * Air + Hotel, Air + Hotel + Car scenarios
				 */
				if (packagesResponse.getFlightsList() != null
						&& packagesResponse.getFlightsList().size() > 0) {
					// Air + Hotel and Air + Hotel + Car
					availablePackage.setSelectedFlight(packagesResponse
							.getFlightsList().get(0));
				}
				if (packagesResponse.getVehiclesList() != null
						&& packagesResponse.getVehiclesList().size() > 0) {
					// Hotel + Car and Air + Hotel + Car
					availablePackage.setSelectedVehicle(packagesResponse
							.getVehiclesList().get(0));
				}
				availablePackage.setHotelOptions(packagesResponse
						.getHotelList());
				availablePackage.setDestinationServices(packagesResponse
						.getDestinationsList());
				if (packagesRequest.getFlightsList() != null) {
					availablePackage.setFlightOptions(packagesRequest
							.getFlightsList());
				}
			} else {
				// Air + Car scenario
				if (packagesResponse.getVehiclesList() != null
						&& packagesResponse.getVehiclesList().size() > 0) {
					availablePackage.setSelectedVehicle(packagesResponse
							.getVehiclesList().get(0));
				}
				availablePackage.setFlightOptions(packagesResponse
						.getFlightsList());
				if (packagesRequest.getFlightsList() != null) {
					availablePackage.setFlightOptions(packagesRequest
							.getFlightsList());
				}
				/*-------------------Regression testing issue ABE Master 8 Coding begins------------------*/
				
				//IGT-A--Issue # 3620601---START
				//This code here generating tripFlight groups, the code shifted from flex to java
				List <GroupedTripFlight>arrFlightsFilterted = new ArrayList<GroupedTripFlight>();
				List <TripFlight>tempArrFlightsFilterted = new ArrayList<TripFlight>();
				for(TripFlight tf: availablePackage.getFlightOptions())
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
				for (TripFlight tfMain : availablePackage.getFlightOptions()){
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
						for (TripFlight tfMainInner : availablePackage.getFlightOptions())
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
				
				availablePackage.setGroupedTripFlight(arrFlightsFilterted);
				//IGT-A---Issue # 3620601---Here we are maintaining List which will be used directly at the front end.---START 
				for (GroupedTripFlight grpdTripFlight : arrFlightsFilterted)
				{
					for (TripFlight tFlight : grpdTripFlight.getTripFlights())
					{
						if(tFlight.isFlightSelectedForDisplay())
							tempArrFlightsFilterted.add(tFlight);
					}
				}
				availablePackage.setDisplayTripFlightList(tempArrFlightsFilterted);
				
				
				/*-------------------Regression testing issue ABE Master 8 Coding ends------------------*/
			}
			
			toReturnPackagesResponse.setAvailablePackage(availablePackage);
		} catch (RejectedExecutionException rx) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_EXECUTE_THE_PACKAGES_REQUEST", this
							.getMessageSource().getMessage(
									"UNABLE_TO_EXECUTE_THE_PACKAGES_REQUEST",
									null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, rx);
		} catch (Exception ex) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_RETRIEVE_PACKAGES_AVAILABILITY", this
							.getMessageSource().getMessage(
									"UNABLE_TO_RETRIEVE_PACKAGES_AVAILABILITY",
									null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, ex);
		}
		return toReturnPackagesResponse;
	}

	/**
	 * Method to retrieve the price break up of given {@link Package}
	 * 
	 * @param hotel
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public AllPriceBreakUpResponse retrievePriceBreakUp(Package availablePackage) {
		return this.packagesDAO.retrievePriceBreakUp(availablePackage);
	}

	/**
	 * Method to retrieve the special packages For sked specials - Get flight
	 * from R/3 and hotel from SCE service Add flight price to hotel room price
	 * For charter specials - Get flight from cache and hotel from SCE service
	 * 
	 * @param request
	 *            - request for packages
	 * @return PackagesResponse object with packages
	 */
	public PackagesResponse retrieveSpecialPackages(
			SearchCriteria searchCriteria) {

		// Retrieve the request objects
		PackagesRequest packagesRequest = searchCriteria.getPackagesRequest();
		PackagesResponse toReturnPackagesResponse = new PackagesResponse();
		HotelsRequest hotelRequest = searchCriteria.getHotelsRequest();
		SpecialOptions specialOptions = hotelRequest.getSpecialOptions();

		try {
			if (specialOptions != null) {
				Future<ABEResponse> charterFuture = null;
				Future<ABEResponse> skedFuture = null;
				Future<ABEResponse> hotelFuture = null;

				// If requested special is of type charter, get charter flights
				if (specialOptions.getSpecialType().isCharterSpecial()
						&& packagesRequest.getFlightsRequest() != null) {
					AvailabilityThreadDao charterDao = (AvailabilityThreadDao) availabilityDaoFactory
							.createAvailabilityThreadDao();
					// Copy the context information to the Threads
					charterDao.setApplicationContext(this
							.getApplicationContextFactory()
							.getApplicationContext());
					FlightsRequest charterRequest = (FlightsRequest) packagesRequest
							.getFlightsRequest().clone();
					charterRequest
							.setFlightRequestType(FlightRequestType.CHARTER);
					charterRequest.setHotelRequested(true);
					charterRequest.setPackageRequest(false);
					// Set FLEXI indicator to false as only specific day
					// charters should come in availability
					charterRequest.setFlexiDateIndicator(false);
					// Set the flight request for charter dao
					charterDao.setAbeRequest(charterRequest);
					// Call the Charter Dao
					charterFuture = taskExecutor.submit(charterDao);
				} else if (specialOptions.getSpecialType().isSkedSpecial()
						&& packagesRequest.getFlightsRequest() != null) {
					AvailabilityThreadDao skedDao = (AvailabilityThreadDao) availabilityDaoFactory
							.createAvailabilityThreadDao();
					skedDao.setApplicationContext(this
							.getApplicationContextFactory()
							.getApplicationContext());
					// Set the flight request for charter dao
					FlightsRequest skedRequest = (FlightsRequest) packagesRequest
							.getFlightsRequest().clone();
					skedRequest
							.setFlightRequestType(FlightRequestType.SCHEDULED);
					skedRequest.setHotelRequested(true);
					skedRequest.setPackageRequest(false);
					skedDao.setAbeRequest(skedRequest);
					// Call the SKED dao
					skedFuture = taskExecutor.submit(skedDao);
				}

				AvailabilityThreadDao hotelCacheDao = (AvailabilityThreadDao) availabilityDaoFactory
						.createAvailabilityThreadDao();
				hotelCacheDao
						.setApplicationContext(this
								.getApplicationContextFactory()
								.getApplicationContext());
				// Set the hotels request for cache dao
				HotelsRequest hotelsRequest = (HotelsRequest) packagesRequest
						.getHotelsRequest().clone();
				hotelCacheDao.setAbeRequest(hotelsRequest);
				hotelFuture = taskExecutor.submit(hotelCacheDao);

				if (specialOptions.getSpecialType().isCharterSpecial()) {
					FlightsResponse charterResponse = (FlightsResponse) charterFuture
							.get();
					toReturnPackagesResponse.processResponse(charterResponse);
					toReturnPackagesResponse.setFlightsList(charterResponse
							.getFlightList());
				} else if (specialOptions.getSpecialType().isSkedSpecial()) {
					// Process sked response
					FlightsResponse skedResponse = (FlightsResponse) skedFuture
							.get();
					toReturnPackagesResponse.processResponse(skedResponse);
					toReturnPackagesResponse.setFlightsList(skedResponse
							.getFlightList());
				}
				HotelsResponse hotelResponse = (HotelsResponse) hotelFuture
						.get();
				toReturnPackagesResponse.processResponse(hotelResponse);
				toReturnPackagesResponse.setHotelList(hotelResponse
						.getHotelList());
			}

			if (toReturnPackagesResponse.isErrorsOccurred()) {
				return toReturnPackagesResponse;
			}

			// Parse the response and populate the VO objects
			Package availablePackage = new Package();
			// Set the SearchCriteria
			availablePackage.setSearchCriteria(searchCriteria);
			if (toReturnPackagesResponse.getHotelList().size() != 0) {
				if (toReturnPackagesResponse.getFlightsList() != null
						&& toReturnPackagesResponse.getFlightsList().size() > 0) {
					List<TripFlight> flightList = toReturnPackagesResponse
							.getFlightsList();
					// For specials always get the cheapest flight
					Collections.sort(flightList, new TripFlightPriceComparator(
							false));
					availablePackage.setFlightOptions(flightList);
					availablePackage.setSelectedFlight(flightList.get(0));
				}
				List<Hotel> hotelList;
				// For scheduled air specials update the room price with flight
				// price
				if (specialOptions.getSpecialType().isSkedSpecial()) {
					hotelList = SpecialUtils.updatePrices(
							toReturnPackagesResponse.getHotelList(),
							availablePackage.getSelectedFlight());
					// For charter specials SCE Service maintains price for
					// both hotel and flight in 'price now' column.
				} else {
					hotelList = toReturnPackagesResponse.getHotelList();
				}
				availablePackage.setHotelOptions(hotelList);
				availablePackage
						.setDestinationServices(toReturnPackagesResponse
								.getDestinationsList());
			}
			toReturnPackagesResponse.setAvailablePackage(availablePackage);
		} catch (RejectedExecutionException rx) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_EXECUTE_THE_SPL_PACKAGES_REQUEST",
					this.getMessageSource().getMessage(
							"UNABLE_TO_EXECUTE_THE_SPL_PACKAGES_REQUEST", null,
							null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, rx);
		} catch (Exception ex) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_RETRIEVE_SPL_PACKAGES_AVAILABILITY",
					this.getMessageSource().getMessage(
							"UNABLE_TO_RETRIEVE_SPL_PACKAGES_AVAILABILITY",
							null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, ex);
		}
		return toReturnPackagesResponse;
	}

	/**
	 * @param specialsCacheDao
	 *            the specialsCacheDao to set
	 */
	public void setSpecialsCacheDao(SpecialsCacheDao specialsCacheDao) {
		this.specialsCacheDao = specialsCacheDao;
	}

	/**
	 * @return the specialsCacheDao
	 */
	public SpecialsCacheDao getSpecialsCacheDao() {
		return specialsCacheDao;
	}

	public boolean isThereHBSIHotel(List<Hotel> hotels) {
		boolean isThereHBSIHotel = false;
		for (int i = 0; i < hotels.size(); i++) {
			if ((hotels.get(i).getHotelCode() != null)
					&& this.isHBSIHotel(hotels.get(i).getHotelCode())) {
				isThereHBSIHotel = true;
				break;
			}
		}
		return isThereHBSIHotel;
	}

	public boolean isHBSIHotel(String hotelCode) {
		if (hotelCode.equals("123")) {
			return true;
		}
		return false;
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
	
	/**
	 * @return the charterFlightsDao
	 */
	public FlightsDao getCharterFlightsDao() {
		return charterFlightsDao;
	}

	/**
	 * @param charterFlightsDao the charterFlightsDao to set
	 */
	public void setCharterFlightsDao(FlightsDao charterFlightsDao) {
		this.charterFlightsDao = charterFlightsDao;
	}

	/***
	 * check if there is flight offer with alternate duration available
	 * 
	 * @param packagesResponse
	 * @param flightsRequest
	 * @return
	 */
	private boolean checkFlightOffer(PackagesResponse packagesResponse, FlightsRequest flightsRequest){
		boolean hasCharterOffer = false;
		if (flightsRequest.isCheckCharterOfferFlight()){
			flightsRequest.setFlightRequestType(FlightRequestType.CHARTER);
			FlightsResponse flightOfferResponse = charterFlightsDao.retrieveFlightOffer(flightsRequest);
			packagesResponse.setFlightOffer(flightOfferResponse.getFlightOffer());
			if (flightOfferResponse.getFlightOffer() != null && flightOfferResponse.getFlightOffer().isCharterFlightOffer())
				hasCharterOffer = true;
		}
		return hasCharterOffer;
	}
}