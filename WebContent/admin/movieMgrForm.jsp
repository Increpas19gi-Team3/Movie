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
	pageContext.setAttribute("CmdMgr", cmd);
	
	
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
		<c:if test="${CmdMgr eq 'Movie_UPDATE_FORM' }"><h1>영  화   수  정</h1></c:if>
		<c:if test="${CmdMgr eq 'Movie_INSERT_FORM' }"><h1>영  화   입  력</h1></c:if>	
		
		<form action="../admin/admin_Movie.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name = "SearchGubun" value="${SearchGubun}">
			<input type="hidden" name = "SearchWord" value="${SearchWord}">
			<input type="hidden" name = "Sort" value="${Sort}">
						
			<c:if test="${not empty mVO }">
			<input type="hidden" name = "CmdMgr" value="Movie_UPDATE">
			<input type="hidden" name = "MCODE" value="${mVO.MCODE}">
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
						<input type="file" name="mvoPOSTER">
					</td>
					
					<td>
					<table>
						<tr>
							<th style="width: 120px">제  목</th>
							<td><input type="text" name="mvoTITLE" value="${mVO.TITLE }"></td>
						</tr>
						<tr>
							<th>가 격</th>
							<td><input type="text" name="mvoPRICE" value="${mVO.PRICE }"> 원</td>
							</tr>
						<tr>
							<th>감 독</th>
							<td><input type="text" name="mvoDIRECTOR" value="${mVO.DIRECTOR }"></td>
						</tr> 
						<tr>
							<th>배 우</th>
							<td><input type="text" name="mvoACTOR" value="${mVO.ACTOR }"></td>
						</tr>
						<tr>
							<th>개봉일</th>
							<td><input type="date" name="mvoOPENDAY" value="${mVO.OPENDAY }"></td>
						</tr>
						<tr>
							<th>장 르</th>
							<td><input type="text" name="mvoGENRE" value="${mVO.GENRE }"></td>
						</tr>
						<tr>
							<th>시놉시스</th>
							<td><textarea name="mvoSYNOPSIS"  rows="5" cols="50">${mVO.SYNOPSIS }</textarea>
						</tr>
						<tr>
							<th>상영 시작일</th>
							<td><input type="date" name="mvoSTARTDAY" value="${mVO.STARTDAY }"></td>
						</tr>
						<tr>
							<th>상영 종료일</th>
							<td><input type="date" name="mvoENDDAY" value="${mVO.ENDDAY }"></td>
						</tr>
						<tr>
							<th>평 점</th>
							<td>
								
								<c:choose>
									<c:when test="${mVO.APPRAISAL == 1}">
										<input type="radio" id="APPRAISAL_1" name="mvoAPPRAISAL" value="1" checked="checked">
									</c:when>
									<c:otherwise>
										<input type="radio" id="APPRAISAL_1" name="mvoAPPRAISAL" value="1">
									</c:otherwise>
								</c:choose><label for="APPRAISAL_1">1 점</label> &nbsp;&nbsp;
								
								<c:choose>
									<c:when test="${mVO.APPRAISAL == 2}">
										<input type="radio" id="APPRAISAL_2" name="mvoAPPRAISAL" value="2" checked="checked">
									</c:when>
									<c:otherwise>
										<input type="radio" id="APPRAISAL_2" name="mvoAPPRAISAL" value="2">
									</c:otherwise>
								</c:choose><label for="APPRAISAL_2">2 점</label> &nbsp;&nbsp;
								
								<c:choose>
									<c:when test="${mVO.APPRAISAL == 3}">
										<input type="radio" id="APPRAISAL_3" name="mvoAPPRAISAL" value="3" checked="checked">
									</c:when>
									<c:otherwise>
										<input type="radio" id="APPRAISAL_3" name="mvoAPPRAISAL" value="3">
									</c:otherwise>
								</c:choose><label for="APPRAISAL_3">3 점</label> &nbsp;&nbsp;
								
								<c:choose>
									<c:when test="${mVO.APPRAISAL == 4}">
										<input type="radio" id="APPRAISAL_4" name="mvoAPPRAISAL" value="4" checked="checked">
									</c:when>
									<c:otherwise>
										<input type="radio" id="APPRAISAL_4" name="mvoAPPRAISAL" value="4">
									</c:otherwise>
								</c:choose><label for="APPRAISAL_4">4 점</label> &nbsp;&nbsp;
								
								<c:choose>
									<c:when test="${mVO.APPRAISAL == 5}">
										<input type="radio" id="APPRAISAL_5" name="mvoAPPRAISAL" value="5" checked="checked">
									</c:when>
									<c:otherwise>
										<input type="radio" id="APPRAISAL_5" name="mvoAPPRAISAL" value="5">
									</c:otherwise>
								</c:choose><label for="APPRAISAL_5">5 점</label> &nbsp;&nbsp;
								
							</td>
						</tr>
					</table> 
				
					</td>
				</tr>
			</table>
			</c:if>
			
			
			<c:if test="${CmdMgr eq 'Movie_INSERT_FORM' }">
				<input type="hidden" name = "CmdMgr" value="Movie_INSERT">
				<table style="width: 80%" border="1">
					<tr>
						<td>
							<input type="file" name="mvoPOSTER">
						</td>
						
						<td>
						<table>
							<tr>
								<th style="width: 120px">제  목</th>
								<td><input type="text" name="mvoTITLE" ></td>
							</tr>
							<tr>
								<th>가 격</th>
								<td><input type="text" name="mvoPRICE"> 원</td>
								</tr>
							<tr>
								<th>감 독</th>
								<td><input type="text" name="mvoDIRECTOR"></td>
							</tr> 
							<tr>
								<th>배 우</th>
								<td><input type="text" name="mvoACTOR"></td>
							</tr>
							<tr>
								<th>개봉일</th>
								<td><input type="date" name="mvoOPENDAY"></td>
							</tr>
							<tr>
								<th>장 르</th>
								<td><input type="text" name="mvoGENRE"></td>
							</tr>
							<tr>
								<th>시놉시스</th>
								<td><textarea name="mvoSYNOPSIS"  rows="5" cols="50"></textarea>
							</tr>
							<tr>
								<th>상영 시작일</th>
								<td><input type="date" name="mvoSTARTDAY"></td>
							</tr>
							<tr>
								<th>상영 종료일</th>
								<td><input type="date" name="mvoENDDAY"></td>
							</tr>
							<tr>
								<th>평 점</th>
								<td>
									<input type="radio" id="APPRAISAL_1" name="mvoAPPRAISAL" value="1">
									<label for="APPRAISAL_1">1 점</label> &nbsp;&nbsp;
									
									<input type="radio" id="APPRAISAL_2" name="mvoAPPRAISAL" value="2">
									<label for="APPRAISAL_2">2 점</label> &nbsp;&nbsp;
									
									<input type="radio" id="APPRAISAL_3" name="mvoAPPRAISAL" value="3">
									<label for="APPRAISAL_3">3 점</label> &nbsp;&nbsp;
									
									<input type="radio" id="APPRAISAL_4" name="mvoAPPRAISAL" value="4">
									<label for="APPRAISAL_4">4 점</label> &nbsp;&nbsp;
									
									<input type="radio" id="APPRAISAL_5" name="mvoAPPRAISAL" value="5">
									<label for="APPRAISAL_5">5 점</label> &nbsp;&nbsp;
								</td>
							</tr>
						</table> 
					
						</td>
					</tr>
				</table>
			</c:if>
			
			
			
			
			
			<br>
		  
		  	<input type="submit" value="확인">
			<input type="reset" value="취소">
			<input type="button" value="목록" onclick="location.href='../admin/admin_Movie.do?CmdMgr=Movie_LIST&SearchGubun=${SearchGubun}&SearchWord=${SearchWord}&Sort=${Sort}'">
		</form> 
	</div>
 






	

<%@include file="/com/footer.jsp" %>