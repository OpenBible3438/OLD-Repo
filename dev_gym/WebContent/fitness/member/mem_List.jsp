<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <script>
	function test() {
		//alert("클릭");
	}
</script>

<style>
.b1{ 
	border-radius: 50px;
	width: 100%;
}
  
</style>
<script type="text/javascript">
	var gmem_no=0;
	//DOM구성이 완료되면...
	function memList() {
		$('#tb_member').bootstrapTable('refreshOptions', {
        	url: "../member/jsonMemList.gym"
		});
	}
	$(document).ready(function() {
    	$('#tb_member').bootstrapTable('refreshOptions', {
        	url: "../member/jsonMemList.gym"
            /*     
            */
            ,onClickRow : function(row,element,field){
            	gmem_no = row.MEM_NO;
            	gmem_id = row.MEM_ID;
            	gmem_name = row.MEM_NAME;
            	//alert("onClick 성공 :"+gmem_name);
            }
            ,onDblClickRow : function(row,element,field){
        	 //alert("선택한 로우");
//             var mem_no = row.MEM_NO;
	        	gmem_no = row.MEM_NO;
	           	var mem_name = row.MEM_NAME;
           		var mem_id = row.MEM_ID;
             	var mem_nickname = row.MEM_NICKNAME;
             	var mem_tel = row.MEM_TEL;
             	var mem_joindate = row.MEM_JOINDATE;
          	 	$("#myDetail").modal('show');
	            $("#mem_no").val(gmem_no);
	            $("#mem_name").val(mem_name);
	            $("#mem_id").val(mem_id);
	            $("#mem_nickname").val(mem_nickname);
	            $("#mem_tel").val(mem_tel);
	            $("#mem_joindate").val(mem_joindate);
            
             //alert("회원번호 : "+mem_no);
             //location.href= '/member/mem_Detail.jsp?mem_no='+mem_no;
             //==> board_no를 넘겨주면 해당 게시글을  select!!
            //alert("g_no"+gmem_no);
			  	$.ajax({
					url: "../member/jsonMemDetail.gym?mem_no="+gmem_no
					,success : function(result){
						if(mem_name != null){
							 var infoList = JSON.parse(result.trim());//trim() : 공백제거
							 //alert("infoList : " + infoList);
							 mem_gender = infoList[0].MEM_GENDER;   
							 mem_addr = infoList[0].MEM_ADDR;   
							 mem_addr_dtl = infoList[0].MEM_ADDR_DTL;   
							 mem_birth = infoList[0].MEM_BIRTH;   
							 //alert("mem_addr : " + mem_addr);
							  $("#mem_gender").val(mem_gender);
							  $("#mem_addr").val(mem_addr);
							  $("#mem_addr_dtl").val(mem_addr_dtl);
							  $("#mem_birth").val(mem_birth);
							  
						}
					}
				});
          	}	
     	});
	});
	function showInbody(){
		 $("#mem_no_d").val(gmem_no);
         $("#mem_id_d").val(gmem_id);
         $("#mem_name_d").val(gmem_name);
		$("#myInbody").modal('show');
	}
	/* 
	function showMemdetail(){
		$("#mem_no").val(mem_no);
        $("#mem_name").val(mem_name);
        $("#mem_id").val(mem_id);
        $("#mem_tel").val(mem_tel);
        $("#mem_nickname").val(mem_nickname);
        $("#mem_joindate").val(mem_joindate);
		$("#myDetail").modal({
			show:true
		});
	} 
	*/
</script>

<div class="container">
<h4><b><br>회원관리 | 전체 회원 관리</b></h4>
<br>
<!-- 검색부분 -->

	<div class="input-group mb-3">
			<div class="input-group-prepend">
		    	<span class="input-group-text">회원이름</span>
		    </div>
		    <div class="col-xs-4">
		    	<input type="text" id="search_memName" name="search_memName" class="form-control" placeholder="회원이름으로 검색하세요.">
			</div> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<div class="input-group-prepend">
		    	<span class="input-group-text">회원번호</span>
		    </div>
		    <div class="col-xs-4">
		    	<input type="text" id="search_memNo" name="search_memNo" class="form-control" placeholder="회원번호로 검색하세요.">
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-secondary" onClick="notSearch()">검색</button>
		</div>
<!-- 검색부분 -->
<div class="btn-group" id="button_group" style="width:50%">
	<button type="button" class="b1 btn-primary m-1" onClick="memList()">전체조회</button>
	<!--<button type="button" class="b1 btn-primary m-1" onClick="자세히보기()">자세히보기</button>   -->
	<!-- <button type="button" class="b1 btn-primary m-1" data-toggle="modal" data-target="myDetail" >자세히보기</button> -->
	<button type="button" class="b1 btn-primary m-1" data-toggle="modal" onClick="showInbody()" >인바디 보기</button>
</div>
<br>
<!-- 테이블 부분 -->
<table id="tb_member" class="table table-bordered" 
       data-toggle="table"
  	   data-click-to-select="true"
       data-single-select="true"
       data-pagination="true">
	<thead>
		<tr align="center">
			<th data-checkbox=true>체크</th>
			<th data-field="RNO">번호</th>
			<th data-field="MEM_NO">회원번호</th>
			<th data-field="MEM_ID">아이디</th>
			<th data-field="MEM_NAME">이름</th>
			<th data-field="MEM_NICKNAME">닉네임</th>
			<th data-field="MEM_TEL">전화번호</th>
			<th data-field="MEM_JOINDATE">최초 등록일</th>
		</tr>
	</thead>
<!-- 					
	<tbody>
			<th>최근 인바디
				<td><button type="button" class="btn-primary m-1"  data-target="#myInbody" >최근 인바디 보기</button></td>
			</th>
	</tbody>
 -->	
</table>
<!-- 테이블 부분 -->
<!-- ======================= 자세히 보기 모달창 =================================-->
<div class="modal" id="myDetail">
	<div class="modal-dialog" style="width:auto;display:table">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header">
				<h4 class="modal-title" id="title">자세히 보기</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<!-- Modal Body 부분 -->
			<div class="modal-body">
				<%@include file="./mem_Detail.jsp" %>
			</div>
			
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal" >확인</button> 
				<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>			
			</div>
		</div>
	</div>
</div>
<!-- =======================인바디 보기 모달창 =================================-->
<div class="modal" id="myInbody">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header">
				<h4 class="modal-title">인바디 보기</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<!-- Modal Body 부분 -->
			<div class="modal-body">
				<%@include file="./mem_InbodyDetail.jsp" %>
			</div>
			
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button> 
				<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>			
			</div>
		</div>
	</div>
</div>
</div>
</form>
<!-- 자세히 보기 모달 end -->

