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
		,data: "type=gym&typecode=6"
		,url: "../gym/gymContImage.gym"
		,success: function(result) {
			alert(result);
			var data = JSON.stringify(result);
			var jsonDoc = JSON.parse(data);
			//document.write(result);
			alert(jsonDoc[0].filedata);
			for(var i=0; i<jsonDoc.length; i++) {
				document.write(jsonDoc[0].FILENAME+"<br>");
				document.write(jsonDoc[0].filesize+"<br>");
				document.write(jsonDoc[0].filedata+"<br>");
			}
		}
	});
</script>
<img id="test"/>
</body>
</html>