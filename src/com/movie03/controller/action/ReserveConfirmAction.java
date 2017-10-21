package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.ReserveDAO;
import com.movie03.dto.ReserveVO;
import com.movie03.dto.ScreenTurnVO;

public class ReserveConfirmAction implements Action {

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {
		String url = "/reserve/reserveConfirm.jsp";//출력뷰
		ReserveDAO dao= new ReserveDAO();

		String userid = (String)reqModel.get("userID");
		
		System.out.println("userid >>>" +userid);
		List<ReserveVO> List= dao.selectReserveList(userid);
		respModel.put("movieList", List);
		
		return url;
	}
	
	

}
