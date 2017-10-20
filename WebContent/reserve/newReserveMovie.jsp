<%@page import="com.movie03.dto.ScreenTurnVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@include file="/com/header.jsp" %>

<div id="wrap" align="center">
		<h1>영화 예매</h1>
		<br>
		<%
			HashMap<String, Object> respModel = (HashMap<String, Object>)request.getAttribute("respModel");
			List<ScreenTurnVO> mVo = (List<ScreenTurnVO>)respModel.get("movieList");
			pageContext.setAttribute("mVo", mVo);
			for(int i=0; i<mVo.size(); i++){
				System.out.println("test : " +mVo.get(i).getSTturn());
			}
		%>
		<form name="frm" method="post" action="/Movie/reserveSeat.do">
			<table>
				<tr>
					<th>영화제목 : </th>
					<td><input type="text" name="title" value="<%=request.getParameter("title")%>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>상영관 : </th>
					<td><input type="text" name="screan" value="1관" readonly="readonly"></td>
				</tr>
				<tr>
					<th>상영날짜 : </th>
					<td><input type="text" name="rday" value="<%=request.getParameter("rday")%>" readonly="readonly"></td>
				</tr>					
				<tr>
					<th>상영시간 : </th>
					<td>
						<c:forEach var="turn" items="${mVo}">
							<c:choose>
    						<c:when test="${turn.STturn eq '1'}">
   								<input type="radio" size="70" name="rtime" value="12"	checked="checked">12시
							</c:when>
							<c:when test="${turn.STturn eq '2'}">
   								<input type="radio" size="70" name="rtime" value="16"	>16시
							</c:when>
							<c:when test="${turn.STturn eq '3'}">
   								<input type="radio" size="70" name="rtime" value="20"	>20시
							</c:when>
							</c:choose>
						</c:forEach>
					</td>
				</tr>
				
			</table>
			<br>
			<br> 
			<input type="submit" value="좌석선택" > 
			
		</form>
	</div>
	
	
<%@include file="/com/footer.jsp" %>