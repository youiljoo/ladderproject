<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  pageEncoding="utf-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- header -->
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mypage.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
        <form action="${contextPath }/adminOrderUpdate.do">
            <div class="order_list21">
            	
						<div class="title_wrap">
							<h2 class="tit_txt" style="text-align:center">주문 상세 정보</h2>
						</div>
						<div class="listTable21">
						<input type="hidden" id="memordernum" name="memordernum" value="${selectOrder.memordernum }">
							<h3>주문정보</h3>
							<table border="0" cellspacing="0" cellpadding="0" width="100%" class="myP_Ttype1">
								<colgroup>
									<col width="20%">
									<col width="35%">
									<col width="15%">
									<col width="10%">
									<col width="10%">
									<col width="10%">
								</colgroup>
								<thead>
									<tr><th>주문번호</th>
									<th>제품정보</th>
									<th>가격</th>
									<th>구매수량</th>
									<th>합계</th>
									<th>주문현황</th>
								</tr></thead>
								<tbody>
									<tr><td>${selectOrder.memordernum }</td>
									<td>${selectOrder.productName }</td>
									<td>${selectOrder.productPrice }</td>
									<td>${selectOrder.productAmt }</td>
									<td>${selectOrder.totalprice }</td>
									<td>
  											<select id="order_state" name="order_state" >
    											<option value="입금확인중" selected>입금확인중</option>
    											<option value="상품준비중">상품준비중</option>
    											<option value="상품배송중">상품배송중</option>
    											<option value="배송완료">배송완료</option>
  											</select>
									</td>				
									</tr>
								</tbody>
							</table>							
							<br>			
						</div>
						
						<div class="listTable21">
							<h3>주문자정보</h3>
							<table border="0" cellspacing="0" cellpadding="0" width="100%" class="myP_Ttype1">
								<colgroup>
									<col width="20%">
									<col width="20%">
									<col width="20%">
									<col width="20%">
									<col width="20%">
								</colgroup>
								<thead>
									<tr>
									<th>아이디</th>
									<th>이름</th>
									<th>연락처</th>
									<th>결제방식</th>
									<th>주문일자</th>
								</tr></thead>
								<tbody>
									<tr><td>${selectOrder.user_id }</td>
									<td>${selectOrder.memsqname }</td>
									<td>${selectOrder.memsqphonenum }</td>
									<td>${selectOrder.mempayment }</td>
									<td>${selectOrder.pay_order_time }</td></tr>
								</tbody>
							</table>							
							<br>			
						</div>
						
						
						<div class="listTable21">
							<h3>배송정보</h3>
							<table border="0" cellspacing="0" cellpadding="0" width="100%" class="myP_Ttype1">
								<colgroup>
									<col width="20%">
									<col width="20%">
									<col width="20%">
									<col width="40%">
								</colgroup>
								<thead>
									<tr><th>수령인</th>
									<th>연락처</th>
									<th>배송지</th>
									<th>요청사항</th>								
								</tr></thead>
								<tbody>
									<tr><td>${selectOrder.memsqname }</td>
									<td>${selectOrder.memsqphonenum }</td>
									<td>${selectOrder.memsqaddr }</td>
									<td>${selectOrder.delivery_message }</td></tr>
								</tbody>
							</table>							
							<br>			
						</div>
						
						<div class="div-1">
						<button type="submit" class="btn btn-outline-dark">변경하기</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-outline-dark" onclick="location='${contextPath}/admin_order.do'">취소하기</button>
						</div>
					</div>
					</form>
        </main>
</div>
</section>
    </div>
  
</body>
</html>

 