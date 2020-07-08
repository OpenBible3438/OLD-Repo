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
	<div id="div_review_nav" style="height:50px">
		<nav class="navbar navbar-expand-sm bg-secondary navbar-dark">
			<a class="navbar-brand" id="rev_seq"><%= i+1 %>. <%= map.get("REV_KIND")+" 후기" %></a>
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" id="review_className"><%= map.get("GYM_NAME") %> </a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="review_tchName"><%= map.get("TCH_NAME") %> </a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="review_tchName"><%= map.get("CLS_NAME") %> </a>
				</li>
			</ul>
		</nav>
	</div>
	<div id="div_review_content">
		<div class="media-body" >
			<div style="padding: 10px">
			<!-- 
			<h4><b id="review_className">여긴 수업이름</b></h4>
			<h5><b id="review_tchName">여긴 강사이름</b></h5>
			 -->
				<p id="review_cont" style="min-height: 100px">
					<%=map.get("REV_CONT") %>
				</p>
			</div>
			<p>
				<span class="star-rating">
					<!-- 백분율로 별점 -->
					<span style="width:<%=map.get("REV_STAR") %>%"></span>
				</span>
				<i style="font-size:15px; float:right;">
					<b id="review_date"><%=map.get("REV_DATE") %></b>/<b id="review_time"><%=map.get("REV_TIME") %></b>
				</i>
				<span style="font-size:15px; float:right;">			
				<b>
					공감<span class="badge badge-light" id="review_up"><%=map.get("REV_UP") %></span>
					비공감<span class="badge badge-light" data-field="review_down"><%=map.get("REV_DOWN") %></span>
				</b>&nbsp;
				</span>
			</p>
		</div>
	</div>
<!-- </div> -->
<hr>
<!-- <script type="text/javascript">
	$("#rev_seq")
</script>   --> 
<%
	}
%>

