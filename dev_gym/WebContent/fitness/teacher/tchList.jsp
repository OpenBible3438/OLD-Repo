<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
//전체조회	
	function tchList() {
		alert("전체 조회");
		$('#tb_tch').bootstrapTable('refreshOptions', {	//이 코드가 있어야 테이블 안의 데이터가 갱신된다.`
	    url: '../teacher/jsonTchList.gym'
    });
		
	}
	
	
//등록버튼 -> 번호찾기		
	function tch_nosearch() {	
		alert("번호찾기");
	}


//등록버튼 -> 주소찾기
	function zip_search() {	
		alert("주소찾기");
	}
	
	
//삭제버튼
	function tch_del() {	
		alert("삭제를 하였습니다.");
	}


//등록버튼 - > 번호찾기 -> 강사번호 찾기
	function tch_ins_search() {
		//alert("강사번호 찾기");
		var s_tch_no = $('#gym_tchS').val();
		//alert("s_tch_no : "+s_tch_no);
		if(s_tch_no != null && s_tch_no.length > 0) {
			$.ajax({
				method:'post'
				,data: 'tch_no='+s_tch_no
				,url: '../teacher/tchNoSearch.gym'
				,success: function(data) {
					var datas = JSON.parse(data.trim());
					var confirm = datas[0].CONFIRM;
					if("확인"== confirm) {
						//모달이 닫히고 등록 페이지에 꽂힌다.
						alert("강사번호가 존재합니다");
						
					} else {
						alert("강사번호가 존재하지 않습니다. 강사등록을 해주세요");
					}
				}
			});
		} else {
			alert("강사번호를 입력 해주세요");
		}
		/* */
	}

//등록버튼 - > 번호찾기 -> 중복확인

	function tch_ins_over() {
		alert("중복 확인");
	  var s_tch_id = $('#tch_id').val();
	  alert("s_tch_id : "+s_tch_id);
<!--	  
		if(s_tch_id.length < 5 
		 ||s_tch_id.length > 9)  {
			alert("5자리 이상, 9자 이하의 아이디를 작성해주세요");
			return;
		}
		var result = check(s_tch_id);
		if(result) { 
			alert("영어 대,소문자, 숫자만 입력 가능 합니다.");
			return; 
		}
		$.ajax({
			method:'post'
			,data: 'tch_id='+tch_id
			,url: '../teacher/jsontchIDSearch.gym'
			,success: function(data) {
				id_check = data.trim();
				//alert("data : "+id_check);
				if(id_check == 1) {
					alert("중복된 아이디 입니다.");
				} else if(id_check == 0) {
					$('#j_tch_id_ok').val(s_tch_id);
					alert("사용가능한 아이디 입니다.");
				}
			}
		});
		// 48~57 : 0~9 
		// 65~90 : 영어 대문자
		// 97~122 : 영어 소문자
		function check(str) {
			//alert("str :"+str);
			var check = 0;
			for(i=0; i<str.length; i++) {
				var code = str.charCodeAt(i)
				//alert("code :"+code);result
				if( 47<code&&code<58 
				  ||64<code&&code<91
				  ||96<code&&code<123) {
					//영어 대,소분자, 숫자
					check = 0;
				} else {
					//사용불가 문자 
					check = 1;
				}
			}
			return check;
-->	
		}
//등록버튼 - > 번호찾기 -> 검색
	function no_search_cancel() {
		alert("취소 버튼");
		$('#no_search').modal('hide');
	}
	
	
//맡은수업보기
 	function infoOn() { 
 		$('#infoTable').bootstrapTable('refreshOptions', {
 			url: '../teacher/jsonTchClass.gym'
 		});
 		$('#info').modal('show');
 	}
	
 	
	$(document).on('hidden.bs.modal',function(event){
		if($('.modal:visible').length){
			$('body').addClass('modal-open');
		}
	});

 	$(document).ready(function() {	
 		$('#tb_tch').on('check.bs.table', function (row, element) {
 			alert("클릭");
 		     var tch_profimg = element.TCH_PROFIMG;
 		     var gym_no = element.GYM_NO;
 		     var tch_no = element.TCH_NO;
 		     var tch_name = element.TCH_NAME;
 		     var tch_intro = element.TCH_INTRO;
 		     $("#tch_profimg").val(tch_profimg);
 		     $("#gym_no").val(gym_no);
 		     $("#tch_no").val(tch_no);
 		     $("#tch_name").val(tch_name);
 		     $("#tch_intro").val(tch_intro);
 		     //$("#profile").modal('show');
 		});
/* 		$('#tb_tch').bootstrapTable({
	          ,onClickRow : function(row,element,field){
	            alert("선택한 로우");
	             var tch_no = row.TCH_NO;
	             var tch_name = row.TCH_NAME;
	             $("#profile").modal('show');
	             $("#tch_no").val(tch_no);
	             $("#tch_name").val(tch_name);
	             
	          	} 
	         });  */
	            /*  $.ajax ({
	            	 url: "../teacher/jsonTchProfile.gym?"
	            	,success : function(result) {
						if()
					}
	             }) */
		});/* document ready  끝 */
		
/* $('#no_search').modal('show').css({ 
	'margin-top':function() { //vertical centering  
		return -($(this).height() / 2);
	},
	'margin-left':function() { //vertical centering  
		return -($(this).width() / 2);
	}
}); */
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
		<!--=========================== 검색부분 시작 ===========================-->
		<div class="input-group mb-3">
			<div class="input-group-prepend">
		    	<span class="input-group-text">이름</span>
		    </div>
		    <div class="col-xs-4">
		    	<input type="text" id="search_title" name = "search_title" class="form-control" placeholder="이름으로 검색하세요">
			</div> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<div class="input-group-prepend">
		    	<span class="input-group-text">번호</span>
		    </div>
		    <div class="col-xs-4">
		    	<input type="text" class="form-control" placeholder="번호로 검색하세요">
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-secondary">검색</button>
		</div>
		<!--=========================== 검색부분 끝 ===========================-->
<!-- 검색부분 -->
<!--<div class="input-group mb-3">
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
	</div> --!>
<!-- 검색부분 -->
<div class="btn-group" id="button_group" style="width:100%">
	<button type="button" class="b1 btn-primary m-1" onclick="tchList()">전체조회</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#ins">등록</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#upd" onclick="tchUpd()">수정</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#del">삭제</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#profile">프로필보기</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" onclick="infoOn()" >맡은 수업 보기</button> <!-- data-target="#info" -->
</div>
<br>
<!-- 테이블 부분 -->
<table id="tb_tch" 
       class="table table-bordered" 
       data-toggle="table"
	   data-url="../teacher/jsonTchList.gym"
	   data-click-to-select="true"
	   data-single-select="true"
	   data-pagination="true">
	<thead>
		<tr align="center">
			<th data-checkbox=true>체크</th>
			<th data-field="RNO">번호</th>
			<th data-field="TCH_NO">강사번호</th>
			<th data-field="TCH_NAME">이름</th>
			<th data-field="TCH_TEL">전화번호</th>
			<th data-field="TCH_GENDER">성별</th>
			<th data-field="TCH_ADDR">주소</th>
			<th data-field="TCH_ADDR_DTL">상세주소</th>
			<th data-field="TCH_ZIPCODE">우편번호</th>
		</tr>
	</thead>
<!--
	<tbody>
		<tr align="center">
			<td data-field="RNO">01</td>
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
 -->
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
				<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="tch_del()">예</button>
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