<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 
			form:form是form标签。
				action属性是提交给服务器的地址
				method 是提交的方式
				modelAttribute是form标签需要关联的表单对应模型
		 -->
		<form:form action="${ pageContext.request.contextPath }/hello2/save.do" method="post" modelAttribute="user">
			<!-- form:input 相当于一个普通的输入框类型。
					path属性就是生成的表单项的name属性，然后它可以找到表单对象模型中的属性进行输出
			 -->
			userName:<form:input path="userName"/><br/>
			age:<form:input path="age"/><br/>
			salary:<form:input path="salary"/><br/>
			isMarry:<form:checkbox path="isMarry"/><br/>
			interests:<form:checkbox path="interests" value="football1"/>football
			<form:checkbox path="interests" value="basketball"/>basketball
			<form:checkbox path="interests" value="vollyball"/>vollyball
			<input type="submit" />
		</form:form>
	</body>
</html>
