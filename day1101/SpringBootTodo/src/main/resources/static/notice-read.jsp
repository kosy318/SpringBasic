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
		<h1>공지 no.${ notice.num }</h1>

		<br>
		<table class="table table-bordered">
			<TR>
				<TH>TITLE</TH>
				<TD COLSPAN=3>${ notice.title }</TD>
			</TR>
			<TR>
				<TH>등록 날짜</TH>
				<TD>${ notice.regdate }</TD>
				<TH>조회수</TH>
				<TD>${ notice.count }</TD>
			</TR>
			<TR style="height: 300px">
				<TH>CONTENT</TH>
				<TD COLSPAN=3>${ notice.content }</TD>
			</TR>
		</TABLE>
		<c:if test="${ user.id eq 'admin' }">
			<a href="notice-modify?num=${ notice.num }">수정하기</a>&nbsp;&nbsp;
		<a href="notice-delete?num=${ notice.num }">삭제하기</a>&nbsp;&nbsp;
		</c:if>
		<a href="notice-list">공지 목록</a> <br> <br>
	</div>
</body>
</html>






