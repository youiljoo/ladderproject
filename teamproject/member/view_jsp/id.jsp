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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script><!-- 합쳐지고 최소화된 최신 자바스크립트 -->

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  
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
				window.onload = function() {
					$('#123').hide(),
					$('#hidden').show();
				};
    				function setDisplay(){
    					if($('input:radio[id=aaa]').is(':checked')){
    						$('#123').hide(),
    						$('#hidden').show();
    						
    					}else{
    						
    						$('#123').show(),
    						$('#hidden').hide();
    					}
    				}	
	
 </script>	

</head>
<body>
<section class="login py-5 border-top-1" style="margin-top:20px; height:600px">
<div class="slideshow-container">
    <div class="container" style="width:830px; flaot:center">
        <div class="row justify-content-center" style="float:center;">
            <div class="col-lg-5 col-md-8 align-item-center">
                <div class="border">
                    <h3 class="bg-gray p-4" style="text-align:center">아이디 찾기</h3>
                        <fieldset class="p-4">
                        	<div class="form-check">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="abcd" id="aaa" value="00" onClick="setDisplay()" checked="checked">
								  <label class="form-check-label" for="aaa">휴대번호</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="abcd" id="bbb" value="10" onClick="setDisplay()">
								  <label class="form-check-label" for="bbb">이메일</label>
								</div>
								</div>
							<form action = "${contextPath}/selectId_1.do" method="post" accept-charset="utf-8">
								<div id="hidden">
							<div class="mt-3 d-inline-block text-primary">
                        		<h3 style="float:left;margin-top: 12px; margin-right: 39px; margin-left: 30px;">&nbsp;이 름&nbsp;&nbsp;</h3>
                            	<input type="text" placeholder="Name" class="border p-6 " id="user_name" name= "user_name" style="width:300px; float:right">
                            </div>
                            <div class="mt-3 d-inline-block text-primary">
                        		<h3 style="float:left;margin-top: 12px; margin-right: 15px; margin-left: 10px;">휴대폰 번호</h3>
                            	<input type="tel" placeholder="Phone-Number" class="border p-6 " id="user_phone" name= "user_phone" style="width:300px; float:center; margin-right:10px; margin-bottom: 10px;">
                            	</div>
                            <button type="submit" class="border p-3 w-100 my-2">찾기</button>
                            
                            </div>
                            </form>
                          
                        <form action = "${contextPath }/selectId_2.do" method="post" accept-charset="utf-8">
                       <div id="123">
							<div class="mt-3 d-inline-block text-primary">
                        		<h3 style="float:left;margin-top: 12px; margin-right: 39px; margin-left: 30px;">&nbsp;이 름&nbsp;&nbsp;</h3>
                            	<input type="text" placeholder="Name" class="border p-6 " id="user_name" name= "user_name" style="width:300px; float:right">
                            </div>
                           <div class="mt-3 d-inline-block text-primary">
                        		<h3 style="float:left;margin-top: 12px; margin-right: 27px; margin-left: 33px;">이메일&nbsp;&nbsp;</h3>
                            	<input type="email" placeholder="Email" class="border p-6 " id="user_email" name= "user_email" style="width:300px; float:center;  margin-right:10px; margin-bottom: 10px;" >
                            </div>
                            <button type="submit" class="border p-3 w-100 my-2">찾기</button>
        				    </div>
                          </form>
                          <div id="message">
                          	${message }
                          </div>
                      </fieldset>  
                </div>
            </div>
        </div>
    </div>              
  </div>
</section>
</body>
</html>