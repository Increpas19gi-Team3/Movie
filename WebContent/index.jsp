<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	index.jsp
	<%
	// 게시글 리스트 보여주기(R) 요청(이동,호출)을 BoardServlet (FC)로 함
	// response.sendRedirect("/web-study-11/BoardServlet?command=board_list"); // 절대경로
	// response.sendRedirect("BoardServlet?command=board_list"); // 절대경로
	response.sendRedirect("com/main.jsp"); // 절대경로
	// response.sendRedirect("/web-study-11/BoardServlet?command=board_list2"); // Action 실습
	%>
</body>
</html>