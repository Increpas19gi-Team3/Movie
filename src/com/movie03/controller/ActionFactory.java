package com.movie03.controller;


import com.movie03.controller.action.Action;
import com.movie03.controller.action.Action2;
import com.movie03.controller.action.AdminAction;
import com.movie03.controller.action.AdminMovieAction;
import com.movie03.controller.action.AdminReserveAction;
import com.movie03.controller.action.AdminScreeningAction;
import com.movie03.controller.action.AdminTheaterAction;
//import com.movie03.controller.action.BoardCheckPassAction;
//import com.movie03.controller.action.BoardCheckPassFormAction;
//import com.movie03.controller.action.BoardDeleteAction;
//import com.movie03.controller.action.BoardListAction;
//import com.movie03.controller.action.BoardReplyAction;
import com.movie03.controller.action.BoardReplyAction2;
import com.movie03.controller.action.BoardReplyDelAction2;
import com.movie03.controller.action.MovieAction;
//import com.movie03.controller.action.BoardUpdateAction;
//import com.movie03.controller.action.BoardUpdateFormAction;
//import com.movie03.controller.action.BoardViewAction;
//import com.movie03.controller.action.BoardWriteAction;
//import com.movie03.controller.action.BoardWriteFormAction;
import com.movie03.controller.action.ReserveAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String uri) {
		///web-study-11/board/reply_add.do
		Action action = null;
		System.out.println("ActionFactory :" + uri);
		
		//요청URI에 reply_add.do 커멘드가 포함되면  
		
		//Admin 관리화면
		if(uri.contains("/admin/admin.do")){
			action = new AdminAction(); 
			
		}else if(uri.contains("/admin/admin_Theater.do")){// 영화관 관리
			action = new AdminTheaterAction(); 
			
		}else if(uri.contains("/admin/admin_Screening.do")){// 상영관 관리
			action = new AdminScreeningAction(); 
			
		}else if(uri.contains("/admin/admin_Movie.do")){// 영화 목록 관리
			action=new AdminMovieAction();
			
		}else if(uri.contains("/admin/admin_Reserve.do")){// 예약 관리
			action=new AdminReserveAction();
		}
		
		// 회원관리
		
		// 예약 관리
		else if(uri.contains("/Movie/MovieServlet.do")){
			action = new ReserveAction();
		}
		
		// 영화 관리
		else if(uri.contains("/movie/movie.do")){
			action = new MovieAction();
		}
		
		System.out.println("ActionFactory Action :"+ action);
		return action;
	}
}
