package com.movie03.dto;

/**
 * 영화 DB VO
 * @author 손가연
 *
 */
public class MovieVO {

	private String MCODE;	// 영화코드
	private String TITLE;   // 제목
	private int PRICE;		// 가격 
	private String DIRECTOR;// 감독
	private String ACTOR;   // 배우
	private String OPENDAY; // 개봉일   
	private String GENRE;   // 장르
	private String POSTER;  // 포스터 img
	private String SYNOPSIS;// 시놉시스
	private String STARTDAY;// 상영 시작일 
	private String ENDDAY;  // 상영 종료일
	private String APPRAISAL;// 평점 0~5
	
	public String getMCODE() {
		return MCODE;
	}	
	public void setMCODE(String mCODE) {
		MCODE = mCODE;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public int getPRICE() {
		return PRICE;
	}
	public void setPRICE(int pRICE) {
		PRICE = pRICE;
	}
	public String getDIRECTOR() {
		return DIRECTOR;
	}
	public void setDIRECTOR(String dIRECTOR) {
		DIRECTOR = dIRECTOR;
	}
	public String getACTOR() {
		return ACTOR;
	}
	public void setACTOR(String aCTOR) {
		ACTOR = aCTOR;
	}
	public String getOPENDAY() {
		return OPENDAY;
	}
	public void setOPENDAY(String oPENDAY) {
		OPENDAY = oPENDAY;
	}
	public String getGENRE() {
		return GENRE;
	}
	public void setGENRE(String gENRE) {
		GENRE = gENRE;
	}
	public String getPOSTER() {
		return POSTER;
	}
	public void setPOSTER(String pOSTER) {
		POSTER = pOSTER;
	}
	public String getSYNOPSIS() {
		return SYNOPSIS;
	}
	public void setSYNOPSIS(String sYNOPSIS) {
		SYNOPSIS = sYNOPSIS;
	}
	public String getSTARTDAY() {
		return STARTDAY;
	}
	public void setSTARTDAY(String sTARTDAY) {
		STARTDAY = sTARTDAY;
	}
	public String getENDDAY() {
		return ENDDAY;
	}
	public void setENDDAY(String eNDDAY) {
		ENDDAY = eNDDAY;
	}
	public String getAPPRAISAL() {
		return APPRAISAL;
	}
	public void setAPPRAISAL(String aPPRAISAL) {
		APPRAISAL = aPPRAISAL;
	}
	
	@Override
	public String toString() {
		return "movieVO [MCODE=" + MCODE + ", TITLE=" + TITLE + ", PRICE=" + PRICE + ", DIRECTOR=" + DIRECTOR
				+ ", ACTOR=" + ACTOR + ", OPENDAY=" + OPENDAY + ", GENRE=" + GENRE + ", POSTER=" + POSTER
				+ ", SYNOPSIS=" + SYNOPSIS + ", STARTDAY=" + STARTDAY + ", ENDDAY=" + ENDDAY 
				+ ", APPRAISAL=" + APPRAISAL + "]";
	}
	
	
}
