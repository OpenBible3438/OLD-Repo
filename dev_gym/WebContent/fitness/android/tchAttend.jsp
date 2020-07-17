<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="padding: 20px;">
	<h3><b>출석</b> / 강사 출석</h3>   <!-- 제목 틀 입니다. -->
	<hr>
	<div style="padding-left: 40px; padding-top: 20px"> <!-- 내용 틀 입니다. -->
		<!--=========================== 검색부분 시작 ===========================-->
		<div class="input-group mb-3">
			<div class="input-group-prepend">
		    	<span class="input-group-text">🔍</span>
		    </div>
		    <div class="col-xs-4">
		    	<input id="tch_atd_search" type="text" class="form-control" placeholder="강사번호 or 강사이름 ">
			</div>&nbsp;
			<button type="button" class="btn btn-secondary" onClick="tchAtdSearch()">검색</button>  
		</div>
		<!--=========================== 검색부분 끝 ===========================-->
<!-- 테이블 부분 -->
		<table id="tch_atd" 
		       class="table table-bordered" 
			   data-url="../android/jsonTeacherAttend.gym"
			   data-toggle="table"
  	           data-click-to-select="true"
               data-single-select="true"
               data-pagination="true">
			<thead>
				<tr align="center">
					<th data-field="GYM_NO">매장번호</th>
					<th data-field="TCH_ATD_SEQ">출석번호</th>
					<th data-field="TCH_NAME">퇴근시간</th>
					<th data-field="TCH_NO">강사번호</th>
					<th data-field="TCH_ATD_DATE">출근일자</th>
					<th data-field="TCH_ATD_IN">출근시간</th>
					<th data-field="TCH_ATD_OUT">퇴근시간</th>
				</tr>
			</thead>
		</table>
	</div>
</div>
<script type="text/javascript">
	function tchAtdSearch() {
		var msg = $('#tch_atd_search').val();
		//alert("회원검색 : "+msg);
		/* */
		$('#tch_atd').bootstrapTable('refreshOptions', {
	    	url: "../android/jsonTeacherAttend.gym?msg="+msg
		});
		
	}
</script>
