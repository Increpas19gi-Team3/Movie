package com.movie03.controller.action;

import java.io.IOException;
import java.util.Map;

/**
 * 영화 관리 AC 
 * @author 손가연
 *
 */
public class MovieAction implements Action{

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {

		//MovieSelect
		
		// 관리자 화면을 보여주기만 함.
		System.out.println("영화 모드 화면창");
		String url = "../movie/Movie.jsp";
		
		return url;
	}

}