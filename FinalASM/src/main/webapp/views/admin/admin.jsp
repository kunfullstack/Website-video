<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Server360 - Responsive Bootstrap 4 Admin Dashboard
	Template</title>
<!-- Favicon -->
<link rel="shortcut icon"
	href="<c:url value='/templates/admin/images/favicon.ico'/>">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<c:url value='/templates/admin/css/bootstrap.min.css'/>">
<!-- Typography CSS -->
<link rel="stylesheet"
	href="<c:url value='/templates/admin/css/typography.css'/>">
<!-- Style CSS -->
<link rel="stylesheet"
	href="<c:url value='/templates/admin/css/style.css'/>">
<!-- Responsive CSS -->
<link rel="stylesheet"
	href="<c:url value='/templates/admin/css/responsive.css'/>">
</head>
<body>
	<%@include file="/views/admin/headerAdmin.jsp"%>

	<!-- Page Content  -->
	<div id="content-page" class="content-page">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-12">
					<div class="iq-card">
						<div class="iq-card-header d-flex justify-content-between">
							<div class="iq-header-title">
								<h4 class="card-title">VIDEO</h4>
							</div>
						</div>
						<div class="iq-card-body">
							<div id="table" class="table-editable">
								<span class="table-add float-right mb-3 mr-2">
									<button class="btn btn-sm iq-bg-success">
										<i class="ri-add-fill"><span class="pl-1">Add New</span></i>
									</button>
								</span>

								<h6>Tổng Video</h6>
								<table
									class="table table-bordered table-responsive-md table-striped text-center">

									<thead>
										<tr>
											<th>Tilte</th>
											<th>Link</th>
											<th>Poster</th>
											<th>Views</th>
											<th>Shares</th>
											<th>Description</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${videoAll}" var="itemAll">
											<tr>
												<td>${itemAll.title}</td>
												<td><a href="video?action=watch&id=${itemAll.href}">${itemAll.href}</a></td>
												<td>${itemAll.poster}</td>
												<td>${itemAll.view}</td>
												<td>${itemAll.share}</td>
												<td>${itemAll.description}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<br>

								<h6>Lượt Like</h6>
								<table
									class="table table-bordered table-responsive-md table-striped text-center">

									<thead>
										<tr>
											<th>Tilte</th>
											<th>Link</th>
											<th>Total Like</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${videos}" var="item">
											<tr>
												<td>${item.title}</td>
												<td><a href="video?action=watch&id=${item.href}">${item.href}</a></td>
												<td>${item.totalLike}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<br>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- Wrapper END -->
	<!-- Footer -->
	<footer class="iq-footer">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-6">
					<ul class="list-inline mb-0">
						<li class="list-inline-item"><a href="privacy-policy.html">Privacy
								Policy</a></li>
						<li class="list-inline-item"><a href="terms-of-service.html">Terms
								of Use</a></li>
					</ul>
				</div>
				<div class="col-lg-6 text-right">
					Copyright 2023 <a href="https://www.facebook.com/kunNnN161203/">Phạm
						Thái</a>.
				</div>
			</div>
		</div>
	</footer>
	<!-- Footer END -->
	<!-- color-customizer -->
	<!-- color-customizer END -->
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="<c:url value='templates/admin/js/jquery.min.js'/>"></script>
	<script src="<c:url value='templates/admin/js/popper.min.js'/>"></script>
	<script src="<c:url value='templates/admin/js/bootstrap.min.js'/>"></script>
	<!-- Appear JavaScript -->
	<script src="<c:url value='templates/admin/js/jquery.appear.js'/>"></script>
	<!-- Countdown JavaScript -->
	<script src="<c:url value='templates/admin/js/countdown.min.js'/>"></script>
	<!-- Counterup JavaScript -->
	<script src="<c:url value='templates/admin/js/waypoints.min.js'/>"></script>
	<script
		src="<c:url value='templates/admin/js/jquery.counterup.min.js'/>"></script>
	<!-- Wow JavaScript -->
	<script src="<c:url value='templates/admin/js/wow.min.js'/>"></script>
	<!-- Apexcharts JavaScript -->
	<script src="<c:url value='templates/admin/js/apexcharts.js'/>"></script>
	<!-- Slick JavaScript -->
	<script src="<c:url value='templates/admin/js/slick.min.js'/>"></script>
	<!-- Select2 JavaScript -->
	<script src="<c:url value='templates/admin/js/select2.min.js'/>"></script>
	<!-- Owl Carousel JavaScript -->
	<script src="<c:url value='templates/admin/js/owl.carousel.min.js'/>"></script>
	<!-- Magnific Popup JavaScript -->
	<script
		src="<c:url value='templates/admin/js/jquery.magnific-popup.min.js'/>"></script>
	<!-- Smooth Scrollbar JavaScript -->
	<script src="<c:url value='templates/admin/js/smooth-scrollbar.js'/>"></script>
	<!-- lottie JavaScript -->
	<script src="<c:url value='templates/admin/js/lottie.js'/>"></script>
	<!-- am core JavaScript -->
	<script src="<c:url value='templates/admin/js/core.js'/>"></script>
	<!-- am charts JavaScript -->
	<script src="<c:url value='templates/admin/s/charts.js'/>"></script>
	<!-- am animated JavaScript -->
	<script src="<c:url value='templates/admin/js/animated.js'/>"></script>
	<!-- am kelly JavaScript -->
	<script src="<c:url value='templates/admin/js/kelly.js'/>"></script>
	<!-- am maps JavaScript -->
	<script src="<c:url value='templates/admin/js/maps.js'/>"></script>
	<!-- am worldLow JavaScript -->
	<script src="<c:url value='templates/admin/s/worldLow.js'/>"></script>
	<!-- Raphael-min JavaScript -->
	<script src="<c:url value='templates/admin/js/raphael-min.js'/>"></script>
	<!-- Morris JavaScript -->
	<script src="<c:url value='templates/admin/js/morris.js'/>"></script>
	<!-- Morris min JavaScript -->
	<script src="<c:url value='templates/admin/js/morris.min.js'/>"></script>
	<!-- Flatpicker Js -->
	<script src="<c:url value='templates/admin/js/flatpickr.js'/>"></script>
	<!-- Style Customizer -->
	<script src="<c:url value='templates/admin/js/style-customizer.js'/>"></script>
	<!-- Chart Custom JavaScript -->
	<script src="<c:url value='templates/admin/js/chart-custom.js'/>"></script>
	<!-- Custom JavaScript -->
	<script src="<c:url value='templates/admin/js/custom.js'/>"></script>
</body>
</html>
y
