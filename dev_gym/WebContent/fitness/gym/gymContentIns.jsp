<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<form id="f_ins" enctype="multipart/form-data" method="post">
			<input type="hidden" name="cud" value="ins">
	       		<div class="cropping">
	       			<img id="contentPreviews">
				</div>
	        	<input type="file" id="contentInputImgs" name="img" class="form-control-file border" accept=".gif, .jpg, .png">
	        	<div class="form-group">
  					<label for="cont_contents">컨텐츠 내용:</label>
  					<textarea class="form-control" rows="5" id="cont_contents" name="cont_contents"></textarea>
				</div>
			</form>
	        </div>
         
	        <!-- Modal footer -->
	        <div class="modal-footer">
	        	<button type="button" class="btn btn-primary" data-dismiss="modal" onClick="contentIns()">등록하기</button>
	        	<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	        </div>
		</div>
	</div>
</div>
