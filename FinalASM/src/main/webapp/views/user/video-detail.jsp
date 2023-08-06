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

<link rel="stylesheet"
	href="<c:url value='/templates/user/css/style.css'/>">


<title>${video.title}</title>
</head>
<body class="bg-dark">

	<%@include file="/common/header.jsp"%>


	<div class="container mt-5">
		<section class="content">
			<h3 class="text-info">${video.title}</h3>
			<div class="row">
				<div class="col-sm-9">
					<iframe width="800" height="450"
						src="https://www.youtube.com/embed/rY_KaL0wPGU"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
						allowfullscreen></iframe>
				</div>

				<div class="col-sm-3 bg-light">
					<div class="text-center d-flex flex-column py-5">

						<c:if test="${not empty sessionScope.currentUser}">
							<c:url var="like" value="/video?action=like&id=${video.href}" />

							<div class="text-center mb-5">

								<%-- <a href="${like}" class="btn btn-primary tm-btn-big"> --%>
								<button id="likeOrUnlikeBtn" class="btn btn-primary tm-btn-big">
									<c:choose>
										<c:when test="${flagLikedBtn == true}">UnLike</c:when>
										<c:otherwise>Like</c:otherwise>
									</c:choose>

								</button>

							</div>
							<div class="text-center mb-5">
								<a href="#" class="btn btn-primary tm-btn-big">Share</a>
							</div>
						</c:if>

						<!--  ẩn thằng href , mục đích: truyền cho script -->
						<input id="videoIdHdn" type="hidden" value="${video.href}">

						<h4 class="">${video.title}</h4>

						<p class="mb-4 text-center"
							style="font-size: medium; font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif; text-align: center;">

							${video.description}</p>
					</div>
				</div>
			</div>
		</section>
	</div>


	<!-- Footer -->

	<%@include file="/common/footer.jsp"%>
</body>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$('#likeOrUnlikeBtn').click(function() {
		var videoId = $('#videoIdHdn').val();
		$.ajax({
			url : 'video?action=like&id=' + videoId
		}).then(function(data) {
			var text = $('#likeOrUnlikeBtn').text();
			console.log(videoId)
			if (text.indexOf('Like') != -1) {
				$('#likeOrUnlikeBtn').text('Unlike');
			} else {
				$('#likeOrUnlikeBtn').text('Like');
			}
		}).fail(function(error) {
			alert('Loi~ roi` ban iu oi!');
			console.log(error)
		});
	});
</script>
</html>
