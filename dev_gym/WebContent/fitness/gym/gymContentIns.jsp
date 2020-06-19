<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../../common/bootStrap4UI.jsp" %>
<script type="text/javascript">
	function readInputFile(input){
		if(input.files && input.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
				$("#preview").html("<img src="+e.target.result+">");
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	$(".input_img").on('change', function(){
		readInputFile(this);
	})
</script>
</head>
<body>
<!-- 등록 Modal -->
<div class="modal" id="contentInsModal">
	<div class="modal-dialog">
		<div class="modal-content">
	        <!-- Modal Header -->
	        <div class="modal-header">
	         	<h4 class="modal-title">컨텐츠 등록</h4>
	         	<button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div> 
	        
	        <!-- Modal body -->
	        <div class="modal-body">
	       		<img id="preview" name="input_img" src="">
	        	<input type="file" id="contentInputImg" class="form-control-file border" accept=".gif, .jpg, .png">
	        	<div class="form-group">
  					<label for="comment">컨텐츠 내용:</label>
  					<textarea class="form-control" rows="5" id="comment"></textarea>
				</div>
	        </div>
         
	        <!-- Modal footer -->
	        <div class="modal-footer">
	        	<button type="button" class="btn btn-primary" data-dismiss="modal" onClick="contentIns()">등록하기</button>
	        	<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	        </div>
		</div>
	</div>
</div>
</body>
</html>