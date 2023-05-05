<!-- addr_delete.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*, task04.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("UTF-8");
%>
<%	Connection conn = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://127.0.0.1/jspdb?useSSL=false&serverTimezone=Asia/Seoul ";
	
	try {
		Class.forName(jdbc_driver);
		conn = DriverManager.getConnection(jdbc_url, "root", "1234");
		String sql = "DELETE FROM addrtest WHERE username = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,request.getParameter("username"));
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	catch (Exception e) {
		System.out.println(e);
	}
%>
<html>
<head>
<title>데이터 삭제</title>
</head>
<body>
<script>
alert("삭제 완료");
location.href = 'addr_list.jsp';
</script>
</body>
</html>