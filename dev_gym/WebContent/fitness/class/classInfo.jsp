<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!--============================================================================================================== 자세히 보기 Modal 시작 -->
	<div class="modal fade" id="c_info" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">자세히 보기</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
				</div>

				<!--=========================================================================================== form 시작  -->
				<div class="modal-body" style="padding-left: 40px; padding-right: 40px; padding-top: 20px">

					<form role="form" id="f_info">
						<div class="form-group row">
							<label for="info_cls_name" class="col-sm-3 col-form-label"><b>수업명</b></label> 
							<div class="col-sm-9"> 
								<input type="text" class="form-control input-sm" id="info_cls_name" name="info_cls_name" readonly>
							</div>	
						</div>
						<div class="form-group row">
							<label for="info_tch_name" class="col-sm-3 col-form-label"><b>강사명</b></label> 
							<div class="col-sm-9"> 
								<input type="text" class="form-control input-sm" id="info_tch_name" name="info_tch_name" readonly>
							</div>
						</div>						
						<div class="form-group row">
							<label for="info_type_no" class="col-sm-3 col-form-label"><b>종목</b></label> 
							<div class="col-sm-9"> 
								<input type="text" class="form-control input-sm" id="info_type_no" name="info_type_no" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="info_cls_kind" class="col-sm-3 col-form-label"><b>수업 구분</b></label> 
							<div class="col-sm-9"> 
								<input type="text" class="form-control input-sm" id="info_cls_kind" name="info_cls_kind" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="info_cls_s_date" class="col-sm-3 col-form-label"><b>시작일</b></label> 
							<div class="col-sm-9"> 
								<input type="date" class="form-control input-sm" id="info_cls_s_date" name="info_cls_s_date" placeholder="연도-월-일" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="info_cls_e_date" class="col-sm-3 col-form-label"><b>종료일</b></label> 
							<div class="col-sm-9"> 
								<input type="date" class="form-control input-sm" id="info_cls_e_date" name="info_cls_e_date" placeholder="연도-월-일" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="info_cls_sTime" class="col-sm-3 col-form-label"><b>시작 시간</b></label> 
							<div class="col-sm-9"> 
								<input type="text" class="form-control input-sm" id="info_cls_sTime" name="info_cls_sTime" readonly>
							</div>							
						</div>						
						<div class="form-group row">
							<label for="info_cls_eTime" class="col-sm-3 col-form-label"><b>종료 시간</b></label> 
							<div class="col-sm-9"> 
								<input type="text" class="form-control input-sm" id="info_cls_eTime" name="info_cls_eTime" readonly>
							</div>							
						</div>						
						<div class="form-group row">
							<label for="info_cls_day" class="col-sm-3 col-form-label"><b>수업 요일</b></label> 
							<div class="col-sm-9"> 
								<input type="text" class="form-control input-sm" id="info_cls_day" name="info_cls_day" readonly>
							</div>							
						</div>						
						<div class="form-group row">
							<label for="info_cls_cnt" class="col-sm-3 col-form-label"><b>수업 횟수</b></label> 
							<div class="col-sm-9"> 
								<input type="text" class="form-control input-sm" id="info_cls_cnt" name="info_cls_cnt" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="info_cls_days" class="col-sm-3 col-form-label"><b>수업 일수</b></label> 
							<div class="col-sm-9"> 
								<input type="text" class="form-control input-sm" id="info_cls_days" name="info_cls_days" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="info_cls_info" class="col-sm-3 col-form-label"><b>수업 소개</b></label> 
							<div class="col-sm-9"> 
								<textarea rows="5" class="form-control" id="info_cls_info" name="info_cls_info" readonly>
								</textarea>
							</div>
						</div>
						<div class="form-group row">
							<label for="info_cls_price" class="col-sm-3 col-form-label"><b>가격</b></label> 
							<div class="col-sm-9"> 
								<input type="text" class="form-control input-sm" id="info_cls_price" name="info_cls_price" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="info_cls_state" class="col-sm-3 col-form-label"><b>진행 상황</b></label> 
							<div class="col-sm-9"> 
								<input type="text" class="form-control input-sm" id="info_cls_state" name="info_cls_state" readonly>	
							</div>						
						</div>						
						
						<!---------------------------------------------------------------------------------- event 영역  
						<div id="f_info_event">
							<hr>
							<div class="form-group">
								<label for="info_cls_evt_name"><b>이벤트 명</b></label> 
								<input type="text" class="form-control input-sm" id="info_cls_evt_name" name="info_cls_evt_name" readonly>
							</div>
							<div class="form-group">
								<label for="info_cls_evt_sDate"><b>이벤트 시작일</b></label> 
								<input type="date" class="form-control input-sm" id="info_cls_evt_sDate" name="info_cls_evt_sDate" readonly>
							</div>
							<div class="form-group">
								<label for="info_cls_evt_eDate"><b>이벤트 종료일</b></label> 
								<input type="date" class="form-control input-sm" id="info_cls_evt_eDate" name="info_cls_evt_eDate" readonly>
							</div>
							<div class="form-group">
								<label for="info_cls_evt_cont"><b>이벤트 내용</b></label> 
								<input type="text" class="form-control input-sm" id="info_cls_evt_cont" name="info_cls_evt_cont" readonly>
							</div>
							<div class="form-group">
								<label for="info_cls_evt_cond"><b>이벤트 조건</b></label> 
								<input type="text" class="form-control input-sm" id="info_cls_evt_cond" name="info_cls_evt_cond" readonly>
							</div>
						</div>
						-->
						
						
					</form>
				<!--=========================================================================================== form 끝  -->
				</div>

			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->
	<!--============================================================================================================== 자세히 보기 Modal 끝 -->