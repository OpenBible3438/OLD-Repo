<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<script type="text/javascript">
	$.ajax({
		method: "post"
		,data: "file_seq=6"
		,url: "../gym/gymContImage.gym"
		,success: function(result) {
			alert(result);
// 			var data = JSON.stringify(result);
// 			var jsonDoc = JSON.parse(data);
 			document.write(result.trim());
			//location.href = result.trim();
// 			$('#text').html(result.trim());
		}
	});
</script>

<div id="text"></div>
</body>
</html>