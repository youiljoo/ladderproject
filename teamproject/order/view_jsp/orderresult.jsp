<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	 isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- header -->
<!DOCTYPE html>
<html>
<head> 
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/orderresult.css">
</head>
<body>
  <div class="sadari_section" id="container">
        <div class="wrapper">
            <div class="buy_end__content">
                <div class="buy_end__info">
                    <div class="info__title">
                        <i class="sadariIcon sadariIcon-line-as_register"></i>
                        주문이 완료되었습니다.
                    </div>
			<c:forEach var="item" items="${myOrderList }">
			<c:set var="memordernum"  value="${item.memordernum}"  />
				<c:set var="totalprice"  value="${item.totalprice}"  />
				<c:set var="mempayment"  value="${item.mempayment}"  />
			   </c:forEach> 
                <!--  배송정보  -->
                <div class="buy_end__delivery">
                    <div class="buy_end__title"> 
                        <p class="title__name">배송정보</p>
                    </div>
                    <ul class="buy_end__list">  
                        <li>
                            <div class="item__title">받으시는 분</div>
                            <div class="item__data">${myOrderInfo.memsqname }</div>
                        </li>
                        <li>
                            <div class="item__title">배송지 주소</div>
                            <div class="item__data">${myOrderInfo.memsqaddr }</div>
                        </li>
                        <li>
                            <div class="item__title">휴대전화</div>
                            <div class="item__data">${myOrderInfo.memsqphonenum }</div>
                        </li>
                        <li>
                            <div class="item__title">배송시 요청사항</div>
                            <div class="item__data">${myOrderInfo.delivery_message }</div>
                        </li>
                    </ul>
                </div>

                <!-- 결제정보  -->
                <div class="buy_end__order">
                    <div class="buy_end__title">
                        <p class="title__name">결제정보</p>
                    </div>
                    <ul class="buy_end__list">
                        <li>
                            <div class="item__title">주문번호</div>
                            <div class="item__data">${memordernum}</div>
                        </li>
                        <li>
                            <div class="item__title">결제금액</div>
                            <div class="item__data">${totalprice}원</div>
                        </li>
                        <li>
                            <div class="item__title">결제방법</div>
                            <div class="item__data">${mempayment}</div>
                        </li>


                                                <!-- * 현금 결제 .todo -->
                        <li>
                            <div class="item__title">입금계좌</div>
                            <div class="item__data">546481115484 / NH농협</div>
                        </li>
                        <li>
                            <div class="item__title">예금주</div>
                            <div class="item__data">사다리컴</div>
                        </li>
 						 </ul>
                                        </div>
                                     
                </div>
                <!-- * 버튼 .todo -->
                <div class="buy_end__button">
                    <form action="/shop/mypage/myp_jumun.htm?mode=jumun" name="GoOrderView" method="post">
                        <input type="hidden" name="order_code" value="2201051606">
                        <input type="hidden" name="order_password" value="">
                        <input type="hidden" name="member_yn" value="N">
                        <input type="hidden" name="no_member_direct" value="">
                        <input type="submit" value="주문내역 보기">
                        <a href="/">쇼핑 계속하기</a>
                    </form>
                </div>

            </div>
        </div>
    </div>
</body>
</html>

