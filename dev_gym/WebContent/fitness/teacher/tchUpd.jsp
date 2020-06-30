<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!-- ===== 강사수정 modal ===== -->
<div class="modal" id="upd">
	<div class="modal-dialog modal-lg" style="width:auto">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header">
				<h5 class="modal-title_Upd">강사관리(수정)</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<!-- Modal Body 부분 -->
		<div class="Upd_body">
			<br>
		<div border="5" class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<img class="img" 
					src="" style="min-height: 250px">
				<!-- witdh="300" height="300" -->
					<br> <br>
			</div>
			<div class="col-sm-3"></div>
		</div>
		
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<input type="file" class="form-control-file border">
			</div>
		</div>
		<br>
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_tcnum" class="col-sm-2 col-form-label">강사번호</label>
				<div class="col-sm-4">
				<input type="text" disabled class="form-control" required
					   id="gym_tcnum" >
				</div>
		</div>
		
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_tcname" class="col-sm-2 col-form-label">강사이름</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" required disabled
					   id="gym_tcname" >
				</div>
		</div>
		
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_tcid" class="col-sm-2 col-form-label">강사아이디</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" required disabled
					   id="gym_tcid" >
				</div>
		</div>
		
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_tctel" class="col-sm-2 col-form-label">연락처</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" required
					   id="gym_tctel" >
				</div>
		</div>
		
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_tctel" class="col-sm-2 col-form-label">성별</label>
				<div class="col-sm-4">
				<select class="form-control" id="tch_gender">
                            <option value="M">남성</option>
                            <option value="F">여성</option>
                </select>
				</div>
		</div>
		
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_tczip" class="col-sm-2 col-form-label">주소</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" required
					   id="gym_tczip" >
				</div>
		<div class="col-sm-3">
				<button onclick="주소검색()" class="btn btn-primary mb-1">🔍</button>
		</div>
			</div>
			
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_addr_dtl" class="col-sm-2 col-form-label">상세주소</label>
			<div class="col-sm-4">
				<input type="text" class="form-control"
					   id="gym_addr_dtl" >
			</div>
			<div class="col-sm-2" >
				<input type="text" class="form-control" readonly
					   id="gym_zipcode" 
					   placeholder="우편번호">
			</div>
		</div>	
	</div>	
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">수정</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>			
			</div>
		</div>
	</div>
</div>

<!-- ===== 강사등록 modal end =====  -->