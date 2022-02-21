<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>


  <!-- CUSTOM CSS -->
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">


  

<title>footer</title>



</head>
<body>
  <header>
    <div id="h-twrap">
        <div id="h-t">
            	<ul>
		   <c:choose>
		     <c:when test="${isLogOn==true and not empty memberInfo}">
			   <li><a href="${contextPath}/logout.do">로그아웃</a></li>
			   <li><a href="${contextPath}/mypage.do">마이페이지</a></li>
			   <li><a href="${contextPath}/cart.do">장바구니</a></li>
			 </c:when>
			 <c:otherwise>
			   <li><a href="${contextPath}/login.do">로그인</a></li>
			   <li><a href="${contextPath}/register.do">회원가입</a></li> 
			    <li><a href="${contextPath}/login.do">마이페이지</a></li>
			   <li><a href="${contextPath}/cart.do">장바구니</a></li>
			 </c:otherwise>
			</c:choose>
			   <li><a href="${contextPath}/board">고객센터</a></li>
      <c:if test="${isLogOn==true and memberInfo.user_id =='admin' }">  
	   	   <li class="no_line"><a href="${contextPath}/admin_main.do">관리자</a></li>
	    </c:if>
		</ul>
		   </div>
		   </div>
	<div id="h-mwrap">
    <div id="h-m">
	<div id="logoimg">
	<a href="${contextPath}/main.do">
		<img width="210" height="100"  src="${contextPath}/resources/images/ladder4.png">
	</a>
	</div>

	<div id="search" >
		<form name="frmSearch"  action="${contextPath}/searchlist.do" >
			<input name="searchWord" class="main_input" type="text"  onKeyUp="keywordSearch()"> 
			<input type="image" name="search"  class="btn1"  src= "${contextPath}/resources/images/icon1.png" >
		</form>
   </div>
      </div>
      </div>
      <div id="h-bwrap">
    <div id= "h-b">
<ul class="nav" style="
    width: 50px;">
    <li style="margin-top:0px;">
        <a class="flex-center2"><img width="40" height="40"  src="${contextPath}/resources/images/Hamburger.png"></a>
        <div>
           
<div class="nav-column"> 
    <h3>모니터</h3>
    <ul style="	margin-top:20px; margin-left:10px;">
        <li><a href="#">19인치 이하</a></li>   
        <li><a href="#">23~25인치</a></li>
        <li><a href="#">27~31인치</a></li>
        <li><a href="#">32인치 이상</a></li>
        <li><a href="#">게이밍 모니터</a></li>
        <li><a href="#">모니터암,어댑터</a></li>
    </ul>
</div>
 <div class="nav-line1">
 </div>
<div class="nav-column">
    <h3>마우스</h3> 
       <ul style="	margin-top:20px; margin-left:10px;">
        <li><a href="#">유선 마우스</a></li>
        <li><a href="#">무선 마우스</a></li>
        <li><a href="#">게이밍 마우스</a></li>
        <li><a href="#">마우스 패드</a></li>
    </ul>
</div>
 <div class="nav-line2">
 </div>
 <div class="nav-column">
    <h3>키보드</h3>
   <ul style="	margin-top:20px; margin-left:10px;">
        <li><a href="#">기계식 키보드</a></li>
        <li><a href="#">게이밍 키보드</a></li>
        <li><a href="#">무접점 키보드</a></li>
        <li><a href="#">무선 키보드</a></li>
    </ul>
</div>
 <div class="nav-line3">
 </div>
<div class="nav-column">
    <h3>스피커</h3>
   <ul style="	margin-top:20px; margin-left:10px;">
        <li><a href="#">2채널</a></li>
        <li><a href="#">2.1채널 이상</a></li>
        <li><a href="#">사운드바</a></li>

    </ul>
</div>
 <div class="nav-line4">
 </div>
<div class="nav-column">
    <h3>헤드셋</h3>
   <ul style="	margin-top:20px; margin-left:10px;">
        <li><a href="#">헤드셋</a></li>
        <li><a href="#">악세서리</a></li>
    </ul>
</div>

        </div>
    </li>
</ul>
   <ul class="h-b_ul">
    		<li><a href="${contextPath}/monitor.do">모니터</a></li>
			<li><a href="${contextPath}/mouse.do">마우스</a></li>
			<li><a href="${contextPath}/keyboard.do">키보드</a></li>
			<li><a href="${contextPath}/speaker.do">스피커</a></li>
			<li><a href="${contextPath}/headset.do">헤드셋</a></li>
   </ul>
   <div id = b-right>
  <a href="${contextPath}/ladder.do">사다리게임</a>
	</div>
  </div>
  </div>
    </header>
    <script>
jQuery(document).ready(function(){
  $('.menu>li').mouseover(function(){
    $(this).find('.submenu').stop().slideDown(500);
  }).mouseout(function(){
    $(this).find('.submenu').stop().slideUp(500);
  });
});
</script>
</body>
</html>