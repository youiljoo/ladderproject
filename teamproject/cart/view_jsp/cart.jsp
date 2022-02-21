<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 


<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="myCartList"  value="${cartMap.myCartList}"  />
<c:set var="myGoodsList"  value="${cartMap.myGoodsList}"  />

<c:set  var="totalGoodsNum" value="0" />  <!-- 주문 개수 -->
<c:set  var="totalDeliveryPrice" value="0" /> <!-- 총 배송비 --> 
<c:set  var="totalDiscountedPrice" value="0" /> <!-- 총 할인금액 -->


<!-- header -->
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/cart.css"> 
 <script type="text/javascript">
 

 
 
   function modify_cart_qty(productNum,index){
	  
	   var length=document.frm_order_all_cart.cartproductAmt.length;
	   var _cartproductAmt=0;
		if(length>1){ //카트에 제품이 한개인 경우와 여러개인 경우 나누어서 처리한다.
			_cartproductAmt=document.frm_order_all_cart.cartproductAmt[index].value;		
		}else{
			_cartproductAmt=document.frm_order_all_cart.cartproductAmt.value;
		}
			
		var cartproductAmt=Number(_cartproductAmt);
	
		$.ajax({
			type : "post",
			async : false, //false인 경우 동기식으로 처리한다.
			url : "${contextPath}/modifyCartQty.do",
			data : {
				productNum:productNum,
				cartproductAmt:cartproductAmt
			},  
			
			success : function(data, textStatus) {
				//alert(data);
				if(data.trim()=='modify_success'){
					alert("수량을 변경했습니다!!");	
				}else{
					alert("다시 시도해 주세요!!");	
				}
				
			},
			error : function(data, textStatus) {
				alert("에러가 발생했습니다."+data);
			},
			complete : function(data, textStatus) {
				//alert("작업을완료 했습니다");
				
			}
		}); //end ajax	
		location.reload(true);
	}
   
   function fn_order_each_goods(productNum,productName,productPrice,originFileName,category){
	  
	 //  var total_price,final_total_price,_productAmt;
		var cartproductAmt=document.getElementById("cartproductAmt");
		
		_productAmt=cartproductAmt.value; //장바구니에 담긴 개수 만큼 주문한다.
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
	    i_productAmt.value=_productAmt;
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

   function selItem() {
	    var total_price = 0;
	    var no = 0;
	    var price = 0;
	    var objForm=document.frm_order_all_cart;
	    var checked_goods=objForm.checked_goods;
	    var length=checked_goods.length;
	   
	    if(length>1){
	    for(var i=0; i<length;i++){
	    	if(checked_goods[i].checked==true){
	            no = checked_goods[i].value;
	            price = document.getElementById("check_price"+ no).value;
	            total_price = total_price + parseInt(price);
	        } 
	    }
	    }
	    else{
	    	if(checked_goods.checked==true){
	    	 	no = checked_goods.value;
	            price = document.getElementById("check_price"+ no).value;
	            total_price = parseInt(price);
	    	}
	    	
	    }
	   
	    
	 
	    $("#p_final_totalPrice").html(total_price);
	}
   
	function fn_order_all_cart_goods(){
//		alert("모두 주문하기");
		var productAmt;
		var order_productNum;
		var objForm=document.frm_order_all_cart;
		var cartproductAmt=objForm.cartproductAmt;
		var checked_goods=objForm.checked_goods;
		var length=checked_goods.length;
		var j=0;
		
	
		if(length>1){ 
			
				for(var i=0;  i<length;i++){
				if(checked_goods[i].checked==true){
					order_productNum=checked_goods[i].value;
					productAmt=cartproductAmt[i].value;
					
					cartproductAmt[i].value="";
					cartproductAmt[i].value=order_productNum+":"+productAmt;
					console.log(cartproductAmt[i].value);
					objForm.method="post";
				 	objForm.action="${contextPath}/orderAllCartGoods.do";
					objForm.submit();
				}
				else { 
					j=j+1; 
					if(j==length){
						alert("주문할 상품을 선택해주세요.");
					}
					
			}	
				 
				}
				
				
		}else if(length=1 && checked_goods.checked==true){
			order_productNum=checked_goods.value;
			productAmt=cartproductAmt.value;
			cartproductAmt.value=order_productNum+":"+productAmt; 
			objForm.method="post";
		 	objForm.action="${contextPath}/orderAllCartGoods.do";
			objForm.submit();
		}	
		else {
			alert("주문할 상품을 선택해주세요.");
		}
	}

   
   function deleteAll_cart_goods(user_id){
	   if(confirm("장바구니 상품을 비우시겠습니까?")){
		   
		var cid=Number(user_id);
		var formObj=document.createElement("form");
		var i_cart = document.createElement("input");
		i_cart.name="user_id";
		i_cart.value=user_id;
		
		formObj.appendChild(i_cart);
	    document.body.appendChild(formObj); 
	    formObj.method="post";
	    formObj.action="${contextPath}/removeAllCartGoods.do";
	    formObj.submit();
	   }
	}
   
   
   function delete_cart_goods(cid){
	   if(confirm("장바구니 상품을 삭제하시겠습니까?")){
		   
		var cid=Number(cid);
		var formObj=document.createElement("form");
		var i_cart = document.createElement("input");
		i_cart.name="cid";
		i_cart.value=cid;
		
		formObj.appendChild(i_cart);
	    document.body.appendChild(formObj); 
	    formObj.method="post";
	    formObj.action="${contextPath}/removeCartGoods.do";
	    formObj.submit();
	   }
	}
   </script>
</head>
<body> 
  <!-- 중간 -->
  <div id="content">
  <div class="cart__text_visual">
        <div class="wrapper">
            <p class="visual__title">장바구니</p>
        </div>
    </div>
    <div class="cart_section">
        <div class="wrapper">
            <!--  장바구니 컨텐츠  -->
            <div class="cart__content">
                <div class="cart__title">
                    <p class="title__name">주문 상품</p>
                </div>

                <!-- 장바구니 리스트 -->
                                <ul class="cart__list"> 
                    
                    
                                        <li class="list__item item--acc">
                        <div class="item__head">
                            <ul class="head__list">
                                <li class="list__item item--product">제품 정보</li>
                                <li class="list__item item--qty">구매수량</li>
                                <li class="list__item item--total">합계(원)</li>
                                <li class="list__item item--etc">-</li>
                            </ul>
                        </div>
                          </li>
                            </ul>
                        	 <c:choose>
				    <c:when test="${ empty myCartList }">
				   <div class="cartempty">
				      
				         <p>장바구니에 상품이 없습니다.</p>
				      </div> 
				    </c:when>
			        <c:otherwise>
			          <form name="frm_order_all_cart">
                                    <c:forEach var="item" items="${myGoodsList}" varStatus="cnt">
                                    <c:set var="final_total_order_price" value="${final_total_order_price + item.productPrice * cartproductAmt}" />
                                      <c:set var="cartproductAmt" value="${myCartList[cnt.count-1].cartproductAmt}" />
				       <c:set var="cid" value="${myCartList[cnt.count-1].cid}" />
				     <c:set var="user_id" value="${myCartList[cnt.count-1].user_id}" />
                        <div class="item__body"> 
              
                            <ul class="item__spec">
                           <li class="item__checkbox"><input type="checkbox" name="checked_goods"  checked value="${item.productNum }" onclick="selItem()">
                                 <input type="hidden" id="check_price${item.productNum}" name="check_price${item.productNum}" value="${item.productPrice*cartproductAmt}"> 
                                 </li>
                      
                                <li class="item__name"> 
					<td class="goods_image">
					<a href="${contextPath}/prodetail.do?productNum=${item.productNum }">
						<img width="80" height ="80" src="${contextPath}/thumbnails.do?productNum=${item.productNum}&category=${item.category}&fileName=${item.originFileName}"  />
					</a>
					</td> 
					
                                    <div class="name--text">
							<a href="${contextPath}/prodetail.do?productNum=${item.productNum }">${item.productName }</a>
                                         </div>
                                </li>
                            
                                <li class="item__price">
                                    <div class="price__qty">
                         
                                        <div class="price--data">
						<input type="text" name="cartproductAmt" id="cartproductAmt" size=3 value="${cartproductAmt}"  class="numadmin">
						<a href="javascript:modify_cart_qty(${item.productNum } ,${cnt.count-1 });" >
										<br><span class="btnadmin" >변경</span>
										</a>
				
                                        </div>
                                        
              
                                        
                                         
                                        
                                    </div>
                                    </li>
                                    <li class="item__total">
                                    <div class="price__total">
                                        <div class="price--data">		
					   <strong>
					    <fmt:formatNumber  value="${ item.productPrice*cartproductAmt}" type="number" var="total_price" />
				         ${total_price}원
					</strong>
					 </div>
                                    </div>
                               </li>
                         
                                <li class="item__button"> 
                                 <a href="javascript:fn_order_each_goods('${item.productNum }','${item.productName }','${item.productPrice}','${item.originFileName}','${item.category}');"> 
                             <button type="button"  class="button button--remove">주문하기</button> </a>
                                	<a href="javascript:delete_cart_goods('${cid}')" > 
					   <button type="button"   class="button button--remove">삭제하기</button>
					   
					   </a>
                            
                                </li>  
                              
                            </ul>
                        </div>
                        <c:set  var="totalGoodsPrice" value="${totalGoodsPrice+ item.productPrice * cartproductAmt }" />
                        				<c:set  var="totalGoodsNum" value="${totalGoodsNum-1 }" />
                               </c:forEach>
                               </form> 
                               </c:otherwise>
                               </c:choose>
                  
    
            
                <!--  장바구니 총 금액  -->
                <div class="cart__total">
                    장바구니 총 결제금액 :
                    <span class="total__price">  
                    </span>
                    <p id="p_final_totalPrice" style="color: #fff;">${totalGoodsPrice}</p>&nbsp;원
                    
                    
                </div>

                <div class="cart__button">
                                            <div class="button__left">
                                             	<a href="javascript:deleteAll_cart_goods('${user_id}')" > 
					   <button type="button" onclick="DelCart();" class="button button--reset">장바구니 비우기</button>
					   </a>
                        </div>
                                        <div class="button__right">
                                                                                    <a href="javascript:fn_order_all_cart_goods()"class="button button--order">주문하기</a>
                                                                            <a href="/teamproject/main.do" class="button button--shopping">쇼핑 계속하기</a>
                    </div>
                </div>
            </div>

        </div>
    </div>
  
  </div> 
 
 </body> 
 </html>
 

<input type="hidden" name="isLogOn" id="isLogOn" value="${isLogOn}"/>