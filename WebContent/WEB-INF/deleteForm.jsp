<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.javaex.vo.GuestbookVo" %>

<%
	int dNo= (int) request.getAttribute("dNo");
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>																<!-- post로 하면 화면이 안나옴  (이유 모름)-->
	<form action="/guestbook2/gbc" method="get">
		비밀번호<input type="text" name="password">
		<input type="hidden" name="no"  value= "<%=dNo %>">
		<input type="hidden" name="action" value="delete">
		<button type="submit">확인</button>
	</form>
	
	<a href="/guestbook2/gbc?action=addList">메인을 돌아가기</a>
	
</body>
</html>