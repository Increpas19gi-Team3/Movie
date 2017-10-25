package com.movie03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie03.dto.MemberVO;

import util.DBManager;

/**
 * 회원관리 DAO
 * 
 * @author 손대성
 *
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
	 *  - 아이디와 비번 그리고 관리자인지를 확인 후 로그인
	 *  - 순서도 login.jsp -> ActionFactory(눈에 잘 안 보임) 
	 *  - -> loginAction.java -> 현재페이지 
	 * @param MID 회원ID
	 * @param Mpwd 회원 비밀번호
	 * @param Madmin 관리자 확인
	 * @return 
	 */
	public void LoginConfirm (String MID,String Mpwd, String Madmin) {
		
		// 아이디와 관리자확인이 같은 것 중에서 비번 추출하기
		// 이게 맞는지 SQL-문은 실행했지만(아무 이상없음) 맞는지 확신은 없음.
		String sql = "SELECT Mpwd FROM MEMBER WHERE MID=? and Madmin=?";		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, MID);
			pstmt.setString(2, Mpwd);			
			pstmt.setString(3, Madmin);
			pstmt.executeQuery();
			
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
	}
	
	
	
	
	
	
	/**
	 * 회원 가입
	 * 
	 * @param memberVO
	 */
	public void insertMember(String MID,String MPWD,String MNAME,String MEMAIL,String MTEL, int MADMIN) {

		String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);

			prepStmt.setString(1, MID);
			prepStmt.setString(2, MPWD);
			prepStmt.setString(3, MNAME);
			prepStmt.setString(4, MEMAIL);
			prepStmt.setString(5, MTEL);
			prepStmt.setInt(6, MADMIN);
			prepStmt.executeQuery();
			
			rs = prepStmt.executeQuery();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, prepStmt, rs);
		}
	}

	/**
	 * 내 정보 보기
	 * 
	 * @return List<MemberVO>
	 */
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

	/**
	 * 내 정보 수정
	 * 
	 * @param memberVO
	 */
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

	/**
	 * 회원 탈퇴
	 * 
	 * @return List<MemberVO>
	 */
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
	/**
	 * 아이디 찾기
	 * 
	 * @param memberVO
	 */
public String find_ID(String MNAME, String MTEL, String MEMAIL) {
		
		String MID=  "";
		String sql = "SELECT MID FROM MEMBER WHERE MNAME = ?, MTEL = ?, MEMAIL =?"; 
		
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		try{
			conn = DBManager.getConnection();
			prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, MNAME);
			prepStmt.setString(2, MTEL);
			prepStmt.setString(3, MEMAIL);
			rs = prepStmt.executeQuery();
			while(rs.next()){
			    MID=rs.getString("MID");
			   }
			} catch (SQLException e){
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, prepStmt);
		}
		return MID;
	}
/**
 * 비밀번호 찾기
 * 
 * @param memberVO
 */
public String find_PWD(String MID, String MTEL, String MEMAIL) {
	
	String MPWD=  "";
	String sql = "SELECT MID FROM MEMBER WHERE MID = ?, MTEL = ?, MEMAIL =?"; 
	
	Connection conn = null;
	PreparedStatement prepStmt = null;
	ResultSet rs = null;

	try{
		conn = DBManager.getConnection();
		prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, MID);
		prepStmt.setString(2, MTEL);
		prepStmt.setString(3, MEMAIL);
		rs = prepStmt.executeQuery();
		while(rs.next()){
		    MPWD=rs.getString("MPWD");
		   }
		} catch (SQLException e){
		// TODO: handle exception
		e.printStackTrace();
	} finally {
		DBManager.close(conn, prepStmt);
	}
	return MPWD;
}

/**
 * 아이디 중복
 * 
 * @return List<MemberVO>
 */
public MemberVO Overap_ID(String MID, String MPWD) {

	String sql = "SELECT * FROM MEMBER WHERE MID = ?";
	MemberVO mVO = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  MID);
		pstmt.setString(2,  MPWD);
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
}
}