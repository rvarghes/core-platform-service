/*
 * InsuranceConvertUtils.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 25, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.kcdata.abe.bapi.Y_Bapi_Insurance_Availability_Output;
import com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType;
import com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType;
import com.kcdata.abe.bapi.Yst_Bapi_Long_TextType;
import com.kcdata.abe.bapi.Yst_Bapi_Res_InsType;
import com.kcdata.abe.bapi.util.Yst_Bapi_Ins_AvailabilityType_List;
import com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Bapi_Long_TextType_List;
import com.kcdata.abe.bapi.util.Yst_Bapi_Res_InsType_List;
import com.kcdata.abe.data.dto.Insurance;
import com.kcdata.abe.data.dto.InsuranceGroup;
import com.kcdata.abe.data.dto.InsuranceGuestAllocation;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.SearchCriteria;

/**
 * Utility class for converting Insurance DTO to SAP structures and vice versa
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class InsuranceConvertUtils {

	/**
	 * Method to convert Insurance DTO object to
	 * 
	 * @param insurance
	 * @param itemRph
	 * @param pricing
	 * 
	 * @see
	 * @since
	 */
	public static Yst_Bapi_Ins_ItemsType prepareInsuranceType(
			Insurance insurance, byte itemRph) {
		Yst_Bapi_Ins_ItemsType insuranceItemType = new Yst_Bapi_Ins_ItemsType();
		insuranceItemType.setItem_Rph(itemRph + "");
		insuranceItemType.setMaterial(insurance.getMaterialNo());
		insuranceItemType.setMaterail_Desc(insurance.getMaterailDesc());
		if (insurance.getValidDateFrom() != null) {
			insuranceItemType.setValiddatefm(new java.sql.Date(insurance
					.getValidDateFrom().getTime()));
		}
		if (insurance.getValidDateTo() != null) {
			insuranceItemType.setValiddateto(new java.sql.Date(insurance
					.getValidDateTo().getTime()));
		}
		insuranceItemType.setVacationtype(insurance.getVacationType());
		insuranceItemType.setVacationdesc(insurance.getVacationDescription());
		insuranceItemType.setOptionins(insurance.getOptionIns());
		if (insurance.getGuestAllocation() == null
				|| "".equals(insurance.getGuestAllocation())) {
			insuranceItemType.setAdult_Price(new BigDecimal(insurance
					.getAdultPrice()));
			insuranceItemType.setChild_Price(new BigDecimal(insurance
					.getChildPrice()));
			insuranceItemType.setChildruledesc(insurance.getChildRuleDesc());
			insuranceItemType.setChildminage("" + insurance.getChildMinAge());
			insuranceItemType.setChildmaxage(insurance.getChildMaxAge() + "");
			insuranceItemType.setNo_Adults(insurance.getAdultsQty());
			insuranceItemType.setNo_Child("" + insurance.getChildsQty());
			insuranceItemType.setNo_Infants("" + insurance.getInfantsQty());
			insuranceItemType.setNo_Lapchild(insurance.getLapChildQty() + "");
			insuranceItemType.setNo_Seniors(insurance.getSeniorsQty() + "");
			// Set child ages if childs exists
			if (insurance.getChildsQty() > 0
					&& insurance.getChildAges() != null
					&& insurance.getChildAges().size() > 0) {
				byte count = 0;
				for (Integer childAge : insurance.getChildAges()) {
					if (childAge != null) {
						switch (++count) {
						case 1:
							insuranceItemType.setChild1_Age(childAge + "");
							break;
						case 2:
							insuranceItemType.setChild2_Age(childAge + "");
							break;
						case 3:
							insuranceItemType.setChild3_Age(childAge + "");
							break;
						case 4:
							insuranceItemType.setChild4_Age(childAge + "");
							break;
						case 5:
							insuranceItemType.setChild5_Age(childAge + "");
							break;
						case 6:
							insuranceItemType.setChild6_Age(childAge + "");
							break;
						}
					}
				}
			}
		} else {
			// Set POSNR values
			insuranceItemType.setPax_Alloc_Rph(insurance.getGuestAllocation());
			insuranceItemType.setPosnr(insurance.getPosnr());
			insuranceItemType.setOld_Posnr(insurance.getOldPosnr());
			//Added for TourGuard issue to set Adult, Child and Total Price. 
			/*insuranceItemType.setAdult_Price(new BigDecimal(insurance
					.getAdultPrice()));
			insuranceItemType.setChild_Price(new BigDecimal(insurance
					.getChildPrice()));
			insuranceItemType.setTotal(getBigDecimalPrice(insurance.getTotalPrice()));*/
			
		}
		return insuranceItemType;
	}
// Method added to handle insurance total price
	
	public static BigDecimal getBigDecimalPrice(Double val){
		BigDecimal price = null;
		try{
		price = new BigDecimal(val);
		}
		catch(Exception e){
			price = new BigDecimal(0);
		}
		return price;
	}

	/**
	 * Method to process the insurance response
	 * 
	 * @param bapiOutput
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<InsuranceGroup> processInsuranceResponse(
			Y_Bapi_Insurance_Availability_Output bapiOutput,
			SearchCriteria searchCriteria) {
		// Prepare insurance options
		Yst_Bapi_Ins_AvailabilityType_List insuranceAvailList = bapiOutput
				.get_as_listIt_Ins_Avail();

		// Prepare Insurance option description list
		Yst_Bapi_Long_TextType_List insuranceOptionDesc = bapiOutput
				.get_as_listIt_Mat_Long_Text();

		// Prepare insurance groups
		HashMap<String, InsuranceGroup> groupMap = new HashMap<String, InsuranceGroup>();

		Iterator<Yst_Bapi_Ins_AvailabilityType> itInsuranceList = insuranceAvailList
				.iterator();
		String insuranceDesc;
		List<Integer> childAges = null;
		if (searchCriteria != null && searchCriteria.getOccupancy() != null
				&& searchCriteria.getOccupancy().getNoOfChilds() > 0
				&& searchCriteria.getOccupancy().getPassengers() != null) {
			childAges = new ArrayList<Integer>();
			for (Passenger passenger : searchCriteria.getOccupancy()
					.getPassengers()) {
				if (passenger.getAgeCode().isChild()) {
					childAges.add(new Integer(passenger.getAge()));
				}
			}
		}
		while (itInsuranceList.hasNext()) {
			Yst_Bapi_Ins_AvailabilityType insuranceDetailRow = itInsuranceList
					.next();
			Iterator<Yst_Bapi_Long_TextType> itInsuranceOptionDescList = insuranceOptionDesc
					.iterator();
			if (insuranceDetailRow != null) {
				Insurance insurance = new Insurance();
				insurance.setItemRPH(Integer.parseInt(insuranceDetailRow
						.getItem_Rph()));
				insurance.setMaterialNo(insuranceDetailRow.getMaterial());
				insurance
						.setMaterailDesc(insuranceDetailRow.getMaterail_Desc());
				insurance.setValidDateFrom(insuranceDetailRow.getValiddatefm());
				insurance.setValidDateTo(insuranceDetailRow.getValiddateto());
				insurance.setVacationType(insuranceDetailRow.getVacationtype());
				insurance.setAdultPrice(insuranceDetailRow.getAdult_Price()
						.doubleValue());
				insurance.setChildPrice(insuranceDetailRow.getChild_Price()
						.doubleValue());
				insurance.setChildRuleDesc(insuranceDetailRow
						.getChildruledesc());
				insurance.setChildMinAge(Integer.parseInt(insuranceDetailRow
						.getChildminage()));
				insurance.setChildMaxAge(Integer.parseInt(insuranceDetailRow
						.getChildmaxage()));
				insurance.setChildAges(childAges);
				insurance.setOptionIns(insuranceDetailRow.getOptionins());
				insurance.setVacationDescription(insuranceDetailRow
						.getVacationdesc());
				if (insuranceDetailRow.getMax_No_Pax() != null) {
					insurance.setMaxQuantity(Byte.parseByte(insuranceDetailRow
							.getMax_No_Pax()));
				}
				if (insuranceDetailRow.getPax_Id() != null
						&& !"00".equals(insuranceDetailRow.getPax_Id())) {
					// If the PAX is not null means need to parse the POSNR and
					// OLD POSNR values
					InsuranceGuestAllocation insuranceGuestAllocation = new InsuranceGuestAllocation();
					insuranceGuestAllocation.setGuestID(insuranceDetailRow
							.getPax_Id());
					insuranceGuestAllocation.setPosnr(insuranceDetailRow.getPosnr());
					insuranceGuestAllocation.setOldPosnr(insuranceDetailRow
							.getOld_Posnr());
					insurance
							.addInsuranceGuestAllocation(insuranceGuestAllocation);
					insurance
							.setGuestAllocation(insuranceDetailRow.getPax_Id());
					if (!"1".equals(insuranceDetailRow.getInput_Allowed())) {
						insurance.setDisabledGuestAllocation(insuranceDetailRow
								.getPax_Id());
					}
				}
				insuranceDesc = new String();
				while (itInsuranceOptionDescList.hasNext()) {
					Yst_Bapi_Long_TextType insuranceOptionDescRow = itInsuranceOptionDescList
							.next();
					if (insuranceOptionDescRow != null
							&& insurance.getItemRPH() == Integer
									.parseInt(insuranceOptionDescRow
											.getItem_Rph()))
						insuranceDesc += insuranceOptionDescRow.getTdline()
								+ " ";
				}
				insurance.setOptionDesc(insuranceDesc);

				// Check if the given InsturanceGroup is exists or not
				InsuranceGroup insuranceGroup = null;
				if (groupMap.get(insuranceDetailRow.getVacationtype()) == null) {
					insuranceGroup = new InsuranceGroup();
					insuranceGroup
							.setCode(insuranceDetailRow.getVacationtype());
					insuranceGroup.setDescription(insuranceDetailRow
							.getVacationdesc());
					groupMap.put(insuranceDetailRow.getVacationtype(),
							insuranceGroup);
				} else {
					insuranceGroup = (InsuranceGroup) groupMap
							.get(insuranceDetailRow.getVacationtype());
				}
				insuranceGroup.addInsuranceToList(insurance);
			}
		} // End of insurance options list
		Collection<InsuranceGroup> insuranceGroupList = groupMap.values();
		if (insuranceGroupList == null || insuranceGroupList.size() == 0) {
			return null;
		}
		List<InsuranceGroup> insuranceGrpList = new ArrayList<InsuranceGroup>();
		insuranceGrpList.addAll(insuranceGroupList);
		return insuranceGrpList;
	}

	/**
	 * Method to process the insurance response
	 * 
	 * @param insuranceList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<Insurance> processReservedInsurance(
			Yst_Bapi_Res_InsType_List insuranceItemsList) {
		if (insuranceItemsList == null) {
			return null;
		}
		// Prepare insurance groups
		HashMap<String, Insurance> insuranceMap = new HashMap<String, Insurance>();
		Iterator<Yst_Bapi_Res_InsType> itInsuranceList = insuranceItemsList
				.iterator();
		while (itInsuranceList.hasNext()) {
			Yst_Bapi_Res_InsType insuranceDetailRow = itInsuranceList.next();
			if (insuranceDetailRow != null) {
				String key = insuranceDetailRow.getVacationtype()
						+ insuranceDetailRow.getMaterial();
				Object insuranceObj = insuranceMap.get(key);
				if (insuranceObj != null) {
					// Assumption: Scenario possible only if the pax is
					// allocated to insurance
					Insurance insurance = (Insurance) insuranceObj;
					InsuranceGuestAllocation insuranceGuestAllocation = new InsuranceGuestAllocation();
					insuranceGuestAllocation.setGuestID(insuranceDetailRow
							.getPax_Alloc_Rph());
					insuranceGuestAllocation.setPosnr(insuranceDetailRow.getPosnr());
					insuranceGuestAllocation.setPrice(insuranceDetailRow
							.getTotal().doubleValue());
					insurance
							.addInsuranceGuestAllocation(insuranceGuestAllocation);
					insurance.setTotalPrice(insurance.getTotalPrice()
							+ insuranceDetailRow.getTotal().doubleValue());
					insurance.setGuestAllocation(insurance.getGuestAllocation()
							+ "," + insuranceDetailRow.getPax_Alloc_Rph());
				} else {
					Insurance insurance = new Insurance();
					insurance.setItemRPH(Integer.parseInt(insuranceDetailRow
							.getItem_Rph()));
					insurance.setMaterialNo(insuranceDetailRow.getMaterial());
					insurance.setMaterailDesc(insuranceDetailRow
							.getMaterail_Desc());
					insurance.setValidDateFrom(insuranceDetailRow
							.getValiddatefm());
					insurance.setValidDateTo(insuranceDetailRow
							.getValiddateto());
					insurance.setVacationType(insuranceDetailRow
							.getVacationtype());
					insurance.setVacationDescription(insuranceDetailRow
							.getVacationdesc());
					insurance.setTotalPrice(insuranceDetailRow.getTotal()
							.doubleValue());
					insurance.setAdultPrice(insuranceDetailRow.getAdult_Price()
							.doubleValue());
					insurance.setChildPrice(insuranceDetailRow.getChild_Price()
							.doubleValue());
					insurance.setChildRuleDesc(insuranceDetailRow
							.getChildruledesc());
					insurance.setChildMinAge(Integer
							.parseInt(insuranceDetailRow.getChildminage()));
					insurance.setChildMaxAge(Integer
							.parseInt(insuranceDetailRow.getChildmaxage()));
					insurance.setOptionIns(insuranceDetailRow.getOptionins());
					if (insuranceDetailRow.getPax_Alloc_Rph() != null
							&& !""
									.equals(insuranceDetailRow
											.getPax_Alloc_Rph())) {
						// If the PAX is not null means need to parse the POSNR
						// and
						// OLD POSNR values
						InsuranceGuestAllocation insuranceGuestAllocation = new InsuranceGuestAllocation();
						insuranceGuestAllocation.setGuestID(insuranceDetailRow
								.getPax_Alloc_Rph());
						insuranceGuestAllocation.setPosnr(insuranceDetailRow.getPosnr());
						insuranceGuestAllocation.setPrice(insuranceDetailRow
								.getTotal().doubleValue());
						insurance
								.addInsuranceGuestAllocation(insuranceGuestAllocation);
						insurance.setGuestAllocation(insuranceDetailRow
								.getPax_Alloc_Rph());
					}
					insuranceMap.put(key, insurance);
				}
			}
		} // End of insurance options list
		Collection<Insurance> insuranceCollection = insuranceMap.values();
		if (insuranceCollection == null || insuranceCollection.size() == 0) {
			return null;
		}
		List<Insurance> insuranceList = new ArrayList<Insurance>();
		insuranceList.addAll(insuranceCollection);
		// Sort insurance by ItemRPH
		Collections.sort(insuranceList, new InsuranceIdComparator());
		return insuranceList;
	}

	/**
	 * Method to process the insurance response
	 * 
	 * @param insuranceList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<Insurance> processQuotedInsurance(
			Yst_Bapi_Ins_ItemsType_List insuranceList) {
		Iterator<Yst_Bapi_Ins_ItemsType> itInsuranceList = insuranceList
				.iterator();
		ArrayList<Insurance> insuranceOptionList = new ArrayList<Insurance>();
		while (itInsuranceList.hasNext()) {
			Yst_Bapi_Ins_ItemsType insuranceDetailRow = itInsuranceList.next();
			if (insuranceDetailRow != null) {
				Insurance insurance = new Insurance();
				insurance.setItemRPH(Integer.parseInt(insuranceDetailRow
						.getItem_Rph()));
				insurance.setMaterialNo(insuranceDetailRow.getMaterial());
				insurance
						.setMaterailDesc(insuranceDetailRow.getMaterail_Desc());
				insurance.setValidDateFrom(insuranceDetailRow.getValiddatefm());
				insurance.setValidDateTo(insuranceDetailRow.getValiddateto());
				insurance.setVacationType(insuranceDetailRow.getVacationtype());
				insurance.setVacationDescription(insuranceDetailRow.getVacationdesc());
				insurance.setTotalPrice(insuranceDetailRow.getTotal()
						.doubleValue());
				insurance.setAdultPrice(insuranceDetailRow.getAdult_Price()
						.doubleValue());
				insurance.setChildPrice(insuranceDetailRow.getChild_Price()
						.doubleValue());
				insurance.setChildRuleDesc(insuranceDetailRow
						.getChildruledesc());
				insurance.setChildMinAge(Integer.parseInt(insuranceDetailRow
						.getChildminage()));
				insurance.setChildMaxAge(Integer.parseInt(insuranceDetailRow
						.getChildmaxage()));
				insurance.setOptionIns(insuranceDetailRow.getOptionins());
				insurance.setGuestAllocation(insuranceDetailRow
						.getPax_Alloc_Rph());
				// POSNR number for reserved insurance
				insurance.setPosnr(insuranceDetailRow.getPosnr());
				processGuestAllocation(insuranceDetailRow, insurance);
				insuranceOptionList.add(insurance);
			}
		} // End of insurance options list
		return insuranceOptionList;
	}

	/**
	 * Method to convert the insurances response to DTO objects
	 * 
	 * @param insuranceItemsList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<Insurance> parseInsuranceResponse(
			Yst_Bapi_Ins_ItemsType_List insuranceItemsList) {
		if (insuranceItemsList == null) {
			return null;
		}
		// Prepare insurance groups
		HashMap<String, Insurance> insuranceMap = new HashMap<String, Insurance>();

		Iterator<Yst_Bapi_Ins_ItemsType> itInsuranceList = insuranceItemsList
				.iterator();
		while (itInsuranceList.hasNext()) {
			Yst_Bapi_Ins_ItemsType insuranceDetailRow = itInsuranceList.next();
			if (insuranceDetailRow != null) {
				String key = insuranceDetailRow.getVacationtype()
						+ insuranceDetailRow.getMaterial();
				Object insuranceObj = insuranceMap.get(key);
				if (insuranceObj != null) {
					// Assumption: Scenario possible only if the pax is
					// allocated to insurance
					Insurance insurance = (Insurance) insuranceObj;
					InsuranceGuestAllocation insuranceGuestAllocation = new InsuranceGuestAllocation();
					insuranceGuestAllocation.setGuestID(insuranceDetailRow
							.getPax_Alloc_Rph());
					insuranceGuestAllocation.setPosnr(insuranceDetailRow.getPosnr());
					insuranceGuestAllocation.setOldPosnr(insuranceDetailRow
							.getOld_Posnr());
					insuranceGuestAllocation.setPrice(insuranceDetailRow
							.getTotal().doubleValue());
					insurance
							.addInsuranceGuestAllocation(insuranceGuestAllocation);
					insurance.setTotalPrice(insurance.getTotalPrice()
							+ insuranceDetailRow.getTotal().doubleValue());
					insurance.setGuestAllocation(insurance.getGuestAllocation()
							+ "," + insuranceDetailRow.getPax_Alloc_Rph());
				} else {
					Insurance insurance = new Insurance();
					insurance.setItemRPH(Integer.parseInt(insuranceDetailRow
							.getItem_Rph()));
					insurance.setMaterialNo(insuranceDetailRow.getMaterial());
					insurance.setMaterailDesc(insuranceDetailRow
							.getMaterail_Desc());
					insurance.setValidDateFrom(insuranceDetailRow
							.getValiddatefm());
					insurance.setValidDateTo(insuranceDetailRow
							.getValiddateto());
					insurance.setVacationType(insuranceDetailRow
							.getVacationtype());
					insurance.setVacationDescription(insuranceDetailRow
							.getVacationdesc());
					insurance.setTotalPrice(insuranceDetailRow.getTotal()
							.doubleValue());
					insurance.setAdultPrice(insuranceDetailRow.getAdult_Price()
							.doubleValue());
					insurance.setChildPrice(insuranceDetailRow.getChild_Price()
							.doubleValue());
					insurance.setChildRuleDesc(insuranceDetailRow
							.getChildruledesc());
					insurance.setChildMinAge(Integer
							.parseInt(insuranceDetailRow.getChildminage()));
					insurance.setChildMaxAge(Integer
							.parseInt(insuranceDetailRow.getChildmaxage()));
					insurance.setOptionIns(insuranceDetailRow.getOptionins());
					if (insuranceDetailRow.getPax_Alloc_Rph() != null
							&& !""
									.equals(insuranceDetailRow
											.getPax_Alloc_Rph())) {
						// If the PAX is not null means need to parse the POSNR
						// and
						// OLD POSNR values
						InsuranceGuestAllocation insuranceGuestAllocation = new InsuranceGuestAllocation();
						insuranceGuestAllocation.setGuestID(insuranceDetailRow
								.getPax_Alloc_Rph());
						insuranceGuestAllocation.setPosnr(insuranceDetailRow.getPosnr());
						insuranceGuestAllocation.setOldPosnr(insuranceDetailRow
								.getOld_Posnr());
						insuranceGuestAllocation.setPrice(insuranceDetailRow
								.getTotal().doubleValue());
						insurance
								.addInsuranceGuestAllocation(insuranceGuestAllocation);
						insurance.setGuestAllocation(insuranceDetailRow
								.getPax_Alloc_Rph());
					} else {
						processGuestAllocation(insuranceDetailRow, insurance);
					}
					insuranceMap.put(key, insurance);
				}
			}
		} // End of insurance options list
		Collection<Insurance> insuranceCollection = insuranceMap.values();
		if (insuranceCollection == null || insuranceCollection.size() == 0) {
			return null;
		}
		List<Insurance> insuranceList = new ArrayList<Insurance>();
		insuranceList.addAll(insuranceCollection);
		// Sort insurance by ItemRPH
		Collections.sort(insuranceList, new InsuranceIdComparator());
		return insuranceList;
	}
	/**
	 * 
	 * Method translates the R/3 insurance structures and populates
	 * guest allocation
	 * @param insuranceDetailRow
	 * @param insurance
	 */
	private static void processGuestAllocation(Yst_Bapi_Ins_ItemsType insuranceDetailRow, Insurance insurance) {
		// Process quantity
		insurance.setAdultsQty((byte) insuranceDetailRow
				.getNo_Adults());
		insurance.setChildsQty(Byte
				.parseByte(insuranceDetailRow.getNo_Child()));
		insurance.setInfantsQty(Byte
				.parseByte(insuranceDetailRow.getNo_Infants()));
		insurance
				.setLapChildQty(Byte
						.parseByte(insuranceDetailRow
								.getNo_Lapchild()));
		insurance.setSeniorsQty(Byte
				.parseByte(insuranceDetailRow.getNo_Seniors()));
		// Process child ages
		byte childCount = (byte) (insurance.getChildsQty()
				+ insurance.getInfantsQty() + insurance
				.getLapChildQty());
		if (childCount > 0) {
			List<Integer> agesList = new ArrayList<Integer>();
			for (byte index = 1; index <= childCount; index++) {
				switch (index) {
				case 1:
					agesList.add(Integer
							.getInteger(insuranceDetailRow
									.getChild1_Age()));
					break;
				case 2:
					agesList.add(Integer
							.getInteger(insuranceDetailRow
									.getChild2_Age()));
					break;
				case 3:
					agesList.add(Integer
							.getInteger(insuranceDetailRow
									.getChild3_Age()));
					break;
				case 4:
					agesList.add(Integer
							.getInteger(insuranceDetailRow
									.getChild4_Age()));
					break;
				case 5:
					agesList.add(Integer
							.getInteger(insuranceDetailRow
									.getChild5_Age()));
					break;
				case 6:
					agesList.add(Integer
							.getInteger(insuranceDetailRow
									.getChild6_Age()));
					break;
				}
			}
			insurance.setChildAges(agesList);
		}
	}
}
