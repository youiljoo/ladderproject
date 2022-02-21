<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
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
<meta charset="EUC-KR">
<title>footer</title>
</head>
<body>
<footer class="footer section section-sm">
  <!-- Container Start -->
  <div class="container">
    <div class="row">
      <div class="col-lg-3 col-md-7 offset-md-1 offset-lg-0" style="magin-right: 50px;margin-right: 49px;">
        <!-- About -->
        <div class="block about">
          <p class="alt-color">
          <table style="float:left">
          <tr>
			<td><h2>CUSTOMER CENTER</h2></td>
		</tr>
		<tr>
			<td><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img width="25px" src = "${contextPath}/resources/images/call.png" style= "margin-bottom: 0px;"/>1599-0094&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h4></td>
		</tr>
		<tr>
			<td><h7>&nbsp;&nbsp;&nbsp;&nbsp;운영시간: AM 10:00 - PM 7:00&nbsp;</h7></td>
		</tr>
		<tr>
			<td><h7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;공휴일 휴무</h7></td>
		</tr></table>
		</p>
		
        </div>
      </div>
      
       <div class="block about" style="margin-right: 50px;">
          <p class="alt-color">
          <table style="float:left">
			<tr>
			<td><h5 style="
  		margin-bottom: 10px;">(주)사다리컴/대표전화: 1599-0094 /팩스번호: 042-1599-0094</h5></td>
		</tr>
		<tr>
		<td><h5 style="
    	margin-bottom: 10px;">주소: 대전 서구 둔산동 사다리빌딩 3층 사다리컴</h5></td>
		</tr>
		<tr>
		<td><h5 style="
    	margin-bottom: 10px;">대표이사: 김우현 /Email: Ladder@naver.com</h5></td>
		</tr>
		<tr>
		<td><h5 style="
    	margin-bottom: 10px;">카카오톡: 
		<a href="http://pf.kakao.com/_MRxgxdb">
      <img width="25px" src = "${contextPath}/resources/images/kakaologo.png" style= "margin-bottom: 0px;"/>
      </a> 
      </h5></td>
		</tr>
		<tr>
		<td><h5 style="
    	margin-bottom: 10px;">인스타그램:
		<a href="https://www.instagram.com">
      <img width="25px" src = "${contextPath}/resources/images/instagramlogo.png" style= "margin-bottom: 0px;"/>
      </a>  
		</h5></td>
		</tr>
		</table>
		</p>
        </div>
              <div class="block about" >
          <p class="alt-color">
          <table style="float:left">
          <a href="${contextPath}/main.do">
      <img width="230px" src = "${contextPath}/resources/images/ladder1.png" />
      </a> 
      </table>
      </div>
      </div>
      </div>
      </footer>
</body>
</html>