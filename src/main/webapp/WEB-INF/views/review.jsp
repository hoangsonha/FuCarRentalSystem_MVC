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



	<div class="row" style="margin-top: 50px">
		<div class="col-md-12">
			<div>
				<div class="collapsible-content">
					<div>

						<table id="Oamuser_Table_1"
							class="table table-bordered table-striped table-hover table-condensed"
							border="1" bordercolor="#f9e491" id="sample_1">
							<thead class="gridheader">
								<tr>
									<th style="text-align: center">ID</th>
									<th style="text-align: center">Comment</th>
									<th style="text-align: center">Review Star</th>
									<th style="text-align: center">CarID</th>
									<th style="text-align: center">CustomerID</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${not empty LIST_REVIEWS}">
									<c:forEach var="review" varStatus="counter"
										items="${LIST_REVIEWS}">
										<tr>
											<td align="center">${review.id}</td>
											<td align="center">${review.comment}</td>
											<td align="center">${review.reviewStar}</td>
											<td align="center">${review.customer.customerName}</td>
											<td align="center">${review.car.carName}</td>
										</tr>
									</c:forEach>
								</c:if>
								<c:if test="${empty LIST_REVIEWS}">
									<div
										style="text-align: center; font-size: 30px; color: green; margin-top: 15px">${MESSAGE}</div>
								</c:if>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

<script type="text/javascript" src="resources/js/login.js"></script>

</html>