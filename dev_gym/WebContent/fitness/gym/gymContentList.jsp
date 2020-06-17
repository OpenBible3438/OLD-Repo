<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GymContent.jsp</title>
<%@include file="../../common/bootStrap4UI.jsp" %>
<!-- <script type="text/javascript">
	function contentIns(){
		alert('등록버튼 클릭!');
	}
	function contentUpd(){
		alert('수정버튼 클릭!');
	}
	function contentDel(){
		//alert('삭제버튼 클릭!');
	}
</script> -->
</head>
<body>
<h4><b>매장관리 | 컨텐츠</b>
<br>
	<button onClick="contentIns()" type="button" class="btn btn-primary" style="float:right;" data-toggle="modal" data-target="#contentInsModal">등록</button>
</h4>
<!-- 컨텐츠 -->
<div id="div_content">
	<!-- navbar 부분 -->
	<div id="div_content_nav">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="width:100%">
			<a class="navbar-brand">컨텐츠번호seq+매장이름 들어가는 곳</a>
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" onClick="contentUpd()" data-toggle="modal" data-target="#contentUpdModal">수정</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" onClick="contentDel()" data-toggle="modal" data-target="#contentDelModal">삭제</a>
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
	        	<button type="button" class="btn btn-danger" data-dismiss="modal">삭제하기</button>
	        	<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	        </div>
		</div>
	</div>
</div>
<!-- 삭제 Modal -->

<!-- 등록 Modal -->
<div class="modal" id="contentInsModal">
	<div class="modal-dialog">
		<div class="modal-content">
	        <!-- Modal Header -->
	        <div class="modal-header">
	         	<h4 class="modal-title">컨텐츠 등록</h4>
	         	<button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div> 
	        
	        <!-- Modal body -->
	        <div class="modal-body">
	        	<img src="bible.jpg" class="mx-auto d-block" style="width:50%">
	        	<button type="button" class="btn btn-outline-primary">사진선택하기</button> 
	        	<div class="form-group">
  					<label for="comment">컨텐츠 내용:</label>
  					<textarea class="form-control" rows="5" id="comment"></textarea>
				</div>
	        </div>
         
	        <!-- Modal footer -->
	        <div class="modal-footer">
	        	<button type="button" class="btn btn-primary" data-dismiss="modal">등록하기</button>
	        	<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	        </div>
		</div>
	</div>
</div>

<!-- 수정 Modal -->
<div class="modal" id="contentUpdModal">
	<div class="modal-dialog">
		<div class="modal-content">
	        <!-- Modal Header -->
	        <div class="modal-header">
	         	<h4 class="modal-title">컨텐츠 수정</h4>
	         	<button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div> 
	        
	        <!-- Modal body -->
	        <div class="modal-body">
	        	<img src="bible.jpg" class="mx-auto d-block" style="width:50%">
	        	<button type="button" class="btn btn-outline-primary">사진선택하기</button> 
	        	<div class="form-group">
  					<label for="comment">컨텐츠 내용:</label>
  					<textarea class="form-control" rows="5" id="comment"></textarea>
				</div>
	        </div>
         
	        <!-- Modal footer -->
	        <div class="modal-footer">
	        	<button type="button" class="btn btn-primary" data-dismiss="modal">수정하기</button>
	        	<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	        </div>
		</div>
	</div>
</div>

</body>
</html>