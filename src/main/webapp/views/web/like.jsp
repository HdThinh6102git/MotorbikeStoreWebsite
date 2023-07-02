<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="search" value="/search" />
<c:url var="filterPrice" value="/filterPrice" />
<c:url var="filterColor" value="/filterColor" />
<c:url var="filterCC" value="/filterCC" />
<c:url var="filterBranch" value="/filterBranch" />
<c:url var="filterMix" value="/filterMix" />
<c:url var="showNumProduct" value="/showNumProduct" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop</title>
</head>


<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="web-main-page">Home</a> <a
					class="breadcrumb-item text-dark" href="like">Favorite</a>

				
			</nav>

		</div>
	</div>
</div>
<!-- Breadcrumb End -->


<!-- Shop Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<!-- Shop Sidebar Start -->
		<div class="col-lg-3 col-md-4">
			<!-- Price Start -->
			
			
			<!-- Price End -->

			<!-- Color Start -->
			<h5 class="section-title position-relative text-uppercase mb-3">
				<span class="bg-secondary pr-3">Favorite Product</span>
			</h5>
			
			<!-- Color End -->

			<!-- Size Start -->
			
			<!-- Size End -->
			<!-- Size Start -->
			<h5 class="section-title position-relative text-uppercase mb-3">
				
			</h5>
			
			<!-- Size End -->
		</div>
		<!-- Shop Sidebar End -->


		<!-- Shop Product Start -->
		<div class="col-lg-9 col-md-8">
			<div class="row pb-3">
				



				
					<c:forEach var="item" items="${model.listResult}">
						<c:set var="path"
							value="/MotorbikeStore/uploads/images/product/${item.picName}" />
						<div class="col-lg-4 col-md-6 col-sm-6 pb-1">
							<div class="product-item bg-light mb-4">
								<a href="DeleteItemOfCart?id=${item.aMotorId}"><i class="fa fa-times"></i></a> 
								<div class="product-img position-relative overflow-hidden">
									<img class="img-fluid w-100" style="height: 400px"
										src="/MotorbikeStore/uploads/images/product/${item.picName}"
										alt="">
									<div class="product-action">


										<a class="btn btn-outline-dark btn-square"
											id="${item.aMotorId}"
											href=""><i
											class="fa fa-shopping-cart"></i></a> <a
											class="btn btn-outline-dark btn-square" href="addCart?id=${item.aMotorId}&idpage=1"><i
											class="far fa-heart"></i></a> <a
											class="btn btn-outline-dark btn-square"
											href="notaddshopDetail?id=${item.aMotorId}"><i
											class="fa fa-search"></i></a>
									</div>
								</div>
								<div class="text-center py-4">
									<a class="h6 text-decoration-none text-truncate" >${item.motors_Name}</a>
									<div
										class="d-flex align-items-center justify-content-center mt-2">
										<h5>$ ${item.price}</h5>
										<h6 class="text-muted ml-2">
											<del>$ ${item.price}</del>
										</h6>
									</div>
									<div
										class="d-flex align-items-center justify-content-center mb-1">
										<small class="fa fa-star text-primary mr-1"></small> <small
											class="fa fa-star text-primary mr-1"></small> <small
											class="fa fa-star text-primary mr-1"></small> <small
											class="fa fa-star text-primary mr-1"></small> <small
											class="fa fa-star text-primary mr-1"></small> <small>(99)</small>
									</div>
								</div>
							</div>
						</div>


					</c:forEach>

				


			</div>
		</div>
		<!-- Shop Product End -->
	</div>
</div>
<!-- Shop End -->

</html>