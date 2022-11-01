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
		<h1>질문 추가</h1>
		<form action="qna-insert" method="post">
			<input type="hidden" id="id" name="id" value=${ user.id }>
			<div class="form-group text-left">
				<label for="title">제 목:</label> <input class="form-control"
					id="title" name="title">
			</div>
			<div class="form-group text-left">
				<label for="content">내 용:</label>
				<textarea class="form-control" rows="5" id="content" name="content"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<a href="qna-list">qna 목록</a> <br> <br>
	</div>

</BODY>
</HTML>











