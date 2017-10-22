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
import com.movie03.dto.ScreenSetVO;
import com.movie03.dto.ScreenTurnVO;
import com.movie03.dto.ScreeningVO;
import com.movie03.dto.TheaterVO;


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
		String sql = "SELECT MCODE, TITLE, PRICE, DIRECTOR, ACTOR, To_Char(OPENDAY, 'YYYY-MM-DD') AS OPENDAY, GENRE, POSTER, SYNOPSIS, "+
					"To_Char(STARTDAY, 'YYYY-MM-DD') AS STARTDAY, To_Char(ENDDAY, 'YYYY-MM-DD') AS ENDDAY, APPRAISAL "+ 
					"FROM MOVIE ";
		
		/*// where 절 생성
		System.out.println("whereColumn equlas:" + (whereColumn.equals("")));
		System.out.println("whereColumn length:" + (whereColumn.length()));*/
		
		if(whereColumn.length() > 0){
			sqlWhere = "WHERE "+ whereColumn +" LIKE ? ";
		}
		
		sqlOrderBy = "ORDER BY TITLE " + sort;
		
		//최종 SQL
		sql = sql + sqlWhere + sqlOrderBy;
		System.out.println("selectMovieList sql:" + sql);
		
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		
		try{
			
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			
			if(whereColumn.length() > 0){
				prepStmt.setString(1, "%" + word + "%");
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
			
		}catch(Exception e){
			e.getStackTrace();
		}finally {
			DBManager.close(conn, prepStmt, rs);
		}
		
		return list;
	}
	
	
	
	/**
	 * 영화 상세보기
	 * @param MCODE - 영화코드
	 * @return MovieVO
	 */
	public MovieVO selectMovieView(String MCODE){
		MovieVO mVO = new MovieVO();
		
		String sql = "SELECT MCODE, TITLE, PRICE, DIRECTOR, ACTOR, To_Char(OPENDAY, 'YYYY-MM-DD') AS OPENDAY, GENRE, POSTER, SYNOPSIS, "+
					"To_Char(STARTDAY, 'YYYY-MM-DD') AS STARTDAY, To_Char(ENDDAY, 'YYYY-MM-DD') AS ENDDAY, APPRAISAL "+ 
					"FROM MOVIE "+
					"WHERE MCODE = ?";
		System.out.println("selectMovieView sql:" + sql);
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, MCODE);
			rs = prepStmt.executeQuery();
			
			while(rs.next()){				
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
			}
			
		}catch(Exception e){
			e.getStackTrace();
		}finally {
			DBManager.close(conn, prepStmt, rs);
		}
		
		return mVO;
	}
	
	
	/**
	 * 영화 정보 수정
	 * @param MovieVO
	 */
	public void updateMovie(MovieVO mVO){
		String sql = "UPDATE MOVIE SET "+
					"TITLE = ?, PRICE = ?, DIRECTOR = ?, ACTOR = ?, OPENDAY = ?, GENRE = ?, "+
					"POSTER = ?, SYNOPSIS = ?, STARTDAY = ?, ENDDAY = ?, APPRAISAL = ? "+
					"WHERE MCODE = ?";
		
		System.out.println("updateMovie sql:" + sql);
		Connection conn = null;
		PreparedStatement prepStmt = null;
		
		try {
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			
			prepStmt.setString(1, mVO.getTITLE());
			prepStmt.setInt(2, mVO.getPRICE());
			prepStmt.setString(3, mVO.getDIRECTOR());
			prepStmt.setString(4, mVO.getACTOR());
			prepStmt.setString(5, mVO.getOPENDAY());
			prepStmt.setString(6, mVO.getGENRE());
			prepStmt.setString(7, mVO.getPOSTER());
			prepStmt.setString(8, mVO.getSYNOPSIS());
			prepStmt.setString(9, mVO.getSTARTDAY());
			prepStmt.setString(10, mVO.getENDDAY());
			prepStmt.setString(11, mVO.getAPPRAISAL());
			prepStmt.setString(12, mVO.getMCODE());
			prepStmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, prepStmt);
		}
	}
	
	
	/**
	 * 영화 삭제
	 * @param MCODE - 영화 코드
	 */
	public void deleteMovie(String MCODE){
		String sql = "DELETE FROM MOVIE WHERE MCODE = ?";
		System.out.println("deleteMovie sql: "+ sql);
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
				
		try{
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, MCODE);
			prepStmt.executeQuery();
			
		}catch(Exception e){
			e.getStackTrace();
		}finally {
			DBManager.close(conn, prepStmt);
		}
		
	}
	
	
	/**
	 * 영화 등록
	 * @param MovieVO
	 */
	public void insertMovie(MovieVO mVO){
		String sql = "INSERT INTO MOVIE VALUES("+
					"(SELECT ('M'||LPAD(SUBSTR(MAX(MCODE), 2)+1, 2, '0')) AS MCODE FROM MOVIE), "+ //MCODE
					"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		System.out.println("insertMovie sql:" + sql);
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
		
		try {
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			
			prepStmt.setString(1, mVO.getTITLE());
			prepStmt.setInt(2, mVO.getPRICE());
			prepStmt.setString(3, mVO.getDIRECTOR());
			prepStmt.setString(4, mVO.getACTOR());
			prepStmt.setString(5, mVO.getOPENDAY());
			prepStmt.setString(6, mVO.getGENRE());
			prepStmt.setString(7, mVO.getPOSTER());
			prepStmt.setString(8, mVO.getSYNOPSIS());
			prepStmt.setString(9, mVO.getSTARTDAY());
			prepStmt.setString(10, mVO.getENDDAY());
			prepStmt.setString(11, mVO.getAPPRAISAL());
			prepStmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, prepStmt);
		}
		
	}

	
	/**
	 * 상영 영화 설정 목록
	 * @return List<ScreenSetVO>
	 */
	public List<ScreenSetVO> selectScreenSetList(){
		
		List<ScreenSetVO> list = new ArrayList<ScreenSetVO>();
		
		String sql = "SELECT T.SCODE, T.MCODE, M.TITLE, T.STTURN, "+
					"TO_CHAR(STDATE, 'YYYY-MM-DD') AS STDATE, TO_CHAR(M.OPENDAY, 'YYYY-MM-DD') AS OPENDAY, "+ 
					"TO_CHAR(M.STARTDAY, 'YYYY-MM-DD') AS STARTDAY, TO_CHAR(M.ENDDAY, 'YYYY-MM-DD') AS ENDDAY "+
					"FROM SCREENTURN T  INNER JOIN MOVIE M "+
					"ON T.MCODE = M.MCODE "+
					"ORDER BY T.STDATE DESC, T.STTURN ASC";
		System.out.println("selectScreenSetList sql:" + sql);
		
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try{
			
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			rs = prepStmt.executeQuery();
			
			while(rs.next()){
				
				ScreenSetVO ssVO = new ScreenSetVO();				
				ssVO.setSCode(rs.getString("SCODE"));
				ssVO.setMCode(rs.getString("MCODE"));
				ssVO.setMTitle(rs.getString("TITLE"));
				ssVO.setSTturn(rs.getString("STTURN"));
				ssVO.setSTdate(rs.getString("STDATE"));
				ssVO.setMOpenday(rs.getString("OPENDAY"));
				ssVO.setMStartday(rs.getString("STARTDAY"));
				ssVO.setMEndday(rs.getString("ENDDAY"));
				list.add(ssVO);
				
				//System.out.println("ADMIN > SSetList > ssVO: "+ ssVO.toString());
			}
			
		}catch(Exception e){
			e.getStackTrace();
		}finally {
			DBManager.close(conn, prepStmt, rs);
		}
		
		return list;
	}
	
	
	/**
	 * 상영 영화 설정 - 날짜에 맞는 영화목록들 가져오기
	 * @param reqSetDate
	 * @return
	 */
	public List<ScreenSetVO> selectScreenSetView(String reqSetDate){
		
		List<ScreenSetVO> list = new ArrayList<ScreenSetVO>();
		
		String sql = "SELECT T.SCODE, T.MCODE, M.TITLE, T.STTURN, "+
					"TO_CHAR(STDATE, 'YYYY-MM-DD') AS STDATE, TO_CHAR(M.OPENDAY, 'YYYY-MM-DD') AS OPENDAY, "+ 
					"TO_CHAR(M.STARTDAY, 'YYYY-MM-DD') AS STARTDAY, TO_CHAR(M.ENDDAY, 'YYYY-MM-DD') AS ENDDAY "+
					"FROM SCREENTURN T  INNER JOIN MOVIE M "+
					"ON T.MCODE = M.MCODE "+
					"WHERE STDATE = ? "+
					"ORDER BY T.STDATE DESC, T.STTURN ASC";
		System.out.println("selectScreenSetView sql:" + sql);
		
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try{
			
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, reqSetDate);
			rs = prepStmt.executeQuery();
			
			while(rs.next()){
				
				ScreenSetVO ssVO = new ScreenSetVO();				
				ssVO.setSCode(rs.getString("SCODE"));
				ssVO.setMCode(rs.getString("MCODE"));
				ssVO.setMTitle(rs.getString("TITLE"));
				ssVO.setSTturn(rs.getString("STTURN"));
				ssVO.setSTdate(rs.getString("STDATE"));
				ssVO.setMOpenday(rs.getString("OPENDAY"));
				ssVO.setMStartday(rs.getString("STARTDAY"));
				ssVO.setMEndday(rs.getString("ENDDAY"));
				list.add(ssVO);
				
			}
			
		}catch(Exception e){
			e.getStackTrace();
		}finally {
			DBManager.close(conn, prepStmt, rs);
		}
		
		return list;
	}
	
	
	/**
	 * 상영 영화 설정 - 날짜에 맞는 영화목록들 가져오기
	 * @param reqSetDate
	 * @return List<MovieVO>
	 */
	public List<MovieVO> selectScreenSetMovie(String reqSetDate){
		
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		String sql = "SELECT MCODE, TITLE, TO_CHAR(OPENDAY, 'YYYY-MM-DD') AS OPENDAY, "+
					"TO_CHAR(STARTDAY, 'YYYY-MM-DD') AS STARTDAY, TO_CHAR(ENDDAY, 'YYYY-MM-DD') AS ENDDAY "+
				"FROM MOVIE "+
				"WHERE ? <= ENDDAY "+
				"ORDER BY ENDDAY ASC";
		System.out.println("selectScreenSetMovie sql:" + sql);
		
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try{
			
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, reqSetDate);
			rs = prepStmt.executeQuery();
			
			while(rs.next()){
				
				MovieVO mVO = new MovieVO();
				mVO.setMCODE(rs.getString("MCODE")); 
				mVO.setTITLE(rs.getString("TITLE"));
				mVO.setOPENDAY(rs.getString("OPENDAY"));
				mVO.setSTARTDAY(rs.getString("STARTDAY"));				
				mVO.setENDDAY(rs.getString("ENDDAY"));
				list.add(mVO);
				
			}
			
		}catch(Exception e){
			e.getStackTrace();
		}finally {
			DBManager.close(conn, prepStmt, rs);
		}
		
		return list;
	}
	
	
	/**
	 * 상영 영화 설정 삭제
	 * @param reqSTdate - 설정 날짜
	 * @param reqSTturn - 설정 회차
	 */
	public void deleteScreenSet(String reqSTdate, String reqSTturn){
		 
		String sql = "DELETE FROM SCREENTURN "+
					"WHERE STDATE = ? AND STTURN = ?";
		System.out.println("deleteScreenSet sql: "+ sql);
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
		
		try{
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, reqSTdate);
			prepStmt.setString(2, reqSTturn);
			prepStmt.executeQuery();
			
		}catch(Exception e){
			e.getStackTrace();
		}finally {
			DBManager.close(conn, prepStmt);
		}
	}
	
	
	//
}
