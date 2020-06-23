<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	       		<img id="contentPreview" class="col-sm-7" name="input_img" src="#" style="min-width:200px; min-height:100px">
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

<script type="text/javascript">
	function contentIns(){
		alert('등록하기!');
	}
	//파일 첨부시 이미지 로드 하기 
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
            	//img태그 아이디
            	//alert("파일첨부1 : "+e.target.result);
                $('#contentPreview').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
	//파일첨부 input태그 아이디
    $("#contentInputImg").change(function() {
        readURL(this);
    });
</script>