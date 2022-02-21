<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<%
  request.setCharacterEncoding("utf-8");
%>

<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<c:set var="as" value="${asMap.as}" />
<c:set var="imageFileList" value="${asMap.imageFileList}" />

<!DOCTYPE html>
<html>
<head>

 
  <!-- CUSTOM CSS -->
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
	 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/board.css">
	 
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> 
<script type="text/javascript">



function deleteConfirm(){

if(!confirm("삭제 하시겠습니까?")){
return false;
}else{
alert("삭제하였습니다.")
location.href="${contextPath}/board/as/delete?as_no=${as.as_no}";
}
}

</script> 






  
</head>
<!--===============================
=            Hero Area            =
================================-->

<section class="hero-area bg-1 text-center overly::before" style="background-color:white">	
	<!-- Container Start -->
	<div class="container" style="height:200px;">
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









<section class="section">
	<!-- Container Start -->
	<div class="container">
		<div class="row" id="writing">
			<h2>A/S 문의</h2>
			<div class="col-12">
				<!-- Section title -->
				
			
		</div>
	</div>
	</div>
	<!-- Container End -->
</section>

<section class="section">
	<div class="container">
		
	<form name="frm" method="post" enctype="multipart/form-data">
		<div class="cbody">
				
						<table class="n-table table-row">
							<tbody>
								<tr class="n-same-row">
									<th scope="row">번호</th>
									<td>
                                      <input type="text" class="m-input" name="as_no" value="${as.as_no}" readonly>
									</td>
								</tr>
							
								<tr class="n-same-row">
									<th scope="row">문의유형</th>
									<td>
                                      <input type="text" class="m-input" name="as_type" value="${as.as_type}" readonly>
									</td>
								</tr>
								
								<tr>
									<th scope="row">작성자</th>
									<td>
										<input type="text" class="m-input" name="user_id" value="${as.user_id}" readonly>
									</td>
								</tr>
								<tr>
									<th scope="row">휴대전화</th>
									<td>
										<input type="text" class="m-input" name="user_phone" value="${as.user_phone}" readonly>
									</td>
								</tr>
								<tr class="n-same-row">
									<th scope="row">이메일</th>
									<td>
										<input type="text" class="m-input" name="user_email" value="${as.user_email}" readonly>
									</td>
								</tr>
								<tr>
									<th scope="row">제목</th>
									<td>
										<input type="text" class="n-input" name="as_name" value="${as.as_name}" readonly>
									</td>
								</tr>
								<tr class="n-same-row">
									<th scope="row">문의내용</th>
									<td>
										<textarea name="as_content" cols="100" rows="20" class="n-input" readonly>${as.as_content}</textarea>
									</td>
								</tr>
								
									<tr class="n-same-row">
									<th scope="row">사진 첨부
									<img src="${contextPath}/resources/images/camera.png" id="preview">
									</th>
									
									<td>
									
									<div id="image_container">
									<c:forEach var="item" items="${imageFileList}" varStatus="status">				
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이미지${status.count}																
										<input type="hidden" name="originalFileName" value="${item.imageFileName}" />
										<img src="${contextPath}/download.do?as_no=${as.as_no}&imageFileName=${item.imageFileName}" />
									</c:forEach>		
									</div>
									
								</td>
									
								</tr>
								
							</tbody>
						</table>
				
		</div>
		
		<div class="cfooter">
		
		<a href="javascript:window.history.back();"><input type="button" class="btn btn-primary pull-right" value="뒤로가기"></a>
		<c:if test="${memberInfo.user_id == list.user_id }"> 
		<a href="${contextPath}/board/as/update?as_no=${as.as_no}" class="btn btn-success">수정</a>
		<!--<input type="submit" class="btn btn-success" value="수정"> -->
		<a href="javascript:void(0);" class="btn btn-danger" onclick="deleteConfirm();">삭제</a>
		</c:if>
		</div>
	</form>
		
	</div>
</section>

<!--============================
=            Footer            =
=============================-->


</body>

</html>



