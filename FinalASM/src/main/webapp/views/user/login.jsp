<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
   <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
    />

<title>Login</title>
</head>
<body>

	<%@include file="/common/header.jsp"%>

<body class="align bg-dark">
	<form id="login-form" action="login" method = "post" class="bg-light rounded-lg p-5 w-50 mx-auto mt-5" >
	
		<h1 class="text-center bg-info text-white p-2 rounded-lg mb-5">
			LOGIN</h1>
		<div class="form-outline mb-4">
			<label class="form-label" for="form2Example1">User:</label> 
			<input name="username" type="text" id="form2Example1" class="form-control" placeholder="Username"/>
		</div>

		<div class="form-outline mb-4">
			<label class="form-label" for="form2Example2">Password</label> 
			<input name="password" type="password" id="form2Example2" class="form-control" placeholder="Password" />
		</div>
		<div class="row mb-4">
			<div class="col d-flex justify-content-center">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="form2Example31" checked /> <label
						class="form-check-label" for="form2Example31"> Remember me
					</label>
				</div>
			</div>

			<div class="col">
				<a href="forgotpass">Forgot password?</a>
			</div>
		</div>
		<!-- <button type="button" class="btn btn-primary btn-block mb-4">Sign in  </button> -->
		<button class="btn btn-primary btn-block mb-4" type="submit"> Login</button>
		<div class="text-center">
			<p>
				Not a member? <a href="register">Register</a>
			</p>
			<p>or sign up with:</p>
			<button type="button" class="btn btn-link btn-floating mx-1">
				<i class="fab fa-facebook-f"></i>
			</button>

			<button type="button" class="btn btn-link btn-floating mx-1">
				<i class="fab fa-google"></i>
			</button>	

			<button type="button" class="btn btn-link btn-floating mx-1">
				<i class="fab fa-twitter"></i>
			</button>

			<button type="button" class="btn btn-link btn-floating mx-1">
				<i class="fab fa-github"></i>
			</button>
		</div>
	</form>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>
	</body>

<%@include file="/common/footer.jsp"%>
</body>
</html>
