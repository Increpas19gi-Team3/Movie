package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.AdminDAO;
import com.movie03.dto.ScreeningVO;

/**
 * 상영관 관리 AC
 * @author 손가연
 *
 */
public class AdminScreeningAction implements Action{

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		String url = "";
		
		String cmd = (String)reqModel.get("CmdMgr");
		System.out.println("AdminScreeningAction CmdMgr = " +cmd);
		

		String reqTCODE  = "";
		String reqSCODE  = "";
		String reqSNAME  = "";
		String reqSINFO  = "";
//		int reqSSSEATCNT;
//		String reqSSTURN  = "";
//		String reqSSTIME  = "";
		
		if((String)reqModel.get("ScreenTCODE") != null) reqTCODE = (String)reqModel.get("ScreenTCODE");
		if((String)reqModel.get("ScreenSCODE") != null) reqSCODE = (String)reqModel.get("ScreenSCODE");
		if((String)reqModel.get("ScreenSNAME") != null) reqSNAME = (String)reqModel.get("ScreenSNAME");
		if((String)reqModel.get("ScreenSSEATINFO") != null) reqSINFO = (String)reqModel.get("ScreenSSEATINFO");
//		if((String)reqModel.get("") != null)
		
		
		if(cmd != null){ // ..//admin/admin_Screening.do
			
			if(cmd.equals("Screen_UPDATE_FORM")){//수정 폼으로 이동
				System.out.println("수정 폼으로 이동 >>");
				
				List<ScreeningVO> screenList = adminDAO.selectScreening();
				respModel.put("MgrViewScreen", screenList);
				
				url = "../admin/screenMgrForm.jsp";
				
			}else if(cmd.equals("Screen_UPDATE")){//정보 수정
	 			System.out.println("정보 수정 >>");
	 			
	 			ScreeningVO sVO = new ScreeningVO();
	 			sVO.setSNAME(reqSNAME);
	 			sVO.setSSEATINFO(reqSINFO);
	 			
	 			adminDAO.updateScreening(sVO);//수정

	 			
	 			// 보기 페이지로 이동
	 			List<ScreeningVO> screenList = adminDAO.selectScreening();
				respModel.put("MgrViewScreen", screenList);
	 			respModel.put("CmdMgr", "Screen_VIEW");
	 			url = "../admin/screenMgrView.jsp";
	 			
	 			
			}else if(cmd.equals("Screen_INSERT")){//정보 등록
	 			System.out.println("정보 등록 >>");
	 			
	 			ScreeningVO sVO = new ScreeningVO();
	 			sVO.setSNAME(reqSNAME);
	 			sVO.setSSEATINFO(reqSINFO);
	 			
	 			adminDAO.insertScreening(sVO);//등록
	 			
	 			
	 			// 보기 페이지로 이동
	 			List<ScreeningVO> screenList = adminDAO.selectScreening();
				respModel.put("MgrViewScreen", screenList);
	 			respModel.put("CmdMgr", "Screen_VIEW");
	 			url = "../admin/screenMgrView.jsp";
	 			
	 			
			}else{// Screen_VIEW
	 			// 보기 페이지로 이동
				List<ScreeningVO> screenList = adminDAO.selectScreening();
				respModel.put("MgrViewScreen", screenList);
				
				url = "../admin/screenMgrView.jsp";
			}
			
		}else{ // 상영관 정보 가져오기
			List<ScreeningVO> screenList = adminDAO.selectScreening();
			
			if(screenList.size() < 1){// DB의 내용이 없으면 입력창으로 이동
				url = "../admin/screenMgrForm.jsp";
			}else{
				
				respModel.put("MgrViewScreen", screenList);
				url = "../admin/screenMgrView.jsp";
			}
			
		}
		System.out.println("AdminScreenAction url =" + url);
		return url;
	}

}
