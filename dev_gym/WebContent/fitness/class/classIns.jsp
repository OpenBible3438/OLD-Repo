<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!--============================================================================================================== 수업등록 Modal 시작 -->
	<div class="modal fade" id="c_ins" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="false">
		<div class="modal-dialog modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">수업 등록</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
				</div>
				<div class="modal-body">
					<!--=========================================================================================== form 시작  -->
					<form role="form" id="f_ins">
						<input type="hidden" name="cud" value="ins">
						<%-- <input type="hidden" name="gym_no" value="<%=gym_no%>"> --%>
						<div class="form-group">
							<label for="ins_cls_name"><b>수업명</b></label> 
							<input type="text" class="form-control input-sm" id="ins_cls_name" name="ins_cls_name" placeholder="수업명을 입력하세요">
						</div>
						<div class="form-group">
							<label for="ins_tch_name"><b>강사명</b></label> 
					        <select class="form-control" id="ins_tch_name" name="ins_tch_name">
							</select>
						</div>					
						<div class="form-group">
							<label for="ins_type_no"><b>종목</b></label> 
							<select class="form-control" id="ins_type_no" name="ins_type_no">
								<option value="1">요가</option>
								<option value="2">헬스</option>
							</select>	
						</div>
						<div class="form-group">
							<label for="ins_cls_kind"><b>수업 구분</b></label> 
					        <select class="form-control" id="ins_cls_kind" name="ins_cls_kind">
								<option value="1:1">개인 수업</option>
								<option value="1:N">단체 수업</option>
							</select>
						</div>
						<div class="form-group">
							<label for="ins_cls_s_date"><b>시작일</b></label> 
							<input type="date" class="form-control input-sm" id="ins_cls_s_date" name="ins_cls_s_date" placeholder="연도-월-일">
						</div>
						<div class="form-group">
							<label for="ins_cls_e_date"><b>종료일</b></label> 
							<input type="date" class="form-control input-sm" id="ins_cls_e_date" name="ins_cls_e_date" placeholder="연도-월-일">
						</div>
						<div class="form-group">
							<label for="ins_cls_days"><b>수업 일수</b></label> 
							<input type="text" class="form-control input-sm" id="ins_cls_days" name="ins_cls_days" placeholder="시작일과 종료일을 입력하세요.">
						</div>
						<div class="form-group">
							<label for="ins_cls_cnt"><b>수업 횟수</b></label> 
							<input type="text" class="form-control input-sm" id="ins_cls_cnt" name="ins_cls_cnt" placeholder="단위:수">
						</div>
						<div class="form-group">
							<label for="ins_cls_info"><b>수업 소개</b></label> 
							<textarea rows="5" class="form-control" id="ins_cls_info" name="ins_cls_info">
							</textarea>
						</div>
						<div class="form-group">
							<label for="ins_cls_price"><b>가격</b></label> 
							<input type="text" class="form-control input-sm" id="ins_cls_price" name="ins_cls_price" placeholder="단위:원">
						</div>
						<div class="form-group">
							<label for="ins_cls_grcode"><b>그룹코드</b></label> 
							<input type="text" class="form-control input-sm" id="ins_cls_grcode" name="ins_cls_grcode" placeholder="그룹코드를 입력하세요.">
						</div>
						<div class="form-group">
							<label for="ins_cls_state"><b>진행 상황</b></label> 
					        <select class="form-control" id="ins_cls_state" name="ins_cls_state">
								<option value="진행">진행</option>
								<option value="대기">대기</option>
								<option value="종료">종료</option>
							</select>
						</div>
					</form>
					<!--=========================================================================================== form 끝  -->
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="classINS()">저장</button>
				</div>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->
	<!--============================================================================================================== 수업등록 Modal 끝 -->
