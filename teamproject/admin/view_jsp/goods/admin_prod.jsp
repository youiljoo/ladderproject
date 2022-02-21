<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  pageEncoding="utf-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- header -->
<!DOCTYPE html>
<html>
<head>
  
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mypage.css">
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/board.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
	.div-1{
		padding : 20px;
		margin: 0 auto;
		display:block;
		text-align : center;
	}
	
	.div-2{		
		padding : 15px;
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
							<h2 class="tit_txt" style="text-align:center">상품관리</h2>
						</div>
						
						<div class="listTable21">				
							<table border="0" cellspacing="0" cellpadding="0" width="100%" class="myP_Ttype1">
								<colgroup>
									<col width="10%">
									<col width="20%">
									<col width="20%">
									<col width="13%">
									<col width="13%">
									<col width="13%">
									<col width="13%">
								</colgroup>
								<thead>
									<tr>
									<th>상품번호</th>
									<th>상품명</th>
									<th>카테고리</th>
									<th>판매가</th>
									<th>재고</th>
									<th>상품등록일</th>
									<th>상세보기</th>
									</tr>
								</thead>
				
			<c:choose>
				<c:when test="${empty list}">
					 <tr  height="400">
     					 <td colspan="4">
         					<p align="center">
           						 <b><span style="font-size:11pt;">등록된 상품이 없습니다.</span></b>
       						</p>
      					</td>  
    				</tr>
  				</c:when>
  			<c:otherwise>
				
			<c:forEach items="${list}" var="list">					
								
								<tbody>
									<tr>
									<td><c:out value="${list.productNum}" /></td>
									<td><c:out value="${list.productName}" /></td>
									<td><c:out value="${list.category}" /><c:out value="${list.subcategory}" /></td>
									<td><c:out value="${list.productPrice}" /></td>
									<td><c:out value="${list.productStock}" /></td>
									<td><c:out value="${list.productDate}" /></td>
									<td><button class="myP_SWbtn" onclick="location='admin_prod_de.do?productNum=${list.productNum}'">상세보기</button></td>
									</tr>
								</tbody>
							</c:forEach>
							</c:otherwise>
							</c:choose>	
							</table>																
							<div class="div-2">
							<button class="myP_SWbtn"onclick="location='admin_prod_add.do'">상품 등록</button>
							</div>
							
							<form role="form" method="get">	
  <div>
            
             <div class="search">
    <select name="searchType" id="searchType">
      <option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>선택</option>
      <option value="a"<c:out value="${scri.searchType eq 'a' ? 'selected' : ''}"/>>상품명</option>
      <option value="b"<c:out value="${scri.searchType eq 'b' ? 'selected' : ''}"/>>카테고리</option>
      <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>판매가</option>
      <option value="d"<c:out value="${scri.searchType eq 'd' ? 'selected' : ''}"/>>재고</option>
   </select>

    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}" placeholder="검색어를 입력하세요" />
    <input type="image"  name="search" width="20" height="20" class="btn1"  src= "${contextPath}/resources/images/icon1.png" >

    <button id="searchBtn" type="button">검색</button>
	<script>
      $(function(){
        $('#searchBtn').click(function() {
          self.location = "admin_prod.do" + '${paging.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });
      });   
    </script>   
  </div>
               
          <div class="board_page">	
		<ul class="paging">
    		<c:if test="${paging.prev}">
        		<span><a href="${contextPath}/admin_prod.do?page=${paging.startPage-1}">이전</a></span>
    		</c:if>
    		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
    		
        		<span><a href="${contextPath}/admin_prod.do?page=${num}">${num}</a></span>
        		
    		</c:forEach>
    		<c:if test="${paging.next && paging.endPage>0}">
        		<span><a href="${contextPath}/admin_prod.do?page=${paging.endPage+1}">다음</a></span>
    		</c:if>
       </ul>
       
            
                        	
		</div>     
             
        </div>
</form>					
							
										
						</div>
						
						
						
        </main>
</div>
</section>
    </div>
</body>
</html>

 