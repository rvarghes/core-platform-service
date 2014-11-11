/*
 * MealPlanType.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Nov 13, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

/**
 * Enum class to hold the MealPlanType information
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public enum MealPlanType {

	ALLI("ALLI", "All Inclusive"), INC("INC", "Inclusive"), EP("EP",
			"European Plan"), BP("BP", "Breakfast Plan"), FAP("FAP",
			"Full American Plan"), MAP("MAP", "Modified American Plan"),ADP("ADP","ADP"),IMAP("IMAP","IMAP"),BB("BB","BB"),NOM("NOM","NOM");

	private String code;
	private String description;

	/**
	 * Overloaded constructor
	 * 
	 * @param code
	 * @param description
	 */
	private MealPlanType(String code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * Default constructor
	 */
	private MealPlanType() {
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	//MAP("MAP", "Modified American Plan"),ADP("ADP","ADP"),IMAP("IMAP","IMAP"),BB("BB","BB"),NOM("NOM","NOM")
	public static MealPlanType getMealPlanType(String mealPlanCode) {
		if(mealPlanCode != null) {
			if(ALLI.code.equals(mealPlanCode)) {
				return ALLI;
			} else if(INC.code.equals(mealPlanCode)) {
				return INC;
			} else if(EP.code.equals(mealPlanCode)) {
				return EP;
			} else if(BP.code.equals(mealPlanCode)) {
				return BP;
			} else if(FAP.code.equals(mealPlanCode)) {
				return FAP;
			} else if(MAP.code.equals(mealPlanCode)) {
				return MAP;
			}else if(IMAP.code.equals(mealPlanCode)) {
					return IMAP;
			}else if(ADP.code.equals(mealPlanCode)) {
					return ADP;
			}else if(BB.code.equals(mealPlanCode)) {
					return BB;
			}else if(NOM.code.equals(mealPlanCode)) {
					return NOM;
			}
			
		}
		return null;
	}
}
