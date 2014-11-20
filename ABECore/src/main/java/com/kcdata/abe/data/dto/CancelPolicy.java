package com.kcdata.abe.data.dto;

import java.util.Date;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

public class CancelPolicy implements ABEDto
{

	private String cancelPolicyCode;
	private Date cancelPolicyDeadLine;
	private Double cancelAmount;
	private List<String> cancelDescription;
	private Double nmbrOfNights;
	
	public Double getNmbrOfNights() {
		return nmbrOfNights;
	}
	public void setNmbrOfNights(Double nmbrOfNights) {
		this.nmbrOfNights = nmbrOfNights;
	}
	/**
	 * @return the cancelPolicyCode
	 */
	public String getCancelPolicyCode() {
		return cancelPolicyCode;
	}
	/**
	 * @param cancelPolicyCode the cancelPolicyCode to set
	 */
	public void setCancelPolicyCode(String cancelPolicyCode) {
		this.cancelPolicyCode = cancelPolicyCode;
	}
	/**
	 * @return the cancelPolicyDeadLine
	 */
	public Date getCancelPolicyDeadLine() {
		return cancelPolicyDeadLine;
	}
	/**
	 * @param cancelPolicyDeadLine the cancelPolicyDeadLine to set
	 */
	public void setCancelPolicyDeadLine(Date cancelPolicyDeadLine) {
		this.cancelPolicyDeadLine = cancelPolicyDeadLine;
	}
	/**
	 * @return the cancelAmount
	 */
	public Double getCancelAmount() {
		return cancelAmount;
	}
	/**
	 * @param cancelAmount the cancelAmount to set
	 */
	public void setCancelAmount(Double cancelAmount) {
		this.cancelAmount = cancelAmount;
	}
	/**
	 * @return the cancelDescription
	 */
	public List<String> getCancelDescription() {
		return cancelDescription;
	}
	/**
	 * @param cancelDescription the cancelDescription to set
	 */
	public void setCancelDescription(List<String> cancelDescription) {
		this.cancelDescription = cancelDescription;
	}
	
}
