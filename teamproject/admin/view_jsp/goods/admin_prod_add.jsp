<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  pageEncoding="utf-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- header -->
<!DOCTYPE html>
<html>
<head>
    
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mypage.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
   function readURL(input) {
      if (input.files && input.files[0]) {
	      var reader = new FileReader();
	      reader.onload = function (e) {
	        $('#preview').attr('src', e.target.result);
          }
         reader.readAsDataURL(input.files[0]);
      }
  }
   
   function categoryChange(e) {
	    var good_a = ["19인치 이하", "23~25인치", "27~31인치", "32인치 이상", "게이밍 모니터","모니터암,어댑터"];
	    var good_b = ["유선마우스", "무선마우스", "게이밍 마우스", "마우스패드"];
	    var good_c = ["기계식 키보드", "게이밍 키보드", "무접점 키보드", "무선 키보드"];
	    var good_d = ["2채널", "2.1채널 이상", "사운드바"];
	    var good_e = ["헤드셋", "악세사리"];
	    var target = document.getElementById("good");
	 
	    if(e.value == "Monitor") var d = good_a;
	    else if(e.value == "Mouse") var d = good_b;
	    else if(e.value == "Keyboard") var d = good_c;
	    else if(e.value == "Speaker") var d = good_d;
	    else if(e.value == "Headset") var d = good_e;
	 
	    target.options.length = 0;
	 
	    for (x in d) {
	        var opt = document.createElement("option");
	        opt.value = d[x];
	        opt.innerHTML = d[x];
	        target.appendChild(opt);
	    }    
	}
   
   var cnt=0;
   function fn_addFile(){
 	  if(cnt == 0){
 		  $("#d_file").append("<br>"+"<input  type='file' name='main_image' id='f_main_image' />");	  
 	  }else{
 		  $("#d_file").append("<br>"+"<input  type='file' name='detail_image"+cnt+"' />");
 	  }
   	
   	cnt++;
   }
   
   function fn_add_new_goods(obj){
		 fileName = $('#f_main_image').val();
		 if(fileName != null && fileName != undefined){
			 obj.submit();
		 }else{
			 alert("메인 이미지는 반드시 첨부해야 합니다.");
			 return;
		 }
		 
	}
  
 

</script>
<style>
	.div-1{
		padding : 25px;
		margin: 0 auto;
		display:block;
		text-align : center;
	}	
</style>
</head>
<body>
     <!-- contents --> 
  <div id = "contents">
    <!-- 관리자 페이지 -->
 <section class="flex-center3">
 <div>
<div class="myP_left">
<ul class="my_gnb">
						<li class="depth1">
							<a class="depth1_b_m" href="${contextPath}/admin_main.do" >관리자 페이지</a>
								<ul>
									<li><a href="${contextPath}/admin_member.do">회원 관리</a></li>
									<li><a href="${contextPath}/admin_order.do">주문 관리</a></li>
									<li><a href="${contextPath}/admin_prod.do">상품 관리</a></li>
									<li><a href="${contextPath}/admin_review.do">후기 관리</a></li>
									<li><a href="${contextPath}/admin_board_main.do">게시판 관리</a></li>
								</ul>
						</li>
</ul>			
</div> 
        <main>
        <div class="title_wrap"><h2 class="tit_txt">관리자 페이지</h2></div> <hr>
        
            <div class="order_list21">
            	
					<div class="title_wrap">
							<h2 class="tit_txt" style="text-align:center">상품 등록</h2>
					</div>
			<form class="form-horizontal form_align" role="form" method="post" enctype="multipart/form-data" action="${contextPath}/admin_prod_add.do">
						<div class="listTable21">
            
            
            	<div class="form-group">
                    <label for="prodNum" class="col-lg-2 control-label"></label>
                    <div class="col-lg-10">
                        <input type="hidden" class="form-control onlyHangul" name="productNum" id="prodNumber" placeholder="숫자만 입력하세요." data-rule-required="true"  maxlength="15">
                    </div>
                </div>
            	
                <div class="form-group">
                    <label class="col-lg-2 control-label">1차 카테고리</label>
                    <div class="col-lg-10">
                      
  								<select id="category" name="category" onchange="categoryChange(this)" class="form-control onlyHangul">
    								<option>선택</option>
    								<option value="Monitor">모니터</option>
    								<option value="Mouse">마우스</option>
    								<option value="Keyboard">키보드</option>
    								<option value="Speaker">스피커</option>
    								<option value="Headset">헤드셋</option>
  								</select>
					
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-lg-2 control-label">2차 카테고리</label>
                    <div class="col-lg-10">
                       
  								<select name="subcategory" id="good" class="form-control onlyHangul">
    								<option>선택</option>
    							
    								    								    							
  								</select>
						
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-lg-2 control-label">제품명</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="productName" name="productName" data-rule-required="true" maxlength="30">
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-lg-2 control-label">판매가</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="productName" name="productPrice" placeholder="숫자만 입력하세요." data-rule-required="true" maxlength="30">
                    </div>
                </div>
                
                
                <div class="form-group">
                    <label class="col-lg-2 control-label">제조사</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="prodmake" name="company" data-rule-required="true"  maxlength="40">
                    </div>
                </div>
                
                
                <div class="form-group">
                    <label class="col-lg-2 control-label">재고수량</label>                    
                    <div class="col-lg-10">
                        <input type="text" class="form-control onlyNumber" id="prodNum" name="productStock" data-rule-required="true" placeholder="숫자만 입력하세요." maxlength="11">
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-lg-2 control-label">상세정보</label>
                    <div class="col-lg-10">            
                             <textarea name="productInfo" rows="10" cols="65" class="form-control onlyNumber" maxlength="4000"></textarea>                                            
                    </div>
                </div>
                
                
                <div class="form-group">
                    <label class="col-lg-3 control-label">제품 이미지 선택하기</label><hr width="80%">
                    <div class="col-lg-10">            
                             <input type="button" class="btn btn-outline-dark" value="파일 추가" onClick="fn_addFile()" />
                             <div id="d_file">
                             </div>                                           
                    </div>
                </div>
                
                <br><br>
                
                           
                </div>
                <div class="div-1">                    
                        <button type="submit" class="btn btn-outline-dark" onClick="fn_add_new_goods(this.form)">등록하기</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="button" class="btn btn-outline-dark" onclick="location='admin_prod.do'">취소하기</button>
                    </div>
                </form>   
                </div>
            
        </main>
        </div>
       </section>
        </div>				
						
						
        


  
</body>
</html>

 