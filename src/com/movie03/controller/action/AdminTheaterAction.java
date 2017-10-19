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
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		String url = "";
		
		String cmd = (String)reqModel.get("CmdMgr");
		System.out.println("AdminTheaterAction CmdMgr = " +cmd);
		
		String reqTNAME = "";
		String reqTLOCAL = "";
		String reqTDESC = "";
		String reqTIMAGE = "";
		
		if((String)reqModel.get("TheaterTNAME") != null) reqTNAME = (String)reqModel.get("TheaterTNAME");
		if((String)reqModel.get("TheaterTLOCAL") != null) reqTLOCAL = (String)reqModel.get("TheaterTLOCAL"); 
		if((String)reqModel.get("TheaterTDESC") != null) reqTDESC = (String)reqModel.get("TheaterTDESC");
		if((String)reqModel.get("TheaterTIMAGE") != null) reqTIMAGE = (String)reqModel.get("TheaterTIMAGE"); 
		
		if(cmd != null) {
			
			if(cmd.equals("Theater_UPDATE_FORM")){//수정 폼으로 이동
				List<TheaterVO> theaterList = adminDAO.selectTheater();
				respModel.put("MgrViewTheater", theaterList);
				
				url = "../admin/theaterMgrForm.jsp"; 
				
			}else if(cmd.equals("Theater_UPDATE")){//정보 수정
	 			System.out.println("정보 수정 >>");
	 			
	 			TheaterVO tVO = new TheaterVO();
	 			tVO.setTNAME(reqTNAME);
	 			tVO.setTLOCAL(reqTLOCAL);
	 			tVO.setTDESC(reqTDESC);
	 			tVO.setTIMAGE(reqTIMAGE);
	 			
	 			adminDAO.updateTheater(tVO); //수정
	 			
	 			// 보기 페이지로 이동
	 			List<TheaterVO> theaterList = adminDAO.selectTheater();
	 			respModel.put("MgrViewTheater", theaterList);
	 			respModel.put("CmdMgr", "Theater_VIEW");
				url = "../admin/theaterMgrView.jsp";
				
				
			}else if(cmd.equals("Theater_INSERT")){//정보 등록
	 			System.out.println("정보 등록 >>");
				
				TheaterVO tVO = new TheaterVO();
	 			tVO.setTNAME(reqTNAME);
	 			tVO.setTLOCAL(reqTLOCAL);
	 			tVO.setTDESC(reqTDESC);
	 			tVO.setTIMAGE(reqTIMAGE);
	 			
	 			adminDAO.insertTheater(tVO); // 영화관 정보 저장
	 			
	 			// 보기 페이지로 이동
	 			List<TheaterVO> theaterList = adminDAO.selectTheater();
	 			respModel.put("MgrViewTheater", theaterList);
	 			respModel.put("CmdMgr", "Theater_VIEW");
				url = "../admin/theaterMgrView.jsp";
				
			}else{//Theater_VIEW
	 			// 보기 페이지로 이동
	 			List<TheaterVO> theaterList = adminDAO.selectTheater();
	 			respModel.put("MgrViewTheater", theaterList);
	 			
				url = "../admin/theaterMgrView.jsp";
			}
			
		}else{ //영화관 정보 가져오기
			
			List<TheaterVO> theaterList = adminDAO.selectTheater();
			
			if(theaterList.size() < 1){//영화관 정보가 없다면 영화관 정보 입력창으로 이동
				
				url = "../admin/theaterMgrForm.jsp"; 
				
			}else{//영화관 정보가 있다면 보여줌
				
				respModel.put("MgrViewTheater", theaterList);
				url = "../admin/theaterMgrView.jsp";
			}
			
		}
		System.out.println("AdminTheaterAction url =" + url);
		return url;
	}

}
