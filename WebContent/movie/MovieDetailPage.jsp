<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 정적 인클루드 --%>

<%@include file="/com/header.jsp"%>

<%@page import="java.util.List"%>
<%@page import="com.movie03.dto.MovieVO"%>
<%@ page import="java.util.HashMap"%>

<div id="#" align="center">
	<h1>상영중인 영화 리스트</h1>
	<table class="#">
		<tr>
			<th>영화 이미지</th>
			<th>영화코드</th>
			<th>영화제목</th>
			<th>가&nbsp;격</th>
			<th>감&nbsp;독</th>
			<th>배&nbsp;우</th>
			<th>개봉일</th>
			<th>장&nbsp;르</th>
			<th>시놉시스</th>
			<th>상영시작일</th>
			<th>상영종료일</th>			
			<th>평&nbsp;점</th>
		</tr>

		<!-- 글목록을 요청영역에서 가져옴  -->
		<%
			HashMap<String, Object> respModel = (HashMap<String, Object>) request.getAttribute("respModel");
			List<MovieVO> mVo = (List<MovieVO>) respModel.get("movieList");
			pageContext.setAttribute("mVo", mVo);
		%>
		
		<c:forEach var="movie" items="${mVo}">
				<tr class="#">
					<th>${movie.POSTER}</th>
					<th>${movie.MCODE}</th>
					<th>${movie.TITLE}</th>
					<th>${movie.PRICE}</th>					
					<th>${movie.DIRECTOR}</th>					
					<th>${movie.ACTOR}</th>
					<th>${movie.OPENDAY}</th>
					<th>${movie.GENRE}</th>					
					<th>${movie.SYNOPSIS}</th>
					<th>${movie.STARTDAY}</th>
					<th>${movie.ENDDAY}</th>					
					<th>${movie.APPRAISAL}</th>
				</tr>
			</c:forEach>
	</table>
	
	<br>
	<br>	
	
	<!-- 버튼(뒤로가기) 
	 : 페이지를 영화-리스트 페이지로 넘어감  
	 : 일단 onclick="MovieList.java"라고 씀 -->	 
	 <input type="button" value="뒤로가기" onclick="MovieList.java">
</div>

<%@include file="/com/footer.jsp"%>