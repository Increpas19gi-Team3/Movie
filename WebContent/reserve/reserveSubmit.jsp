<%@page import="com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException"%>
<%@page import="com.movie03.dto.SeatVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@include file="/com/header.jsp" %>

<div id="wrap" align="center">
		<h1>영화 예매</h1>

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
					<td><input type="text" name="rtime" value="<%=request.getParameter("rtime")%>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>좌석정보 : </th>
					<td>
						<%
							String[] info = request.getParameterValues("seat");
							String seat = null;
							for(int i=0; i<info.length; i++){
								if(i==0)
									seat = info[i];
								else
									seat = seat + "," + info[i];
							}
						%>
						<input  type="text" name="seat" value="<%=seat%>" readonly="readonly">						
					</td>
				</tr>
			</table>
			<br>
			<br> 

			<p> 위 정보로 예약하시겠습니까?</p><br>
			<input type="submit" value="확인" > 
			<input type="button" value="취소" onclick="location.href='/Movie/MovieServlet.do'">
			<br>
			<br> 
		</form>
	</div>
	
	
<%@include file="/com/footer.jsp" %>