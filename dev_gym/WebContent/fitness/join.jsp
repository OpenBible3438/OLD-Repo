<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="m_join">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">

<!-- <div style="padding: 20px;"> -->
	<div class="modal-header">
    	<h4 class="modal-title">매장 회원가입</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
    </div>
    <div class="modal-body" style="padding-left: 40px; padding-top: 20px">
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
	</form>
<!-- end of container -->
	<div class="modal-footer">
		<button type="button" class="btn btn-primary" onclick="classINS()">가입</button>
		<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
	</div>
	</div><!-- 왼쪽 패딩 -->
<!-- </div> 전체 패딩  -->

		</div><!-- end of modal-content -->
	</div><!-- end of modal-dialog modal-lg -->
</div><!-- end of modal m_join-->





