package com.movie03.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

	Map<String, Object> reqModel = null;
	Map<String, Object> respModel  = null;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
		
		reqModel = new HashMap<String, Object>();
		respModel  = new HashMap<String, Object>();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("▶▶▶▶▶ doGet");
		
		
		/* 파라메터, request 객체 를 전부 reqModel에 저장하는 로직 Start */
		// JSP 에서 넘어온 파라메터를 requestModel 에 저장
		System.out.println("----- getParameterNames -----");
		Enumeration params = request.getParameterNames();
		while (params.hasMoreElements()){
		    String name = (String)params.nextElement();
		    System.out.println(name + " : " + request.getParameter(name));
		    
		    reqModel.put(name, request.getParameter(name));
		}
		System.out.println("-----------------------------");
		
		
		// request 객체의 정보를 requestModel 에 저장
		System.out.println("----- request.getAttributeNames() -----");
		Enumeration<String> reqNames = request.getAttributeNames();
		while (reqNames.hasMoreElements()){
		    String name = (String)reqNames.nextElement();
		    System.out.println(name + " : " + request.getAttribute(name));
		    
		    reqModel.put(name, request.getAttribute(name));
		}
		System.out.println("---------------------------------------");
		
		
		// 세션 객체의 정보를 가져옴. 세션 데이터까지 requestModel에 넣을지는 회의 필요.
		System.out.println("----- request.getSession().getAttributeNames() -----");
		Enumeration<String> reqSessionNames = request.getSession().getAttributeNames();
		while (reqSessionNames.hasMoreElements()){
		    String name = (String)reqSessionNames.nextElement();
		    System.out.println(name + " : " + request.getSession().getAttribute(name));
		    
		    //reqModel.put(name, request.getSession().getAttribute(name));// 세션까지 저장할지는 고민중
		}
		System.out.println("----------------------------------------------------");

		
		System.out.println("***** 저장된 reqModel 출력 *****");
		Set keys = reqModel.keySet();
		for (Object key : keys) {
			System.out.println(key + " : " + reqModel.get(key));
		}
		System.out.println("********************************");
		/* 파라메터, request 객체 를 전부 reqModel에 저장하는 로직 End */
		
		
		
		
		
		String command = request.getRequestURI();//접근한 주소
		System.out.println("MovieServlet :" + command);
		
		ActionFactory af = ActionFactory.getInstance();
		// 액션컨트롤러 객체 리턴받음
		Action action = af.getAction(command);
		System.out.println("action :"+ action);
		
		if (action != null) {
			
			// 액션컨트롤러의 액션메소드 execute 호출
			// AC 에 가서 url 과 reqModel, respModel 객체를 통해 작업 & 저장하기
			String url = action.execute(reqModel, respModel);
			System.out.println("url :"+url);
			
			//request 객체에 reqModel, respModel을 저장
			request.setAttribute("reqModel", reqModel);
			request.setAttribute("respModel", respModel);
			
			
			// 디버그코드
			System.out.println("reqModel = " + reqModel);
			System.out.println("respModel = " + respModel);

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
