<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  pageEncoding="utf-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- header -->
<!DOCTYPE html>
<html>
<head>
   
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mypage.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>



<script type="text/javascript">



function deleteConfirm(){

if(!confirm("삭제 하시겠습니까?")){
return false;
}else{
alert("삭제하였습니다.")
location.href="${contextPath}/admin_board_notice_delete.do?n_no=${list.n_no}";
}
}

</script> 








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
        	<form name="frm" method="post">
            <div class="order_list21">
            	
						<div class="title_wrap">
							<h2 class="tit_txt" style="text-align:center">공지사항</h2>
						</div>
						<div class="listTable21">
							<table border="0" cellspacing="0" cellpadding="0" width="100%" class="myP_Ttype1">
								<colgroup>
									<col width="30%">
									<col width="70%">
								</colgroup>
								<thead>
									<tr><th>구분</th><td><c:out value="${list.n_type}"/></td></tr>
									<tr><th>작성자</th><td>관리자</td></tr>
									<tr><th>제목</th><td><c:out value="${list.n_name}"/></td></tr>
									<tr><th>내용</th><td><c:out value="${list.n_content}"/> <br><br><br><br><br><br><br><br></td></tr>
									
									</thead>
								<tbody>																		
									</tr>									
								</tbody>	
															
							</table>							
						</div><br>									
						<div class="div-1">
						<button type="button" class="myP_SWbtn" onclick="location='admin_board_notice.do'">돌아가기</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="${contextPath}/admin_board_notice_update.do?n_no=${list.n_no}" class="btn btn-success">수정</a>
						<a href="javascript:void(0);" class="btn btn-danger" onclick="deleteConfirm();">삭제</a>
	
			
						</div>
					</div>
				</form>	
        </main>
</div>
</section>
    </div>
 
</body>
</html>

 