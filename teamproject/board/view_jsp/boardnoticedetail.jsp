<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"    
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>

  
  
  
  <!-- CUSTOM CSS -->
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/board.css">

 
</head>





<!--===============================
=            Hero Area            =
================================-->

<section class="hero-area bg-1 text-center overly::before" style="background-color:white">	
	<!-- Container Start -->
	<div class="container">
		<h2>고객센터 : 1688-5454 </h2>
		<p>고객센터 운영시간 : 평일(09:00~17:30) <br>토,일 공휴일 휴무</p>
		<div class="row">
		
			<div class="col-md-12">
				<img src="${contextPath}/resources/images/customer.jpg" id="call">
				<!-- Header Contetnt -->
				<div class="content-block">
					
					
					
				</div>
			</div>
		</div>
	</div>
	<!-- Container End -->
</section>

<!--===================================
=            Client Slider            =
====================================-->


<!--===========================================
=            Popular deals section            =
============================================-->

<section class="popular-deals section bg-gray">
	

<div class="board_list">
	<div class="board_title">
		<p class="title_name"></p>
		<h2>고객 지원 게시판</h2>		
	</div>
	<div class="container">
	<div class="category-block"> 
		<a href="${contextPath}/board/notice">
			공지사항
		</a>
	 	</div>
	 
	
	<div class="category-block"> 
		<a href="${contextPath}/board/consulting">
			상담문의
		</a>
	 	</div>

	
	<div class="category-block"> 
		<a href="${contextPath}/board/qna">
			&nbsp;&nbsp;&nbsp;&nbsp;Q&A
		</a>
	 	</div>
	 	
	
	<div class="category-block"> 
		<a href="${contextPath}/board/as">
			&nbsp;&nbsp;A/S문의
		</a>
	 	</div>
	 
	 </div>	
	

			
</div>


</section>




<!--==========================================
=            All Category Section            =
===========================================-->

<section class=" section">
	<!-- Container Start -->
	<div class="container">
		<div class="row">
			<span class="nt_dt" style="width:150px"><h2><c:out value="${list.n_type}" /></h2></a></span>
			<span class="nt_dt2" style="width:800px"><h2><c:out value="${list.n_name}"/></h2></span>
			<span class="nt_dt" style="width:150px"><h2><c:out value="${list.n_regdate}"/></h2></span>
		</div>
		
		
		

	</div>
	<!-- Container End -->
</section>

<section class="section" id="nt_detail">
	<div class="container">
		<td>
			<textarea name="n_content" id="n_content" cols="100" rows="20" readonly><c:out value="${list.n_content}"/></textarea>
		</td>
		
	 </div>
	 
	 <div class="container">
	
	 
	 <div class="cfooter">
			<a href="${contextPath}/board/notice"><input type="button" class="btn btn-primary pull-right" value="목록"></a>
		</div>
	 
	 </div>
	 
	 	
</section>

		

<!--============================
=            Footer            =
=============================-->
	

</body>

</html>



