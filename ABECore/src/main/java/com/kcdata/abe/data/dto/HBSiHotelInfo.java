package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold Apple Hotel Constants from DB
 * 
 * @author 
 *
 */
public class HBSiHotelInfo  implements ABEDto{

	private String hotelId;
	private String hotelMaterialId;
	private String propertyName;
	private String appleRating;
	private String resortAreaName;
	private String resortAreaCode;
	private String hotelVendorCode;
	/**
	 * @return the hotelId
	 */
	public String getHotelId() {
		return hotelId;
	}
	/**
	 * @param hotelId the hotelId to set
	 */
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	/**
	 * @return the hotelMaterialId
	 */
	public String getHotelMaterialId() {
		return hotelMaterialId;
	}
	/**
	 * @param hotelMaterialId the hotelMaterialId to set
	 */
	public void setHotelMaterialId(String hotelMaterialId) {
		this.hotelMaterialId = hotelMaterialId;
	}
	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}
	/**
	 * @param propertyName the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	/**
	 * @return the appleRating
	 */
	public String getAppleRating() {
		return appleRating;
	}
	/**
	 * @param appleRating the appleRating to set
	 */
	public void setAppleRating(String appleRating) {
		this.appleRating = appleRating;
	}
	/**
	 * @return the resortAreaName
	 */
	public String getResortAreaName() {
		return resortAreaName;
	}
	/**
	 * @param resortAreaName the resortAreaName to set
	 */
	public void setResortAreaName(String resortAreaName) {
		this.resortAreaName = resortAreaName;
	}
	/**
	 * @return the resortAreaCode
	 */
	public String getResortAreaCode() {
		return resortAreaCode;
	}
	/**
	 * @param resortAreaCode the resortAreaCode to set
	 */
	public void setResortAreaCode(String resortAreaCode) {
		this.resortAreaCode = resortAreaCode;
	}
	/**
	 * @return the hotelVendorCode
	 */
	public String getHotelVendorCode() {
		return hotelVendorCode;
	}
	/**
	 * @param hotelVendorCode the hotelVendorCode to set
	 */
	public void setHotelVendorCode(String hotelVendorCode) {
		this.hotelVendorCode = hotelVendorCode;
	}
	
	
}
