/*
 * AvailabilityThreadDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 26, 2009  hguntupa
 * Sep 24, 2009  hguntupa	  Added VehicleRequest and Package flows
 ******************************************************************************
 */

package com.kcdata.abe.data.dao.threads;

import java.util.concurrent.Callable;

import com.kcdata.abe.business.request.FlightsRequest;
import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.request.VehiclesRequest;
import com.kcdata.abe.data.dao.FlightsDao;
import com.kcdata.abe.data.dao.HotelsCacheDao;
import com.kcdata.abe.data.dao.HotelsDao;
import com.kcdata.abe.data.dao.VehiclesDao;
import com.kcdata.abe.framework.context.ABEApplicationContext;
import com.kcdata.abe.framework.dao.ABEDaoBase;
import com.kcdata.abe.framework.request.ABERequest;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Class to provide threaded behavior to the DAO classes. Hold the objects of
 * FlightsDao, HotelDao, VehicleDao and calls the appropriate DAO depending on
 * the ABERequest type
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AvailabilityThreadDao extends ABEDaoBase implements
		Callable<ABEResponse> {

	private volatile ABERequest abeRequest;

	private FlightsDao charterDao;
	private FlightsDao flightsDao;
	private HotelsDao hotelDao;
	private VehiclesDao vehiclesDao;
	private HotelsCacheDao hotelsCacheDao;

	/**
	 * Variable used to pass the ApplicationContext from the caller
	 */
	private ABEApplicationContext applicationContext;

	/**
	 * @return the charterDao
	 */
	public FlightsDao getCharterDao() {
		return charterDao;
	}

	/**
	 * @param charterDao
	 *            the charterDao to set
	 */
	public void setCharterDao(FlightsDao charterDao) {
		this.charterDao = charterDao;
	}

	/**
	 * @return the skedDao
	 */
	public FlightsDao getFlightsDao() {
		return flightsDao;
	}

	/**
	 * @param skedDao
	 *            the flightsDao to set
	 */
	public void setFlightsDao(FlightsDao flightsDao) {
		this.flightsDao = flightsDao;
	}

	/**
	 * @return the hotelDao
	 */
	public HotelsDao getHotelDao() {
		return hotelDao;
	}

	/**
	 * @param hotelDao
	 *            the hotelDao to set
	 */
	public void setHotelDao(HotelsDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	/**
	 * @return the vehiclesDao
	 */
	public VehiclesDao getVehiclesDao() {
		return vehiclesDao;
	}

	/**
	 * @param vehiclesDao
	 *            the vehiclesDao to set
	 */
	public void setVehiclesDao(VehiclesDao vehiclesDao) {
		this.vehiclesDao = vehiclesDao;
	}

	/**
	 * @return the hotelsCacheDao
	 */
	public HotelsCacheDao getHotelsCacheDao() {
		return hotelsCacheDao;
	}

	/**
	 * @param hotelsCacheDao the hotelsCacheDao to set
	 */
	public void setHotelsCacheDao(HotelsCacheDao hotelsCacheDao) {
		this.hotelsCacheDao = hotelsCacheDao;
	}

	/**
	 * @return the abeRequest
	 */
	public ABERequest getAbeRequest() {
		return abeRequest;
	}

	/**
	 * @param abeRequest
	 *            the abeRequest to set
	 */
	public void setAbeRequest(ABERequest abeRequest) {
		this.abeRequest = abeRequest;
	}

	/**
	 * @return the applicationContext
	 */
	public ABEApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * @param applicationContext
	 *            the applicationContext to set
	 */
	public void setApplicationContext(ABEApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	/**
	 * Method to execute specific dao's business method depending on the request
	 * type
	 * 
	 * @return
	 * @throws Exception
	 * 
	 * @see
	 * @since
	 */

	public ABEResponse call() throws Exception {
		this.getApplicationContextFactory().create(this.applicationContext);
		if (abeRequest instanceof FlightsRequest) {
			FlightsRequest flightsRequest = (FlightsRequest) abeRequest;
			if (flightsRequest.isPackageRequest()) {
				// call flights for packages
				if (flightsRequest.getFlightRequestType().isCharter()) {
					return charterDao.retrieveFlightsForPackage(flightsRequest);
				} else {
					return flightsDao.retrieveFlightsForPackage(flightsRequest);
				}
			} else {
				// Call flights for Flights only or Multi-destination scenarios
				// If the charter one way is requested, then it should call R/3
				// for charter flights
				if (flightsRequest.getFlightRequestType().isCharter()
						&& !flightsRequest.getTripType().isOnewayTrip()) {
					return charterDao.retrieveFlights(flightsRequest);
				} else {
					return flightsDao.retrieveFlights(flightsRequest);
				}
			}
		} else if (abeRequest instanceof HotelsRequest) {
			HotelsRequest hotelsRequest = (HotelsRequest) abeRequest;
			// retrieve hotels from grid if specials request is populated
			if(hotelsRequest.getSpecialOptions() != null) {
				return hotelsCacheDao.retrieveHotels(hotelsRequest);
			}
			if (hotelsRequest.isMultiDestinationRequest()) {
				// Call hotels for multi destinations
				return hotelDao.retrieveHotels(hotelsRequest);
			} else {
				// Call hotels for packages
				return hotelDao.retrieveHotelsForPackages(hotelsRequest);
			}
		} else if (abeRequest instanceof VehiclesRequest) {
			VehiclesRequest vehiclesRequest = (VehiclesRequest) abeRequest;
			if (vehiclesRequest.isMultiDestinationRequest()) {
				// Call vehicles for multi destinations
				return vehiclesDao.retrieveVehicles(vehiclesRequest);
			} else {
				// Call vehicles for packages
				return vehiclesDao.retrieveVehiclesForPackages(vehiclesRequest);
			}
		}
		return null;
	}

}
