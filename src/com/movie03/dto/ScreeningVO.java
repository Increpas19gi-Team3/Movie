package com.movie03.dto;

/**
 * 상영관 DB VO
 * @author 손가연
 *
 */
public class ScreeningVO {
	
	private String SCODE;	// 상영관코드 S01   
	private String TCODE;   // 극장코드 T01
	private String SNAME;   // 상영관 이름
	private int SSEATCNT;   // 좌석수
	private String SSEATINFO; // 좌석정보
	private String STURN;  	// 회차 1, 2, 3회차
	private String STIME;	// 시간 12, 16, 20시
	
	
	public String getSCODE() {
		return SCODE;
	}
	public void setSCODE(String sCODE) {
		SCODE = sCODE;
	}
	public String getTCODE() {
		return TCODE;
	}
	public void setTCODE(String tCODE) {
		TCODE = tCODE;
	}
	public String getSNAME() {
		return SNAME;
	}
	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}
	public int getSSEATCNT() {
		return SSEATCNT;
	}
	public void setSSEATCNT(int sSEATCNT) {
		SSEATCNT = sSEATCNT;
	}
	public String getSSEATINFO() {
		return SSEATINFO;
	}
	public void setSSEATINFO(String sSEATINFO) {
		SSEATINFO = sSEATINFO;
	}
	public String getSTURN() {
		return STURN;
	}
	public void setSTURN(String sTURN) {
		STURN = sTURN;
	}
	public String getSTIME() {
		return STIME;
	}
	public void setSTIME(String sTIME) {
		STIME = sTIME;
	}
	
	@Override
	public String toString() {
		return "screeningVO [SCODE=" + SCODE + ", TCODE=" + TCODE + ", SNAME=" + SNAME + ", SSEATCNT=" + SSEATCNT
				+ ", SSEATINFO=" + SSEATINFO + ", STURN=" + STURN + ", STIME=" + STIME + "]";
	}
	
	
}
