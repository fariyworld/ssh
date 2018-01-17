<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.mall.entity.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--
	时间：2017-12-01
	描述：系统首页
-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Fairy商城首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style>
        *{
            margin: 0;
            padding: 0;
        }
        ul{
            list-style: none;
        }
        .box{
            width: 15%;
           /* margin: 0 auto;*/
            background: #444444;
            color: #c5c5c5;
            float: left;
        }
        .list>li{

        }
        .list>li h3{
            height: 40px;
            padding-left: 20px;
            line-height: 40px;
        }
        .list>li h3.cur{
            background: #cb302f;
        }
        .list ul{
            display: none;
        }
        .list ul li{
            height: 40px;
            padding-left: 30px;
            line-height: 40px;
        }
        
        .list ul li a{
        	color: #c5c5c5; 
        }
        
        .content{
        	float:left;
        	/* background: red; */
        	width:85%;
        	height:500px;
        }
        
        
    </style>
	
  </head>
  
<body>
	<%@include file="views/base/head.jsp" %>
	<div class="box">
    <ul class="list">
        <li>
            <h3 flag="0">用户模块</h3>
            <ul>
                <li><a href="views/user/updatePWD.jsp">修改密码</a></li>
                <li><a href="views/user/queryMember.jsp">查看用户</a></li>
                <li><a href="views/user/queryMember.jsp">完善个人资料</a></li>
            </ul>
        </li>
        <li>
            <h3 flag="0">管理员模块</h3>
            <ul>
           		<li><a href="views/admin/checking-in.jsp">管理员考勤</a></li>
           		<li><a href="views/admin/upload_HeadPortrait.jsp">管理员上传头像</a></li>
                <li>发布公告</li>
            </ul>
        </li>
        <li>
            <h3 flag="0">商品模块</h3>
            <ul>
                <li>展示商品</li>
            </ul>
        </li>
        <li>
            <h3 flag="0">新品</h3>
            <ul>
                <li>查看新品</li>
                <li>上架新品</li>
                <li>下架新品</li>
            </ul>
        </li>
        <li>
            <h3 flag="0">留言模块</h3>
            <ul>
                <li>发布留言</li>
            </ul>
        </li>
        <li>
            <h3 flag="0">测试模块</h3>
            <ul>
                <li><a href="views/test/getpost.jsp">Get/POST请求</a></li>
            </ul>
        </li>
    </ul>
</div>
<div class="content"></div>
<script src="resources/js/jquery-1.11.2.min.js"></script>
<script>
    $('h3').mouseover(function () {
        $(this).addClass('cur');
    }).mouseout(function () {
        if($(this).attr('flag')==0){
            $(this).removeClass('cur');
        }
    }).click(function () {
        if($(this).attr('flag')==0){
           var res =  $(this).next().slideDown().end().attr('flag',1).parent().siblings().find('ul').slideUp().prev().attr('flag',0).removeClass('cur');
        }else{
            $(this).next().slideUp().end().attr('flag',0);
        }
    });
    
    $("ul.list a").click(function(){
    
    	var val = $(this).attr("href");
    	
    	$("div.content").load(val);
    	
    	return false;
    });
    
</script>
	
</body>
</html>
