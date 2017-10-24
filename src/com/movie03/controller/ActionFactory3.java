package com.movie03.controller;

import com.movie03.controller.action.Action;
import com.movie03.controller.action.Action2;
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

public class ActionFactory3 {
	private static ActionFactory3 instance = new ActionFactory3();

	private ActionFactory3() {
		super();
	}

	public static ActionFactory3 getInstance() {
		return instance;
	}

	// AC 등록
	public Action2 getAction(String uri) {
		///web-study-11/board/reply_add.do
		Action2 action = null;
		System.out.println("ActionFactory3 :" + uri);
		//요청URI에 reply_add.do 커멘드가 포함되면  
		
		if(uri.contains("reply_add.do")){
			// 부모클레스, 인터페이스 타입의 참조변수는
			//자식클래스객체를 대입받을 수 있다
			action=new BoardReplyAction2();
		}else if(uri.equals("reply_del.do")){
			action=new BoardReplyDelAction2();
		}
		
		String test = "AF 충돌 테스트 중!!!";
		System.out.println(test);
		
		
		return action;
	}
}
