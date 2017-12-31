<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
		#loginform{
			width:30%;
			margin: 50px auto;
		}
	</style>

  </head>
  
  <body>
  	<%@include file="/views/base/head.jsp" %>
  
    	<form action="" method="post" id="loginform">
		<table>
			<tr>
				<td>请选择角色：</td>
				<td>
					<select name="role">
						<option value="Member" selected="selected">会员</option>
						<option value="Admin">管理员</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>用户名:</td>
				<td><input type="text" id="account" name="account" value="" /></td>
			</tr>
			<tr>
				<td>密&nbsp;码:</td>
				<td><input type="password" id="password" name="password" value="" /></td>
			</tr>
			<tr>
				<td>验证码 :</td>
				<td>
					<input type="text" id="code" name="code" value=""/>
					<img alt="验证码" src="" id="imgcode" />
					<a href="javascript: reload();" style="font-size: 8px">看不清楚，换一张</a>
				</td>
			</tr>
			<tr>
				<td><input type="button" id="register" name="register" value="注册" /></td>
				<td>
					<input type="button" id="userLogin" name="userLogin" value="登录" />
					<input type="reset" id="reset" name="reset"value="重置" />
				</td>
			</tr>
		</table>
	</form>
	<script src="resources/js/jquery-1.11.2.min.js"></script>
    
    <script type="text/javascript" language="javascript">
    
    		//加载验证码
	    	reload();
	   		function reload(){
				$("#imgcode").attr("src","<%= path %>/servlet/VerifyCodeServlet?date="+ new Date().getTime());
				$("#code").val("");
			}
			
	    	//验证图片验证码checkCode
 			var codeboo = true;
			$("#code").blur(checkCode);
			function checkCode(){
			
				var val = $("#code").val();
				var urls = "servlet/ServletUtils";
				$.ajax({
					async: false,
					type: "post",
					url: urls,
					data: {"icode":val, "idt": "1"},
					dataType: "text",
					success: function(hello){
						if( hello == ""){
							codeboo =  true;
						}else{
							codeboo =  false;
							alert(hello);
						}
					}
				});
			}
			
			//点击注册按钮
	    	$("#register").click(function regBtn(){
	    	
	    		$("#loginform").attr("action","<%= path %>/views/user/UserRegister.jsp");
	    		$("#loginform").submit();
	    	});
	    	
	    	//用户登录验证跳转至action -- MemberAction_Login   在action中调用验证数据库数据
    		$("#userLogin").click(function loginBtn(){
    		
    			if( $("#account").val() === "" ){
					alert("用户名为空");
					return false;
				}else if( $("#password").val() === "" ){
					alert("密码为空");
					return false;
				}
	    		
	    		if (codeboo == true) {
	    		
		    		$("#loginform").attr("action","<%= path %>/MemberAction_login.action");
		    		$("#loginform").submit();
		    		
	    		}else{
	    			alert("验证码错误，请重新输入");
	    			return false;
	    		}
	    	});

    </script>
  </body>
</html>
