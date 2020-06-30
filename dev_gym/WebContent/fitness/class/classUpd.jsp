<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!--============================================================================================================== 수업수정 Modal 시작 -->
	<div class="modal fade" id="c_upd" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">수업 수정</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
				</div>

				<div class="modal-body" style="padding-left: 40px; padding-right: 40px; padding-top: 20px">

					<!--=========================================================================================== form 시작  -->
					<form role="form" id="f_upd">
						<input type="hidden" name="cud" value="upd">
						<input type="hidden" id="upd_cls_cls_no" name="cls_no">
						
						<div class="form-group row">
							<label for="upd_cls_name" class="col-sm-3 col-form-label"><b>수업명</b></label> 
							<div class="col-sm-9">
								<input type="text" class="form-control input-sm" id="upd_cls_name" name="upd_cls_name">
							</div>
						</div>
						<div class="form-group row">
							<label for="upd_tch_name" class="col-sm-3 col-form-label"><b>강사 </b></label>
							<div class="col-sm-6">
								<!--  
								<a href="javascript:upd_tchName()"><font size=2 color=blue> &nbsp; 수정 here! </font></a>
								-->
								<input type="text" class="form-control input-sm" id="upd_tch_name" name="upd_tch_name" readonly>
								<input type="hidden" class="form-control input-sm" id="upd_tch_no" name="upd_tch_no">
							</div>
							<button type="button" class="btn btn-primary btn-xs col-sm-3" onclick="upd_tchName()">강사검색</button>
						</div>						
						<div class="form-group row">
							<label for="upd_type_name" class="col-sm-3 col-form-label"><b>종목 </b></label> 
							<div class="col-sm-6">
								<!--
								<a href="javascript:upd_typeName()"><font size=2 color=blue> &nbsp; 수정 here! </font></a>
								-->
								<input type="text" class="form-control input-sm" id="upd_type_name" name="upd_type_name" readonly>
								<input type="hidden" class="form-control input-sm" id="upd_type_no" name="upd_type_no">
							</div>
							<button type="button" class="btn btn-primary btn-xs col-sm-3" onclick="upd_typeName()">종목검색</button>
						</div>
						<div class="form-group row">
							<label for="upd_cls_kind" class="col-sm-3 col-form-label"><b>수업 구분</b></label>
							<div class="col-sm-9"> 
						        <select class="form-control" id="upd_cls_kind" name="upd_cls_kind">
									<option value="개인 수업">개인 수업</option>
									<option value="단체 수업">단체 수업</option>
									<option value="매장 이용">매장 이용</option>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label for="upd_cls_s_date" class="col-sm-3 col-form-label"><b>시작일</b></label> 
							<div class="col-sm-9">
								<input type="date" class="form-control input-sm" id="upd_cls_s_date" name="upd_cls_s_date" placeholder="연도-월-일">
							</div>
						</div>
						<div class="form-group row">
							<label for="upd_cls_e_date" class="col-sm-3 col-form-label"><b>종료일</b></label> 
							<div class="col-sm-9">
								<input type="date" class="form-control input-sm" id="upd_cls_e_date" name="upd_cls_e_date" placeholder="연도-월-일">
							</div>
						</div>
						
						<div class="form-group row">
							<label for="upd_cls_sTime" class="col-sm-3 col-form-label"><b>시작 시간&nbsp;&nbsp;</b></label> 
							<div class="col-sm-6">
								<!-- 
								<a href="javascript:ins_sTime()"><font size=2 color=blue> 수정 here! </font></a>
								-->
								<input type="text" class="form-control input-sm" id="upd_cls_sTime" name="upd_cls_sTime" readonly>
							</div>
							<button type="button" class="btn btn-primary btn-xs col-sm-3" onclick="ins_sTime()">시간선택</button>							
						</div>						
						<div class="form-group row">
							<label for="upd_cls_eTime" class="col-sm-3 col-form-label"><b>종료 시간&nbsp;&nbsp;</b></label> 
							<div class="col-sm-6">
								<!--
								<a href="javascript:ins_eTime()"><font size=2 color=blue> 수정 here! </font></a>
								-->
								<input type="text" class="form-control input-sm" id="upd_cls_eTime" name="upd_cls_eTime" readonly>	
							</div>
							<button type="button" class="btn btn-primary btn-xs col-sm-3" onclick="ins_eTime()">시간선택</button>					
						</div>						
						<div class="form-group row">
							<label for="upd_cls_day" class="col-sm-3 col-form-label"><b>수업 요일</b></label> 
							<div class="col-sm-9">
								<input type="text" class="form-control input-sm" id="upd_cls_day" name="upd_cls_day">
							</div>
						</div>
						<div class="form-group row">
							<label for="upd_cls_day" class="col-sm-3 col-form-label"><b>수업 횟수</b></label> 
							<div class="col-sm-9">
								<input type="text" class="form-control input-sm" id="upd_cls_cnt" name="upd_cls_cnt">
							</div>
						</div>					
						<div class="form-group row">
							<label for="upd_cls_info" class="col-sm-3 col-form-label"><b>수업 소개</b></label> 
							<div class="col-sm-9">
								<textarea rows="5" class="form-control" id="upd_cls_info" name="upd_cls_info">
								</textarea>
							</div>
						</div>
						<div class="form-group row">
							<label for="upd_cls_price" class="col-sm-3 col-form-label"><b>가격</b></label> 
							<div class="col-sm-9">
								<input type="text" class="form-control input-sm" id="upd_cls_price" name="upd_cls_price">
							</div>
						</div>
						<div class="form-group row">
							<label for="upd_cls_state" class="col-sm-3 col-form-label"><b>진행 상황</b></label> 
							<div class="col-sm-9">
						        <select class="form-control" id="upd_cls_state" name="upd_cls_state">
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
					<button type="button" class="btn btn-primary" onclick="classUPD()">저장</button>
				</div>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->
	<!--============================================================================================================== 수업수정 Modal 끝 -->
	
	<!--============================================================================================================== 수업수정 안 강사검색 Modal 시작 -->
	<div class="modal fade" id="c_upd_tchName" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">강사 검색</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
				</div>	
				
				<div class="modal-body">
					<p>강사를 선택하세요.</p>
					
					<!--======================================================================================= 테이블 시작-->
					<table class="table table-hover" id="tb_tList"
					 data-toggle="table"
			  		 data-click-to-select="true"
			 		 data-pagination="true"				
					>
						<thead>
							<tr>
								<!--  
								<th data-field="ROWNUM">#</th>
								-->
								<th data-checkbox=true>check</th>
								<th data-field="TCH_NO">강사번호</th>					
								<th data-field="TCH_ID">아이디</th>					
								<th data-field="TCH_NAME">강사명</th>					
								<th data-field="TCH_TEL">전화번호</th>					
								<th data-field="TCH_GENDER">성별</th>					
							</tr>
						</thead>
						
					</table>
					<!--======================================================================================= 테이블 끝-->
				</div>	
				
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="upd_tchSelecte()">선택</button>
				</div>				
		
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->	
	<!--============================================================================================================== 수업수정 안 강사검색 Modal 끝 -->
	
	<!--============================================================================================================== 수업수정 안 종목검색 Modal 시작 -->
	<div class="modal fade" id="c_upd_typeName" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">종목 검색</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
				</div>	
				
				<div class="modal-body">
					<p>종목을 선택하세요.</p>
					
					<!--======================================================================================= 테이블 시작-->
					<table class="table table-hover" id="tb_typeList"
					 data-toggle="table"
			  		 data-click-to-select="true"
			 		 data-pagination="true"				
					>
						<thead>
							<tr>
								<!--  
								<th data-field="ROWNUM">#</th>
								-->
								<th data-checkbox=true>check</th>
								<th data-field="TYPE_NAME">종목</th>					
							</tr>
						</thead>
						
					</table>
					<!--======================================================================================= 테이블 끝-->
				</div>	
				
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="upd_typeSelecte()">선택</button>
				</div>				
		
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->	
	<!--============================================================================================================== 수업수정 안 종목검색 Modal 끝 -->
