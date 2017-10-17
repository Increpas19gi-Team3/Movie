package com.movie03.dto;

/**
 * 예약 DB VO
 * @author 손가연
 *
 */
public class ReserveVO {

	private String RCODE;	// 예매번호
	private String MID; 	// 아이디
	private String MCODE;	// 영화 코드 
	private String SCODE;	// 상영관 코드
	private String RDAY;	// 상영날짜
	private String RTURN;	// 상영회차 1, 2, 3 회차
	private String RTIME;	// 상영시간 12, 16, 20시
	private String RSEAT;	// 좌석정보
	
	
	public String getRCODE() {
		return RCODE;
	}
	public void setRCODE(String rCODE) {
		RCODE = rCODE;
	}
	public String getMID() {
		return MID;
	}
	public void setMID(String mID) {
		MID = mID;
	}
	public String getMCODE() {
		return MCODE;
	}
	public void setMCODE(String mCODE) {
		MCODE = mCODE;
	}
	public String getSCODE() {
		return SCODE;
	}
	public void setSCODE(String sCODE) {
		SCODE = sCODE;
	}
	public String getRDAY() {
		return RDAY;
	}
	public void setRDAY(String rDAY) {
		RDAY = rDAY;
	}
	public String getRTURN() {
		return RTURN;
	}
	public void setRTURN(String rTURN) {
		RTURN = rTURN;
	}
	public String getRTIME() {
		return RTIME;
	}
	public void setRTIME(String rTIME) {
		RTIME = rTIME;
	}
	public String getRSEAT() {
		return RSEAT;
	}
	public void setRSEAT(String rSEAT) {
		RSEAT = rSEAT;
	}
	
	
	@Override
	public String toString() {
		return "reserveVO [RCODE=" + RCODE + ", MID=" + MID + ", MCODE=" + MCODE + ", SCODE=" + SCODE + ", RDAY=" + RDAY
				+ ", RTURN=" + RTURN + ", RTIME=" + RTIME + ", RSEAT=" + RSEAT + "]";
	}
	
	
}
