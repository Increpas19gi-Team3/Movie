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
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("▶▶▶▶▶ doGet");
		
		String command = request.getRequestURI();//접근한 주소
		System.out.println("MovieServlet :" + command);
		
		ActionFactory af = ActionFactory.getInstance();
		// 액션컨트롤러 객체 리턴받음
		Action action = af.getAction(command);
		System.out.println("action :"+ action);
		
		if (action != null) {
			
			// 액션컨트롤러의 액션메소드 execute 호출
			Map<String, Object> reqModel = new HashMap<String, Object>();
			Map<String, Object> respModel  = new HashMap<String, Object>();
			
			
			// AC 에 가서 url 과 reqModel, respModel 객체를 통해 작업 & 저장하기
			String url = action.execute(reqModel, respModel);
			System.out.println("url :"+url);
			
			//request 객체에 reqModel, respModel을 저장
			request.setAttribute("reqModel", reqModel);
			request.setAttribute("respModel", respModel);
			
			
			// 디버그코드
			System.out.println("reqModel=" + reqModel);
			System.out.println("respModel=" + respModel);

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
		
		System.out.println("▶▶▶▶▶ doPost");
		
		doGet(request, response);
	}

}
