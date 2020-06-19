<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 수정 Modal -->
<div class="modal" id="contentUpdModal">
	<div class="modal-dialog">
		<div class="modal-content">
	        <!-- Modal Header -->
	        <div class="modal-header">
	         	<h4 class="modal-title">컨텐츠 수정</h4>
	         	<button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div> 
	        
	        <!-- Modal body -->
	        <div class="modal-body">
	        	<img src="bible.jpg" class="mx-auto d-block" style="width:50%">
	        	<button type="button" class="btn btn-outline-primary">사진선택하기</button> 
	        	<div class="form-group">
  					<label for="comment">컨텐츠 내용:</label>
  					<textarea class="form-control" rows="5" id="comment"></textarea>
				</div>
	        </div>
         
	        <!-- Modal footer -->
	        <div class="modal-footer">
	        	<button type="button" class="btn btn-primary" data-dismiss="modal">수정하기</button>
	        	<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	        </div>
		</div>
	</div>
</div>
</body>
</html>