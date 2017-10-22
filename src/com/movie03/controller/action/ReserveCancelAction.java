package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.ReserveDAO;
import com.movie03.dto.ReserveVO;

/***
 * 예매 취소 Action 
 * @author jhkim
 *
 */
public class ReserveCancelAction implements Action{

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {
		String url = "/reserve/reserveCancelResult.jsp";//출력뷰
		
		ReserveDAO dao= new ReserveDAO();

		String rcode = (String)reqModel.get("rcode");
		String turn = (String)reqModel.get("turn");
		String rday = (String)reqModel.get("rday");
		String seat = (String)reqModel.get("seat");

		dao.deleteReserve(rcode);
		
		String seatCK[] = seat.split(",");
		System.out.println("seat >>>> "+seat);
		for(int i=0; i<seatCK.length; i++){
			System.out.println("seat >>>> "+seatCK[i]);
			dao.updateSeatCancel(seatCK[i], rday, turn);
		}
		
		return url;
	}
	
	

}
