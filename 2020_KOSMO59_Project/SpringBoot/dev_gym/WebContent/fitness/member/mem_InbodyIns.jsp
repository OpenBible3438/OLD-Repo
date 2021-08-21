<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
img.img{
	position:webkit-stick;
	position:sticky;
	top:0;
	width: auto;
	height: auto;
}
</style>
<div class="modal" id="myInbodyIns">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header">
				<h5 class="modal-title">인바디 등록</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<!-- Modal Body 부분 -->
			<div class="modal-body" style="padding-left: 40px; padding-top: 20px">
			<form role="form" id="inbodyins" method="post" 
		      	  action="../member/memInbodyIns.gym"
		      	  enctype="multipart/form-data">
				<div class="form-group row">
					<label for="mem_no" class="col-sm-4 col-form-label ">회원번호</label>
					<div class="col-sm-5">
						<input type="hidden" name="cud" value="ins"> 
						<input type="text" class="form-control" 
					   		     id="mem_no" name="mem_no" readonly>
					</div>
					<div class="col-sm-3">
						<a type="button" class="btn btn-primary mb-1" href="javascript:mem_noSearch()">🔍</a>
					</div>
				</div>
				<div class="form-group row">
					<label for="mem_name" class="col-sm-4 col-form-label">회원이름</label>
					<div class="col-sm-5">
						<input type="text" class="form-control"
					   	 		 id="mem_name" name="mem_name" readonly>
					</div>
					
	    		</div>
	    		<div class="row">
               		<div class="col-sm-6">
                  		<img id="img_ins" style="max-width:400px; min-height:200px ;max-height:500px">
                  		<br><br>
              		</div>
               		<div class="col-sm-3"></div>
            	</div>
            	<div class="row">
               	<div class="col-sm-3"></div>
               		<div class="col-sm-6">
                  		<input type="file" class="form-control-file border" id="img" name="img">
               		</div>
            	</div>
   			</form>
			</div>
			
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" onclick="inbodySubmit()">등록</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>			
			</div>
		</div>
	</div>
</div>
<!-- ======================= 인바디 등록-회원번호 찾기 모달창  =================================-->
	<%@include file="./mem_InbodyfindNo.jsp" %>
<script type="text/javascript">
   //파일 첨부시 이미지 로드 하기 
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                  $('#img_ins').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
   //파일첨부 input태그 아이디
    $("#img").change(function() {
        readURL(this);
    });
</script>