package com.movie03.controller.action;

import java.io.IOException;
import java.util.Map;

import com.movie03.dao.MemberDAO;
import com.movie03.dto.MemberVO;

/**
 * 회원가입를 위한 Action
 * @author 손가연, 손대성
 *
 */
public class MembershipAction implements Action {

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException{
	String url = "/member/login.jsp";//출력뷰
	
	System.out.println("Join >>>>>>>>");
	
	MemberDAO dao = new MemberDAO();

	String MID = (String)reqModel.get("MID");
	String Mpwd = (String)reqModel.get("Mpwd");
	String Mname = (String)reqModel.get("Mname");
	String Memail = (String)reqModel.get("Memail");
	String Mtel = (String)reqModel.get("Mtel");
	int Madmin = (int)reqModel.get("Madmin");
	
	// 관리자 여부 : 관리자(0), 일반사용자(1)	
	/*if(Madmin.equals("0"))
		Madmin=0;
	else
		Madmin=1;*/
	
	dao.insertMember(MID, Mpwd, Mname, Memail, Mtel, Madmin);
	
return url;
}
}