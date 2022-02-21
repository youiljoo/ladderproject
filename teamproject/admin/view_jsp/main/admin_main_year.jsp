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
							<a class="depth1_b_m" href="${contextPath}/adminmain.do" >관리자 페이지</a>
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
							<h1 class="tit_txt" style="text-align:center">관리자님 환영합니다.</h1>
						</div>
						<div class="listTable21">
							<h3>올해 운영 실적</h3>
							<button class="myP_SWbtn"onclick="location='admin_main.do'">오늘운영실적</button>
							<button class="myP_SWbtn"onclick="location='admin_main_month.do'">이달운영실적</button>
							<button class="myP_SWbtn"onclick="location='admin_main_year.do'">올해운영실적</button>
							<br><br>
							
							<table border="0" cellspacing="0" cellpadding="0" width="100%" class="myP_Ttype1">
								<colgroup>
									<col width="25%">
									<col width="50%">
									<col width="25%">									
								</colgroup>
								<thead>
									<thead>
									<tr><th>주문건 수</th><td>10건</td><td>처리완료</td></tr>
									<tr><th>금액</th><td>895,000</td><td> </td></tr>
									<tr><th>가입자 수</th><td>235명</td><td> </td></tr>
									<tr><th>상단건 수</th><td>12건</td><td>미처리5건</td></tr>
									</thead>
								<tbody>
									
								</tbody>
							</table>							
							<br>			
						</div>
						
						<div class="listTable21">
							<h3>공지사항</h3>
							<table border="0" cellspacing="0" cellpadding="0" width="100%" class="myP_Ttype1">								
  								<tr height="10" align="center"  bgcolor="lightgreen">                 
     							<td >제목</td>
     							<td >작성일</td>
  								</tr>
     							<tr align="center">
								<td align='left' width="75%">
	 							<span></span>
                   				<a class='cls1' href="${contextPath}/admin_main_notice.do">[안내]게시판 스팸 대응 요령</a>
								</td>	
								<td align='left'  width="25%">
	  							<span>2021-12-30</span>
	  							</td>
	  							</tr>
	  						</table>							
							<br>			
						</div>										
					</div>
        </main>
</div>
</section>
    </div>
  
</body>
</html>

 