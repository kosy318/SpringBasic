<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>RESTful 웹서비스 클라이언트(JSON)</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body onload="selectAll()">
	<div class="container">
		<form id="form1" class="form-horizontal mt-5">
			<h2>Customer Management</h2>
			<div class="form-group">
				<label>번호:</label> <input type="text" class="form-control" id="num">
			</div>
			<div class="form-group">
				<label>이름:</label> <input type="text" class="form-control" id="name">
			</div>

			<div class="form-group">
				<label>주소:</label> <input type="text" class="form-control"
					id="address">
			</div>

			<div class="btn-group">
					<input type="button" class="btn btn-secondary" value="등록"	id="btnInsert" onclick="customerInsert()" /> 
					<input type="button"class="btn btn-secondary" value="수정" id="btnUpdate"	onclick="customerUpdate()" /> 
					<input type="button"class="btn btn-secondary" value="삭제" id="btnDelete" onclick="customerDelete()" />
					<input type="button"class="btn btn-secondary" value="검색" id="btnSearch" onclick="customerSearch()" />
					<input type="button"class="btn btn-secondary" value="전체" id="btnAll" onclick="selectAll()" />
					<input type="button" class="btn btn-secondary" value="초기화" id="btnInit" onclick="init()" />
			</div>
		</form>
	</div>
	<hr />
	<div class="container">
		<h2>사용자 목록</h2>
		<table class="table text-center">
			<thead>
				<tr>
					<th class="text-center">번호</th>
					<th class="text-center">이름</th>
					<th class="text-center">주소</th>
				</tr>
			</thead>
			<tbody id="tb"></tbody>
		</table>
	</div>
	
	<script type="text/javascript">
		let root = "http://localhost:8080/rest"
	
		function selectAll(){ // 모든 고객 정보 받아오기
			fetch(root+"/customers")
				.then(response => response.json())
				.then(data => selectAllResult(data));
		}
		
		function selectAllResult(customers){
			let tbody = ``;
			
			customers.forEach(function(customer){
				tbody += `<tr onclick=selectOne(\${customer.num})>\
							  <td>\${customer.num}</td>\
							  <td>\${customer.name}</td>\
							  <td>\${customer.address}</td></tr>`;
			});
			
			document.querySelector("#tb").innerHTML = tbody;
		}
		
		function selectOne(num){
			fetch(root+"/customers/"+num)
			.then(response => response.json())
			.then(data => selectOneResult(data));
		}
		
		function selectOneResult(customer){
			let num = document.querySelector("#num");
			let name =  document.querySelector("#name");
			let address = document.querySelector("#address");
			
			if(customer != ""){
				num.value = customer.num;
				name.value = customer.name;
				address.value = customer.address;
			}else{
				num.value = customer;
				name.value = customer;
				address.value = customer;
			}
		}
		
		function init(){
			selectOneResult("");
		}
		
		function customerInsert(){
			let num = document.querySelector("#num").value;
			let name =  document.querySelector("#name").value;
			let address = document.querySelector("#address").value;

			if(num != "" && name != "" && address != ""){
				let config = {method : "POST",
							headers : {
								"Content-Type" : "application/json",
							},
							body : JSON.stringify({
								"num" : num,
								"name" : name,
								"address" : address
							}),
						};
				
				fetch(root+"/customers", config)
					.then(response => {
						selectAll();
						init();
					});
			} else {
				alert("추가할 값을 입력해 주세요!!");
			}
		}
		
		function customerDelete(){
			let num = document.querySelector("#num").value;

			if(num != ""){
				let config = {method : "DELETE"};
				
				fetch(root+"/customers", config)
					.then(response => {
						selectAll();
						init();
					});
			} else {
				alert("삭제할 값을 입력해 주세요!!");
			}
		}
		
		function customerUpdate(){
			let num = document.querySelector("#num").value;
			let address = document.querySelector("#address").value;
			
			if(num != ""){
				let config = {method : "PUT",
						headers : {
							"Content-Type" : "application/json",
						},
						body : JSON.stringify({
							"num" : num,
							"address" : address
						}),
					};
				
				fetch(root+"/customers", config)
					.then(response => {
						selectAll();
						init();
					});
			} else {
				alert("수정할 값을 입력해 주세요!!");
			}
		}
		
		function customerSearch(customer){
			let address = document.querySelector("#address").value;
			
			fetch(root+"/customers/find/"+address)
				.then(response => response.json())
				.then(data => selectAllResult(data));
		}
		
	</script>
</body>
</html>





