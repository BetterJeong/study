<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 회원 탈퇴</title>
</head>
<body>
	<div align=center>
		<H2>게시판</H2>
		<HR>
		<form method="post" action="board_control.jsp" name="memeberDelete">
			<input type=hidden name="action" value="memeberDelete">
			<table width="250" border="1" align="center" cellspacing="0"
				cellpadding="5">
				<tr>
					<td colspan="2" align="center">회원 탈퇴</td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="m_id" size=10></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="m_pw" size=10></td>
				</tr>
				<tr>
					<td>비밀번호 재입력</td>
					<td><input type="password" name=m_repw size=10></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" name="RegisterSubmit" value="삭제하기">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<button type="button" onclick="location.href='login.jsp'">로그인 화면으로 이동</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>