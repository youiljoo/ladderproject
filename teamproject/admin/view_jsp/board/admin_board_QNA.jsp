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




</head>
<body>
  
     <!-- contents --> 
  <div id = "contents">
    <!-- 마이페이지 메인 -->
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
           <br><br> 
            <div class="bookmark mt45">
						<div class="title_wrap"><h2 class="tit_txt">게시판 관리</h2></div> 
						<ul class="bookmark_list">
							<li>
								<a href="${contextPath }/admin_board_notice.do">
									<h3>공지사항</h3>
									<div class="count_area"><i></i></div>
								</a>
							</li>
							<li>
								<a href="${contextPath }/admin_board_consulting.do">
									<h3>상담문의</h3>
									<div class="count_area"><i></i></div>
								</a>
							</li>
							<li>
								<a href="${contextPath }/admin_board_QNA.do">
									<h3>Q&A</h3>
									<div class="count_area"><i></i></div>  
								</a>
							</li> 
							<li style = "margin-right: 0px;">
								<a href="${contextPath }/admin_board_AS.do">
									<h3>A/S문의</h3>
									<div class="count_area"><i></i></div>
								</a>
							</li>
						</ul>
					</div>

            <div class="order_list21">
						<div class="title_wrap">
							<h2 class="tit_txt">Q&A 게시판</h2>							
						</div>
						<div class="listTable21">							
							<table border="0" cellspacing="0" cellpadding="0" width="100%" class="myP_Ttype1">								
  								<tr height="10" align="center"  bgcolor="lightgreen">                 
     							<td>순번</td>
     							<td>제목</td>
     							<td>작성자</td>
     							<td>상태</td>    						
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
								<td align='left' width="15%">
	 							<span><c:out value="${list.q_no}"/></span>                   				
								</td>
								<td align='left' width="40%">
	 							<span></span>
                   				<a class="cls1" href="${contextPath}/admin_board_QNA_detail.do?q_no=${list.q_no}"><c:out value="${list.q_name}"/></a>
								</td>	
								<td align='left'  width="15%">
	  							<span><c:out value="${list.user_id}"/></span>
	  							</td>
	  							<td align='left'  width="15%">
	  							<span><c:out value="${list.q_state}"/></span>
	  							</td>	  						
	  							
	  							</tr>
	  							</c:forEach>
	  							</c:otherwise>
	  							</c:choose>	  							
	  						</table>	  										
							<br>			
						</div>		
					</div>

<form role="form" method="get">				
  <div class="search">
    <select name="searchType" id="searchType">
   		<option value="u"<c:out value="${scri.searchType eq 'u' ? 'selected' : ''}"/>>작성자</option>
   </select>

    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}" placeholder="검색어를 입력하세요" />

    <button id="searchBtn" type="button">검색</button>
	<script>
      $(function(){
        $('#searchBtn').click(function() {
          self.location = "admin_board_QNA.do" + '${paging.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });
      });   
    </script>   
  </div>
					
	
	
	<div class="board_page">	
		<ul class="paging">
    		<c:if test="${paging.prev}">
        		<span><a href="${contextPath}/admin_board_QNA.do?page=${paging.startPage-1}">이전</a></span>
    		</c:if>
    		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
    		
        		<span><a href="${contextPath}/admin_board_QNA.do?page=${num}">${num}</a></span>
        		
    		</c:forEach>
    		<c:if test="${paging.next && paging.endPage>0}">
        		<span><a href="${contextPath}/admin_board_QNA.do?page=${paging.endPage+1}">다음</a></span>
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




  