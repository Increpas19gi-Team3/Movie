package com.movie03.dao;

/**
 * 회원관리 DAO
 * @author 한범석
 *
 */
public class MemberDAO {
	private MemberDAO() {}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}
	
	
	
}
