<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="text-center p-5 m-auto" style="width: 500px">
		<form class="form-signin" action="login" method="post">
			<h1 class="h3 mb-3 font-weight-normal">로그인</h1>
			<input type="text" class="form-control" placeholder="아이디" name="id">
			<input type="password" class="form-control" placeholder="비밀번호" name="pw">
			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me" id="remember">
					아이디 저장
				</label>
			</div>
			<button class="btn btn-lg btn-info btn-block" type="submit">로그인</button>
		</form>
			<a href="signup" class="mt-1 btn btn-lg btn-info btn-block" role="button">회원가입</a>
	</div>
</body>
</html>