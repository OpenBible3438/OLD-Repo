<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!--============================================================================================================== 자세히 보기 Modal 시작 -->
	<div class="modal fade" id="c_info" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">자세히 보기</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
				</div>

				<!--=========================================================================================== form 시작  -->
				<div class="modal-body">

					<form role="form" id="f_info">
						<div class="form-group">
							<label for="info_c_name"><b>수업명</b></label> 
							<input type="text" class="form-control input-sm" id="info_c_name" name="info_c_name" value="상수상수" readonly>
						</div>
						<div class="form-group">
							<label for="info_c_tNumber"><b>강사 번호</b></label> 
					        <select class="form-control" id="info_c_tNumber" name="info_c_tNumber" readonly>
								<option>1111</option>
								<option>1112</option>
								<option>1113</option>
							</select>
						</div>
						<div class="form-group">
							<label for="info_c_tName"><b>강사명</b></label> 
							<input type="text" class="form-control input-sm" id="info_c_tName" name="info_c_tName" placeholder="강사 번호를 선택하세요." readonly>
						</div>						
						<div class="form-group">
							<label for="info_c_sports"><b>종목</b></label> 
							<input type="text" class="form-control input-sm" id="info_c_sports" name="info_c_sports" value="상수상수" readonly>
						</div>
						<div class="form-group">
							<label for="info_c_type"><b>수업 구분</b></label> 
					        <select class="form-control" id="info_c_type" readonly>
								<option>개인 수업</option>
								<option>단체 수업</option>
							</select>
						</div>
						<div class="form-group">
							<label for="info_c_startDate"><b>시작일</b></label> 
							<input type="date" class="form-control input-sm" id="info_c_startDate" name="info_c_startDate" value="2020-06-20" readonly>
						</div>
						<div class="form-group">
							<label for="info_c_endDate"><b>종료일</b></label> 
							<input type="date" class="form-control input-sm" id="info_c_endDate" name="info_c_endDate" value="2020-06-20" readonly>
						</div>
						<div class="form-group">
							<label for="info_c_totalDays"><b>수업 일수</b></label> 
							<input type="text" class="form-control input-sm" id="info_c_totalDays" name="info_c_totalDays" value="상수상수" readonly>
						</div>
						<div class="form-group">
							<label for="info_c_times"><b>수업 횟수</b></label> 
							<input type="text" class="form-control input-sm" id="info_c_times" name="info_c_times" value="상수상수" readonly>
						</div>
						<div class="form-group">
							<label for="info_c_intro"><b>수업 소개</b></label> 
							<textarea rows="5" class="form-control" id="info_c_intro" name="info_c_intro" value="상수상수" readonly>
							</textarea>
						</div>
						<div class="form-group">
							<label for="info_c_price"><b>가격</b></label> 
							<input type="text" class="form-control input-sm" id="info_c_price" name="info_c_price" value="상수상수" readonly>
						</div>
						<div class="form-group">
							<label for="info_c_groupCode"><b>그룹코드</b></label> 
							<input type="text" class="form-control input-sm" id="info_c_groupCode" name="info_c_groupCode" value="상수상수" readonly>
						</div>
						<div class="form-group">
							<label for="info_c_process"><b>진행 상황</b></label> 
					        <select class="form-control" id="info_c_process" name="info_c_process" readonly>
								<option>진행</option>
								<option>대기</option>
								<option>종료</option>
							</select>
						</div>
					</form>
				<!--=========================================================================================== form 끝  -->
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="classDetail()">닫기</button>
				</div>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->
	<!--============================================================================================================== 자세히 보기 Modal 끝 -->