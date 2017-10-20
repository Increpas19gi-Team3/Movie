<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.movie03.dto.MovieVO" %>
<%-- 정적 인클루드 --%>
<%@include file="/com/header_Admin.jsp" %>
<%
	HashMap<String, Object> respModel = (HashMap<String, Object>)request.getAttribute("respModel");
	ArrayList<MovieVO> mVO = (ArrayList<MovieVO>)respModel.get("MgrListMovie");
	pageContext.setAttribute("mVO", mVO);
	
	String cmd = (String)respModel.get("CmdMgr");
	pageContext.setAttribute("cmd", cmd);
	
	String SearchGubun = "";
	if((String)respModel.get("SearchGubun") != null) SearchGubun = (String)respModel.get("SearchGubun");
	String SearchWord = "";
	if((String)respModel.get("SearchWord") != null) SearchWord = (String)respModel.get("SearchWord");
	
	String Sort = "";
	if((String)respModel.get("Sort") != null) Sort = (String)respModel.get("Sort");
%>


	<div class = "">
	
		<form action="../admin/admin_Movie.do" method="post">
			<input type="hidden" name = "CmdMgr" value="Movie_INSERT_FORM">
			<input type="submit" value="영화 등록">
		</form>
		
		<hr>
	
		<table border="1">
			<tr>
				<th>포스터</th>
				<th>제목</th>
				<th>감독</th>
				<th>배우</th>
				<th>장르</th>
				<th>상영 시작일</th>
				<th>상영 종료일</th>
				<th>평점</th>
			</tr>
	
			<c:if test="${not empty mVO }">
				<c:forEach var="mVO" items="${mVO }">
				<tr>
					<td><img src="../image/sm_${mVO.POSTER }"></td>
					<td><a href="../admin/admin_Movie.do?SearchGubun=&SearchWord=&Sort='ASC'">${mVO.TITLE }</a></td>
					<td>${mVO.DIRECTOR }</td>
					<td>${mVO.ACTOR }</td>
					<td>${mVO.GENRE }</td>
					<td>${mVO.STARTDAY }</td>
					<td>${mVO.ENDDAY }</td>
					<td>${mVO.APPRAISAL }</td>
				</tr>
				</c:forEach>
			</c:if>
		</table>
		
		<form action="../admin/admin_Movie.do" method="post">
			<select name="SearchGubun">
				<option value="TITLE">제목</option>
				<option value="DIRECTOR">감독</option>
				<option value="ACTOR">배우</option>
				<option value="GENRE">장르</option> 
			</select>
			<input type="text" name="SearchWord" />
			<input type="submit" value="검색">
		</form>
		
	</div>

영화 정보 관리	- 리스트, 등록버튼, 검색, 정렬

	

<%@include file="/com/footer.jsp" %>