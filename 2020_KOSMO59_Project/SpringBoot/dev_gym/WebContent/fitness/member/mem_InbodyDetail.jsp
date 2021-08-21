<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal" id="myInbody">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header">
				<h4 class="modal-title">인바디 보기</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<!-- Modal Body 부분 -->
			<div class="modal-body">
    <!-- <h2>인바디 보기</h2> -->
		    	<div class="form-group row">
					<label for="mem_no_d" class="col-sm-3 col-form-label ">회원번호</label>
					<div class="col-sm-2">
						<input type="text" style="width:80px;" class="form-control" readonly
							   id="mem_no_d" >
					</div>
				</div>
				<div class="form-group row">
					<label for="gym_id" class="col-sm-3 col-form-label ">아이디</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" readonly
							   id="mem_id_d" >
					</div>
				</div>
				<div class="form-group row">
					<label for="gym_name" class="col-sm-3 col-form-label">회원이름</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" readonly
							   id="mem_name_d" >
					</div>
				</div>
				<div class="row">
					<div id="inbody_images">
						<img id="mem_inbodyImg_d" style="width:400px; height: 600px;">
					</div>
				</div>
			</div>
			
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button> 
				<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>			
			</div>
		</div>
	</div>
</div>

		
