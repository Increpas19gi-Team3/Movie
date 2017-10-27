<%-- 내 정보 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.movie03.dto.MemberVO"%>

<%
	// 이게 중요함 내가 보낼때 2번 포장해서?(1번은 ArrayList안에 list로 덮어서) 보냄
	// login.jsp -> loginAction.java 
	// -> MemberDAO.java : ArrayList<MemberVO>() - loginlist 1차
	// 우선 입력받은 파라미터를 ArrayList로 덮고 
	// -> loginAction.java : List( ArrayList<MemberVO>() ) - login2 2차
	// ArrayList를 list로 덮어서 보냄..? 이라고 하면 이해할라나?
	HashMap<String, Object> respModel = (HashMap<String, Object>)request.getAttribute("respModel");
	ArrayList<MemberVO> list = (ArrayList<MemberVO>)respModel.get("login2");
	MemberVO mVo = list.get(0);
	
	// console-창에 출력
	System.out.println(mVo.getMID());
	System.out.println(mVo.getMNAME());
	System.out.println(mVo.getMADMIN());
	
	//세션에 저장
	session.setAttribute("MID", mVo.getMID());
	session.setAttribute("MNAME", mVo.getMNAME());
	session.setAttribute("MADMIN", mVo.getMADMIN());
	
	//MovieVO mVo = (MovieVO)respModel.get("login2");
	//pageContext.setAttribute("mVo", mVo);
%>
<%-- <%@ page import="com.movie03.dto.MemberVO"%> --%>

<%-- 정적 인클루드 --%>
<%@include file="/com/header.jsp"%>
'MYPAGE'입니다.
<!-- <div class = "MemberDAO.java" align="center">
<h2>내 정보</h2>
<form action="" method="post">
 <div class="log">
          <input type="hidden" name=MID value="" id="MID" placeholder="아이디" maxlength="20" >
        </div>
         <div class="log">
          <input type="hidden" name=MNAME value="" id="MNAME" placeholder="이름" maxlength="20" >
        </div>
        <div class="log">
          <input type="hidden" name=MEMAIL value="" id="MEMAIL" placeholder="이메일" maxlength="15">
        </div>
        <div class="log">
          <input type="hidden" name=MTEL value="" id="MTEL" placeholder="전화번호" maxlength="15">
        </div>
        <div class="log">
          <input type="submit" name="" value="확인" onclick="">
        </div>
        
</form>
</div> -->

<%@include file="/com/footer.jsp"%>