<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 	<%@ include file="../../common/bootStrap4UI.jsp" %> --%>
<!-- <div style="padding: 20px;">
   <h3><b>회원관리</b> / 인바디 수정</h3>   제목 틀 입니다. -->
   
<div class="modal" id="myInbodySee">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header  bg-primary text-white">
				<h5 class="modal-title">인바디 보기</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
<!-- Modal Body 부분 -->
    <!--=========================== 내용 시작 ===========================-->
			<div class="modal-body">
			<div style="padding-left: 40px; padding-top: 10px">
				<div class="form-group row" >
					<div class="col-sm-12">
						<img id="inbodyOneImg" 
						     style="max-width:500px; max-height:800px; min-height:500px"/>
					</div>
				</div>
			</div><!-- padding -->
			</div><!-- modal body -->
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>			
			</div>
		</div>
	</div>
</div>
