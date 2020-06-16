<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../../common/bootStrap4UI.jsp" %>
<script type="text/javascript">
	function 강사조회(){
		alert("강사조회클릭!");
	}
</script>
</head>
<body>
<h4><b>강사관리 | 전체 강사 관리</b></h4>
<br>
<!-- 검색부분 -->
	<div class="input-group mb-3">
		<div class="input-group-prepend">
	    	<span class="input-group-text">@</span>
	    </div>
	    <div class="col-xs-4">
	    	<input type="text" class="form-control" placeholder="Username">
		</div> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<div class="input-group-prepend">
	    	<span class="input-group-text">@</span>
	    </div>
	    <div class="col-xs-4">
	    	<input type="text" class="form-control" placeholder="Username">
		</div>  
	</div>
<!-- 검색부분 -->

<div id="button">
	<button type="button" class="btn btn-primary" onClick="강사조회()">전체조회</button>
	<button type="button" class="btn btn-primary">등록</button>
	<button type="button" class="btn btn-primary">수정</button>
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">삭제</button>
	<button type="button" class="btn btn-primary">프로필보기</button>
	<button type="button" class="btn btn-primary">맡은 수업 보기</button>
</div>
<br>
<!-- 테이블 부분 -->
<table class="table table-bordered">
	<thead>
		<tr>
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
		<tr>
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
<div class="modal" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header">
				<h5 class="modal-title">삭제</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<!-- Modal Body 부분 -->
			<div class="modal-body">
				강사를 삭제하시겠습니까?
			</div>
			
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">삭제</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>			
			</div>
		</div>
	</div>
</div>
<!-- 삭제 모달 부분 -->

</body>
</html>