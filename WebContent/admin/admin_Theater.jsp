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
	
	<c:choose>
		<c:when test="${not empty tVO}">
			<c:forEach var="tVO" items="${tVO }">
				
				<div id = "theater_Info">
					<img src="../image/"${tVO.TIMAGE }><br />
					
					<%-- ${tVO.TCODE }<br /> --%>
					${tVO.TNAME }<br />
					${tVO.TLOCAL }<br />
					${tVO.TDESC }<br />
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			
			<hr>
			<div id="">
				<form action="/admin/theater_Insert.do" method="post">
					<input type="submit" value="등록" />
				</form>
			</div>
		
		</c:otherwise>
	</c:choose>


<%@include file="/com/footer.jsp" %>