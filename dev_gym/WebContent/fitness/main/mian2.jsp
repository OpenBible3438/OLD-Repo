<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap 4 Website Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../../common/bootStrap4UI.jsp" %>
<link href="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.css" rel="stylesheet">
<script src="https://unpkg.com/bootstrap-table@1.16.0/dist/bootstrap-table.min.js"></script>
<script type="text/javascript">
	function test() {
		alert("test 호출");
		$('#testTable').bootstrapTable('refreshOptions', {
	        url: '../gym/jsonGymNoticeList.gym'
	  	});
	}
</script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function() {
	});
</script>
<button type="button" class="btn btn-primary" onclick="test()">전체 조회</button>
<table id="testTable" data-toggle="table" 
       class="display table table-bordered" >
    <thead>
        <tr><!-- not_seq, not_title, not_cont, gym_no -->
            <th data-field="NOT_SEQ">NO</th>
            <th data-field="NOT_TITLE">NO</th>
            <th data-field="NOT_CONT">NO</th>
            <th data-field="GYM_NO">NO</th>
        </tr>
    </thead>
</table>
<!-- 
<script>

	테이블 태그안에  data-url="json/data1.json" 이 있음
  var $table = $('#table')
  var $button = $('#button')

  $(function() {
    $button.click(function () {
      $table.bootstrapTable('refresh')
    })
  })
</script>
 -->
 <!-- 
 $table.bootstrapTable('refreshOptions', {
        showColumns: true,
        search: true,
        showRefresh: true,
        url: 'json/data1.json'
  })
  -->
	<!-- 
$.ajax({
	url : '../gym/jsonGymNoticeList.gym'
	,dataType : 'json'
	,success : function(data) {
		alert(JSON.stringify(data));
		$('#testTable').bootstrapTable({
			data : data
		});
	}
	,error : function(e) {
		console.log(e.responseText);
	}
});
   -->
</body>
</html>