<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<c:url var="order" value="/order" />
<c:url var="checkout" value="/checkout" />
<html>
<head>
<meta charset="UTF-8">
<title>Check Out</title>
</head>
<body>

	<!-- Breadcrumb Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-12">
				<nav class="breadcrumb bg-light mb-30">
					<a class="breadcrumb-item text-dark" href="web-main-page">Home</a>
					<a class="breadcrumb-item text-dark" href="shop">Shop</a> <span
						class="breadcrumb-item active">Checkout</span>
				</nav>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->


	<!-- Checkout Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-lg-8">
				<h5 class="section-title position-relative text-uppercase mb-3">
					<span class="bg-secondary pr-3">Billing Address</span>
				</h5>
				<div class="bg-light p-30 mb-5">
					<div class="row">


						<div class="col-md-6 form-group">
							<label>Your Name</label> <input class="form-control" id="cusName"
								type="text" value="" placeholder="John" required="required"
								data-validation-required-message="Please enter your name">
						</div>
						<div class="col-md-6 form-group">
							<label>Identify Card</label> <input class="form-control"
								id="idCard" type="text" placeholder="010101" required="required"
								data-validation-required-message="Please enter idcard">
						</div>
						<div class="col-md-6 form-group">
							<label>E-mail</label> <input class="form-control" type="text"
								required="required"
								data-validation-required-message="Please enter your email"
								id="email" placeholder="example@email.com">
						</div>
						<div class="col-md-6 form-group">
							<label>Mobile No</label> <input class="form-control" type="text"
								required="required"
								data-validation-required-message="Please enter your num"
								id="phoneNum" placeholder="+123 456 789">
						</div>
						<div class="col-md-6 form-group">
							<label>Address</label> <input class="form-control" type="text"
								required="required"
								data-validation-required-message="Please enter your address"
								id="address" placeholder="123 Street">
						</div>

						<div class="col-md-6 form-group">
							<label>Country</label> <select class="custom-select" id="country">
								<option selected value="Vietnam">Vietnam</option>
								<option value="US">United States</option>
								<option value="Thailand">Thailand</option>

							</select>
						</div>




					</div>
				</div>

			</div>
			<div class="col-lg-4">
				<h5 class="section-title position-relative text-uppercase mb-3">
					<span class="bg-secondary pr-3">Order Total</span>
				</h5>
				<div class="bg-light p-30 mb-5">
					<div class="border-bottom">
						<h6 class="mb-3">Products</h6>


						<c:forEach var="item" items="${model.listResult}">

							<div class="d-flex justify-content-between">
								<p>${item.motors_Name}</p>
								<p>$ ${item.moneyPrepaid}</p>


							</div>

						</c:forEach>





					</div>

					<div class="pt-2">
						<div class="d-flex justify-content-between mt-2">
							<h5>Total</h5>
							<h5>$ ${cart.totalPrice}</h5>
						</div>
					</div>
				</div>
				<div class="mb-5">
					<h5 class="section-title position-relative text-uppercase mb-3">
						<span class="bg-secondary pr-3">Payment</span>
					</h5>
					<div class="bg-light p-30">
						

						<button class="btn btn-block btn-primary font-weight-bold py-3"
							id="btnOrder">Place Order</button>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Checkout End -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		document.getElementById("btnOrder").onclick = function() {
			myFunction()
		};

		function myFunction() {
			
			var cusName = $('#cusName').val();
			var idCard = $('#idCard').val();
			var email = $('#email').val();
			var phoneNum = $('#phoneNum').val();
			var address = $('#address').val();
			var country = document.getElementById("country").value;
			
			
			var data = {};
			if (!confirm('Are you sure to place order ?')) {
				e.preventDefault();

			}else {
				data["cusName"] = cusName;
				data["idCard"] = idCard;
				data["email"] = email;
				data["phoneNum"] = phoneNum;
				data["address"] = address;
				data["country"] = country;
				$.ajax({
					url : '${order}',
					contentType : 'application/json',
					data : JSON.stringify(data),
					
					type : "post",
					
					success : function(response) {
						
						alert('Ordered');
						window.location.href = "${checkout}";
					},
					error : function(xhr) {
						alert('Error');
					}
				});
			}
		}
	</script>



</body>
</html>