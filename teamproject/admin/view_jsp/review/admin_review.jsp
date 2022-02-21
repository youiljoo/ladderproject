<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="utf-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="goods" value="${goodsMap.goodsVO}" />
<c:set var="imageList" value="${goodsMap.imageList}" />
<!-- header -->
<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mypage.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
	.div-1{
		padding : 25px;
		margin: 0 auto;
		display:block;
		text-align : center;
	}
</style>
</head>
<body>
	<!-- contents -->
	<div id="contents">
		<!-- 관리자 페이지 -->
		<section class="flex-center3">
			<div>
				<div class="myP_left">
					<ul class="my_gnb">
						<li class="depth1"><a class="depth1_b_m"
							href="${contextPath}/admin_main.do">관리자 페이지</a>
							<ul>
								<li><a href="${contextPath}/admin_member.do">회원 관리</a></li>
								<li><a href="${contextPath}/admin_order.do">주문 관리</a></li>
								<li><a href="${contextPath}/admin_prod.do">상품 관리</a></li>
								<li><a href="${contextPath}/admin_review.do">후기 관리</a></li>
								<li><a href="${contextPath}/admin_board_main.do">게시판 관리</a></li>
							</ul></li>
					</ul>
				</div>
				<main>
					<div class="title_wrap">
						<h2 class="tit_txt">관리자 페이지</h2>
					</div>
					<hr>

					<div class="order_list21">

						<div class="title_wrap">
							<h2 class="tit_txt" style="text-align: center">후기 관리</h2>
						</div>
						<div class="listTable21">
							<table border="0" cellspacing="0" cellpadding="0" width="100%"
								class="myP_Ttype1">
								<colgroup>
									<col width="30%">
									<col width="40%">
									<col width="30%">									
								</colgroup>
								<thead>
									<tr>
										<th>상품명</th>
										<th>내용</th>
										<th>작성자</th>										
									</tr>
								</thead>
								<c:forEach items="${list}" var="list" varStatus="p">
											<tbody>
												<tr><td>${list.productName}</td>
												<td><a class='cls1' href="${contextPath}/admin_review_re.do?re_num=${list.re_num}">${list.re_content}</a></td>
												<td>${list.user_id}</td>													
												</tr>
											</tbody>
								</c:forEach>
							</table>
							
							<div class="div-1">				
  <div class="search">
    <select name="searchType" id="searchType">
      <option value="p"<c:out value="${reviewList.searchType eq 'p' ? 'selected' : ''}"/>>상품명</option>    
      <option value="c"<c:out value="${reviewList.searchType eq 'c' ? 'selected' : ''}"/>>내용</option> 
      <option value="i"<c:out value="${reviewList.searchType eq 'i' ? 'selected' : ''}"/>>작성자</option>  
   </select>

    <input type="text" name="keyword" id="keywordInput" value="${reviewList.keyword}" placeholder="검색어를 입력하세요" />

    <button id="searchBtn" type="button">검색</button>
	<script>
      $(function(){
        $('#searchBtn').click(function() {
          self.location = "admin_review.do" + '${paging.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });
      });   
    </script>   
  </div>
					
	
	
	<div class="board_page">	
		<ul class="paging">
    		<c:if test="${paging.prev}">
        		<span><a href="${contextPath}/admin_review.do?page=${paging.startPage-1}">이전</a></span>
    		</c:if>
    		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
    		
        		<span><a href="${contextPath}/admin_review.do?page=${num}">${num}</a></span>
        		
    		</c:forEach>
    		<c:if test="${paging.next && paging.endPage>0}">
        		<span><a href="${contextPath}/admin_review.do?page=${paging.endPage+1}">다음</a></span>
    		</c:if>
       </ul>
       
         </div>   
                        	
		</div>
		

							
							
							
						</div>

						
					</div>
				</main>
			</div>
		</section>
	</div>
</body>
</html>

