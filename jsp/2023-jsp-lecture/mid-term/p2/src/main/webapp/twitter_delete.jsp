<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("UTF-8");

String msgToDelete = request.getParameter("msg");
ArrayList<String>msgs = (ArrayList<String>)application.getAttribute("msgs");

for (int i = 0; i < msgs.size(); i++) {
	if (msgs.get(i).equals(msgToDelete)) {
		msgs.remove(i);
		break;
	}
}
response.sendRedirect("twitter_list.jsp");
%>