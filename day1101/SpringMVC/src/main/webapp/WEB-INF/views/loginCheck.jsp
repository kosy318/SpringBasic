<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<body>
<c:if test="${empty id}">
	<a href="login">로그인</a>
</c:if>

<c:if test="${!empty id}">
	Welcome, ${id}!!!
	<a href="logout">로그아웃</a>
</c:if>

</body>
</html>