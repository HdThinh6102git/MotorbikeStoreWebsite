<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="editpayment" value="/admin-editPayment" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Edit Payment</title>


</head>
<body>


	<div class="container tm-mt-big tm-mb-big">
		<div class="row">
			<div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
				<div class="tm-bg-primary-dark tm-block tm-block-h-auto">

					<form method="post" action="${editpayment}">
						<div class="form-group ">
							<label for="name">Pre paid Money </label> <input id=""
								name="moneyPrepaid" type="text" class="form-control validate"
								required value="${model.moneyPrepaid}" />
						</div>
						<div class="col-12">
							<button type="submit" id="btnAddPicture" value="addPicture"
								class="btn btn-primary btn-block text-uppercase">Edit
								Payment Now</button>

						</div>
					</form>

				</div>
			</div>
		</div>
	</div>




</body>
</html>