<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<meta name="Description" content="Enter your description here" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
	
 <link rel="stylesheet" href="<c:url value='/templates/user/css/style.css'/>">


<title>My Favorites</title>
</head>
<body class=" bg-dark">

	<%@include file="/common/header.jsp"%>
	
	
	<div class="container mt-5">
		<section class="content">
			<h3 class="text-info">List Favorites</h3>

			<div class="row my-5 tm-mb-90 tm-gallery">
 
				<c:forEach items="${videos}" var="video">

					<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
						<c:url var="clip" value="/video?action=watch&id=${video.href}" />
						
						<figure class="effect-ming tm-video-item">
								<a href="${clip}"><img src="<c:url value='${video.poster}'/>" alt="" class="img-fluid"></a>
						<figcaption class="d-flex align-items-center">
							
							<a href="${clip}" style="color: red">${video.title}</a>
						</figcaption>
					
						</figure>
						
						
<!-- 						<iframe 
							src="https://www.youtube.com/embed/NRzWPX0h5s4"
							title="YouTube video player" frameborder="0"
							allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
							allowfullscreen></iframe> -->
							
						<div class="d-flex justify-content-between tm-text-gray">
							<span class="tm-text-gray-light" style="color: white">${video.view} views</span> 
							
							<span class="tm-text-gray-light" style="color: white">${video.share} shares</span>
						</div>

					</div>
				</c:forEach>


			</div>




		</section>
	</div>

	<!-- Footer -->

	<%@include file="/common/footer.jsp"%>
</body>
</html>
