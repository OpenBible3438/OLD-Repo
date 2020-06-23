<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/bootStrap4UI.jsp" %>

<script type="text/javascript">
	$(document).on('hidden.bs.modal',function
	(event){
		if($('.modal:visible').length){
			$('body').addClass('modal-open');
		}
	});
</script>

<!-- 이미지 스타일 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
img.img {
  position: -webkit-sticky;
  position: sticky;
  top: 0;
  width: 100%;
  height: 100%;
}
</style>

<!-- 버튼 스타일 -->
<style>
.b1{ 
	border-radius: 50px;
	width: 100%;
}

</style>
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
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#info">전체조회</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#ins">등록</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#upd">수정</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#del">삭제</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#profile">프로필보기</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#info">맡은 수업 보기</button>
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
			<th>성별</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>상세주소</th>
			<th>우편번호</th>
		</tr>
	</thead>
	<tbody>
		<tr align="center">
			<td>01</td>
			<td data-field="TCH_PROFIMG">사진없음</td>
			<td data-field="TCH_NO">970124</td>
			<td data-field="TCH_ID">idTeacher</td>
			<td data-field="TCH_NAME">편성경</td>
			<td data-field="TCH_GENDER">여성</td>
			<td data-field="TCH_TEL">010-1234-5678</td>
			<td data-field="TCH_ADDR">서울시 금천구 가산동</td>
			<td data-field="TCH_ADDR_DTL">월드메르디앙2차</td>
			<td data-field="TCH_ZIPCODE">123456</td>
		</tr>
	</tbody>
</table>
</div>
<!-- 테이블 부분 -->
<!-- ===== 강사등록 modal =====  -->

<div class="modal" id="ins">
	<div class="modal-dialog modal-lg" style="width:auto">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header bg-primary text-white">
				<h5 class="modal-title_Ins">강사관리(등록)</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<div class="Ins_body">
				<%@include file="./tchIns.jsp" %>
			</div>
			
			
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">등록</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>			
			</div>
		</div>
	</div>
</div>
<!-- ===== 강사등록 modal end =====  -->


<!-- ===== 강사수정 modal ===== -->

<div class="modal" id="upd">
	<div class="modal-dialog modal-lg" style="width:auto">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header bg-primary text-white">
				<h5 class="modal-title_Upd">강사관리(수정)</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<div class="Upd_body">
				<%@include file="./tchUpd.jsp" %>
			</div>
			
			
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">수정</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>			
			</div>
		</div>
	</div>
</div>

<!-- ===== 강사수정 modal end ===== -->

<!-- =====삭제 modal=====  -->
<div class="modal" id="del">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header bg-primary text-white">
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

<!-- =====프로필 보기 modal ===== -->

<div class="modal" id="profile">
	<div class="modal-dialog modal-lg" style="width:auto">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header bg-primary text-white">
				<h5 class="modal-title">프로필보기</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<!-- Modal Body 부분 -->
			<div class="profile_body">
				<%@include file="./tchProfile.jsp" %>
			</div>
			
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
			
			</div>
		</div>
	</div>
</div>
<!-- =====프로필 보기 modal end ===== -->

<!-- =====맡은수업 보기 modal ===== -->

<div class="modal" id="info">
	<div class="modal-dialog modal-lg" style="width:auto">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header bg-primary text-white">
				<h5 class="modal-title">맡은수업 보기</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<!-- Modal Body 부분 -->
			<div class="info_body">
			<%@include file="./tchClassList.jsp" %>
			
			</div>
			
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
			
			</div>
		</div>
	</div>
</div>
<!-- =====맡은수업 보기 modal end===== -->

<!-- div 정렬 (센터) 닫는 부분 -->