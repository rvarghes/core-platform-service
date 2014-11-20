package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

public class SeatInfo  implements ABEDto {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String seatNo;
    private String paxName;
    private String sNo;
    private String paxNo;
    private int seatPrice;
    
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public String getPaxName() {
		return paxName;
	}
	public void setPaxName(String paxName) {
		this.paxName = paxName;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getPaxNo() {
		return paxNo;
	}
	public void setPaxNo(String paxNo) {
		this.paxNo = paxNo;
	}
	public int getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(int seatPrice) {
		this.seatPrice = seatPrice;
	}
}
