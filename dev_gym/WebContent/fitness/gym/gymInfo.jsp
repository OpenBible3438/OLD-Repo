<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매장정보조회</title>
</head>
	<%@ include file="../../common/bootStrap4UI.jsp" %>
<body>
<div style="padding: 20px;">
   <h3><b>매장관리</b> / 공지사항</h3>   <!-- 제목 틀 입니다. -->
   <hr>
    <!--=========================== 내용 시작 ===========================-->
	<div style="padding-left: 40px; padding-top: 20px">
<br>
</div>
		<form role="form" id="gym_join">
		<div class="form-group row">
			<label for="gym_id" class="col-sm-2 col-form-label ">아이디</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" required
					   id="gym_id" >
			</div>
			<div class="col-sm-3">
				<button onclick="id_confirm()" 
				        class="btn btn-primary mb-1">중복확인</button>
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_pw" class="col-sm-2 col-form-label">비밀번호</label>
			<div class="col-sm-5">
				<input type="password" class="form-control"
					   id="gym_pw" placeholder="8자리 이상 입력하세요" required>
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_pw_2" class="col-sm-2 col-form-label">재 입력</label>
			<div class="col-sm-5">
				<input type="password" class="form-control"
					   id="gym_pw_2" placeholder="비밀번호 확인">
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_username" class="col-sm-2 col-form-label">이름 </label>
			<div class="col-sm-5">
				<input type="text" class="form-control"
					   id="gym_username" >
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_usertell" class="col-sm-2 col-form-label">전화번호 </label>
			<div class="col-sm-5">
				<input type="text" class="form-control"
					   id="gym_usertell" >
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_name" class="col-sm-2 col-form-label">매장이름</label>
			<div class="col-sm-5">
				<input type="text" class="form-control"
					   id="gym_name" >
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_tel" class="col-sm-2 col-form-label">매장번호</label>
			<div class="col-sm-5">
				<input type="text" class="form-control"
					   id="gym_tel" >
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_addr" class="col-sm-2 col-form-label">매장주소</label>
			<div class="col-sm-5">
				<input type="text" class="form-control"
					   id="gym_addr" >
			</div>
			<div class="col-sm-3">
				<button onclick="addrSearch()" class="btn btn-primary mb-1">주소검색</button>
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_addr_dtl" class="col-sm-2 col-form-label">매장상세주소</label>
			<div class="col-sm-5">
				<input type="text" class="form-control"
					   id="gym_addr_dtl" >
			</div>
			<div class="col-sm-2" >
				<input type="text" class="form-control" readonly
					   id="gym_zipcode" 
					   placeholder="우편번호">
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_number" class="col-sm-2 col-form-label">사업자번호</label>
			<div class="col-sm-5">
				<input type="text" class="form-control"
					   id="gym_number" >
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_profimg" class="col-sm-2 col-form-label">이미지</label>
			<div class="col-sm-5">
				<input type="file" class="form-control-file border" id="gym_profimg" name="gym_profimg">
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_info" class="col-sm-2 col-form-label">매장소개</label>
			<div class="col-sm-8">
				<textarea class="form-control" id="gym_info"
					      placeholder="매장을 소개해 주세요">
				</textarea>
			</div>
		</div>
		<label for="gym_info" class="col-sm-2 col-form-label">편의시설</label>
		<div id="gym_info" class="container pl-5 py-4 my-2 border rounded">
			<div class="form-group row">
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="gum_parking"> 
					<label class="form-check-label" for="gum_parking">주차장</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="gum_wash"> 
					<label class="form-check-label" for="gum_wash">샤워실</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="gum_uniform"> 
					<label class="form-check-label" for="gum_uniform">유니폼</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="gum_locker"> 
					<label class="form-check-label" for="gum_locker">락커룸</label>
				</div>
			</div>
		</div>
	</form>
</body>
</html>