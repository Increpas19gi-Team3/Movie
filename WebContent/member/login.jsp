<%-- 로그인 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- 정적 인클루드 --%>
<%@include file="/com/header.jsp"%>

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
					<td>
					<input type="radio" style="margin-top: 10px"
						name="Madmin" value="0">관리자 
					<input type="radio"	style="margin-top: 10px" 
						name="Madmin" value="1" checked="checked">일반인
					</td>
				</tr>
			</table>					
		</div>

		<div class="row">
			<input type="submit" style="margin-top: 20px" name="loginbutton" value="로그인"
				onclick="return input_login()">
		</div>
	</div>

	<div class="" align="center">
		<a href="findid.jsp" style="margin-top: 10px">아이디 찾기</a> 
		<a href="findpw.jsp" style="margin-top: 10px">비밀번호 찾기</a> 
		<a href="join.jsp" style="margin-top: 10px">회원가입</a>
	</div>

	<script type="text/javascript">
		function input_login() {
			var id = document.getElementById('MID').value;
			var pw = document.getElementById('Mpwd').value;

			if (MID == null || MID == "") {
				alert("아이디를 입력 하세요.");
				return false;
			} else if (Mpwd == null || Mpwd == "") {
				alert("패스워드를 입력 하세요.")
				return false;
			} else {
				return true;
			}
		}
	</script>
</form>

<%@include file="/com/footer.jsp"%>


