<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, final1.*"%>
<%
	Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판:상세 화면</title>
<script type="text/javascript">
	function check(num, url) {
		<% if (!session.getAttribute("s_id").equals("admin")) {%>
		pwd = prompt('비밀번호를 입력하세요.');	
		
		if (url == "update") {
			document.location.href = "board_control.jsp?action=update&board_num=" + num + "&pw=" + pwd;
		}
		else if (url == "delete" && pwd != "") {
			conResult = confirm("정말로 삭제하시겠습니까?");
			document.location.href = "board_control.jsp?action=delete&board_num=" + num + "&pw=" + pwd + "&conResult=" + conResult;
		}
		<% }
		else { %>
		if (url == "update") {
			document.location.href = "board_control.jsp?action=update&board_num=" + num;
		}
		else if (url == "delete") {
			conResult = confirm("정말로 삭제하시겠습니까?");
			document.location.href = "board_control.jsp?action=delete&board_num=" + num + "&conResult=" + conResult;
		}
		<%
		}
		%>
	}
</script>
</head>
<body>
	<div align="center">
		<H2>게시판:상세 화면</H2>
		<HR>
		<P>
		<table>
			<tr>
				<th width="100" height="30">제목</th>
				<td width="250"><%= board.getBoard_title() %></td>
			</tr>
			<tr>
				<th width="100" height="30">번호</th>
				<td width="250"><%= board.getBoard_num() %></td>
			</tr>
			<tr>
				<th height="30">작성자</th>
				<td><%= board.getBoard_name() %></td>
			</tr>
			<tr>
				<th height="30">작성일</th>
				<td><%= board.getBoard_date() %></td>
			</tr>
			<tr>
				<th height="30">내용</th>
				<td><%= board.getBoard_content() %></td>
			</tr>
			<tr>
				<td colspan=2>
				</td>
				<% if (session.getAttribute("s_id").equals("admin") || board.getBoard_id().equals(session.getAttribute("s_id"))) {%>
				<td align=center>
					<button onclick="check(<%=board.getBoard_num()%>, 'update');">수정</button>
				</td>
				<td align=center>
					<button onclick="check(<%=board.getBoard_num()%>, 'delete');">삭제</button>
				</td>
				<% } %>
				<td align=center>
					<form name=form method=post action=board_control.jsp>
						<button type="button" onclick="location.href='board_control.jsp?action=list&pageNum=1'">목록</button>
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
<script>
	function pwValidationForUpdate() {
		var data = prompt("비밀번호를 입력해주세요.");
		if (!data.equals(<%=session.getAttribute("s_pw")%>) {
			alert('비밀번호를 확인해주세요.');
			history.go(-1);
		}
		else {
			location.href='board_control.jsp?board_num=<%=board.getBoard_num()%>&action=update';
		}
	}
</script>
</html>