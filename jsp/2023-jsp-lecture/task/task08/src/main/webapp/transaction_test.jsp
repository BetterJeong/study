<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:useBean scope="page" id="bb" class="task08.Bank1Bean" />
<jsp:useBean scope="page" id="bb2" class="task08.Bank2Bean" />
<%
if (request.getMethod().equals("POST")) {
	int bal = Integer.parseInt(request.getParameter("bal"));
	bb.getData();
	bb2.getData();
	if (request.getParameter("bank").equals("bank1")) {
		if (bb.getBalance() >= bal) {
			bb.transfer(bal);
		}
		else {
			out.println("<script>alert('잔액이 부족합니다.')</script>");
		}
	}
	else if (request.getParameter("bank").equals("bank2")) {
		if (bb2.getBalance() >= bal) {
			bb2.transfer(bal);
		}
		else {
			out.println("<script>alert('잔액이 부족합니다.')</script>");
		}
	}
}
bb.getData();
bb2.getData();
%>
<HTML>
<HEAD>
<TITLE>ch12 :트랜잭션 테스트</TITLE>
</HEAD>
<BODY>
	<div align="CENTER">
		<H3>계좌현황</H3>
		<HR>
		<table border=1 cellpadding=5 cellspacing=0>
			<tr>
				<td>Bank1</td>
				<td>이름 : <%=bb.getAname()%></td>
				<td>잔액 : <%=bb.getBalance()%></td>
			</tr>
			<tr>
				<td>Bank2</td>
				<td>이름 : <%=bb2.getAname()%></td>
				<td>잔액 : <%=bb2.getBalance()%></td>
			</tr>
		</table>
		<HR>
		<form name=form2 method=post>
			Bank1에서 Bank2로 <br>
			이체금액 : <INPUT TYPE="text" NAME="bal" width=200 size="5">
			<input type="hidden" name="bank" value="bank1">  <input
				type="submit" value="이체실행" name="B1toB2"> <input type="reset"
				value="다시입력" name="B2">
		</form>
		<form name=form2 method=post>
		<HR>
			Bank2에서 Bank1로 <br>
			이체금액 : <INPUT TYPE="text" NAME="bal" width=200 size="5"> 
			 <input type="hidden" name="bank" value="bank2"> <input
				type="submit" value="이체실행" name="B2toB1"> <input type="reset"
				value="다시입력" name="B2">
		</form>
		<HR>
	</div>
</BODY>
</HTML>
