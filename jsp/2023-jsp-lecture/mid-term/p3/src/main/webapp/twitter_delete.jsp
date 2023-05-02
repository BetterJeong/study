<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, java.text.*, mid.*"%>
	<jsp:useBean id="tweetlist" class="mid.Mid2" scope="application"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("UTF-8");

String username = request.getParameter("user");
String msgToDelete = request.getParameter("msg");

for (Mid1 m : tweetlist.getList()) {
	if (m.getMsg().equals(msgToDelete) && m.getUsername().equals(username)) {
		tweetlist.delete(m);
		break;
	}
}

response.sendRedirect("twitter_list.jsp");
%>