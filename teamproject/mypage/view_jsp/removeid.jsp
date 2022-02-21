<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  pageEncoding="utf-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- header -->
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mypage_pw.css">
   
</head>
  <script>

  var result = '${result}';
  if(result === 'removeFalse') {
	  alert('비밀번호를 다시 입력해 주세요.');
  }

</script>

<body>
   <!-- contents --> 
   
  <div id = "contents">
  <div class="wrapper">
            <div class="sadari__fieldset">
                <div class="fieldset__title">
                    <p class="title__main">비밀번호 확인</p>
                    <p class="title__sub">
                        <span>고객님의 정보를 보호하기 위해 비밀번호를 확인합니다.</span>
                    </p>
                </div>
                <div class="fieldset__verification">
                    <div class="verification__content">
                        <div class="active">
                            <form name="pass_form" method="post" action="${contextPath }/deleteid.do">
                                <input type="hidden" name="mode" value="check">
								<input type="hidden" id = "user_id" name="user_id" value="${user_id }">
                                <ul class="verification__list">
                                    <li>
                                        <div class="item__data">
                                        	
                                            <input type="password" id="user_pw" name="user_pw" placeholder="Password">
                                                                                    </div>
                                    </li>
                                    
                                </ul>

                                <div class="verification__button">
                                     <input type="submit" value="탈퇴하기"  class="button__item item--submit">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
  </div>   

</body>
</html>



