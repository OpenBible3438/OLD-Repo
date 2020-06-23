<%@page import="org.apache.log4j.Logger"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> infoList = (List<Map<String, Object>>)request.getAttribute("selResult");
	if(infoList != null && infoList.size() > 0){
		Gson g = new Gson();
		String infos = g.toJson(infoList);
		out.print(infos);
	}
	else{
		out.print("null입니다.");
	}
%>