<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gymReviewList.jsp</title>
<%@include file="../../common/bootStrap4UI.jsp" %>
<%
	String mode = request.getParameter("mode");
	if(mode!=null && mode.equals("refresh")){
		%>
		reviewList();
		<%
	}
	
	List<Map<String, Object>> reviewList = (List<Map<String, Object>>)request.getAttribute("selResult");
%>
<style type="text/css">
	.star-rating{width:160px;}
	.star-rating, .star-rating span{
		display:inline-block; height:28px; overflow:hidden; background:url(../../images/star.png)no-repeat;}
	.star-rating span{ background-position:left bottom; line-height:0; vertical-align:top;}
</style>
<script type="text/javascript">
	function reviewList(){
		location.href="../gym/jsonGymReviewList.gym"
	}
	function reviewUp() {
		alert("공감버튼 클릭");
	}
	function reviewDown() {
		alert("비공감 클릭");
	}
</script>
</head>
<body>
<div style="padding: 20px;">
<h3><b>매장관리</b> / 매장후기보기</h3>
<button id="searchReview" onClick="reviewList()">조회하기</button>
<div style="padding-left: 40px; padding-top: 20px">
<%
	if(reviewList != null){
		for(int i=0; i<reviewList.size(); i++){
			Map<String, Object> rmap = reviewList.get(i);
%>
<div id="div_review">
	<div id="div_review_nav">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<a class="navbar-brand"><%=rmap.get("REV_SEQ")%></a>
		</nav>
	</div>
	<div id="div_review_content">
		<div class="media border p-3">
			<!-- 사진 들어가는 부분 -->
			<!-- <img src="bible.jpg" style="width:80px;">
			<img src="bible.jpg" style="width:80px;"> -->
			<div class="media-body">
				<h5><b>여기는 후기 제목</b></h5>
				<p><%=rmap.get("REV_CONT")%></p>
				<p>
				<span class="star-rating">
					<span style="width:50%"></span>
				</span><br>			
				<button type="button" class="btn btn-primary" onClick="reviewUp()">공감<span class="badge badge-light"><%=rmap.get("REV_UP")%></span></button>
				<button type="button" class="btn btn-danger" onClick="reviewDown()">비공감<span class="badge badge-light"><%=rmap.get("REV_DOWN")%></span></button>
				<i style="font-size:20px; float:right;"><b><%=rmap.get("REV_DATE")%></b></i>
				</p>
			</div>
		</div>
	</div>
</div>
<br>
<%
		}
	}
%>
</div>
</div> 
</body>

</html>