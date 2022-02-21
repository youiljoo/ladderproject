<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- header -->
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mypagechange.css">
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

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
$(function(){

	//비밀번호 확인
		$('#user_repw').blur(function(){
		   if($('#user_pw').val() != $('#user_repw').val()){
		    	if($('#user_repw').val()!=''){
			    alert("비밀번호가 일치하지 않습니다.");
		    	    $('#user_repw').val('');
		          $('#user_repw').focus();
		       }
		    }
		})  	   
	});

</script>

<script>

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
var pw = document.getElementById("user_pw");
var repw = document.getElementById("user_repw");
var phone = document.getElementById("user_phone");
var nick = document.getElementById("nickname");
var email = document.getElementById("user_email");
var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
var phoneCheck = $("#phoneCheck").val();
var nickCheck = $('#nickCheck').val();
var emailCheck = $('#emailCheck').val();

 if(name.value==""){
 alert("이름을 입력하세요");
 return false; 
 
 }else if(nickname.value==""){
 alert("닉네임을 입력하세요");
 return false;
 
 }else if(pw.value==""){
 alert("비밀번호를 입력하세요");
 return false;
 
 }else if(repw.value=="") {
 alert("비밀번호 확인을 입력해주세요");
 return false;
 
 }else if(email.value==""){
 alert("이메일을 입력하세요");
 return false;
 
 }else if(phone.value==""){
 alert("휴대폰 번호를 입력하세요");
 return false;
 
 }else if(nickCheck!="1") {
 alert("닉네임 중복체크 하세요.");
 return false;
 
 }else if(emailCheck!="1") {
 alert("이메일 중복체크 하세요.");
 return false;
 
 }else if(phoneCheck!="1") {
 alert("휴대폰 인증확인을 하세요.");
 return false;
 }
 
 if(exptext.test(addjoin.user_email.value)==false){
 
 alert("이메일 형식이 올바르지 않습니다.");
 return false;
 }
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
    	alert("닉네임은 3~12자의 한글, 영문 대소문자와 숫자로만 입력해 주세요.");
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
<body>
<section>
  <div class = "contents">
  
  <div class="sadari_section">
        <div class="wrapper">
            <div class="sadari__fieldset">
            <form action="${contextPath }/memberedit.do" onsubmit="return checkfield()" method="post" accept-charset="utf-8">
                <div class="fieldset__title">
                    <p class="title__main">회원정보 수정</p>
                </div>
                <div class="fieldset__write">   
                        <div class="write__content">
                            <div class="write__list">
                            <ul>
                                  <li>

                                        <input type="hidden" id="user_id" name="user_id" value="${user_id }" >


                                    <p class="item__title">이름</p>
                                    <div class="item__data">
                                        <input type="text" id="user_name" name="user_name" placeholder="Name">
                                    </div>
                                </li>
                                <li>
                                    <p class="item__title">닉네임</p>
                                    <div class="item__data">
                                        <input type="text" onkeyup= "init_nicknameCheck();" id="nickname" name="nickname" placeholder="Nickname">
                                        <button type="button" onClick="fn_overlappedNickname()" style="width:80px; height:48px; float:right; font-size:12px">중복확인</button>
                                        <input type="hidden" name="nickCheck" id="nickCheck" value="0">
                                    </div>
                                </li>
                                  <li>
                                    <p class="item__title">변경할 비밀번호</p>
                                    <div class="item__data">
                                        <input type="password" onkeyup="checkCapsLock_1(event)" id="user_pw" name="user_pw" placeholder="password"> 
                                    </div>
                                     <div class="d-inline-block text-primary" style="width:300px; height:10px;">
                            	<div id="message_1">	</div>
                            </div>
                                </li>
                                
                                  <li>
                                    <p class="item__title">변경할 비밀번호 확인</p>
                                    <div class="item__data">
                                        <input type="password" onkeyup="checkCapsLock_2(event)" id="user_repw" name="user_repw" placeholder="password">
                                    </div>
                                     <div class="d-inline-block text-primary" style="width:300px; height:10px;">
                            	<div id="message_2">	</div>
                            </div>
                                </li>
                                 <li>
                                    <p class="item__title">이메일</p>
                                    <div class="item__data">
                                        <input type="text" onkeyup= "init_emailCheck();" id="user_email" name="user_email" placeholder="E-mail">
                                        <button type="button" onClick="fn_overlappedEmail()" style="width:80px; height:48px; float:right; font-size:12px">중복확인</button>
                                        <input type="hidden" name="emailCheck" id="emailCheck" value="0">
                                    </div>
                                </li>      
                                <li>
                                    <p class="item__title">휴대폰 번호</p>
                                    <div class="item__data">
                                        <input type="tel" id="user_phone" name="user_phone" maxlength="13" placeholder="Phone_Number">
                                        <button type="button"  id="phoneChk" style="width:80px; height:48px; float:right; font-size:12px" >인증하기</button>
                                    </div>
                                </li>
                                <li>
	                               	<p class="item__title">휴대폰 인증</p>
	                            	<div class="item__data">
	                            		 <input type="text" placeholder="Check-Number" id="user_phone_check" name= "user_phone_check" maxlength="13" disabled required>
	                             		 <button type="button" id="phoneChk_2" style="width:80px; height:48px; float:right; font-size:12px" disabled>인증확인</button>
	                                     <input type="hidden" name="phoneCheck" id="phoneCheck" value="0">
	                              	</div>
	                           </li>
                            </ul>
                        <div class="write__button col--2">
                            <button type="submit" class="button__item item--submit">수정하기</button>
                            <a href="/teamproject/mypage.do" class="button__item item--cancel">취소하기</a>
                        </div>
                       
                        </div>
                    	</div>
                    </div>
                        </form> 
                </div>
               
            </div>
            
        </div>

    </div>
</section>
</body>
</html>



