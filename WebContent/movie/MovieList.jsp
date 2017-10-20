<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- 정적 인클루드 --%>

<%@include file="/com/header.jsp"%>

<%@page import="java.util.List"%>
<%@page import="com.movie03.dto.MovieVO"%>
<%@ page import="java.util.HashMap"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--영화 리스트(검색, 정렬, 상세보기 링크)

노출시켜할 목록 : 영화코드, 제목, 감독, 배우, 장르
	1. 어떻게 정렬기능을 삽입 시킬 것인가#
	 : '제목'을 반복 클릭시 내림과 오름차순이 번갈아 가면서 정렬
	 : MovieDAO.java ->  
	
	2. 어떻게 상세-페이지로 이동 시킬것인가?
	 : 영화제목을 클릭시 상세페이지로 이동시킴
	 -->
	 
<!-- 글-목록을 요청영역에서 가져옴  -->
<%
	HashMap<String, Object> respModel = (HashMap<String, Object>) request.getAttribute("respModel");

	String OrderBy = (String) respModel.get("OrderBy");
	pageContext.setAttribute("OrderBy", OrderBy);

	List<MovieVO> mVo = (List<MovieVO>) respModel.get("MovieList");
	pageContext.setAttribute("mVo", mVo);
%>

<div id="#" align="center">
	<h1>영화-리스트</h1>
	<br>
	<form name="#" method="post" action="../movie/movie.do">
		<!-- 이부분의 input의 type="hidden" 속성을 잘 모르겠음 -->
		<input type="hidden" name="CmdMovie" value="Search">
		
		<table class="#" border="1">
			<tr>
				<th>번호(영화코드)</th>
				<!-- 제목 클릭시 정렬에 관한 SQL문 실행 -->
				<th><a href="../movie/movie.do?OrderBy=${OrderBy}">제목</a></th>
				<th>감독</th>
				<th>배우</th>
				<th>장르</th>

				<c:forEach var="movie" items="${mVo}">
					<tr class="#">
						<td>${movie.MCODE}</td>
						<!-- 영화제목 클릭시 상세보기에 관한 페이지 이동 -->						
						<td><a href="../movie/movie.do?DetailMovie=${DetailMovie}">${movie.TITLE}</td>
						<td>${movie.DIRECTOR}</td>
						<td>${movie.ACTOR}</td>
						<td>${movie.GENRE}</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
		<br> 
		<br>
		<!-- 검색기능 : 아직 구현안됨
		 선택바 : 없음, 제목, 감독, 배우, 장르
	 	 내용(text) : 검색내용이 없을 시 경고창으로 알림
		 클릭버튼(value=검색) : 검색을 클릭시 검색 내용만 출력되게 만듬 -->		 
		<select name="select_word">
			<option value="none">없음</option>
			<option value="title">제목</option>
			<option value="director">감독</option>
			<option value="actor">배우</option>
			<option value="genre">장르</option>
		</select> 
		
		<input type="text" name="search_text"> 
		<input type="submit" value="검색" onclick="#">
	</form>
</div>

<%@include file="/com/footer.jsp"%>
