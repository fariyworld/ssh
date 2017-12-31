<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>会员注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
		#register{
				margin:50px 0;
				margin-left: 40%;
			}
	</style>
  </head>
  
  <body>
  	<%@include file="/views/base/head.jsp" %>
  	
  	<div id="register">
		<form action="" method="post" id="regform">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td>*用户名：</td>
					<td><input type="text" id="userName" name="member.userName" value="" /></td>
				</tr>
				<tr>
					<td>真实姓名：</td>
					<td><input type="text" id="realName" name="member.realName" value="" /></td>
				</tr>
				<tr>
					<td>*密码：</td>
					<td><input type="password" id="password" name="member.password" value="" /></td>
				</tr>
				<tr>
					<td>*确认密码：</td>
					<td><input type="password" id="apassword" name="apassword" value="" /></td>
				</tr>
				<tr>
					<td>*邮箱：</td>
					<td><input type="text" id="email" name="member.email" value="" /></td>
				</tr>
				<tr>
					<td>*验证码 :</td>
					<td><input type="text" id="code" name="code" value=""/>
						<img alt="验证码" src="<%= path %>/servlet/VerifyCodeServlet" id="imgcode" />
						<a href="javascript:reload();" style="font-size: 8px">看不清楚，换一张</a>
					</td>
				</tr>
				<tr>
					<td><input type="button" id="btn" value="注册"/></td>
					<td><input type="reset" value="重置"/></td>
				</tr>
			</table>
		</form>
  	</div>
 	
    <script src="resources/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" language="javascript">
    	
			//验证用户名的合法性 原生JS+Ajax
   			var boo = true;
			$("#userName").blur(checkUserName);
			function checkUserName(){
				var msg = "";
				var urls = "servlet/ServletUtils";
				var userName = document.getElementById("userName").value;
				var xmlrequest = new XMLHttpRequest();
				xmlrequest.open("post", urls, true);
				xmlrequest.onreadystatechange = function (){
					if( xmlrequest.readyState == 4 && xmlrequest.status == 200){
						msg = xmlrequest.responseText;
						if( msg === ""){
							boo = true;
							//用户名验证合法后去数据库验证是否存在
							userNameisExist();
						}else{
							alert(msg);
							boo = false;
						}
					}
				};
				xmlrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xmlrequest.send("userName=" + userName + "&idt=2");
				
			}
			
			//验证用户名是否已存在
			function userNameisExist(){
				var val = $("#userName").val();
				$.ajax({
   		
		    		async:false,
		    		type: "post",
		    		url: "json_Ajax_checkUserNameisExist.action",
		    		data:{"userName": val },
		    		dataType:"json",
		    		success: function(data){
		    			if(data.result === "1"){
		    				alert("当前用户名已注册，换一个");
		    			}
		    		}
   		
   				});
			}
		
			//jquery框架
			//验证密码的合法性 jquery
			$("#password").blur(checkUserPWD);
			function checkUserPWD(){
				var val = $("#password").val();
				var regEx = /^\w{6,20}$/;
				if( val ){
					if( regEx.test(val) ){
						if( val.length < 8 ){//弱
							//alert("有被盗风险,建议使用字母、数字和符号两种及以上组合");
						}else if( 8 < val.length < 12 ){//适中
							//alert("安全强度适中，可以使用三种以上的组合来提高安全强度");
						}else{//强
							//alert("你的密码很安全");
						}
						return true;				
					}else{
						alert("长度只能在6-20个字符之间");
						return false;
					}
				}else{
					alert("密码不能为空");
					return false;
				}
			}
			
			//验证两个密码框是否一致
			$("#apassword").blur(checkAuserPWD);
			function checkAuserPWD(){
				var val = $("#apassword").val();
				var val2 = $("#password").val();
				if( val === val2 ){
					return true;
				}else{
					alert("两次密码输入不一致");
					return false;
				}
			}
			
			//验证邮箱的合法性
			$("#email").blur(checkEmailbox);
			function checkEmailbox(){
				var val = $("#email").val();
				var aeindex = val.indexOf('@');
				var adindex = val.lastIndexOf('.');
				if( aeindex<1 || adindex< aeindex+2 || val.length <= adindex+2 ){
					alert("您的邮箱地址不合法");
					return false;
				}else{
					return true;
				}
			}
			
			//验证真实姓名 只接受中文字符
			$("#realName").blur(checkRealName);
			function checkRealName(){
				var val = $("#realName").val();
				var regEx = /^[\u2E80-\u9FFF]+$/;
				if( val ){
					if( regEx.test(val)){
						//alert("姓名ok");//实名认证+身份证，后期完善个人资料
						return true;
					}else{
						alert("姓名格式错误");
						return false;
					}
				}else{
					alert("姓名不能为空");
					return false;
				}
			}
			
			//验证图片验证码checkCode
			reload();
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
			
			function reload(){
				
				$("#imgcode").attr("src","<%= path %>/servlet/VerifyCodeServlet?date="+ new Date().getTime());
				$("#code").val("");
			}
			
			//是否提交表单
			$("#btn").click(function(){
			    
				//input没有触发失焦事件
				if( $("#userName").val() === "" ){
					alert("用户名为空");
					return false;
				}else if( $("#password").val() === "" ){
					alert("密码为空");
					return false;
				}else if( $("#apassword").val() === "" ){
					alert("再一次输入密码为空");
					return false;
				}else if( $("#email").val() === "" ){
					alert("邮箱为空");
					return false;
				}else if( $("#code").val() === "" ){
					alert("验证码为空");
					return false;
				}
				
				//触发失焦事件
				if( boo == false){
					alert("用户名有误");
					return false;
				}else if( checkUserPWD() === false ){
					alert("密码有误");
					return false;
				}else if( checkAuserPWD() === false ){
					alert("第二次密码有误");
					return false;
				}else if( checkEmailbox() === false ){
					alert("邮箱有误");
					return false;
				}else if( checkRealName() === false ){
					alert("真实姓名有误");
					return false;
				}else if( codeboo == false ){
					alert("验证码有误");
					return false;
				}else{
					//全部通过 开始Ajax请求注册用户
					//Ajax注册用户
					alert("全部通过 开始Ajax请求注册用户");
					
					$.ajax({
	   		
			    		async:false,
			    		type: "post",
			    		url: "json_Ajax_register.action",
			    		data:$("#regform").serialize(),
			    		dataType:"json",
			    		success: function(data){
			    			alert(data.result);
			    		}
	   		
	   				});
				}
			});
    	
    </script>
  </body>
</html>
