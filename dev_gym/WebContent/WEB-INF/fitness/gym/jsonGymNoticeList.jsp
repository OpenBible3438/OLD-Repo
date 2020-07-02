<%@page import="org.apache.log4j.Logger"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> noticeList = (List<Map<String, Object>>)request.getAttribute("selResult");
	if(noticeList != null && noticeList.size() > 0){
		Gson g = new Gson();
		String notices = g.toJson(noticeList);
		out.print(notices);
	}
	else{
		out.print("null입니다.");
	}
%>