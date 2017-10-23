<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.movie03.dto.MovieVO"%>

<%@ page import="java.util.HashMap" %>



<%@include file="/com/header.jsp" %>

	<div id="wrap" align="center">
		<h1>영화 리스트</h1>
		<table border="1">
			
			<tr>
				<th class="title">제목</th>
				<th class="title">감독</th>
				<th class="title">배우</th>
				<th class="title">가격</th>
				<th class="title">예매</th>
			</tr>
			
			<!-- 글목록을 요청영역에서 가져옴  -->
			<%
				HashMap<String, Object> respModel = (HashMap<String, Object>)request.getAttribute("respModel");
				List<MovieVO> mVo = (List<MovieVO>)respModel.get("movieList");
				pageContext.setAttribute("mVo", mVo);
				/* for(int i=0; i<mVo.size(); i++){
					System.out.println(mVo.get(i).getTITLE());
					System.out.println(mVo.get(i).getDIRECTOR());
					System.out.println(mVo.get(i).getACTOR());
					System.out.println(mVo.get(i).getPRICE());
				} */
			%>				
			
			<c:forEach var="movie" items="${mVo}">
				<tr class="record">
					<th>${movie.TITLE}</th>
					<th>${movie.DIRECTOR}</th>
					<th>${movie.ACTOR}</th>
					<th>${movie.PRICE}</th>
					<th><input type="button" value="예매하기" onclick="location.href='/Movie/reserve/reserveMovie.jsp?title=${movie.TITLE}'"></th>
				</tr>
			</c:forEach>
		</table>
		<br><br>
	</div>

<%@include file="/com/footer.jsp" %>


