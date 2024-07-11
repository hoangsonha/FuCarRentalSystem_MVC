<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Rubik:wght@500&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link href="resources/css/profile.css" rel="stylesheet" type="text/css">
<link href="resources/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div>
		<div class="">
			<div class="brand-logo">Car Renting</div>
			<div class="brand-phone" style="width: 200px">
				<div class="register">
					<a href="/logout" style="margin-top: 0px"><span
						class="register-title">Logout</span></a>
				</div>
			</div>

			<div class="text-center">
				<nav class="top-bar-wrap">
					<ul class="top-bar">
						<li class="nav-item"><a href="/home" class="nav-link"><span
								class="inner-link">Home</span></a></li>
						<li class="nav-item"><a href="/review" class="nav-link"><span
								class="inner-link">Reviews</span></a></li>
						<li class="nav-item"><a href="/history" class="nav-link"><span
								class="inner-link">History</span></a></li>
						<li class="nav-item"><a href="/profile" class="nav-link"><span
								class="inner-link">Profile</span></a></li>
					</ul>
				</nav>
				<nav class="main-nav-wrap">
					<div class="main-nav">
						<div class="nav-item-scroll" style="width: 985px">
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

	<!--  Cars  -->

	<c:if test="${not empty MESSAGE}">
		<div
			style="text-align: center; font-size: 30px; color: green; margin-top: 15px">${MESSAGE}</div>
	</c:if>



	<section class="section profile ">
		<div class="row ">
			<div class="col-xl-4 ">

				<div class="card ">
					<div
						class="card-body profile-card pt-4 d-flex flex-column align-items-center ">
						<h1 id="la">${sessionScope.CUSTOMER_LOGIN.customerName}</h1>
					</div>
				</div>

			</div>

			<div class="col-xl-8 ">

				<div class="card ">
					<div class="card-body pt-3 ">
						<!-- Bordered Tabs -->
						<ul class="nav nav-tabs nav-tabs-bordered " role="tablist ">

							<li class="nav-item " role="presentation ">
								<button class="nav-link active " data-bs-toggle="tab "
									data-bs-target="#profile-overview " aria-selected="true "
									role="tab ">Overview</button>
							</li>
						</ul>
						<div class="tab-content pt-2 ">

							<div class="tab-pane fade show active profile-overview "
								id="profile-overview " role="tabpanel ">
								<h5 class="card-title ">Profile Details</h5>

								<c:if test="${CUSTOMER_LOGIN != null}">

									<form action="/update/${CUSTOMER_LOGIN.customerID}"
										method="post">
										<div class="row mb-3 ">
											<label class="col-md-4 col-lg-3 col-form-label ">CustomerID</label>
											<div class="col-md-8 col-lg-9 ">
												<input class="form-control" type="text" id="accountID" name="customerID" value="${CUSTOMER_LOGIN.customerID}"
													readonly=" ">
											</div>
										</div>

										<div class="row mb-3 ">
											<label class="col-md-4 col-lg-3 col-form-label ">CustomerName</label>
											<div class="col-md-8 col-lg-9 ">
												<input class="form-control" type="text" id="customerName"
													name="customerName" value="${CUSTOMER_LOGIN.customerName}">
											</div>
										</div>

										<div class="row mb-3 ">
											<label class="col-md-4 col-lg-3 col-form-label ">Birthday</label>
											<div class="col-md-8 col-lg-9 ">
												<input class="form-control" type="text" id="birthday"
													name="birthday" value="${CUSTOMER_LOGIN.birthday}">
											</div>
										</div>

										<div class="row mb-3 ">
											<label class="col-md-4 col-lg-3 col-form-label ">Email</label>
											<div class="col-md-8 col-lg-9 ">
												<input class="form-control" type="text" id="email"
													name="email" value="${CUSTOMER_LOGIN.email}" readonly=" ">
											</div>
										</div>

										<div class="row mb-3 ">
											<label class="col-md-4 col-lg-3 col-form-label ">Password</label>
											<div class="col-md-8 col-lg-9 ">
												<input class="form-control" type="text" id="password"
													name="password" value="${CUSTOMER_LOGIN.password}">
											</div>
										</div>

										<div class="row mb-3 ">
											<label class="col-md-4 col-lg-3 col-form-label ">Identity
												Card</label>
											<div class="col-md-8 col-lg-9 ">
												<input class="form-control" type="text" id="identityCard"
													name="identityCard" value="${CUSTOMER_LOGIN.identityCard}">
											</div>
										</div>

										<div class="row mb-3 ">
											<label class="col-md-4 col-lg-3 col-form-label ">Licence
												Date</label>
											<div class="col-md-8 col-lg-9 ">
												<input class="form-control " type="text " id="licenceDate"
													name="licenceDate" value="${CUSTOMER_LOGIN.licenceDate}">
											</div>
										</div>

										<div class="row mb-3 ">
											<label class="col-md-4 col-lg-3 col-form-label ">Licence
												Number</label>
											<div class="col-md-8 col-lg-9 ">
												<input class="form-control" type="text" id="licenceNumber"
													name="licenceNumber"
													value="${CUSTOMER_LOGIN.licenceNumber}">
											</div>
										</div>

										<div class="row mb-3 ">
											<label class="col-md-4 col-lg-3 col-form-label ">Mobile</label>
											<div class="col-md-8 col-lg-9 ">
												<input class="form-control" type="text" id="mobile"
													name="mobile" value="${sessionScope.CUSTOMER_LOGIN.mobile}">
											</div>
										</div>


										<input type="submit" class="btn btn-success"
											style="padding: 5px 45px" />

									</form>
								</c:if>




							</div>
							<!-- End Bordered Tabs -->

						</div>
					</div>

				</div>
			</div>
	</section>
	;


</body>

<script type="text/javascript" src="resources/js/login.js"></script>

</html>