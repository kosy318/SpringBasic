<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TodoList</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="list">TodoList</a>

		<div class="collapse navbar-collapse" id="navb">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="qna-list">QnA</a></li>
				<li class="nav-item"><a class="nav-link"
					href="notice-list">공지사항</a></li>
			</ul>
			<jsp:include page="loginCheck.jsp"></jsp:include>
		</div>
	</nav>
</body>
</html>