<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> contentList = (List<Map<String, Object>>)request.getAttribute("selResult");
	if(contentList != null && contentList.size() > 0){
		Gson g = new Gson();
		String contents = g.toJson(contentList);
		out.print(contents);
	} else {
		//out.print("reviewList == null");
	}
%>