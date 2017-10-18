package com.movie03.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie03.dto.MovieVO;
import com.movie03.dto.ReserveVO;

import util.DBManager;


/**
 * 예약 DB DAO
 * @author 김지현
 *
 */
public class ReserveDAO {
	private ReserveDAO() {}

	private static ReserveDAO instance = new ReserveDAO();

	public static ReserveDAO getInstance() {
		return instance;
	}	
	
	public List<MovieVO> selectMvList(){
		String sql = "select * from movie where endday > sysdate";
		List<MovieVO> list = new ArrayList<MovieVO>();//목록
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); //글행집합
			while (rs.next()) {
				ReserveVO bVo = new ReserveVO();//글(VO)
				bVo.setMCODE(rs.getString("MCODE"));
				bVo.setMID(rs.getString("MID"));
				bVo.setRCODE(rs.getString("RCODE"));
				bVo.setRDAY(rs.getString("RCODE"));
				bVo.setRSEAT(rs.getString("RCODE"));
				bVo.set
				
				list.add(bVo);//글목록에 글(VO) 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
}
