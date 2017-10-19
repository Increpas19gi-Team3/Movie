<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.movie03.dto.TheaterVO" %>

<%-- 정적 인클루드 --%>
<%@include file="/com/header_Admin.jsp" %>

	
	<div class ="theater">
		<div class = "logo">
			극장 정보 입력
			<hr>
		</div>
		
		
		<div class ="theather_reg" style="text-align: left; padding: 30px 50px 30px 50px;">
			<form action="../admin/admin_Theater.do" method="post">
				<input type="hidden" name = "AdminTheater" value="UPDATE">
				<input type="hidden" name = "TheaterTCODE" value="T01">
				<label> 이름 </label> <input type="text" name="TheaterTNAME"><p>
				<label> 위치 </label> <input type="text" name="TheaterTLOCAL"><p>
				<label> 소개 </label> <input type="text" name="TheaterTDESC"><p>
				
				<input type="submit" value="등록" />
				<input type="reset">
			</form>
		</div>
		
		
		Multipart 용 <br>
		<div class ="theather_reg" style="text-align: left; padding: 30px 50px 30px 50px;">
			<form action="../admin/admin_Theater.do" method="post" enctype="multipart/form-data">
				<input type="hidden" name = "AdminTheater" value="UPDATE">
				<input type="hidden" name = "TheaterTCODE" value="T01">
				<label> 이름 </label> <input type="text" name="TheaterTNAME"><p>
				<label> 위치 </label> <input type="text" name="TheaterTLOCAL"><p>
				<label> 소개 </label> <input type="text" name="TheaterTDESC"><p>
				<label> 사진 </label> <input type="file" name="TheaterTIMAGE"><p>
				
				<input type="submit" value="등록" />
				<input type="reset">
			</form>
		</div>
	</div>

<%@include file="/com/footer.jsp" %>