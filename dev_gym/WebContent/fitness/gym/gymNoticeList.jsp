<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mode = request.getParameter("mode");
	if(mode!=null && mode.equals("refresh")){
		%>
		noticeList();
		<%
	}
%>
<%-- <%
	String gym_no = null;
	if(session.getAttribute("gym_no") != null){
		gym_no = session.getAttribute("gym_no").toString();
	}
	else {
		gym_no = "1";
	}
%> --%>
<!-- 등록,수정 모달 include -->
<%@include file="gymNoticeIns_Upd.jsp"%>
<script type="text/javascript">
	var choNotic_no = 0; //선택한 공지사항을 저장 
	var choNot_title = "";
	var choNot_cont = "";
	
	function noticeList(){
		$('#tb_nList').bootstrapTable('refreshOptions', {	//이 코드가 있어야 테이블 안의 데이터가 갱신된다.
	           url: '../gym/jsonGymNoticeList.gym'
	        });
	}
	function notSearch(){
		var not_title = $("#search_title").val();
		var not_cont = $("#search_cont").val();
		$('#tb_nList').bootstrapTable('refreshOptions', {
	           url: '../gym/jsonGymNoticeList.gym?not_title='+not_title+"&not_cont="+not_cont
	        });
	}
	function startIns(){
		$("#m_title").text("공지사항 등록");
		$("#cud").val("ins");
		$("#not_title").text("");
		$("#not_cont").text("");
		$("#m_ins_upd").modal({
			show : true
		  , keyboard : true
		  , focus : true
		})
	}
	function startUpd(){
		$("#m_title").text("공지사항 수정");
		$("#cud").val("upd");
		$("#not_title").text(choNot_title);
		$("#not_cont").text(choNot_cont);
		$("#m_ins_upd").modal({
			show : true
		  , keyboard : true
		  , focus : true
		})
	}
	function noticeDel(){
		location.href = "gymNoticeDel.gym?cud=del&notice_no="+choNotice_no;
	}
	function noticeSave(){
		alert("저장");
		$("#m_ins_upd").modal({
			show : false
		});
		if($("#cud").val()=="ins"){
			$("#f_ins_upd").attr('action', "../gym/gymNoticeIns.gym")
		}
		else if($("#cud").val()=="upd"){
			$("#f_ins_upd").attr('action', "../gym/gymNoticeUpd.gym")
		}
			$("#f_ins_upd").submit();
	}
	
</script>
<!-- ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<!--=========================== 전체 시작 ===========================-->
<div style="padding: 20px; margin-bottom: 50px">
   <h3><b>매장관리</b> / 공지사항</h3>   <!-- 제목 틀 입니다. -->
   <hr>
    <!--=========================== 내용 시작 ===========================-->
	<div style="padding-left: 40px; padding-top: 20px">
<br>
		<!--=========================== 검색부분 시작 ===========================-->
		<div class="input-group mb-3">
			<div class="input-group-prepend">
		    	<span class="input-group-text">제목</span>
		    </div>
		    <div class="col-xs-4">
		    	<input type="text" id="search_title" name="search_title" class="form-control" placeholder="제목으로 검색하세요.">
			</div> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<div class="input-group-prepend">
		    	<span class="input-group-text">내용</span>
		    </div>
		    <div class="col-xs-4">
		    	<input type="text" id="search_cont" name="search_cont" class="form-control" placeholder="내용으로 검색하세요.">
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-secondary" onClick="notSearch()">검색</button>
		</div>
		<!--=========================== 검색부분 끝 ===========================-->
		
		<!--=========================== 버튼부분 시작 =========================== -->
		<div id="button">
			<button type="button" class="btn btn-primary" onClick="noticeList()">전체조회</button>
			<button type="button" class="btn btn-primary" data-toggle="modal" onClick="startIns()">등록</button>
			<button type="button" class="btn btn-primary" data-toggle="modal" onClick="startUpd()">수정</button>
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#m_del">삭제</button>
		</div>
		<!--=========================== 버튼부분 끝 =========================== -->
<br>
			<!--=========================== 테이블 부분 시작 ===========================-->
		<table id="tb_nList" class="table table-bordered"
		 data-toggle="table"
		 data-url = "../gym/jsonGymNoticeList.gym"
  		 data-click-to-select="true"
  		 data-single-select="true"
 		 data-pagination="true"
		>
			<thead>
				<tr>
					<th data-checkbox=true>체크</th>
					<th data-field="NOTICE_NO">번호</th>
					<th data-field="NOT_TITLE">제목</th>
					<th data-field="NOT_CONT">내용</th>
				</tr>
			</thead>
		</table>
		<!--=========================== 테이블 부분 끝 ===========================-->
	</div>
    <!--=========================== 내용 끝 ===========================-->
</div>
<!--=========================== 전체 끝 ===========================-->

<!-- =====삭제 modal=====  -->
<div class="modal" id="m_del">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header">
				<h5 class="modal-title">공지사항 삭제</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<!-- Modal Body 부분 -->
			<div class="modal-body">
				공지사항을 삭제하시겠습니까?
			</div>
			
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" onClick="noticeDel()">삭제</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>			
			</div>
		</div>
	</div>
</div>
<!-- =====삭제 modal end=====  -->

<script>
    $('#tb_nList').on('check.bs.table', function (row, element) {
      //table.bootstrapTable('resetView')
     // alert("row : " + row + ", element : " + element.NOT_SEQ);
      choNotice_no = element.NOTICE_NO;
      choNot_title = element.NOT_TITLE;
  	  choNot_cont = element.NOT_CONT;
	});
</script>
