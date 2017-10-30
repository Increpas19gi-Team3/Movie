<%-- 로그아웃 처리 페이지 --%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 'session' 내용 완전 제거
	// //* 주석은 session에 저장된 내용을 있는지 확인하기 위한 기능들
	//* HashMap<String, Object> respModel 
	//* = (HashMap<String, Object>)request.getAttribute("respModel");
	//* System.out.println("request : " + respModel);	
	session.invalidate();	
	//* response.sendRedirect("../movie/movie.do");
%>

<script type="text/javascript">
	alert("로그아웃 되셨습니다.");
	location.href = "login.jsp"; /* alert의 확인 버튼을 누르면 login.jsp 로 이동 */
</script>