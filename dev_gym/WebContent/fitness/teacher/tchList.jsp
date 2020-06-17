<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/common/bootStrap4UI.jsp" %>
<style>
.b1{ 
	border-radius: 50px;
	width: 100%;
}
</style>
</head>
<body>
<div class="container">
<h4><b><br>강사관리 | 전체 강사 관리</b></h4>
<br>
<!-- 검색부분 -->
	<div class="input-group mb-3">
		<div class="input-group-prepend">
	    	<span class="input-group-text">🔍</span>
	    </div>
	    <div class="col-xs-4">
	    	<input type="text" class="form-control" placeholder="강사이름검색">
		</div> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<div class="input-group-prepend">
	    	<span class="input-group-text">🔍</span>
	    </div>
	    <div class="col-xs-4">
	    	<input type="text" class="form-control" placeholder="강사번호검색">
		</div>  
	</div>
<!-- 검색부분 -->
<div class="btn-group" id="button_group" style="width:100%">
	<button type="button" class="b1 btn-primary m-1" onClick="강사조회()">전체조회</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#ins">등록</button>
	<button type="button" class="b1 btn-primary m-1" onClick="수정()">수정</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#del">삭제</button>
	<button type="button" class="b1 btn-primary m-1" onClick="프로필보기()">프로필보기</button>
	<button type="button" class="b1 btn-primary m-1" onClick="맡은수업보기()">맡은 수업 보기</button>
</div>
<br>
<!-- 테이블 부분 -->
<table class="table table-bordered">
	<thead>
		<tr align="center">
			<th>번호</th>
			<th>사진</th>
			<th>강사번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>상세주소</th>
			<th>우편번호</th>
		</tr>
	</thead>
	<tbody>
		<tr align="center">
			<td>01</td>
			<td>사진없음</td>
			<td>970124</td>
			<td>idTeacher</td>
			<td>편성경</td>
			<td>010-1234-5678</td>
			<td>서울시 금천구 가산동</td>
			<td>월드메르디앙2차</td>
			<td>123456</td>
		</tr>
	</tbody>
</table>
<!-- 테이블 부분 -->
<!-- ===== 강사등록 modal =====  -->
<div class="modal" id="ins">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header alert-primary">
				<h5 class="modal-title">강사관리(등록)</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<!-- Modal Body 부분 -->
			
			
			
			
		<form role="form" id="tc_ins"/>
			<div class="modal-body">
		<div class="form-group row">
			<label for="gym_id" class="col-sm-2 col-form-label ">아이디</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" required
					   id="gym_id" >
			</div>
			<div class="col-sm-3">
				<button onclick="id_confirm()" 
				        class="btn btn-primary mb-1">중복확인</button>
			</div>
				
			</div>
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">등록</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>			
			</div>
		</div>
	</div>
</div>
</div>
<!-- ===== 강사등록 modal end =====  -->

<!-- =====삭제 modal=====  -->
<div class="modal" id="del">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header">
				<h5 class="modal-title">강사관리(삭제)</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<!-- Modal Body 부분 -->
			<div class="modal-body">
				강사를 삭제하시겠습니까?
			</div>
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">예</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">아니요</button>			
			</div>
		</div>
	</div>
</div>
<!-- =====삭제 modal end=====  -->

</div> <!-- div 정렬 (센터) 닫는 부분 -->
</body>
</html>