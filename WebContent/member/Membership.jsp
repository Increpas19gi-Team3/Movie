<%-- 정적 인클루드 --%>
<%@include file="/com/header.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<div class="" align="center">
	<h2>회원가입</h2>
	<br>
	
	<form action="../member/Membership.do" method="post" >
	<input type="hidden" name="Membership">

		<div class="log">
			<input type="text" style="margin-top: 10px" name=MID value=""
				id="MID" placeholder="아이디" maxlength="20">
		</div>

		<div class="log">
			<input type="text" style="margin-top: 10px" name=Mpwd value=""
				id="MPWD" placeholder="비밀번호" maxlength="20">
		</div>

		<div class="log">
			<input type="text" style="margin-top: 10px" name=Mname value=""
				id="MNAME" placeholder="이름" maxlength="20">
		</div>

		<div class="log">
			<input type="text" style="margin-top: 10px" name=Memail value=""
				id="MEMAIL" placeholder="이메일" maxlength="15">
		</div>

		<div class="log">
			<input type="text" style="margin-top: 10px" name=Mtel value=""
				id="MTEL" placeholder="전화번호" maxlength="15">
		</div>
		
		<div class="row">
			<table>
				<tr>
					<td>
					<input type="radio" style="margin-top: 10px" 
					name="Madmin" value="0">관리자 
					<input type="radio" style="margin-top: 10px" 
					name="Madmin" value="1" checked="checked">일반인
					</td>
				</tr>
			</table>
		</div>

		<div class="log">
			<input type="submit" style="margin-top: 20px" value="확인" onclick="return input_check_func()">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="취소">
		</div>
	</form>
	
	<script type="text/javascript">
	function input_check_func() {
		
		var id = document.Membership.getElementById('MID').value;
		var pw = document.Membership.getElementById('Mpwd').value;
		var nm = document.Membership.getElementById('Mname').value;
		var ph = document.Membership.getElementById('Mtel').value;
		var em = document.Membership.getElementById('Memail').value;

		if (id == null || id == "") {
			alert("아이디를 입력하셔야 합니다.");
			return false;
		} else if (pw == null || pw == "") {
			alert("패스워드를 입력하셔야 합니다.");
			return false;
		} else if (nm == null || nm == "") {
			alert("이름을 입력하셔야 합니다.");
			return false;
		}
		
		regNumber = /^[0-9]*$/;

		if (regNumber.test(nm)) {
			alert('이름은 한글이나 영어로만 쓰셔야 합니다.');
			return false;
		} else if (ph == null || ph == "") {
			alert("핸드폰번호를 입력하셔야 합니다.");
			return false;
		} else if (em == null || em == "") {
			alert("이메일을 입력하셔야 합니다.");
			return false;
		}
		
		regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

		if (!regEmail.test(em)) {
			alert('이메일 주소가 올바르지 않습니다.');
			return false;
		} else {
			return true;
		}
	}
	</script>
</div>

<%@include file="/com/footer.jsp"%>