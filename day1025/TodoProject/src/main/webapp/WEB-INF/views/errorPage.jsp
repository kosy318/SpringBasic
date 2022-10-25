<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>예외 페이지</title>
</head>
<body>
	<h1>예외 페이지</h1>
	<c:if test="${!empty errormsg}">
		${errormsg}
	</c:if>
	<a href="list">초기화면</a>
</body>
</html>