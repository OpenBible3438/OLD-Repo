<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 클래스 공통코드 -->
<%@include file="classCommon.jsp"%>

	<script type="text/javascript">
		function classSEL(){
 			alert("수업보기 완료");
			$.ajax({
				 url:'jsonClassList.jsp'
				 //성공하면 data에 json 데이터가 담긴다.
				,success:function(data){
					//.trim() ==> 공백제거
					
					var doc = JSON.stringify(data); 	// 가져온 data를 문자열로 doc에 담았다.
					var doc2 = JSON.parse(doc);   		//doc2에 doc의 값이 배열처럼 담긴다. doc2의 길이는 가져온 데이터의 행의 갯수와 같다.	
					
					var imsi = "";
					for(var i=0;i<doc2.length;i++){
						//html 함수 안에 집어 넣을 변수
						imsi += "<tr>";
						imsi += "<td>"+doc2[i].C_NUM+"</td>";
						imsi += "<td>"+doc2[i].C_NUMBER+"</td>";
						imsi += "<td>"+doc2[i].C_NAME+"</td>";
						imsi += "<td>"+doc2[i].C_TNAME+"</td>";
						imsi += "<td>"+doc2[i].C_SPORTS+"</td>";
						imsi += "<td>"+doc2[i].C_TIMES+"</td>";
						imsi += "<td>"+doc2[i].C_TOTALDAYS+"</td>";
						imsi += "<td>"+doc2[i].C_STARTDATE+"</td>";
						imsi += "<td>"+doc2[i].C_ENDDATE+"</td>";
						imsi += "<td>"+doc2[i].C_PRICE+"</td>";
						imsi += "<td>"+doc2[i].C_PROCESS+"</td>";
						imsi += "</tr>";
					}
					$("#tb_cListTest").html(imsi);
				}
			});		

		}
		function classINS(){
 			alert("수업등록 저장 완료");
 			$("#f_ins").attr("method","get");
 			$("#f_ins").attr("action","jsonClassList.jsp?=classList"+classList);
 			$("#f_ins").submit();
 			$("#c_ins").modal('hide');
		}
		function classUPD(){
 			alert("수업수정 저장 완료");
 			$("#f_ins").attr("method","get");
 			$("#f_ins").attr("action","classList.jsp");
 			$("#f_ins").submit();
 			$("#c_upd").modal('hide');
		}
		function classDetail(){
 			alert("디테일 닫기 완료");
 			$("#c_detail").modal('hide');
		}
		function c_btnDel(){
 			alert("수업을 삭제합니다.");
		}
		function classMemINS(){
 			alert("수강생을 등록합니다.");
 			$("#c_memIns").modal('hide');
		}
		function classMemDEL(){
 			alert("수강생을 삭제합니다.");
		}
	</script>

</head>
<body>
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
				<div class="btn-group">
					<button type="button" class="btn btn-primary dropdown-toggle"
						data-toggle="dropdown">진행상황</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">진행</a> <a class="dropdown-item"
							href="#">대기</a> <a class="dropdown-item" href="#">종료</a>
					</div>
				</div>
				<button type="button" class="btn btn-primary" onclick="classSEL()">전체조회</button>
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#c_ins">수업등록</button>
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#c_upd">수업수정</button>
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#c_detail">자세히보기</button>
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#c_memList">수강생보기</button>
				<button type="button" class="btn btn-primary" onclick="c_btnDel()">삭제</button>
				<!--======================================================================================= 버튼 끝-->
		
				<div>
					<p></p>
				</div>
		
				<!--======================================================================================= 테이블 시작-->
				<table class="table table-hover" id="tb_cList" name="tb_cList">
					<thead>
						<tr>
							<th data-field="c_num">#</th>
							<th data-field="c_number">수업 번호</th>
							<th data-field="c_name">수업명</th>
							<th data-field="c_tName">강사명</th>
							<th data-field="c_sports">종목</th>
							<th data-field="c_times">수업 횟수</th>
							<th data-field="c_totalDays">수업 일수</th>
							<th data-field="c_startDate">시작일</th>
							<th data-field="c_endDate">종료일</th>
							<th data-field="c_price">가격</th>
							<th data-field="c_process">진행 상황</th>
						</tr>
					</thead>
					<tbody id="tb_cListTest">
						
					</tbody>
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

</body>
</html>