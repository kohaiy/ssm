<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作失败！</title>
</head>
<body>
<p><span style="font-size: 200px;">:(</span> <h1>操作失败！</h1></p>
<p>【 <span id="time">3</span> 】秒后页面<a href="javascript:window.history.go(-1);">跳转</a>！<a href="javascript:clearInterval(tip);">停止跳转</a></p>
<script type="text/javascript">
	var tip,t=3;
	var time = document.getElementById('time');
	tip = setInterval(function(){
		time.innerHTML = t;
		t--;
		if(t<0){
			window.history.go(-1);
		}
	},1000);
</script>
</body>
</html>