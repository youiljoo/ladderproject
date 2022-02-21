<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="utf-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- header -->
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/mypage.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
.div-1 {
	padding: 25px;
	margin: 0 auto;
	display: block;
	text-align: center;
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
				<form>
					<main>
						<div class="title_wrap">
							<h2 class="tit_txt">관리자 페이지</h2>
						</div>
						<hr>

						<div class="order_list21">

							<div class="title_wrap">
								<h2 class="tit_txt" style="text-align: center">후기관리</h2>
							</div>
							<div class="listTable21">
								<table border="0" cellspacing="0" cellpadding="0" width="100%"
									class="myP_Ttype1">
									<colgroup>
										<col width="30%">
										<col width="70%">
									</colgroup>
									<thead>
										<tr>
											<th>상품명</th>
											<td>${list.productName}</td>
										</tr>
										<tr>
											<th>작성자</th>
											<td>${list.user_id}</td>
										</tr>
										<tr>
											<th>후기내용</th>
											<td>${list.re_content}</td>
										</tr>

										<tr>
											<th>답변내용</th>
											<td>${list.re_reply}</td>
										</tr>

									</thead>
									<tbody>
										
									</tbody>
								</table>
							</div>
							<div class="div-1">
								<a href="javascript:void(0);" class="btn btn-danger" onclick="deleteConfirm();">삭제하기</a> 
								<a href="${contextPath}/admin_review_re2.do?re_num=${list.re_num}" class="btn btn-outline-dark">답변쓰기</a>
								<button type="button" class="btn btn-outline-dark" onclick="location='admin_review.do'">취소하기</button>
								
								
								<script type="text/javascript">
									function deleteConfirm() {
										if (!confirm("삭제 하시겠습니까?")) {
											return false;
										} else {
											alert("삭제하였습니다.")
											location.href = "${contextPath}/admin_review_delete.do?re_num=${list.re_num}";
										}
									}
								</script>
							</div>
						</div>

					</main>
				</form>
			</div>
		</section>
	</div>

</body>
</html>

