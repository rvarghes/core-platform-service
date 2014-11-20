/*
 * GuestInfoConvertUtil.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 19, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.kcdata.abe.bapi.Yst_Ota_GuestinfoType;
import com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType;
import com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType;
import com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Res_GuestinfoType_List;
import com.kcdata.abe.data.dto.Address;
import com.kcdata.abe.data.dto.AgeCode;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.GuestPriceBreakup;
import com.kcdata.abe.data.dto.PassportInfo;

/**
 * Utility class to convert GuestInfo object to SAP structures and vice versa
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class GuestInfoConvertUtil {

	/**
	 * Method to covert the GuestInfo object to SAP structures
	 * 
	 * @param guestsList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static Yst_Ota_GuestinfoType_List prepareGuestInfoTypeList(
			List<GuestInfo> guestsList) {
		if (guestsList == null || guestsList.size() == 0) {
			return null;
		}
		Yst_Ota_GuestinfoType_List guestInfoTypeList = new Yst_Ota_GuestinfoType_List();
		for (GuestInfo guest : guestsList) {
			Yst_Ota_GuestinfoType guestInfoType = new Yst_Ota_GuestinfoType();
			guestInfoType.setPax_Id(guest.getGuestId());
			if (guest.getAgeCode() != null) {
				guestInfoType.setAgequalifyingcode(guest.getAgeCode()
						.getAgeCode() + "");
			}
			guestInfoType.setPaxtitle(guest.getTitle());
			guestInfoType.setName_Fst(guest.getFirstName());
			guestInfoType.setName_Mdl(guest.getMiddleName());
			guestInfoType.setName_Lst(guest.getLastName());
			guestInfoType.setGender(guest.getGender());
			//IGT-S---Ticket # 3620558a--Code Revoked--Code Before 3620558a changes--START
			/*//IGT-S---Issue # 3620558---START
			if(guest.getPaxDob()!=null && !"".equals(guest.getPaxDob())){
				guestInfoType.setDatebirth(
						new java.sql.Date(
								FlightUtils.StrToDateConversion(
										guest.getPaxDob(), "MM/dd/yyyy").getTime()));
			}
			//Mantis issue #78 : Date of Birth failure for Affiliate Bookings
			else */
			//IGT-S---Ticket # 3620558a--Code Revoked--Code Before 3620558a changes--END
			if (guest.getDateOfBirth() != null) {
				guestInfoType.setDatebirth(new java.sql.Date(guest
						.getDateOfBirth().getTime()));
			}
			guestInfoType.setAge(guest.getAge() + "");
			if (guest.getPassportInfo() != null) {
				PassportInfo passportInfo = guest.getPassportInfo();
				if (passportInfo.getAddress() != null) {
					guestInfoType.setCity(passportInfo.getAddress().getCity());
					guestInfoType
							.setState(passportInfo.getAddress().getState());
					guestInfoType.setPostal_Code(passportInfo.getAddress()
							.getZipCode());
					guestInfoType.setAddress(passportInfo.getAddress()
							.getStreetAddress());
					//Start the implemention of AV3749/HBsi 52 emergency tab information for passgenger enhancement
					// Todo: Country field couldn't be require as per business
					// We are just commenting the code for future use
					//guestInfoType.setCity(passportInfo.getAddress().getCity());
					//guestInfoType.setCity(passportInfo.getAddress().getCity());
				}
					//End of the implemention of AV3749/HBsi 52 emergency tab information for passgenger enhancement
				guestInfoType.setNationality(passportInfo.getNationality());
				guestInfoType
						.setPassportissue(passportInfo.getCountryOfIssue());
				guestInfoType.setPassport(passportInfo.getPassportNumber());
				if (passportInfo.getExpirationDate() != null) {
					guestInfoType.setPassportexpdate(new java.sql.Date(
							passportInfo.getExpirationDate().getTime()));
				}
			}
			guestInfoType.setPhoneno(guest.getPhoneNumber());
			guestInfoType.setEmail(guest.getEmailId());
			guestInfoType.setEmgphone(guest.getEmergencyContactPhone());
			guestInfoType.setEmgcont(guest.getEmergencyContactName());
			guestInfoType.setParentid(guest.getParentGuestId());
			guestInfoType.setFreqfly(guest.getFrequentFlyerNo());
			guestInfoType.setAirremks(guest.getAirRemarks());
			guestInfoType.setHotremks(guest.getHotelRemarks());
			guestInfoType.setCrsremks(guest.getCruiseRemarks());
			guestInfoType.setMeal_Code(guest.getMealRequest());
			guestInfoType.setAirrequest(guest.getAirRequest());
			guestInfoType.setGroundrequest(guest.getGroundRequest());
			guestInfoType.setCateringrequest(guest.getCateringRequest());
			guestInfoType.setSeatpreference(guest.getSeatPreference());
			guestInfoType.setDhsreadress(guest.getRedressNumber());
			// Set Guest Info flags
			guestInfoType.setChange_Flag(guest.getChangeType());
			guestInfoType.setOld_Pax_Id(guest.getOldPaxId());
			guestInfoType.setPax_Weight(guest.getPaxWeight());
			guestInfoTypeList.add(guestInfoType);
		}
		return guestInfoTypeList;
	}

	/**
	 * Method processes guest info data in booking
	 * 
	 * @param guestInfoList
	 *            Guest info list in BAPI response
	 * @return Guest info list
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<GuestInfo> processGuestInfo(
			Yst_Ota_Res_GuestinfoType_List guestInfoList) {
		ArrayList<GuestInfo> guests = null;

		if (guestInfoList != null && !guestInfoList.isEmpty()) {
			guests = new ArrayList<GuestInfo>();

			Iterator<Yst_Ota_Res_GuestinfoType> itGuestInfo = guestInfoList
					.iterator();

			while (itGuestInfo.hasNext()) {
				Yst_Ota_Res_GuestinfoType guestInfoRow = itGuestInfo.next();
				GuestInfo guestInfo = new GuestInfo();
				guestInfo.setGuestId(""
						+ Integer.parseInt(guestInfoRow.getPax_Id()));
				guestInfo.setTitle(guestInfoRow.getPaxtitle());
				guestInfo.setFirstName(guestInfoRow.getName_Fst());
				guestInfo.setMiddleName(guestInfoRow.getName_Mdl());
				guestInfo.setLastName(guestInfoRow.getName_Lst());
				guestInfo.setAge(Byte.parseByte(guestInfoRow.getAge()));
				// Set age code
				prepareAgeCode(guestInfo, guestInfoRow.getAgequalifyingcode());

				if (guestInfoRow.getGender() != null)
					guestInfo.setGender(guestInfoRow.getGender());
				if (guestInfoRow.getDatebirth() != null)
					guestInfo.setDateOfBirth(guestInfoRow.getDatebirth());
				//IGT-S---Ticket # 3620558a--Code Revoked--Code Before 3620558a changes--START
				/*//Issue # 3620558---IGT-S--START
				//Providing flex side the paxDob String
				if(guestInfoRow.getDatebirth() != null)
					guestInfo.setPaxDob(FlightUtils.DateToStrConversion(guestInfoRow.getDatebirth(), "MM/dd/yyyy"));
				//Issue # 3620558---IGT-S--END
				 */				
				//IGT-S---Ticket # 3620558a--Code Revoked--Code Before 3620558a changes--END
				if (guestInfoRow.getEmail() != null)
					guestInfo.setEmailId(guestInfoRow.getEmail());
				if (guestInfoRow.getPhoneno() != null)
					guestInfo.setPhoneNumber(guestInfoRow.getPhoneno());
				if (guestInfoRow.getParentid() != null
						&& !guestInfoRow.getParentid().trim().equals(""))
					guestInfo.setParentGuestId(""
							+ Integer.parseInt(guestInfoRow.getParentid()));

				if (guestInfoRow.getEmgcont() != null)
					guestInfo
							.setEmergencyContactName(guestInfoRow.getEmgcont());
				if (guestInfoRow.getEmgphone() != null)
					guestInfo.setEmergencyContactPhone(guestInfoRow
							.getEmgphone());

				// Set passport details
				guestInfo.setPassportInfo(preparePassportInfo(guestInfoRow));

				if (guestInfoRow.getHotremks() != null)
					guestInfo.setHotelRemarks(guestInfoRow.getHotremks());
				if (guestInfoRow.getSeatpreference() != null)
					guestInfo.setSeatPreference(guestInfoRow
							.getSeatpreference());
				if (guestInfoRow.getAirremks() != null)
					guestInfo.setAirRemarks(guestInfoRow.getAirremks());
				if (guestInfoRow.getAirrequest() != null)
					guestInfo.setAirRequest(guestInfoRow.getAirrequest());
				if (guestInfoRow.getFreqfly() != null)
					guestInfo.setFrequentFlyerNo(guestInfoRow.getFreqfly());
				if (guestInfoRow.getGroundrequest() != null)
					guestInfo.setGroundRequest(guestInfoRow.getGroundrequest());
				if (guestInfoRow.getMeal_Code() != null)
					guestInfo.setMealRequest(guestInfoRow.getMeal_Code());
				if (guestInfoRow.getCateringrequest() != null)
					guestInfo.setCateringRequest(guestInfoRow
							.getCateringrequest());
				if (guestInfoRow.getCrsremks() != null)
					guestInfo.setCruiseRemarks(guestInfoRow.getCrsremks());
				if (guestInfoRow.getDhsreadress() != null) {
					guestInfo.setRedressNumber(guestInfoRow.getDhsreadress());
				}
				if (guestInfoRow.getPax_Weight() != null) {
					guestInfo.setPaxWeight(guestInfoRow.getPax_Weight());
				}
				guestInfo.setPnrNumber(guestInfoRow.getPnrnumber());
				guestInfo.setStatus(guestInfoRow.getPax_Bkst());

				guests.add(guestInfo);
			}
		}

		return guests;
	}

	/**
	 * Method processes guest info data in booking
	 * 
	 * @param guestInfoList
	 *            Guest info list in BAPI response
	 * @return Guest info list
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<GuestInfo> processQuotedGuestInfo(
			Yst_Ota_GuestinfoType_List guestInfoList) {
		ArrayList<GuestInfo> guests = null;

		if (guestInfoList != null && !guestInfoList.isEmpty()) {
			guests = new ArrayList<GuestInfo>();

			Iterator<Yst_Ota_GuestinfoType> itGuestInfo = guestInfoList
					.iterator();

			while (itGuestInfo.hasNext()) {
				Yst_Ota_GuestinfoType guestInfoRow = itGuestInfo.next();
				GuestInfo guestInfo = new GuestInfo();
				guestInfo.setGuestId(""
						+ Integer.parseInt(guestInfoRow.getPax_Id()));
				guestInfo.setTitle(guestInfoRow.getPaxtitle());
				guestInfo.setFirstName(guestInfoRow.getName_Fst());
				guestInfo.setMiddleName(guestInfoRow.getName_Mdl());
				guestInfo.setLastName(guestInfoRow.getName_Lst());
				guestInfo.setAge(Byte.parseByte(guestInfoRow.getAge()));
				// Set age code
				prepareAgeCode(guestInfo, guestInfoRow.getAgequalifyingcode());

				if (guestInfoRow.getGender() != null)
					guestInfo.setGender(guestInfoRow.getGender());
				if (guestInfoRow.getDatebirth() != null)
					guestInfo.setDateOfBirth(guestInfoRow.getDatebirth());
				if (guestInfoRow.getEmail() != null)
					guestInfo.setEmailId(guestInfoRow.getEmail());
				if (guestInfoRow.getPhoneno() != null)
					guestInfo.setPhoneNumber(guestInfoRow.getPhoneno());
				if (guestInfoRow.getParentid() != null)
					guestInfo.setParentGuestId(""
							+ Integer.parseInt(guestInfoRow.getParentid()));

				if (guestInfoRow.getEmgcont() != null)
					guestInfo
							.setEmergencyContactName(guestInfoRow.getEmgcont());
				if (guestInfoRow.getEmgphone() != null)
					guestInfo.setEmergencyContactPhone(guestInfoRow
							.getEmgphone());

				// Set passport details
				guestInfo
						.setPassportInfo(prepareQuotedPassportInfo(guestInfoRow));

				if (guestInfoRow.getHotremks() != null)
					guestInfo.setHotelRemarks(guestInfoRow.getHotremks());
				if (guestInfoRow.getSeatpreference() != null)
					guestInfo.setSeatPreference(guestInfoRow
							.getSeatpreference());
				if (guestInfoRow.getAirremks() != null)
					guestInfo.setAirRemarks(guestInfoRow.getAirremks());
				if (guestInfoRow.getAirrequest() != null)
					guestInfo.setAirRequest(guestInfoRow.getAirrequest());
				if (guestInfoRow.getFreqfly() != null)
					guestInfo.setFrequentFlyerNo(guestInfoRow.getFreqfly());
				if (guestInfoRow.getGroundrequest() != null)
					guestInfo.setGroundRequest(guestInfoRow.getGroundrequest());
				if (guestInfoRow.getMeal_Code() != null)
					guestInfo.setMealRequest(guestInfoRow.getMeal_Code());
				if (guestInfoRow.getCateringrequest() != null)
					guestInfo.setCateringRequest(guestInfoRow
							.getCateringrequest());
				if (guestInfoRow.getCrsremks() != null)
					guestInfo.setCruiseRemarks(guestInfoRow.getCrsremks());
				if (guestInfoRow.getDhsreadress() != null) {
					guestInfo.setRedressNumber(guestInfoRow.getDhsreadress());
				}
				if (guestInfoRow.getPax_Weight() != null) {
					guestInfo.setPaxWeight(guestInfoRow.getPax_Weight());
				}
				guests.add(guestInfo);
			}
		}

		return guests;
	}

	/**
	 * Prepares age code to guest info based on age qualifying code
	 * 
	 * @param guestInfo
	 * @param ageQualifyingCode
	 * 
	 * @see
	 * @since
	 */
	private static void prepareAgeCode(GuestInfo guestInfo,
			String ageQualifyingCode) {
		if (ageQualifyingCode == null)
			return;
		int ageCode = Integer.parseInt(ageQualifyingCode);
		if (ageCode == AgeCode.ADULT.getAgeCode())
			guestInfo.setAgeCode(AgeCode.ADULT);
		else if (ageCode == AgeCode.CHILD.getAgeCode())
			guestInfo.setAgeCode(AgeCode.CHILD);
		else if (ageCode == AgeCode.INFANT.getAgeCode())
			guestInfo.setAgeCode(AgeCode.INFANT);
		else if (ageCode == AgeCode.LAPCHILD.getAgeCode())
			guestInfo.setAgeCode(AgeCode.LAPCHILD);
		else if (ageCode == AgeCode.SENIOR.getAgeCode())
			guestInfo.setAgeCode(AgeCode.SENIOR);
	}

	/**
	 * Method prepares passport info
	 * 
	 * @param guestInfoRow
	 * @return PassportInfo object
	 * 
	 * @see
	 * @since
	 */
	private static PassportInfo preparePassportInfo(
			Yst_Ota_Res_GuestinfoType guestInfoRow) {
		PassportInfo passportInfo = new PassportInfo();
		// Set passport details
		if (guestInfoRow.getPassport() != null)
			passportInfo.setPassportNumber(guestInfoRow.getPassport());
		if (guestInfoRow.getPassportexpdate() != null)
			passportInfo.setExpirationDate(guestInfoRow.getPassportexpdate());
		if (guestInfoRow.getPassportissue() != null)
			passportInfo.setCountryOfIssue(guestInfoRow.getPassportissue());
		if (guestInfoRow.getNationality() != null)
			passportInfo.setNationality(guestInfoRow.getNationality());
		// Prepare address details
		Address address = new Address();
		if (guestInfoRow.getCity() != null)
			address.setCity(guestInfoRow.getCity());
		if (guestInfoRow.getState() != null)
			address.setState(guestInfoRow.getState());
		if (guestInfoRow.getPostal_Code() != null)
			address.setZipCode(guestInfoRow.getPostal_Code());
		if (guestInfoRow.getAddress() != null)
			address.setStreetAddress(guestInfoRow.getAddress());
		// Set address to passport
		passportInfo.setAddress(address);

		return passportInfo;
	}

	/**
	 * Method prepares passport info
	 * 
	 * @param guestInfoRow
	 * @return PassportInfo object
	 * 
	 * @see
	 * @since
	 */
	private static PassportInfo prepareQuotedPassportInfo(
			Yst_Ota_GuestinfoType guestInfoRow) {
		PassportInfo passportInfo = new PassportInfo();
		// Set passport details
		if (guestInfoRow.getPassport() != null)
			passportInfo.setPassportNumber(guestInfoRow.getPassport());
		if (guestInfoRow.getPassportexpdate() != null)
			passportInfo.setExpirationDate(guestInfoRow.getPassportexpdate());
		if (guestInfoRow.getPassportissue() != null)
			passportInfo.setCountryOfIssue(guestInfoRow.getPassportissue());
		if (guestInfoRow.getNationality() != null)
			passportInfo.setNationality(guestInfoRow.getNationality());
		// Prepare address details
		Address address = new Address();
		if (guestInfoRow.getCity() != null)
			address.setCity(guestInfoRow.getCity());
		if (guestInfoRow.getState() != null)
			address.setState(guestInfoRow.getState());
		if (guestInfoRow.getPostal_Code() != null)
			address.setZipCode(guestInfoRow.getPostal_Code());
		if (guestInfoRow.getAddress() != null)
			address.setStreetAddress(guestInfoRow.getAddress());
		// Set address to passport
		passportInfo.setAddress(address);

		return passportInfo;
	}

	/**
	 * Method to process pax level pricing
	 * 
	 * @param guests
	 * @param paxPriceList
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static void processPaxPriceBreakup(List<GuestInfo> guests,
			Yst_Ota_Pax_PricingType_List paxPriceList) {
		if (guests == null)
			return;
		// Clear the pricing structures before pasrsing the new values
		for (GuestInfo guest : guests) {
			guest.setPriceBreakup(null);
		}
		if (paxPriceList == null || paxPriceList.isEmpty()) {
			return;
		}
		Iterator<Yst_Ota_Pax_PricingType> paxPriceIterator = paxPriceList
				.iterator();
		while (paxPriceIterator.hasNext()) {
			Yst_Ota_Pax_PricingType paxPrice = paxPriceIterator.next();
			GuestPriceBreakup priceBreakup = new GuestPriceBreakup();
			priceBreakup.setFees(paxPrice.getFees().doubleValue());
			priceBreakup.setFlightPrice(paxPrice.getFlight_Net_Amt()
					.doubleValue());
			priceBreakup.setHotelPrice(paxPrice.getHotel_Net_Amt()
					.doubleValue());
			priceBreakup.setVehiclePrice(paxPrice.getVehicle_Net_Amt()
					.doubleValue());
			priceBreakup.setInsurancePrice(paxPrice.getIns_Amt().doubleValue());
			priceBreakup.setServicePrice(paxPrice.getServices_Amt()
					.doubleValue());
			priceBreakup.setTaxPrice(paxPrice.getTaxes().doubleValue());
			priceBreakup.setTotalPrice(paxPrice.getTotal().doubleValue());
			priceBreakup.setBasePrice(paxPrice.getBaseprice().doubleValue());
			for (GuestInfo guest : guests) {
				if (paxPrice.getPax_Id() != null && guest.getGuestId() != null) {
					if (Integer.parseInt(paxPrice.getPax_Id()) == Integer
							.parseInt(guest.getGuestId())) {
						guest.setPriceBreakup(priceBreakup);
					}
				}
			}
		}
	}
}
