<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  pageEncoding="utf-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="pro" value="${proMap.pro}" />
<c:set var="imageFileList" value="${proMap.imageFileList}" />


<!-- header -->
<!DOCTYPE html>
<html>
<head>
    
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mypage.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script type="text/javascript">



function deleteConfirm(){

if(!confirm("삭제 하시겠습니까?")){
return false;
}else{
alert("삭제하였습니다.")
location.href="${contextPath}/admin_prod_delete.do?category=${pro.category}&productNum=${pro.productNum}";
}
}

</script> 


<style>
	.div-1{
		padding : 25px;
		margin: 0 auto;
		display:block;
		text-align : center;
	}
	
</style>
</head>
<body>
     <!-- contents --> 
  <div id = "contents">
    <!-- 관리자 페이지 -->
 <section class="flex-center3">
 <div>
<div class="myP_left">
<ul class="my_gnb">
						<li class="depth1">
							<a class="depth1_b_m" href="${contextPath}/admin_main.do" >관리자 페이지</a>
								<ul>
									<li><a href="${contextPath}/admin_member.do">회원 관리</a></li>
									<li><a href="${contextPath}/admin_order.do">주문 관리</a></li>
									<li><a href="${contextPath}/admin_prod.do">상품 관리</a></li>
									<li><a href="${contextPath}/admin_review.do">후기 관리</a></li>
									<li><a href="${contextPath}/admin_board_main.do">게시판 관리</a></li>
								</ul>
						</li>
</ul>			
</div> 
        <main>
        <div class="title_wrap"><h2 class="tit_txt">관리자 페이지</h2></div> <hr>
        <form name="frm" method="post">
            <div class="order_list21">
            	
						<div class="title_wrap">
							<h2 class="tit_txt" style="text-align:center">상품 상세 정보</h2>
						</div>
						<div class="listTable21">
							<table border="0" cellspacing="0" cellpadding="0" width="100%" class="myP_Ttype1">
								<colgroup>
									<col width="30%">
									<col width="70%">
								</colgroup>
								
								<thead>
									<tr><th>상품번호</th><td><c:out value="${pro.productNum}"/></td></tr>
									<tr><th>카테고리</th><td><c:out value="${pro.category}"/></td></tr>
									<tr><th>제품명</th><td><c:out value="${pro.productName}"/></td></tr>
									<tr><th>제조사</th><td><c:out value="${pro.company}"/></td></tr>
									<tr><th>재고수량</th><td><c:out value="${pro.productStock}"/></td></tr>
									<tr><th>상세정보</th><td><c:out value="${pro.productInfo}"/></td></tr>
									<tr><th>상품등록일</th><td><c:out value="${pro.productDate}"/></td></tr>
									<tr>
									<th>상품 이미지</th>
									<td>
									<div id="image_container">
									<c:forEach var="item" items="${imageFileList}" varStatus="status">				
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이미지${status.count}																
										<input type="hidden" name="fileName" value="${item.fileName}" />
									
										<img src="${contextPath}/thumbnails.do?productNum=${pro.productNum}&category=${pro.category}&fileName=${item.fileName}" />
										
									</c:forEach>
									<p>이미지1만 메인 이미지이고 나머지는 전부 상세 이미지 입니다.</p>								
									</div>
									</td>
									</tr>
								
									</thead>
									
															
							</table>							
						</div><br>									
						<div class="div-1">
						<button type="button" class="btn btn-outline-dark" onclick="location='admin_prod.do'">돌아가기</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-outline-dark" onclick="location='admin_prod_update.do?productNum=${pro.productNum}'">수정하기</button>
							<a href="javascript:void(0);" class="btn btn-danger" onclick="deleteConfirm();">삭제</a>
						</div>
							
					</div>
						
			</form>	
        </main>
</div>
</section>
    </div>
 
</body>
</html>

 