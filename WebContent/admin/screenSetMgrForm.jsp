<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.movie03.dto.MovieVO" %>

<%-- 정적 인클루드 --%>
<%@include file="/com/header_Admin.jsp" %>
<%
	HashMap<String, Object> respModel = (HashMap<String, Object>)request.getAttribute("respModel");
	ArrayList<MovieVO> mVO = (ArrayList<MovieVO>)respModel.get("MgrViewSSetMovie");
	pageContext.setAttribute("mVO", mVO);
	
	String cmd = (String)respModel.get("CmdMgr");
	pageContext.setAttribute("CmdMgr", cmd);
	
	String STturn = (String)respModel.get("STturn");
	String STdate = (String)respModel.get("STdate");
	String MTitle = (String)respModel.get("MTitle");
	pageContext.setAttribute("STturn", STturn);
	pageContext.setAttribute("STdate", STdate);
	pageContext.setAttribute("MTitle", MTitle);
%>
 	미구현 ) 수정 : 수정하는 쿼리
 	미구현 ) 입력 : 입력창, 입력하는 쿼리
 	
 	
<p>

	<div id="wrap" align="center">
		<c:if test="${CmdMgr eq 'SSet_UPDATE_FORM' }"><h1>수  정</h1></c:if>
		<c:if test="${CmdMgr eq 'SSet_INSERT_FORM' }"><h1>입  력</h1></c:if>
		
		<table style="width: 80%" border="1">
			<tr>
				<th style="width: 120px">상영 일</th>
				<td>${STdate }</td>
			</tr>
			<tr>
				<th>상영 회차</th>
				<td>
					<c:choose>
						<c:when test="${STturn == 1}">
							<input type="radio" id="STturn_1" name="ssvoSTturn" value="1" checked="checked">
						</c:when>
						<c:otherwise>
							<input type="radio" id="STturn_1" name="ssvoSTturn" value="1">
						</c:otherwise>
					</c:choose><label for="STturn_1">1 회</label> &nbsp;&nbsp;
					
					<c:choose>
						<c:when test="${STturn == 2}">
							<input type="radio" id="STturn_2" name="ssvoSTturn" value="2" checked="checked">
						</c:when>
						<c:otherwise>
							<input type="radio" id="STturn_2" name="ssvoSTturn" value="2">
						</c:otherwise>
					</c:choose><label for="STturn_2">2 회</label> &nbsp;&nbsp;
					
					<c:choose>
						<c:when test="${STturn == 3}">
							<input type="radio" id="STturn_3" name="ssvoSTturn" value="3" checked="checked">
						</c:when>
						<c:otherwise>
							<input type="radio" id="STturn_3" name="ssvoSTturn" value="3">
						</c:otherwise>
					</c:choose><label for="STturn_3">3 회</label> &nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<th>제 목</th>
				<td>
					<c:if test="${not empty mVO }">
					<select name="selTitle">
					<c:forEach var="mVO" items="${mVO }">				
						<c:choose>
							<c:when test="${mVO.TITLE == MTitle }">
								<option value="${mVO.MCODE }" selected="selected">${mVO.TITLE }</option>
							</c:when>
							<c:otherwise>
								<option value="${mVO.MCODE }" >${mVO.TITLE }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					</select>
					</c:if>
				
				</td>
			</tr>
		</table>
		
		<br>
		<form method="post" action="">	  
			<input type="button" value="목록" onclick="location.href='../admin/admin_ScreenSet.do?CmdMgr=SSet_LIST'">
		</form> 
	</div>
 
<%@include file="/com/footer.jsp" %>