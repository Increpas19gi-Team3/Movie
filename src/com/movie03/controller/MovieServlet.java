package com.movie03.controller;

import java.io.File;
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

import java.awt.Graphics2D;
import java.awt.image.renderable.ParameterBlock;
import java.awt.image.BufferedImage;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.imageio.ImageIO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import util.ThumbImage;

/**
 * Servlet implementation class BoardServlet
 */

@WebServlet("*.do")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 전역변수로 쓸 것인지 확인 필요함.
	// Map<String, Object> reqModel = null;
	// Map<String, Object> respModel = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	} // MovieServlet() - End

	/**
	 * 전역변수로 쓸 것인지 확인 필요함.
	 */
	// @Override
	// public void init() throws ServletException {
	// // TODO Auto-generated method stub
	// //super.init();
	//
	// reqModel = new HashMap<String, Object>();
	// respModel = new HashMap<String, Object>();
	// }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 실행되는지 확인하기 위한 consoloe-창
		System.out.println("▶▶▶▶▶ doGet");
		System.out.println("request getContentType : " + request.getContentType());

		// multipart Request 처리용(파일 업로드에 관한)
		String imagePath = null;
		// 책에서는 p533 :
		// ServletContext context = getServletContext();
		// context.getRaelPath(임의의 값)
		// 이렇게도 호출이 가능한가?
		// request.getRealPath("image");
		imagePath = request.getRealPath("image");
		int size = 1 * 1024 * 1024; // 1MB, 파일크기 제한byte단위
		// MultipartRequest - 파일 업로드를 직접적으로 관여하는 클래스
		MultipartRequest multiReq = null;
		if (request.getContentType() != null) {
			if (request.getContentType().contains("multipart/form-data")) {
				try {
					multiReq = new MultipartRequest(request, // 객체
							imagePath, // 서버상의 실제 디렉토리
							size, // 최대 업로드 파일 크기
							"utf-8", // 인코딩 방법
							// 동일한 이름이 존재하면 새로운 이름이 부여됨
							new DefaultFileRenamePolicy());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		// 지역변수로 Map 사용
		Map<String, Object> reqModel = new HashMap<String, Object>();
		Map<String, Object> respModel = new HashMap<String, Object>();

		/* 파라메터, request 객체를 전부 reqModel에 저장하는 로직 Start */
		
		// 'JSP'에서 넘어온 파라메터를 requestModel 에 저장
		System.out.println("----- getParameterNames -----");

		// Enumeration은 여러 개의 파일 정보를 저장하고 있는 파일 목록
		Enumeration<String> params = request.getParameterNames();
		// boolean - hasMoreElements() : 파일 존재 확인(있다:ture, 없다:false)
		while (params.hasMoreElements()) {
			// E - nextElement() : 데이터(element)얻어낸다.
			String name = (String) params.nextElement();
			System.out.println(name + " : " + request.getParameter(name));
			reqModel.put(name, request.getParameter(name));
		}
		System.out.println("-----------------------------");

		// 'JSP'에서 넘어온 multipart 파라메터를 'requestModel'에 저장
		// multiReq(MultipartRequest) - 파일 업로드를 직접적으로 관여하는 클래스
		if (multiReq != null) {
			System.out.println("----- MultipartRequest getParameterNames -----");

			// 파라미터를 저장
			// Enumeration은 여러 개의 파일 정보를 저장하고 있는 파일 목록
			// getParameterNames() : 폼에서 전송된 파라미터의 이름을 Enumeration 타입으로 리턴한다.
			Enumeration<String> multipartParamsNames = multiReq.getParameterNames();
			while (multipartParamsNames.hasMoreElements()) {
				String name = (String) multipartParamsNames.nextElement();
				System.out.println(name + " : " + multiReq.getParameter(name));

				reqModel.put(name, multiReq.getParameter(name));
			}

			// 이미지를 저장
			// imagePath - 서버상의 실제 디렉토리
			reqModel.put("imagePath", imagePath); // 이미지 경로 저장
			// getFileNames() : 파일을 여러개 업로드 할 경우 그 값들을 Enumeration 타입으로 리턴한다.
			Enumeration<String> multipartFileNames = multiReq.getFileNames();
			while (multipartFileNames.hasMoreElements()) {
				String name = (String) multipartFileNames.nextElement();
				System.out.println(name + " : " + multiReq.getFile(name));
				// getFilesystemName(name) : 서버에 실제로 업로드 된 파일의 이름을 의미한다.
				String file_name = multiReq.getFilesystemName(name); // 업로드 파일명

				// 이미지 중복 처리 안함!
				// reqModel.put(name, multiReq.getFile(file_name)); 맵에 파일 저장 한다면
				reqModel.put(name, file_name);// 파일 이름만 저장
				try {
					// 썸네일 이미지 저장 - 경로(util / ThumbImage.java - ThumbImage())
					ThumbImage.createThumbImage(imagePath, file_name, 100, 100);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("---------------------------------------");
		}

		// request - 객체의 정보를 requestModel 에 저장
		System.out.println("----- request.getAttributeNames() -----");
		Enumeration<String> reqNames = request.getAttributeNames();
		while (reqNames.hasMoreElements()) {
			String name = (String) reqNames.nextElement();
			System.out.println(name + " : " + request.getAttribute(name));

			reqModel.put(name, request.getAttribute(name));
		}
		System.out.println("---------------------------------------");

		// Session - 객체의 정보를 requestModel 에 저장
		System.out.println("----- request.getSession().getAttributeNames() -----");
		Enumeration<String> reqSessionNames = request.getSession().getAttributeNames();
		while (reqSessionNames.hasMoreElements()) {
			String name = (String) reqSessionNames.nextElement();
			System.out.println(name + " : " + request.getSession().getAttribute(name));

			reqModel.put(name, request.getSession().getAttribute(name));
		}
		
		System.out.println("----------------------------------------------------");

		System.out.println("***** 저장된 reqModel 출력 *****");
		
		Set<String> keys = reqModel.keySet();
		for (Object key : keys) {
			System.out.println(key + " : " + reqModel.get(key));
		}
		System.out.println("********************************");
		/* 파라미터, 'request'객체를 전부 'reqModel'에 저장하는 로직 End */

		String command = request.getRequestURI(); // 접근한 주소
		System.out.println("MovieServlet :" + command);
		// ActionFactory.java - getInstance()
		ActionFactory af = ActionFactory.getInstance();
		// 액션컨트롤러 객체 리턴받음
		// ActionFactory.java - public Action getAction(String uri)
		Action action = af.getAction(command);
		System.out.println("action :" + action);

		if (action != null) {

			// 액션컨트롤러의 액션메소드 execute 호출
			// 'AC'에 가서 'url'과'reqModel', 'respModel'객체를 통해 작업 & 저장하기
			// Action.java - execute(reqModel, respModel)
			String url = action.execute(reqModel, respModel);
			System.out.println("url :" + url);

			// request 객체에 'reqModel', 'respModel'을 저장
			request.setAttribute("reqModel", reqModel);
			request.setAttribute("respModel", respModel);

			// 디버그코드
			System.out.println("reqModel = " + reqModel);
			System.out.println("respModel = " + respModel);

			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		
	} // doGet - End

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("UTF-8"); //filter 에서 인코딩 작업을 함

		System.out.println("▶▶▶▶▶ doPost");

		doGet(request, response);
		
	} // doPost - End
	
} // class MovieServlet - End
