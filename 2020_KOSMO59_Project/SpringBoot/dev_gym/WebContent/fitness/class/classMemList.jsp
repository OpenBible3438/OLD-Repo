<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!--============================================================================================================== 수강생 보기 Modal 시작 -->
	<div class="modal fade" id="c_memList" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">수강생 보기 <span style="color:gray">[<span id="m_className"></span>]</span></h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
				</div>
				<div class="modal-body" style="padding-left: 40px; padding-right: 40px; padding-top: 20px">
				
				<!--=========================================================================================== table 시작  -->
					<table class="table table-hover" id="tb_mList"
					 data-toggle="table"
			  		 data-click-to-select="true"
			  		 data-pagination="true"
			  		 data-single-select="true"					
					>
						<thead>
							<tr>
								<th data-checkbox=true>check</th>
								
								<th data-field="MEM_NO">회원 번호</th>
								<th data-field="MEM_NAME">회원 이름</th>
								<th data-field="MEM_NICKNAME">닉네임</th>
								<th data-field="MEM_BIRTH">생년월일</th>
								<th data-field="MEM_GENDER">성별</th>
								<th class="d-none" data-field="PAY_NO">PAY_NO</th>
								<!-- 
								<th data-field="MEM_CLS_CNT">남은 횟수</th>
								<th data-field="MEM_CLS_DAYS">남은 일수</th>
								<th data-field="MEM_ATT_RATE">출석률</th>
								-->
							</tr>
						</thead>
						
					</table>
				</div>
				<!--=========================================================================================== table 끝  -->

				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#c_memIns" onClick="classMemINS_open()">수강생 등록</button>
					<button type="button" class="btn btn-primary" onclick="classMemDEL()">수강생 삭제</button>
				</div>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->
	<!--============================================================================================================== 수강생 보기 Modal 끝 -->
	<!--============================================================================================================== 수강생 등록 Modal 시작 -->
	<div class="modal fade" id="c_memIns" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">수강생 등록</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
				</div>
				<div class="modal-body" style="padding-left: 40px; padding-right: 40px; padding-top: 20px">
										
					<div class="row">
						<label for="m_number" class="col-sm-3 col-form-label"><b>회원번호</b></label> 
						<div class="col-sm-6">
							<input type="text" class="form-control input-sm" id="c_mem_number" name="c_mem_number" placeholder="회원 번호 검색">
						</div>
						<button type="button" class="btn btn-primary btn-xs col-sm-3" onclick="classMemSearch()">검색</button> 
					</div>						
					<hr> 
					<!--=========================================================================================== 찾은 회원 정보 시작  -->
					<!--=========================================================================================== form 시작  -->
					<form role="form" id="m_ins">
						<input type="hidden" name="cud" value="ins">
						<input type="hidden" id="ins_mem_cls_no" name="cls_no">
						<!--  
						<input type="hidden" name="c_mem_pay_state" value="매장 결제">
						-->
						<!--  
						<img src="../class/c_member.jpg" class="rounded mx-auto d-block" width="150" heigth="150">
						-->												
						<div class="form-group row">
							<label for="c_mem_no" class="col-sm-3 col-form-label"><b>회원번호</b></label>
							<div class="col-sm-9"> 
								<input type="text" class="form-control input-sm" id="c_mem_no" name="c_mem_no" readonly>	
							</div>							
						</div>	
					</form>													
					<!--=========================================================================================== form 끝  -->
						<div class="form-group row">
							<label for="m_name" class="col-sm-3 col-form-label"><b>회원 이름</b></label> 
							<div class="col-sm-9"> 
								<input type="text" class="form-control input-sm" id="c_mem_name" name="c_mem_name" readonly>
							</div>	
						</div>						
						<div class="form-group row">
							<label for="c_mem_tel" class="col-sm-3 col-form-label"><b>전화번호</b></label>
							<div class="col-sm-9">  
								<input type="text" class="form-control input-sm" id="c_mem_tel" name="c_mem_tel" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="c_mem_birth" class="col-sm-3 col-form-label"><b>생년월일</b></label> 
							<div class="col-sm-9"> 
								<input type="text" class="form-control input-sm" id="c_mem_birth" name="c_mem_birth" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="c_mem_gender" class="col-sm-3 col-form-label"><b>성별</b></label> 
							<div class="col-sm-9"> 
								<input type="text" class="form-control input-sm" id="c_mem_gender" name="c_mem_gender" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="c_mem_joindate" class="col-sm-3 col-form-label"><b>가입일</b></label> 
							<div class="col-sm-9"> 
								<input type="text" class="form-control input-sm" id="c_mem_joindate" name="c_mem_joindate" readonly>
							</div>
						</div> 				
						
						
								
						<!--  
						<div class="form-group">
							<label for="c_mem_pay_date"><b>결제일</b></label> 
							<input type="date" class="form-control input-sm" id="c_mem_pay_date" name="c_mem_pay_date">
						</div>
						<div class="form-group">
							<label for="c_check_pTime"><b>결제시간</b></label>
							<input type="text" class="form-control input-sm" id="c_check_pTime" name="c_check_pTime" placeholder="입력창을 클릭하세요.">							
						</div>																						
						<p>빈칸을 채워 수강생을 등록하세요.</p>
						-->			
						
					<!--=========================================================================================== 찾은 회원 정보 끝  -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="classMemINS_close()">등록</button>
				</div>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->
	<!--============================================================================================================== 수강생 등록 Modal 끝 -->
	