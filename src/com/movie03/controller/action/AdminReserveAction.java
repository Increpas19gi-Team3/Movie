package com.movie03.controller.action;

import java.io.IOException;
import java.util.Map;

/**
 * 예약 관리 AC
 * @author 손가연
 *
 */
public class AdminReserveAction implements Action2{

	@Override
	public String execute(Map<String, Object> model) throws IOException {

		
		// 관리자 화면을 보여주기만 함.
		System.out.println("예약 관리 모드 화면창");
		String url = "../admin/admin_Reserve.jsp";
		
		return url;
	}

}
