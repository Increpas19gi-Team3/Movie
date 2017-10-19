package com.movie03.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie03.dto.MovieVO;

import util.DBManager;

/**
 * 영화 DB DAO
 * 
 * @author 손대성
 *
 */
public class MovieDAO {

	private MovieDAO() {
	}

	private static MovieDAO instance = new MovieDAO();

	public static MovieDAO getInstance() {
		return instance;
	}

	/**
	 * 실행 : 아직 구현안됨
	 * 
	 * 영화 전체 검색 영화-리스트 ; MovieChoose(String gubun) : 영화제목으로 내림차순-정렬하는 SQL문 :
	 * choose에 따라 down=내림차순, up=오름차순 '없음'은 테이블 전체 출력 : 일단 모든 정보를 List에 담아 넣음
	 * 
	 * @return List<MovieVO>
	 */
	public List<MovieVO> MovieChoose(String choose) {

		String sql = "select * from Movie order by title";

		if (choose.equals("")) { // 정렬에 관한 값이 없다면 오름차순으로 정리
			sql += "ASC";
		} else { // 정렬에 관한 값이 있다면 내림차순(DESC)
			if (choose.equals("ASC")) {
				sql += "DESC";
			} else {
				sql += "ASC";
			}
		}

		List<MovieVO> list = new ArrayList<MovieVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				MovieVO mVo = new MovieVO();
				mVo.setMCODE(rs.getString("Mcode"));
				mVo.setTITLE(rs.getString("title"));
				mVo.setPRICE(rs.getInt("price"));
				mVo.setDIRECTOR(rs.getString("director"));
				mVo.setACTOR(rs.getString("actor"));
				mVo.setOPENDAY(rs.getString("openDay"));
				mVo.setGENRE(rs.getString("genre"));
				mVo.setPOSTER(rs.getString("poster"));
				mVo.setSYNOPSIS(rs.getString("synopsis"));
				mVo.setSTARTDAY(rs.getString("startDay"));
				mVo.setENDDAY(rs.getString("endDay"));
				mVo.setMCOMMENT(rs.getString("Mcomment"));
				mVo.setAPPRAISAL(rs.getString("appraisal"));
				list.add(mVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	} // MovieChoose(String gubun)-End

	/**
	 * 영화검색 기능
	 * 
	 * @param gubun
	 * @param 검색어
	 *            화면(MovieList.jsp)에서 '선택박스(없음, 영화제목, 감독, 배우, 장르)'를 선택 후 '검색어'에
	 *            검색을 하는 기능을 하는 메소드 아직 SQL문 실행 안했음
	 */
	public List<MovieVO> MovieSelect(String select_word, String search_text) {

		// "MovieAction.java"에서 입력 받은 word(select_word), text(search_text)
		// SQL문 실행
		String sql = "select mcode, title, DIRECTOR, ACTOR, GENRE from movie ";

		if (select_word.equals("")) {// 전체 검색			
		} else if (select_word.equals("title")) {// 제목 검색
			sql += "where title = ";
		} else if (select_word.equals("director")) {// 감독 검색
			sql += "where DIRECTOR = ";
		} else if (select_word.equals("actor")) {// 배우 검색
			sql += "where ACTOR = ";
		} else if (select_word.equals("genre")) {// 장르 검색
			sql += "where GENRE = ";
		}
		sql += search_text;
		System.out.println("sql = " + sql);

		List<MovieVO> list = new ArrayList<MovieVO>();
		/*Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				MovieVO mVo = new MovieVO();
				mVo.setMCODE(rs.getString("Mcode"));
				mVo.setTITLE(rs.getString("title"));
				mVo.setPRICE(rs.getInt("price"));
				mVo.setDIRECTOR(rs.getString("director"));
				mVo.setACTOR(rs.getString("actor"));
				mVo.setGENRE(rs.getString("genre"));
				list.add(mVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}*/
		return list;
	} // MovieSelect(String select_word, String search_text)-End
}