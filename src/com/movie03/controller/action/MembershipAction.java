package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.MemberDAO;
import com.movie03.dto.MemberVO;
import com.movie03.dto.MovieVO;

/**
 * 회원가입를 위한 Action
 * 
 * @author 손가연, 손대성
 */
public class MembershipAction implements Action {

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {

		// consoloe-창에 보여줌
		System.out.println("회원가입 진행중>>>>");
		
		String url 
		// = "../member/mypage.jsp";
		="../member/login.jsp";
		 
		MemberDAO Mdao = MemberDAO.getInstance();		

		MemberVO mVo = new MemberVO();
		
		String Membership = (String) reqModel.get("Membership");
		System.out.println("MembershipAction Membership = " + Membership);

		String MID = ""; // ID
		String Mpwd = ""; // 비밀번호
		String Mname = ""; // 이름
		String Memail = ""; // 메일
		String Mtel = ""; // 전화번호
		String Madmin = ""; // 관리자 여부

		if (Membership != null) {
						
			MID = (String) reqModel.get("MID");
			Mpwd = (String) reqModel.get("Mpwd");
			Mname = (String) reqModel.get("Mname");
			Memail = (String) reqModel.get("Memail");
			Mtel = (String) reqModel.get("Mtel");
			Madmin = (String) reqModel.get("Madmin");
			
			mVo.setMID(MID);
			mVo.setMPWD(Mpwd);
			mVo.setMNAME(Mname);
			mVo.setMEMAIL(Memail);
			mVo.setMTEL(Mtel);
			mVo.setMADMIN(Madmin);
			System.out.println("if에 관한 Membership != null 확인중>>>");
			
			Mdao.InsertMember(mVo);			
		} 
		return url;

		/*
		 * if ((String) reqModel.get("MID") != null) { MID = (String)
		 * reqModel.get("MID"); } if ((String) reqModel.get("Mpwd") != null) {
		 * Mpwd = (String) reqModel.get("Mpwd"); } if ((String)
		 * reqModel.get("Mname") != null) { Mname = (String)
		 * reqModel.get("Mname"); } if ((String) reqModel.get("Memail") != null)
		 * { Memail = (String) reqModel.get("Memail"); } if ((String)
		 * reqModel.get("Mtel") != null) { Mtel = (String) reqModel.get("Mtel");
		 * } if ((String) reqModel.get("Madmin") != null) { Madmin = (String)
		 * reqModel.get("Madmin"); }
		 */

	} // execute End

} // class MembershipAction End