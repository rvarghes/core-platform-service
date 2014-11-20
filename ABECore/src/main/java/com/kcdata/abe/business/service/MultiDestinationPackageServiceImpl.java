/*
 * MultiDestinationPackageServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 14, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

import org.springframework.core.task.AsyncTaskExecutor;

import com.kcdata.abe.business.request.FlightsRequest;
import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.request.MultiDestPackagesRequest;
import com.kcdata.abe.business.request.VehiclesRequest;
import com.kcdata.abe.business.response.FlightsResponse;
import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.business.response.MultiDestinationPackageResponse;

import com.kcdata.abe.business.response.VehiclesResponse;
import com.kcdata.abe.data.dao.HBSiHotelDao;
import com.kcdata.abe.data.dao.WesbMultiDestinationPackageDao;

import com.kcdata.abe.data.dao.threads.AvailabilityThreadDao;
import com.kcdata.abe.data.dto.Destination;
import com.kcdata.abe.data.dto.Flight;
import com.kcdata.abe.data.dto.FlightRequestType;
import com.kcdata.abe.data.dto.FlightSegment;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.MultiDestinationPackage;
import com.kcdata.abe.data.dto.Price;
import com.kcdata.abe.data.dto.RoomPrice;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.data.dto.VehicleOptions;
import com.kcdata.abe.data.factory.AvailabilityDaoFactory;
import com.kcdata.abe.data.util.FlightConvertUtils;
import com.kcdata.abe.data.util.FlightUtils;
import com.kcdata.abe.data.util.HotelPriceComparator;

import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.request.ABERequest;
import com.kcdata.abe.framework.response.ABEResponse;
import com.kcdata.abe.framework.service.ABEServiceBase;
import com.kcdata.abe.framework.util.ABEConstants;
import com.kcdata.abe.framework.util.DateUtils;

/**
 * Implementation class for Multi-Destination service
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class MultiDestinationPackageServiceImpl extends ABEServiceBase
		implements MultiDestinationPackageService {

	ABELogger logger = ABELogger
			.getLogger(MultiDestinationPackageServiceImpl.class);

	/**
	 * Task executor for executing the threads
	 */
	private AsyncTaskExecutor taskExecutor;

	/**
	 * Service Interface to create the Availability Dao objects
	 */
	private AvailabilityDaoFactory availabilityDaoFactory;
	
	private boolean stopoverFlag;
	
	private List<String> islandCityPair; 

	private HBSiHotelDao hbsiHotelDao;  

	/**
	 * @return the hbsiHotelDao
	 */
	public HBSiHotelDao getHbsiHotelDao() {
		return hbsiHotelDao;
	}

	/**
	 * @param hbsiHotelDao the hbsiHotelDao to set
	 */
	public void setHbsiHotelDao(HBSiHotelDao hbsiHotelDao) {
		this.hbsiHotelDao = hbsiHotelDao;
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
	 * @return the stopoverFlag
	 */
	public boolean isStopoverFlag() {
		return stopoverFlag;
	}

	/**
	 * @param stopoverFlag the stopoverFlag to set
	 */
	public void setStopoverFlag(boolean stopoverFlag) {
		this.stopoverFlag = stopoverFlag;
	}

	/**
	 * @return the islandCityPair
	 */
	public List<String> getIslandCityPair() {
		return islandCityPair;
	}

	/**
	 * @param islandCityPair the islandCityPair to set
	 */
	public void setIslandCityPair(List<String> islandCityPair) {
		this.islandCityPair = islandCityPair;
	}

	/**
	 * Packages DAO for WESB
	 */
	private WesbMultiDestinationPackageDao wesbMultiDestpackageDao;
	
	/**
	 * @return the wesbMultiDestpackageDao
	 */
	public WesbMultiDestinationPackageDao getWesbMultiDestpackageDao() {
		return wesbMultiDestpackageDao;
	}

	/**
	 * @param wesbMultiDestpackageDao the wesbMultiDestpackageDao to set
	 */
	public void setWesbMultiDestpackageDao(
			WesbMultiDestinationPackageDao wesbMultiDestpackageDao) {
		this.wesbMultiDestpackageDao = wesbMultiDestpackageDao;
	}

	/**
	 * Method to retrieve the flights for packages
	 * 
	 * @param searchCriteria
	 *            - searchCriteria for packages
	 * @param multiDestPackage
	 *            - package to be changed
	 * @return MultiDestinationPackageResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public MultiDestinationPackageResponse changeFlights(
			MultiDestinationPackage multiDestPackage) {
		MultiDestinationPackageResponse multiDestPkgResponse = new MultiDestinationPackageResponse();

		// Retrieve the Flight Request corresponding to the change flight
		// position
		FlightsRequest flightsRequest = this
				.retrieveChangeFlightsRequest(multiDestPackage);
		if (flightsRequest == null) {
			// Return the business error.
			ABEBusinessError businessError = new ABEBusinessError(
					"INVALID_MULTI_DESTINATION_SEARCH_CRITERIA",
					this.getMessageSource().getMessage(
							"INVALID_MULTI_DESTINATION_SEARCH_CRITERIA", null,
							null));
			multiDestPkgResponse.saveBusinessError(businessError);
			return multiDestPkgResponse;
		}
		// During change flights, system should clear the advanced criteria
		// because user requests change flights for more options
		flightsRequest.setPreferredCarriersList(null);
		flightsRequest.setOutboundAirOptions(null);
		flightsRequest.setInboundAirOptions(null);		
		try {
			flightsRequest.setFlightRequestType(FlightRequestType.SCHEDULED);
			Future<ABEResponse> abeResponseFuture = this
					.submitAvailabilityRequest(flightsRequest);
			FlightsResponse flightsResponse = (FlightsResponse) abeResponseFuture
					.get();
			multiDestPkgResponse.processResponse(flightsResponse);
			if (multiDestPkgResponse.isErrorsOccurred()) {
				return multiDestPkgResponse;
			}
			List<TripFlight> flightsList = flightsResponse.getFlightList();
			if (flightsList != null && flightsList.size() > 0) {
				// Compute the package price
				double pkgPriceWithoutChangeComponent = this
						.retrievePackagePriceWithoutComponent(multiDestPackage,
								true, false, false);
				for (TripFlight tripFlight : flightsList) {
					Price price = tripFlight.getPrice();
					price.setPackagePrice(price.getOccpancyBasedPrice()
							+ pkgPriceWithoutChangeComponent);
				}
			}
			multiDestPackage.setFlightOptions(flightsList);
			multiDestPkgResponse.setMultiDestinationPackage(multiDestPackage);
		} catch (RejectedExecutionException rx) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_EXECUTE_THE_MULTIDESTINATION_PACKAGE_REQUEST",
					this
							.getMessageSource()
							.getMessage(
									"UNABLE_TO_EXECUTE_THE_MULTIDESTINATION_PACKAGE_REQUEST",
									null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, rx);
		} catch (Exception ex) {
			
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_RETRIEVE_MULTI_DESTINATION_PACKAGES_AVAILABILITY",
					this
							.getMessageSource()
							.getMessage(
									"UNABLE_TO_RETRIEVE_MULTI_DESTINATION_PACKAGES_AVAILABILITY",
									null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, ex);
		}
		return multiDestPkgResponse;
	}

	/**
	 * Method to retrieve the hotels for packages
	 * 
	 * @param searchCriteria
	 *            - searchCriteria for packages
	 * @param multiDestPackage
	 *            - package to be changed
	 * @return MultiDestinationPackageResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public MultiDestinationPackageResponse changeHotels(
			MultiDestinationPackage multiDestPackage) {
		MultiDestinationPackageResponse multiDestPkgResponse = new MultiDestinationPackageResponse();

		// Retrieve the Hotels Request corresponding to the change flight
		// position
		HotelsRequest hotelsRequest = this
				.retrieveChangeHotelsRequest(multiDestPackage);
		if (hotelsRequest == null) {
			// Return the business error.
			ABEBusinessError businessError = new ABEBusinessError(
					"INVALID_MULTI_DESTINATION_SEARCH_CRITERIA",
					this.getMessageSource().getMessage(
							"INVALID_MULTI_DESTINATION_SEARCH_CRITERIA", null,
							null));
			multiDestPkgResponse.saveBusinessError(businessError);
			return multiDestPkgResponse;
		}
		// During change flights, system should clear the advanced criteria
		// because user requests change flights for more options
		if(hotelsRequest.getHotelOptions() != null) {
			hotelsRequest.getHotelOptions().setAppleRating(null);
			hotelsRequest.getHotelOptions().setResortArea(null);
			hotelsRequest.getHotelOptions().setHotelChain(null);
		}
		
		try {
			Future<ABEResponse> abeResponseFuture = this
					.submitAvailabilityRequest(hotelsRequest);
			HotelsResponse hotelsResponse = (HotelsResponse) abeResponseFuture
					.get();
			
			
	
			
	/******************WESB CODE BEGINS************************/
			if(hotelsResponse.getBusinessErrors()==null)
			{
				//Get The Destination for HBSi Hotels
				List<String> destinationList = this.hbsiHotelDao.getHotelDestinations();
			List<Hotel> wesbHotelList = null;
			/*if (hotelsRequest != null
					&& hotelsRequest.getDestination().equalsIgnoreCase("NAS"))*/
			
				if (hotelsRequest != null
						&& destinationList != null
						&& hotelsRequest.getDestination() != null
						&& hotelsRequest.getDestination() != ""
						&& destinationList.contains(hotelsRequest
								.getDestination()))
			{

				Map<String, HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao
						.getHBSiDBData();
				wesbHotelList = this.wesbMultiDestpackageDao
						.retrieveMultidestinationPackages(hotelsRequest,
								hbsiHotelList);

				if (wesbHotelList != null && wesbHotelList.size() > 0) {
					for (int i = 0; i < wesbHotelList.size(); i++) {
						if(wesbHotelList.get(i)!=null)
						{
						hotelsResponse.getHotelList().add(wesbHotelList.get(i));
						}
					}
				}
			}
		}
			
			
			
	/**********************WESB CODE ENDS**************/		
			
			multiDestPkgResponse.processResponse(hotelsResponse);
			if (multiDestPkgResponse.isErrorsOccurred()) {
				return multiDestPkgResponse;
			}
			List<Hotel> hotelsList = hotelsResponse.getHotelList();
			if (hotelsList != null && hotelsList.size() > 0) {
				// Compute the package price
				double pkgPriceWithoutChangeComponent = this
						.retrievePackagePriceWithoutComponent(multiDestPackage,
								false, true, false);
				for (Hotel hotel : hotelsList) {
					RoomPrice price = hotel.getDisplayRoomCategory()
							.getDisplayRoomPrice();
					price.setPackagePrice(price.getTotalAmount()
							+ pkgPriceWithoutChangeComponent);
				}
			}
			multiDestPackage.setHotelOptions(hotelsList);
			multiDestPackage.setDestinationServices(hotelsResponse
					.getDestinations());
			multiDestPkgResponse.setMultiDestinationPackage(multiDestPackage);
		} catch (RejectedExecutionException rx) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_EXECUTE_THE_MULTIDESTINATION_PACKAGE_REQUEST",
					this
							.getMessageSource()
							.getMessage(
									"UNABLE_TO_EXECUTE_THE_MULTIDESTINATION_PACKAGE_REQUEST",
									null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, rx);
		} catch (Exception ex) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_RETRIEVE_MULTI_DESTINATION_PACKAGES_AVAILABILITY",
					this
							.getMessageSource()
							.getMessage(
									"UNABLE_TO_RETRIEVE_MULTI_DESTINATION_PACKAGES_AVAILABILITY",
									null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, ex);
		}
		return multiDestPkgResponse;
	}

	/**
	 * Method to retrieve the vehicles for packages
	 * 
	 * @param searchCriteria
	 *            - searchCriteria for packages
	 * @param multiDestPackage
	 *            - package to be changed
	 * @return MultiDestinationPackageResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public MultiDestinationPackageResponse changeVehicles(
			MultiDestinationPackage multiDestPackage) {
		MultiDestinationPackageResponse multiDestPkgResponse = new MultiDestinationPackageResponse();

		// Retrieve the Hotels Request corresponding to the change flight
		// position
		VehiclesRequest vehiclesRequest = this
				.retrieveChangeVehiclesRequest(multiDestPackage);
		if (vehiclesRequest == null) {
			// Return the business error.
			ABEBusinessError businessError = new ABEBusinessError(
					"INVALID_MULTI_DESTINATION_SEARCH_CRITERIA",
					this.getMessageSource().getMessage(
							"INVALID_MULTI_DESTINATION_SEARCH_CRITERIA", null,
							null));
			multiDestPkgResponse.saveBusinessError(businessError);
			return multiDestPkgResponse;
		}
		// During change flights, system should clear the advanced criteria
		// because user requests change flights for more options
		if(vehiclesRequest.getVehicleOptions() != null) {
			vehiclesRequest.getVehicleOptions().setVehicleClass(null);
		}
		try {
			Future<ABEResponse> abeResponseFuture = this
					.submitAvailabilityRequest(vehiclesRequest);
			VehiclesResponse vehiclesResponse = (VehiclesResponse) abeResponseFuture
					.get();
			multiDestPkgResponse.processResponse(vehiclesResponse);
			if (multiDestPkgResponse.isErrorsOccurred()) {
				return multiDestPkgResponse;
			}
			List<Vehicle> vehiclesList = vehiclesResponse.getVehicles();
			if (vehiclesList != null && vehiclesList.size() > 0) {
				// Compute the package price
				double pkgPriceWithoutChangeComponent = this
						.retrievePackagePriceWithoutComponent(multiDestPackage,
								false, false, true);
				for (Vehicle vehicle : vehiclesList) {
					Price price = vehicle.getPrice();
					price.setPackagePrice(price.getOccpancyBasedPrice()
							+ pkgPriceWithoutChangeComponent);
				}
			}
			multiDestPackage.setVehicleOptions(vehiclesList);
			multiDestPkgResponse.setMultiDestinationPackage(multiDestPackage);
		} catch (RejectedExecutionException rx) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_EXECUTE_THE_MULTIDESTINATION_PACKAGE_REQUEST",
					this
							.getMessageSource()
							.getMessage(
									"UNABLE_TO_EXECUTE_THE_MULTIDESTINATION_PACKAGE_REQUEST",
									null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, rx);
		} catch (Exception ex) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_RETRIEVE_MULTI_DESTINATION_PACKAGES_AVAILABILITY",
					this
							.getMessageSource()
							.getMessage(
									"UNABLE_TO_RETRIEVE_MULTI_DESTINATION_PACKAGES_AVAILABILITY",
									null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, ex);
		}
		return multiDestPkgResponse;
	}

	/**
	 * Method to retrieve the packages
	 * 
	 * @param searchCriteria
	 *            - searchCriteria for multi-destination packages
	 * @return MultiDestinationPackageResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public MultiDestinationPackageResponse retrievePackages(
			SearchCriteria searchCriteria) {
		MultiDestinationPackageResponse multiDestPkgResponse = new MultiDestinationPackageResponse();

		// Retrieve multi-destination request from search criteria
		MultiDestPackagesRequest multiDestPkgRequest = searchCriteria
				.getMultiDestPackageRequest();
		/*try {
			//String strXML = new XMLConvertUtils().marshal(multiDestPkgRequest);
			//System.out.println("+++++++++++++++++++++++++++");
			//System.out.println("multiDestPkgRequest -"+strXML);
			//System.out.println("+++++++++++++++++++++++++++");
		} catch (Exception e) {
			// TODO Auto-generated catch blockp
			e.printStackTrace();
		}*/
		if (multiDestPkgRequest == null) {
			// Return the business error.
			ABEBusinessError businessError = new ABEBusinessError(
					"INVALID_MULTI_DESTINATION_SEARCH_CRITERIA",
					this.getMessageSource().getMessage(
							"INVALID_MULTI_DESTINATION_SEARCH_CRITERIA", null,
							null));
			multiDestPkgResponse.saveBusinessError(businessError);
			return multiDestPkgResponse;
		}

		try {
			ArrayList<Future<ABEResponse>> availabilityResponseList = new ArrayList<Future<ABEResponse>>();

			// Call Flights availability If User requests flights
			if (multiDestPkgRequest.getFlightsRequestList() != null) {
				for (FlightsRequest flightsRequest : multiDestPkgRequest
						.getFlightsRequestList()) {
					flightsRequest
							.setFlightRequestType(FlightRequestType.SCHEDULED);
					availabilityResponseList.add(this
							.submitAvailabilityRequest(flightsRequest));
				}
			}

			// Call Vehicles availability If User requests vehicles
			if (multiDestPkgRequest.getVehiclesRequestList() != null) {
				for (VehiclesRequest vehiclesRequest : multiDestPkgRequest
						.getVehiclesRequestList()) {
					availabilityResponseList.add(this
							.submitAvailabilityRequest(vehiclesRequest));
				}
			}

			// Call Hotels availability If User Requests Hotels
			if (multiDestPkgRequest.getHotelsRequestList() != null) {
				for (HotelsRequest hotelsRequest : multiDestPkgRequest
						.getHotelsRequestList()) {
					availabilityResponseList.add(this
							.submitAvailabilityRequest(hotelsRequest));
					
					
					
										
				}
			}
			
			/**
			 * HBSi hotels for Multidestination Package
			 * WESB CODE BEGINS
			 * 
			 */
			
			List<Hotel> wesbHotelList = null;
			List<HotelsRequest> hotelRequestList = multiDestPkgRequest.getHotelsRequestList();
			//Get The Destination List for HBSi Hotels 
			List<String> destinationList = this.hbsiHotelDao.getHotelDestinations();
			int hotelRequestListSize =0;
			if(hotelRequestList!=null)
			{
				hotelRequestListSize = hotelRequestList.size();
			}
		
			//for(HotelsRequest wesbhotelsRequest:hotelRequestList)
			for(int i=0;i<hotelRequestListSize;i++)
			{
				
				HotelsRequest wesbhotelsRequest =hotelRequestList.get(i);	
			/*	if (wesbhotelsRequest != null
						&& wesbhotelsRequest.getDestination() != null
						&& wesbhotelsRequest.getDestination() != ""
						&& wesbhotelsRequest.getDestination().equalsIgnoreCase(
								"NAS"))*/
				
					if (wesbhotelsRequest != null
							&& wesbhotelsRequest.getDestination() != null
							&& wesbhotelsRequest.getDestination() != ""
							&& destinationList!=null && destinationList.contains(wesbhotelsRequest.getDestination()))
				{
					
					Map<String,HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao.getHBSiDBData();
					wesbHotelList = this.wesbMultiDestpackageDao.retrieveMultidestinationPackages(wesbhotelsRequest,hbsiHotelList);
				}
				
			}
		
			
			
			/**
			 * WESB CODE ENDS
			 */
			
			// Create a object of multi-destination package
			MultiDestinationPackage multiDestinationPackage = new MultiDestinationPackage();
			// Set SearchCriteria to package
			multiDestinationPackage.setSearchCriteria(searchCriteria);
			// Process the Response
			for (Future<ABEResponse> availabilityResponse : availabilityResponseList) {
				// Wait for the task to complete
				ABEResponse response = availabilityResponse.get();

				// Parse the response for business errors, warnings and info
				// messages
				multiDestPkgResponse.processResponse(response);

				if (response instanceof FlightsResponse) {
					// Parse Flights Response
					FlightsResponse flightsResponse = (FlightsResponse) response;
					TripFlight selectedFlight = this
							.preselectFlight(flightsResponse.getFlightList());
					if (selectedFlight != null) {
						if (multiDestinationPackage.getSelectedFlights() == null) {
							multiDestinationPackage
									.setSelectedFlights(new ArrayList<TripFlight>());
						}
						
						multiDestinationPackage.getSelectedFlights().add(
								selectedFlight);
						
						/*try {
							String strXML = new XMLConvertUtils().marshal(multiDestinationPackage.getSelectedFlights());
							System.out.println("+++++++++++++++++++++++++++");
							System.out.println("Trip Flights -"+strXML);
							System.out.println("+++++++++++++++++++++++++++");
						} catch (Exception e) {
							// TODO Auto-generated catch blockp
							e.printStackTrace();
						}*/
						
					}
				} else if (response instanceof HotelsResponse) {
					// Parse Hotels Response
					HotelsResponse hotelsResponse = (HotelsResponse) response;
					
					/**
					 * HBSi hotels for Multidestination Package
					 * WESB CODE BEGINS
					 * 
					 */
					if(hotelsResponse.getBusinessErrors()==null)
					{
					/*List<Hotel> wesbHotelList = null;
					List<HotelsRequest> hotelRequestList = multiDestPkgRequest.getHotelsRequestList();
					
					int hotelRequestListSize =0;
					if(hotelRequestList!=null)
					{
						hotelRequestListSize = hotelRequestList.size();
					}
				
					//for(HotelsRequest wesbhotelsRequest:hotelRequestList)
					for(int i=0;i<hotelRequestListSize;i++)
					{
						
						HotelsRequest wesbhotelsRequest =hotelRequestList.get(i);	
						if(wesbhotelsRequest!=null && wesbhotelsRequest.getDestination().equalsIgnoreCase("NAS"))
						{
							System.out.println("Inside If");
							Map<String,HBSiHotelInfo> hbsiHotelList = this.hbsiHotelDao.getHBSiDBData();
							wesbHotelList = this.wesbMultiDestpackageDao.retrieveMultidestinationPackages(wesbhotelsRequest,hbsiHotelList);
						}
						
					}
					
										*/
					if(hotelsResponse.getHotelList()!=null && hotelsResponse.getHotelList().get(0)!=null
							&&hotelsResponse.getHotelList().get(0).getHotelCityCode().equalsIgnoreCase("NAS") )	
					{
					if(wesbHotelList!=null && wesbHotelList.size()>0)
					{
						
						for(int i=0;i<wesbHotelList.size();i++)
						{
							if(wesbHotelList.get(i)!=null)
							{
							hotelsResponse.getHotelList().add(wesbHotelList.get(i));
							}
						}
					}
					}
					}
					
					/**
					 * WESB CODE ENDS
					 */
					Hotel selectedHotel = this.preselectHotel(hotelsResponse
							.getHotelList());
					if (selectedHotel != null) {
						if (multiDestinationPackage.getSelectedHotels() == null) {
							multiDestinationPackage
									.setSelectedHotels(new ArrayList<Hotel>());
						}
						multiDestinationPackage.getSelectedHotels().add(
								selectedHotel);
					}
					// Set the destination services
					if (hotelsResponse.getDestinations() != null) {
						if (multiDestinationPackage.getDestinationServices() == null) {
							multiDestinationPackage
									.setDestinationServices(new ArrayList<Destination>());
						}
						multiDestinationPackage.getDestinationServices()
								.addAll(hotelsResponse.getDestinations());
					}
				} else if (response instanceof VehiclesResponse) {
					// Parse Vehicles Response
					VehiclesResponse vehiclesResponse = (VehiclesResponse) response;
					Vehicle selectedVehicle = this
							.preselectVehicle(vehiclesResponse.getVehicles());
					if (selectedVehicle != null) {
						if (multiDestinationPackage.getSelectedVehicles() == null) {
							multiDestinationPackage
									.setSelectedVehicles(new ArrayList<Vehicle>());
						}
						multiDestinationPackage.getSelectedVehicles().add(
								selectedVehicle);
					}
				}
			}
			// Process multi-destination flight for overnights and adjust the
			// dates of hotels
			processPackageForOvernight(multiDestinationPackage);
			multiDestinationPackage.setPrice(this
					.computeMultiDestPkgPrice(multiDestinationPackage));
			multiDestPkgResponse
					.setMultiDestinationPackage(multiDestinationPackage);
		} catch (RejectedExecutionException rx) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_EXECUTE_THE_MULTIDESTINATION_PACKAGE_REQUEST",
					this
							.getMessageSource()
							.getMessage(
									"UNABLE_TO_EXECUTE_THE_MULTIDESTINATION_PACKAGE_REQUEST",
									null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, rx);
		} catch (Exception ex) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_RETRIEVE_MULTI_DESTINATION_PACKAGES_AVAILABILITY",
					this
							.getMessageSource()
							.getMessage(
									"UNABLE_TO_RETRIEVE_MULTI_DESTINATION_PACKAGES_AVAILABILITY",
									null, null));
			throw new ABESystemException(systemError, ABETier.BUSINESS, ex);
		}
		
		//Temporaray
		if(isStopoverFlag()){
			if(multiDestPkgResponse.getMultiDestinationPackage().getSelectedFlights() !=null){
				multiDestPkgResponse.getMultiDestinationPackage().setSelectedFlights(processStopOverFlights(multiDestPkgResponse.getMultiDestinationPackage().getSelectedFlights(), islandCityPair));
				
				/*try {
					String strXML = new XMLConvertUtils().marshal(multiDestPkgResponse.getMultiDestinationPackage().getSelectedFlights());
					System.out.println("+++++++++++++++++++++++++++");
					System.out.println("Stopover Trip Flights -"+strXML);
					System.out.println("+++++++++++++++++++++++++++");
				} catch (Exception e) {
					// TODO Auto-generated catch blockp
					e.printStackTrace();
				}*/
			}
		}
		return multiDestPkgResponse;
	}

	/**
	 * Method to create a Task for retrieving the availability and submits it
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private Future<ABEResponse> submitAvailabilityRequest(ABERequest request) {
		// Create a thread DAO
		AvailabilityThreadDao availabilityDao = (AvailabilityThreadDao) availabilityDaoFactory
				.createAvailabilityThreadDao();
		// Set the application context for execution
		availabilityDao.setApplicationContext(this
				.getApplicationContextFactory().getApplicationContext());

		// Set the request object for execution
		availabilityDao.setAbeRequest(request);

		// Submit the task and return the response
		return taskExecutor.submit(availabilityDao);
	}

	/**
	 * Method to preselect the flight based on the business rules
	 * 
	 * @param flightsList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private TripFlight preselectFlight(List<TripFlight> flightsList) {
		if (flightsList == null) {
			return null;
		}
		// Sort the flights based on price
		flightsList = FlightUtils.sortFlights(flightsList, null, false);
		// Pre-select and return the first flight
		return flightsList.get(0);
	}

	/**
	 * Method to preselect the flight based on the business rules
	 * 
	 * @param flightsList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private Hotel preselectHotel(List<Hotel> hotelsList) {
		if (hotelsList == null) {
			return null;
		}
		Collections.sort(hotelsList, new HotelPriceComparator());
		// Hotels are already sorted in DAO. So, preselect the first hotel	
		// Filter the  RFA  hotels pre selected  for  Mulitp destination package  Defect ID 10 ABE TA PJ
		for (Iterator iterator = hotelsList.iterator(); iterator.hasNext();) {
			Hotel hotel = (Hotel) iterator.next();
			if(hotel.getDisplayRoomCategory().getStatus()!=null &&
					!hotel.getDisplayRoomCategory().getStatus().trim().equalsIgnoreCase(ABEConstants.RFA_HOTEL_STATUS) &&
					!ABEConstants.ON_YOUR_OWN_HOTEL_TEXT.equalsIgnoreCase(hotel.getHotelName()))
					return hotel;
		}
		return null;
		//return hotelsList.get(0);
	}

	/**
	 * Method to preselect the flight based on the business rules
	 * 
	 * @param flightsList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private Vehicle preselectVehicle(List<Vehicle> vehiclesList) {
		if (vehiclesList == null) {
			return null;
		}
		// Vehicles are already sorted in DAO. So, preselect the first vehicle
		return vehiclesList.get(0);
	}

	/**
	 * Method to reset the price by dynamically computing it.
	 * 
	 * 
	 * @see
	 * @since
	 */
	public Price computeMultiDestPkgPrice(MultiDestinationPackage multiDestPkg) {
		if (multiDestPkg == null) {
			return null;
		}
		Price price = new Price();
		// Add Flights price
		if (multiDestPkg.getSelectedFlights() != null) {
			for (TripFlight flight : multiDestPkg.getSelectedFlights()) {
				if (flight.getPrice() != null) {
					price.setPackagePrice(price.getPackagePrice()
							+ flight.getPrice().getOccpancyBasedPrice());
				}
			}
		}
		// Add Hotels price
		if (multiDestPkg.getSelectedHotels() != null) {
			for (Hotel hotel : multiDestPkg.getSelectedHotels()) {
				if (hotel.getDisplayRoomCategory() != null
						&& hotel.getDisplayRoomCategory().getDisplayRoomPrice() != null) {
					price.setPackagePrice(price.getPackagePrice()
							+ hotel.getDisplayRoomCategory()
									.getDisplayRoomPrice().getTotalAmount());
				}
			}
		}
		// Add Vehicles price
		if (multiDestPkg.getSelectedVehicles() != null) {
			for (Vehicle vehicle : multiDestPkg.getSelectedVehicles()) {
				if (vehicle.getPrice() != null) {
					price.setPackagePrice(price.getPackagePrice()
							+ vehicle.getPrice().getOccpancyBasedPrice());
				}
			}
		}
		return price;
	}

	/**
	 * Method to retrieve the FlightRequest associated with change flight
	 * requested
	 * 
	 * @param multiDestPkg
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private FlightsRequest retrieveChangeFlightsRequest(
			MultiDestinationPackage multiDestPkg) {
		MultiDestPackagesRequest multiDestPkgRequest = multiDestPkg
				.getSearchCriteria().getMultiDestPackageRequest();
		if (multiDestPkgRequest == null
				|| multiDestPkgRequest.getFlightsRequestList() == null
				|| multiDestPkg.getSelectedFlights() == null
				|| multiDestPkg.getSelectedFlights().size() <= multiDestPkg
						.getChangePosition()) {
			return null;
		}
		TripFlight tripFlight = multiDestPkg.getSelectedFlights().get(
				multiDestPkg.getChangePosition());
		for (FlightsRequest flightsRequest : multiDestPkgRequest
				.getFlightsRequestList()) {
			if (flightsRequest.getGateway().equals(
					tripFlight.getOutboundFlight().getGateway())
					&& flightsRequest.getDestination().equals(
							tripFlight.getOutboundFlight().getDestination())) {
				return flightsRequest;
			}else{
				//CQ7968 - Changes done for stopover flights added as segment
				List<FlightSegment> flightSegmentList = tripFlight.getOutboundFlight().getFlightSegments();
				for(FlightSegment flightSegment:flightSegmentList){
					if(flightsRequest.getGateway().equals(
							flightSegment.getGateway())
							&& flightsRequest.getDestination().equals(
									flightSegment.getDestination())){
						return flightsRequest;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Method to retrieve the Hotels associated with change hotel requested
	 * 
	 * @param multiDestPkg
	 * @param multiDestPkgRequest
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private HotelsRequest retrieveChangeHotelsRequest(
			MultiDestinationPackage multiDestPkg) {
		MultiDestPackagesRequest multiDestPkgRequest = multiDestPkg
				.getSearchCriteria().getMultiDestPackageRequest();
		if (multiDestPkgRequest == null
				|| multiDestPkgRequest.getHotelsRequestList() == null
				|| multiDestPkg.getSelectedHotels() == null
				|| multiDestPkg.getSelectedHotels().size() <= multiDestPkg
						.getChangePosition()) {
			return null;
		}
		Hotel hotel = multiDestPkg.getSelectedHotels().get(
				multiDestPkg.getChangePosition());
		for (HotelsRequest hotelRequest : multiDestPkgRequest
				.getHotelsRequestList()) {
			if (hotelRequest.getGateway().equals(hotel.getOriginLocation())
					&& hotelRequest.getDestination().equals(
							hotel.getHotelCityCode())) {
				hotelRequest.setDepartureDate(hotel.getCheckInDate());
				hotelRequest.setNoOfNights((byte) DateUtils
						.dateDifferenceInDays(hotel.getCheckInDate(), hotel
								.getCheckOutDate()));
				return hotelRequest;
			}
		}
		return null;
	}

	/**
	 * Method to retrieve the VehiclesRequest associated with change Vehicle
	 * requested
	 * 
	 * @param multiDestPkg
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private VehiclesRequest retrieveChangeVehiclesRequest(
			MultiDestinationPackage multiDestPkg) {
		MultiDestPackagesRequest multiDestPkgRequest = multiDestPkg
				.getSearchCriteria().getMultiDestPackageRequest();
		if (multiDestPkgRequest == null
				|| multiDestPkgRequest.getVehiclesRequestList() == null
				|| multiDestPkg.getSelectedVehicles() == null
				|| multiDestPkg.getSelectedVehicles().size() <= multiDestPkg
						.getChangePosition()) {
			return null;
		}
		Vehicle vehicle = multiDestPkg.getSelectedVehicles().get(
				multiDestPkg.getChangePosition());
		for (VehiclesRequest vehiclesRequest : multiDestPkgRequest
				.getVehiclesRequestList()) {
			if (vehiclesRequest.getVehicleOptions() != null
					&& vehiclesRequest.getDestination()
							.equals(vehicle.getDestination())) {
				VehicleOptions vehicleOptions = vehiclesRequest
						.getVehicleOptions();
				vehicleOptions.setPickupDateTime(vehicle.getPickupTime());
				vehicleOptions.setDropoffDateTime(vehicle.getDropOffTime());
				return vehiclesRequest;
			}
		}
		return null;
	}

	/**
	 * Method to compute the multi-destination package price without change
	 * component
	 * 
	 * @param flightsList
	 * @param multiDestPkg
	 * 
	 * @see
	 * @since
	 */
	private double retrievePackagePriceWithoutComponent(
			MultiDestinationPackage multiDestPkg, boolean changeFlights,
			boolean changeHotels, boolean changeVehicles) {
		double packagePrice = 0;
		if (multiDestPkg.getSelectedFlights() != null) {
			for (byte index = 0; index < multiDestPkg.getSelectedFlights()
					.size(); index++) {
				if (changeFlights && multiDestPkg.getChangePosition() == index) {
					continue;
				}
				TripFlight flight = (TripFlight) multiDestPkg
						.getSelectedFlights().get(index);
				packagePrice += flight.getPrice().getOccpancyBasedPrice();
			}
		}
		if (multiDestPkg.getSelectedHotels() != null) {
			for (byte index = 0; index < multiDestPkg.getSelectedHotels()
					.size(); index++) {
				if (changeHotels && multiDestPkg.getChangePosition() == index) {
					continue;
				}
				Hotel hotel = (Hotel) multiDestPkg.getSelectedHotels().get(
						index);
				packagePrice += hotel.getDisplayRoomCategory()
						.getDisplayRoomPrice().getTotalAmount();
			}
		}
		if (multiDestPkg.getSelectedVehicles() != null) {
			for (byte index = 0; index < multiDestPkg.getSelectedVehicles()
					.size(); index++) {
				if (changeVehicles && multiDestPkg.getChangePosition() == index) {
					continue;
				}
				Vehicle vehicle = (Vehicle) multiDestPkg.getSelectedVehicles()
						.get(index);
				packagePrice += vehicle.getPrice().getOccpancyBasedPrice();
			}
		}
		return packagePrice;
	}

	/**
	 * Method to process the MultiDestinationPackage for over nights
	 * 
	 * @param multiDestinationPackage
	 * 
	 * @see
	 * @since
	 */
	private void processPackageForOvernight(
			MultiDestinationPackage multiDestinationPackage) {
		if (multiDestinationPackage == null
				|| multiDestinationPackage.getSelectedFlights() == null
				|| multiDestinationPackage.getSelectedFlights().size() == 0) {
			return;
		}
		// Flights exists
		for (TripFlight tripFlight : multiDestinationPackage
				.getSelectedFlights()) {
			if (tripFlight.getOutboundFlight().isOverNight()) {
				// Process Hotels for overnight
				processPackageHotelsForOvernight(multiDestinationPackage,
						tripFlight);
				// Process vehicles for overnight
				processPackageVehiclesForOvernight(multiDestinationPackage,
						tripFlight);
			}
		}
	}

	/**
	 * Method to process the MultiDestinationPackage hotels for over nights
	 * 
	 * @param multiDestinationPackage
	 * 
	 * @see
	 * @since
	 */
	private void processPackageHotelsForOvernight(
			MultiDestinationPackage multiDestinationPackage,
			TripFlight tripFlight) {
		if (multiDestinationPackage.getSelectedHotels() == null
				|| multiDestinationPackage.getSelectedHotels().size() == 0) {
			return;
		}
		String destination = tripFlight.getOutboundFlight().getDestination();
		Date arrivalDate = tripFlight.getOutboundFlight().getArrivalTime();
		for (Hotel hotel : multiDestinationPackage.getSelectedHotels()) {
			if (hotel.getHotelCityCode().equals(destination)) {
				hotel.setCheckInDate(arrivalDate);
			}
		}
	}

	/**
	 * Method to process the MultiDestinationPackage vehicles for over nights
	 * 
	 * @param multiDestinationPackage
	 * 
	 * @see
	 * @since
	 */
	private void processPackageVehiclesForOvernight(
			MultiDestinationPackage multiDestinationPackage,
			TripFlight tripFlight) {
		if (multiDestinationPackage.getSelectedVehicles() == null
				|| multiDestinationPackage.getSelectedVehicles().size() == 0) {
			return;
		}
		String destination = tripFlight.getOutboundFlight().getDestination();
		Date arrivalDate = tripFlight.getOutboundFlight().getArrivalTime();
		for (Vehicle vehicle : multiDestinationPackage.getSelectedVehicles()) {
			if (vehicle.getPickupLocation().equals(destination)) {
				vehicle.setPickupTime(arrivalDate);
			}
		}
	}
	
	/**
	 * Method to process Trip Flights based on stop over city pairs
	 * 
	 * @param flightList
	 * @param islandCityList
	 * @return
	 */
	private List<TripFlight> processStopOverFlights(List<TripFlight> flightList, final List<String> islandCityList){
		List<TripFlight> flights = new ArrayList<TripFlight>();
		List<TripFlight> islandFlights = new ArrayList<TripFlight>();
		for(TripFlight tripFlight:flightList){
			if(flights.size()==0){
				flights.add(tripFlight);
			}else if(FlightConvertUtils.isIslandCityPair(tripFlight, islandCityList)){
				islandFlights.add(tripFlight);
			}else{
				if(flights!=null && flights.size()>0){
					TripFlight previousTripFlight = flights.get(flights.size()>0?flights.size()-1:flights.size());
					Flight outboundFlight = previousTripFlight.getOutboundFlight();
					String prevDest = outboundFlight.getDestination();
					String gateway = tripFlight.getOutboundFlight().getGateway();
					if(tripFlight.getOutboundFlight()!=null ){
						outboundFlight.getFlightSegments().addAll(tripFlight.getOutboundFlight().getFlightSegments());
						outboundFlight.setDestination(tripFlight.getOutboundFlight().getDestination());
						previousTripFlight.setOutboundFlight(outboundFlight);
						flights.set(flights.size()>0?flights.size()-1:flights.size(), previousTripFlight);
					}else{
						flights.add(tripFlight);
					}
				}
			}
		}
		flights.addAll(islandFlights);
		return flights;
		
	}
}
