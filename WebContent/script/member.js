function loginCheck() {
	// MID의 길이 값이 0이면 출력되는 문
	if (document.loginValue.MID.value.length == 0) {
		alert("아이디를 써주세요");		
		loginValue.MID.focus();
		return false;
	}
	// 암호를 입력하시 않았을때 나오는 출력문
	if (document.loginValue.Mpwd.value == "") {
		alert("암호는 반드시 입력하셔야 합니다.");
		loginValue.Mpwd.focus();
		return false;
	}
	
// 사용가능
//===================================================================

	// 중복체크 페이지를 새로운 창으로 띄우기 위한 자바스크립트 함수
	function idCheck() {
		if (document.frm.userid.value == "") {
			alert("아이디를 입력하세요");
			document.frm.userid.focus();
			return;
		}
		var url = "idCheck.do?userid=" + document.frm.userid.value;
		window
				.open(url, "_blank_1",
						"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200")
	}// idCheck() End

	// 아이디 중복 체크 완료 처리를 위한 자바스크립트 함수
	function idok() {
		opener.frm.userid.value = document.frm.userid.value;
		opener.frm.reid.value = document.frm.userid.value;
		self.close();
	}// idok() End

	// 회원 정보의 유효성을 체크하기 위한 자바스크립트 함수
	function joinCheck() {

		if (document.frm.name.value.length == 0) {
			alert("이름을 써주세요");
			frm.name.focus();
			return false;
		}

		if (document.frm.userid.value.length == 0) {
			alert("아이디를 써주세요");
			frm.userid.focus();
			return false;
		}

		if (document.frm.userid.value.length < 4) {
			alert("4글자 이상이어야 합니다.");
			frm.userid.focus();
			return false;
		}

		if (document.frm.pwd.value == "") {
			alert("암호는 반드시 입력해야 합니다.");
			frm.pwd.focus();
			return false;
		}

		if (document.frm.pwd.value != document.frm.pwd_check.value) {
			alert("암호가 일치하지 않습니다.");
			frm.pwd.focus();
			return false;
		}

		if (document.frm.pwd.value != document.frm.pwd_check.value) {
			alert("중복 체크를 하지 않았습니다.");
			frm.userid.focus();
			return false;
		}
	} // joinCheck() End

	return ture;
}// loginCheck() End
