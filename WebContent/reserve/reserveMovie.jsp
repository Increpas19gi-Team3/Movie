<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@include file="/com/header.jsp" %>

<div id="wrap" align="center">
		<h1>영화 예매</h1>
		<br>
		<form name="frm" method="post" action="reserveMovie.do">
			<input type="hidden" name="command" value="board_write">
			<table>
				<tr>
					<th>영화제목 : </th>
					<td><input type="text" name="title" value="<%=request.getParameter("title")%>"></td>
				</tr>
				<tr>
					<th>상영관 : </th>
					<td><input type="text" name="screan" value="1관"></td>
				</tr>
				<tr>
					<th>상영날짜 : </th>
					<td>
						<input type="date" name="rday" value="zzz">
						<input type="button" value="선택" onclick="location.href='MovieServlet.do'"> 
					</td>
				</tr>
				<tr>
					<th>상영시간 : </th>
					<td>
						<input type="radio" size="70" name="rtime" value="12시" checked="checked">12시
						<input type="radio" size="70" name="rtime" value="16시">16시
						<input type="radio" size="70" name="rtime" value="20시">20시
					</td>
				</tr>
				<tr>
					<th>좌석정보 : </th>
					<td>
					<br>
						<input type="checkbox" name="seat"  value="A01">A01
						<input type="checkbox" name="seat"  value="A02">A02
						<input type="checkbox" name="seat"  value="A03">A03
						<input type="checkbox" name="seat"  value="A04">A04
						<input type="checkbox" name="seat"  value="A05">A05
						<br>
						<input type="checkbox" name="seat"  value="B01">B01
						<input type="checkbox" name="seat"  value="B02">B02
						<input type="checkbox" name="seat"  value="B03">B03
						<input type="checkbox" name="seat"  value="B04">B04
						<input type="checkbox" name="seat"  value="B05">B05
						<br>
						<input type="checkbox" name="seat"  value="C01">C01
						<input type="checkbox" name="seat"  value="C02">C02
						<input type="checkbox" name="seat"  value="C03">C03
						<input type="checkbox" name="seat"  value="C04">C04
						<input type="checkbox" name="seat"  value="C05">C05
						<br>
						<input type="checkbox" name="seat"  value="D01">D01
						<input type="checkbox" name="seat"  value="D02">D02
						<input type="checkbox" name="seat"  value="D03">D03
						<input type="checkbox" name="seat"  value="D04">D04
						<input type="checkbox" name="seat"  value="D05">D05
						<br>
						<input type="checkbox" name="seat"  value="E01">E01
						<input type="checkbox" name="seat"  value="E02">E02
						<input type="checkbox" name="seat"  value="E03">E03
						<input type="checkbox" name="seat"  value="E04">E04
						<input type="checkbox" name="seat"  value="E05">E05
						<br>
					</td>
				</tr>
			</table>
			<br>
			<br> 
			<input type="submit" value="등록" onclick="return boardCheck()"> 
			<input type="reset"  value="다시 작성"> 
			<input type="button" value="목록" onclick="location.href='MovieServlet.do'">
		</form>
	</div>
	
	
<%@include file="/com/footer.jsp" %>