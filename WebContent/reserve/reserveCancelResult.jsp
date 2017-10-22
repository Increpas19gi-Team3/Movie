<%@page import="com.movie03.dto.ReserveVO"%>
<%@page import="com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException"%>
<%@page import="com.movie03.dto.SeatVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@include file="/com/header.jsp" %>

<link rel="stylesheet" type="text/css" href="css/shopping.css">

	<div id="wrap" align="center">
		<form name="frm" method="post" action="/Movie/reserveCon.do?userID=${sessionScope.MID}">
			<table>
				<tr>
					<th>예매번호 : </th>
					<td><input type="text" name="rcode" value="<%=request.getParameter("rcode")%>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>영화제목 : </th>
					<td><input type="text" name="title" value="<%=request.getParameter("title")%>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>상영날짜 : </th>
					<td>
					<input type="date" name="rday" value="<%=request.getParameter("rday")%>" readonly="readonly">  
					</td>
				</tr>
				<tr>
					<th>상영회차 : </th>
					<td><input type="text" name="turn" value="<%=request.getParameter("turn")%>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>상영시간 : </th>
					<td><input type="text" name="rtime" value="<%=request.getParameter("rtime")%>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>좌석 : </th>
					<td><input type="text" name="seat" value="<%=request.getParameter("seat")%>" readonly="readonly"></td>
				</tr>
			<tr></tr>

			</table>
			<br>
			<p align="center">취소 완료 됐습니다</p>
			<br>
			<input type="submit" value="확인" >
			<br>
			</form>
	</div>
<%@include file="/com/footer.jsp" %>