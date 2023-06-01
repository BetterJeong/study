<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>ch11 : forEach</title>
</head>
<body bgcolor="#FFFFFF">
	<h3>&lt;c:for&gt;</h3>
	<c:set value="0" var="evenSum" />
	<c:set value="0" var="oddSum" />
	<c:forEach var="i" begin="1" end="100">
		<c:if test="${ i % 2 == 0 }">
			<c:set value="${evenSum+i}" var="evenSum" />
		</c:if>
		<c:if test="${ i % 2 == 1 }">
			<c:set value="${oddSum+i}" var="oddSum" />
		</c:if>
	</c:forEach>

	1부터 100까지 짝수 합: ${evenSum} <br>
	1부터 100까지 홀수 합: ${oddSum}
	
</body>
</html>