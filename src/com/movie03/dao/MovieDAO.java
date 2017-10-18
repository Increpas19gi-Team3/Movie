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
 * @author 손대성
 *
 */
public class MovieDAO {
	
	private MovieDAO() {}
	
	private static MovieDAO instance = new MovieDAO();

	public static MovieDAO getInstance() {
		return instance;
	}
	
	/**
	 * 영화 전체 검색
	 * 영화-리스트 ; MovieSelect()
	 *  : 영화제목으로 내림차순-정렬하는 SQL문
	 *  : 일단 모든 정보를 List에 담아 넣음
	 * @return List<MovieVO>
	 * 
	 */	
	public List<MovieVO> MovieSelect(String gubun){
				
		String sql= "select * form Movie order by title ";
//		
//		if(구분이 "DESC"){
//			sql += "DESC";
//		}else{
//			sql += "ASC";
//		}
		
		
		
		
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
	} // MovieSelectAll()-End
}