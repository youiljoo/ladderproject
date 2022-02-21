<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
  request.setCharacterEncoding("utf-8");
%>

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
			<h2>상담문의 작성</h2>
			<div class="col-12">
				<!-- Section title -->
				
			
		</div>
	</div>
	</div>
	<!-- Container End -->
</section>

<section class="section">
	<div class="container">
		
		<form method="post" action="consultwriting" accept-charset="utf-8">
		<div class="cbody">
				
						<table class="n-table table-row">
							<tbody>
								
								<tr class="n-same-row">
									<th scope="row">문의유형</th>
									<td>
                                       <div class="form-check">
  											<input class="form-check-input1" type="radio" name="c_type" id="flexRadioDefault1" value="전화 상담">
  												<label class="form-check-label" for="flexRadioDefault1">
    													<p>전화 상담</p>
  															</label>
  												<input class="form-check-input2" type="radio" name="c_type" id="flexRadioDefault2" value="카카오톡 상담" checked>
  														<label class="form-check-label" for="flexRadioDefault2">
   																<p>카카오톡 상담</p>
  														</label>
										</div>

									</td>
								</tr>
								
								<tr>
									<th scope="row">작성자</th>
									<td>
										<input type="text" class="m-input" name="user_id" value="${memberInfo.user_id}" readonly>
									</td>
								</tr>
								<tr>
									<th scope="row">휴대전화</th>
									<td>
										<input type="text" class="m-input" name="user_phone" value="${memberInfo.user_phone}" readonly>
									</td>
								</tr>
								<tr class="n-same-row">
									<th scope="row">이메일</th>
									<td>
										<input type="text" class="m-input" name="user_email" value="${memberInfo.user_email}" readonly>
									</td>
								</tr>
								<tr>
									<th scope="row">제목</th>
									<td>
										<input type="text" class="n-input" name="c_name" value="" placeholder="제목을 입력해주세요.">
									</td>
								</tr>
								<tr class="n-same-row">
									<th scope="row">문의내용</th>
									<td>
										<textarea name="c_content" cols="100" rows="20" class="n-input" placeholder="내용을 입력해주세요."></textarea>
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



