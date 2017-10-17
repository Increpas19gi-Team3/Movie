package com.movie03.dao;

/**
 * 좌석 예약 현황 DB DAO
 * @author 김지현
 *
 */
public class SeatDAO {
	private SeatDAO() {}

	private static SeatDAO instance = new SeatDAO();

	public static SeatDAO getInstance() {
		return instance;
	}	
	
	
}
