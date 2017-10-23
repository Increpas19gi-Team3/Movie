<%-- 로그인 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.movie03.dto.MemberVO"%>

<%-- 정적 인클루드 --%>
<%@include file="/com/header.jsp"%>

    <div class="MemberDAO.java" align="center">
      <h2>로그인</h2>
        <div class="log">
          <input type="text" style = "margin-top : 10px" name=MID value="" id="MID" placeholder="아이디" maxlength="20" >
        </div>
        <div class="row">
          <input type="password" style = "margin-top : 10px" name="MPWD" value="" id="MPWD" placeholder="비밀번호" maxlength="15">
        </div>
        <div class="row">
          <input type="submit" style = "margin-top : 20px" name="" value="로그인" onclick="return input_login()">
        </div>
    </div>
      <div class="MemberDAO.java" align="center">
        <a href="findid.jsp" style = "margin-top : 10px">아이디 찾기</a>
        <a href="findpw.jsp" style = "margin-top : 10px">비밀번호 찾기</a>
        <a href="join.jsp" style = "margin-top : 10px">회원가입</a>
        <a href="#" style = "margin-top : 10px">회원탈퇴</a>
        </div>

<%@include file="/com/footer.jsp"%>

	<script type="text/javascript">
	function input_login(){
		var id = document.getElementById('MID').value;
		var pw = document.getElementById('MPWD').value;
		
		if(MID == null || MID == ""){
			alert("아이디를 입력 하세요.");
			return false;
		}
		else if(MPWD == null || MPWD == ""){
				alert("패스워드를 입력 하세요.")
				return false;
		}
		else{
			return true;
		}
	}	
	</script>
