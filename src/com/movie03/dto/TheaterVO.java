package com.movie03.dto;

/**
 * 극장 정보 DB VO
 * @author 손가연
 *
 */
public class TheaterVO {
	
	private String TCODE;   // 극장 코드 T01
	private String TNAME;   // 극장이름
	private String TLOCAL;  // 위치
	private String TDESC;	// 소개
	private String TIMAGE;	// 사진 img
	
	
	public String getTCODE() {
		return TCODE;
	}
	public void setTCODE(String tCODE) {
		TCODE = tCODE;
	}
	public String getTNAME() {
		return TNAME;
	}
	public void setTNAME(String tNAME) {
		TNAME = tNAME;
	}
	public String getTLOCAL() {
		return TLOCAL;
	}
	public void setTLOCAL(String tLOCAL) {
		TLOCAL = tLOCAL;
	}
	public String getTDESC() {
		return TDESC;
	}
	public void setTDESC(String tDESC) {
		TDESC = tDESC;
	}
	public String getTIMAGE() {
		return TIMAGE;
	}
	public void setTIMAGE(String tIMAGE) {
		TIMAGE = tIMAGE;
	}
	
	
	@Override
	public String toString() {
		return "theaterVO [TCODE=" + TCODE + ", TNAME=" + TNAME + ", TLOCAL=" + TLOCAL + ", TDESC=" + TDESC
				+ ", TIMAGE=" + TIMAGE + "]";
	}
	
	
	
}
