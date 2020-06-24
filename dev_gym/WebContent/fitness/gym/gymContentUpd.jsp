<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal" id="contentUpdModal">
	<div class="modal-dialog">
		<div class="modal-content">
	        <!-- Modal Header -->
	        <form id="f_upd">
	        <input type="hidden" name="cud" value="upd">
	        <div class="modal-header">
	         	<h4 class="modal-title"><input id="contUpd_seq" name="contUpd_seq" style="width:20px" readonly>번 컨텐츠 수정</h4>
	         	<button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div> 
	        
	        <!-- Modal body -->
	        <div class="modal-body">
	        	<img id="contentUpdPreview" class="col-sm-7" name="input_img" src="#" style="min-width:200px; min-height:100px">
	        	<input type="file" id="contentUpdImg" class="form-control-file border" accept=".gif, .jpg, .png">
	        	<div class="form-group">
  					<label for="contents_upd">컨텐츠 내용:</label>
  					<textarea class="form-control" rows="5" id="contents_upd" name="contents_upd"></textarea>
				</div>
	        </div>
	        </form>
         
	        <!-- Modal footer -->
	        <div class="modal-footer">
	        	<button type="button" class="btn btn-primary" data-dismiss="modal" onClick="contUpd()">수정하기</button>
	        	<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	        </div>
		</div>
	</div>
</div>

<script type="text/javascript">
	function contUpd(){
		alert("수정되었습니다.");
		$("#f_upd").attr("method", "get");
		$("#f_upd").attr("action", "../gym/contentUpd.gym");
		$("#f_upd").submit();
	}
	//파일 첨부시 이미지 로드 하기 
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
            	//img태그 아이디
            	//alert("파일첨부1 : "+e.target.result);
                $('#contentUpdPreview').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
	//파일첨부 input태그 아이디
    $("#contentUpdImg").change(function() {
        readURL(this);
    });
</script>