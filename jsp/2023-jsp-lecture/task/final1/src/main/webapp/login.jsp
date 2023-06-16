<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!-- 완성
	기말시험 과제 2
	게시판에 글을 등록할 때 글마다 비밀번호를 설정 (완료)
	본인이 작성한 글이라도 비밀번호를 기억하지 못 할 경우 수정이나 삭제 자체가 불가능 (완료)
	관리자(아이디를 admin으로 작성)인 경우는 글의 비밀번호와 상관없이 삭제나 수정이 가능 (완료)
 -->
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/board.css" type="text/css" media="screen"/>
<meta charset="UTF-8">
<title>게시판 로그인 페이지</title>
</head>
<body bgcolor="#FFFFFF">
<div style="text-align:center;">
	<h2>게시판</h2>
	<hr>
	<form method="post" action="board_control.jsp" name="form1">
		<input type="hidden" name="action" value="loginProc">
		<input type="hidden" name="pageNum" value="1">
		<table width="250px" border="1" align="center" cellspacing="0" cellpadding="5">
			<tr>
			<td colspan="2" align="center">로그인</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="m_id" size="10"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="m_pw" size="10"></td>
			</tr>
			<tr>
				<td align ="center" colspan="2">
					<div style="display: flex; justify-content:space-between;">
						<button type="submit" style="width:80px;">로그인</button>
						<button type="button" style="width:80px;" onclick="location.href='member_join.jsp'">회원가입</button>
						<button type="button" style="width:80px;" onclick="location.href='member_delete.jsp'">회원탈퇴</button>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<p>
	기말시험 과제 2 <br>
	게시판에 글을 등록할 때 글마다 비밀번호를 설정 (완료) <br>
	본인이 작성한 글이라도 비밀번호를 기억하지 못 할 경우 수정이나 삭제 자체가 불가능 (완료) <br>
	관리자(아이디를 admin으로 작성)인 경우는 글의 비밀번호와 상관없이 삭제나 수정이 가능 (완료)
	</p>
</div>
</body>
</html>