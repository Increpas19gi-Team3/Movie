package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import com.movie03.dao.ReserveDAO;
import com.movie03.dto.MovieVO;

public class ReserveAction implements Action{


	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {
		ReserveDAO dao= new ReserveDAO();
		List<MovieVO> res= dao.selectMvList();

		String url = "/reserve/reserve.jsp";//출력뷰
		respModel.put("res", res);
		
		return url;
	}

	
}