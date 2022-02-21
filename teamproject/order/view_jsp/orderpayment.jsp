<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	 isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- header -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/orderpayment.css">

  

	
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<script>
/* 유효성 검사 통과유무 변수 */
var nameCheck = false;            // 이름

//F5 새로고침 막기
document.onkeydown = function(e){
	 if(!e) e = window.event;
	 if (e.keyCode == 116){
	  if( confirm("새로 고침 하시겠습니까?") ){
	  }else{
	   e.keyCode = 0;
	   return false; 
	  }
	 }
	} 



    function payment() {
    	var r_mempayment  =  document.form_order.mempayment;
    	for(var i=0; i<r_mempayment.length;i++){
    	  if(r_mempayment[i].checked==true){
    		  mempayment2=r_mempayment[i].value
                
                
                if(mempayment2 =="통합결제"){
                	var i_order_name=document.getElementById("order_name");
                	var i_order_phone=document.getElementById("order_phone");
                	var i_order_email=document.getElementById("order_email");
                	var i_zipcode=document.getElementById("zipcode");
                	var i_roadAddress=document.getElementById("roadAddress");
                	var i_jibunAddress=document.getElementById("jibunAddress");
                	var i_namujiAddress=document.getElementById("namujiAddress");
                	var i_memsqname=document.getElementById("memsqname");
                	var i_memsqphonenum=document.getElementById("memsqphonenum");
                	var i_delivery_message=document.getElementById("delivery_message");
                	var i_totalprice=document.getElementById("totalprice");
                	var r_mempayment  =  document.form_order.mempayment;
                	for(var i=0; i<r_mempayment.length;i++){
                	  if(r_mempayment[i].checked==true){
                		  mempayment=r_mempayment[i].value
                		  break;
                	  }
                	}
                	  
                	memsqaddr="우편번호:&nbsp;"+i_zipcode.value+"<br>"+
                	"도로명 주소:"+i_roadAddress.value+"<br>"+
                	"[지번 주소:"+i_jibunAddress.value+"]<br>"+
                			  i_namujiAddress.value;
                	
                	order_name=i_order_name.value; 
                	order_phone=i_order_phone.value;
                	order_email=i_order_email.value;
                	memsqname=i_memsqname.value; 
                	memsqphonenum=i_memsqphonenum.value;
                	delivery_message=i_delivery_message.value;
                	totalprice=i_totalprice.value;
                	zipcode=i_zipcode.value;
                	roadAddress=i_roadAddress.value;
                	namujiAddress=i_namujiAddress.value;
                	
                	if(order_name == "") {
                		alert("주문자명을 입력해주세요.");
                		name.foucs();
                	}
                	else if(order_phone == "") {
                		alert("주문자 전화번호를 입력해주세요.");
                		order_phone.foucs();
                	}
                	else if(zipcode == "") {
                		alert("주소를 입력해주세요.");
                		zipcode.foucs(); 
                	}
                	else if(roadAddress == "") {
                		alert("주소를 입력해주세요.");
                		roadAddress.foucs();
                	}
                	else if(namujiAddress == "") {
                		alert("상세 주소를 입력해주세요.");
                		namujiAddress.foucs();
                	}
                	else if(memsqname == "") {
                		alert("받는사람을 입력해주세요.");
                		memsqname.foucs();
                	}
                	else if(memsqphonenum == "") {
                		alert("받는사람 전화번호를 입력해주세요.");
                		memsqphonenum.foucs();
                	}
                	  iamport();
                	
                } 
                else{
                	var i_order_name=document.getElementById("order_name");
                	var i_order_phone=document.getElementById("order_phone");
                	var i_order_email=document.getElementById("order_email");
                	var i_zipcode=document.getElementById("zipcode");
                	var i_roadAddress=document.getElementById("roadAddress");
                	var i_jibunAddress=document.getElementById("jibunAddress");
                	var i_namujiAddress=document.getElementById("namujiAddress");
                	var i_memsqname=document.getElementById("memsqname");
                	var i_memsqphonenum=document.getElementById("memsqphonenum");
                	var i_delivery_message=document.getElementById("delivery_message");
                	var i_totalprice=document.getElementById("totalprice");
                	var r_mempayment  =  document.form_order.mempayment;
                	for(var i=0; i<r_mempayment.length;i++){
                	  if(r_mempayment[i].checked==true){
                		  mempayment=r_mempayment[i].value
                		  break;
                	  }
                	}
                	  
                	memsqaddr="우편번호:&nbsp;"+i_zipcode.value+"<br>"+
                	"도로명 주소:"+i_roadAddress.value+"<br>"+
                	"[지번 주소:"+i_jibunAddress.value+"]<br>"+
                			  i_namujiAddress.value;
                	
                	order_name=i_order_name.value; 
                	order_phone=i_order_phone.value;
                	order_email=i_order_email.value;
                	memsqname=i_memsqname.value; 
                	memsqphonenum=i_memsqphonenum.value;
                	delivery_message=i_delivery_message.value;
                	totalprice=i_totalprice.value;
                	zipcode=i_zipcode.value;
                	roadAddress=i_roadAddress.value;
                	namujiAddress=i_namujiAddress.value;
                	
                	if(order_name == "") {
                		alert("주문자명을 입력해주세요.");
                		name.foucs();
                	}
                	else if(order_phone == "") {
                		alert("주문자 전화번호를 입력해주세요.");
                		order_phone.foucs();
                	}
                	else if(zipcode == "") {
                		alert("주소를 입력해주세요.");
                		zipcode.foucs(); 
                	}
                	else if(roadAddress == "") {
                		alert("주소를 입력해주세요.");
                		roadAddress.foucs();
                	}
                	else if(namujiAddress == "") {
                		alert("상세 주소를 입력해주세요.");
                		namujiAddress.foucs();
                	}
                	else if(memsqname == "") {
                		alert("받는사람을 입력해주세요.");
                		memsqname.foucs();
                	}
                	else if(memsqphonenum == "") {
                		alert("받는사람 전화번호를 입력해주세요.");
                		memsqphonenum.foucs();
                	}
                	fn_process_pay_order();
                }
                }
    
        }
    }

    	function iamport(){
    		var totalprice1 = document.getElementById('totalprice').value;
    		var name = document.getElementById('order_name').value; 
    		var tel =  document.getElementById('order_phone').value; 
    		var post =  document.getElementById('zipcode').value;  
    		var adr =  document.getElementById('roadAddress').value;
    		//가맹점 식별코드
    		IMP.init('imp71762399');  
    		IMP.request_pay({
    		    pg : 'html5_inicis',
    		    pay_method : 'card',
    		    merchant_uid : 'merchant_' + new Date().getTime(),
    		    name : '사다리컴 결제' , //결제창에서 보여질 이름 
    		    amount : totalprice1 , // 실제 결제되는 가격
    		    buyer_name : order_name, 
    		    buyer_tel : order_phone, 
    		    buyer_addr : roadAddress,
    		    buyer_postcode : post
    		}, function(rsp) {
    			console.log(rsp);
    		    if ( rsp.success ) {
    		    	var msg = '결제가 완료되었습니다.';
    		        msg += '고유ID : ' + rsp.imp_uid;
    		        msg += '상점 거래ID : ' + rsp.merchant_uid;
    		        msg += '결제 금액 : ' + rsp.paid_amount;
    		        msg += '카드 승인번호 : ' + rsp.apply_num;
    		        fn_process_pay_order();
    		    } else {
    		    	 var msg = '결제에 실패하였습니다.';
    		         msg += '에러내용 : ' + rsp.error_msg;
    		    }
    		    alert(msg);
    		});
    	} 

    	</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script type="text/javascript" charset="UTF-8">
function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 도로명 조합형 주소 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
            if(fullRoadAddr !== ''){
                fullRoadAddr += extraRoadAddr;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('roadAddress').value = fullRoadAddr;
            document.getElementById('jibunAddress').value = data.jibunAddress;
            
	
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                //예상되는 도로명 주소에 조합형 주소를 추가한다.
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

            } else { 
            	self.close()  
            }
            
        }
    
    }).open();

}
	



function fromBtn() {


		var name = document.getElementById('order_name').value; 
		var tel =  document.getElementById('order_phone').value; 

		$("#memsqname").val(name);
		$("#memsqphonenum").val(tel);

	}
	


//결제 하기
function fn_process_pay_order(){	

	var i_order_name=document.getElementById("order_name");
	var i_order_phone=document.getElementById("order_phone");
	var i_order_email=document.getElementById("order_email");
	var i_zipcode=document.getElementById("zipcode");
	var i_roadAddress=document.getElementById("roadAddress");
	var i_jibunAddress=document.getElementById("jibunAddress");
	var i_namujiAddress=document.getElementById("namujiAddress");
	var i_memsqname=document.getElementById("memsqname");
	var i_memsqphonenum=document.getElementById("memsqphonenum");
	var i_delivery_message=document.getElementById("delivery_message");
	var i_totalprice=document.getElementById("totalprice");
	var r_mempayment  =  document.form_order.mempayment;
	for(var i=0; i<r_mempayment.length;i++){
	  if(r_mempayment[i].checked==true){
		  mempayment=r_mempayment[i].value
		  break;
	  }
	}
	  
	memsqaddr="우편번호:&nbsp;"+i_zipcode.value+"<br>"+
	"도로명 주소:"+i_roadAddress.value+"<br>"+
	"[지번 주소:"+i_jibunAddress.value+"]<br>"+
			  i_namujiAddress.value;
	
	order_name=i_order_name.value; 
	order_phone=i_order_phone.value;
	order_email=i_order_email.value;
	memsqname=i_memsqname.value; 
	memsqphonenum=i_memsqphonenum.value;
	delivery_message=i_delivery_message.value;
	totalprice=i_totalprice.value;
	zipcode=i_zipcode.value;
	roadAddress=i_roadAddress.value;
	namujiAddress=i_namujiAddress.value;

 
	
	var formObj=document.createElement("form"); 
	
	var i_order_name=document.createElement("input");
	var i_order_phone=document.createElement("input");
	var i_order_email=document.createElement("input");
	var i_memsqname=document.createElement("input");
    var i_memsqphonenum=document.createElement("input");
    var i_memsqaddr=document.createElement("input");
	var i_delivery_message=document.createElement("input");
	var i_totalprice=document.createElement("input");
	var i_mempayment=document.createElement("input");
   
	i_order_name.name="order_name";
	i_order_phone.name="order_phone";
	i_order_email.name="order_email";
    i_memsqname.name="memsqname";
    i_memsqphonenum.name="memsqphonenum"; 
    i_memsqaddr.name="memsqaddr";
	i_delivery_message.name="delivery_message";
	i_totalprice.name="totalprice";
	i_mempayment.name="mempayment";
    
	i_order_name.value=order_name;
	i_order_phone.value=order_phone;
	i_order_email.value=order_email;
    i_memsqname.value=memsqname; 
    i_memsqphonenum.value=memsqphonenum;
    i_memsqaddr.value=memsqaddr;
    i_delivery_message.value=delivery_message;
    i_totalprice.value=totalprice;
    i_mempayment.value=mempayment;
	
    formObj.appendChild(i_order_name);
    formObj.appendChild(i_order_phone);
    formObj.appendChild(i_order_email);
    formObj.appendChild(i_memsqname);
    formObj.appendChild(i_memsqphonenum);
    formObj.appendChild(i_memsqaddr);
    formObj.appendChild(i_delivery_message);
    formObj.appendChild(i_totalprice);
    formObj.appendChild(i_mempayment);
    
    document.body.appendChild(formObj); 
    formObj.method="post";
    formObj.action="${contextPath}/payToOrderGoods.do"
    	
    formObj.submit();
}
</script>

</head>
<body>
   <form  name="form_order" accept-charset="utf-8" >
    <!-- 주문결제페이지 -->
  <div class="simpWrap21">
					<div class="cartWrap">
						<div class="simpOrder21 simp_bsk21">
							<div class="simp_titWrap">
								<h1>주문결제</h1>
							</div>
						</div>		
						<div class="cartContent">
					
        <div class="around_list">
			<ul class="around_top">
				<li class="a01">주문제품 정보</li>
				<li class="a02">구매수량</li>
				<li class="a03">합계(원)</li>
			</ul>
					<c:forEach var="item" items="${myOrderList}">
						<div id=around_bot>			
						<ul class="around_bot">
 
				<li class="a01">
				<ul class="ul01">
						 <a href="${contextPath}/prodetail.do?productNum=${item.productNum }">
					    <img width="100"   src="${contextPath}/thumbnails.do?productNum=${item.productNum}&category=${item.category}&fileName=${item.originFileName}">
					    <input   type="hidden" id="h_productNum" name="h_productNum" value="${item.productNum }" />
					    <input   type="hidden" id="h_originFileName" name="h_originFileName" value="${item.originFileName }" />
				</a>
				</ul>
				<ul class="ul02">
				  <a href="${pageContext.request.contextPath}/prodetail.do?productNum=${item.productNum}">${item.productName }</A>
				 	      <input   type="hidden" id="h_productName" name="h_productName" value="${item.productName }" />
					      </ul>
					      </li>
				<li class="a02">
				  ${item.productAmt }개
					    <input   type="hidden" id="h_productAmt" name="h_productAmt" value="${item.productAmt}" />
				</li> 
				<li class="a03">
				${item.productPrice * item.productAmt}원 
					  <input  type="hidden" id="h_each_goods_price"  name="h_each_goods_price" value="${item.productPrice * item.productAmt}" />
				</li>
				</ul>
			</div>
			<c:set var="final_total_order_price"
				value="${final_total_order_price+ item.productPrice * item.productAmt + total_delivery_price}" />
				
				
			<c:set var="total_order_price"
				value="${total_order_price+ item.productPrice* item.productAmt}" />
			<c:set var="total_productAmt"
				value="${total_productAmt + item.productAmt }" />
			</c:forEach>
	
		</div> 

								
						<div class="deliInfo_wrap21 clearfix">
							<div class="deliSimp_left">
								<!-- 주문자 정보 -->
								<div class="simpBx21 simpDeli_Info">
									<div class="simpB_tit">
										<h2>주문자 정보</h2>
									</div>
									<div class="simpB_con conList_wrap">
										<div class="newForm_tr1 clearfix">
											<div class="conS_left">주문자</div>
											<div class="conS_left"> <span class="bskS_input"><input id="order_name" name="order_name" type="text" value="${orderer.user_name}" size="10" /></span></div>
											<input type="hidden" id="order_name" name="order_name" /> 
										</div>

				
												<div class="newForm_tr1 clearfix">
											<div class="conS_left">전화번호</div>
											<div class="conS_left"> <span class="bskS_input"><input  id="order_phone" name="order_phone" type="text" value="${orderer.user_phone}" size="20" /></span></div>
											<input type="hidden" id="order_phone" name="order_phone" /> 
										</div>

										<div class="hp_tr clearfix">
											<div class="conS_left">이메일</div>
											<div class="conS_right">
												<div class="email_wrap">             
													<input type="hidden" name="order_email" id="order_email">                     
													<span class="bskS_input"><input type="text" name="order_email" id="order_email" value="${orderer.user_email }" ></span>
												</div>
											</div>
										</div>
										<div class="clearfix">
											<div class="conS_left ntRB16" style="margin-top:0;">주문처리내역 알림</div>
											<div class="conS_right">
												<div style="margin-top:3px;">
															<span class="bskS_check">
														<input type="checkbox" name="confirm_sms" value="Y"  id="orderUserA3" >
														<label for="orderUserA3" ><i></i>휴대폰</label>
													</span>
													<span class="bskS_check" style="margin-left:45px;">
														<input type="checkbox" name="confirm_email"  id="orderUserA4">
														<label for="orderUserA4"><i></i>이메일</label>
													</span>
												</div>
											</div>
										</div>
				 					</div>
								</div>
								<div class="simpBx21 simpDeli_Info">
									<div class="simpB_tit">
										<h2>배송 정보</h2> 
										<div class="bskS_check orderUserChk">
											<input type="checkbox" value="on" onclick="fromBtn()">
											<label for="orderUserS" class="bskS_chk"><i></i>주문자 정보와 동일</label>
										</div> 
									</div>
									<div class="simpB_con conList_wrap">
										<div class="address_tr clearfix">
											<div class="conS_left">배송지</div>
											<div class="conS_right">
												<div class="bskS_address">
													<input type="text" name="zipcode" id="zipcode" size="5" placeholder="우편번호" disabled> 
													<a href="javascript:execDaumPostcode()" class="bskS_MBtnG">주소 찾기</a>
												</div>
												<span class="bskS_input"><input type="text" id="roadAddress" name="roadAddress" placeholder="도로명" size="45"  disabled/><br></span>
												<span class="bskS_input"> <input type="text" id="jibunAddress" name="jibunAddress" size="50" placeholder="지번"  disabled/></span>
											<span class="bskS_input">   <input type="text" id="namujiAddress"  name="namujiAddress" size="50" placeholder="상세주소"  /> </span>
						 <input type="hidden" id="h_zipcode" name="h_zipcode" value="${orderer.zipcode }" /> 
						 <input type="hidden"  id="h_roadAddress" name="h_roadAddress"  value="${orderer.roadAddress }" /> 
						 <input type="hidden"  id="h_jibunAddress" name="h_jibunAddress" value="${orderer.jibunAddress }" /> 
						 <input type="hidden"  id="h_namujiAddress" name="h_namujiAddress" value="${orderer.namujiAddress }" />
											</div>
										</div>
			<div class="newForm_tr1 clearfix">
											<div class="conS_left">배송요청사항</div>
											<div class="conS_right">
											<span class="bskS_input2">  
						<input id="delivery_message" name="delivery_message" type="text" size="50" /> 
					   <input type="hidden" id="delivery_message" name="delivery_message" /> 
					   </span></div> 
										</div> 
										<div class="newForm_tr1 clearfix">
											<div class="conS_left">받는사람</div>
											<div class="conS_right">
											<span class="bskS_input">
						<input id="memsqname" name="memsqname" type="text" placeholder="이름입력" />
					   <input type="hidden" id="memsqname" name="memsqname" /> 
					   </span></div>
										</div>
										<div class="hp_tr clearfix">
											<div class="conS_left">전화번호</div>
											<div class="conS_right">
												<div class="hp_wrap">
								
													<span class="bskS_input"><input type="text" name="memsqphonenum" id="memsqphonenum"  onkeyup="isNum(this);" autocomplete="off"></span>
												</div>
										<div class="hp_wrap" style="display:none;" id="AddReceiveTelNumber">
											<input type="hidden" id="memsqphonenum" name="memsqphonenum"/> 
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- 결제방법 --><form  name="form_order">	
								<div class="simpBx21 simpOrder_payment"> 
									<div id="payment_title" class="simpB_tit" onclick="toggle_payment();">
										<h2>결제방법</h2>										
									</div>
									<div id="payment_layout" class="simpB_con simpOrder_payCon" style="display:">
										<div class="simpB_conT" style="display:;">																				
											<div id="div_payment" class="select_btnList2 ">
											
											<ul>
											<li>
													<input type="radio" id="mempayment" name="mempayment"  checked value="무통장입금">
								<label for="by_c01" class="btn_payment w50">무통장입금</label> 
	
								</li>
								
								<li> 
								
								<input type="radio" id="mempayment" name="mempayment" value="통합결제" >
								<label for="by_c01" class="btn_payment w50">통합결제</label>
 
  
								</li>  
								
									
													</ul>
												
											</div>	
										
																					</div>
									</div>
								</div>
								<div class="simpBx21 simpOrder_payment">
									<div id="payment_title" class="simpB_tit" onclick="toggle_payment();">
										<h2>최종결제정보</h2>										
									</div>
									<div id="payment_layout" class="simpB_con simpOrder_payCon" style="display:">
										<div class="simpB_conT" style="display:;">																				
											<div id="div_payment" class="select_btnList2 ">
							
											</div>	<table width="80%" class="list_view" style="background:#white">
	<tbody>
	     <tr align="center" class="fixed">
	       <td class="fixed">총 상품수 </td>
	       <td>총 상품금액</td>
	       <td></td>
	       <td>배송비</td>
	       <td></td>
	       <td>최종 결제금액</td>
	     </tr>
		<tr cellpadding="40" align="center">
			<td id="">
			  <p id="p_totalNum">${total_productAmt}개 </p>
			  <input id="h_total_productAmt" type="hidden" value="${total_productAmt}"> 
			</td>
	       <td>
	          <p id="p_totalPrice">${total_order_price}원</p>
	          <input id="h_totalPrice" type="hidden" value="${total_order_price}">
	       </td>
	       <td> 
	          <img width="25" alt="" src="/teamproject/resources/images/plus.png">  
	       </td>
	       <td>
	         <p id="p_totalDelivery">${total_delivery_price}2500원</p>
	         <input id="h_totalDelivery" type="hidden" value="${total_delivery_price}">
	       </td>
	       <td> 
	         <img width="25" alt="" src="/teamproject/resources/images/equal.png"> 
	       </td>
	       <td>  
	         <p id="_totalprice">${final_total_order_price + 2500}원</p>
	         <input id="totalprice" name="totalprice" type="hidden" value="${final_total_order_price + 2500}">
	       </td>
	  
		</tr> 
		</tbody>
	</table> 
																					</div>
									</div>
								</div>
	<div class="buy_go cl_bo">
					<div class="if_mo01"> 
						<span id="pay_btn1">
							  <input  name="btn_process_pay_order" type="button" onClick="javascript:payment()"class="btn_pay1"  value="결제하기">  
						</span>
					</div>   
					<div class="if_mo02"> 
						<span id="pay_btn2">
							 <a href="/teamproject/main.do" class="btn_pay2">취소하기</a>
						</span>
					</div>
				</div>
				</form> 
</div>
 </div>
 </div> 
 </div>
 </div>

 
 </form>
 
 
   
</body>
</html>

