package com.movie03.dao;

/**
 * 극장 정보 DB DAO
 * @author 손대성
 *
 */
public class TheaterDAO {
	private TheaterDAO() {}

	private static TheaterDAO instance = new TheaterDAO();

	public static TheaterDAO getInstance() {
		return instance;
	}
	
	
}
