<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  pageEncoding="utf-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="pre_order_id" value="${item.user_id }" />
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

   

 
</head>

<style>
	.div-1{
		padding : 15px;
		margin: 0 auto;
		display:block;
		text-align : center;
	}
	
	.div-2{		
		text-align : right;
	}	
	
	
</style>

<body>
  
     <!-- contents --> 
  <div id = "contents">
    <!-- 마이페이지 메인 -->
 <section class="flex-center3">
 <div>
<div class="myP_left">
<ul class="my_gnb">
						<li class="depth1">
							<a href="javascript:sl_tab(1)" class="depth1_b_m" id="tab_1">MY 주문</a><i class="gnb_i"></i>
							<div class="depth2 tab_li" id="tab_li_1" style="">
								<ul>
									<li><a href="${contextPath}/orderlist.do">주문내역</a></li>
									<li><a href="${contextPath}/mypageas.do">교환 · 반품 내역</a></li>
								</ul>
							</div>
						</li>
						
						<li class="depth1">
							<a href="javascript:sl_tab(2)" class="depth1_b_m" id="tab_2">MY 관심목록</a><i class="gnb_i"></i>
							<div class="depth2 tab_li" id="tab_li_2" style="">
								<ul>
									<li><a href="${contextPath}/cart.do">장바구니</a></li>
								</ul>
							</div>
						</li> 
						<li class="depth1">
							<a href="javascript:sl_tab(3)" class="depth1_b_m" id="tab_3">MY 활동</a><i class="gnb_i"></i>
							<div class="depth2 tab_li" id="tab_li_3" style="display: none;">
								<ul>
									<li class="on"><a href="${contextPath}/mypage_conlist.do">상담내역</a></li>
									<li ><a href="${contextPath}/mypage_reviewlist.do">구매후기</a></li>
								</ul>
							</div>
						</li>
						
						<li class="depth1">
							<a href="javascript:sl_tab(4)" class="depth1_b_m" id="tab_4">MY 정보</a><i class="gnb_i"></i>
							<div class="depth2 tab_li" id="tab_li_4">
								<ul>
									<li><a href="${contextPath}/edit_pw.do">회원정보 수정</a></li>
									<li><a href="${contextPath}/removeid.do">회원탈퇴</a></li>
								</ul>
							</div>
						</li>
					</ul>
							<div class="cs_box">
						<h2>사다리컴 고객센터</h2>
						<h3 class="SpqBlue2">1588-0000</h3>
						<p style="margin-bottom: 0px;margin-top: 0px; font-size: 16px">월~금 10:00~19:00</p>
						<p style="margin-top: 2px; margin-bottom: 0px; font-size: 16px">주말, 공휴일 휴무</p>
						<a class="myP_SWbtn" href="${contextPath }/board" target="_blank" style="margin-top:15px;">상담하기</a>
					</div> 
					</div>   
			
				
        <main>
            <div id="main-img">
         <div class="title_wrap"><h2 class="tit_txt">주문현황</h2></div> 
            <div class="orderState_list os_list1">
							<ul>
								<li class="step1 ">
									<a href="orderlist.do">
										<p class="wCircle"><span class="img"></span><em class="num">0</em></p>
										<p class="step_t">결제대기</p>
									</a>
								</li>
								<li class="step2 ">
									<a href="orderlist.do">
										<p class="wCircle"><span class="img"></span><em class="num">0</em></p>
										<p class="step_t">결제완료</p>
									</a>
								</li>
								<li class="step3 ">
									<a href="orderlist.do">
										<p class="wCircle"><span class="img"></span><em class="num">0</em></p>
										<p class="step_t">상품준비</p>
									</a>
								</li>
								<li class="step4 ">
									<a href="orderlist.do">
										<p class="wCircle"><span class="img"></span><em class="num">0</em></p>
										<p class="step_t">상품발송</p>
									</a>
								</li>
								<li class="step5 ">
									<a href="orderlist.do">
										<p class="wCircle"><span class="img"></span><em class="num">0</em></p>
										<p class="step_t">주문취소</p>
									</a>
								</li>
								<li class="step6 ">
									<a href="orderlist.do">
										<p class="wCircle"><span class="img"></span><em class="num">0</em></p>
										<p class="step_t">A/S·교환·반품</p>
									</a>
								</li>
							</ul>
						</div>

            </div>
            <div class="bookmark mt45">
						<div class="title_wrap"><h2 class="tit_txt">자주 찾는 메뉴</h2></div> 
						<ul class="bookmark_list">
							<li>
								<a href="${contextPath }/mypage_conlist.do">
									<h3>상담내역</h3>
									<div class="count_area"><i></i></div>
								</a>
							</li>
							<li>
								<a href="${contextPath }/mypage_reviewlist.do">
									<h3>구매후기</h3>
									<div class="count_area"><i></i></div>
								</a>
							</li>
							<li>
								<a href="${contextPath }/cart.do">
									<h3>장바구니</h3>
									<div class="count_area"><i></i></div>  
								</a>
							</li> 
							<li style = "margin-right: 0px;">
								<a href="${contextPath }/edit_pw.do">
									<h3>회원 정보 수정</h3>
									<div class="count_area"><i></i></div>
								</a>
							</li>
						</ul>
					</div>

            <div class="order_list21">
						<div class="title_wrap">
							<h2 class="tit_txt">최근 주문 내역</h2>
							<a class="viewAll_btn" href="orderlist.do">전체보기<i></i></a>
						</div>
						<div class="listTable21">
							<table border="0" cellspacing="0" cellpadding="0" width="100%" class="myP_Ttype1">
								<colgroup>
									<col width="23%">
									<col width="30%">
									<col width="20%">
									<col width="10%">
									<col width="17%">
								</colgroup>
								<thead>
									<tr><th>주문번호</th>
									<th>상품</th>
									<th>수량</th>
									<th>주문금액</th>
									<th>주문상태</th>
									<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
									
								</tr></thead>
				<tbody>
					<c:choose>
						<c:when test="${empty list }">	
									<tr>
										<td colspan="6">
											<div class="no_list">
												<span><img src="${contextPath}/resources/images/cart_big.png"></span>
												<p class="txt">최근 3개월 동안의 주문/배송 내역이 없습니다.</p>
												<a class="myP_MBbtn" href="${contextPath }/main.do">쇼핑 시작하기</a>
											</div>
										</td>
									</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="item" items="${list }" varStatus="i">
								
									<tr>
									<td><span>${item.memorderseqnum }</span></td>
									<td><strong><span>${item.productname }</span></strong></td>
									<td><span>${item.productAmt }</span></td>
									<td><span>${item.totalprice }</span></td>
									<td><span>${item.order_state }</span></td>
									<td align="left">
								</c:forEach>
								</c:otherwise>
								
					</c:choose>
				</tbody>
			</table>
			<div class="page_area">
				<div class="div-1">
					<div class="mypage_page">
						<ul class="paging">
							<c:if test="${paging.prev }">
								<span><a href='<c:url value="/mapage.do?page=${paging.startPage-1 }"/>'>이전</a></span>
							</c:if>
							<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
				        		<span><a href='<c:url value="/mypage.do?page=${num }"/>'>${num }</a></span>
				    		</c:forEach>
				    		<c:if test="${paging.next && paging.endPage>0}">
				        		<span><a href='<c:url value="/mypage.do?page=${paging.endPage+1 }"/>'>다음</a></span>
				    		</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>
</div>
</section>
    </div>
  <script></script>
   <script>
	function sl_tab(tabIdx){
		
		if(!$("#all_view_tab").is(":checked")){
			if( $("#tab_"+tabIdx).hasClass('active')){
				$(".depth1_b_m").removeClass('active');
				$("#tab_"+tabIdx).removeClass('active');
				$(".tab_li").slideUp(300);
			}else{
				$(".tab_li").slideUp(300);
				$(".depth1_b_m").removeClass('active');
				$("#tab_"+tabIdx).addClass('active');
				$("#tab_li_"+tabIdx).slideDown(300);
			}
		}else{
			if( $("#tab_"+tabIdx).hasClass('active')){
				$("#tab_"+tabIdx).removeClass('active');
				$("#tab_li_"+tabIdx).slideUp(300);
			}else{
				$("#tab_"+tabIdx).addClass('active');
				$("#tab_li_"+tabIdx).slideDown(300);
			}
		}
	}
$(document).ready(function(){

	$(window).scroll(function () {
		if($(window).scrollTop() > 200) {
			$(".myP_topFixed").addClass("sticky");
		} else {
			$(".myP_topFixed").removeClass("sticky");
		}
	});

	if(getCookie('mp_all_chk') == "Y"){
		$(".depth2").show();
		$(".depth1_b_m").addClass('active');
		$(".switch-ui-checkbox").prop('checked',true);
	}

	//gnb on/off 스위치 
	$(".switch-ui-checkbox").on('click',function(){
		if($(this).is(':checked')){
			$(".depth2").show();
			$(".depth1_b_m").addClass('active');
			setCookie('mp_all_chk','Y',365,'/');
		}
		else{
			$(".depth2").hide();
			$(".depth1_b_m").removeClass('active');
			setCookie('mp_all_chk','N',1,'/');
		}
	});
	
	
});
</script>
  
</body>
</html>




  