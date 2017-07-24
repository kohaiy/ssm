<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student List</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<table class="table table-hover">
		<caption class="text-center">Student List</caption>
		<thead>
			<tr>
				<td>id</td>			
				<td>name</td>			
				<td>password</td>			
				<td>age</td>			
				<td>gender</td>			
				<td>email</td>			
				<td>phone</td>			
				<td>create_time</td>			
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${studentList}" var="student">
			<tr>
				<th>#${student.id }</th>
				<td>${student.name }</td>
				<td>${student.password }</td>
				<td>${student.age }</td>
				<td>${student.gender }</td>
				<td>${student.email }</td>
				<td>${student.phone }</td>
				<td><fmt:formatDate value="${student.create_time }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>	
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>