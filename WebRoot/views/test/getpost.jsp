<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<input type="button" id="btn1" value="test get" />


<script type="text/javascript">

	$("#btn1").click(function() {

		alert("get");

		function createXHR() {
			if (window.XMLHttpRequest) {
				return new XMLHttpRequest();
			} else {
				return new ActiveXObject('MicroSoft.XMLHTTP');
			}
		}
		function addParams(url, name, value) {
			//先判断url有没有‘？’，若果无，加参数时需要补上，如果已经有了，则不需在加‘？’
			url += url.indexOf('?') == -1 ? '?' : '&';
			url += escape(encodeURIComponent(name)) + '=' + encodeURIComponent(value);
			return url;
		}
		var xhr = createXHR();
		var url = "admin_Ajax_testGet.action";
		url = addParams(url, 'getParam', 'g&uoyu'); //注意这里特殊符号
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					alert(xhr.responseText);
				} else {
					alert('获取数据错误,错误代码：' + xhr.status + '错误信息：' + xhr.statusText);
				}
			}

		}
		xhr.open('get', url, true);
		//设置请求头信息，比如添加一些信息
		xhr.setRequestHeader('myname', 'guoyu');
		xhr.send(null);

	});
</script>