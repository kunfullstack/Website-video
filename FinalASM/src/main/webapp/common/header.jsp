<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
<c:url var="logo" value="/templates/user/img/logoKun.PNG" />	
<nav class="sticky-top navbar navbar-expand-lg navbar-light bg-dark">
	<div class="container">
		<a class="navbar-brand" href="index"><img
			style="width: 70px" src="${logo}" alt="" /></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			
			<ul class="navbar-nav ml-auto mb-2 mb-lg-0">
			
			
		<c:choose>
			<c:when test="${not empty sessionScope.currentUser}"> 
					<li class="nav-item active"><a class="nav-link text-white"
					href="index">Home<span
						class="sr-only">(current)</span></a></li>
						
				<li class="nav-item active"><a class="nav-link text-white"
					href="favorites">My favorites</a></li>
					
				<li class="nav-item active"><a class="nav-link text-white"
					href="history">History</a></li>

						
				<li class="nav-item dropdown"><a class="nav-link dropdown-toggle text-white" href="#"
				id="navbarDropdown" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> Welcome, ${sessionScope.currentUser.username}</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						
						<a class="dropdown-item" href="admin">Admin</a>
						<div class="dropdown-divider"></div>
						<a data-toggle="modal" data-target="#changePassModal" class="dropdown-item">Change Password</a>
						<div class="dropdown-divider"></div>						
						<a class="dropdown-item" href="logout">Logout</a>
						<div class="dropdown-divider"></div>

					</div>
				</li>
									
		 	</c:when>
			<c:otherwise> 
				<li class="nav-item dropdown"><a class="nav-link dropdown-toggle text-white" href=""
				id="navbarDropdown" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> Account </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="login">Login</a> 
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="register">Register</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="forgotpass">Fogot Password</a>
						<div class="dropdown-divider"></div>
					</div>
				</li>
			</c:otherwise>
		</c:choose> 
			</ul>
		</div>
	</div>
</nav>
<div id="carouselExampleIndicators" class="carousel slide"
	data-ride="carousel">
	<ol class="carousel-indicators">
		<li data-target="#carouselExampleIndicators" data-slide-to="0"
			class="active"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	</ol>
	<div class="carousel-inner" style="height: 400px">
		<div class="carousel-item active">
			<img class="d-block w-100"
				src="https://images.unsplash.com/photo-1593437783747-66ed2e10a9af?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1469&q=80"
				alt="First slide" />
		</div>
		<div class="carousel-item">
			<img class="d-block w-100"
				src="https://images.unsplash.com/photo-1481328101413-1eef25cc76c0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80"
				alt="Second slide" />
		</div>
		<div class="carousel-item">
			<img class="d-block w-100"
				src="https://images.unsplash.com/photo-1670349148055-e11a0b3be242?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwxMXx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60"
				alt="Third slide" />
		</div>
	</div>
	<a class="carousel-control-prev" href="#carouselExampleIndicators"
		role="button" data-slide="prev"> <span
		class="carousel-control-prev-icon" aria-hidden="true"></span> <span
		class="sr-only">Previous</span>
	</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
		role="button" data-slide="next"> <span
		class="carousel-control-next-icon" aria-hidden="true"></span> <span
		class="sr-only">Next</span>
	</a>
</div>







