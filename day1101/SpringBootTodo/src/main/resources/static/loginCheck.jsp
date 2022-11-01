<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<body>
<c:if test="${empty user}">
	<a href="login" class="btn btn-outline-info" role="button">로그인</a>
</c:if>

<c:if test="${!empty user}">
	<span style="color: white">Welcome, <b>${ user.name }(${ user.id })</b></span>&nbsp;&nbsp;&nbsp;
	<a href="logout" class="btn btn-outline-info" role="button">로그아웃</a>
</c:if>

</body>
</html>