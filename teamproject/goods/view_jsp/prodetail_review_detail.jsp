<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"    
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="goods"  value="${goodsMap.goodsVO}"  />
<c:set var="imageList"  value="${goodsMap.imageList}"  />
<c:set var="re" value="${reMap.re}" />
<c:set var="imageFileList" value="${reMap.imageFileList}" />
<!DOCTYPE html>
<html> 
<head>

  
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

  <!-- CUSTOM CSS -->
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
  <!-- Main CSS -->
  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/prodetail.css">
  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/board.css">

  
 	<body onload="init();">

  			<script type="text/javascript">
  		  	var sell_price;
  		  	var productAmt;

  		  	function init () {
  		  		sell_price = document.form.sell_price.value;
  		  		productAmt = document.form.productAmt.value;
  		  		document.form.sum.value = sell_price;
  		  		change();
  		  	}

  		  	function add () {
  		  		hm = document.form.productAmt;
  		  		sum = document.form.sum;
  		  		hm.value ++ ;

  		  		sum.value = parseInt(hm.value) * sell_price;
  		  	}

  		  	function del () {
  		  		hm = document.form.productAmt;
  		  		sum = document.form.sum;
  		  			if (hm.value > 1) {
  		  				hm.value -- ;
  		  				sum.value = parseInt(hm.value) * sell_price;
  		  			}
  		  	}

  		  	function change () {
  		  		hm = document.form.productAmt;
  		  		sum = document.form.sum;

  		  			if (hm.value < 0) {
  		  				hm.value = 0;
  		  			}
  		  		sum.value = parseInt(hm.value) * sell_price;
  		  	}  
  		  	
  			function add_cart(productNum) {
  				var cartproductAmt = $("#productAmt").val();
  				$.ajax({	
  					type : "POST",
  					async : false, //false인 경우 동기식으로 처리한다.
  					url : "${contextPath}/addGoodsInCart.do",
  					data : {
  						productNum:productNum,
  						cartproductAmt:cartproductAmt
  					},
  					success : function(data, textStatus) {
  						//alert(data); 
  					//	$('#message').append(data);
  						if(data.trim()=='add_success'){
  							alert("장바구니에 담았습니다.");
  						}else if(data.trim()=='already_existed'){
  							alert("이미 카트에 등록된 상품입니다.");	
  						}
  						
  					},
  					error : function(data, textStatus) {
  						alert("에러가 발생했습니다."+data);
  					},
  					complete : function(data, textStatus) {
  						//alert("작업을완료 했습니다");
  					}
  				}); //end ajax	
  			}
  		
  		function fn_order_each_goods(productNum,productName,productPrice,originFileName,category){

  			
  			var total_price,final_total_price;
  			var productAmt=document.getElementById("productAmt");
  				
  			var formObj=document.createElement("form");
  			var i_productNum = document.createElement("input"); 
  		    var i_productName = document.createElement("input");
  		    var i_productPrice=document.createElement("input");
  		    var i_originFileName=document.createElement("input");
  		    var i_productAmt=document.createElement("input");
  			var i_category=document.createElement("input");
  		    
  		    i_productNum.name="productNum";
  		    i_productName.name="productName";
  		    i_productPrice.name="productPrice";
  		    i_originFileName.name="originFileName";
  		    i_productAmt.name="productAmt";
  		    i_category.name="category";
  		  
  		    i_productNum.value=productNum;
  		    i_productAmt.value=productAmt.value;
  		    i_productName.value=productName;
  		    i_productPrice.value=productPrice;
  		    i_originFileName.value=originFileName;
  		    i_category.value=category;
  		    
  		    formObj.appendChild(i_productNum);
  		    formObj.appendChild(i_productName);
  		    formObj.appendChild(i_productPrice);
  		    formObj.appendChild(i_originFileName);
  		    formObj.appendChild(i_productAmt);
  		    formObj.appendChild(i_category);

  		    document.body.appendChild(formObj); 
  		    formObj.method="post";
  		    formObj.action="${contextPath}/orderpayment.do";
  		    formObj.submit();
  			}	
  		</script>
  	</head>
	   
	   
	   
	   
  





<!--===============================
=            Hero Area            =
================================-->

<section class="hero-area bg-1 text-center overly::before" style="background-color:white">	
	<!-- Container Start -->
	<div class="container">
		<h2 style="text-align:left; margin-left:-60px; margin-top:-50px;">${goods.productName}</h2>		
		<div class="row">
			
				
				<!-- Header Content -->
		
		
					
	
		
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

<section class="popular-deals section bg-gray"
style="padding-top: 40px; padding-bottom: 20px;">
<form name="form" method="get">
	<div class="container">
		<div class="row">
		
			<div class="col-md-4">	
				<div class="card" style="width: 360px; height: 360px">
					<div id="goods_image">
		<figure>
			<img width="360px" height="300px" 
				     src="${contextPath}/thumbnails.do?category=${goods.category}&productNum=${goods.productNum}&fileName=${goods.originFileName}">
		</figure>
	</div>
	</div>
</div>
			<div class="pd info_price" style="width:750px">
							<h3 style="top: 29px; margin-left:200px; margin-top:30px; border-bottom: 1px solid #6666;">판매가</h3>					
							<div class="ct price_inner">
								
								<div class="price_real" style="margin-left:500px; margin-top:-35px">		
				        		<div> ${goods.productPrice}원</div>							
								</div>
								
							</div>
								<div class="pd info_num" style="width:750px">
								<h3 style="top: 29px; margin-left:200px; margin-top:30px;">상품번호</h3>
								<div class="ct num_inner">
								
								<div class="num_real" style="margin-left:500px; margin-top:-35px">									
										${goods.productNum}							
								</div>
								
							</div>								
								</div>
								<div class="pd info_reg" style="width:750px">
								<h3 style="top: 29px; margin-left:200px; margin-top:20px;">상품등록일</h3>
									<div class="ct reg_inner">
								
								<div class="reg_real" style="margin-left:500px; margin-top:-35px">									
										${goods.productDate}					
								</div>
								
							</div>								
								</div>
								<div class="pd info_amount" style="width:750px">
								<h3 style="top: 29px; margin-left:200px; margin-top:20px;">재고수량</h3>
									<div class="ct amount_inner">
								
								<div class="amount_real" style="margin-left:500px; margin-top:-35px">									
										${goods.productStock}							
								</div>
								
							</div>								
								</div>
								<div class="pd info_orderamount" style="width:750px">
								<h3 style="top: 29px; margin-left:200px; margin-top:20px;">주문수량</h3>
									<div class="ct orderamount_inner">
								
								<div class="orderamount_real" style="margin-left:500px; margin-top:-35px">									
								 <input type=hidden name="sell_price" value="${goods.productPrice}">
<input type="text" id = "productAmt" name="productAmt" value="1" size="3" onchange="change();">
<input type="button" value=" + " onclick="add();"><input type="button" value=" - " onclick="del();"><br>
								<div>
								</div>
								
							</div>								
								</div>
								<div class="pd info_company" style="width:750px">
								<h3 style="top: 29px; margin-left:200px; margin-top:20px;">제조사</h3>
									<div class="ct company_inner">
								
								<div class="company_real" style="margin-left:500px; margin-top:-35px">									
										${goods.company}							
								</div>
								
							</div>								
								</div>
								<div class="pd info_delinfo" style="width:750px">
								<h3 style="top: 29px; margin-left:200px; margin-top:20px; border-bottom: 1px solid #6666;">배송정보</h3>
									<div class="ct delinfo_inner">
								
								<div class="delinfo_real" style="margin-left:500px; margin-top:-35px">									
										입금 확인 후 평균 1~3일 소요						
								</div>
								
							</div>								
								</div>
								
								<div class="pd info_allprice" style="width:750px">
								<h3 style="top: 29px; margin-left:200px; margin-top:20px; border-bottom: 1px solid #6666;">총 합계 금액</h3>
									<div class="ct allprice_inner">
								
								<div class="allprice_real" style="margin-left:500px; margin-top:-35px">									
 <input style = "background: #F5F5F5;" type="text" name="sum" size="11" readonly>원	 
						</div>								
								</div>
								
				
						
</div>	
</div>			
			
</div>
</div>
</form>
</section>

 

<!--==========================================
=            All Category Section            =
===========================================-->
<div class="popular-deals">

<div class="btn_section" >
<div class="btn_area" role="group" aria-label="Basic outlined example">

	<a class="buy" href="javascript:fn_order_each_goods('${goods.productNum }','${goods.productName }','${goods.productPrice}','${goods.originFileName}','${goods.category}');">구매하기 </a>
			<a class="cart" href="javascript:add_cart('${goods.productNum}')">장바구니</a>
	
</div>
</div>
</div>   

<section class="popular-deals section bg-gray"
style="padding-top: 40px; padding-bottom: 20px;">

<div class="container">

	<div class="main">
  <input type="radio" id="tab-1" name="show" />
  <input type="radio" id="tab-2" name="show" checked/>
  <input type="radio" id="tab-3" name="show" />
  <input type="radio" id="tab-4" name="show" />
  <div class="tab">
    <label for="tab-1">상세 정보</label>
    <label for="tab-2">구매 후기</label>
    <label for="tab-3">배송 정보</label>
    <label for="tab-4">교환/환불 안내</label>
  </div>
  
  <div class="content">
    <div class="content-dis">
    	<c:forEach var="image" items="${imageList}">
       <img src="${contextPath}/thumbnails.do?category=${goods.category}&productNum=${goods.productNum}&fileName=${image.fileName}" class="card-img-top" alt="${goods.productName}" style="width:1075px; height:500px;">
      	</c:forEach>
       <div class="content-info">
       <h2><c:out value="${goods.productName}"></c:out></h2>
	 		<p>
	 		   <c:out value="${goods.productInfo}"/>
	 		  
	 		</p>
	   </div>	
    </div>
    
	 	
	
    <div class="content-dis">
    <div class="review_list" style="position:relative;">  
      <div class="review_list_inner">
											<div class="average">
												<p class="tit">전체 만족도 평점</p>
												<div style="display: inline-block; margin: 35px 134px;"><span class="avgDetail_starN"><span class="avgDetail_star" style="width:94%"></span></span></div>
												<strong>4.7</strong>
											</div>
											<div class="graph_list">
												<p class="tit">평점비율</p>
												<div class="graph_satisfaction">
													<ul class="list">
														<li class="item point">
															<span class="bar_blank">
																<span class="wrap_value" style="min-height:0;height: 80%">
																	<span class="area_value"><em class="value">63명</em></span>
																	<span class="bar"></span>
																</span>
															</span>
															<span class="label">5점</span>
														</li>
														<li class="item point">
															<span class="bar_blank">
																<span class="wrap_value" style="min-height:0;height: 12%">
																	<span class="area_value"><em class="value">9명</em></span>
																	<span class="bar"></span>
																</span>
															</span>
															<span class="label">4점</span>
														</li>
														<li class="item point">
															<span class="bar_blank">
																<span class="wrap_value" style="min-height:0;height: 7%">
																	<span class="area_value"><em class="value">5명</em></span>
																	<span class="bar"></span>
																</span>
															</span>
															<span class="label">3점</span>
														</li>
														<li class="item point">
															<span class="bar_blank">
																<span class="wrap_value" style="min-height:0;height: 0%">
																	<span class="area_value"><em class="value">0명</em></span>
																	<span class="bar"></span>
																</span>
															</span>
															<span class="label">2점</span>
														</li>
														<li class="item point">
															<span class="bar_blank">
																<span class="wrap_value" style="min-height:0;height: 3%">
																	<span class="area_value"><em class="value">2명</em></span>
																	<span class="bar"></span>
																</span>
															</span>
															<span class="label">1점</span>
														</li>
													</ul>
												</div>
											</div>

										
										</div>
      
      
      
    	</div>
    
    	<table class="n-table table-row">
							<tbody>
								<tr class="n-same-row">
									<th scope="row">번호</th>
									<td>
                                      <input type="text" class="m-input" name="re_num" value="${re.re_num}" readonly>
									</td>
								</tr>
																						
								<tr>
									<th scope="row">작성자</th>
									<td>
										<input type="text" class="m-input" name="user_id" value="${re.user_id}" readonly>
									</td>
								</tr>							
								
								<tr class="n-same-row">
									<th scope="row">내용</th>
									<td>
										<textarea name="re_content" cols="80" rows="10" class="n-input" readonly>${re.re_content}</textarea>
									</td>
								</tr>
								
									<tr class="n-same-row">
									<th scope="row">사진 첨부
									<img src="${contextPath}/resources/images/camera.png" id="preview">
									</th>
									
									<td>
									
									<div id="image_container">
									<c:forEach var="item" items="${imageFileList}" varStatus="status">				
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이미지${status.count}																
										<input type="hidden" name="originalFileName" value="${item.imageFileName}" />
										<img src="${contextPath}/re_download.do?re_num=${re.re_num}&imageFileName=${item.imageFileName}" />
									</c:forEach>		
									</div>
									
								</td>
									
								</tr>
								
							</tbody>
						</table>
     
    
    
    
    
    
    
    
   </div> 
    
    <div class="content-dis">
      
      <div class="pddt_info_area" id="pddt_info_area">
							
<p class="txt"><span>기본배송</span>결제 마감시간 전에 입금하시면 당일 발송됩니다.</p>
<table class="table_style02" cellpadding="0" cellspacing="0">
	<colgroup>
		<col width="">
		<col width="26.6%">
		<col width="26.6%">
		<col width="26.6%">
	</colgroup>
	<tbody><tr>
		<th>구분</th>
		<th>모니터</th>
		<th>그 외 일반상품</th>
		<th>헤드셋</th>
	</tr>
	<tr>
		<th>CJ대한통운<a href="javascript:window_open('../delivery_info/delivery.htm','940','600','scrollbars=no','');" class="ico_n_win"></a></th>
		<td>오후 5시 30분까지 결제하면<br><b>당일발송</b></td>
		<td rowspan="4" class="last">오후 4시까지 결제하면<br><b>당일발송</b></td>
		<td rowspan="4" class="last">오후 4시까지 결제하면<br><b>당일발송</b></td>
	</tr>
	<tr>
		<th>한진택배<a href="javascript:window_open('../delivery_info/delivery.htm','940','600','scrollbars=no','');" class="ico_n_win"></a></th>
		<td>오후 5시까지 결제하면<br><b>당일발송</b></td>
	</tr>
	<tr>
		<th>롯데택배<a href="javascript:window_open('../delivery_info/delivery.htm','940','600','scrollbars=no','');" class="ico_n_win"></a></th>
		<td>오후 5시까지 결제하면<br><b>당일발송</b></td>
	</tr>
	<tr>
		<th class="last">경동화물<a href="javascript:window_open('../delivery_info/delivery_kdexp.htm','940','600','scrollbars=no','');" class="ico_n_win"></a><br><span>(플래티늄 회원 전용)</span></th>
		<td class="last">오후 4시까지 결제하면<br><b>2일 이내 도착</b></td>
	</tr>
</tbody></table>
<p class="txt" style="margin-top: 60px;"><span>빠른배송</span>결제 마감시간 전에 입금하시면 당일 받으실 수 있습니다.</p>
<table class="table_style02" cellpadding="0" cellspacing="0">
	<colgroup>
		<col width="">
		<col width="20%">
		<col width="20%">
		<col width="20%">
		<col width="20%">
	</colgroup>
	<tbody><tr>
		<th>구분</th>
		<th>모니터</th>
		<th>마우스</th>
		<th>그 외 일반상품</th>
		<th>헤드셋</th>
	</tr>
	<tr>
		<th>당일택배<a href="javascript:window_open('../delivery_info/delivery_sameday.htm','940','600','scrollbars=no','');" class="ico_n_win"></a><br><span>(서울,경기 일부지역)</span></th>
		<td>① 오전 10시까지 결제하면<br><b>오후 5시까지 도착</b><br> ② 낮 12시까지 결제하면<br><b>오후 10시까지 도착</b><br> ※ (OS설치 요청 시 예외)</td>
		<td colspan="2">오전 10시까지 결제하면<b>&nbsp;오후 10시까지 도착</b><br> ※ (OS설치 요청 시 예외)</td>
		<td>오전 10시까지 결제하면<br><b>오후 10시까지 도착</b><br>※ (OS설치 요청 시 예외)</td>
	</tr>
	<tr>
		<th>방문수령<a href="javascript:window_open('../delivery_info/delivery_visits.htm','940','600','scrollbars=no','');" class="ico_n_win"></a><br><span>(용산점, 가산점)</span></th>
		<td colspan="2">오후 5시 30분까지 결제하면<br><b>당일수령</b></td>
		<td colspan="2">오후 3시까지 결제하면<br><b>당일수령</b></td>
	</tr>
	<tr>
		<th class="last">퀵서비스<a href="javascript:window_open('../delivery_info/delivery_quick.htm','940','600','scrollbars=no','');" class="ico_n_win"></a><br><span>(서울,경기 일부지역)</span></th>
		<td class="last" colspan="2">오후 5시 30분까지 결제하면<br><b>3시간 30분 이내 도착</b></td>
		<td class="last" colspan="2">오후 4시까지 결제하면<br><b>3시간 30분 이내 도착</b></td>
	</tr>
</tbody></table>
<p class="txt" style="margin-top: 60px;"><span>배송 특이사항</span></p>
<div class="txt_box">
	<span class="co_red"></span>
	- 도서산간지역은 2~3일 추가 소요됩니다.<br>
	- 일요일, 공휴일은 배송되지 않습니다.
</div>           
      
     
      
      
     </div>
   </div> 
   
    <div class="content-dis">
    	  <div class="pddt_info_area" id="pddt_info_area">
    	  
    	  <h2 style="margin-top: 60px;">교환/환불 문의정보<span class="btnSmall btnGray" style="margin: 6px 0 0 8px;"></span></h2>
<table class="table_style02" cellpadding="0" cellspacing="0">
	<colgroup>
		<col width="30%">
		<col width="">
	</colgroup>
	<tbody><tr>
		<th>교환/환불 신청기준</th>
		<td>
			- 제품 수령 후 7일 이내에 교환/환불을 신청하실 수 있습니다.<br>
			- 제품포장상태(박스, 내용물등)이 완벽해야 하며 제품 발송시 동봉해드린 영수증이 있으셔야 합니다.<br>
			-교환 및 환불에 소요되는 운송비는 고객분께서 부담하셔야 됩니다. (색상 교환, 사이즈 교환, 모델 변경 등 포함)<br><br>
			<span class="co_red">※ 하지만 다음의 각 내용에 해당하는 경우에는 교환/환불 신청이 받아들여지지 않을 수 있습니다.</span><br><br>
			1) 소비자의 책임 있는 사유로 상품 등이 멸실/훼손된 경우 (상품 확인을 위한 포장 훼손 제외)<br>
			2) 소비자의 사용/소비에 의해 상품 등의 가치가 현저히 감소한 경우<br>
			3) 시간의 경과에 의해 재판매가 곤란할 정도로 상품 등의 가치가 현저히 감소한 경우<br>
			4) 복제가 가능한 상품 등의 포장을 훼손한 경우
		</td>
	</tr>
	<tr>
		<th>A/S 운송비</th>
		<td>
			- 제품 수령 후 7일 이내 제품불량 발생시 교환이나 환불에 필요한 운송비를 전액(왕복) 컴퓨존에서 부담<br>
			- 제품 수령 후 7일 이상 30일 이내에 제품불량 발생시 교환에 필요한 운송비는 반액(편도) 컴퓨존에서 부담<br>
			- 고객 변심에 의해 반품하는 경우 운송비는 전액 고객이 부담해야 합니다<br><br>
			<span class="co_red">※ 컴퓨존에서 부담하는 운송비는 CJ대한통운, 한진택배, 롯데택배를 이용하는 경우에만 적용되며, 다른 운송방법을 이용하는 경우 운송비는 고객이 부담해야 됩니다.</span>
		</td>
	</tr>
	<tr>
		<th>상품 하자문의 및 기타 기준 사항</th>
		<td>
			- 사용 중 발생한 하자의 환불/교환 등은 '공정거래위원회 소비자분쟁해결기준'에 준하여 처리됩니다.<br>
			- 미성년자가 법정대리인의 동의 없이 구매계약을 체결한 경우, 미성년자와 법정대리인은 구매계약을 취소할 수 있습니다.
		</td>
	</tr>
	<tr>
		<th class="last">주의사항</th>
		<td class="last">
			- 품질 경영 및 공산품안전관리법에 의거하여 안전검사대상공산품이나 어린이 보호포장대상 공산품을 구매하실 경우에는 안전검사를 받은 제품이거나<br>어린이 보호포장 적용제품인지를 확인하시기 바랍니다.<br>
			- 전기용품안전관리법 및 전기통신기본법, 전파법에 의거하여 인증 대상 상품을 구매하실 경우, 안전인증 또는 형식승인,<br>전자파적합등록 제품인지 여부를 확인하시기 바랍니다.
		</td>
	</tr>
</tbody></table>						</div>
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  </div>
    
    
   </div>
	
	

	

			

</div>
</div>
</section>
	<!-- Container End -->

<!--============================
=            Footer            =
=============================-->


</body>

</html>
<input type="hidden" name="isLogOn" id="isLogOn" value="${isLogOn}"/>


