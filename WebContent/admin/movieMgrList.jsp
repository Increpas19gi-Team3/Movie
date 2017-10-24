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
	if(cmd != null){
		pageContext.setAttribute("CmdMgr", "Movie_LIST");
	}else{
		pageContext.setAttribute("CmdMgr", cmd);
	}
	
	
	String SearchGubun = (String)respModel.get("SearchGubun");
	String SearchWord = (String)respModel.get("SearchWord");
	String Sort = (String)respModel.get("Sort");
	String TitleSort = "";
	if(Sort != null){
		if(Sort.equals("DESC")) TitleSort = "ASC";
		else TitleSort = "DESC";
	}else{
		TitleSort = "ASC";
	}
	
	pageContext.setAttribute("SearchGubun", SearchGubun);
	pageContext.setAttribute("SearchWord", SearchWord);
	pageContext.setAttribute("Sort", Sort);
	pageContext.setAttribute("TitleSort", TitleSort);	
%>

	<div id="wrap" align="center">
	
		<form action="../admin/admin_Movie.do" method="post">
			<input type="hidden" name = "CmdMgr" value="Movie_INSERT_FORM">
			<input type="submit" value="영화 등록">
		</form>
		
		<hr>
	
		<table border="1" width="80%">
			<tr>
				<!-- <th>포스터</th> -->
				<th>
					<a href="../admin/admin_Movie.do?CmdMgr=Movie_LIST&SearchGubun=${SearchGubun}&SearchWord=${SearchWord}&Sort=${TitleSort}">제목
					<c:choose>
						<c:when test="${TitleSort eq 'ASC' }">▼</c:when>
						<c:otherwise>▲</c:otherwise>
					</c:choose>
					</a>
				</th>
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
					<%-- <td><img src="../image/sm_${mVO.POSTER }"></td> --%>
					<td>
						<a href="../admin/admin_Movie.do?CmdMgr=Movie_VIEW&SearchGubun=${SearchGubun}&SearchWord=${SearchWord}&Sort=${Sort}&MCODE=${mVO.MCODE}">${mVO.TITLE }</a>
					</td>
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
			<input type="hidden" name="CmdMgr" value="Movie_LIST">
			<input type="hidden" name="Sort" value="${Sort}">
		
			<select name="SearchGubun" >
				<%-- 검색조건 없이 검색어만 입력시 처리를 미구현 -> 해당 버그를 발생 시키지 않기 위해 해당 내용 주석처리함. 
				<c:if test="${fn:length(SearchWord) eq 0}">
					<option value="" selected="selected">선택하세요.</option>
				</c:if> --%>
				
				<c:choose>
					<c:when test="${SearchGubun eq 'TITLE' && fn:length(SearchWord) > 0}"><option value="TITLE" selected="selected">제목</option></c:when>
					<c:otherwise><option value="TITLE">제목</option></c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${SearchGubun eq 'DIRECTOR' && fn:length(SearchWord) > 0}"><option value="DIRECTOR" selected="selected">감독</option></c:when>
					<c:otherwise><option value="DIRECTOR">감독</option></c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${SearchGubun eq 'ACTOR' && fn:length(SearchWord) > 0}"><option value="ACTOR" selected="selected">배우</option></c:when>
					<c:otherwise><option value="ACTOR">배우</option></c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${SearchGubun eq 'GENRE' && fn:length(SearchWord) > 0}"><option value="GENRE" selected="selected">장르</option></c:when>
					<c:otherwise><option value="GENRE">장르</option></c:otherwise>
				</c:choose> 
				
			</select>
			
			<c:choose>
				<c:when test="${not empty SearchWord }"><input type="text" name="SearchWord" value="${SearchWord }"/></c:when>
				<c:otherwise><input type="text" name="SearchWord" /></c:otherwise>
			</c:choose>
			
			<input type="submit" value="검색">
		</form>
		
	</div>
	

<%@include file="/com/footer.jsp" %>