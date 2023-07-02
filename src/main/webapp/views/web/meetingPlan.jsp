<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Meeting Plan</title>
</head>
<body>
	<!-- Breadcrumb Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-12">
				<nav class="breadcrumb bg-light mb-30">
					<a class="breadcrumb-item text-dark" href="web-main-page">Home</a>
					<a class="breadcrumb-item text-dark" href="shop">Shop</a> <span
						class="breadcrumb-item active">Meeting Plan</span>
				</nav>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->


	<!-- Checkout Start -->
	<form action="https://formspree.io/f/moqbzobb" method="post">
		<div class="container-fluid">
			<div class="row px-xl-5">

				<div class="col-lg-8">

					<h5 class="section-title position-relative text-uppercase mb-3">
						<span class="bg-secondary pr-3">Plan Details</span>
					</h5>
					<div class="bg-light p-30 mb-5">

						<div class="row">

							<div class="col-md-6 form-group">

								<label for="firstname">First Name</label> <input
									class="form-control" name="firstname" id="firstname"
									type="text" placeholder="John">
							</div>
							<div class="col-md-6 form-group">
								<label for="lastname">Last Name</label> <input
									class="form-control" type="text" name="lastname" id="lastname"
									placeholder="Doe">

							</div>
							<div class="col-md-6 form-group">
								<label for="email">E-mail</label> <input type="email"
									name="email" class="form-control" id="email"
									placeholder="example@email.com">
							</div>
							<div class="col-md-6 form-group">
								<label for="mobileno">Mobile No</label> <input
									class="form-control" type="text" name="mobileno" id="mobileno"
									placeholder="+123 456 789">
							</div>
							<div class="col-md-6 form-group">
								<label for="time">Time</label> <input class="form-control"
									name="time" id="time" type="text" placeholder="123 Street">
							</div>
							<div class="col-md-6 form-group">
								<label for="MeetInStore">Meet In Store</label> <input
									class="form-control" name="MeetInStore" id="MeetInStore"
									type="text" placeholder="123 Street">
							</div>
							<div class="col-md-6 form-group">
								<label for="country">Country</label> <select
									class="custom-select" name="country" id="country">
									<option selected>VietNam</option>
									<option>United States</option>
									<option>Albania</option>
									<option>Algeria</option>
								</select>
							</div>
							<div class="col-md-6 form-group">
								<label for="city">City</label> <input class="form-control"
									type="text" name="city" id="city" placeholder="New York">
							</div>
							<div class="col-md-6 form-group">
								<label for="state">State</label> <input class="form-control"
									name="state" id="state" type="text" placeholder="New York">
							</div>

							<div class="col-md-12 form-group">
								<div class="custom-control custom-checkbox">
									<input type="checkbox" class="custom-control-input"
										name="newaccount" id="newaccount"> <label
										class="custom-control-label" for="newaccount">Agreement</label>
								</div>
							</div>

						</div>
					</div>
					<div class="collapse mb-5" id="shipping-address">
						<h5 class="section-title position-relative text-uppercase mb-3">
							<span class="bg-secondary pr-3">Shipping Address</span>
						</h5>
						<div class="bg-light p-30">
							<div class="row">
								<div class="col-md-6 form-group">
									<label for="firstname">First Name</label> <input
										class="form-control" name="firstname" id="firstname"
										type="text" placeholder="John">
								</div>
								<div class="col-md-6 form-group">
									<label for="lastname">Last Name</label> <input
										class="form-control" name="lastname" id="lastname" type="text"
										placeholder="Doe">

									<div class="col-md-6 form-group">
										<label for="mobileno">Mobile No</label> <input
											class="form-control" name="mobileno" id="mobileno"
											type="text" placeholder="+123 456 789">
									</div>
									<div class="col-md-6 form-group">
										<label for=time>Time</label> <input class="form-control"
											type="time" name="time" id="time" placeholder="123 Street">
									</div>
									<div class="col-md-6 form-group">
										<label for="MeetInStore">Meet In Store</label> <input
											class="form-control" name="MeetInStore" id="MeetInStore"
											type="text" placeholder="123 Street">
									</div>
									<div class="col-md-6 form-group">
										<label for="country">Country</label> <select
											class="custom-select" name="country" id="country">
											<option selected>VietNam</option>
											<option>United States</option>
											<option>Albania</option>
											<option>Algeria</option>
										</select>
									</div>
									<div class="col-md-6 form-group">
										<label for="city">City</label> <input class="form-control"
											type="text" name="city" id="city" placeholder="New York">
									</div>
									<div class="col-md-6 form-group">
										<label for="state">State</label> <input class="form-control"
											name="state" id="state" type="text" placeholder="New York">
									</div>

								</div>
							</div>
						</div>

					</div>
					</div>
					<div class="col-lg-4">

						<div class="mb-5">
							<h5 class="section-title position-relative text-uppercase mb-3">
								<span class="bg-secondary pr-3">Your Offer</span>
							</h5>
							<div class="bg-light p-30">

								<button class="btn btn-block btn-primary font-weight-bold py-3"
									type="submit">Offer Plan</button>
								<button class="btn btn-block btn-primary font-weight-bold py-3"
									onclick="window.location.href='cart'">Cart</button>
							</div>
						</div>
					</div>



				
			</div>
			</div>
	</form>
	<!-- Checkout End -->
</body>
</html>