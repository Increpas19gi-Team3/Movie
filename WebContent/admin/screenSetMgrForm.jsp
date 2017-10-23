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
	
	String[] STturnArr = (String[])respModel.get("STturnArr");
	pageContext.setAttribute("STturnArr", STturnArr);
	
	
	String STdate = (String)respModel.get("STdate");
	String STturn = (String)respModel.get("STturn");
	String MTitle = (String)respModel.get("MTitle");
	pageContext.setAttribute("STdate", STdate);
	pageContext.setAttribute("STturn", STturn);
	pageContext.setAttribute("MTitle", MTitle);
	
	String selDate = (String)respModel.get("selDate");
	pageContext.setAttribute("selDate", selDate);
%>
<p>

	<c:if test="${CmdMgr eq 'SSet_UPDATE_FORM' }">
	<div id="wrap" align="center">
		<h1>수  정</h1>
		
		<form method="post" action="../admin/admin_ScreenSet.do">
		<input type="hidden" name="CmdMgr" value="SSet_UPDATE">
		<input type="hidden" name="STdate" value="${STdate }">
		<input type="hidden" name="STturn" value="${STturn }">
		
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
							<input type="radio" id="STturn_1" name="selSTturn" value="1" checked="checked">
						</c:when>
						<c:otherwise>
							<input type="radio" id="STturn_1" name="selSTturn" value="1">
						</c:otherwise>
					</c:choose><label for="STturn_1">1 회</label> &nbsp;&nbsp;
					
					<c:choose>
						<c:when test="${STturn == 2}">
							<input type="radio" id="STturn_2" name="selSTturn" value="2" checked="checked">
						</c:when>
						<c:otherwise>
							<input type="radio" id="STturn_2" name="selSTturn" value="2">
						</c:otherwise>
					</c:choose><label for="STturn_2">2 회</label> &nbsp;&nbsp;
					
					<c:choose>
						<c:when test="${STturn == 3}">
							<input type="radio" id="STturn_3" name="selSTturn" value="3" checked="checked">
						</c:when>
						<c:otherwise>
							<input type="radio" id="STturn_3" name="selSTturn" value="3">
						</c:otherwise>
					</c:choose><label for="STturn_3">3 회</label> &nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<th>제 목</th>
				<td>
					<c:if test="${not empty mVO }">
					<select name="selMovie">
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
			<input type="submit" value="수정">
			<input type="reset" value="취소">
			<input type="button" value="목록" onclick="location.href='../admin/admin_ScreenSet.do?CmdMgr=SSet_LIST'">
		</form> 
	</div>
 	</c:if>
 	
 	
 	<c:if test="${CmdMgr eq 'SSet_INSERT_FORM' }">
	<div id="wrap" align="center">
		<h1>입  력</h1>
		
		<form method="post" action="../admin/admin_ScreenSet.do">
		<input type="hidden" name="CmdMgr" value="SSet_INSERT">
		<input type="hidden" name="selDate" value="${selDate }">
		
		<table style="width: 80%" border="1">
			<tr>
				<th style="width: 120px">상영 일</th>
				<td>${selDate }</td>
			</tr>
			<tr>
				<th>상영 회차</th>
				<td>
					<%--
						 ${STturnArr[0]}, ${STturnArr[1] }, ${STturnArr[2] }
					 \${STturnArr[0] eq '0' } = ${STturnArr[0] eq '0' }
					\${STturnArr[1] eq '0' } = ${STturnArr[1] eq '0' }
					\${STturnArr[2] eq '0' } = ${STturnArr[2] eq '0' } --%>
				
					<%-- <c:choose>
						<c:when test="${not empty STturnArr }">
							
							<c:choose>
								<c:when test="${STturnArr[0] eq '0' }">
									<input type="radio" id="STturn_1" name="selSTturn" value="1" >
									<label for="STturn_1">1 회</label> &nbsp;&nbsp;
								</c:when>
								<c:otherwise>
									<input type="radio" id="STturn_1" name="selSTturn" value="1" disabled="disabled">
									<label for="STturn_1">1 회</label> &nbsp;&nbsp;
								</c:otherwise>
								
								
								<c:when test="${STturnArr[1] eq '0' }">
									<input type="radio" id="STturn_2" name="selSTturn" value="2" >
									<label for="STturn_2">2 회</label> &nbsp;&nbsp;
								</c:when>
								<c:otherwise>
									<input type="radio" id="STturn_2" name="selSTturn" value="2" disabled="disabled">
									<label for="STturn_2">2 회</label> &nbsp;&nbsp;
								</c:otherwise>
								
								
								<c:when test="${STturnArr[2] eq '0' }">
									<input type="radio" id="STturn_3" name="selSTturn" value="3">
									<label for="STturn_3">3 회</label> &nbsp;&nbsp;
								</c:when>
								<c:otherwise>
									<input type="radio" id="STturn_3" name="selSTturn" value="3" disabled="disabled">
									<label for="STturn_3">3 회</label> &nbsp;&nbsp;
								</c:otherwise>
							</c:choose>
							
							
						</c:when>
						<c:otherwise> --%>
						
							<input type="radio" id="STturn_1" name="selSTturn" value="1">
							<label for="STturn_1">1 회</label> &nbsp;&nbsp;
							
							<input type="radio" id="STturn_2" name="selSTturn" value="2">
							<label for="STturn_2">2 회</label> &nbsp;&nbsp;
							
							<input type="radio" id="STturn_3" name="selSTturn" value="3">
							<label for="STturn_3">3 회</label> &nbsp;&nbsp;
						
						<%-- </c:otherwise>					
					</c:choose>  --%>
				
				</td>
			</tr>
			<tr>
				<th>제 목</th>
				<td>
					<c:if test="${not empty mVO }">
					<select name="selMovie">
					<c:forEach var="mVO" items="${mVO }">				
						<option value="${mVO.MCODE }" >${mVO.TITLE }</option>
					</c:forEach>
					</select>
					</c:if>
				</td>
			</tr>
		</table>
		
		<br>
			<input type="submit" value="입력">
			<input type="reset" value="취소">
			<input type="button" value="목록" onclick="location.href='../admin/admin_ScreenSet.do?CmdMgr=SSet_LIST'">
		</form> 
	</div>
 	</c:if>
<%@include file="/com/footer.jsp" %>