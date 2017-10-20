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
		String reqListSort = "";
		
		if((String)reqModel.get("SearchGubun") != null) reqListGubun = (String)reqModel.get("SearchGubun");
		if((String)reqModel.get("SearchWord") != null) reqListWord = (String)reqModel.get("SearchWord");
		if((String)reqModel.get("Sort") != null) reqListSort = (String)reqModel.get("Sort");

		// 검색, 정렬을 그대로 표현해 주기 위해서 받아온 데이터를 다시 넣어서 돌려보내 줌
		respModel.put("SearchGubun", reqListGubun);
		respModel.put("SearchWord", reqListWord);
		respModel.put("Sort", reqListSort);
		
		
		//if((String)reqModel.get("") != null)  = (String)reqModel.get("");
		
		
		
		if(cmd != null){
			if(cmd.equals("Movie_LIST")){
				System.out.println("리스트 출력-검색, 정렬");
				List<MovieVO> movieList = adminDAO.selectMovieList(reqListGubun, reqListWord, reqListSort);
				
				respModel.put("MgrListMovie", movieList);
				respModel.put("CmdMgr", "Movie_LIST");
				
				url = "../admin/movieMgrList.jsp";
				
			}else if(cmd.equals("Movie_INSERT_FORM")){//Movie_INSERT_FORM
				
				
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
