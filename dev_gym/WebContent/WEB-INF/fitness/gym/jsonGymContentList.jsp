<%@page import="org.apache.log4j.Logger"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> contentList = (List<Map<String, Object>>)request.getAttribute("selResult");
	if(contentList != null && contentList.size() > 0){
		Gson g = new Gson();
		String reviews = g.toJson(contentList);
		//out.print(reviews);
	} else {
		//out.print("reviewList == null");
	}
	for(int i=0; i<contentList.size(); i++) {
		Map<String,Object> map = contentList.get(i);
%>
	<!-- content html 코드 -->
		<!-- navbar 부분 -->
	<div id="div_content_nav">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="width:100%">
			<a class="navbar-brand"><%=map.get("GYM_CONT_SEQ") %>/<%=map.get("GYM_NO") %></a>
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
					<img src="../../images/contentTestImg.jpg" width="100%">
				</div>
				<div class="col-sm-8">
					<p style="font-size:20px;"><b><%=map.get("GYM_CONTENTS") %></b></p>
					<p>
						<button type="button" class="btn btn-primary">좋아요<span class="badge"><%=map.get("GYM_CONT_LIKE") %></span></button>
						<i style="font-size:20px; float:right;"><b>2020-06-12</b></i>
					</p>
				</div>
			</div>
		</div>
	</div>
<%
	}
%>