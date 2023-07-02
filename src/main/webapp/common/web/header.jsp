<!-- Navigation-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Free HTML Templates" name="keywords">
<meta content="Free HTML Templates" name="description">
<link href="<c:url value='/template/web/homepage/img/favicon.ico' />"
	rel="icon" />
<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link
	href="<c:url value='/template/web/homepage/lib/animate/animate.min.css' />"
	rel="stylesheet" />
<link
	href="<c:url value='/template/web/homepage/lib/owlcarousel/assets/owl.carousel.min.css' />"
	rel="stylesheet" />
<!-- Customized Bootstrap Stylesheet -->
<link href="<c:url value='/template/web/homepage/css/style.css' />"
	rel="stylesheet" />



</head>
<body>
	<!-- Topbar Start -->
	<div class="container-fluid">
		<div class="row bg-secondary py-1 px-xl-5">
			<div class="col-lg-6 d-none d-lg-block">
				<div class="d-inline-flex align-items-center h-100">

					<a class="text-body mr-3" href="contact">Contact</a>

				</div>
			</div>
			<div class="col-lg-6 text-center text-lg-right">
				<div class="d-inline-flex align-items-center">
					<div class="btn-group">
						<%
						if (session.getAttribute("name") != null) {
						%>
						<button type="button" class="btn btn-sm btn-light dropdown-toggle"
							data-toggle="dropdown"><%=session.getAttribute("name")%></button>
						<div class="dropdown-menu dropdown-menu-right">
							<button class="dropdown-item" type="button"
								onclick="window.location.href='login'">Sign In</button>
							<button class="dropdown-item" type="button"
								onclick="window.location.href='logout'">Log Out</button>
						</div>
						<%
						} else {
						%>
						<button type="button" class="btn btn-sm btn-light dropdown-toggle"
							data-toggle="dropdown">My Account</button>
						<div class="dropdown-menu dropdown-menu-right">
							<button class="dropdown-item" type="button"
								onclick="window.location.href='login'">Sign In</button>
							<button class="dropdown-item" type="button"
								onclick="window.location.href='regist'">Sign Up</button>
						</div>
						<%
						}
						%>
					</div>
					<div class="btn-group mx-2">
						<button type="button" class="btn btn-sm btn-light dropdown-toggle"
							data-toggle="dropdown">VND</button>

					</div>
					<div class="btn-group">
						<button type="button" class="btn btn-sm btn-light dropdown-toggle"
							data-toggle="dropdown">VN</button>

					</div>
				</div>
				<div class="d-inline-flex align-items-center d-block d-lg-none">
					<a href="" class="btn px-0 ml-2"> <i
						class="fas fa-heart text-dark"></i> <span
						class="badge text-dark border border-dark rounded-circle"
						style="padding-bottom: 2px;">0</span>
					</a> <a href="" class="btn px-0 ml-2"> <i
						class="fas fa-shopping-cart text-dark"></i> <span
						class="badge text-dark border border-dark rounded-circle"
						style="padding-bottom: 2px;">0</span>
					</a>
				</div>
			</div>
		</div>
		<div
			class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
			<div class="col-lg-4">
				<a href="web-main-page" class="text-decoration-none"> <span
					class="h1 text-uppercase text-primary bg-dark px-2">Motorbike</span>
					<span class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">Shop</span>
				</a>
			</div>


		</div>
	</div>
	<!-- Topbar End -->


	<!-- Navbar Start -->
	<div class="container-fluid bg-dark mb-30">
		<div class="row px-xl-5">
			<div class="col-lg-3 d-none d-lg-block">
				<a
					class="btn d-flex align-items-center justify-content-between bg-primary w-100"
					data-toggle="collapse" href="#navbar-vertical"
					style="height: 65px; padding: 0 30px;">
					<h6 class="text-dark m-0">
						<i class="fa fa-bars mr-2"></i>Branch
					</h6> <i class="fa fa-angle-down text-dark"></i>
				</a>
				<nav
					class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 bg-light"
					id="navbar-vertical"
					style="width: calc(100% - 30px); z-index: 999;">
					<div class="navbar-nav w-100">

						<a  class="nav-item nav-link">Honda</a> <a 
							class="nav-item nav-link">Yamaha</a> <a 
							class="nav-item nav-link">Suzuki</a> <a 
							class="nav-item nav-link">SYM</a>

					</div>
				</nav>
			</div>
			<div class="col-lg-9">
				<nav
					class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0">
					<a href="" class="text-decoration-none d-block d-lg-none"> <span
						class="h1 text-uppercase text-dark bg-light px-2">Multi</span> <span
						class="h1 text-uppercase text-light bg-primary px-2 ml-n1">Shop</span>
					</a>
					<button type="button" class="navbar-toggler" data-toggle="collapse"
						data-target="#navbarCollapse">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse justify-content-between"
						id="navbarCollapse">
						<div class="navbar-nav mr-auto py-0">
							<a href="web-main-page" class="nav-item nav-link active">Home</a>
							<a href="shop" class="nav-item nav-link">Shop</a>

							<div class="nav-item dropdown">
								<a href="#" class="nav-link dropdown-toggle"
									data-toggle="dropdown">Pages <i
									class="fa fa-angle-down mt-1"></i></a>
								<div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
									<a href="checkout" class="dropdown-item">Checkout</a>
								</div>
							</div>
							<a href="contact" class="nav-item nav-link">Contact</a>
						</div>
						<div class="navbar-nav ml-auto py-0 d-none d-lg-block">



							<c:if test="${not empty cart.quantity }">
								<a href="cart?userId=<%=session.getAttribute("userId")%>"
									class="btn px-0 ml-3"> <i
									class="fas fa-shopping-cart text-primary"></i> <span
									class="badge text-secondary border border-secondary rounded-circle"
									style="padding-bottom: 2px;">${cart.quantity}</span>
								</a>

							</c:if>
							<c:if test="${empty cart.quantity }">
								<a href="cart?userId=<%=session.getAttribute("userId")%>"
									class="btn px-0 ml-3"> <i
									class="fas fa-shopping-cart text-primary"></i> <span
									class="badge text-secondary border border-secondary rounded-circle"
									style="padding-bottom: 2px;">0</span>
								</a>

							</c:if>

							<c:if test="${not empty favorite.quantity }">
								<a href="like" class="btn px-0"> <i
									class="fas fa-heart text-primary"></i> <span
									class="badge text-secondary border border-secondary rounded-circle"
									style="padding-bottom: 2px;">${favorite.quantity}</span>
								</a>

							</c:if>
							<c:if test="${ empty favorite.quantity }">
								<a href="like" class="btn px-0"> <i
									class="fas fa-heart text-primary"></i> <span
									class="badge text-secondary border border-secondary rounded-circle"
									style="padding-bottom: 2px;">0</span>
								</a>

							</c:if>




						</div>
					</div>
				</nav>
			</div>
		</div>
	</div>
	<!-- Navbar End -->
</body>