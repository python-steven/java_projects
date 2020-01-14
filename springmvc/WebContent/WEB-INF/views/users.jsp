<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JSTL Demo</title>
</head>
<body>
	<table cellpadding=0 cellspacing=0 border="1" width="80%">
		<thead>
			<tr>
				<th>UserName</th>
				<th>age</th>
				<th>salary</th>
				<th>marry</th>
				<th>interests</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users1 }" var="user">
			<tr>
				<td>${user.userName }</td>
				<td>${user.age }</td>
				<td>${user.salary}</td>
				<td>${user.isMarry}</td>
				<td>${user.interests[0]},${user.interests[1]}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
