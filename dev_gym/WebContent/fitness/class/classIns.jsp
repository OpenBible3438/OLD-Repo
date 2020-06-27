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
						
						<%-- <input type="hidden" name="ins_gym_no" value="<%=gym_no%>"> --%>
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
								
							</select>	
						</div>
						<div class="form-group">
							<label for="ins_cls_kind"><b>수업 구분</b></label> 
					        <select class="form-control" id="ins_cls_kind" name="ins_cls_kind">
								<option value="개인 수업">개인 수업</option>
								<option value="단체 수업">단체 수업</option>
								<option value="매장 이용">매장 이용</option>
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
							<label for="ins_cls_sTime"><b>시작 시간</b></label> 
							<input type="text" class="form-control input-sm" id="ins_cls_sTime" name="ins_cls_sTime" placeholder="입력창을 클릭하세요.">							
						</div>						
						<div class="form-group">
							<label for="ins_cls_eTime"><b>종료 시간</b></label> 
							<input type="text" class="form-control input-sm" id="ins_cls_eTime" name="ins_cls_eTime" placeholder="입력창을 클릭하세요.">							
						</div>	
						<div class="form-group">
							<label for="ins_cls_day"><b>수업 요일</b></label> 
						</div>
						<div class="form-group row" style="padding: 0px 0px 0px 18px;">
							<div class="custom-control custom-checkbox">
								<input type="checkbox" id="ins_cls_day1" class="custom-control-input">
								<label class="custom-control-label" for="ins_cls_day1">월&nbsp;&nbsp;&nbsp;&nbsp;</label>
							</div>							
							<div class="custom-control custom-checkbox">
								<input type="checkbox" id="ins_cls_day2" class="custom-control-input">
								<label class="custom-control-label" for="ins_cls_day2">화&nbsp;&nbsp;&nbsp;&nbsp;</label>
							</div>							
							<div class="custom-control custom-checkbox">
								<input type="checkbox" id="ins_cls_day3" class="custom-control-input">
								<label class="custom-control-label" for="ins_cls_day3">수&nbsp;&nbsp;&nbsp;&nbsp;</label>
							</div>							
							<div class="custom-control custom-checkbox">
								<input type="checkbox" id="ins_cls_day4" class="custom-control-input">
								<label class="custom-control-label" for="ins_cls_day4">목&nbsp;&nbsp;&nbsp;&nbsp;</label>
							</div>							
							<div class="custom-control custom-checkbox">
								<input type="checkbox" id="ins_cls_day5" class="custom-control-input">
								<label class="custom-control-label" for="ins_cls_day5">금&nbsp;&nbsp;&nbsp;&nbsp;</label>
							</div>							
							<div class="custom-control custom-checkbox">
								<input type="checkbox" id="ins_cls_day6" class="custom-control-input">
								<label class="custom-control-label" for="ins_cls_day6">토&nbsp;&nbsp;&nbsp;&nbsp;</label>
							</div>							
							<div class="custom-control custom-checkbox">
								<input type="checkbox" id="ins_cls_day7" class="custom-control-input">
								<label class="custom-control-label" for="ins_cls_day7">일</label>
							</div>							
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
