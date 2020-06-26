<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD

=======
>>>>>>> refs/heads/hjho
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
						<div class="form-group">
							<label for="upd_c_name"><b>수업명</b></label> 
							<input type="text" class="form-control input-sm" id="upd_c_name" name="upd_c_name" value="상수상수">
						</div>
						<div class="form-group">
							<label for="upd_c_tNumber"><b>강사 번호</b></label> 
					        <select class="form-control" id="upd_c_tNumber" name="upd_c_tNumber">
								<option>1111</option>
								<option>1112</option>
								<option>1113</option>
							</select>
						</div>
						<div class="form-group">
							<label for="upd_c_tName"><b>강사명</b></label> 
							<input type="text" class="form-control input-sm" id="upd_c_tName" name="upd_c_tName" placeholder="강사 번호를 선택하세요." readonly>
						</div>						
						<div class="form-group">
							<label for="upd_c_sports"><b>종목</b></label> 
							<input type="text" class="form-control input-sm" id="upd_c_sports" name="upd_c_sports" value="상수상수">
						</div>
						<div class="form-group">
							<label for="upd_c_type"><b>수업 구분</b></label> 
					        <select class="form-control" id="upd_c_type">
								<option>개인 수업</option>
								<option>단체 수업</option>
							</select>
						</div>
						<div class="form-group">
							<label for="upd_c_startDate"><b>시작일</b></label> 
							<input type="date" class="form-control input-sm" id="upd_c_startDate" name="upd_c_startDate" value="2020-06-20">
						</div>
						<div class="form-group">
							<label for="upd_c_endDate"><b>종료일</b></label> 
							<input type="date" class="form-control input-sm" id="upd_c_endDate" name="upd_c_endDate" value="2020-06-20">
						</div>
						<div class="form-group">
							<label for="upd_c_totalDays"><b>수업 일수</b></label> 
							<input type="text" class="form-control input-sm" id="upd_c_totalDays" name="upd_c_totalDays" value="상수상수">
						</div>
						<div class="form-group">
							<label for="upd_c_times"><b>수업 횟수</b></label> 
							<input type="text" class="form-control input-sm" id="upd_c_times" name="upd_c_times" value="상수상수">
						</div>
						<div class="form-group">
							<label for="upd_c_intro"><b>수업 소개</b></label> 
							<textarea rows="5" class="form-control" id="upd_c_intro" name="upd_c_intro" value="상수상수">
							</textarea>
						</div>
						<div class="form-group">
							<label for="upd_c_price"><b>가격</b></label> 
							<input type="text" class="form-control input-sm" id="upd_c_price" name="upd_c_price" value="상수상수">
						</div>
						<div class="form-group">
							<label for="upd_c_groupCode"><b>그룹코드</b></label> 
							<input type="text" class="form-control input-sm" id="upd_c_groupCode" name="upd_c_groupCode" value="상수상수">
						</div>
						<div class="form-group">
							<label for="upd_c_process"><b>진행 상황</b></label> 
					        <select class="form-control" id="upd_c_process" name="upd_c_process">
								<option>진행</option>
								<option>대기</option>
								<option>종료</option>
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