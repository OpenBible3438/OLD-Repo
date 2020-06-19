<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GymContent.jsp</title>
<%@include file="../../common/bootStrap4UI.jsp" %>
<%@include file="gymContentIns.jsp" %>
<%@include file="gymContentUpd.jsp" %>
<script type="text/javascript">
	function btnIns(){
		alert('등록버튼클릭');		
	}
	function contentDel(){
		//alert('삭제하기');
		location.href='../jsonGymContentList?cud=del';
	}
</script>
</head>
<body>
<h4><b>매장관리 | 컨텐츠</b>
<br>
	<button onClick="btnIns()" type="button" class="btn btn-primary" style="float:right;" data-toggle="modal" data-target="#contentInsModal">등록</button>
</h4>
<!-- 컨텐츠 -->
<div id="div_content">
	<!-- navbar 부분 -->
	<div id="div_content_nav">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="width:100%">
			<a class="navbar-brand">컨텐츠번호seq+매장이름 들어가는 곳</a>
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" onClick="btnUpd()" data-toggle="modal" data-target="#contentUpdModal">수정</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" onClick="btnDel()" data-toggle="modal" data-target="#contentDelModal">삭제</a>
				</li>
			</ul>
		</nav>
	</div>
	
	<!-- 내용 부분 -->
	<div id="div_content_main">
		<div class="container-fluid bg-grey">
			<div class="row">
				<div class="col-sm-4">
					<!-- 사진 들어가는 부분 -->
					<!-- <img src="bible.jpg" width="200px"> -->
				</div>
				<div class="col-sm-8">
					<p style="font-size:20px;"><b>컨텐츠 내용 들어가는 부분 #가산동 #시설최고 #주차장무료</b></p>
					<p>
						<button type="button" class="btn btn-primary">좋아요<span class="badge">7</span></button>
						<i style="font-size:20px; float:right;">2020-06-12</i>
					</p>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 삭제버튼 눌렀을 때 모달부분 -->
<!-- 삭제 Modal -->
<div class="modal" id="contentDelModal">
	<div class="modal-dialog">
		<div class="modal-content">
	        <!-- Modal Header -->
	        <div class="modal-header">
	         	<h4 class="modal-title">삭제</h4>
	         	<button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div> 
	        
	        <!-- Modal body -->
	        <div class="modal-body">
	        	해당 컨텐츠를 삭제하시겠습니까?
	        </div>
         
	        <!-- Modal footer -->
	        <div class="modal-footer">
	        	<button type="button" class="btn btn-danger" data-dismiss="modal" onClick="contentDel()">삭제하기</button>
	        	<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	        </div>
		</div>
	</div>
</div>
<!-- 삭제 Modal -->

</body>
</html>