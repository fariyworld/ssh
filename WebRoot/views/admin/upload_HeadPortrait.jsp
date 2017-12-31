<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>管理员上传(更改)头像</h2>
<form action="" method="post" enctype="multipart/form-data" id="upload">
	<input type="file" id="photo" name="photo" />
	<input type="button" id="hpbtn" value="上传" />
</form>
<script src="resources/js/ajaxfileupload.js"></script>
<script type="text/javascript">

	//上传头像
	$("#hpbtn").click(function(){
	
	<% 
		Integer uid = null;
		if( session.getAttribute("currentUserID") == null || session.getAttribute("currentUserID").equals("")){
	%>		
			alert("您还没有登录，请先去登录才能上传头像");
	<% 		
		}else {
			uid = (Integer) session.getAttribute("currentUserID");
		}
	 %>
		var uid = <%= uid %>;
		if( uid ){
				//上传文件
				$.ajaxFileUpload({
					url : 'admin_Ajax_upload_HP.action',//用于文件上传的服务器端请求地址  
					secureuri : false,//一般设置为false  
					fileElementId : 'photo',//文件上传空间的id属性  <input type="file" id="file" name="file" />  
					dataType : 'json',//返回值类型 一般设置为json
					data:{"uid":uid},  
					success : function(data) //服务器成功响应处理函数  
					{
						alert(data.result);//从服务器返回的json中取出message中的数据,其中message为在struts2中定义的成员变量  
					}
				});
			}
		});
</script>