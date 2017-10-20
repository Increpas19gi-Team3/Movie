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

//	전역변수로 쓸 것인지 확인 필요함.	
//	Map<String, Object> reqModel = null;
//	Map<String, Object> respModel  = null;
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * 전역변수로 쓸 것인지 확인 필요함.
	 */
//	@Override
//	public void init() throws ServletException {
//		// TODO Auto-generated method stub
//		//super.init();
//		
//		reqModel = new HashMap<String, Object>();
//		respModel  = new HashMap<String, Object>();
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("▶▶▶▶▶ doGet");
		System.out.println("request getContentType : " + request.getContentType());
		
		//multipart Request 용 처리
		String imagePath = null;
		imagePath = request.getRealPath("image");
		int size = 1*1024*1024 ;//1MB , 파일 크기 제한byte단위
		MultipartRequest multiReq = null;
		if (request.getContentType() != null){
			if(request.getContentType().contains("multipart/form-data")){
				try{
					multiReq = new MultipartRequest(request,
					  imagePath,//저장 폴더
					  size,		// 크기
					  "utf-8", //파일명 인코딩
					  new DefaultFileRenamePolicy());	//파일명 중복 시, 숫자를 붙여서 덮어쓰기 방지
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		//지역변수로 Map 사용
		Map<String, Object> reqModel = new HashMap<String, Object>();
		Map<String, Object> respModel  = new HashMap<String, Object>();
		
		
		
		/* 파라메터, request 객체 를 전부 reqModel에 저장하는 로직 Start */
		
		// JSP 에서 넘어온 파라메터를 requestModel 에 저장
		System.out.println("----- getParameterNames -----");
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()){
		    String name = (String)params.nextElement();
		    System.out.println(name + " : " + request.getParameter(name));
		    
		    reqModel.put(name, request.getParameter(name));
		}System.out.println("-----------------------------");
				
		
		// JSP 에서 넘어온 multipart 파라메터를 requestModel 에 저장
		if(multiReq != null){
			System.out.println("----- MultipartRequest getParameterNames -----");
			
			// 파라메터를 저장
			Enumeration<String> multipartParamsNames = multiReq.getParameterNames();
			while (multipartParamsNames.hasMoreElements()){
			    String name = (String)multipartParamsNames.nextElement();
			    System.out.println(name + " : " + multiReq.getParameter(name));
			    
			    reqModel.put(name, multiReq.getParameter(name));
			}
			
			// 이미지를 저장
			reqModel.put("imagePath", imagePath);//이미지 경로 저장
			Enumeration<String> multipartFileNames = multiReq.getFileNames();
			while (multipartFileNames.hasMoreElements()){
			    String name = (String)multipartFileNames.nextElement();
			    System.out.println(name + " : " + multiReq.getFile(name));
			    
			    String file_name = multiReq.getFilesystemName(name); //업로드 파일명
				
				//이미지 중복 처리 안함!
			    //reqModel.put(name, multiReq.getFile(file_name)); 맵에 파일 저장 한다면
			    reqModel.put(name, file_name);//파일 이름만 저장
				try {
					ThumbImage.createThumbImage(imagePath, file_name, 100, 100);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("---------------------------------------");
		}
		
		
		// request 객체의 정보를 requestModel 에 저장
		System.out.println("----- request.getAttributeNames() -----");
		Enumeration<String> reqNames = request.getAttributeNames();
		while (reqNames.hasMoreElements()){
		    String name = (String)reqNames.nextElement();
		    System.out.println(name + " : " + request.getAttribute(name));
		    
		    reqModel.put(name, request.getAttribute(name));
		}
		System.out.println("---------------------------------------");
		
		
		// 세션 객체의 정보를 requestModel 에 저장
		System.out.println("----- request.getSession().getAttributeNames() -----");
		Enumeration<String> reqSessionNames = request.getSession().getAttributeNames();
		while (reqSessionNames.hasMoreElements()){
		    String name = (String)reqSessionNames.nextElement();
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
		//request.setCharacterEncoding("UTF-8"); //filter 에서 인코딩 작업을 함
		
		System.out.println("▶▶▶▶▶ doPost");
		
		doGet(request, response);
	}
	
}
