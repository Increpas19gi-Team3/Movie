<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="com.movie03.dto.ReserveVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@include file="/com/header.jsp" %>
   



<div id="wrap" align="center">
		<h1>영화 예매</h1>
		<br>
		<%
			HashMap<String, Object> respModel = (HashMap<String, Object>)request.getAttribute("respModel");
			List<ReserveVO> mVo = (List<ReserveVO>)respModel.get("reserveList");
			pageContext.setAttribute("mVo", mVo);
		%>
		<form name="frm" method="post" action="/Movie/Reserve.do">
			<input type="hidden" name="id" value="<%=session.getAttribute("MID")%>">
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
					<th>상영회차 : </th>
					<td><input type="text" name=rtime value="<%=request.getParameter("rtime")%>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>좌석정보 : </th>
					<td>
						<input type="text" name=seat value="<%=request.getParameter("seat")%>" readonly="readonly">
					</td>
				</tr>
			</table>
			<br>
			<br> 
			<input type="button" value="확인" onclick="location.href='MovieServlet.do'">
		</form>
	</div>


<%@include file="/com/footer.jsp" %>