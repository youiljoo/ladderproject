<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"    
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
<head>

  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> 

  <!-- CUSTOM CSS -->
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
	 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/board.css">

</head>



<!--===============================
=            Hero Area            =
================================-->

<section class="hero-area bg-1 text-center overly::before" style="background-color:white">	
	<!-- Container Start -->
	<div class="container" style="height:200px;">
		<h2>고객센터 : 1688-5454 </h2>
		<p>고객센터 운영시간 : 평일(09:00~17:30) <br>토,일 공휴일 휴무</p>
		<div class="row">
		
			<div class="col-md-12">
				<img src="${contextPath}/resources/images/customer.jpg" id="call">
				<!-- Header Contetnt -->
				<div class="content-block">
					
					
					
				</div>
			</div>
		</div>
	</div>
	<!-- Container End -->
</section>

<!--===================================
=            Client Slider            =
====================================-->


<!--===========================================
=            Popular deals section            =
============================================-->

<section class="popular-deals section bg-gray">
	

<div class="board_list">
	<div class="board_title">
		<p class="title_name"></p>
		<h2>고객 지원 게시판</h2>		
	</div>
	<div class="container">
	<div class="category-block"> 
		<a href="${contextPath}/board/notice">
			공지사항
		</a>
	 	</div>
	 
	
	<div class="category-block"> 
		<a href="${contextPath}/board/consulting">
			상담문의
		</a>
	 	</div>

	
	<div class="category-block"> 
		<a href="${contextPath}/board/qna">
			&nbsp;&nbsp;&nbsp;&nbsp;Q&A
		</a>
	 	</div>
	 	
	
	<div class="category-block"> 
		<a href="${contextPath}/board/as">
			&nbsp;&nbsp;A/S문의
		</a>
	 	</div>
	 
	 </div>	
	

			
</div>


</section>




<!--==========================================
=            All Category Section            =
===========================================-->

<section class=" section" style="
    padding-bottom: 10px;
">
	<!-- Container Start -->
	<div class="container">
		<div class="row" id="common">
			<h2>공지사항</h2>
			<div class="col-12">
				<!-- Section title -->
				
			
		</div>
	</div>
	</div>
	<!-- Container End -->
</section>

<section class="section">
	<div class="container">
		
		<form role="form" method="get">
		<div class="cbody">
		 
			<div align="center">
			<table class="table_style" border="1" width="100%">
				<tr height="10%" align="center">
					
					<th width="10%">구분</th>
					<th width="50%">제목</th>
					<th width="10%">작성일</th>
					
				</tr>
			
			<c:choose>
				<c:when test="${empty list}">
					 <tr  height="200">
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
					<td><c:out value="${list.n_type}"></c:out></td>
					<td>
					<a href="${contextPath}/board/notice/detail?n_no=${list.n_no}"><c:out value="${list.n_name}"></c:out></a>
					</td>
					<td><c:out value="${list.n_regdate}"></c:out></td>
				</tr>
	
			
				
							</c:forEach>
				</c:otherwise>
				</c:choose>	
	
			</table>
			</div>
			
		
	 	
	</div>
		  <div>
            
             <div class="search">
    <select name="searchType" id="searchType">
      <option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
      <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
      <option value="u"<c:out value="${scri.searchType eq 'u' ? 'selected' : ''}"/>>구분</option>
   </select>

    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}" placeholder="검색어를 입력하세요" />

    <button id="searchBtn" type="button">검색</button>
	<script>
      $(function(){
        $('#searchBtn').click(function() {
          self.location = "notice" + '${paging.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });
      });   
    </script>   
  </div>
               
               
             
        </div>
			
		<div class="board_page">	
		<ul class="paging">
    		<c:if test="${paging.prev}">
        		<span><a href="${contextPath}/board/notice?page=${paging.startPage-1}">이전</a></span>
    		</c:if>
    		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
    		
        		<span><a href="${contextPath}/board/notice?page=${num}">${num}</a></span>
        		
    		</c:forEach>
    		<c:if test="${paging.next && paging.endPage>0}">
        		<span><a href="${contextPath}/board/notice?page=${paging.endPage+1}">다음</a></span>
    		</c:if>
       </ul>
       
            
                        	
		</div>
		
		
		
		
		
		
		
		
		
		</form>
		
		
	
		
		
	 </div>	
</section>

<!--============================
=            Footer            =
=============================-->


</body>

</html>



