<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="review" value="/review" />
<c:url var="addCart" value="/addCart" />
<c:url var="login" value="/login" />
<c:url var="customerReview" value="/customerReview" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>Shop Detail</title>
</head>
<body>
	<%@ include file="/common/web/header.jsp"%>
	<!-- Breadcrumb Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-12">
				<nav class="breadcrumb bg-light mb-30">
					<a class="breadcrumb-item text-dark" href="#">Home</a> <a
						class="breadcrumb-item text-dark" href="#">Shop</a> <span
						class="breadcrumb-item active">Shop Detail</span>
				</nav>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->


	<!-- Shop Detail Start -->
	<div class="container-fluid pb-5">
		<div class="row px-xl-5">
			<div class="col-lg-5 mb-30">
				<div id="product-carousel" class="carousel slide"
					data-ride="carousel">
					<div class="carousel-inner bg-light">
						<div class="carousel-item active">
							<img class="w-100 h-400"
								src="/MotorbikeStore/uploads/images/product/${model3.picName}"
								alt="Image" style="height: 600px">
						</div>
						<c:forEach var="item" items="${model2.listResult}">
							<c:set var="path"
								value="/MotorbikeStore/uploads/images/product/${item.picName}" />
							<div class="carousel-item">
								<img class="w-100 h-400" src="${path}" alt="Image"
									style="height: 600px">
							</div>
						</c:forEach>

					</div>
					<a class="carousel-control-prev" href="#product-carousel"
						data-slide="prev"> <i class="fa fa-2x fa-angle-left text-dark"></i>
					</a> <a class="carousel-control-next" href="#product-carousel"
						data-slide="next"> <i
						class="fa fa-2x fa-angle-right text-dark"></i>
					</a>
				</div>
			</div>

			<div class="col-lg-7 h-auto mb-30">
				<div class="h-100 bg-light p-30">
					<h3>${model.motors_Name}</h3>
					<div class="d-flex mb-3">
						<div class="text-primary mr-2">
							<small class="fas fa-star"></small> <small class="fas fa-star"></small>
							<small class="fas fa-star"></small> <small
								class="fas fa-star-half-alt"></small> <small class="far fa-star"></small>
						</div>
						<small class="pt-1">(${modelComment2.quantity} Reviews)</small>
					</div>
					<h3 class="font-weight-semi-bold mb-4">${model.price}</h3>
					<p class="mb-4">Deposit: ${model.moneyPrepaid}</p>

					<p class="mb-4">Authentic</p>
					<div class="d-flex mb-3">
						<strong class="text-dark mr-3">CC:</strong>

						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input" id="size-1"
								checked> <label class="custom-control-label"
								for="size-1">${model.CC}</label>
						</div>


					</div>
					<div class="d-flex mb-4">
						<strong class="text-dark mr-3">Colors:</strong>


						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input" id="color-5"
								checked> <label class="custom-control-label"
								for="color-5">${model.color}</label>
						</div>

					</div>
					<div class="d-flex mb-4">
						<strong class="text-dark mr-3">Style:</strong>


						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input" id="color-5"
								checked> <label class="custom-control-label"
								for="color-5">${model.style}</label>
						</div>

					</div>
					<div class="d-flex mb-4">
						<strong class="text-dark mr-3">Branch:</strong>


						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input" id="color-5"
								checked> <label class="custom-control-label"
								for="color-5">${model.branch}</label>
						</div>

					</div>
					<div class="d-flex mb-4">
						<strong class="text-dark mr-3">Version:</strong>


						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input" id="color-5"
								checked> <label class="custom-control-label"
								for="color-5">${model.version}</label>
						</div>

					</div>
					<div class="d-flex align-items-center mb-4 pt-2">



						<a class="btn btn-outline-dark btn-square btnaddCart"
							id="${model.aMotorId}" href=""><i class="fa fa-shopping-cart"></i></a>
					</div>

				</div>
			</div>
		</div>
		<div class="row px-xl-5">
			<div class="col">
				<div class="bg-light p-30">
					<div class="nav nav-tabs mb-4">
						<a class="nav-item nav-link text-dark active" data-toggle="tab"
							href="#tab-pane-1">Description</a> <a
							class="nav-item nav-link text-dark" data-toggle="tab"
							href="#tab-pane-2">Specification</a> <a
							class="nav-item nav-link text-dark" data-toggle="tab"
							href="#tab-pane-3">Discussion (${modelComment2.quantity})</a> <a
							class="nav-item nav-link text-dark" data-toggle="tab"
							href="#tab-pane-4">Review (${modelReview2.quantity})</a>
					</div>
					<div class="tab-content">
						<div class="tab-pane fade show active" id="tab-pane-1">
							<h4 class="mb-3">Description</h4>
							<p>${model.motorsDecs}.</p>

						</div>
						<div class="tab-pane fade" id="tab-pane-2">
							<h4 class="mb-3">Specification</h4>

							<div class="row">
								<div class="col-md-6">
									<ul class="list-group list-group-flush">
										<li class="list-group-item px-0">Mass: ${modelSpe.massKg}
										</li>
										<li class="list-group-item px-0">Height:
											${modelSpe.saddleHeightCm}</li>


									</ul>
								</div>
								<div class="col-md-6">
									<ul class="list-group list-group-flush">
										<li class="list-group-item px-0">RPM: ${modelSpe.rpm}</li>
										<li class="list-group-item px-0">HorsePower:
											${modelSpe.horsePower}</li>

									</ul>
								</div>
							</div>
						</div>
						<div class="tab-pane fade" id="tab-pane-3">
							<div class="row">
								<div class="col-md-6">
									<h4 class="mb-4">${modelComment2.quantity} discuss about
										${model.motors_Name}</h4>



									<c:forEach var="item" items="${modelComment.listResult}">
										<div class="media mb-4">
											<img src="template/web/homepage/img/avataruser.jpg"
												alt="Image" class="img-fluid mr-3 mt-1" style="width: 45px;">

											<div class="media-body">
												<h6>
													${item.userName}<small> - <i>${item.datecmt}</i></small>
												</h6>

												<p>${item.cmtDecs}</p>
											</div>
										</div>
									</c:forEach>




								</div>
								<div class="col-md-6">
									<h4 class="mb-4">Leave a discussion</h4>







									<form method="post" action="${review}">

										<input type="hidden" class="form-control" id=""
											name="aMotorId" value="${model.aMotorId}"> <input
											type="hidden" class="form-control" id="" name="userId"
											value="<%=session.getAttribute("userId")%>">

										<div class="form-group">
											<label for="message">Your Discussion *</label>
											<textarea id="" cols="30" rows="5" name="message"
												class="form-control"></textarea>
										</div>
										<div class="form-group mb-0">
											<input type="submit" value="Leave Your Discussion"
												class="btn btn-primary px-3">
										</div>
									</form>



								</div>
							</div>
						</div>
						<div class="tab-pane fade" id="tab-pane-4">
							<div class="row">
								<div class="col-md-6">
									<h4 class="mb-4">${modelReview2.quantity} review about
										${model.motors_Name}</h4>



									<c:forEach var="item" items="${modelReview.listResult}">
										<div class="media mb-4">
											<img src="template/web/homepage/img/avataruser.jpg"
												alt="Image" class="img-fluid mr-3 mt-1" style="width: 45px;">

											<div class="media-body">
												<h6>
													${item.userName}<small> - <i>${item.daterv}</i></small>
												</h6>

												<p>${item.rvDesc}</p>
											</div>
										</div>
									</c:forEach>




								</div>
								<div class="col-md-6">
									<h4 class="mb-4">Leave a review (Only Customer)</h4>







									<form method="post" action="${customerReview}">

										<input type="hidden" class="form-control" id=""
											name="aMotorId" value="${model.aMotorId}"> 

										<div class="form-group">
											<label for="message">Your Review *</label>
											<textarea id="" cols="30" rows="5" name="message"
												class="form-control"></textarea>
										</div>
										<div class="form-group mb-0">
											<input type="submit" value="Leave Your Review (Only Customer)"
												class="btn btn-primary px-3">
										</div>
									</form>



								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Shop Detail End -->


	<!-- Products Start -->
	<div class="container-fluid py-5">
		<h2
			class="section-title position-relative text-uppercase mx-xl-5 mb-4">
			<span class="bg-secondary pr-3">You May Also Like</span>
		</h2>
		<div class="row px-xl-5">
			<div class="col">
				<div class="owl-carousel related-carousel">

					<c:forEach var="item" items="${modelAlso.listResult}">
						<div class="product-item bg-light mb-4">
							<div class="product-img position-relative overflow-hidden">
								<img class="img-fluid w-100"
									src="/MotorbikeStore/uploads/images/product/${item.picName}"
									style="height: 400px" alt="">
								<div class="product-action">
									<a class="btn btn-outline-dark btn-square btnaddCart" href=""
										id="${item.aMotorId}"><i class="fa fa-shopping-cart"></i></a>
									<a class="btn btn-outline-dark btn-square"
										href="addFavoriteProduct?id=${item.aMotorId}&idpage=2"><i
										class="far fa-heart"></i></a> <a
										class="btn btn-outline-dark btn-square"
										href="notaddshopDetail?id=${item.aMotorId}"><i
										class="fa fa-search"></i></a>
								</div>
							</div>
							<div class="text-center py-4">
								<a class="h6 text-decoration-none text-truncate" href="">${item.motors_Name}</a>
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
					</c:forEach>

















				</div>
			</div>
		</div>
	</div>
	<!-- Products End -->
	<%@ include file="/common/web/footer.jsp"%>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(".btnaddCart").click(function(e) {

			var idpage = 2;
			var userId =
	<%=session.getAttribute("userId")%>
		;
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
</body>
</html>