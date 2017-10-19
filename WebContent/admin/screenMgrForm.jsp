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
	
	if(sVO != null){
		pageContext.setAttribute("CmdMgr", "Screen_UPDATE");
	}else{
		pageContext.setAttribute("CmdMgr", "Screen_INSERT");
	}
%>
	
	<div class ="screen">
		<div class = "logo">
			상영관 정보 입력
			<hr>
		</div>
		
		<c:if test="${CmdMgr == 'Screen_UPDATE'}">
			<c:forEach var="sVO" items="${sVO }">
			<div class ="Screen_reg" style="text-align: left; padding: 30px 50px 30px 50px;">
				<form action="../admin/admin_Screening.do" method="post">
					<input type="hidden" name = "CmdMgr" value="${CmdMgr }">
					<input type="hidden" name = "ScreenTCODE" value="T01">
					<input type="hidden" name = "ScreenSCODE" value="S01">
					<label> 이름 </label> <input type="text" name="ScreenSNAME" value="${sVO.SNAME }"><p>
					<%-- <label> 좌석수 </label> <input type="text" name="ScreenSSEATCNT" value="${sVO.SSEATCNT }" style="background-color:transparent;border:0px" readonly="readonly"><p> --%>
					<label> 소개 </label> <textarea name="ScreenSSEATINFO" rows="5" cols="50">${sVO.SSEATINFO }</textarea><p>
					
					<%-- <label> 회차 </label> <input type="text" name="ScreenSTURN" value="${sVO.STURN }" style="background-color:transparent;border:0px" readonly="readonly"><p>
					<label> 시간 </label> <input type="file" name="ScreenSTIME" value="${sVO.STIME }" style="background-color:transparent;border:0px" readonly="readonly"> <br /><p> --%>
					<br><br>
					<input type="submit" value="등록" />
					<input type="reset">
				</form>
			</div>
			</c:forEach>
		</c:if>
		
		<c:if test="${CmdMgr == 'Screen_INSERT' }">
			<div class ="Screen_reg" style="text-align: left; padding: 30px 50px 30px 50px;">
				<form action="../admin/admin_Screening.do" method="post">
					<input type="hidden" name = "CmdMgr" value="${CmdMgr }">
					<input type="hidden" name = "ScreenTCODE" value="T01">
					<input type="hidden" name = "ScreenSCODE" value="S01">
					<label> 이름 </label> <input type="text" name="ScreenSNAME" ><p>
					<label> 소개 </label> <textarea name="ScreenSSEATINFO" rows="5" cols="50"></textarea><p>
					<br><br>
					<input type="submit" value="등록" />
					<input type="reset">
				</form>
			</div>
		</c:if>
		
	</div>

<%@include file="/com/footer.jsp" %>