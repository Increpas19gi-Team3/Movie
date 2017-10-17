package com.movie03.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie03.controller.action.Action;
import com.movie03.controller.action.Action2;
import com.movie03.controller.action.BoardReplyAction2;
import com.movie03.dto.BoardVO;

/**
 * Servlet implementation class BoardServlet
 */
//     /web-study-11/board/reply_add.do
//      /web-study-1/board/boardReplyList2.jsp
//    슬래시로 시작하는 경우 *.확장자 패턴 X
@WebServlet("*.do")
public class BoardServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardServlet3() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// /web-study-11/board/reply_add.do
		
		String command = request.getRequestURI();

		System.out.println("BoardServlet3" + command);
		ActionFactory3 af = ActionFactory3.getInstance();
		// 액션컨트롤러 객체 리턴받음
		Action2 action = af.getAction(command);
		
		if (action != null) {
			
			// 액션컨트롤러의 액션메소드 execute 호출
			Map<String, Object> model = new HashMap<String, Object>(); // 100번지
			BoardVO vo = new BoardVO();
			//vo에 글내용(파라미터)을 채움
			//.......
			// model.put("vo", vo);
			
			model.put("writer", "kim"); // 작성자 -> 유저id 별로 저장??? 여기서 세션 정보를 가져올 수 있나?
			//아니면 파라미터? userID= 
			
			
			String url = action.execute(model);
			request.setAttribute("model", model);
			// 디버그코드
			System.out.println("model=" + model);

			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
