<!-- addr_add.jsp -->

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
<jsp:useBean id="addr" class="task04.AddrBean" />
<jsp:setProperty name="addr" property="*" />
<jsp:useBean id="am" class="task04.AddrManager" scope="application" />
<%
am.add(addr);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ch07 : addr_add.jsp</title>
</head>
<body>
	<div align="center">
		<H2>등록내용</H2>
		이름 :
		<jsp:getProperty property="username" name="addr" /><P>
			전화번호 :
			<%=addr.getTel()%>
		<P>
			이메일 :
			<%=addr.getEmail()%>
		<P>
			주소 :
			<%=addr.getAddress() %>
		<P>
			성별 :
			<%=addr.getSex()%>
		<HR>
		<a href="addr_list.jsp">목록 보기</a>
	</div>
</body>
</html>

