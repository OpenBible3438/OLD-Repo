<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String mode = request.getParameter("mode");
	if(mode!=null && mode.equals("refresh")){
		%>
		noticeList();
		<%
	}
%>
<%-- <%
	String gym_no = null;
	if(session.getAttribute("gym_no") != null){
		gym_no = session.getAttribute("gym_no").toString();
	}
	else {
		gym_no = "1";
	}
%> --%>
<!-- 등록,수정 모달 include -->
<%@include file="gymNoticeIns_Upd.jsp"%>
<%@include file="gymNoticeDetail.jsp"%>
<script src="../../js/kakao.js"></script>
<style>
.active {
  color: red;
  font-weight: bold;
}

</style>
<script>
        // SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해 주세요.
        Kakao.init('1225a581b4fb1a6098c442808c7cef60');

        // SDK 초기화 여부를 판단합니다.
        console.log(Kakao.isInitialized());
 </script>
<script type="text/javascript">
	var choNotice_no = 0; //선택한 공지사항을 저장 
	var choNot_title = "";
	var choNot_cont = "";
	   // 선택된 갯수
   var selected = 0;
	
	function noticeList(){
		$("#search_title").val("");
		$("#search_cont").val("");
		$('#tb_nList').bootstrapTable('refreshOptions', {	//이 코드가 있어야 테이블 안의 데이터가 갱신된다.
	           url: '../gym/jsonGymNoticeList.gym'
	        });
	}
	function showDetail(){
		if(selected == 0){
			alert("조회 할 공지사항을 선택하세요.");
		}
		else if(selected == 1){
			$("#m_detail").modal({
				show : true
			  , focus : true
			})
			$.ajax({
				url : "../gym/jsonGymNoticeList.gym?notice_no="+choNotice_no
			  , success : function(data){
				  var dtlList = JSON.parse(JSON.stringify(data));
				  $("#not_title_dtl").text(dtlList[0].NOT_TITLE);
				  $("#not_cont_dtl").text(dtlList[0].NOT_CONT);
				  $("#not_date").text(dtlList[0].NOT_DATE);
				  $("#not_time").text(dtlList[0].NOT_TIME);
			  }
			});
		}
		else if(selected > 1){
			alert("공지사항 조회는 1건씩만 가능합니다.");
			$('input:checkbox[name=btSelectItem]').prop('checked', false);
			selected = 0;
		}
		
	}
	function notSearch(){
		var searchNot = $("#searchNot").val();
		//alert("not_title : " + not_title + ", not_cont : " + not_cont);
		$('#tb_nList').bootstrapTable('refreshOptions', {
	    	url: '../gym/jsonGymNoticeList.gym?msg='+searchNot
	    });
	}
	function startIns(){
		$("#m_title").text("공지사항 등록");
		$("#cud").val("ins");
		$("#not_title").text("");
		$("#not_cont").text("");
		$("#m_ins_upd").modal({
			show : true
		  , focus : true
		})
	}
	function startUpd(){
		if(selected == 0){
			alert("수정할 공지사항을 선택하세요.");
		}
		else if(selected == 1){
			$("#m_title").text("공지사항 수정");
			$("#cud").val("upd");
			$("#not_title").text(choNot_title);
			$("#notice_no").val(choNotice_no);
			$("#not_cont").text(choNot_cont);
			$("#m_ins_upd").modal({
				show : true
			  , focus : true
			})
		}
		else if(selected > 1){
			alert("공지사항 수정은 1건씩만 가능합니다.");
			$('input:checkbox[name=btSelectItem]').prop('checked', false);
			selected = 0;
		}
	}
	function startDel(){
		if(selected == 0){
			alert("삭제할 공지사항을 선택하세요.");
		}
		else if(selected == 1){
			$("#m_del").modal({
				show : true
			});
		}
		else if(selected > 1){
			alert("공지사항 삭제는 1건씩만 가능합니다.");
			$('input:checkbox[name=btSelectItem]').prop('checked', false);
			selected = 0;
		}
	}
	function noticeDel(){
			location.href = "gymNoticeDel.gym?cud=del&notice_no=" + choNotice_no;
	}
	function noticeSave(){
		//등록창과 수정창이 같다...
		//not_title//not_cont
		var title = $('#not_title').val().trim();
		var not_cont = $('#not_cont').val().trim();
		if(title != "") {
			if(not_cont != "") {
				$("#m_ins_upd").modal({
					show : false
				});
				if($("#cud").val()=="ins"){
					$("#f_ins_upd").attr('action', "../gym/gymNoticeIns.gym")
					$("#f_ins_upd").submit();
				}
				else if($("#cud").val()=="upd"){
					$("#f_ins_upd").attr('action', "../gym/gymNoticeUpd.gym")
					$("#f_ins_upd").submit();
				}
			} else {
				alert("내용을 입력하세요 ");	
			}
		} else {
			alert("제목을 입력하세요 ");
		}
	}
	 function sendLink() {
		    Kakao.Link.sendDefault({
		      objectType: 'feed',
		      content: {
		        title: $("#not_title_dtl").text(),
		        description: $("#not_cont_dtl").text(),
		        imageUrl:
		          'http://k.kakaocdn.net/dn/Q2iNx/btqgeRgV54P/VLdBs9cvyn8BJXB3o7N8UK/kakaolink40_original.png',
		        link: {
		          mobileWebUrl: 'https://developers.kakao.com',
		          webUrl: 'https://developers.kakao.com',
		        },
		      },
		      social: {
		        likeCount: 286,
		        commentCount: 45,
		        sharedCount: 845,
		      },
		      buttons: [
		        {
		          title: '웹으로 보기',
		          link: {
		            mobileWebUrl: 'http://192.168.0.191:7777/dev_gym/index.jsp',
		            webUrl: 'http://192.168.0.191:7777/dev_gym/index.jsp',
		          },
		        },
		        {
		          title: '앱으로 보기',
		          link: {
		            mobileWebUrl: 'https://developers.kakao.com',
		            webUrl: 'http://192.168.0.191:7777',
		          },
		        },
		      ],
		    })
		  }
</script>
</head>
<!-- ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<body>
<!--=========================== 전체 시작 ===========================-->
<div style="padding: 20px;">
   <h3><b>매장관리</b> / 공지사항</h3>   <!-- 제목 틀 입니다. -->
   <hr>
    <!--=========================== 내용 시작 ===========================-->
	<div style="padding-left: 40px; padding-top: 20px">
		<!--=========================== 검색부분 시작 ===========================-->
		<div class="input-group mb-3">
			<div class="input-group-prepend">
		    	<span class="input-group-text">🔍</span>
		    </div>
		    <div class="col-xs-4">
		    	<input id="searchNot" type="text" class="form-control" placeholder="제목  or 날짜 ">
			</div>&nbsp;
			<button type="button" class="btn btn-secondary" onClick="notSearch()">검색</button>  
		</div>
		<!--=========================== 검색부분 끝 ===========================-->
		<!--=========================== 버튼부분 시작 =========================== -->
		<button type="button" class="btn btn-primary" onClick="noticeList()">전체조회</button>
		<button type="button" class="btn btn-primary" data-toggle="modal" onClick="showDetail()">상세조회</button>
		<button type="button" class="btn btn-primary" data-toggle="modal" onClick="startIns()">등록</button>
		<button type="button" class="btn btn-primary" data-toggle="modal" onClick="startUpd()">수정</button>
		<button type="button" class="btn btn-primary" data-toggle="modal" onClick="startDel()">삭제</button>
		<!--=========================== 버튼부분 끝 =========================== -->
		<p></p>
			<!--=========================== 테이블 부분 시작 ===========================-->
		<table id="tb_nList" class="table table-bordered"
				 data-toggle="table"
				 data-url= '../gym/jsonGymNoticeList.gym'
		  		 data-click-to-select="true"
		  		 data-single-select="true"
		 		 data-pagination="true"
				>
			<thead>
				<tr>
					<th data-checkbox=true>체크</th>
					<th data-field="NOTICE_NO">번호</th>
					<th data-field="NOT_DATE">등록일</th>
					<th data-field="NOT_TITLE" class="w-25">제목</th>
					<th data-field="NOT_CONT" class="w-50">내용</th>
				</tr>
			</thead>
		</table>
		<!--=========================== 테이블 부분 끝 ===========================-->
	</div>
    <!--=========================== 내용 끝 ===========================-->
</div>
<!--=========================== 전체 끝 ===========================-->

<!-- =====삭제 modal=====  -->
<div class="modal" id="m_del">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header 부분 -->
			<div class="modal-header">
				<h5 class="modal-title">공지사항 삭제</h5>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<!-- Modal Body 부분 -->
			<div class="modal-body">
				공지사항을 삭제하시겠습니까?
			</div>
			
			<!-- Modal Footer 부분 -->
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" onClick="noticeDel()">삭제</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>			
			</div>
		</div>
	</div>
</div>
<!-- =====삭제 modal end=====  -->

<script>
    $('#tb_nList').on('check.bs.table', function (row, element) {
      //table.bootstrapTable('resetView')
      choNotice_no = element.NOTICE_NO;
      choNot_title = element.NOT_TITLE;
  	  choNot_cont = element.NOT_CONT;
      $(element).addClass('active')
  	  selected = $("input:checkbox[name=btSelectItem]:checked").length;
		});
    
    $('#tb_nList').on('uncheck.bs.table', function (row, element) {
	  	  selected = $("input:checkbox[name=btSelectItem]:checked").length;
		});
    
</script>
</body>
</html>