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


<title>KUNTUBE</title>
</head>
<body>

	<%@include file="/common/header.jsp"%>
	
	
	<div class="container mt-5">
		<section class="content">
			<h3 class="text-info">List Video</h3>

			<div class="row justify-content-md-center my-5">

				<c:forEach items="${videos}" var="video">

					<div class="col-xl-5 col-lg-5 col-md-6 col-sm-6 col-12 mb-5">
					
						<c:url var="clip" value="/video?action=watch&id=${video.href}" />
						
						<figure class="effect-ming tm-video-item">
							<a href="${clip}"><img src="<c:url value='${video.poster}'/>" alt="" class="img-fluid"></a>
						<figcaption class="">

							<a href="${clip}" class="text-decoration-none text-dark font-semibold">${video.title}</a>
						</figcaption>
						</figure>
						
						<div class="d-flex justify-content-between tm-text-gray">
							<span class="tm-text-gray-light">${video.view} views</span> <span>${video.share}
								shares</span>
						</div>
					</div>
				</c:forEach>
			</div>

	<nav aria-label="Page navigation example">
  		<ul class="pagination justify-content-center">
    		<li class="page-item">
    		
    	
    	
    		
      		<c:if test="${currentPage == 1}">
      				<a href="#" class="btn btn-primary tm-btn-prev mb-2 disabled">Previous </a>
      		</c:if>
      		
      		<c:if test="${currentPage > 1}">
      		<a href="#index?page=${currentPage -1}" class="btn btn-primary tm-btn-prev mb 2">Previous </a>
      		</c:if>
      		
      			<c:forEach varStatus="i" begin ="1" end="${maxPage}">
    			<li class="page-item">
    			<a class="page-link" href="index?page=${i.index}">${i.index}</a>
    			</li>
    			</c:forEach>
      		
      			<c:if test="${currentPage == maxPage}">
      				<a href="#" class="btn btn-primary tm-btn-prev mb-2 disabled">Next</a>
      		</c:if>
      		
      		<c:if test="${currentPage < maxPage}">
      		<a href="#index?page=${currentPage + 1}" class="btn btn-primary tm-btn-prev mb-2">Next </a>
      		</c:if>
      			
    		</li>
 	 	</ul>
	</nav>
		</section>
	</div>
				
				
	<!-- Footer -->

	<%@include file="/common/footer.jsp"%>
	
	
	<!-- Modal -->
<div class="modal fade" id="changePassModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Change Password</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
      <div class="form-group">
      <input type="password" name="oldpass"  id="oldpassW" class="form-control" placeholder="Mật khẩu cũ"/>
      </div>
      
      <div class="form-group">
      <input  type="password" name="newpass" id="newpassW" class="form-control" placeholder="Mật khẩu mới"/>
      </div>
        	<h5 style="color: red" id="messChangePass"></h5>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
        <button id="changePassBtn" type="button" class="btn btn-primary">Lưu</button>
      </div>
    </div>
  </div>
</div>
	
	<!-- xử lí ko reload trang khi change password bằng ajax -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		 $('#changePassBtn').click(function(){
			 $('#messChangePass').text('');
			var oldpass = $('#oldpassW').val();
			var newpass = $('#newpassW').val();
			console.log(oldpass)
			console.log(newpass)
			var formData = {'oldpass' : oldpass,
							'newpass' :	newpass
							}; //get parameter email ben usercontroller
			$.ajax({
				url: 'changepass',
				type: 'Post',
				data: formData
			}).then(function(data){
				$('#messChangePass').text('Đổi mật khẩu thành công ♥');
			}).fail(function(error){
				$('#messChangePass').text('mật khẩu cũ không đúng, vui lòng nhập lại');
			});
		}); 
	</script> 
	
</body>
</html>
