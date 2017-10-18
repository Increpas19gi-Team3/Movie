<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.movie03.dto.TheaterVO" %>

<%-- 정적 인클루드 --%>
<%@include file="/com/header_Admin.jsp" %>


admin_Theater.jsp

극장 정보 관리	리스트	
	상세보기	극장이름, 극장 위치
	수정	
<br />

<%
	HashMap<String, Object> respModel = (HashMap<String, Object>)request.getAttribute("respModel");
	//respModel.get("CmdAdmin:Theater");// request 객체로 가져온 데이터
	//System.out.println("respModel 데이터:"+respModel.get("CmdAdmin:Theater"));

	TheaterVO theaterVo = (TheaterVO)respModel.get("CmdAdmin:Theater");//1개 행이라 바로 받음
	
%>

<p /><p/ >

	<%= theaterVo.getTCODE() %><br />
	<%= theaterVo.getTNAME() %> <br />
	<%= theaterVo.getTLOCAL() %> <br />
	<%= theaterVo.getTDESC() %> <br />
	<%= theaterVo.getTIMAGE() %> <br />
	

<%@include file="/com/footer.jsp" %>