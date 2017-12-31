<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>checking-in管理员考勤</h2>
<a href="javascript:;" id="checking-in">签到</a><br />
<a href="javascript:;" id="checking-out">签退</a><br />
<a href="javascript:;">考勤汇总（按月查看每月的考勤情况）---按月生成表格统计</a><br />
<table border="1" id="astable" style="display: none;">
  <tr>
    <th>日期：</th>
    <th>考勤状态</th>
  </tr>
  <tbody id="asbody">
  
  </tbody>
</table>
<br />
<h2 style="text-align: center">考勤日历表</h2>
<br />
<table border="1" style="width: 80%; height: 350px; text-align: center; margin: 0 auto">
 	<thead>
 		<tr>
	 		<th>日</th>	
	 		<th>一</th>	
	 		<th>二</th>	
	 		<th>三</th>	
	 		<th>四</th>	
	 		<th>五</th>	
	 		<th>六</th>
 		</tr>	
 	</thead>
 	<tbody>
 		<tr>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 			<td></td>
 		</tr>
 	</tbody>
 </table>


<script type="text/javascript">
	
	//签到
	$("div.content a").click(function(){
	
	<% 
		Integer uid = null;
		if( session.getAttribute("currentUserID") == null || session.getAttribute("currentUserID").equals("")){
	%>		
			alert("您还没有登录，请先去登录才能签到/签退/查看考勤汇总表");
	<% 		
		}else {
			uid = (Integer) session.getAttribute("currentUserID");
		}
	 %>
		var uid = <%= uid %>;
		console.log("id-->"+uid);
		if( uid ){
			var val = $(this).text();
			if( val === '签到' ){
				var url = "admin_Ajax_checking_in.action";
				$.post(url,{"checking_in_time":new Date().getTime(),"uid":uid},function(data){
					if(data.result === "checking-in failed"){
						alert("您已签到");
					}else{
						alert(data.result);
					}
				},"json");
			}else if(val === '签退'){
				var url = "admin_Ajax_checking_out.action";
				$.post(url,{"checking_out_time":new Date().getTime(),"uid":uid},function(data){
					if(data.result === "checking-out failed"){
						alert("1.您还没有签到,请先签到再签退  or 2.或者您已签退");
					}else{
						alert(data.result);
					}
				},"json");
			}else{
				
				var url = "admin_Ajax_checking_sum.action";
				$.post(url,{"uid":uid},function(data){
					alert(data.result);
					$("#asbody").empty();
					var map = data.asMap;
					var html = "";//asbody
					for ( var key in map){
						html += "<tr><td>"+ key + "</td><td>"+ map[key] +"</td><tr>";
					}
					console.log(html);
					$("#astable").show();
					$("#asbody").append(html);
				},"json");
			}
		}
		
	});
	
</script>