<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>

<form class="example" action="getSearchedData">
  <input type="text" placeholder="Search.." name="search">
  <button type="submit">search</button>
</form>
<br> <br>
<hr>
	<table class="content-table" border="2">
		<thead>
			<tr>
				<th class="header">Post_Id</th>
				<th class="header">Author_Name</th>
				<th class="header">Title</th>
				<th class="header">Content</th>
				<th class="header">Created At</th>


			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="post" items="${posts}">
					<tr>
						<td>${post.id}</td>
						<td>${post.author}</td>
						<td>${post.title}</td>
						<td>${post.content}</td>
						<td>${post.createdAt}</td>
						<td>
							<form action="viewPost">
								<button type="submit" value="${post.id}" name="id">view</button>
							</form>
						</td>

					</tr>


				</c:forEach>
		</tbody>
	</table>
	<hr />
	<br />
	<form action="writePost">
		<button>write story</button>
	</form>



</body>
</html>