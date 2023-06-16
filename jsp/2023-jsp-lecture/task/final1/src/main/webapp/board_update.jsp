<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, final1.*"%>
<% request.setCharacterEncoding("utf-8"); %>
<%
	Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판: 수정 화면</title>
</head>
<body>
<div align="center">
		<H2>게시판: 수정 화면</H2>
		<HR>
		<P>
		<form name=form method=POST action=board_control.jsp>
			<input type=hidden name="action" value="updateProc">
			<input type=hidden name="board_id" value="<%=session.getAttribute("s_id")%>">
			<input type=hidden name="board_name" value="<%=session.getAttribute("s_name")%>">
			<input type=hidden name="board_date" value="<%=board.getBoard_date()%>">
			<input type=hidden name="board_num" value="<%=board.getBoard_num()%>">
			<table>
				<tr>
					<th width="100" height="30">제목</th>
					<td><input type="text" name="board_title" maxlength="20" value="<%=board.getBoard_title()%>"></td>
				</tr>
				<tr>
					<th height="30">작성자</th>
					<td><%=board.getBoard_name()%></td>
				</tr>
				<tr>
					<th height="30">작성일</th>
					<td><%=board.getBoard_date()%></td>
				</tr>
				<tr>
					<th height="30">내용</th>
					<td><textarea rows="15" cols="50" name="board_content"><%=board.getBoard_content()%></textarea></td>
				</tr>
				<tr>
					<td colspan=2 align=center>
					<input type=submit value="수정하기">
					<button type="button" onclick="location.href='board_control.jsp?action=list&pageNum=1'">목록</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>