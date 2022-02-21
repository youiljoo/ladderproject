<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  pageEncoding="utf-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- header -->
<!DOCTYPE html>
<html>
<head>
    
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mypage.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<style type="text/css">
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
							<h2 class="tit_txt" style="text-align:center">관리자 공지사항</h2>
					</div>
						<div class="listTable21">
            <form class="form-horizontal form_align" role="form" method="post" action="admin_main_notice_add.do">              
               
        
                <div class="form-group">
                    <label class="col-lg-2 control-label">작성자</label>
                    <div class="col-lg-10">
                        <input type="text" name="user_id" value="관리자" class="form-control" id="prodmake" data-rule-required="true"  maxlength="40" readonly>
                    </div>
                </div>
                
                
                <div class="form-group">
                    <label class="col-lg-2 control-label">제목</label>
                    <div class="col-lg-10">
                        <input type="text" name="a_main_title" class="form-control" id="prodmake" data-rule-required="true"  maxlength="40">
                    </div>
                </div>
                   
                <div class="form-group">
                    <label class="col-lg-2 control-label">내용</label>
                    <div class="col-lg-10">            
                             <textarea name="a_main_content" rows="10" cols="65" class="form-control onlyNumber" maxlength="4000"></textarea>                                            
                    </div>
                </div>                
                
                
                <br><br>
                
                              
                </div>
               
           
        
        </div>
       
       <div class="div-1">
						<button type="button" class="btn btn-outline-dark" onclick="location='admin_main.do'">돌아가기</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" class="btn btn-outline-dark" value="등록하기">
						</div>
     </form>
       </main>
     
        </div>				
						
						
   
</div>
</section>
    </div>
</body>
</html>

 