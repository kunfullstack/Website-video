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


<title>Re-Password</title>
</head>
<body>

	<%@include file="/common/header.jsp"%>
<body class="align bg-dark">


	<form class="bg-light rounded-lg p-5 w-50 mx-auto mt-5" id="login-form">
	
		<h1>${message}</h1>
		<h1 class="text-center bg-info text-white p-2 rounded-lg mb-5">
			Reset Password</h1>
			
			 <div class="form-outline mb-4">
                <label class="form-label" >Email address</label>
              <input name="email" id="email" type="email" class="form-control" />
            </div>

		<!-- <button type="button" class="btn btn-primary btn-block mb-4">Sign in  </button> -->
		<button id="sendBtn" class="btn btn-primary btn-block mb-4" type="submit">Confirm</button>
			<h5 style="color: red" id="messageReturn"></h5>
		
		
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

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		 $('#sendBtn').click(function(){
			 $('#messageReturn').text('');
			var email = $('#email').val(); // lấy giá trị của thằng id=email
			console.log(email)
			var formData = {'email' : email}; // get parameter email ben usercontroller
			$.ajax({
				url: 'forgotpass',
				type: 'Post',
				data: formData
			}).then(function(data) {
				$('#messageReturn').text('Password has been reset, please check your email');
				setTimeout(function(){
					window.location.href = 'http://localhost:8080/FinalASM/index';
				}, 5*1000);
			}).fail(function(error){
				$('#messageReturn').text('Email không tồn tại!');
			});
		}); 
	</script> 
				
</html>
