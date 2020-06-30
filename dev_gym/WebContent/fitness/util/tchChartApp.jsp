<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			method: 'get'
			,url:'./tchChart.jsp'
			,success: function(data) {
				$('#test').html(data);
			}
		
		});
	});
</script>
<div id="test"></div>
</body>
</html>