<%@page import="com.MotorbikeStore.service.impl.ProductDetailService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<c:url var="MotorcyclesAPI" value="/api-admin-Motorcycles" />
<c:url var="SpecificationAPI" value="/api-admin-Specification" />
<c:url var="aMotorcycleAPI" value="/api-admin-aMotorcycle" />
<c:url var="LoadProductDetail" value="/admin-products" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
    <!-- https://fonts.google.com/specimen/Roboto -->
    <link href="<c:url value='/template/admin/css/fontawesome.min.css' />" rel="stylesheet" />
    
    <!-- https://getbootstrap.com/ -->
   
<title>Products</title>
</head>
<body>
	
	<div class="container mt-5">
		<div class="row tm-content-row2">
			<div class="col-12 tm-block-col">
				<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
					<h2 class="tm-block-title">Product Categories</h2>
					<p class="text-white">Category</p>
					<select class="custom-select" id="catego"
						onchange="getSelectedValue();">

						<option value="0">All Products</option>
						<c:forEach var="item" items="${model1.listResult}">
							<option value="${item.motorsId}">${item.motors_Name}</option>
						</c:forEach>



					</select>

				</div>
			</div>
		</div>

		<div class="row tm-content-row2">
			<div class="col-sm-12 col-md-12 col-lg-8 col-xl-8 tm-block-col">
				<div class="tm-bg-primary-dark tm-block tm-block-products">
					<div class="tm-product-table-container">
						<table class="table table-hover tm-table-small tm-product-table">
							<thead>
								<tr>
									<th scope="col">&nbsp;</th>
									<th scope="col">&nbsp;</th>
									<th scope="col">&nbsp;</th>
									<th scope="col">Motor NAME</th>
									<th scope="col">Version</th>
									<th scope="col">Motor type</th>
									<th scope="col">Branch</th>
									<th scope="col">Style</th>
									<th scope="col">Color</th>
									<th scope="col">Price</th>
									<th scope="col">Check Sold</th>
									<th scope="col">Date Insert</th>
									
								</tr>
							</thead>
							<tbody id="contenthaha">



								<c:forEach var="item" items="${model.listResult}">
									
									<tr>

										<td><a
											href="" id = "${item.aMotorId }"
											class="btndeleteProduct" data-toggle="tooltip" title="Delete"
											class="tm-product-delete-link"> <i
												class="far fa-trash-alt tm-product-delete-icon"></i>

										</a></td>
										<td><a
											href="admin-editProduct?id=${item.aMotorId}&id2=${item.motorsId}"
											data-toggle="tooltip" title="Update "
											class="tm-product-delete-link"> <i class="fas fa-wrench"></i>
										</a></td>
										<td><a href="admin-addPicture?id=${item.aMotorId}"
											data-toggle="tooltip" title="Add Image"
											class="tm-product-delete-link"> <i class="fa-light fa-file-circle-plus"></i>
										</a></td>
										<td class="tm-product-name">${item.motors_Name}</td>
										<td>${item.version}</td>
										<td>${item.motorType}</td>
										<td>${item.branch}</td>
										<td>${item.style}</td>
										<td>${item.color}</td>
										<td>${item.price}</td>
										<td>${item.checkSold}</td>
										<td>${item.date_insert}</td>
										
										
										
										
									</tr>

								</c:forEach>



							</tbody>
						</table>
					</div>
					
					<!-- table container -->
					<a href="admin-addProduct"
						class="btn btn-primary btn-block text-uppercase mb-3">Add new
						product</a>

					
				</div>
			</div>
			<div class="col-sm-12 col-md-12 col-lg-4 col-xl-4 tm-block-col">
				<div class="tm-bg-primary-dark tm-block tm-block-product-categories">
					<h2 class="tm-block-title">Product Categories</h2>
					<div class="tm-product-table-container">
						<table class="table tm-table-small tm-product-table">
							<tbody>
							
								<c:forEach var="item" items="${model1.listResult}">

									
									<tr>
										<td class="text-center"><a href="" class="btndeleteCate"
											data-toggle="tooltip" title="Delete"
											class="tm-product-delete-link" id = "${item.motorsId }" > <i
												class="far fa-trash-alt tm-product-delete-icon" ></i>
										</a></td>

										<td><a href="admin-editcategory?id=${item.motorsId}"
											data-toggle="tooltip" title="Update "
											class="tm-product-delete-link"> <i class="fas fa-wrench"></i>
										</a></td>
										<td class="tm-product-name">${item.motors_Name}</td>
										
										
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
					<a href="admin-addcategory"
						class="btn btn-primary btn-block text-uppercase mb-3">Add new
						Category</a>
				</div>
			</div>
		</div>
	</div>
	
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


	
	<script >
	
	$(".btndeleteProduct").click(function(e) {
		if (!confirm('Are you sure to delete this product?')) {
			e.preventDefault();
		}else {
			e.preventDefault();
			var aMotorId = $(this).attr("id");

			var data = {};
			data["aMotorId"] = aMotorId;
			$.ajax({
				type : "DELETE",
				url : '${aMotorcycleAPI}',
				contentType : 'application/json; charset=utf-8',
				data : JSON.stringify(data),
				dataType : 'json',

				success : function(result) {
					alert('Deleted aMotorcycle');
					window.location.href = "${LoadProductDetail}";
					console.log(result);
				},
				error : function(result) {
					alert('error');
					console.log(result);
				}
			});
		}
		

	});
	
	
	
	
	
	
		$(".btndeleteCate").click(function(e) {
			
			if (!confirm('Are you sure to delete this product?')) {
				e.preventDefault();
				
			}else {
				e.preventDefault();
				
				var motorsId = $(this).attr("id");
				
				var data = {};
				data["motorsId"] = motorsId;
				
					$.ajax({
						type : "DELETE",
						url : '${SpecificationAPI}',
						contentType : 'application/json; charset=utf-8',
						data : JSON.stringify(data),
						dataType : 'json',

						success : function(result) {
							alert('Deleted specification');
							$.ajax({
								type : "DELETE",
								url : '${MotorcyclesAPI}',
								contentType : 'application/json; charset=utf-8',
								data : JSON.stringify(data),
								dataType : 'json',

								success : function(result) {
									alert('Deleted motorcycles');
									window.location.href = "${LoadProductDetail}";
								},
								error : function(result) {
									alert('error');
									
								}
							});
							
						},
						error : function(result) {
							alert('error');
							
						}
					});
				
				
				
			}
			

		});

		

		
	</script>



	<script type="text/javascript">
		function getSelectedValue() {
			var selectedValue = document.getElementById("catego").value;

			$.ajax({
				url : "/MotorbikeStore/load",
				type : "get", //send it through get method
				contentType : 'application/json; charset=utf-8',
				data : {
					id : selectedValue
				},
				success : function(response) {
					var row = document.getElementById("contenthaha");
					row.innerHTML = response;
					$(".btndeleteProduct").click(function(e) {

						if (!confirm('Are you sure to delete this product?')) {
							e.preventDefault();
						}else {
							e.preventDefault();
							var aMotorId = $('#aMotorId').val();

							var data = {};
							data["aMotorId"] = aMotorId;
							$.ajax({
								type : "DELETE",
								url : '${aMotorcycleAPI}',
								contentType : 'application/json; charset=utf-8',
								data : JSON.stringify(data),
								dataType : 'json',

								success : function(result) {
									alert('Deleted aMotorcycle');
									window.location.href = "${LoadProductDetail}";
									console.log(result);
								},
								error : function(result) {
									alert('error');
									console.log(result);
								}
							});
						}

					});
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});

		}
	</script>


</body>
</html>