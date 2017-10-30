package com.movie03.controller.action;

import java.io.IOException;
import java.util.Map;

import com.movie03.dto.MemberVO;
import com.movie03.dto.MovieVO;

/**
 * 회원가입를 위한 Action 
 * @author 손가연, 손대성
 *
 */
public class MembershipAction implements Action {

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {
		
		System.out.println("회원가입 진행중.>>");
		
		String url = "../member/mypage.jsp"; // 출력뷰

		System.out.println("Join >>>>>>>>");

		MemberVO mVo = new MemberVO();

		String MID = ""; // ID
		String Mpwd = ""; // 비밀번호
		String Mname = ""; // 이름
		String Memail = ""; // 메일
		String Mtel = ""; // 전화번호
		String Madmin = ""; // 관리자 여부

		if((String) reqModel.get("MID") !=null){
			MID = (String) reqModel.get("MID");
		}
		if((String) reqModel.get("Mpwd") !=null){
			Mpwd = (String) reqModel.get("Mpwd");
		}		
		if((String) reqModel.get("Mname") !=null){
			Mname = (String) reqModel.get("Mname");
		}
		if((String) reqModel.get("Memail") !=null){
			Memail = (String) reqModel.get("Memail");
		}
		if((String) reqModel.get("Mtel") !=null){
			Mtel = (String) reqModel.get("Mtel");
		}
		if((String) reqModel.get("Madmin") !=null){
			Madmin = (String) reqModel.get("Madmin");
		}
		
		mVo.setMID(MID);
		mVo.setMPWD(Mpwd);
		mVo.setMNAME(Mname);
		mVo.setMEMAIL(Memail);
		mVo.setMTEL(Mtel);
		mVo.setMADMIN(Madmin);
		
		
		// 관리자 여부 : 관리자(0), 일반사용자(1)
		/*
		 * if(Madmin.equals("0")) Madmin=0; else Madmin=1;
		 */

		// dao.insertMember(MID, Mpwd, Mname, Memail, Mtel, Madmin);

		return url;
		
	} // execute End	

} // class MembershipAction End