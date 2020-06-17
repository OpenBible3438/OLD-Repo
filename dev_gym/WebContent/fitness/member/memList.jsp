<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../../common/bootStrap4UI.jsp" %>
<!-- <script>
	function test() {
		alert("클릭");
	}
</script> -->
<style>
.b1{ 
	border-radius: 50px;
	width: 100%;
}

</style>
</head>
<body>
<div class="container">
<h4><b><br>회원관리 | 전체 회원 관리</b></h4>
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
	<button type="button" class="b1 btn-primary m-1" onClick="전체조회()">전체조회</button>
	<!--<button type="button" class="b1 btn-primary m-1" onClick="자세히보기()">자세히보기</button>   -->
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#myDetail" >자세히보기</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#myInbody" >인바디 보기</button>
</div>
<br>
<!-- 테이블 부분 -->
<table class="table table-bordered">
	<thead>
		<tr align="center">
			<th>번호</th>
			<th>회원번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>닉네임</th>
			<th>전화번호</th>
			<th>최근 인바디</th>
			<th>최초 등록일</th>
		</tr>
	</thead>
	<thead>
		<tr align="center">
			<th>1</th>
			<th>001</th>
			<th>test</th>
			<th>강감찬</th>
			<th>감찬</th>
			<th>010-0000-0000</th>
			<th>최근 인바디</th>
			<th>2020.06-17</th>
		</tr>
	</thead>
</table>
<!-- 테이블 부분 -->
<!-- ======================= 자세히 보기 모달창 =================================-->
<div class="modal" id="myDetail">
	<div class="modal-dialog" style="width:auto;display:table">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header bg-primary text-white">
				<h4 class="modal-title">자세히 보기</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<!-- Modal Body 부분 -->
			<div class="modal-body">
				<%@include file="./memDetail.jsp" %>
			</div>
			
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<!-- <button type="button" class="btn btn-primary" data-dismiss="modal">확인</button> -->
				<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>			
			</div>
		</div>
	</div>
</div>
</div>
<!-- =======================인바디 보기 모달창 =================================-->
<div class="modal" id="myInbody">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header bg-primary text-white">
				<h4 class="modal-title">인바디 보기</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<!-- Modal Body 부분 -->
			<div class="modal-body">
				<%@include file="./memInbodyIns.jsp" %>
			</div>
			
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<!-- <button type="button" class="btn btn-primary" data-dismiss="modal">확인</button> -->
				<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>			
			</div>
		</div>
	</div>
</div>
</div>
<!-- 삭제 모달 부분 -->


</body>
</html>