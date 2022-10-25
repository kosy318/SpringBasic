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
			<form class="form-inline my-2 my-lg-0" action="searchAll" method="get">
				<select class="form-control" name="search">
					<option value="content" selected="selected">내용</option>
					<option value="id">아이디</option>
				</select>&nbsp;&nbsp;
				<input class="form-control mr-sm-2" type="text"
					name="word">
				<button class="btn btn-info my-2 my-sm-0" type="submit">검색</button>
			</form>&nbsp;&nbsp;
			<jsp:include page="loginCheck.jsp"></jsp:include>
		</div>
	</nav>
</body>
</html>