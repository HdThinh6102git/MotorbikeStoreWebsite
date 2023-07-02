<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="search" value="/search" />
<c:url var="filterPrice" value="/filterPrice" />
<c:url var="filterColor" value="/filterColor" />
<c:url var="filterCC" value="/filterCC" />
<c:url var="filterBranch" value="/filterBranch" />
<c:url var="filterMix" value="/filterMix" />
<c:url var="showNumProduct" value="/showNumProduct" />
<c:url var="addCart" value="/addCart" />
<c:url var="login" value="/login" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop</title>
</head>


<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="web-main-page">Home</a> <a
					class="breadcrumb-item text-dark" href="shop">Shop</a> <span
					class="breadcrumb-item active">Shop List</span>

				<div class="input-group">
					<input type="text" class="form-control" name="txtSearch"
						oninput="searchbyname(this)" placeholder="Search for products">
					<div class="input-group-append">
						<span class="input-group-text bg-transparent text-primary">
							<i class="fa fa-search"></i>
						</span>
					</div>
				</div>
			</nav>

		</div>
	</div>
</div>
<!-- Breadcrumb End -->


<!-- Shop Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<!-- Shop Sidebar Start -->
		<div class="col-lg-3 col-md-4">
			<!-- Price Start -->
			<h5 class="section-title position-relative text-uppercase mb-3">
				<span class="bg-secondary pr-3">Filter by price</span>
			</h5>
			<div class="bg-light p-4 mb-30">

				<div class="">
					<input type="radio" class="" value="0" name="radio" checked
						onclick="priceChecked()" id="price-all"> <label class=""
						for="price-all">All Price</label>
				</div>
				<div class="">
					<input type="radio" class="" id="price-1" name="radio" value="1"
						onclick="priceChecked1()"> <label class="" for="price-1">$100
						- $500</label>
				</div>
				<div class="">
					<input type="radio" class="" id="price-2" value="2" name="radio"
						onclick="priceChecked2()"> <label class="" for="price-2">$500
						- $1000</label>
				</div>
				<div class="">
					<input type="radio" class="" id="price-3" value="3" name="radio"
						onclick="priceChecked3()"> <label class="" for="price-3">$1000
						- $3000</label>

				</div>



			</div>
			<!-- Price End -->

			<!-- Color Start -->
			<h5 class="section-title position-relative text-uppercase mb-3">
				<span class="bg-secondary pr-3">Filter by color</span>
			</h5>
			<div class="bg-light p-4 mb-30">
				<form>
					<div class="">
						<input type="radio" class="" id="color-all" name="radio" checked
							value="0" onclick="colorChecked()"> <label class=""
							for="color-all">All Color</label>
					</div>
					<div class="">
						<input type="radio" class="" id="color-1" name="radio"
							onclick="colorChecked1()" value="1"> <label class=""
							for="color-1">Red</label>
					</div>
					<div class="">
						<input type="radio" class="" id="color-2" name="radio"
							onclick="colorChecked2()" value="2"> <label class=""
							for="color-2">Blue</label>
					</div>
					<div class="">
						<input type="radio" class="" id="color-3" name="radio"
							onclick="colorChecked3()" value="3"> <label class=""
							for="color-3">Black</label>
					</div>


				</form>
			</div>
			<!-- Color End -->

			<!-- Size Start -->
			<h5 class="section-title position-relative text-uppercase mb-3">
				<span class="bg-secondary pr-3">Filter by Cubic Centimeter</span>
			</h5>
			<div class="bg-light p-4 mb-30">
				<form>
					<div class="">
						<input type="radio" class="" checked name="radio" id="speed-all"
							value="0" onclick="speedChecked()"> <label class=""
							for="speed-all">All CC</label>
					</div>
					<div class="">
						<input type="radio" class="" id="speed-1" name="radio"
							onclick="speedChecked1()" value="1"> <label class=""
							for="speed-1">50 -110 CC</label>
					</div>
					<div class="">
						<input type="radio" class="" id="speed-2" name="radio"
							onclick="speedChecked2()" value="2"> <label class=""
							for="speed-2">110 -125 CC</label>
					</div>
					<div class="">
						<input type="radio" class="" id="speed-3" name="radio"
							onclick="speedChecked3()" value="3"> <label class=""
							for="speed-3">125 -150 CC</label>
					</div>


				</form>
			</div>
			<!-- Size End -->
			<!-- Size Start -->
			<h5 class="section-title position-relative text-uppercase mb-3">
				<span class="bg-secondary pr-3">Filter by Branch</span>
			</h5>
			<div class="bg-light p-4 mb-30">
				<form>
					<div class="">
						<input type="radio" class="" checked name="radio" id="branch-all"
							value="0" onclick="branchChecked()"> <label class=""
							for="branch-all">All Brach</label>
					</div>
					<div class="">
						<input type="radio" class="" id="branch-1" name="radio"
							onclick="branchChecked1()" value="1"> <label class=""
							for="branch-1">Honda</label>
					</div>
					<div class="">
						<input type="radio" class="" id="branch-2" name="radio"
							onclick="branchChecked2()" value="2"> <label class=""
							for="branch-2">Yamaha</label>
					</div>
					<div class="">
						<input type="radio" class="" id="branch-3" name="radio"
							onclick="branchChecked3()" value="3"> <label class=""
							for="branch-3">Suzuki</label>
					</div>
					<div class="">
						<input type="radio" class="" id="branch-4" name="radio"
							onclick="branchChecked4()" value="4"> <label class=""
							for="branch-4">SYM</label>
					</div>

				</form>
			</div>
			<!-- Size End -->
		</div>
		<!-- Shop Sidebar End -->


		<!-- Shop Product Start -->
		<div class="col-lg-9 col-md-8">
			<div class="row pb-3">
				<div class="col-12 pb-1">
					<div class="d-flex align-items-center justify-content-between mb-4">
						<div>
							<button class="btn btn-sm btn-light">
								<i class="fa fa-th-large"></i>
							</button>
							<button class="btn btn-sm btn-light ml-2">
								<i class="fa fa-bars"></i>
							</button>
						</div>
						<div class="ml-2">

							<div class="btn-group ml-2">
								<button type="button"
									class="btn btn-sm btn-light dropdown-toggle"
									data-toggle="dropdown">Showing</button>
								<div class="dropdown-menu dropdown-menu-right">
									<a class="dropdown-item" href=""
										onclick="showNum();return false;">All</a> <a
										class="dropdown-item" href=""
										onclick="showNum1();return false;">5</a> <a
										class="dropdown-item" href=""
										onclick="showNum2();return false;">10</a> <a
										class="dropdown-item" href=""
										onclick="showNum3();return false;">20</a>
								</div>
							</div>
						</div>
					</div>
				</div>



				<div class="row px-xl-5" id="searchsa">
					<c:forEach var="item" items="${model.listResult}">
						<c:set var="path"
							value="/MotorbikeStore/uploads/images/product/${item.picName}" />
						<div class="col-lg-4 col-md-6 col-sm-6 pb-1">
							<div class="product-item bg-light mb-4">
								<div class="product-img position-relative overflow-hidden">
									<img class="img-fluid w-100" style="height: 400px"
										src="/MotorbikeStore/uploads/images/product/${item.picName}"
										alt="">
									<div class="product-action">

										<a 
											class="btn btn-outline-dark btn-square btnaddCart" id="${item.aMotorId}"
											href="" ><i
											class="fa fa-shopping-cart"></i></a> <a
											class="btn btn-outline-dark btn-square"
											href="addFavoriteProduct?id=${item.aMotorId}&idpage=1"><i
											class="far fa-heart"></i></a> <a
											class="btn btn-outline-dark btn-square"
											href="notaddshopDetail?id=${item.aMotorId}"><i
											class="fa fa-search"></i></a>
									</div>
								</div>
								<div class="text-center py-4">
									<a class="h6 text-decoration-none text-truncate">${item.motors_Name}</a>
									<div
										class="d-flex align-items-center justify-content-center mt-2">
										<h5>$ ${item.price}</h5>
										<h6 class="text-muted ml-2">
											<del>$ ${item.price}</del>
										</h6>
									</div>
									<div
										class="d-flex align-items-center justify-content-center mb-1">
										<small class="fa fa-star text-primary mr-1"></small> <small
											class="fa fa-star text-primary mr-1"></small> <small
											class="fa fa-star text-primary mr-1"></small> <small
											class="fa fa-star text-primary mr-1"></small> <small
											class="fa fa-star text-primary mr-1"></small> <small>(99)</small>
									</div>
								</div>
							</div>
						</div>


					</c:forEach>

				</div>


			</div>
		</div>
		<!-- Shop Product End -->
	</div>
</div>
<!-- Shop End -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script >
$(".btnaddCart").click(function(e) {
	
	var idpage = 1;
	var userId =
<%=session.getAttribute("userId")%>
;
	var aMotorId = $(this).attr("id");
	$.ajax({
		type : "POST",
		url : '${addCart}',
		data : {
			idpage : idpage,
			userId : userId,
			aMotorId : aMotorId
		},
		success : function(data) {
			window.location.href = "${login}";
		},
		error : function(result) {
			alert('error');

		}
	});
	
	

});



</script>




<script>
	function addCart() {
		var idpage = 1;
		var userId =
<%=session.getAttribute("userId")%>
	;
		var aMotorId = $(this).attr("id");
		$.ajax({
			type : "POST",
			url : '${addCart}',
			data : {
				idpage : idpage,
				userId : userId,
				aMotorId : aMotorId
			},
			success : function(data) {
				
				window.location.href = "${login}";
			},
			error : function(result) {
				alert('error');

			}
		});
	}
</script>
<script>
	function searchbyname(parameter) {
		var txt = parameter.value;
		$.ajax({
			type : "GET",
			url : '${search}',
			data : {
				txtSearch : txt
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
</script>

<script>
	function showNum() {
		var number = 0;
		var id = "number";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				numberMotor : number,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
	function showNum1() {
		var number = 5;
		var id = "number";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				numberMotor : number,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
	function showNum2() {
		var number = 10;
		var id = "number";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				numberMotor : number,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
	function showNum3() {
		var number = 20;
		var id = "number";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				numberMotor : number,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
</script>




<script>
	function branchChecked() {
		var id = "branch";
		var branch = "all";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				branch : branch,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
	function branchChecked1() {
		var branch = "honda";
		var id = "branch";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				branch : branch,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
	function branchChecked2() {
		var branch = "yamaha";
		var id = "branch";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				branch : branch,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
	function branchChecked3() {
		var branch = "suzuki";
		var id = "branch";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				branch : branch,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
	function branchChecked4() {
		var branch = "sym";
		var id = "branch";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				branch : branch,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
</script>






<script>
	function speedChecked() {
		var first = 0;
		var second = 0;
		var id = "speed";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				firstCC : first,
				secondCC : second,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
	function speedChecked1() {
		var first = 50;
		var second = 110;
		var id = "speed";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				firstCC : first,
				secondCC : second,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
	function speedChecked2() {
		var first = 110;
		var second = 125;
		var id = "speed";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				firstCC : first,
				secondCC : second,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
	function speedChecked3() {
		var first = 125;
		var second = 150;
		var id = "speed";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				firstCC : first,
				secondCC : second,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
</script>
<script>
	function colorChecked() {
		var color = "all";
		var id = "color";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				color : color,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
	function colorChecked1() {
		var color = "đỏ";
		var id = "color";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				color : color,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
	function colorChecked2() {
		var color = "xanh";
		var id = "color";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				color : color,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
	function colorChecked3() {
		var color = "đen";
		var id = "color";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				color : color,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
</script>
<script>
	function priceChecked() {
		var first = 0;
		var second = 0;
		var id = "price";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				firstPrice : first,
				secondPrice : second,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
	function priceChecked1() {
		var first = 100;
		var second = 500;
		var id = "price";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				firstPrice : first,
				secondPrice : second,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
	function priceChecked2() {
		var first = 500;
		var second = 1000;
		var id = "price";
		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				firstPrice : first,
				secondPrice : second,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
	function priceChecked3() {
		var first = 1000;
		var second = 3000;
		var id = "price";

		$.ajax({
			type : "GET",
			url : '${filterMix}',
			data : {
				firstPrice : first,
				secondPrice : second,
				id : id
			},
			success : function(data) {
				var row = document.getElementById("searchsa");
				row.innerHTML = data;
				function addCart() {
					var idpage = 1;
					var userId =
			<%=session.getAttribute("userId")%>
				;
					var aMotorId = $(this).attr("id");
					$.ajax({
						type : "POST",
						url : '${addCart}',
						data : {
							idpage : idpage,
							userId : userId,
							aMotorId : aMotorId
						},
						success : function(data) {
							
							window.location.href = "${login}";
						},
						error : function(result) {
							alert('error');

						}
					});
				}
			},
			error : function(result) {
				alert('error');

			}
		});
	}
</script>
</html>