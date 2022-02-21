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
							<h1 class="tit_txt" style="text-align:center">관리자님 환영합니다.</h1>
						</div>
						<div class="listTable21">
							<h3>오늘 운영 실적</h3>
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
									<tr><th>상담건 수</th><td>12건</td><td>미처리5건</td></tr>
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
     							<td >NO</td>
     							<td >제목</td>
     							<td >작성일</td>
  								</tr>
  				
  				<c:choose>
				<c:when test="${empty list}">
					 <tr height="400">
     					 <td colspan="4">
         					<p align="center">
           						 <b><span style="font-size:11pt;">등록된 글이 없습니다.</span></b>
       						</p>
      					</td>  
    				</tr>
  				</c:when>
  				<c:otherwise>
  				
  												 
                           	<c:forEach items="${list}" var="list">			
     					    <tr align="center">
     					    	<td align='left' width="10%">	 							
                   				${list.a_main_NO}
								</td>	
								<td align='left' width="65%">	 							
                   				<a class='cls1' href="${contextPath}/admin_main_notice.do?a_main_NO=${list.a_main_NO}">${list.a_main_title}</a>
								</td>	
								<td align='left'  width="25%">
	  							${list.a_main_writeDate}
	  							</td>
	  							</tr>   
	  						 </c:forEach>
	  						 </c:otherwise>
	  						 </c:choose>
	  					</table>
	  						
	  						<div class="div-2">
							<button class="myP_SWbtn"onclick="location='admin_main_notice_add.do'">글쓰기</button>
							</div>
														
							<br>			
						</div>										
					</div>
					
<form role="form" method="get">				
  <div class="search">
    <select name="searchType" id="searchType">
      <option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
      <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>     
   </select>

    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}" placeholder="검색어를 입력하세요" />

    <button id="searchBtn" type="button">검색</button>
	<script>
      $(function(){
        $('#searchBtn').click(function() {
          self.location = "admin_main.do" + '${paging.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });
      });   
    </script>   
  </div>
					
	
	
	<div class="board_page">	
		<ul class="paging">
    		<c:if test="${paging.prev}">
        		<span><a href="${contextPath}/admin_main.do?page=${paging.startPage-1}">이전</a></span>
    		</c:if>
    		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
    		
        		<span><a href="${contextPath}/admin_main.do?page=${num}">${num}</a></span>
        		
    		</c:forEach>
    		<c:if test="${paging.next && paging.endPage>0}">
        		<span><a href="${contextPath}/admin_main.do?page=${paging.endPage+1}">다음</a></span>
    		</c:if>
       </ul>
       
            
                        	
		</div>
		
</form>	
	
						
					
					
					
					
					
					
					
					
					
					
					
        </main>
</div>
</section>
    </div>
  
</body>
</html>

 