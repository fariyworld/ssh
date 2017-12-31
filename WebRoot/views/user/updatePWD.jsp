<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div width="800px"  style="margin: 0 200px; margin-top: 100px">
	
	<form action="" method="post" id="updatePWD">
		<input type="hidden" name="member.uid" value="${currentUserID }" />
		<table style="width: 40%; height: 200px; margin: 0 auto">
			<tr>
				<td colspan="2">修改密码<br /></td>
			</tr>
			<tr>
				<td>旧密码：</td>
				<td><input type="password" id="oldpwd" value=""/></td>
			</tr>
			<tr>
				<td>新密码：</td>
				<td><input type="password" id="newpwd" value=""/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="确定" /></td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript">

	$(":button").click(function(){
	
	<% 
		Integer uid = null;
		if( session.getAttribute("currentUserID") == null || session.getAttribute("currentUserID").equals("")){
	%>		
			alert("您还没有登录，请先去登录才能修改密码");
	<% 		
		}else {
			uid = (Integer) session.getAttribute("currentUserID");
		}
	 %>
	 	var uid = <%= uid%>;
	 	
	 	if(uid){
		 	var pwd = $("#oldpwd").val();
		 	if(pwd){
		 		var url = "json_Ajax_checkPWD.action";
			 	var data = {"uid":uid ,"pwd": pwd };
			 	
			 	var boocheckpwd = true;
			 	
				$.post(url,data,function (data){
					console.log(data.result);
					if ( data.result === '1'){
						boocheckpwd = true;
					}else{
						boocheckpwd = false;
					}
				},"json");
				
				if(boocheckpwd){
					alert("去修改密码");
					var newpwd = $("#newpwd").val();
					// judge new password is not null?
					var updateurl = "json_Ajax_updatePWD.action";
					var update_data = {"uid":uid ,"pwd": newpwd };
					$.post(updateurl, update_data, function(data){
						alert(data.result);
					},"json");
				}else{
					alert("原密码错误");
				}
		 	}else{
		 		alert("please enter old password");
		 	}
	 	}

	});


</script>