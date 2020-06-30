<%@page import="com.google.gson.JsonObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mode = request.getParameter("mode");
	if(mode!=null && mode.equals("refresh")){
		%>
		reviewList();
		<%
	}
%>
<!-- 별점 CSS 시작 -->
<style type="text/css">
	.star-rating{width:160px;}
	.star-rating, .star-rating span{
		display:inline-block; height:28px; overflow:hidden; background:url(../../images/star.png)no-repeat;}
	.star-rating span{ background-position:left bottom; line-height:0; vertical-align:top;}
</style>
<!-- 별점 CSS 끝 -->
<div style="padding: 20px;">
<h3><b>매장관리</b> / 매장후기보기</h3>
<div style="padding-left: 40px; padding-top: 20px">
<div id="div_review"></div>
</div>
</div>
<script type="text/javascript">
   $(document).ready(function(){
      $.ajax({
         url : "../gym/jsonGymReviewList.gym"
        , success : function(result){
           $("#div_review").html(result)     
        }
      });
   });
</script>
