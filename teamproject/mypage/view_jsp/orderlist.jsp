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
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/orderlist.css">
  
   
  
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script language="javascript" src="/js/PopupCalendar.js"></script>

<script>
	$(document).ready(function(){
		/*상품 등록일*/
		var calendar={
				monthNamesShort:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
				dayNamesMin:['일','월','화','수','목','금','토'],
				weekHeader:'Wk',
				dateFormat:'yy-mm-dd',
				//오토 리사이즈
				autoSize:false,
				//월 변경가능
				changeMonth:true,
				//년 변경가능
				changeYear:true,
				//년 뒤에 월 표시
				showMonthAfterYear:true,
				//이미지 표시
				buttonimageOnly:true,
				//버튼 텍스트 표시
				buttonText:'달력선텍',
				//next 아이콘의 툴팁
				nextText:'다음 달',
				//prev 아이콘의 툴팁
				prevText:'이전 달',
				//이미지 주소
				buttonImage:'',
				//엘리먼트와 이미지 동시 사용(both,button)
				showOn:'both',
				//2019년 부터 2100년 까지
				yearRange:'2019:2100',
				showButtonPanel:true,
				currentText:'오늘 날짜',
		};
		/* 상품 등록일-시작일*/
		$("#pr_start_date").datepicker(calendar);
		
		/* 상품 등록일-종료일*/
		$("#pr_end_date").datepicker(calendar);
		
		//이미지 버튼 style 적용
		$("img.ui-datepicker-trigger").attr("style","margin-left:5px; vertical-align:middle; cursor:pointer;");
		
		//자동으로 생성되는 div 객체 숨김
		$("#ui-datepicker-div").hide();
	});
</script>

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

</head>
<body>
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
    <!--  주문내역 -->
    <div class="order_list21">
							 
							<div class="title_wrap"><h2 class="tit_txt">주문내역</h2></div>
							<div class="listTable21">
								<div class="myP_search clearfix">
									<div class="left_area">
										<div class="top">
											
										</div>
										<div class="bottom">
											<span class="myP_select select2">
												<select name="searchType">
													<option value="n"<c:out value="${memberList.searchType eq 'n' ? 'selected' : '' }"/>>주문번호</option>
													<option value="p"<c:out value="${memberList.searchType eq 'p' ? 'selected' : '' }"/>>상품명</option>
												</select>
											</span>
											
											<span class="inputWrap search2"><input type="text" name="keyword" id="keywordInput" value="" placeholder="주문번호, 상품명을 입력해주세요."></span>
										<div class="right_area">
										<button id = "searchBtn" type="button" class="save_B15btn">조회</button>
										<script>
											$(function(){
												$('#searchBtn').click(function(){
													self.location = "orderlist.do" + "${paging.makeQuery(1)}" + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
												})
											})
										</script>
										
									</div>
										</div>
									</div>
									
								</div>
							</div>
				
							
							<div class="listTable_TotalTit clearfix">
							
							</div>
						
							<div class="orderList_con">
								<div class="order_list21">
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
						<c:when test="${empty myOrderList }">	
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
							<c:forEach var="item" items="${myOrderList }" varStatus="i">
								
									<tr>
									<td><span>${item.memorderseqnum }</span></td>
									<td><strong><span>${item.productName }</span></strong></td>
									<td><span>${item.productAmt }</span></td>
									<td><span>${item.totalprice }</span></td>
									<td><span>${item.order_state }</span></td>
									<td><span><a href="${contextPath}/prodetail_review.do?productnum=${item.productnum}" type="button" class="myP_SWbtn">후기</a></span>
									<td align="left">
								</c:forEach>
								</c:otherwise>
								
					</c:choose>
				</tbody>
			</table>
			<div class="div-1">
	<div class="orderList_page">
					<ul class="paging"> 
						<c:if test="${paging.prev }">
							<span><a href='<c:url value="/orderlist.do?page=${paging.startPage-1}"/>'>이전</a></span>
						</c:if>
						<c:forEach begin="${paging.startPage }" end="${paging.endPage}" var="num">
							<span><a href='<c:url value="/orderlist.do?page=${num }"/>'>${num }</a></span>
						</c:forEach>
						<c:if test="${paging.next && paging.endPage>0 }">
							<span><a href='<c:url value="/orderlist.do?page=${paging.endPage+1 }"/>'>다음</a></span>
						</c:if>
					</ul>
				</div>
				</div>
		</div>
	</div>
	
							</div>  
						

						</div>
    <div class="order_list21 mt50">
							<div class="title_wrap clearfix"><h2 class="tit_txt">주문/배송 진행 단계</h2></div>
							<div class="listTable21">
								<ul class="orderStep_list clearfix">
									<li>
										<span class="step_text">STEP1</span>
										<p class="wCircle">
											<span class="img1"><img src="${contextPath}/resources/images/orderS1.png"></span>
										</p>
										<dl>
											<dt>입금 확인중</dt>
											<dd>주문접수가 완료된 상태로<br>3일내 미입금 시<br>주문이 자동 취소됩니다.</dd>
										</dl>
									</li>
									<li>
										<span class="step_text">STEP2</span>
										<p class="wCircle">
											<span class="img2"><img src="${contextPath}/resources/images/orderS2.png"></span>
										</p>
										<dl>
											<dt>결제완료</dt>
											<dd>정상적으로<br>주문 및 결제가 완료된<br>상태입니다.</dd>
										</dl>
									</li>
									<li>
										<span class="step_text">STEP3</span>
										<p class="wCircle">
											<span class="img3"><img src="${contextPath}/resources/images/orderS3.png"></span>
										</p>
										<dl>
											<dt>상품준비</dt>
											<dd>사다리컴매장 또는 거래처에<br>주문이 접수되어 재고 및 상태를<br>확인 중입니다.</dd>
										</dl>
									</li>
									<li>
										<span class="step_text">STEP4</span>
										<p class="wCircle">
											<span class="img4"><img src="${contextPath}/resources/images/orderS5.png"></span>
										</p>
										<dl>
											<dt>상품발송</dt>
											<dd>택배사에 상품이<br>인계되어 고객님께<br>배송 중입니다.</dd>
										</dl>
									</li>
									<li>
										<span class="step_text">STEP5</span>
										<p class="wCircle">
											<span class="img5"><img src="${contextPath}/resources/images/orderS7.png"></span>
										</p>
										<dl>
											<dt>배송/수령완료</dt>
											<dd>고객님께 상품이<br>인계되어 배송이 완료된<br>상태입니다.</dd>
										</dl>
									</li>
								</ul>
							</div>
							<div class="order_noticeBox">
								<ul class="notice_list listDot">
									<li><i>·</i>무통장 입금으로 주문하신 경우 3일 이내에 입금해 주셔야 하며, 3일 경과 시 별도 고지없이 주문 취소됩니다.</li>
									<li><i>·</i>입금이 늦어지는 경우 제품의 품절 및 재고 부족으로 주문이 취소될 수 있습니다.</li>
									<li><i>·</i>제품은 배송 후 1~2일 이내에 받으실 수 있습니다. (주문제작상품, 설치상품, 예약상품 등 일부 상품 제외)</li>
									<li><i>·</i>주문취소는 입금확인중, 결제완료 시에만 가능합니다.<br>상품준비중, 상품발송, 배송완료 단계에서 주문취소 및 교환, 반품이 필요한 경우 직접신청 혹은 1:1문의하기를 이용해 주세요.<br>
									<a class="page_go" href="${contextPath }/mypageas.do">교환/반품 신청하기 &gt;</a><a class="page_go" href="${contextPath }/main.do">문의하기 &gt;</a></li>
								</ul>
							</div>
						</div>
    </main>
  
    </div> 
    </section>
 </div>
   
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

