<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> <%-- 문자 라이브러리 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <%-- 시간, 숫자 포맷 라이브러리 --%>


<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/shopping.css">
	<link rel="stylesheet" href="/Movie/css/style.css?v=2">
	<!-- <script type="text/javascript" src="script/product.js"></script> -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<title> Movie Reserve Site 03 </title>
</head>
<body>
	
	<div class="header">
      <div class="logo">
        <a href="/Movie/index.jsp">영화 예매 사이트</a>
      </div>
      <div class="menu">
        <ul>
          <li><a href="/Movie/movie/movie.do">영화</a></li>
          <li><a href="/Movie/MovieServlet.do">예매</a></li>
          <li><a href="/Movie/theater/theater.do">극장정보</a></li>
        </ul>
      </div>
      
      <div class="gnb">
      	
        <ul>
        	<c:if test="${sessionScope.MNAME != null}">
        		<li><a>${sessionScope.MNAME}님 어서오세요.</a></li>
        		
        		<c:if test="${sessionScope.MADMIN == 0}">
        			<li><a href="../admin/admin.do">[관리자 화면]</a></li>
        		</c:if>
        		
        		<li><a href="../member/logout.jsp">로그아웃</a></li>
        	</c:if>
        	<c:if test="${sessionScope.MNAME == null}">
        		<li><a href="../member/login.jsp">login</a></li>
			</c:if>

			<li><a href="../member/myPage.jsp">my</a></li>
			<li><a href="/Movie/reserveCon.do?userID=${sessionScope.MID}">예매확인</a></li>
        </ul>
      </div>
    </div>