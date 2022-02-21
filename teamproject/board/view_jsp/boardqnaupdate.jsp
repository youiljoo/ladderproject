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

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>

function _onSubmit(){

if(!confirm("수정하시겠습니까?")){
return false;
}else{
	alert("수정이 완료되었습니다.")
	location.href="${contextPath}/board/qna";
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
		
		<form role="form" method="post" action="${contextPath}/board/qna/update_action" onsubmit="return _onSubmit();" accept-charset="utf-8">
		<input type="hidden" id="q_no" name="q_no" value="${list.q_no}" />
		<div class="cbody">
				
						<table class="n-table table-row">
							<tbody>
								<tr class="n-same-row">
									<th scope="row">문의유형</th>
									<td>
                                       <div class="bg-select">
  											<select name="q_type" id="q_type">
  												<option>문의유형 선택</option>
  												<option value="교환">교환</option>
  												<option value="환불">환불</option>
  												<option value="취소(출하 전 취소)">취소(출하 전 취소)</option>
  												<option value="배송">배송</option>
  												<option value="주문/결제">주문/결제</option>
  												<option value="회원 관련">회원 관련</option>
  												<option value="신고">신고</option>
  												
  											</select>
										</div>

									</td>
								</tr>
								
								<tr>
									<th scope="row">작성자</th>
									<td>
										<input type="text" class="m-input" name="user_id" value="${list.user_id}" readonly>
									</td>
								</tr>
								<tr>
									<th scope="row">휴대전화</th>
									<td>
										<input type="text" class="m-input"  name="user_phone" value="${list.user_phone}" readonly>
									</td>
								</tr>
								<tr class="n-same-row">
									<th scope="row">이메일</th>
									<td>
										<input type="text" class="m-input"  name="user_email" value="${list.user_email}" readonly>
									</td>
								</tr>
								<tr>
									<th scope="row">제목</th>
									<td>
										<input type="text" class="n-input" name="q_name" value="" placeholder="제목을 입력해주세요.">
									</td>
								</tr>
								<tr class="n-same-row">
									<th scope="row">문의내용</th>
									<td>
										<textarea name="q_content" cols="100" rows="20" class="n-input" placeholder="내용을 입력해주세요."></textarea>
									</td>
								</tr>
								<tr class="n-same-row">
									<th scope="row">비밀글 설정</th>
									<td>
                                       <div class="form-check">
  											<input class="form-check-input1" type="radio" name="q_secret" id="aaa" value="Y" onchange="setDisplay()">
  												<label class="form-check-label" for="aaa">
    													<p>설정</p>
  															</label>
  												<input class="form-check-input2" type="radio" name="q_secret" id="bbb" value="N" onchange="setDisplay()" checked>
  														<label class="form-check-label" for="bbb">
   																<p>설정안함</p>
  														</label>
										</div>

									</td>
								</tr>
								<tr id="hidden" style="display:none;">
									<th scope="row">(비밀글 설정시)<br>비밀번호</th>
									<td>
										<input type="password" class="n-input" name="user_pw" value="" placeholder="회원가입 시 입력한 비밀번호를 입력해주세요.">
									</td>
								</tr>
	
		
							</tbody>
						</table>
						
						
				<script>
    				function setDisplay(){
    					if($('input:radio[id=aaa]').is(':checked')){
    						$('#hidden').show();
    					}else{
    						$('#hidden').hide();
    					}
    				}	
    			</script>					
				
											
				
				
		</div>
	
		<div class="cfooter">
			<button type="submit" class="btn btn-success">수정</button>
			<a href="${contextPath}/board/qna" class="btn btn-danger">취소</a>
		</div>
	</form>

	
	
	</div>
</section>

<!--============================
=            Footer            =
=============================-->


</body>

</html>



