<%-- 아이디 찾기 --%>
<%@include file="/com/header.jsp"%>

<%@ page import="com.movie03.dto.MemberVO"%>
<%@ page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	HashMap<String, Object> respModel = (HashMap<String, Object>) request.getAttribute("respModel");
	MemberVO mVo = (MemberVO) respModel.get("mVo");
	pageContext.setAttribute("mVo", mVo);
%>

<div class="" style="margin-left: 30%;">
	<!-- forgetPw -->
	<%-- 
	\${mVo } : mVo<br /> 
	\${mVo.MID }: ${mVo.MID } <br /> 
	\${empty mVo.MID } : ${empty mVo.MID }<br /> 
	\${not empty mVo.MID } : ${not empty mVo.MID }<br />

	\${mVo.MID } : ${mVo.MID } <br /> 
	\${mVo.MPWD } : ${mVo.MPWD } <br />
	\${mVo.MNAME } : ${mVo.MNAME } <br /> 
	\${mVo.MEMAIL } : ${mVo.MEMAIL } <br /> 
	\${mVo.MTEL }: ${mVo.MTEL } <br /> 
	\${mVo.MADMIN }: ${mVo.MADMIN } <br /> 
	--%>

	<form class="" action="find.jsp" method="post">

		<h1>고객님의 ID는.. </h1>		
		<c:choose>
			<c:when test="${not empty mVo.MID}">
				<h2>'ID' : ${mVo.MID} 입니다.</h2>
			</c:when>
			<c:otherwise>
				<h2>'ID'를 찾을 수 없습니다.</h2>
			</c:otherwise>
		</c:choose>

		<h1>고객님의 비밀번호는..</h1>		
		<c:choose>
			<c:when test="${empty mVo.MPWD}">
				<h2>'Password'를 찾을 수 없습니다.</h2>
			</c:when>
			<c:otherwise>
				<h2>Password : ${mVo.MPWD} 입니다.</h2>
			</c:otherwise>
		</c:choose>
		<br /> <br />

		<div class="row">
			<input type="button" value="뒤로가기"
				onclick="location.href='../member/login.do?'">
		</div>
	</form>
</div>

<%@include file="/com/footer.jsp"%>