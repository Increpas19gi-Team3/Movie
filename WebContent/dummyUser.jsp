<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	session.setAttribute("MNAME", "한범석");
	session.setAttribute("MID", "han");
	session.setAttribute("MADMIN", "1");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 개발용 더미 페이지 입니다.</title>
</head>
<body>

	해당 파일은 개발용 더미 입니다. <br />
	로그인 한 것으로 인식하게 합니다.<br />
	
	<c:redirect url="com/main.jsp"></c:redirect>
</body>
</html>