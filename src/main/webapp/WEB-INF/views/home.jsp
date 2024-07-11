<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>     
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@500&display=swap" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
        <link href="resources/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
        
        <div>
            <div class="">
                <div class="brand-logo">
                    Car Renting
                </div>
                <div class="brand-phone">
                    <div class="register"><a href="/logout" style="margin-top: -20px"><span class="register-title">Logout</span></a></div>
                    <h4>Hello ${sessionScope.CUSTOMER_LOGIN.customerName}</h4>
                </div>
                
                <div class="text-center">
                    <nav class="top-bar-wrap">
                        <ul class="top-bar" style="margin-left: -200px">
                            <li class="nav-item">
                                <a href="/home" class="nav-link"><span class="inner-link">Home</span></a>
                            </li>
                            <li class="nav-item">
                                <a href="/review" class="nav-link"><span class="inner-link">Reviews</span></a>
                            </li>
                            <li class="nav-item">
                                <a href="/history" class="nav-link"><span class="inner-link">History</span></a>
                            </li>
                            <li class="nav-item">
                                <a href="/profile" class="nav-link"><span class="inner-link">Profile</span></a>
                            </li>  
                        </ul>
                    </nav>
                    <nav class="main-nav-wrap">
                        <div class="main-nav">
                            <div class="nav-item-scroll" style="width: 790px">
                                <div id="scrollContent">
                                    <div>Đây là mẫu bài viết về món ăn thông dụng thường thấy trong quá trình hoạt động ở nhà hàng. Việc chia sẻ thêm nhiều món ăn mới sẽ giúp khách hàng cũ thích thú và quay lại, kèm theo đó thu hút thêm khách hàng mới trải nghiệm những món ăn lạ của riêng nhà hàng. </div>
                                </div>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
        </div> 

						<!--  Cars  -->
		
		 <c:if test="${not empty MESSAGE}">
			<div style="text-align: center; font-size: 30px; color: green; margin-top: 15px">${MESSAGE}</div>
		</c:if>
		
		
		<section style="background-color: #eee;">               
                    <div class="container py-5">
                        <div class="row" id="contentSearch" style="flex-wrap: nowrap;">

                                    <c:forEach var="car" items="${LIST_CARS}">      
                                        <div class="col-md-8 col-lg-6 col-xl-4">
                                            <div class="card" style="border-radius: 15px;">
                                                <div class="bg-image hover-overlay ripple ripple-surface ripple-surface-light"
                                                     data-mdb-ripple-color="light">
                                                    <a href="#!">
                                                        <div class="mask"></div>
                                                    </a>
                                                </div>
                                                <div class="card-body pb-0">
                                                    <div class="d-flex justify-content-between">
                                                        <div>
                                                            <p>${car.carName}</p>
                                                            <p class="small text-muted">Car</p>
                                                        </div>
                                                        <div>
                                                            <div class="d-flex flex-row justify-content-end mt-1 mb-4 text-danger">
                                                                <i class="fas fa-star"></i>
                                                                <i class="fas fa-star"></i>
                                                                <i class="fas fa-star"></i>
                                                                <i class="fas fa-star"></i>
                                                            </div>
                                                            <p class="small text-muted">Rated 4.0/5</p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <hr class="my-0" />
                                                <div class="card-body pb-0">
                                                    <div class="d-flex justify-content-between">
                                                        <p>${car.rentPrice} VND</p>
                                                        <p class="text-dark">#### ${car.carID}</p>
                                                    </div>
                                                </div>
                                                <hr class="my-0" />
                                                <div class="card-body">
                                                    <div class="d-flex justify-content-between align-items-center pb-2 mb-1">
                                                        <a href="#!" class="text-dark fw-bold">Details</a>
                                                        
                                                        <!-- the a rent -->
                                                        
                                                        <a href="/rent/ ${car.carID}" class="btn btn-success" style="padding: 10px 30px" >Rent</a>
                                                        
                                                    </div>
                                                    <div  style="color: greenyellow; font-size: 18px; text-align: center;"></div> 
                                                </div>
                                            </div>         
                                        </div>            
                                    </c:forEach>
                        </div>
                    </div>
                </section> 
       

    </body>
    
    <script type="text/javascript" src="resources/js/login.js"></script>
    
</html>