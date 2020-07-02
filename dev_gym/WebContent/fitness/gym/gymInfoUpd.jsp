<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매장정보조회</title>

</head>
<body>
	<div id="info_upd">
		<div class="form-group row">
		   <h3><b>매장관리</b> / 매장 정보 수정</h3>  <!-- 제목 틀 입니다. -->
		   <div class="w-50"></div>
		   <button type="button" class="btn btn-primary" onClick="infoUPD_save()">저장</button>
	   	</div>
	    <hr>
	    <form id="f_infoUpd">
	    <!--=========================== 내용 시작 ===========================-->
			<input type="hidden" name="cud" value="upd">
			<input type="hidden" name="type" value="gym">
			<div class="form-group row ">
				<label for="gym_id" class="col-sm-2" width="10px"><b>아이디</b></label>
				<label id="gym_id" class="col-sm-5">디비아이디</label>
			</div>
			<div class="form-group row">
				<label for="gym_pw" class="col-sm-2 col-form-label">비밀번호</label>
				<div class="col-sm-5">
					<input type="password" class="form-control"
						   id="gym_pw" name="gym_pw" placeholder="8자리 이상 입력하세요" >
				</div>
			</div>
			<div class="form-group row">
				<label for="gym_pw_2" class="col-sm-2 col-form-label">재 입력</label>
				<div class="col-sm-5">
					<input type="password" class="form-control"
						   id="gym_pw_2" placeholder="비밀번호 확인" onkeyup="pw_confirm()">
					
				</div>
				<div id="pw_icon" class="col-sm-1" style="padding-left: 0px">
					<i class="material-icons" style="font-size:36px;color:red">clear</i>
				</div>
			</div>
			<div class="form-group row">
				<label for="gym_username" class="col-sm-2"><b>이름</b></label>
				<div class="col-sm-5">
					<input type="text" class="form-control"
						   id="gym_username" name="gym_username">
				</div>
			</div>
			<div class="form-group row">
				<label for="gym_usertell" class="col-sm-2"><b>전화번호</b></label>
				<div class="col-sm-5">
					<input type="text" class="form-control"
						   id="gym_usertell" name="gym_usertell">
				</div>
			</div>
			<div class="form-group row">
				<label for="gym_name" class="col-sm-2"><b>매장이름</b></label>
				<div class="col-sm-5">
					<input type="text" class="form-control"
						   id="gym_name" name="gym_name">
				</div>
			</div>
			<div class="form-group row">
				<label for="gym_tel" class="col-sm-2"><b>매장번호</b></label>
				<div class="col-sm-5">
					<input type="tel" class="form-control" id="gym_tel" name="gym_tel">
				</div>
			</div>
			<div class="form-group row">
				<label for="gym_addr" class="col-sm-2"><b>매장주소</b></label>
				<div class="col-sm-5">
					<input type="text" class="form-control"
						   id="gym_addr" name="gym_addr" readonly>
				</div>
				<div class="col-sm-3">
					<a type="button" href="javascript:addrSearch()" 
						        class="btn btn-primary">주소검색</a>
				</div>
			</div>
			<div class="form-group row">
				<label for="gym_addr_dtl" class="col-sm-2"><b>매장상세주소</b></label>
				<div class="col-sm-5">
					<input type="text" class="form-control"
						   id="gym_addr_dtl" name="gym_addr_dtl">
				</div>
				<div class="col-sm-2" >
					<input type="text" class="form-control" readonly
						   id="gym_zipcode" name="gym_zipcode"
						   placeholder="우편번호">
				</div>
			</div>
			<div class="form-group row">
				<label for="gym_number" class="col-sm-2"><b>사업자번호</b></label>
				<div class="col-sm-5">
					<input type="text" class="form-control"
						   id="gym_number" name="gym_number">
				</div>
			</div>
			<div class="form-group row form-inline ">
				<label for="gym_profimg" class="col-sm-2"><b>매장 프로필 사진</b></label>
				<div class="p-1 m-3 continer border rounded">
				<div class="cropping">
					<img id="gym_profimg_img" src="#" />
				</div>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-2" ></div>
				<div class="col-sm-5">
					<input type="file" class="form-control-file border" id="gym_profimg" name="gym_profimg">
				</div>
			</div>
			<div class="form-group row form-inline">
				<label for="gym_info" class="col-sm-2"><b>매장소개</b></label>
				<textarea class="form-control w-75 px-3 py-3 m-3 continer border rounded" id="gym_info" name="gym_info">
				</textarea>
			</div>
			<div class="form-group row form-inline">
				<label for="gym_info" class="col-sm-2"><b>편의시설</b></label>
				<div id="gym_info" class="w-75 px-5 py-3 m-3 container border rounded">
					<div class="form-group row"><!-- 체크박스 디비 데이터로 설정 -->
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox"  id="gym_parking" name="gym_parking"> 
							<label class="form-check-label" for="gym_parking">주차장</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox"  id="gym_wash" name="gym_wash"> 
							<label class="form-check-label" for="gym_wash">샤워실</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="gym_uniform" name="gym_uniform"> 
							<label class="form-check-label" for="gym_uniform">유니폼</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox"  id="gym_locker" name="gym_locker"> 
							<label class="form-check-label" for="gym_locker">락커룸</label>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- 파일 이미지 로드 하기 -->
	<script type="text/javascript">
		//파일 첨부시 이미지 로드 하기 
	    function readURL(input) {
	        if (input.files && input.files[0]) {
	            var reader = new FileReader();
	            reader.onload = function(e) {
	            	//img태그 아이디
	            	alert("파일첨부1 : "+e.target.result);
	                $('#gym_profimg_img').attr('src', e.target.result);
	            }
	            reader.readAsDataURL(input.files[0]);
	        }
	    }
		//파일첨부 input태그 아이디
	    $("#gym_profimg").change(function() {
	        readURL(this);
	    });
	</script>
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
			
			  
			  $("#gym_id").text(gym_id);
			  $("#gym_username").val(gym_username);
			  $("#gym_usertell").val(gym_usertell);
			  $("#gym_name").val(gym_name);
			  $("#gym_tel").val(gym_tel);
			  $("#gym_addr").val(gym_addr);
			  $("#gym_addr_dtl").val(gym_addr_dtl);
			  $("#gym_zipcode").val(gym_zipcode);
			  $("#gym_number").val(gym_number);
			  $("#gym_profimg").val(gym_profimg);
			  $("#gym_info").val(gym_info);
			  $("#gym_parking").val(gym_parking);
			  $("#gym_wash").val(gym_wash);
			  $("#gym_uniform").val(gym_uniform);
			  $("#gym_locker").val(gym_locker);
			  $("#gym_like").val(gym_like);
			 
			  
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
			  
		  }
		});
	});
</script>
</body>
</html>