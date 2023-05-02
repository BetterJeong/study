<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("UTF-8");
String username = request.getParameter("username");
if (username != null) {
	session.setAttribute("user", username);
}
%>
<html>
<head>
<title>ch06 : twitter_list.jsp</title>
</head>
<body>
	<div align=center>
		<H3>My Simple Twitter!!</H3>
		<HR>
		<form action="tweet.jsp" method="POST">
			<!-- 세션에 저장된 이름 출력 -->
			@<%=session.getAttribute("user")%>
			<input type="text" name="msg"><input type="submit"
				value="Tweet">
		</form>
		<br>
		<a href="twitter_login.jsp">로그인 화면으로 돌아가기</a>
		<HR>
		<div align="left">
			<UL>
				<%
				// application 내장객체를 통해 msgs 이름으로 저장된 ArrayList를 가지고 옴
				ArrayList<String> msgs = (ArrayList<String>) application.getAttribute("msgs");

				//msgs가 null 이 아닌 경우에만 목록 출력
				if (msgs != null) {
					for (String msg : msgs) {
						String[] str = msg.split(":");
						out.println("<form action='twitter_delete.jsp' name='delete_form' method='POST'>");
						out.println("<LI>" + msg);
						String userStr = str[0].substring(0, str[0].length()-1);
						if (session.getAttribute("user").equals(userStr)){
							out.println("<input type='hidden' name='user' value='" + userStr + "'/>");
							out.println("<input type='hidden' name='msg' value='" + msg + "'/>");
							out.println("<input type='submit' value='삭제'>");
						}
						out.println("</LI>");
						out.println("</form>");
					}
				}
				%>
			</UL>
		</div>
	</div>
</body>
</html>

