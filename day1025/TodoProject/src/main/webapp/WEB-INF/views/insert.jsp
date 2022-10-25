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
		<h1>할 일 추가</h1>
		<form action="insert" method="post">
			<div class="row">
				<div class="form-group text-left col-sm-4">
					<label for="id">아이디:</label> <input type="text"
						class="form-control" name="id">
				</div>
				<div class="form-group text-left col-sm-4">
					<label for="sdate">시작 날짜 : </label> <input type="date"
						class="form-control" name="sdate">
				</div>
				<div class="form-group text-left col-sm-4">
					<label for="edate">종료 날짜 : </label> <input type="date"
						class="form-control" name="edate">
				</div>
			</div>
				<div class="form-group text-left">
					<label for="content">내 용:</label>
					<textarea class="form-control" rows="2" id="content" name="content"></textarea>
				</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<a href="list">전체화면</a>
		<br>
		<br>
	</div>

</BODY>
</HTML>











