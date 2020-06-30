<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
<!-- 파일 이미지 로드 하기 -->
// 전역변수 
    var g_tch_no = 0;
    var g_tch_id = null;
    var g_element = null;
//전체조회	
	function tchList() {
		alert("전체 조회");
		$('#tb_tch').bootstrapTable('refreshOptions', {	//이 코드가 있어야 테이블 안의 데이터가 갱신된다.`
	    	url: '../teacher/jsonTchList.gym'
    	});
		
	}
//프로필보기
	function profile(){
		alert("프로필관리 클릭");
		if(g_element != null) {
		    $("#prof_tch_id").val(g_element.TCH_ID);
		    $("#prof_tch_no").val(g_element.TCH_NO);
		    $("#prof_tch_name").val(g_element.TCH_NAME);
		    $("#prof_tch_img").attr('src','../main/getImages.gym?file_seq='+g_element.FILE_SEQ);
		    $("#tch_intro").val(g_element.TCH_INTRO);
		    $("#tch_career").val(g_element.TCH_CAREER);
		    $("#prof_tch_like").val(g_element.TCH_LIKE);
			$('#profile_info').modal('show');
		} else {
			alert("강사를 클릭해주세요!");
		}
	}
	
//삭제버튼	
/* 	function tchDel() {
		alert("삭제버튼");
	}// 강사가 삭제 되려면... 결제이력 지워야되고, 수업, 강사, 회원의 결제 ㅣㅇ력도 사라져... 회원 출석 */  
	
//수정버튼
 	function tchUpd() {
		//alert("수정버튼");
		$('#tch_pro').submit();
	}
//등록버튼 -> 번호찾기		
	function tch_nosearch() {	
		//alert("번호찾기");
		$('#no_search').modal('show');
	}


//등록버튼 -> 주소찾기
	function zip_search() {	
		//alert("주소찾기");
		var noOk = $('#gym_tcnum').val();
		if(noOk == "") {
		    new daum.Postcode({
		        oncomplete: function(data) {
		            var result = JSON.stringify(data);
		            var addrDoc = JSON.parse(result);
		            $('#tch_addr').val(addrDoc.address);
		            $('#tch_zipcode').val(addrDoc.zonecode);
		           	//alert("addrDoc.sido : "+addrDoc.sido);
		         	
		        }
		    }).open();
		} else {
			alert("수정 할 수 없습니다.");
		}
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
					if("ok"== confirm) {
						alert("강사번호가 존재합니다");
						//모달이 닫히고 등록 페이지에 꽂힌다.
						$('#gym_tcnum').val(datas[0].TCH_NO);
						$('#gym_tcname').val(datas[0].TCH_NAME);
						$('#gym_tcid').val(datas[0].TCH_ID);
						$('#gym_tcid_ok').val(datas[0].TCH_ID);
						$('#gym_tcIpw').val(datas[0].TCH_PW);
						$('#gym_tctel').val(datas[0].TCH_TEL);
						$('#tch_zipcode').val(datas[0].TCH_ZIPCODE);
						$('#tch_gender').val(datas[0].TCH_GENDER);
						$('#tch_addr').val(datas[0].TCH_ADDR);
						$('#gym_addr_dtl').val(datas[0].TCH_ADDR_DTL);
						
						$('#no_search').modal('hide');
					} else if("1"== confirm){
						alert("이미 등록된 강사입니다.");
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
		//alert("중복 확인");
		var noOk = $('#gym_tcnum').val();
		if(noOk == "") {
		 	var s_tch_id = $('#gym_tcid').val();
		  	//alert("s_tch_id : "+s_tch_id);
		  	$('#gym_tcid_ok').val(s_tch_id);
			if(s_tch_id.length < 4 
			 ||s_tch_id.length > 9)  {
				alert("4자리 이상, 9자 이하의 아이디를 작성해주세요");
				return;
			}
			var result = check(s_tch_id);
			if(result) { 
				alert("영어 대,소문자, 숫자만 입력 가능 합니다.");
				return; 
			}
		  	$.ajax({
		  		method :'post'
				,data : 'tch_id='+s_tch_id
		  		,url :'../teacher/tchIDSearch.gym'
		  		,success: function(data) {
		  			var result = data.trim();
		  			if(result == 1) {
		  				alert("아이디가 존재합니다.");
		  			} else if(result == 0) {
		  				alert("사용가능한 아이디 입니다.");
					  	//중복확인 되면 이 input 태그에 값을 넣는다.
					 	$('#gym_tchId_ok').val(s_tch_id);
		  			}
		  			
		  		}
		  	});
		} else {
			alert("아이디를 바꿀수 없습니다.");
		}
	}
	/**/
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
	}
			
//등록버튼 - > 번호찾기 -> 검색
	function no_search_cancel() {
		//alert("취소 버튼");
		$('#no_search').modal('hide');
	}
	
	
//맡은수업보기
 	function infoOn() { 
 		if(g_element != null) {
	 		$('#infoTable').bootstrapTable('refreshOptions', {
	 			url: '../teacher/jsonTchClass.gym?tch_no='+g_element.TCH_NO
	 		});
	 		$('#info').modal('show');
		} else {
			alert("강사를 클릭해주세요!");
		}
 	}
	
 	
// 	$(document).on('hidden.bs.modal',function(event){
// 		if($('.modal:visible').length){
// 			$('body').addClass('modal-open');
// 		}
// 	});
	function tchIns() {
		$('#tch_insF').submit();
	}

 	$(document).ready(function() {	
 		$('#tb_tch').on('click-row.bs.table', function (row, $element, field) {
 	         g_element = $element;
 	         //alert(g_element.TCH_NO);
 	    });
	});/* document ready  끝 */
</script>

<!-- 이미지 스타일 -->
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
<div class="btn-group" id="button_group" style="width:70%">
	<button type="button" class="b1 btn-primary m-1" onclick="tchList()">전체조회</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#ins">등록</button>
<!-- 	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#upd" onclick="tchUpd()">수정</button> -->
	<!-- <button type="button" class="b1 btn-primary m-1" data-toggle="modal" onclick="tchDel()">삭제</button> -->
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" onclick="profile()">프로필관리</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" onclick="infoOn()">맡은 수업 보기</button> <!-- data-target="#info" -->
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
			<th data-field="TCH_NO">강사번호</th>
			<th data-field="TCH_ID">강사아이디</th>
			<th data-field="TCH_NAME">강사이름</th>
			<th data-field="TCH_TEL">전화번호</th>
			<th data-field="TCH_ADDR">주소</th>
			<th data-field="TCH_GENDER">성별</th>
			<th class="d-none"  data-field="TCH_INTRO">자기소개</th>
			<th class="d-none"  data-field="TCH_CAREER">경력사항</th>
			<th class="d-none"  data-field="TCH_LIKE">좋아요</th>
			<th class="d-none"  data-field="FILE_SEQ">프로필 사진번호</th>
		</tr>
	</thead>

</table>
</div>
<!-- 테이블 부분 -->

<!-- 강사등록 modal -->
<%@include file="./tchIns.jsp" %>
<!-- 강사등록 modal end-->

<!-- =====프로필 보기 modal ===== -->
<%@include file="./tchProfile.jsp" %>
<!-- =====프로필 보기 modal end ===== -->

<!-- =====맡은수업 보기 modal===== -->
 <%@include file="./tchClassList.jsp" %>
<!-- =====맡은수업 보기 modal end===== -->

<!-- ===== 강사수정 modal ===== -->
<%@include file="./tchUpd.jsp" %>
<!-- ===== 강사수정 modal end ===== -->

<!-- =====삭제 modal=====  -->


<!-- =====삭제 modal end=====  -->

<!-- div 정렬 (센터) 닫는 부분 -->