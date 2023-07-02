<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chu cua admin</title>
</head>
<body>
	<div class="" id="home">

		<div class="container">
			<div class="row">
				<div class="col">
					<p class="text-white mt-5 mb-5">
						Welcome back, <b>Admin</b>
					</p>
				</div>
			</div>
			<!-- row -->
			<div class="row tm-content-row2">




				<div class="col-12 tm-block-col">
					<div
						class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
						<h2 class="tm-block-title">Orders List</h2>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">&nbsp;</th>
									<th scope="col">PAYMENT NO.</th>
									<th scope="col">STATUS</th>
									<th scope="col">CUSNAME</th>

									<th scope="col">PRODUCTNAME</th>
									<th scope="col">PRODUCTCOLOR</th>
									<th scope="col">DATEBUY</th>
									<th scope="col">DATEPREPAID</th>
									<th scope="col">MONEYPREPAID</th>
									<th scope="col">PRICE</th>
									<th scope="col">PAYMENTMETHOD</th>

								</tr>
							</thead>
							<tbody>






								<c:forEach var="item" items="${model.listResult}">

									<tr>
										<td><a
											href="admin-editPayment?id=${item.paymentId}"
											data-toggle="tooltip" title="Update "
											class="tm-product-delete-link"> <i class="fas fa-wrench"></i>
										</a></td>
										<th scope="row"><b># ${item.paymentId}</b></th>
										<td><div class="tm-status-circle moving">
                                        </div>${item.status}</td>
										<td><b>${item.cusName}</b></td>
										 <td><b>${item.motorsName}</b></td>
										 <td><b>${item.color}</b></td>
										 <td>${item.dateBuy}</td>
										 <td>${item.datePrepaid}</td>
										 <td><b>${item.moneyPrepaid}</b></td>
										 <td><b>${item.price}</b></td>
										 <td><b>${item.paymentMethod}</b></td>
									</tr>

								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>