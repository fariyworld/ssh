<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

 <div width="800px"  style="margin: 0 200px; margin-top: 100px; display: none" id="updateMemberJSP">
 	<h2>更改用户信息,用户只能更改地址，手机号，邮箱</h2>
 	<form action="" method="post" id="updateMemberForm">
 		<table style="width: 20%; height: 200px; margin: 0 auto">
 			<tbody id="memberUpdateInfo">
 				<tr>
 					<td>地址：</td>
 					<td><input type="text" name="member.address" value="" id="updateAddress"/></td>
 				</tr>
 				<tr>
 					<td>手机号：</td>
 					<td><input type="text" name="member.phone" value="" id="updatePhone"/></td>
 				</tr>
 				<tr>
 					<td>邮箱：</td>
 					<td><input type="text" name="member.email" value="" id="updateEmail"/></td>
 				</tr>
 			
 			</tbody>
 			<tr>
 				<td colspan="2" style="text-align: center;">
 					<input type="hidden" value="" name="member.uid" id="update_UID"/>
 					<input type="button" id="updateMember" value="确认修改">
 				</td>
 			</tr>
 		</table>
 	</form>
 </div>
<script type="text/javascript">
	//点击确认修改按钮
	$("#updateMember").click(function(){
		var uid = $("#update_UID").val();
		console.log(uid);
		//发出更新用户信息的请求,$("#updateMemberForm").serialize()
		var url = "json_Ajax_updateMember.action?tips=u";
		$.post(url,$("#updateMemberForm").serialize(),function(data){
			alert(data.result);
		},"json");
	});
</script>
