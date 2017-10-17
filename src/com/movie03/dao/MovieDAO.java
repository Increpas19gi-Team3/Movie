package com.movie03.dao;

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
	
}
