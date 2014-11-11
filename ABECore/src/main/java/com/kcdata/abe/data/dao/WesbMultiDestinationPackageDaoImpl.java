package com.kcdata.abe.data.dao;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import com.kcdata.abe.business.request.HotelsRequest;

import com.kcdata.abe.business.service.WesbProxyService;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;

import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.multidestinationpackage.v1.MultiDestinationPackage;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.resortarea.v1.ResortArea;
import com.kcdataservices.partners.kcdebsrvlib_package.interfaces.hotelspackagerequest.v1.HotelsPackageRequest;
import com.kcdataservices.partners.kcdebsrvlib_package.interfaces.multidestpackageavialabilityrequest.v1.MultiDestPackageAvialabilityRequest;
import com.kcdataservices.partners.kcdebsrvlib_package.interfaces.multidestpackageavialabilityresponse.v1.MultiDestPackageAvialabilityResponse;


public class WesbMultiDestinationPackageDaoImpl extends ABESAPDaoBase implements WesbMultiDestinationPackageDao
{

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
	
	
	public List<Hotel> retrieveMultidestinationPackages(HotelsRequest hotelRequest,Map<String,HBSiHotelInfo> hbsiHotelList)
	{
		MultiDestPackageAvialabilityRequest multiDestPackageAvialabilityRequestBO = new MultiDestPackageAvialabilityRequest();
		 MultiDestPackageAvialabilityResponse multiDestPackageAvialabilityResponse = new MultiDestPackageAvialabilityResponse();
		 MultiDestinationPackage multiDestinationPackage=null;
		 List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel> listOfHbsiHotels = null;
		 List<Hotel> hotelListDTO = new ArrayList<Hotel>();
		 
		 multiDestPackageAvialabilityRequestBO =  this.getMultiDestpackageRequestBO(hotelRequest);
		 
		
		
	try {
			
			/*PackageServiceExport_PackageServiceBSHttpPortProxy proxyService = new PackageServiceExport_PackageServiceBSHttpPortProxy(
				new  URL("http://172.22.50.211:9080/KCDEBBusSrv_PackageService_v1Web/sca/PackageServiceExport/WEB-INF/wsdl/KCDEBBusSrv_PackageService_v1_PackageServiceExport.wsdl"),
				new QName("http://www.partners.kcdataservices.com/KCDEBSrvLib_Package/interfaces/PackageServiceBS/v1", "PackageServiceExport_PackageServiceBSHttpService"));*/
			
		/*PackageServiceExport_PackageServiceBSHttpPortProxy proxyService = new PackageServiceExport_PackageServiceBSHttpPortProxy(
				new  URL("file:///C:/RADWorkSpace/Projects/ABE/PackageHotelServiceClient/src/KCDEBBusSrv_PackageService_v1_PackageServiceExport.wsdl"),
				new QName("http://www.partners.kcdataservices.com/KCDEBSrvLib_Package/interfaces/PackageServiceBS/v1", "PackageServiceExport_PackageServiceBSHttpService"));
		
		proxyService._getDescriptor().setEndpoint("http://172.22.50.211:9080/KCDEBBusSrv_PackageService_v1Web/sca/PackageServiceExport");*/
		
			
			if(multiDestPackageAvialabilityRequestBO!=null)
			{
			
			multiDestPackageAvialabilityResponse = proxyService.getPackageProxyService().retrieveMultidestinationPackages(multiDestPackageAvialabilityRequestBO);
			
			
			}
		
			List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel> hotelResponseList = new ArrayList<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel>();
			if (multiDestPackageAvialabilityResponse != null && multiDestPackageAvialabilityResponse.getMultiDestinationPackage()!=null && hbsiHotelList != null) {
				List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel> hotelList = multiDestPackageAvialabilityResponse.getMultiDestinationPackage()
						.getSelectedHotels();

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
							//setting the hotel code as vendor code
							hotel.setHotelCode(hbsiHotelInfo.getHotelVendorCode());
							
						hotel.getDisplayRoomCategory().setRoomTypeCode(hbsiHotelInfo.getHotelMaterialId());
						if(hotel.getAppleRating()==null || hotel.getAppleRating().equals(""))
							hotel.setAppleRating(hbsiHotelInfo.getAppleRating());
						if(hotel.getResortArea()==null)
						{
							ResortArea resortAreaBO = new ResortArea();
							resortAreaBO.setResortAreaCode(hbsiHotelInfo.getResortAreaCode());
							resortAreaBO.setResortAreaName(hbsiHotelInfo.getResortAreaName());
							hotel.setResortArea(resortAreaBO);
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
			
			MultiDestinationPackage wesbPackageAvailabilityResponse = new MultiDestinationPackage();
			MultiDestPackageAvialabilityResponse multidestinationPackageResponse = new MultiDestPackageAvialabilityResponse(); 
			
			if(hotelResponseList!=null)
			{
				
				for(int i=0;i<hotelResponseList.size();i++)
				{
					wesbPackageAvailabilityResponse.getSelectedHotels().add(hotelResponseList.get(i));
				}
			}
			
			multidestinationPackageResponse.setMultiDestinationPackage(wesbPackageAvailabilityResponse);
			if(multidestinationPackageResponse!=null)
			{
				multiDestinationPackage = multidestinationPackageResponse.getMultiDestinationPackage();
				if(multiDestinationPackage.getSelectedHotels()!=null)
					listOfHbsiHotels = multiDestinationPackage.getSelectedHotels(); 
			}
			
			if(listOfHbsiHotels!=null)
			{
				for(int i=0;i<listOfHbsiHotels.size();i++)
				{
					if(listOfHbsiHotels.get(i)!=null)
						hotelListDTO.add(this.getHotel(listOfHbsiHotels.get(i)));
						
				}
					
					
			}
				
		}
	/*	catch (MalformedURLException e) {
		System.out.println("Message 1"+e.getMessage());
		
		}*/
		catch (Exception e) {
			System.out.println("Message"+e.getMessage());
			
		}
		
		
		return hotelListDTO;
	}
	
	
	public MultiDestPackageAvialabilityRequest getMultiDestpackageRequestBO(HotelsRequest multidestPackageRequest)
	{
		List<HotelsPackageRequest> wesbHotelrequestList = new ArrayList<HotelsPackageRequest>();
		MultiDestPackageAvialabilityRequest multidestReqBO = new MultiDestPackageAvialabilityRequest(); 
		HotelsPackageRequest hotelPackageReq = this.getHotelsPackageRequestReq(multidestPackageRequest);
		
		if(multidestPackageRequest!=null)
		{
			multidestReqBO.setGateway(multidestPackageRequest.getGateway());
			multidestReqBO.setBookingNo(multidestPackageRequest.getBookingNo());
			multidestReqBO.setDestination(multidestPackageRequest.getDestination());
			multidestReqBO.setPromoCode(multidestPackageRequest.getPromoCode());
			multidestReqBO.setAirRequested(multidestPackageRequest.isAirRequested());
			multidestReqBO.setHotelRequested(multidestPackageRequest.isHotelRequested());
			multidestReqBO.setMultiDestinationRequest(multidestPackageRequest.isMultiDestinationRequest());
			multidestReqBO.setPackageRequest(multidestPackageRequest.isPackageRequest());
			multidestReqBO.setNoOfNights(multidestPackageRequest.getNoOfNights());
			multidestReqBO.setVehicleRequested(multidestPackageRequest.isVehicleRequested());
			
			if(multidestPackageRequest.getDepartureDate()!=null)
				multidestReqBO.setDepartureDate(this.getDate(multidestPackageRequest.getDepartureDate()));
			
			if(multidestPackageRequest.getOccupancy()!=null)
				multidestReqBO.setOccupancy(this.getOccupancyReq(multidestPackageRequest.getOccupancy()));
			
			
			
		}
		if(hotelPackageReq!=null)
		{
		wesbHotelrequestList.add(hotelPackageReq);
		multidestReqBO.getHotelsRequestList().addAll(wesbHotelrequestList);
		}
		return multidestReqBO;
	}
	
}
