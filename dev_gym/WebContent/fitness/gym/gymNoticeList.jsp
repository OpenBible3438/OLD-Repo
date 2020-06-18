<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../../common/bootStrap4UI.jsp" %>
    
<!-- ******************************************************* -->
<% session.setAttribute("gym_no", 1); %>
<!-- 
*****************************************************
*************로그인 처리 할 때는 세션 만드는 코드 없애야 함 -->
<script type="text/javascript">
	function noticeList(){
		alert("강사조회클릭!");
	/* 	var $table = $("#table");
	  var data = [ { "NOT_SEQ": "바뀜", "NOT_TITLE": "가나다", "NOT_CONT": "20191234" }
	 			 , { "NOT_SEQ": "체육학과", "NOT_TITLE": "알란", "NOT_CONT": "20194567" }
	  		  , { "NOT_SEQ": "심리학과", "NOT_TITLE": "구론", "NOT_CONT": "20171227" }
				  , { "NOT_SEQ": "심리학과", "NOT_TITLE": "구론", "NOT_CONT": "20171227" } ];
		  $table.bootstrapTable({ data: data }) */
	 /*	$.ajax({
			url:"gym/jsonGymNoticeList.gym"
		  , success: function(data){
		  }
		}); */
		/* $('#table').bootstrapTable({
			  url: 'gym/jsonGymChartList.gym',
			  columns: [{
			    field: 'NOT_SEQ',
			    title: '번호'
			  }, {
			    field: 'NOT_TITLE',
			    title: '제목'
			  }, {
			    field: 'NOT_CONT',
			    title: '내용'
			  }]
			}) */
			
	}
	function noticeDel(){
		alert("삭제");
	}
	
	function noticeINS(){
		alert("등록");
		$("#f_ins").attr('action', "jsonGymNoticeList.gym")
		$("#f_ins").submit();
	}
	
</script>
</head>
<body>
<div style="padding: 20px;">
   <h3><b>매장관리</b> / 공지사항</h3>   <!-- 제목 틀 입니다. -->
   <hr>
   <div style="padding-left: 40px; padding-top: 20px"> <!-- 내용 틀 입니다. -->
      
<br>
<!-- 검색부분 -->
	<div class="input-group mb-3">
		<div class="input-group-prepend">
	    	<span class="input-group-text">제목</span>
	    </div>
	    <div class="col-xs-4">
	    	<input type="text" id="search_title" name = "search_title" class="form-control" placeholder="제목으로 검색하세요.">
		</div> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<div class="input-group-prepend">
	    	<span class="input-group-text">내용</span>
	    </div>
	    <div class="col-xs-4">
	    	<input type="text" class="form-control" placeholder="내용으로 검색하세요.">
		</div>  
	</div>
<!-- 검색부분 -->

<div id="button">
	<button type="button" class="btn btn-primary" onClick="noticeList()">전체조회</button>
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#m_ins">등록</button>
	<button type="button" class="btn btn-primary">수정</button>
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onClick="noticeDel()">삭제</button>
</div>
<br>
<!-- 테이블 부분 -->
<table id="tb_nList" class="table table-bordered"
 data-toggle="table"
data-url = "jsonGymNoticeList.gym"
>
	<thead>
		<tr>
		<!-- 	<th data-checkbox=true>체크</th> -->
			<th data-field="NOT_SEQ">번호</th>
			<th data-field="NOT_TITLE">제목</th>
			<th data-field="NOT_CONT">내용</th>
		</tr>
	</thead>
</table>
<!-- 테이블 부분 -->


      </div>
</div>

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
				<button type="button" class="btn btn-primary" onClick="noticeDel()">삭제</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>			
			</div>
		</div>
	</div>
</div>

				<!-- 등록 모달 include -->
			<%@include file="gymNoticeIns.jsp"%>





<!-- 삭제 모달 부분 -->
<script>
 $(function() {
    $('#table').on('check.bs.table', function (row, $element) {
      //table.bootstrapTable('resetView')
      alert("row : " + row + ", element : " + $element);
      
    });
}) 
</script>
<script type="text/javascript">
 	$(document).ready(function(){
			var $table = $("#table"); // 테이블 표현할 데이터 표현
			var result = [ 
				  { "CKB":0, "NOT_SEQ": "경영학과", "NOT_TITLE": "가나다", "NOT_CONT": "20191234" }
				, { "CKB":0, "NOT_SEQ": "체육학과", "NOT_TITLE": "알란", "NOT_CONT": "20194567" }
				, { "CKB":0, "NOT_SEQ": "심리학과", "NOT_TITLE": "구론", "NOT_CONT": "20171227" }
				, { "CKB":0, "NOT_SEQ": "심리학과", "NOT_TITLE": "구론", "NOT_CONT": "20171227" }
			];
			$table.bootstrapTable({ data: result })
		});
</script>
</body>
</html>