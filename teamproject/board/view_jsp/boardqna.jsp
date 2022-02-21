<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"    
    %>

<%
  request.setCharacterEncoding("utf-8");
%>
   
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />



<!DOCTYPE html>
<html>
<head>

  <!-- CUSTOM CSS -->
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/board.css">  
     
     <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
     
 
      
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

<section class="section">
	<!-- Container Start -->
	<div class="container">
		<div class="row" id="common">
			<h2>Q&A 게시판</h2>
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
			<table class="table_style" border="1" cellpadding="0" cellspacing="0" width="100%">
				<tr height="10%" align="center">
					<th width="10%">순번</th>
					<th width="50%">제목</th>
					<th width="15%">작성자</th>
					<th width="10%">작성일</th>
					<th width="10%">상태</th>
				</tr>
				
				<c:choose>
				<c:when test="${empty list}">
					 <tr height="400">
     					 <td colspan="5">
         					<p align="center">
           						 <b><span style="font-size:11pt;">등록된 글이 없습니다.</span></b>
       						</p>
      					</td>  
    				</tr>
  				</c:when>
  				<c:otherwise>
     			
     			<c:forEach items="${list}" var="list">	
  				
				<tr align="center">
					<td>${list.q_no}</td>
					<td>
				    <c:if test="${list.q_secret=='Y'}" >
												
						<img src="${contextPath}/resources/images/locker.png" alt="비밀글" style="width:15px;height:15px">
						<a href="javascript:fn_viewQNA('${isLogOn}','${contextPath}/board/qna/detail?q_no=${list.q_no}',
						'${contextPath}/login.do')">
						<input type="hidden" name="q_name" value="<c:out value="${list.q_name}" />" />비밀글입니다.
						
						</a>
					 	
					 </c:if> 
					<c:if test="${list.q_secret=='N'}" >
						<a href="javascript:fn_viewQNA2('${isLogOn}','${contextPath}/board/qna/detail?q_no=${list.q_no}', 
                                                    '${contextPath}/login.do')"><c:out value="${list.q_name}" /></a>
					</c:if>	
					</td>
					<td>${list.user_id}</td>
					<td>${list.q_regdate}</td>
					<td>${list.q_state}</td>
				
				</tr>
				<input type="hidden" name="user_pw" value="${list.user_pw}">
<script>
		
	function fn_viewQNA(isLogOn,qnadetail,login){
	
		if(isLogOn != "" && isLogOn !='false' && ${memberInfo.user_id == list.user_id}){
			alert("회원가입 시 입력한 비밀번호를 입력해주세요.")
			
			var user_pw = prompt("회원가입 시 입력한 비밀번호를 입력해주세요");
			
			if(${list.user_pw != user_pw} || ${user_pw==""}){
				alert("비밀번호가 일치하지 않습니다.")
			}
			else if(${list.user_pw == user_pw}){
				alert("인증되었습니다.")
				location.href=qnadetail;									
			}
		
	  }else{
		 alert("비밀글은 작성자 본인만 볼 수 있습니다.")
	  }
	}
	
	function fn_viewQNA2(isLogOn,qnadetail,login){
		if(isLogOn != '' && isLogOn !='false' && ${memberInfo.user_id == list.user_id}){
			location.href=qnadetail;
		}else{
			alert("상세글은 관리자와 작성자 본인만 볼 수 있습니다.")
			location.href=qna;
		}
	}
</script>	    				
				
				</c:forEach>
				</c:otherwise>			
				</c:choose>
							
																					
			</table>
			</div>
	</div>
		
		<div class="search">
    <select name="searchType" id="searchType">
       <option value="u"<c:out value="${scri.searchType eq 'u' ? 'selected' : ''}"/>>작성자</option>
   </select>

    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}" placeholder="검색어를 입력하세요" />

    <button id="searchBtn" type="button">검색</button>
	<script>
      $(function(){
        $('#searchBtn').click(function() {
          self.location = "qna" + '${paging.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });
      });   
    </script>   
  </div>
               
               
             
        
			
		<div class="board_page">	
		<ul class="paging">
    		<c:if test="${paging.prev}">
        		<span><a href='<c:url value="/board/qna?page=${paging.startPage-1}"/>'>이전</a></span>
    		</c:if>
    		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
    		
        		<span><a href='<c:url value="/board/qna?page=${num}"/>'>${num}</a></span>
        		
    		</c:forEach>
    		<c:if test="${paging.next && paging.endPage>0}">
        		<span><a href='<c:url value="/board/qna?page=${paging.endPage+1}"/>'>다음</a></span>
    		</c:if>
       </ul>
       
            
                        	
		</div>
	
		
		<div class="cfooter">
			<a href="javascript:fn_qnaForm('${isLogOn}','${contextPath}/board/qnawriting', 
                                                    '${contextPath}/login.do')"><input type="button" class="btn btn-primary pull-right" value="글쓰기"></a>
		</div>
		
		<script>
	function fn_qnaForm(isLogOn,qnawriting,login){
		if(isLogOn != '' && isLogOn !='false'){
			location.href=qnawriting;
		}else{
			alert("로그인 후 글쓰기 가능합니다.")
			location.href=login+'?action=/login.do';
		}
	}
	</script>
		</form>
	</div>
</section>

<!--============================
=            Footer            =
=============================-->


</body>

</html>



