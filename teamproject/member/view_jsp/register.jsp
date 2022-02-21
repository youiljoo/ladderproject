<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"    
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("utf-8"); %>
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

function init_idCheck(){
	document.getElementById("idCheck").value="0";
}

function init_phoneCheck(){
	document.getElementById("phoneCheck").value="0";
}

function init_nickCheck(){
	document.getElementById("nickCheck").value="0";
}

function init_emailCheck(){
	document.getElementById("emailCheck").value="0";
}

</script>

<script type="text/javascript">

function checkfield(){
	
var name = document.getElementById("user_name");
var id = document.getElementById("user_id");
var pw = document.getElementById("user_pw");
var phone = document.getElementById("user_phone");
var nick = document.getElementById("nickname");
var email = document.getElementById("user_email");
var radio_1 = document.getElementById("check_01");
var radio_2 = document.getElementById("check_02");
var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
var idCheck = $('#idCheck').val();
var phoneCheck = $("#phoneCheck").val();
var nickCheck = $('#nickCheck').val();
var emailCheck = $('#emailCheck').val();

 if(name.value==""){
 alert("이름을 입력하세요");
 return false; 
 
 }else if(id.value==""){
 alert("아이디를 입력하세요");
 return false;
 
 }else if(pw.value==""){
 alert("비밀번호를 입력하세요");
 return false;
 
 }else if(phone.value==""){
 alert("휴대폰 번호를 입력하세요");
 return false;
 
 }else if(nickname.value==""){
 alert("닉네임을 입력하세요");
 return false;
 
 }else if(email.value==""){
 alert("이메일을 입력하세요");
 return false;

 }else if(!radio_1.checked) {
 alert("사다리컴 이용약관 동의를 체크하세요.");
 return false;
 
 }else if(!radio_2.checked) {
 alert("개인정보 수집 및 이용를 체크하세요.");
 return false;

 }else if(idCheck!="1") {
 alert("아이디 중복체크 하세요.");
 return false;
 
 }else if(phoneCheck!="1") {
 alert("휴대폰 인증확인을 하세요.");
 return false;
 
 }else if(nickCheck!="1") {
 alert("닉네임 중복체크 하세요.");
 return false;
 
 }else if(emailCheck!="1") {
 alert("이메일 중복체크 하세요.");
 return false;
 }

 if(exptext.test(addjoin.user_email.value)==false){
 
 alert("이메일 형식이 올바르지 않습니다.");
 return false;
 }
}
</script>

<script type="text/javascript">
function checkSelectAll()  {
	  // 전체 체크박스
	  const checkboxes 
	    = document.querySelectorAll('input[name="chk"]');
	  // 선택된 체크박스
	  const checked 
	    = document.querySelectorAll('input[name="chk"]:checked');
	  // select all 체크박스
	  const selectAll 
	    = document.querySelector('input[name="selectall"]');
	  
	  if(checkboxes.length === checked.length)  {
	    selectAll.checked = true;
	  }else {
	    selectAll.checked = false;
	  }

	}

	function selectAll(selectAll)  {
	  const checkboxes 
	     = document.getElementsByName('chk');
	  
	  checkboxes.forEach((checkbox) => {
	    checkbox.checked = selectAll.checked
	  })
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

</script>
<script>
function fn_overlapped(){
    var _id=$("#user_id").val();
    var idCheck = /^[a-zA-Z0-9]{5,12}$/;
    if(_id==''){
   	 alert("ID를 입력하세요");
   	 return;
    } else if(!idCheck.test(_id)) {
    	alert("ID는 5~12자의 영문 대소문자와 숫자로만 입력해 주세요.");
    	return;
    }
    $.ajax({
       type:"post",
       async:false,  
       url:"${contextPath}/overlapped.do",
       dataType:"text",
       data: {id:_id},
       success:function (data,textStatus){
          if(data=='false'){
       	    alert("사용할 수 있는 ID입니다.");
       	    $('#btnOverlapped').prop("disabled", true);
       	    $('#_user_id').prop("disabled", true);
       	    $('#user_id').val(_id);
       	 	document.getElementById("idCheck").value="1"; //중복확인을 했다는 flag
          }else{
        	  alert("사용할 수 없는 ID입니다.");
        	  $('#user_id').val('');
          }
       },
       error:function(data,textStatus){
          alert("에러가 발생했습니다.");ㅣ
       },
       complete:function(data,textStatus){
          //alert("작업을완료 했습니다");
       }
    });  //end ajax	 
 }	
</script>

<script>
function fn_overlappedNickname(){
    var _nickname=$("#nickname").val();
    var nickCheck = /^[a-zA-Z가-힣0-9]{3,12}$/;
    if(_nickname==''){
   	 alert("닉네임을 입력하세요");
   	 return;
    } else if(!nickCheck.test(_nickname)) {
    	alert("닉네임은 3~12자의 한글, 영문 대소문자와 숫자로만 입력해 주세요.")
     return;
    }
    $.ajax({
       type:"post",
       async:false,  
       url:"${contextPath}/overlappednickname.do",
       dataType:"text",
       data: {nickname:_nickname},
       success:function (data,textStatus){
          if(data=='false'){
       	    alert("사용할 수 있는 닉네임 입니다.");
       	    $('#btnOverlapped').prop("disabled", true);
       	    $('#_nickname').prop("disabled", true);
       	    $('#nickname').val(_nickname);
       	 	document.getElementById("nickCheck").value="1"; //중복확인을 했다는 flag
          }else{
        	  alert("사용할 수 없는 닉네임 입니다.");
        	  $('#nickname').val('');
          }
       },
       error:function(data,textStatus){
          alert("에러가 발생했습니다.");ㅣ
       },
       complete:function(data,textStatus){
          //alert("작업을완료 했습니다");
       }
    });  //end ajax	 
 }	
</script>

<script>
function fn_overlappedEmail(){
    var _email=$("#user_email").val();
    if(_email==''){
   	 alert("이메일을 입력하세요");
   	 return;
    }
    $.ajax({
       type:"post",
       async:false,  
       url:"${contextPath}/overlappedemail.do",
       dataType:"text",
       data: {email:_email},
       success:function (data,textStatus){
          if(data=='false'){
       	    alert("사용할 수 있는 이메일입니다.");
       	    $('#btnOverlapped').prop("disabled", true);
       	    $('#_user_email').prop("disabled", true);
       	    $('#user_email').val(_email);
       	 	document.getElementById("emailCheck").value="1"; //중복확인을 했다는 flag
          }else{
        	  alert("사용할 수 없는 이메일 입니다.");
        	  $('#user_eamil').val('');
          }
       },
       error:function(data,textStatus){
          alert("에러가 발생했습니다.");ㅣ
       },
       complete:function(data,textStatus){
          //alert("작업을완료 했습니다");
       }
    });  //end ajax	 
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

</head>
<!--===========================================
=            Popular deals section            =
============================================-->

<section class="login py-5 border-top-1">
        <div class="container" style="width:900px; flaot:center">
            <div class="row justify-content-center">
                <div class="col-lg-5 col-md-8 align-item-center">
                    <div class="border border" style="width:650px; float:center;">
                        <h3 class="bg-gray p-4" style="text-align:center">회원가입</h3>
                        <form name="addjoin" action="${contextPath}/addmember.do" onsubmit="return checkfield();" accept-charset="utf-8">
                            <fieldset class="p-4"> 
                           	  <div class="mt-3 d-inline-block text-primary">
                        		<h3 style="float:left;margin-top: 12px; margin-right: 50px; margin-left: 40px;">이름</h3>
                            	<input type="text" placeholder="Name" class="border p-6 " id="user_name" name= "user_name" style="width:300px; float:right">
                              </div>
                              
                              <div class="mt-3 d-inline-block text-primary">
                        		<h3 style="float:left;margin-top: 12px; margin-right: 40px; margin-left: 30px;">아이디</h3>
                            	<input type="text" onkeyup= "init_idCheck();" placeholder="Id" class="border p-6 " id="user_id" name= "user_id" value="" style="width:300px; float:center; margin-right:30px">
                            	<button type="button" onClick="fn_overlapped()" id="user_id" class="d-block py-7 px-4 bg-primary text-white" style="float:right">중복확인</button>
                            	<input type="hidden" name="idCheck" id="idCheck" value="0">
                            	<h6>*한글과 여백은 사용하실 수 없습니다</h6>
                    
                           	  </div>
                              <div class="mt-3 d-inline-block text-primary">
                        		<h3 style="float:left;margin-top: 12px; margin-right: 30px; margin-left: 20px;">비밀번호</h3>
                            	<input type="password" onkeyup="checkCapsLock_1(event)" placeholder="Password" class="border p-6 " id="user_pw" name= "user_pw" style="width:300px; float:right">
                              </div>
                              <div class="d-inline-block text-primary" style="width:300px; height:10px;">
                            	<div id="message_1">	</div>
                            </div>
                              <div class="d-inline-block text-primary">
                        		<h3 style="float:left;margin-top: 12px; margin-right: 5px; margin-left: 0px;">비밀번호 확인</h3>
                            	<input type="password" onkeyup="checkCapsLock_2(event)" placeholder="Password" class="border p-6 " id="user_repw" name= "user_repw" style="width:300px; float:right">
                              </div>
                              <div class="d-inline-block text-primary" style="width:300px; height:10px;">
                            	<div id="message_2">	</div>
                            </div>
                              <div class="d-inline-block text-primary">
                        		<h3 style="float:left;margin-top: 32px; margin-right: 20px; margin-left: 5px;">휴대폰 번호</h3>
                            	<input type="tel" placeholder="Phone-Number" class="border p-6 " id="user_phone" name= "user_phone" style="width:300px; float:center; margin-right:10px">
                            	<button type="button"  id="phoneChk" class="d-block px-4 bg-primary text-white" style="float:right; margin-right:25px; margin-top:5px;">인증하기</button>
                            	<input type="tel" placeholder="Check-Number" class="border p-6 " id="user_phone_check" name= "user_phone_check" style="width:300px; float:center; margin-right:10px" disabled required>
                            	<button type="button" id="phoneChk_2" class="d-block px-4 bg-primary text-white" style="float:right; margin-right:25px; margin-top:5px" disabled>인증확인</button>
                            	<input type="hidden" name="phoneCheck" id="phoneCheck" value="0">
                              </div>
                              <div class="mt-3 d-inline-block text-primary">
                        		<h3 style="float:left;margin-top: 12px; margin-right: 40px; margin-left: 30px;">닉네임</h3>
                            	<input type="text" onkeyup= "init_nickCheck();" placeholder="NickName" class="border p-6 " id="nickname" name= "nickname" style="width:300px; float:center; margin-right:30px">
                            	<button type="button" onClick="fn_overlappedNickname()" class="d-block py-7 px-4 bg-primary text-white" style="float:right">중복확인</button>
                            	<input type="hidden" name="nickCheck" id="nickCheck" value="0">
                           	  </div>
                              <div class="mt-3 d-inline-block text-primary">
                        		<h3 style="float:left;margin-top: 12px; margin-right: 20px; margin-left: 5px;">이메일 주소</h3>
                            	<input type="text" onkeyup= "init_emailCheck();" placeholder="Email" class="border p-6 " id="user_email" name= "user_email" style="width:300px; float:center; margin-right:30px">
                            	<button type="button" onClick="fn_overlappedEmail()" class="d-block py-7 px-4 bg-primary text-white" style="float:right">중복확인</button>
                            	<input type="hidden" name="emailCheck" id="emailCheck" value="0">
                              </div>
                              <div class="mt-3 d-inline-block text-primary" >
                        		<h3 style="float:left;margin-top: 20px; margin-right: 40px; margin-left: 20px;">알림설정</h3>
								<div class="form-check form-check-inline" style="float:left;margin-top: 20px; margin-right: 20px; margin-left: 5px;">
								  <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
								  <label class="form-check-label" for="inlineCheckbox1">email</label>
								</div>
								<div class="form-check form-check-inline" style="float:left;margin-top: 20px; margin-right: 20px; margin-left: 5px;">
								  <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
								  <label class="form-check-label" for="inlineCheckbox2">SMS</label>
								</div>
								   
								</div>
								<div class="agreement-container">
								<div class="agreement-allcheck" style="margin-top:16px"> 
						           <input type="checkbox" id="checkall" name="selectall" class="input-text" onclick='selectAll(this)' style="margin-top:0px">
						            <label for="allcheck"><h6>전체동의 (선택사항 포함)</h6></label>
						             </div> 
						             <div class="check-group"> 
						             <input type="checkbox" id="check_01" class="input-text" name="chk" onclick="checkSelectAll()"> 
						             <label for="check_01">(필수) 사다리컴 이용약관</label> 
						             </div> 
						             <div class="check-group">
						              <input type="checkbox" id="check_02" class="input-text" name="chk" onclick="checkSelectAll()">
						               <label for="check_02">(필수) 개인정보 수집 및 이용</label>
						               </div> 
						               <div class="check-group">
						                <input type="checkbox" id="check_03" class="input-text" style="float:left; margin-right:5px; margin-top:5px;" name="chk" onclick="checkSelectAll()">
						               <label for="check_03" style="float:left;margin-right:300px;margin-bottom: 30px;">(선택) 광고성 정보 수신 동의</label> 
						               
						                <button type="submit" class="d-block py-7 px-4 bg-primary text-white" style="float:left; margin-left:130px; margin-right:25px;">회원가입완료</button>   
                            			<button type="button" onclick="history.back()" class="d-block py-7 px-4 bg-primary text-white" style="float:left; margin-right:25px; ">돌아가기</button>
								  </div>                            
                            	</div>
                               </fieldset>
                            </form>
						 </div>
					 </div>         
                </div>
            </div>
    </section>
</body>
</html>