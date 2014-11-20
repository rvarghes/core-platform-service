package com.kcdata.abe.application.command;

import com.kcdata.abe.bapi.Yzexp_SeatType;
import com.kcdata.abe.framework.command.ABECommandBase;

public class ExpireBookingCommand  extends ABECommandBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String COMMAND_HANDLER_NAME = "expireBookingHandler";
	
	private String action;
	private String status;
	private String imSeatStatus;
	private String imUpdateTab;
	private Yzexp_SeatType[] yzExpSeatTypes;
	
	
	public Yzexp_SeatType[] getYzExpSeatTypes() {
		return yzExpSeatTypes;
	}
	public void setYzExpSeatTypes(Yzexp_SeatType[] yzExpSeatTypes) {
		this.yzExpSeatTypes = yzExpSeatTypes;
	}

	public String getImUpdateTab() {
		return imUpdateTab;
	}


	public void setImUpdateTab(String imUpdateTab) {
		this.imUpdateTab = imUpdateTab;
	}



	public String getImSeatStatus() {
		return imSeatStatus;
	}


	public void setImSeatStatus(String imSeatStatus) {
		this.imSeatStatus = imSeatStatus;
	}


	public String getCommandHandlerName() {		
		return COMMAND_HANDLER_NAME;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	

}
