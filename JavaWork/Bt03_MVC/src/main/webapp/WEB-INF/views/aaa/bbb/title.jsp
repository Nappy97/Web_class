<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>title.jsp</title>
</head>
<body>
<h2>title.jsp - /aaa/bbb</h2>
${first } - ${second }<br>

<img src="face01.png"/><br>
<img src="../face01.png"/><br>
<img src="${pageContext.request.contextPath }/face01.png"/><br>

<img src="face02.png"/><br>
<a href="${pageContext.request.contextPath }/member/infoView">응애!</a>
</body>
</html>