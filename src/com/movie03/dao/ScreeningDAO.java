package com.movie03.dao;

/**
 * 상영관 DB DAO
 * @author 손대성
 *
 */
public class ScreeningDAO {
	private ScreeningDAO() {}

	private static ScreeningDAO instance = new ScreeningDAO();

	public static ScreeningDAO getInstance() {
		return instance;
	}	
	
}
