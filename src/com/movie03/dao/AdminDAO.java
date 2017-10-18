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
	public TheaterVO selectTheater(){
		TheaterVO theaterVo = null;
		
		String sql = "SELECT * FROM THEATER";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				theaterVo = new TheaterVO();
				theaterVo.setTCODE(rs.getString("TCODE"));
				theaterVo.setTNAME(rs.getString("TNAME"));
				theaterVo.setTLOCAL(rs.getString("TLOCAL"));
				theaterVo.setTDESC(rs.getString("TDESC"));
				theaterVo.setTIMAGE(rs.getString("TIMAGE"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return theaterVo;
	}
}
