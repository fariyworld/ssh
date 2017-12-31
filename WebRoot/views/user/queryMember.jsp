<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style>
	#memberInfo td{
		text-align: center;
	}
	
	#memberInfo td a{
		padding:0 5px;
	}
</style>
<div width="800px"  style="margin: 0 200px; margin-top: 100px">
 	<form action="">
 		<table style="width: 100%; height: 200px; margin: 0 auto" border="1">
 			<tr>
 				<td colspan="9"><h4>查看用户信息(查看全部用户)</h4></td>
 			</tr>
 			<tr>	
 				<th>ID编号</th>
 				<th>用户名</th>
 				<th>真实姓名</th>
 				<th>地址</th>
 				<th>邮箱</th>
 				<th>等级</th>
 				<th>激活状态</th>
 				<th>注册时间</th>
 				<th>操作</th>
 			</tr>
 			<tbody id="memberInfo">
 			</tbody>
 		</table>
 	</form>
 </div>
 <script type="text/javascript">
 	
 	$(function(){
 		init();
 	});
	function init(){
	 	var url = "json_Ajax_queryMember.action";
		$.post(url, function(data){
			var arr = data.memList;
			console.log(arr);
			var html = "";
			$(arr).each(function(index, value){
				var active = value.activeCode;
				var uid = value.uid;
				if(active !== null){
					active = "未激活";
				}else{
					active = "已激活";
				}
				html += "<tr><td>" + uid +"</td><td>"
					+ value.userName +"</td><td>"
					+ value.realName +"</td><td>"
					+ value.address +"</td><td>"
					+ value.email +"</td><td>"
					+ value.grade +"</td><td>"
					+ active +"</td><td>"
					+ value.regTime +"</td><td>"
					+ "<a href='javascript:;' tag='"+uid+"'>删除</a>"
					+ "<a href='javascript:;' tag='"+uid+"'>修改</a>"
					+ "</td></tr>";
			});
			$("#memberInfo").append(html);
		},"json");
	 }
 	
	//删除或者修改操作按钮
	$("#memberInfo").on("click","a[tag]",function(){
		var text = $(this).text();
	   	var uid = $(this).attr("tag");
	    if(text === "删除"){
	    	var flag = confirm("确定要删除该条信息吗？");
	    	if(flag){
	    		var url = "json_Ajax_deleteMember.action";
				console.log("调用ajax去action删除该条记录--用户id为---->"+ uid);	 
				$.post(url,{"uid":uid},function(data){
					alert(data.result);
					$("#memberInfo").empty();
					init(); 
				},"json");
	    	}
	    }else{
	    	/*
	    		1.发送请求，接收响应数据
	    		2.加载jsp --> 设置value（回显）
	    		3.显示div
	    	*/
	    	$("div.content").load("views/user/updateMember.jsp");
	    	var url = "json_Ajax_updateMember.action";
			//alert("调用ajax去action回显该条记录--用户id为---->"+ uid);	 
			$.post(url,{"uid":uid, "tips":"w"},function(data){
				var memberObject = data.member;
				console.log(memberObject);
				//回显数据 设置input的 value
				$("#updateAddress").val(memberObject.address);
				$("#updatePhone").val(memberObject.phone);
				$("#updateEmail").val(memberObject.email);
				$("#update_UID").val(uid);
				$("#updateMemberJSP").show();
			},"json");
	    }
		return false;
	});
	
 </script>
