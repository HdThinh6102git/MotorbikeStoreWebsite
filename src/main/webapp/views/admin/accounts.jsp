<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="accounts" value="/admin-accounts" />
<c:url var="accountAPI" value="/accountAPI" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Manage</title>
</head>
<body>
	<div class="" id="home">

		<div class="container">
			
			<!-- row -->
			<div class="row tm-content-row2">




				<div class="col-12 tm-block-col">
					<div
						class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
						<h2 class="tm-block-title">List Comments</h2>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">&nbsp;</th>
									<th scope="col">&nbsp;</th>
									<th scope="col">User Name</th>
									<th scope="col">Pass word</th>
									<th scope="col">Role name</th>

									<th scope="col">Email</th>
									<th scope="col">Phone Number</th>
									<th scope="col">Identify Card</th>
									

								</tr>
							</thead>
							<tbody>






								<c:forEach var="item" items="${model.listResult}">

									<tr>
										<td><a
											href="" id = "${item.userId}"
											class="btndeleteAccount" data-toggle="tooltip" title="Delete"
											class="tm-product-delete-link"> <i
												class="far fa-trash-alt tm-product-delete-icon"></i>

										</a></td>
										<td><a
											href="admin-editAccount?id=${item.userId}"
											data-toggle="tooltip" title="Update "
											class="tm-product-delete-link"> <i class="fas fa-wrench"></i>
										</a></td>
										<td><b>${item.userName}</b></td>
										<td><b>${item.userPass}</b></td>
										<td><b>${item.roleName}</b></td>
										<td><b>${item.email}</b></td>
										<td><b>${item.phoneNum}</b></td>
										<td><b>${item.idCard}</b></td>
										 
									</tr>

								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>


<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>

$(".btndeleteAccount").click(function(e) {
	if (!confirm('Are you sure to delete this account?')) {
		e.preventDefault();
	}else {
		e.preventDefault();
		var userId = $(this).attr("id");

		var data = {};
		data["userId"] = userId;
		$.ajax({
			type : "DELETE",
			url : '${accountAPI}',
			contentType : 'application/json; charset=utf-8',
			data : JSON.stringify(data),
			dataType : 'json',

			success : function(result) {
				alert('Deleted account');
				window.location.href = "${accounts}";
				
			},
			error : function(result) {
				alert('error');
				
			}
		});
	}
	

});
</script>

</body>
</html>