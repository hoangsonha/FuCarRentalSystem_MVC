<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Rubik:wght@500&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link href="resources/css/admin.css" rel="stylesheet" type="text/css">
</head>
<body>
<body>

	<!-- ======= Header ======= -->
	<header id="header" class="header fixed-top d-flex align-items-center">

		<div class="d-flex align-items-center justify-content-between">
			<a href="index.html" class="logo d-flex align-items-center"> <span
				class="d-none d-lg-block">Admin Page</span>
			</a> <i class="bi bi-list toggle-sidebar-btn"></i>
		</div>
		<!-- End Logo -->

		<nav class="header-nav nav-mg">
			<ul class="d-flex align-items-center">

				<li class="nav-item dropdown pe-3"><a
					class="nav-link nav-profile d-flex align-items-center pe-0"
					href="#" data-bs-toggle="dropdown"> <span
						class="d-md-block ps-2" style="font-size: 20px;">Admin :
							${sessionScope.CUSTOMER_LOGIN.customerName}</span>
				</a> <!-- End Profile Iamge Icon --></li>
				<!-- End Profile Nav -->
				<li class="logout-log"><a href="/logout"
					class="nav-link nav-profile d-flex align-items-center pe-0"
					style="margin-right: 50px">Logout</a></li>

			</ul>
		</nav>
		<!-- End Icons Navigation -->

	</header>
	<!-- End Header -->

	<!-- ======= Sidebar ======= -->
	<aside id="sidebar" class="sidebar">

		<ul class="sidebar-nav" id="sidebar-nav">

			<li class="nav-item"><a class="nav-link " href="/admin"> <i
					class="bi bi-grid"></i> <span>Dashboard</span>
			</a></li>
			<!-- End Dashboard Nav -->

			<li class="nav-item"><a class="nav-link collapsed"
				data-bs-target="#components-nav" href="/adminCustomer"> <i
					class="bi bi-menu-button-wide"></i><span>Customers</span><i
					class="bi bi-chevron-down ms-auto"></i>
			</a></li>
			<!-- End Components Nav -->

			<li class="nav-item"><a class="nav-link collapsed"
				data-bs-target="#forms-nav" href="/adminCar"> <i
					class="bi bi-journal-text"></i><span>Cars</span><i
					class="bi bi-chevron-down ms-auto"></i>
			</a></li>
			<!-- End Forms Nav -->

			<li class="nav-item"><a class="nav-link collapsed"
				data-bs-target="#tables-nav" href="/adminRental"> <i
					class="bi bi-layout-text-window-reverse"></i><span>Car
						Rental</span><i class="bi bi-chevron-down ms-auto"></i>
			</a></li>
			
			<li class="nav-item"><a class="nav-link collapsed"
				data-bs-target="#components-nav" href="/adminReview"> <i
					class="bi bi-menu-button-wide"></i><span>Reviews</span><i
					class="bi bi-chevron-down ms-auto"></i>
			</a></li>
			<!-- End Tables Nav -->


			<li class="nav-heading">Pages</li>

			<li class="nav-item"><a class="nav-link collapsed" href="#">
					<i class="bi bi-person"></i> <span>...</span>
			</a></li>
			<!-- End Profile Page Nav -->
			<li class="nav-item"><a class="nav-link collapsed" href="#">
					<i class="bi bi-envelope"></i> <span>...</span>
			</a></li>
			<!-- End Contact Page Nav -->
			<li class="nav-item"><a class="nav-link collapsed" href="#">
					<i class="bi bi-card-list"></i> <span>...</span>
			</a></li>
			<!-- End Register Page Nav -->
		</ul>

	</aside>
	<!-- End Sidebar-->

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Dashboard</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="/admin">Home</a></li>
					<li class="breadcrumb-item active">Dashboard</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">

				<!-- Left side columns -->
				<div class="col-lg-8">
					<div class="row">

						<!-- Sales Card -->
						<div class="col-xxl-4 col-md-6">
							<div class="card info-card sales-card">
								<div class="card-body">
									<h5 class="card-title">
										Sales <span>| Today</span>
									</h5>

									<div class="d-flex align-items-center">
										<div
											class="card-icon rounded-circle d-flex align-items-center justify-content-center">
											<i class="bi bi-cart"></i>
										</div>
										<div class="ps-3">
											<h6>Car Rental</h6>

										</div>
									</div>
								</div>

							</div>
						</div>
						<!-- End Sales Card -->

						<!-- Revenue Card -->

						<div class="col-xxl-4 col-md-6">
							<div class="card info-card revenue-card">

								<div class="card-body">
									<h5 class="card-title">
										Revenue <span>| This Month</span>
									</h5>

									<div class="d-flex align-items-center">
										<div
											class="card-icon rounded-circle d-flex align-items-center justify-content-center">
											<i class="bi bi-currency-dollar"></i>
										</div>
										<div class="ps-3">
											<h6>VND</h6>
										</div>
									</div>
								</div>

							</div>
						</div>
						<!-- End Revenue Card -->

						<!-- Recent Sales -->
						<div class="col-12">
							<div class="card recent-sales overflow-auto">
								<div class="card-body">
									<h5 class="card-title">Recent Sales</h5>

									<div
										class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
										<div class="datatable-top">
											<div
												style="display: flex; justify-content: space-around; margin: 20px">
												<form action="/adminReport" method="get"
													style="display: flex; align-items: center; margin-bottom: 10px">
													<div class="datatable-search" style="margin-right: 15px">
														<label>Start Date</label> 
														<input class="datatable-input" type="text" id="startDate" name="startDate">
													</div>
													<div class="datatable-search" style="margin-right: 15px">
														<label>End Date</label> 
														<input class="datatable-input" type="text" id="endDate" name="endDate">
													</div>

													<input type="submit" class="btn btn-primary" />
												</form>
											</div>
										</div>
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
												<c:forEach var="rental" varStatus="counter" items="${LISTS}">
													<tr>
														<td align="center">${rental.carRentalID}</td>
														<td align="center">${rental.customer.customerID}</td>
														<td align="center">${rental.car.carID}</td>
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
						<!-- End Recent Sales -->

					</div>
				</div>
				<!-- End Left side columns -->

				<!-- Right side columns -->
				<div class="col-lg-4"></div>
				<!-- End Right side columns -->

			</div>
		</section>

	</main>
	
	
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<footer id="footer" class="footer">
		<div class="copyright">
			Pizza Store <strong><span>Admin</span></strong>. All Rights Reserved
		</div>
		Designed by <a href="https://bootstrapmade.com/">HSH</a>
		</div>
	</footer>
	<!-- End Footer -->


	<div class="" id="test_apply">Hello world</div>
</body>

</body>
</html>