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
		<div class ="theather_reg" style="text-align: center; padding: 30px 50px 30px 50px;">
			
			
			<form action="thumbnail.jsp" method="post" >
			상품명 : <input type="text" name="pname"><p>
			판매수량 : <input type="text" name="pqty"><p>
			이미지 파일 : <input type="file" name="filename"><p>
			<input type="submit" value="전송">
		</form>
			
			
			
			<form action="../admin/admin_Theater.do" method="post" enctype="multipart/form-data">
				<input type="hidden" name = "AdminTheater" value="UPDATE">
				<input type="hidden" name = "TheaterTCODE" value="T01">
				<label> 이름 </label> <input type="text" name="TheaterTNAME"><p>
				<label> 위치 </label> <input type="text" name="TheaterTNAME"><p>
				<label> 소개 </label> <input type="text" name="TheaterTNAME"><p>
				<label> 사진 </label> <input type="text" name="TheaterTNAME"><p>
				<label> 극장 이름 </label> <input type="text" name="TheaterTNAME"><p>
				
				
				
				<input type="submit" value="영화관 정보 등록" />
			</form>
		</div>
	</div>

<%@include file="/com/footer.jsp" %>