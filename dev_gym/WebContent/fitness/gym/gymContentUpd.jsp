<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal" id="contentUpdModal">
	<div class="modal-dialog">
		<div class="modal-content">
	        <!-- Modal Header -->
	        <form id="f_upd" enctype="multipart/form-data" method="post">
	        <input type="hidden" name="cud" value="upd">
	        <div class="modal-header">
	         	<h4 class="modal-title"><input id="contUpd_seq" name="contUpd_seq" style="width:60px" readonly>번 컨텐츠 수정</h4>
	         	<button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div> 
	        
	        <!-- Modal body -->
	        <div class="modal-body">
	         	<div class="cropping">
		        	<img id="contentUpdPreview">
				</div>
	        	<input type="file" id="contentUpdImg" name="img"class="form-control-file border" accept=".gif, .jpg, .png">
	        	<div class="form-group">
  					<label for="contents_upd">컨텐츠 내용:</label>
  					<textarea class="form-control" rows="5" id="contents_upd" name="contents_upd"></textarea>
				</div>
	        </div>
	        </form>
         
	        <!-- Modal footer -->
	        <div class="modal-footer">
	        	<button type="button" class="btn btn-primary" onClick="contUpd()">수정하기</button>
	        	<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	        </div>
		</div>
	</div>
</div>

<script type="text/javascript">
	function contUpd(){
		//alert("수정되었습니다.");
		var contentUpdImgs = $('#contentUpdImg').val();
		var contents_upds = $('#contents_upd').val().trim();
		if(contentUpdImgs != "") {
			if(contents_upds != "") {
				$("#f_upd").attr("action", "../gym/contentUpd.gym");
				$("#f_upd").submit();
			} else {
				alert("내용을 입력해주세요");
			}
		}
		else {
			alert("이미지를 등록해주세요 ");
		}
	}
</script>