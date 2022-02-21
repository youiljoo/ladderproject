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
        <form action = "${contextPath }/adminUpdate.do" onsubmit = "return falseCheck()">
        <input type="hidden" id="user_id" name="user_id" value="${Details.user_id}" />
            <div class="order_list21">
            	
						<div class="title_wrap">
							<h2 class="tit_txt" style="text-align:center">회원 상세 정보</h2>
						</div>
						<div class="listTable21">
							<table border="0" cellspacing="0" cellpadding="0" width="100%" class="myP_Ttype1">
								<colgroup>
									<col width="30%">
									<col width="70%">
								</colgroup>
								<thead>
									<tr><th>아이디</th><td>${Details.user_id }</td></tr>
									<tr><th>이름</th><td>${Details.user_name }</td></tr>
									<tr><th>닉네임</th><td>${Details.nickname }</td></tr>
									<tr><th>연락처</th><td>${Details.user_phone }</td></tr>
									<tr><th>이메일</th><td>${Details.user_email }</td></tr>
									<tr><th>가입일</th><td>${Details.user_date }</td></tr>
									<tr><th>권한</th>
											<td>
  												<select id = "authority" name="authority" >
    												<option value="일반">일반</option>
    												<option value="관리자">관리자</option>
  												</select>
											</td></tr>
									</thead>
								<tbody>
									
										
									</tr>
									
								</tbody>
								
							</table>
							
						</div><br><br>
						<div class="div-2">
						<a class="myP_SWbtn" href="${contextPath }/admindelete.do?user_id=${Details.user_id}">회원 강제 탈퇴</a>
						</div>
						
						<div class="div-1">
						<br><br>
						<button type="submit" class="btn btn-outline-dark">변경하기</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-outline-dark" onclick="location='admin_member.do'">취소하기</button>					</div>
        				</div>
        </form></main>
</div>
</section>
    </div>
 
</body>
</html>

 