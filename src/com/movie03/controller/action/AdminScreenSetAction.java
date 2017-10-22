package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.AdminDAO;
import com.movie03.dto.MovieVO;
import com.movie03.dto.ScreenSetVO;

/**
 * 상영 영화 관리 AC 
 * @author 손가연
 *
 */
public class AdminScreenSetAction implements Action{

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {

		// 관리자 화면을 보여주기만 함.
		System.out.println("상영 영화 관리 모드 화면창");
		AdminDAO adminDAO = AdminDAO.getInstance();
		String url = "../admin/screenSetMgrList.jsp";
		
		String cmd = (String)reqModel.get("CmdMgr");
		System.out.println("AdminScreenSetAction CmdMgr = " +cmd);
		

		//수정, 삭제
		String reqSTturn = "";
		String reqSTdate = "";
		String reqMTitle = "";
		if((String)reqModel.get("STturn") != null) reqSTturn = (String)reqModel.get("STturn");
		if((String)reqModel.get("STdate") != null) reqSTdate = (String)reqModel.get("STdate");
		if((String)reqModel.get("MTitle") != null) reqMTitle = (String)reqModel.get("MTitle");
		
				
		if(cmd != null){
			//SSet_FORM
			if(cmd.equals("SSet_LIST")){// 리스트 화면
				List<ScreenSetVO> SSetList = adminDAO.selectScreenSetList();
				respModel.put("MgrListSSet", SSetList);
				
				respModel.put("CmdMgr", "SSet_LIST");
				url = "../admin/screenSetMgrList.jsp";
				
			}else if(cmd.equals("SSet_VIEW")){
				
				List<ScreenSetVO> SSetView = adminDAO.selectScreenSetView(reqSTdate);
				respModel.put("MgrViewSSet", SSetView);
				
				respModel.put("CmdMgr", cmd);
				url = "../admin/screenSetMgrView.jsp";
				
				
			}else if(cmd.equals("SSet_INSERT_FORM")){
				respModel.put("CmdMgr", cmd);
				url = "../admin/screenSetMgrForm.jsp";
				
			}else if(cmd.equals("SSet_UPDATE_FORM")){

				respModel.put("STturn", reqSTturn);
				respModel.put("STdate", reqSTdate);
				respModel.put("MTitle", reqMTitle);
				
				//System.out.println("2. 클릭한 날짜<"+  +">에 맞춰서 영화 목록표를 가져옴");
				List<MovieVO> SSetMovie = adminDAO.selectScreenSetMovie(reqSTdate);
				respModel.put("MgrViewSSetMovie", SSetMovie);
				
				respModel.put("CmdMgr", cmd);
				url = "../admin/screenSetMgrForm.jsp";
				
				
				
			}else if(cmd.equals("SSet_DELETE")){
				
				//DB 내용 삭제
				adminDAO.deleteScreenSet(reqSTdate, reqSTturn);
				
				
				//리스트 화면으로 내보냄
				List<ScreenSetVO> SSetList = adminDAO.selectScreenSetList();
				respModel.put("MgrListSSet", SSetList);
				
				respModel.put("CmdMgr", "SSet_LIST");
				url = "../admin/screenSetMgrList.jsp";
			}
			
			
			
		}else{// 명령이 없으면 list만 보여주기
			
			List<ScreenSetVO> SSetList = adminDAO.selectScreenSetList();
			respModel.put("MgrListSSet", SSetList);
			
			respModel.put("CmdMgr", "SSet_LIST");
			url = "../admin/screenSetMgrList.jsp";
			
		}
		
		
		
		
		return url;
	}

}
