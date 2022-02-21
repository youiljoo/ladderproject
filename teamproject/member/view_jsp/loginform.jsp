</script>
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
  <title>Classimax</title>
  
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


  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

	<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
	
	<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>

<script>
	function checkCapsLock(event) {
		if(event.getModifierState("CapsLock")) {
			document.getElementById("message").innerText="Caps Lock이 켜져 있습니다."
		} else {
			document.getElementById("message").innerText=""
		}
	}
</script>

<script>
window.onload=function()
{
  result();
}

function result(){
	alert("아이디나  비밀번호가 틀립니다. 다시 로그인해주세요");
}
</script>

</head>


<!--===========================================
=            Popular deals section            =
============================================-->

<section class="login py-5 border-top-1" >
<div class="slideshow-container" style="height:600px">
    <div class="container">
        <div class="row justify-content-center" style="float:left; width:50%; height:500px">
            <div class="col-lg-5 col-md-8 align-item-center">
            
                <div class="border" style="height:460px">
                    <h3 class="bg-gray p-4" style="text-align:center">회원 로그인</h3>
                    <form action="login2.do" accept-charset="utf-8">
                        <fieldset class="p-4">
                            <input type="text" name="user_id" placeholder="UserName" class="border p-3 w-100 my-2" style="height:55px;">
                            
                            <input type="password" name="user_pw" id="password" onkeyup="checkCapsLock(event)" placeholder="Password" class="border p-3 w-100 my-2" style="height:55px;">
                            <div class="d-inline-block text-primary" style="width:300px; height:10px;">
                            	<div id="message">	</div>
                            </div>
                            <button type="submit" class="border p-3 w-100 my-2">로그인</button>
                            <a href="${kakao_url }"><img src="${contextPath}/resources/images/kakao_login.png" alt="카카오계정 로그인" style="width:49%; height:50px;"/></a>
                         	
							<a id="naver_id_login" href="${url }" ><img src="https://static.nid.naver.com/oauth/big_g.PNG?version=js-2.0.1" style="width:49%; height:50px; float:right"></a>
                           
                            <a class="mt-3 d-inline-block text-primary" href="${contextPath}/id.do">아이디 찾기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a class="mt-3 d-inline-block text-primary" href="${contextPath}/password.do">비밀번호 찾기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a class="mt-3 d-inline-block text-primary" href="${contextPath}/register.do">회원가입</a>
                        </fieldset>
                    </form>
                </div>
                
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row justify-content-center" style="float:left; width:50%; height:500px">
            <div class="col-lg-5 col-md-8 align-item-center">
                <div class="border" style="height:460px">
                    <h3 class="bg-gray p-4" style="text-align:center; margin-bottom: 0px;">비회원 주문조회</h3>
                    <form action="main.do">
                        <fieldset class="p-4">
                        	<h4 style="margin-top: 25px;">이름</h4>
                            <input type="text" id="order_name" name="order_name" placeholder="UserName" class="border p-3 w-100 my-2" style="height:55px;">              
                            <h4 style="margin-top: 20px;">휴대폰 번호</h4>
                            <input type="text" id= "order_phone" name="order_name" placeholder="Phone_Number" class="border p-3 w-100 my-2" style="height:55px;">
                            <button type="submit" class="border p-3 w-100 my-2" style="height:55px;">조회하기</button>
                        </fieldset>
                    </form>
                </div>
                
                </div>
            </div>
        </div>
    </div>
</section>






</body>

</html>
