<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
		<!-- Modal Body 부분 -->
		<div class="profile_body">
			<br>
		<div border="5" class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-4">
				<img class="img" id="tch_profimg"
					src="" style="min-height: 200px">
				<!-- witdh="300" height="300" -->
				<br>
			</div>
 			<div class="col-sm-7">
				<div class="row" style="padding-top: 10px"><!-- col-sm-4 -->
					<label for="gym_tcgnum" class="col-sm-4 col-form-label">매장번호</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" required disabled
							   id="gym_no" >
					</div>
				</div>	   	 
				<div class="row" style="padding-top: 10px">
					<label for="gym_tcnum" class="col-sm-4 col-form-label">강사번호</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" required disabled
							   id="tch_no" >
					</div>
				</div>
				<div class="row" style="padding-top: 10px">
					<label for="gym_tcnum" class="col-sm-4 col-form-label">강사이름</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" required disabled
							   id="tch_name" >
					</div>
				</div>
				<div class="row" style="padding-top: 10px">
					<label for="gym_tcnum" class="col-sm-4 col-form-label">좋아요 수</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" required disabled
							   id="tch_Like" >
					</div>
				</div>
 			</div>
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
		
		<!-- <div class="btn-group" id="button_group" style="margin-left: 50px">
			<div class="col-sm-1"></div>
			<button type="button" class="b1"><h1>👍</button></h1>
			<div class="col-sm-1"></div>
		</div>
		
		
		<div class="btn-group" id="button_group">
			<div class="col-sm-1"></div>
			<button type="button" class="b1"><h1>👎</button></h1>
		</div> -->
		
	</div>
<!-- ===== 강사등록 modal end =====  -->