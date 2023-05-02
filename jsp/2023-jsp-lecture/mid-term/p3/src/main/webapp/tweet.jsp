<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, java.text.*, mid.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="tweetlist" class="mid.Mid2" scope="application"/>
<%
request.setCharacterEncoding("UTF-8");

String msg = request.getParameter("msg");
String username = String.valueOf(session.getAttribute("user"));

Date date = new Date();
SimpleDateFormat f = new SimpleDateFormat("E MMM dd HH:mm", Locale.KOREA);
tweetlist.add(new Mid1(username, msg));

response.sendRedirect("twitter_list.jsp");
%>
