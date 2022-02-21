<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"    
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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


  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->




</head>


<!--===========================================
=            Popular deals section            =
============================================-->

<section class="login py-5 border-top-1" style="margin-top: 20px; height:600px">
        <div class="container" style="width:900px; flaot:center">
            <div class="row justify-content-center">
                <div class="col-lg-5 col-md-8 align-item-center">
                    <div class="border border" style="width:650px; float:center;">
                        <h3 class="bg-gray p-4" style="text-align:center">아이디 찾기</h3>
                       <div class="container" style="width:80%; float:center">
                       		
                       		<h3>찾으시는 아이디는 ${id} 입니다.</h3>
                       		
                       <a href="${contextPath}/login.do"><button type="submit" class="border p-3 w-100 my-2">로그인</button></a>
                       <a href="${contextPath}/password.do"><button type="submit" class="border p-3 w-100" style="margin-bottom:20px; margin-top:10px;">비밀번호 찾기</button></a>
                       </div>
        

                    </div>
                </div>
            </div>
        </div>
    </section>

</body>

</html>



