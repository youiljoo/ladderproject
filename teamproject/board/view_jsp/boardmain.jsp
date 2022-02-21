<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"    
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html >
<head>

  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/board.css">

  <title>고객지원 게시판</title>

</head>
<style>
  .answer {
    display: none;
    padding-bottom: 30px;
  }
  #faq-title {
    font-size: 25px;
  }
  .faq-content {
    border-bottom: 1px solid #e0e0e0;
  }
  .question {
    font-size: 19px;
    padding: 30px 0;
    cursor: pointer;
    border: none;
    outline: none;
    background: none;
    width: 100%;
    text-align: left;
  }
  .question:hover {
    color: #2962ff;
  }
  [id$="-toggle"] {
    margin-right: 15px;
  }
</style>



  

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
				<img src="${contextPath}/resources/images/customer.jpg" width="300px" height="250px" style="margin-left:-900px; margin-top:-200px;">
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

<section class=" section" style="
    padding-bottom: 10px;
">
	<!-- Container Start -->
	<div class="container">
		<span id="faq-title">자주 묻는 질문(FAQ)</span>
<div class="faq-content">
  <button class="question" id="que-1"><span id="que-1-toggle">+</span><span>Q1. 상품 배송은 보통 얼마나 걸리나요?</span></button>
  <div class="answer" id="ans-1">배송은 평균 1~2일 소요되며, 외곽지역의 경우 3~4일, 제주도는 6일정도 소요됩니다<br>재고가 없을 경우 2주정도 소요되며, SMS로 미리 연락을 드립니다.</div>
</div>
<div class="faq-content">
  <button class="question" id="que-2"><span id="que-2-toggle">+</span><span>Q2. 회원 탈퇴는 어떻게 하나요?</span></button>
  <div class="answer" id="ans-2">회원탈퇴는 마이페이지에서 이루어집니다.<br><br>1.마이페이지에 MY정보를 눌러주십시요.<br><img src="${contextPath}/resources/images/qanda/withdrawal/회원탈퇴_1.PNG" style="width:700px;"><br><br>2.비밀번호를 입력후 회원탈퇴를 눌러주십시요.<br><img src="${contextPath}/resources/images/qanda/withdrawal/회원탈퇴_2.PNG" style="width:700px;"></div>
</div>
<div class="faq-content">
  <button class="question" id="que-3"><span id="que-3-toggle">+</span><span>Q3. 카카오페이나 다른 결제 방식도 가능한가요?</span></button>
  <div class="answer" id="ans-3">죄송합니다 회원님. 현재 저희 사이트에서는 가능한 결제 방식이 카드 결제 혹은 무통장 입금입니다.</div>
</div>
<div class="faq-content">
  <button class="question" id="que-4"><span id="que-4-toggle">+</span><span>Q4. 사다리 게임은 어떻게 하는건가요?</span></button>
  <div class="answer" id="ans-4">사다리게임은 구매가 결정이 어려우신 분을 위해 재미로 준비한 게임입니다.<br><br>1.물품의 개수를 정해주세요!<br><img src="${contextPath}/resources/images/qanda/ladder/사다리게임_1.PNG" style="width:700px;"><br><br>2.물품명을 적은 후 시작 버튼을 눌러주세요!<br><img src="${contextPath}/resources/images/qanda/ladder/사다리게임_2.PNG" style="width:700px;"><br><br>3.GO 버튼을 누르면 사다리게임이 시작됩니다!<br><img src="${contextPath}/resources/images/qanda/ladder/사다리게임_3.PNG" style="width:700px;"></div>
</div>
<div class="faq-content">
  <button class="question" id="que-5"><span id="que-5-toggle">+</span><span>Q5. 아이디와 비밀번호를 분실했을 경우 어떻게 해야하나요?</span></button>
  <div class="answer" id="ans-5">로그인 창에서 아이디 찾기, 비밀번호 찾기 기능을 이용하여 해결하실 수 있습니다.<br>아이디 찾기의 경우 휴대전화 또는 이메일 인증을 통하여 이루어지며,<br><img src="${contextPath}/resources/images/qanda/find/아이디.PNG" style="width:700px;"><br><br>비밀번호 찾기 역시 휴대전화 또는 이메일 인증을 통해 이루어집니다<br><img src="${contextPath}/resources/images/qanda/find/비밀번호.PNG" style="width:700px;"></div>
</div>
	</div>
	<!-- Container End -->
</section>

<section class="section">
	
</section>

<script>
  const items = document.querySelectorAll('.question');

  function openCloseAnswer() {
    const answerId = this.id.replace('que', 'ans');

    if(document.getElementById(answerId).style.display === 'block') {
      document.getElementById(answerId).style.display = 'none';
      document.getElementById(this.id + '-toggle').textContent = '+';
    } else {
      document.getElementById(answerId).style.display = 'block';
      document.getElementById(this.id + '-toggle').textContent = '-';
    }
  }

  items.forEach(item => item.addEventListener('click', openCloseAnswer));
</script>

<!--============================
=            Footer            =
=============================-->






</body>

</html>



