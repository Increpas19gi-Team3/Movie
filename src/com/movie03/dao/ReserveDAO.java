package com.movie03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie03.dto.MovieVO;
import com.movie03.dto.ReserveVO;
import com.movie03.dto.ScreenTurnVO;
import com.movie03.dto.SeatVO;

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
	
	/***
	 * 상영 중인 영화 리스트 조회
	 * @return
	 */
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
	
	/***
	 * 선택된 날에 해당 영화 상영 회차 조회
	 * @param rday
	 * @param mcode
	 * @return
	 */
	public List<ScreenTurnVO> selectTurnMovie(String rday, String mcode){
		String sql = "select * from screenturn where MCODE=? and to_char(stdate, 'YYYY-MM-DD')=?";
		List<ScreenTurnVO> list = new ArrayList<ScreenTurnVO>();//목록
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			//뷰를 하고 싶은 글번호 세팅
			pstmt.setString(1,  mcode);
			pstmt.setString(2, rday);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ScreenTurnVO bVo = new ScreenTurnVO();//글(VO)
				bVo.setMCode(rs.getString("MCODE"));
				bVo.setSCode(rs.getString("SCODE"));
				bVo.setSTdate(rs.getString("STDATE"));
				bVo.setSTturn(rs.getString("STTURN"));
				
				list.add(bVo);//글목록에 글(VO) 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	/***
	 * 선택된 영화 코드 조회
	 * @param title
	 * @return
	 */
	public String selectMovieCode(String title){
		String sql = "select mcode from movie where title=?";
		String mcode = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println("title : " + title);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, title);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				mcode = rs.getString("MCODE");
				System.out.println("mcode : " + mcode);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mcode;
	}
	
	/***
	 * 좌석 정보 조회
	 * @param turn
	 * @param date
	 * @return
	 */
	public List<SeatVO> selectSeat(String turn, String date){
		String sql = "select * from seat where sturn=? and to_char(sdate, 'YYYY-MM-DD')=?";
		List<SeatVO> list = new ArrayList<SeatVO>();//목록
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println("turn : " + turn);
		System.out.println("date : " + date);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, turn);
			pstmt.setString(2, date);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				SeatVO bVo = new SeatVO();//글(VO)
				bVo.setSDATE(rs.getString("SDATE"));
				bVo.setSSEAT(rs.getString("SSEAT"));
				bVo.setSSTATE(rs.getString("SSTATE"));
				bVo.setSTURN(rs.getString("STURN"));
				
				/*System.out.println("TEST >>> " + bVo.getSSEAT() + "," + bVo.getSSTATE()  );*/
				list.add(bVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}
