<%-- 비밀번호 찾기 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.movie03.dto.MemberVO"%>
   
<%-- 정적 인클루드 --%>
<%@include file="/com/header.jsp"%>

<div class = "MemberDAO.java" align="center">
<h2>비밀번호 찾기</h2>
<form action="" method="post">
 <div class="log">
          <input type="text" style = "margin-top : 10px" name=MID value="" id="MID" placeholder="아이디" maxlength="20" >
        </div>
        <div class="log">
          <input type="text" style = "margin-top : 10px" name=MTEL value="" id="MTEL" placeholder="전화번호" maxlength="15">
        </div>
        <div class="log">
          <input type="text" style = "margin-top : 10px" name=MEMAIL value="" id="MEMAIL" placeholder="이메일" maxlength="15">
        </div>
        <div class="log">
          <input type="submit" style = "margin-top : 20px" name="" value="확인" onclick="">
        </div>

</form>
</div>
<%@include file="/com/footer.jsp"%>
