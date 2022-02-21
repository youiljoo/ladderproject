<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  pageEncoding="utf-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="pro" value="${proMap.pro}" />
<c:set var="imageFileList" value="${proMap.imageFileList}" />


<!-- header -->
<!DOCTYPE html>
<html>
<head>
    
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mypage.css">

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script>
window.onload=function()
{
	init();
}

function init(){
	var frm_mod_goods=document.frm_mod_goods;	
	
}
</script>


<script type="text/javascript">
	function fn_modify_goods(productNum,attribute){
		var frm_mod_goods=document.frm_mod_goods;
		var value="";
		
		if(attribute=="productName"){
			value=frm_mod_goods.productName.value;
		}else if(attribute=="productPrice"){
			value=frm_mod_goods.productPrice.value;
		}else if(attribute=="productStock"){
			value=frm_mod_goods.productStock.value;
		}else if(attribute=="company"){
			value=frm_mod_goods.company.value;
		}else if(attribute=="productStar"){
			value=frm_mod_goods.productStar.value;
		}else if(attribute=="productInfo"){
			value=frm_mod_goods.productInfo.value;
		}
	
	
	$.ajax({
		type:"post",
		async:false,
		url:"${contextPath}/admin_prod_update_action.do",
		data : {
			productNum:productNum,
			attribute:attribute,
			value:value
		},
		success:function(data,textStatus){
			if(data.trim()=='mod_success'){
				alert("수정이 완료되었습니다.");
			}else if(data.trim()=='failed'){
				alert("다시 시도해 주세요.");
			}
		},
		error:function(data,textStatus){
			alert("에러가 발생했습니다."+data);
		},
		complete:function(data,textStatus){
			//alert("작업을 완료했습니다.");
		}
	}); //end ajax
}
	
	function readURL(input,preview){
		if(input.files&&input.files[0]){
			var reader=new FileReader();
			reader.onload=function(e){
				$('#'+preview).attr('src',e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	
	var cnt=1;
	 function fn_addFile(){
		  $("#d_file").append("<br>"+"<input  type='file' name='detail_image"+cnt+"' id='detail_image"+cnt+"'  onchange=readURL(this,'previewImage"+cnt+"') />");
		  $("#d_file").append("<img id='previewImage"+cnt+"'   width=200 height=200  />");
		  $("#d_file").append("<input  type='button' value='추가'  onClick=addNewImageFile('detail_image"+cnt+"','${imageFileList[0].productNum}','detail_image')  />");
		  cnt++;
	  }
	 
	 function modifyImageFile(fileId,productNum, imageNum,fileType){
		    // alert(fileId);
			  var form = $('#FILE_FORM')[0];
		      var formData = new FormData(form);
		      formData.append("fileName", $('#'+fileId)[0].files[0]);
		      formData.append("productNum", productNum);
		      formData.append("imageNum", imageNum);
		      formData.append("fileType", fileType);
		      
		      $.ajax({
		        url: '${contextPath}/admin_prodimage_update_action.do',
		        processData: false,
		        contentType: false,
		        data: formData,
		        type: 'POST',
			      success: function(result){
			         alert("이미지를 수정했습니다!");
			       }
		      });
		  } 
	
	 function addNewImageFile(fileId,productNum, fileType){
		   //  alert(fileId);
			  var form = $('#FILE_FORM')[0];
		      var formData = new FormData(form);
		      formData.append("uploadFile", $('#'+fileId)[0].files[0]);
		      formData.append("productNum", productNum);
		      formData.append("fileType", fileType);
		      
		      $.ajax({
		          url: '${contextPath}/addNewGoodsImage.do',
		                  processData: false,
		                  contentType: false,
		                  data: formData,
		                  type: 'post',
		                  success: function(result){
		                      alert("이미지를 수정했습니다!");
		                  }
		          });
		  }
	  
	  function deleteImageFile(productNum,imageNum,imageFileName,trId){
		var tr = document.getElementById(trId);

	      	$.ajax({
	    		type : "post",
	    		async : true, //false인 경우 동기식으로 처리한다.
	    		url : "${contextPath}/removeGoodsImage.do",
	    		data: {productNum:productNum,
	     	         imageNum:imageNum,
	     	         imageFileName:imageFileName},
	    		success : function(data, textStatus) {
	    			alert("이미지를 삭제했습니다!!");
	                tr.style.display = 'none';
	    		},
	    		error : function(data, textStatus) {
	    			alert("에러가 발생했습니다."+textStatus);
	    		},
	    		complete : function(data, textStatus) {
	    			//alert("작업을완료 했습니다");
	    			
	    		}
	    	}); //end ajax	
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
        <form name="frm_mod_goods" method="post">
            <div class="order_list21">
            	
						<div class="title_wrap">
							<h2 class="tit_txt" style="text-align:center">상품 상세 정보</h2>
						</div>
						<div class="listTable21">
							<table border="0" cellspacing="0" cellpadding="0" width="100%" class="myP_Ttype1">
								<colgroup>
									<col width="30%">
									<col width="70%">
								</colgroup>
								
								<thead>
									<tr>
									<th>상품번호</th>
									<td>
									<input type="text" name="productNum" value="${pro.productNum}" readonly />
									</td>
									</tr>
									<tr>
									<th>카테고리</th>
									<td>
									<input type="text" name="category" value="${pro.category}" readonly/>
									</td>																		
									</tr>																
									<tr>
									<th>제품명</th>
									<td><input type="text" name="productName" value="${pro.productName}"/></td>
									<td>
									 <input type="button" value="수정반영"  onClick="fn_modify_goods('${pro.productNum}','productName')"/>									
									</td>
									</tr>
									<tr>
									<th>상품 가격</th>
									<td><input type="text" name="productPrice" value="${pro.productPrice}"/></td>
									<td>
									 <input type="button" value="수정반영"  onClick="fn_modify_goods('${pro.productNum}','productPrice')"/>
									</td>
									</tr>
									<tr>
									<th>별점</th>
									<td><input type="text" name="productStar" value="${pro.productStar}"/></td>
									<td>
									 <input type="button" value="수정반영"  onClick="fn_modify_goods('${pro.productNum}','productStar')"/>
									</td>
									</tr>
									<tr>
									<th>제조사</th>
									<td><input type="text" name="company" value="${pro.company}"/></td>
									<td>
									 <input type="button" value="수정반영"  onClick="fn_modify_goods('${pro.productNum}','company')"/>
									</td>
									</tr>
									<tr>
									<th>재고수량</th>
									<td><input type="text" name="productStock" value="${pro.productStock}"/></td>
									<td>
									 <input type="button" value="수정반영"  onClick="fn_modify_goods('${pro.productNum}','productStock')"/>
									</td>
									</tr>
									<tr>
									<th>상세정보</th>
									<td><input type="text" name="productInfo" value="${pro.productInfo}"/></td>
									<td>
									 <input type="button" value="수정반영"  onClick="fn_modify_goods('${pro.productNum}','productInfo')"/>
									</td>
									</tr>
									<tr>
									<th>상품등록일</th>
									<td><input type="text" name="productDate" value="${pro.productDate}" readonly/></td>
									</tr>
									<tr>
									<th>상품 이미지</th>
									<td>
								
									<div id="image_container">
									
									<form id="FILE_FORM" method="post" enctype="multipart/form-data">
									
									<c:forEach var="item" items="${imageFileList}" varStatus="status">				
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이미지${status.count}
										<input type="file"  id="main_image"  name="main_image"  onchange="readURL(this,'preview${status.count}');" />																
										<input type="hidden" name="fileName" value="${item.fileName}" />
										<input type="hidden" name="fileType" value="${item.fileType}" />
										<input type="hidden" name="imageNum" value="${item.imageNum}" />
									
										<img id="preview${status.count}" width=200 height=200 src="${contextPath}/thumbnails.do?productNum=${pro.productNum}&category=${pro.category}&fileName=${item.fileName}" />
										
									</c:forEach>
									<p>이미지1만 메인 이미지이고 나머지는 전부 상세 이미지 입니다.</p>	
									 <td>
						 			<input  type="button" value="수정"  onClick="modifyImageFile('main_image','${pro.productNum}','${item.imageNum}','${item.fileType}')"/>
									</td>
									</form>	
												
									</div>
									</td>
									</tr>
								
									</thead>
									
															
							</table>
													
						</div><br>									
						<div class="div-1">
						<button type="button" class="btn btn-outline-dark" onclick="location='admin_prod.do'">돌아가기</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						
						</div>
					</div>
			</form>	
        </main>
</div>
</section>
    </div>
 
</body>
</html>

 