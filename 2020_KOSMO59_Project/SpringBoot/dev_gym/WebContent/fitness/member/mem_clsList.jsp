<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal" id="clsListModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header">
				<h5 class="modal-title">등록된 수업 보기</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<!-- Modal Body 부분 -->
    <!--=========================== 내용 시작 ===========================-->
    		<div class="modal-body">
				<div style="padding-left: 40px; padding-top: 10px; padding-right: 40px">
					<div class="form-group row" >
						<table id="clsTable" class="table table-bordered"
						       data-toggle="table"
						       style="width:100%">
							<thead>
								<tr align="center">
									<th data-field="RNO">번호</th>
									<th data-field="MEM_NAME">회원이름</th>
									<th data-field="CLS_NO">수업번호</th>
									<th data-field="CLS_NAME">수업이름</th>
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
	</div>
</div>