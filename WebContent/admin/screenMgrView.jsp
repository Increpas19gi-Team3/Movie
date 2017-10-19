<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.movie03.dto.ScreeningVO" %>

<%-- 정적 인클루드 --%>
<%@include file="/com/header_Admin.jsp" %>

<%
	HashMap<String, Object> respModel = (HashMap<String, Object>)request.getAttribute("respModel");
	
	ArrayList<ScreeningVO> sVO = (ArrayList<ScreeningVO>)respModel.get("MgrViewScreen");//1개 행이라 바로 받음
	pageContext.setAttribute("sVO", sVO);
%>

	<div class ="screen">
		<c:forEach var="sVO" items="${sVO }">
			<div class = "logo">
				${sVO.SNAME }
			</div>
			<hr>
			<div class = "screen_Info">
				소개 : ${sVO.SSEATINFO }<br />
				좌석 수: ${sVO.SSEATCNT }<br />
				회차 : ${sVO.STURN }회 <br />
				시간 : ${sVO.STIME }시 <br />
				
				<form action="../admin/admin_Screening.do" method="post">
					<input type="hidden" name = "CmdMgr" value="Screen_UPDATE_FORM">
					<input type="submit" value="상영관 정보 수정" />
				</form>				
			</div>
		</c:forEach>
	</div>


<%@include file="/com/footer.jsp" %>


