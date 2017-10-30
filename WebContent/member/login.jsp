<%-- 로그인 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- 정적 인클루드 --%>
<%@include file="/com/header.jsp"%>

<form action="../member/member.do" method="post">

	<!-- 
기능이 적용이 안됨
<script type="text/javascript">

function loginCheck() {
	// MID의 길이 값이 0이면 출력되는 문
	if (document.loginValue.MID.value.length == 0) {
		alert("아이디를 써주세요");		
		loginValue.MID.focus();
		return false;
	}
	// 암호를 입력하지 않았을때 나오는 출력문
	if (document.loginValue.Mpwd.value == "") {
		alert("암호는 반드시 입력하셔야 합니다.");
		loginValue.Mpwd.focus();
		return false;
	}
</script> 
->

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
</form>

<div class="" align="center">
	<a href="../member/findid.jsp" style="margin-top: 10px">아이디 찾기</a> 
	<a href="../member/findpw.jsp" style="margin-top: 10px">비밀번호 찾기</a> 
	<a href="../member/Membership.jsp" style="margin-top: 10px">회원가입</a>
</div>

<%@include file="/com/footer.jsp"%>