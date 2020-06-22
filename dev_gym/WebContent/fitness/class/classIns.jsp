<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 클래스 공통코드 -->
<%@include file="classCommon.jsp"%>

</head>
<body>
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
						<div class="form-group">
							<label for="c_name"><b>수업명</b></label> 
							<input type="text" class="form-control input-sm" id="c_name" name="c_name" placeholder="수업명을 입력하세요">
						</div>
						<div class="form-group">
							<label for="c_tNumber"><b>강사 번호</b></label> 
					        <select class="form-control" id="c_tNumber" name="c_tNumber">
								<option>1111</option>
								<option>1112</option>
								<option>1113</option>
							</select>
						</div>
						<div class="form-group">
							<label for="c_tName"><b>강사명</b></label> 
							<input type="text" class="form-control input-sm" id="c_tName" name="c_tName" placeholder="강사 번호를 선택하세요." readonly>
						</div>						
						<div class="form-group">
							<label for="c_sports"><b>종목</b></label> 
							<input type="text" class="form-control input-sm" id="c_sports" name="c_sports" placeholder="종목을 입력하세요.">
						</div>
						<div class="form-group">
							<label for="c_type"><b>수업 구분</b></label> 
					        <select class="form-control" id="c_type">
								<option>개인 수업</option>
								<option>단체 수업</option>
							</select>
						</div>
						<div class="form-group">
							<label for="c_startDate"><b>시작일</b></label> 
							<input type="date" class="form-control input-sm" id="c_startDate" name="c_startDate" placeholder="연도-월-일">
						</div>
						<div class="form-group">
							<label for="c_endDate"><b>종료일</b></label> 
							<input type="date" class="form-control input-sm" id="c_endDate" name="c_endDate" placeholder="연도-월-일">
						</div>
						<div class="form-group">
							<label for="c_totalDays"><b>수업 일수</b></label> 
							<input type="text" class="form-control input-sm" id="c_totalDays" name="c_totalDays" placeholder="시작일과 종료일을 입력하세요.">
						</div>
						<div class="form-group">
							<label for="c_times"><b>수업 횟수</b></label> 
							<input type="text" class="form-control input-sm" id=c_times" name="c_times" placeholder="단위:수">
						</div>
						<div class="form-group">
							<label for="c_intro"><b>수업 소개</b></label> 
							<textarea rows="5" class="form-control" id="c_intro" name="c_intro">
							</textarea>
						</div>
						<div class="form-group">
							<label for="c_price"><b>가격</b></label> 
							<input type="text" class="form-control input-sm" id="c_price" name="c_price" placeholder="단위:원">
						</div>
						<div class="form-group">
							<label for="c_groupCode"><b>그룹코드</b></label> 
							<input type="text" class="form-control input-sm" id="c_groupCode" name="c_groupCode" placeholder="그룹코드를 입력하세요.">
						</div>
						<div class="form-group">
							<label for="c_process"><b>진행 상황</b></label> 
					        <select class="form-control" id="c_process" name="c_process">
								<option>진행</option>
								<option>대기</option>
								<option>종료</option>
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
</body>
</html>