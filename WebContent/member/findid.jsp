<%-- 아이디 찾기 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.movie03.dto.MemberVO"%>
   
<%-- 정적 인클루드 --%>
<%@include file="/com/header.jsp"%>


<link rel="stylesheet" type="text/css" href="css/shopping.css">
<div id = "log" class = "MemberDAO.java" align="center">
<h2>아이디 찾기</h2>
<form id = "log" method="post" action="">
 <div id ="log">
          <input type="text" style = "margin-top : 10px" name=MNAME value="" id="MNAME" placeholder="이름" maxlength="20" >
        </div>
        <div  id ="log">
          <input type="text" style = "margin-top : 10px" name=MTEL value="" id="MTEL" placeholder="이메일" maxlength="15">
        </div>
        <div id ="log">
          <input type="text" style = "margin-top : 10px" name=MEMAIL value="" id="MEMAIL" placeholder="전화번호" maxlength="15">
        </div>
        <div id ="log">
          <input type="submit" style = "margin-top : 20px" name="" value="확인">
          <input type="submit" style = "margin-top : 20px" name="" value="뒤로가기">
          
        </div>

</form>
</div>
<%@include file="/com/footer.jsp"%>