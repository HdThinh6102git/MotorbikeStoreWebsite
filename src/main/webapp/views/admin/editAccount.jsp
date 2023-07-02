<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="editAccount" value="/admin-editAccount" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Edit Account</title>


</head>
<body>


	<div class="container tm-mt-big tm-mb-big">
		<div class="row">
			<div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
				<div class="tm-bg-primary-dark tm-block tm-block-h-auto">

					<form method="post" action="${editAccount}">
						<div class="form-group ">
							<label for="name">User Name </label> <input id=""
								name="userName" type="text" class="form-control validate"
								required value="${model.userName}" />
						</div>
						<div class="form-group ">
							<label for="name">Password </label> <input id=""
								name="userPass" type="text" class="form-control validate"
								required value="${model.userPass}" />
						</div>
						
						<div class="form-group ">
							<label for="name">Email </label> <input id=""
								name="email" type="text" class="form-control validate"
								required value="${model.email}" />
						</div>
						<div class="form-group ">
							<label for="name">Phone Number </label> <input id=""
								name="phoneNum" type="text" class="form-control validate"
								required value="${model.phoneNum}" />
						</div>
						<div class="form-group ">
							<label for="name">Identify Card </label> <input id=""
								name="idCard" type="text" class="form-control validate"
								required value="${model.idCard}" />
						</div>
						<div class="col-12">
							<button type="submit" id="btnAddPicture" value="addPicture"
								class="btn btn-primary btn-block text-uppercase">Edit
								Account Now</button>

						</div>
					</form>

				</div>
			</div>
		</div>
	</div>




</body>
</html>