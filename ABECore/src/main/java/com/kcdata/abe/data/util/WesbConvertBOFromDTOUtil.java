package com.kcdata.abe.data.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.kcdata.abe.data.dto.AirOptions;
import com.kcdata.abe.data.dto.Amenity;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.RequestedDatesForAvailability;
import com.kcdata.abe.data.dto.RoomPrice;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.VehicleOptions;
import com.kcdata.abe.data.dto.VendorService;
import com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.address.v1.Address;
import com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.agecode.v1.AgeCode;
import com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.passenger.v1.Passenger;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.cabintype.v1.CabinType;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.carrier.v1.Carrier;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.flighttriptype.v1.FlightTripType;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guestpricebreakup.v1.GuestPriceBreakup;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hoteloptions.v1.HotelOptions;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.mealplantype.v1.MealPlanType;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.passportinfo.v1.PassportInfo;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paxtypebaseprices.v1.PaxTypeBasePrices;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paxtypepricebreakup.v1.PaxTypePriceBreakup;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.resortarea.v1.ResortArea;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.specialoptions.v1.SpecialOptions;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.specialrequesttype.v1.SpecialRequestType;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.specialtype.v1.SpecialType;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.timeofday.v1.TimeOfDay;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vendor.v1.Vendor;

public class WesbConvertBOFromDTOUtil 
{
	
	/**
	 * Convert XMLGregorianCalendarn to java.util.date
	 * @param xmlDate
	 * @return Date
	 */

	private static Date dateConverterXMLtoUtilDate(XMLGregorianCalendar xmlDate)
	{
		
		Date date = new Date() ;
		if(xmlDate!=null)
		{
		date = xmlDate.toGregorianCalendar().getTime();
	
		}
		return date;
		
	}
	

	/**
	 * Convert java.util.date to XMLGregorianCalendar
	 * 
	 * @param date
	 * @return XMLGregorianCalendar
	 */
	private static XMLGregorianCalendar dateConverter(Date date)
	{
		DatatypeFactory df=null;
		try 
		{
		 df = DatatypeFactory.newInstance(); 
			
		}
		catch(DatatypeConfigurationException e) { 
			throw new IllegalStateException( "Error while trying to obtain a new instance of DatatypeFactory", e); 
		}
		if(date == null) { 
			return null; 
		} 
		else { 
			GregorianCalendar gc = new GregorianCalendar(); 
			gc.setTimeInMillis(date.getTime()); 
			return df.newXMLGregorianCalendar(gc); 
		}
		
      
	}

	/**
	 * Prepare Requested dates for availibility
	 * @param requestedDateDTO
	 * @return RequestedDatesForAvailability
	 * 
	 */
	public static com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.requesteddatesforavailability.v1.RequestedDatesForAvailability getRequestedDatesForAvailibilityBO(RequestedDatesForAvailability requestedDateDTO)
	{

	com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.requesteddatesforavailability.v1.RequestedDatesForAvailability requestedDatesForAvailabilityBO= new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.requesteddatesforavailability.v1.RequestedDatesForAvailability(); 	
	requestedDatesForAvailabilityBO.setBookingDate(requestedDateDTO.getBookingDate());
	requestedDatesForAvailabilityBO.setBookingDuration(requestedDateDTO.getBookingDuration());
	requestedDatesForAvailabilityBO.setMaterialNumber(requestedDateDTO.getMaterialNumber());
	requestedDatesForAvailabilityBO.setNoOfRooms(requestedDateDTO.getNoOfRooms());
	requestedDatesForAvailabilityBO.setRoomDescription(requestedDateDTO.getRoomDescription());
	requestedDatesForAvailabilityBO.setRoomStatus(requestedDateDTO.getRoomStatus());
	if(requestedDateDTO.getReqDates()!=null)
	{	
	for(int i=0;i<requestedDateDTO.getReqDates().size();i++)
	{
		if(requestedDateDTO.getReqDates().get(i)!=null)
		{
			if(requestedDatesForAvailabilityBO!=null)
			{
		requestedDatesForAvailabilityBO.getReqDates().add(i, requestedDateDTO.getReqDates().get(i));
			}
		}
	}
	}
	
	return requestedDatesForAvailabilityBO;
	}
	


	/**
	 * Prepare RoomPrice BO
	 * @param roomPriceDTO
	 * @return RoomPrice
	 * 
	 */
	public static com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice getRoomPriceBO(RoomPrice roomPriceDTO)
	{
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice roomPriceBO =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice();
		PaxTypeBasePrices paxTypeBasePricesBO = new PaxTypeBasePrices();
		PaxTypePriceBreakup paxTypePriceBreakUpBO = new PaxTypePriceBreakup();
		
		
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice internalRoomPriceBO =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice();
		
		//Prepare RoomPrice BO based on input RoomPrice DTO
		roomPriceBO.setHotelCost(roomPriceDTO.getHotelCost());
		roomPriceBO.setTransferCost(roomPriceDTO.getTransferCost());
		
		roomPriceBO.setCommissionAmount(roomPriceDTO.getCommissionAmount());
		roomPriceBO.setCommissionPercent(roomPriceDTO.getCommissionPercent());
		roomPriceBO.setCurrency(roomPriceDTO.getCurrency());
		roomPriceBO.setFreeNights(roomPriceDTO.getFreeNights());
		roomPriceBO.setGuestAllocation(roomPriceDTO.getGuestAllocation());
		roomPriceBO.setHotelId(roomPriceDTO.getHotelId());
		
		
		roomPriceBO.setLateFee(roomPriceDTO.getLateFee());
		roomPriceBO.setPackagePrice(roomPriceDTO.getPackagePrice());
		roomPriceBO.setPerAdultBasePrice(roomPriceDTO.getPerAdultBasePrice());
		roomPriceBO.setPriceChanged(roomPriceDTO.isPriceChanged());
		roomPriceBO.setRoomCategoryId(roomPriceDTO.getRoomCategoryId());
		roomPriceBO.setRoomId(roomPriceDTO.getRoomId());
		roomPriceBO.setSavings(roomPriceDTO.getSavings());
		roomPriceBO.setTax(roomPriceDTO.getTax());
		roomPriceBO.setTotalAmount(roomPriceDTO.getTotalAmount());
		
		//Prepare paxTypeBasePricesBO for RoomPrice BO
		if(roomPriceDTO.getPaxBasePrices()!=null)
		{
			paxTypeBasePricesBO.setAdultBasePrice(roomPriceDTO.getPaxBasePrices().getAdultBasePrice());
			paxTypeBasePricesBO.setChild1Age(roomPriceDTO.getPaxBasePrices().getChild1Age());
			paxTypeBasePricesBO.setChild1Type(roomPriceDTO.getPaxBasePrices().getChild1Type());
			paxTypeBasePricesBO.setChild2Age(roomPriceDTO.getPaxBasePrices().getChild2Age());
			paxTypeBasePricesBO.setChild2Type(roomPriceDTO.getPaxBasePrices().getChild2Type());
			paxTypeBasePricesBO.setChild3Age(roomPriceDTO.getPaxBasePrices().getChild3Age());
			paxTypeBasePricesBO.setChild3Type(roomPriceDTO.getPaxBasePrices().getChild3Type());
			paxTypeBasePricesBO.setChild4Type(roomPriceDTO.getPaxBasePrices().getChild4Type());
			paxTypeBasePricesBO.setChild4Age(roomPriceDTO.getPaxBasePrices().getChild4Age());
			paxTypeBasePricesBO.setChild5Age(roomPriceDTO.getPaxBasePrices().getChild5Age());
			paxTypeBasePricesBO.setChild5Type(roomPriceDTO.getPaxBasePrices().getChild5Type());
			paxTypeBasePricesBO.setChild6Age(roomPriceDTO.getPaxBasePrices().getChild6Age());
			paxTypeBasePricesBO.setChild6Type(roomPriceDTO.getPaxBasePrices().getChild6Type());
			paxTypeBasePricesBO.setChildBasePrice(roomPriceDTO.getPaxBasePrices().getChildBasePrice());
			paxTypeBasePricesBO.setInfantBasePrice(roomPriceDTO.getPaxBasePrices().getInfantBasePrice());
			paxTypeBasePricesBO.setJuniorBasePrice(roomPriceDTO.getPaxBasePrices().getJuniorBasePrice());
			paxTypeBasePricesBO.setLapChildBasePrice(roomPriceDTO.getPaxBasePrices().getLapChildBasePrice());
			paxTypeBasePricesBO.setMinorBasePrice(roomPriceDTO.getPaxBasePrices().getMinorBasePrice());
			paxTypeBasePricesBO.setNoOfAdults(roomPriceDTO.getPaxBasePrices().getNoOfAdults());
			paxTypeBasePricesBO.setNoOfChilds(roomPriceDTO.getPaxBasePrices().getNoOfChilds());
			paxTypeBasePricesBO.setNoOfInfants(roomPriceDTO.getPaxBasePrices().getNoOfInfants());
			paxTypeBasePricesBO.setNoOfJuniors(roomPriceDTO.getPaxBasePrices().getNoOfJuniors());
			paxTypeBasePricesBO.setNoOfLapChilds(roomPriceDTO.getPaxBasePrices().getNoOfLapChilds());
			paxTypeBasePricesBO.setNoOfMinors(roomPriceDTO.getPaxBasePrices().getNoOfMinors());
			paxTypeBasePricesBO.setNoOfSeniors(roomPriceDTO.getPaxBasePrices().getNoOfSeniors());
			roomPriceBO.setPaxBasePrices(paxTypeBasePricesBO);
		}
		List<com.kcdata.abe.data.dto.PaxTypePriceBreakup> listOfPaxTypePriceBreakUpDTO;
		
		//Prepare PaxTypePriceBreakup BO
		if(roomPriceDTO.getPaxTypePriceBreakups()!=null)
		{
			listOfPaxTypePriceBreakUpDTO = roomPriceDTO.getPaxTypePriceBreakups();
			for(int i=0;i<listOfPaxTypePriceBreakUpDTO.size();i++)
			{
				if(listOfPaxTypePriceBreakUpDTO.get(i)!=null)
				{
				paxTypePriceBreakUpBO.setAge(listOfPaxTypePriceBreakUpDTO.get(i).getAge());
				paxTypePriceBreakUpBO.setAirportTax(listOfPaxTypePriceBreakUpDTO.get(i).getAirportTax());
				paxTypePriceBreakUpBO.setCount(listOfPaxTypePriceBreakUpDTO.get(i).getCount());
				paxTypePriceBreakUpBO.setForeignTax(listOfPaxTypePriceBreakUpDTO.get(i).getForeignTax());
				//paxTypePriceBreakUpBO.setLateFee(listOfPaxTypePriceBreakUpDTO.get(i).getLateFee());
				paxTypePriceBreakUpBO.setMaxAge(listOfPaxTypePriceBreakUpDTO.get(i).getMaxAge());
				paxTypePriceBreakUpBO.setMinAge(listOfPaxTypePriceBreakUpDTO.get(i).getMinAge());
				paxTypePriceBreakUpBO.setPaxType(Character.toString(listOfPaxTypePriceBreakUpDTO.get(i).getPaxType()));
				paxTypePriceBreakUpBO.setPrice(listOfPaxTypePriceBreakUpDTO.get(i).getPrice());
				paxTypePriceBreakUpBO.setRoomId(listOfPaxTypePriceBreakUpDTO.get(i).getRoomId());
				paxTypePriceBreakUpBO.setSavings(listOfPaxTypePriceBreakUpDTO.get(i).getSavings());
				paxTypePriceBreakUpBO.setTaxes(listOfPaxTypePriceBreakUpDTO.get(i).getTaxes());
				paxTypePriceBreakUpBO.setTotalAmount(listOfPaxTypePriceBreakUpDTO.get(i).getTotalAmount());
				paxTypePriceBreakUpBO.setTypeRule(listOfPaxTypePriceBreakUpDTO.get(i).getTypeRule());
				paxTypePriceBreakUpBO.setUsTax(listOfPaxTypePriceBreakUpDTO.get(i).getUsTax());
				roomPriceBO.getPaxTypePriceBreakups().add(i, paxTypePriceBreakUpBO);
				}
			}
		}
		
		
		if(roomPriceDTO.getInitialPrice()!=null)
		{
		roomPriceBO.setInitialPrice(getInternalRoomPriceBO(roomPriceDTO.getInitialPrice()));
		}
		
		return roomPriceBO;
	}
	
	/**
	 * Method to prepare inner initialRoomPrice which is inner RoomPrice object of RoomPrice BO
	 * @param roomPriceDTO
	 * @return RoomPrice
	 * 
	 */
	public static com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice getInternalRoomPriceBO(RoomPrice roomPriceDTO)
	{

		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice roomPriceBO =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice();
		PaxTypeBasePrices paxTypeBasePricesBO = new PaxTypeBasePrices();
		PaxTypePriceBreakup paxTypePriceBreakUpBO = new PaxTypePriceBreakup();
		
		//Prepare RoomPrice BO based on input RoomPrice DTO
		
		//roomPriceBO.setCheckInDate(dateConverter(roomPriceDTO.getCheckInDate()));
		roomPriceBO.setCommissionAmount(roomPriceDTO.getCommissionAmount());
		roomPriceBO.setCommissionPercent(roomPriceDTO.getCommissionPercent());
		roomPriceBO.setCurrency(roomPriceDTO.getCurrency());
		roomPriceBO.setFreeNights(roomPriceDTO.getFreeNights());
		roomPriceBO.setGuestAllocation(roomPriceDTO.getGuestAllocation());
		roomPriceBO.setHotelId(roomPriceDTO.getHotelId());
		
		roomPriceBO.setInitialPrice(null);
		roomPriceBO.setLateFee(roomPriceDTO.getLateFee());
		roomPriceBO.setPackagePrice(roomPriceDTO.getPackagePrice());
		roomPriceBO.setPerAdultBasePrice(roomPriceDTO.getPerAdultBasePrice());
		roomPriceBO.setPriceChanged(roomPriceDTO.isPriceChanged());
		roomPriceBO.setRoomCategoryId(roomPriceDTO.getRoomCategoryId());
		roomPriceBO.setRoomId(roomPriceDTO.getRoomId());
		roomPriceBO.setSavings(roomPriceDTO.getSavings());
		roomPriceBO.setTax(roomPriceDTO.getTax());
		roomPriceBO.setTotalAmount(roomPriceDTO.getTotalAmount());
		
		//Prepare paxTypeBasePricesBO for RoomPrice BO
		if(roomPriceDTO.getPaxBasePrices()!=null)
		{
			paxTypeBasePricesBO.setAdultBasePrice(roomPriceDTO.getPaxBasePrices().getAdultBasePrice());
			paxTypeBasePricesBO.setChild1Age(roomPriceDTO.getPaxBasePrices().getChild1Age());
			paxTypeBasePricesBO.setChild1Type(roomPriceDTO.getPaxBasePrices().getChild1Type());
			paxTypeBasePricesBO.setChild2Age(roomPriceDTO.getPaxBasePrices().getChild2Age());
			paxTypeBasePricesBO.setChild2Type(roomPriceDTO.getPaxBasePrices().getChild2Type());
			paxTypeBasePricesBO.setChild3Age(roomPriceDTO.getPaxBasePrices().getChild3Age());
			paxTypeBasePricesBO.setChild3Type(roomPriceDTO.getPaxBasePrices().getChild3Type());
			paxTypeBasePricesBO.setChild4Type(roomPriceDTO.getPaxBasePrices().getChild4Type());
			paxTypeBasePricesBO.setChild4Age(roomPriceDTO.getPaxBasePrices().getChild4Age());
			paxTypeBasePricesBO.setChild5Age(roomPriceDTO.getPaxBasePrices().getChild5Age());
			paxTypeBasePricesBO.setChild5Type(roomPriceDTO.getPaxBasePrices().getChild5Type());
			paxTypeBasePricesBO.setChild6Age(roomPriceDTO.getPaxBasePrices().getChild6Age());
			paxTypeBasePricesBO.setChild6Type(roomPriceDTO.getPaxBasePrices().getChild6Type());
			paxTypeBasePricesBO.setChildBasePrice(roomPriceDTO.getPaxBasePrices().getChildBasePrice());
			paxTypeBasePricesBO.setInfantBasePrice(roomPriceDTO.getPaxBasePrices().getInfantBasePrice());
			paxTypeBasePricesBO.setJuniorBasePrice(roomPriceDTO.getPaxBasePrices().getJuniorBasePrice());
			paxTypeBasePricesBO.setLapChildBasePrice(roomPriceDTO.getPaxBasePrices().getLapChildBasePrice());
			paxTypeBasePricesBO.setMinorBasePrice(roomPriceDTO.getPaxBasePrices().getMinorBasePrice());
			paxTypeBasePricesBO.setNoOfAdults(roomPriceDTO.getPaxBasePrices().getNoOfAdults());
			paxTypeBasePricesBO.setNoOfChilds(roomPriceDTO.getPaxBasePrices().getNoOfChilds());
			paxTypeBasePricesBO.setNoOfInfants(roomPriceDTO.getPaxBasePrices().getNoOfInfants());
			paxTypeBasePricesBO.setNoOfJuniors(roomPriceDTO.getPaxBasePrices().getNoOfJuniors());
			paxTypeBasePricesBO.setNoOfLapChilds(roomPriceDTO.getPaxBasePrices().getNoOfLapChilds());
			paxTypeBasePricesBO.setNoOfMinors(roomPriceDTO.getPaxBasePrices().getNoOfMinors());
			paxTypeBasePricesBO.setNoOfSeniors(roomPriceDTO.getPaxBasePrices().getNoOfSeniors());
			roomPriceBO.setPaxBasePrices(paxTypeBasePricesBO);
		}
		List<com.kcdata.abe.data.dto.PaxTypePriceBreakup> listOfPaxTypePriceBreakUpDTO;
		
		//Prepare PaxTypePriceBreakup BO
		if(roomPriceDTO.getPaxTypePriceBreakups()!=null)
		{
			listOfPaxTypePriceBreakUpDTO = roomPriceDTO.getPaxTypePriceBreakups();
			for(int i=0;i<listOfPaxTypePriceBreakUpDTO.size();i++)
			{
				paxTypePriceBreakUpBO.setAge(listOfPaxTypePriceBreakUpDTO.get(i).getAge());
				paxTypePriceBreakUpBO.setAirportTax(listOfPaxTypePriceBreakUpDTO.get(i).getAirportTax());
				paxTypePriceBreakUpBO.setCount(listOfPaxTypePriceBreakUpDTO.get(i).getCount());
				paxTypePriceBreakUpBO.setForeignTax(listOfPaxTypePriceBreakUpDTO.get(i).getForeignTax());
				//paxTypePriceBreakUpBO.setLateFee(listOfPaxTypePriceBreakUpDTO.get(i).getLateFee());
				paxTypePriceBreakUpBO.setMaxAge(listOfPaxTypePriceBreakUpDTO.get(i).getMaxAge());
				paxTypePriceBreakUpBO.setMinAge(listOfPaxTypePriceBreakUpDTO.get(i).getMinAge());
				paxTypePriceBreakUpBO.setPaxType(Character.toString(listOfPaxTypePriceBreakUpDTO.get(i).getPaxType()));
				paxTypePriceBreakUpBO.setPrice(listOfPaxTypePriceBreakUpDTO.get(i).getPrice());
				paxTypePriceBreakUpBO.setRoomId(listOfPaxTypePriceBreakUpDTO.get(i).getRoomId());
				paxTypePriceBreakUpBO.setSavings(listOfPaxTypePriceBreakUpDTO.get(i).getSavings());
				paxTypePriceBreakUpBO.setTaxes(listOfPaxTypePriceBreakUpDTO.get(i).getTaxes());
				paxTypePriceBreakUpBO.setTotalAmount(listOfPaxTypePriceBreakUpDTO.get(i).getTotalAmount());
				paxTypePriceBreakUpBO.setTypeRule(listOfPaxTypePriceBreakUpDTO.get(i).getTypeRule());
				paxTypePriceBreakUpBO.setUsTax(listOfPaxTypePriceBreakUpDTO.get(i).getUsTax());
				roomPriceBO.getPaxTypePriceBreakups().add(i, paxTypePriceBreakUpBO);
			}
		}
		
		
		return roomPriceBO;
	
	}
	

	/**
	 * Method to prepare Amenity BO
	 * @param amenityDTO
	 * @return Amenity
	 */
	public static com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.amenity.v1.Amenity getAmenityBO(Amenity amenityDTO)
	{
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.amenity.v1.Amenity amenityBO = 
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.amenity.v1.Amenity();
		
		amenityBO.setAmenityCode(amenityDTO.getAmenityCode());
		if(amenityDTO.getAmenityDate()!=null)
		{
		amenityBO.setAmenityDate(dateConverter(amenityDTO.getAmenityDate()));
		}
		amenityBO.setAmenityName(amenityDTO.getAmenityName());
		amenityBO.setAmenityValue(amenityDTO.getAmenityValue());
		amenityBO.setHotelId(amenityDTO.getHotelId());
		amenityBO.setRoomCategoryId(amenityDTO.getRoomCategoryId());
		
		return amenityBO;
	}
	
	
	/**
	 * Method to prepare RoomCategory BO
	 * @param roomCategoryDTO
	 * @return RoomCategory
	 * 
	 */
	public static RoomCategory getRoomCategoryBO(com.kcdata.abe.data.dto.RoomCategory roomCategoryDTO)
	{
		RoomCategory roomCategoryBO = new RoomCategory();
		MealPlanType mealPlanTypeBO = new MealPlanType();
		
		roomCategoryBO.setAppleChoice(roomCategoryDTO.getAppleChoice());
		roomCategoryBO.setCorporateId(roomCategoryDTO.getCorporateId());
		roomCategoryBO.setCurrency(roomCategoryDTO.getCurrency());
		roomCategoryBO.setDisplayRoomPrice(getRoomPriceBO(roomCategoryDTO.getDisplayRoomPrice()));
		roomCategoryBO.setGuaranteeAmount(roomCategoryDTO.getGuaranteeAmount());
		roomCategoryBO.setGuaranteeMethod(roomCategoryDTO.getGuaranteeMethod());
		roomCategoryBO.setGuaranteeRequired(roomCategoryDTO.getGuaranteeRequired());
		roomCategoryBO.setGuaranteeType(roomCategoryDTO.getGuaranteeType());
		roomCategoryBO.setHotelId(roomCategoryDTO.getHotelId());
		roomCategoryBO.setMealplanDesc(roomCategoryDTO.getMealplanDesc());
		
		//prepare MealPlanType BO from DTO
		if(roomCategoryDTO.getMealPlanType()!=null)
		{
			mealPlanTypeBO.setCode(roomCategoryDTO.getMealPlanType().getCode());
			mealPlanTypeBO.setDescription(roomCategoryDTO.getMealPlanType().getDescription());
				
		}
		
		roomCategoryBO.setMealPlanType(mealPlanTypeBO);
		roomCategoryBO.setNoOfRoomsAvailable(roomCategoryDTO.getNoOfRoomsAvailable());
		roomCategoryBO.setOldPosnr(roomCategoryDTO.getOldPosnr());
		roomCategoryBO.setPosnr(roomCategoryDTO.getPosnr());
		roomCategoryBO.setRateIndicator(roomCategoryDTO.getRateIndicator());
		roomCategoryBO.setRatePlanCategory(roomCategoryDTO.getRatePlanCategory());
		roomCategoryBO.setRatePlanCode(roomCategoryDTO.getRatePlanCode());
		roomCategoryBO.setRatePlanDescription(roomCategoryDTO.getRatePlanDescription());
		roomCategoryBO.setRatePlanId(roomCategoryDTO.getRatePlanId());
		roomCategoryBO.setRiskRoomCategory(roomCategoryDTO.isRiskRoomCategory());
		roomCategoryBO.setRoomCategoryId(roomCategoryDTO.getRoomCategoryId());
		roomCategoryBO.setRoomTypeCode(roomCategoryDTO.getRoomTypeCode());
		roomCategoryBO.setStatus(roomCategoryDTO.getStatus());
		roomCategoryBO.setRoomTypeDescription(roomCategoryDTO.getRoomTypeDescription());
		
		//Prepare List Of RoomPrice roomPrices; 
		if(roomCategoryDTO.getRoomPrices()!=null)
		{
			com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice roomPriceBO =
				new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice();
			for(int i=0;i<roomCategoryDTO.getRoomPrices().size();i++)
			{
				if(roomCategoryDTO.getRoomPrices().get(i)!=null)
				{
				roomPriceBO = getRoomPriceBO(roomCategoryDTO.getRoomPrices().get(i));
				roomCategoryBO.getRoomPrices().add(i, roomPriceBO);
				}
			}
		}
		
		//Prepare List Of Amenities amenities
		if(roomCategoryDTO.getAmenities()!=null)
		{
			com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.amenity.v1.Amenity amenityBO = 
				new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.amenity.v1.Amenity();
			for(int i=0;i<roomCategoryDTO.getAmenities().size();i++)
			{
				amenityBO=getAmenityBO(roomCategoryDTO.getAmenities().get(i));
				roomCategoryBO.getAmenities().add(i, amenityBO);
			}
			
		}
		
		return roomCategoryBO;
		
	}
	
	/**
	 * Method to prepare AgeCode BO
	 * @param ageCodeDTO
	 * @return AgeCode
	 */
	public static AgeCode getAgeCodeBO(com.kcdata.abe.data.dto.AgeCode ageCodeDTO)
	{
		AgeCode ageCodeBO = new AgeCode();
		ageCodeBO.setAge(ageCodeDTO.getAgeCode());
		if(Character.toString(ageCodeDTO.getPaxTypeCode())!=null)
		{
		ageCodeBO.setPaxTypeCode(Character.toString(ageCodeDTO.getPaxTypeCode()));
		}
		return ageCodeBO;
		
	}
	
	/**
	 * Method to Prepare passenger BO
	 * @param passengerDTO
	 * @return Passenger
	 * 
	 */
	public static Passenger getPassengerBO(com.kcdata.abe.data.dto.Passenger passengerDTO)
	{
		Passenger passengerBO = new Passenger();
		passengerBO.setAge(passengerDTO.getAge());
		passengerBO.setGuestCount(passengerDTO.getGuestCount());
		passengerBO.setPaxId(passengerDTO.getPaxId());
		passengerBO.setRoomNumber(passengerDTO.getRoomNumber());
		if(passengerDTO.getAgeCode()!=null)
		{
			AgeCode ageCodeBO = getAgeCodeBO(passengerDTO.getAgeCode());
			passengerBO.setAgeCode(ageCodeBO);
		}
		return passengerBO;
		
	}
	
	
	/**
	 * Method to Prepare Occupancy Object
	 * @param occupancyDTO
	 * @return Occupancy
	 */
	public static com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.occupancy.v1.Occupancy getOccuPancyBO(Occupancy occupancyDTO)
	{
		com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.occupancy.v1.Occupancy occupancyBO = 
			new com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.occupancy.v1.Occupancy();
		
		occupancyBO.setNoOfAdults(occupancyDTO.getNoOfAdults());
		occupancyBO.setNoOfChilds(occupancyDTO.getNoOfChilds());
		occupancyBO.setNoOfInfants(occupancyDTO.getNoOfInfants());
		occupancyBO.setNoOfLapChilds(occupancyDTO.getNoOfLapChilds());
		occupancyBO.setNoOfSeniors(occupancyDTO.getNoOfSeniors());
		
		if(occupancyDTO.getPassengers()!=null)
		{
			
			for(int i=0;i<occupancyDTO.getPassengers().size();i++)
			{
				Passenger passengerBO = new Passenger();
				passengerBO =getPassengerBO(occupancyDTO.getPassengers().get(i));
				occupancyBO.getPassengers().add(i, passengerBO);
			}
		}
		
		return occupancyBO;
	}
	
	/**
	 * Method to prepare TimeOfDay BO
	 * @param timeOfDayDTO
	 * @return TimeOfDay
	 */
	public static TimeOfDay getTimeOfDayBO(com.kcdata.abe.data.dto.TimeOfDay timeOfDayDTO)
	{
		TimeOfDay timeOfDayBO = new TimeOfDay();
		timeOfDayBO.setCode(timeOfDayDTO.getCode());
		return timeOfDayBO;
	}
	

	
	/**
	 * Method to prepare CabinType BO
	 * @param cabinTypeDTO
	 * @return CabinType
	 * 
	 */
	public static CabinType getCabinTypeBo(com.kcdata.abe.data.dto.CabinType cabinTypeDTO)
	{
		CabinType cabinTypeBO = new CabinType();
		cabinTypeBO.setType(Character.toString(cabinTypeDTO.getType()));
		
		return cabinTypeBO;
		
	}
	
	/**
	 * Method to Prepare AirOptions BO
	 * @param airOptionsDTO
	 * @return AirOptions
	 */
	public static com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.airoptions.v1.AirOptions getAirOptionsBO(AirOptions airOptionsDTO)
	{
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.airoptions.v1.AirOptions airOptionsBO = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.airoptions.v1.AirOptions();
		airOptionsBO.setClassOfService(airOptionsDTO.getClassOfService());
		airOptionsBO.setConnectingCity(airOptionsDTO.getConnectingCity());
		airOptionsBO.setConnectionCity1(airOptionsDTO.getConnectionCity1());
		airOptionsBO.setConnectionCity2(airOptionsDTO.getConnectionCity2());
		airOptionsBO.setExcludeCity1(airOptionsDTO.getExcludeCity1());
		airOptionsBO.setExcludeCity2(airOptionsDTO.getExcludeCity2());
		airOptionsBO.setExcludeCity3(airOptionsDTO.getExcludeCity3());
		airOptionsBO.setFlightNo(airOptionsDTO.getFlightNo());
		airOptionsBO.setNoOfStops(airOptionsDTO.getNoOfStops());
		airOptionsBO.setShowAll(airOptionsDTO.isShowAll());
		airOptionsBO.setStopOverCity(airOptionsDTO.getStopOverCity());
		airOptionsBO.setStopOverDuration(airOptionsDTO.getStopOverDuration());
		if(airOptionsDTO.getDepartureTimeOfDay()!=null)
		{
			airOptionsBO.setDepartureTimeOfDay(getTimeOfDayBO(airOptionsDTO.getDepartureTimeOfDay()));
		}
		if(airOptionsDTO.getArrivaTimeOfDay()!=null)
		{
			airOptionsBO.setArrivaTimeOfDay(getTimeOfDayBO(airOptionsDTO.getArrivaTimeOfDay()));
		}
		if(airOptionsDTO.getCabinType()!=null)
		{
			airOptionsBO.setCabinType(getCabinTypeBo(airOptionsDTO.getCabinType()));
		}
		return airOptionsBO;
	}
	
	
	/**
	 * Method to Prepare VehicleOptions BO
	 * @param vehicleOptionDTO
	 * @return VehicleOptions
	 */
	public static com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vehicleoptions.v1.VehicleOptions getVehicleOptionsBO(VehicleOptions vehicleOptionDTO)
	{
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vehicleoptions.v1.VehicleOptions vehicleOptionsBO = 
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vehicleoptions.v1.VehicleOptions();
		if(vehicleOptionDTO.getDropoffDateTime()!=null)
		{
		vehicleOptionsBO.setDropoffDateTime(dateConverter(vehicleOptionDTO.getDropoffDateTime()));
		}
		vehicleOptionsBO.setDropoffLocation(vehicleOptionDTO.getDropoffLocation());
		if(vehicleOptionDTO.getPickupDateTime()!=null)
		{
		vehicleOptionsBO.setPickupDateTime(dateConverter(vehicleOptionDTO.getPickupDateTime()));
		}
		vehicleOptionsBO.setPickupLocation(vehicleOptionDTO.getPickupLocation());
		vehicleOptionsBO.setVendorCode(vehicleOptionDTO.getVendorCode());
		vehicleOptionsBO.setVehicleClass(vehicleOptionDTO.getVehicleClass());
		return vehicleOptionsBO;
	}
	

	/**
	 * Method to Prepare SPecialType BO
	 * @param specialTypeDTO
	 * @return SpecialType
	 * 
	 */
	public static SpecialType getSpecialTypeBO(com.kcdata.abe.data.dto.SpecialType specialTypeDTO)
	{
		SpecialType specialTypeBO = new SpecialType();
		specialTypeBO.setType(specialTypeDTO.getType());
		return specialTypeBO;
	}
	
	
	/**
	 * Method to Prepare SpcialRequestType BO
	 * @param specialRequestTypeDTO
	 * @return SpecialRequestType
	 */
	public static SpecialRequestType getSpecialRequestTypeBO(com.kcdata.abe.data.dto.SpecialRequestType specialRequestTypeDTO)
	{
		SpecialRequestType specialRequestTypeBO = new SpecialRequestType();
		specialRequestTypeBO.setType(specialRequestTypeDTO.getType());
		return specialRequestTypeBO;
	}
	
	/**
	 * Method to prepare SpecialOptions BO
	 * @param specialOptionsDTO
	 * @return SpecialOptions
	 */
	public static SpecialOptions getSpecialOptionsBO(com.kcdata.abe.data.dto.SpecialOptions specialOptionsDTO)
	{
		SpecialOptions specialOptionsBO = new SpecialOptions();
		specialOptionsBO.setSpecialBatchId(specialOptionsDTO.getSpecialBatchId());
		specialOptionsBO.setSpecialCategoryId(specialOptionsDTO.getSpecialCategoryId());
		specialOptionsBO.setSpecialId(specialOptionsDTO.getSpecialId());
		if(specialOptionsDTO.getSpecialType()!=null)
		{
			specialOptionsBO.setSpecialType(getSpecialTypeBO(specialOptionsDTO.getSpecialType()));
		}
		if(specialOptionsDTO.getSpecialRequestType()!=null)
		{
			specialOptionsBO.setSpecialRequestType(getSpecialRequestTypeBO(specialOptionsDTO.getSpecialRequestType()));
		}
		return specialOptionsBO;
		
	}
	
	
	/**
	 * Method to Prepare Carrier BO
	 * @param carrierDTO
	 * @return Carrier
	 */
	public static Carrier getCarriersBO(com.kcdata.abe.data.dto.Carrier carrierDTO)
	{
		Carrier carrierBO = new Carrier();
		carrierBO.setCarrierCode(carrierDTO.getCarrierCode());
		carrierBO.setCarrierName(carrierDTO.getCarrierName());
		carrierBO.setCodeshareAvaialable(carrierDTO.isCodeshareAvaialable());
		carrierBO.setCodeShareInfo(carrierDTO.getCodeShareInfo());
		return carrierBO;
		
	}

	/**
	 * Method to Prepare ResortArea BO
	 * @param resortAreaDTO
	 * @return ResortArea
	 * 
	 */
	public static ResortArea getResortAreaBO(com.kcdata.abe.data.dto.ResortArea resortAreaDTO)
	{
		ResortArea resortAreaBO = new ResortArea();
		resortAreaBO.setResortAreaCode(resortAreaDTO.getResortAreaCode());
		resortAreaBO.setResortAreaName(resortAreaDTO.getResortAreaName());
			
		return resortAreaBO;
	}

	
	/************** Insert IMApplicationINfo Method here***/
	
	
	/**
	 * Method to prepare Address BO
	 * @param addressDTO
	 * @return Address
	 */
	public static Address getAddressBO(com.kcdata.abe.data.dto.Address addressDTO)
	{
		Address addressBO = new Address();
		addressBO.setCity(addressDTO.getCity());
		addressBO.setCountry(addressDTO.getCountry());
		addressBO.setState(addressDTO.getState());
		addressBO.setStreetAddress(addressDTO.getStreetAddress());
		addressBO.setZipCode(addressDTO.getZipCode());
		return addressBO;
	}

	/**
	 * Method to prepare PassportInfo
	 * @param passportInfoDTO
	 * @return PassportInfo
	 */
	public static PassportInfo getPassportInfoBO(com.kcdata.abe.data.dto.PassportInfo passportInfoDTO)
	{
		PassportInfo passportInfoBO = new PassportInfo();
		if(passportInfoDTO.getAddress()!=null)
		{
			passportInfoBO.setAddress(getAddressBO(passportInfoDTO.getAddress()));
		}
		passportInfoBO.setCountryOfIssue(passportInfoDTO.getCountryOfIssue());
		if(passportInfoDTO.getExpirationDate()!=null)
		{
		passportInfoBO.setExpirationDate(dateConverter(passportInfoDTO.getExpirationDate()));
		}
		passportInfoBO.setNationality(passportInfoDTO.getNationality());
		passportInfoBO.setPassportNumber(passportInfoDTO.getPassportNumber());
		
		return passportInfoBO;
		
	}
	
	

	/**
	 * Method to prepare GusetInfo BO
	 * @param guestInfoDTO
	 * @return GuestInfo
	 */
	public static com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guestinfo.v1.GuestInfo getGuestInfoBO(com.kcdata.abe.data.dto.GuestInfo guestInfoDTO)
	{
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guestinfo.v1.GuestInfo guestInfoBO = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guestinfo.v1.GuestInfo();
		guestInfoBO.setAge(guestInfoDTO.getAge());
		guestInfoBO.setAirRemarks(guestInfoDTO.getAirRemarks());
		guestInfoBO.setAirRequest(guestInfoDTO.getAirRequest());
		guestInfoBO.setBookingNo(null);
		guestInfoBO.setCateringRequest(guestInfoDTO.getCateringRequest());
		guestInfoBO.setChangeType(guestInfoDTO.getChangeType());
		guestInfoBO.setCruiseRemarks(guestInfoDTO.getCruiseRemarks());
		if(guestInfoDTO.getDateOfBirth()!=null)
		{
		guestInfoBO.setDateOfBirth(dateConverter(guestInfoDTO.getDateOfBirth()));
		}
		guestInfoBO.setEmailId(guestInfoDTO.getEmailId());
		guestInfoBO.setEmergencyContactName(guestInfoDTO.getEmergencyContactName());
		guestInfoBO.setEmergencyContactPhone(guestInfoDTO.getEmergencyContactPhone());
		guestInfoBO.setFirstName(guestInfoDTO.getFirstName());
		guestInfoBO.setFrequentFlyerNo(guestInfoDTO.getFrequentFlyerNo());
		guestInfoBO.setGender(guestInfoDTO.getGender());
		guestInfoBO.setGroundRequest(guestInfoDTO.getGroundRequest());
		guestInfoBO.setGuestId(guestInfoDTO.getGuestId());
		guestInfoBO.setHotelRemarks(guestInfoDTO.getHotelRemarks());
		guestInfoBO.setLapChild(guestInfoDTO.isLapChild());
		guestInfoBO.setLastName(guestInfoDTO.getLastName());
		guestInfoBO.setMealRequest(guestInfoDTO.getMealRequest());
		guestInfoBO.setMiddleName(guestInfoDTO.getMiddleName());
		guestInfoBO.setOldPaxId(guestInfoDTO.getOldPaxId());
		guestInfoBO.setParentGuestId(guestInfoDTO.getParentGuestId());
		//guestInfoBO.setPassportInfo(guestInfoDTO.getPassportInfo());
		guestInfoBO.setPaxWeight(guestInfoDTO.getPaxWeight());
		guestInfoBO.setPhoneNumber(guestInfoDTO.getPhoneNumber());
		guestInfoBO.setRedressNumber(guestInfoDTO.getRedressNumber());
		guestInfoBO.setSeatPreference(guestInfoDTO.getSeatPreference());
		guestInfoBO.setSelectedFlag(guestInfoDTO.getSelectedFlag());
		guestInfoBO.setStatus(guestInfoDTO.getStatus());
		guestInfoBO.setTitle(guestInfoDTO.getTitle());
		if(guestInfoDTO.getPassportInfo()!=null)
		{
		guestInfoBO.setPassportInfo(getPassportInfoBO(guestInfoDTO.getPassportInfo()));
		}
		
		if(guestInfoDTO.getPriceBreakup()!=null)
		{
		guestInfoBO.setPriceBreakup(getGuestPriceBreakupBO(guestInfoDTO.getPriceBreakup()));
		}
	
		if(guestInfoDTO.getAgeCode()!=null)
		{
		guestInfoBO.setAgeCode(getAgeCodeBO(guestInfoDTO.getAgeCode()));
		}
		
		return guestInfoBO;
	}
	
	/**
	 * Method to prepare GuestPriceBreakUP
	 * @param guestPriceBreakupDTO
	 * @return GuestPriceBreakup
	 * 
	 */
	public static GuestPriceBreakup getGuestPriceBreakupBO(com.kcdata.abe.data.dto.GuestPriceBreakup guestPriceBreakupDTO)
	
	{
	GuestPriceBreakup guestpriceBreakupBO = new GuestPriceBreakup();
	
		
	guestpriceBreakupBO.setBasePrice(guestPriceBreakupDTO.getBasePrice());
	guestpriceBreakupBO.setFees(guestPriceBreakupDTO.getFees());
	guestpriceBreakupBO.setFlightPrice(guestPriceBreakupDTO.getFlightPrice());
	guestpriceBreakupBO.setHotelPrice(guestPriceBreakupDTO.getHotelPrice());
	guestpriceBreakupBO.setInsurancePrice(guestPriceBreakupDTO.getInsurancePrice());
	guestpriceBreakupBO.setServicePrice(guestPriceBreakupDTO.getServicePrice());
	guestpriceBreakupBO.setSupplementsPrice(guestPriceBreakupDTO.getSupplementsPrice());
	guestpriceBreakupBO.setTaxPrice(guestPriceBreakupDTO.getTaxPrice());
	guestpriceBreakupBO.setTotalPrice(guestPriceBreakupDTO.getTotalPrice());
	guestpriceBreakupBO.setVehiclePrice(guestPriceBreakupDTO.getVehiclePrice());
	return guestpriceBreakupBO;
	
	}
	
	/**
	 * Method to Prepare HotelOptions BO
	 * @param hotelOptionsDTO
	 * @return HotelOptions
	 * 
	 */
	public static HotelOptions getHotelOptionsBO(com.kcdata.abe.data.dto.HotelOptions hotelOptionsDTO)
	{
		HotelOptions hotelOptionsBO = new HotelOptions();
		hotelOptionsBO.setAppleRating(hotelOptionsDTO.getAppleRating());
		hotelOptionsBO.setHotelChain(hotelOptionsDTO.getHotelChain());
		hotelOptionsBO.setHotelCode(hotelOptionsDTO.getHotelCode());
		hotelOptionsBO.setHotelName(hotelOptionsDTO.getHotelName());
		hotelOptionsBO.setNoOfRooms(hotelOptionsDTO.getNoOfRooms());
		hotelOptionsBO.setRatePlanCode(hotelOptionsDTO.getRatePlanCode());
		hotelOptionsBO.setRoomTypeCode(hotelOptionsDTO.getRoomTypeCode());
		hotelOptionsBO.setShowAll(hotelOptionsDTO.isShowAll());
		
		if(hotelOptionsDTO.getResortArea()!=null)
		{
			hotelOptionsBO.setResortArea(getResortAreaBO(hotelOptionsDTO.getResortArea()));
		}
		if(hotelOptionsDTO.getAmenities()!=null)
		{
			for(int i=0;i<hotelOptionsDTO.getAmenities().size();i++)
			{
				hotelOptionsBO.getAmenities().add(i, getAmenityBO(hotelOptionsDTO.getAmenities().get(i)));
			}
		}
		//hotelOptionsBO.setImApplicationInfo(getImApplicationInfo());
		
		
		return hotelOptionsBO;
	}
	

	/**
	 * Method to Prepare DestinationOptions BO
	 * @param destinationOptionsDTO
	 * @return DestinationOptions
	 * 
	 */
	
	public static com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destinationoptions.v1.DestinationOptions getdestinationOptionsBO(DestinationOptions destinationOptionsDTO)
	{
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destinationoptions.v1.DestinationOptions destinationOptionsBO =
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destinationoptions.v1.DestinationOptions();
		
		destinationOptionsBO.setAirRequested(destinationOptionsDTO.isAirRequested());
		destinationOptionsBO.setAlternateGatewayMiles(destinationOptionsDTO.getAlternateGatewayMiles());
		destinationOptionsBO.setCharterOnly(destinationOptionsDTO.isCharterOnly());
		destinationOptionsBO.setDestination(destinationOptionsDTO.getDestination());
		destinationOptionsBO.setDestinationId(destinationOptionsDTO.getDestinationId());
		destinationOptionsBO.setDoubleConnections(destinationOptionsDTO.getDoubleConnections());
		destinationOptionsBO.setFlexiDateIndicator(destinationOptionsDTO.isFlexiDateIndicator());
		destinationOptionsBO.setHotelRequested(destinationOptionsDTO.isHotelRequested());
		destinationOptionsBO.setMultiCarrierFlights(destinationOptionsDTO.getMultiCarrierFlights());
		destinationOptionsBO.setNearbyAirportIndicator(destinationOptionsDTO.isNearbyAirportIndicator());
		destinationOptionsBO.setNonStopFlights(destinationOptionsDTO.getNonStopFlights());
		destinationOptionsBO.setNoOfAirOptions(destinationOptionsDTO.getNoOfAirOptions());
		destinationOptionsBO.setNoOfNights(destinationOptionsDTO.getNoOfNights());
		destinationOptionsBO.setSkedOnly(destinationOptionsDTO.isSkedOnly());
		destinationOptionsBO.setVehicleRequested(destinationOptionsDTO.isVehicleRequested());
		
		if(destinationOptionsDTO.getOutboundAirOptions()!=null)
		{
			AirOptions outBoundAirOptionsDTO =destinationOptionsDTO.getOutboundAirOptions();
			com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.airoptions.v1.AirOptions outBoundAirOptionsBO = 
				new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.airoptions.v1.AirOptions();
			if(outBoundAirOptionsDTO!=null)
			{
			outBoundAirOptionsBO = getAirOptionsBO(outBoundAirOptionsDTO);
			destinationOptionsBO.setOutboundAirOptions(outBoundAirOptionsBO);
			}
		}

		if(destinationOptionsDTO.getInboundAirOptions()!=null)
		{
			destinationOptionsBO.setInboundAirOptions(getAirOptionsBO(destinationOptionsDTO.getInboundAirOptions()));
		}
		if(destinationOptionsDTO.getVehicleOptions()!=null)
		{
			destinationOptionsBO.setVehicleOptions(getVehicleOptionsBO(destinationOptionsDTO.getVehicleOptions()));
		}
		if(destinationOptionsDTO.getSpecialOptions()!=null)
		{
			destinationOptionsBO.setSpecialOptions(getSpecialOptionsBO(destinationOptionsDTO.getSpecialOptions()));
		}
		
		//Prepare List of Carriers preferredCarriersList for DestinationOptions
		if(destinationOptionsDTO.getPreferredCarriersList()!=null)
		{
			for(int i=0;i<destinationOptionsDTO.getPreferredCarriersList().size();i++)
			{
				if(destinationOptionsDTO.getPreferredCarriersList().get(i)!=null)
				{
				Carrier carrierBO = getCarriersBO(destinationOptionsDTO.getPreferredCarriersList().get(i));
				destinationOptionsBO.getPreferredCarriersList().add(i, carrierBO);
				}
			}
		}
		
		//Prepare List nearByDestinations for DestinationOptions BO
		if(destinationOptionsDTO.getNearByDestinations()!=null)
		{
			for(int i=0;i<destinationOptionsDTO.getNearByDestinations().size();i++)
			{
				destinationOptionsBO.getNearByDestinations().add(i, destinationOptionsDTO.getNearByDestinations().get(i));
			}
			
		}
		
		//Prepare HotelOptions BO for DestinationOptions BO
		
		if(destinationOptionsDTO.getHotelOptions()!=null)
		{
			destinationOptionsBO.setHotelOptions(getHotelOptionsBO(destinationOptionsDTO.getHotelOptions()));
		}
		return destinationOptionsBO;		
		
	}
	

	
	public static com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel getListOfHotels(com.kcdata.abe.data.dto.Hotel hotel)
	{
			
		
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel hotelBO;
		ResortArea resortAreaBO;
		Vendor vendorBO;
		RoomCategory displayRoomCategoryBO;
		
		com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.occupancy.v1.Occupancy occupancyBO = 
			new com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.occupancy.v1.Occupancy();
		
			hotelBO=new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel();
			resortAreaBO = new ResortArea();
			vendorBO = new Vendor();
			displayRoomCategoryBO = new RoomCategory();
			com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.searchcriteria.v1.SearchCriteria searchCriteriaBO =
				new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.searchcriteria.v1.SearchCriteria();
			
			
			hotelBO.setAppleRating(hotel.getAppleRating());
			if(hotel.getCheckInDate()!=null)
			{
			hotelBO.setCheckInDate(dateConverter(hotel.getCheckInDate()));
			}
			if(hotel.getCheckOutDate()!=null)
			{
			hotelBO.setCheckOutDate(dateConverter(hotel.getCheckOutDate()));
			}
			hotelBO.setHotelChain(hotel.getHotelChain());
			hotelBO.setHotelCityCode(hotel.getHotelCityCode());
			hotelBO.setHotelId(hotel.getHotelId());
			hotelBO.setCurrency(hotel.getCurrency());
			hotelBO.setHotelCode(hotel.getHotelCode());
			hotelBO.setHotelName(hotel.getHotelName());
			hotelBO.setMinRate(hotel.getMinRate());
			hotelBO.setNoOfNights(hotel.getNoOfNights());
			hotelBO.setNoOfRooms(hotel.getNoOfRooms());
			hotelBO.setOriginLocation(hotel.getOriginLocation());
			hotelBO.setPackageHotelNoChange(hotel.isPackageHotelNoChange());
			hotelBO.setRiskHotel(hotel.isRiskHotel());
			hotelBO.setAppleSpecialsAndSavers(hotel.isAppleSpecialsAndSavers());
			hotelBO.setNoOfRequestedRooms(hotel.getNoOfRequestedRooms());
			
			//Prepare ResortArea BO
			
			if(hotel.getResortArea()!=null)
			{
				resortAreaBO.setResortAreaCode(hotel.getResortArea().getResortAreaCode());
				resortAreaBO.setResortAreaName(hotel.getResortArea().getResortAreaName());
				
			}
			//set ResortArea in HotelBO
			
			hotelBO.setResortArea(resortAreaBO);
			
			//prepare Vendor BO
			if(hotel.getVendor()!=null)
			{
				vendorBO.setCity(hotel.getVendor().getCity());
				vendorBO.setCountry(hotel.getVendor().getCountry());
				vendorBO.setEmail(hotel.getVendor().getEmail());
				vendorBO.setFaxNo(hotel.getVendor().getFaxNo());
				vendorBO.setFirstName(hotel.getVendor().getFirstName());
				vendorBO.setLastName(hotel.getVendor().getLastName());
				vendorBO.setMode(hotel.getVendor().getMode());
				vendorBO.setPhone(hotel.getVendor().getPhone());
				vendorBO.setPostalCode(hotel.getVendor().getPostalCode());
				vendorBO.setRegion(hotel.getVendor().getRegion());
				vendorBO.setStreetAddrs(hotel.getVendor().getStreetAddrs());
				
				//need to check because vendorExist is boolean in ABE but in WESB it is String
				vendorBO.setVendorExist(null);
				vendorBO.setVendorId(hotel.getVendor().getVendorId());
				
				//set Vendor BO in Hotel
				hotelBO.setVendor(vendorBO);
				
			}
			
			List<VendorService> listOfVendorServiceDTO = hotel.getVendorServices();
			List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vendorservice.v1.VendorService> listOfVendorServiceBO =  new ArrayList<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vendorservice.v1.VendorService>();
			if(listOfVendorServiceDTO!=null)
			{
			for(int i=0;i<listOfVendorServiceDTO.size();i++)
			{
				com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vendorservice.v1.VendorService vendorSrviceBO = 
					new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vendorservice.v1.VendorService(); 
				vendorSrviceBO.setCurrency(listOfVendorServiceDTO.get(i).getCurrency());
				vendorSrviceBO.setPrice(listOfVendorServiceDTO.get(i).getPrice());
				vendorSrviceBO.setServiceCode(listOfVendorServiceDTO.get(i).getServiceCode());
				vendorSrviceBO.setServiceName(listOfVendorServiceDTO.get(i).getServiceName());
				vendorSrviceBO.setVendorId(listOfVendorServiceDTO.get(i).getVendorId());
				hotelBO.getVendorServices().add(i,vendorSrviceBO);
				
			}
			}
			//Prepare Occupancy BO
			if(hotel.getOccupancy()!=null)
			{
				occupancyBO.setNoOfAdults(hotel.getOccupancy().getNoOfAdults());
				occupancyBO.setNoOfChilds(hotel.getOccupancy().getNoOfChilds());
				occupancyBO.setNoOfInfants(hotel.getOccupancy().getNoOfInfants());
				occupancyBO.setNoOfLapChilds(hotel.getOccupancy().getNoOfLapChilds());
				occupancyBO.setNoOfSeniors(hotel.getOccupancy().getNoOfSeniors());
				
				List<com.kcdata.abe.data.dto.Passenger> listOfPassengersDTO;
				if(hotel.getOccupancy().getPassengers()!=null)
				{
					listOfPassengersDTO=hotel.getOccupancy().getPassengers();
					if(listOfPassengersDTO!=null)
					{
					for(int i=0;i<listOfPassengersDTO.size();i++)
					{
						Passenger passengerBO = new Passenger();
						AgeCode ageCodeBO = new AgeCode();
						passengerBO.setAge(listOfPassengersDTO.get(i).getAge());
						passengerBO.setGuestCount(listOfPassengersDTO.get(i).getGuestCount());
						passengerBO.setPaxId(listOfPassengersDTO.get(i).getPaxId());
						passengerBO.setRoomNumber(listOfPassengersDTO.get(i).getRoomNumber());
						ageCodeBO.setAge(listOfPassengersDTO.get(i).getAgeCode().getAgeCode());
						//ageCodeBO.setPaxTypeCode(Character.toString(listOfPassengersDTO.get(i).getAgeCode().getPaxTypeCode()));
						passengerBO.setAgeCode(ageCodeBO);
						
						occupancyBO.getPassengers().add(i,passengerBO);
						}
					}
					
				}
				hotelBO.setOccupancy(occupancyBO);
			}
			
			//Pepare RoomCategory displayRoomCategory BO;
			
			if(hotel.getDisplayRoomCategory()!=null)
			{
				displayRoomCategoryBO.setAppleChoice(hotel.getDisplayRoomCategory().getAppleChoice());
				displayRoomCategoryBO.setCorporateId(hotel.getDisplayRoomCategory().getCorporateId());
				displayRoomCategoryBO.setCurrency(hotel.getDisplayRoomCategory().getCurrency());
				displayRoomCategoryBO.setGuaranteeAmount(hotel.getDisplayRoomCategory().getGuaranteeAmount());
				displayRoomCategoryBO.setGuaranteeMethod(hotel.getDisplayRoomCategory().getGuaranteeMethod());
				displayRoomCategoryBO.setGuaranteeRequired(hotel.getDisplayRoomCategory().getGuaranteeRequired());
				displayRoomCategoryBO.setGuaranteeType(hotel.getDisplayRoomCategory().getGuaranteeType());
				displayRoomCategoryBO.setHotelId(hotel.getDisplayRoomCategory().getHotelId());
				displayRoomCategoryBO.setMealplanDesc(hotel.getDisplayRoomCategory().getMealplanDesc());
				displayRoomCategoryBO.setNoOfRoomsAvailable(hotel.getDisplayRoomCategory().getNoOfRoomsAvailable());
				displayRoomCategoryBO.setOldPosnr(hotel.getDisplayRoomCategory().getOldPosnr());
				displayRoomCategoryBO.setPosnr(hotel.getDisplayRoomCategory().getPosnr());
				displayRoomCategoryBO.setRateIndicator(hotel.getDisplayRoomCategory().getRateIndicator());
				displayRoomCategoryBO.setRatePlanCategory(hotel.getDisplayRoomCategory().getRatePlanCategory());
				displayRoomCategoryBO.setRatePlanCode(hotel.getDisplayRoomCategory().getRatePlanCode());
				displayRoomCategoryBO.setRatePlanDescription(hotel.getDisplayRoomCategory().getRatePlanDescription());
				displayRoomCategoryBO.setRatePlanId(hotel.getDisplayRoomCategory().getRatePlanId());
				displayRoomCategoryBO.setRiskRoomCategory(hotel.getDisplayRoomCategory().isRiskRoomCategory());
				displayRoomCategoryBO.setRoomCategoryId(hotel.getDisplayRoomCategory().getRoomCategoryId());
				displayRoomCategoryBO.setRoomTypeCode(hotel.getDisplayRoomCategory().getRoomTypeCode());
				displayRoomCategoryBO.setRoomTypeDescription(hotel.getDisplayRoomCategory().getRoomTypeDescription());
				displayRoomCategoryBO.setStatus(hotel.getDisplayRoomCategory().getStatus());
				
			
				
				List<RoomPrice> displayRoomCategoryRoomPriceDTO ;
				
				//Prepare List of RoomPrce displyRoomcategory
				if(hotel.getDisplayRoomCategory().getRoomPrices()!=null)
				{
					com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice displayRoomCategoryRoomPriceBO = 
						new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice();
					displayRoomCategoryRoomPriceDTO = hotel.getDisplayRoomCategory().getRoomPrices();
					 
					if(displayRoomCategoryRoomPriceDTO!=null)
					{
					for(int i=0;i<displayRoomCategoryRoomPriceDTO.size();i++)
					{
						displayRoomCategoryRoomPriceBO = getRoomPriceBO(displayRoomCategoryRoomPriceDTO.get(i));
						displayRoomCategoryBO.getRoomPrices().add(i, displayRoomCategoryRoomPriceBO);
					}
					}
				}
				
				//Prepare displayRoomPrice BO of RoomCategory
				
				if(hotel.getDisplayRoomCategory().getDisplayRoomPrice()!=null)
				{
					com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice displayRoomPriceBO =
						new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice();
					displayRoomPriceBO = getRoomPriceBO(hotel.getDisplayRoomCategory().getDisplayRoomPrice());
					displayRoomCategoryBO.setDisplayRoomPrice(displayRoomPriceBO);
				}
				
				//Prepare List Of Aminities
				List<Amenity> listOfAmenitiesDTO;
				if(hotel.getDisplayRoomCategory().getAmenities()!=null)
				{
					listOfAmenitiesDTO = hotel.getDisplayRoomCategory().getAmenities();
					com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.amenity.v1.Amenity amenityBO =
						new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.amenity.v1.Amenity();
					for(int i=0;i<hotel.getDisplayRoomCategory().getAmenities().size();i++)
					{
						amenityBO = getAmenityBO(hotel.getDisplayRoomCategory().getAmenities().get(i));
						displayRoomCategoryBO.getAmenities().add(i, amenityBO);
					}
				}
				
				//Prepare MealPlanType BO
				if(hotel.getDisplayRoomCategory().getMealPlanType()!=null)
				{
					MealPlanType mealPlanTypeBO = new MealPlanType();
					mealPlanTypeBO.setCode(hotel.getDisplayRoomCategory().getMealPlanType().getCode());
					mealPlanTypeBO.setDescription(hotel.getDisplayRoomCategory().getMealPlanType().getDescription());
					displayRoomCategoryBO.setMealPlanType(mealPlanTypeBO);
					
				}
				
				
				
				
			hotelBO.setDisplayRoomCategory(displayRoomCategoryBO);
				
			}
			
			//Prepare List of RoomPrice for preSelectedRooms
			List<RoomPrice> roomPriceForPreselctedRoomsDTO;
			if(hotel.getPreselectedRooms()!=null)
			{
				roomPriceForPreselctedRoomsDTO = hotel.getPreselectedRooms();
				com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice preselectedRoomPriceBO =
					new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice();
				for(int i=0;i<roomPriceForPreselctedRoomsDTO.size();i++)
				{
					preselectedRoomPriceBO = getRoomPriceBO(roomPriceForPreselctedRoomsDTO.get(i));
					hotelBO.getPreselectedRooms().add(i, preselectedRoomPriceBO);
				}
			}
			
			//Prepare List of RoomPrice BO for selectedRooms
			List<RoomPrice> roomPriceForSelectedRoomsDTO;
			if(hotel.getSelectedRooms()!=null)
			{
				roomPriceForSelectedRoomsDTO =hotel.getSelectedRooms();
				com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice selectedRoomPrice = 
					new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice();
				for(int i=0;i<roomPriceForSelectedRoomsDTO.size();i++)
				{
					selectedRoomPrice =	getRoomPriceBO(hotel.getSelectedRooms().get(i));
					hotelBO.getSelectedRooms().add(i,selectedRoomPrice );
				}
			}
			
			//prepare RequestedDatesForAvailability BO
			List<RequestedDatesForAvailability> requestedDatesForAvailabilityDTO;
			if(hotel.getRequestedDatesForAvailabilities()!=null)
			{
				com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.requesteddatesforavailability.v1.RequestedDatesForAvailability requestedDatesforAvailibilityBO =
					new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.requesteddatesforavailability.v1.RequestedDatesForAvailability();
				requestedDatesForAvailabilityDTO = hotel.getRequestedDatesForAvailabilities();
				for(int i=0;i<requestedDatesForAvailabilityDTO.size();i++)
				{
					if(requestedDatesForAvailabilityDTO.get(i)!=null)
					{
					requestedDatesforAvailibilityBO = getRequestedDatesForAvailibilityBO(requestedDatesForAvailabilityDTO.get(i));
					hotelBO.getRequestedDatesForAvailabilities().add(i, requestedDatesforAvailibilityBO);
					}
				}
			}
			
			//Prepare List Of RoomCategories roomCategories
			List<com.kcdata.abe.data.dto.RoomCategory> roomCategoriesListDTO;
			if(hotel.getRoomCategories()!=null)
			{
				roomCategoriesListDTO = hotel.getRoomCategories();
				RoomCategory roomcCategoryBO = new RoomCategory(); 
				for(int i=0;i<roomCategoriesListDTO.size();i++)
				{
					roomcCategoryBO = getRoomCategoryBO(roomCategoriesListDTO.get(i));
					hotelBO.getRoomCategories().add(i, roomcCategoryBO);
				}
				
			}
			
			
			//Prepare SearchCriteria
			
			if(hotel.getSearchCriteria()!=null)
			{
				SearchCriteria searchCriteriaDTO = hotel.getSearchCriteria();
				if(searchCriteriaDTO.getAnchorDepartureDate()!=null)
				{
				searchCriteriaBO.setAnchorDepartureDate(dateConverter(searchCriteriaDTO.getAnchorDepartureDate()));
				}
				searchCriteriaBO.setAnchorGateway(searchCriteriaDTO.getAnchorGateway());
				searchCriteriaBO.setBookingNo(searchCriteriaDTO.getBookingNo());
				if(searchCriteriaDTO.getDepartureDate()!=null)
				{
				searchCriteriaBO.setDepartureDate(dateConverter(searchCriteriaDTO.getDepartureDate()));
				}
				searchCriteriaBO.setFilterSpecials(searchCriteriaDTO.isFilterSpecials());
				
				//Prepare FilterType
				if(searchCriteriaDTO.getFlightTripType()!=null)
				{
					FlightTripType flightTripTypeBO = new FlightTripType();
					flightTripTypeBO.setType(searchCriteriaDTO.getFlightTripType().getType());
					searchCriteriaBO.setFlightTripType(flightTripTypeBO);
					
				}
				searchCriteriaBO.setGateway(searchCriteriaDTO.getGateway());
				searchCriteriaBO.setPromoCode(searchCriteriaDTO.getPromoCode());
				
				//Prepare Occupancy BO for SearchCriteria BO
				
				if(hotel.getSearchCriteria().getOccupancy()!=null)
				{
					com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.occupancy.v1.Occupancy occupancyBOOfsearchCriteria =
						new com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.occupancy.v1.Occupancy();
					
					occupancyBOOfsearchCriteria = getOccuPancyBO(hotel.getSearchCriteria().getOccupancy());
					searchCriteriaBO.setOccupancy(occupancyBOOfsearchCriteria);
				}
				
				//prepare List of nearByGateways for SearchCriteria
				
				if(hotel.getSearchCriteria().getNearByGateways()!=null)
				{
					for(int i=0;i<hotel.getSearchCriteria().getNearByGateways().size();i++)
					{
						searchCriteriaBO.getNearByGateways().add(i, hotel.getSearchCriteria().getNearByGateways().get(i));
					}
				}
				
				//Prepare DestinationOptions for SearchCriteria
				
				if(hotel.getSearchCriteria().getDestinationOptions()!=null)
				{
					List<DestinationOptions> destinationOptionsDTO = hotel.getSearchCriteria().getDestinationOptions();
					for(int i=0;i<destinationOptionsDTO.size();i++)
					{
						com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destinationoptions.v1.DestinationOptions destinationOptionsBO = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destinationoptions.v1.DestinationOptions();
						destinationOptionsBO = getdestinationOptionsBO(destinationOptionsDTO.get(i));
						searchCriteriaBO.getDestinationOptions().add(i, destinationOptionsBO);
					}
				}
				
				hotelBO.setSearchCriteria(searchCriteriaBO);
			}
			
			
		return hotelBO;
	}
	
	/**
	 * Method to Prepare Service BO from Service DTO for service details
	 * @param serviceDTO
	 * @return Service
	 */
	
	public static com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service getServiceBO(com.kcdata.abe.data.dto.Service serviceDTO)
	{
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service serviceBO = 
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service();
		serviceBO.setAdultPrice(serviceDTO.getAdultPrice());
		serviceBO.setAdultQty(serviceDTO.getAdultQty());
		serviceBO.setAllOrNothing(serviceDTO.isAllOrNothing());
		serviceBO.setChild1MaxAge(serviceDTO.getChild1MaxAge());
		serviceBO.setChild2MaxAge(serviceDTO.getChild2MaxAge());
		serviceBO.setChild3MaxAge(serviceDTO.getChild3MaxAge());
		serviceBO.setChild1MinAge(serviceDTO.getChild1MinAge());
		serviceBO.setChild2MinAge(serviceDTO.getChild2MinAge());
		serviceBO.setChild3MinAge(serviceDTO.getChild3MinAge());
		serviceBO.setChild1Price(serviceDTO.getChild1Price());
		serviceBO.setChild2Price(serviceDTO.getChild2Price());
		serviceBO.setChild3Price(serviceDTO.getChild3Price());
		serviceBO.setChild1Qty(serviceDTO.getChild1Qty());
		serviceBO.setChild2Qty(serviceDTO.getChild2Qty());
		serviceBO.setChild3Qty(serviceDTO.getChild3Qty());
		serviceBO.setCurrency(serviceDTO.getCurrency());
		serviceBO.setDateSpecific(serviceDTO.isDateSpecific());
		if(serviceDTO.getDepatureDate()!=null)
		{
		serviceBO.setDepatureDate(dateConverter(serviceDTO.getDepatureDate()));
		}
		serviceBO.setDestination(serviceDTO.getDestination());
		serviceBO.setFlightMaterialCode(serviceDTO.getFlightMaterialCode());
		serviceBO.setGateway(serviceDTO.getGateway());
		serviceBO.setGroupCode(serviceDTO.getGroupCode());
		serviceBO.setGroupDescription(serviceDTO.getGroupDescription());
		serviceBO.setGuestAllocation(serviceDTO.getGuestAllocation());
		serviceBO.setFree(serviceDTO.isFree());
		serviceBO.setFriday(serviceDTO.isFriday());
		serviceBO.setHotelMaterialCode(serviceDTO.getHotelMaterialCode());
		serviceBO.setMandatory(serviceDTO.isMandatory());
		serviceBO.setMaxQuantity(serviceDTO.getMaxQuantity());
		serviceBO.setMonday(serviceDTO.isMonday());
		serviceBO.setOccupancyBased(serviceDTO.isOccupancyBased());
		serviceBO.setOldPosnr(serviceDTO.getOldPosnr());
		serviceBO.setParentItemRph(serviceDTO.getParentItemRph());
		serviceBO.setPosnr(serviceDTO.getPosnr());
		if(serviceDTO.getReturnDate()!=null)
		{
		serviceBO.setReturnDate(dateConverter(serviceDTO.getReturnDate()));
		}
		serviceBO.setSaturday(serviceDTO.isSaturday());
		if(serviceDTO.getSelectedDate()!=null)
		{
		serviceBO.setSelectedDate(dateConverter(serviceDTO.getSelectedDate()));
		}
		serviceBO.setServiceCode(serviceDTO.getServiceCode());
		serviceBO.setServiceName(serviceDTO.getServiceName());
		serviceBO.setSunday(serviceDTO.isSunday());
		serviceBO.setThursday(serviceDTO.isThursday());
		serviceBO.setTierBased(serviceDTO.isTierBased());
		serviceBO.setTuesday(serviceDTO.isTuesday());
		serviceBO.setTotalPrice(serviceDTO.getTotalPrice());
		serviceBO.setTravelAgentFee(serviceDTO.getTravelAgentFee());
		serviceBO.setUnitOfMeasure(serviceDTO.getUnitOfMeasure());
		serviceBO.setWednesday(serviceDTO.isWednesday());
		serviceBO.setWeightBased(serviceDTO.isWeightBased());
		
		if(serviceDTO.getServiceDescription()!=null)
		{
			for(int i=0;i<serviceDTO.getServiceDescription().size();i++)
			{
				if(serviceDTO.getServiceDescription().get(i)!=null)
				{
				serviceBO.getServiceDescription().add(i, serviceDTO.getServiceDescription().get(i));
				}
			}
		}
		if(serviceDTO.getAvailableDates()!=null)
		{
			for(int i=0;i<serviceDTO.getAvailableDates().size();i++)
			{
				if(serviceDTO.getAvailableDates().get(i)!=null)
				{
				serviceBO.getAvailableDates().add(i, dateConverter(serviceDTO.getAvailableDates().get(i)));
				}
			}
		}
		
		
		return serviceBO;
		
	}
}
