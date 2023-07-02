<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="comment" value="/admin-comments" />
<c:url var="commentAPI" value="/commentAPI" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comments Manage</title>
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
									<th scope="col">User Name</th>
									<th scope="col">Comment</th>
									<th scope="col">Date</th>

									<th scope="col">Product ID</th>
									<th scope="col">Product Name</th>
									<th scope="col">Color</th>
									

								</tr>
							</thead>
							<tbody>






								<c:forEach var="item" items="${model.listResult}">

									<tr>
										<td><a
											href="" id = "${item.cmtId }"
											class="btndeleteComment" data-toggle="tooltip" title="Delete"
											class="tm-product-delete-link"> <i
												class="far fa-trash-alt tm-product-delete-icon"></i>

										</a></td>
										<td><b>${item.userName}</b></td>
										<td><b>${item.cmtDesc}</b></td>
										<td><b>${item.dateCmt}</b></td>
										<td><b>${item.aMotorId}</b></td>
										<td><b>${item.motorName}</b></td>
										<td><b>${item.motorColor}</b></td>
										 
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

$(".btndeleteComment").click(function(e) {
	if (!confirm('Are you sure to delete this comment?')) {
		e.preventDefault();
	}else {
		e.preventDefault();
		var cmtId = $(this).attr("id");

		var data = {};
		data["cmtId"] = cmtId;
		$.ajax({
			type : "DELETE",
			url : '${commentAPI}',
			contentType : 'application/json; charset=utf-8',
			data : JSON.stringify(data),
			dataType : 'json',

			success : function(result) {
				alert('Deleted comment');
				window.location.href = "${comment}";
				
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