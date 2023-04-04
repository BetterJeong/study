<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>ch05 :footer.jsp</TITLE></HEAD>
<BODY>
footer.jsp 에서 출력한  메시지 입니다.
<HR>
<%
	int start = Integer.parseInt(request.getParameter("start"));
	int last = Integer.parseInt(request.getParameter("last"));
	int result = 0;
	
	for (int i = start; i <= last; i++) {
		result += i;
	}
	
	out.println(start+"부터 "+last+"까지의 합: "+result);
%>
</BODY></HTML>
