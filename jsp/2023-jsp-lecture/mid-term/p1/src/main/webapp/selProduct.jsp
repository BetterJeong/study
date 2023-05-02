<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<title>ch06 : selProduct.jsp</title>
</head>
<%
request.setCharacterEncoding("UTF-8");
session.setAttribute("username", request.getParameter("username"));
HashMap<String, Integer> list = new HashMap<>();
session.setAttribute("productlist", list);
%>
<body>
	<div align="center">
		<H2>상품선택</H2>
		<HR>
		<%=session.getAttribute("username")%>님 환영합니다!!!!
		<HR>
		<form name="form1" method="POST" action="checkOut.jsp">
			사과 1000원 <SELECT name="appleCount">
				<option>0</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
			</SELECT><br>
			귤 1500원 <SELECT name="mandarinCount">
				<option>0</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
			</SELECT><br>
			파인애플 2000원 <SELECT name="pineappleCount">
				<option>0</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
			</SELECT><br>
			자몽 3000원 <SELECT name="grapefruitCount">
				<option>0</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
			</SELECT><br>
			레몬 4000원 <SELECT name="lemonCount">
				<option>0</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
			</SELECT><br>
			<br>
			<input type="submit" value="계산하기" />
		</form>
	</div>
</body>
</html>
