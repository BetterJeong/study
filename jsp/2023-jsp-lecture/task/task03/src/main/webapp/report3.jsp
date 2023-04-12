<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");

String userName = request.getParameter("name");
String gender = request.getParameter("성별");
String[] sports = request.getParameterValues("스포츠");
String[] fruits = request.getParameterValues("과일");
String music = request.getParameter("음악");
String proposal = request.getParameter("제안사항");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>제출 결과</title>
  </head>
  <body>
    <h2>안녕하세요, <%=userName%> 님</h2>
    <div>
        <p>
            성별: <%=gender%> <br>
            좋아하는 스포츠: 
            <% if (sports == null) {
            	out.println("좋아하는 스포츠가 없네요."); 
            }
            else { 
            	for (int i = 0; i < sports.length; i++) {
                    out.println(sports[i]);
            	}
            }  %> <br>
            좋아하는 과일:
            <%  for (int i = 0; i < fruits.length; i++) {
                out.println(fruits[i]);
            }  %> <br>
            좋아하는 음악: <%=music%> <br>
        </p>
        <p>
            기타 제안 사항: <%=proposal%>
        </p>
        <p>
            <a href="report3.html">다시 제출하기</a>
        </p>
    </div>
  </body>
</html>
