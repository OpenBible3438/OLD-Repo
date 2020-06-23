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
		out.print("reviewList == null");
	}
%>