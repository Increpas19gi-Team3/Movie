package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.MemberDAO;
import com.movie03.dto.MemberVO;

public class MemberAction implements Action {
	
	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("로그인 보여주기");
		String url = "../member/member.jsp";
		MemberDAO dao = new MemberDAO(); 
		
		List<MemberVO> member = dao.selectMember();
		respModel.put("member", member);
		return url;
	}

}
