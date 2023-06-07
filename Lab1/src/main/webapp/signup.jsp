<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="include/head.jsp"%>
</head>
<body>
	<!-- header session -->
	<%@include file="include/header.jsp"%>
	<div class="container" style="margin-top: 30px">
		<div class="row">
			<div class="col-lg-10 col-xl-6 mx-auto">
				<div
					class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden">
					<div class="card-img-left d-none d-md-flex">
						<!-- Background image for card set in CSS! -->
					</div>
					<div class="card-body p-4 p-sm-3">
						<h5 class="card-title text-center mb-5 fw-light fs-5"
							style="margin-top: 30px">Register</h5>
						<form name="signup" action="./SignUpServlet" onsubmit="validateForm(event)"
							method="post">
							<div class="form-floating mb-3">
								<label for="floatingInputUsername">Username<span
									class="text-danger"> *</span></label> <input type="text"
									class="form-control" name="username" id="username"
									placeholder="Enter your username">
								<div style="color: red" id="error-message2"></div>
							</div>

							<div class="form-floating mb-3">
								<label for="floatingInputEmail">Email address<span
									class="text-danger"> *</span></label> <input type="email"
									class="form-control" name="email" id="email"
									placeholder="name@example.com">
								<div style="color: red" id="error-message3"></div>
							</div>
							<div class="form-floating mb-3">
								<label for="floatingPassword">Password<span
									class="text-danger"> *</span></label> <input type="password"
									class="form-control" name="password" id="password"
									placeholder="Password">
								<div style="color: red" id="error-message4"></div>
							</div>
							<p>
								Have an account? <a class="mt-2" href="login.jsp"> Sign In</a>
							</p>
							<div class="d-grid mb-2 text-center">
								<button class="btn btn-primary  " type="submit">Register</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- footer session -->
	<%@include file="include/footer.jsp"%>
</body>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
function validateForm(event) {
	  event.preventDefault();

	  var username = document.forms["signup"]["username"].value;
	  var email = document.forms["signup"]["email"].value;
	  var password = document.forms["signup"]["password"].value;
	  
	  // Get the error message container
	  var errorMessage2 = document.getElementById("error-message2");
	  var errorMessage3 = document.getElementById("error-message3");
	  var errorMessage4 = document.getElementById("error-message4");

	  // Reset the error message container
	  errorMessage2.innerHTML = "";
	  errorMessage3.innerHTML = "";
	  errorMessage4.innerHTML = "";
	  
	  // Check each field for errors
	  if (username == "" || username.length <6) {
	    errorMessage2.innerHTML += "Username must be at least 6 character<br>";
	  }
	  if (email == "") {
	    errorMessage3.innerHTML += "Email must be filled out<br>";
	  }
	  if (password == "") {
	    errorMessage4.innerHTML += "Password must be filled out<br>";
	  }
	  
	  // If there are errors, do not submit the form
	  if (errorMessage2.innerHTML !== "") {
	    return false;
	  }
	  if (errorMessage3.innerHTML !== "") {
	    return false;
	  }
	  if (errorMessage4.innerHTML !== "") {
	    return false;
	  }
	  
	  // If all fields are valid, submit the form
	  document.forms["signup"].submit();
	}
</script>
</html>