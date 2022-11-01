<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<HTML>
<head>
<title>TodoList</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<BODY>
	<jsp:include page="nav.jsp" />
	<div class="container text-center pt-5">
		<h1>공지 수정 </h1>
		<form action="notice-modify" method="post">
			<input type="hidden" id="num" name="num" value="${ notice.num }">
			<div class="form-group text-left">
				<label for="content">제 목:</label> <input class="form-control"
					id="title" name="title" value="${ notice.title }">
			</div>
			<div class="form-group text-left">
				<label for="content">내 용:</label>
				<textarea class="form-control" rows="5" id="content" name="content">${ notice.content }</textarea>
			</div>
			<button type="submit" class="btn btn-primary">수정하기</button>
		</form>
		<a href="notice-list">공지 목록</a> <br> <br>
	</div>

</BODY>
</HTML>











