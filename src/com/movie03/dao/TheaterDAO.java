package com.movie03.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie03.dto.TheaterVO;

import util.DBManager;

/**
 * 극장 정보 DB DAO
 * @author 손대성
 * 극장에 관한 상세정보를 출력하기위한 
 * SQL문-
 */
public class TheaterDAO {
	
	public TheaterDAO() {}

	private static TheaterDAO instance = new TheaterDAO();

	public static TheaterDAO getInstance() {
		return instance;
	}
	
	public List<TheaterVO> TheaterList() {

		String sql = "select * from theater";		
		
		// console-창에 보여주기 위한 실행문
		System.out.println("(TheaterList)sql = " + sql);

		List<TheaterVO> list = new ArrayList<TheaterVO>();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	} // TheaterList()-End
	
} // class TheaterDAO - End
