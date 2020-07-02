<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal" id="myDetail">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header">
				<h4 class="modal-title" id="title">자세히 보기</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
<!-- Modal Body 부분 -->
			<div class="modal-body">
		        <div class="form-group row">
					<label for="dtl_mem_no" class="col-sm-3 col-form-label ">회원번호</label>
					<div class="col-sm-3">
						<input type="text" style="width:300px;" readonly class="form-control"
							   id="dtl_mem_no" >
					</div>
				</div>
				<div class="form-group row">
					<label for="dtl_mem_name" class="col-sm-3 col-form-label">회원이름</label>
					<div class="col-sm-4">
						<input type="text"  style="width:300px;" class="form-control" readonly
							   id="dtl_mem_name" >
					</div>
				</div>
				<div class="form-group row">
					<label for="dtl_mem_id" class="col-sm-3 col-form-label ">아이디</label>
					<div class="col-sm-4">
						<input type="text" style="width:300px;" class="form-control" readonly
							   id="dtl_mem_id" >
					</div>
				</div>
				<div class="form-group row">
					<label for="dtl_mem_gender" class="col-sm-3 col-form-label">성별 </label>
						<div class="col-sm-4">
							<input type="text" style="width:300px;" class="form-control" readonly
							   id="dtl_mem_gender">
						</div>
				</div>
				<div class="form-group row">
					<label for="dtl_mem_profImg" class="col-sm-3 col-form-label">이미지</label>
						<div class="col-sm-5">
						<div class="cropping">
							<img id="dtl_mem_profImg">
						</div>
						</div>
				</div>
				<div class="form-group row">
					<label for="dtl_mem_tel" class="col-sm-3 col-form-label">전화번호 </label>
						<div class="col-sm-5">
							<input type="text" style="width:300px;" readonly class="form-control"
							   id="dtl_mem_tel">
						</div>
				</div>
				<div class="form-group row">
					<label for="dtl_mem_addr" class="col-sm-3 col-form-label" >주소</label>
					<div class="col-sm-5">
						<input type="text" style="width:300px;" readonly class="form-control"
						   id="dtl_mem_addr">
					</div>
				</div>
				<div class="form-group row">
					<label for="dtl_mem_birth" class="col-sm-3 col-form-label">생년월일 </label>
					<div class="col-sm-5">
						<input type="text" style="width:300px;" readonly class="form-control" id="dtl_mem_birth" >
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