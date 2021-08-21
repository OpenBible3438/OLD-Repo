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
	function getImage() {
		var url = "";
		var urls = null;
		$.ajax({
			method: "post"
			,data: "typecode=6"
			,url: "../gym/gymContImage.gym"
			,success: function(result) {
				var data = JSON.stringify(result);
				var jsonDoc = JSON.parse(data);
				
				//다중 이미지 처리
				var imgTag = "";
				for(var i=0; i<jsonDoc.length; i++) {
					var binaryData = jsonDoc[i].filedata;
					var blob = new Blob([new Uint8Array(binaryData)],{type:'image/png'});
					url = URL.createObjectURL(blob);
					imgTag += "<img src='"+url+"' style='width:250px; height:250px'/>"
					if((i+1)%3 == 0) {
						imgTag += "<br>";
					}
				}
				$('#text').html(imgTag);
				//다중 이미지 처리
			}
		});
	}
</script>

<div id="text"></div>
</body>
</html>