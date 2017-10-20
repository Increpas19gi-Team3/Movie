package com.movie03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * @author 손대성 모든-SQL문?
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
	 * 실행 : 아직 구현안됨 영화 전체 검색 영화-리스트 ; MovieArray(String array) : 영화제목으로
	 * 내림차순-정렬하는 SQL문 : array에 따라 null(입력값 없음) = ASC, ASC(입력값없음)=DESC '없음'은 테이블
	 * 전체 출력 : 일단 모든 정보를 List에 담아 넣음
	 * 
	 * @return List<MovieVO>
	 */
	public List<MovieVO> MovieArray(String array) {

		String sql = "select * from Movie order by title  "+ array;

		//sql += array;
		
		// console-창에 보여주기 위한 실행문
		System.out.println("(MovieArray)sql = " + sql);

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
	} // MovieArray(String array)-End

	/**
	 * 영화검색 기능 화면(MovieList.jsp)에서 '선택박스(없음, 영화제목, 감독, 배우, 장르)'를 선택 후 '검색어'에 검색을
	 * 하는 기능을 하는 메소드 아직 SQL문 실행 안했음 
	 * @param gubun
	 * @param 검색어
	 */
	public List<MovieVO> MovieSelect(String select_word, String search_text) {

		MovieVO mVo = new MovieVO();
		
		// "MovieAction.java"에서 입력 받은 word(select_word), text(search_text)
		// SQL문 실행
		String sql = "select mcode, title, DIRECTOR, ACTOR, GENRE from movie ";

		if (select_word.equals("")) { // 전체 검색
		} else if (select_word.equals("title")) { // 제목 검색
			sql += "where title like '%?%'";
		} else if (select_word.equals("director")) { // 감독 검색
			sql += "where DIRECTOR like '%?%'";
		} else if (select_word.equals("actor")) { // 배우 검색
			sql += "where ACTOR like '%?%'";
		} else if (select_word.equals("genre")) { // 장르 검색
			sql += "where GENRE like '%?%'";
		}

		// console-창에 보여주기 위한 실행문
		sql += search_text;
		System.out.println("(MovieSelect)sql = " + sql);

		List<MovieVO> list = new ArrayList<MovieVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 이 문장이 맞는지 확인 필수!!
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search_text);
			rs = pstmt.executeQuery();

			// SQL문 실행이 된다면 제목, 감독, 배우, 장르
			if (rs.next()) {
				mVo.setTITLE(rs.getString("TITLE"));
				mVo.setDIRECTOR(rs.getString("DIRECTOR"));
				mVo.setACTOR(rs.getString("ACTOR"));
				mVo.setGENRE(rs.getString("GENRE"));
				list.add(mVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	} // MovieSelect(String select_word, String search_text)-End

	/*
	 * 정렬, 선택박스, 검색어 모든 것을 기능하는 메소드?
	 */
	public List<MovieVO> MovieAllSearch(String array, String select_word, String search_text) {

		MovieVO mVo = new MovieVO();

		// 최종적인 SQL문
		// select * from movie - 공통부분
		// where (변수, 선택박스) like '%(검색어)%'
		// order by title - 공통부분
		// desc(변수, 정렬)
		String sql = "select * from movie "; // 고정적 SQL문

		// where title(변수, 선택박스) like '%검색어%' order by title
		if (select_word.equals("")) { // 전체 검색
			sql += "order by title ";

		} else if (select_word.equals("title")) { // 제목 검색
			sql += "where title like '%?%' order by title ";

		} else if (select_word.equals("director")) { // 감독 검색
			sql += "where DIRECTOR like '%?%' order by title ";

		} else if (select_word.equals("actor")) { // 배우 검색
			sql += "where ACTOR like '%?%' order by title ";

		} else if (select_word.equals("genre")) { // 장르 검색
			sql += "where GENRE like '%?%' order by title ";
		}
		// 추가로 오름, 내림차순
		if (array.equals("")) { // 정렬에 관한 값이 없다면 오름차순으로 정리
			sql += "ASC";
		} else { // 정렬에 관한 값이 있다면 내림차순(DESC)
			if (array.equals("ASC")) {
				sql += "DESC";
			} else {
				sql += "ASC";
			}
		}
		// 잘 입력되는지 확인하기 위한 console 창
		sql += search_text;
		System.out.println("MovieAllSearch(array, select_word, search_text) : " + sql);

		// SQL문 조건 정렬과 선택박스, 검색어
		List<MovieVO> list = new ArrayList<MovieVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search_text);
			rs = pstmt.executeQuery();

			// SQL문 실행이 된다면 
			while (rs.next()) {				
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
				mVo.setAPPRAISAL(rs.getString("appraisal"));
				list.add(mVo);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}
