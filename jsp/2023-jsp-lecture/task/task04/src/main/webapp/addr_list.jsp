<!-- addr_list.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("utf-8"); %>
<%	Connection conn = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://127.0.0.1/jspdb?useSSL=false&serverTimezone=Asia/Seoul ";
	
	try {
		Class.forName(jdbc_driver);
		conn = DriverManager.getConnection(jdbc_url, "root", "1234");
		String sql = "insert into addrtest values(?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,request.getParameter("username"));
		pstmt.setString(2,request.getParameter("tel"));
		pstmt.setString(3,request.getParameter("email"));
		pstmt.setString(4,request.getParameter("address"));
		pstmt.setString(5,request.getParameter("sex"));
		if (request.getParameter("username") != null) {
			pstmt.executeUpdate();
		}
	}
	catch (Exception e) {
		System.out.println(e);
	}
%>
<jsp:useBean id="addr" class="task04.AddrBean"/>
<jsp:setProperty name="addr" property="*"/>
<jsp:useBean id="am" class="task04.AddrManager" scope="application"/>
<%  	am.add(addr);    %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ch07 : 주소록 목록</title>
</head>
<body>
	<div align=center>
		<H2>주소록</H2>
		<HR>
		<a href="addr_form.html">주소추가</a>
		<P>
		
		<table border=1 width=600>
			<tr>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>주소</th>
				<th>성별</th>
			</tr>
		<%	try{
				String sql = "select username, tel, email, address, sex from addrtest";
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					out.println("<form name=delete_form action=addr_delete.jsp>");
					out.println("<input type=\"hidden\" name=\"username\" value="+rs.getString("username"));
					out.println("<tr>");
					out.println("<td>"+rs.getString("username")+"</td>");
					out.println("<td>"+rs.getString("tel")+"</td>");
					out.println("<td>"+rs.getString("email")+"</td>");
					out.println("<td>"+rs.getString("address")+"</td>");
					out.println("<td>"+rs.getString("sex")+"</td>");
					out.println("<td><input type=submit value=\"삭제\"></td>");
					out.println("</tr>");
					out.println("</form>");
				}
				
				rs.close();
				pstmt.close();
				conn.close();
			}
			catch(Exception e) {
			System.out.println(e);
			}
%>

		</table>
	</div>
</body>
</html>
