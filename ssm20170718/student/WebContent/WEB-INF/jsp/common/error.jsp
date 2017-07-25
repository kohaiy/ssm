<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作失败！</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div style="text-align:center;padding:50px 0;margin-top: 20px;" class="bg-danger">
	<div>
		<span style="font-size:100px;" class="text-danger"><span class="glyphicon glyphicon-remove"></span></span>
		<span style="position: relative; top: -20px;" class="h3">${msg }操作失败！</span>
	</div>
	<p>【 <span id="time">${timeout}</span> 】秒后页面<a href="<c:choose><c:when test="${url!=null}">${url}</c:when><c:otherwise>javascript:window.history.go(-1);</c:otherwise></c:choose>">跳转</a>！<a href="javascript:clearInterval(tip);">停止跳转</a></p>
</div>

<script type="text/javascript">
	var tip,t=${timeout};
	var time = document.getElementById('time');
	tip = setInterval(function(){
		time.innerHTML = t;
		t--;
		if(t<0){
			<c:choose><c:when test="${url!=null}">window.location='${url}';</c:when><c:otherwise>window.history.go(-1);</c:otherwise></c:choose>
		}
	},1000);
</script>
</body>
</html>