<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Rubik:wght@500&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link href="resources/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div>
		<div class="">
			<div class="brand-logo">Car Renting</div>
			<div class="brand-phone">
				<div class="register">
					<a href="HomeController"><span class="register-title">0334386995</span></a>
				</div>
			</div>
			<div class="text-center">
				<nav class="top-bar-wrap">
					<ul class="top-bar">
						<li class="nav-item"><a href="/" class="nav-link"><span
								class="inner-link">Home</span></a></li>
						<li class="nav-item"><a href="/" class="nav-link"><span
								class="inner-link">Reviews</span></a></li>
						<li class="nav-item"><a href="/" class="nav-link"><span
								class="inner-link">History</span></a></li>
						<li class="nav-item"><a href="/" class="nav-link"><span
								class="inner-link">Profile</span></a></li>
					</ul>
				</nav>
				<nav class="main-nav-wrap">
					<div class="main-nav">
						<div class="nav-item-scroll">
							<div id="scrollContent">
								<div>Đây là mẫu bài viết về món ăn thông dụng thường thấy
									trong quá trình hoạt động ở nhà hàng. Việc chia sẻ thêm nhiều
									món ăn mới sẽ giúp khách hàng cũ thích thú và quay lại, kèm
									theo đó thu hút thêm khách hàng mới trải nghiệm những món ăn lạ
									của riêng nhà hàng.</div>
							</div>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</div>


	<div class="login-reg-panel">
		<div class="login-info-box">
			<h2>Have an account?</h2>
			<p>Login Now</p>
			<label id="label-register" for="log-reg-show">Login</label> <input
				type="radio" name="active-log-panel" id="log-reg-show"
				checked="checked">
		</div>

		<div class="register-info-box">
			<h2>Don't have an account?</h2>
			<p>Regíter Now</p>
			<label id="label-login" for="log-login-show">Register</label> <input
				type="radio" name="active-log-panel" id="log-login-show">
		</div>

		<div class="white-panel">
			<div class="login-show" id="formlogin">
				<h2>LOGIN</h2>
				<c:if test="${not empty MESSAGE}">
					<div style="text-align: center; font-size: 15px; color: red;">${MESSAGE}</div>
				</c:if>
				<form action="/login" method="POST">
					<div class="form-group">
						<input type="text" placeholder="Email" id="email" name="email">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" id="password"
							name="password">
					</div>
					<input type="submit" class="btn btn-base"
						style="padding: 10px 20px; background-color: darkgray">
				</form>
				<a href="">Forgot password?</a>
			</div>
			<div class="register-show">
				<h2>REGISTER</h2>
				<c:if test="${not empty MESSAGE}">
					<div style="text-align: center; font-size: 15px; color: green;">${MESSAGE}</div>
				</c:if>
				<div id="mess"
					style="color: greenyellow; font-size: 18px; text-align: center"></div>
				<form action="/register" method="post">
					<div class="form-group">
						<input type="text" placeholder="CustomerID" id="customerID"
							name="customerID">
					</div>
					<div class="form-group">
						<input type="text" placeholder="CustomerName" id="customerName"
							name="customerName">
					</div>
					<div class="form-group">
						<input type="text" placeholder="Email" id="fullName" name="email">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" id="password1"
							name="password">
					</div>
					<input type="submit" class="btn btn-base"
						style="padding: 10px 20px; background-color: #999">
				</form>
			</div>
		</div>
	</div>

</body>

<script type="text/javascript" src="resources/js/login.js"></script>

</html>