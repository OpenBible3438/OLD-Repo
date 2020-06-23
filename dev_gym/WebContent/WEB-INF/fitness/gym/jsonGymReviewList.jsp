<%@page import="org.apache.log4j.Logger"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> reviewList = (List<Map<String, Object>>)request.getAttribute("selResult");
	if(reviewList != null && reviewList.size() > 0){
		Gson g = new Gson();
		String reviews = g.toJson(reviewList);
		//out.print(reviews);
	} else {
		//out.print("reviewList == null");
	}
	for(int i=0; i<reviewList.size(); i++) {
		Map<String,Object> map = reviewList.get(i);
%>
<!-- <div id="div_review"> -->
	<div id="div_review_nav">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<a class="navbar-brand" id="rev_seq"><%=map.get("REV_SEQ") %></a>
		</nav>
	</div>
	<div id="div_review_content">
		<div class="media-body">
			<h4><b id="review_className">여긴 수업이름</b></h4>
			<h5><b id="review_tchName">여긴 강사이름</b></h5>
			<p id="review_cont"><%=map.get("REV_CONT") %></p>
			<p>
			<span class="star-rating">
				<!-- 백분율로 별점 -->
				<span style="width:<%=map.get("REV_STAR") %>%"></span>
			</span><br>			
			<button type="button" class="btn btn-primary">공감<span class="badge badge-light" id="review_up"><%=map.get("REV_UP") %></span></button>
			<button type="button" class="btn btn-danger">비공감<span class="badge badge-light" data-field="review_down"><%=map.get("REV_DOWN") %></span></button>
			<i style="font-size:20px; float:right;"><b id="review_date"><%=map.get("REV_DATE") %></b>/<b id="review_time"><%=map.get("REV_TIME") %></b></i>
			</p>
		</div>
	</div>
<!-- </div> -->
<br>
<!-- <script type="text/javascript">
	$("#rev_seq")
</script>   --> 
<%
	}
%>

