<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- header -->
<!DOCTYPE html>
<html>
<head>
   
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mypage.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script>

function _onSubmit(){

if(!confirm("수정하시겠습니까?")){
return false;
}else{
	alert("수정이 완료되었습니다.")
	location.href="${contextPath}/admin_main.do";
}
}


</script> 





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
	<form role="form" method="post" action="${contextPath}/admin_main_notice_update_action.do" onsubmit="return _onSubmit();">
        <main>
        <div class="title_wrap"><h2 class="tit_txt">관리자 페이지</h2></div> <hr>
        <input type="hidden" id="a_main_NO" name="a_main_NO" value="${list.a_main_NO}" />
            <div class="order_list21">
            	
					<div class="title_wrap">
							<h2 class="tit_txt" style="text-align:center">관리자 공지사항 수정</h2>
					</div>
						<div class="listTable21">
            
            
            	
                
               
                <div class="form-group">
                    <label class="col-lg-2 control-label">작성자</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" name="user_id" value="${list.user_id}" id="prodName" data-rule-required="true" maxlength="30" readonly>
                    </div>
                </div>
                
                
                <div class="form-group">
                    <label class="col-lg-2 control-label">제목</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" name="a_main_title" id="prodmake" data-rule-required="true"  maxlength="40">
                    </div>
                </div>
                
              
                
                <div class="form-group">
                    <label class="col-lg-2 control-label">내용</label>
                    <div class="col-lg-10">            
                             <textarea name="a_main_content" rows="10" cols="65" class="form-control onlyNumber" maxlength="4000"></textarea>                                            
                    </div>
                </div>
                
                
              
                
                <br><br>
                
                            
                </div><br><br>
                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10" align="center">
                        <button type="submit"  class="btn btn-outline-dark">수정하기</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                        <button type="button" class="btn btn-outline-dark" onclick="location='admin_main.do'">취소하기</button>
                    </div>
                </div>
           
        
        </div>
       </main>
       </form>
        </div>				
						
						
       
</div>

  <script></script>
  
</body>
</html>

 