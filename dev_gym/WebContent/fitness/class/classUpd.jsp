<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!--============================================================================================================== 수업수정 Modal 시작 -->
	<div class="modal fade" id="c_upd" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">수업 수정</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
				</div>

				<!--=========================================================================================== form 시작  -->
				<div class="modal-body">

					<form role="form" id="f_upd">
						<input type="hidden" name="cud" value="upd">
						<div class="form-group">
							<label for="upd_cls_name"><b>수업명</b></label> 
							<input type="text" class="form-control input-sm" id="upd_cls_name" name="upd_cls_name">
						</div>
						<div class="form-group">
							<label for="upd_tch_name"><b>강사 </b></label>
							<a href="javascript:upd_tchName()"><font size=2 color=blue> &nbsp; 수정 here! </font></a>
							<input type="text" class="form-control input-sm" id="upd_tch_name" name="upd_tch_name" readonly>
							<input type="hidden" class="form-control input-sm" id="upd_tch_no" name="upd_tch_no">
							<!--  
					        <select class="form-control" id="upd_tch_name" name="upd_tch_name">

							</select>							
							-->
						</div>						
						<div class="form-group">
							<label for="upd_type_name"><b>종목 </b></label> 
							<a href="javascript:upd_typeName()"><font size=2 color=blue> &nbsp; 수정 here! </font></a>
							<input type="text" class="form-control input-sm" id="upd_type_name" name="upd_type_name" readonly>
							<input type="hidden" class="form-control input-sm" id="upd_type_no" name="upd_type_no">
							<!--  
					        <select class="form-control" id="upd_type_name" name="upd_type_name">

							</select>
							-->
							
						</div>
						<div class="form-group">
							<label for="upd_cls_kind"><b>수업 구분</b></label> 
					        <select class="form-control" id="upd_cls_kind" name="upd_cls_kind">
								<option value="개인 수업">개인 수업</option>
								<option value="단체 수업">단체 수업</option>
								<option value="매장 이용">매장 이용</option>
							</select>
						</div>
						<div class="form-group">
							<label for="upd_cls_s_date"><b>시작일</b></label> 
							<input type="date" class="form-control input-sm" id="upd_cls_s_date" name="upd_cls_s_date" placeholder="연도-월-일">
						</div>
						<div class="form-group">
							<label for="upd_cls_e_date"><b>종료일</b></label> 
							<input type="date" class="form-control input-sm" id="upd_cls_e_date" name="upd_cls_e_date" placeholder="연도-월-일">
						</div>
						<div class="form-group">
							<label for="upd_cls_cnt"><b>수업 횟수</b></label> 
							<input type="text" class="form-control input-sm" id="upd_cls_cnt" name="upd_cls_cnt">
						</div>
						<div class="form-group">
							<label for="upd_cls_info"><b>수업 소개</b></label> 
							<textarea rows="5" class="form-control" id="upd_cls_info" name="upd_cls_info">
							</textarea>
						</div>
						<div class="form-group">
							<label for="upd_cls_price"><b>가격</b></label> 
							<input type="text" class="form-control input-sm" id="upd_cls_price" name="upd_cls_price">
						</div>
						<div class="form-group">
							<label for="upd_cls_state"><b>진행 상황</b></label> 
					        <select class="form-control" id="upd_cls_state" name="upd_cls_state">
								<option value="진행">진행</option>
								<option value="대기">대기</option>
								<option value="종료">종료</option>
							</select>
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
	<div class="modal fade" id="c_upd_tchName" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
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
	<div class="modal fade" id="c_upd_typeName" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
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
