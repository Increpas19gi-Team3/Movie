<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.movie03.dto.TheaterVO" %>

<%-- 정적 인클루드 --%>
<%@include file="/com/header_Admin.jsp" %>
<%
	HashMap<String, Object> respModel = (HashMap<String, Object>)request.getAttribute("respModel");
	
	ArrayList<TheaterVO> tVO = (ArrayList<TheaterVO>)respModel.get("MgrViewTheater");//1개 행이라 바로 받음
	pageContext.setAttribute("tVO", tVO);
%>
		
	<div class ="theater">
		<c:forEach var="tVO" items="${tVO }">
			<div class = "logo">
				${tVO.TNAME }
			</div>
			<hr>
			<div class = "theater_Info">
				소개 : ${tVO.TDESC }<br />
				위치 : ${tVO.TLOCAL }<br />
				
				<form action="../admin/admin_Theater.do" method="post">
					<input type="hidden" name = "CmdMgr" value="Theater_UPDATE_FORM">
					<input type="submit" value="영화관 정보 수정" />
				</form>
				
				<p />
				<img src="../image/${tVO.TIMAGE }"><br />				
			</div>
		</c:forEach>
	</div>

<%@include file="/com/footer.jsp" %>