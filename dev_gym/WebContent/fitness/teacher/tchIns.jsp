<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

//번호찾기 -> 등록
	function no_ins() {
		alert("등록하였습니다.");
	}
</script>

			<!-- Modal Body 부분 -->
		<div class="Ins_body">
			<br>
		<div border="5" class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<img class="img" 
					src="" style="min-height: 250px">
				<!-- witdh="300" height="300" -->
					<br> <br>
			</div>
			<div class="col-sm-3"></div>
		</div>
		
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<input type="file" class="form-control-file border">
			</div>
		</div>
		<br>
<!-- (테스트중인 파일첨부)	
		<div class="file">
			<label for="InputSubject1">파일첨부</label>
			<input id="fileInput" filestyle="" type="file" data-class-button="btn btn-default" data-class-input="form-control" data-button-text="" data-icon-name="fa fa-upload" class="form-control" tabindex="-1" style="position: absolute; clip: rect(0px 0px 0px 0px);"> 
			<div class="bootstrap-filestyle input-file">
				<input type="text" id="userfile" class="form-control" name="userfile" disabled="">
				<span class="group-span-filestyle input-file-btn" tabindex="0">
					<label for="fileInput" class="btn btn-default">
						<span class="glyphicon fa fa-upload"></span>
					</label>
				</span>
			</div>
		</div>
 -->	
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_tcnum" class="col-sm-2 col-form-label">강사번호</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" required 
					   id="gym_tcnum" >
				</div>
				<div class="col-sm-3">
				<button onclick="tch_nosearch()" class="btn btn-primary mb-1"
				data-toggle="modal" data-target="#no_search" 
				>번호찾기</button>
				</div>
		</div>
		
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_tcname" class="col-sm-2 col-form-label">강사이름</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" required disabled
					   id="gym_tcname" >
				</div>
		</div>
		
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_tcid" class="col-sm-2 col-form-label">강사아이디</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" required disabled
					   id="gym_tcid" >
				</div>
		</div>
		
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_tctel" class="col-sm-2 col-form-label">연락처</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" required
					   id="gym_tctel" >
				</div>
		</div>
		
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_tctel" class="col-sm-2 col-form-label">성별</label>
				<div class="col-sm-4">
				<select class="form-control" id="tch_gender">
                            <option value="M">남성</option>
                            <option value="F">여성</option>
                </select>
				</div>
		</div>
		
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_tczip" class="col-sm-2 col-form-label">주소</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" required disabled
					   id="gym_tczip" >
				</div>
		<div class="col-sm-3">
				<button onclick="zip_search()" class="btn btn-primary mb-1">🔍</button>
		</div>
			</div>
			
		<div class="form-group row">
			<div class="col-sm-1"></div>
			<label for="gym_addr_dtl" class="col-sm-2 col-form-label">상세주소</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" disabled
					   id="gym_addr_dtl" >
			</div>
			<div class="col-sm-2" >
				<input type="text" class="form-control" disabled
					   id="gym_zipcode" 
					   placeholder="우편번호">
			</div>
		</div>	
	</div>
<!-- ===== 강사등록 modal end =====  -->


<!-- ===== 번호찾기 modal ===== -->
<div class="modal" id="no_search">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
		
			<!-- Modal Header 부분 -->
			<div class="modal-header bg-primary text-white">
				<h5 class="modal-title_Ins">번호찾기</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<div class="no_body" style="min-height: 750px">
				<%@include file="./tchNoSearch.jsp" %>
			</div>
			
			
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="no_ins()">등록</button>
				<button type="button" class="btn btn-danger" onclick="no_search_cancel()">취소</button>			
			</div>
		</div>
	</div>
</div>