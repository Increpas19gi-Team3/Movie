package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.MovieDAO;
import com.movie03.dto.MovieVO;

/**
 * 영화 관리 AC
 * 
 * @author 손가연
 *
 */
public class MovieAction implements Action {

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {

		String url = ""; // 선언

		// 요청 받은 검색어
		// 검색에 관한 - CmdMovie
		System.out.println("CmdMovie : " + reqModel.get("CmdMovie"));
		String Cmd = (String) reqModel.get("CmdMovie");

		// 제목 정렬에 관한(내림, 오름) - OrderBy
		System.out.println("OrderBy : " + reqModel.get("OrderBy"));
		String OrderBy = (String) reqModel.get("OrderBy");

		// List<MovieVO> list 선언
		List<MovieVO> list = null;

		// 이걸 왜 이렇게 복잡하게 만들었을까?
		// 그냥 if, else로만 쓰면 안될까?
		if (OrderBy == null) { // 정렬에 관한 값이 없다면 오름차순으로 정리
			OrderBy = "ASC";
		} else { // 정렬에 관한 값이 있다면 내림차순(DESC)
			if (OrderBy.equals("ASC")) {
				OrderBy = "DESC";
			} else {
				OrderBy = "ASC";
			}
		}

		// 요청 받은 검색어
		// 검색에 관한 - CmdMovie
		if (Cmd != null) { // 뭔가 검색어를 입력 받았다면
			if (Cmd.equals("Search")) {
				// 요청 request = get
				// select_word : 선택박스(제목, 감독, 배우, 장르)
				// search_text : 검색박스(입력받은 값) 
				String word = (String) reqModel.get("select_word");
				String text = (String) reqModel.get("search_text");

				MovieDAO mDAO = MovieDAO.getInstance();
				// MovieDAO-MovieSelect(select_word, search_text) SQL문 실행
				list = mDAO.MovieSelect(word, text);
				// response = put
				// 응답받은 list = MovieList에 담고
				// 응답받은 OrderBy = OrderBy에 넣는다.
				respModel.put("MovieList", list);
				respModel.put("OrderBy", OrderBy);
				// url = "../movie/MovieList.jsp" 이동주소를 넣어줌
				url = "../movie/MovieList.jsp";
			}
		} else { // 명령어 없을때는 리스트 보여주기
			MovieDAO mDAO = MovieDAO.getInstance();
			// MovieDAO - MovieChoose(String choose)
			// 오름차순으로 전체 검색 SQL문 실행
			list = mDAO.MovieChoose(OrderBy);
			// response - put
			respModel.put("MovieList", list);
			respModel.put("OrderBy", OrderBy);

			url = "../movie/MovieList.jsp";
		}

		// 검색일때

		// 상세보기 일때

		// 관리자 화면을 보여주기만 함.
		System.out.println("영화 모드 화면창");
		System.out.println("url = " + url);
		return url;
	}
}
