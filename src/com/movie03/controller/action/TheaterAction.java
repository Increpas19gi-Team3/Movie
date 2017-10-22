package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.TheaterDAO;
import com.movie03.dto.TheaterVO;


public class TheaterAction implements Action {

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {
		
		// 극장정보 화면을 보여주기만 함.		
		System.out.println("극장정보-화면 보여주기");		
		String url = "../theater/theater.jsp";
		TheaterDAO dao = new TheaterDAO(); 
		
		List<TheaterVO> TheaterList= dao.TheaterList();
		// TheaterAction.java -> 화면(theater.jsp)으로 넘어가는 부분 
		respModel.put("TheaterList", TheaterList);
		
		return url;

	} // execute - End
	
} // TheaterAction End