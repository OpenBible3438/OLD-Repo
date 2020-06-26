<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="modal fade" id="m_join" >
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
	<div class="modal-header">
    	<h4 class="modal-title">매장 회원가입</h4>
        <button type="button" class="close" data-dismiss="modal" >&times;</button>
    </div>
    <div class="modal-body" style="padding-left: 40px; padding-top: 20px">
		<form role="form" id="gym_join" method="post" 
		      action="./gym/joinResult.gym"
		      enctype="multipart/form-data"
		      >
		<div class="form-group row">
			<label for="gym_id" class="col-sm-2 col-form-label ">아이디</label>
			<div class="col-sm-5">
				<input type="hidden" class="form-control" name="cud" value="join">
				<input type="hidden" class="form-control" id="gym_sido" name="gym_sido">
				<input type="hidden" class="form-control" name="type" value="gym">
				<input type="hidden" class="form-control" id="gym_lat" name="gym_lat">
				<input type="hidden" class="form-control" id="gym_lng" name="gym_lng">
				<input type="hidden" class="form-control" id="j_gym_id_ok" name="j_gym_id">
				<input type="text" class="form-control isvalid" id="j_gym_id" required>
			</div>
			<div class="col-sm-3">
				<a type="button" id="confirm" href="javascript:id_confirm()"
				        class="btn btn-primary">중복확인</a><!--    중복확인</input> -->
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_pw" class="col-sm-2 col-form-label" >비밀번호</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" required
					   id="j_gym_pw" name="j_gym_pw" placeholder="8자리 이상 입력하세요" >
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_pw_2" class="col-sm-2 col-form-label">재 입력</label>
			<div class="col-sm-5">
				<input type="password" class="form-control"
					   id="j_gym_pw_2" placeholder="비밀번호 확인" onkeyup="pw_confirm()">
				
			</div>
			<div id="pw_icon" class="col-sm-1" style="padding-left: 0px">
				<i class="material-icons" style="font-size:36px;color:red">clear</i>
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_username" class="col-sm-2 col-form-label">이름 </label>
			<div class="col-sm-5">
				<input type="text" class="form-control"
					   id="gym_username" name="gym_username" required>
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_usertell" class="col-sm-2 col-form-label">전화번호 </label>
			<div class="col-sm-5">
				<input type="tel" class="form-control" required
					   id="gym_usertell" name="gym_usertell" placeholder="000-0000-0000">
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_name" class="col-sm-2 col-form-label">매장이름</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" required
					   id="gym_name" name="gym_name">
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_tel" class="col-sm-2 col-form-label">매장번호</label>
			<div class="col-sm-5">
				<input type="tel" class="form-control" id="gym_tel" name="gym_tel" required>
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_addr" class="col-sm-2 col-form-label">매장주소</label>
			<div class="col-sm-5">
				<input type="text" class="form-control"
					   id="gym_addr" name="gym_addr" readonly required>
			</div>
			<div class="col-sm-3">
				<a type="button" href="javascript:addrSearch()" 
					        class="btn btn-primary">주소검색</a>
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_addr_dtl" class="col-sm-2 col-form-label">매장상세주소</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" required
					   id="gym_addr_dtl" name="gym_addr_dtl">
			</div>
			<div class="col-sm-2" >
				<input type="text" class="form-control" readonly
					   id="gym_zipcode" name="gym_zipcode"
					   placeholder="우편번호">
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_number" class="col-sm-2 col-form-label">사업자번호</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" required
					   id="gym_number" name="gym_number" placeholder="000-00000-00">
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_profimg" class="col-sm-2 col-form-label">매장 프로필 사진</label>
			<img id="gym_profimg_img"src="#" class="col-sm-7" style="min-width:200px; min-height:100px"/>
		</div>
		<div class="form-group row">
			<div class="col-sm-2" ></div>
			<div class="col-sm-5">
				<input type="file" class="form-control-file border" id="gym_profimg" name="gym_profimg">
			</div>
		</div>
		<div class="form-group row">
			<label for="gym_info" class="col-sm-2 col-form-label">매장소개</label>
			<div class="col-sm-8">
				<textarea class="form-control" id="gym_info" name="gym_info" required>
				</textarea>
			</div>
		</div>
		<div class="form-group row">
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="checkbox" id="gym_parking" name="gym_parking"> 
				<label class="form-check-label" for="gym_parking">주차장</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="checkbox" id="gym_wash" name="gym_wash"> 
				<label class="form-check-label" for="gym_wash">샤워실</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="checkbox" id="gym_uniform" name="gym_uniform"> 
				<label class="form-check-label" for="gym_uniform">유니폼</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="checkbox" id="gym_locker" name="gym_locker"> 
				<label class="form-check-label" for="gym_locker">락커룸</label>
			</div>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary" onclick="joinINS()">가입</button><!--   -->
			<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
		</div>
	</form>
<!-- end of container -->
	</div><!-- 왼쪽 패딩 -->
		</div><!-- end of modal-content -->
	</div><!-- end of modal-dialog modal-lg -->
</div><!-- end of modal m_join-->
<script type="text/javascript">
	$(document).ready(function() {
		
	});
</script>
<!-- 파일 이미지 로드 하기 -->
<script type="text/javascript">
	//파일 첨부시 이미지 로드 하기 
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
            	//img태그 아이디
            	//alert("파일첨부1 : "+e.target.result);
                $('#gym_profimg_img').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
	//파일첨부 input태그 아이디
    $("#gym_profimg").change(function() {
        readURL(this);
    });
</script>


