package com.movie03.controller.action;

import java.io.IOException;
import java.util.Map;

/**
 * 영화관 관리 AC
 * @author 손가연
 *
 */
public class AdminTheaterAction implements Action{

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {
		// 관리자 화면을 보여주기만 함.
		System.out.println("극장 정보 관리 모드 화면창");
		String url = "../admin/admin_Theater.jsp";
		
		return url;
	}

}
