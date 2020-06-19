<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 클래스 공통코드 -->
<%@include file="classCommon.jsp"%>

	<script type="text/javascript">
// 		function classMemDEL(){
// 			alert("수강생을 조회합니다.");
// 		}
// 		function classMemSearch(){
// 			alert("수강생을 조회합니다.");
// 		}
	</script>

</head>
<body>
	<!--============================================================================================================== 수강생 보기 Modal 시작 -->
	<div class="modal fade" id="c_memList" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">수강생 보기 [수업명]</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
				</div>

				<!--=========================================================================================== table 시작  -->
				<div class="modal-body" style="padding-left: 40px; padding-top: 20px">
					<table class="table table-hover" id="tb_mList" name="tb_mList">
						<thead>
							<tr>
								<th data-field="c_num">#</th>
								<th data-field="c_number">회원 번호</th>
								<th data-field="c_name">회원 이름</th>
								<th data-field="c_sports">남은 횟수</th>
								<th data-field="c_tName">남은 일수</th>
								<th data-field="c_times">등급</th>
								<th data-field="c_totalDays">출석율</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>2222</td>
								<td>장영실</td>
								<td>20</td>
								<td>90</td>
								<td>GOLD</td>
								<td>95%</td>
							</tr>
							<tr>
								<td>2</td>
								<td>2223</td>
								<td>김영삼</td>
								<td>20</td>
								<td>90</td>
								<td>SILVER</td>
								<td>75%</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!--=========================================================================================== table 끝  -->

				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#c_memIns">수강생 등록</button>
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

				<div class="modal-body" style="padding-left: 40px; padding-top: 20px">
					<!--=========================================================================================== form 시작  -->
					<form role="form" id="m_search">
						<div class="form-group">
							<label for="m_name"><b>회원 이름</b></label> 
							<input type="text" class="form-control input-sm" id="m_name" name="m_name" placeholder="회원 이름을 입력하세요.">
						</div>
						<div class="form-group">
							<label for="m_number"><b>회원 번호</b></label> 
							<input type="text" class="form-control input-sm" id="m_number" name="m_number" placeholder="회원 번호를 입력하세요.">
						</div>						
						<button type="button" class="btn btn-primary btn-xs" onclick="classMemSearch()">회원 찾기</button> 
					</form>
					<!--=========================================================================================== form 끝  -->
				
					<hr> 
				
					<!--=========================================================================================== 찾은 회원 정보 시작  -->
					<form role="form" id="m_ins">
						<img src="c_member.jpg" class="rounded mx-auto d-block" width="150" heigth="150">
						
						<div class="form-group">
							<label for="m_nickName"><b>닉네임</b></label> 
							<input type="text" class="form-control input-sm" id="m_nickName" name="m_nickName"">
						</div>
						<div class="form-group">
							<label for="m_birth"><b>생년월일</b></label> 
							<input type="date" class="form-control input-sm" id="m_birth" name="m_birth"">
						</div>
						<div class="form-group">
							<label for="m_tell"><b>전화번호</b></label> 
							<input type="tell" class="form-control input-sm" id="m_tell" name="m_tell"">
						</div>
						<div class="form-group">
							<label for="m_add"><b>주소</b></label> 
							<input type="text" class="form-control input-sm" id="m_add" name="m_add"">
						</div>
					</form>
						
					<!--=========================================================================================== 찾은 회원 정보 끝  -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="classMemINS()">등록</button>
				</div>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->
	<!--============================================================================================================== 수강생 등록 Modal 끝 -->
	


</body>
</html>