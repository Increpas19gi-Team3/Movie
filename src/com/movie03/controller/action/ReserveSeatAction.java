package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.ReserveDAO;
import com.movie03.dto.SeatVO;

/***
 * 예약 가능 좌석 조회 action
 * @author 2-16
 *
 */

public class ReserveSeatAction implements Action {

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {
		String url = "/reserve/reserveSeat.jsp";//출력뷰
		ReserveDAO dao= new ReserveDAO();
		String turn = (String)reqModel.get("rtime");
		String rday = (String)reqModel.get("rday");

		/*System.out.println("turn : " + turn + "rday : " + rday);*/
		List<SeatVO> List= dao.selectSeat(turn, rday);
		respModel.put("seatList", List);
		
		return url;
	}
	
}
