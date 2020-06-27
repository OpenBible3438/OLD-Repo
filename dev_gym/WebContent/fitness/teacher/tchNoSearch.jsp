<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- .modal {
 width: 100%;
 height: 100%;

 justify-content: center;
 align-items: center;
}
 -->
 	<div style="padding-top: 20px"></div> 
    <div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_tcnum" class="col-sm-3 col-form-label">강사번호</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" id="gym_tchS" required  >
				</div>
				<div class="col-sm-3">
				<button onclick="tch_ins_search()" class="btn btn-primary mb-1">찾기</button>
				</div>
	</div>
	<hr>
	
	<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_tcid" class="col-sm-3 col-form-label">아이디</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" required 
					   id="gym_tchId" >
				</div>
				<div class="col-sm-3">
				<button onclick="tch_ins_over()" class="btn btn-primary mb-1">중복</button>
				</div>
	</div>
	
	<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_tcname" class="col-sm-3 col-form-label">비밀번호</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" required
					   id="gym_tcpw" >
				</div>
	</div>
	
	<div class="form-group row">
			<div class="col-sm-1" ></div>
			<label for="gym_tcname" class="col-sm-3 col-form-label">비밀번호 확인</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" required 
					   id="gym_tcpw_o" >
				</div>
	</div>
	
	<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_tcname" class="col-sm-3 col-form-label">이름</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" required
					   id="gym_tch_name" >
				</div>
	</div>