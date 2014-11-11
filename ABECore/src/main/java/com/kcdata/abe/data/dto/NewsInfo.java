/*
 * NewsInfo.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 15, 2010  vgandrap	  DTO to hold agent news information	
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

public class NewsInfo implements ABEDto {

	/**
	 * Auto generated serial ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 8768352171601698883L;

	private static final String MARKETING_MESSAGE = "MM";
	private static final String PRODUCT_UPDATE = "PU";
	private static final String DELAYED_FLIGHTS = "DL";
	private static final String SUPPLIER_VISITS = "SV";
	private static final String PERSONNEL_INFORMATION = "PI";
	private static final String SALES_INCENTIVES_AND_CONTESTS = "SI";
	private static final String GENERAL_INFORMATION = "GI";
	private static final String SYSTEM_AND_POLICY_UPDATES = "SP";

	/**
	 * @param marketingMessages the marketingMessages to set
	 */
	public void setMarketingMessages(List<String> marketingMessages) {
		this.marketingMessages = marketingMessages;
	}

	/**
	 * @param productUpdates the productUpdates to set
	 */
	public void setProductUpdates(List<String> productUpdates) {
		this.productUpdates = productUpdates;
	}

	/**
	 * @param supplierVisits the supplierVisits to set
	 */
	public void setSupplierVisits(List<String> supplierVisits) {
		this.supplierVisits = supplierVisits;
	}

	/**
	 * @param flightDelayInfo the flightDelayInfo to set
	 */
	public void setFlightDelayInfo(List<String> flightDelayInfo) {
		this.flightDelayInfo = flightDelayInfo;
	}

	/**
	 * @param personnelInfo the personnelInfo to set
	 */
	public void setPersonnelInfo(List<String> personnelInfo) {
		this.personnelInfo = personnelInfo;
	}

	/**
	 * @param salesIncentive the salesIncentive to set
	 */
	public void setSalesIncentive(List<String> salesIncentive) {
		this.salesIncentive = salesIncentive;
	}

	/**
	 * @param generalInfo the generalInfo to set
	 */
	public void setGeneralInfo(List<String> generalInfo) {
		this.generalInfo = generalInfo;
	}

	/**
	 * @param systemAndPolicy the systemAndPolicy to set
	 */
	public void setSystemAndPolicy(List<String> systemAndPolicy) {
		this.systemAndPolicy = systemAndPolicy;
	}

	private List<String> marketingMessages;
	private List<String> productUpdates;
	private List<String> supplierVisits;
	private List<String> flightDelayInfo;
	private List<String> personnelInfo;
	private List<String> salesIncentive;
	private List<String> generalInfo;
	private List<String> systemAndPolicy;

	public void addSalesIncentive(String salesIncentive) {
		if (this.salesIncentive != null) {
			this.salesIncentive.add(salesIncentive);
		} else {
			this.salesIncentive = new ArrayList<String>();
			this.salesIncentive.add(salesIncentive);
		}
	}

	public List<String> getSalesIncentive() {
		return this.salesIncentive;
	}

	public void addGeneralInfo(String generalInfo) {
		if (this.generalInfo != null) {
			this.generalInfo.add(generalInfo);
		} else {
			this.generalInfo = new ArrayList<String>();
			this.generalInfo.add(generalInfo);
		}
	}

	public List<String> getGeneralInfo() {
		return this.generalInfo;
	}

	public void addSystemAndPolicy(String systemAndPolicy) {
		if (this.systemAndPolicy != null) {
			this.systemAndPolicy.add(systemAndPolicy);
		} else {
			this.systemAndPolicy = new ArrayList<String>();
			this.systemAndPolicy.add(systemAndPolicy);
		}
	}

	public List<String> getSystemAndPolicy() {
		return this.systemAndPolicy;
	}

	public void addProductUpdates(String product) {
		if (productUpdates != null) {
			productUpdates.add(product);
		} else {
			productUpdates = new ArrayList<String>();
			productUpdates.add(product);
		}
	}

	public List<String> getProductUpdates() {
		return productUpdates;
	}

	public void addMarketingMessages(String marketingMsg) {
		if (marketingMessages != null) {
			marketingMessages.add(marketingMsg);
		} else {
			marketingMessages = new ArrayList<String>();
			marketingMessages.add(marketingMsg);
		}
	}

	public List<String> getMarketingMessages() {
		return marketingMessages;
	}

	public void addSupplierVisits(String supplierVisit) {
		if (supplierVisits != null) {
			supplierVisits.add(supplierVisit);
		} else {
			supplierVisits = new ArrayList<String>();
			supplierVisits.add(supplierVisit);
		}
	}

	public List<String> getSupplierVisits() {
		return supplierVisits;
	}

	public void addFlightDelayInfo(String flightDelayInfo) {
		if (this.flightDelayInfo != null) {
			this.flightDelayInfo.add(flightDelayInfo);
		} else {
			this.flightDelayInfo = new ArrayList<String>();
			this.flightDelayInfo.add(flightDelayInfo);
		}
	}

	public List<String> getFlightDelayInfo() {
		return this.flightDelayInfo;
	}

	public void addPersonnelInfo(String personnelInfo) {
		if (this.personnelInfo != null) {
			this.personnelInfo.add(personnelInfo);
		} else {
			this.personnelInfo = new ArrayList<String>();
			this.personnelInfo.add(personnelInfo);
		}
	}

	public List<String> getPersonnelInfo() {
		return this.personnelInfo;
	}

	public void addNews(String category, String value) {
		if (category.equalsIgnoreCase(PRODUCT_UPDATE))
			addProductUpdates(value);
		else if (category.equalsIgnoreCase(SUPPLIER_VISITS))
			addSupplierVisits(value);
		else if (category.equalsIgnoreCase(PERSONNEL_INFORMATION))
			addPersonnelInfo(value);
		else if (category.equalsIgnoreCase(DELAYED_FLIGHTS))
			addFlightDelayInfo(value);
		else if (category.equalsIgnoreCase(SALES_INCENTIVES_AND_CONTESTS))
			addSalesIncentive(value);
		else if (category.equalsIgnoreCase(GENERAL_INFORMATION))
			addGeneralInfo(value);
		else if (category.equalsIgnoreCase(SYSTEM_AND_POLICY_UPDATES))
			addSystemAndPolicy(value);
		else if (category.equalsIgnoreCase(MARKETING_MESSAGE))
			addMarketingMessages(value);
	}

}
