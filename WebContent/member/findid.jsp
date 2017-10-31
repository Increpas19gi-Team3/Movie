<%-- 아이디 찾기 --%>
<%-- 정적 인클루드 --%>
<%@ include file="/com/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<div id="log" class="" align="center">
	<h2>아이디 찾기</h2>
	<br><br>
	
	<form id="log" method="post" action="../member/findid.do">
	<input type="hidden" name="findid">	
		<div id="log">
			<input type="text" style="margin-top: 10px" name=Mname placeholder="이름" maxlength="20">
		</div>
		
		<div id="log">
			<input type="text" style="margin-top: 10px" name=Memail placeholder="이메일" maxlength="15">
		</div>
		
		<div id="log">
			<input type="text" style="margin-top: 10px" name=Mtel placeholder="전화번호" maxlength="15">
		</div>
		
		<div id="log">
			<input type="submit" style="margin-top: 20px" value="확인">
			<input type="reset" style="margin-top: 20px" value="취소">
		</div>
	</form>
</div>

<%@include file="/com/footer.jsp"%>