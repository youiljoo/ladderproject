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
	
	.div-2{		
		text-align : right;
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
        
            <div class="order_list21">
            	
						<div class="title_wrap">
							<h2 class="tit_txt" style="text-align:center">주문 관리</h2>
						</div>
						<div class="listTable21">
							<table border="0" cellspacing="0" cellpadding="0" width="100%" class="myP_Ttype1">
								<colgroup>
									<col width="13%">
									<col width="13%">
									<col width="13%">
									<col width="31%">
									<col width="10%">
									<col width="10%">
									<col width="10%">
								</colgroup>
								<thead>
									<tr><th>주문번호</th>
									<th>주문자아이디</th>
									<th>주문일자</th>
									<th>주문내역</th>
									<th>결제방식</th>
									<th>주문현황</th>
									<th>상세보기</th>
								</tr></thead>
								<c:forEach var="item" items="${admin }" varStatus="i">
								<tbody>
									<tr><td>${item.memordernum }</td>
									<td>${item.user_id }</td>
									<td>${item.pay_order_time }</td>
									<td>${item.productName }</td>
									<td>${item.mempayment }</td>
									<td>${item.order_state }</td>
									<td><a class="myP_SWbtn" href="${contextPath }/admin_order_de.do?memordernum=${item.memordernum}">상세보기</a></td>											
										</tr>
									
									
								</tbody>
								</c:forEach>
							</table>
							
							<div class="div-1">
								<div class="search">
									<select id="searchType" name="searchType" >
    									<option value="i"<c:out value="${orderList.searchType eq 'i' ? 'selected' : '' }"/>>아이디</option>
  									</select>
  									 <input type="text" name="keyword" id="keywordInput" value="${orderList.keyword }" placeholder="내용" >
  									 <button id = "searchBtn" type="button">검색</button>
									 <script>
  											 	$(function(){
  											 		$('#searchBtn').click(function(){
  											 			self.location = "admin_order.do" + '${paging.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
  											 		});
  											 	});
  									</script>
								</div>
								<div class="admin_order_page">
										<ul class="paging">
											<c:if test="${paging.prev }">
												<span><a href='<c:url value="/admin_order.do?page=${paging.startPage-1 }"/>'>이전</a></span>
											</c:if>
											<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="num">
												<span><a href='<c:url value="/admin_order.do?page=${num }" />'>${num }</a></span>
											</c:forEach>
											<c:if test="${paging.next && paging.endPage>0 }">
												<span><a href='<c:url value="/admin_order.do?page=${paging.endPage+1 }"/>'>다음</a></span>
											</c:if>
										</ul>
										</div>
							<h1>${message }</h1>
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

 