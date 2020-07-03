<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매장정보조회</title>
 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<script type="text/javascript">
	var gym_id = "";
	var gym_username= "";
	var gym_usertell = "";
	var gym_name = "";
	var gym_tel = "";
	var gym_addr = "";
	var gym_addr_dtl = "";
	var gym_zipcode = "";
	var gym_number = "";
	var gym_profimg = "";
	var gym_info = "";
	var gym_parking = "";
	var gym_wash = "";
	var gym_uniform = "";
	var gym_locker = "";
	var gym_like = "";
	var pw_check = 1;
	var imageOk = 1;
	
	
	function infoUPD(){
		$.ajax({
			url : "../gym/gymInfoUpd.jsp"
		  , success : function(data){
			  $("#d_info").html(data)
		  }
		});
	}
	function infoUPD_save(){
		//alert("저장");
		if(pw_check == 1) {
			alert("비밀번호를 입력 해주세요 ");
		} else {
			if(imageOk == 1) {
				alert("이미지를 등록 해주세요 ");
			} else {
				$("#f_infoUpd").attr('action', "gymInfoUpd.gym")
				$("#f_infoUpd").submit();
			}
		}
	}
	function pw_confirm() {
		//alert("비번확인");
		var gym_pw = $('#gym_pw').val();
		var gym_pw_2 = $('#gym_pw_2').val();
		if( gym_pw.length>7 && gym_pw.length <= gym_pw_2.length) {
			if(gym_pw == gym_pw_2) {
				//alert("확인되었습니다");
				$('#pw_icon').html('<i class="material-icons" style="font-size:36px;color:green">done</i>');
				pw_check = 0;
			} else {
				//alert("비밀번호가 다릅니다.");
				$('#pw_icon').html('<i class="material-icons" style="font-size:36px;color:red">clear</i>');
				pw_check = 1;
			}
		} else {
			$('#pw_icon').html('<i class="material-icons" style="font-size:36px;color:red">clear</i>');
			pw_check = 1;
		}
	}
	function addrSearch() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            var result = JSON.stringify(data);
	            var addrDoc = JSON.parse(result);
	            $('#gym_addr').val(addrDoc.address);
	            $('#gym_zipcode').val(addrDoc.zonecode);
	        }
	    }).open();
	}
</script>
<div style="padding: 20px;" id="d_info">
		<div class="form-group row form-inline" style="width:100%;">
		  <div class="w-75" style="min-width:100px;"><h3><b>매장관리</b> / 매장 정보 조회</h3></div>  <!-- 제목 틀 입니다. -->
			  <div class="w-25">
				   <button type="button" class="btn btn-primary" onClick="infoUPD()" style="float:right">수정</button>
			  </div>
	   	</div>
    <hr>
    <!--=========================== 내용 시작 ===========================-->
		<div class="form-group row ">
			<label for="gym_id" class="col-sm-2" width="10px"><b>아이디</b></label>
			<label id="gym_id" class="col-sm-5"></label>
		</div>
		<div class="form-group row">
			<label for="gym_username" class="col-sm-2"><b>이름 </b></label>
			<label id="gym_username" class="col-sm-5"></label>
		</div>
		<div class="form-group row">
			<label for="gym_usertell" class="col-sm-2"><b>전화번호</b></label>
			<label id="gym_usertell" class="col-sm-5"></label>
		</div>
		<div class="form-group row">
			<label for="gym_name" class="col-sm-2"><b>매장이름</b></label>
			<label id="gym_name" class="col-sm-5"></label>
		</div>
		<div class="form-group row">
			<label for="gym_tel" class="col-sm-2"><b>매장번호</b></label>
			<label id="gym_tel" class="col-sm-5"></label>
		</div>
		<div class="form-group row">
			<label for="gym_addr" class="col-sm-2"><b>매장주소</b></label>
			<label id="gym_addr" class="col-sm-5"></label>
		</div>
		<div class="form-group row">
			<label for="gym_addr_dtl" class="col-sm-2"><b>매장상세주소</b></label>
			<label id="gym_addr_dtl" class="col-sm-5"></label>
		</div>
		<div class="form-group row">
			<label for="gym_zipcode" class="col-sm-2"><b>우편번호</b></label>
			<label id="gym_zipcode" class="col-sm-5"></label>
		</div>
		<div class="form-group row">
			<label for="gym_number" class="col-sm-2"><b>사업자번호</b></label>
			<label id="gym_number" class="col-sm-5"></label>
		</div>
		<div class="form-group row form-inline ">
			<label for="gym_profimg" class="col-sm-2"><b>매장 프로필 사진</b></label>
			<div class="p-1 m-3 continer border rounded" style="padding: 0">
				<div class="cropping" style="margin: 0">
					<img id="gym_profimg" alt="디비 사진" src="#">
				</div>
			</div>
		</div>
		<div class="form-group row form-inline">
			<label for="gym_info" class="col-sm-2"><b>매장소개</b></label>
			<div class="w-75 px-3 py-3 m-3 continer border rounded" id = "gym_info"></div>
		</div>
		<div class="form-group row form-inline">
			<label for="gym_info" class="col-sm-2"><b>편의시설</b></label>
			<div id="gym_info" class="w-75 px-5 py-3 m-3 container border rounded">
				<div class="form-group row">
					<div class="form-check form-check-inline">
						<input type="checkbox" disabled id="gym_parking"> 
						<label class="form-check-label" for="gym_parking">주차장</label>
					</div>
					<div class="form-check form-check-inline">
						<input type="checkbox"  disabled id="gym_wash"> 
						<label class="form-check-label" for="gym_wash">샤워실</label>
					</div>
					<div class="form-check form-check-inline">
						<input type="checkbox" disabled id="gym_uniform"> 
						<label class="form-check-label" for="gym_uniform">유니폼</label>
					</div>
					<div class="form-check form-check-inline">
						<input type="checkbox" disabled id="gym_locker"> 
						<label class="form-check-label" for="gym_locker">락커룸</label>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			url : "../gym/jsonGymInfoList.gym"
		  , success : function(result){
			  var infoList = JSON.parse(result.trim());
			  
			  gym_id= infoList[0].GYM_ID;
			  gym_username= infoList[0].GYM_USERNAME;
			  gym_usertell = infoList[0].GYM_USERTELL;   
			  gym_name = infoList[0].GYM_NAME;   
			  gym_tel = infoList[0].GYM_TEL;   
			  gym_addr = infoList[0].GYM_ADDR;   
			  gym_addr_dtl = infoList[0].GYM_ADDR_DTL;   
			  gym_zipcode = infoList[0].GYM_ZIPCODE;   
			  gym_number = infoList[0].GYM_NUMBER;   
			  gym_profimg = infoList[0].GYM_PROFIMG;   
			  gym_info = infoList[0].GYM_INFO;   
			  gym_parking = infoList[0].GYM_PARKING;   
			  gym_wash = infoList[0].GYM_WASH;   
			  gym_uniform = infoList[0].GYM_UNIFORM;   
			  gym_locker = infoList[0].GYM_LOCKER;   
			  gym_like = infoList[0].GYM_LIKE;
			  file_seq = infoList[0].FILE_SEQ;
			  
			  $("#gym_id").text(gym_id);
			  $("#gym_username").text(gym_username);
			  $("#gym_usertell").text(gym_usertell);
			  $("#gym_name").text(gym_name);
			  $("#gym_tel").text(gym_tel);
			  $("#gym_addr").text(gym_addr);
			  $("#gym_addr_dtl").text(gym_addr_dtl);
			  $("#gym_zipcode").text(gym_zipcode);
			  $("#gym_number").text(gym_number);
			  $("#gym_profimg").text(gym_profimg);
			  $("#gym_info").text(gym_info);
			  $("#gym_parking").text(gym_parking);
			  $("#gym_wash").text(gym_wash);
			  $("#gym_uniform").text(gym_uniform);
			  $("#gym_locker").text(gym_locker);
			  $("#gym_like").text(gym_like);
			  $('#gym_profimg').attr('src','../main/getImages.gym?file_seq='+file_seq);
			  
			  if(gym_parking=="on"){
				  $("input:checkbox[id='gym_parking']").prop("checked", true); 
			  }
			  if(gym_wash=="on"){
				  $("input:checkbox[id='gym_wash']").prop("checked", true); 
			  }
			  if(gym_uniform=="on"){
				  $("input:checkbox[id='gym_uniform']").prop("checked", true); 
			  }
			  if(gym_locker=="on"){
				  $("input:checkbox[id='gym_locker']").prop("checked", true); 
			  }
			  /*
			  $.ajax({
				 url:"../gym/gymProfImage.gym" 
	   	  	   , success:function(data){
			   		var data = JSON.stringify(result);
					var jsonDoc = JSON.parse(data);
					var imgTag = "";
					for(var i=0; i<jsonDoc.length; i++) {
						var binaryData = jsonDoc[i].filedata;
						var blob = new Blob([new Uint8Array(binaryData)],{type:'image/png'});
						url = URL.createObjectURL(blob);
						$("gym_profimg").attr('src',url);
						 }
		   	   		}
			  });
			  
			  */
			  }
		});
	});
</script>
