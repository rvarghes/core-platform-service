package com.kcdata.abe.data.dto;

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

public class HBSiRates implements ABEDto
{
private int unitMultiplier;
private String currencyCode;
private String tax;
private String description;
private double amountBeforeTax;
private double amountAfterTax;
private Date effectiveDate;
private Date expireDate;
/**
 * @return the unitMultiplier
 */
public int getUnitMultiplier() { 
	return unitMultiplier;
}
/**
 * @param unitMultiplier the unitMultiplier to set
 */
public void setUnitMultiplier(int unitMultiplier) {
	this.unitMultiplier = unitMultiplier;
}
/**
 * @return the currencyCode
 */
public String getCurrencyCode() {
	return currencyCode;
}
/**
 * @param currencyCode the currencyCode to set
 */
public void setCurrencyCode(String currencyCode) {
	this.currencyCode = currencyCode;
}
/**
 * @return the tax
 */
public String getTax() {
	return tax;
}
/**
 * @param tax the tax to set
 */
public void setTax(String tax) {
	this.tax = tax;
}
/**
 * @return the description
 */
public String getDescription() {
	return description;
}
/**
 * @param description the description to set
 */
public void setDescription(String description) {
	this.description = description;
}
/**
 * @return the amountBeforeTax
 */
public double getAmountBeforeTax() {
	return amountBeforeTax;
}
/**
 * @param amountBeforeTax the amountBeforeTax to set
 */
public void setAmountBeforeTax(double amountBeforeTax) {
	this.amountBeforeTax = amountBeforeTax;
}
/**
 * @return the amountAfterTax
 */
public double getAmountAfterTax() {
	return amountAfterTax;
}
/**
 * @param amountAfterTax the amountAfterTax to set
 */
public void setAmountAfterTax(double amountAfterTax) {
	this.amountAfterTax = amountAfterTax;
}
/**
 * @return the effectiveDate
 */ 
public Date getEffectiveDate() {
	return effectiveDate;
}
/**
 * @param effectiveDate the effectiveDate to set
 */
public void setEffectiveDate(Date effectiveDate) {
	this.effectiveDate = effectiveDate;
}
/**
 * @return the expireDate
 */
public Date getExpireDate() {
	return expireDate;
}
/**
 * @param expireDate the expireDate to set
 */
public void setExpireDate(Date expireDate) {
	this.expireDate = expireDate;
}
}
