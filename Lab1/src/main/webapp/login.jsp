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
	<section style="background-color: #eee;" >
		<div class="container py-5 h-100" >
			<div class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-9">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-6 order-2 order-lg-1">

									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4" >Sign in</p>

									<form name="login" class="mx-1 mx-md-4" method="post" action="./LoginServlet" onsubmit="validateForm(event)">
										<div class="d-flex flex-row align-items-center mb-4">
											<div class=" flex-fill mb-0">
												<label class="form-label" for="username">Username</label>
												<input name="username" type="text" name="username" id="username" class="form-control" placeholder="Enter your username" />
												<div style="color: red" id="errorMessage"></div>
											</div>
										</div>
										<div class="d-flex flex-row align-items-center mb-4">
											<div class="form-outline flex-fill mb-0">
												<label class="form-label" for="pass">Password</label>
												<input name="password" type="password" id="password" id="password" class="form-control" placeholder="Enter your password" />
												<div style="color: red" id="errorMessage2"></div> 
											</div>
										</div>
										
										<div class="form-check mb-4 mr-sm-2">
										    <input
										      class="form-check-input"
										      type="checkbox"
										      id="inlineFormCheck"
										    />
										    <label class="form-check-label" for="inlineFormCheck">
										      Remember me
										    </label>
										</div>
										<div class="flex-row mb-3 text-center">
											<button type="submit" class="btn btn-primary">Login</button>
										</div>
										<p>	Don't have an Account ? <a href="signup.jsp">Sign up here</a> </p>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@include file="include/footer.jsp"%>
</body>
<script>
function validateForm(event) {
	  event.preventDefault();

	  var username = document.forms["login"]["username"].value;
	  var password = document.forms["login"]["password"].value;
	  
	  // Get the error message container
	  var errorMessage = document.getElementById("errorMessage");
	  var errorMessage2 = document.getElementById("errorMessage2");


	  // Reset the error message container
	  errorMessage.innerHTML = "";
	  errorMessage2.innerHTML = "";
	  
	  // Check each field for errors
	  if (username == "") {
	    errorMessage.innerHTML += "Username must be filled out<br>";
	  }
	  if (password == "") {
	    errorMessage2.innerHTML += "Password must be filled out<br>";
	  }
	  
	  // If there are errors, do not submit the form
	  if (errorMessage.innerHTML !== "") {
	    return false;
	  }
	  if (errorMessage2.innerHTML !== "") {
	    return false;
	  }
	  
	  // If all fields are valid, submit the form
	  document.forms["login"].submit();
	}
</script>
</html>