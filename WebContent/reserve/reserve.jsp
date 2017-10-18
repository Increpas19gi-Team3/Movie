<%@page import="java.util.List"%>
<%@page import="com.movie03.dto.MovieVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>

<%-- 정적 인클루드 --%>
<%@include file="/com/header.jsp" %>

	<div id="wrap" align="center">
		<h1>영화 리스트</h1>
		<table border="1">
			
			<tr>
				<th>제목</th>
				<th>감독</th>
				<th>배우</th>
				<th>가격</th>
				<th>예매</th>
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
				
			
			<c:forEach var="movie" items="${mVo}" varStatus="status">
				<tr class="record">
					<td>${movie.TITLE}</td>
					<td>${movie.DIRECTOR}</td>
					<td>${movie.ACTOR}</td>
					<td>${movie.PRICE}</td>
					<td><input type="button" value="예매하기" onclick="location.href='/Movie/reserveMovie.do?command=reserveMovie"></td>
				</tr>
			</c:forEach>
		</table>
		<br><br>
	</div>

<%@include file="/com/footer.jsp" %>


