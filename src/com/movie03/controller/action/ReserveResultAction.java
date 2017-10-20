package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.ReserveDAO;
import com.movie03.dto.ReserveVO;

public class ReserveResultAction implements Action{

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {
		String url = "/reserve/reserveResult.jsp";//출력뷰
		ReserveDAO dao= new ReserveDAO();
		
		String title = (String)reqModel.get("title");
		String screan = (String)reqModel.get("screan");
		String rday = (String)reqModel.get("rday");
		String rtime = (String)reqModel.get("rtime");
		String seat = (String)reqModel.get("seat");
		String mid = (String)reqModel.get("id");
		
		String code = dao.selectMovieCode("title");
		String rcode = dao.selectReserveCode();
		
		/*System.out.println("turn : " + turn + "rday : " + rday);*/
		List<ReserveVO> list = dao.insertReserve(code, screan, rday, rtime, seat, mid, rcode);
		respModel.put("reserveList", list);
		
		return url;
	}

	
}
