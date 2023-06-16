<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
Date nowDate = new Date();
SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm");
String now = sd.format(nowDate);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판:글 작성 화면</title>
</head>
<body>
	<div align="center">
		<H2>게시판:글 작성 화면</H2>
		<HR>
		<P>
		<form name=form1 method=post action=board_control.jsp>
			<input type=hidden name="action" value="insertBoard">
			<input type="hidden" name="pageNum" value="1">
			<input type=hidden name="board_id" value="<%=session.getAttribute("s_id")%>">
			<input type=hidden name="board_name" value="<%=session.getAttribute("s_name")%>">
			<input type=hidden name="board_date" value="<%=now%>">
			<table>
				<tr>
					<th width="100" height="30">제목</th>
					<td><input type="text" name="board_title" maxlength="20"></td>
				</tr>
				<tr>
					<th height="30">비밀번호</th>
					<td><input type="text" name="board_pw" maxlength="20"></td>
				</tr>
				<tr>
					<th height="30">작성자</th>
					<td><%=session.getAttribute("s_name")%></td>
				</tr>
				<tr>
					<th height="30">작성일</th>
					<td><%=now%></td>
				</tr>
				<tr>
					<th height="30">내용</th>
					<td><textarea rows="15" cols="50" name="board_content"></textarea></td>
				</tr>
				<tr>
					<td colspan=2 align=center><input type=submit value="완료">
					<button type="button" onclick="location.href='board_control.jsp?action=list&pageNum=1'">목록</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>