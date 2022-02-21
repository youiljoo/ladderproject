<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"    
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>

 
  <!-- CUSTOM CSS -->
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">


<script>
	var result = '${result}';
	if(result === 'removeTrue') {
		alert('탈퇴가 완료되었습니다');
	} 

</script>

<script>
	var True = '${True}';
	if(True === 'True') {
		alert('수정되었습니다. 다시 로그인 해주세요.');
	} 

</script>  


<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>



<!--===============================
=            Hero Area            =
================================-->


	<!-- Container Start -->

<div class="slider-container">
	<div class="image">
		<img src = "${contextPath}/resources/images/mainimage.jpg" style="width:1900px; height:700px; opacity:0.4"/>
		<div class="text">
			<h10>사다리컴</h10><br><br><br><br>
			<h11>전국으로 퍼져나가는 사다리컴 제품</h11><br><br><br><br>
			<h12>저희 사다리컴은 엄선된 제품으로 최고의 품질을 보장하며,</h12><br>
			<h12>사용자에게 불편함을 느끼지 않도록 항상 최선을 다하고 있습니다.</h12>
			
		</div>
		
	</div>
</div>	

	<!-- Container End -->


<!--===================================
=            Client Slider            =
====================================-->


<!--===========================================
=            Popular deals section            =
============================================-->

<section class="popular-deals section bg-gray"
style="padding-top: 40px; padding-bottom: 20px;">

	<div class="container">
	<div class="row" style="float:left">
		
			<div class="col-md-12" style="
    padding-right: 140px;
">

</div></div>
	
				
					<div class="slideshow-container">

<div class="slider-container">

  <div class="menu">
    <label for="slide-dot-1"></label>
    <label for="slide-dot-2"></label>
    <label for="slide-dot-3"></label>
  </div>
  
  <input id="slide-dot-1" type="radio" name="slides" checked>
    <div class="slide slide-1"></div>
  
  <input id="slide-dot-2" type="radio" name="slides">
    <div class="slide slide-2"></div>
  
  <input id="slide-dot-3" type="radio" name="slides">
    <div class="slide slide-3"></div>
</div>
	</div>




					</div>
				</div>
			</div>
			
			
		</div>
	</div>
</section>



<!--==========================================
=            All Category Section            =
===========================================-->

<section class=" section" style="
    padding-bottom: 10px;
">
	<!-- Container Start -->
	<div class="container">
			<div class= main22>
			<div class="col-12">
				<div class="section-title">
					<h2 style="text-align: center;">인기상품</h2>
					<p>가장 인기있는 상품을 만나보세요!</p>
				</div>
		

				<div>
							<div class="bestproductwrap">
							<c:forEach var="item" items="${goodsMap.popular_item}">
	   
		<div class="category-block" style="padding-left: 10px; padding-right: 10px;">
			<a href="${contextPath}/prodetail.do?productNum=${item.productNum }">
			<img class="link"  src="${contextPath}/resources/images/1px.gif"> 
			</a> 
				<img width="235" height="220" 
				     src="${contextPath}/thumbnails.do?category=${item.category}&productNum=${item.productNum}&fileName=${item.originFileName}">
			<div class="title">${item.productName}</div>
		</div>
  </c:forEach>
</div>
				
		</div>
	</div>
	</div>
	<div class= main22>
			<div class="col-12">
				<div class="section-title">
					<h2 style="text-align: center;">신상품</h2>
					<p>따끈따끈한 상품을 만나보세요!</p>
				</div>
		

				<div>
							<div class="bestproductwrap">
							<c:forEach var="item" items="${goodsMap.new_item}">
	   
		<div class="category-block" style="padding-left: 10px; padding-right: 10px;">
			<a href="${contextPath}/prodetail.do?productNum=${item.productNum }">
			<img class="link"  src="${contextPath}/resources/images/1px.gif"> 
			</a> 
				<img width="235" height="220" 
				     src="${contextPath}/thumbnails.do?category=${item.category}&productNum=${item.productNum}&fileName=${item.originFileName}">
			<div class="title">${item.productName}</div>
		</div>
  </c:forEach>
</div>
				
		</div>
	</div>
	</div> 
	</div>
	<!-- Container End -->
</section>

</html>



