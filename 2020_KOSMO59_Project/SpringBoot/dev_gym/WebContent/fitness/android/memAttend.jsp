<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="padding: 20px;">
	<h3><b>출석</b> / 회원 출석</h3>   <!-- 제목 틀 입니다. -->
	<hr>
	<div style="padding-left: 40px; padding-top: 20px"> <!-- 내용 틀 입니다. -->
		<!--=========================== 검색부분 시작 ===========================-->
		<div class="input-group mb-3">
			<div class="input-group-prepend">
		    	<span class="input-group-text">🔍</span>
		    </div>
		    <div class="col-xs-4">
		    	<input id="mem_atd_search" type="text" class="form-control" placeholder="회원번호  or 회원이름 ">
			</div>&nbsp;
			<button type="button" class="btn btn-secondary" onClick="memAtdSearch()">검색</button>  
		</div>
		<!--=========================== 검색부분 끝 ===========================-->
<!-- 테이블 부분 -->
		<table id="mem_atd" 
		       class="table table-bordered" 
			   data-url="../android/jsonMemberAttend.gym"
			   data-toggle="table"
  	           data-click-to-select="true"
               data-single-select="true"
               data-pagination="true">
			<thead>
				<tr align="center">
					<th class="d-none" data-field="PAY_NO">결제번호</th>
					<th class="d-none" data-field="CLS_NO">수업번호</th>
					<th data-field="CLS_NAME">수업이름</th>
					<th class="d-none" data-field="TCH_NO">강사번호</th>
					<th class="d-none" data-field="TCH_NAME">강사이름</th>
					<th class="d-none" data-field="GYM_NO">매장번호</th>
					<th class="d-none" data-field="GYM_NAME">매장이름</th>
					<th data-field="MEM_NO">회원번호</th>
					<th data-field="MEM_NAME">회원이름</th>
					<th class="d-none" data-field="MEM_ATD_SEQ">출석번호</th>
					<th data-field="MEM_ATD_DATE">출석 날짜</th>
					<th data-field="MEM_ATD_IN">입실시간</th>
					<th data-field="MEM_ATD_OUT">퇴실시간</th>
					<th class="d-none" data-field="MEM_CLS_DAYS">남은일수</th>
					<th class="d-none" data-field="MEM_CLS_CNT">남은횟수</th>
				</tr>
			</thead>
		</table>
	</div>
</div>
<script type="text/javascript">
	function memAtdSearch() {
		var msg = $('#mem_atd_search').val();
		alert("회원검색 : "+msg);
		/* */
		$('#mem_atd').bootstrapTable('refreshOptions', {
	    	url: "../android/jsonMemberAttend.gym?msg="+msg
		});
		
	}
</script>

