<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"    
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html lang="ko">
<head>

  <!-- SITE TITTLE -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>사다리컴</title>
  
  <!-- FAVICON -->
  <link href="img/favicon.png" rel="shortcut icon">
  <!-- PLUGINS CSS STYLE -->
  <!-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/jquery-ui/jquery-ui.min.css"> -->
  <!-- Bootstrap -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/bootstrap/css/bootstrap-min.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/bootstrap/css/bootstrap-slider.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/font-awesome/css/font-awesome.min.css">
  <!-- Owl Carousel -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/slick-carousel/slick/slick.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/slick-carousel/slick/slick-theme.css">
  <!-- Fancy Box -->
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/fancybox/jquery.fancybox.pack.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/jquery-nice-select/css/nice-select.css">

  <!-- CUSTOM CSS -->
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

<!-- JAVASCRIPTS -->
<script src="<c:url value="/resources/plugins/jQuery/jquery.min.js" />">
<script src="<c:url value="/resources/plugins/bootstrap/js/popper.min.js" />">
<script src="<c:url value="/resources/plugins/bootstrap/js/bootstrap.min.js" />">
<script src="<c:url value="/resources/plugins/bootstrap/js/bootstrap-slider.js" />">

  <!-- tether js -->
<script src="<c:url value="/resources/plugins/tether/js/tether.min.js" />">
<script src="<c:url value="/resources/plugins/raty/jquery.raty-fa.js" />">
<script src="<c:url value="/resources/plugins/slick-carousel/slick/slick.min.js" />">
<script src="<c:url value="/resources/plugins/jquery-nice-select/js/jquery.nice-select.min.js" />">
<script src="<c:url value="/resources/plugins/fancybox/jquery.fancybox.pack.js" />">
<script src="<c:url value="/resources/plugins/smoothscroll/SmoothScroll.min.js" />">

<!-- google map -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCcABaamniA6OL5YvYSpB3pFMNrXwXnLwU&libraries=places"></script>
<script src="<c:url value="/resources/plugins/smoothscroll/SmoothScroll.min.js" />">
<script src="<c:url value="/resources/js/script.js" />">
<script src="<c:url value="/resources/js/a.js" />">

  <!-- CUSTOM CSS -->
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">


  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  
<script></script>

<script>
//F5 새로고침 막기
document.onkeydown = function(e){
	 if(!e) e = window.event;
	 if (e.keyCode == 116){
	  if( confirm("새로 고침 하시겠습니까?") ){
	  }else{
	   e.keyCode = 0;
	   return false;
	  }
	 }
	}
</script>

<script>
	function checkCapsLock_1(event) {
		if(event.getModifierState("CapsLock")) {
			document.getElementById("message_1").innerText="Caps Lock이 켜져 있습니다."
		} else {
			document.getElementById("message_1").innerText=""
		}
	}
</script>

<script>
	function checkCapsLock_2(event) {
		if(event.getModifierState("CapsLock")) {
			document.getElementById("message_2").innerText="Caps Lock이 켜져 있습니다."
		} else {
			document.getElementById("message_2").innerText=""
		}
	}
</script>

<script>
$(document).ready(function(){
 $(function(){

	//비밀번호 확인
	var passCheck = /^[a-zA-Z0-9]{8,12}$/;
	$('#user_pw').blur(function(){
		if(!passCheck.test($("#user_pw").val())) {
			alert("비밀번호는 8~12자의 영문 대소문자와 숫자로만 입력해 주세요");
			$('#user_pw').val('');
		}
	})
		$('#user_repw').blur(function(){
		   if($('#user_pw').val() != $('#user_repw').val()){
		    	if($('#user_repw').val()!=''){
			    alert("비밀번호가 일치하지 않습니다.");
		    	    $('#user_repw').val('');
		          $('#user_repw').focus();
		       }
		    }
		});  	   
	});
});
</script>
</head>
<body>
<section class="login py-5 border-top-1" style="margin-top: 20px; height:600px">
        <div class="container" style="width:900px; flaot:center">
            <div class="row justify-content-center">
                <div class="col-lg-5 col-md-8 align-item-center">
                <form action="${contextPath}/change.do" method="post">
                    <div class="border border" style="width:650px; float:center;">
                        <h3 class="bg-gray p-4" style="text-align:center">비밀번호 찾기</h3>
                       <div class="container" style="width:80%; float:center">
                       		<h3 class="p-4" style="text-align:center; margin-top:30px; margin-bottom:20px">새로운 비밀번호를 입력해 주세요</h3>
                      		<div class="mt-3 d-inline-block text-primary">
                      			<input type="hidden" id="user_id" name = "user_id" value="${id }">
                        		<h3 style="float:left;margin-top: 12px; margin-right: 39px; margin-left: 30px;">비밀번호</h3>
                            	<input type="password" onkeyup="checkCapsLock_1(event)" placeholder="Password" class="border p-6 " id="user_pw" name= "user_pw" style="width:300px; float:right">
                            </div>
                 			
                            <div class="mt-3 d-inline-block text-primary">
                        		<h3 style="float:left;margin-top: 12px; margin-right: 15px; margin-left: 10px;">비밀번호 확인</h3>
                            	<input type="password" onkeyup="checkCapsLock_2(event)" placeholder="Password" class="border p-6 " id="user_repw" name= "user_repw" style="width:300px; float:center; margin-right:10px; margin-bottom: 10px;">
                            </div>
                            <div class="d-inline-block text-primary" style="width:300px; height:10px;">
                            	<div id="message_2">	</div>
                            </div>
                            <button type="submit" class="border p-3 w-100 my-2">확인</button>
                      
                       </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </section>






</body>

</html>



