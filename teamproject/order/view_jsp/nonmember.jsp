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
<body>
  
     <!-- contents --> 
  <div id = "contents">
    <!-- 마이페이지 메인 -->
 <section class="flex-center3">		
        <main>
            <div class="order_list21">
						<div class="title_wrap">
							<h2 class="tit_txt">주문 내역</h2>
						</div>
						<div class="listTable21">
							<table border="0" cellspacing="0" cellpadding="0" width="100%" class="myP_Ttype1">
							
								<colgroup>
									<col width="18%">
									<col width="45%">
									<col width="15%">
									<col width="10%">
									<col width="12%">
								</colgroup>
								<thead>
									<tr><th>주문번호</th>
									<th>상품</th>
									<th>수량</th>
									<th>주문금액</th>
									<th>주문상태</th>
									
								</tr></thead>
							<c:forEach var="item" items="${list }" varStatus="i">
							<tbody>
									<tr>
									<td><span>${item.memorderseqnum }</span></td>
									<td><strong><span>${item.productName }</span></strong></td>
									<td><span>${item.productAmt }</span></td>
									<td><span>${item.totalprice }</span>
									<td><span>${item.order_state }</span></td>
									<td align="left">
							</tbody>
					</c:forEach>
			</table>
		</div>
	</div>
</main>
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




  