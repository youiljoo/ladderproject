<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"    
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>



  <!-- CUSTOM CSS -->
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/board.css">

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]){
			var reader = new FileReader();
			reader.onload=function (e){
				$('#preview').attr('src',e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	
	var cnt=1;
	function fn_addFile(){
		$("#d_file").append("<br>"+"<input type='file' name='file"+cnt+"' />");
		cnt++;
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

<section class=" section">
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
		
		<form method="post" action="aswriting" accept-charset="utf-8" enctype="multipart/form-data">
		<div class="cbody">
			
						<table class="n-table table-row">
							<tbody>
								<tr class="n-same-row">
									<th scope="row">문의유형</th>
									<td>
                                       <div class="bg-select">
  											<select name="as_type" id="as_type">
  												<option value>문의유형 선택</option>
  												<option value="A/S">A/S</option>
  												<option value="방문 신청">방문 신청</option>
  												<option value="교환">교환</option>
  												<option value="기능/작동 오류">기능/작동 오류</option>
  											</select>
										</div>

									</td>
								</tr>
								
								<tr>
									<th scope="row">작성자</th>
									<td>
										<input type="text" class="as-input" name="user_id" value="${memberInfo.user_id}" readonly>
									</td>
								</tr>
								<tr>
									<th scope="row">휴대전화</th>
									<td>
										<input type="text" class="as-input" name="user_phone" value="${memberInfo.user_phone }" readonly>
									</td>
								</tr>
								<tr class="n-same-row">
									<th scope="row">이메일</th>
									<td>
										<input type="text" class="as-input" name="user_email" value="${memberInfo.user_email }" readonly>
									</td>
								</tr>
								<tr>
									<th scope="row">제목</th>
									<td>
										<input type="text" class="as-input2" name="as_name" value="" placeholder="제목을 입력해주세요.">
									</td>
								</tr>
								<tr class="n-same-row">
									<th scope="row">문의내용</th>
									<td>
										<textarea name="as_content" cols="100" rows="20" class="as-input2" placeholder="내용을 입력해주세요."></textarea>
									</td>
								</tr>
								<tr class="n-same-row">
									<th scope="row">사진 첨부
									<img src="${contextPath}/resources/images/camera.png" id="preview">
									<input type="file" name="imageFileName" onchange="readURL(this);" />
									</th>
									
									<td>
									
									<div id="d_file">
									<input type="button" class="btn btn-primary pull-right" value="파일 추가" onClick="fn_addFile()" />									
									</div>
									
								</td>
									
								</tr>
								



							</tbody>
						</table>
			
 	
		
		</div>
		
		<div class="cfooter">
		<a href="javascript:window.history.back();"><input type="button" class="btn btn-primary pull-right" value="뒤로가기"></a>
		<a href="#"><input type="submit" class="btn btn-primary pull-right" value="등록하기"></a>
		</div>
	</form>

		
	
	</div>
</section>

<!--============================
=            Footer            =
=============================-->



</body>

</html>



