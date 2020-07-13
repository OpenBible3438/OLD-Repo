<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!--============================================================================================================== 수업등록 Modal 시작 -->
	<div class="modal fade" id="c_ins" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="false">
		<div class="modal-dialog modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">수업 등록</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
				</div>
				<div class="modal-body" style="padding-left: 40px; padding-right: 40px; padding-top: 20px">
				
					<!--=========================================================================================== form 시작  -->
					<form role="form" id="f_ins">
						<input type="hidden" name="cud" value="ins">
						
						<div class="form-group row">
							<label for="ins_cls_name" class="col-sm-3 col-form-label"><b>수업명</b></label> 
							<div class="col-sm-9">
								<input type="text" class="form-control input-sm" id="ins_cls_name" name="ins_cls_name" placeholder="수업명을 입력하세요">
							</div>
						</div>
						<div class="form-group row">
							<label for="ins_tch_name" class="col-sm-3 col-form-label"><b>강사명</b></label> 
							<div class="col-sm-9">
						        <select class="form-control" id="ins_tch_name" name="ins_tch_no">
						        
								</select>
							</div>
						</div>					
						<div class="form-group row">
							<label for="ins_type_no" class="col-sm-3 col-form-label"><b>종목</b></label> 
							<div class="col-sm-9">
								<select class="form-control" id="ins_type_no" name="ins_type_no">
									
								</select>
							</div>	
						</div>
						<div class="form-group row">
							<label for="ins_cls_kind" class="col-sm-3 col-form-label"><b>수업 구분</b></label> 
							<div class="col-sm-9">
						        <select class="form-control" id="ins_cls_kind" name="ins_cls_kind">
									<option value="개인 수업">개인 수업</option>
									<option value="단체 수업">단체 수업</option>
									<option value="매장 이용">매장 이용</option>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label for="ins_cls_s_date" class="col-sm-3 col-form-label"><b>판매시작</b></label> 
							<div class="col-sm-9">
								<input type="date" class="form-control input-sm" id="ins_cls_s_date" name="ins_cls_s_date" placeholder="연도-월-일">
							</div>
						</div>
						<div class="form-group row">
							<label for="ins_cls_e_date" class="col-sm-3 col-form-label"><b>판매종료</b></label> 
							<div class="col-sm-9">
								<input type="date" class="form-control input-sm" id="ins_cls_e_date" name="ins_cls_e_date" placeholder="연도-월-일">
							</div>
						</div>
						
						<!-- 
				        <div class="input-group bootstrap-timepicker timepicker">
				            <input id="timepicker1" type="text" class="form-control input-small">
				            <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
				        </div>	
				        				
						
						<div class="form-group">
							<label for="ins_check_dTime"><b>시작 시간</b></label> 
							<input type="text" class="form-control input-sm" id="ins_check_sTime" name="ins_check_sTime" placeholder="입력창을 클릭하세요.">							
						</div>							
						
						
						
						<div class="form-group">
							<label for="ins_cls_ssTime"><b>시작 시간&nbsp;&nbsp;</b></label> 
							<input type="text" class="form-control input-sm" id="ins_cls_ssTime" name="ins_cls_ssTime" placeholder="시간을 선택하세요." readonly>							
						</div>		
						-->	
						
						<div class="form-group row">
							<label for="ins_cls_sTime" class="col-sm-3 col-form-label"><b>시작 시간&nbsp;&nbsp;</b></label>
							<div class="col-sm-6"> 
								<!--  
								<a href="javascript:ins_sTime()"><font size=2 color=blue> 시간선택 here! </font></a>
								-->
								<input type="text" class="form-control input-sm" id="ins_cls_sTime" name="ins_cls_sTime" placeholder="시간을 입력하세요." readonly>
							</div>
							<button type="button" class="btn btn-primary btn-xs col-sm-3" onclick="ins_sTime()">입력</button>							
						</div>						
						<div class="form-group row">
							<label for="ins_cls_eTime" class="col-sm-3 col-form-label"><b>종료 시간&nbsp;&nbsp;</b></label> 
							<div class="col-sm-6"> 
								<!-- 
								<a href="javascript:ins_eTime()"><font size=2 color=blue> 시간선택 here! </font></a>
								-->
								<input type="text" class="form-control input-sm" id="ins_cls_eTime" name="ins_cls_eTime" placeholder="시간을 입력하세요." readonly>
							</div>
							<button type="button" class="btn btn-primary btn-xs col-sm-3" onclick="ins_eTime()">입력</button>								
						</div>	
						
						
						
						<div class="form-group row">
							<label for="ins_cls_cnt" class="col-sm-3 col-form-label"><b>수업 요일</b></label>
							<div class="col-sm-6">
								<input type="text" class="form-control input-sm" id="ins_cls_day" name="ins_cls_day" placeholder="요일을 선택하세요." readonly>
							</div>
							<button type="button" class="btn btn-primary btn-xs col-sm-3" onclick="ins_checkDay()">선택</button>
						</div>	
								
						<div class="form-group row">					
							<div class="col-sm-3"></div>		
							<div class="form-group row col-sm-9" style="padding: 0px 0px 0px 30px;">
								<div class="custom-control custom-checkbox">
									<input type="checkbox" id="ins_cls_day1" class="custom-control-input" value="월">
									<label class="custom-control-label" for="ins_cls_day1">월&nbsp;&nbsp;&nbsp;&nbsp;</label>
								</div>							
								<div class="custom-control custom-checkbox">
									<input type="checkbox" id="ins_cls_day2" class="custom-control-input" value="화">
									<label class="custom-control-label" for="ins_cls_day2">화&nbsp;&nbsp;&nbsp;&nbsp;</label>
								</div>							
								<div class="custom-control custom-checkbox">
									<input type="checkbox" id="ins_cls_day3" class="custom-control-input" value="수">
									<label class="custom-control-label" for="ins_cls_day3">수&nbsp;&nbsp;&nbsp;&nbsp;</label>
								</div>							
								<div class="custom-control custom-checkbox">
									<input type="checkbox" id="ins_cls_day4" class="custom-control-input" value="목">
									<label class="custom-control-label" for="ins_cls_day4">목&nbsp;&nbsp;&nbsp;&nbsp;</label>
								</div>							
								<div class="custom-control custom-checkbox">
									<input type="checkbox" id="ins_cls_day5" class="custom-control-input" value="금">
									<label class="custom-control-label" for="ins_cls_day5">금&nbsp;&nbsp;&nbsp;&nbsp;</label>
								</div>							
								<div class="custom-control custom-checkbox">
									<input type="checkbox" id="ins_cls_day6" class="custom-control-input" value="토">
									<label class="custom-control-label" for="ins_cls_day6">토&nbsp;&nbsp;&nbsp;&nbsp;</label>
								</div>							
								<div class="custom-control custom-checkbox">
									<input type="checkbox" id="ins_cls_day7" class="custom-control-input" value="일">
									<label class="custom-control-label" for="ins_cls_day7">일&nbsp;&nbsp;&nbsp;&nbsp;</label>
								</div>
								<!--  
								<a href="javascript:ins_checkDay()"><font size=2 color=blue> 선택완료 </font></a>
								-->
							</div>
						</div>

						
						<div class="form-group row">
							<label for="ins_cls_days" class="col-sm-3 col-form-label"><b>수업 일수</b></label> 
							<div class="col-sm-9">
								<input type="text" class="form-control input-sm" id="ins_cls_days" name="ins_cls_days" placeholder="숫자만 입력하세요.">
							</div>
						</div>
						<div class="form-group row">
							<label for="ins_cls_cnt" class="col-sm-3 col-form-label"><b>수업 횟수</b></label> 
							<div class="col-sm-9">
								<input type="text" class="form-control input-sm" id="ins_cls_cnt" name="ins_cls_cnt" placeholder="숫자만 입력하세요.">
							</div>
						</div>
						<div class="form-group row">
							<label for="ins_cls_info" class="col-sm-3 col-form-label"><b>수업 소개</b></label> 
							<div class="col-sm-9">
								<textarea rows="5" class="form-control" id="ins_cls_info" name="ins_cls_info">
								</textarea>
							</div>
						</div>
						<div class="form-group row">
							<label for="ins_cls_price" class="col-sm-3 col-form-label"><b>가격</b></label> 
							<div class="col-sm-9">
								<input type="text" class="form-control input-sm" id="ins_cls_price" name="ins_cls_price" placeholder="숫자만 입력하세요.">
							</div>
						</div>
						<div class="form-group row">
							<label for="ins_cls_state" class="col-sm-3 col-form-label"><b>진행 상황</b></label> 
							<div class="col-sm-9">
						        <select class="form-control" id="ins_cls_state" name="ins_cls_state">
									<option value="진행">진행</option>
									<option value="대기">대기</option>
									<option value="종료">종료</option>
								</select>
							</div>
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
	
	<!--============================================================================================================== 수업등록 안 시작시간 Modal 시작 -->
	<div class="modal fade" id="int_sTime" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">시작 시간</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
				</div>	
				<div class="modal-body">
					<div>
						<p>시간을 선택하세요.</p>
						<input type="text" class="form-control input-sm" id="ins_check_sTime" name="ins_check_sTime" placeholder="입력창을 클릭하세요.">							
					</div>					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="int_sTimeCheck()">완료</button>
				</div>					
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->	
	<!--============================================================================================================== 수업등록 안 시작시간 Modal 끝 -->	

	<!--============================================================================================================== 수업등록 안 종료시간 Modal 시작 -->
	<div class="modal fade" id="int_eTime" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">종료 시간</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
				</div>	
				<div class="modal-body">
					<div>
						<p>시간을 선택하세요.</p>
						<input type="text" class="form-control input-sm" id="ins_check_eTime" name="ins_check_eTime" placeholder="입력창을 클릭하세요.">							
					</div>					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="int_eTimeCheck()">완료</button>
				</div>					
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->	
	<!--============================================================================================================== 수업등록 안 종료시간 Modal 끝 -->	