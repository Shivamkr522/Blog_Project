<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post Page</title>
</head>
<body>

	<form:form action="submitForm" method="post" modelAttribute="post">
		<form:hidden path="id"/>
		<form:input path="title" placeholder="Write the title"/>
		<br>
		<form:input path="excerpt" placeholder="Write the excerpt"/>
		<br>
		<form:input path="content" placeholder="Write the Content"/>
		<br>
		<form:input path="author" placeholder="Write the Author name"/>
		<br>
		<input type="submit" value="Submit">
	</form:form> 
	
</body>
</html>