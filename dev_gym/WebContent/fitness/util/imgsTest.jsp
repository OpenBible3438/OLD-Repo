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
				var imgTag = "";
				for(var i=0; i<jsonDoc.length; i++) {
					var binaryData = jsonDoc[i].filedata;
					var blob = new Blob([new Uint8Array(binaryData)],{type:'image/png'});
					url = URL.createObjectURL(blob);
					//urls[i] = url;
					//
					
					imgTag += "<div>"
					imgTag += "<img src='"+url+"' style='width:250px; height:250px'/>"
					imgTag += "</div>"
					
					//
					if((i+1)%3 == 0) {
						imgTag += "<br>";
					}
				}
				//$('#test').attr('src',url);
				$('#text').html(imgTag);
				//URL.revokeObjectURL(url);
				//$('#text').text(binaryData.length);
				//alert(jsonDoc[0].filedata);
				//alert(url);
				//location.href = url;
			}
		});
// 		for(var i=0; i<urls.length; i++) {
// 			alert("i:"+i);
// 			URL.revokeObjectURL(urls[i]);
// 		}
	}
</script>
<img id="test"/>
<button onclick="getImage()">조회</button>
<div id="text"></div>
</body>
</html>