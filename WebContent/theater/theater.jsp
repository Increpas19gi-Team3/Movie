<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- 정적 인클루드 --%>
<%@include file="/com/header.jsp"%>

<%@page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@page import="com.movie03.dto.TheaterVO"%>

<!-- 극장정보 theater.jsp 출력해야할 내용들
 
* 상세정보 
Tcode - 극장코드 
Tname - 극장이름 
Tlocal - 위치 
Tdesc - 소개 
Timage - 사진 -->

<div id="#" align="center">
	<h1>극장-정보</h1>
	<table class="#">
		<tr>
			<th>극장 사진</th>
			<th>극장코드</th>
			<th>극장이름</th>
			<th>위&nbsp;&nbsp;치</th>
			<th>소&nbsp;&nbsp;개</th>			
		</tr>

		<!-- 글목록을 요청영역에서 가져옴  -->
		<%
			HashMap<String, Object> respModel = (HashMap<String, Object>) request.getAttribute("respModel");
		
			// TheaterAction.java에서 요청 받은
			// respModel.put("TheaterList", TheaterList);이 부분에서
			// TheaterList 와 (List<TheaterVO>)respModel.get("TheaterList")의
			// TheaterList = respModel.get("TheaterList")이 일치해야 내용이 나옴..ㅠㅜ
			List<TheaterVO> tVo = (List<TheaterVO>)respModel.get("TheaterList");
			pageContext.setAttribute("tVo", tVo);
		%>
		
		<c:forEach var="theater" items="${tVo}">
				<tr class="#">
					<th>${theater.TIMAGE}</th><!-- 이미지 -->
					<th>${theater.TCODE}</th><!-- 극장코드 -->
					<th>${theater.TNAME}</th><!-- 극장이름 -->
					<th>${theater.TLOCAL}</th><!-- 극장위치 -->
					<th>${theater.TDESC}</th><!-- 극장소개 -->					
				</tr>
			</c:forEach>
	</table>
	
	<br>
	<br>	
	
	<!-- 버튼(뒤로가기) 	
	 : 메인-페이지(index 페이지로 넘어감) -->	 
	 <input type="button" value="뒤로가기" onclick="location.href='../movie/movie.do?'">
</div>

<%@include file="/com/footer.jsp"%>