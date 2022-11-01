<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Bootstrap Example</title>
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
<body>
	<div class="container text-center">
		<img src="resources/image/f1.jpg" />
		<h1>spring MVC 게시판</h1>
		<jsp:include page="loginCheck.jsp" />
		
		<form action="search" method="get">
			<select name="search">
				<option value="title" selected="selected">제목</option>
				<option value="name">글쓴이</option>
			</select> 
			<input type="text" name="word">
			<button type="submit" class="btn btn-primary">검색</button>
		</form>
		<hr>
		<div class="container" id="result">
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ list }" var="row">
					<tr>
						<td>${ row.num }</td>
						<td onmouseover="show(${ row.num })"><a href="read?num=${ row.num }">${ row.title }</a></td>
						<td>${ row.name }</td>
						<td>${ row.wdate }</td>
						<td>${ row.count }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br> <a href="insert">새글쓰기</a> <br>
	</div>
	
	<script type="text/javascript">
		function show(num){
			// 서버로 비동기 요청해서 결과 받아오기(num을 전달)
			fetch("http://localhost:8080/mvc/show?num=" + num)
			.then(response => response.json())
			.then(data => {
				console.log(data);
				showResult(data); // 서버에서 온 결과 data를 화면에 출력해주는 함수				
			})
		}
		
		function showResult(data){ // 서버에서 온 결과 data를 화면에 출력해주는 함수	
			let result = document.getElementById("result");
			result.innerHTML = `<h4>\${data.title}</h4><p>\${data.content}</p>`;
		}
	</script>
</body>
</html>



