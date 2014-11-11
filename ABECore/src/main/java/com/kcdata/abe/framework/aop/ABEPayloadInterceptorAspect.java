/*
 * ABEPayloadInterceptorAspect.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jan 28, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.framework.aop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.kcdata.abe.application.command.BookItineraryCommand;
import com.kcdata.abe.application.command.PriceItineraryCommand;
import com.kcdata.abe.application.command.RetrieveFlightsCommand;
import com.kcdata.abe.application.command.RetrieveHotelsCommand;
import com.kcdata.abe.application.command.RetrieveInsuranceCommand;
import com.kcdata.abe.application.command.RetrievePackagesCommand;
import com.kcdata.abe.application.command.RetrieveServicesCommand;
import com.kcdata.abe.application.command.RetrieveVehiclesCommand;
import com.kcdata.abe.application.command.SaveItineraryChangeCommand;
import com.kcdata.abe.framework.aop.interceptor.ABEInterceptorBase;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.logging.ABELogger;
import com.thoughtworks.xstream.XStream;

/**
 * Class intercepts all the calls from FLEX to CommandHandler objects for payload logging 
 * N/A specific usecase
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class ABEPayloadInterceptorAspect extends ABEInterceptorBase {

	/**
	 * Logger Initialization
	 */
	ABELogger logger = ABELogger
			.getLogger(ABEPayloadInterceptorAspect.class);

	/**
	 * "Before" advise method to prepare & log request payload
	 * 
	 * @param command
	 * 
	 * @see
	 * @since
	 */
	public void requestPayloadHandler(ABECommand command) {
		if(command != null) {
			XStream xstream = new XStream();
			xstream.setMode(XStream.NO_REFERENCES);
			// Replace fully qualified names of classes with readable XML names
			xstream.alias("SearchCriteria", com.kcdata.abe.data.dto.SearchCriteria.class);
			xstream.alias("Occupancy", com.kcdata.abe.data.dto.Occupancy.class);
			xstream.alias("DestinationOptions", com.kcdata.abe.data.dto.DestinationOptions.class);
			xstream.alias("AirOptions", com.kcdata.abe.data.dto.AirOptions.class);
			xstream.alias("HotelOptions", com.kcdata.abe.data.dto.HotelOptions.class);
			xstream.alias("VehicleOptions", com.kcdata.abe.data.dto.VehicleOptions.class);
			xstream.alias("TimeOfDay", com.kcdata.abe.data.dto.TimeOfDay.class);
			xstream.alias("CabinType", com.kcdata.abe.data.dto.CabinType.class);
			xstream.alias("FlightRequestType", com.kcdata.abe.data.dto.FlightRequestType.class);
			xstream.alias("FlightTripType", com.kcdata.abe.data.dto.FlightTripType.class);
			xstream.alias("Occupancy", com.kcdata.abe.data.dto.Occupancy.class);
			xstream.alias("Passenger", com.kcdata.abe.data.dto.Passenger.class);
			xstream.alias("AgeCode", com.kcdata.abe.data.dto.AgeCode.class);
			xstream.alias("Carrier", com.kcdata.abe.data.dto.Carrier.class);
			xstream.alias("ResortArea", com.kcdata.abe.data.dto.ResortArea.class);
			xstream.alias("VendorService", com.kcdata.abe.data.dto.VendorService.class);
			xstream.alias("Amenity", com.kcdata.abe.data.dto.Amenity.class);
			xstream.alias("PackagesRequest", com.kcdata.abe.business.request.PackagesRequest.class);
			xstream.alias("FlightsRequest", com.kcdata.abe.business.request.FlightsRequest.class);
			xstream.alias("HotelsRequest", com.kcdata.abe.business.request.HotelsRequest.class);
			xstream.alias("VehiclesRequest", com.kcdata.abe.business.request.VehiclesRequest.class);
			xstream.alias("Destination", com.kcdata.abe.data.dto.Destination.class);
			xstream.alias("TripFlight",
					com.kcdata.abe.data.dto.TripFlight.class);
			xstream.alias("FlightSegment",
					com.kcdata.abe.data.dto.FlightSegment.class);
			xstream.alias("RoomCategory",
					com.kcdata.abe.data.dto.RoomCategory.class);
			xstream.alias("RoomPrice", com.kcdata.abe.data.dto.RoomPrice.class);
			xstream.alias("Package", com.kcdata.abe.data.dto.Package.class);
			xstream.alias("Itinerary", com.kcdata.abe.data.dto.Itinerary.class);
			xstream.alias("ItineraryCharge", com.kcdata.abe.data.dto.ItineraryCharge.class);
			xstream.alias("ItineraryPrice", com.kcdata.abe.data.dto.ItineraryPrice.class);
			xstream.alias("BookingHeader", com.kcdata.abe.data.dto.BookingHeader.class);
			xstream.alias("BookingLockDetails", com.kcdata.abe.data.dto.BookingLockDetails.class);
			xstream.alias("Agent", com.kcdata.abe.data.dto.Agent.class);
			xstream.alias("Address", com.kcdata.abe.data.dto.Address.class);
			xstream.alias("GuestInfo", com.kcdata.abe.data.dto.GuestInfo.class);
			xstream.alias("GuestPriceBreakup", com.kcdata.abe.data.dto.GuestPriceBreakup.class);
			xstream.alias("Vehicle", com.kcdata.abe.data.dto.Vehicle.class);
			xstream.alias("VehicleClass", com.kcdata.abe.data.dto.VehicleClass.class);
			xstream.alias("VehicleCategory", com.kcdata.abe.data.dto.VehicleCategory.class);
			xstream.alias("Insurance", com.kcdata.abe.data.dto.Insurance.class);
			xstream.alias("OpsAlert", com.kcdata.abe.data.dto.OpsAlert.class);
			xstream.alias("Service", com.kcdata.abe.data.dto.Service.class);
			xstream.alias("MultiDestinationPackage", com.kcdata.abe.data.dto.MultiDestinationPackage.class);
			xstream.alias("BookingSearchResponse", com.kcdata.abe.business.response.BookingSearchResponse.class);
			xstream.alias("BookingResult", com.kcdata.abe.data.dto.BookingResult.class);
			xstream.alias("PaymentInformation", com.kcdata.abe.data.dto.PaymentInformation.class);
			xstream.alias("PaymentHistory", com.kcdata.abe.data.dto.PaymentHistoryInfo.class);
			xstream.alias("CreditCard", com.kcdata.abe.data.dto.CreditCard.class);
			xstream.alias("GuaranteedCheck", com.kcdata.abe.data.dto.GuaranteedCheck.class);
			xstream.alias("MoneyTransfer", com.kcdata.abe.data.dto.MoneyTransfer.class);
			
			try {
				if(command instanceof RetrieveFlightsCommand ) {
						RetrieveFlightsCommand flightsCommand = (RetrieveFlightsCommand) command;
						FileWriter fileWriter = new FileWriter("FlightsRequestPayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(xstream.toXML(flightsCommand.getSearchCriteria()));
						bw.close();
				} else if (command instanceof RetrieveHotelsCommand) {
						RetrieveHotelsCommand hotelsCommand = (RetrieveHotelsCommand) command;
						FileWriter fileWriter = new FileWriter("HotelsRequestPayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(xstream.toXML(hotelsCommand.getSearchCriteria()));
						bw.close();
				} else if (command instanceof RetrievePackagesCommand) {
						RetrievePackagesCommand packageCommand = (RetrievePackagesCommand) command;
						FileWriter fileWriter = new FileWriter("PackagesRequestPayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(xstream.toXML(packageCommand.getSearchCriteria()));
						bw.close();
				} else if (command instanceof RetrieveVehiclesCommand) {
						RetrieveVehiclesCommand vehiclesCommand = (RetrieveVehiclesCommand) command;
						FileWriter fileWriter = new FileWriter("VehiclesRequestPayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(xstream.toXML(vehiclesCommand.getSearchCriteria()));
						bw.close();
				} else if (command instanceof RetrieveServicesCommand) {
						RetrieveServicesCommand servicesCommand = (RetrieveServicesCommand) command;
						FileWriter fileWriter = new FileWriter("SupplementsRequestPayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(xstream.toXML(servicesCommand.getItinerary()));
						bw.close();
				} else if (command instanceof RetrieveInsuranceCommand) {
						RetrieveInsuranceCommand insuranceCommand = (RetrieveInsuranceCommand) command;
						FileWriter fileWriter = new FileWriter("InsuranceRequestPayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(xstream.toXML(insuranceCommand.getItinerary()));
						bw.close();
				} else if (command instanceof PriceItineraryCommand) {
						PriceItineraryCommand pricingCommand = (PriceItineraryCommand) command;
						FileWriter fileWriter = new FileWriter("ItineraryPricingRequestPayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(xstream.toXML(pricingCommand.getItinerary()));
						bw.close();
				} else if (command instanceof BookItineraryCommand) {
						BookItineraryCommand bookingCommand = (BookItineraryCommand) command;
						FileWriter fileWriter = new FileWriter("BookingRequestPayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(xstream.toXML(bookingCommand.getItinerary()));
						bw.close();
				} else if (command instanceof SaveItineraryChangeCommand) {
						SaveItineraryChangeCommand cancelCommand = (SaveItineraryChangeCommand) command;
						FileWriter fileWriter = new FileWriter("CancelBookingRequestPayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(xstream.toXML(cancelCommand.getItinerary()));
						bw.close();
				}
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}						
		}
	}

	/**
	 * "After" advise method to prepare & log response payload
	 * 
	 * @param command
	 * 
	 * @see
	 * @since
	 */	
	public Object responsePayloadHandler(ABECommand command) {
		if(command != null) {
			XStream xstream = new XStream();
			xstream.setMode(XStream.NO_REFERENCES);
			// Replace fully qualified names of classes with readable XML names
			xstream.alias("FlightsResponse", com.kcdata.abe.business.response.FlightsResponse.class);
			xstream.alias("TripFlight", com.kcdata.abe.data.dto.TripFlight.class);
			xstream.alias("Flight", com.kcdata.abe.data.dto.Flight.class);
			xstream.alias("FlightTripType", com.kcdata.abe.data.dto.FlightTripType.class);
			xstream.alias("FlightType", com.kcdata.abe.data.dto.FlightType.class);
			xstream.alias("FlightRequestType", com.kcdata.abe.data.dto.FlightRequestType.class);
			xstream.alias("FlightStatus", com.kcdata.abe.data.dto.FlightStatus.class);
			xstream.alias("FlightSegment", com.kcdata.abe.data.dto.FlightSegment.class);
			xstream.alias("Occupancy", com.kcdata.abe.data.dto.Occupancy.class);
			xstream.alias("Carrier", com.kcdata.abe.data.dto.Carrier.class);
			xstream.alias("TimeOfDay", com.kcdata.abe.data.dto.TimeOfDay.class);
			xstream.alias("CabinType", com.kcdata.abe.data.dto.CabinType.class);
			xstream.alias("SearchCriteria", com.kcdata.abe.data.dto.SearchCriteria.class);
			xstream.alias("PaxTypePriceBreakup", com.kcdata.abe.data.dto.PaxTypePriceBreakup.class);
			xstream.alias("Price", com.kcdata.abe.data.dto.Price.class);
			xstream.alias("PaxTypeBasePrices", com.kcdata.abe.data.dto.PaxTypeBasePrices.class);
			xstream.alias("Passenger", com.kcdata.abe.data.dto.Passenger.class);
			xstream.alias("AgeCode", com.kcdata.abe.data.dto.AgeCode.class);
			xstream.alias("AirOptions", com.kcdata.abe.data.dto.AirOptions.class);
			xstream.alias("DestinationOptions", com.kcdata.abe.data.dto.DestinationOptions.class);
			xstream.alias("HotelsResponse", com.kcdata.abe.business.response.HotelsResponse.class);
			xstream.alias("Destination", com.kcdata.abe.data.dto.Destination.class);
			xstream.alias("DestinationService", com.kcdata.abe.data.dto.DestinationService.class);
			xstream.alias("Hotel", com.kcdata.abe.data.dto.Hotel.class);
			xstream.alias("HotelOptions", com.kcdata.abe.data.dto.HotelOptions.class);
			xstream.alias("RoomCategory",
					com.kcdata.abe.data.dto.RoomCategory.class);
			xstream.alias("RoomPrice", com.kcdata.abe.data.dto.RoomPrice.class);
			xstream.alias("ResortArea", com.kcdata.abe.data.dto.ResortArea.class);
			xstream.alias("VendorService", com.kcdata.abe.data.dto.VendorService.class);
			xstream.alias("Amenity", com.kcdata.abe.data.dto.Amenity.class);
			xstream.alias("DestinationOptions", com.kcdata.abe.data.dto.DestinationOptions.class);
			xstream.alias("PackagesResponse", com.kcdata.abe.business.response.PackagesResponse.class);
			xstream.alias("Package", com.kcdata.abe.data.dto.Package.class);
			xstream.alias("VehiclesResponse", com.kcdata.abe.business.response.VehiclesResponse.class);
			xstream.alias("Vehicle", com.kcdata.abe.data.dto.Vehicle.class);
			xstream.alias("VehicleVendorDetails", com.kcdata.abe.data.dto.VehicleVendorDetails.class);
			xstream.alias("VehicleOptions", com.kcdata.abe.data.dto.VehicleOptions.class);
			xstream.alias("VehicleClass", com.kcdata.abe.data.dto.VehicleClass.class);
			xstream.alias("VehicleCategory", com.kcdata.abe.data.dto.VehicleCategory.class);
			xstream.alias("ServicesResponse", com.kcdata.abe.business.response.ServicesResponse.class);
			xstream.alias("ServiceGroup", com.kcdata.abe.data.dto.ServiceGroup.class);
			xstream.alias("Service", com.kcdata.abe.data.dto.Service.class);
			xstream.alias("InsuranceResponse", com.kcdata.abe.business.response.InsuranceResponse.class);
			xstream.alias("InsuranceGroup", com.kcdata.abe.data.dto.InsuranceGroup.class);
			xstream.alias("Insurance", com.kcdata.abe.data.dto.Insurance.class);
			xstream.alias("InsuranceGuestAllocation", com.kcdata.abe.data.dto.InsuranceGuestAllocation.class);
			xstream.alias("BookingSearchResponse", com.kcdata.abe.business.response.BookingSearchResponse.class);
			xstream.alias("BookingResult", com.kcdata.abe.data.dto.BookingResult.class);
			xstream.alias("Itinerary", com.kcdata.abe.data.dto.Itinerary.class);
			xstream.alias("ItineraryCharge", com.kcdata.abe.data.dto.ItineraryCharge.class);
			xstream.alias("ItineraryPrice", com.kcdata.abe.data.dto.ItineraryPrice.class);
			xstream.alias("BookingHeader", com.kcdata.abe.data.dto.BookingHeader.class);
			xstream.alias("BookingLockDetails", com.kcdata.abe.data.dto.BookingLockDetails.class);
			xstream.alias("Agent", com.kcdata.abe.data.dto.Agent.class);
			xstream.alias("Address", com.kcdata.abe.data.dto.Address.class);
			xstream.alias("GuestInfo", com.kcdata.abe.data.dto.GuestInfo.class);
			xstream.alias("MultiDestnPackage", com.kcdata.abe.data.dto.MultiDestinationPackage.class);
			xstream.alias("PaymentInformation", com.kcdata.abe.data.dto.PaymentInformation.class);
			xstream.alias("PaymentHistory", com.kcdata.abe.data.dto.PaymentHistoryInfo.class);
			xstream.alias("CreditCard", com.kcdata.abe.data.dto.CreditCard.class);
			xstream.alias("GuaranteedCheck", com.kcdata.abe.data.dto.GuaranteedCheck.class);
			xstream.alias("MoneyTransfer", com.kcdata.abe.data.dto.MoneyTransfer.class);
			xstream.alias("ItineraryPricingResponse", com.kcdata.abe.business.response.ItineraryPricingResponse.class);
			xstream.alias("ItineraryCancellationRules", com.kcdata.abe.data.dto.ItineraryCancellationRules.class);
			xstream.alias("OpsAlert", com.kcdata.abe.data.dto.OpsAlert.class);
			xstream.alias("GuestPriceBreakup", com.kcdata.abe.data.dto.GuestPriceBreakup.class);
						
			try {			
				if(command instanceof RetrieveFlightsCommand ) {
						RetrieveFlightsCommand flightsCommand = (RetrieveFlightsCommand) command;
						FileWriter fileWriter = new FileWriter("FlightsResponsePayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(xstream.toXML(flightsCommand.getFlights()));
						bw.close();
				} else if (command instanceof RetrieveHotelsCommand) {
						RetrieveHotelsCommand hotelsCommand = (RetrieveHotelsCommand) command;
						FileWriter fileWriter = new FileWriter("HotelsResponsePayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						StringBuffer sb = new StringBuffer(xstream.toXML(hotelsCommand.getHotels()));
						sb.append(xstream.toXML(hotelsCommand.getDestinations()));
						bw.write(sb.toString());
						bw.close();
				} else if (command instanceof RetrievePackagesCommand) {
						RetrievePackagesCommand packageCommand = (RetrievePackagesCommand) command;
						FileWriter fileWriter = new FileWriter("PackagesResponsePayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(xstream.toXML(packageCommand.getAvailablePackage()));
						bw.close();
				} else if (command instanceof RetrieveVehiclesCommand) {
						RetrieveVehiclesCommand vehiclesCommand = (RetrieveVehiclesCommand) command;
						FileWriter fileWriter = new FileWriter("VehiclesResponsePayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						StringBuffer sb = new StringBuffer(xstream.toXML(vehiclesCommand.getVehicles()));
						sb.append(xstream.toXML(vehiclesCommand.getVendorDetails()));
						bw.write(sb.toString());
						bw.close();
				} else if (command instanceof RetrieveServicesCommand) {
						RetrieveServicesCommand servicesCommand = (RetrieveServicesCommand) command;
						FileWriter fileWriter = new FileWriter("SupplementsResponsePayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(xstream.toXML(servicesCommand.getServiceGroups()));
						bw.close();
				} else if (command instanceof RetrieveInsuranceCommand) {
						RetrieveInsuranceCommand insuranceCommand = (RetrieveInsuranceCommand) command;
						FileWriter fileWriter = new FileWriter("InsuranceResponsePayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(xstream.toXML(insuranceCommand.getInsuranceGroupList()));
						bw.close();
				} else if (command instanceof PriceItineraryCommand) {
						PriceItineraryCommand pricingCommand = (PriceItineraryCommand) command;
						FileWriter fileWriter = new FileWriter("ItineraryPricingResponsePayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(xstream.toXML(pricingCommand.getItinerary()));
						bw.close();
				} else if (command instanceof BookItineraryCommand) {
						BookItineraryCommand bookingCommand = (BookItineraryCommand) command;
						FileWriter fileWriter = new FileWriter("BookingResponsePayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(xstream.toXML(bookingCommand.getItinerary()));
						bw.close();
				} else if (command instanceof SaveItineraryChangeCommand) {
						SaveItineraryChangeCommand cancelCommand = (SaveItineraryChangeCommand) command;
						FileWriter fileWriter = new FileWriter("CancelBookingResponsePayload.xml");
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(xstream.toXML(cancelCommand.getItinerary()));
						bw.close();
				}
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}			
		}
		return command;
	}

}
