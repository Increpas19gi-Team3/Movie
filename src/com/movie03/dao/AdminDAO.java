package com.movie03.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBManager;
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
				TheaterVO tVo = new TheaterVO();
				tVo.setTCODE(rs.getString("TCODE"));
				tVo.setTNAME(rs.getString("TNAME"));
				tVo.setTLOCAL(rs.getString("TLOCAL"));
				tVo.setTDESC(rs.getString("TDESC"));
				tVo.setTIMAGE(rs.getString("TIMAGE"));
				list.add(tVo);
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
	public void insertTheater(TheaterVO tVo){
		
		String sql = "INSERT INTO THEATER VALUES('T01', ?, ?, ?, ? )";
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
		
		try {
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			
			prepStmt.setString(1, tVo.getTNAME());
			prepStmt.setString(2, tVo.getTLOCAL());
			prepStmt.setString(3, tVo.getTDESC());
			prepStmt.setString(4, tVo.getTIMAGE());
			prepStmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, prepStmt);
		}
	}
	
	
public void updateTheater(TheaterVO tVo){
		
		String sql = "UPDATE THEATER SET TNAME = ?, TLOCAL = ?, TDESC = ?, TIMAGE = ?"
				+ "WHERE TCODE = 'T01'";
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
		
		try {
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			
			prepStmt.setString(1, tVo.getTNAME());
			prepStmt.setString(2, tVo.getTLOCAL());
			prepStmt.setString(3, tVo.getTDESC());
			prepStmt.setString(4, tVo.getTIMAGE());
			prepStmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, prepStmt);
		}
	}
}
