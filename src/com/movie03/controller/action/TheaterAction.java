package com.movie03.controller.action;

import java.io.IOException;
import java.util.Map;


public class TheaterAction implements Action {

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {
		
		// 극장정보 화면을 보여주기만 함.		
		System.out.println("극장정보-화면 보여주기");		
		String url = "../theater/theater.jsp";		
		return url;		

	} // execute - End
	
} // TheaterAction End