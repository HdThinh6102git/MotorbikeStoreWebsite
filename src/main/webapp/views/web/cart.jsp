<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ include file="/template/web/cartpage/css/cssLink.jsp"%>
<!DOCTYPE html>
<html>

<head>
<title>Cart</title>
<meta charset="UTF-8">
</head>
<body>

	<!-- Breadcrumb Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-12">
				<nav class="breadcrumb bg-light mb-30">
					<a class="breadcrumb-item text-dark" href="web-main-page">Home</a> <a
						class="breadcrumb-item text-dark" href="shop">Shop</a> <span
						class="breadcrumb-item active">Shopping Cart</span>
				</nav>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->


	<!-- Cart Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-lg-8 table-responsive mb-5">
				<table
					class="table table-light table-borderless table-hover text-center mb-0">
					<thead class="thead-dark">
						<tr>
							<th>Products</th>
							<th>Price</th>
							<th>Deposit</th>
							<th>Total</th>
							<th>Remove</th>
						</tr>
					</thead>
					<tbody class="align-middle">

						 
						<c:forEach var="item" items="${model.listResult}">
							
							
							<tr>
								<td class="align-middle"><img src="img/product-1.jpg"
									alt="" style="width: 50px;">${item.motors_Name}</td>
								<td class="align-middle">$${item.price}</td>
								<td class="align-middle">$${item.moneyPrepaid}</td>
								<td class="align-middle">$${item.moneyPrepaid}</td>
								

								<td class="align-middle">
									<a href="DeleteCart?id=${item.cartId}&userId=<%=session.getAttribute("userId")%>"><i class="fa fa-times"></i></a> </td>



							</tr>

						</c:forEach>







					</tbody>
				</table>
			</div>
			<div class="col-lg-4">
				<form class="mb-30" action="">
					<div class="input-group">
						<input type="text" class="form-control border-0 p-4"
							placeholder="Coupon Code">
						<div class="input-group-append">
							<button class="btn btn-primary">Apply Coupon</button>
						</div>
					</div>
				</form>
				<h5 class="section-title position-relative text-uppercase mb-3">
					<span class="bg-secondary pr-3">Cart Summary</span>
				</h5>
				<div class="bg-light p-30 mb-5">

					<div class="pt-2">
						<div class="d-flex justify-content-between mt-2">
							<h5>Total</h5>
							<h5>$${cart.totalPrice}</h5>
						</div>
						<button
							class="btn btn-block btn-primary font-weight-bold my-3 py-3"
							onclick="window.location.href='checkout'">Proceed To
							Checkout</button>
						<button
							class="btn btn-block btn-primary font-weight-bold my-3 py-3"
							onclick="window.location.href='meetingPlan'">Plans For
							Buying Directly In Store</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Cart End -->
</body>
</html>