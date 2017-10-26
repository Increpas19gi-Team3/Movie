<%-- 로그인 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- 정적 인클루드 --%>
<%@include file="/com/header.jsp"%>

<script type="text/javascript" src="script/member.js"></script>

<form action="../member/member.do" method="post">
	<!-- Login는 key값 loginValue는.. -->
	<input type="hidden" name="Login" value="loginValue">
	<div class="" align="center">
		<h2>로그인</h2>
		<br> <br>

		<div class="log">
			<input type="text" style="margin-top: 10px" name="MID"
				placeholder="아이디" maxlength="20">
		</div>

		<div class="row">
			<input type="password" style="margin-top: 10px" name="Mpwd"
				placeholder="비밀번호" maxlength="15">
		</div>

		<div class="row">
			<table>
				<tr>
					<td><input type="radio" style="margin-top: 10px" name="Madmin"
						value="0">관리자 <input type="radio" style="margin-top: 10px"
						name="Madmin" value="1" checked="checked">일반인</td>
				</tr>
			</table>
		</div>

		<div class="row">
			<input type="submit" style="margin-top: 20px" name="loginbutton"
				value="로그인" onclick="return loginCheck()">
		</div>
	</div>

	<div class="" align="center">
		<a href="findid.jsp" style="margin-top: 10px">아이디 찾기</a> <a
			href="findpw.jsp" style="margin-top: 10px">비밀번호 찾기</a> <a
			href="join.jsp" style="margin-top: 10px">회원가입</a>
	</div>
</form>

<%@include file="/com/footer.jsp"%>


