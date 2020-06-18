<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 등록</title>
<%@include file="../class/classCommon.jsp"%>
</head>
<body>
<!--============================================================================================================== 공지사항 등록 Modal 시작 -->
	<div class="modal fade" id="m_ins" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">공지사항 등록</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
				</div>
				<div class="modal-body">
					<!--=========================================================================================== form 시작  -->
					<form role="form" id="f_ins">
						<div class="form-group">
							<label for="c_name"><b>제목</b></label> 
							<input type="text" class="form-control input-sm" id="c_name" name="c_name" placeholder="공지사항 제목">
						</div>
						<div class="form-group">
							<label for="c_intro"><b>내용</b></label> 
							<textarea rows="5" class="form-control" id="c_intro" name="c_intro" placeholder="내용을 입력하세요.">
							</textarea>
						</div>
					<button type="button" class="btn btn-primary" onclick="noticeINS()">저장</button>
					</form>
					<!--=========================================================================================== form 끝  -->
				</div>
				<div class="modal-footer">
				</div>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->
	<!--============================================================================================================== 수업등록 Modal 끝 -->
</body>
</html>