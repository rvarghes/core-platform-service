/*
 * SearchCriteria.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 26, 2009  hguntupa
 * Sep 24, 2009	 hguntupa	  Added new methods for request objects
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.kcdata.abe.business.request.FlightsRequest;
import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.request.MultiDestPackagesRequest;
import com.kcdata.abe.business.request.PackagesRequest;
import com.kcdata.abe.business.request.VehiclesRequest;
import com.kcdata.abe.framework.dto.ABEDto;
import com.kcdata.abe.framework.util.DateUtils;

/**
 * Class holds search criteria objects N/A for any use case
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class SearchCriteria implements ABEDto {

	/**
	 * Field for serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -4391265988270904218L;

	/**
	 * @return the gateway
	 */
	public String getGateway() {
		return gateway;
	}

	/**
	 * @param gateway
	 *            the gateway to set
	 */
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	/**
	 * @return the departureDate
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate
	 *            the departureDate to set
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @return the promoCode
	 */
	public String getPromoCode() {
		return promoCode;
	}

	/**
	 * @param promoCode
	 *            the promoCode to set
	 */
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	/**
	 * @return the occupancy
	 */
	public Occupancy getOccupancy() {
		return occupancy;
	}

	/**
	 * @param occupancy
	 *            the occupancy to set
	 */
	public void setOccupancy(Occupancy occupancy) {
		this.occupancy = occupancy;
	}

	/**
	 * @return the destinationOptions
	 */
	public List<DestinationOptions> getDestinationOptions() {
		return destinationOptions;
	}

	/**
	 * @param destinationOptions
	 *            the destinationOptions to set
	 */
	public void setDestinationOptions(
			List<DestinationOptions> destinationOptions) {
		this.destinationOptions = destinationOptions;
	}

	/**
	 * @return the nearByGateways
	 */
	public List<String> getNearByGateways() {
		return nearByGateways;
	}

	/**
	 * @param nearByGateways
	 *            the nearByGateways to set
	 */
	public void setNearByGateways(List<String> nearByGateways) {
		this.nearByGateways = nearByGateways;
	}

	/**
	 * @return the anchorGateway
	 */
	public String getAnchorGateway() {
		return anchorGateway;
	}

	/**
	 * @param anchorGateway
	 *            the anchorGateway to set
	 */
	public void setAnchorGateway(String anchorGateway) {
		this.anchorGateway = anchorGateway;
	}

	/**
	 * @return the anchorDepartureDate
	 */
	public Date getAnchorDepartureDate() {
		return anchorDepartureDate;
	}

	/**
	 * @param anchorDepartureDate
	 *            the anchorDepartureDate to set
	 */
	public void setAnchorDepartureDate(Date anchorDepartureDate) {
		this.anchorDepartureDate = anchorDepartureDate;
	}

	/**
	 * @return the flightTripType
	 */
	public FlightTripType getFlightTripType() {
		return flightTripType;
	}

	/**
	 * @param flightTripType
	 *            the flightTripType to set
	 */
	public void setFlightTripType(FlightTripType flightTripType) {
		this.flightTripType = flightTripType;
	}

	/**
	 * @return the bookingNo
	 */
	public String getBookingNo() {
		return bookingNo;
	}

	/**
	 * @param bookingNo
	 *            the bookingNo to set
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	/**
	 * Method to retrieve flight request from SearchCriteria
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public FlightsRequest getFlightRequest() {
		if (this.getDestinationOptions() != null) {
			DestinationOptions destinationOptions = this
					.getDestinationOptions().get(0);
			if (destinationOptions == null
					|| !destinationOptions.isAirRequested()) {
				return null;
			}
			FlightsRequest flightsRequest = new FlightsRequest();
			flightsRequest.setGateway(this.getGateway());
			flightsRequest.setDestination(destinationOptions.getDestination());
			flightsRequest.setDepartureDate(this.getDepartureDate());
			flightsRequest.setFlexiDateIndicator(destinationOptions
					.isFlexiDateIndicator());
			flightsRequest.setAlternateGatewayMiles(destinationOptions.getAlternateGatewayMiles());
			flightsRequest.setNearbyAirportIndicator(destinationOptions
					.isNearbyAirportIndicator());
			flightsRequest.setNearByGateways(this.getNearByGateways());
			flightsRequest.setNearByDestinations(destinationOptions
					.getNearByDestinations());
			flightsRequest.setNoOfNights(destinationOptions.getNoOfNights());
			flightsRequest.setOccupancy(this.getOccupancy());
			if (destinationOptions.getOutboundAirOptions() != null) {
				flightsRequest.setShowAll(destinationOptions
						.getOutboundAirOptions().isShowAll());
			}
			flightsRequest.setAirRequested(true);
			flightsRequest.setHotelRequested(destinationOptions
					.isHotelRequested());
			flightsRequest.setVehicleRequested(destinationOptions
					.isVehicleRequested());
			flightsRequest.setOutboundAirOptions(destinationOptions
					.getOutboundAirOptions());
			flightsRequest.setInboundAirOptions(destinationOptions
					.getInboundAirOptions());
			flightsRequest.setDoubleConnections(destinationOptions
					.getDoubleConnections());
			flightsRequest.setNonStopFlights(destinationOptions
					.getNonStopFlights());
			flightsRequest.setMultiCarrierFlights(destinationOptions
					.getMultiCarrierFlights());
			flightsRequest.setNoOfAirOptions(destinationOptions
					.getNoOfAirOptions());
			if (flightTripType == null) {
				flightsRequest.setTripType(FlightTripType.ROUNDTRIP);
			} else {
				flightsRequest.setTripType(flightTripType);
				if (flightTripType.isAnchorTrip()) {
					flightsRequest.setAnchorGateway(anchorGateway);
					flightsRequest.setAnchorDepartureDate(anchorDepartureDate);
				}
			}
			flightsRequest.setPreferredCarriersList(destinationOptions
					.getPreferredCarriersList());
			flightsRequest.setCharterOnly(destinationOptions.isCharterOnly());
			flightsRequest.setSkedOnly(destinationOptions.isSkedOnly());
			flightsRequest.setPromoCode(promoCode);
			flightsRequest.setBookingNo(bookingNo);
			//retrieve soldout charter air
			flightsRequest.setSoldOutFlight(destinationOptions.isSoldOutFlight());
			return flightsRequest;
		}
		return null;
	}

	/**
	 * Method to retrieve Hotels request from SearchCriteria
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public HotelsRequest getHotelsRequest() {
		if (this.getDestinationOptions() != null) {
			DestinationOptions destnOption = this.getDestinationOptions()
					.get(0);
			if (!destnOption.isHotelRequested()) {
				return null;
			}
			HotelsRequest hotelsRequest = new HotelsRequest();
			hotelsRequest.setDepartureDate(this.getDepartureDate());
			hotelsRequest.setGateway(this.getGateway());
			hotelsRequest.setDestination(destnOption.getDestination());
			hotelsRequest.setNoOfNights(destnOption.getNoOfNights());
			hotelsRequest.setHotelOptions(destnOption.getHotelOptions());
			hotelsRequest.setVehicleRequested(destnOption.isVehicleRequested());
			hotelsRequest.setAirRequested(destnOption.isAirRequested());
			hotelsRequest.setHotelRequested(true);
			hotelsRequest.setOccupancy(this.getOccupancy());
			hotelsRequest.setPromoCode(promoCode);
			hotelsRequest.setBookingNo(bookingNo);
			if (destnOption.getSpecialOptions() != null)
				hotelsRequest
						.setSpecialOptions(destnOption.getSpecialOptions());
			if(destnOption.isAirRequested() && flightTripType != null && !flightTripType.isRoundTrip()) {
				hotelsRequest.setMultiDestinationRequest(true);
			}
			return hotelsRequest;
		}
		return null;
	}

	/**
	 * Method to retrieve the VehicleRequest from the SearchCriteria
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public VehiclesRequest getVehiclesRequest() {
		if (this.getDestinationOptions() != null) {
			DestinationOptions destnOption = this.getDestinationOptions()
					.get(0);
			if (!destnOption.isVehicleRequested()) {
				return null;
			}
			VehiclesRequest vehiclesRequest = new VehiclesRequest();
			vehiclesRequest.setVehicleOptions(destnOption.getVehicleOptions());
			vehiclesRequest.setAirRequested(destnOption.isAirRequested());
			vehiclesRequest.setHotelRequested(destnOption.isHotelRequested());
			vehiclesRequest.setVehicleRequested(true);
			vehiclesRequest.setGateway(this.gateway);
			vehiclesRequest.setDestination(destnOption.getDestination());

			// Prepare vehicle options
			if (vehiclesRequest.getVehicleOptions() == null) {
				VehicleOptions vehicleOptions = new VehicleOptions();
				vehicleOptions.setPickupLocation(destnOption.getDestination());
				vehicleOptions.setDropoffLocation(destnOption.getDestination());
				vehicleOptions.setPickupDateTime(this.getDepartureDate());
				Calendar cal = Calendar.getInstance();
				cal.setTime(this.getDepartureDate());
				cal.add(Calendar.DATE, destnOption.getNoOfNights());
				vehicleOptions.setDropoffDateTime(cal.getTime());
				vehiclesRequest.setVehicleOptions(vehicleOptions);
			}

			// Occupancy is not required/used at this point of time.
			// When required, can be passed to availability BAPI
			vehiclesRequest.setOccupancy(this.getOccupancy());
			vehiclesRequest.setPromoCode(promoCode);
			vehiclesRequest.setBookingNo(bookingNo);
			return vehiclesRequest;
		}
		return null;
	}

	/**
	 * Method to retrieve the package request
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public PackagesRequest getPackagesRequest() {
		if (this.getDestinationOptions() != null
				&& this.getDestinationOptions().size() > 0) {
			DestinationOptions destnOption = this.getDestinationOptions()
					.get(0);
			PackagesRequest packagesRequest = new PackagesRequest();
			packagesRequest.setAirRequested(destnOption.isAirRequested());
			packagesRequest.setHotelRequested(destnOption.isHotelRequested());
			packagesRequest.setVehicleRequested(destnOption
					.isVehicleRequested());
			packagesRequest.setPromoCode(promoCode);
			FlightsRequest flightRequest = this.getFlightRequest();
			if (flightRequest != null) {
				flightRequest.setPackageRequest(true);
				packagesRequest.setFlightsRequest(flightRequest);
			}
			HotelsRequest hotelRequest = this.getHotelsRequest();
			if (hotelRequest != null) {
				hotelRequest.setPackageRequest(true);
				packagesRequest.setHotelsRequest(hotelRequest);
			}
			VehiclesRequest vehiclesRequest = this.getVehiclesRequest();
			if (vehiclesRequest != null) {
				vehiclesRequest.setPackageRequest(true);
				packagesRequest.setVehiclesRequest(vehiclesRequest);
			}
			packagesRequest.setPromoCode(promoCode);
			packagesRequest.setBookingNo(bookingNo);
			return packagesRequest;
		}
		return null;
	}

	/**
	 * Method to retrieve the Multi-destination package request from
	 * SearchCriteria
	 * 
	 * @return MultiDestPackagesRequest
	 * 
	 * @see
	 * @since
	 */
	public MultiDestPackagesRequest getMultiDestPackageRequest() {
		if (destinationOptions == null || destinationOptions.size() < 2) {
			return null;
		}
		MultiDestPackagesRequest multiDestPackagesRequest = new MultiDestPackagesRequest();
		if (this.getDestinationOptions() != null
				&& this.getDestinationOptions().size() > 1) {
			boolean airRequested = false;
			for (DestinationOptions destinationOption : destinationOptions) {
				if (destinationOption.isAirRequested()) {
					airRequested = true;
				}
			}
			for (DestinationOptions destinationOption : destinationOptions) {
				int index = destinationOptions.indexOf(destinationOption);
				// Populate Inter-island flights request
				DestinationOptions previousDestOption = null;
				Calendar departureCal = null;
				if (index > 0) {
					previousDestOption = destinationOptions.get(index - 1);
					// Calculate the departure date/check in date at this
					// destination
					departureCal = Calendar.getInstance();
					departureCal.setTime(departureDate);
					for (byte count = 0; count < index; count++) {
						DestinationOptions tempDestOptions = destinationOptions
								.get(count);
						departureCal.add(Calendar.DATE, tempDestOptions
								.getNoOfNights());
					}
				}

				// Populate Flight requests, if they are selected
				if (destinationOption.isAirRequested()) {
					if (multiDestPackagesRequest.getFlightsRequestList() == null) {
						multiDestPackagesRequest
								.setFlightsRequestList(new ArrayList<FlightsRequest>());
					}
					FlightsRequest flightsRequest = new FlightsRequest();
					flightsRequest.setDestination(destinationOption
							.getDestination());
					flightsRequest.setFlexiDateIndicator(destinationOption
							.isFlexiDateIndicator());
					flightsRequest.setNearbyAirportIndicator(destinationOption
							.isNearbyAirportIndicator());
					flightsRequest.setNearByGateways(this.getNearByGateways());
					flightsRequest.setNearByDestinations(destinationOption
							.getNearByDestinations());
					flightsRequest.setNoOfNights(destinationOption
							.getNoOfNights());
					flightsRequest.setOccupancy(this.getOccupancy());
					if (destinationOption.getOutboundAirOptions() != null) {
						flightsRequest.setShowAll(destinationOption
								.getOutboundAirOptions().isShowAll());
					}
					flightsRequest.setAirRequested(true);
					flightsRequest.setHotelRequested(destinationOption
							.isHotelRequested());
					flightsRequest.setVehicleRequested(destinationOption
							.isVehicleRequested());
					flightsRequest.setOutboundAirOptions(destinationOption
							.getOutboundAirOptions());
					flightsRequest.setPreferredCarriersList(destinationOption
							.getPreferredCarriersList());
					flightsRequest.setDoubleConnections(destinationOption
							.getDoubleConnections());
					flightsRequest.setNonStopFlights(destinationOption
							.getNonStopFlights());
					flightsRequest.setMultiCarrierFlights(destinationOption
							.getMultiCarrierFlights());
					flightsRequest.setNoOfAirOptions(destinationOption
							.getNoOfAirOptions());
					flightsRequest.setPromoCode(this.getPromoCode());
					if (index == 0) {
						// Populate Anchor flights request
						flightsRequest.setGateway(this.getGateway());
						flightsRequest
								.setDepartureDate(this.getDepartureDate());
						flightsRequest.setInboundAirOptions(destinationOption
								.getInboundAirOptions());
						flightsRequest.setTripType(FlightTripType.ANCHOR);
						//Added for ticket no 3397925-SHOW ALL does not work for multi-island air hotel packages
						this.setFlightTripType(FlightTripType.ANCHOR);
						flightsRequest
								.setAnchorGateway(this.getAnchorGateway());
						if(this.getAnchorDepartureDate() != null) 
							flightsRequest.setAnchorDepartureDate(getAnchorDepartureDate());
						else	
							flightsRequest.setAnchorDepartureDate(this
								.getTripReturnDate());
					} else {
						// Get previoud destination option
						flightsRequest.setGateway(previousDestOption
								.getDestination());
						flightsRequest.setDepartureDate(departureCal.getTime());
						flightsRequest.setTripType(FlightTripType.ONEWAY);
						//Added for ticket no 3397925-SHOW ALL does not work for multi-island air hotel packages
						this.setFlightTripType(FlightTripType.ONEWAY);
					}
					flightsRequest.setMultiDestinationRequest(true);
					multiDestPackagesRequest.getFlightsRequestList().add(
							flightsRequest);
				}
				// Populate Hotel Requests
				if (destinationOption.isHotelRequested()) {
					if (multiDestPackagesRequest.getHotelsRequestList() == null) {
						multiDestPackagesRequest
								.setHotelsRequestList(new ArrayList<HotelsRequest>());
					}
					HotelsRequest hotelsRequest = new HotelsRequest();
					if (index == 0) {
						hotelsRequest.setDepartureDate(this.getDepartureDate());
						hotelsRequest.setGateway(this.getGateway());
					} else {
						hotelsRequest.setDepartureDate(departureCal.getTime());
						hotelsRequest.setGateway(previousDestOption
								.getDestination());
					}
					hotelsRequest.setDestination(destinationOption
							.getDestination());
					hotelsRequest.setNoOfNights(destinationOption
							.getNoOfNights());
					hotelsRequest.setHotelOptions(destinationOption
							.getHotelOptions());
					hotelsRequest.setVehicleRequested(destinationOption
							.isVehicleRequested());
					hotelsRequest.setAirRequested(airRequested);
					hotelsRequest.setHotelRequested(true);
					hotelsRequest.setOccupancy(this.getOccupancy());
					hotelsRequest.setMultiDestinationRequest(true);
					multiDestPackagesRequest.getHotelsRequestList().add(
							hotelsRequest);
				}

				// Populate Vehicle Requests
				if (destinationOption.isVehicleRequested()) {
					if (multiDestPackagesRequest.getVehiclesRequestList() == null) {
						multiDestPackagesRequest
								.setVehiclesRequestList(new ArrayList<VehiclesRequest>());
					}
					VehiclesRequest vehiclesRequest = new VehiclesRequest();
					vehiclesRequest.setVehicleOptions(destinationOption
							.getVehicleOptions());
					vehiclesRequest.setAirRequested(destinationOption
							.isAirRequested());
					vehiclesRequest.setHotelRequested(destinationOption
							.isHotelRequested());
					vehiclesRequest.setVehicleRequested(true);
					vehiclesRequest.setDestination(destinationOption
							.getDestination());
					// Prepare vehicle options
					if (vehiclesRequest.getVehicleOptions() == null) {
						VehicleOptions vehicleOptions = new VehicleOptions();
						vehicleOptions.setPickupLocation(destinationOption
								.getDestination());
						vehicleOptions.setDropoffLocation(destinationOption
								.getDestination());
						if (index == 0) {
							vehicleOptions.setPickupDateTime(this
									.getDepartureDate());
							Calendar cal = Calendar.getInstance();
							cal.setTime(this.getDepartureDate());
							cal.add(Calendar.DATE, destinationOption
									.getNoOfNights());
							vehicleOptions.setDropoffDateTime(cal.getTime());
							vehiclesRequest.setGateway(gateway);
						} else {
							vehicleOptions.setPickupDateTime(departureCal
									.getTime());
							departureCal.add(Calendar.DATE, destinationOption
									.getNoOfNights());
							vehicleOptions.setDropoffDateTime(departureCal
									.getTime());
							vehiclesRequest.setGateway(previousDestOption
									.getDestination());
						}
						vehiclesRequest.setVehicleOptions(vehicleOptions);
					}

					// Occupancy is not required/used at this point of time.
					// When required, can be passed to availability BAPI
					vehiclesRequest.setOccupancy(this.getOccupancy());
					vehiclesRequest.setMultiDestinationRequest(true);
					multiDestPackagesRequest.getVehiclesRequestList().add(
							vehiclesRequest);
				}
			}
		}
		multiDestPackagesRequest.setPromoCode(promoCode);
		multiDestPackagesRequest.setBookingNo(bookingNo);
		return multiDestPackagesRequest;
	}

	/**
	 * Method to get the return date of the vacation
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public Date getTripReturnDate() {
		if (this.getDestinationOptions() != null
				&& this.getDestinationOptions().size() > 0) {
			Date returnDate = new Date();
			byte totalTripDuration = 0;
			for (DestinationOptions destnOption : destinationOptions) {
				totalTripDuration += destnOption.getNoOfNights();
			}
			returnDate = DateUtils.addDaysToDate(this.departureDate,
					totalTripDuration);
			return returnDate;
		}
		return null;
	}
	
	/**
	 * Method to get the trip duration
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public byte getTripDuration() {
		if (this.getDestinationOptions() != null
				&& this.getDestinationOptions().size() > 0) {
			byte totalTripDuration = 0;
			for (DestinationOptions destnOption : destinationOptions) {
				totalTripDuration += destnOption.getNoOfNights();
			}
			return totalTripDuration;
		}
		return 0;
	}	

	/**
	 * Method to get the return date of the vacation
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public String getTripReturnLocation() {
		if (this.getDestinationOptions() != null
				&& this.getDestinationOptions().size() > 0) {
			return destinationOptions.get(destinationOptions.size() - 1)
					.getDestination();
		}
		return null;
	}

	/**
	 * Method to clone the object
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */
	public Object clone() throws CloneNotSupportedException {
		SearchCriteria searchCriteria = (SearchCriteria) super.clone();
		if (destinationOptions != null) {
			ArrayList<DestinationOptions> dOptionsList = new ArrayList<DestinationOptions>();
			for (DestinationOptions dOptions : dOptionsList) {
				dOptionsList.add((DestinationOptions) dOptions.clone());
			}
			searchCriteria.destinationOptions = dOptionsList;
		}
		if (occupancy != null) {
			searchCriteria.occupancy = (Occupancy) occupancy.clone();
		}
		return searchCriteria;
	}

	public boolean isFilterSpecials() {
		return filterSpecials;
	}

	public void setFilterSpecials(boolean filterSpecials) {
		this.filterSpecials = filterSpecials;
	}

	private String gateway;
	private Date departureDate;
	private String promoCode;
	private Occupancy occupancy;
	private List<DestinationOptions> destinationOptions;
	private List<String> nearByGateways;
	private String anchorGateway;
	private Date anchorDepartureDate;
	private FlightTripType flightTripType;
	private String bookingNo;
	private boolean filterSpecials;
	
	private boolean changeFlightOnly;
	
	private Itinerary itineraryChangeFlight;
	
	private boolean shopMoreIndicator;
	private boolean checkCharterOfferFlight;
	/**
	 * @return the changeFlightOnly
	 */
	public boolean isChangeFlightOnly() {
		return changeFlightOnly;
	}

	/**
	 * @param changeFlightOnly the changeFlightOnly to set
	 */
	public void setChangeFlightOnly(boolean changeFlightOnly) {
		this.changeFlightOnly = changeFlightOnly;
	}

	/**
	 * @return the itineraryChangeFlight
	 */
	public Itinerary getItineraryChangeFlight() {
		return itineraryChangeFlight;
	}

	/**
	 * @param itineraryChangeFlight the itineraryChangeFlight to set
	 */
	public void setItineraryChangeFlight(Itinerary itineraryChangeFlight) {
		this.itineraryChangeFlight = itineraryChangeFlight;
	}

	/**
	 * @return the shopMoreIndicator
	 */
	public boolean isShopMoreIndicator() {
		return shopMoreIndicator;
	}

	/**
	 * @param shopMoreIndicator the shopMoreIndicator to set
	 */
	public void setShopMoreIndicator(boolean shopMoreIndicator) {
		this.shopMoreIndicator = shopMoreIndicator;
	}

	/**
	 * @return the checkCharterOfferFlight
	 */
	public boolean isCheckCharterOfferFlight() {
		return checkCharterOfferFlight;
	}

	/**
	 * @param checkCharterOfferFlight the checkCharterOfferFlight to set
	 */
	public void setCheckCharterOfferFlight(boolean checkCharterOfferFlight) {
		this.checkCharterOfferFlight = checkCharterOfferFlight;
	}
		
}