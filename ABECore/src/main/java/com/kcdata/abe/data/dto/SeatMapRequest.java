package com.kcdata.abe.data.dto;



import com.kcdata.abe.framework.dto.ABEDto;

public class SeatMapRequest implements ABEDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String gatewayCode;        //gateway (from)
	private String gatewayName;
	private String destinationCode;    //destination (to)
	private String destinationName;
	private String date;            // travel date
	private String cabinClass;      // first or coach classes 
	private Long contractId;       // id we need to send to SMS for getting result from cache.
	private String segmentId;       // like PUJPHLF91204301130X1
	private String rotation;        // 
	private String carrier;         // f9 
	private String groupBlockedRequest; // Y=this request is for group blcoked else N=No 

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCabinClass() {
		return cabinClass;
	}
	public void setCabinClass(String cabinClass) {
		this.cabinClass = cabinClass;
	}
	public String getSegmentId() {
		return segmentId;
	}
	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}
	public String getRotation() {
		return rotation;
	}
	public void setRotation(String rotation) {
		this.rotation = rotation;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}	
	/**
	 * @return the gatewayCode
	 */
	public String getGatewayCode() {
		return gatewayCode;
	}
	/**
	 * @param gatewayCode the gatewayCode to set
	 */
	public void setGatewayCode(String gatewayCode) {
		this.gatewayCode = gatewayCode;
	}
	/**
	 * @return the gatewayName
	 */
	public String getGatewayName() {
		return gatewayName;
	}
	/**
	 * @param gatewayName the gatewayName to set
	 */
	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}
	/**
	 * @return the destinationCode
	 */
	public String getDestinationCode() {
		return destinationCode;
	}
	/**
	 * @param destinationCode the destinationCode to set
	 */
	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}
	/**
	 * @return the destinationName
	 */
	public String getDestinationName() {
		return destinationName;
	}
	/**
	 * @param destinationName the destinationName to set
	 */
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public Long getContractId() {
		return contractId;
	}
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	/**
	 * @return the groupBlockedRequest
	 */
	public String getGroupBlockedRequest() {
		return groupBlockedRequest;
	}
	/**
	 * @param groupBlockedRequest the groupBlockedRequest to set
	 */
	public void setGroupBlockedRequest(String groupBlockedRequest) {
		this.groupBlockedRequest = groupBlockedRequest;
	}

}
