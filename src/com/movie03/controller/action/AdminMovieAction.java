package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.AdminDAO;
import com.movie03.dto.MovieVO;


/**
 * 영화 관리 AC 
 * @author 손가연
 *
 */
public class AdminMovieAction implements Action{

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {

		System.out.println("영화 관리 모드 화면창");
		AdminDAO adminDAO = AdminDAO.getInstance();
		String url = "../admin/movieMgrList.jsp";
		
		String cmd = (String)reqModel.get("CmdMgr");
		System.out.println("AdminMovieAction CmdMgr = " +cmd);
		
		//리스트 검색, 정렬 용도 변수
		String reqListGubun = ""; //찾을 컬럼
		String reqListWord = "";
		String reqListSort = "ASC";
		
		if((String)reqModel.get("SearchGubun") != null) reqListGubun = (String)reqModel.get("SearchGubun");
		if((String)reqModel.get("SearchWord") != null) reqListWord = (String)reqModel.get("SearchWord");
		if((String)reqModel.get("Sort") != null) reqListSort = (String)reqModel.get("Sort");

		// 검색, 정렬을 그대로 표현해 주기 위해서 받아온 데이터를 다시 넣어서 돌려보내 줌
		respModel.put("SearchGubun", reqListGubun);
		respModel.put("SearchWord", reqListWord);
		respModel.put("Sort", reqListSort);
		
		String reqMCODE = "";
		if((String)reqModel.get("MCODE") != null) reqMCODE = (String)reqModel.get("MCODE");
		
		
		if(cmd != null){
			if(cmd.equals("Movie_LIST")){// 리스트 화면
				List<MovieVO> movieList = adminDAO.selectMovieList(reqListGubun, reqListWord, reqListSort);
				
				respModel.put("MgrListMovie", movieList);
				respModel.put("CmdMgr", cmd);
				
				url = "../admin/movieMgrList.jsp";
				
			}if(cmd.equals("Movie_VIEW")){// 상세보기 화면
				MovieVO movieView = adminDAO.selectMovieView(reqMCODE);				
				
				respModel.put("MgrViewMovie", movieView);
				respModel.put("CmdMgr", cmd);
				
				url = "../admin/movieMgrView.jsp";
				
			}else if(cmd.equals("Movie_INSERT_FORM")){//입력 폼으로 이동
				System.out.println(">>>>>>>>>> 입력 폼으로 이동 작업 필요");
				
			}else if(cmd.equals("Movie_INSERT")){//입력 - DB
				System.out.println(">>>>>>>>>> 입력 DB 작업 필요");
				
			}else if(cmd.equals("Movie_UPDATE_FORM")){//수정 폼으로 이동
				System.out.println(">>>>>>>>>> 수정 폼으로 이동, 수정할 내용 화면에 출력 작업 필요");
				
			}else if(cmd.equals("Movie_UPDATE")){//수정 - DB
				System.out.println(">>>>>>>>>> 수정 DB 작업 필요");
				
			}else if(cmd.equals("Movie_DELETE")){//삭제 - DB
				System.out.println(">>>>>>>>>> 삭제 DB 작업 필요");
				
			}
			
		}else{// 명령이 없으면 list만 보여주기
			
			List<MovieVO> movieList = adminDAO.selectMovieList(reqListGubun, reqListWord, reqListSort);

			respModel.put("MgrListMovie", movieList);
			respModel.put("CmdMgr", "Movie_LIST");
			
			url = "../admin/movieMgrList.jsp";
			
			
		}
		
		
		return url;
	}

}
