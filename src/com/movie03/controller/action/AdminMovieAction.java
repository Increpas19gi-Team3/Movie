package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.AdminDAO;
import com.movie03.dao.MovieDAO;
import com.movie03.dto.MovieVO;


/**
 * 영화 관리 AC 
 * @author 손가연
 *
 */
public class AdminMovieAction implements Action{

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {

		//System.out.println("영화 관리 모드 화면창");
		AdminDAO adminDAO = AdminDAO.getInstance();
		String url = "../admin/movieMgrList.jsp";
		
		String cmd = (String)reqModel.get("CmdMgr");
		System.out.println("AdminMovieAction CmdMgr = " +cmd);
		
		// 리스트 검색, 정렬 용도 변수
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
		
		//상세보기, 수정, 삭제
		String reqMCODE = ""; // 영화코드
		if((String)reqModel.get("MCODE") != null) reqMCODE = (String)reqModel.get("MCODE");		
		
		if(cmd != null){
			if(cmd.equals("Movie_LIST")){// 리스트 화면
				List<MovieVO> movieList = adminDAO.selectMovieList(reqListGubun, reqListWord, reqListSort);
				
				respModel.put("MgrListMovie", movieList);
				respModel.put("CmdMgr", cmd);
				
				url = "../admin/movieMgrList.jsp";
				
			}if(cmd.equals("Movie_VIEW")){ // 상세보기 화면
				MovieVO movieView = adminDAO.selectMovieView(reqMCODE);				
				
				respModel.put("MgrViewMovie", movieView);
				respModel.put("CmdMgr", cmd);
				
				url = "../admin/movieMgrView.jsp";
				
			}else if(cmd.equals("Movie_INSERT_FORM")){ //입력 폼으로 이동
				
				respModel.put("CmdMgr", "Movie_INSERT_FORM");
				url = "../admin/movieMgrForm.jsp";				
				
			}else if(cmd.equals("Movie_INSERT")){ //입력 - DB
				
				// DB 입력 쿼리
				adminDAO.insertMovie(setData(reqModel));
				
				// 입력 후, 리스트로 보냄
				List<MovieVO> movieList = adminDAO.selectMovieList(reqListGubun, reqListWord, reqListSort);
				respModel.put("MgrListMovie", movieList);
				
				respModel.put("CmdMgr", "Movie_LIST");
				url = "../admin/movieMgrList.jsp";
				
				
			}else if(cmd.equals("Movie_UPDATE_FORM")){//수정 폼으로 이동
				MovieVO movieView = adminDAO.selectMovieView(reqMCODE);				
				respModel.put("MgrViewMovie", movieView);
				
				respModel.put("CmdMgr", "Movie_UPDATE_FORM");
				url = "../admin/movieMgrForm.jsp";
				
			}else if(cmd.equals("Movie_UPDATE")){//수정 - DB
				
				//DB 수정 쿼리
				adminDAO.updateMovie(setData(reqModel));
								
				// 수정 후, 상세보기로 보냄
				MovieVO movieView = adminDAO.selectMovieView(reqMCODE);				
				respModel.put("MgrViewMovie", movieView);
				
				respModel.put("CmdMgr", "Movie_VIEW");
				url = "../admin/movieMgrView.jsp";
				
			}else if(cmd.equals("Movie_DELETE")){//삭제 - DB
				
				//DB 작업
				adminDAO.deleteMovie(reqMCODE);				
				
				// 삭제 후 리스트로 이동
				List<MovieVO> movieList = adminDAO.selectMovieList(reqListGubun, reqListWord, reqListSort);
				respModel.put("MgrListMovie", movieList);
				
				respModel.put("CmdMgr", "Movie_LIST");
				url = "../admin/movieMgrList.jsp";
				
			}
			
		}else{// 명령이 없으면 list만 보여주기
			
			List<MovieVO> movieList = adminDAO.selectMovieList(reqListGubun, reqListWord, reqListSort);
			respModel.put("MgrListMovie", movieList);
			
			respModel.put("CmdMgr", "Movie_LIST");
			url = "../admin/movieMgrList.jsp";			
		}		
		return url;
	}
	
	
	/**
	 * 수정, 등록용 받아온 데이터를 MovieVO에 맞게 셋팅
	 * @param reqModel
	 * @return MovieVO
	 */
	public MovieVO setData(Map<String, Object> reqModel){
		MovieVO reqMVO = new MovieVO();
		
		String reqMCODE = ""; // 영화코드
		String reqTITLE = "";
		String reqPRICE = "";//int
		String reqDIRECTOR = "";
		String reqACTOR = "";
		String reqOPENDAY = "";
		String reqGENRE = "";
		String reqPOSTER = "";
		String reqSYNOPSIS = "";
		String reqSTARTDAY = "";
		String reqENDDAY = "";
		String reqAPPRAISAL = "";
		
		if((String)reqModel.get("MCODE") != null) reqMCODE = (String)reqModel.get("MCODE");
		
		if((String)reqModel.get("mvoTITLE") != null) reqTITLE = (String)reqModel.get("mvoTITLE");
		if((String)reqModel.get("mvoPRICE") != null) reqPRICE = (String)reqModel.get("mvoPRICE");//int
		if((String)reqModel.get("mvoDIRECTOR") != null) reqDIRECTOR = (String)reqModel.get("mvoDIRECTOR");
		if((String)reqModel.get("mvoACTOR") != null) reqACTOR = (String)reqModel.get("mvoACTOR");
		if((String)reqModel.get("mvoOPENDAY") != null) reqOPENDAY = (String)reqModel.get("mvoOPENDAY");
		if((String)reqModel.get("mvoGENRE") != null) reqGENRE = (String)reqModel.get("mvoGENRE");
		if((String)reqModel.get("mvoPOSTER") != null) reqPOSTER = (String)reqModel.get("mvoPOSTER");
		if((String)reqModel.get("mvoSYNOPSIS") != null) reqSYNOPSIS = (String)reqModel.get("mvoSYNOPSIS");
		if((String)reqModel.get("mvoSTARTDAY") != null) reqSTARTDAY = (String)reqModel.get("mvoSTARTDAY");
		if((String)reqModel.get("mvoENDDAY") != null) reqENDDAY = (String)reqModel.get("mvoENDDAY");
		if((String)reqModel.get("mvoAPPRAISAL") != null) reqAPPRAISAL = (String)reqModel.get("mvoAPPRAISAL");		
		
		reqMVO.setMCODE(reqMCODE);
		reqMVO.setTITLE(reqTITLE);
		reqMVO.setPRICE(Integer.parseInt(reqPRICE));
		reqMVO.setDIRECTOR(reqDIRECTOR);
		reqMVO.setACTOR(reqACTOR);
		reqMVO.setOPENDAY(reqOPENDAY);
		reqMVO.setGENRE(reqGENRE);
		reqMVO.setPOSTER(reqPOSTER);
		reqMVO.setSYNOPSIS(reqSYNOPSIS);
		reqMVO.setSTARTDAY(reqSTARTDAY);
		reqMVO.setENDDAY(reqENDDAY);
		reqMVO.setAPPRAISAL(reqAPPRAISAL);
		
		return reqMVO;
	}
}
