<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>History Page</title>
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
					<a href="/logout" style="margin-top: -20px"><span
						class="register-title">Logout</span></a>
				</div>
				<h4>Hello ${sessionScope.CUSTOMER_LOGIN.customerName}</h4>
			</div>

			<div class="text-center">
				<nav class="top-bar-wrap">
				<ul class="top-bar" style="margin-left: -200px">
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
					<div class="nav-item-scroll" style="width: 790px">
						<div id="scrollContent">
							<div>Đây là mẫu bài viết về món ăn thông dụng thường thấy
								trong quá trình hoạt động ở nhà hàng. Việc chia sẻ thêm nhiều
								món ăn mới sẽ giúp khách hàng cũ thích thú và quay lại, kèm theo
								đó thu hút thêm khách hàng mới trải nghiệm những món ăn lạ của
								riêng nhà hàng.</div>
						</div>
					</div>
				</div>
				</nav>
			</div>
		</div>
	</div>



	<div class="row" style="margin-top: 100px">
		<div class="col-md-12">
			<div>

				<div class="collapsible-content">
					<div>

						<table id="Oamuser_Table_1"
							class="table table-bordered table-striped table-hover table-condensed"
							border="1" bordercolor="#f9e491" id="sample_1">
							<thead class="gridheader">
								<tr>
									<th style="text-align: center">CarRentalID</th>
									<th style="text-align: center">CustomerID</th>
									<th style="text-align: center">CarID</th>
									<th style="text-align: center">PickupDate</th>
									<th style="text-align: center">ReturnDate</th>
									<th style="text-align: center">RentPrice</th>
									<th style="text-align: center">Status</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="rental" varStatus="counter"
									items="${LIST_RENTALS}">
									<tr>
										<td align="center">${rental.carRentalID}</td>
										<td align="center">${rental.customer.customerName}</td>
										<td align="center">${rental.car.carName}</td>
										<td align="center">${rental.pickupDate}</td>
										<td align="center">${rental.returnDate}</td>
										<td align="center">${rental.rentPrice}</td>
										<td align="center">${rental.status}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	</main>
	<!-- End #main -->



</body>



<script type="text/javascript" src="resources/js/Lbs_Func_General.js"></script>
<script type="text/javascript" src="resources/js/Lbs_Modal_Message.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/Oamuser_Js_General.js"></script>

</html>
