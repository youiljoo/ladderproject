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
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/productList.css">

</head>


<!--===============================
=            Hero Area            =
================================-->

<section class="hero-area bg-1 text-center overly::before" style="background-color:white">	
	<!-- Container Start -->
	<div class="container">
		<h2 style="text-align:left; margin-left:-60px; margin-top:-100px;">마우스</h2>
		<div class="row">
			
				<!-- Header Content -->
<div class="tab_menu" style="
    font-size: 12px;
    font-family: 'spoqa M';
    position: relative;
    width: 100%;
    height: 56px;
    float: left;
    background: #f7f7f7;
    margin-left:-60px;"
>

	<ul>
		<li class="tab_on" style="float: left; line-height: 15px; box-sizing: border-box;">
			<a href="javascript:void(0);" class="tab_M" style="padding: 20px 25px 0 25px; box-sizing: border-box; display: inline-block; font-size: 15px; line-height: 15px; letter-spacing: -1px;" onclick="setProductListVal"('PreOrder','recommend','M');">인기상품순</a><i></i>
		</li>
		<li class="tab_on" style="float: left; line-height: 15px; box-sizing: border-box;">
			<a href="javascript:void(0);" class="tab_M" style="padding: 20px 25px 0 25px; box-sizing: border-box; display: inline-block; font-size: 15px; line-height: 15px; letter-spacing: -1px;" onclick="setProductListVal"('PreOrder','recommend','M');">낮은가격순</a><i></i>
		</li>
		<li class="tab_on" style="float: left; line-height: 15px; box-sizing: border-box;">
			<a href="javascript:void(0);" class="tab_M" style="padding: 20px 25px 0 25px; box-sizing: border-box; display: inline-block; font-size: 15px; line-height: 15px; letter-spacing: -1px;" onclick="setProductListVal"('PreOrder','recommend','M');">높은가격순</a><i></i>
		</li>
		<li class="tab_on" style="float: left; line-height: 15px; box-sizing: border-box;">
			<a href="javascript:void(0);" class="tab_M" style="padding: 20px 25px 0 25px; box-sizing: border-box; display: inline-block; font-size: 15px; line-height: 15px; letter-spacing: -1px;" onclick="setProductListVal"('PreOrder','recommend','M');">등록순</a><i></i>
		</li>
		<li class="tab_on" style="float: left; line-height: 15px; box-sizing: border-box;">
			<a href="javascript:void(0);" class="tab_M" style="padding: 20px 25px 0 25px; box-sizing: border-box; display: inline-block; font-size: 15px; line-height: 15px; letter-spacing: -1px;" onclick="setProductListVal"('PreOrder','recommend','M');">구매후기순</a><i></i>
		</li>
		
		
	</ul>
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

<section class="popular-deals section bg-gray"
style="padding-top: 40px; padding-bottom: 20px;">
	<div class="container">
		<div>
		
			<div class="col-12">	
				<div class="row">

					<c:forEach var="item" items="${productList }">

						<div class="category-block" style="padding-left: 10px; padding-right: 10px;">
							<a href="${contextPath}/prodetail.do?productNum=${item.productNum}">				
 								 <img width="235" height="220" src="${contextPath}/thumbnails.do?category=${item.category}&productNum=${item.productNum }&fileName=${item.originFileName}">
  							</a>
  					<div class="card-body-list">
    					<h5 style="text-align:center">${item.productName }</h5>
    					<h5 style="text-align:center">${item.productPrice} 원</h5>
  					</div>
				</div>

    	</c:forEach>   
									
</div>
<div class="productList_page">
										<ul class="paging">
											<c:if test="${paging.prev }">
												<span><a href='<c:url value="/searchlist.do?page=${paging.startPage-1 }"/>'>이전</a></span>
											</c:if>
											<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="num">
												<span><a href='<c:url value="/searchlist.do?page=${num }" />'>${num }</a></span>
											</c:forEach>
											<c:if test="${paging.next && paging.endPage>0 }">
												<span><a href='<c:url value="/searchlist.do?page=${paging.endPage+1 }"/>'>다음</a></span>
											</c:if>
										</ul>
										</div>
</div>
</div>	
</div>	
</section>
</body>

</html>



