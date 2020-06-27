<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 등록</title>
</head>
<body>
<!--============================ 공지사항 등록 Modal 시작 ============================-->
	<div class="modal fade" id="m_ins_upd" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="m_title">공지사항 등록</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
				</div>
				<div class="modal-body">
					<!--============ form 시작  -->
					<form role="form" id="f_ins_upd">
						<input type="hidden" id="cud" name="cud">
						<input type="hidden" id="notice_no" name="notice_no">
						<div class="form-group">
							<label for="not_title"><b>제목</b></label> 
							<!-- <input type="text" class="form-control" id="not_title" name="not_title" placeholder="공지사항 제목"> -->
							<textarea rows="1" class="form-control" id="not_title" style="resize: none;" name="not_title" placeholder="공지사항 제목"></textarea>
						</div>
						<div class="form-group">
							<label for="not_cont"><b>내용</b></label> 
							<textarea rows="5" class="form-control" id="not_cont" name="not_cont" style="resize: none;" placeholder="내용을 입력하세요."></textarea>
						</div>
					<button type="button" class="btn btn-primary" onclick="noticeSave()">저장</button>
					</form>
					<!--================== form 끝  -->
				</div>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
<!--============================ 공지사항 등록 Modal 끝 ============================-->
</body>
</html>