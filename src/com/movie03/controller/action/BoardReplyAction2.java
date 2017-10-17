package com.movie03.controller.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie03.dao.BoardReplyDAO;

//목적 : 서블릿 api가 없더라도 재사용이 가능하게 위해서
//POJO(순수 자바클래스) 클래스로 변환
// 출력뷰로 직접 이동시키는 controller를 presenter라고 부름
public class BoardReplyAction2 implements Action2{
    
	//modelMap으로 FC에서 파라미터 전달받음
	// 리턴값: 출력뷰 url
	public String execute(Map<String, Object> model) throws IOException {
		//1. JDBC 로직코드는 BoardReplyDAO로 분리후 연동
		//System.out.println("board 테이블에 1번글의 답글 추가");
		BoardReplyDAO dao= new BoardReplyDAO();
		String res= dao.insertReply();
		
		//2. 비JDBC 로직코드(로그)
		System.out.println("답글완료");
		
		//3. 비JDBC 로직코드(이동)
		String url = "/board/boardReplyList2.jsp";//출력뷰
		model.put("res", res);
		
		////출력뷰 이동을 FC로 분리
		// 주소를 return 함으로써 FC가 이동 시킴. AC는 겹치는 부분이 사라짐.
		/*RequestDispatcher dispatcher 
		= request.getRequestDispatcher(url);
		dispatcher.forward(request, response);*/
		return url;
		
		
	}

}
