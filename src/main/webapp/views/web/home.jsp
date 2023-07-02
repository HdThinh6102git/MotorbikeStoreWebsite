<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="addCart" value="/addCart" />
<c:url var="login" value="/login" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Home Page</title>

</head>

<!-- Carousel Start -->
<div class="container-fluid mb-3">
	<div class="row px-xl-5">
		<div class="col-lg-8">
			<div id="header-carousel"
				class="carousel slide carousel-fade mb-30 mb-lg-0"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#header-carousel" data-slide-to="0" class="active"></li>
					<li data-target="#header-carousel" data-slide-to="1"></li>
					<li data-target="#header-carousel" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">


					<c:set var="path"
							value="/MotorbikeStore/uploads/images/product/${model5.picName}" />
							
					<div class="carousel-item position-relative active"
						style="height: 430px;">
						<img class="position-absolute w-100 h-100"
							src="${path}"
							style="object-fit: cover;">
						<div
							class="carousel-caption d-flex flex-column align-items-center justify-content-center">
							<div class="p-3" style="max-width: 700px;">
								<h1
									class="display-4 text-white mb-3 animate__animated animate__fadeInDown">${model5.motors_Name}</h1>
								<p class="mx-md-5 px-5 animate__animated animate__bounceIn">${model5.motorsDecs}</p>
								<a
									class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
									href="notaddshopDetail?id=${model5.aMotorId}">Shop Now</a>
							</div>
						</div>
					</div>


					<c:forEach var="item" items="${model3.listResult1.arrayList}">
						<c:set var="path"
							value="/MotorbikeStore/uploads/images/product/${item.picName}" />
						<div class="carousel-item position-relative" style="height: 430px;">
						<img class="position-absolute w-100 h-100"
							src="${path}"
							style="object-fit: cover;">
						<div
							class="carousel-caption d-flex flex-column align-items-center justify-content-center">
							<div class="p-3" style="max-width: 700px;">
								<h1
									class="display-4 text-white mb-3 animate__animated animate__fadeInDown">${item.motors_Name}</h1>
								<p class="mx-md-5 px-5 animate__animated animate__bounceIn">${item.motorsDecs}</p>
								<a
									class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
									href="notaddshopDetail?id=${item.aMotorId}">Shop Now</a>
							</div>
						</div>
					</div>

					</c:forEach>				
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="product-offer mb-30" style="height: 200px;">
				<img class="img-fluid" src="template/web/homepage/img/airblade.jpg"
					alt="">
				<div class="offer-text">
					<h6 class="text-white text-uppercase">Save 20%</h6>
					<h3 class="text-white mb-3">Special Offer</h3>
					
				</div>
			</div>
			<div class="product-offer mb-30" style="height: 200px;">
				<img class="img-fluid" src="template/web/homepage/img/shmode.jpg"
					alt="">
				<div class="offer-text">
					<h6 class="text-white text-uppercase">Save 20%</h6>
					<h3 class="text-white mb-3">Special Offer</h3>
					
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Carousel End -->


<!-- Featured Start -->
<div class="container-fluid pt-5">
	<div class="row px-xl-5 pb-3">
		<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
			<div class="d-flex align-items-center bg-light mb-4"
				style="padding: 30px;">
				<h1 class="fa fa-check text-primary m-0 mr-3"></h1>
				<h5 class="font-weight-semi-bold m-0">Quality Product</h5>
			</div>
		</div>
		<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
			<div class="d-flex align-items-center bg-light mb-4"
				style="padding: 30px;">
				<h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
				<h5 class="font-weight-semi-bold m-0">Free Shipping</h5>
			</div>
		</div>
		<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
			<div class="d-flex align-items-center bg-light mb-4"
				style="padding: 30px;">
				<h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
				<h5 class="font-weight-semi-bold m-0">14-Day Return</h5>
			</div>
		</div>
		<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
			<div class="d-flex align-items-center bg-light mb-4"
				style="padding: 30px;">
				<h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
				<h5 class="font-weight-semi-bold m-0">24/7 Support</h5>
			</div>
		</div>
	</div>
</div>
<!-- Featured End -->





<!-- Products Start -->
<div class="container-fluid pt-5 pb-3">
	<h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4">
		<span class="bg-secondary pr-3">Featured Products</span>
	</h2>
	<div class="row px-xl-5">

		<c:forEach var="item" items="${modelFeature.listResult1.arrayList}">
			<c:set var="path"
				value="/MotorbikeStore/uploads/images/product/${item.picName}" />
			<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
				<div class="product-item bg-light mb-4">
					<div class="product-img position-relative overflow-hidden">
						<img class="img-fluid w-100" style="height: 400px" src="${path}"
							alt="">
						<div class="product-action">
							
							
							<a class="btn btn-outline-dark btn-square btnaddCart" id ="${item.aMotorId}"  href=""><i
								class="fa fa-shopping-cart"></i></a>
								
								
								 <a
								class="btn btn-outline-dark btn-square" href="addFavoriteProduct?id=${item.aMotorId}&idpage=0"><i
								class="far fa-heart"></i></a>  <a
								class="btn btn-outline-dark btn-square"
								href="notaddshopDetail?id=${item.aMotorId}"><i
								class="fa fa-search"></i></a>
						</div>
					</div>
					<div class="text-center py-4">
						<a class="h6 text-decoration-none text-truncate" >${item.motors_Name}</a>
						<div class="d-flex align-items-center justify-content-center mt-2">
							<h5>$ ${item.price}</h5>
							<h6 class="text-muted ml-2">
								<del>$ ${item.price}</del>
							</h6>
						</div>
						<div class="d-flex align-items-center justify-content-center mb-1">
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
<!-- Products End -->


<!-- Offer Start -->
<div class="container-fluid pt-5 pb-3">
	<div class="row px-xl-5">
		<div class="col-md-6">
			<div class="product-offer mb-30" style="height: 300px;">
				<img class="img-fluid" src="template/web/homepage/img/dream.jpg"
					alt="">
				<div class="offer-text">
					<h6 class="text-white text-uppercase">Save 20%</h6>
					<h3 class="text-white mb-3">Special Offer</h3>
					
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="product-offer mb-30" style="height: 300px;">
				<img class="img-fluid" src="template/web/homepage/img/future.jpg"
					alt="">
				<div class="offer-text">
					<h6 class="text-white text-uppercase">Save 20%</h6>
					<h3 class="text-white mb-3">Special Offer</h3>
					
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Offer End -->


<!-- Products Start -->
<div class="container-fluid pt-5 pb-3">
	<h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4">
		<span class="bg-secondary pr-3">Recent Products</span>
	</h2>
	<div class="row px-xl-5">


		<c:forEach var="item" items="${model.listResult1.arrayList}">
			<c:set var="path"
				value="/MotorbikeStore/uploads/images/product/${item.picName}" />
			<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
				<div class="product-item bg-light mb-4">
					<div class="product-img position-relative overflow-hidden">
						<img class="img-fluid w-100" style="height: 400px" src="${path}"
							alt="">
						<div class="product-action">
							
							
							<a class="btn btn-outline-dark btn-square btnaddCart" id ="${item.aMotorId}" href=""><i
								class="fa fa-shopping-cart"></i></a>
								
								 <a
								class="btn btn-outline-dark btn-square" href="addFavoriteProduct?id=${item.aMotorId}&idpage=0"><i
								class="far fa-heart"></i></a>  <a
								class="btn btn-outline-dark btn-square"
								href="notaddshopDetail?id=${item.aMotorId}"><i
								class="fa fa-search"></i></a>
						</div>
					</div>
					<div class="text-center py-4">
						<a class="h6 text-decoration-none text-truncate" >${item.motors_Name}</a>
						<div class="d-flex align-items-center justify-content-center mt-2">
							<h5>$ ${item.price}</h5>
							<h6 class="text-muted ml-2">
								<del>$ ${item.price}</del>
							</h6>
						</div>
						<div class="d-flex align-items-center justify-content-center mb-1">
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
<!-- Products End -->


<!-- Vendor Start -->
<div class="container-fluid py-5">
	<div class="row px-xl-5">
		<div class="col">
			<div class="owl-carousel vendor-carousel">
				<div class="bg-light p-4">
					<img src="template/web/homepage/img/logosuzu.jpg" alt=""
						style="height: 215px">
				</div>
				<div class="bg-light p-4">
					<img src="template/web/homepage/img/logoYamaha.jpg" alt=""
						style="height: 215px">
				</div>
				<div class="bg-light p-4">
					<img src="template/web/homepage/img/logosym.jpg" alt=""
						style="height: 215px">
				</div>
				<div class="bg-light p-4">
					<img src="template/web/homepage/img/logopiagio.jpg" alt=""
						style="height: 215px">
				</div>
				<div class="bg-light p-4">
					<img src="template/web/homepage/img/logo honda.jpg" alt=""
						style="height: 215px">
				</div>
				<div class="bg-light p-4">
					<img src="template/web/homepage/img/logoducati2.png" alt=""
						style="height: 215px">
				</div>

			</div>
		</div>
	</div>
</div>
<!-- Vendor End -->




<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script >
$(".btnaddCart").click(function(e) {
	
	var idpage = 0;
	var userId = <%=session.getAttribute("userId")%>;
	var aMotorId = $(this).attr("id");
	$.ajax({
		type : "POST",
		url : '${addCart}',
		data : {
			idpage : idpage,
			userId : userId,
			aMotorId : aMotorId
		},
		success : function(data) {
			window.location.href = "${login}";
		},
		error : function(result) {
			alert('error');

		}
	});	

});



</script>



<script type="text/javascript">
        function refresh() {
            location.reload(true);
        }
</script>
<script type="text/javascript">
            function reCluster(cluster_id) {
                recluster();
            }
        </script>

</html>