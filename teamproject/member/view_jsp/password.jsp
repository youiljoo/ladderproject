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
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
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

<script type="text/javascript">

function checkfield_1(){	
var phoneCheck = $("#phoneCheck").val();

if(phoneCheck!="1") {
	alert("휴대폰 인증확인을 하세요.");
 	return false;
	}
}

</script>

<script>
function checkfield_2(){
var emailCheck = $("#emailCheck").val();
	if(emailCheck!="1"){
	alert("이메일 인증확인을 하세요.");
		return false;
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
 
 <script>	
var code2 = "";
$(document).ready(function(){
	$("#phoneChk").click(function(){
		var phonenum = $('#user_phone').val();
		var regPhone = /(01[0|1|6|9|7])(\d{3}|\d{4})(\d{4}$)/g;
		var user_phone = $("#user_phone").val();
		if(user_phone == "" || !regPhone.test(phonenum)) {
			alert("핸드폰 번호를 확인해 주세요");
			return false;
		} else {
			alert("인증번호 발송 완료.")
		}
		$.ajax({
			type:"GET",
			url:"${contextPath}/phoneCheck?user_phone=" + user_phone,
			cache:false,
			success:function(data) {
				if(data == "error") {
					alert("휴대폰 번호가 올바르지 않습니다");
					$("#user_phone").attr("autofocus",true);
				} else {
					$("#user_phone_check").attr("disabled",false);
					$("#phoneChk_2").attr("disabled",false);
					$("#user_phone").attr("readonly",true); 
					code2 = data;
				}
			}
		});
	});
	
	$("#phoneChk_2").click(function(){
		if($("#user_phone_check").val() == code2) {
			alert("인증번호가 일치합니다");
			$("#user_phone_check").attr("disabled", true);
			document.getElementById("phoneCheck").value="1"; //중복확인을 했다는 flag
		} else {
			alert("인증번호가 일치하지 않습니다.")
			$(this).attr("autofocus",true);
		}
	});
});

</script>

<script>
var code = "";
$(document).ready(function(){
	$("#emailChk").click(function(){
		var user_email = $("#user_email").val();
		$.ajax({
	        type:"GET",
	        url:"${contextPath}/emailCheck?user_email=" + user_email,
	        cache : false,
	        success:function(data){
	        	if(data == "error"){
	        		alert("이메일 주소가 올바르지 않습니다. 유효한 이메일 주소를 입력해주세요.");
					$("#user_email").attr("autofocus",true);
	        	}else{	        		
					alert("인증번호 발송이 완료되었습니다.\n입력한 이메일에서 인증번호 확인을 해주십시오.");
	        		$("#user_email_check").attr("disabled",false);
	        		$("#emailChk_2").attr("disabled",false);
	        		$("#user_email").attr("readonly",true);
	        		code = data;
	        	}
	        }
	    });
	});
	$("#emailChk_2").click(function(){
		if($("#user_email_check").val() == code){
			alert("인증번호가 일치합니다");
			$("#user_email_check").attr("disabled",true);
			document.getElementById("emailCheck").value="1";
		}else{
			alert("인증번호가 일치하지 않습니다.");
			$("#user_email_check").attr("autofocus",true);
		}
	});

});
</script>

</head>




<!--===========================================
=            Popular deals section            =
============================================-->

<section class="login py-5 border-top-1" style="margin-top: 20px;">
<div class="slideshow-container" style="height:600px">
    <div class="container" style="width:830px; flaot:center">
        <div class="row justify-content-center" style="float:center;">
            <div class="col-lg-5 col-md-8 align-item-center">
            
                <div class="border">
                    <h3 class="bg-gray p-4" style="text-align:center">비밀번호 찾기</h3>
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
								
							<form action="${contextPath}/selectPw_1.do" method="post" onsubmit="return checkfield_1();" accept-charset="utf-8">
								<div id="hidden">
							<div class="mt-3 d-inline-block text-primary">
                        		<h3 style="float:left;margin-top: 12px; margin-right: 40px; margin-left: 30px;">아이디</h3>
                            	<input type="text" placeholder="ID" class="border p-6 " id="user_id" name= "user_id" style="width:300px; float:right">
                            </div>
                            <div class="mt-3 d-inline-block text-primary">
                        		<h3 style="float:left; margin-right: 15px; margin-left: 10px; margin-top:30px;">휴대폰 번호</h3>
                            	<input type="tel" placeholder="Phone-Number" class="border p-6 " id="user_phone" name= "user_phone" style="width:300px; float:center; margin-right:10px; margin-bottom: 10px;">
                            	<button type="button" id="phoneChk" class="d-block py-7 px-4 bg-primary text-white" style="float:right">인증하기</button>
                            	<input type="text" placeholder="Check-Number" class="border p-6 " id="user_phone_check" name= "user_phone_check" style="width:300px; float:center; margin-right:10px" disabled required>
                            	<button type="button" id="phoneChk_2" class="d-block py-7 px-4 bg-primary text-white" style="float:right" disabled>인증확인</button>
                            	<input type="hidden" name="phoneCheck" id="phoneCheck" value="0">
                            </div>
                            <button type="submit" class="border p-3 w-100 my-2">찾기</button>
                            </div>
                            
                            </form>
                            
                            <form action="${contextPath}/selectPw_2.do" method="post" onsubmit="return checkfield_2();" accept-charset="utf-8">
	                            <div id="123">
								<div class="mt-3 d-inline-block text-primary">
	                        		<h3 style="float:left;margin-top: 12px; margin-right: 40px; margin-left: 30px;">아이디</h3>
	                            	<input type="text" placeholder="ID" class="border p-6 " id="user_id" name= "user_id" style="width:300px; float:right">
	                            </div>
		                            <div class="mt-3 d-inline-block text-primary">
	                        		<h3 style="float:left;margin-top: 30px; margin-right: 26px; margin-left: 33px;">이메일&nbsp;&nbsp;</h3>
	                            	<input type="email" placeholder="Email" class="border p-6 " id="user_email" name= "user_email" style="width:300px; float:center;  margin-right:10px; margin-bottom: 10px;" >
	                            	<button type="button" id="emailChk" class="d-block py-7 px-4 bg-primary text-white" style="float:right">인증하기</button>
	                            	<input type="text" placeholder="Check-Number" class="border p-6 " id="user_email_check" name= "user_email_check" style="width:300px; float:center; margin-right:10px" disabled required>
                            		<button type="button" id="emailChk_2" class="d-block py-7 px-4 bg-primary text-white" style="float:right" disabled>인증확인</button>
									<input type="hidden" name="emailCheck" id="emailCheck" value="0">	                           
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


</html>



