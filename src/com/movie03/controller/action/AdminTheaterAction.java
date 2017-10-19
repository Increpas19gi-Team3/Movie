package com.movie03.controller.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.AdminDAO;
import com.movie03.dto.TheaterVO;

import util.ThumbImage;

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
		System.out.println("AdminTheaterAction cmd = " +cmd);
		
		
		if(cmd != null) {
			if(cmd.equals("UPDATE")){//정보 수정
	 			System.out.println("정보 수정 >>");
	 			//정보 수정
	 			
	 			System.out.println("TheaterTNAME :" + reqModel.get("TheaterTNAME"));
	 			System.out.println("TheaterTLOCAL :" + reqModel.get("TheaterTLOCAL"));
	 			System.out.println("TheaterTDESC :" + reqModel.get("TheaterTDESC"));
	 			System.out.println("TheaterTIMAGE :" + reqModel.get("TheaterTIMAGE"));
	 			
				url = "../admin/theaterMgrView.jsp";
			}
			
		}else{ //영화관 정보 가져오기
			AdminDAO adminDAO = AdminDAO.getInstance();
			List<TheaterVO> theaterList = adminDAO.selectTheater();
			
			if(theaterList.size() < 1){//영화관 정보가 없다면 영화관 정보 입력창으로 이동
				url = "../admin/theaterMgrInsert.jsp"; 
				
			}else{//영화관 정보가 있다면 보여줌
				respModel.put("Admin_Theater", theaterList);
				url = "../admin/theaterMgrView.jsp";
			}
			
			
//			bDao.updateReadCount(num);//글 조회수 1 증가
//			
//			BoardVO bVo = bDao.selectOneBoardByNum(num);//글 읽어오기
//			request.setAttribute("board", bVo);
			
			
			System.out.println("AdminTheaterAction respModel(Admin_Theater) ="+ respModel.get("Admin_Theater"));
			System.out.println("AdminTheaterAction url =" + url);
		}
		
		return url;
	}

}
