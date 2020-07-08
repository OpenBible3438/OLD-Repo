<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--  
<script src="https://cdn.jsdelivr.net/timepicker.js/latest/timepicker.min.js"></script>
<link href="https://cdn.jsdelivr.net/timepicker.js/latest/timepicker.min.css" rel="stylesheet"/>
-->
<script src="../../js/jquery.timepicker.min.js"></script> 
<link rel="stylesheet" href="../../css/jquery.timepicker.css">
<script src="../../js/bootstrap-datetimepicker.min.js"></script> 
<link rel="stylesheet" href="../../css/bootstrap-datetimepicker.min.css">




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
				<div id="button" style="width:100%">
					<button type="button" class="btn btn-primary" onClick="classSEL()">전체조회</button>
					<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">진행상황</button>
					<div class="dropdown-menu" id="p_menu">
						<a class="dropdown-item" id="p_work" href="javascript:progressWork()">진행</a> 
						<a class="dropdown-item" id="p_wait" href="javascript:progressWait()">대기</a> 
						<a class="dropdown-item" id="p_done" href="javascript:progressDone()">종료</a>
					</div>
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#c_ins" onclick="ins()">수업등록</button>
					<button type="button" class="btn btn-primary" onclick="upd()">수업수정</button>
					<button type="button" class="btn btn-primary" onclick="info()">자세히보기</button>
					<button type="button" class="btn btn-primary" onclick="cls_mem()">수강생보기</button>
					<button type="button" class="btn btn-primary" data-toggle="modal" onclick="cls_del()">수업삭제</button>
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
		 		 data-single-select="true"			
				>
					<thead>
						<tr>
							<th data-checkbox=true>check</th>
							<!--  
							<th data-field="ROWNUM">#</th>
							-->
							<th data-field="CLS_NO">수업번호</th>
							<th data-field="CLS_NAME">수업명</th>
							<th data-field="TCH_NAME">강사명</th>
							<th class="d-none" data-field="TCH_NO">강사번호</th>
							<th data-field="TYPE_NAME">종목</th>
							<th class="d-none" data-field="TYPE_NO">종목번호</th>
							<th data-field="CLS_KIND">수업구분</th>
							<th class="d-none" data-field="CLS_CNT">수업횟수</th>
							<th class="d-none" data-field="CLS_DAYS">수업일수</th>
							<th class="d-none" data-field="CLS_DAY">요일</th>
							<th class="d-none" data-field="CLS_S_DATE">시작일</th>
							<th class="d-none" data-field="CLS_E_DATE">종료일</th>
							<th class="d-none" data-field="CLS_INFO">수업소개</th>
							<th data-field="CLS_PRICE">가격</th>
							<th data-field="CLS_STATE">진행상황</th>
							<th class="d-none" data-field="CLS_LIKE">좋아요</th>
							<th class="d-none" data-field="CLS_STIME">시작시간</th>
							<th class="d-none" data-field="CLS_ETIME">종료시간</th>
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
            //$('#timepicker1').timepicker();
        </script>


<script type="text/javascript">
////////////////////////////////////////////////////////////////////////////////////////////////////////////// 스크립스 시작
	var list;
	var progress;
	var tb_cls_no;
	var tb_cls_name;
	var tb_tch_no;
	var tb_tch_name;
	var tb_pay_no;
	var evt_seq;
	var ins_checked_val = [];
	var upd_checked_val = [];
	var ins_cls_sTime;
	var ins_cls_eTime;
	var payTime;
	var table_cList;
	var checkRow = 0;	//수업리스트 테이블 
	var mem_checkRow = 0;	//수강생리스트 테이블
	
	
	

	//------------------------------------------ 수업 수정 모달 안 저장 버튼
	function classUPD(){
		//alert("수업수정 저장 완료");
		$("#c_upd").modal('hide');
		$("#f_upd").attr("method","get");
		$("#f_upd").attr("action","../class/classUpd.gym");
		$("#f_upd").submit();
	}	
	
	//------------------------------------------------------------------------------------------> 수업 조회 버튼
	function classSEL() {
		//alert("전체 수업을 조회합니다.");
		$('#tb_cList').bootstrapTable('refreshOptions', {	
	           url: '../class/jsonClassList.gym'
	    });
	}
	//------------------------------------------------------------------------------------------> (조건 조회)드롭다운 버튼
	function progressWork() {
		$('#tb_cList').bootstrapTable('refreshOptions', { 
			url: '../class/jsonClassList.gym?progress=진행&timestamp='+new Date().getTime()
		});		
	}
	function progressWait() {  
		$('#tb_cList').bootstrapTable('refreshOptions', { 
			url: '../class/jsonClassList.gym?progress=대기&timestamp='+new Date().getTime()
		});

	}
	function progressDone() {
		$('#tb_cList').bootstrapTable('refreshOptions', { 
			url: '../class/jsonClassList.gym?progress=종료&timestamp='+new Date().getTime()
		});				
	}
	
	//------------------------------------------------------------------------------------------> 수업 등록 버튼 
	function ins(){
		//alert("ins호출");
		//alert(check_val);
		
		//----------------------------------input box 비우기
		$("#ins_cls_name").val("");			
		$("#ins_tch_name").val("");			
		$("#ins_type_no").val("");			
		//$("#ins_cls_kind").val("");			
		$("#ins_cls_s_date").val("");			
		$("#ins_cls_e_date").val("");			
		$("#ins_cls_sTime").val("");			
		$("#ins_cls_eTime").val("");			
		$("#ins_cls_day").val("");			
		$("#ins_cls_cnt").val("");			
		$("#ins_cls_info").val("");			
		$("#ins_cls_price").val("");			
		//$("#ins_cls_state").val("");

		//해당화면에 모든 checkbox들의 체크를해제시킨다.
		$("input[type=checkbox]").prop("checked",false);
		
		//-----------------------------------시간 객체
		$("#ins_check_sTime").timepicker({
			step: 10,            //시간간격 : 5분
			timeFormat: "H:i:s"  //시간:분 으로표시
		});	 			
		$("#ins_check_eTime").timepicker({
			step: 10,            //시간간격 : 5분
			timeFormat: "H:i:s"  //시간:분 으로표시
		});	 	
	 		
		//---------------------------------ajax1 시작
		$.ajax({
			 method:'get'
			,url:"../class/jsonComboList.gym"
			,dataType:"json"
			,success:function(data){
				//alert(data);
				list = JSON.stringify(data);
				var result = JSON.parse(list);
				//alert(result[0].TCH_NAME);
				$("#ins_tch_name").html("");
				$("#ins_type_no").html("");
				for(var i=0;i<result.length;i++){
					if(result[i].TYPE == "tch") {
						$("#ins_tch_name").append("<option value="+result[i].TYPECODE+">"+result[i].TYPENAME+"</option>");
					} 
					else if(result[i].TYPE == "typ") {
						$("#ins_type_no").append("<option value="+result[i].TYPECODE+">"+result[i].TYPENAME+"</option>");
					}
				}//////////for end
			}////////////////success end
		});//////////////////ajax1 end
	}////////////////////////ins() end
	
	//------------------------------------------ 수업 등록 모달 안 요일 선택완료 버튼
	function ins_checkDay(){
		var days ="";
		for(var i=0; i<ins_checked_val.length; i++){
			if(ins_checked_val[i] != null) {
				days += ins_checked_val[i];
				days += " ";
			}
		}
		//alert(days);
		days = days.trim();
		days = days.replace(/ /gi,"/");
		$("#ins_cls_day").val(days);
	}

	
	
	//------------------------------------------ 수업 등록 모달 안 시작시간 등록 버튼
	function ins_sTime(){
		//alert("시작시간 설정 모달 오픈");
 		$("#int_sTime").modal('show');		
	}
	//------------------------------------------ 수업 등록 모달 안 시작시간 등록 모달 안 완료 버튼
	function int_sTimeCheck(){
		//alert("시작시간 선택 완료");
		$("#int_sTime").modal('hide');
		ins_cls_sTime = $("#ins_check_sTime").val();
		$("#ins_cls_sTime").val(ins_cls_sTime);
	}
	//------------------------------------------ 수업 등록 모달 안 종료시간 등록 버튼
	function ins_eTime(){
		//alert("종료시간 설정 모달 오픈");		
 		$("#int_eTime").modal('show');		
	}
	//------------------------------------------ 수업 등록 모달 안 종료시간 등록 모달 안 완료 버튼
	function int_eTimeCheck(){
		//alert("종료시간 선택 완료");
		$("#int_eTime").modal('hide');
		ins_cls_eTime = $("#ins_check_eTime").val();
		$("#ins_cls_eTime").val(ins_cls_eTime);
	}
	
	//------------------------------------------ 수업 등록 모달 안 저장 버튼
	function classINS(){
		//alert("수업등록 저장 완료");
		var cls_name = $("#ins_cls_name").val()
		
// 		alert(
// 				  $("#ins_cls_name").val()
// 				+", "+ $("#ins_tch_name").val()
// 				+", "+ $("#ins_type_no").val()	
// 				+", "+ $("#ins_cls_kind").val()		
// 				+", "+ $("#ins_cls_s_date").val()		
// 				+", "+ $("#ins_cls_e_date").val()		
// 				+", "+ $("#ins_cls_sTime").val()		
// 				+", "+ $("#ins_cls_eTime").val()			
// 				+", "+ $("#ins_cls_day").val()			
// 				+", "+ $("#ins_cls_cnt").val()			
// 				+", "+ $("#ins_cls_info").val()		
// 				+", "+ $("#ins_cls_price").val()		
// 				+", "+ $("#ins_cls_state").val()
// 			);

		if(cls_name != ""){
			$("#c_ins").modal('hide');
	 		$("#f_ins").attr("method","get");
	 		$("#f_ins").attr("action","../class/classIns.gym");
	 		$("#f_ins").submit();
		}else{
			alert("수업명을 입력하세요.")
		}
	}	
	
	//------------------------------------------------------------------------------------------> 수업 수정 버튼
	function upd(){
			//----------------------------------input box 비우기
			$("#upd_cls_name").val(null);			
			$("#upd_tch_no").val(null);			
			$("#upd_type_no").val(null);			
			$("#upd_cls_kind").val(null);			
			$("#upd_cls_s_date").val(null);			
			$("#upd_cls_e_date").val(null);			
			$("#upd_cls_sTime").val(null);			
			$("#upd_cls_eTime").val(null);			
			$("#upd_cls_day").val(null);			
			$("#upd_cls_cnt").val(null);			
			$("#upd_cls_info").val(null);			
			$("#upd_cls_price").val(null);			
			$("#upd_cls_state").val(null);	
			
		if(checkRow != 0){
			//-----------------------------------시간 객체
			$("#upd_check_sTime").timepicker({
				step: 10,            //시간간격 : 5분
				timeFormat: "H:i:s"  //시간:분 으로표시
			});	 			
			$("#upd_check_eTime").timepicker({
				step: 10,            //시간간격 : 5분
				timeFormat: "H:i:s"  //시간:분 으로표시
			});	 		
			
	
			//해당화면에 모든 checkbox들의 체크를해제시킨다.
			$("input[type=checkbox]").prop("checked",false);
			
			//----------------------------------input box 채우기
			$("#upd_cls_name").val(table_cList.CLS_NAME);
			$("#upd_tch_name").val(table_cList.TCH_NAME);
			$("#upd_tch_no").val(table_cList.TCH_NO);
			$("#upd_type_name").val(table_cList.TYPE_NAME);
			$("#upd_type_no").val(table_cList.TYPE_NO);
			$("#upd_cls_kind").val(table_cList.CLS_KIND);
			$("#upd_cls_s_date").val(table_cList.CLS_S_DATE);
			$("#upd_cls_e_date").val(table_cList.CLS_E_DATE);
			$("#upd_cls_days").val(table_cList.CLS_DAYS);
			$("#upd_cls_sTime").val(table_cList.CLS_STIME);
			$("#upd_cls_eTime").val(table_cList.CLS_ETIME);
			$("#upd_cls_day").val(table_cList.CLS_DAY);
			$("#upd_cls_cnt").val(table_cList.CLS_CNT);
			$("#upd_cls_info").val(table_cList.CLS_INFO);
			$("#upd_cls_price").val(table_cList.CLS_PRICE);
			$("#upd_cls_state").val(table_cList.CLS_STATE);		
			
			$("#c_upd").modal('show');
		}else{
			alert("수업을 선택하세요.");
		}
	}
	
	//--------------------------------------------- 수업수정 모달 안 강사수정 버튼
	function upd_tchName(){
		//alert("강사를 수정합니다.");
		$('#tb_tList').bootstrapTable('refreshOptions', {	
           url: '../teacher/jsonTchList.gym'
	    });
		$("#c_upd_tchName").modal('show');
	}
	//------------------------------ 강사수정 모달 안 선택 버튼
	function upd_tchSelecte(){
		//alert("강사를 선택했습니다.");
		$("#upd_tch_name").val(tb_tch_name);
		$("#upd_tch_no").val(tb_tch_no);
		$("#c_upd_tchName").modal('hide');
	}
	//--------------------------------------------- 수업수정 모달 안 종목수정 버튼
	function upd_typeName(){
		//alert("종목을 수정합니다.");
		$('#tb_typeList').bootstrapTable('refreshOptions', {	
           url: '../class/jsonTypeList.gym'
	    });
		$("#c_upd_typeName").modal('show');
	}
	//------------------------------ 종목수정 모달 안 선택 버튼
	function upd_typeSelecte(){
		//alert("종목을 선택했습니다.");
		$("#upd_type_name").val(tb_type_name);
		$("#upd_type_no").val(tb_type_no);
		$("#c_upd_typeName").modal('hide');
	}
	//------------------------------------------ 수업 수정 모달 안 요일 선택완료 버튼
	function upd_checkDay(){
		var days ="";
		for(var i=0; i<upd_checked_val.length; i++){
			if(upd_checked_val[i] != null) {
				days += upd_checked_val[i];
				days += " ";
			}
		}
		//alert(days);
		days = days.trim();
		days = days.replace(/ /gi,"/");
		$("#upd_cls_day").val(days);
	}
	
	//------------------------------------------------------------------------------------------> 자세히 보기 버튼
	function info(){
		if(checkRow != 0){
			$("#info_cls_name").val(table_cList.CLS_NAME);
			$("#info_tch_name").val(table_cList.TCH_NAME);
			$("#info_type_no").val(table_cList.TYPE_NAME);
			$("#info_cls_kind").val(table_cList.CLS_KIND);
			$("#info_cls_s_date").val(table_cList.CLS_S_DATE);
			$("#info_cls_e_date").val(table_cList.CLS_E_DATE);
			$("#info_cls_cnt").val(table_cList.CLS_CNT);
			$("#info_cls_days").val(table_cList.CLS_DAYS);
			$("#info_cls_info").val(table_cList.CLS_INFO);
			$("#info_cls_price").val(table_cList.CLS_PRICE);
			$("#info_cls_state").val(table_cList.CLS_STATE);		
			$("#info_cls_sTime").val(table_cList.CLS_STIME);
			$("#info_cls_eTime").val(table_cList.CLS_ETIME);
			$("#info_cls_day").val(table_cList.CLS_DAY);
			
			$("#c_info").modal('show');
		}else{
			alert("수업을 선택하세요.");
		}	
	}
	
	//------------------------------------------ 수업 수정 모달 안 시작시간 등록 버튼
	function upd_sTime(){
		//alert("시작시간 설정 모달 오픈");
 		$("#upd_sTime").modal('show');		
	}
	//------------------------------------------ 수업 수정 모달 안 시작시간 등록 모달 안 완료 버튼
	function upd_sTimeCheck(){
		//alert("시작시간 선택 완료");
		$("#upd_sTime").modal('hide');
		var upd_cls_sTime = $("#upd_check_sTime").val();
		$("#upd_cls_sTime").val(upd_cls_sTime);
	}
	//------------------------------------------ 수업 수정 모달 안 종료시간 등록 버튼
	function upd_eTime(){
		//alert("종료시간 설정 모달 오픈");		
 		$("#upd_eTime").modal('show');		
	}
	//------------------------------------------ 수업 수정 모달 안 종료시간 등록 모달 안 완료 버튼
	function upd_eTimeCheck(){
		//alert("종료시간 선택 완료");
		$("#upd_eTime").modal('hide');
		var upd_cls_eTime = $("#upd_check_eTime").val();
		$("#upd_cls_eTime").val(upd_cls_eTime);
	}	
	
	
	//------------------------------------------------------------------------------------------> 수강생 보기 버튼
	function cls_mem(){
		//alert("수강생 보기");
		
		if(checkRow != 0){
			$('#tb_mList').bootstrapTable('refreshOptions', {	
		           url: '../class/jsonClassMemList.gym?cls_no='+tb_cls_no
			});
			$("#c_memList").modal('show');			
			$("#c_check_pTime").timepicker({
				step: 10,            //시간간격 : 5분
				timeFormat: "H:i:s"  //시간:분 으로표시
			});
		}else{
			alert("수업을 선택하세요.");
		}
		
	}
	//------------------------------------------ 수강생 보기 모달 안 수강생 등록 버튼
	function classMemINS_open(){
		//alert("수강생 등록 모달을 엽니다..");
		$("#c_mem_number").val(null);
		$("#c_mem_no").val(null);
		$("#c_mem_name").val(null);
		$("#c_mem_birth").val(null);				
		$("#c_mem_tel").val(null);
		$("#c_mem_gender").val(null);				
		$("#c_mem_joindate").val(null);				
	}
	//------------------- 수강생 등록 모달 안 회원 조회 버튼
	function classMemSearch(){
		//alert("수강생을 조회합니다.");
 		var c_mem_number = $("#c_mem_number").val();
// 		$("#c_mem_no").val(c_mem_number);	
		//alert(c_mem_number);
		
		$.ajax({
			 url:"../class/jsonPayMemList.gym?mem_no="+c_mem_number
			,dataType:"json"
			,success:function(data){
				//alert(data);
				var buf = JSON.stringify(data);
				var result = JSON.parse(buf);
				//alert(result[0].MEM_NAME);
				
				//$("#ins_tch_name").html("");
				$("#c_mem_no").val(result[0].MEM_NO);				
				$("#c_mem_name").val(result[0].MEM_NAME);				
				$("#c_mem_birth").val(result[0].MEM_BIRTH);				
				$("#c_mem_tel").val(result[0].MEM_TEL);				
				$("#c_mem_gender").val(result[0].MEM_GENDER);				
				$("#c_mem_joindate").val(result[0].MEM_JOINDATE);				
				
			}////////success end
		});//////////ajax end
				
	}
	//------------------- 수강생 등록 모달 안 등록 버튼
	function classMemINS_close(){
		//alert("수강생을 등록합니다.");
		$("#c_memIns").modal('hide');
		$("#m_ins").attr("method","get");
		$("#m_ins").attr("action","../class/classMemIns.gym");
		$("#m_ins").submit();		
	}
	//------------------------------------------ 수강생 보기 모달 안 수강생 삭제 버튼
	function classMemDEL(){
		//alert("수강생을 삭제합니다.");
		//alert("PAY_NO: "+tb_pay_no);
		if(mem_checkRow != 0){
			location.href="../class/classMemUpd.gym?cud=upd&pay_no="+tb_pay_no;		
		}else{
			alert("수강생을 선택하세요.");
		}
	}	
	
	//------------------------------------------------------------------------------------------> 수강생 삭제 버튼	
	function cls_del(){
		if(checkRow != 0){
			location.href="../class/classDel.gym?cud=del&cls_no="+tb_cls_no;	
		}else{
			alert("수업을 선택하세요.");
		}
	}	
	
	/////////////////////////////////////////////////////////////////////////////////////////////선택된 로우에서 값 가져오기
	
	//--------------------------------------------- 수업 리스트에서 수업번호 가져오기
	$('#tb_cList').on('click-row.bs.table', function (row, $element, field) {
		checkRow = 1;
		table_cList = $element
		tb_cls_no = $element.CLS_NO;
		tb_cls_name = $element.CLS_NAME;
		$("#m_className").text(tb_cls_name);
		$("#ins_cls_cls_no").val(tb_cls_no);
		$("#upd_cls_cls_no").val(tb_cls_no);
		$("#ins_mem_cls_no").val(tb_cls_no);
		//alert("수업번호: "+tb_cls_no);
		//alert("수업명: "+tb_cls_name);
		//$("#c_info").modal('show');
	})
	$('#tb_cList').on('uncheck.bs.table', function (row, $element) {	
		checkRow = 0;
		//alert("로우 체크 해제");
	})
	
	//--------------------------------------------- 강사 리스트에서 선택 값 가져오기
	$('#tb_tList').on('click-row.bs.table', function (row, $element, field) {
		tb_tch_no = $element.TCH_NO;
		tb_tch_name = $element.TCH_NAME;
		//alert("강사번호: "+tb_tch_no);
	})
	//--------------------------------------------- 종목 리스트에서 선택 값 가져오기
	$('#tb_typeList').on('click-row.bs.table', function (row, $element, field) {
		tb_type_no = $element.TYPE_NO;
		tb_type_name = $element.TYPE_NAME;
		//alert("종목번호: "+tb_type_no);
	})
	//--------------------------------------------- 수강생 리스트에서 선택 값 가져오기
	$('#tb_mList').on('click-row.bs.table', function (row, $element, field) {
		mem_checkRow = 1;
		tb_pay_no = $element.PAY_NO;
		//alert("PAY_NO: "+tb_pay_no);
	})
	$('#tb_mList').on('uncheck.bs.table', function (row, $element) {	
		mem_checkRow = 0;
		//alert("로우 체크 해제");
	})
		
	
	/////////////////////////////////////////////////////////////////////////////////////////////////dom구성이 완료됐을 때
	$(document).ready(function(){
		
		//--------------------------------------------- 수업 등록에서 요일 체크박스 선택한 값을 아래 input박스에 넣기
	    $("#ins_cls_day1").change(function(){
	        if($("#ins_cls_day1").is(":checked")){
	        	ins_checked_val[0] = $(this).val();
	        } else {
	        	ins_checked_val[0] = null;
	        }
	    });//제이쿼리 end
	    $("#ins_cls_day2").change(function(){
	        if($("#ins_cls_day2").is(":checked")){
	        	ins_checked_val[1] = $(this).val();
	        } else {
	        	ins_checked_val[1] = null;
	        }
	    });//제이쿼리 end
	    $("#ins_cls_day3").change(function(){
	        if($("#ins_cls_day3").is(":checked")){
	        	ins_checked_val[2] = $(this).val();
	        } else {
	        	ins_checked_val[2] = null;
	        }
	    });//제이쿼리 end
	    $("#ins_cls_day4").change(function(){
	        if($("#ins_cls_day4").is(":checked")){
	        	ins_checked_val[3] = $(this).val();
	        } else {
	        	ins_checked_val[3] = null;
	        }
	    });//제이쿼리 end
	    $("#ins_cls_day5").change(function(){
	        if($("#ins_cls_day5").is(":checked")){
	        	ins_checked_val[4] = $(this).val();
	        } else {
	        	ins_checked_val[4] = null;
	        }
	    });//제이쿼리 end
	    $("#ins_cls_day6").change(function(){
	        if($("#ins_cls_day6").is(":checked")){
	        	ins_checked_val[5] = $(this).val();
	        } else {
	        	ins_checked_val[5] = null;
	        }
	    });//제이쿼리 end
	    $("#ins_cls_day7").change(function(){
	        if($("#ins_cls_day7").is(":checked")){
	        	ins_checked_val[6] = $(this).val();
	        } else {
	        	ins_checked_val[6] = null;
	        }
	    });//제이쿼리 end
	    
		//--------------------------------------------- 수업 수정에서 요일 체크박스 선택한 값을 아래 input박스에 넣기
	    $("#upd_cls_day1").change(function(){
	        if($("#upd_cls_day1").is(":checked")){
	        	upd_checked_val[0] = $(this).val();
	        } else {
	        	upd_checked_val[0] = null;
	        }
	    });//제이쿼리 end
	    $("#upd_cls_day2").change(function(){
	        if($("#upd_cls_day2").is(":checked")){
	        	upd_checked_val[1] = $(this).val();
	        } else {
	        	upd_checked_val[1] = null;
	        }
	    });//제이쿼리 end
	    $("#upd_cls_day3").change(function(){
	        if($("#upd_cls_day3").is(":checked")){
	        	upd_checked_val[2] = $(this).val();
	        } else {
	        	upd_checked_val[2] = null;
	        }
	    });//제이쿼리 end
	    $("#upd_cls_day4").change(function(){
	        if($("#upd_cls_day4").is(":checked")){
	        	upd_checked_val[3] = $(this).val();
	        } else {
	        	upd_checked_val[3] = null;
	        }
	    });//제이쿼리 end
	    $("#upd_cls_day5").change(function(){
	        if($("#upd_cls_day5").is(":checked")){
	        	upd_checked_val[4] = $(this).val();
	        } else {
	        	upd_checked_val[4] = null;
	        }
	    });//제이쿼리 end
	    $("#upd_cls_day6").change(function(){
	        if($("#upd_cls_day6").is(":checked")){
	        	upd_checked_val[5] = $(this).val();
	        } else {
	        	upd_checked_val[5] = null;
	        }
	    });//제이쿼리 end
	    $("#upd_cls_day7").change(function(){
	        if($("#upd_cls_day7").is(":checked")){
	        	upd_checked_val[6] = $(this).val();
	        } else {
	        	upd_checked_val[6] = null;
	        }
	    });//제이쿼리 end
	});//document end

</script>