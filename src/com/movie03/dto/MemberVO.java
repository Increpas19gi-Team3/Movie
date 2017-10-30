package com.movie03.dto;

/**
 * 회원관리 DB VO
 * @author 손가연
 *
 */
public class MemberVO {

	private String MID; 	//아이디
	private String MPWD; 	//비밀번호
	private String MNAME; 	//이름
	private String MEMAIL; 	//이메일
	private String MTEL; 	//전화번호
	private String MADMIN;	//관리자여부 0:관리자, 1:사용자
	
	
	public String getMID() {
		return MID;
	}
	public void setMID(String mID) {
		MID = mID;
	}
	public String getMPWD() {
		return MPWD;
	}
	public void setMPWD(String mPWD) {
		MPWD = mPWD;
	}
	public String getMNAME() {
		return MNAME;
	}
	public void setMNAME(String mNAME) {
		MNAME = mNAME;
	}	
	public String getMEMAIL() {
		return MEMAIL;
	}
	public void setMEMAIL(String mEMAIL) {
		MEMAIL = mEMAIL;
	}	
	public String getMTEL() {
		return MTEL;
	}
	public void setMTEL(String mTEL) {
		MTEL = mTEL;
	}
	public String getMADMIN() {
		return MADMIN;
	}
	public void setMADMIN(String mADMIN) {
		MADMIN = mADMIN;
	}
	@Override
	public String toString() {
		return "memberVO [MID=" + MID + ", MPWD=" + MPWD + ", MNAME=" + MNAME + ", MEMAIL=" + MEMAIL + ", MTEL=" + MTEL
				+ ", MADMIN=" + MADMIN + "]";
	}	
}
