package com.movie03.controller.action;

import java.io.IOException;
import java.util.Map;

import com.movie03.dao.AdminDAO;

/**
 * 영화관 관리 AC
 * @author 손가연
 *
 */
public class AdminTheaterAction implements Action{

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {
		
		String url = "";
		
		String cmd = (String)reqModel.get("AdminTheater");
		System.out.println("cmd = " +cmd);
		
		
		if(cmd != null) {
			
			if(cmd.equals("Update")){//정보 수정
	 			System.out.println("정보 수정 >>");
	 			
			}else if(cmd.equals("Insert")){//정보 등록
	 			System.out.println("정보 등록 >>");
			}
			
		}else{ //영화관 정보 가져오기
			AdminDAO adminDAO = AdminDAO.getInstance();
			
			respModel.put("CmdAdmin_Theater", adminDAO.selectTheater());
			
			System.out.println("respModel : CmdAdmin:Theater ="+ respModel.get("CmdAdmin_Theater"));
			
//			bDao.updateReadCount(num);//글 조회수 1 증가
//			
//			BoardVO bVo = bDao.selectOneBoardByNum(num);//글 읽어오기
//			request.setAttribute("board", bVo);
			
			
			
			System.out.println("극장 정보 관리 모드 화면창");
			url = "../admin/admin_Theater.jsp";
		}
		
		return url;
	}

}
