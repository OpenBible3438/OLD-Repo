<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 클래스 공통코드 -->
<link href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css" rel="stylesheet">
<script src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.js"></script>

	<script type="text/javascript">
	var updCLS_NO;
	var progress;
	
	function progressWork() {
		alert("진행 중인 수업을 조회합니다.");
	}
	function progressWait() {
		alert("대기 중인 수업을 조회합니다.");
		progress = $("#p_wait").html();
		alert(progress);
// 		$table.bootstrapTable('getData', {
// 			url: '../class/jsonClassList.gym?progress='+'wait'
//		});
		
	}
	function progressDone() {
		alert("종료된 수업을 조회합니다.");
	}
	function classSEL() {
		alert("전체 수업을 조회합니다.");
		$('#tb_cList').bootstrapTable('refreshOptions', {
	        url: '../class/jsonClassList.gym'
	  	});
	}

	function classINS(){
			alert("수업등록 저장 완료");
			$("#f_ins").attr("method","get");
			$("#f_ins").attr("action","classList.jsp");
			$("#f_ins").submit();
			$("#c_ins").modal('hide');
			location.href="classList.jsp";
	}
	function classUPD(){
			alert("수업수정 저장 완료");
			$("#f_upd").attr("method","get");
			$("#f_upd").attr("action","classList.jsp");
			$("#f_upd").submit();
			$("#c_upd").modal('hide');
			location.href="classList.jsp";
	}
	function classDetail(){
			alert("자세히보기 닫기 완료");
			$("#c_detail").modal('hide');
			location.href="classList.jsp";
	}
	function c_btnDel(){
			alert("선택한 수업을 삭제합니다.");
	}

	//------------------------------------------ 수강생 등록 모달 안 버튼 이벤트 시작
	function classMemSearch(){
		alert("수강생을 조회합니다.");
		
	}
	function classMemINS(){
			alert("수강생을 등록합니다.");
			$("#c_memIns").modal('hide');
			$("#c_detail").modal('open');
	}
	function classMemDEL(){
			alert("수강생을 삭제합니다.");
	}
	//------------------------------------------ 수강생 등록 모달 안 버튼 이벤트 끝

	</script>

</head>
<body>
	<div class="container">
		<div style="padding: 20px;">
			<h3>
				<b>수업관리</b> / 전체 수업 관리
			</h3>
			<!-- 제목 틀 입니다. -->
			<hr>
			<div style="padding-left: 40px; padding-top: 20px">
				<!-- 내용 틀 입니다. -->
				<!--======================================================================================= 버튼 시작-->
				<div id="button">
					<button type="button" class="btn btn-primary" onClick="classSEL()">전체조회</button>
					<button type="button" class="btn btn-primary dropdown-toggle"
						data-toggle="dropdown">진행상황</button>
					<div class="dropdown-menu" id="p_menu">
						<a class="dropdown-item" id="p_work" href="'../class/jsonClassList.gym?progress='+'p_work'" onClick="progressWork()">진행</a> 
						<a class="dropdown-item" id="p_wait" href="'../class/jsonClassList.gym?progress='+'p_wait'" onClick="progressWait()">대기</a> 
						<a class="dropdown-item" id="p_done" href="'../class/jsonClassList.gym?progress='+'p_done'" onClick="progressDone()">종료</a>
					</div>
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#c_ins">수업등록</button>
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#c_upd">수업수정</button>
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#c_info">자세히보기</button>
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#c_memList">수강생보기</button>
					<button type="button" class="btn btn-primary" onclick="c_btnDel()">삭제</button>
				</div>
		
				<div>
				<!--======================================================================================= 버튼 끝-->
					<p></p>
				</div>
		
				<!--======================================================================================= 테이블 시작-->
				<table class="table table-hover" id="tb_cList"
				 data-toggle="table"
				 data-url = "../class/jsonClassList.gym"
		  		 data-click-to-select="true"
		 		 data-pagination="true"				
				>
					<thead>
						<tr>
							<th data-checkbox=true>체크</th>
							<th data-field="ROWNUM">#</th>
							<th data-field="CLS_NO">수업번호</th>
							<th data-field="CLS_NAME">수업명</th>
							<th data-field="TCH_NAME">강사명</th>
							<th data-field="CLS_KIND">종목</th>
							<th data-field="CLS_CNT">수업횟수</th>
							<th data-field="CLS_DAYS">수업일수</th>
							<th data-field="CLS_S_DATE">시작일</th>
							<th data-field="CLS_E_DATE">종료일</th>
							<th data-field="CLS_PRICE">가격</th>
							<th data-field="CLS_STATE">진행상황</th>
						</tr>
					</thead>
					
				</table>
				<!--======================================================================================= 테이블 끝-->
			</div>
		
			<!-- 수업 등록 모달 -->
			<%@include file="classIns.jsp"%>
			<!-- 수업 수정 모달 -->
			<%@include file="classUpd.jsp"%>
			<!-- 자세히 보기 모달 -->
			<%@include file="classInfo.jsp"%>
			<!-- 수강생 보기 모달 -->
			<%@include file="classMemList.jsp"%>
			</div>
			
		</div>

	<!--============================================================================== 체크 로우  -->

</body>
</html>