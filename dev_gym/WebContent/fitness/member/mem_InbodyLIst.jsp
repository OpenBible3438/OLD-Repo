<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- <%@include file="../../common/bootStrap4UI.jsp" %> --%>
 <script>
	 function test() {
		//alert("클릭");
	}
	
</script> 

<style>
.b1{ 
	border-radius: 50px;
	width: 100%;
}
</style>

<script type="text/javascript">
	var gmem_no=0;
	var g_element = null;
	//DOM구성이 완료되면...
	$(document).ready(function() {
		$('#inbd_member').on('click-row.bs.table', function (row, $element, field) {
			g_element = $element;
			//alert(g_element.MEM_NO);
		});
	});
</script>
<script type="text/javascript">
	function mem_noSearch() {
		alert("회원번호 검색 호출 성공");
		$("#InbodyfindNo").modal('show');
	}
	function memno_search(){
		//alert("회원번호 찾기 호출 성공");
		var mem_no = $("#inbody_find_no").val();
		alert("mem_no: "+mem_no);
		$.ajax({
			method: 'get'
			,data : 'mem_no='+mem_no
			,dataType: 'json'
			,url: '../member/jsonMemList.gym'
		   	,success : function(result) { // 회원번호, 회원이름
		   		alert(result);
		   		var data = JSON.stringify(result);
				var infoList = JSON.parse(data);
				if(infoList != "") {
					var r_mem_no = infoList[0].MEM_NO;
					var r_mem_name = infoList[0].MEM_NAME;
					//alert(r_mem_no);
					//alert(r_mem_name);
					$("#mem_no").val(r_mem_no);
					$("#mem_name").val(r_mem_name);
					$('#InbodyfindNo').modal('hide');
				} else {
					alert("등록된 번호가 없습니다.");
				}
			}
		});
	}
	function inbodySubmit() {
		//alert("인바디 사진 등록버튼 클릭 ");
		$('#inbodyins').submit();
	}
	function myInbodySee() {
		//alert("인바디 보기 호출 성공");
		if(g_element != null) {
			$("#myInbodySee").modal('show');
			$('#inbodyOneImg').attr('src','../main/getImages.gym?file_seq='+g_element.FILE_SEQ);
 		} else {
 			alert("이름을 클릭해 주세요");
 		}
	}
	function myInbodyDel(){
		//alert("파일을 삭제 호출 성공");
		if(g_element != null) {
			var inbody_seq = g_element.INBD_SEQ;
			alert("인바디 번호 호출 성공"+inbody_seq);
			location.href="../member/memInbodyDel.gym?cud=del&inbd_seq="+inbody_seq;
		} else {
 			alert("삭제할 이름을 클릭해 주세요");
 		}
	}
	function inbodyList() {
		$('#inbd_member').bootstrapTable('refreshOptions',{
			url : "../member/jsonMemInbody.gym"
		});
	}
</script>

<div class="container">
<h4><b><br>회원관리 | 인바디 관리</b></h4>
<br>
<!-- 검색부분 -->
	<div class="input-group mb-3">
		<div class="input-group-prepend">
	    	<span class="input-group-text">🔍</span>
	    </div>
	    <div class="col-xs-4">
	    	<input type="text" class="form-control" placeholder="회원이름검색">
		</div> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<div class="input-group-prepend">
	    	<span class="input-group-text">🔍</span>
	    </div>
	    <div class="col-xs-4">
	    	<input type="text" class="form-control" placeholder="회원번호검색">
		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" class="btn btn-secondary" onClick="notSearch()">검색</button>  
	</div>
<!-- 검색부분 -->
<div class="btn-group" id="button_group" style="width:50%">
	<button type="button" class="b1 btn-primary m-1" onClick="inbodyList()">전체조회</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="#myInbodyIns" >인바디 등록</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" onclick="myInbodySee()">인바디 보기</button>
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" onclick="myInbodyDel()" >인바디 삭제</button>
</div>
<br>
<!-- 테이블 부분 -->
<table id="inbd_member" class="table table-bordered" 
       					data-toggle="table"
 	   					data-pagination="true"
 	   					data-url="../member/jsonMemInbody.gym">
	<thead>
		<tr align="center">
			<th data-field="RNO">번호</th>
			<!-- <th data-field="INBD_PROFIMG">사진</th> -->
			<th class="d-none" data-field="INBD_SEQ">인바디 번호</th>
			<th class="d-none" data-field="FILE_SEQ">파일번호</th>
			<th data-field="MEM_NO">회원번호</th>
			<th data-field="MEM_NAME">회원이름</th>
			<th data-field="CK_DATE">측정일</th>
			<th data-field="FILENAME">파일이름</th>
		</tr>
	</thead>
	<!-- 
	<thead>
		<tr align="center">
			<th>1</th>
			<th>사진</th>
			<th>001</th>
			<th>강감찬</th>
			<th>인바디 목록</th>
			<th>2020.06.17</th>
		</tr>
	</thead>
	 -->
</table>
</div>
<!-- 테이블 부분 -->
<!-- ======================= 인바디 등록 모달창 =================================-->

<%@include file="./mem_InbodyIns.jsp" %>

<!-- =======================인바디 보기 모달창 =================================-->

<%@include file="./mem_InbodySee.jsp" %>
			
<!-- =======================인바디 삭제 모달창 =================================-->

<%@include file="./mem_InbodyDel.jsp" %>
			


