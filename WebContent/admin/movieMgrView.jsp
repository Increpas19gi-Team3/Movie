<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.movie03.dto.MovieVO" %>

<%-- 정적 인클루드 --%>
<%@include file="/com/header_Admin.jsp" %>
<%
	HashMap<String, Object> respModel = (HashMap<String, Object>)request.getAttribute("respModel");
	MovieVO mVO = (MovieVO)respModel.get("MgrViewMovie");
	pageContext.setAttribute("mVO", mVO);
	
	String cmd = (String)respModel.get("CmdMgr");
	if(cmd != null){
		pageContext.setAttribute("CmdMgr", "Movie_VIEW");
	}else{
		pageContext.setAttribute("CmdMgr", cmd);
	}
	
	// 리스트로 되돌아가기 위한 검색,정렬 조건들
	String SearchGubun = (String)respModel.get("SearchGubun");
	String SearchWord = (String)respModel.get("SearchWord");
	String Sort = (String)respModel.get("Sort");
	pageContext.setAttribute("SearchGubun", SearchGubun);
	pageContext.setAttribute("SearchWord", SearchWord);
	pageContext.setAttribute("Sort", Sort);
%>
<p>

	<div id="wrap" align="center">
	<h1>상  세   보  기</h1>
		<c:if test="${not empty mVO }">
		<table style="width: 80%" border="1">
			<tr>
				<td>
					<c:choose>
					<c:when test="${empty mVO.POSTER}">
					<img src="images/noimage.png">
					</c:when>
					<c:otherwise>
					<img src="../image/${mVO.POSTER}" width="200" height="300">
					</c:otherwise>
					</c:choose>
				</td>
				
				<td>
				<table>
					<tr>
						<th style="width: 120px">제  목</th>
						<td>${mVO.TITLE }</td>
						</tr>
					<tr>
						<th>가 격</th>
						<td>${mVO.PRICE } 원</td>
						</tr>
					<tr>
						<th>감 독</th>
						<td>${mVO.DIRECTOR }</td>
					</tr> 
					<tr>
						<th>배 우</th>
						<td>${mVO.ACTOR }</td>
					</tr>
					<tr>
						<th>개봉일</th>
						<td>${mVO.OPENDAY }</td>
					</tr>
					<tr>
						<th>장 르</th>
						<td>${mVO.GENRE }</td>
					</tr>
					<tr>
						<th>시놉시스</th>
						<td>${mVO.SYNOPSIS }</td>
					</tr>
					<tr>
						<th>상영 시작일</th>
						<td>${mVO.STARTDAY }</td>
					</tr>
					<tr>
						<th>상영 종료일</th>
						<td>${mVO.ENDDAY }</td>
					</tr>
					<tr>
						<th>평 점</th>
						<td>${mVO.APPRAISAL }</td>
					</tr>
				</table> 
			
				</td>
			</tr>
		</table>
		</c:if>
		
		<br>
		<form method="post" action="">	  
			<input type="button" value="목록" onclick="location.href='../admin/admin_Movie.do?CmdMgr=Movie_LIST&SearchGubun=${SearchGubun}&SearchWord=${SearchWord}&Sort=${Sort}'">
			<input type="button" value="수정" onclick="location.href='../admin/admin_Movie.do?CmdMgr=Movie_UPDATE_FORM&&MCODE=${mVO.MCODE}'">
			<input type="button" value="삭제" onclick="location.href='../admin/admin_Movie.do?CmdMgr=Movie_DELETE&&MCODE=${mVO.MCODE}'">
		</form> 
	</div>
 






	

<%@include file="/com/footer.jsp" %>