<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	用户登录failure<br />
	<h3>三秒后回到登录页面</h3>
	 
	 <%
	 	response.setHeader("refresh", "3, url=/SS2H_Mall/views/user/login.jsp");
	  %>
</body>
</html>