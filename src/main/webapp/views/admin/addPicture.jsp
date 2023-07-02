<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="addPicture" value="/admin-addPicture" />
<c:url var="delPicture" value="/delPictureAPI" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Edit Picture</title>


</head>
<body>


	<div class="container tm-mt-big tm-mb-big">
		<div class="row">
			<div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
				<div class="tm-bg-primary-dark tm-block tm-block-h-auto">

					<form method="post"
						action="<%=request.getContextPath()%>/admin-addPicture"
						enctype="multipart/form-data">
						<div class="form-group">
							<label for="picture">Picture</label>&emsp;
							<!-- <input type="file" id="file-input" multiple name="picture"/><br></br> -->
							<%-- <img class="blah"width="200px" height="200px" src="<%=request.getContextPath()%>/templates/admin/images/noimage.gif" alt="no-image"/> --%>
							<input type="file" multiple id="gallery-photo-add" name="picture">
							<div class="gallery"></div>
						</div>
						<div class="col-12">
							<button type="submit" id="btnAddPicture" value="addPicture"
								class="btn btn-primary btn-block text-uppercase">Add
								Picture Now</button>

						</div>
					</form>





					<div class="tm-product-table-container">
						<table class="table table-hover tm-table-small tm-product-table">
							<thead>
								<tr>

									<th scope="col">ID</th>
									<th scope="col">PictureName</th>
									<th scope="col">AMotorID</th>
									<th scope="col">Picture</th>
									<th scope="col">&nbsp;</th>

								</tr>
							</thead>
							<tbody id="">
								<c:forEach var="item" items="${model.listResult}">
									<tr>
										<td class="tm-product-name">${item.picId}</td>
										<td>${item.picName}</td>
										<td>${item.aMotorId}</td>
										
										<c:set var="path" value="${model.picPath}${item.picName}" />
										<td><img alt="picture" src="${path}"
											style="width: 100px; height: 100px"></td>
										<td><a href="delPictureAPI?id=${item.picId}&id2=${item.aMotorId}" id="${item.picId}"
											class="btndeletePicture" data-toggle="tooltip" title="Delete"
											class="tm-product-delete-link"> <i
												class="far fa-trash-alt tm-product-delete-icon"></i>
										</a></td>
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
		$(".btndeletePicture1").click(function(e) {
			if (!confirm('Are you sure to delete this picture?')) {
				e.preventDefault();
			} else {
				e.preventDefault();
				var PicId = $(this).attr("id");
				var aMotor = 

				
				$.ajax({
					type : "DELETE",
					url : '${delPicture}',
					
					data:{
						id1 : PicId
						motorid : 
					},
					success : function(result) {
						alert('Deleted Picture');
						window.location.href = "${addPicture}";
						
					},
					error : function(result) {
						alert('error');
						
					}
				});
			}

		});
	</script>
	<script>
		$(function() {
			// Multiple images preview in browser
			var imagesPreview = function(input, placeToInsertImagePreview) {

				if (input.files) {
					var filesAmount = input.files.length;

					for (i = 0; i < filesAmount; i++) {
						var reader = new FileReader();

						reader.onload = function(event) {
							$(
									$
											.parseHTML('<img style="width:100px;height:100px;padding:3px;">'))
									.attr('src', event.target.result).appendTo(
											placeToInsertImagePreview);
						}

						reader.readAsDataURL(input.files[i]);
					}
				}

			};

			$('#gallery-photo-add').on('change', function() {
				imagesPreview(this, 'div.gallery');
			});
		});
	</script>
</body>
</html>