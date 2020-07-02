<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	var g_row;
	function memList() {
		$('#tb_member').bootstrapTable('refreshOptions', {
        	url: "../member/jsonMemList.gym"
		});
	}
	function memSearch() {
		var msg = $('#searchMem').val();
		alert("회원검색 : "+msg);
		/* */
		$('#tb_member').bootstrapTable('refreshOptions', {
        	url: "../member/jsonMemListOne.gym?msg="+msg
		});
		 
	}
	//DOM구성이 완료되면...
	$(document).ready(function() {
    	$('#tb_member').bootstrapTable('refreshOptions', {
    		url: "../member/jsonMemList.gym"
        	,onClickRow : function(row,element,field){
            	g_row = row;
            	//alert("onClick 성공 :"+g_row.MEM_NO);
            }
            ,onDblClickRow : function(row,element,field){
            	//alert(g_row.FILE_SEQ);
				$('#dtl_mem_no').val(g_row.MEM_NO);
				$('#dtl_mem_id').val(g_row.MEM_ID);
				if(g_row.FILE_SEQ > 0) {
					$('#dtl_mem_profImg').attr('src', '../main/getImages.gym?file_seq='+g_row.FILE_SEQ);
				} else {
					$('#dtl_mem_profImg').attr('src', '../../images/noimage.png');
				}
				$('#dtl_mem_name').val(g_row.MEM_NAME);
				$('#dtl_mem_gender').val(g_row.MEM_GENDER);
				$('#dtl_mem_birth').val(g_row.MEM_BIRTH);
				$('#dtl_mem_tel').val(g_row.MEM_TEL);
				$('#dtl_mem_addr').val(g_row.MEM_ADDR);
          		$("#myDetail").modal('show');
          	}	
     	});
	});
	function showInbody(){
		//alert("인바디 보기");
		if(g_row != null) {
			var p_mem_no = g_row.MEM_NO;
			$("#mem_no_d").val(p_mem_no);
	        $("#mem_id_d").val(g_row.MEM_ID);
	        $("#mem_name_d").val(g_row.MEM_NAME);
       		$('#mem_inbodyImg_d').attr('src','../member/getInbodyImg.gym?mem_no='+p_mem_no);
			$("#myInbody").modal('show');
		}
		else {
			alert("회원을 클릭해주세요 ");
		}
	}
	function oneMemClsList() {
		//alert("등록한 수업 보기");
		if(g_row != null) {
			var mem_no = g_row.MEM_NO;
			//alert("mem_no"+mem_no);
			$('#clsTable').bootstrapTable('refreshOptions', {
	        	url: "../member/jsonOneMemClsList.gym?mem_no="+mem_no
			});
			$("#clsListModal").modal('show');
		}
		else {
			alert("회원을 클릭해주세요 ");
		}
	}

</script>

<div style="padding: 20px;">
	<h3><b>회원관리</b> / 전체 회원 관리</h3>   <!-- 제목 틀 입니다. -->
	<hr>
	<div style="padding-left: 40px; padding-top: 20px"> <!-- 내용 틀 입니다. -->
<!-- 검색부분 -->
		<div class="input-group mb-3">
			<div class="input-group-prepend">
		    	<span class="input-group-text">🔍</span>
		    </div>
		    <div class="col-xs-4">
		    	<input id="searchMem" type="text" class="form-control" placeholder="회원번호 or 회원이름 ">
			</div>&nbsp;
			<button type="button" class="btn btn-secondary" onClick="memSearch()">검색</button>
		</div>
<!-- 검색부분 -->
		<button type="button" class="btn btn-primary" onClick="memList()">전체조회</button>
		<!--<button type="button" class="b1 btn-primary m-1" onClick="자세히보기()">자세히보기</button>   -->
		<!-- <button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="myDetail" >자세히보기</button> -->
		<!-- <button type="button" class="btn btn-primary" data-toggle="modal" onClick="showInbody()" >인바디 보기</button> -->
		<button type="button" class="btn btn-primary" data-toggle="modal" onClick="oneMemClsList()" >등록한 수업 보기</button>
		<p></p>
<!-- 테이블 부분 -->
		<table id="tb_member" class="table table-bordered" 
       		   data-toggle="table"
  	           data-click-to-select="true"
               data-single-select="true"
               data-pagination="true">
			<thead>
				<tr align="center">
					<th data-checkbox=true>체크</th>
				<!-- 
					<th class="d-none" data-field="PAY_NO">결제번호</th>
					<th class="d-none" data-field="CLS_NO">수업번호</th>
					<th class="d-none" data-field="TCH_NO">강사번호</th>
					<th data-field="TYPE_NAME">수업타입</th>
					<th data-field="CLS_NAME">수업이름</th>
					<th data-field="TCH_NAME">강사이름</th>
				 -->
					<th data-field="RNO">번호</th>
					<th class="d-none" data-field="MEM_NO">회원번호</th>
					<th class="d-none" data-field="MEM_ID">회원아이디</th>
					<th data-field="MEM_NAME">회원이름</th>
					<th class="d-none" data-field="MEM_BIRTH">생년월일</th>
					<th data-field="MEM_GENDER">성별</th>
					<th data-field="MEM_TEL">회원전화번호</th>
					<th class="d-none" data-field="MEM_ADDR">회원주소</th>
					<th data-field="NUMS">등록한 총 수업</th>
					<th class="d-none" data-field="FILE_SEQ">회원프로필사진 번호</th>
				</tr>
			</thead>
		</table>
   </div>
</div>
<!-- 테이블 부분 -->
<!-- ======================= 자세히 보기 모달창 =================================-->

				<%@include file="./mem_Detail.jsp" %>

<!-- =======================인바디 보기 모달창 =================================-->

				<%-- <%@include file="./mem_InbodyDetail.jsp" %> --%>

<!-- =======================인바디 보기 모달창 =================================-->
		
				<%@include file="./mem_clsList.jsp" %>