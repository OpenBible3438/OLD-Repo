<%@page import="com.google.gson.JsonObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 별점 CSS 시작 -->
<style type="text/css">
	.star-rating{width:160px;}
	.star-rating, .star-rating span{
		display:inline-block; height:28px; overflow:hidden; background:url(../../images/star.png)no-repeat;}
	.star-rating span{ background-position:left bottom; line-height:0; vertical-align:top;}
</style>
<!-- 별점 CSS 끝 -->

<div style="padding: 20px;">
	<div class="row">
		<div class="col-sm-8">
			<h3><b>매장관리</b> / 전체후기조회</h3>
		</div>
		<div class="col-sm-2"></div>
		<div class="col-sm-2">
			<button type="button" id="reviewTP" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">후기종류</button>
			<div class="dropdown-menu" >
				<a class="dropdown-item" href="javascript:reviewType('')">전체</a>
				<a class="dropdown-item" href="javascript:reviewType('매장')">매장</a> 
				<a class="dropdown-item" href="javascript:reviewType('강사')">강사</a>
				<a class="dropdown-item" href="javascript:reviewType('수업')">수업</a>
			</div>
		</div>
	</div>
	<hr>
	<div style="padding-left: 40px; padding-top: 20px">
	<div id="div_review">
	
	</div>
	</div>
</div>
<script type="text/javascript">
	function reviewType(type) {
		//alert("type : " + type);
		var typeUrl = "";
		var reviewT = type;
		if(reviewT == "") {
			typeUrl = "../gym/jsonGymReviewList.gym"
		} else {
			typeUrl = "../gym/jsonGymReviewList.gym?rev_kind="+reviewT
		}
		$.ajax({
			url : typeUrl
			,success : function(result) {
				$("#div_review").html(result)
			}
		});
	}
	reviewType("");
	$(document).ready(function() {
	});
</script>











