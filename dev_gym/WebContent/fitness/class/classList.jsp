<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<script type="text/javascript">
	var progress;
	
	function progressWork() {
		alert("진행 중인 수업을 조회합니다.");
	}

	function progressDone() {
		alert("종료된 수업을 조회합니다.");
	}
	function classSEL() {
		alert("전체 수업을 조회합니다.");
		
// 		$('#tb_cList').bootstrapTable('refreshOptions', {
// 	        url: '../class/jsonClassList.gym'
// 	  	});
		
	}
	
	$(document).ready(function() {
		 $('#tb_cList').bootstrapTable({
	         click:function(row, $element) {
	        	 alert(row); 
	         } 
	     });  
	});
	function classINS(){
			alert("수업등록 저장 완료");
			$("#f_ins").attr("method","get");
			$("#f_ins").attr("action","../class/classIns.gym");
			$("#f_ins").submit();
			$("#c_ins").modal('hide');
			
	}
	function classUPD(){
			alert("수업수정 저장 완료");
			$("#f_upd").attr("method","get");
			$("#f_upd").attr("action","classList.jsp");
			$("#f_upd").submit();
			$("#c_upd").modal('hide');
			location.href="classList.jsp";
	}
	function classDetail(){
			alert("자세히보기 닫기 완료");
			$("#c_detail").modal('hide');
			location.href="classList.jsp";
	}
	function c_btnDel(){
			alert("선택한 수업을 삭제합니다.");
	}

	//------------------------------------------ 수강생 등록 모달 안 버튼 이벤트 시작
	function classMemSearch(){
		alert("수강생을 조회합니다.");
		
	}
	function classMemINS(){
			alert("수강생을 등록합니다.");
			$("#c_memIns").modal('hide');
			$("#c_detail").modal('open');
	}
	function classMemDEL(){
			alert("수강생을 삭제합니다.");
	}
	//------------------------------------------ 수강생 등록 모달 안 버튼 이벤트 끝

	</script>

	<div class="container">
		<div style="padding: 20px;">
			<h3>
				<b>수업관리</b> / 전체 수업 관리
			</h3>
			<!-- 제목 틀 입니다. -->
			<hr>
			<div style="padding-left: 40px; padding-top: 20px">
				<!-- 내용 틀 입니다. -->
				<!--======================================================================================= 버튼 시작-->
				<div id="button">
					<button type="button" class="btn btn-primary" onClick="classSEL()">전체조회</button>
					<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">진행상황</button>
					<div class="dropdown-menu" id="p_menu">
						<a class="dropdown-item" id="p_work" href="javascript:progressWork()">진행</a> 
						<a class="dropdown-item" id="p_wait" href="javascript:progressWait()">대기</a> 
						<a class="dropdown-item" id="p_done" href="javascript:progressDone()">종료</a>
					</div>
					<button id="ins" type="button" class="btn btn-primary" data-toggle="modal" data-target="#c_ins" onclick="ins()">수업등록</button>
					<button id="upd" type="button" class="btn btn-primary" data-toggle="modal" data-target="#c_upd" onclick="upd()">수업수정</button>
					<button id="info" type="button" class="btn btn-primary" data-toggle="modal" data-target="#c_info" onclick="info()">자세히보기</button>
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#c_memList">수강생보기</button>
					<button type="button" class="btn btn-primary" onclick="c_btnDel()">삭제</button>
				</div>
		
				<div>
				<!--======================================================================================= 버튼 끝-->
					<p></p>
				</div>
		
				<!--======================================================================================= 테이블 시작-->
				<table class="table table-hover" id="tb_cList"
				 data-toggle="table"
				 data-url = "../class/jsonClassList.gym"
		  		 data-click-to-select="true"
		 		 data-pagination="true"				
				>
					<thead>
						<tr>
							<th data-checkbox=true>check</th>
							<th data-field="ROWNUM">#</th>
							<th data-field="CLS_NO">수업번호</th>
							<th data-field="CLS_NAME">수업명</th>
							<th data-field="TCH_NAME">강사명</th>
							<th data-field="TYPE_NAME">종목</th>
							<th data-field="CLS_KIND">수업구분</th>
							<th data-field="CLS_CNT">수업횟수</th>
							<th data-field="CLS_DAYS">수업일수</th>
							<th data-field="CLS_S_DATE">시작일</th>
							<th data-field="CLS_E_DATE">종료일</th>
							<th data-field="CLS_PRICE">가격</th>
							<th data-field="CLS_STATE">진행상황</th>
							<th data-field="EVT_DNAME">이벤트</th>
							<th class="d-none" data-field="EVT_SEQ">이벤트 번호</th>
						</tr>
					</thead>
					
				</table>
				<!--======================================================================================= 테이블 끝-->
			</div>
		
			<!-- 수업 등록 모달 -->
			<%@include file="classIns.jsp"%>
			<!-- 수업 수정 모달 -->
			<%@include file="classUpd.jsp"%>
			<!-- 자세히 보기 모달 -->
			<%@include file="classInfo.jsp"%>
			<!-- 수강생 보기 모달 -->
			<%@include file="classMemList.jsp"%>
			</div>
		</div>

<script type="text/javascript">
////////////////////////////////////////////////////////////////////////////////////////////////////////////// 스크립스 시작
	var list;
	var progress;
	var tb_cls_no;
	var tb_tch_no;
	var tb_tch_name;
	var evt_seq;
	
	//---------------------------------------------------------------------------------------> (조건 조회)드롭다운 버튼
	function progressWork() {
		//alert("진행 중인 수업을 조회합니다.");
		$('#tb_cList').bootstrapTable('refreshOptions', { 
			url: '../class/jsonClassList.gym?progress=진행&timestamp='+new Date().getTime()
		});		
	}
	function progressWait() {
	   //alert("대기 중인 수업을 조회합니다."); 
// 	   progress = $("#p_wait").html();
// 	   alert(progress);   
	
		$('#tb_cList').bootstrapTable('refreshOptions', { 
			url: '../class/jsonClassList.gym?progress=대기&timestamp='+new Date().getTime()
		});

	}
	function progressDone() {
		//alert("종료된 수업을 조회합니다.");
		$('#tb_cList').bootstrapTable('refreshOptions', { 
			url: '../class/jsonClassList.gym?progress=종료&timestamp='+new Date().getTime()
		});				
	}
	//---------------------------------------------------------------------------------------> 수업 조회 버튼
	function classSEL() {
		alert("전체 수업을 조회합니다.");
		$('#tb_cList').bootstrapTable('refreshOptions', {	
	           url: '../class/jsonClassList.gym'
	    });
		
// 		$("#tb_cList").on('click',function(e){
// 		    alert($('#tb_cList:checked').val() );
// 		});
		
// 		$('#tb_cList').bootstrapTable({
// 			onDblClickRow:function(row, $element, field)
// 		    { alert(JSON.stringify(row)); }
// 		});	
	}
	//------------------------------------------ 수업 등록 모달 안 저장 버튼
	function classINS(){
		alert("수업등록 저장 완료");
		$("#f_ins").attr("method","get");
		$("#f_ins").attr("action","../class/classIns.gym");
		$("#f_ins").submit();
		$("#c_ins").modal('hide');
			
	}
	//------------------------------------------ 수업 수정 모달 안 저장 버튼
	function classUPD(){
		alert("수업수정 저장 완료");
		$("#f_upd").attr("method","get");
		$("#f_upd").attr("action","../class/classUpd.gym");
		$("#f_upd").submit();
		$("#c_upd").modal('hide');
		//location.href="classUpd.jsp";
	}
	//------------------------------------------ 자세히 보기 모달 안 닫기 버튼
	function classDetail(){
		alert("자세히보기 닫기 완료");
		$("#c_detail").modal('hide');
		location.href="classList.jsp";
	}
	//---------------------------------------------------------------------------------------> 수업 삭제 버튼 
	function c_btnDel(){
		alert("선택한 수업을 삭제합니다.");
	}

	//------------------------------------------ 수강생 등록 모달 안 버튼 이벤트 시작
	function classMemSearch(){
		alert("수강생을 조회합니다.");
		
	}
	function classMemINS(){
		alert("수강생을 등록합니다.");
		$("#c_memIns").modal('hide');
		$("#c_detail").modal('open');
	}
	function classMemDEL(){
		alert("수강생을 삭제합니다.");
	}
	//------------------------------------------ 수강생 등록 모달 안 버튼 이벤트 끝
	
	//---------------------------------------------------------------------------------------> 수업 등록 버튼 
	function ins(){
		alert("ins호출");
		$.ajax({
			 url:"../class/jsonTeacherNoList.gym"
			,dataType:"json"
			,success:function(data){
				//alert(data);
				list = JSON.stringify(data);
				var result = JSON.parse(list);
				//alert(result[0].TCH_NAME);
				$("#ins_tch_name").html("");
				for(var i=0;i<result.length;i++){
					$("#ins_tch_name").append("<option value="+result[i].TCH_NO+">"+result[i].TCH_NAME+"</option>");
				}//////////for end
				
				//---------------------------------ajax1의 success 안 ajax2 시작
				$.ajax({
					 url:"../class/jsonTypeList.gym"
					,dataType:"json"
					,success:function(data){
	 					//alert(data);
						list = JSON.stringify(data);
						var result = JSON.parse(list);
						$("#ins_type_no").html("");
						for(var i=0;i<result.length;i++){
							$("#ins_type_no").append("<option value="+result[i].TYPE_NO+">"+result[i].TYPE_NAME+"</option>");
						}////for end
					}////////success end
				});//////////ajax2 end
				
			}////////////////success end
		});//////////////////ajax1 end
	}////////////////////////ins() end

	//---------------------------------------------------------------------------------------> 수업 수정 버튼
	function upd(){
		$.ajax({
			 url:"../class/jsonClassList.gym"
			,dataType:"json"
			,success:function(data){
					//alert(data);
				list = JSON.stringify(data);
				var result = JSON.parse(list);
				var cls_no = tb_cls_no-1;
				$("#upd_cls_name").val(result[cls_no].CLS_NAME);
 				$("#upd_tch_name").val(result[cls_no].TCH_NAME);
 				$("#upd_type_name").val(result[cls_no].TYPE_NAME);
				$("#upd_cls_kind").val(result[cls_no].CLS_KIND);
				$("#upd_cls_s_date").val(result[cls_no].CLS_S_DATE);
				$("#upd_cls_e_date").val(result[cls_no].CLS_E_DATE);
				$("#upd_cls_cnt").val(result[cls_no].CLS_CNT);
				$("#upd_cls_info").val(result[cls_no].CLS_INFO);
				$("#upd_cls_price").val(result[cls_no].CLS_PRICE);
				$("#upd_cls_state").val(result[cls_no].CLS_STATE);
			}
		});//////////ajax1 end	
	}
	
	//--------------------------------------------- 수업수정 모달 안 강사수정 버튼
	function upd_tchName(){
		alert("강사수정");
		$('#tb_tList').bootstrapTable('refreshOptions', {	
           url: '../teacher/jsonTchList.gym'
	    });
		$("#c_upd_tchName").modal('show');
	}
	//------------------------------ 강사수정 모달 안 선택 버튼
	function upd_tchSelecte(){
		alert("강사를 선택했습니다.");
		$("#upd_tch_name").val(tb_tch_name);
		$("#upd_tch_no").val(tb_tch_no);
		$("#c_upd_tchName").modal('hide');
	}
	//--------------------------------------------- 수업수정 모달 안 종목수정 버튼
	function upd_typeName(){
		alert("종목을 수정합니다.");
		$('#tb_typeList').bootstrapTable('refreshOptions', {	
           url: '../class/jsonTypeList.gym'
	    });
		$("#c_upd_typeName").modal('show');
	}
	//------------------------------ 종목수정 모달 안 선택 버튼
	function upd_typeSelecte(){
		alert("종목을 선택했습니다.");
		$("#upd_type_name").val(tb_type_name);
		$("#upd_type_no").val(tb_type_no);
		$("#c_upd_typeName").modal('hide');
	}

	
	//---------------------------------------------------------------------------------------> 자세히 보기 버튼
	function info(){
		
		$.ajax({
			 url:"../class/jsonClassList.gym?cls_no="+tb_cls_no
			,dataType:"json"
			,success:function(data){
					//alert(data);
				list = JSON.stringify(data);
				var result = JSON.parse(list);
				//var cls_no = tb_cls_no-1;
				
				$("#info_cls_name").val(result[0].CLS_NAME);
				$("#info_tch_name").val(result[0].TCH_NAME);
				$("#info_type_no").val(result[0].TYPE_NAME);
				$("#info_cls_kind").val(result[0].CLS_KIND);
				$("#info_cls_s_date").val(result[0].CLS_S_DATE);
				$("#info_cls_e_date").val(result[0].CLS_E_DATE);
				$("#info_cls_cnt").val(result[0].CLS_CNT);
				$("#info_cls_info").val(result[0].CLS_INFO);
				$("#info_cls_price").val(result[0].CLS_PRICE);
				$("#info_cls_grcode").val(result[0].CLS_GRCODE);
				$("#info_cls_state").val(result[0].CLS_STATE);
				//여기서부터 이벤트		
				$("#info_cls_evt_name").val(result[0].EVT_NAME);
				$("#info_cls_evt_sDate").val(result[0].EVT_S_DATE);
				$("#info_cls_evt_eDate").val(result[0].EVT_E_DATE);
				$("#info_cls_evt_cont").val(result[0].EVT_CONT);
				$("#info_cls_evt_cond").val(result[0].EVT_COND);
				
				$("#info_cls_sTime").val(result[0].CLS_STIME);
				$("#info_cls_eTime").val(result[0].CLS_ETIME);
				$("#info_cls_day").val(result[0].CLS_DAY);

			}////////success end
		});//////////ajax end	
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////선택된 로우에서 값 가져오기
	
	//--------------------------------------------- 수업 리스트에서 수업번호 가져오기
	$('#tb_cList').on('click-row.bs.table', function (row, $element, field) {
		tb_cls_no = $element.CLS_NO;
		alert("수업번호: "+tb_cls_no);
		//$("#c_info").modal('show');
	})
	//--------------------------------------------- 강사 리스트에서 선택 값 가져오기
	$('#tb_tList').on('click-row.bs.table', function (row, $element, field) {
		tb_tch_no = $element.TCH_NO;
		tb_tch_name = $element.TCH_NAME;
		alert("강사번호: "+tb_tch_no);
	})
	//--------------------------------------------- 종목 리스트에서 선택 값 가져오기
	$('#tb_typeList').on('click-row.bs.table', function (row, $element, field) {
		tb_type_no = $element.TYPE_NO;
		tb_type_name = $element.TYPE_NAME;
		alert("종목번호: "+tb_type_no);
	})
	
	//--------------------------------------------- 수업 등록에서 시작 시간 형식
	var sTime = new TimePicker('ins_cls_sTime', {
	  lang: 'en',
	  theme: 'dark'
	});
	sTime.on('change', function(evt) {
	  
	  var value = (evt.hour || '00') + ':' + (evt.minute || '00');
	  evt.element.value = value;
	
	});	
	
	//--------------------------------------------- 수업 등록에서 종료 시간 형식
// 	var eTime = new TimePicker('ins_cls_eTime', {
// 	  lang: 'en',
// 	  theme: 'dark'
// 	});
// 	eTime.on('change', function(evt) {
	  
// 	  var value = (evt.hour || '00') + ':' + (evt.minute || '00');
// 	  evt.element.value = value;
	
// 	});		
	
	//--------------------------------------------- 수업 등록에서 체크박스 선택한 값 아래 input박스에 넣기
	$(document).ready(function(){
	    $("#ins_cls_day1").change(function(){
	        if($("#ins_cls_day1").is(":checked")){
	        	var value = $(this).val();
// 	        	var value = $('input:checkbox[id="ins_cls_day1"]').val();
	        	$("#ins_cls_day").val(value);
// 	        	$("#ins_type_no").append("<option value="+result[i].TYPE_NO+">"+result[i].TYPE_NAME+"</option>");
//	        	$("#ins_cls_day").append("<option value=value>월</option>");
	        	
	        }else{
	        	$("#ins_cls_day").val("");
	        }
	    });//제이쿼리 end
	    $("#ins_cls_day2").change(function(){
	        if($("#ins_cls_day2").is(":checked")){
	        	var value = $(this).val();
// 	        	var value = $('input:checkbox[id="ins_cls_day1"]').val();
//	        	$("#ins_cls_day").val(value);
// 	        	$("#ins_type_no").append("<option value="+result[i].TYPE_NO+">"+result[i].TYPE_NAME+"</option>");
	        	$("#ins_cls_day").append("<option value=value>화</option>");
	        	
	        }else{
	        	$("#ins_cls_day").val("");
	        }
	    });//제이쿼리 end	    
	    
	
	
	});//document end
	
	
// 	$("input[name=ins_cls_day1]:checked").each(function() {
// 		var test = $(this).val(); 
// 		alert("벨류값확인 : " + test);
// 	}
	
</script>