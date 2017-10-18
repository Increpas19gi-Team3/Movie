<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.movie03.dto.TheaterVO" %>

<%-- 정적 인클루드 --%>
<%@include file="/com/header_Admin.jsp" %>
<%
	HashMap<String, Object> respModel = (HashMap<String, Object>)request.getAttribute("respModel");
	ArrayList<TheaterVO> tVO = (ArrayList<TheaterVO>)respModel.get("CmdAdmin_Theater");//1개 행이라 바로 받음
	pageContext.setAttribute("tVO", tVO);
%>
	
	<div class ="theater">
		<c:choose>
			<c:when test="${not empty tVO}">
				<c:forEach var="tVO" items="${tVO }">
					
						<div class = "logo">
							${tVO.TNAME }
						</div>
						<div class = "theater_Info">
							${tVO.TDESC }<br />
							${tVO.TLOCAL }<br />
						<hr>
						<p />
						<img src="../image/${tVO.TIMAGE }"><br />
						
						<%-- ${tVO.TCODE }<br /> --%>
						
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				
				<div class ="theather_reg" style="text-align: center; padding: 30px 50px 30px 50px;">
					<!-- <form action="/admin/theater_Insert.do" method="post"> -->
					
					<% request.setAttribute("AdminTheater", "Insert"); %>
					<form action="../admin/admin_Theater.do" method="post">
						<input type="submit" value="영화관 정보 등록" />
					</form>
				</div>
			
			</c:otherwise>
		</c:choose>

	</div>

<%@include file="/com/footer.jsp" %>