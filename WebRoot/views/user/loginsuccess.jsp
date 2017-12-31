<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mall.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	String role = (String) request.getAttribute("role");
	Object obj = request.getAttribute("object"); 
	Admin admin = null;
	Member member = null;
	String name = "";
	
	if (role.equals("Admin")){
		admin = (Admin) obj;
		name = admin.getAdminName();
		session.setAttribute("currentUserID", admin.getAid());
	}else{
		member = (Member) obj;
		name = member.getUserName(); 
		session.setAttribute("currentUserID", member.getUid());
	}
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    	用户登录成功<br />
    	欢迎 <%= role %><br />
    	名称<%= name %><br />
	<%
		Integer id = (Integer) session.getAttribute("currentUserID");
	 %>   
	 ID : <%= id %>	<br />
	 
	 <h3>三秒后回到主页面</h3>
	 
	 <%
	 	response.setHeader("refresh", "3, url=/SS2H_Mall");
	  %>
  </body>
</html>
