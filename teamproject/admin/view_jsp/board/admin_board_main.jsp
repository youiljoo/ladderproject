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
	.div-2{		
		padding : 15px;
		text-align : right;
	}
</style>
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

           
        </main>
</div>
</section>
    </div>

</body>
</html>




  