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
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mypageas2.css"> 
   <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

   
</head>

<style>
	.div-1{
		padding : 25px;
		margin: 0 auto;
		display:block;
		text-align : center;
	}
	
	.div-2{		
		text-align : right;
	}	
	
	
</style>

<script>
	$(function(){
		$('#searchBtn').click(function(){
			self.location = "mypageas2.do" + "${paging.makeQuery(1)}" + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
		});
	});
</script>

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
			
<div class="myP_right as_list_wrap">
					<form name="global_form" id="global_form" method="post" enctype="multipart/form-data">
						<input type="hidden" name="PageNum" value="1">
						<input type="hidden" name="StartNum" value="0">
						<input type="hidden" name="old_db" value="">
						<input type="hidden" name="period" id="period" value="1week">
						<input type="hidden" name="AsPresentState" value="">

					<!-- 처리 현황 -->
					<div class="order_state">
						<div class="orderState_list os_list4">
							<ul>
								<!-- 현재 상태에 있을때 li class="on" 추가해주세요 -->
								<li class="step1 ">
									<a href="javascript:fn_SearchState('접수대기');">
										<p class="wCircle"><span class="img"></span><em class="num">0</em></p>
										<p class="step_t">접수대기</p>
									</a>
								</li>
								<li class="step2 ">
									<a href="javascript:fn_SearchState('상품회수');">
										<p class="wCircle"><span class="img"></span><em class="num">0</em></p>
										<p class="step_t">상품회수</p>
									</a>
								</li>
								<li class="step3 ">
									<a href="javascript:fn_SearchState('처리중');">
										<p class="wCircle"><span class="img"></span><em class="num">0</em></p>
										<p class="step_t">처리중</p>
									</a>
								</li>
								<li class="step4 ">
									<a href="javascript:fn_SearchState('출고대기');">
										<p class="wCircle"><span class="img"></span><em class="num">0</em></p>
										<p class="step_t">출고대기</p>
									</a>
								</li>
								<li class="step5 ">
									<a href="javascript:fn_SearchState('처리완료');">
										<p class="wCircle"><span class="img"></span><em class="num">0</em></p>
										<p class="step_t">처리완료</p>
									</a>
								</li>
								<li class="step6 ">
									<a href="javascript:fn_SearchState('신청취소');">
										<p class="wCircle"><span class="img"></span><em class="num">0</em></p>
										<p class="step_t">신청취소</p>
									</a>
								</li>
							</ul>
						</div>
					</div>
					<!-- 처리 현황// -->

					<!-- A/S · 교환 · 반품 내역 -->
					<div class="as_list mt45">
						
						<div class="title_wrap clearfix">
							<h2 class="tit_txt">A/S · 교환 · 반품 내역</h2>
						</div>
						<div class="listTable21">
							<div class="myP_search clearfix">
								<div class="left_area">
									<div class="bottom">
										<span class="myP_select select2">
											<select name="SearchType">
                        <option value="n"<c:out value="${mypageList.searchType eq 'n' ? 'selected' : '' }"/>> 접수번호</option>
                        <option value="p"<c:out value="${mypageList.searchType eq 'p' ? 'selected' : '' }"/>> 상품명</option>
                      </select>
										</span>
										<span class="inputWrap search2"><input type="text" name="SearchValue" value="${mypageList.keyword }" placeholder="접수번호 또는 상품명을 입력해 주세요."></span>
											<div class="right_area">
												<button type="button" id="searchBtn" class="save_B15btn">조회</button>
											</div>
											
									</div>
								</div>
							</div>
						</div>
						<div class="listTable21 mt20">
							<table border="0" cellspacing="0" cellpadding="0" width="100%" class="myP_Ttype1">
								<colgroup>
									<col width="25%">
									<col width="25%">
									<col width="25%">
									<col width="25%">
								</colgroup>
								<thead>
									<tr><th>접수번호</th>
									<th>구분</th>
									<th>상품</th>
									<th>처리상태</th>
								</tr></thead>
							<tbody> 
								<c:choose>
									<c:when test="${empty list }">
									<tr>
										<td colspan="6">
											<div class="no_list">
												<span><img src="//image5.compuzone.co.kr/img/images/mypage21/cart_big.png"></span>
												<p class="txt">A/S · 교환 · 반품 내역이 없습니다.</p>
											</div>
										</td>
									</tr>
									</c:when>
								<c:otherwise>
									<c:forEach var="item" items="${list }" varStatus="i">
										<tr>
										<td><span>${item.as_no }</span></td>
										<td><span>${item.as_type }</span></td>
										<td><span>${item.as_name }</span></td>
										<td><span>${item.as_state }</span></td>
										</tr>
									</c:forEach>
								</c:otherwise>
								</c:choose>
								</tbody>
							</table>
							
							<div class="bottom_area">			
								<div class="page_area">
								<div class="div-1">
									<div class="mypage_page">
										<ul class="paging">
											<c:if test="${paging.prev }">
												<span><a href='<c:url value="/mypageas.do?page=${paging.startPage-1 }"/>'>이전</a></span>
											</c:if>
											<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="num">
												<span><a href='<c:url value="/mypageas.do?page=${num}" />'>${num }</a></span>
											</c:forEach>
											<c:if test="${paging.next && paging.endPage>0 }">
												<span><a href='<c:url value="/mypageas.do?page${paging.endPage+1 }" />'>다음</a></span>
												</c:if>
										</ul>
									</div>
									</div>
								</div>							
							</div>
						</div>
						
						<div class="asCPL_notice">
							<span class="ntRB16">주의사항</span>
							<span class="ntRB13">
								<p style="font-size:12px; margin-bottom: 0px;">※ A/S·교환·반품 신청 후 상품이 7일 이내에 사다리컴에 입고되지 않는 경우, 자동 취소됩니다.</p>
								<p style="font-size:12px; margin-bottom: 0px;">※ 반품 소요 기간 - 무통장 입금 : 영업일 기준 1~2일, 카드 : 영업일 기준 4~7일</p>
							</span>
						</div>
					</div>
					</form>
				</div>
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

