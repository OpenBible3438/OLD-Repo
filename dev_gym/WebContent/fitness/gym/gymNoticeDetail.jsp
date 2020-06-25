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
	<div class="modal fade" id="m_detail" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">자세히 보기</h4>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
				</div>
				<div class="modal-body">
					<!--============ form 시작  -->
					<div class="form-group">
						<label for="not_title"><b>제목</b></label>
						<div class="px-3 py-3 continer border rounded" id = "not_title_dtl"></div>
						<label for="not_cont"><b>내용</b></label> 
						<div class="px-3 py-3 continer border rounded" id = "not_cont_dtl"></div>
					</div>
					<div class="form-group form-inline" style="float:right;">
						<label id="not_date"></label>
						<label id="not_time" style="margin-left:10px; margin-right:20px"></label>
					</div>
				</div>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
<!--============================ 공지사항 자세히보기 Modal 끝 ============================-->
</body>
</html>