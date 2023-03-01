<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<div class="form" id="login">
		<h3 style="text-align: center; font-size: 30px">Login</h3>
		<form action="./login" method="post">
			<div class="form-login ">
				<input type="text" name="username" placeholder="Enter your usename" />
				<small></small>
			</div>

			<div class="form-login ">
				<input type="password" name="password" id="password"
					placeholder="Enter your password" /> <small> </small>
			</div>
			<br>
			<%
		if (session.getAttribute("errorlogin") != null) {
		%>
		<div class="alert alert-danger">
			<center><%=session.getAttribute("errorlogin")%></center>
		</div>
		<%
		session.removeAttribute("errorlogin");
		}
		%>
			<div class="form-login">
				<button type="submit" class="btn-submit">Login</button>
			</div>
			
		</form>
		
	</div>
<style type="text/css">
:root { 
--success-color: #2691d9; 
--error-color: #e74c3c;
}

body {
	height: 100vh;
	background: no-repeat;
	background-image: linear-gradient(120deg, #ac74e9, #9f6ad8);
}

* {
	padding: 0px;
	margin: 0px;
	box-sizing: border-box;
}

.form {
	width: 500px;
	margin: auto;
	border: 1px solid red;
	border-radius: 20px;
	background-color: white;
	padding: 10px 25px;
	margin-top: 15vh;
	align-items: center;
}

.form-login {
	width: 100%;
	position: relative;
	margin-top: 30px;
}

.form-login input {
	width: 100%;
	height: 40px;
	font-size: 16px;
	border: none;
	outline: none;
	border-bottom: 2px solid #adadad;
}

.form-login input:focus ~span {
	width: 100%;
}

.form-login small {
	color: var(--error-color);
}

.form-login input {
	border-bottom: 2px solid var(--success-color);
}

.btn-submit {
	width: 100%;
	height: 50px;
	border-radius: 25px;
	border: none;
	outline: none;
	background: var(--success-color);
	color: #fff;
	font-size: 18px;
	margin: 25px 0;
	font-weight: bold;
}

.btn-submit:hover {
	background: #08609a;
}
.alert-danger{
color: red}
</style>
</body>
</html>