<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal" id="myDetail">
	<div class="modal-dialog" style="width:auto;display:table">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header">
				<h4 class="modal-title" id="title">자세히 보기</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
<!-- Modal Body 부분 -->
			<div class="modal-body">
		        <div class="form-group row">
					<label for="gym_no" class="col-sm-3 col-form-label ">회원번호</label>
					<div class="col-sm-3">
						<input type="text" style="width:200px;" class="form-control" placeholder="Readonly" readonly
							   id="mem_no" >
					</div>
				</div>
				<div class="form-group row">
					<label for="gym_name" class="col-sm-3 col-form-label">회원이름</label>
					<div class="col-sm-4">
						<input type="text"  style="width:200px;" class="form-control" placeholder="Readonly input here…" readonly
							   id="mem_name" >
					</div>
				</div>
				<div class="form-group row">
					<label for="gym_id" class="col-sm-3 col-form-label ">아이디</label>
					<div class="col-sm-4">
						<input type="text" style="width:200px;" class="form-control" placeholder="Readonly input here…" readonly
							   id="mem_id" >
					</div>
				</div>
				<div class="form-group row">
					<label for="gym_nickname" class="col-sm-3 col-form-label">닉네임 </label>
					<div class="col-sm-4">
						<input type="text" style="width:200px;" class="form-control" placeholder="Readonly input here…" readonly
							   id="mem_nickname" >
					</div>
				</div>
				<div class="form-group row">
					<label for="gym_gender" class="col-sm-3 col-form-label">성별 </label>
						<div class="col-sm-4">
							<input type="text" style="width:200px;" class="form-control" required readonly
							   id="mem_gender">
						</div>
				</div>
				<div class="form-group row">
					<label for="mem_profimg" class="col-sm-3 col-form-label">이미지</label>
						<div class="col-sm-5">
							<input type="file" class="custom-file-input" id="gym_profimg" placeholder="Readonly input here…" readonly></input>
							<label style="padding-left: 10px"class="custom-file-label" for="mem_profimg">회원 프로필 사진</label>
						</div>
				</div>
				<div class="form-group row">
					<label for="gym_tel" class="col-sm-3 col-form-label">전화번호 </label>
						<div class="col-sm-5">
							<input type="text" style="width:200px;" class="form-control" placeholder="Readonly input here…" readonly
							   id="mem_tel">
						</div>
				<!-- <div class="col-sm-3">
						<button onclick="addrSearch()" class="btn btn-primary mb-1" placeholder="Readonly input here…" readonly>주소검색</button>
					</div> -->
				</div>
				<div class="form-group row">
					<label for="gym_addr" class="col-sm-3 col-form-label" >주소</label>
						<div class="col-sm-5">
							<input type="text" style="width:200px;" class="form-control" placeholder="Readonly input here…" readonly
							   id="mem_addr">
						</div>
						<!-- <button onclick="addrSearch()" class="btn btn-primary mb-1" placeholder="Readonly input here…" readonly>주소검색</button> -->
				</div>
				
				<div class="form-group row">
					<label for="gym_addr_dtl" class="col-sm-3 col-form-label" >상세주소</label>
						<div class="col-sm-5">
							<input type="text" style="width:200px;" class="form-control" placeholder="Readonly input here…" readonly
								   id="mem_addr_dtl" >
						</div>
					<!-- <div class="col-sm-3" >
						<input type="text" class="form-control" 
							   id="mem_zipcode" 
							   placeholder="우편번호">
					</div> -->
				</div>
				<div class="form-group row">
					<label for="gym_joindate" class="col-sm-3 col-form-label">등록일 </label>
						<div class="col-sm-5">
							<input type="text" style="width:200px;" class="form-control" placeholder="Readonly input here…" readonly
								   id="mem_joindate" >
						</div>
				</div> 
				<div class="form-group row">
					<label for="gym_birth" class="col-sm-3 col-form-label">생년월일 </label>
						<div class="col-sm-5">
							<input type="text" style="width:200px;" class="form-control" placeholder="Readonly input here…" readonly
								   id="mem_birth" >
					</div>
				</div> 
			</div>				
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>			
			</div>
		</div>
	</div>
</div>	