<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Forgot Password</title>
<link
	href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'
	rel='stylesheet'>
	<!-- Font Icon -->
	<link href="<c:url value='template/web/forgotPasswordPage/css/forgotPasswordPage.css' />"
		rel="stylesheet" type="text/css" media="all" />
	<link
	href="<c:url value='template/web/forgotPasswordPage/img/motorcycle.png' />"
	rel="shortcut icon" type="image/png" />
<script type='text/javascript'
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>

</head>

<body  class="main">
	<input type = "hidden" id="status" value = "<%=request.getAttribute("status") %>">

	<div class="container padding-bottom-3x mb-2 mt-5">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10">
				<div class="forgot">
					<h2>Forgot your password?</h2>
					<p>Change your password in three easy steps. This will help you
						to secure your password!</p>
					<ol class="list-unstyled">
						<li><span class="text-primary text-medium">1. </span>Enter
							your email address below.</li>
						<li><span class="text-primary text-medium">2. </span>Our
							system will send you an OTP to your email</li>
						<li><span class="text-primary text-medium">3. </span>Enter the OTP on the 
						next page</li>
					</ol>
				</div>
				<form class="card mt-4" action="forgot" method="post">
					<div class="card-body">
						<div class="form-group">
							<label for="email-for-pass">Enter your email address</label> <input
								class="form-control" type="text" name="email" id="email-for-pass" required><small
								class="form-text text-muted">Enter the registered email address . Then we'll
								email a OTP to this address.</small>
						</div>
					</div>
					<div class="card-footer">
						<button class="btn btn-success" type="submit">Get New
							Password </button>
						<button class="btn btn-danger" onclick="window.location.href='/MotorbikeStore/login'" >Back to
							Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type='text/javascript'
		src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>

	

		<!-- JS -->
	<script src="template/web/registPage/vendor/jquery/jquery.min.js"></script>
	<script src="template/web/registPage/js/main.js"></script>
	<script src = "https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stysheet" href="alert/dist/sweetalert.css">
	<script type="text/javascript">
	
	var status = document.getElementById("status").value;

	if(status == "success")
	{
		swal("Congratulations","OTP Is Sent To Your Email","success");
	}
	if(status == "0")
	{
		swal("Information","Email Does Not Exist","error");
	}
	if(status == "-1")
	{
		swal("Information","OTP Have Not Been Sent","error");
	}


	</script>
	
</body>
</html>