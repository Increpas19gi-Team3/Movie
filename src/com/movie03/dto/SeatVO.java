package com.movie03.dto;

/**
 * 좌석 예약 현황 DB VO
 * @author 손가연
 *
 */
public class SeatVO {
	
	private String SSEAT;	// 좌석번호 
	private String SDATE;   // 상영일
	private String STURN; 	// 상영회차
	private String SSTATE;	// 예매현황
	
	
	public String getSSEAT() {
		return SSEAT;
	}
	public void setSSEAT(String sSEAT) {
		SSEAT = sSEAT;
	}
	public String getSDATE() {
		return SDATE;
	}
	public void setSDATE(String sDATE) {
		SDATE = sDATE;
	}
	public String getSTURN() {
		return STURN;
	}
	public void setSTURN(String sTURN) {
		STURN = sTURN;
	}
	public String getSSTATE() {
		return SSTATE;
	}
	public void setSSTATE(String sSTATE) {
		SSTATE = sSTATE;
	}
	
	
	@Override
	public String toString() {
		return "seatVO [SSEAT=" + SSEAT + ", SDATE=" + SDATE + ", STURN=" + STURN + ", SSTATE=" + SSTATE + "]";
	}
	
	
}
