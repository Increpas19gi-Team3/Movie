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
	
	if(tVO != null){
		pageContext.setAttribute("CmdMgr", "Theater_UPDATE");
	}else{
		pageContext.setAttribute("CmdMgr", "Theater_INSERT");
	}
%>
	
	<div class ="theater">
		<div class = "logo">
			극장 정보 입력
			<hr>
		</div>
		
		<c:if test="${CmdMgr == 'Theater_UPDATE'}">
			<c:forEach var="tVO" items="${tVO }">
			<div class ="theather_reg" style="text-align: left; padding: 30px 50px 30px 50px;">
				<form action="../admin/admin_Theater.do" method="post" enctype="multipart/form-data">
					<input type="hidden" name = "CmdMgr" value="${CmdMgr }">
					<input type="hidden" name = "TheaterTCODE" value="T01">
					<label> 이름 </label> <input type="text" name="TheaterTNAME" value="${tVO.TNAME }"><p>
					<label> 위치 </label> <input type="text" name="TheaterTLOCAL" value="${tVO.TLOCAL }"><p>
					<label> 소개 </label> <textarea name="TheaterTDESC" rows="5" cols="50">${tVO.TDESC }</textarea><p>
					<label> 사진 </label> <input type="file" name="TheaterTIMAGE"> <br /><p>
					<br><br>
					<input type="submit" value="등록" />
					<input type="reset">
				</form>
			</div>
			</c:forEach>
		</c:if>
		
		<c:if test="${CmdMgr == 'Theater_INSERT' }">
			<div class ="theather_reg" style="text-align: left; padding: 30px 50px 30px 50px;">
				<form action="../admin/admin_Theater.do" method="post" enctype="multipart/form-data">
					<input type="hidden" name = "CmdMgr" value="${CmdMgr }">
					<input type="hidden" name = "TheaterTCODE" value="T01">
					<label> 이름 </label> <input type="text" name="TheaterTNAME" ><p>
					<label> 위치 </label> <input type="text" name="TheaterTLOCAL" ><p>
					<label> 소개 </label> <textarea name="TheaterTDESC" rows="5" cols="50"></textarea><p>
					<label> 사진 </label> <input type="file" name="TheaterTIMAGE"> <br /><p>
					<br><br>
					<input type="submit" value="등록" />
					<input type="reset">
				</form>
			</div>
		</c:if>
		
	</div>

<%@include file="/com/footer.jsp" %>