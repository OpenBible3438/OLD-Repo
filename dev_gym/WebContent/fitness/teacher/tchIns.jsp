<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

//번호찾기 -> 등록
	function no_ins() {
		alert("등록하였습니다.");
	}
</script>
<!-- ===== 강사등록 modal =====  -->
<div class="modal" id="ins">
	<div class="modal-dialog modal-lg" style="width:auto">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header">
				<h5 class="modal-title_Ins">강사관리(등록)</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
		<!-- Modal Body 부분 -->
			<div class="Ins_body">
			<form role="form" id="tch_insF" method="post" 
		          action="../teacher/tchIns.gym"
		          enctype="multipart/form-data">
				<br>
				<div border="5" class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-6">
						<img id="img_ins" style="max-width:400px; max-height:200px">
						<br><br>
					</div>
					<div class="col-sm-3"></div>
				</div>
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-6">
						<input type="file" class="form-control-file border" id="img" name="img">
					</div>
				</div><br>
				<div class="form-group row">
					<div class="col-sm-1"></div>
					<label for="gym_tcnum" class="col-sm-2 col-form-label">강사번호</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" required readonly
							   id="gym_tcnum" name="tch_no">
					</div>
					<div class="col-sm-3">
						<a href="javascript:tch_nosearch()" 
						   class="btn btn-primary mb-1">번호찾기</a>
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-1"></div>
					<label for="gym_tcid" class="col-sm-2 col-form-label">강사아이디</label>
					<div class="col-sm-4">
						<input type="hidden" id="gym_tcid_ok" name="tch_id" >  
						<input type="hidden" name="cud" value="ins">  
						<input type="text" class="form-control" required  
						       id="gym_tcid">
					</div>
					<div class="col-sm-3">
						<a href="javascript:tch_ins_over()"
							class="btn btn-primary mb-1">중복</a>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-1"></div>
					<label for="gym_tcIpw" class="col-sm-2 col-form-label">비밀번호</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" required 
							   id="gym_tcIpw" name="tch_pw">
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-1"></div>
					<label for="gym_tcname" class="col-sm-2 col-form-label">강사이름</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" required 
							   id="gym_tcname" name="tch_name">
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-1"></div>
					<label for="gym_tctel" class="col-sm-2 col-form-label">연락처</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" required
							   id="gym_tctel" name="tch_tel">
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-1"></div>
					<label for="gym_tctel" class="col-sm-2 col-form-label">성별</label>
					<div class="col-sm-4">
						<select class="form-control" id="tch_gender" name="tch_gender">
		                            <option value="남성">남성</option>
		                            <option value="여성">여성</option>
		                </select>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-1"></div>
					<label for="tch_addr" class="col-sm-2 col-form-label">주소</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" required readonly
							   id="tch_addr" name="tch_addr">
					</div>
					<div class="col-sm-3">
						<a href="javascript:zip_search()" class="btn btn-primary mb-1">🔍</a>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-1"></div>
					<label for="gym_addr_dtl" class="col-sm-2 col-form-label">상세주소</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" 
							   id="gym_addr_dtl" name="tch_addr_dtl">
					</div>
					<div class="col-sm-2" >
						<input type="text" class="form-control" readonly
							   id="tch_zipcode" name="tch_zipcode"
							   placeholder="우편번호">
					</div>
				</div>	
			</form>
			</div>
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" onclick="tchIns()">등록</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>			
			</div>
		</div>
	</div>
</div>
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
<!-- ===== 강사등록 modal end =====  -->


<!-- ===== 번호찾기 modal ===== -->
<%@include file="./tchNoSearch.jsp" %>
