package com.movie03.dao;

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
	
	
}
