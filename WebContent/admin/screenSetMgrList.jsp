<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.movie03.dto.ScreenSetVO" %>
<%-- 정적 인클루드 --%>
<%@include file="/com/header_Admin.jsp" %>
<%
	HashMap<String, Object> respModel = (HashMap<String, Object>)request.getAttribute("respModel");
	ArrayList<ScreenSetVO> ssVO = (ArrayList<ScreenSetVO>)respModel.get("MgrListSSet");
	pageContext.setAttribute("ssVO", ssVO);
	
	String cmd = (String)respModel.get("CmdMgr");
	if(cmd != null){
		pageContext.setAttribute("CmdMgr", "SSet_LIST");
	}else{
		pageContext.setAttribute("CmdMgr", cmd);
	}
	
%>
	<c:set var="now" value="<%=new java.util.Date()%>" />
	
	<div id="wrap" align="center">
	
		<form action="../admin/admin_ScreenSet.do" method="post">
			<input type="hidden" name = "CmdMgr" value="SSet_VIEW">
			<input type="date" name="SetDate" value="<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />">
			<input type="submit" value="영화 설정">
		</form>
		
		<hr>
	
		<table border="1">
			<tr>
				<th>상영 일</th>
				<th>상영 회차</th>
				<th>제목</th>
				<th>개봉 일</th>
				<th>상영 시작일</th>
				<th>상영 종료일</th>
			</tr>
	
			<c:if test="${not empty ssVO }">
				<c:forEach var="ssVO" items="${ssVO }">
				<tr>
					<td>
						<a href="../admin/admin_ScreenSet.do?CmdMgr=SSet_VIEW&STdate=${ssVO.STdate }">
						${ssVO.STdate }
						</a>
					</td>
					<td>${ssVO.STturn }</td>
					<td>${ssVO.MTitle }</td>
					<td>${ssVO.MOpenday }</td>
					<td>${ssVO.MStartday }</td>
					<td>${ssVO.MEndday }</td>
				</tr>
				</c:forEach>
			</c:if>
		</table>
		
		
	</div>
	

<%@include file="/com/footer.jsp" %>