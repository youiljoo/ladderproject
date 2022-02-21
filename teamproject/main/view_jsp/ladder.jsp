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

<script language="javascript" type="text/javascript">

var Yl = {
 getEl : function(strId){
  if (document.getElementById) return document.getElementById(strId); 
  if (document.all) return document.all[strId];
 }
 //div 리턴
 ,getDiv : function(sWidth, sHeight, sBgColor){
  var d = document.createElement("div");
  if(sWidth) d.style.width = sWidth;
  if(sHeight) d.style.height = sHeight;
  if(sBgColor) d.style.backgroundColor = sBgColor;
  d.style.position = "absolute";
  d.style.overflow = "hidden";  
  return d;
 }
 ,arrColor : [
  '#8c7301','#9b014f','#0084a0','#ad8e00','#bb005f'
  ,'#00a0c2','#8d3901','#8f0197','#156200','#9ca53b'
  ,'#c9a601','#d6006d','#01b6de','#80adaf','#a44201'
  ,'#e0b800','#ec0078','#0021b0','#92b7d7','#013add'
  ]  
 ,arrVerDiv : [] //수직 선 div
 ,arrHorDiv : [] //수평 선 div
 ,arrMovDiv : [] //이동 선 div
 
 ,arrIng : [] //진행여부 체크용

 ,arrMDiv : [] //이동선 배열 번호값 저장, 이동후 확인용
  
 ,nMaxWidth : 1000 //최고 넓이
 ,nWidth : 0 //사다리 넓이
 ,nHeight : 300 //사다리 높이
 
 ,nNum : 0
 
 ,arrTopDiv : [] //탑 div
 ,arrBotDiv : [] //아래 div
 ,arrGoDiv : [] //go 버튼 div
 
 ,init : function(){
  
  //갯수
  this.nNum = parseInt(this.getEl("sel_num").value);
  
  //넓이
  this.nWidth = parseInt(this.nMaxWidth/this.nNum);
        
  for(var i=0; i<this.nNum; i++){
 
   this.arrTopDiv[i] = this.getDiv(this.nWidth+"px", "50px", "");
   this.arrBotDiv[i] = this.getDiv(this.nWidth+"px", "50px", "");
   this.arrGoDiv[i] = this.getDiv(this.nWidth+"px", "30px", "");
                     
   this.arrTopDiv[i].style.left = (i*this.nWidth)+"px";
   this.arrTopDiv[i].style.top = "20px";
   
   this.arrBotDiv[i].style.left = (i*this.nWidth)+"px";
   this.arrBotDiv[i].style.top = "410px";
   
   this.arrGoDiv[i].style.left = (i*this.nWidth)+"px";
   this.arrGoDiv[i].style.top = "70px";
   
   this.arrTopDiv[i].style.fontSize="12px";
   this.arrBotDiv[i].style.fontSize="12px";
   
   //this.arrTopDiv[i].style.border = "1px solid #CCCCCC";
   //this.arrBotDiv[i].style.border = "1px solid #CCCCCC";
   
   this.arrTopDiv[i].align = "center";
   this.arrBotDiv[i].align = "center";
   this.arrGoDiv[i].align = "center";

   this.arrTopDiv[i].innerHTML = (i+1)+'<br><input type="text" id="inp_top_'+i+'" value="" style="width:90%; text-align:center" tabindex="'+(i+1)+'" />';
   this.arrBotDiv[i].innerHTML = '<input type="text" id="inp_bot_'+i+'" value="" style="width:90%; text-align:center" tabindex="'+((i+1)+50)+'" />';

   this.getEl("div_body").appendChild(this.arrTopDiv[i]);  
   this.getEl("div_body").appendChild(this.arrBotDiv[i]);
   this.getEl("div_body").appendChild(this.arrGoDiv[i]);  
   
     
   this.arrVerDiv[i] = this.getDiv("1px", this.nHeight+"px", "#bbbbbb");
        
   this.arrVerDiv[i].style.left = ( (i*this.nWidth)+parseInt(this.nWidth/2) )+"px";
   this.arrVerDiv[i].style.top = "100px";
        
   this.getEl("div_body").appendChild(this.arrVerDiv[i]); 
        
  }
  
  this.getEl("div_step1").style.display = "none";
  this.getEl("div_step2").style.display = "";  
  
 }
 ,create : function(){ //사다리 생성
    
  for(var i=0; i<this.nNum; i++){
   
   this.arrTopDiv[i].innerHTML = (i+1)+"<br>"+this.getEl("inp_top_"+i).value;
   this.arrBotDiv[i].innerHTML = this.getEl("inp_bot_"+i).value;
   this.arrGoDiv[i].innerHTML = '<input type="button" value="GO" onClick="Yl.start('+i+')">';
      
   this.arrTopDiv[i].style.overflow = "auto";
   this.arrBotDiv[i].style.overflow = "auto";
        
   this.arrIng[i] = false;
           
   this.arrMDiv[i] = [];   
  }
      
  for(var i=0; i<(this.nNum*7); i++){
   
   var nLen = this.arrHorDiv.length;
   
   this.arrHorDiv[nLen] = this.getDiv(this.nWidth+"px","1px", "#aaaaaa");

   var nRndLeft = (parseInt(Math.random()*(this.nNum-1))*this.nWidth)+parseInt(this.nWidth/2);
   var nRndTop = this.getRndTop();
            
   this.arrHorDiv[nLen].style.left = nRndLeft+"px";
   this.arrHorDiv[nLen].style.top = nRndTop+"px";
       
   this.getEl("div_body").appendChild(this.arrHorDiv[nLen]);    
  }
  
  this.getEl("div_step2").innerHTML = "GO 버튼을 눌러 주세요.";
  
 }
 ,sRndTop : ""
 ,getRndTop : function(){
  var nRnd = parseInt(Math.random()*(this.nHeight-100))+150; 
  
  if( this.sRndTop.indexOf( "["+nRnd+"]" ) < 0 ){
   this.sRndTop += "["+nRnd+"]";
   return nRnd;
  }else{
   return this.getRndTop();   
  }
 } 
 ,start : function( no ){
  
  if( this.arrIng[no] ){
   for(var i=0; i<this.arrMDiv.length; i++){
    for(var j=0; j<this.arrMDiv[i].length; j++){
     this.arrMovDiv[this.arrMDiv[i][j]].style.backgroundColor = "#CCCCCC"; 
     this.arrMovDiv[this.arrMDiv[i][j]].style.zIndex = 1;
    }
    
   }
   for(var i=0; i<this.arrMDiv[no].length; i++){
    this.arrMovDiv[this.arrMDiv[no][i]].style.backgroundColor = "#0000ff";
    this.arrMovDiv[this.arrMDiv[no][i]].style.zIndex = 2;
   }
  }else{
               
   var nSx = parseInt(this.arrVerDiv[no].style.left);
   var nSy = parseInt(this.arrVerDiv[no].style.top);
   
   this.moveStart("y", no, nSx, nSy);
   
   this.arrIng[no] = true; //진행
  }
 
 }
 ,moveStart : function(sXy, pno, nSx, nSy){
    
  var nLen = this.arrMovDiv.length;
  
  this.arrMovDiv[nLen] = this.getDiv("2px","2px", this.arrColor[pno]);
  
  this.arrMDiv[pno].push(nLen);
    
  this.getEl("div_body").appendChild(this.arrMovDiv[nLen]);  
  
  this.arrMovDiv[nLen].style.left = nSx+"px";
  this.arrMovDiv[nLen].style.top = nSy+"px";
  
  this.arrMovDiv[nLen].style.zIndex = 3;
  
  
  var nEx = nSx;
  var nEy = nSy;
  if(sXy=="y") nEy = this.nHeight+100;
        
  var bCk = false;
  
  for(var i=0; i<this.arrHorDiv.length; i++){
   
   var nx = parseInt(this.arrHorDiv[i].style.left);
   var ny = parseInt(this.arrHorDiv[i].style.top);  
   var nw = parseInt(this.arrHorDiv[i].style.width);
   var nh = parseInt(this.arrHorDiv[i].style.height);
   
   if(sXy=="x"){
    if( ny == nSy ){
     if( nx==nSx ){
      nEx = nx+nw;
      break;
     }else if( (nx+nw)==nSx ){
      nEx = nx;
      break;
     }     
    }
   }else{
    
    //반복하면서 큰것중에서 제일 작은것으로        
    if( ny>nSy ){

     if( nx==nEx || (nx+nw)==nEx ){
            
      if(bCk){
       if(ny<nEy) nEy = ny;
      }else
       nEy = ny; 
       
      bCk = true; 
     } 
    }
   }
  }
  
  this.move(nLen, pno, nSx, nSy, nEx, nEy);     
 }
 ,nSpeed : 10
 ,move : function(no, pno, nSx, nSy, nEx, nEy){

  var nx = parseInt(this.arrMovDiv[no].style.left);
  var ny = parseInt(this.arrMovDiv[no].style.top);  
  var nw = parseInt(this.arrMovDiv[no].style.width);
  var nh = parseInt(this.arrMovDiv[no].style.height);
  
  var np;
  var bIng = true;
  
  var sXy = "";
  
  if( nSx != nEx ){
   np = nw+this.nSpeed;
   if(nEx<nSx){
    if( (nSx-np) <= nEx ){
     bIng = false;
     np = nSx-nEx;
    }   
    this.arrMovDiv[no].style.left = (nSx-np)+"px"; 
   }else{
    if( (nSx+np) >= nEx ){
     bIng = false;
     np = nEx-nSx;
    }       
   }
   
   this.arrMovDiv[no].style.height = "4px";
   this.arrMovDiv[no].style.width = np+"px"; 
   
   sXy = "x";
  }else{
    
   np = nh+this.nSpeed;
   if( (nSy+np) >= nEy ){
    bIng = false;
    np = nEy-nSy;
   }
  
   this.arrMovDiv[no].style.width = "4px";   
   this.arrMovDiv[no].style.height = np+"px";   
   
   sXy = "y";
  }

    
  if(bIng){
        
   setTimeout("Yl.move("+no+","+pno+","+nSx+","+nSy+","+nEx+","+nEy+")", 1);
   
  }else{
   
   if((sXy=="x")) this.arrMovDiv[no].style.height = "2px";
   else this.arrMovDiv[no].style.width = "2px";
   
   if( nEy<this.nHeight+100 ){
    this.moveStart((sXy=="x")?"y":"x", pno, nEx, nEy);
   }else{
    
    for(var i=0; i<this.arrVerDiv.length; i++){
     if(nEx==parseInt(this.arrVerDiv[i].style.left)){      
      
      this.arrBotDiv[i].innerHTML = "<b>"+(pno+1)+"</b><br>"+this.arrBotDiv[i].innerHTML;
            
      this.arrGoDiv[pno].innerHTML = '<input type="button" value="확인" onClick="Yl.start('+pno+')">';
      
      break;
     }
    }  
   }
  }
 }
};


</script>

</head>

<body>
<section class="popular-deals section bg-gray"
style="padding-top: 40px; padding-bottom: 20px;">
<h5 style="text-align:center">※결정이 어려우신 분들을 위한 게임입니다. 재미로만 해주시고 선택은 본인의 몫 입니다</h5>
</section>
<section class="login border-top-1" style="padding-bottom:20px;">
<div class="container" style="width:1000px; flaot:center">
<div id="div_step1" style="font-size:12px; float:center">


<select id="sel_num">
 <option value="2">2</option>
 <option value="3">3</option>
 <option value="4">4</option>
 <option value="5" selected >5</option>
</select>
개

<input type="button" value="만들기" onclick="Yl.init();">

</div>


<div id="div_step2" style="font-size:12px;display:none;">
 입력후 게임 시작 <input type="button" value="시작" onclick="Yl.create();">
</div>

 

<div id="div_body" style="width:1000px;height:450px;border:1px solid #CCCCCC;position:relative;"></div>
</div>

</section>
</body>
</html>