package com.movie03.dto;

public class ScreenTurnVO {
	private String SCode; //상영관 코드
	private String MCode; //영화 코드
	private String STturn; //상영 회차
	private String STdate; //상영 날짜
	
	
	public String getSCode() {
		return SCode;
	}
	public void setSCode(String sCode) {
		SCode = sCode;
	}
	public String getMCode() {
		return MCode;
	}
	public void setMCode(String mCode) {
		MCode = mCode;
	}
	public String getSTturn() {
		return STturn;
	}
	public void setSTturn(String sTturn) {
		STturn = sTturn;
	}
	public String getSTdate() {
		return STdate;
	}
	public void setSTdate(String sTdate) {
		STdate = sTdate;
	}
	
}
