package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import com.movie03.dao.ReserveDAO;
import com.movie03.dto.MovieVO;

/***
 * 예매할 수 있는 영화 리스트 action
 * @author 2-16
 *
 */
public class ReserveAction implements Action{


	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {
				
		String url = "/reserve/reserve.jsp";//출력뷰
		ReserveDAO dao= new ReserveDAO();
		
		List<MovieVO> movieList= dao.selectMvList();
		respModel.put("movieList", movieList);
		
		return url;
	}

	
}