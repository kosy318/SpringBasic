<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
</head>
<jsp:include page="nav.jsp" />
<body>
	<div class="container">
		<div class="py-5 text-center">
			<h1 class="h3 mb-3 font-weight-normal">회원가입</h1>
		</div>

		<div class="col-md-6 m-auto">
			<form id="signup" method="post" action="signup">
				<div class="mb-3">
					<label for="name"><span style="color: red">*</span>이름</label> <input
						type="text" class="form-control" id="name" name="name">
				</div>

				<div class="mb-3">
					<label for="id"><span style="color: red">*</span>아이디</label>
					<div class="input-group">
						<input type="text" class="form-control" id="id" name="id">
					</div>
				</div>

				<div class="mb-3">
					<label for="pw"><span style="color: red">*</span>비밀번호</label>
					<div class="input-group">
						<input type="password" class="form-control" id="pw"
							name="pw">
					</div>
				</div>

				<div class="mb-3">
					<label for="pw-confirm"><span style="color: red">*</span>비밀번호
						확인</label>
					<div class="input-group">
						<input type="password" class="form-control" id="pw-confirm"
							name="pw-confirm">
					</div>
				</div>

				<div class="mb-3">
					<label for="email">이메일</label> <input type="email"
						class="form-control" id="email" name="email" placeholder="email@example.com">
				</div>

				<button class="btn btn-info btn-lg btn-block" type="submit">회원
					가입</button>
			</form>
		</div>
	</div>
</body>
</html>