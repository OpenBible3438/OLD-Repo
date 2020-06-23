<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ include file="../../common/bootStrap4UI.jsp" %>
<!-- <div style="padding: 20px;">
   <h3><b>회원관리</b> / 인바디 수정</h3>   제목 틀 입니다. -->
   <hr>
    <!--=========================== 내용 시작 ===========================-->
	<div style="padding-left: 40px; padding-top: 10px"></div>
		<form role="form" id="gym_join">
		<div class="form-group row">
			<label for="gym_id" class="col-sm-3 col-form-label ">아이디</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" required
					   id="gym_id" >
			</div>
			<div class="col-sm-5">
				<button onclick="id_confirm()" 
				        class="btn btn-primary mb-1">중복확인</button>
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_pw" class="col-sm-3 col-form-label">비밀번호</label>
			<div class="col-sm-4">
				<input type="password" class="form-control"
					   id="gym_pw" placeholder="8자리 이상 입력하세요" required>
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_pw_2" class="col-sm-3 col-form-label">재 입력</label>
			<div class="col-sm-4">
				<input type="password" class="form-control"
					   id="gym_pw_2" placeholder="비밀번호 확인">
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_username" class="col-sm-3 col-form-label">이름 </label>
			<div class="col-sm-4">
				<input type="text" class="form-control"
					   id="gym_username" >
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_usertell" class="col-sm-3 col-form-label">전화번호 </label>
			<div class="col-sm-4">
				<input type="text" class="form-control"
					   id="gym_usertell" >
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_profimg" class="col-sm-3 col-form-label">이미지</label>
			<div class="col-sm-7">
				<input type="file" class="form-control-file border" id="gym_profimg" name="gym_profimg">
			</div>
		</div>
	</form>
