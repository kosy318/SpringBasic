<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="text-center">
	<main class="form-signin m-auto mt-5" style="width: 500px">
		<form action="login" id="f" method="post">
			<h1 class="h3 mb-3 fw-normal">로그인 정보</h1>

			<div class="form-floating">
				<input type="text" class="form-control" id="id" name="id"
					placeholder="id"> <label for="floatingInput">아이디</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="pass" name="pass"
					placeholder="Password"> <label for="floatingPassword">비밀번호</label>
			</div>

			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary" type="submit">Send</button>
			<button class="btn btn-lg btn-primary" type="reset">Clear</button>
		</form>
	</main>
</body>
</html>