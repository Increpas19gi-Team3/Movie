package com.movie03.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.movie03.dao.MemberDAO;
import com.movie03.dto.MemberVO;
import com.movie03.dto.MovieVO;

/**
 * 로그인 및 로그인 유지를 위한 Action
 * 
 * @author 손가연, 손대성
 *
 */
public class loginAction implements Action {

	@Override
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException {
		// TODO Auto-generated method stub

		// session에 필요한 정보를 담기위해서 보안상의 이유로?
		// 로그인을 유지하는데 필요한 정보는 아이디(MID), 이름(Mname), 관리자인확인(Madmin:0,1) 선택
		System.out.println("로그인 보여주기");
		// 내 정보-보기"로 넘기기('main'으로 넘기고 싶은데 'main'이 따로 없다;;)
		String url = "";

		List<MemberVO> login2 = null;

		String Login1 = (String) reqModel.get("Login");
		// Login에 어떤 정보가 들어와있는지 확인하는 console-창
		System.out.println("loginAction Login = " + Login1);

		String MID1 = null;
		String Mpwd1 = null;

		System.out.println("MID1: " + MID1);
		System.out.println("Mpwd1: " + Mpwd1);

		// 로그인을 하면 "../member/mypage.jsp" 경로로 들어옴
		// 조건절을 만들어야 하는데 'login2'가 'null' 들어는 경우는 없고
		// "" 빈공간으로 들어와서 "../member/mypage.jsp"로
		// 들어오는 것 같음

		// 관리자-선택 값이 들어가서 절대로 null 값이 나올리 없음;;

		if (Login1 != null) { // Login에서 받은 정보 값이 있다면

			if (Login1.equals("loginValue")) {

				MID1 = (String) reqModel.get("MID");
				Mpwd1 = (String) reqModel.get("Mpwd");

				System.out.println("MID1: " + MID1);
				System.out.println("Mpwd1: " + Mpwd1);

				MemberDAO Mdao = MemberDAO.getInstance(); 
				// SQL문을 실행한후 받은 값들을									
				login2 = Mdao.LoginConfirm(MID1, Mpwd1);
				
				
				if(login2.size() == 1){ // 로그인 성공					
					respModel.put("login2", login2);
					url = "../member/mypage.jsp";
					
				}else{//로그인 실패
					url = "../member/login.jsp";
				}
				System.out.println("loginAction url:"+url);
			} else { 
				// 화면에서 받은 정보가 없으면 다시 로그인 화면으로..
				// 근데 'null'이 나올리 없음..
				url = "../member/login.jsp";
			}

		} // if문 - End

		System.out.println("loginAction - End ");
		return url;

	} // execute - End

} // class loginAction - End
