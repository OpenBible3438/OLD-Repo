<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gymReviewList.jsp</title>
<%@include file="../../common/bootStrap4UI.jsp" %>
</head>
<body>
<h4><b>매장관리 | 매장후기보기</b></h4>
<br>
<!--==================== 예시부분 ====================-->
<div id="div_review">
	<div id="div_review_nav">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<a class="navbar-brand">사용자ID들어가는 부분</a>
		</nav>
	</div>
	<div id="div_review_content">
		<div class="media border p-3">
			<!-- 사진 들어가는 부분 -->
			<!-- <img src="bible.jpg" style="width:80px;">
			<img src="bible.jpg" style="width:80px;"> -->
			<div class="media-body">
				<h5><b>여기는 후기 제목</b></h5>
				<p>후기 내용 들어가는 부분. 너무 좋습니다다. 시설 최고 ! ! !</p>
				<p>
				<button type="button" class="btn btn-primary">좋아요<span class="badge badge-light">7</span></button>
				<i style="font-size:20px; float:right;">2020-06-11</i>
				</p>
			</div>
		</div>
	</div>
</div>
<!--==================== 예시부분 ====================-->
 
</body>
</html>