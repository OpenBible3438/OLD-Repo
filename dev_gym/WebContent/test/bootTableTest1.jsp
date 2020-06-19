<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  Jquery 가져오기 -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <!-- bootstrap 가져오기 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    <!-- bootstrap table 가져오기  -->
    <script src="https://unpkg.com/bootstrap-table@1.15.5/dist/bootstrap-table.min.js"></script>
<!-- 부트스트랩 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- 부트스트랩 테이블 -->
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.15.5/dist/bootstrap-table.min.css">
</head>
<body>
	<!-- 테이블 생성 부분 -->
	<table id="table">
		<thead>
			<tr>
				<!-- JSON 값과 매칭될 field를 명시 -->
				<th data-field="subject">학과</th>
				<th data-field="name">이름</th>
				<th data-field="number">학번</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
<script type="text/javascript">
	$(document).ready(function(){
			var $table = $("#table"); // 테이블 표현할 데이터 표현
			var result = [ { "subject": "경영학과", "name": "가나다", "number": "20191234" }
			, { "subject": "체육학과", "name": "알란", "number": "20194567" }
			, { "subject": "심리학과", "name": "구론", "number": "20171227" }
			, { "subject": "심리학과", "name": "구론", "number": "20171227" }
			];
			$table.bootstrapTable({ data: result })
		});
</script>
</body>
</html>