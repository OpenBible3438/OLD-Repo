<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<Map<String, Object>> contentList = (List<Map<String, Object>>)request.getAttribute("selResult");
	for(int i=0; i<contentList.size(); i++) {
		Map<String,Object> map = contentList.get(i);
		
%>
	<!-- content html 코드 -->
		<!-- navbar 부분 -->
	<div id="div_content_nav">
		<nav class="navbar navbar-expand-sm bg-secondary navbar-dark" style="width:100%">
			<a class="navbar-brand"><%= i+1 %> / <%=map.get("GYM_NAME") %></a>
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" onClick="btnUpd(<%=map.get("GYM_CONT_SEQ") %>)" data-toggle="modal" data-target="#contentUpdModal">수정</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" onClick="btnDel(<%=map.get("GYM_CONT_SEQ") %>)" data-toggle="modal" data-target="#contentDelModal">삭제</a>
				</li>
			</ul>
		</nav>
	</div>
	
	
	<!-- 내용 부분 -->
	<div id="div_content_main">
		<div class="container-fluid bg-grey">
			<div class="row">
				<div class="col-sm-4" style="padding: 0; min-width:250px">
					<!-- 사진 들어가는 부분 -->
					<!-- <img id="getContImg" src= width="100%"> -->
					<input type="hidden" name="file_seq" value="<%=map.get("FILE_SEQ")%>">
					<div class="cropping" style="margin: 0">
						<img id="img<%=i%>" >
					</div>
				</div><!-- src="http://192.168.0.251/dev_gym/fitness/util/getImageList.jsp?imgByte=" --><%-- <%=map.get("filedata") %> --%>
				<div class="col-sm-8">
					<div class="row" align="right" style="padding-left: 10px; padding-top: 10px; padding-bottom: 0px; a">
						<p style="font-size:15px; float:right;">
							<b>좋아요<span class="badge"><%=map.get("GYM_CONT_LIKE") %></span></b>
							<i><b><%=map.get("GYM_CONT_DATE") %></b>/<b><%=map.get("GYM_CONT_TIME") %></b></i>
						</p>
					</div>
					<div class="row" style="padding-left: 10px;">
						<div class="col-sm-12">
							<p style="font-size:20px; "><b id="getContents"><%=map.get("GYM_CONTENTS") %></b></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr>
<%
	}
%>
