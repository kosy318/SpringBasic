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
	<jsp:include page="nav.jsp" />
	<div class="container text-center pt-5">
		<h1>todo no.${ todo.num }</h1>

		<br>
		<table class="table table-bordered">
			<TR>
				<TH>DONE</TH>
				<TD>${ todo.done }</TD>
				<Th>NAME</TH>
				<TD>${ todo.id }</TD>
			</TR>
			<TR>
				<TH>start</TH>
				<TD>${ todo.sdate}</TD>
				<TH>end</TH>
				<TD>${ todo.edate }</TD>
			</TR>
			<TR>
				<TH>CONTENT</TH>
				<TD COLSPAN=3>${ todo.content}</TD>
			</TR>
		</TABLE>
		<a href="complete?num=${ todo.num }">완료</a>&nbsp;&nbsp;
		<a href="modify?num=${ todo.num }">수정하기</a>&nbsp;&nbsp;
		<a href="delete?num=${ todo.num }">삭제하기</a>&nbsp;&nbsp;
		<a href="list">초기화면</a> 
		 <br> <br>
	</div>
</body>
</html>






