package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.ReserveDAO;
import com.movie03.dto.MovieVO;

public class ReserveMovieAction implements Action{

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {
		String url = "/reserve/reserve.jsp";//출력뷰
		ReserveDAO dao= new ReserveDAO();
		
		List<MovieVO> movieList= dao.selectMvList();
		respModel.put("movieList", movieList);
		
		return url;
	}

	
}
