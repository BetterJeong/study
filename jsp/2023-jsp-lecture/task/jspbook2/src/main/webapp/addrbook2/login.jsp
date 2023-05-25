<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="jspbook2.*, java.util.*" %>
<!DOCTYPE html>
<jsp:useBean id="memberBean" class="jspbook2.MemberBean" scope="application"/>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%
// 컨트롤러 요청 파라미터
String action = request.getParameter("action"); // 파라미터에 따른 요청 처리

if (action == null) {
}
else if (action.equals("login")) {
	String userId = request.getParameter("userid");
	String password = request.getParameter("passwd");
	boolean b = false;
	
	for (Member m : memberBean.getMembers()) {
		if (userId.equals(m.getId()) && password.equals(m.getPassword())) {
			b = true;
			break;
		}
	}
	
	if (b) {
		pageContext.forward("index.jsp");
	}
	else {
		out.println("<script>alert('아이디 또는 패스워드 오류입니다.')</script>");
	}
}
%>
	<div align=center>
		<H2>로그인</H2>
		<HR>
		<form method="post" action="login.jsp" name="login_form">
			<input type=hidden name="action" value="login">
			<table width="250" border="1" align="center" cellspacing="0"
				cellpadding="5">
				<tr>
					<td colspan="2" align="center">로그인</td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" size=10></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="passwd" size=10></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" name="submit" value="로그인">
					<button type="button" onclick="location.href='register.jsp'">회원가입</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>