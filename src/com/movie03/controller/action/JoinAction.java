package com.movie03.controller.action;

import java.io.IOException;
import java.util.Map;

import com.movie03.dao.MemberDAO;
import com.movie03.dto.MemberVO;

public class JoinAction  implements Action {

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException{
	String url = "/member/login.jsp";//출력뷰
	
	System.out.println("Join >>>>>>>>");
	
	MemberDAO dao = new MemberDAO();

	String MID = (String)reqModel.get("MID");
	String MPWD = (String)reqModel.get("MPWD");
	String MNAME = (String)reqModel.get("MNAME");
	String MEMAIL = (String)reqModel.get("MEMAIL");
	String MTEL = (String)reqModel.get("MTEL");
	String MADMIN = (String)reqModel.get("MADMIN");
	int admin=0;
	
	if(MADMIN.equals("관리자"))
		admin=0;
	else
		admin=1;
	
	dao.insertMember(MID,MPWD,MNAME,MEMAIL, MTEL, admin);
	
return url;
}
}