<%@page import="com.MotorbikeStore.service.impl.ProductDetailService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="aMotorcycleAPI" value="/api-admin-aMotorcycle" />
<c:url var="LoadProductDetail" value="/admin-products" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:if test="${not empty model4.aMotorId }">
	<title>Edit Product</title>
</c:if>
<c:if test="${empty model4.aMotorId }">
	<title>Add Product</title>
</c:if>

</head>
<body>
	<div class="container tm-mt-big tm-mb-big">
		<div class="row">
			<div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
				<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
					<div class="row">
						<div class="col-12">
							<c:if test="${not empty model4.aMotorId }">
								<h2 class="tm-block-title d-inline-block">Edit Product</h2>
							</c:if>
							<c:if test="${empty model4.aMotorId }">
								<h2 class="tm-block-title d-inline-block">Add Product</h2>
							</c:if>

						</div>
					</div>

					<div class="row tm-edit-product-row">

						<div class="col-xl-6 col-lg-6 col-md-12">


							<input id="tempId1" name="tempId" type="hidden"
								class="form-control validate" required
								value="${model4.aMotorId }" /> <input id="tempmotorsId"
								name="tempId" type="hidden" class="form-control validate"
								required value="${model4.motorsId }" />
							<form id="formProduct" class="tm-edit-product-form">

								<div class="form-group mb-3">
									<label for="category">Category</label> <select
										class="custom-select tm-select-accounts" id="category"
										onchange="getSelectedValue(); getSelectedValue2(); ">

										<c:forEach var="item" items="${model1.listResult}">
											<option value="">Category</option>
											<c:if test="${item.motorsId == model2.motorsId}">
												<option selected value="${item.motorsId}">${item.motors_Name}</option>

											</c:if>

											<option value="${item.motorsId}">${item.motors_Name}</option>
										</c:forEach>
									</select>
								</div>


								<c:if test="${not empty model4.aMotorId }">
									<div class="form-group mb-3">
										<label for="name">Product ID </label> <input id="aMotorId"
											name="aMotorId" type="text" class="form-control validate"
											required disabled="disabled" value="${model4.aMotorId}" />
									</div>
								</c:if>
								<c:if test="${empty model4.aMotorId }">
									<div class="form-group mb-3">
										<label for="name">Product ID </label> <input id="aMotorId"
											name="aMotorId" type="text" class="form-control validate"
											required value="${model4.aMotorId}" />
									</div>
								</c:if>

								<div class="form-group mb-3">
									<label for="name">Color </label> <input id="color" name="color"
										type="text" class="form-control validate" required
										value="${model4.color }" />
								</div>
								<div class="form-group mb-3">
									<label for="name">Price </label> <input id="price" name="price"
										type="text" class="form-control validate" required
										value="${model4.price }" />
								</div>
								<div class="form-group mb-3">
									<label for="name">Check Sold </label> <input id="checkSold"
										name="checkSold" type="text" class="form-control validate"
										required value="${model4.checkSold }" />
								</div>
								<div class="form-group mb-3">
										<label for="description">A Motor Description</label>
										<textarea class="form-control validate" id="aMotorDesc"
											name="aMotorDesc"  rows="3" required>${model4.aMotorDesc}</textarea>
									</div>



								<div id="motorcycles">

									<div class="form-group mb-3">
										<label for="name">Product Name </label> <input
											id="motors_Name" name="motors_Name" type="text"
											class="form-control validate" required disabled="disabled"
											value="${model2.motors_Name}" />
									</div>
									<div class="form-group mb-3">
										<label for="name">Version </label> <input id="version"
											name="version" type="text" class="form-control validate"
											required disabled="disabled" value="${model2.version}" />
									</div>
									<div class="form-group mb-3">
										<label for="name">Type </label> <input id="motorType"
											name="motorType" type="text" class="form-control validate"
											required disabled="disabled" value="${model2.motorType }" />
									</div>

									<div class="form-group mb-3">
										<label for="name">Branch </label> <input id="branch"
											name="branch" type="text" class="form-control validate"
											required disabled="disabled" value="${model2.branch }" />
									</div>
									<div class="form-group mb-3">
										<label for="name">Style </label> <input id="style"
											name="style" type="text" class="form-control validate"
											required disabled="disabled" value="${model2.style }" />
									</div>
									<div class="form-group mb-3">
										<label for="description">Description</label>
										<textarea class="form-control validate" id="motors_decs"
											name="motors_decs" disabled="disabled" rows="3" required>${model2.motors_decs}</textarea>
									</div>
								</div>


							</form>
						</div>


						<div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
							<form id="formProduct2">





								<div id="specification">
									<div class="form-group mb-3">
										<label for="name">Size </label> <input id="size" name="size"
											type="text" class="form-control validate" required
											disabled="disabled" value="${model3.size }" />
									</div>
									<div class="form-group mb-3">
										<label for="name">Mass(KG) </label> <input id="massKg"
											name="massKg" type="text" class="form-control validate"
											required disabled="disabled" value="${model3.massKg }" />
									</div>
									<div class="form-group mb-3">
										<label for="name">Height(CM) </label> <input
											id="saddleHeightCm" name="saddleHeightCm" type="text"
											class="form-control validate" required disabled="disabled"
											value="${model3.saddleHeightCm }" />
									</div>
									<div class="form-group mb-3">
										<label for="name">RPM </label> <input id="rpm" name="rpm"
											type="text" class="form-control validate" required
											disabled="disabled" value="${model3.rpm }" />
									</div>
									<div class="form-group mb-3">
										<label for="name">Engine Torque </label> <input
											id="engineTorque" name="engineTorque" type="text"
											class="form-control validate" required disabled="disabled"
											value="${model3.engineTorque}" />
									</div>
									<div class="form-group mb-3">
										<label for="name">Horse Power </label> <input id="horsePower"
											name="horsePower" type="text" class="form-control validate"
											required disabled="disabled" value="${model3.horsePower}" />
									</div>



								</div>


							</form>


						</div>
						<div class="col-12">
							<c:if test="${not empty model4.aMotorId }">
								<button type="button" id="btnAddOrUpdateProduct"
									value="updateProduct"
									class="btn btn-primary btn-block text-uppercase">Update
									Product Now</button>
							</c:if>
							<c:if test="${empty model4.aMotorId }">
								<button type="button" id="btnAddOrUpdateProduct"
									value="addProduct"
									class="btn btn-primary btn-block text-uppercase">Add
									Product Now</button>
							</c:if>

						</div>



					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value='/template/admin/jquery-ui-datepicker/jquery-ui.min.js' />"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<script>
		$("#btnAddOrUpdateProduct").click(function(e) {

			e.preventDefault();
			var id = $('#tempId1').val();
			var motorsId = $('#motorsId').val();
			var motorsId2 = $('#tempmotorsId').val();
			var aMotorId = $('#aMotorId').val();
			var color = $('#color').val();
			var price = $('#price').val();
			var checkSold = $('#checkSold').val();
			var aMotorDesc = $('#aMotorDesc').val();

			var data = {};

			if (id == "") {
				if (!confirm('Are you sure to add this product?')) {
					e.preventDefault();

				} else {
					data["motorsId"] = motorsId;
					data["aMotorId"] = aMotorId;
					data["color"] = color;
					data["price"] = price;
					data["checkSold"] = checkSold;
					data["aMotorDesc"] = aMotorDesc;
					$.ajax({
						type : "POST",
						url : '${aMotorcycleAPI}',
						contentType : 'application/json',
						data : JSON.stringify(data),
						success : function(result) {
							alert('Product Added');
							window.location.href = "${LoadProductDetail}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}

			} else {
				if (!confirm('Are you sure to update this product?')) {
					e.preventDefault();

				} else {
					if (typeof motorsId != 'undefined') {
						data["motorsId"] = motorsId;
					} else {
						data["motorsId"] = motorsId2;
					}

					data["aMotorId"] = aMotorId;
					data["color"] = color;
					data["price"] = price;
					data["checkSold"] = checkSold;
					data["aMotorDesc"] = aMotorDesc;
					$.ajax({
						type : "PUT",
						url : '${aMotorcycleAPI}',
						contentType : 'application/json',
						data : JSON.stringify(data),
						success : function(result) {
							alert('Product updated');
							window.location.href = "${LoadProductDetail}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}

			}

		});

		function getSelectedValue() {
			var selectedValue = document.getElementById("category").value;

			$
					.ajax({
						url : "/MotorbikeStore/loadMotorcycles",
						type : "get", //send it through get method
						data : {
							id : selectedValue

						},
						success : function(response) {

							var row = document.getElementById("motorcycles");
							row.innerHTML = response;
							$(function() {
								// Multiple images preview in browser
								var imagesPreview = function(input,
										placeToInsertImagePreview) {

									if (input.files) {
										var filesAmount = input.files.length;

										for (i = 0; i < filesAmount; i++) {
											var reader = new FileReader();

											reader.onload = function(event) {
												$(
														$
																.parseHTML('<img style="width:100px;height:100px;padding:3px;">'))
														.attr(
																'src',
																event.target.result)
														.appendTo(
																placeToInsertImagePreview);
											}

											reader
													.readAsDataURL(input.files[i]);
										}
									}

								};

								$('#gallery-photo-add').on('change',
										function() {
											imagesPreview(this, 'div.gallery');
										});
							});

						},
						error : function(xhr) {
							//Do Something to handle error
						}
					});

		}

		function getSelectedValue2() {
			var selectedValue = document.getElementById("category").value;

			$.ajax({
				url : "/MotorbikeStore/loadSpecification",
				type : "get", //send it through get method
				data : {
					id : selectedValue
				},
				success : function(response) {
					var row = document.getElementById("specification");
					row.innerHTML = response;

				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});

		}
	</script>

</body>
</html>