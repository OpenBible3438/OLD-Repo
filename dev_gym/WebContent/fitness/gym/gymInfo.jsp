<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매장정보조회</title>
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
	
	
	function infoUPD(){
		$.ajax({
			url : "../gym/gymInfoUpd.jsp"
		  , success : function(data){
			  $("#d_info").html(data)
		  }
		});
	}
	function infoUPD_save(){
		alert("저장");
		$("#f_infoUpd").attr('action', "jsonGymInfoList.gym")
		$("#f_infoUpd").submit();
	}
	function pw_confirm() {
		//alert("비번확인");
		var gym_pw = $('#j_gym_pw').val();
		var gym_pw_2 = $('#j_gym_pw_2').val();
		if( gym_pw.length>8 && gym_pw.length <= gym_pw_2.length) {
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
</head>
	<%@ include file="../../common/bootStrap4UI.jsp" %>
<body>
	<div id = "d_info" class="px-3 py-3 m-3">
		<div class="form-group row">
		   <h3 class="w-25"><b>매장관리</b> / 매장 정보 조회</h3>  <!-- 제목 틀 입니다. -->
		   <div class="w-50"></div>
		   <button type="button" class="btn btn-primary" onClick="infoUPD()">수정</button>
	   	</div>
    <hr>
    <!--=========================== 내용 시작 ===========================-->
		<div class="form-group row ">
			<label for="gym_id" class="col-sm-2" width="10px"><b>아이디</b></label>
			<label id="gym_id" class="col-sm-5">디비아이디</label>
		</div>
		<div class="form-group row">
			<label for="gym_username" class="col-sm-2"><b>이름 </b></label>
			<label id="gym_username" class="col-sm-5">디비이름</label>
		</div>
		<div class="form-group row">
			<label for="gym_usertell" class="col-sm-2"><b>전화번호</b></label>
			<label id="gym_usertell" class="col-sm-5">디비전화번호</label>
		</div>
		<div class="form-group row">
			<label for="gym_name" class="col-sm-2"><b>매장이름</b></label>
			<label id="gym_name" class="col-sm-5">디비매장이름</label>
		</div>
		<div class="form-group row">
			<label for="gym_tel" class="col-sm-2"><b>매장번호</b></label>
			<label id="gym_tel" class="col-sm-5">디비매장번호</label>
		</div>
		<div class="form-group row">
			<label for="gym_addr" class="col-sm-2"><b>매장주소</b></label>
			<label id="gym_addr" class="col-sm-5">디비매장주소</label>
		</div>
		<div class="form-group row">
			<label for="gym_addr_dtl" class="col-sm-2"><b>매장상세주소</b></label>
			<label id="gym_addr_dtl" class="col-sm-5">디비매장상세주소</label>
		</div>
		<div class="form-group row">
			<label for="gym_zipcode" class="col-sm-2"><b>우편번호</b></label>
			<label id="gym_zipcode" class="col-sm-5">디비우편번호</label>
		</div>
		<div class="form-group row">
			<label for="gym_number" class="col-sm-2"><b>사업자번호</b></label>
			<label id="gym_number" class="col-sm-5">디비사업자번호</label>
		</div>
		<div class="form-group row form-inline ">
			<label for="gym_profimg" class="col-sm-2"><b>매장 프로필 사진</b></label>
			<div class="p-1 m-3 continer border rounded">
				<img id="gym_profimg" alt="디비 사진" src="#">
			</div>
		</div>
		<div class="form-group row form-inline">
			<label for="gym_info" class="col-sm-2"><b>매장소개</b></label>
			<div class="w-75 px-3 py-3 m-3 continer border rounded">
				디비 매장소개애애애ㅐ 매장 소개 매장소개
			</div>
		</div>
		<div class="form-group row form-inline">
			<label for="gym_info" class="col-sm-2"><b>편의시설</b></label>
			<div id="gym_info" class="w-75 px-5 py-3 m-3 container border rounded">
				<div class="form-group row">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" checked disabled id="gym_parking"> 
						<label class="form-check-label" for="gym_parking">주차장</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" checked disabled id="gym_wash"> 
						<label class="form-check-label" for="gym_wash">샤워실</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" disabled id="gym_uniform"> 
						<label class="form-check-label" for="gym_uniform">유니폼</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" checked disabled id="gym_locker"> 
						<label class="form-check-label" for="gym_locker">락커룸</label>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			url : "../gym/jsonGymInfo.gym"
		  , success : function(result){
			  var data = JSON.stringify(result);
			  var infoList = JSON.parse(data);
			  
		  }
		});
	});
</script>
</body>
</html>