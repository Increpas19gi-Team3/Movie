package com.movie03.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBManager;

import com.movie03.dto.MovieVO;
import com.movie03.dto.ScreeningVO;
import com.movie03.dto.TheaterVO;

import oracle.jdbc.proxy.annotation.Pre;

/**
 * 관리자용 DAO
 * @author 손가연
 *
 */
public class AdminDAO {
	private AdminDAO() {}

	private static AdminDAO instance = new AdminDAO();

	public static AdminDAO getInstance() {
		return instance;
	}
	

	/**
	 * 영화관 정보 가져오기
	 * @return List<TheaterVO>
	 */
	public List<TheaterVO> selectTheater(){
		List<TheaterVO> list = new ArrayList<TheaterVO>();
		
		String sql = "SELECT * FROM THEATER";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				TheaterVO tVO = new TheaterVO();
				tVO.setTCODE(rs.getString("TCODE"));
				tVO.setTNAME(rs.getString("TNAME"));
				tVO.setTLOCAL(rs.getString("TLOCAL"));
				tVO.setTDESC(rs.getString("TDESC"));
				tVO.setTIMAGE(rs.getString("TIMAGE"));
				list.add(tVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	/**
	 * 영화관 정보 등록
	 * @param TheaterVO
	 */
	public void insertTheater(TheaterVO tVO){
		
		String sql = "INSERT INTO THEATER VALUES('T01', ?, ?, ?, ? )";
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
		
		try {
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			
			prepStmt.setString(1, tVO.getTNAME());
			prepStmt.setString(2, tVO.getTLOCAL());
			prepStmt.setString(3, tVO.getTDESC());
			prepStmt.setString(4, tVO.getTIMAGE());
			prepStmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, prepStmt);
		}
	}
	
	/**
	 * 영화관 정보 수정
	 * @param TheaterVO
	 */
	public void updateTheater(TheaterVO tVO){
		
		String sql = "UPDATE THEATER SET TNAME = ?, TLOCAL = ?, TDESC = ?, TIMAGE = ?"
				+ "WHERE TCODE = 'T01'";
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
		
		try {
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			
			prepStmt.setString(1, tVO.getTNAME());
			prepStmt.setString(2, tVO.getTLOCAL());
			prepStmt.setString(3, tVO.getTDESC());
			prepStmt.setString(4, tVO.getTIMAGE());
			prepStmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, prepStmt);
		}
	}

	
	/**
	 * 상영관 정보 가져오기
	 * @return List<ScreeningVO>
	 */
	public List<ScreeningVO> selectScreening(){
		List<ScreeningVO> list = new ArrayList<ScreeningVO>();
		
		String sql = "SELECT * FROM SCREENING";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				ScreeningVO sVO = new ScreeningVO();
				sVO.setSCODE(rs.getString("SCODE"));
				sVO.setTCODE(rs.getString("TCODE"));
				sVO.setSNAME(rs.getString("SNAME"));
				sVO.setSSEATCNT(rs.getInt("SSEATCNT"));
				sVO.setSSEATINFO(rs.getString("SSEATINFO"));
				sVO.setSTURN(rs.getString("STURN"));
				sVO.setSTIME(rs.getString("STIME"));
				list.add(sVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}

	
	/**
	 * 상영관 정보 등록
	 * @param ScreeningVO
	 */
	public void insertScreening(ScreeningVO sVO){
		
		String sql = "INSERT INTO SCREENING VALUES('S01', 'T01',  ?, '25', ?, '1,2,3', '12, 16, 20')";
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
		
		try {
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			
			prepStmt.setString(1, sVO.getSNAME());//상영관 이름
			prepStmt.setString(2, sVO.getSSEATINFO());// 정보
			prepStmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, prepStmt);
		}
	}

	
	/**
	 * 상영관 정보 수정
	 * @param ScreeningVO
	 */
	public void updateScreening(ScreeningVO sVO){
		
		System.out.println("updateScreening :" + sVO.toString());
		
		String sql = "UPDATE SCREENING SET SNAME = ?, SSEATINFO = ? WHERE SCODE = 'S01'";
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
		
		try {
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			
			prepStmt.setString(1, sVO.getSNAME());
			prepStmt.setString(2, sVO.getSSEATINFO());
			prepStmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, prepStmt);
		}
	}

	
	/**
	 * 영화 목록 가져오기
	 * @param whereColumn - 검색 종류(TITLE, DIRECTOR, ACTOR, GENRE) 
	 * @param word - 검색어
	 * @param sort - 정렬
	 * @return
	 */
	public List<MovieVO> selectMovieList(String whereColumn, String word, String sort){
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		String sqlWhere = "";
		String sqlOrderBy = "ORDER BY TITLE ASC";
		String sql = "SELECT * FROM MOVIE ";
		
		// where 절 생성
		System.out.println("whereColumn equlas:" + (whereColumn.equals("")));
		System.out.println("whereColumn length:" + (whereColumn.length()));
		if(!whereColumn.equals("")){
			//sqlWhere = "WHERE ? LIKE '%?%' ";
			sqlWhere = "WHERE "+ whereColumn +" LIKE '%"+ word +"%' ";
		}
		
		// sort 절 생성
		if(sort.equals("ASC")){
			sqlOrderBy = "ORDER BY TITLE DESC";
		}else{
			sqlOrderBy = "ORDER BY TITLE ASC";
		}
		
		//최종 SQL
		sql = sql + sqlWhere + sqlOrderBy;
		System.out.println("selectMovieList sql:" + sql);
		
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		
		try{
			
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			
			if(!whereColumn.equals("")){
				prepStmt.setString(1, whereColumn);
				prepStmt.setString(2, word);
			}
			rs = prepStmt.executeQuery();
			
			
			while(rs.next()){
				MovieVO mVO = new MovieVO();
				mVO.setMCODE(rs.getString("MCODE")); 
				mVO.setTITLE(rs.getString("TITLE"));
				mVO.setPRICE(rs.getInt("PRICE"));
				mVO.setDIRECTOR(rs.getString("DIRECTOR"));
				mVO.setACTOR(rs.getString("ACTOR"));
				mVO.setOPENDAY(rs.getString("OPENDAY"));
				mVO.setGENRE(rs.getString("GENRE"));   
				mVO.setPOSTER(rs.getString("POSTER"));
				mVO.setSYNOPSIS(rs.getString("SYNOPSIS"));
				mVO.setSTARTDAY(rs.getString("STARTDAY"));
				mVO.setENDDAY(rs.getString("ENDDAY"));
				mVO.setAPPRAISAL(rs.getString("APPRAISAL"));
				list.add(mVO);
			}
			
			System.out.println(">>>>>>>>>>>>>>>> 여기까지 이상 없음");
		}catch(Exception e){
			e.getStackTrace();
		}finally {
			System.out.println(">>>>>>>>>>>>>>>> finally 시작");
			DBManager.close(conn, prepStmt, rs);
			System.out.println(">>>>>>>>>>>>>>>> finally 끝");
		}
		
		return list;
	}
	
}
