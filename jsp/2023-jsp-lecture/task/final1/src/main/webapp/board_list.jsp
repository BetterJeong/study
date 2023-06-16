<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, final1.*"%>
<jsp:useBean id="board" class="final1.BoardBean" />
<% request.setCharacterEncoding("utf-8"); %>
<%
	ArrayList<Board> boards = (ArrayList<Board>) request.getAttribute("boards");
	int pageNum = Integer.parseInt(request.getParameter("pageNum"));
%>
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="board.css" type="text/css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판:목록화면</title>
</head>
<body>
	<div align="center">
		<%
		if (session.getAttribute("s_id") == null) {
			response.sendRedirect("board_control.jsp?action=login");
		}
		%>
		<H2>게시판:목록화면</H2>
		<form name=form method=post action=board_control.jsp>
		<p>
			<%=session.getAttribute("s_name")%> 님 안녕하세요. <input type="submit" value="로그아웃">
			<input type=hidden name="action" value="logOut">
		</p>
		</form>
		<HR>
		<form name=form method=post action=board_control.jsp>
		<p>
			<input type=hidden name="action" value="search">
			<input type="text" name="word"> <input type="submit" value="검색">
		</p>
		</form>
		<form name=form1 method=GET action=board_control.jsp>
			<P>
			<table border="1">
				<tr>
					<th width="100">번호</th>
					<th width="200">제목</th>
					<th width="150">작성자</th>
					<th width="150">작성일</th>
				</tr>
				<%
				for (Board b : boards) {
					int b_num = b.getBoard_num();
				%>
				<tr>
					<td><%=b_num%></td>
					<td><a href="board_control.jsp?board_num=<%=b_num%>&action=detail"><%=b.getBoard_title()%></a></td>
					<td><%=b.getBoard_name()%></td>
					<td><%=b.getBoard_date()%></td>
				</tr>
				<% } %>
			</table>
		</form>
		<p>
		<%
		int pageAll = board.getBoardList().size() / 10 + 1;
		
		if (!(boolean) request.getAttribute("search")) {
			for (int i = 1; i <= pageAll; i++) { 
				out.println("<a href='board_control.jsp?action=list&pageNum="+ i + "'>"+ i +"</a>");
			}
		}
		else { %>
			<button type="button" onclick="location.href='board_control.jsp?action=list&pageNum=1'">목록으로</button>
		<%
		}
		%>
		</p>
		<p> <button type="button" onclick="location.href='board_form.jsp'">게시글 등록</button> </p>
	</div>
</body>
</html>