package com.movie03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie03.dto.MemberVO;
import com.movie03.dto.MovieVO;

import util.DBManager;

/**
 * 회원관리 DAO  
 * @author 손대성 
 */
public class MemberDAO {
	public MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}

	/**
	 * 로그인
	 * - 아이디와 비번 그리고 관리자인지를 확인 후 로그인
	 * - 순서도 login.jsp -> ActionFactory(눈에 잘 안 보임)
	 * -> loginAction.java -> 현재페이지 
	 * 
	 * @param MID 회원ID
	 * @param Mpwd 회원 비밀번호
	 * @param Madmin 관리자 확인
	 * @return
	 */
	public List<MemberVO> LoginConfirm(String MID, String Mpwd) {

		System.out.println("LoginConfirm - start");
		System.out.println("MID: "+MID+", MPWD: "+Mpwd);
		
		// 'session'에 저장할 값이 책에서 나오는 것처럼
		// return result(1, 0, -1)값으로 보내지 않고
		// 아이디, 이름, 관리자확인 여부만 'session'에 저장할 것이기 때문에
		// 'List'로 내보내기 위해 아래 문장을 씀
		List<MemberVO> loginlist = new ArrayList<MemberVO>();

		// 아이디와 관리자확인이 같은 것 중에서 비번 추출하기
		// 아디디(MID) 값이 'key'값이기 때문에 괜히 관리자(Madmin)를 불러올 필요가 없음		
		String sql = "SELECT MID, Mname, Madmin FROM MEMBER WHERE MID= ? and Mpwd= ?"; //MID : PK
					
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MID);			
			pstmt.setString(2, Mpwd);
			rs = pstmt.executeQuery();			
			
			System.out.println("MID :" + MID);
			System.out.println("MPWD :" + Mpwd);			
			
			// SQL-문이 실행된다면 비번이 뭔가 있고(!= null) 
			// 데이터상의 비번과 입력받은 비번이 확인되면
			// 아이디와 이름과 관리자여부만 loginlist에 넣어서 내보냄
			while(rs.next()) {				
//				if ((rs.getString("MPWD") != null) && (rs.getString("MPWD").equals(Mpwd))) {
					
					System.out.println("while >>>>>>>>> 실행중");
					
					MemberVO mVo = new MemberVO();
					mVo.setMID(rs.getString("MID"));
					mVo.setMNAME(rs.getString("Mname"));
					mVo.setMADMIN(rs.getString("Madmin"));
					loginlist.add(mVo);					
//				} else {
					// console-창에 확인하기 위한 출력물
//					System.out.println("비밀번호 오류?");
				} 
//			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return loginlist;
	} // LoginConfirm - End 
	

	/**
	 * 회원 가입
	 * 
	 * @param memberVO
	 * @return 
	 */
	public void InsertMember(MemberVO mVo) {

		String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		
		System.out.println("sql="+sql);
		System.out.println(mVo.getMID());
		System.out.println(mVo.getMPWD());
		System.out.println(mVo.getMNAME());
		System.out.println(mVo.getMEMAIL());
		System.out.println(mVo.getMTEL());
		System.out.println(mVo.getMADMIN());
		
		try {
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);

			prepStmt.setString(1, mVo.getMID());
			prepStmt.setString(2, mVo.getMPWD());
			prepStmt.setString(3, mVo.getMNAME());
			prepStmt.setString(4, mVo.getMEMAIL());
			prepStmt.setString(5, mVo.getMTEL());
			prepStmt.setString(6, mVo.getMADMIN());
			rs = prepStmt.executeQuery();

			System.out.println("rs:"+rs);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, prepStmt, rs);
		}		
	}
	
	/**
	 * 아이디 찾기
	 * 
	 * @param memberVO
	 */
	public String find_ID(MemberVO mVo) {

		String MID = "";
		String sql = "SELECT MID FROM MEMBER WHERE MNAME = ? and MTEL = ? and MEMAIL = ?";

		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, mVo.getMNAME());
			prepStmt.setString(2, mVo.getMTEL());
			prepStmt.setString(3, mVo.getMEMAIL());
			rs = prepStmt.executeQuery();
			
			while (rs.next()) {
				MID = rs.getString("MID");
				System.out.println("MID : "+ MID);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, prepStmt, rs);
		}
		return MID;
	}
	

	/**
	 * 내 정보 보기
	 * 
	 * @return List<MemberVO>
	 *//* 
	public List<MemberVO> selectMember() {
		List<MemberVO> list = new ArrayList<MemberVO>();

		String sql = "SELECT * FROM MEMBER";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MemberVO mVO = new MemberVO();
				mVO.setMID(rs.getString("MID"));
				mVO.setMPWD(rs.getString("MPWD"));
				mVO.setMNAME(rs.getString("MNAME"));
				mVO.setMEMAIL(rs.getString("MEMAIL"));
				mVO.setMTEL(rs.getString("MTEL"));
				mVO.setMADMIN(rs.getString("MADMIN"));
				list.add(mVO);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	*//**
	 * 내 정보 수정
	 * 
	 * @param memberVO
	 *//*
	public void upadtemymember(MemberVO mVO) {

		System.out.println("updatemymember :" + mVO.toString());

		String sql = "UPDATE MEMBER SET MID = ?, MPWD = ?, MNAME = ?, MEMAIL = ?, MTEL = ?, MADMIN = ?";

		Connection conn = null;
		PreparedStatement prepStmt = null;

		try {
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);

			prepStmt.setString(1, mVO.getMID());
			prepStmt.setString(2, mVO.getMPWD());
			prepStmt.setString(3, mVO.getMNAME());
			prepStmt.setString(4, mVO.getMEMAIL());
			prepStmt.setString(5, mVO.getMTEL());
			prepStmt.setString(6, mVO.getMADMIN());
			prepStmt.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, prepStmt);
		}
	}

	*//**
	 * 회원 탈퇴
	 * 
	 * @return List<MemberVO>
	 *//*
	public void deletemember(MemberVO mVO) {

		String sql = "DELETE FROM MEMBER WHERE MID =?";
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, mVO.getMID());
			prepStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, prepStmt);
		}
	}

	

	*//**
	 * 비밀번호 찾기
	 * 
	 * @param memberVO
	 *//*
	public String find_PWD(String MID, String MTEL, String MEMAIL) {

		String MPWD = "";
		String sql = "SELECT MID FROM MEMBER WHERE MID = ?, MTEL = ?, MEMAIL =?";

		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, MID);
			prepStmt.setString(2, MTEL);
			prepStmt.setString(3, MEMAIL);
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				MPWD = rs.getString("MPWD");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, prepStmt);
		}
		return MPWD;
	}

	*//**
	 * 아이디 중복
	 * 
	 * @return List<MemberVO>
	 *//*
	public MemberVO Overap_ID(String MID, String MPWD) {

		String sql = "SELECT * FROM MEMBER WHERE MID = ?";
		MemberVO mVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MID);
			pstmt.setString(2, MPWD);
			rs = pstmt.executeQuery(sql);

			if (rs.next()) {
				mVO = new MemberVO();
				mVO.setMID(rs.getString("MID"));
				mVO.setMID(rs.getString("MPWD"));
				mVO.setMID(rs.getString("MNAME"));
				mVO.setMID(rs.getString("MEMAIL"));
				mVO.setMID(rs.getString("MTEL"));
				mVO.setMID(rs.getString("MADMIN"));

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mVO;
	}*/
}