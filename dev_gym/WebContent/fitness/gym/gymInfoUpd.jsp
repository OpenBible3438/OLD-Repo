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
			<div class="form-group row ">
				<label for="gym_id" class="col-sm-2" width="10px"><b>아이디</b></label>
				<label id="gym_id" class="col-sm-5">디비아이디</label>
			</div>
			<div class="form-group row">
				<label for="gym_pw" class="col-sm-2 col-form-label">비밀번호</label>
				<div class="col-sm-5">
					<input type="password" class="form-control"
						   id="j_gym_pw" name="j_gym_pw" placeholder="8자리 이상 입력하세요" >
				</div>
			</div>
			<div class="form-group row">
				<label for="gym_pw_2" class="col-sm-2 col-form-label">재 입력</label>
				<div class="col-sm-5">
					<input type="password" class="form-control"
						   id="j_gym_pw_2" placeholder="비밀번호 확인" onkeyup="pw_confirm()">
					
				</div>
				<div id="pw_icon" class="col-sm-1" style="padding-left: 0px">
					<i class="material-icons" style="font-size:36px;color:red">clear</i>
				</div>
			</div>
			<div class="form-group row">
				<label for="gym_username" class="col-sm-2"><b>이름 </b></label>
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
					<img id="gym_profimg_img"src="#" style="min-width:200px; min-height:100px"/>
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
							<input class="form-check-input" type="checkbox" checked id="gym_parking"> 
							<label class="form-check-label" for="gym_parking">주차장</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" checked id="gym_wash"> 
							<label class="form-check-label" for="gym_wash">샤워실</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="gym_uniform"> 
							<label class="form-check-label" for="gym_uniform">유니폼</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" checked id="gym_locker"> 
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
	
</body>
</html>