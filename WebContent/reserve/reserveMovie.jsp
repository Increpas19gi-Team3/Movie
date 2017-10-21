<%@page import="com.movie03.dto.ScreenTurnVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@include file="/com/header.jsp" %>

<div id="wrap" align="center">
		<h1>영화 예매</h1>
		<br>

		<form name="frm" method="post" action="/Movie/reserveMovie.do">
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
					<td>
						<input type="date" name="rday" value="stdate"> 
						<input type="submit" value="선택"> 
					</td>
			</tr>
			<tr></tr>
			<tr></tr>
			</table>
			</form>
	</div>
	<br>
	<br>
	
	
<%@include file="/com/footer.jsp" %>