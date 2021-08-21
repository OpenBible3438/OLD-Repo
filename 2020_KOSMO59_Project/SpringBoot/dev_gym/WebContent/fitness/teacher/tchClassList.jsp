<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- =====맡은수업 보기 modal ===== -->

<div class="modal" id="info">
	<div class="modal-dialog modal-lg" style="width:auto">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header">
				<h5 class="modal-title">맡은수업 보기</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<!-- Modal Body 부분 -->
			<div class="info_body">
				<table id="infoTable" class="table table-bordered" data-toggle="table"
													data-click-to-select="true"
													data-pagination="true"><!-- data-url="../teacher/jsonTchClass.gym" -->
					<thead>
						<tr align="center">
							<th data-field="TCH_NAME">강사이름</th>
							<th data-field="CLS_NO">수업번호</th>
							<th data-field="CLS_NAME">수업명</th>
							<th data-field="CLS_KIND">종목</th>
							<th data-field="CLS_INFO">소개</th>
							<th data-field="CLS_PRICE">가격</th>
							<th data-field="CLS_LIKE">좋아요 수</th>
							<th data-field="CLS_STATE">진행상태</th>
						</tr>
					</thead>
				</table>
			</div>
<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
			
			</div>
		</div>
	</div>
</div>
