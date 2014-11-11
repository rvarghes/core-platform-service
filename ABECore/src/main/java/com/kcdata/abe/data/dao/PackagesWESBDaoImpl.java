/*
 * PackagesSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 23, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.namespace.QName;

import com.kcdata.abe.bapi.Y_Bapi_Room_Show_All_Pricing_Input;
import com.kcdata.abe.bapi.Y_Bapi_Room_Show_All_Pricing_Output;
import com.kcdata.abe.bapi.Y_Ota_Package_Availability_Input;
import com.kcdata.abe.bapi.Y_Ota_Package_Availability_Output;
import com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType;
import com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType;
import com.kcdata.abe.bapi.Yst_Bapi_Req_Pkg_HdrType;
import com.kcdata.abe.bapi.Yst_Bapi_Show_AllType;
import com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType;
import com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType;
import com.kcdata.abe.bapi.util.Yst_Bapi_All_PaxtypeType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_Orig_DestType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Veh_AvailabilityType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List;
import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.request.PackagesRequest;
import com.kcdata.abe.business.request.VehiclesRequest;
import com.kcdata.abe.business.response.AllPriceBreakUpResponse;
import com.kcdata.abe.business.response.PackagesResponse;
import com.kcdata.abe.business.service.WesbProxyService;
import com.kcdata.abe.data.dto.AllPricesBreakUp;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.PaxTypePriceBreakup;
import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.RoomPrice;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.data.util.FlightConvertUtils;
import com.kcdata.abe.data.util.HotelConvertUtils;
import com.kcdata.abe.data.util.VehicleConvertUtils;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.request.ABERequest;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.resortarea.v1.ResortArea;
import com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelsavailabilityresponse.v1.HotelsAvailabilityResponse;
import com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packageservicebs.v1.PackageServiceExport_PackageServiceBSHttpPortProxy;

/**
 * Packages DAO implementation class Retrieve Packages usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class PackagesWESBDaoImpl extends ABESAPDaoBase implements
		WesbPackagesDAO {

	/**
	 * Instance of Logger
	 */
	final ABELogger logger = ABELogger
			.getLogger(com.kcdata.abe.data.dao.PackagesWESBDaoImpl.class);

	private Properties airportsTimeZones;
	private Properties airlineNames;
	private WesbProxyService proxyService;
	
	

	/**
	 * @return the proxyService
	 */
	public WesbProxyService getProxyService() {
		return proxyService;
	}

	/**
	 * @param proxyService the proxyService to set
	 */
	public void setProxyService(WesbProxyService proxyService) {
		this.proxyService = proxyService;
	}

	/**
	 * @return the aiportsTimeZones
	 */
	public Properties getAirportsTimeZones() {
		return airportsTimeZones;
	}

	/**
	 * @param aiportsTimeZones
	 *            the aiportsTimeZones to set
	 */
	public void setAirportsTimeZones(Properties airportsTimeZones) {
		this.airportsTimeZones = airportsTimeZones;
	}

	/**
	 * @return the airlineNames
	 */
	public Properties getAirlineNames() {
		return airlineNames;
	}

	/**
	 * @param airlineNames
	 *            the airlineNames to set
	 */
	public void setAirlineNames(Properties airlineNames) {
		this.airlineNames = airlineNames;
	}

	/**
	 * Method to retrieve the cars for packages
	 * 
	 * @param packagesRequest
	 *            - request for packages
	 * @return PackagesResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public PackagesResponse changeVehicles(PackagesRequest packagesRequest) {
		PackagesResponse packagesResponse = new PackagesResponse();

		// set the Request package back to response
		packagesResponse.setAvailablePackage(packagesRequest
				.getAvailablePackage());

		// Create the input structure for BAPI
		Y_Ota_Package_Availability_Input bapiInput = new Y_Ota_Package_Availability_Input();

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// Prepare & set header structures
		bapiInput.setIm_Req_Hdr(this.preparePackageHeader(packagesRequest,
				false, false, true));

		// Prepare & set flights
		this.prepareFlightsInput(packagesRequest, bapiInput, false, false, true);

		// Prepare & set hotels
		this.prepareHotelsInput(packagesRequest, bapiInput, false, false, true);

		// Prepare & set cars
		this.prepareVehcilesInput(packagesRequest, bapiInput, false, false,
				true);

		// Execute the BAPI
		Y_Ota_Package_Availability_Output bapiOutput = (Y_Ota_Package_Availability_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Ota_Package_Availability", bapiInput);

		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				packagesResponse);

		// Check for any business errors from BAPI
		if (packagesResponse.isBusinessErrorOccurred()) {
			return packagesResponse;
		}

		// Process the cars response
		packagesResponse.getAvailablePackage().setVehicleOptions(
				VehicleConvertUtils.parseVehicleResponse(
						bapiOutput.get_as_listIt_Veh_Availability(),
						packagesRequest.getVehiclesRequest()));

		return packagesResponse;
	}

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
	public PackagesResponse changeFlights(PackagesRequest packagesRequest) {
		PackagesResponse packagesResponse = new PackagesResponse();

		// set the Request package back to response
		packagesResponse.setAvailablePackage(packagesRequest
				.getAvailablePackage());

		// Create the input structure for BAPI
		Y_Ota_Package_Availability_Input bapiInput = new Y_Ota_Package_Availability_Input();

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// Prepare & set header structures
		bapiInput.setIm_Req_Hdr(this.preparePackageHeader(packagesRequest,
				true, false, false));

		// Prepare & set flights
		this.prepareFlightsInput(packagesRequest, bapiInput, true, false, false);

		// Prepare & set hotels
		this.prepareHotelsInput(packagesRequest, bapiInput, true, false, false);

		// Prepare & set cars
		this.prepareVehcilesInput(packagesRequest, bapiInput, true, false,
				false);

		// Execute the BAPI
		Y_Ota_Package_Availability_Output bapiOutput = (Y_Ota_Package_Availability_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Ota_Package_Availability", bapiInput);

		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				packagesResponse);

		// Check for any business errors from BAPI
		if (packagesResponse.isBusinessErrorOccurred()) {
			return packagesResponse;
		}
	/*Code commented for revocation of 3620608 on 04/05/2013*/
		// Process the Flights structures
		/*packagesResponse.getAvailablePackage().setFlightOptions(
				FlightConvertUtils.convertFlightsResponse(
						bapiOutput.get_as_listEx_Ota_Flt_Segments_Cpy(),
						bapiOutput.get_as_listIt_Ota_Flt_Orig_Dest(),
						packagesRequest.getFlightsRequest(), airportsTimeZones,
						airlineNames));*/
		packagesResponse.getAvailablePackage().setFlightOptions(
				FlightConvertUtils.convertFlightsResponse(
						bapiOutput.get_as_listIt_Ota_Flt_Segments(),
						bapiOutput.get_as_listIt_Ota_Flt_Orig_Dest(),
						packagesRequest.getFlightsRequest(), airportsTimeZones,
						airlineNames));

		return packagesResponse;
	}
	
	

	private PackagesResponse retrievePackageAvailability(
			PackagesRequest packagesRequest, Map<String,HBSiHotelInfo> hbsiHotelList) {
		PackagesResponse packagesResponse = new PackagesResponse();

		com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packageavailabilityrequest.v1.PackageAvailabilityRequest packageAvailabilityRequest = this
				.getPackageAvailabilityRequestReq(packagesRequest);

		com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packageavailabilityresponse.v1.PackageAvailabilityResponse packageAvailabilityResponse = null;

		//Create one more response object which will have modified room categories
		com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packageavailabilityresponse.v1.PackageAvailabilityResponse wesbPackageAvailabilityResponse = new com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packageavailabilityresponse.v1.PackageAvailabilityResponse();
		try {

			/*proxyService new PackageServiceExport_PackageServiceBSHttpPortProxy(
					new URL(
							"http://172.22.50.211:9080/KCDEBBusSrv_PackageService_v1Web/sca/PackageServiceExport/WEB-INF/wsdl/KCDEBBusSrv_PackageService_v1_PackageServiceExport.wsdl"),
					new QName(
							"http://www.partners.kcdataservices.com/KCDEBSrvLib_Package/interfaces/PackageServiceBS/v1",
							"PackageServiceExport_PackageServiceBSHttpService"));*/
			
			

			/*
			 * PackageServiceExport_PackageServiceBSHttpPortProxy proxyService =
			 * new PackageServiceExport_PackageServiceBSHttpPortProxy( new URL(
			 * "file:///C:/RADWorkSpace/Projects/ABE/PackageHotelServiceClient/src/KCDEBBusSrv_PackageService_v1_PackageServiceExport.wsdl"
			 * ), new QName(
			 * "http://www.partners.kcdataservices.com/KCDEBSrvLib_Package/interfaces/PackageServiceBS/v1"
			 * , "PackageServiceExport_PackageServiceBSHttpService"));
			 * 
			 * proxyService._getDescriptor().setEndpoint(
			 * "http://172.22.50.211:9080/KCDEBBusSrv_PackageService_v1Web/sca/PackageServiceExport"
			 * );
			 */

			packageAvailabilityResponse = proxyService.getPackageProxyService().retrievePackages(packageAvailabilityRequest);
		}  catch (Exception e) {

		}

		List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel> hotelResponseList = new ArrayList<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel>();
		if (packageAvailabilityResponse != null && hbsiHotelList != null) {
			List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel> hotelList = packageAvailabilityResponse
					.getHotelList();

			for (int i = 0; i < hotelList.size(); i++) {
				com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel hotel = hotelList
						.get(i);

				if (hotel.getHotelCode() != null
						&& hbsiHotelList.containsKey(hotel.getHotelCode())) {
					
					HBSiHotelInfo hbsiHotelInfo = new HBSiHotelInfo();
					

					List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory> roomCategoryList = hotel
							.getRoomCategories();

					int sizeOfRoomCategory = roomCategoryList.size();
						
					hbsiHotelInfo = hbsiHotelList.get(hotel.getHotelCode());
					for (int j = 0; j < sizeOfRoomCategory; j++) {

						com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory roomCategory = roomCategoryList
								.get(j);
						hotel.getRoomCategories().remove(j);
						if(hbsiHotelInfo!=null)
							roomCategory.setRoomTypeCode(hbsiHotelInfo.getHotelMaterialId());
						
						hotel.getRoomCategories().add(j,roomCategory);

					}
					if(hbsiHotelInfo!=null)
					{
						
						//setting the hotel Code as Vendor code
						hotel.setHotelCode(hbsiHotelInfo.getHotelVendorCode());
						
					hotel.getDisplayRoomCategory().setRoomTypeCode(hbsiHotelInfo.getHotelMaterialId());
					if(hotel.getAppleRating()==null || hotel.getAppleRating().equals(""))
						hotel.setAppleRating(hbsiHotelInfo.getAppleRating());
					if(hotel.getResortArea()==null)
					{
						ResortArea resortAreaBO = new ResortArea();
						resortAreaBO.setResortAreaCode(hbsiHotelInfo.getResortAreaName());
						resortAreaBO.setResortAreaName(hbsiHotelInfo.getResortAreaName());
						hotel.setResortArea(resortAreaBO);
						hotel.setHotelChain(hbsiHotelInfo.getResortAreaCode());
					}
					}
										
					hotelResponseList.add(hotel);

				}
				else
				{
					
					
					hotelResponseList.add(hotel);
					
				}

			}
		}

		if(hotelResponseList!=null)
		{
			
			for(int i=0;i<hotelResponseList.size();i++)
			{
				wesbPackageAvailabilityResponse.getHotelList().add(hotelResponseList.get(i));
			}
		}
		
		/*if (packageAvailabilityResponse != null) {
			packagesResponse = this
					.getPackagesResponse(packageAvailabilityResponse);
		}*/

		if (wesbPackageAvailabilityResponse != null) {
			packagesResponse = this
					.getPackagesResponse(wesbPackageAvailabilityResponse);
		}
		return packagesResponse;
	}

	/**
	 * Method to retrieve HBSi hotels
	 * 
	 * @param packagesRequest
	 * @return packagesResponse
	 * 
	 */
	public PackagesResponse wesbRetrievePackages(
			PackagesRequest packagesRequest, Map<String,HBSiHotelInfo> hbsiHotelList) {
		PackagesResponse packagesResponse = this.retrievePackageAvailability(
				packagesRequest, hbsiHotelList);

		return packagesResponse;
	}

	/**
	 * Method to chnage the hotel
	 * 
	 * @param packagesRequest
	 * @return packagesResponse
	 */
	private PackagesResponse changeHotels(PackagesRequest packagesRequest) {
		PackagesResponse packagesResponse = new PackagesResponse();

		com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packageavailabilityrequest.v1.PackageAvailabilityRequest packageAvailabilityRequest = this
				.getPackageAvailabilityRequestReq(packagesRequest);

		com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packageavailabilityresponse.v1.PackageAvailabilityResponse packageAvailabilityResponse = null;

		try {
			/*
			 * PackageServiceExport_PackageServiceBSHttpPortProxy proxyService =
			 * new PackageServiceExport_PackageServiceBSHttpPortProxy( new URL(
			 * "http://172.22.50.211:9080/KCDEBBusSrv_PackageService_v1Web/sca/PackageServiceExport/WEB-INF/wsdl/KCDEBBusSrv_PackageService_v1_PackageServiceExport.wsdl"
			 * ), new QName(
			 * "http://www.partners.kcdataservices.com/KCDEBSrvLib_Package/interfaces/PackageServiceBS/v1"
			 * , "PackageServiceExport_PackageServiceBSHttpService"));
			 */
			// logger.info("--WESBQNAME--"+this.getMessageSource().getMessage("wesbPackageQname",null,
			// null));
			PackageServiceExport_PackageServiceBSHttpPortProxy proxyService = new PackageServiceExport_PackageServiceBSHttpPortProxy(
					new URL(this.getMessageSource().getMessage(
							"wesbPackageUrl", null, null)), new QName(this
							.getMessageSource().getMessage("wesbPackageQname",
									null, null),
							"PackageServiceExport_PackageServiceBSHttpService"));

			packageAvailabilityResponse = proxyService
					.changeHotels(packageAvailabilityRequest);
		} catch (MalformedURLException e) {

		} catch (Exception e) {

		}

		if (packageAvailabilityResponse != null) {
			packagesResponse = this
					.getPackagesResponse(packageAvailabilityResponse);
		}

		return packagesResponse;
	}

	/**
	 * Method to chnage the Hotel
	 * 
	 * @param packagesRequest
	 * @return packagesResponse
	 */
	public PackagesResponse wesbChangeHotels(PackagesRequest packagesRequest) {
		PackagesResponse packagesResponse = this.changeHotels(packagesRequest);

		return packagesResponse;
	}

	/**
	 * Method to retrieve the packages
	 * 
	 * @param packagesRequest
	 *            - request for packages
	 * @return PackagesResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public PackagesResponse retrievePackages(PackagesRequest packagesRequest) {
		PackagesResponse packagesResponse = new PackagesResponse();
		// Create the input structure for BAPI
		Y_Ota_Package_Availability_Input bapiInput = new Y_Ota_Package_Availability_Input();

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// Prepare & set header structures
		bapiInput.setIm_Req_Hdr(this.preparePackageHeader(packagesRequest,
				false, false, false));

		// Prepare & set flights
		this.prepareFlightsInput(packagesRequest, bapiInput, false, false,
				false);

		// Prepare & set hotels
		this.prepareHotelsInput(packagesRequest, bapiInput, false, false, false);

		// Prepare & set cars
		this.prepareVehcilesInput(packagesRequest, bapiInput, false, false,
				false);

		// Execute the BAPI
		Y_Ota_Package_Availability_Output bapiOutput = (Y_Ota_Package_Availability_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Ota_Package_Availability", bapiInput);

		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				packagesResponse);

		// Check for any business errors from BAPI
		if (packagesResponse.isBusinessErrorOccurred()) {
			return packagesResponse;
		}
	/*Code commented for revocation of 3620608 on 04/05/2013*/
		// Process the Flights structures
	/*	packagesResponse.setFlightsList(FlightConvertUtils
				.convertFlightsResponse(
						bapiOutput.get_as_listEx_Ota_Flt_Segments_Cpy(),
						bapiOutput.get_as_listIt_Ota_Flt_Orig_Dest(),
						packagesRequest.getFlightsRequest(), airportsTimeZones,
						airlineNames));*/
		packagesResponse.setFlightsList(FlightConvertUtils
				.convertFlightsResponse(
						bapiOutput.get_as_listIt_Ota_Flt_Segments(),
						bapiOutput.get_as_listIt_Ota_Flt_Orig_Dest(),
						packagesRequest.getFlightsRequest(), airportsTimeZones,
						airlineNames));

		// Process the hotels structures
		packagesResponse.setHotelList(HotelConvertUtils.parseHotelAvailability(
				packagesRequest.getHotelsRequest(),
				bapiOutput.get_as_listIt_Htl_Info(),
				bapiOutput.get_as_listIt_Htl_Availability(),
				bapiOutput.get_as_listIt_Htl_Pricing(),
				bapiOutput.get_as_listIt_Htl_Amenity(),
				bapiOutput.get_as_listIt_Htl_Vend_Services()));
		packagesResponse.setDestinationsList(HotelConvertUtils
				.processDestinationServices(bapiOutput
						.get_as_listIt_Htl_Dest_Services()));

		// Process the cars structures
		packagesResponse.setVehiclesList(VehicleConvertUtils
				.parseVehicleResponse(
						bapiOutput.get_as_listIt_Veh_Availability(),
						packagesRequest.getVehiclesRequest()));

		return packagesResponse;
	}

	/**
	 * Method to prepare the flight input structures.
	 * 
	 * @param packagesRequest
	 * @param bapiInput
	 * 
	 * @see
	 * @since
	 */
	private void prepareFlightsInput(PackagesRequest packagesRequest,
			Y_Ota_Package_Availability_Input bapiInput, boolean changeFlight,
			boolean changeHotel, boolean changeVehicle) {
		if (changeVehicle) {
			/**
			 * If change hotel or change car, prepare flight structures from
			 * selectedFligthts of a package
			 */
			if (packagesRequest.getAvailablePackage() != null) {
				TripFlight tripFlight = packagesRequest.getAvailablePackage()
						.getSelectedFlight();
				if (tripFlight != null) {
					Yst_Ota_Flt_ItemsType_List flightItemsList = new Yst_Ota_Flt_ItemsType_List();
					Yst_Ota_Flt_SegmentsType_List segmentsList = new Yst_Ota_Flt_SegmentsType_List();
					flightItemsList.add(FlightConvertUtils
							.prepareFlightItemTypeList(tripFlight, (byte) 1));
					// Process the segment details
					segmentsList.addAll(FlightConvertUtils
							.prepareFltSegmentsTypeList(tripFlight, (byte) 1));
					bapiInput.setIt_Sel_Flt_Items(flightItemsList);
					bapiInput.setIt_Sel_Flt_Segments(segmentsList);
				}
			}
		} else {
			Yst_Ota_Flt_Orig_DestType_List flightOrigDestList = packagesRequest
					.getSapOrigDestOptionsList();
			Yst_Ota_Flt_SegmentsType_List flightSegmentsList = packagesRequest
					.getSapSegmentsList();
			byte flightItemRph = (byte) 0;
			if (changeHotel) {
				if (packagesRequest.getAvailablePackage() != null
						&& packagesRequest.getAvailablePackage()
								.getSelectedFlight() != null) {
					if (flightOrigDestList == null) {
						flightOrigDestList = new Yst_Ota_Flt_Orig_DestType_List();
					} else {
						flightItemRph = (byte) flightOrigDestList.size();
					}
					if (flightSegmentsList == null) {
						flightSegmentsList = new Yst_Ota_Flt_SegmentsType_List();
					}
					++flightItemRph;
					TripFlight tripFlight = packagesRequest
							.getAvailablePackage().getSelectedFlight();
					flightOrigDestList.add(FlightConvertUtils
							.prepareFltOrigDestType(tripFlight, flightItemRph));
					// Prepare the segements
					flightSegmentsList.addAll(FlightConvertUtils
							.prepareFltSegmentsTypeList(tripFlight,
									flightItemRph));
				}
			} else {
				/**
				 * Availability and Change flight scenarios
				 */
				if (packagesRequest.getFlightsList() != null
						&& packagesRequest.getFlightsList().size() > 0) {
					if (flightOrigDestList == null) {
						flightOrigDestList = new Yst_Ota_Flt_Orig_DestType_List();
					} else {
						flightItemRph = (byte) flightOrigDestList.size();
					}
					if (flightSegmentsList == null) {
						flightSegmentsList = new Yst_Ota_Flt_SegmentsType_List();
					}
					for (TripFlight tripFlight : packagesRequest
							.getFlightsList()) {
						// Prepare Orig destination object
						++flightItemRph;
						flightOrigDestList.add(FlightConvertUtils
								.prepareFltOrigDestType(tripFlight,
										flightItemRph));
						// Prepare the segements
						flightSegmentsList.addAll(FlightConvertUtils
								.prepareFltSegmentsTypeList(tripFlight,
										flightItemRph));
					}
				}
			}
			if (flightOrigDestList != null) {
				// Setting the Flight options and segements to bapi input
				bapiInput.setIt_Ota_Flt_Orig_Dest(flightOrigDestList);
				bapiInput.setIt_Ota_Flt_Segments(flightSegmentsList);
			}
		}
	}

	/**
	 * Method to prepare hotel input structures
	 * 
	 * @param packagesRequest
	 * @param bapiInput
	 * 
	 * @see
	 * @since
	 */
	private void prepareHotelsInput(PackagesRequest packagesRequest,
			Y_Ota_Package_Availability_Input bapiInput, boolean changeFlight,
			boolean changeHotel, boolean changeVehicle) {
		if (changeFlight || changeVehicle) {
			/**
			 * If change flight or change car, prepare hotel structures from
			 * selectedHotel of a package
			 */
			if (packagesRequest.getAvailablePackage() != null) {
				Hotel selectedHotel = packagesRequest.getAvailablePackage()
						.getSelectedHotel();
				if (selectedHotel != null) {
					byte hotelItemRph = 0;
					Yst_Ota_Htl_ItemsType_List itemsTypeList = new Yst_Ota_Htl_ItemsType_List();
					Yst_Ota_RoomstaycandidatesType_List roomStayList = new Yst_Ota_RoomstaycandidatesType_List();
					Yst_Ota_Htl_ItemsType_List hotelItemsList = HotelConvertUtils
							.prepareHotelItemTypeList(selectedHotel,
									hotelItemRph, null,false);
					if (hotelItemsList != null) {
						itemsTypeList.addAll(hotelItemsList);
					}
					/**
					 * Prepare room stay list
					 */
					if (selectedHotel.getSelectedRooms() != null) {
						for (RoomPrice roomPrice : selectedHotel
								.getSelectedRooms()) {
							RoomCategory roomCategory = selectedHotel
									.getRoomCatgoryById(roomPrice
											.getRoomCategoryId());
							if (roomCategory != null) {
								// Prepare room stay candidates
								if (selectedHotel.getOccupancy() != null
										&& selectedHotel.getOccupancy()
												.getPassengers() != null) {
									roomStayList.addAll(HotelConvertUtils
											.prepareRoomStayCandidates(
													selectedHotel
															.getOccupancy(),
													roomPrice.getRoomId(),
													++hotelItemRph));
								}
							}
						}
					}
					bapiInput.setIt_Sel_Htl_Items(itemsTypeList);
					bapiInput.setIt_Htl_Roomstaycandidates(roomStayList);
				}
			}
		} else {
			HotelsRequest hotelsRequest = packagesRequest.getHotelsRequest();
			if (hotelsRequest != null) {
				// Prepare hotel request options
				bapiInput.setIt_Htl_Req(HotelConvertUtils
						.prepareRequestOptions(hotelsRequest));

				// Prepare & set room occupancy criteria to BAPI input
				bapiInput.setIt_Htl_Roomstaycandidates(HotelConvertUtils
						.prepareRoomOccupancy(hotelsRequest.getOccupancy()));

				// Prepare amenity request options
				bapiInput
						.setIt_Htl_Req_Amenity(HotelConvertUtils
								.prepareAmenityOptions(hotelsRequest
										.getHotelOptions()));
			}
		}
	}

	/**
	 * Method to prepare vehicles input structures
	 * 
	 * @param packagesRequest
	 * @param bapiInput
	 * 
	 * @see
	 * @since
	 */
	private void prepareVehcilesInput(PackagesRequest packagesRequest,
			Y_Ota_Package_Availability_Input bapiInput, boolean changeFlight,
			boolean changeHotel, boolean changeVehicle) {
		if (changeFlight || changeHotel) {
			/**
			 * If change flight or change car, prepare hotel structures from
			 * selectedHotel of a package
			 */
			if (packagesRequest.getAvailablePackage() != null) {
				Vehicle selectedVehicle = packagesRequest.getAvailablePackage()
						.getSelectedVehicle();
				if (selectedVehicle != null) {
					// Prepare vehicle input structures
					Yst_Ota_Veh_ItemsType_List vehItemsList = new Yst_Ota_Veh_ItemsType_List();
					vehItemsList.add(VehicleConvertUtils.prepareVehItemType(
							selectedVehicle, (byte) 1));
					bapiInput.setIt_Sel_Veh_Items(vehItemsList);
				}
			}
		} else if (changeVehicle
				|| ((!packagesRequest.isAirRequested())
						&& packagesRequest.isHotelRequested() && packagesRequest
						.isVehicleRequested())) {
			// Change Vehicle flow
			VehiclesRequest vehiclesRequest = packagesRequest
					.getVehiclesRequest();
			if (vehiclesRequest != null) {
				// Prepare the vehicle request values
				bapiInput.setIt_Veh_Req(VehicleConvertUtils
						.constructVehicleRequestList(vehiclesRequest));
			}
		} else {
			Yst_Ota_Veh_AvailabilityType_List vehAvailabilityList = packagesRequest
					.getSapVehicleAvailabilityList();
			List<Vehicle> vehiclesList = packagesRequest.getVehiclesList();
			if (vehiclesList != null && vehiclesList.size() > 0) {
				byte vehicleRph = (byte) 0;
				if (vehAvailabilityList == null) {
					vehAvailabilityList = new Yst_Ota_Veh_AvailabilityType_List();
				} else {
					vehicleRph = (byte) vehAvailabilityList.size();
				}
				for (Vehicle vehicle : vehiclesList) {
					++vehicleRph;
					vehAvailabilityList.add(VehicleConvertUtils
							.prepareVehAvailabilityType(vehicle, vehicleRph));
				}
			}
			if (vehAvailabilityList != null && !vehAvailabilityList.isEmpty()) {
				bapiInput.setIt_Veh_Availability(vehAvailabilityList);
			}
		}
	}

	/**
	 * Method to prepare the header for Package BAPI
	 * 
	 * @param request
	 * @return
	 * 
	 * @see
	 * @since
	 */
	protected Yst_Bapi_Req_Pkg_HdrType preparePackageHeader(ABERequest request,
			boolean changeFlight, boolean changeHotel, boolean changeVehicle) {
		Yst_Bapi_Req_Pkg_HdrType header = new Yst_Bapi_Req_Pkg_HdrType();
		if (request.isAirRequested()) {
			header.setFlights_Ind("1");
		}
		if (request.isHotelRequested()) {
			header.setHotels_Ind("1");
		}
		if (request.isVehicleRequested()) {
			header.setVehicle_Ind("1");
		}
		if (request.getPromoCode() != null) {
			header.setPromo_Code(request.getPromoCode());
		}
		if (request.getBookingNo() != null
				&& !"".equals(request.getBookingNo())) {
			header.setBooking_Num(request.getBookingNo());
		}
		// Set show all flag, if passed
		if (request instanceof PackagesRequest) {
			PackagesRequest pRequest = (PackagesRequest) request;
			if (pRequest.getHotelsRequest() != null
					&& pRequest.getHotelsRequest().getHotelOptions() != null
					&& pRequest.getHotelsRequest().getHotelOptions()
							.isShowAll()) {
				header.setShow_All("X");
			}
		}
		if (changeFlight) {
			header.setFlights_Chg_Ind("1");
		}
		if (changeHotel) {
			header.setHotels_Chg_Ind("1");
		}
		if (changeVehicle) {
			header.setVehicle_Chg_Ind("1");
		}
		return header;
	}

	/**
	 * Method to retrieve the price break up of given hotel
	 * 
	 * @param hotel
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public AllPriceBreakUpResponse retrievePriceBreakUp(Package availablePackage) {
		AllPriceBreakUpResponse response = new AllPriceBreakUpResponse();
		if (availablePackage == null) {
			// Return business error
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_PACKAGE");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_PACKAGE", null, null));
			response.saveBusinessError(businessError);
			return response;
		}
		// Prepare Input
		Y_Bapi_Room_Show_All_Pricing_Input bapiInput = new Y_Bapi_Room_Show_All_Pricing_Input();

		// Set ImApplicationInfo
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// Prepare request header
		Yst_Bapi_Req_HdrType headerType = new Yst_Bapi_Req_HdrType();
		headerType.setHotels_Ind("1");
		headerType.setFlights_Ind("1");
		// set the header
		bapiInput.setIm_Req_Hdr(headerType);

		this.preparePackageInput(availablePackage, bapiInput);

		Y_Bapi_Room_Show_All_Pricing_Output bapiOutput = (Y_Bapi_Room_Show_All_Pricing_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Bapi_Room_Show_All_Pricing", bapiInput);
		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(), response);
		// Return in case of any business error
		if (response.isBusinessErrorOccurred())
			return response;
		// Process BAPI Output
		AllPricesBreakUp pricesBreakUp = new AllPricesBreakUp();
		pricesBreakUp.setPaxTypePrices(parsePaxTypePriceBreakUp(bapiOutput
				.get_as_listIt_All_Paxtype()));
		if (bapiOutput.getEx_St_Show_All() != null) {
			Yst_Bapi_Show_AllType showAllType = bapiOutput.getEx_St_Show_All();
			pricesBreakUp.setFreeChildCount(Byte.parseByte(showAllType
					.getNo_Free_Child()));
			pricesBreakUp.setMaxPerRoom(Byte.parseByte(showAllType
					.getMax_Per_Room()));
			pricesBreakUp.setMinPerRoom(Byte.parseByte(showAllType
					.getMin_Per_Room()));
			pricesBreakUp.setMaxAdultCount(Byte.parseByte(showAllType
					.getMax_No_Adults()));
			pricesBreakUp.setMaxChildCount(Byte.parseByte(showAllType
					.getMax_No_Child()));
			pricesBreakUp.setChildRule(showAllType.getChild_Age_Rule());
		}
		response.setAllPricesBreakUp(pricesBreakUp);
		return response;
	}

	/**
	 * Method to process the pax type list
	 * 
	 * @param paxTypeList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private List<PaxTypePriceBreakup> parsePaxTypePriceBreakUp(
			Yst_Bapi_All_PaxtypeType_List paxTypeList) {
		if (paxTypeList == null) {
			return null;
		}
		List<PaxTypePriceBreakup> breakUpList = new ArrayList<PaxTypePriceBreakup>();
		Iterator<Yst_Bapi_All_PaxtypeType> iterator = paxTypeList.iterator();
		while (iterator.hasNext()) {
			Yst_Bapi_All_PaxtypeType paxTypeBreakup = iterator.next();
			PaxTypePriceBreakup paxTypePriceBreakup = new PaxTypePriceBreakup();
			paxTypePriceBreakup.setPaxType(paxTypeBreakup.getPaxtype()
					.charAt(0));
			paxTypePriceBreakup.setCount(Integer.parseInt(paxTypeBreakup
					.getGuestcount()));
			paxTypePriceBreakup.setPrice(paxTypeBreakup.getTotal()
					.doubleValue());
			paxTypePriceBreakup.setSavings(paxTypeBreakup.getSavings()
					.doubleValue());
			breakUpList.add(paxTypePriceBreakup);
		}
		return breakUpList;
	}

	/**
	 * Method to process the package to prepare all packages structures
	 * 
	 * @param packages
	 * @param bapiInput
	 * @param itemsMap
	 * @param itemRPH
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private void preparePackageInput(Package availablePackage,
			Y_Bapi_Room_Show_All_Pricing_Input bapiInput) {
		if (availablePackage.getSelectedFlight() != null) {

			TripFlight tripFlight = availablePackage.getSelectedFlight();

			Yst_Ota_Flt_ItemsType selectedFlightItem = FlightConvertUtils
					.prepareFlightItemTypeList(tripFlight, (byte) 1);
			bapiInput.setIm_St_Flt_Item(selectedFlightItem);

			// Process the segment details
			bapiInput.setIt_Ota_Flt_Segments(FlightConvertUtils
					.prepareFltSegmentsTypeList(tripFlight, (byte) 1));
		}

		if (availablePackage.getSelectedHotel() != null) {
			Yst_Ota_Htl_ItemsType_List hotelItemsList = HotelConvertUtils
					.prepareHotelItemTypeList(
							availablePackage.getSelectedHotel(), (byte) 2, null,false);
			Yst_Ota_Htl_ItemsType hotelItemType = hotelItemsList
					.getYst_Ota_Htl_ItemsType(0);
			hotelItemType.setFlt_Item_Rph("" + 1);
			bapiInput.setIm_St_Htl_Item(hotelItemType);
		}
	}
}