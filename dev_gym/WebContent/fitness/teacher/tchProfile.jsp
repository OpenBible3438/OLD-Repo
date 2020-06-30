<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- =====프로필 보기 modal ===== -->    
<div class="modal" id="profile_info">
	<div class="modal-dialog modal-lg" style="width:auto">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header">
				<h5 class="modal-title">프로필보기</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<!-- Modal Body 부분 -->
		<div class="profile_body">
		<form role="form" id="tch_pro" method="post" 
		          action="./teacher/tchProfile.gym"
		          enctype="multipart/form-data">
			<br>
		<div border="5" class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-4">
				<img id="prof_tch_img" style="width:200px; height: 200px">
			</div>
 			<div class="col-sm-6">
				<div class="row" style="padding-top: 10px"><!-- col-sm-4 -->
					<label for="prof_tch_id" class="col-sm-4 col-form-label">강사아이디</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" required disabled
							   id="prof_tch_id" >
					</div>
				</div>	   	 
				<div class="row" style="padding-top: 10px">
					<label for="prof_tch_no" class="col-sm-4 col-form-label">강사번호</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" required disabled
							   id="prof_tch_no" >
					</div>
				</div>
				<div class="row" style="padding-top: 10px">
					<label for="prof_tch_name" class="col-sm-4 col-form-label">강사이름</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" required disabled
							   id="prof_tch_name" >
					</div>
				</div>
				<div class="row" style="padding-top: 10px">
					<label for="prof_tch_like" class="col-sm-4 col-form-label">좋아요 수</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" required disabled
							   id="prof_tch_like" >
					</div>
				</div>
 			</div>
 			<div class="col-sm-1"></div>
		</div>
		<br>
		
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_info" class="col-sm-3 col-form-label">소개</label>
			<div class="col-sm-7">
				<textarea class="form-control" id="tch_intro" disabled
					      placeholder="" style="min-height: 100px">
				</textarea>
			</div>
		</div>
		
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_info" class="col-sm-3 col-form-label">경력사항</label>
			<div class="col-sm-7">
				<textarea class="form-control" id="tch_career" disabled
					      placeholder="" style="min-height: 100px">
				</textarea>
			</div>
		</div>
		</form>
	</div>
			
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
			
			</div>
		</div>
	</div>
</div>		
<!-- ===== 강사등록 modal end =====  -->