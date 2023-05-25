<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jspbook2.*, java.util.*" %>
<!DOCTYPE html>
<jsp:useBean id="memberBean" class="jspbook2.MemberBean" scope="application"/>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<%
// 컨트롤러 요청 파라미터
String action = request.getParameter("action"); // 파라미터에 따른 요청 처리
if (action == null) {
}
else if (action.equals("register")) {
	String userId = request.getParameter("userid");
	String password = request.getParameter("passwd");
	boolean b = false;
	
	if (userId.length() < 4) {
		out.println("<script>alert('아이디가 너무 짧습니다.')</script>");
	}
	else {
		for (Member m : memberBean.getMembers()) {
			if (userId.equals(m.getId())) {
				b = true;
				break;
			}
		}
		
		if (b) {
			out.println("<script>alert('이미 존재하는 아이디 입니다.')</script>");
		}
		else {
			memberBean.addMember(new Member(userId, password));
			pageContext.forward("login.jsp");
		}
	}
}
%>
	<div align=center>
		<H2>회원 가입</H2>
		<HR>
		<form method="post" action="register.jsp" name="register_form">
			<input type=hidden name="action" value="register">
			<table width="250" border="1" align="center" cellspacing="0"
				cellpadding="5">
				<tr>
					<td colspan="2" align="center">회원 가입</td>
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
					<input type="submit" name="RegisterSubmit" value="가입하기">
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