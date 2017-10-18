<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%-- 정적 인클루드 --%>
<%@include file="/com/header.jsp" %>


	<div id="wrap" align="center">
		<h1>영화 리스트</h1>
		<table class="list">
			
			<tr>
				<th>제목</th>
				<th>감독</th>
				<th>배우</th>
				<th>가격</th>
				<th>예매</th>
			</tr>
			<!-- 글목록을 요청영역에서 가져옴  -->
			<c:forEach var="movie" items="${movieList }">
				<tr class="record">
					<td>${res.TITLE}</td>
					<td>${res.DIRECTOR}</td>
					<td>${res.ACTOR}</td>
					<td>${res.PRICE}</td>
					<td><input type="button" value="예매하기" onclick="location.href='BoardServlet"></td>
				</tr>
			</c:forEach>
		</table>
	</div>





<%@include file="/com/footer.jsp" %>


