<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ch06 : checkOut.jsp</title>
</HEAD>
<body>
	<div align="center">
		<H2>계산</H2>
		선택한 상품 목록
		<HR>
		<%
		HashMap<String, Integer> map = (HashMap) session.getAttribute("productlist");
		int sum = 0;
		String[] p = {"사과", "귤", "파인애플", "자몽", "레몬"};
		
		String appleCount = request.getParameter("appleCount");
		map.put(p[0], Integer.parseInt(appleCount));
		String mandarinCount = request.getParameter("mandarinCount");
		map.put(p[1], Integer.parseInt(mandarinCount));
		String pineappleCount = request.getParameter("pineappleCount");
		map.put(p[2], Integer.parseInt(pineappleCount));
		String grapefruitCount = request.getParameter("grapefruitCount");
		map.put(p[3], Integer.parseInt(grapefruitCount));
		String lemonCount = request.getParameter("lemonCount");
		map.put(p[4], Integer.parseInt(lemonCount));
		
		for (int i = 0; i < p.length; i++) {
		   int value = map.get(p[i]);
		   out.println(p[i] + " : " + value + "개<br>");
		    
		   if (p[i].equals("사과")) {
			   sum += value * 1000;
		   }
		   else if (p[i].equals("귤")) {
			   sum += value * 1500;
		   }
		   else if (p[i].equals("파인애플")) {
			   sum += value * 2000;
		   }
		   else if (p[i].equals("자몽")) {
			   sum += value * 3000;
		   }
		   else if (p[i].equals("레몬")) {
			   sum += value * 4000;
		   }
		}
		
		out.println("<br>최종 금액: " + sum + "원 결제되었습니다.<br><br>");
		%>
		
		<% session.invalidate(); %>
		
		<a href="login.jsp">로그인 화면으로 돌아가기</a>
	</div>
</body>
</html>
