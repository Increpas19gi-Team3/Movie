package com.movie03.controller;


import com.movie03.controller.action.Action2;
import com.movie03.controller.action.AdminAction;
import com.movie03.controller.action.AdminMovieAction;
import com.movie03.controller.action.AdminScreeningAction;
import com.movie03.controller.action.AdminTheaterAction;
//import com.movie03.controller.action.BoardCheckPassAction;
//import com.movie03.controller.action.BoardCheckPassFormAction;
//import com.movie03.controller.action.BoardDeleteAction;
//import com.movie03.controller.action.BoardListAction;
//import com.movie03.controller.action.BoardReplyAction;
import com.movie03.controller.action.BoardReplyAction2;
import com.movie03.controller.action.BoardReplyDelAction2;
//import com.movie03.controller.action.BoardUpdateAction;
//import com.movie03.controller.action.BoardUpdateFormAction;
//import com.movie03.controller.action.BoardViewAction;
//import com.movie03.controller.action.BoardWriteAction;
//import com.movie03.controller.action.BoardWriteFormAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	// AC 등록
	public Action2 getAction(String uri) {
		///web-study-11/board/reply_add.do
		Action2 action = null;
		System.out.println("ActionFactory :" + uri);
		
		//요청URI에 reply_add.do 커멘드가 포함되면  
		
		//Admin 관리화면
		if(uri.contains("/admin/admin.do")){
			action = new AdminAction(); 
			
		}else if(uri.contains("/admin/admin_Theater.do")){//
			action = new AdminTheaterAction(); 
			
		}else if(uri.contains("/admin/admin_Screening.do")){
			action = new AdminScreeningAction(); 
			
		}else if(uri.contains("/admin/admin_Movie.do")){
			action=new AdminMovieAction();
		}
		
		// 회원관리
		
		// 예약 관리
		
		// 
		
		System.out.println("AF :"+ action);
		return action;
	}
}
