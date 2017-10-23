package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.MovieDAO;
import com.movie03.dto.MovieVO;

/**
 * 영화 관리 AC
 * 
 * @author 손가연, 손대성
 *
 */
public class MovieAction implements Action {

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {

		System.out.println("MovieAction >>>>>>>>>>>>>>");

		String url = "../movie/MovieList.jsp";
		// MovieList.java에서
		String Cmd = ""; // 요청 받은 검색어 : 검색에 관한 - CmdMovie
		String OrderBy = "DESC"; // 제목 정렬에 관한(내림, 오름) - OrderBy
		String DetailMovieNum = ""; // 상세보기에 관한 영화코드번호 - DetailMovieNum

		System.out.println("MovieAction-execute : " + url);

		System.out.println("CmdMovie : " + reqModel.get("CmdMovie"));
		Cmd = (String) reqModel.get("CmdMovie");

		System.out.println("OrderBy : " + reqModel.get("OrderBy"));
		if ((String) reqModel.get("OrderBy") != null) {
			OrderBy = (String) reqModel.get("OrderBy");
		}

		System.out.println("DetailMovieNum : " + reqModel.get("DetailMovieNum"));
		DetailMovieNum = (String) reqModel.get("DetailMovieNum");

		List<MovieVO> list = null;
		
		/* if-문은 잘써야 함 안그러면 괜히 다른 if-절이 같이 실행됨 고럼 이상한 출력물이 계속 뜨게됨 */

		// 처음 실행시 null임 그래서 'ASC'
		// 두번쨰 클릭시 저장된 값이 'ASC'이기 때문에 'DESC'로 바뀌게 됨
		if (OrderBy.equals("DESC")) { // DESC 일때 ASC 로 변환
			OrderBy = "ASC";
		} else { // ASC 일때 DESC 로 변환
			OrderBy = "DESC";
		}

		// 1. 요청 받은 검색어
		// 검색에 관한 - CmdMovie
		if (Cmd != null) { // 뭔가 검색어를 입력 받았다면
			// MovieList.jsp-<input type="hidden" name="CmdMovie"
			// value="Search"
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
		} else { // "Cmd(CmdMovie) == null" : 검색받은 내용이 없으면 상세보기 페이지로 (DetailMovie)

			if (DetailMovieNum != null) {

				MovieDAO mDAO = MovieDAO.getInstance();
				// MovieDAO - SelectOneMovieByCode(String code)
				// 영화코드로 영화상세정보를 가져옴
				list = mDAO.SelectOneMovieByCode(DetailMovieNum);
				// response - put
				respModel.put("DetailMovieNum", list);

				url = "../movie/MovieDetailPage.jsp";

			} else { // 명령어 없을때는 리스트 보여주기

				MovieDAO mDAO = MovieDAO.getInstance();
				// MovieDAO - MovieArray(String array)
				// 오름차순으로 전체 검색 SQL문 실행
				list = mDAO.MovieArray(OrderBy);
				// response - put
				respModel.put("MovieList", list);
				respModel.put("OrderBy", OrderBy);
				url = "../movie/MovieList.jsp";
			}
		}

		// console - 화면을 보여주기만 함.
		System.out.println("영화 모드 화면창");
		System.out.println("MovieAction url = " + url);
		return url;
	}
}
