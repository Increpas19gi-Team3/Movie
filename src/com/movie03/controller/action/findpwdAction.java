package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.MemberDAO;
import com.movie03.dto.MemberVO;
import com.movie03.dto.MovieVO;

/**
 * 비밀번호를 찾기위한 Action
 * 
 * @author 손가연, 손대성
 */
public class findpwdAction implements Action {

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {

		// consoloe-창에 보여줌
		System.out.println("비밀번호 찾기 진행중>>>>");
		
		String url="";		
		 
		MemberDAO Mdao = MemberDAO.getInstance();
		MemberVO mVo = new MemberVO();
		
		String findpwd = (String) reqModel.get("findpwd");
		System.out.println("findpwdAction findpwd = " + findpwd);
		
		String Mname = ""; // 이름
		String Memail = ""; // 메일
		String Mtel = ""; // 전화번호		

		if (findpwd != null) {
						
			Mname = (String) reqModel.get("Mname");
			Memail = (String) reqModel.get("Memail");
			Mtel = (String) reqModel.get("Mtel");			
							
			mVo.setMNAME(Mname);
			mVo.setMEMAIL(Memail);
			mVo.setMTEL(Mtel);			
			System.out.println("if에 관한 findpwdAction != null 확인중>>>");
			
			if(Mdao.find_PWD(mVo) != null ){
				url = "../member/find.jsp";	
				
				mVo.setMPWD(Mdao.find_PWD(mVo));				
				respModel.put("mVo", mVo);
			}else{
				url ="../member/login.jsp";
			}			
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