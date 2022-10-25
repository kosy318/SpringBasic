<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
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
<body>
	<jsp:include page="nav.jsp" />
	<div class="container text-center pt-5">
		<h1>Todo List</h1>
<!-- 
		<form action="searchAll" method="get">
			검 색: <select name="search">
				<option value="content" selected="selected">내용</option>
				<option value="id">아이디</option>
			</select> <input type="text" name="word"> <input type="submit"
				value="검색">
		</form>
 -->
		<div class="text-right">
			<a href="insert" class="btn btn-info" role="button">할 일 추가</a>&nbsp;&nbsp;
			<a href="deleteAll" class="btn btn-info" role="button">전체 삭제</a>
		</div>
		<br>

		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>내용</th>
					<th>아이디</th>
					<th>날짜</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ todoList }" var="todo">
					<tr>
						<td>${ todo.num }</td>
						<c:if test="${ todo.done eq 'N' }">
							<td><a href="read?num=${ todo.num }">${ todo.content }</a></td>
						</c:if>
						<c:if test="${ todo.done eq 'Y' }">
							<td><a href="read?num=${ todo.num }"><del>${ todo.content }</del></a></td>
						</c:if>
						<td>${ todo.id }</td>
						<td>${ todo.sdate }~${ todo.edate }</td>
						<c:if test="${ todo.done eq 'N' }">
							<td><input
								onchange="window.location.href='change?done=${ todo.done }&num=${ todo.num }'"
								class="form-check-input" name="done" type="checkbox"></td>
						</c:if>
						<c:if test="${ todo.done eq 'Y' }">
							<td><input
								onchange="window.location.href='change?done=${ todo.done }&num=${ todo.num }'"
								class="form-check-input" name="done" type="checkbox"
								checked="checked"></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>



