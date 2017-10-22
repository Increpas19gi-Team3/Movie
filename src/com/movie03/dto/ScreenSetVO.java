package com.movie03.dto;

public class ScreenSetVO {
	private String SCode; //상영관 코드
	private String MCode; //영화 코드
	private String MTitle; //영화 제목 
	private String STturn; //상영 회차
	private String STdate; //상영 날짜
	private String MOpenday; // 영화 개봉일
	private String MStartday;// 상영 시작일 
	private String MEndday;  // 상영 종료일
	  
	
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
	public String getMTitle() {
		return MTitle;
	}
	public void setMTitle(String mTitle) {
		MTitle = mTitle;
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
	public String getMStartday() {
		return MStartday;
	}
	public void setMStartday(String mStartday) {
		MStartday = mStartday;
	}
	public String getMEndday() {
		return MEndday;
	}
	public void setMEndday(String mEndday) {
		MEndday = mEndday;
	}
	public String getMOpenday() {
		return MOpenday;
	}
	public void setMOpenday(String mOpenday) {
		MOpenday = mOpenday;
	}
	@Override
	public String toString() {
		return "ScreenSetVO [SCode=" + SCode + ", MCode=" + MCode + ", MTitle=" + MTitle + ", STturn=" + STturn
				+ ", STdate=" + STdate + ", MOpenday=" + MOpenday + ", MStartday=" + MStartday + ", MEndday=" + MEndday
				+ "]";
	}
	
}
