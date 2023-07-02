<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="MotorcyclesAPI" value="/api-admin-Motorcycles" />
<c:url var="SpecificationAPI" value="/api-admin-Specification" />
<c:url var="LoadProductDetail" value="/admin-products" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:if test="${not empty model1.motorsId }">
	<title>Edit Category</title>
</c:if>
<c:if test="${empty model1.motorsId }">
	<title>Add Category</title>
</c:if>

</head>
<body>
	<div class="container tm-mt-big tm-mb-big">
		<div class="row">
			<div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
				<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
					<div class="row">
						<div class="col-12">
							<c:if test="${not empty model1.motorsId }">
								<h2 class="tm-block-title d-inline-block">Edit Category</h2>
							</c:if>
							<c:if test="${empty model1.motorsId }">
								<h2 class="tm-block-title d-inline-block">Add Category</h2>
							</c:if>

						</div>
					</div>
					<div class="row tm-edit-product-row">

						<div class="col-xl-6 col-lg-6 col-md-12">
							<input id="tempId" name="tempId" type="hidden"
								class="form-control validate" required
								value="${model1.motorsId }" />
							<form id="formCategory" class="tm-edit-product-form">
								<c:if test="${not empty model1.motorsId }">
									<div class="form-group mb-3">
										<label for="name">Category ID </label> <input id="motorsId"
											name="motorsId" type="text" class="form-control validate"
											required disabled="disabled" value="${model1.motorsId }" />
									</div>
								</c:if>
								<c:if test="${empty model1.motorsId }">
									<div class="form-group mb-3">
										<label for="name">Category ID </label> <input id="motorsId"
											name="motorsId" type="text" class="form-control validate"
											required value="${model1.motorsId }" />
									</div>
								</c:if>

								<div class="form-group mb-3">
									<label for="name">Category Name </label> <input
										id="motors_Name" name="motors_Name" type="text"
										class="form-control validate" required
										value="${model1.motors_Name }" />
								</div>
								<div class="form-group mb-3">
									<label for="name">Version </label> <input id="version"
										name="version" type="text" class="form-control validate"
										required value="${model1.version }" />
								</div>
								<div class="form-group mb-3">
									<label for="name">Type </label> <input id="motorType"
										name="motorType" type="text" class="form-control validate"
										required value="${model1.motorType }" />
								</div>

								<div class="form-group mb-3">
									<label for="name">Branch </label> <input id="branch"
										name="branch" type="text" class="form-control validate"
										required value="${model1.branch }" />
								</div>
								<div class="form-group mb-3">
									<label for="name">Style </label> <input id="style" name="style"
										type="text" class="form-control validate" required
										value="${model1.style }" />
								</div>
								<div class="form-group mb-3">
									<label for="name">Quantity </label> <input id="quantity"
										name="quantity" type="text" class="form-control validate"
										required value="${model1.quantity }" />
								</div>

								<div class="form-group mb-3">
									<label for="name">Check Sale </label> <input id="checkSale"
										name="checkSale" type="text" class="form-control validate"
										required value="${model1.checkSale }" />
								</div>

								<div class="form-group mb-3">
									<label for="description">Description</label>
									<textarea class="form-control validate" rows="3" required
										id="motors_decs" name="motors_decs">${model1.motors_decs}</textarea>
								</div>
							</form>
						</div>

						<div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
							<form id="formCategory2">

								<div class="form-group mb-3">
									<label for="name">Size </label> <input id="size" name="size"
										type="text" class="form-control validate" required
										value="${model2.size }" />
								</div>
								<div class="form-group mb-3">
									<label for="name">Mass(KG) </label> <input id="massKg"
										name="massKg" type="text" class="form-control validate"
										required value="${model2.massKg }" />
								</div>
								<div class="form-group mb-3">
									<label for="name">Height(CM) </label> <input
										id="saddleHeightCm" name="saddleHeightCm" type="text"
										class="form-control validate" required
										value="${model2.saddleHeightCm }" />
								</div>
								<div class="form-group mb-3">
									<label for="name">RPM </label> <input id="rpm" name="rpm"
										type="text" class="form-control validate" required
										value="${model2.rpm }" />
								</div>
								<div class="form-group mb-3">
									<label for="name">Engine Torque </label> <input
										id="engineTorque" name="engineTorque" type="text"
										class="form-control validate" required
										value="${model2.engineTorque}" />
								</div>
								<div class="form-group mb-3">
									<label for="name">Horse Power </label> <input id="horsePower"
										name="horsePower" type="text" class="form-control validate"
										required value="${model2.horsePower}" />
								</div>
							</form>
						</div>


						<div class="col-12">
							<c:if test="${not empty model1.motorsId }">
								<button type="button" id="btnAddorUpdatecate" value="updatecate"
									class="btn btn-primary btn-block text-uppercase">Update
									Category Now</button>
							</c:if>
							<c:if test="${empty model1.motorsId }">
								<button type="button" id="btnAddorUpdatecate" value="addcate"
									class="btn btn-primary btn-block text-uppercase">Add
									Category Now</button>
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
		$("#btnAddorUpdatecate")
				.click(
						function(e) {

							e.preventDefault();
							var id = $('#tempId').val();
							var motorsId = $('#motorsId').val();
							var data = {};
							var data2 = {};

							var formData = $('#formCategory').serializeArray();
							var formData2 = $('#formCategory2')
									.serializeArray();

							$.each(formData, function(i, v) {
								data["" + v.name + ""] = v.value;
								console.log(v);
							});
							$.each(formData2, function(i, v) {
								data2["" + v.name + ""] = v.value;
								console.log(v);
							});
							data2["motorsId"] = motorsId;
							data["motorsId"] = motorsId;
							if (id == "") {
								if (!confirm('Are you sure to add this category?')) {
									e.preventDefault();

								} else {

									$
											.ajax({
												type : "POST",
												url : '${MotorcyclesAPI}',
												contentType : 'application/json; charset=utf-8',
												data : JSON.stringify(data),
												dataType : 'json',

												success : function(result) {
													alert('add motorcycles');
													$
															.ajax({

																type : "POST",
																url : '${SpecificationAPI}',
																contentType : 'application/json; charset=utf-8',
																data : JSON
																		.stringify(data2),
																dataType : 'json',

																success : function(
																		result) {
																	alert('add specification');
																	window.location.href = "${LoadProductDetail}";
																},
																error : function(
																		result) {
																	alert('error');

																}
															});
												},
												error : function(result) {
													alert('error');

												}
											});

								}

							} else {
								if (!confirm('Are you sure to update this category?')) {
									e.preventDefault();

								} else {
									$
											.ajax({
												type : "PUT",
												url : '${SpecificationAPI}',
												contentType : 'application/json; charset=utf-8',
												data : JSON.stringify(data2),
												dataType : 'json',

												success : function(result) {
													alert('update specification');
													$
															.ajax({
																type : "PUT",
																url : '${MotorcyclesAPI}',
																contentType : 'application/json; charset=utf-8',
																data : JSON
																		.stringify(data),
																dataType : 'json',
																success : function(
																		result) {
																	alert('update motorcycles');
																	window.location.href = "${LoadProductDetail}";
																},
																error : function(
																		result) {
																	alert('error');

																}
															});
												},
												error : function(result) {
													alert('error');

												}
											});

								}

							}

						});
	</script>
</body>
</html>