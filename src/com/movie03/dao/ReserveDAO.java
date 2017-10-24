package com.movie03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.Session;

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
		String sql = "select * from movie where endday > sysdate and mcode in (select mcode from screenturn) ";
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
	 * 예매된 좌석 업데이트
	 * @param title
	 * @return
	 */
	public void updateSeat(String seat, String rday, String rtime){
		String sql = "update seat set SSTATE='1' where SSEAT=? and to_char(sdate, 'YYYY-MM-DD')=?  and STURN=?";
		String mcode = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println("test >>> " + seat+","+rday+","+rtime);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, seat);
			pstmt.setString(2, rday);
			pstmt.setString(3, rtime);
			
			rs = pstmt.executeQuery();
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
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
	/***
	 * 좌석 정보 조회
	 * @param turn
	 * @param date
	 * @return
	 */
	public String selectReserveCode(){
		String sql = "select MAX(RCODE) as max from reserve";
		String rcode = null;
		String imsicode = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				if(rs.getString("MAX").isEmpty()){
					rcode = "R01";
				}
				else{
					imsicode = rs.getString("MAX");
					rcode = imsicode.replace("R","");
					
					int a = Integer.valueOf(rcode);
					a = a+1;
					
					if(a<10)
						rcode = "R0" + String.valueOf(a);
					else
						rcode = "R" + String.valueOf(a);
				}
				
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return rcode;
	}
	
	/***
	 * 예매 정보 insert
	 * @param turn
	 * @param date
	 * @return
	 */
	 public void insertReserve(String code, String screan, String rday, String rturn, String seat, String mid, String rcode){
		String sql = "insert into reserve values (?,?,?,?,to_date(?, 'yyyyMMdd'),?,?,?)";
		//List<ReserveVO> list = new ArrayList<ReserveVO>();//목록
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println("seat : " + seat);
		
		String rtime = null;
		if(rturn.equals("1"))
			rtime = "12시";
		else if(rturn.equals("2"))
			rtime = "16시";
		else if(rturn.equals("3"))
			rtime = "20시";
		else
			rtime = "0시";
		
		rday = rday.replace("-","");
		System.out.println("test >>> " + rcode +"," +mid +"," +code +"," +rday +"," +rturn +"," +rtime +"," +seat);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, rcode);
			pstmt.setString(2, mid);
			pstmt.setString(3, code);
			pstmt.setString(4, "S01");
			pstmt.setString(5, rday);
			pstmt.setString(6, rturn);
			pstmt.setString(7, rtime);
			pstmt.setString(8, seat);
			
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	}
	
	 /***
		 * 예매 정보 조회(예매번호로 조회)
		 * @param turn
		 * @param date
		 * @return
		 */
		public List<ReserveVO> selectReserve(String rcode){
			String sql = "select * from reserve where rcode=?";
			List<ReserveVO> list = new ArrayList<ReserveVO>();//목록
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, rcode);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					ReserveVO bVo = new ReserveVO();//글(VO)
					bVo.setMCODE(rs.getString("MCODE"));
					bVo.setMID(rs.getString("MID"));
					bVo.setRCODE(rs.getString("RCODE"));
					bVo.setRDAY(rs.getString("RDAY"));
					bVo.setRSEAT(rs.getString("RSEAT"));
					bVo.setRTIME(rs.getString("RTIME"));
					bVo.setRTURN(rs.getString("RTURN"));
					bVo.setSCODE(rs.getString("SCODE"));
					
					list.add(bVo);
					
				}
							
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return list;
		}

		 /***
		 * 예매 정보 조회(예매번호로 조회)
		 * @param turn
		 * @param date
		 * @return
		 */
		public List<ReserveVO> selectReserveList(String userid){
			String sql = "select mcode, mid, rcode, to_char(rday,'yyyy-MM-dd') as rdays, rseat, rtime, rturn, scode from reserve "
					+ "where mid=? and to_char(RDAY, 'yyyyMMdd')>=to_char(sysdate, 'yyyyMMdd') order by rcode";
			List<ReserveVO> list = new ArrayList<ReserveVO>();//목록
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, userid);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					ReserveVO bVo = new ReserveVO();//글(VO)
					bVo.setMCODE(rs.getString("MCODE"));
					bVo.setMID(rs.getString("MID"));
					bVo.setRCODE(rs.getString("RCODE"));
					bVo.setRDAY(rs.getString("RDAYS"));
					bVo.setRSEAT(rs.getString("RSEAT"));
					bVo.setRTIME(rs.getString("RTIME"));
					bVo.setRTURN(rs.getString("RTURN"));
					bVo.setSCODE(rs.getString("SCODE"));
					
					list.add(bVo);
					
				}
							
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return list;
		}
		
		/***
		 * 예매 내역 영화 제목 select
		 * @param title
		 * @return
		 */
		public String selectMovieTitle(String mcode){
			String sql = "select title from movie where mcode=?";
			String title=null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, mcode);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					title = rs.getString("TITLE");
					System.out.println("title : " + title);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return title;
		}
		
		
		/***
		 * 예매 내역 삭제 
		 * @param title
		 * @return
		 */
		public void deleteReserve(String rcode){
			String sql = "delete from reserve where rcode=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, rcode);
				
				rs = pstmt.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		
		
		/***
		 * 예매 취소 좌석 업데이트
		 * @param title
		 * @return
		 */
		public void updateSeatCancel(String seat, String rday, String rtime){
			String sql = "update seat set SSTATE='0' where SSEAT=? and to_char(sdate, 'YYYY-MM-DD')=?  and STURN=?";
			String mcode = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			System.out.println("test >>> " + seat+","+rday+","+rtime);
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, seat);
				pstmt.setString(2, rday);
				pstmt.setString(3, rtime);
				
				rs = pstmt.executeQuery();
				
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
}
