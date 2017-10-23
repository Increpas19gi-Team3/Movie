<%-- 회원가입 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.movie03.dto.MemberVO"%>
   
<%-- 정적 인클루드 --%>
<%@include file="/com/header.jsp"%>

<div class = "MemberDAO.java" align="center">
<h2>회원가입</h2>
<form method="post" action="/Movie/join.do">
 <div class="log">
          <input type="text" style = "margin-top : 10px" name=MID value="" id="MID" placeholder="아이디" maxlength="20" >
        </div>
         <div class="log">
          <input type="text" style = "margin-top : 10px" name=MPWD value="" id="MPWD" placeholder="비밀번호" maxlength="20" >
        </div>
         <div class="log">
          <input type="text" style = "margin-top : 10px" name=MNAME value="" id="MNAME" placeholder="이름" maxlength="20" >
        </div>
        <div class="log">
          <input type="text" style = "margin-top : 10px" name=MEMAIL value="" id="MEMAIL" placeholder="이메일" maxlength="15">
        </div>
        <div class="log">
          <input type="text" style = "margin-top : 10px" name=MTEL value="" id="MTEL" placeholder="전화번호" maxlength="15">
        </div>
        
        <div class="log">
          <input type="submit" style = "margin-top : 20px" name="" value="확인">
        </div>
        
</form>
</div>