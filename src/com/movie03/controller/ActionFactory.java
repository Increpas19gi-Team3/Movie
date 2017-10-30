package com.movie03.controller;

import com.movie03.controller.action.Action;
import com.movie03.controller.action.Action2;
import com.movie03.controller.action.AdminAction;
import com.movie03.controller.action.AdminMovieAction;
import com.movie03.controller.action.AdminReserveAction;
import com.movie03.controller.action.AdminScreenSetAction;
import com.movie03.controller.action.AdminScreeningAction;
import com.movie03.controller.action.AdminTheaterAction;
//import com.movie03.controller.action.BoardCheckPassAction;
//import com.movie03.controller.action.BoardCheckPassFormAction;
//import com.movie03.controller.action.BoardDeleteAction;
//import com.movie03.controller.action.BoardListAction;
//import com.movie03.controller.action.BoardReplyAction;
import com.movie03.controller.action.BoardReplyAction2;
import com.movie03.controller.action.BoardReplyDelAction2;
import com.movie03.controller.action.MembershipAction;
import com.movie03.controller.action.loginAction;
import com.movie03.controller.action.MovieAction;
//import com.movie03.controller.action.BoardUpdateAction;
//import com.movie03.controller.action.BoardUpdateFormAction;
//import com.movie03.controller.action.BoardViewAction;
//import com.movie03.controller.action.BoardWriteAction;
//import com.movie03.controller.action.BoardWriteFormAction;
import com.movie03.controller.action.ReserveAction;
import com.movie03.controller.action.ReserveCancelAction;
import com.movie03.controller.action.ReserveConfirmAction;
import com.movie03.controller.action.ReserveMovieAction;
import com.movie03.controller.action.ReserveResultAction;
import com.movie03.controller.action.ReserveSeatAction;
import com.movie03.controller.action.TheaterAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String uri) {
		// "web-study-11/board/reply_add.do"
		Action action = null;
		System.out.println("ActionFactory :" + uri);

		// 요청'URI'에 "reply_add.do" 커멘드가 포함되면

		// Admin 관리화면
		if (uri.contains("/admin/admin.do")) {
			action = new AdminAction();

		} else if (uri.contains("/admin/admin_Theater.do")) { // 영화관 관리
			action = new AdminTheaterAction();

		} else if (uri.contains("/admin/admin_Screening.do")) { // 상영관 관리
			action = new AdminScreeningAction();

		} else if (uri.contains("/admin/admin_Movie.do")) { // 영화 목록 관리
			action = new AdminMovieAction();

		} else if (uri.contains("/admin/admin_ScreenSet.do")) { // 상영 영화 관리
			action = new AdminScreenSetAction();

		} else if (uri.contains("/admin/admin_Reserve.do")) { // 예약 관리
			action = new AdminReserveAction();
		}

		// 예약 관리
		else if (uri.contains("/Movie/MovieServlet.do")) {
			action = new ReserveAction();
		} else if (uri.contains("/Movie/reserveMovie.do")) {
			action = new ReserveMovieAction();
		} else if (uri.contains("/Movie/reserveSeat.do")) {
			action = new ReserveSeatAction();
		} else if (uri.contains("/Movie/Reserve.do")) {
			action = new ReserveResultAction();
		} else if (uri.contains("/Movie/reserveCon.do")) {
			action = new ReserveConfirmAction();
		} else if (uri.contains("/Movie/reserveCancel.do")) {
			action = new ReserveCancelAction();
		}

		// 영화 관리
		else if (uri.contains("/movie/movie.do")) {
			action = new MovieAction();
		} else if (uri.contains("/Movie/Reserve.do")) {
			action = new ReserveResultAction();
		}

		// <=================================================================>

		// Theater(극장) - 관리
		else if (uri.contains("/theater/theater.do")) {
			action = new TheaterAction();
		}

		// Login(로그인) - 로그인		
		else if (uri.contains("/member/member.do")) { // 로그인 유지를 위한 액션
			action = new loginAction();
		} // 일단 MembershipAction()을 로그인 유지 Action으로 사용
		else if (uri.contains("/member/Membership.do")) { // 회원가입
			action = new MembershipAction();
		} 
		

		System.out.println("ActionFactory Action :" + action);
		return action;
	}
}
