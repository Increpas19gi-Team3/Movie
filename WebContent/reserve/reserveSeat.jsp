<%@page import="com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException"%>
<%@page import="com.movie03.dto.SeatVO"%>
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
			List<SeatVO> mVo = (List<SeatVO>)respModel.get("seatList");
			pageContext.setAttribute("mVo", mVo);
		%>
		<form name="frm" method="post" action="/Movie/reserve/reserveSubmit.jsp">
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
						
						<c:forEach var="list" items="${mVo}">
							<c:choose>
    							<c:when test="${list.SSEAT eq 'A01'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="A01" >A01
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="A01" disabled="disabled" >A01
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'A02'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="A02" >A02
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="A02" disabled="disabled" >A02
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'A03'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="A03" >A03
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="A03" disabled="disabled" >A03
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'A04'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="A04" >A04
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="A04" disabled="disabled" >A04
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'A05'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="A05" >A05<br>
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="A05" disabled="disabled" >A05<br>
   									</c:when>
   									</c:choose>	
								</c:when>
								
								
								
								<c:when test="${list.SSEAT eq 'B01'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="B01" >B01
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="B01" disabled="disabled" >B01
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'B02'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="B02" >B02
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="B02" disabled="disabled" >B02
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'B03'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="B03" >B03
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="B03" disabled="disabled" >B03
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'B04'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="B04" >B04
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="B04" disabled="disabled" >B04
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'B05'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="B05" >B05<br>
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="B05" disabled="disabled" >B05<br>
   									</c:when>
   									</c:choose>	
								</c:when>
								
								<c:when test="${list.SSEAT eq 'C01'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="C01" >C01
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="C01" disabled="disabled" >C01
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'C02'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="C02" >C02
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="C02" disabled="disabled" >C02
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'C03'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="C03" >C03
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="C03" disabled="disabled" >C03
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'C04'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="C04" >C04
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="C04" disabled="disabled" >C04
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'C05'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="C05" >C05<br>
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="C05" disabled="disabled" >C05<br>
   									</c:when>
   									</c:choose>	
								</c:when>
								
								<c:when test="${list.SSEAT eq 'D01'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="D01" >D01
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="D01" disabled="disabled" >D01
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'D02'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="D02" >D02
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="D02" disabled="disabled" >D02
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'D03'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="D03" >D03
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="D03" disabled="disabled" >D03
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'D04'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="D04" >D04
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="D04" disabled="disabled" >D04
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'D05'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="D05" >D05<br>
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="D05" disabled="disabled" >D05<br>
   									</c:when>
   									</c:choose>	
								</c:when>
								
								
								<c:when test="${list.SSEAT eq 'E01'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="E01" >E01
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="E01" disabled="disabled" >E01
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'E02'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="E02" >E02
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="E02" disabled="disabled" >E02
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'E03'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="E03" >E03
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="E03" disabled="disabled" >E03
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'E04'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="E04" >E04
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="E04" disabled="disabled" >E04
   									</c:when>
   									</c:choose>	
								</c:when>
								<c:when test="${list.SSEAT eq 'E05'}">
    								<c:choose>
    								<c:when test="${list.SSTATE eq '0'}">
   										<input type="checkbox" name="seat"  value="E05" >E05<br>
   									</c:when>
    								<c:when test="${list.SSTATE eq '1'}">
   										<input type="checkbox" name="seat"  value="E05" disabled="disabled" >E05<br>
   									</c:when>
   									</c:choose>	
								</c:when>
							</c:choose> 
							
							
						</c:forEach>
						<%-- <c:forEach begin="1" end="5" step="1" var="j">
    						<input type="checkbox" name="seat" value="A0${j}" >A0${j}
						</c:forEach>
						<br>
						<c:forEach begin="1" end="5" step="1" var="j">
    						<input type="checkbox" name="seat" value="B0${j}" >B0${j}
						</c:forEach>
						<br>
						<c:forEach begin="1" end="5" step="1" var="j">
							<input type="checkbox" name="seat" value="C0${j}" disabled="Check(${mVo});">C0${j}
						</c:forEach>
						<br>
						<c:forEach begin="1" end="5" step="1" var="j">
    						<input type="checkbox" name="seat" value="D0${j}" disabled="Check(${mVo});">D0${j}
						</c:forEach>
						<br>
						<c:forEach begin="1" end="5" step="1" var="j">
    						<input type="checkbox" name="seat" value="E0${j}" disabled="Check(${mVo});">E0${j}
						</c:forEach>
						<br> --%>
						
					</td>
				</tr>
			</table>
			<br>
			<br> 


			<input type="submit" value="예매" > 
			<input type="reset"  value="다시 작성"> 
			<input type="button" value="목록" onclick="location.href='MovieServlet.do'">
		</form>
	</div>
	
	
<%@include file="/com/footer.jsp" %>