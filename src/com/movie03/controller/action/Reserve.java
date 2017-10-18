package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import com.movie03.dao.ReserveDAO;

public class Reserve implements Action2{

	@Override
	public String execute(Map<String, Object> model) throws IOException {
		String url = "/reserve/reserve.jsp";
		ReserveDAO rDao = ReserveDAO.getInstance();
		
		List<MovieVO> boardList = rDao.selectMvList();
		request.setAttribute("boardList", boardList);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	
}