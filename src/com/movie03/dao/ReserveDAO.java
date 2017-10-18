package com.movie03.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie03.dto.MovieVO;
import com.movie03.dto.ReserveVO;

import oracle.net.aso.b;
import util.DBManager;


/**
 * 예약 DB DAO
 * @author 김지현
 *
 */
public class ReserveDAO {
	public ReserveDAO() {}

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
				MovieVO bVo = new MovieVO();//글(VO)
				bVo.setMCODE(rs.getString("MCODE"));
				bVo.setACTOR(rs.getString("ACTOR"));
				bVo.setAPPRAISAL(rs.getString("APPRAISAL"));
				bVo.setDIRECTOR(rs.getString("DIRECTOR"));
				bVo.setENDDAY(rs.getString("ENDDAY"));
				bVo.setGENRE(rs.getString("GENRE"));
				bVo.setMCOMMENT(rs.getString("MCOMMENT"));
				bVo.setOPENDAY(rs.getString("OPENDAY"));
				bVo.setPOSTER(rs.getString("POSTER"));
				bVo.setPRICE(rs.getInt("PRICE"));
				bVo.setSTARTDAY(rs.getString("STARTDAY"));
				bVo.setSYNOPSIS(rs.getString("SYNOPSIS"));
				bVo.setTITLE(rs.getString("TITLE"));
				
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
