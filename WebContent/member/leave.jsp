<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 정적 인클루드 --%>
<%@include file="/com/header.jsp"%>


<div class="" align="center">

	<h2>비밀번호 찾기</h2>
	<br><br>
	
	<div class="timeline">
		<div class="entries">

			<div class="entry">
				<div class="title">회원탈퇴 안내</div>
				<div class="body">
					<p>
						회원탈퇴를 신청하기 전에<br> 
						안내사항을 확인해 주세요.
					</p>
				</div>
			</div>

			<div class="entry">
				<div class="title">
					사용자 ID(아이디)<br> 
					재사용 및 복구 불가능
				</div>
				
				<div class="body">
					<p>
						탈퇴한 사용자 ID(아이디)는 본인과<br> 
						타인 모두 재사용 및 복구가 불가하오니<br> 
						신중하게 선택하시기 바랍니다.
					</p>
				</div>
			</div>

			<div class="entry">
			
				<div class="title big">
					회원정보 이용기록은<br> 
					모두 삭제
				</div>
				
				<div class="body">
					<p>
						회원정보 및 메일, 블로그, 주소록 등<br> 
						개인형 서비스 이용기록은 모두 삭제되며<br> 
						삭제된 데이터는 복구 되지 않습니다.<br> 
						삭제되는 내용을 확인하시고 필요한<br> 
						데이터는 미리 백업을 해주시길 바랍니다.
					</p>
				</div>
			</div>

			<div class="entry">
				<div class="title">게시판형 서비스에 등록한 게시물은 남아 있습니다.</div>
				<div class="body">
					<p>
						게시판에 올린 게시글 및 댓글은 탈퇴 시<br> 
						자동 삭제되지 않고 그대로 남아 있습니다.<br>
						삭제를 원하시는 게시글이 있다면 반드시<br> 
						탈퇴 전에 비공개 처리하거나 삭제하시기<br>
						바랍니다.
					</p>
				</div>
			</div>

			<div class="entry">
				<div class="title">
					사용자(ID)를 이용하여<br> 
					다른 서비스에 로그인<br> 
					할 수 없게 됩니다.
				</div>
				<div class="body">
					<p>
						사용자 아이디로 로그인하여<br> 
						사용 중이던 외부 사이트를 방문하여<br> 
						다른 로그인 수단을 준비하거나<br> 
						데이터 백업한 후 탈퇴하셔야 합니다.
					</p>
				</div>
			</div>

			<div class="entry">
				<div class="title big">탈퇴확인</div>
				<div class="body">
					<p>
						1. 사용자 아이디(ID)로 다시 가입불가<br> 
						2. 아이디, 데이터 복구 불가<br> 
						3. 서비스에 남아있는 게시글 탈퇴 후<br> 
						&nbsp;삭제 불가<br> 
						4. 아이디를 사용하여 다른 서비스에<br> 
						&nbsp;로그인 불가
					</p>
				</div>
			</div>

			<div class="entry">
				<div class="title">안내 사항을 모두 확인</div>
				<div class="body">
					<p>
						안내 사항을 모두 확인하였으며<br>
						이에 동의 합니다.
					</p>

					<form action="leave_out.jsp">
						<input type="submit" value="탈퇴">
					</form>

				</div>
			</div>
		</div>
	</div>
	<%-- 탈퇴관련 문구 끝 --%>

	<%
		//System.out.println("leave=>" + session.getAttribute("USERID"));
	%>
	<br><br>
</div>

<%@include file="/com/footer.jsp"%>