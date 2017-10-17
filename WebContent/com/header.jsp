<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- <script type="text/javascript" src="script/product.js"></script> -->
	<link rel="stylesheet" href="../css/style.css?v=2">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<title> Movie Reserve Site 03 </title>
</head>
<body>
	
	<div class="header">
      <div class="logo">
        <a href="index.jsp">영화 예매 사이트</a>
      </div>
      <div class="menu">
        <ul>
          <li><a href="../movie/movie.jsp">영화</a></li>
          <li><a href="../reserve/reserve.jsp">예매</a></li>
          <li><a href="../theater/theater.jsp">극장정보</a></li>
        </ul>
      </div>
      
      <div class="gnb">
      	
        <ul>
        	<c:if test="${sessionScope.NAME != null}">
        		<li><a>${sessionScope.NAME}님 어서오세요.</a></li>
        		
        		<c:if test="${sessionScope.ADMIN == 1}">
        			<li><a>관리자</a></li>
        		</c:if>
        		
        		<li><a href="../member/logout.jsp">로그아웃</a></li>
        	</c:if>
        	<c:if test="${sessionScope.NAME == null}">
        		<li><a href="../member/login.jsp">login</a></li>
			</c:if>
			
			<li><a href="../member/myPage.jsp">my</a></li>
        </ul>
      </div>
    </div>