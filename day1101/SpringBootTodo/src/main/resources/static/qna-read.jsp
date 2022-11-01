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
		<h1>질문 no.${ qna.num }</h1>

		<br>
		<div class="container text-right mb-1">
			<c:if test="${ user.id eq 'admin' }">
				<button id="answer" onclick="show()" type="submit" class="btn btn-info">답 달기</button><br>
			</c:if>
		</div>
		<table class="table table-bordered">
			<TR>
				<TH>TITLE</TH>
				<TD COLSPAN=3>${ qna.title }</TD>
			</TR>
			<TR>
				<TH>등록 날짜</TH>
				<TD>${ qna.regdate }</TD>
				<TH>조회수</TH>
				<TD>${ qna.count }</TD>
			</TR>
			<TR style="height: 300px">
				<TH>CONTENT</TH>
				<TD COLSPAN=3>${ qna.content }</TD>
			</TR>
			<c:if test="${ qna.answer ne null }">
			<TR style="height: 300px">
				<TH>ANSWER</TH>
				<TD COLSPAN=3>${ qna.answer }</TD>
			</TR>
			</c:if>
		</TABLE>
		<form class="row align-items-center" style="display: none" method="post" action="answer" id="answer-container">
			<input type="hidden" name="num" value="${ qna.num }">
			<div class="container text-right mb-2">
				<div class="btn-group">
					<button type="submit" class="btn btn-info">등록</button>
					<div class="btn btn-info" onclick="hide()">취소</div>
				</div>
			</div>
			<textarea class="form-control" rows="2" id="answer-content" name="answer"></textarea>
		</form>
		<div class="btn-group">
		<c:if test="${ user.id eq qna.id }">
			<a type="button" class="btn btn-info" href="qna-modify?num=${ qna.num }">수정하기</a>
			<a type="button" class="btn btn-info" href="qna-delete?num=${ qna.num }">삭제하기</a>
		</c:if>
		<a type="button" class="btn btn-info" href="qna-list">qna 목록</a>
		</div>
		 <br> <br>
	</div>
	<script>
		function show(){
			document.getElementById("answer-container").setAttribute("style", "display:");
			document.getElementById("answer").setAttribute("style", "display: none");
		}
		function hide(){
			document.getElementById("answer").setAttribute("style", "display:");
			document.getElementById("answer-container").setAttribute("style", "display: none");
		}
	</script>
</body>
</html>






