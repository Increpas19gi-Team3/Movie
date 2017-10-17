package com.movie03.dao;
/**
 * 샘플용
 */
import java.sql.Connection;

import util.DBManager;

public class BoardReplyDAO {
	
	public String insertReply() {
		Connection conn= DBManager.getConnection();
		String s="board 테이블에 1번글의 답글 추가";
		DBManager.close(conn, null);
		return s;
		
	}
	public String deleteReply() {
		Connection conn= DBManager.getConnection();
		String s="board 테이블에 1번글의 답글 삭제";
		DBManager.close(conn, null);
		return s;
		
	}

}
