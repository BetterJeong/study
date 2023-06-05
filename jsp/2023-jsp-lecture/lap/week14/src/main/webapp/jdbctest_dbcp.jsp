<%@ page contentType="text/html;charset=utf-8" import="javax.sql.*,java.sql.*, javax.naming.*"%>
<%
request.setCharacterEncoding("utf-8");
%>

<%
// 데이터베이스 연결관련 변수 선언
Connection conn = null;
PreparedStatement pstmt = null;

try {
	Context initContext = new InitialContext();
	Context envContext = (Context) initContext.lookup("java:/comp/env");
	DataSource ds = (DataSource) envContext.lookup("jdbc/mysql");

	// 커넥션 얻기
	conn = ds.getConnection();

	// username 값을 입력한 경우 sql 문장을 수행.
	if (request.getParameter("username") != null) {
		// Connection 클래스의 인스턴스로 부터 SQL  문 작성을 위한 Statement 준비
		String sql = "insert into jdbc_test values(?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, request.getParameter("username"));
		pstmt.setString(2, request.getParameter("email"));
		pstmt.executeUpdate();
	}
} catch (Exception e) {
	e.printStackTrace();
}
%>
<HTML>
<HEAD>
<TITLE>ch12 : JDBC 테스트</TITLE>
</HEAD>
<BODY>
	<center>
		<H2>ch12:jdbctest_dbcp.jsp</H2>
		<HR>
		<form name=form1 method=post action=jdbctest_dbcp.jsp>
			등록이름 : <input type=text name=username> email주소 : <input type=text name=email size=20>
			<input type=submit value="등록">
		</form>
		<HR>
	</center>
	# 등록 목록
	<P>
		<%
		try {
			String sql = "select username, email from jdbc_test";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			while (rs.next()) {
				out.println(i + " : " + rs.getString(1) + " , " + rs.getString("email") + "<BR>");
				i++;
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		%>
	</P>
</BODY>
</HTML>
