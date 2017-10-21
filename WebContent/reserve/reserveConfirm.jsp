<%@page import="com.movie03.dto.ReserveVO"%>
<%@page import="com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException"%>
<%@page import="com.movie03.dto.SeatVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@include file="/com/header.jsp" %>

<link rel="stylesheet" type="text/css" href="css/shopping.css">
	<div id="wrap" align="center">
		<h1>영화 리스트</h1>
		 <table border="1">
			
			<tr>
				<th class="title">예매번호</th>
				<th class="title">영화제목</th>
				<th class="title">상영관</th>
				<th class="title">상영날짜</th>
				<th class="title">상영회차</th>
				<th class="title">좌석</th>
			</tr>
			<!-- 글목록을 요청영역에서 가져옴  -->
			<%
				HashMap<String, Object> respModel = (HashMap<String, Object>)request.getAttribute("respModel");
				List<ReserveVO> mVo = (List<ReserveVO>)respModel.get("movieList");
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
					<th>${movie.RCODE}</th>
					<th>${movie.MCODE}</th> <!-- 영화코드로 영화제목 읽어오기 -->
					<th>1관</th>
					<th>${movie.RDAY}</th>
					<th>${movie.RTURN}</th>
					<th>${movie.RSEAT}</th>
				</tr>
			</c:forEach>
		</table>
		<br><br> 
	</div>
	
<%@include file="/com/footer.jsp" %>