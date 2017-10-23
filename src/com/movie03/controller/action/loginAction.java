package com.movie03.controller.action;

import java.io.IOException;
import java.util.Map;

import com.movie03.dao.MemberDAO;

public interface loginAction {
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException;
	String url = "/member/login.jsp";//출력뷰
	
	MemberDAO dao = new MemberDAO();

}
