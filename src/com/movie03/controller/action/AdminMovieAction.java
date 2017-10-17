package com.movie03.controller.action;

import java.io.IOException;
import java.util.Map;

public class AdminMovieAction implements Action2{

	@Override
	public String execute(Map<String, Object> model) throws IOException {

		
		// 관리자 화면을 보여주기만 함.
		System.out.println("영화 관리 모드 화면창");
		String url = "../admin/admin_Movie.jsp";
		
		return url;
	}

}
