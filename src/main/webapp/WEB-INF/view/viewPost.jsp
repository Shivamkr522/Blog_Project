<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Title: ${post.title}
	<br>
	Excerpt: ${post.excerpt}
	<br>
	Content: ${post.content}
	<br>
	Author: ${post.author}
	<br>
	Created At: ${post.createdAt}
	<br>
	Updated At: ${post.updatedAt}
	<br>
	
	<form action="editPost">
		<button type="submit" value="${post.id}" name="id">Edit</button>
	</form>
	
	<form action="deletePost">
		<button type="submit" value="${post.id}" name="id" >Delete</button>
	</form>
	
	
	<form:form action="addComment" method="post" modelAttribute="commentnew">
	<%-- 	<form:hidden path="id"/> --%>
		<form:input path="name" placeholder="Write your name"/>
		<br>
		<form:input path="email" placeholder="Write the email"/>
		<br>
		<form:input path="comment" placeholder="Write the comment"/>
		<br>
		<button type="submit" name="id" value="${post.id}">Comment</button>
	</form:form> 
	
	
	Comments
	<br>
	
		<c:forEach var="comment" items="${post.comment}">
			<br>
			Name: ${comment.name}
			<br>
			Comment: ${comment.comment}
			<br>
			<form action="editComment">
				<button type="submit" value="${comment.id}" name="commentId">Edit</button>
			</form>
		</c:forEach>
	
	<form action="/Blog_proj/" method="post">
		<input type="submit" value="Return to Main Page">
	</form>
	
	
	
</body>
</html>