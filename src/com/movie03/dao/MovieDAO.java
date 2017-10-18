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
	 * 영화 전체 검색
	 * 영화-리스트 ; MovieChoose(String gubun)
	 *  : 영화제목으로 내림차순-정렬하는 SQL문
	 *  : gubun에 따라 down=내림차순, up=오름차순 '없음'은 테이블 전체 출력
	 *  : 일단 모든 정보를 List에 담아 넣음
	 * @return List<MovieVO>	  
	 */	
	public List<MovieVO> MovieChoose(String gubun){
				
		String sql= "select * form Movie order by title";
	
		/*if(gubun=down){
			sql+=desc;
		} else if(gubun=up){
			sql+=asc;
		} else if(gubun=없음){
			sql="select * form Movie";
		}*/	
		
		List<MovieVO> list = new ArrayList<MovieVO>();
		Connection conn  = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				
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
	 * @param gubun
	 * @param 검색어
	 * 화면에서 '선택박스(없음, 영화제목, 감독, 배우, 장르)'를 선택후 '검색어'에
	 * 검색을 하는 기능을 하는 메소드
	 * 아직 SQL문 실행 안했음
	 */
	public List<MovieVO> MovieSelect(String gubun, String 검색어) {

		String sql = "select mcode, title, DIRECTOR, ACTOR, GENRE  from movie";		
		
		/*if (gubun = 없음) {
			// 전체 검색
			// '없음'이면 sql = sql???? 이게 뭐지?
			sql = "select mcode, title, DIRECTOR, ACTOR, GENRE  from movie";			
		} else if (gubun = title) {
			// 제목 검색
			sql += "where title like '%검색어%'";
		} else if (gubun = DIRECTOR) {
			// 감독 검색
			sql += "where DIRECTOR like '%검색어%'";
		} else if (gubun = ACTOR) {
			// 배우 검색
			sql += "where ACTOR like '%검색어%'";
		} else if (gubun = GENRE) {
			// 장르 검색
			sql += "where GENRE like '%검색어%'";
		}*/
		
		System.out.println("sql = " + sql);
		
		List<MovieVO> list = new ArrayList<MovieVO>();
		Connection conn  = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				
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
		}	
		return list;
	} // MovieSelect(String gubun, String 검색어)-End	
}