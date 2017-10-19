package com.movie03.controller.action;

import java.io.IOException;
import java.util.Map;

public class AdminAction implements Action{

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {

		// 관리자 화면을 보여주기만 함.
		System.out.println("관리자 모드 화면창");
		String url = "../admin/adminMain.jsp";
		
		return url;
	}

}
