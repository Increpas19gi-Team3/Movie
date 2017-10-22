<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.movie03.dto.ScreenSetVO" %>

<%-- 정적 인클루드 --%>
<%@include file="/com/header_Admin.jsp" %>
<%
	HashMap<String, Object> respModel = (HashMap<String, Object>)request.getAttribute("respModel");
	ArrayList<ScreenSetVO> ssVO = (ArrayList<ScreenSetVO>)respModel.get("MgrViewSSet");
	pageContext.setAttribute("ssVO", ssVO);
	
	String cmd = (String)respModel.get("CmdMgr");
	
%>


				
<p>

	<div id="wrap" align="center">
	<h1>상  세   보  기</h1>
		
		<table style="width: 80%" border="1">
			<tr>
				<th style="width: 120px">상영 일</th>
				<th>상영 회차</th>
				<th>제 목</th>
				<th>개봉 일</th>
				<th>상영 시작일</th>
				<th>상영 종료일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			
			<c:if test="${not empty ssVO }">
			<c:forEach var="ssVO" items="${ssVO }">	
			<tr>
				<td>${ssVO.STdate }</td>
				<td>${ssVO.STturn } 회</td>
				<td>${ssVO.MTitle }</td>
				<td>${ssVO.MOpenday }</td>
				<td>${ssVO.MStartday }</td>
				<td>${ssVO.MEndday }</td>
				<td><a href="../admin/admin_ScreenSet.do?CmdMgr=SSet_UPDATE_FORM&STdate=${ssVO.STdate }&STturn=${ssVO.STturn }">수정</a></td>
				<td><a href="../admin/admin_ScreenSet.do?CmdMgr=SSet_DELETE&STdate=${ssVO.STdate }&STturn=${ssVO.STturn }">삭제</a></td>
				
			</tr> 
			</c:forEach>
			</c:if>
		</table>
		
		<br>
		<form method="post" action="">	  
			<input type="button" value="목록" onclick="location.href='../admin/admin_ScreenSet.do?CmdMgr=SSet_LIST'">
		</form> 
	</div>
 






	

<%@include file="/com/footer.jsp" %>