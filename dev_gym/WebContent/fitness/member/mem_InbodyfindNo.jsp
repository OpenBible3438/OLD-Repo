<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="modal" id="InbodyfindNo">
	<div class="modal-dialog" style="width:auto;display:table">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header">
				<h5 class="modal-title">회원번호 찾기</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<!-- Modal Body 부분 -->
    		<div class="modal-body" style="padding-left: 40px; padding-top: 20px">
				<form role="form" id="mem_InbodyfindNo" method="post" 
		      		  action="./fitness/insertResult.gym"
		      	       enctype="multipart/form-data">
	         	<div class="form-group row">
					<label for="gym_no" class="col-sm-4 col-form-label ">회원번호</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" 
							   id="inbody_find_no" >
					</div>
					<div class="col-sm-3">
						<a type="button" href="javascript:memno_search()" class="btn btn-primary mb-1">🔍</a>
					</div>
				</div>	  
				</form>
	    	</div>
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">확인</button>
				<button type="button" class="btn btn-danger">닫기</button>			
			</div>
		</div>
	</div>
</div>
