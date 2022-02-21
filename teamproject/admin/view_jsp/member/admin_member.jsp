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

<script>
	var result = '${result}';
	if(result === 'removeTrue') {
		alert("탈퇴가 완료되었습니다.");
	}
</script>

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
							<h2 class="tit_txt" style="text-align:center">회원 관리</h2>
						</div>
						<div class="listTable21">
							<table border="0" cellspacing="0" cellpadding="0" width="100%" class="myP_Ttype1">
								<colgroup>
									<col width="20%">
									<col width="20%">
									<col width="20%">
									<col width="20%">
									<col width="20%">
								</colgroup>
								<thead>
									<tr><th>아이디</th>
									<th>연락처</th>
									<th>이메일</th>
									<th>회원 권한</th>
									<th>상세보기</th>
								</tr></thead>
								<c:forEach var="item" items="${admin }" varStatus="i">
								<tbody>
									<tr><td>${item.user_id }</td>
									<td>${item.user_phone }</td>
									<td>${item.user_email }</td>
									<td>${item.authority }</td>
									<td><a class="myP_SWbtn" href="${contextPath}/admin_member_de.do?user_id=${item.user_id}">상세보기</a></td>				
									</tr>
									
								</tbody>
								</c:forEach>
							</table>							
							
							<div class="div-1">
										<div class="search">
  											<select id="searchType" name="searchType" >
    											<option value="i"<c:out value="${memberList.searchType eq 'i' ? 'selected' : '' }"/>>아이디</option>
    											<option value="p"<c:out value="${memberList.searchType eq 'p' ? 'selected' : '' }"/>>연락처</option>
    											<option value="e"<c:out value="${memberList.searchType eq 'e' ? 'selected' : '' }"/>>이메일</option>
  											</select>
  											 <input type="text" name="keyword" id="keywordInput" value="${memberList.keyword }" placeholder="내용" >
  											 <button id = "searchBtn" type="button">검색</button>
  											 <script>
  											 	$(function(){
  											 		$('#searchBtn').click(function(){
  											 			self.location = "admin_member.do" + '${paging.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
  											 		});
  											 	});
  											 </script>
										</div>
										
										<div class="admin_member_page">
										<ul class="paging">
											<c:if test="${paging.prev }">
												<span><a href='<c:url value="/admin_member.do?page=${paging.startPage-1 }"/>'>이전</a></span>
											</c:if>
											<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="num">
												<span><a href='<c:url value="/admin_member.do?page=${num }" />'>${num }</a></span>
											</c:forEach>
											<c:if test="${paging.next && paging.endPage>0 }">
												<span><a href='<c:url value="/admin_member.do?page=${paging.endPage+1 }"/>'>다음</a></span>
											</c:if>
										</ul>
										</div>
										
												
										<h1>${message }</h1>
										<h1>${message_2 }</h1>
							</div>
						</div>
					</div>
        </main>
</div>
</section>
    </div>
 
</body>
</html>

 